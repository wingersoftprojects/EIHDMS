CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pivot_base_data_by_form_id_and_logged_in_user2`(IN in_table_name varchar(100),IN in_data_element_ids_involved varchar(1000))
BEGIN
SET SESSION group_concat_max_len = 18446744073709551615;
SET @sql = NULL;

SET @sql_text=NULL;

SET @source=CONCAT('((z_temp_view_union_',in_table_name,' `bd` join `district` `d` on((`bd`.`district_id` = `d`.`district_id`))) join `region` `r` on((`d`.`region_id` = `r`.`region_id`))) where bd.data_element_id in (',in_data_element_ids_involved,')');

SET @sql_text=CONCAT('SELECT
  GROUP_CONCAT(DISTINCT
    CONCAT(''max(case when bd.data_element_id = '',bd.data_element_id,'' then data_element_value end) AS '',''DE'',bd.data_element_id,'' '')
  ) INTO @sql
FROM ',@source);

prepare stmt from @sql_text;
execute stmt;

SET @sql_drop_table=CONCAT('DROP TABLE IF EXISTS ','z_temp_base_data_',in_table_name);

prepare stmt_drop_table from @sql_drop_table;
execute stmt_drop_table;

SET @sql = CONCAT('CREATE TABLE ', 'z_temp_base_data_',in_table_name ,' SELECT r.region_id,bd.district_id,county_id,sub_county_id,parish_id,health_facility_id,region_name,bd.district_name,county_name,sub_county_name,parish_name,health_facility_name,report_period_year,report_period_quarter,report_period_month,report_period_bi_month,report_period_week,bd.report_form_id,', @sql, ' FROM ',@source,' GROUP BY region_id,district_id,county_id,sub_county_id,parish_id,health_facility_id,region_name,district_name,county_name,sub_county_name,parish_name,health_facility_name,report_period_year,report_period_quarter,report_period_month,report_period_bi_month,report_period_week,report_form_id HAVING report_form_id in(select report_form_id from data_element where data_element_id in (',in_data_element_ids_involved,'))');

prepare stmt from @sql;
execute stmt;
END
/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : eihdms

Target Server Type    : MYSQL
Target Server Version : 50199
File Encoding         : 65001

Date: 2016-09-16 19:43:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- View structure for vw_base_data
-- ----------------------------
DROP VIEW IF EXISTS `vw_base_data`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `vw_base_data` AS SELECT
r.region_name,
d.district_name,
c.county_name,
sc.sub_county_name,
p.parish_name,
h.health_facility_name,
bd.base_data_id,
bd.data_element_id,
bd.data_element_value,
bd.health_facility_id,
bd.parish_id,
bd.district_id,
bd.report_period_from_date,
bd.report_period_to_date,
bd.is_deleted,
bd.is_active,
bd.add_date,
bd.add_by,
bd.last_edit_date,
bd.last_edit_by,
bd.financial_year_id,
bd.report_period_quarter,
bd.sub_county_id,
bd.batch_id,
bd.report_period_month,
bd.report_period_week,
bd.report_period_year,
bd.report_period_bi_month,
de.data_element_name,
de.data_element_code,
de.age_category,
de.sex_category,
de.other_category,
de.data_element_context,
rf.report_form_name,
rfg.report_form_group_name,
de.report_form_id,
de.report_form_group_id,
r.region_id,
c.county_id
FROM
base_data AS bd
INNER JOIN district AS d ON bd.district_id = d.district_id
INNER JOIN region AS r ON d.region_id = r.region_id
LEFT JOIN sub_county AS sc ON bd.sub_county_id = sc.sub_county_id
LEFT JOIN county AS c ON c.county_id = bd.county_id
LEFT JOIN parish AS p ON bd.parish_id = p.parish_id
LEFT JOIN health_facility AS h ON bd.health_facility_id = h.health_facility_id
INNER JOIN data_element AS de ON bd.data_element_id = de.data_element_id
INNER JOIN report_form AS rf ON de.report_form_id = rf.report_form_id
INNER JOIN report_form_group AS rfg ON de.report_form_group_id = rfg.report_form_group_id ;

-- ----------------------------
-- View structure for vw_interface_data
-- ----------------------------
DROP VIEW IF EXISTS `vw_interface_data`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `vw_interface_data` AS SELECT
interface_data.interface_data_id,
interface_data.data_element_id,
interface_data.data_element_value,
interface_data.health_facility_name,
interface_data.parish_name,
interface_data.district_name,
interface_data.report_period_from_date,
interface_data.report_period_to_date,
interface_data.is_deleted,
interface_data.is_active,
interface_data.add_date,
interface_data.add_by,
interface_data.last_edit_date,
interface_data.last_edit_by,
interface_data.financial_year_id,
interface_data.report_period_quarter,
data_element.data_element_name,
report_form.report_form_id,
report_form_group.report_form_group_id,
interface_data.sub_county_name,
interface_data.batch_id,
interface_data.county_name
FROM
interface_data
INNER JOIN data_element ON interface_data.data_element_id = data_element.data_element_id
INNER JOIN report_form ON report_form.report_form_id = data_element.report_form_id
INNER JOIN report_form_group ON report_form_group.report_form_id = report_form.report_form_id AND report_form_group.report_form_group_id = data_element.report_form_group_id ;

-- ----------------------------
-- Procedure structure for sp_move_data_from_interface_to_base
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_move_data_from_interface_to_base`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_move_data_from_interface_to_base`(IN in_batch_id int)
BEGIN
INSERT INTO base_data (data_element_id,
data_element_value,
health_facility_id,
parish_id,
district_id,
report_period_from_date,
report_period_to_date,
is_deleted,
is_active,
add_date,
add_by,
last_edit_date,
last_edit_by,
financial_year_id,
report_period_quarter,
sub_county_id,
batch_id,
report_period_month,
report_period_week,
report_period_year,report_period_bi_month,report_form_id,county_id) SELECT 
data_element_id,
data_element_value,
health_facility_id,
parish_id,
district_id,
report_period_from_date,
report_period_to_date,
is_deleted,
is_active,
add_date,
add_by,
last_edit_date,
last_edit_by,
financial_year_id,
report_period_quarter,
sub_county_id,
batch_id,
report_period_month,
report_period_week,
report_period_year,
report_period_bi_month,
report_form_id,
county_id
FROM interface_data where batch_id=in_batch_id AND status_v='Pass';


-- BEGIN Update STATUS
UPDATE interface_data set status_m='Pass',status_m_desc='Moved Successfully' WHERE  batch_id=in_batch_id AND status_v='Pass';
-- END Update STATUS
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_pivot_base_data_by_form_id_and_logged_in_user
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_pivot_base_data_by_form_id_and_logged_in_user`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pivot_base_data_by_form_id_and_logged_in_user`(IN in_report_form_id int,IN in_table_name varchar(100))
BEGIN
		SET SESSION group_concat_max_len = 100000000;
SET @sql = NULL;
SELECT
  GROUP_CONCAT(DISTINCT
    CONCAT('max(case when data_element_id = ',data_element_id,' then data_element_value end) AS ','DE',data_element_id,' ')
  ) INTO @sql
FROM  vw_base_data where data_element_id AND report_form_id=in_report_form_id;

SET @sql_drop_table=CONCAT('DROP TABLE IF EXISTS ','z_temp_base_data_',in_table_name);

prepare stmt_drop_table from @sql_drop_table;
execute stmt_drop_table;

SET @sql = CONCAT('CREATE TABLE ', 'z_temp_base_data_',in_table_name ,' SELECT region_id,district_id,county_id,sub_county_id,parish_id,health_facility_id,region_name,district_name,county_name,sub_county_name,parish_name,health_facility_name,report_period_year,report_period_quarter,report_period_month,report_period_bi_month,report_period_week,report_form_id,', @sql, ' FROM vw_base_data GROUP BY region_id,district_id,county_id,sub_county_id,parish_id,health_facility_id,region_name,district_name,county_name,sub_county_name,parish_name,health_facility_name,report_period_year,report_period_quarter,report_period_month,report_period_bi_month,report_period_week,report_form_id HAVING report_form_id=',in_report_form_id);

prepare stmt from @sql;
execute stmt;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_select_kpi
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_select_kpi`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_select_kpi`(IN in_kpi_id int,IN in_username varchar(200),IN in_report_form_id int,IN in_report_period_year varchar(1000),IN in_district_id varchar(1000))
BEGIN

DECLARE kpi_summary_function_v varchar(12000);
SET @report_period_year_v ='';
SET @district_id_v ='';

IF LENGTH(in_report_period_year )>0 THEN
SET @report_period_year_v=CONCAT('report_period_year in(',in_report_period_year,')') ;
ELSE
SET @report_period_year_v='1=1';
END IF;

IF LENGTH(in_district_id )>0 THEN
SET @district_id_v=CONCAT('district_id in(',in_district_id,')') ;
ELSE
SET @district_id_v ='1=1';
END IF;

CALL sp_pivot_base_data_by_form_id_and_logged_in_user(in_report_form_id ,in_username);

SELECT kpi_summary_function FROM kpi where kpi_id=in_kpi_id into kpi_summary_function_v;

SET @sql_kpi=CONCAT('SELECT district_name,county_name,sub_county_name,parish_name,health_facility_name,report_period_year,report_period_quarter,',kpi_summary_function_v,' AS kpi_value FROM z_temp_base_data_',in_username,' AS temp WHERE ',kpi_summary_function_v,' is not null AND ',@district_id_v,' AND ',@report_period_year_v);

prepare stmt_select_kpi from @sql_kpi;
execute stmt_select_kpi;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_update_data_obligation_bi_monthly
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_update_data_obligation_bi_monthly`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_data_obligation_bi_monthly`(
	IN in_year int,
	IN in_bi_month int
)
BEGIN 
	DELETE FROM data_obligation WHERE data_obligation_id>0 AND year_value=in_year AND bi_month_value=in_bi_month;
	
	INSERT INTO data_obligation(report_form_id,count_de,count_parish,count_district,count_facility,year_value,bi_month_value,
	bi_month_records_f,bi_month_records_p,bi_month_records_d,bi_month_des) 
	SELECT 
	rf.report_form_id,
	(select count(*) from data_element de1 where de1.report_form_id=rf.report_form_id and de1.is_active=1 and is_deleted=0) as count_de,
	(select count(*) from parish p where p.is_active=1 and is_deleted=0) as count_parish,
	(select count(*) from district d where d.is_active=1 and is_deleted=0) as count_district,
	(select count(*) from health_facility hf where hf.is_active=1 and is_deleted=0) as count_facility,
	in_year as year_value,in_bi_month as bi_month_value,
	( select count(distinct bd2.health_facility_id) from base_data bd2 
	  inner join data_element de2 on bd2.data_element_id=de2.data_element_id 
	  where de2.report_form_id=rf.report_form_id and bd2.is_active=1 and bd2.is_deleted=0 and bd2.report_period_year=in_year and bd2.report_period_bi_month=in_bi_month
	) as bi_month_records_f,
	( select count(distinct bd3.parish_id) from base_data bd3 
	  inner join data_element de3 on bd3.data_element_id=de3.data_element_id 
	  where de3.report_form_id=rf.report_form_id and bd3.is_active=1 and bd3.is_deleted=0 and bd3.report_period_year=in_year and bd3.report_period_bi_month=in_bi_month
	) as bi_month_records_p,
	( select count(distinct bd4.district_id) from base_data bd4 
	  inner join data_element de4 on bd4.data_element_id=de4.data_element_id 
	  where de4.report_form_id=rf.report_form_id and bd4.is_active=1 and bd4.is_deleted=0 and bd4.report_period_year=in_year and bd4.report_period_bi_month=in_bi_month
	) as bi_month_records_d,
	( select count(distinct bd5.data_element_id) from base_data bd5 
      inner join data_element de5 on bd5.data_element_id=de5.data_element_id 
      where de5.report_form_id=rf.report_form_id and bd5.is_active=1 and bd5.is_deleted=0 and bd5.report_period_year=in_year and bd5.report_period_bi_month=in_bi_month
	) as bi_month_des 
	from report_form rf where rf.report_form_frequency='Bi-Monthly';
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_update_data_obligation_monthly
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_update_data_obligation_monthly`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_data_obligation_monthly`(
	IN in_year int,
	IN in_month int
)
BEGIN 
	DELETE FROM data_obligation WHERE data_obligation_id>0 AND year_value=in_year AND month_value=in_month;
	
	INSERT INTO data_obligation(report_form_id,count_de,count_parish,count_district,count_facility,year_value,month_value,
	month_records_f,month_records_p,month_records_d,month_des) 
	SELECT 
	rf.report_form_id,
	(select count(*) from data_element de1 where de1.report_form_id=rf.report_form_id and de1.is_active=1 and is_deleted=0) as count_de,
	(select count(*) from parish p where p.is_active=1 and is_deleted=0) as count_parish,
	(select count(*) from district d where d.is_active=1 and is_deleted=0) as count_district,
	(select count(*) from health_facility hf where hf.is_active=1 and is_deleted=0) as count_facility,
	in_year as year_value,in_month as month_value,
	( select count(distinct bd2.health_facility_id) from base_data bd2 
	  inner join data_element de2 on bd2.data_element_id=de2.data_element_id 
	  where de2.report_form_id=rf.report_form_id and bd2.is_active=1 and bd2.is_deleted=0 and bd2.report_period_year=in_year and bd2.report_period_month=in_month
	) as month_records_f,
	( select count(distinct bd3.parish_id) from base_data bd3 
	  inner join data_element de3 on bd3.data_element_id=de3.data_element_id 
	  where de3.report_form_id=rf.report_form_id and bd3.is_active=1 and bd3.is_deleted=0 and bd3.report_period_year=in_year and bd3.report_period_month=in_month
	) as month_records_p,
	( select count(distinct bd4.district_id) from base_data bd4 
	  inner join data_element de4 on bd4.data_element_id=de4.data_element_id 
	  where de4.report_form_id=rf.report_form_id and bd4.is_active=1 and bd4.is_deleted=0 and bd4.report_period_year=in_year and bd4.report_period_month=in_month
	) as month_records_d,
	( select count(distinct bd5.data_element_id) from base_data bd5 
      inner join data_element de5 on bd5.data_element_id=de5.data_element_id 
      where de5.report_form_id=rf.report_form_id and bd5.is_active=1 and bd5.is_deleted=0 and bd5.report_period_year=in_year and bd5.report_period_month=in_month
	) as month_des 
	from report_form rf where rf.report_form_frequency='Monthly';
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_update_data_obligation_quarterly
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_update_data_obligation_quarterly`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_data_obligation_quarterly`(
	IN in_year int,
	IN in_quarter int
)
BEGIN 
	DELETE FROM data_obligation WHERE data_obligation_id>0 AND year_value=in_year AND quarter_value=in_quarter;
	
	INSERT INTO data_obligation(report_form_id,count_de,count_parish,count_district,count_facility,year_value,quarter_value,
	quarter_records_f,quarter_records_p,quarter_records_d,quarter_des) 
	SELECT 
	rf.report_form_id,
	(select count(*) from data_element de1 where de1.report_form_id=rf.report_form_id and de1.is_active=1 and is_deleted=0) as count_de,
	(select count(*) from parish p where p.is_active=1 and is_deleted=0) as count_parish,
	(select count(*) from district d where d.is_active=1 and is_deleted=0) as count_district,
	(select count(*) from health_facility hf where hf.is_active=1 and is_deleted=0) as count_facility,
	in_year as year_value,in_quarter as quarter_value,
	( select count(distinct bd2.health_facility_id) from base_data bd2 
	  inner join data_element de2 on bd2.data_element_id=de2.data_element_id 
	  where de2.report_form_id=rf.report_form_id and bd2.is_active=1 and bd2.is_deleted=0 and bd2.report_period_year=in_year and bd2.report_period_quarter=in_quarter
	) as quarter_records_f,
	( select count(distinct bd3.parish_id) from base_data bd3 
	  inner join data_element de3 on bd3.data_element_id=de3.data_element_id 
	  where de3.report_form_id=rf.report_form_id and bd3.is_active=1 and bd3.is_deleted=0 and bd3.report_period_year=in_year and bd3.report_period_quarter=in_quarter
	) as quarter_records_p,
	( select count(distinct bd4.district_id) from base_data bd4 
	  inner join data_element de4 on bd4.data_element_id=de4.data_element_id 
	  where de4.report_form_id=rf.report_form_id and bd4.is_active=1 and bd4.is_deleted=0 and bd4.report_period_year=in_year and bd4.report_period_quarter=in_quarter
	) as quarter_records_d,
	( select count(distinct bd5.data_element_id) from base_data bd5 
      inner join data_element de5 on bd5.data_element_id=de5.data_element_id 
      where de5.report_form_id=rf.report_form_id and bd5.is_active=1 and bd5.is_deleted=0 and bd5.report_period_year=in_year and bd5.report_period_quarter=in_quarter
	) as quarter_des 
	from report_form rf where rf.report_form_frequency='Quarterly';
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_update_data_obligation_weekly
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_update_data_obligation_weekly`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_data_obligation_weekly`(
	IN in_year int,
	IN in_month int,
	IN in_week int
)
BEGIN 
	DELETE FROM data_obligation WHERE data_obligation_id>0 AND year_value=in_year AND month_value=in_month AND week_value=in_week;
	
	INSERT INTO data_obligation(report_form_id,count_de,count_parish,count_district,count_facility,year_value,month_value,week_value,
	week_records_f,week_records_p,week_records_d,week_des) 
	SELECT 
	rf.report_form_id,
	(select count(*) from data_element de1 where de1.report_form_id=rf.report_form_id and de1.is_active=1 and is_deleted=0) as count_de,
	(select count(*) from parish p where p.is_active=1 and is_deleted=0) as count_parish,
	(select count(*) from district d where d.is_active=1 and is_deleted=0) as count_district,
	(select count(*) from health_facility hf where hf.is_active=1 and is_deleted=0) as count_facility,
	in_year as year_value,in_month as month_value,in_week as week_value,
	( select count(distinct bd2.health_facility_id) from base_data bd2 
	  inner join data_element de2 on bd2.data_element_id=de2.data_element_id 
	  where de2.report_form_id=rf.report_form_id and bd2.is_active=1 and bd2.is_deleted=0 and bd2.report_period_year=in_year 
	  and bd2.report_period_month=in_month and bd2.report_period_week=in_week
	) as week_records_f,
	( select count(distinct bd3.parish_id) from base_data bd3 
	  inner join data_element de3 on bd3.data_element_id=de3.data_element_id 
	  where de3.report_form_id=rf.report_form_id and bd3.is_active=1 and bd3.is_deleted=0 and bd3.report_period_year=in_year 
	  and bd3.report_period_month=in_month and bd3.report_period_week=in_week
	) as week_records_p,
	( select count(distinct bd4.district_id) from base_data bd4 
	  inner join data_element de4 on bd4.data_element_id=de4.data_element_id 
	  where de4.report_form_id=rf.report_form_id and bd4.is_active=1 and bd4.is_deleted=0 and bd4.report_period_year=in_year 
	  and bd4.report_period_month=in_month and bd4.report_period_week=in_week
	) as week_records_d,
	( select count(distinct bd5.data_element_id) from base_data bd5 
      inner join data_element de5 on bd5.data_element_id=de5.data_element_id 
      where de5.report_form_id=rf.report_form_id and bd5.is_active=1 and bd5.is_deleted=0 and bd5.report_period_year=in_year 
	  and bd5.report_period_month=in_month and bd5.report_period_week=in_week
	) as week_des 
	from report_form rf where rf.report_form_frequency='Weekly';
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_update_location_id
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_update_location_id`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_location_id`(IN in_reporting_level varchar(50),IN in_district_name varchar(200),IN in_county_name varchar(200), IN in_sub_county_name varchar(200), IN in_parish_name varchar(200), IN in_health_facility_name varchar(200), IN in_batch_id int)
BEGIN

DECLARE health_facility_id_v int;
DECLARE parish_id_v int;
DECLARE sub_county_id_v int;
DECLARE district_id_v int;
DECLARE county_id_v int;


IF in_reporting_level='Facility' THEN
SELECT district_id FROM district where district_name=in_district_name into district_id_v;
SELECT county_id FROM county c where c.district_id=district_id_v and c.county_name=in_county_name  into county_id_v;
SELECT sub_county_id FROM sub_county sc where sc.county_id=county_id_v and sc.sub_county_name=in_sub_county_name into sub_county_id_v;
SELECT health_facility_id FROM health_facility where sub_county_id=sub_county_id_v AND district_id=district_id_v AND health_facility_name=in_health_facility_name into health_facility_id_v;

IF health_facility_id_v!=0 THEN
UPDATE interface_data set district_id=district_id_v,county_id=county_id_v, sub_county_id=sub_county_id_v,health_facility_id=health_facility_id_v WHERE district_name=in_district_name AND sub_county_name=in_sub_county_name AND health_facility_name=in_health_facility_name AND batch_id=in_batch_id ;
ELSE
UPDATE interface_data set status_v='Fail',status_v_desc=CONCAT(status_v_desc,'\n','=>Facility ',in_district_name,'/',in_sub_county_name ,'/',in_health_facility_name ,' does not exist!') WHERE district_name=in_district_name AND sub_county_name=in_sub_county_name AND health_facility_name=in_health_facility_name AND batch_id=in_batch_id ;
END IF;
ELSEIF in_reporting_level='Parish' THEN
SELECT district_id FROM district where district_name=in_district_name into district_id_v;
SELECT county_id FROM county c where c.district_id=district_id_v and c.county_name=in_county_name  into county_id_v;
SELECT sub_county_id FROM sub_county sc where sc.county_id=county_id_v and sc.sub_county_name=in_sub_county_name into sub_county_id_v;
SELECT parish_id FROM parish where sub_county_id=sub_county_id_v AND district_id=district_id_v AND parish_name=in_parish_name into parish_id_v;

IF parish_id_v!=0 THEN
UPDATE interface_data set district_id=district_id_v,county_id=county_id_v, sub_county_id=sub_county_id_v,parish_id=parish_id_v WHERE district_name=in_district_name AND sub_county_name=in_sub_county_name AND parish_name=in_parish_name AND batch_id=in_batch_id ;
ELSE
UPDATE interface_data set status_v='Fail',status_v_desc=CONCAT(status_v_desc,'\n','=>Parish ',in_district_name,'/',in_sub_county_name ,'/',in_parish_name ,' does not exist!') WHERE district_name=in_district_name AND sub_county_name=in_sub_county_name AND parish_name=in_parish_name AND batch_id=in_batch_id ;
END IF;
ELSEIF in_reporting_level='District' THEN
SELECT district_id into district_id_v FROM district where district_name=in_district_name;
IF district_id_v!=0 THEN
UPDATE interface_data set district_id=district_id_v WHERE district_name=in_district_name AND batch_id=in_batch_id ;
ELSE
UPDATE interface_data set status_v='Fail',status_v_desc=CONCAT(status_v_desc,'\n','=>District ',in_district_name,' does not exist!') WHERE district_name=in_district_name AND batch_id=in_batch_id ;
END IF;
END IF;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_validate_batch
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_validate_batch`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validate_batch`(IN batch_id int,IN reporting_level_name varchar(500), IN in_validation_formula varchar(200),IN in_reporting_name varchar(200))
BEGIN
	SET SESSION group_concat_max_len = 1000000;
SET @sql = NULL;
SELECT
  GROUP_CONCAT(DISTINCT
    CONCAT('max(case when data_element_id = ',data_element_id,' then data_element_value end) AS ','DE',data_element_id,' ')
  ) INTO @sql
FROM  vw_interface_data where data_element_id;

SET @sql = CONCAT('SELECT batch_id,',reporting_level_name,' AS ReportingName, ', @sql, ' FROM vw_interface_data GROUP BY batch_id,',reporting_level_name,' having (',in_validation_formula,') AND ReportingName =''',in_reporting_name,''' AND batch_id=',batch_id);

prepare stmt from @sql;
execute stmt;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_validate_data
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_validate_data`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validate_data`(IN in_report_form_group_id int, IN in_batch_id int,IN in_reporting_level varchar(255))
BEGIN
	
DECLARE validation_rule_formula_v varchar(200);
DECLARE validation_rule_name_v varchar(200);

DECLARE validation_text varchar(12000);

DECLARE district_name_v varchar(200);
DECLARE county_name_v varchar(200);
DECLARE sub_county_name_v varchar(200);
DECLARE parish_name_v varchar(200);
DECLARE health_facility_name_v varchar(200);

-- For Existing DATA
DECLARE week_v int;
DECLARE month_v int;
DECLARE bi_month_v int;
DECLARE quarter_v int;
DECLARE year_v int;
DECLARE frequency_v varchar(50);
DECLARE reporting_hierarchy_v varchar(500);
-- For Existing DATA

DECLARE cur_validation_rules CURSOR FOR SELECT validation_rule_formula,validation_rule_name FROM validation_rule where report_form_group_id=in_report_form_group_id and is_active=1;
DECLARE cur_district_level CURSOR FOR SELECT DISTINCT district_name FROM interface_data where batch_id=in_batch_id;
DECLARE cur_parish_level CURSOR FOR SELECT DISTINCT district_name,county_name,sub_county_name,parish_name FROM interface_data where batch_id=in_batch_id;
DECLARE cur_facility_level CURSOR FOR SELECT DISTINCT district_name,county_name,sub_county_name,health_facility_name FROM interface_data where batch_id=in_batch_id;
DECLARE cur_location CURSOR FOR SELECT DISTINCT district_name,county_name,sub_county_name,parish_name,health_facility_name FROM interface_data where batch_id=in_batch_id;
-- For Existing DATA
DECLARE cur_interface_data CURSOR FOR SELECT DISTINCT CONCAT(district_name,CASE WHEN county_name IS NULL THEN '' ELSE county_name END,CASE WHEN sub_county_name IS NULL THEN '' ELSE sub_county_name END,CASE WHEN parish_name IS NULL THEN '' ELSE parish_name END ,CASE WHEN health_facility_name IS NULL THEN '' ELSE health_facility_name END) AS reporting_hierarchy,report_period_week,report_period_month,report_period_bi_month,report_period_quarter,report_period_year FROM interface_data where batch_id=in_batch_id;
-- For Existing DATA


SET sub_county_name_v ='';
SET parish_name_v ='';
SET health_facility_name_v='';

-- OPEN cur_validation_rules;
OPEN cur_district_level;
OPEN cur_parish_level;
OPEN cur_facility_level;
-- Begin IF --
-- Begin Validate District Level--
IF  in_reporting_level = 'District' THEN
BEGIN
DECLARE CONTINUE HANDLER FOR NOT FOUND SET district_name_v ='';
loopDistrict: LOOP
	FETCH cur_district_level INTO district_name_v;
IF district_name_v='' THEN
LEAVE loopDistrict;
END IF;
SET validation_text='';
OPEN cur_validation_rules;
BEGIN
DECLARE CONTINUE HANDLER FOR NOT FOUND SET validation_rule_formula_v='';
	loopValidationrule: LOOP
	FETCH cur_validation_rules INTO validation_rule_formula_v, validation_rule_name_v;
IF validation_rule_formula_v='' THEN
LEAVE loopValidationrule;
END IF;
call sp_validate_batch(in_batch_id,'CONCAT(district_name)',validation_rule_formula_v,CONCAT(district_name_v));
IF FOUND_ROWS()=0 THEN
IF LENGTH(validation_text)>0 THEN
SET validation_text=CONCAT(validation_text,'\n=>Failed Validation Rule:',validation_rule_name_v);
ELSE
SET validation_text=CONCAT(validation_text,'=>Failed Validation Rule:',validation_rule_name_v);
END IF;
END IF;
END LOOP;
IF LENGTH(validation_text)>0 THEN
UPDATE interface_data set status_v='Fail',status_v_desc=validation_text where batch_id=in_batch_id and district_name=district_name_v;
ELSE
UPDATE interface_data set status_v='Pass',status_v_desc='=>Passed Validation Rules' where batch_id=in_batch_id and district_name=district_name_v;
END IF;
END;
CLOSE cur_validation_rules;
END LOOP;
END;
-- End Validate District Level--
-- Begin Validate Parish Level--
ELSEIF   in_reporting_level = 'Parish' THEN
BEGIN
DECLARE CONTINUE HANDLER FOR NOT FOUND SET parish_name_v ='';
loopParish: LOOP
	FETCH cur_parish_level INTO district_name_v,county_name_v,sub_county_name_v,parish_name_v;
IF parish_name_v='' THEN
LEAVE loopParish;
END IF;
SET validation_text='';
OPEN cur_validation_rules;
BEGIN
DECLARE CONTINUE HANDLER FOR NOT FOUND SET validation_rule_formula_v='';
	loopValidationrule:	LOOP
	FETCH cur_validation_rules INTO validation_rule_formula_v, validation_rule_name_v;
IF validation_rule_formula_v='' THEN
LEAVE loopValidationrule;
END IF;
call sp_validate_batch(in_batch_id,'CONCAT(district_name,CASE WHEN county_name IS NULL THEN '''' ELSE county_name END,CASE WHEN sub_county_name IS NULL THEN '''' ELSE sub_county_name END,CASE WHEN parish_name IS NULL THEN '''' ELSE parish_name END ,CASE WHEN health_facility_name IS NULL THEN '''' ELSE health_facility_name END)',validation_rule_formula_v,CONCAT(district_name_v,county_name_v,sub_county_name_v,parish_name_v));
IF FOUND_ROWS()=0 THEN
IF LENGTH(validation_text)>0 THEN
SET validation_text=CONCAT(validation_text,'\n=>Failed Validation Rule:',validation_rule_name_v);
ELSE
SET validation_text=CONCAT(validation_text,'=>Failed Validation Rule:',validation_rule_name_v);
END IF;
END IF;
	END LOOP;
if LENGTH(validation_text)>0 THEN
UPDATE interface_data set status_v='Fail',status_v_desc=validation_text where batch_id=in_batch_id and district_name=district_name_v AND county_name=county_name_v AND sub_county_name=sub_county_name_v AND parish_name=parish_name_v;
ELSE
UPDATE interface_data set status_v='Pass',status_v_desc='=>Passed Validation Rules' where batch_id=in_batch_id and district_name=district_name_v AND county_name=county_name_v AND sub_county_name=sub_county_name_v AND parish_name=parish_name_v;
END IF;
END;
CLOSE cur_validation_rules;
END LOOP;
END;
-- End Validate Parish Level--
-- Begin Validate Facility Level--
ELSEIF   in_reporting_level = 'Facility' THEN
BEGIN
DECLARE CONTINUE HANDLER FOR NOT FOUND SET health_facility_name_v ='';
loopFacility: LOOP
	FETCH cur_facility_level INTO district_name_v,county_name_v,sub_county_name_v,health_facility_name_v;
IF health_facility_name_v='' THEN
LEAVE loopFacility;
END IF;
SET validation_text='';
OPEN cur_validation_rules;
BEGIN
DECLARE CONTINUE HANDLER FOR NOT FOUND SET validation_rule_formula_v='';
	loopValidationrule: LOOP

	FETCH cur_validation_rules INTO validation_rule_formula_v, validation_rule_name_v;
IF validation_rule_formula_v='' THEN
LEAVE loopValidationrule;
END IF;
call sp_validate_batch(in_batch_id,'CONCAT(district_name,CASE WHEN county_name IS NULL THEN '''' ELSE county_name END,CASE WHEN sub_county_name IS NULL THEN '''' ELSE sub_county_name END,CASE WHEN parish_name IS NULL THEN '''' ELSE parish_name END ,CASE WHEN health_facility_name IS NULL THEN '''' ELSE health_facility_name END)',validation_rule_formula_v,CONCAT(district_name_v,county_name_v,sub_county_name_v,health_facility_name_v));
IF FOUND_ROWS()=0 THEN
IF LENGTH(validation_text)>0 THEN
SET validation_text=CONCAT(validation_text,'\n=>Failed Validation Rule:',validation_rule_name_v);
ELSE
SET validation_text=CONCAT(validation_text,'=>Failed Validation Rule:',validation_rule_name_v);
END IF;
END IF;
	END LOOP;
if LENGTH(validation_text)>0 THEN
UPDATE interface_data set status_v='Fail',status_v_desc=validation_text where batch_id=in_batch_id and district_name=district_name_v AND county_name=county_name_v AND sub_county_name=sub_county_name_v AND health_facility_name=health_facility_name_v;
ELSE
UPDATE interface_data set status_v='Pass',status_v_desc='=>Passed Validation Rules' where batch_id=in_batch_id and district_name=district_name_v AND county_name=county_name_v AND sub_county_name=sub_county_name_v AND health_facility_name=health_facility_name_v;
END IF;
END;
CLOSE cur_validation_rules;
END LOOP;
END;
-- End Validate Facility Level--
END IF;
-- End IF

-- CLOSE cur_validation_rules;
CLOSE cur_district_level;
CLOSE cur_parish_level;
CLOSE cur_facility_level;


-- BEGIN Update Locations
BEGIN
DECLARE CONTINUE HANDLER FOR NOT FOUND SET district_name_v ='';
OPEN cur_location;
loopUpdateLocation: LOOP

	FETCH cur_location INTO district_name_v,county_name_v, sub_county_name_v,parish_name_v,health_facility_name_v;
		IF district_name_v='' THEN
		LEAVE loopUpdateLocation;
		END IF;
	CALL sp_update_location_id (in_reporting_level ,district_name_v,county_name_v,sub_county_name_v,parish_name_v,health_facility_name_v,in_batch_id);

END LOOP;
CLOSE cur_location;
END;
-- END Update Locations


select report_form_frequency from report_form where report_form_id in (select report_form_id from report_form_group where report_form_group_id=in_report_form_group_id) LIMIT 1 into frequency_v;

-- BEGIN Validate Existing Data
BEGIN
DECLARE CONTINUE HANDLER FOR NOT FOUND SET year_v =0;
OPEN cur_interface_data;
loopvalidateExisting: LOOP

	FETCH cur_interface_data INTO reporting_hierarchy_v, week_v,month_v,bi_month_v,quarter_v,year_v;
		IF year_v=0 THEN
		LEAVE loopvalidateExisting;
		END IF;
	CALL sp_validate_existing_data (reporting_hierarchy_v,frequency_v ,in_batch_id,week_v,month_v,bi_month_v,quarter_v,year_v);
END LOOP;
CLOSE cur_interface_data;
END;
-- END Validate Existing Data

-- BEGIN Move DATA
CALL sp_move_data_from_interface_to_base(in_batch_id);
-- END Move DATA


END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_validate_existing_data
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_validate_existing_data`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validate_existing_data`(IN in_reporting_hierarchy varchar(255),IN in_frequency varchar(50),IN in_batch_id int,IN in_week int , IN in_month int ,IN in_bi_month int, IN in_quarter int,IN in_calendar_year int)
BEGIN

IF in_frequency='Weekly' THEN
SELECT b.data_element_id,b.data_element_value FROM base_data AS b INNER JOIN district AS d ON b.district_id = d.district_id
								LEFT JOIN county c on b.county_id=c.county_id
                LEFT JOIN sub_county AS s ON b.sub_county_id = s.sub_county_id LEFT JOIN parish AS p ON b.parish_id = p.parish_id
                -- INNER JOIN financial_year AS fy ON b.financial_year_id = fy.financial_year_id
                LEFT JOIN health_facility AS f ON b.health_facility_id = f.health_facility_id
                INNER JOIN data_element ON b.data_element_id = data_element.data_element_id 
                INNER JOIN report_form_group AS rg ON data_element.report_form_group_id = rg.report_form_group_id
WHERE b.report_period_week=in_week AND b.report_period_month=in_month AND b.report_period_year=in_calendar_year AND CONCAT(d.district_name,CASE WHEN c.county_name IS NULL THEN '' ELSE c.county_name END,CASE WHEN s.sub_county_name IS NULL THEN '' ELSE s.sub_county_name END,CASE WHEN p.parish_name IS NULL THEN '' ELSE p.parish_name END ,CASE WHEN f.health_facility_name IS NULL THEN '' ELSE f.health_facility_name END)=in_reporting_hierarchy;

IF FOUND_ROWS()>0 THEN
UPDATE interface_data set status_v='Fail', status_v_desc=CONCAT(status_v_desc,'\n','=>Data for the same period has already been uploaded Location:', in_reporting_hierarchy ,'Year:',in_calendar_year,',Quarter:', in_quarter ,',Month:',in_month,',Week:', in_week) WHERE CONCAT(district_name,CASE WHEN county_name IS NULL THEN '' ELSE county_name END,CASE WHEN sub_county_name IS NULL THEN '' ELSE sub_county_name END,CASE WHEN parish_name IS NULL THEN '' ELSE parish_name END ,CASE WHEN health_facility_name IS NULL THEN '' ELSE health_facility_name END)=in_reporting_hierarchy AND batch_id= in_batch_id;
END IF;

END IF;

IF in_frequency='Monthly' THEN
SELECT b.data_element_id,b.data_element_value FROM base_data AS b INNER JOIN district AS d ON b.district_id = d.district_id
								LEFT JOIN county c on b.county_id=c.county_id
                LEFT JOIN sub_county AS s ON b.sub_county_id = s.sub_county_id LEFT JOIN parish AS p ON b.parish_id = p.parish_id
                -- INNER JOIN financial_year AS fy ON b.financial_year_id = fy.financial_year_id
                LEFT JOIN health_facility AS f ON b.health_facility_id = f.health_facility_id
                INNER JOIN data_element ON b.data_element_id = data_element.data_element_id 
                INNER JOIN report_form_group AS rg ON data_element.report_form_group_id = rg.report_form_group_id
WHERE b.report_period_month=in_month AND b.report_period_year=in_calendar_year AND CONCAT(d.district_name,CASE WHEN c.county_name IS NULL THEN '' ELSE c.county_name END,CASE WHEN s.sub_county_name IS NULL THEN '' ELSE s.sub_county_name END,CASE WHEN p.parish_name IS NULL THEN '' ELSE p.parish_name END ,CASE WHEN f.health_facility_name IS NULL THEN '' ELSE f.health_facility_name END)=in_reporting_hierarchy;

IF FOUND_ROWS()>0 THEN
UPDATE interface_data set status_v='Fail', status_v_desc=CONCAT(status_v_desc,'\n','=>Data for the same period has already been uploaded Location:', in_reporting_hierarchy ,'Year:',in_calendar_year,',Quarter:', in_quarter ,',Month:',in_month) WHERE CONCAT(district_name,CASE WHEN county_name IS NULL THEN '' ELSE county_name END,CASE WHEN sub_county_name IS NULL THEN '' ELSE sub_county_name END,CASE WHEN parish_name IS NULL THEN '' ELSE parish_name END ,CASE WHEN health_facility_name IS NULL THEN '' ELSE health_facility_name END)=in_reporting_hierarchy AND batch_id= in_batch_id;
END IF;

END IF;

IF in_frequency='Bi-Monthly' THEN
SELECT b.data_element_id,b.data_element_value FROM base_data AS b INNER JOIN district AS d ON b.district_id = d.district_id
								LEFT JOIN county c on b.county_id=c.county_id
                LEFT JOIN sub_county AS s ON b.sub_county_id = s.sub_county_id LEFT JOIN parish AS p ON b.parish_id = p.parish_id
                -- INNER JOIN financial_year AS fy ON b.financial_year_id = fy.financial_year_id
                LEFT JOIN health_facility AS f ON b.health_facility_id = f.health_facility_id
                INNER JOIN data_element ON b.data_element_id = data_element.data_element_id 
                INNER JOIN report_form_group AS rg ON data_element.report_form_group_id = rg.report_form_group_id
WHERE b.report_period_bi_month=in_bi_month AND b.report_period_year=in_calendar_year AND CONCAT(d.district_name,CASE WHEN c.county_name IS NULL THEN '' ELSE c.county_name END,CASE WHEN s.sub_county_name IS NULL THEN '' ELSE s.sub_county_name END,CASE WHEN p.parish_name IS NULL THEN '' ELSE p.parish_name END ,CASE WHEN f.health_facility_name IS NULL THEN '' ELSE f.health_facility_name END)=in_reporting_hierarchy;

IF FOUND_ROWS()>0 THEN
UPDATE interface_data set status_v='Fail', status_v_desc=CONCAT(status_v_desc,'\n','=>Data for the same period has already been uploaded Location:', in_reporting_hierarchy ,'Year:',in_calendar_year,',Quarter:', in_quarter ,',Month:',in_month) WHERE CONCAT(district_name,CASE WHEN county_name IS NULL THEN '' ELSE county_name END,CASE WHEN sub_county_name IS NULL THEN '' ELSE sub_county_name END,CASE WHEN parish_name IS NULL THEN '' ELSE parish_name END ,CASE WHEN health_facility_name IS NULL THEN '' ELSE health_facility_name END)=in_reporting_hierarchy AND batch_id= in_batch_id;
END IF;

END IF;

IF in_frequency='Quarterly' THEN
SELECT b.data_element_id,b.data_element_value FROM base_data AS b INNER JOIN district AS d ON b.district_id = d.district_id
								LEFT JOIN county c on b.county_id=c.county_id
                LEFT JOIN sub_county AS s ON b.sub_county_id = s.sub_county_id LEFT JOIN parish AS p ON b.parish_id = p.parish_id
                -- INNER JOIN financial_year AS fy ON b.financial_year_id = fy.financial_year_id
                LEFT JOIN health_facility AS f ON b.health_facility_id = f.health_facility_id
                INNER JOIN data_element ON b.data_element_id = data_element.data_element_id 
                INNER JOIN report_form_group AS rg ON data_element.report_form_group_id = rg.report_form_group_id
WHERE b.report_period_quarter=in_quarter AND b.report_period_year=in_calendar_year AND CONCAT(d.district_name,CASE WHEN c.county_name IS NULL THEN '' ELSE c.county_name END,CASE WHEN s.sub_county_name IS NULL THEN '' ELSE s.sub_county_name END,CASE WHEN p.parish_name IS NULL THEN '' ELSE p.parish_name END ,CASE WHEN f.health_facility_name IS NULL THEN '' ELSE f.health_facility_name END)=in_reporting_hierarchy;

IF FOUND_ROWS()>0 THEN
UPDATE interface_data set status_v='Fail', status_v_desc=CONCAT(status_v_desc,'\n','=>Data for the same period has already been uploaded Location:', in_reporting_hierarchy ,'Year:',in_calendar_year,',Quarter:', in_quarter) WHERE CONCAT(district_name,CASE WHEN county_name IS NULL THEN '' ELSE county_name END,CASE WHEN sub_county_name IS NULL THEN '' ELSE sub_county_name END,CASE WHEN parish_name IS NULL THEN '' ELSE parish_name END ,CASE WHEN health_facility_name IS NULL THEN '' ELSE health_facility_name END)=in_reporting_hierarchy AND batch_id= in_batch_id;
END IF;

END IF;

IF in_frequency='Annually' THEN
SELECT b.data_element_id,b.data_element_value FROM base_data AS b INNER JOIN district AS d ON b.district_id = d.district_id
								LEFT JOIN county c on b.county_id=c.county_id
                LEFT JOIN sub_county AS s ON b.sub_county_id = s.sub_county_id LEFT JOIN parish AS p ON b.parish_id = p.parish_id
                -- INNER JOIN financial_year AS fy ON b.financial_year_id = fy.financial_year_id
                LEFT JOIN health_facility AS f ON b.health_facility_id = f.health_facility_id
                INNER JOIN data_element ON b.data_element_id = data_element.data_element_id 
                INNER JOIN report_form_group AS rg ON data_element.report_form_group_id = rg.report_form_group_id
WHERE b.report_period_year=in_calendar_year AND CONCAT(d.district_name,CASE WHEN c.county_name IS NULL THEN '' ELSE c.county_name END,CASE WHEN s.sub_county_name IS NULL THEN '' ELSE s.sub_county_name END,CASE WHEN p.parish_name IS NULL THEN '' ELSE p.parish_name END ,CASE WHEN f.health_facility_name IS NULL THEN '' ELSE f.health_facility_name END)=in_reporting_hierarchy;

IF FOUND_ROWS()>0 THEN
UPDATE interface_data set status_v='Fail', status_v_desc=CONCAT(status_v_desc,'\n','=>Data for the same period has already been uploaded Location:', in_reporting_hierarchy ,'Year:',in_calendar_year) WHERE CONCAT(district_name,CASE WHEN county_name IS NULL THEN '' ELSE county_name END,CASE WHEN sub_county_name IS NULL THEN '' ELSE sub_county_name END,CASE WHEN parish_name IS NULL THEN '' ELSE parish_name END ,CASE WHEN health_facility_name IS NULL THEN '' ELSE health_facility_name END)=in_reporting_hierarchy AND batch_id= in_batch_id;
END IF;

END IF;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_validate_formula
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_validate_formula`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validate_formula`(IN `in_validation_formula` varchar(250))
BEGIN
	SET SESSION group_concat_max_len = 1000000;
SET @sql = NULL;
SELECT
  GROUP_CONCAT(DISTINCT
    CONCAT('max(case when data_element_id = ',data_element_id,' then data_element_id end) AS ','Col',data_element_id,' ')
  ) INTO @sql
FROM  data_element where data_element_id;

SET @sql = CONCAT('SELECT data_element_id,', @sql, ' FROM data_element GROUP BY data_element_id having (',in_validation_formula,')');

prepare stmt from @sql;
execute stmt;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_validate_kpi_summary_function
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_validate_kpi_summary_function`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validate_kpi_summary_function`(IN `in_kpi_summary_function` varchar(1000), IN in_report_form_id int)
BEGIN
SET SESSION group_concat_max_len = 100000000;
SET @sql = NULL;
SELECT
  GROUP_CONCAT(DISTINCT
    CONCAT('max(case when data_element_id = ',data_element_id,' then data_element_id end) AS ','DE',data_element_id,' ')
  ) INTO @sql
FROM  data_element where data_element_id;

-- Begin Create Temp Table
SET @sql_drop_table=CONCAT('DROP TABLE IF EXISTS z_temp_kpi_summary_function');
prepare stmt_drop_table from @sql_drop_table;
execute stmt_drop_table;
-- End Create Temp Table

SET @sql = CONCAT('CREATE TABLE z_temp_kpi_summary_function SELECT data_element_id,report_form_id,', @sql, ' FROM data_element having report_form_id=',in_report_form_id);

prepare stmt from @sql;
execute stmt;

SET @sql=CONCAT('SELECT ',in_kpi_summary_function,' FROM z_temp_kpi_summary_function');

prepare stmt from @sql;
execute stmt;

END
;;
DELIMITER ;

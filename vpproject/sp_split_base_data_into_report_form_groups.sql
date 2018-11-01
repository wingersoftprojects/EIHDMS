DROP PROCEDURE IF EXISTS `sp_split_base_data_into_report_form_groups`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_split_base_data_into_report_form_groups`(IN `in_report_form_id` int)
BEGIN
	
DECLARE report_form_group_id_v int;
DECLARE done int;
	DECLARE cur_report_form_group CURSOR FOR select report_form_group_id from report_form_group where report_form_id=in_report_form_id;


declare continue handler for not found set done=1;

    set done = 0;
    open cur_report_form_group;
    tableLoop: loop
        fetch cur_report_form_group into report_form_group_id_v;
        if done = 1 then leave tableLoop; end if;



SET @sql_text1=CONCAT('create table base_data_',in_report_form_id,'_',report_form_group_id_v,' (base_data_id INT NOT NULL AUTO_INCREMENT, primary key(base_data_id)) select  b.*,
                     d.district_name,
                     c.county_name,
                     sc.sub_county_name,
                     p.parish_name,
                     hf.health_facility_name,
                     se.section_name,
                     ss.sub_section_name,
                     de.data_element_name,
                     de.data_element_context,
                     de.data_type,
                     de.data_size,
                     de.age_category,
                     de.sex_category,
                     de.other_category,
                     ta.technical_area_name from base_data_',in_report_form_id,' b LEFT JOIN district AS d ON d.district_id = b.district_id
                     LEFT JOIN county AS c ON c.county_id = b.county_id
                     LEFT JOIN sub_county AS sc ON sc.sub_county_id = b.sub_county_id
                     LEFT JOIN parish AS p ON p.parish_id = b.parish_id
                     LEFT JOIN health_facility AS hf ON hf.health_facility_id = b.health_facility_id
                     INNER JOIN data_element AS de ON de.data_element_id = b.data_element_id
                     INNER JOIN section AS se ON de.section_id = se.section_id
                     INNER JOIN sub_section AS ss ON de.sub_section_id = ss.sub_section_id
                     LEFT JOIN technical_area AS ta ON de.technical_area_id = ta.technical_area_id where b.report_form_group_id=',report_form_group_id_v,';');
PREPARE stmt1 FROM @sql_text1;
EXECUTE stmt1;
DEALLOCATE PREPARE stmt1;
        
    end loop tableLoop;
    close cur_report_form_group;
	
	
END
;;
delimiter ;
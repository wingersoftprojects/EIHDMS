/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : eihdms

Target Server Type    : MYSQL
Target Server Version : 50199
File Encoding         : 65001

Date: 2017-02-22 19:22:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Procedure structure for sp_check_duplicate_temp_data_elements
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_check_duplicate_temp_data_elements`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_check_duplicate_temp_data_elements`(
	IN in_report_form_name varchar(250)
)
BEGIN 
	SELECT report_form_name,data_element_name FROM temp_data_element WHERE report_form_name=in_report_form_name GROUP BY data_element_name HAVING count(data_element_name)>1;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_create_report_form_base_data
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_create_report_form_base_data`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_create_report_form_base_data`(IN `in_report_form_id` int)
BEGIN 
SET @table_name=CONCAT('base_data_',in_report_form_id);
SET @sql1=CONCAT('CREATE TABLE IF NOT EXISTS ',@table_name);
SET @sql2="(
  `base_data_id` int(11) NOT NULL AUTO_INCREMENT,
  `batch_id` int(11) DEFAULT NULL,
  `data_element_id` int(11) NOT NULL,
  `data_element_value` varchar(100) NOT NULL,
  `health_facility_id` int(11) DEFAULT NULL,
  `parish_id` int(11) DEFAULT NULL,
  `sub_county_id` int(11) DEFAULT NULL,
  `county_id` int(11) DEFAULT NULL,
  `district_id` int(11) DEFAULT NULL,
  `financial_year_id` int(11) DEFAULT NULL,
  `report_period_month` int(11) DEFAULT NULL,
  `report_period_week` int(11) DEFAULT NULL,
  `report_period_year` int(11) DEFAULT NULL,
  `report_period_quarter` int(11) DEFAULT NULL,
  `report_period_from_date` date NOT NULL,
  `report_period_to_date` date NOT NULL,
  `is_deleted` int(1) NOT NULL,
  `is_active` int(1) NOT NULL,
  `add_date` datetime DEFAULT NULL,
  `add_by` int(10) DEFAULT NULL,
  `last_edit_date` datetime DEFAULT NULL,
  `last_edit_by` int(10) DEFAULT NULL,
  `report_period_bi_month` int(11) DEFAULT NULL,
  `report_form_id` int(11) DEFAULT NULL,
  `report_form_group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`base_data_id`)
  )";
SET @sql_text=CONCAT(@sql1,@sql2);
PREPARE stmt FROM @sql_text;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_delete_base_data
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_delete_base_data`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_base_data`(IN in_base_data_id_in LONGTEXT,IN in_deleted_by int,IN in_report_form_id int)
BEGIN
SET SESSION group_concat_max_len = 18446744073709551615;
SET @sql = NULL;

IF LENGTH(in_base_data_id_in)>0 THEN

SET @sql= CONCAT('INSERT INTO base_data_deleted (base_data_id,
data_element_id,
data_element_value,
health_facility_id,
parish_id,
sub_county_id,
county_id,
district_id,
financial_year_id,
report_period_week,
report_period_month,
report_period_bi_month,
report_period_quarter,
report_period_year,
report_period_from_date,
report_period_to_date,
is_deleted,
is_active,
add_date,
add_by,
last_edit_date,
last_edit_by,
batch_id,
report_form_id,
deleted_by,
delete_date,
report_form_group_id)

SELECT
base_data_id,
data_element_id,
data_element_value,
health_facility_id,
parish_id,
sub_county_id,
county_id,
district_id,
financial_year_id,
report_period_week,
report_period_month,
report_period_bi_month,
report_period_quarter,
report_period_year,
report_period_from_date,
report_period_to_date,
is_deleted,
is_active,
add_date,
add_by,
last_edit_date,
last_edit_by,
batch_id,
report_form_id,',
in_deleted_by,',
NOW(),
report_form_group_id
FROM
base_data_',in_report_form_id,'  where base_data_id in (',in_base_data_id_in,')');

prepare stmt from @sql;
execute stmt;

SET @sql= CONCAT('DELETE FROM base_data_',in_report_form_id,' where base_data_id in (',in_base_data_id_in,')');

prepare stmt from @sql;
execute stmt;

END IF;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_delete_from_interface_data_by_batch_id
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_delete_from_interface_data_by_batch_id`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_from_interface_data_by_batch_id`(IN in_batch_id int)
BEGIN
	DECLARE max_interface_data_id int;
  DECLARE min_interface_data_id int;
	DECLARE counter int;

	SELECT min(interface_data_id),max(interface_data_id) from interface_data where batch_id=in_batch_id into min_interface_data_id,max_interface_data_id;
SET counter=min_interface_data_id+600;

WHILE(min_interface_data_id < (max_interface_data_id+1200)) DO
delete from interface_data where batch_id=in_batch_id AND interface_data_id>=min_interface_data_id AND interface_data_id<=counter;
SET min_interface_data_id=min_interface_data_id+600;
SET counter=counter+600;
END WHILE;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_delete_login_session_id
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_delete_login_session_id`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_login_session_id`(IN in_user_detail_id int,IN in_session_id varchar(100))
BEGIN
	SET @nw=Now();
	UPDATE login_session SET  is_deleted=1,last_edit_date=@nw, last_edit_by=in_user_detail_id where session_id=in_session_id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_delete_login_session_unlogged_out
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_delete_login_session_unlogged_out`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_login_session_unlogged_out`(IN in_user_detail_id int)
BEGIN
	SET @nw=Now();
	UPDATE login_session SET  is_deleted=1,last_edit_date=@nw, last_edit_by=in_user_detail_id where timediff(@nw,add_date)>'12:00:00';
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_execute_insert_string
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_execute_insert_string`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_execute_insert_string`(IN in_sql_string LONGTEXT)
BEGIN
		SET SESSION group_concat_max_len = 18446744073709551615;

SET @count_v=0;
SELECT  
    ROUND (   
        (
            LENGTH(in_sql_string)
            - LENGTH( REPLACE (in_sql_string, ";", "") ) 
        ) / LENGTH(";")        
    ) AS count    INTO @count_v;

-- select @count_v;
SET @x = 1;
WHILE(@x <= @count_v) DO
SET @sql=SPLIT_STR(in_sql_string,';',@x);
prepare stmt from @sql;
execute stmt;
SET @x=@x+1;
END WHILE;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_load_data_element
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_load_data_element`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_load_data_element`(IN in_report_form_name varchar(100))
BEGIN

-- DECLARE report_form_name_v varchar(100);
DECLARE report_form_group_name_v varchar(100);
DECLARE section_name_v varchar(100);
DECLARE sub_section_name_v varchar(100);
DECLARE technical_area_name_v varchar(100);
DECLARE data_element_name_v varchar(255);
DECLARE report_form_id_v int;

DECLARE section_column_number_v int;
DECLARE group_column_number_v int;
DECLARE data_type_v varchar(100);
DECLARE data_size_v int;
DECLARE age_category_v varchar(100);
DECLARE sex_category_v varchar(100);
DECLARE other_category_v varchar(100);
DECLARE technical_area_name_v2 varchar(100);
DECLARE description_v varchar(255);
DECLARE data_element_code_v varchar(255);
DECLARE data_element_context_v varchar(255);
DECLARE report_form_group_name_v2 varchar(100);

DECLARE cur_report_form CURSOR FOR SELECT distinct report_form_name from temp_data_element where report_form_name=in_report_form_name;
DECLARE cur_technical_area CURSOR FOR SELECT distinct technical_area_name from temp_data_element where report_form_name=in_report_form_name;
DECLARE cur_report_form_group CURSOR FOR SELECT distinct report_form_group_name from temp_data_element where report_form_name IN (select DISTINCT report_form_name from report_form where report_form_name=in_report_form_name);
DECLARE cur_section CURSOR FOR SELECT distinct section_name from temp_data_element where report_form_name IN (select DISTINCT report_form_name from report_form where report_form_name=in_report_form_name);
DECLARE cur_sub_section CURSOR FOR SELECT distinct sub_section_name from temp_data_element where report_form_name=in_report_form_name AND section_name IN (select DISTINCT section_name from section where section_name=section_name_v and report_form_id in (select report_form_id from report_form where report_form_name=in_report_form_name));
DECLARE cur_data_element CURSOR FOR SELECT distinct data_element_name,section_column_number,group_column_number,data_type,data_size,age_category,sex_category,other_category,technical_area_name,description,data_element_code,data_element_context,report_form_group_name from temp_data_element where report_form_name=in_report_form_name AND sub_section_name IN (SELECT sub_section_name from sub_section where sub_section_name=sub_section_name_v AND section_id in (SELECT section_id from section where section_name=section_name_v AND report_form_id IN (SELECT report_form_id from report_form where report_form_name=in_report_form_name)));


select report_form_id from report_form where report_form_name=in_report_form_name into report_form_id_v;


-- Begin Technical Area
OPEN cur_technical_area;
BEGIN
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET technical_area_name_v ='';
	loopTechnicalArea: LOOP
			FETCH cur_technical_area INTO technical_area_name_v;
				IF technical_area_name_v='' THEN
					LEAVE loopTechnicalArea;
				END IF;

	SELECT * FROM technical_area where technical_area_name=technical_area_name_v;
	IF FOUND_ROWS()=0 AND technical_area_name_v<>'' THEN
		INSERT INTO technical_area (technical_area_name,description,is_deleted,is_active,add_by,add_date) VALUES (technical_area_name_v,technical_area_name_v,0,1,1,NOW());
	END IF;
END LOOP;
END;
CLOSE cur_technical_area;
-- End Technical Area


-- Begin Report form group
OPEN cur_report_form_group;
BEGIN
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET report_form_group_name_v ='';
	loopReportFormGroup: LOOP
			FETCH cur_report_form_group INTO report_form_group_name_v;
				IF report_form_group_name_v='' THEN
					LEAVE loopReportFormGroup;
				END IF;
	SELECT * FROM report_form_group where report_form_group_name=report_form_group_name_v AND report_form_id IN (select report_form_id from report_form where report_form_name=in_report_form_name);
		IF FOUND_ROWS()=0 THEN
			INSERT INTO report_form_group (report_form_group_name,`description`,report_form_id,group_order,is_deleted,is_active,add_by,add_date) VALUES (report_form_group_name_v,report_form_group_name_v,report_form_id_v,1,0,1,1,NOW());
		END IF;
	END LOOP;
END;
CLOSE cur_report_form_group;
-- End Report form group

-- Begin Section
OPEN cur_section;
BEGIN
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET section_name_v ='';
	loopSection: LOOP
			FETCH cur_section INTO section_name_v;
				IF section_name_v='' THEN
					LEAVE loopSection;
				END IF;

	SELECT * FROM section where section_name=section_name_v AND report_form_id=report_form_id_v;
	IF FOUND_ROWS()=0 THEN
		INSERT INTO section (section_name,section_order,report_form_id,is_deleted,is_active,add_by,add_date) VALUES (section_name_v,1,report_form_id_v,0,1,1,NOW());
	END IF;

-- Begin Sub Section
OPEN cur_sub_section;
BEGIN
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET sub_section_name_v ='';
	loopSubSection: LOOP
			FETCH cur_sub_section INTO sub_section_name_v;
				IF sub_section_name_v='' THEN
					LEAVE loopSubSection;
				END IF;

	SELECT * FROM sub_section where sub_section_name=sub_section_name_v AND section_id IN (SELECT section_id from section where section_name=section_name_v AND report_form_id=report_form_id_v);
	IF FOUND_ROWS()=0 THEN
		INSERT INTO sub_section (sub_section_name,sub_section_order,section_id,is_deleted,is_active,add_by,add_date) VALUES (sub_section_name_v,1,(SELECT section_id from section where section_name=section_name_v AND report_form_id=report_form_id_v),0,1,1,NOW());
	END IF;

-- Begin Data Element
OPEN cur_data_element;
BEGIN
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET data_element_name_v ='';
	loopDataElement: LOOP
			FETCH cur_data_element INTO data_element_name_v,section_column_number_v,group_column_number_v,data_type_v,data_size_v,age_category_v,sex_category_v,other_category_v,technical_area_name_v2,description_v,data_element_code_v,data_element_context_v,report_form_group_name_v2;
				IF data_element_name_v='' THEN
					LEAVE loopDataElement;
				END IF;

	SELECT * FROM data_element where data_element_name=data_element_name_v AND sub_section_id IN (SELECT sub_section_id from sub_section WHERE sub_section_name=sub_section_name_v AND section_id IN (SELECT section_id from section where section_name=section_name_v AND report_form_id=report_form_id_v));
	IF FOUND_ROWS()=0 THEN
		INSERT INTO data_element (report_form_id,section_id,sub_section_id,technical_area_id,report_form_group_id,data_element_name,
data_type,data_size,description,section_column_number,group_column_number,data_element_code,age_category,sex_category,
other_category,data_element_context,is_deleted,is_active,add_by,add_date) 
VALUES (report_form_id_v,
(SELECT section_id from section where section_name=section_name_v AND report_form_id=report_form_id_v),
(SELECT sub_section_id from sub_section WHERE sub_section_name=sub_section_name_v AND section_id IN (SELECT section_id from section where section_name=section_name_v AND report_form_id=report_form_id_v)),
(SELECT technical_area_id from technical_area where technical_area_name=technical_area_name_v2),
(SELECT report_form_group_id from report_form_group where report_form_group_name=report_form_group_name_v2 AND report_form_id=report_form_id_v),
data_element_name_v,
data_type_v,
data_size_v,
description_v,
section_column_number_v,
group_column_number_v,
data_element_code_v,
age_category_v,
sex_category_v,
other_category_v,
data_element_context_v,
0,1,1,NOW());
	END IF;
END LOOP;
END;
CLOSE cur_data_element;
-- End Data Element

END LOOP;
END;
CLOSE cur_sub_section;
-- End Sub Section

END LOOP;
END;
CLOSE cur_section;
-- End Section


END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_load_health_facility
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_load_health_facility`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_load_health_facility`()
BEGIN

DECLARE inserted_region_id_v int;
DECLARE inserted_district_id_v int;
DECLARE inserted_county_id_v int;
DECLARE inserted_sub_county_id_v int;
DECLARE inserted_parish_id_v int;
DECLARE inserted_health_facility_id_v int;
DECLARE is_active_v varchar(3);



DECLARE region_name_v varchar(200);
DECLARE district_name_v varchar(200);
DECLARE sub_district_name_v varchar(200);
DECLARE sub_district_name_v2 varchar(200);
DECLARE county_name_v varchar(200);
DECLARE sub_county_name_v varchar(200);
DECLARE parish_name_v varchar(200);
DECLARE health_facility_name_v varchar(200);
DECLARE facility_level_name_v varchar(200);
DECLARE facility_level_name_v2 varchar(200);
DECLARE ownership_v varchar(100);
DECLARE short_name_v varchar(100);
DECLARE xcoordinate_v varchar(100);
DECLARE ycoordinate_v varchar(100);
DECLARE zcoordinate_v varchar(100);
DECLARE cur_facility_level CURSOR FOR SELECT distinct facility_level_name from temp_health_facility;
DECLARE cur_regions CURSOR FOR SELECT distinct region_name from temp_health_facility;
DECLARE cur_districts CURSOR FOR SELECT distinct district_name from temp_health_facility where region_name IN (select DISTINCT region_name from region where region_name=region_name_v);
DECLARE cur_sub_districts CURSOR FOR SELECT distinct sub_district_name from temp_health_facility where district_name IN (select DISTINCT district_name from district where district_name=district_name_v and region_id in (select region_id from region where region_id=inserted_region_id_v));
DECLARE cur_counties CURSOR FOR SELECT distinct county_name from temp_health_facility where district_name IN (select DISTINCT district_name from district where district_id=inserted_district_id_v and region_id in (select region_id from region where region_id=inserted_region_id_v));
DECLARE cur_sub_counties CURSOR FOR SELECT distinct sub_county_name from temp_health_facility where county_name IN (SELECT county_name from county where county_name=county_name_v AND district_id in (SELECT district_id from district where district_name=district_name_v AND region_id IN (SELECT region_id from region where region_name=region_name_v)));
DECLARE cur_parishes CURSOR FOR SELECT distinct parish_name from temp_health_facility where sub_county_name IN (SELECT sub_county_name from sub_county where sub_county_id=inserted_sub_county_id_v AND county_id in (select county_id from county where county_id=inserted_county_id_v AND district_id in (select district_id from district where district_id=inserted_district_id_v AND region_id in (SELECT region_id from region where region_id=inserted_region_id_v))));
DECLARE cur_health_facilities CURSOR FOR SELECT distinct health_facility_name,parish_name,sub_county_name,county_name,sub_district_name,district_name,region_name,facility_level_name,ownership,short_name,xcoordinate,ycoordinate,zcoordinate,is_active from temp_health_facility;


-- Begin Facility Level
OPEN cur_facility_level;
BEGIN
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET facility_level_name_v ='';
	loopFacilityLevel: LOOP
			FETCH cur_facility_level INTO facility_level_name_v;
				IF facility_level_name_v='' THEN
					LEAVE loopFacilityLevel;
				END IF;

	SELECT * FROM facility_level where facility_level_name=facility_level_name_v;
	IF FOUND_ROWS()=0 THEN
		INSERT INTO facility_level (facility_level_name,is_deleted,is_active,add_by,add_date) VALUES (facility_level_name_v,0,1,1,NOW());
	END IF;
END LOOP;
END;
CLOSE cur_facility_level;
-- End Load Facility Level

-- Begin Load Region
OPEN cur_regions;
BEGIN
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET region_name_v ='';
	loopRegion: LOOP
			FETCH cur_regions INTO region_name_v;
				IF region_name_v='' THEN
					LEAVE loopRegion;
				END IF;

	SELECT * FROM region where region_name=region_name_v;
	IF FOUND_ROWS()=0 THEN
		INSERT INTO region (region_name,is_deleted,is_active,add_by,add_date) VALUES (region_name_v,0,1,1,NOW());
		SET inserted_region_id_v=LAST_INSERT_ID();
	END IF;

-- Begin Load District
OPEN cur_districts;
BEGIN
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET district_name_v ='';
	loopDistrict: LOOP
			FETCH cur_districts INTO district_name_v;
				IF district_name_v='' THEN
					LEAVE loopDistrict;
				END IF;

	SELECT * FROM district where district_name=district_name_v;
	IF FOUND_ROWS()=0 THEN
		-- INSERT INTO district (district_name,region_id,is_deleted,is_active,add_by,add_date) VALUES (district_name_v,(select region_id from region where region_name=region_name_v LIMIT 1),0,1,1,NOW());
		INSERT INTO district (district_name,region_id,is_deleted,is_active,add_by,add_date) VALUES (district_name_v,inserted_region_id_v,0,1,1,NOW());
		SET inserted_district_id_v=LAST_INSERT_ID();
	END IF;

-- Begin Load Sub District
OPEN cur_sub_districts;
BEGIN
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET sub_district_name_v ='';
	loopSubDistrict: LOOP
			FETCH cur_sub_districts INTO sub_district_name_v;
				IF sub_district_name_v='' THEN
					LEAVE loopSubDistrict;
				END IF;

	SELECT * FROM sub_district where sub_district_name=sub_district_name_v AND district_id in (SELECT district_id from district where district_name=district_name_v and region_id in(select region_id from region where region_name=region_name_v));
	IF FOUND_ROWS()=0 THEN
		-- INSERT INTO sub_district (sub_district_name,district_id,is_deleted,is_active,add_by,add_date) VALUES (sub_district_name_v,(SELECT district_id from district where district_name=district_name_v and region_id in(select region_id from region where region_name=region_name_v) LIMIT 1),0,1,1,NOW());
		INSERT INTO sub_district (sub_district_name,district_id,is_deleted,is_active,add_by,add_date) VALUES (sub_district_name_v,inserted_district_id_v,0,1,1,NOW());
	END IF;

	END LOOP;
END;
CLOSE cur_sub_districts;
-- End Load Sub District

-- Begin Load County
OPEN cur_counties;
BEGIN
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET county_name_v ='';
	loopCounty: LOOP
			FETCH cur_counties INTO county_name_v;
				IF county_name_v='' THEN
					LEAVE loopCounty;
				END IF;

	SELECT * FROM county where county_name=county_name_v AND district_id in (SELECT district_id from district where district_name=district_name_v and region_id in(select region_id from region where region_name=region_name_v));
	IF FOUND_ROWS()=0 THEN
		-- INSERT INTO county (county_name,district_id,is_deleted,is_active,add_by,add_date) VALUES (county_name_v,(SELECT district_id from district where district_name=district_name_v and region_id in(select region_id from region where region_name=region_name_v) LIMIT 1),0,1,1,NOW());
			INSERT INTO county (county_name,district_id,is_deleted,is_active,add_by,add_date) VALUES (county_name_v,inserted_district_id_v,0,1,1,NOW());
			SET inserted_county_id_v=LAST_INSERT_ID();
	END IF;

-- Begin Load Sub County
OPEN cur_sub_counties;
BEGIN
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET sub_county_name_v ='';
	loopSubCounty: LOOP
			FETCH cur_sub_counties INTO sub_county_name_v;
				IF sub_county_name_v='' THEN
					LEAVE loopSubCounty;
				END IF;

	SELECT * FROM sub_county where sub_county_name=sub_county_name_v AND county_id in (SELECT county_id from county where county_name=county_name_v and district_id in(select district_id from district where district_name=district_name_v AND region_id IN (select region_id from region where region_name=region_name_v)));
	IF FOUND_ROWS()=0 THEN
		-- INSERT INTO sub_county (sub_county_name,county_id,is_deleted,is_active,add_by,add_date) VALUES (sub_county_name_v,(SELECT county_id from county where county_name=county_name_v and district_id in(select district_id from district where district_name=district_name_v AND region_id IN (select region_id from region where region_name=region_name_v))),0,1,1,NOW());
		INSERT INTO sub_county (sub_county_name,county_id,is_deleted,is_active,add_by,add_date) VALUES (sub_county_name_v,inserted_county_id_v,0,1,1,NOW());
SET inserted_sub_county_id_v=LAST_INSERT_ID();
	END IF;

-- Begin Load Parish
OPEN cur_parishes;
BEGIN
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET parish_name_v ='';
	loopParish: LOOP
			FETCH cur_parishes INTO parish_name_v;
				IF parish_name_v='' THEN
					LEAVE loopParish;
				END IF;

	SELECT * FROM parish where parish_name=parish_name_v AND sub_county_id IN(SELECT sub_county_id from sub_county where sub_county_name=sub_county_name_v AND county_id in (SELECT county_id from county where county_name=county_name_v and district_id in(select district_id from district where district_name=district_name_v AND region_id IN (select region_id from region where region_name=region_name_v))));
	IF FOUND_ROWS()=0 THEN
	-- INSERT INTO parish (parish_name,sub_county_id,is_deleted,is_active,add_by,add_date) VALUES (parish_name_v,(SELECT sub_county_id from sub_county where sub_county_name=sub_county_name_v AND county_id in (SELECT county_id from county where county_name=county_name_v and district_id in(select district_id from district where district_name=district_name_v AND region_id IN (select region_id from region where region_name=region_name_v)))),0,1,1,NOW());
	INSERT INTO parish (parish_name,sub_county_id,is_deleted,is_active,add_by,add_date) VALUES (parish_name_v,inserted_sub_county_id_v,0,1,1,NOW());
	SET inserted_parish_id_v=LAST_INSERT_ID();
	END IF;
	END LOOP;
END;
CLOSE cur_parishes;
-- End Load Parish
	END LOOP;
END;
CLOSE cur_sub_counties;
-- End Load Sub County

	END LOOP;
END;
CLOSE cur_counties;
-- End Load County


	END LOOP;
END;
CLOSE cur_districts;
-- End Load District


	END LOOP;
END;
CLOSE cur_regions;
-- End Load Region


-- Begin Load Health Facility
OPEN cur_health_facilities;
BEGIN
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET health_facility_name_v ='';
	loopHealthFacility: LOOP
			FETCH cur_health_facilities INTO health_facility_name_v,parish_name_v,sub_county_name_v,county_name_v,sub_district_name_v2,district_name_v,region_name_v,facility_level_name_v2,ownership_v,short_name_v,xcoordinate_v,ycoordinate_v,zcoordinate_v,is_active_v;
				IF health_facility_name_v='' THEN
					LEAVE loopHealthFacility;
				END IF;

	SELECT * FROM health_facility where health_facility_name=health_facility_name_v AND parish_id IN (SELECT parish_id from parish where parish_name=parish_name_v AND sub_county_id IN(SELECT sub_county_id from sub_county where sub_county_name=sub_county_name_v AND county_id in (SELECT county_id from county where county_name=county_name_v and district_id in(select district_id from district where district_name=district_name_v AND region_id IN (select region_id from region where region_name=region_name_v)))));
IF FOUND_ROWS()=0 THEN
	SELECT sub_district_id from sub_district where sub_district_name=sub_district_name_v2 and district_id in(select district_id from district where district_name=district_name_v AND region_id IN (select region_id from region where region_name=region_name_v));
	IF FOUND_ROWS()>0 THEN
		INSERT INTO health_facility (health_facility_name,facility_level_id,parish_id,sub_county_id,county_id,sub_district_id,district_id,region_id,ownership,short_name,xcoordinate,ycoordinate,zcoordinate,is_deleted,is_active,add_by,add_date)
		VALUES (health_facility_name_v,
		(SELECT facility_level_id from facility_level where facility_level_name=facility_level_name_v2),
		(SELECT parish_id FROM parish where parish_name=parish_name_v AND sub_county_id IN (SELECT sub_county_id from sub_county where sub_county_name=sub_county_name_v AND county_id in (SELECT county_id from county where county_name=county_name_v and district_id in(select district_id from district where district_name=district_name_v AND region_id IN (select region_id from region where region_name=region_name_v))))),
		(SELECT sub_county_id from sub_county where sub_county_name=sub_county_name_v AND county_id in (SELECT county_id from county where county_name=county_name_v and district_id in(select district_id from district where district_name=district_name_v AND region_id IN (select region_id from region where region_name=region_name_v)))),
		(SELECT county_id from county where county_name=county_name_v and district_id in(select district_id from district where district_name=district_name_v AND region_id IN (select region_id from region where region_name=region_name_v))),
		(SELECT sub_district_id from sub_district where sub_district_name=sub_district_name_v2 and district_id in(select district_id from district where district_name=district_name_v AND region_id IN (select region_id from region where region_name=region_name_v))),
		(SELECT district_id from district where district_name=district_name_v and region_id in(select region_id from region where region_name=region_name_v)),
		(select region_id from region where region_name=region_name_v),
ownership_v,
short_name_v,
xcoordinate_v,
ycoordinate_v,
zcoordinate_v,
		0,
		CASE WHEN is_active_v='Y' THEN 1 ELSE 0 END,1,NOW());
	END IF;
END IF;

	END LOOP;
END;
CLOSE cur_health_facilities;
-- End Load Health Facility
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_move_data_from_interface_to_base
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_move_data_from_interface_to_base`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_move_data_from_interface_to_base`(IN in_report_form_id int,IN in_batch_id int,IN reporting_level varchar(100),IN in_frequency varchar(50),IN in_report_form_group_id int,IN in_week int , IN in_month int ,IN in_bi_month int, IN in_quarter int,IN in_calendar_year int)
BEGIN 
IF reporting_level='Facility' THEN 
SET @sql1=CONCAT("INSERT INTO base_data_",in_report_form_id);
SET @sql2=CONCAT("(data_element_id,
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
report_period_quarter,
sub_county_id,
batch_id,
report_period_month,
report_period_week,
report_period_year,report_period_bi_month,report_form_id,county_id,report_form_group_id) SELECT 
id.data_element_id,
id.data_element_value,
id.health_facility_id,
id.parish_id,
id.district_id,
id.report_period_from_date,
id.report_period_to_date,
id.is_deleted,
id.is_active,
id.add_date,
id.add_by,
id.last_edit_date,
id.last_edit_by,
id.report_period_quarter,
id.sub_county_id,
id.batch_id,
id.report_period_month,
id.report_period_week,
id.report_period_year,
id.report_period_bi_month,
id.report_form_id,
id.county_id,id.report_form_group_id
FROM interface_data id INNER JOIN validation_report vr on vr.batch_id=id.batch_id and vr.health_facility_id=id.health_facility_id where vr.batch_id=",in_batch_id," AND vr.status_v='Pass'");
SET @sql_text1=CONCAT(@sql1,@sql2);
PREPARE stmt1 FROM @sql_text1;
EXECUTE stmt1;
DEALLOCATE PREPARE stmt1;
ELSEIF reporting_level='Parish' THEN 
SET @sql11=CONCAT("INSERT INTO base_data_",in_report_form_id);
SET @sql22=CONCAT("(data_element_id,
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
report_period_quarter,
sub_county_id,
batch_id,
report_period_month,
report_period_week,
report_period_year,report_period_bi_month,report_form_id,county_id,report_form_group_id) SELECT 
id.data_element_id,
id.data_element_value,
id.health_facility_id,
id.parish_id,
id.district_id,
id.report_period_from_date,
id.report_period_to_date,
id.is_deleted,
id.is_active,
id.add_date,
id.add_by,
id.last_edit_date,
id.last_edit_by,
id.report_period_quarter,
id.sub_county_id,
id.batch_id,
id.report_period_month,
id.report_period_week,
id.report_period_year,
id.report_period_bi_month,
id.report_form_id,
id.county_id,id.report_form_group_id
FROM interface_data id INNER JOIN validation_report vr on vr.batch_id=id.batch_id and vr.parish_id=id.parish_id where vr.batch_id=",in_batch_id," AND vr.status_v='Pass'");
SET @sql_text2=CONCAT(@sql11,@sql22);
PREPARE stmt2 FROM @sql_text2;
EXECUTE stmt2;
DEALLOCATE PREPARE stmt2;
ELSEIF reporting_level='District' THEN 
SET @sql111=CONCAT("INSERT INTO base_data_",in_report_form_id);
SET @sql222=CONCAT("(data_element_id,
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
report_period_quarter,
sub_county_id,
batch_id,
report_period_month,
report_period_week,
report_period_year,report_period_bi_month,report_form_id,county_id,report_form_group_id) SELECT 
id.data_element_id,
id.data_element_value,
id.health_facility_id,
id.parish_id,
id.district_id,
id.report_period_from_date,
id.report_period_to_date,
id.is_deleted,
id.is_active,
id.add_date,
id.add_by,
id.last_edit_date,
id.last_edit_by,
id.report_period_quarter,
id.sub_county_id,
id.batch_id,
id.report_period_month,
id.report_period_week,
id.report_period_year,
id.report_period_bi_month,
id.report_form_id,
id.county_id,id.report_form_group_id
FROM interface_data id INNER JOIN validation_report vr on vr.batch_id=id.batch_id and vr.district_id=id.district_id where vr.batch_id=",in_batch_id," AND vr.status_v='Pass'");
SET @sql_text3=CONCAT(@sql111,@sql222);
PREPARE stmt3 FROM @sql_text3;
EXECUTE stmt3;
DEALLOCATE PREPARE stmt3;
END IF;


-- BEGIN Update STATUS
UPDATE validation_report set status_m='Pass',status_m_desc='Moved Successfully' WHERE  batch_id=in_batch_id AND status_v='Pass';
UPDATE validation_report set status_m='Fail',status_m_desc='Not Moved' WHERE  batch_id=in_batch_id AND status_v='Fail';
-- END Update STATUS

-- BEGIN loaded_data_summary
SELECT * FROM validation_report where status_v='Pass' and batch_id=in_batch_id;
IF FOUND_ROWS()>0 THEN
INSERT INTO loaded_data_summary (report_period_month,
report_period_week,
report_period_year,
report_period_quarter,
report_period_bi_month,
report_form_group_id,
report_form_id,
batch_id,
add_by,
add_date,
loaded_entities) SELECT DISTINCT report_period_month,
report_period_week,
report_period_year,
report_period_quarter,
report_period_bi_month,
report_form_group_id,
report_form_id,
batch_id,
add_by,
add_date,
(select count(*) from validation_report where status_v='Pass' and batch_id=in_batch_id) FROM validation_report WHERE batch_id=in_batch_id AND status_v='Pass';
END IF;
-- END loaded_data_summary


-- Delete from interface_data
-- DELETE from interface_data WHERE batch_id=in_batch_id;
CALL sp_delete_from_interface_data_by_batch_id(in_batch_id);
-- Delete from interface_data

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_pivot_base_data_by_form_id_and_logged_in_user
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_pivot_base_data_by_form_id_and_logged_in_user`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pivot_base_data_by_form_id_and_logged_in_user`(IN in_report_form_id int,IN in_table_name varchar(100),IN in_data_element_ids_involved varchar(1000))
BEGIN
SET SESSION group_concat_max_len = 18446744073709551615;
SET @sql = NULL;

SET @sql_text=NULL;

SET @source=CONCAT('(((((((((base_data_',in_report_form_id,' `bd` join `district` `d` on((`bd`.`district_id` = `d`.`district_id`))) join `region` `r` on((`d`.`region_id` = `r`.`region_id`))) left join `sub_county` `sc` on((`bd`.`sub_county_id` = `sc`.`sub_county_id`))) left join `county` `c` on((`c`.`county_id` = `bd`.`county_id`))) left join `parish` `p` on((`bd`.`parish_id` = `p`.`parish_id`))) left join `health_facility` `h` on((`bd`.`health_facility_id` = `h`.`health_facility_id`))) join `data_element` `de` on((`bd`.`data_element_id` = `de`.`data_element_id`))) join `report_form` `rf` on((`de`.`report_form_id` = `rf`.`report_form_id`))) join `report_form_group` `rfg` on((`de`.`report_form_group_id` = `rfg`.`report_form_group_id`))) ');

SET @sql_text=CONCAT('SELECT
  GROUP_CONCAT(DISTINCT
    CONCAT(''max(case when bd.data_element_id = '',bd.data_element_id,'' then data_element_value end) AS '',''DE'',bd.data_element_id,'' '')
  ) INTO @sql
FROM ',@source,'where bd.report_form_id=',in_report_form_id,' AND bd.data_element_id in (',in_data_element_ids_involved,')');

prepare stmt from @sql_text;
execute stmt;

SET @sql_drop_table=CONCAT('DROP TABLE IF EXISTS ','z_temp_base_data_',in_table_name);

prepare stmt_drop_table from @sql_drop_table;
execute stmt_drop_table;

SET @sql = CONCAT('CREATE TABLE ', 'z_temp_base_data_',in_table_name ,' SELECT r.region_id,d.district_id,c.county_id,sc.sub_county_id,p.parish_id,h.health_facility_id,region_name,district_name,county_name,sub_county_name,parish_name,health_facility_name,report_period_year,report_period_quarter,report_period_month,report_period_bi_month,report_period_week,bd.report_form_id,', @sql, ' FROM ',@source,' GROUP BY region_id,district_id,county_id,sub_county_id,parish_id,health_facility_id,region_name,district_name,county_name,sub_county_name,parish_name,health_facility_name,report_period_year,report_period_quarter,report_period_month,report_period_bi_month,report_period_week,report_form_id HAVING report_form_id=',in_report_form_id);

prepare stmt from @sql;
execute stmt;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_search_room_by_name_empty
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_search_room_by_name_empty`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_search_room_by_name_empty`(IN `in_search_name` varchar(50))
BEGIN
	SELECT * FROM view_room 
	WHERE (room_number LIKE concat('%',in_search_name,'%') OR room_category_name LIKE concat('%',in_search_name,'%'))
 AND room_id not in (select room_id from room_occupancy where (room_occupancy_status ='Checked In' or room_occupancy_status='Reserved') AND room_id is not null)
AND room_id is not null 
	ORDER BY room_category_name,room_number ASC; 
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_select_kpi
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_select_kpi`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_select_kpi`(IN in_kpi_id int,IN in_username varchar(200),IN in_report_form_id int,IN in_report_period_year varchar(1000),IN in_district_id varchar(1000), IN in_kpi_summary_functions varchar(1000),IN in_data_element_ids_involved varchar(1000))
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

SET @count_data =0;
SET @sql=CONCAT('SELECT count(*) FROM base_data_',in_report_form_id,' WHERE ',@report_period_year_v,' AND ',@district_id_v,' INTO @count_data');

prepare stmt from @sql;
execute stmt;


IF @count_data>0 THEN 

CALL sp_pivot_base_data_by_form_id_and_logged_in_user(in_report_form_id ,in_username,in_data_element_ids_involved);

-- SELECT kpi_summary_function FROM kpi where kpi_id=in_kpi_id into kpi_summary_function_v;

SET @sql_kpi=CONCAT('SELECT district_name,county_name,sub_county_name,parish_name,health_facility_name,report_period_year,report_period_quarter,report_period_month,report_period_bi_month,report_period_week,',in_kpi_summary_functions,' FROM z_temp_base_data_',in_username,' AS temp WHERE ',@district_id_v,' AND ',@report_period_year_v);

prepare stmt_select_kpi from @sql_kpi;
execute stmt_select_kpi;

ELSE
SET @sql=CONCAT('SELECT * FROM base_data_',in_report_form_id,' WHERE ',@report_period_year_v,' AND ',@district_id_v);
prepare stmt from @sql;
execute stmt;
END IF;
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_location_id`(IN in_reporting_level varchar(50), IN in_batch_id int)
BEGIN

SET @sql = NULL;

IF in_reporting_level='Facility' THEN
-- Updates status on fail
UPDATE validation_report set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Failed validation because Health Facility ',district_name,'/',sub_county_name,'/',health_facility_name,' Does not exist!') where batch_id=in_batch_id and district_id is null;

ELSEIF in_reporting_level='Parish' THEN

-- Updates status on fail
UPDATE validation_report set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Failed validation because Parish ',district_name,'/',sub_county_name,'/',parish_name,' Does not exist!') where batch_id=in_batch_id and district_id is null;

ELSEIF in_reporting_level='District' THEN

-- Updates status on fail
UPDATE validation_report set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Failed validation because District ',district_name,' Does not exist!') where batch_id=in_batch_id and district_id is null;

END IF;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_validate_batch
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_validate_batch`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validate_batch`(IN in_batch_id int,IN reporting_level_name varchar(500), IN in_validation_formula varchar(200),IN in_reporting_name varchar(200))
BEGIN
SET SESSION group_concat_max_len = 18446744073709551615;
SET @sql = NULL;
SET @sql_text=NULL;

SET @sql_text=CONCAT('SELECT
  GROUP_CONCAT(DISTINCT
    CONCAT(''max(case when data_element_id = '',data_element_id,'' then data_element_value end) AS '',''DE'',data_element_id,'' '')
  )  FROM ', 'vw_interface_data' ,' where batch_id=',in_batch_id,' INTO @sql');


prepare stmt from @sql_text;
execute stmt;

-- SELECT @sql;


SET @sql = CONCAT('SELECT batch_id,',reporting_level_name,' AS ReportingName, ', @sql, ' FROM vw_interface_data GROUP BY batch_id,',reporting_level_name,' having (',in_validation_formula,') AND ReportingName =''',in_reporting_name,''' AND batch_id=',in_batch_id);

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
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validate_data`(IN in_report_form_id int,IN in_report_form_group_id int, IN in_batch_id int,IN in_reporting_level varchar(255))
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

-- Load validation_report
INSERT INTO validation_report (district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
district_id,
county_id,
sub_county_id,
parish_id,
health_facility_id,
report_form_group_id,
report_form_id,
report_period_bi_month,
report_period_month,
report_period_week,
report_period_year,
report_period_quarter,
batch_id,add_by,add_date) SELECT DISTINCT district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
district_id,
county_id,
sub_county_id,
parish_id,
health_facility_id,
report_form_group_id,
report_form_id,
report_period_bi_month,
report_period_month,
report_period_week,
report_period_year,
report_period_quarter,
batch_id,add_by,NOW() FROM interface_data where batch_id=in_batch_id;
-- Load validation_report

SET sub_county_name_v ='';
SET parish_name_v ='';
SET health_facility_name_v='';

-- Begin Validations rules
SELECT * FROM validation_rule where report_form_group_id=in_report_form_group_id;
IF FOUND_ROWS()>0 THEN
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
UPDATE validation_report set status_v='Fail',status_v_desc=validation_text where batch_id=in_batch_id and district_name=district_name_v;
ELSE
UPDATE validation_report set status_v='Pass',status_v_desc='=>Passed Validation Rules' where batch_id=in_batch_id and district_name=district_name_v;
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
UPDATE validation_report set status_v='Fail',status_v_desc=validation_text where batch_id=in_batch_id and district_name=district_name_v AND county_name=county_name_v AND sub_county_name=sub_county_name_v AND parish_name=parish_name_v;
ELSE
UPDATE validation_report set status_v='Pass',status_v_desc='=>Passed Validation Rules' where batch_id=in_batch_id and district_name=district_name_v AND county_name=county_name_v AND sub_county_name=sub_county_name_v AND parish_name=parish_name_v;
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
UPDATE validation_report set status_v='Fail',status_v_desc=validation_text where batch_id=in_batch_id and district_name=district_name_v AND county_name=county_name_v AND sub_county_name=sub_county_name_v AND health_facility_name=health_facility_name_v;
ELSE
UPDATE validation_report set status_v='Pass',status_v_desc='=>Passed Validation Rules' where batch_id=in_batch_id and district_name=district_name_v AND county_name=county_name_v AND sub_county_name=sub_county_name_v AND health_facility_name=health_facility_name_v;
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
ELSE
UPDATE validation_report set status_v='Pass',status_v_desc='=>Passed Validation Rules' where batch_id=in_batch_id;
END IF;
-- End Validation rules

-- BEGIN Update Locations
	CALL sp_update_location_id (in_reporting_level,in_batch_id);
-- END Update Locations


 -- BEGIN Validate Existing Data
select report_form_frequency from report_form where report_form_id in (select report_form_id from report_form_group where report_form_group_id=in_report_form_group_id) LIMIT 1 into frequency_v;
select distinct report_period_week,report_period_month,report_period_bi_month,report_period_quarter,report_period_year from interface_data where batch_id=in_batch_id into week_v,month_v,bi_month_v,quarter_v,year_v;
CALL sp_validate_existing_data (in_report_form_id,frequency_v ,in_batch_id,week_v,month_v,bi_month_v,quarter_v,year_v,in_report_form_group_id,in_reporting_level);
-- END Validate Existing Data

-- BEGIN Move DATA
CALL sp_move_data_from_interface_to_base(in_report_form_id,in_batch_id,in_reporting_level,frequency_v,in_report_form_group_id,week_v,month_v,bi_month_v,quarter_v,year_v);
-- END Move DATA

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_validate_existing_data
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_validate_existing_data`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validate_existing_data`(IN in_report_form_id int,IN in_frequency varchar(50),IN in_batch_id int,IN in_week int , IN in_month int ,IN in_bi_month int, IN in_quarter int,IN in_calendar_year int,IN in_report_form_group_id int,IN in_reporting_level varchar(100))
BEGIN

IF in_frequency='Weekly' THEN
SELECT * FROM loaded_data_summary where report_period_year=in_calendar_year and report_period_month=in_month and report_period_week=in_week and report_form_group_id=in_report_form_group_id;
IF FOUND_ROWS()>0 THEN
IF in_reporting_level='Facility' THEN 
SET @sql1=CONCAT("
UPDATE validation_report
set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Data for the same period (Week:',report_period_week,'/Month:',report_period_month,'/Year:',report_period_year,') already exists')
WHERE health_facility_id in (select DISTINCT health_facility_id from base_data_",in_report_form_id," where report_period_year=",in_calendar_year," AND report_period_month=",in_month," AND report_period_week=",in_week,") and batch_id=",in_batch_id);
PREPARE stmt1 FROM @sql1;
EXECUTE stmt1;
DEALLOCATE PREPARE stmt1;
ELSEIF in_reporting_level='Parish' THEN
SET @sql2=CONCAT("
UPDATE validation_report
set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Data for the same period (Week:',report_period_week,'/Month:',report_period_month,'/Year:',report_period_year,') already exists')
WHERE parish_id in (select DISTINCT parish_id from base_data_",in_report_form_id," where report_period_year=",in_calendar_year," AND report_period_month=",in_month," AND report_period_week=",in_week,") and batch_id=",in_batch_id);
PREPARE stmt2 FROM @sql2;
EXECUTE stmt2;
DEALLOCATE PREPARE stmt2;
 ELSEIF in_reporting_level='District' THEN 
SET @sql3=CONCAT("
UPDATE validation_report
set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Data for the same period (Week:',report_period_week,'/Month:',report_period_month,'/Year:',report_period_year,') already exists')
WHERE district_id in (select DISTINCT district_id from base_data_",in_report_form_id," where report_period_year=",in_calendar_year," AND report_period_month=",in_month," AND report_period_week=",in_week,") and batch_id=",in_batch_id);
PREPARE stmt3 FROM @sql3;
EXECUTE stmt3;
DEALLOCATE PREPARE stmt3;
END IF;
END IF;
END IF;

IF in_frequency='Monthly' THEN 
SELECT * FROM loaded_data_summary where report_period_year=in_calendar_year and report_period_month=in_month and report_form_group_id=in_report_form_group_id;
IF FOUND_ROWS()>0 THEN 
IF in_reporting_level='Facility' THEN 
SET @sql4=CONCAT("
UPDATE validation_report
set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Data for the same period (Month:',report_period_month,'/Year:',report_period_year,') already exists')
WHERE health_facility_id in (select DISTINCT health_facility_id from base_data_",in_report_form_id," where report_period_year=",in_calendar_year," AND report_period_month=",in_month,") and batch_id=",in_batch_id);
PREPARE stmt4 FROM @sql4;
EXECUTE stmt4;
DEALLOCATE PREPARE stmt4;
ELSEIF in_reporting_level='Parish' THEN 
SET @sql5=CONCAT("
UPDATE validation_report
set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Data for the same period (Month:',report_period_month,'/Year:',report_period_year,') already exists')
WHERE parish_id in (select DISTINCT parish_id from base_data_",in_report_form_id," where report_period_year=",in_calendar_year," AND report_period_month=",in_month,") and batch_id=",in_batch_id);
PREPARE stmt5 FROM @sql5;
EXECUTE stmt5;
DEALLOCATE PREPARE stmt5;
 ELSEIF in_reporting_level='District' THEN 
SET @sql6=CONCAT("
UPDATE validation_report
set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Data for the same period (Month:',report_period_month,'/Year:',report_period_year,') already exists')
WHERE district_id in (select DISTINCT district_id from base_data_",in_report_form_id," where report_period_year=",in_calendar_year," AND report_period_month=",in_month,") and batch_id=",in_batch_id);
PREPARE stmt6 FROM @sql6;
EXECUTE stmt6;
DEALLOCATE PREPARE stmt6;
END IF;
END IF;
END IF;

IF in_frequency='Bi-Monthly' THEN
SELECT * FROM loaded_data_summary where report_period_year=in_calendar_year and report_period_bi_month=in_bi_month and report_form_group_id=in_report_form_group_id;
IF FOUND_ROWS()>0 THEN
IF in_reporting_level='Facility' THEN 
SET @sql7=CONCAT("
UPDATE validation_report
set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Data for the same period (Bi-Month:',report_period_bi_month,'/Year:',report_period_year,') already exists')
WHERE health_facility_id in (select health_facility_id from base_data_",in_report_form_id," where report_period_year=",in_calendar_year," AND report_period_bi_month=",in_bi_month,") and batch_id=",in_batch_id);
PREPARE stmt7 FROM @sql7;
EXECUTE stmt7;
DEALLOCATE PREPARE stmt7;
ELSEIF in_reporting_level='Parish' THEN 
SET @sql8=CONCAT("
UPDATE validation_report
set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Data for the same period (Bi-Month:',report_period_bi_month,'/Year:',report_period_year,') already exists')
WHERE parish_id in (select parish_id from base_data_",in_report_form_id," where report_period_year=",in_calendar_year," AND report_period_bi_month=",in_bi_month,") and batch_id=",in_batch_id);
PREPARE stmt8 FROM @sql8;
EXECUTE stmt8;
DEALLOCATE PREPARE stmt8;
 ELSEIF in_reporting_level='District' THEN 
SET @sql9=CONCAT("
UPDATE validation_report
set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Data for the same period (Bi-Month:',report_period_bi_month,'/Year:',report_period_year,') already exists')
WHERE district_id in (select district_id from base_data_",in_report_form_id," where report_period_year=",in_calendar_year," AND report_period_bi_month=",in_bi_month,") and batch_id=",in_batch_id);
PREPARE stmt9 FROM @sql9;
EXECUTE stmt9;
DEALLOCATE PREPARE stmt9;
END IF;
END IF;
END IF;

IF in_frequency='Quarterly' THEN
SELECT * FROM loaded_data_summary where report_period_year=in_calendar_year and report_period_quarter=in_quarter and report_form_group_id=in_report_form_group_id;
IF FOUND_ROWS()>0 THEN 
IF in_reporting_level='Facility' THEN
SET @sql10=CONCAT("
UPDATE validation_report
set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Data for the same period (Quarter:',report_period_quarter,'/Year:',report_period_year,') already exists')
WHERE health_facility_id in (select health_facility_id from base_data_",in_report_form_id," where report_period_year=",in_calendar_year," AND report_period_quarter=",in_quarter,") and batch_id=",in_batch_id);
PREPARE stmt10 FROM @sql10;
EXECUTE stmt10;
DEALLOCATE PREPARE stmt10;
ELSEIF in_reporting_level='Parish' THEN 
SET @sql11=CONCAT("
UPDATE validation_report
set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Data for the same period (Quarter:',report_period_quarter,'/Year:',report_period_year,') already exists')
WHERE parish_id in (select parish_id from base_data_",in_report_form_id," where report_period_year=",in_calendar_year," AND report_period_quarter=",in_quarter,") and batch_id=",in_batch_id);
PREPARE stmt11 FROM @sql11;
EXECUTE stmt11;
DEALLOCATE PREPARE stmt11;
 ELSEIF in_reporting_level='District' THEN 
SET @sql12=CONCAT("
UPDATE validation_report
set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Data for the same period (Quarter:',report_period_quarter,'/Year:',report_period_year,') already exists')
WHERE district_id in (select district_id from base_data_",in_report_form_id," where report_period_year=",in_calendar_year," AND report_period_quarter=",in_quarter,") and batch_id=",in_batch_id);
PREPARE stmt12 FROM @sql12;
EXECUTE stmt12;
DEALLOCATE PREPARE stmt12;
END IF;
END IF;
END IF;

IF in_frequency='Annually' THEN
SELECT * FROM loaded_data_summary where report_period_year=in_calendar_year and report_form_group_id=in_report_form_group_id;
IF FOUND_ROWS()>0 THEN
IF in_reporting_level='Facility' THEN 
SET @sql13=CONCAT("
UPDATE validation_report
set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Data for the same period (Year:',report_period_year,') already exists')
WHERE health_facility_id in (select health_facility_id from base_data_",in_report_form_id," where report_period_year=",in_calendar_year,") and batch_id=",in_batch_id);
PREPARE stmt13 FROM @sql13;
EXECUTE stmt13;
DEALLOCATE PREPARE stmt13;
ELSEIF in_reporting_level='Parish' THEN 
SET @sql14=CONCAT("
UPDATE validation_report
set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Data for the same period (Year:',report_period_year,') already exists')
WHERE parish_id in (select parish_id from base_data_",in_report_form_id," where report_period_year=",in_calendar_year,") and batch_id=",in_batch_id);
PREPARE stmt14 FROM @sql14;
EXECUTE stmt14;
DEALLOCATE PREPARE stmt14;
 ELSEIF in_reporting_level='District' THEN 
SET @sql15=CONCAT("
UPDATE validation_report
set status_v='Fail',status_v_desc=CONCAT(CASE WHEN status_v_desc is null THEN '' ELSE status_v_desc END,'\n=>Data for the same period (Year:',report_period_year,') already exists')
WHERE district_id in (select district_id from base_data_",in_report_form_id," where report_period_year=",in_calendar_year,") and batch_id=",in_batch_id);
PREPARE stmt15 FROM @sql15;
EXECUTE stmt15;
DEALLOCATE PREPARE stmt15;
END IF;
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validate_formula`(IN `in_validation_formula` varchar(250),IN in_report_form_group_id int)
BEGIN
	SET SESSION group_concat_max_len = 18446744073709551615;
SET @sql = NULL;
SELECT
  GROUP_CONCAT(DISTINCT
    CONCAT('max(case when data_element_id = ',data_element_id,' then data_element_id end) AS ','DE',data_element_id,' ')
  ) INTO @sql
FROM  data_element where report_form_group_id=in_report_form_group_id;

SET @sql = CONCAT('SELECT data_element_id,', @sql, ' FROM data_element where report_form_group_id=',in_report_form_group_id,' GROUP BY data_element_id having (',in_validation_formula,')');

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
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validate_kpi_summary_function`(IN `in_kpi_summary_function` varchar(1000), IN in_report_form_id int,IN in_data_element_ids_involved varchar(1000))
BEGIN
SET SESSION group_concat_max_len = 18446744073709551615;
SET @sql = NULL;

SET @insert_into_sql =CONCAT('SELECT
  GROUP_CONCAT(DISTINCT
    CONCAT(''max(case when data_element_id = '',data_element_id,'' then data_element_id end) AS '',''DE'',data_element_id,'' '')
  ) INTO @sql
FROM  data_element where report_form_id=',in_report_form_id,' and data_element_id in (',in_data_element_ids_involved,')');

prepare stmt from @insert_into_sql;
execute stmt;


-- Begin Create Temp Table
SET @sql_drop_table=CONCAT('DROP TABLE IF EXISTS z_temp_kpi_summary_function');
prepare stmt_drop_table from @sql_drop_table;
execute stmt_drop_table;
-- End Create Temp Table

SET @sql = CONCAT('CREATE TABLE z_temp_kpi_summary_function SELECT data_element_id,report_form_id,', @sql, ' FROM data_element having report_form_id=',in_report_form_id,' AND data_element_id in (',in_data_element_ids_involved,')');

prepare stmt from @sql;
execute stmt;

SET @sql=CONCAT('SELECT ',in_kpi_summary_function,' FROM z_temp_kpi_summary_function');

prepare stmt from @sql;
execute stmt;

END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for SPLIT_STR
-- ----------------------------
DROP FUNCTION IF EXISTS `SPLIT_STR`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SPLIT_STR`(x LONGTEXT,
  delim VARCHAR(12),
  pos INT) RETURNS longtext CHARSET utf8
RETURN REPLACE(SUBSTRING(SUBSTRING_INDEX(x, delim, pos),
       LENGTH(SUBSTRING_INDEX(x, delim, pos -1)) + 1),
       delim, '')
;;
DELIMITER ;

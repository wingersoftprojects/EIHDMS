SET FOREIGN_KEY_CHECKS=0;

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
report_period_name,
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
report_period_year) SELECT 
data_element_id,
data_element_value,
health_facility_id,
parish_id,
district_id,
report_period_from_date,
report_period_to_date,
report_period_name,
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
report_period_year 
FROM interface_data where batch_id=in_batch_id AND status_v='Pass';


-- BEGIN Update STATUS
UPDATE interface_data set status_m='Pass',status_m_desc='Moved Successfully' WHERE  batch_id=in_batch_id AND status_v='Pass';
-- END Update STATUS
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_update_location_id
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_update_location_id`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_location_id`(IN in_reporting_level varchar(50),IN in_district_name varchar(200), IN in_sub_county_name varchar(200), IN in_parish_name varchar(200), IN in_health_facility_name varchar(200), IN in_batch_id int)
BEGIN

DECLARE health_facility_id_v int;
DECLARE parish_id_v int;
DECLARE sub_county_id_v int;
DECLARE district_id_v int;


IF in_reporting_level='Facility' THEN
SELECT district_id FROM district where district_name=in_district_name into district_id_v;
SELECT sub_county_id FROM sub_county sc INNER JOIN county c on c.county_id=sc.county_id where c.district_id=district_id_v AND sub_county_name=in_sub_county_name limit 1 into sub_county_id_v;
SELECT health_facility_id FROM health_facility where sub_county_id=sub_county_id_v AND district_id=district_id_v AND health_facility_name=in_health_facility_name into health_facility_id_v;

IF health_facility_id_v!=0 THEN
UPDATE interface_data set district_id=district_id_v, sub_county_id=sub_county_id_v,health_facility_id=health_facility_id_v WHERE district_name=in_district_name AND sub_county_name=in_sub_county_name AND health_facility_name=in_health_facility_name AND batch_id=in_batch_id ;
ELSE
UPDATE interface_data set status_v='Fail',status_v_desc=CONCAT(status_v_desc,'\n','Facility ',in_district_name,'/',in_sub_county_name ,'/',in_health_facility_name ,' does not exist!') WHERE district_name=in_district_name AND sub_county_name=in_sub_county_name AND health_facility_name=in_health_facility_name AND batch_id=in_batch_id ;
END IF;
ELSEIF in_reporting_level='Parish' THEN
SELECT district_id FROM district where district_name=in_district_name into district_id_v;
SELECT sub_county_id FROM sub_county sc INNER JOIN county c on c.county_id=sc.county_id where c.district_id=district_id_v AND sub_county_name=in_sub_county_name limit 1 into sub_county_id_v;
SELECT parish_id FROM parish where sub_county_id=sub_county_id_v AND district_id=district_id_v AND parish_name=in_parish_name into parish_id_v;

IF parish_id_v!=0 THEN
UPDATE interface_data set district_id=district_id_v, sub_county_id=sub_county_id_v,parish_id=parish_id_v WHERE district_name=in_district_name AND sub_county_name=in_sub_county_name AND parish_name=in_parish_name AND batch_id=in_batch_id ;
ELSE
UPDATE interface_data set status_v='Fail',status_v_desc=CONCAT(status_v_desc,'\n','Parish ',in_district_name,'/',in_sub_county_name ,'/',in_parish_name ,' does not exist!') WHERE district_name=in_district_name AND sub_county_name=in_sub_county_name AND parish_name=in_parish_name AND batch_id=in_batch_id ;
END IF;
ELSEIF in_reporting_level='District' THEN
SELECT district_id into district_id_v FROM district where district_name=in_district_name;
IF district_id_v!=0 THEN
UPDATE interface_data set district_id=district_id_v WHERE district_name=in_district_name AND batch_id=in_batch_id ;
ELSE
UPDATE interface_data set status_v='Fail',status_v_desc=CONCAT(status_v_desc,'\n','District ',in_district_name,' does not exist!') WHERE district_name=in_district_name AND batch_id=in_batch_id ;
END IF;
END IF;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for sp_validate_data
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_validate_data`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validate_data`(IN in_report_form_group_id int, IN in_batch_id int,IN in_reporting_level varchar(50))
BEGIN
	
DECLARE validation_rule_formula_v varchar(200);
DECLARE validation_rule_name_v varchar(200);

DECLARE validation_text varchar(12000);

DECLARE district_name_v varchar(200);
DECLARE sub_county_name_v varchar(200);
DECLARE parish_name_v varchar(200);
DECLARE health_facility_name_v varchar(200);

-- For Existing DATA
DECLARE week_v int;
DECLARE month_v int;
DECLARE quarter_v int;
DECLARE year_v int;
DECLARE frequency_v varchar(50);
DECLARE reporting_hierarchy_v varchar(500);
-- For Existing DATA

DECLARE cur_validation_rules CURSOR FOR SELECT validation_rule_formula,validation_rule_name FROM validation_rule where report_form_group_id=in_report_form_group_id and is_active=1;
DECLARE cur_district_level CURSOR FOR SELECT DISTINCT district_name FROM interface_data where batch_id=in_batch_id;
DECLARE cur_parish_level CURSOR FOR SELECT DISTINCT district_name,sub_county_name,parish_name FROM interface_data where batch_id=in_batch_id;
DECLARE cur_facility_level CURSOR FOR SELECT DISTINCT district_name,sub_county_name,health_facility_name FROM interface_data where batch_id=in_batch_id;
DECLARE cur_location CURSOR FOR SELECT DISTINCT district_name,sub_county_name,parish_name,health_facility_name FROM interface_data where batch_id=in_batch_id;
-- For Existing DATA
DECLARE cur_interface_data CURSOR FOR SELECT DISTINCT CONCAT(district_name,sub_county_name,parish_name,health_facility_name) AS reporting_hierarchy,report_period_week,report_period_month,report_period_quarter,report_period_year FROM interface_data where batch_id=in_batch_id;
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
SET validation_text=CONCAT(validation_text,'\n',validation_rule_name_v);
END IF;
END LOOP;
if LENGTH(validation_text)>0 THEN
UPDATE interface_data set status_v='Fail',status_v_desc=validation_text where batch_id=in_batch_id and district_name=district_name_v;
ELSE
UPDATE interface_data set status_v='Pass',status_v_desc='Validated and ready for moving' where batch_id=in_batch_id and district_name=district_name_v;
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
	FETCH cur_parish_level INTO district_name_v,sub_county_name_v,parish_name_v;
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
call sp_validate_batch(in_batch_id,'CONCAT(district_name,sub_county_name,parish_name)',validation_rule_formula_v,CONCAT(district_name_v,sub_county_name_v,parish_name_v));
IF FOUND_ROWS()=0 THEN
SET validation_text=CONCAT(validation_text,'\n',validation_rule_name_v);
   END IF;
	END LOOP;
if LENGTH(validation_text)>0 THEN
UPDATE interface_data set status_v='Fail',status_v_desc=validation_text where batch_id=in_batch_id and district_name=district_name_v AND sub_county_name=sub_county_name_v AND parish_name=parish_name_v;
ELSE
UPDATE interface_data set status_v='Pass',status_v_desc='Validated and ready for moving' where batch_id=in_batch_id and district_name=district_name_v AND sub_county_name=sub_county_name_v AND parish_name=parish_name_v;
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
	FETCH cur_facility_level INTO district_name_v,sub_county_name_v,health_facility_name_v;
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
call sp_validate_batch(in_batch_id,'CONCAT(district_name,sub_county_name,health_facility_name)',validation_rule_formula_v,CONCAT(district_name_v,sub_county_name_v,health_facility_name_v));
IF FOUND_ROWS()=0 THEN
SET validation_text=CONCAT(validation_text,'\n',validation_rule_name_v);
   END IF;
	END LOOP;
if LENGTH(validation_text)>0 THEN
UPDATE interface_data set status_v='Fail',status_v_desc=validation_text where batch_id=in_batch_id and district_name=district_name_v AND sub_county_name=sub_county_name_v AND health_facility_name=health_facility_name_v;
ELSE
UPDATE interface_data set status_v='Pass',status_v_desc='Validated and ready for moving' where batch_id=in_batch_id and district_name=district_name_v AND sub_county_name=sub_county_name_v AND health_facility_name=health_facility_name_v;
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

	FETCH cur_location INTO district_name_v, sub_county_name_v,parish_name_v,health_facility_name_v;
		IF district_name_v='' THEN
		LEAVE loopUpdateLocation;
		END IF;
	CALL sp_update_location_id (in_reporting_level ,district_name_v,sub_county_name_v,parish_name_v,health_facility_name_v,in_batch_id);

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

	FETCH cur_interface_data INTO reporting_hierarchy_v, week_v,month_v,quarter_v,year_v;
		IF year_v=0 THEN
		LEAVE loopvalidateExisting;
		END IF;
	CALL sp_validate_existing_data (reporting_hierarchy_v,frequency_v ,in_batch_id,week_v,month_v,quarter_v,year_v);
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validate_existing_data`(IN in_reporting_hierarchy varchar(255),IN in_frequency varchar(50),IN in_batch_id int,IN in_week int , IN in_month int , IN in_quarter int,IN in_calendar_year int)
BEGIN

IF in_frequency='Weekly' THEN
SELECT b.data_element_id,b.data_element_value FROM base_data AS b INNER JOIN district AS d ON b.district_id = d.district_id
                 LEFT JOIN sub_county AS s ON b.sub_county_id = s.sub_county_id LEFT JOIN parish AS p ON b.parish_id = p.parish_id
                INNER JOIN financial_year AS fy ON b.financial_year_id = fy.financial_year_id
                LEFT JOIN health_facility AS f ON b.health_facility_id = f.health_facility_id
                INNER JOIN data_element ON b.data_element_id = data_element.data_element_id 
                INNER JOIN report_form_group AS rg ON data_element.report_form_group_id = rg.report_form_group_id
WHERE b.report_period_week=in_week AND b.report_period_month=in_month AND b.report_period_quarter=in_quarter AND b.report_period_year=in_calendar_year AND CONCAT(d.district_name,CASE WHEN s.sub_county_name IS NULL THEN '' ELSE s.sub_county_name END,CASE WHEN p.parish_name IS NULL THEN '' ELSE p.parish_name END ,CASE WHEN f.health_facility_name IS NULL THEN '' ELSE f.health_facility_name END)=in_reporting_hierarchy;

IF FOUND_ROWS()>0 THEN
UPDATE interface_data set status_v='Fail', status_v_desc=CONCAT(status_v_desc,'\n','Data for the same period has already been uploaded Location:', in_reporting_hierarchy ,'Year:',in_calendar_year,',Quarter:', in_quarter ,',Month:',in_month,',Week:', in_week) WHERE CONCAT(district_name,sub_county_name,parish_name,health_facility_name)=in_reporting_hierarchy AND batch_id= in_batch_id;
END IF;

END IF;

IF in_frequency='Monthly' THEN
SELECT b.data_element_id,b.data_element_value FROM base_data AS b INNER JOIN district AS d ON b.district_id = d.district_id
                 LEFT JOIN sub_county AS s ON b.sub_county_id = s.sub_county_id LEFT JOIN parish AS p ON b.parish_id = p.parish_id
                INNER JOIN financial_year AS fy ON b.financial_year_id = fy.financial_year_id
                LEFT JOIN health_facility AS f ON b.health_facility_id = f.health_facility_id
                INNER JOIN data_element ON b.data_element_id = data_element.data_element_id 
                INNER JOIN report_form_group AS rg ON data_element.report_form_group_id = rg.report_form_group_id
WHERE b.report_period_month=in_month AND b.report_period_quarter=in_quarter AND b.report_period_year=in_calendar_year AND CONCAT(d.district_name,CASE WHEN s.sub_county_name IS NULL THEN '' ELSE s.sub_county_name END,CASE WHEN p.parish_name IS NULL THEN '' ELSE p.parish_name END ,CASE WHEN f.health_facility_name IS NULL THEN '' ELSE f.health_facility_name END)=in_reporting_hierarchy;

IF FOUND_ROWS()>0 THEN
UPDATE interface_data set status_v='Fail', status_v_desc=CONCAT(status_v_desc,'\n','Data for the same period has already been uploaded Location:', in_reporting_hierarchy ,'Year:',in_calendar_year,',Quarter:', in_quarter ,',Month:',in_month) WHERE CONCAT(district_name,sub_county_name,parish_name,health_facility_name)=in_reporting_hierarchy AND batch_id= in_batch_id;
END IF;

END IF;

IF in_frequency='Bi-Monthly' THEN
SELECT b.data_element_id,b.data_element_value FROM base_data AS b INNER JOIN district AS d ON b.district_id = d.district_id
                 LEFT JOIN sub_county AS s ON b.sub_county_id = s.sub_county_id LEFT JOIN parish AS p ON b.parish_id = p.parish_id
                INNER JOIN financial_year AS fy ON b.financial_year_id = fy.financial_year_id
                LEFT JOIN health_facility AS f ON b.health_facility_id = f.health_facility_id
                INNER JOIN data_element ON b.data_element_id = data_element.data_element_id 
                INNER JOIN report_form_group AS rg ON data_element.report_form_group_id = rg.report_form_group_id
WHERE b.report_period_month=in_month AND b.report_period_quarter=in_quarter AND b.report_period_year=in_calendar_year AND CONCAT(d.district_name,CASE WHEN s.sub_county_name IS NULL THEN '' ELSE s.sub_county_name END,CASE WHEN p.parish_name IS NULL THEN '' ELSE p.parish_name END ,CASE WHEN f.health_facility_name IS NULL THEN '' ELSE f.health_facility_name END)=in_reporting_hierarchy;

IF FOUND_ROWS()>0 THEN
UPDATE interface_data set status_v='Fail', status_v_desc=CONCAT(status_v_desc,'\n','Data for the same period has already been uploaded Location:', in_reporting_hierarchy ,'Year:',in_calendar_year,',Quarter:', in_quarter ,',Month:',in_month) WHERE CONCAT(district_name,sub_county_name,parish_name,health_facility_name)=in_reporting_hierarchy AND batch_id= in_batch_id;
END IF;

END IF;

IF in_frequency='Quarterly' THEN
SELECT b.data_element_id,b.data_element_value FROM base_data AS b INNER JOIN district AS d ON b.district_id = d.district_id
                 LEFT JOIN sub_county AS s ON b.sub_county_id = s.sub_county_id LEFT JOIN parish AS p ON b.parish_id = p.parish_id
                INNER JOIN financial_year AS fy ON b.financial_year_id = fy.financial_year_id
                LEFT JOIN health_facility AS f ON b.health_facility_id = f.health_facility_id
                INNER JOIN data_element ON b.data_element_id = data_element.data_element_id 
                INNER JOIN report_form_group AS rg ON data_element.report_form_group_id = rg.report_form_group_id
WHERE b.report_period_quarter=in_quarter AND b.report_period_year=in_calendar_year AND CONCAT(d.district_name,CASE WHEN s.sub_county_name IS NULL THEN '' ELSE s.sub_county_name END,CASE WHEN p.parish_name IS NULL THEN '' ELSE p.parish_name END ,CASE WHEN f.health_facility_name IS NULL THEN '' ELSE f.health_facility_name END)=in_reporting_hierarchy;

IF FOUND_ROWS()>0 THEN
UPDATE interface_data set status_v='Fail', status_v_desc=CONCAT(status_v_desc,'\n','Data for the same period has already been uploaded Location:', in_reporting_hierarchy ,'Year:',in_calendar_year,',Quarter:', in_quarter) WHERE CONCAT(district_name,sub_county_name,parish_name,health_facility_name)=in_reporting_hierarchy AND batch_id= in_batch_id;
END IF;

END IF;

IF in_frequency='Annually' THEN
SELECT b.data_element_id,b.data_element_value FROM base_data AS b INNER JOIN district AS d ON b.district_id = d.district_id
                 LEFT JOIN sub_county AS s ON b.sub_county_id = s.sub_county_id LEFT JOIN parish AS p ON b.parish_id = p.parish_id
                INNER JOIN financial_year AS fy ON b.financial_year_id = fy.financial_year_id
                LEFT JOIN health_facility AS f ON b.health_facility_id = f.health_facility_id
                INNER JOIN data_element ON b.data_element_id = data_element.data_element_id 
                INNER JOIN report_form_group AS rg ON data_element.report_form_group_id = rg.report_form_group_id
WHERE b.report_period_year=in_calendar_year AND CONCAT(d.district_name,CASE WHEN s.sub_county_name IS NULL THEN '' ELSE s.sub_county_name END,CASE WHEN p.parish_name IS NULL THEN '' ELSE p.parish_name END ,CASE WHEN f.health_facility_name IS NULL THEN '' ELSE f.health_facility_name END)=in_reporting_hierarchy;

IF FOUND_ROWS()>0 THEN
UPDATE interface_data set status_v='Fail', status_v_desc=CONCAT(status_v_desc,'\n','Data for the same period has already been uploaded Location:', in_reporting_hierarchy ,'Year:',in_calendar_year) WHERE CONCAT(district_name,sub_county_name,parish_name,health_facility_name)=in_reporting_hierarchy AND batch_id= in_batch_id;
END IF;

END IF;

END
;;
DELIMITER ;

SET FOREIGN_KEY_CHECKS=1;


DROP PROCEDURE IF EXISTS sp_update_data_obligation_monthly;
DELIMITER //
CREATE PROCEDURE sp_update_data_obligation_monthly
(
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
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_update_data_obligation_bi_monthly;
DELIMITER //
CREATE PROCEDURE sp_update_data_obligation_bi_monthly
(
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
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_update_data_obligation_quarterly;
DELIMITER //
CREATE PROCEDURE sp_update_data_obligation_quarterly
(
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
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_update_data_obligation_weekly;
DELIMITER //
CREATE PROCEDURE sp_update_data_obligation_weekly
(
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
END//
DELIMITER ;
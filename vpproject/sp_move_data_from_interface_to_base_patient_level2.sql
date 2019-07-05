
-- ----------------------------
-- Procedure structure for sp_move_data_from_interface_to_base_patient_level2
-- ----------------------------
DROP PROCEDURE IF EXISTS sp_move_data_from_interface_to_base_patient_level2;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_move_data_from_interface_to_base_patient_level2`(IN in_report_form_id int,IN in_batch_id int,IN reporting_level varchar(100),IN in_frequency varchar(50),IN in_report_form_group_id int,IN in_week int , IN in_month int ,IN in_bi_month int, IN in_quarter int,IN in_calendar_year int)
BEGIN 
IF reporting_level='Facility' THEN 
SET @sql1=CONCAT("INSERT INTO base_data_",in_report_form_id,'_',in_report_form_group_id);
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
report_period_year,report_period_bi_month,report_form_id,county_id,report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name) SELECT 
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
id.county_id,
id.report_form_group_id,
entry_mode,
id.rec_id,
id.district_name,
id.county_name,
id.sub_county_name,
id.parish_name,
id.health_facility_name,
se.section_name,
ss.sub_section_name,
de.data_element_name,
de.data_element_context,
de.data_type,
de.data_size,
de.age_category,
de.sex_category,
de.other_category,
ta.technical_area_name
FROM interface_data id 
INNER JOIN data_element AS de ON de.data_element_id = id.data_element_id
INNER JOIN section AS se ON de.section_id = se.section_id
INNER JOIN sub_section AS ss ON de.sub_section_id = ss.sub_section_id
LEFT JOIN technical_area AS ta ON de.technical_area_id = ta.technical_area_id 
INNER JOIN validation_report vr on vr.batch_id=id.batch_id and vr.health_facility_id=id.health_facility_id where vr.batch_id=",in_batch_id," AND vr.status_v='Pass'");

SET @sql_text1=CONCAT(@sql1,@sql2);
PREPARE stmt1 FROM @sql_text1;
EXECUTE stmt1;
DEALLOCATE PREPARE stmt1;

-- Update for SMS Data
-- Weekly
IF in_frequency='Weekly' THEN
-- Insert into base_data_deleted2 before updating

SET @sql= CONCAT('INSERT INTO base_data_deleted2 (base_data_id,
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
report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name)

SELECT
b.base_data_id,
b.data_element_id,
b.data_element_value,
b.health_facility_id,
b.parish_id,
b.sub_county_id,
b.county_id,
b.district_id,
b.financial_year_id,
b.report_period_week,
b.report_period_month,
b.report_period_bi_month,
b.report_period_quarter,
b.report_period_year,
b.report_period_from_date,
b.report_period_to_date,
b.is_deleted,
b.is_active,
b.add_date,
b.add_by,
b.last_edit_date,
b.last_edit_by,
b.batch_id,
b.report_form_id,1,
NOW(),
b.report_form_group_id,b.entry_mode,b.rec_id,
b.district_name,
b.county_name,
b.sub_county_name,
b.parish_name,
b.health_facility_name,
b.section_name,
b.sub_section_name,
b.data_element_name,
b.data_element_context,
b.data_type,
b.data_size,
b.age_category,
b.sex_category,
b.other_category,
b.technical_area_name
FROM
base_data_',in_report_form_id,'_',in_report_form_group_id," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.health_facility_id=b.health_facility_id
			 AND b.report_period_week=i.report_period_week
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.health_facility_id=i.health_facility_id
	AND i.entry_mode='SMS'
	AND b.report_period_week=",in_week,
	" AND b.report_period_year=",in_calendar_year
	);
	-- " AND report_period_month=",in_month
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month

prepare stmt from @sql;
execute stmt;
DEALLOCATE PREPARE stmt;
-- End insert


SET @sql2=CONCAT("UPDATE base_data_",in_report_form_id,'_',in_report_form_group_id);
SET @sql21=CONCAT(@sql2," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.health_facility_id=b.health_facility_id
			 AND b.report_period_week=i.report_period_week
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 SET b.data_element_value = i.data_element_value
WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.health_facility_id=i.health_facility_id
	AND i.entry_mode='SMS'
	AND b.report_period_week=",in_week,
		" AND b.report_period_year=",in_calendar_year
	);
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month
	-- " AND report_period_month=",in_month
	
PREPARE stmt12 FROM @sql21;
EXECUTE stmt12;
DEALLOCATE PREPARE stmt12;
END IF;

-- Monthly
IF in_frequency='Monthly' THEN
-- Insert into base_data_deleted2 before updating

SET @sql= CONCAT('INSERT INTO base_data_deleted2 (base_data_id,
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
report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name)

SELECT
b.base_data_id,
b.data_element_id,
b.data_element_value,
b.health_facility_id,
b.parish_id,
b.sub_county_id,
b.county_id,
b.district_id,
b.financial_year_id,
b.report_period_week,
b.report_period_month,
b.report_period_bi_month,
b.report_period_quarter,
b.report_period_year,
b.report_period_from_date,
b.report_period_to_date,
b.is_deleted,
b.is_active,
b.add_date,
b.add_by,
b.last_edit_date,
b.last_edit_by,
b.batch_id,
b.report_form_id,1,
NOW(),
b.report_form_group_id,b.entry_mode,b.rec_id,
b.district_name,
b.county_name,
b.sub_county_name,
b.parish_name,
b.health_facility_name,
b.section_name,
b.sub_section_name,
b.data_element_name,
b.data_element_context,
b.data_type,
b.data_size,
b.age_category,
b.sex_category,
b.other_category,
b.technical_area_name
FROM
base_data_',in_report_form_id,'_',in_report_form_group_id," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.health_facility_id=b.health_facility_id
			 AND b.report_period_month=i.report_period_month
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.health_facility_id=i.health_facility_id
	AND i.entry_mode='SMS'
	AND b.report_period_month=",in_month,
	" AND b.report_period_year=",in_calendar_year
	);
	-- " AND report_period_month=",in_month
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month

prepare stmt from @sql;
execute stmt;
DEALLOCATE PREPARE stmt;
-- End insert


SET @sql2=CONCAT("UPDATE base_data_",in_report_form_id,'_',in_report_form_group_id);
SET @sql21=CONCAT(@sql2," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.health_facility_id=b.health_facility_id
			 AND b.report_period_month=i.report_period_month
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 SET b.data_element_value = i.data_element_value
WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.health_facility_id=i.health_facility_id
	AND i.entry_mode='SMS'
	AND b.report_period_month=",in_month,
		" AND b.report_period_year=",in_calendar_year
	);
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month
	-- " AND report_period_month=",in_month
	
PREPARE stmt12 FROM @sql21;
EXECUTE stmt12;
DEALLOCATE PREPARE stmt12;
END IF;

-- Bi-Monthly
IF in_frequency='Bi-Monthly' THEN
-- Insert into base_data_deleted2 before updating

SET @sql= CONCAT('INSERT INTO base_data_deleted2 (base_data_id,
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
report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name)

SELECT
b.base_data_id,
b.data_element_id,
b.data_element_value,
b.health_facility_id,
b.parish_id,
b.sub_county_id,
b.county_id,
b.district_id,
b.financial_year_id,
b.report_period_week,
b.report_period_month,
b.report_period_bi_month,
b.report_period_quarter,
b.report_period_year,
b.report_period_from_date,
b.report_period_to_date,
b.is_deleted,
b.is_active,
b.add_date,
b.add_by,
b.last_edit_date,
b.last_edit_by,
b.batch_id,
b.report_form_id,1,
NOW(),
b.report_form_group_id,b.entry_mode,b.rec_id,
b.district_name,
b.county_name,
b.sub_county_name,
b.parish_name,
b.health_facility_name,
b.section_name,
b.sub_section_name,
b.data_element_name,
b.data_element_context,
b.data_type,
b.data_size,
b.age_category,
b.sex_category,
b.other_category,
b.technical_area_name
FROM
base_data_',in_report_form_id,'_',in_report_form_group_id," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.health_facility_id=b.health_facility_id
			 AND b.report_period_bi_month=i.report_period_bi_month
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.health_facility_id=i.health_facility_id
	AND i.entry_mode='SMS'
	AND b.report_period_bi_month=",in_bi_month,
	" AND b.report_period_year=",in_calendar_year
	);
	-- " AND report_period_month=",in_month
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month

prepare stmt from @sql;
execute stmt;
DEALLOCATE PREPARE stmt;
-- End insert


SET @sql2=CONCAT("UPDATE base_data_",in_report_form_id,'_',in_report_form_group_id);
SET @sql21=CONCAT(@sql2," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.health_facility_id=b.health_facility_id
			 AND b.report_period_bi_month=i.report_period_bi_month
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 SET b.data_element_value = i.data_element_value
WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.health_facility_id=i.health_facility_id
	AND i.entry_mode='SMS'
	AND b.report_period_bi_month=",in_bi_month,
		" AND b.report_period_year=",in_calendar_year
	);
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month
	-- " AND report_period_month=",in_month
	
PREPARE stmt12 FROM @sql21;
EXECUTE stmt12;
DEALLOCATE PREPARE stmt12;
END IF;

-- Quarterly
IF in_frequency='Quarterly' THEN
-- Insert into base_data_deleted2 before updating

SET @sql= CONCAT('INSERT INTO base_data_deleted2 (base_data_id,
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
report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name)

SELECT
b.base_data_id,
b.data_element_id,
b.data_element_value,
b.health_facility_id,
b.parish_id,
b.sub_county_id,
b.county_id,
b.district_id,
b.financial_year_id,
b.report_period_week,
b.report_period_month,
b.report_period_bi_month,
b.report_period_quarter,
b.report_period_year,
b.report_period_from_date,
b.report_period_to_date,
b.is_deleted,
b.is_active,
b.add_date,
b.add_by,
b.last_edit_date,
b.last_edit_by,
b.batch_id,
b.report_form_id,1,
NOW(),
b.report_form_group_id,b.entry_mode,b.rec_id,
b.district_name,
b.county_name,
b.sub_county_name,
b.parish_name,
b.health_facility_name,
b.section_name,
b.sub_section_name,
b.data_element_name,
b.data_element_context,
b.data_type,
b.data_size,
b.age_category,
b.sex_category,
b.other_category,
b.technical_area_name
FROM
base_data_',in_report_form_id,'_',in_report_form_group_id," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.health_facility_id=b.health_facility_id
			 AND b.report_period_quarter=i.report_period_quarter
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.health_facility_id=i.health_facility_id
	AND i.entry_mode='SMS'
	AND b.report_period_quarter=",in_quarter,
	" AND b.report_period_year=",in_calendar_year
	);
	-- " AND report_period_month=",in_month
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month

prepare stmt from @sql;
execute stmt;
DEALLOCATE PREPARE stmt;
-- End insert


SET @sql2=CONCAT("UPDATE base_data_",in_report_form_id,'_',in_report_form_group_id);
SET @sql21=CONCAT(@sql2," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.health_facility_id=b.health_facility_id
			 AND b.report_period_quarter=i.report_period_quarter
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 SET b.data_element_value = i.data_element_value
WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.health_facility_id=i.health_facility_id
	AND i.entry_mode='SMS'
	AND b.report_period_quarter=",in_quarter,
		" AND b.report_period_year=",in_calendar_year
	);
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month
	-- " AND report_period_month=",in_month
	
PREPARE stmt12 FROM @sql21;
EXECUTE stmt12;
DEALLOCATE PREPARE stmt12;
END IF;

-- Annually
IF in_frequency='Annually' THEN
-- Insert into base_data_deleted2 before updating

SET @sql= CONCAT('INSERT INTO base_data_deleted2 (base_data_id,
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
report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name)

SELECT
b.base_data_id,
b.data_element_id,
b.data_element_value,
b.health_facility_id,
b.parish_id,
b.sub_county_id,
b.county_id,
b.district_id,
b.financial_year_id,
b.report_period_week,
b.report_period_month,
b.report_period_bi_month,
b.report_period_quarter,
b.report_period_year,
b.report_period_from_date,
b.report_period_to_date,
b.is_deleted,
b.is_active,
b.add_date,
b.add_by,
b.last_edit_date,
b.last_edit_by,
b.batch_id,
b.report_form_id,1,
NOW(),
b.report_form_group_id,b.entry_mode,b.rec_id,
b.district_name,
b.county_name,
b.sub_county_name,
b.parish_name,
b.health_facility_name,
b.section_name,
b.sub_section_name,
b.data_element_name,
b.data_element_context,
b.data_type,
b.data_size,
b.age_category,
b.sex_category,
b.other_category,
b.technical_area_name
FROM
base_data_',in_report_form_id,'_',in_report_form_group_id," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.health_facility_id=b.health_facility_id
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.health_facility_id=i.health_facility_id
	AND i.entry_mode='SMS'
	 AND b.report_period_year=",in_calendar_year
	);
	-- " AND report_period_month=",in_month
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month

prepare stmt from @sql;
execute stmt;
DEALLOCATE PREPARE stmt;
-- End insert


SET @sql2=CONCAT("UPDATE base_data_",in_report_form_id,'_',in_report_form_group_id);
SET @sql21=CONCAT(@sql2," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.health_facility_id=b.health_facility_id
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 SET b.data_element_value = i.data_element_value
WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.health_facility_id=i.health_facility_id
	AND i.entry_mode='SMS'
	AND b.report_period_year=",in_calendar_year
	);
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month
	-- " AND report_period_month=",in_month
	
PREPARE stmt12 FROM @sql21;
EXECUTE stmt12;
DEALLOCATE PREPARE stmt12;
END IF;

-- End Update SMS Data

ELSEIF reporting_level='Parish' THEN 
SET @sql11=CONCAT("INSERT INTO base_data_",in_report_form_id,'_',in_report_form_group_id);
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
report_period_year,report_period_bi_month,report_form_id,county_id,report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name) SELECT 
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
id.county_id,id.report_form_group_id,entry_mode,id.rec_id,
id.district_name,
id.county_name,
id.sub_county_name,
id.parish_name,
id.health_facility_name,
se.section_name,
ss.sub_section_name,
de.data_element_name,
de.data_element_context,
de.data_type,
de.data_size,
de.age_category,
de.sex_category,
de.other_category,
ta.technical_area_name
FROM interface_data id INNER JOIN validation_report vr on vr.batch_id=id.batch_id and vr.parish_id=id.parish_id where vr.batch_id=",in_batch_id," AND vr.status_v='Pass'");
SET @sql_text2=CONCAT(@sql11,@sql22);
PREPARE stmt2 FROM @sql_text2;
EXECUTE stmt2;
DEALLOCATE PREPARE stmt2;

-- Update for SMS Data
-- Weekly
IF in_frequency='Weekly' THEN

-- Insert into base_data_deleted2 before updating

SET @sql= CONCAT('INSERT INTO base_data_deleted2 (base_data_id,
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
report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name)

SELECT
b.base_data_id,
b.data_element_id,
b.data_element_value,
b.health_facility_id,
b.parish_id,
b.sub_county_id,
b.county_id,
b.district_id,
b.financial_year_id,
b.report_period_week,
b.report_period_month,
b.report_period_bi_month,
b.report_period_quarter,
b.report_period_year,
b.report_period_from_date,
b.report_period_to_date,
b.is_deleted,
b.is_active,
b.add_date,
b.add_by,
b.last_edit_date,
b.last_edit_by,
b.batch_id,
b.report_form_id,1,
NOW(),
b.report_form_group_id,b.entry_mode,b.rec_id,
b.district_name,
b.county_name,
b.sub_county_name,
b.parish_name,
b.health_facility_name,
b.section_name,
b.sub_section_name,
b.data_element_name,
b.data_element_context,
b.data_type,
b.data_size,
b.age_category,
b.sex_category,
b.other_category,
b.technical_area_name
FROM
base_data_',in_report_form_id," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 			 AND i.parish_id=b.parish_id
			 AND b.report_period_week=i.report_period_week
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.parish_id=i.parish_id
	AND i.entry_mode='SMS'
	AND b.report_period_week=",in_week,
	" AND b.report_period_year=",in_calendar_year
	);
	-- " AND report_period_month=",in_month
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month

prepare stmt from @sql;
execute stmt;
DEALLOCATE PREPARE stmt;
-- End insert


SET @sql2=CONCAT("UPDATE base_data_",in_report_form_id,'_',in_report_form_group_id);
SET @sql21=CONCAT(@sql2," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.parish_id=b.parish_id
			 AND b.report_period_week=i.report_period_week
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 SET b.data_element_value = i.data_element_value,
						 b.batch_id=i.batch_id
WHERE i.batch_id = ",in_batch_id,"  
  AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.parish_id=i.parish_id
	AND i.entry_mode='SMS'
	AND b.report_period_week=",in_week,
	" AND b.report_period_year=",in_calendar_year
	);
	
PREPARE stmt12 FROM @sql21;
EXECUTE stmt12;
DEALLOCATE PREPARE stmt12;
END IF;

-- Monthly
IF in_frequency='Monthly' THEN

-- Insert into base_data_deleted2 before updating

SET @sql= CONCAT('INSERT INTO base_data_deleted2 (base_data_id,
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
report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name)

SELECT
b.base_data_id,
b.data_element_id,
b.data_element_value,
b.health_facility_id,
b.parish_id,
b.sub_county_id,
b.county_id,
b.district_id,
b.financial_year_id,
b.report_period_week,
b.report_period_month,
b.report_period_bi_month,
b.report_period_quarter,
b.report_period_year,
b.report_period_from_date,
b.report_period_to_date,
b.is_deleted,
b.is_active,
b.add_date,
b.add_by,
b.last_edit_date,
b.last_edit_by,
b.batch_id,
b.report_form_id,1,
NOW(),
b.report_form_group_id,b.entry_mode,b.rec_id,
b.district_name,
b.county_name,
b.sub_county_name,
b.parish_name,
b.health_facility_name,
b.section_name,
b.sub_section_name,
b.data_element_name,
b.data_element_context,
b.data_type,
b.data_size,
b.age_category,
b.sex_category,
b.other_category,
b.technical_area_name
FROM
base_data_',in_report_form_id," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 			 AND i.parish_id=b.parish_id
			 AND b.report_period_month=i.report_period_month
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.parish_id=i.parish_id
	AND i.entry_mode='SMS'
	AND b.report_period_month=",in_month,
	" AND b.report_period_year=",in_calendar_year
	);
	-- " AND report_period_month=",in_month
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month

prepare stmt from @sql;
execute stmt;
DEALLOCATE PREPARE stmt;
-- End insert


SET @sql2=CONCAT("UPDATE base_data_",in_report_form_id,'_',in_report_form_group_id);
SET @sql21=CONCAT(@sql2," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.parish_id=b.parish_id
			 AND b.report_period_month=i.report_period_month
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 SET b.data_element_value = i.data_element_value,
						 b.batch_id=i.batch_id
WHERE i.batch_id = ",in_batch_id,"  
  AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.parish_id=i.parish_id
	AND i.entry_mode='SMS'
	AND b.report_period_month=",in_month,
	" AND b.report_period_year=",in_calendar_year
	);
	
PREPARE stmt12 FROM @sql21;
EXECUTE stmt12;
DEALLOCATE PREPARE stmt12;
END IF;

-- Bi-Monthly
IF in_frequency='Bi-Monthly' THEN

-- Insert into base_data_deleted2 before updating

SET @sql= CONCAT('INSERT INTO base_data_deleted2 (base_data_id,
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
report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name)

SELECT
b.base_data_id,
b.data_element_id,
b.data_element_value,
b.health_facility_id,
b.parish_id,
b.sub_county_id,
b.county_id,
b.district_id,
b.financial_year_id,
b.report_period_week,
b.report_period_month,
b.report_period_bi_month,
b.report_period_quarter,
b.report_period_year,
b.report_period_from_date,
b.report_period_to_date,
b.is_deleted,
b.is_active,
b.add_date,
b.add_by,
b.last_edit_date,
b.last_edit_by,
b.batch_id,
b.report_form_id,1,
NOW(),
b.report_form_group_id,b.entry_mode,b.rec_id,
b.district_name,
b.county_name,
b.sub_county_name,
b.parish_name,
b.health_facility_name,
b.section_name,
b.sub_section_name,
b.data_element_name,
b.data_element_context,
b.data_type,
b.data_size,
b.age_category,
b.sex_category,
b.other_category,
b.technical_area_name
FROM
base_data_',in_report_form_id," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 			 AND i.parish_id=b.parish_id
			 AND b.report_period_bi_month=i.report_period_bi_month
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.parish_id=i.parish_id
	AND i.entry_mode='SMS'
	AND b.report_period_bi_month=",in_bi_month,
	" AND b.report_period_year=",in_calendar_year
	);
	-- " AND report_period_month=",in_month
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month

prepare stmt from @sql;
execute stmt;
DEALLOCATE PREPARE stmt;
-- End insert


SET @sql2=CONCAT("UPDATE base_data_",in_report_form_id,'_',in_report_form_group_id);
SET @sql21=CONCAT(@sql2," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.parish_id=b.parish_id
			 AND b.report_period_bi_month=i.report_period_bi_month
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 SET b.data_element_value = i.data_element_value,
						 b.batch_id=i.batch_id
WHERE i.batch_id = ",in_batch_id,"  
  AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.parish_id=i.parish_id
	AND i.entry_mode='SMS'
	AND b.report_period_bi_month=",in_bi_month,
	" AND b.report_period_year=",in_calendar_year
	);
	
PREPARE stmt12 FROM @sql21;
EXECUTE stmt12;
DEALLOCATE PREPARE stmt12;
END IF;

-- Quarterly
IF in_frequency='Quarterly' THEN

-- Insert into base_data_deleted2 before updating

SET @sql= CONCAT('INSERT INTO base_data_deleted2 (base_data_id,
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
report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name)

SELECT
b.base_data_id,
b.data_element_id,
b.data_element_value,
b.health_facility_id,
b.parish_id,
b.sub_county_id,
b.county_id,
b.district_id,
b.financial_year_id,
b.report_period_week,
b.report_period_month,
b.report_period_bi_month,
b.report_period_quarter,
b.report_period_year,
b.report_period_from_date,
b.report_period_to_date,
b.is_deleted,
b.is_active,
b.add_date,
b.add_by,
b.last_edit_date,
b.last_edit_by,
b.batch_id,
b.report_form_id,1,
NOW(),
b.report_form_group_id,b.entry_mode,b.rec_id,
b.district_name,
b.county_name,
b.sub_county_name,
b.parish_name,
b.health_facility_name,
b.section_name,
b.sub_section_name,
b.data_element_name,
b.data_element_context,
b.data_type,
b.data_size,
b.age_category,
b.sex_category,
b.other_category,
b.technical_area_name
FROM
base_data_',in_report_form_id," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 			 AND i.parish_id=b.parish_id
			 AND b.report_period_quarter=i.report_period_quarter
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.parish_id=i.parish_id
	AND i.entry_mode='SMS'
	AND b.report_period_quarter=",in_quarter,
	" AND b.report_period_year=",in_calendar_year
	);
	-- " AND report_period_month=",in_month
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month

prepare stmt from @sql;
execute stmt;
DEALLOCATE PREPARE stmt;
-- End insert


SET @sql2=CONCAT("UPDATE base_data_",in_report_form_id,'_',in_report_form_group_id);
SET @sql21=CONCAT(@sql2," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.parish_id=b.parish_id
			 AND b.report_period_quarter=i.report_period_quarter
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 SET b.data_element_value = i.data_element_value,
						 b.batch_id=i.batch_id
WHERE i.batch_id = ",in_batch_id,"  
  AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.parish_id=i.parish_id
	AND i.entry_mode='SMS'
	AND b.report_period_quarter=",in_quarter,
	" AND b.report_period_year=",in_calendar_year
	);
	
PREPARE stmt12 FROM @sql21;
EXECUTE stmt12;
DEALLOCATE PREPARE stmt12;
END IF;

-- Annually
IF in_frequency='Annually' THEN

-- Insert into base_data_deleted2 before updating

SET @sql= CONCAT('INSERT INTO base_data_deleted2 (base_data_id,
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
report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name)

SELECT
b.base_data_id,
b.data_element_id,
b.data_element_value,
b.health_facility_id,
b.parish_id,
b.sub_county_id,
b.county_id,
b.district_id,
b.financial_year_id,
b.report_period_week,
b.report_period_month,
b.report_period_bi_month,
b.report_period_quarter,
b.report_period_year,
b.report_period_from_date,
b.report_period_to_date,
b.is_deleted,
b.is_active,
b.add_date,
b.add_by,
b.last_edit_date,
b.last_edit_by,
b.batch_id,
b.report_form_id,1,
NOW(),
b.report_form_group_id,b.entry_mode,b.rec_id,
b.district_name,
b.county_name,
b.sub_county_name,
b.parish_name,
b.health_facility_name,
b.section_name,
b.sub_section_name,
b.data_element_name,
b.data_element_context,
b.data_type,
b.data_size,
b.age_category,
b.sex_category,
b.other_category,
b.technical_area_name
FROM
base_data_',in_report_form_id," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 			 AND i.parish_id=b.parish_id
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.parish_id=i.parish_id
	AND i.entry_mode='SMS'
	 AND b.report_period_year=",in_calendar_year
	);
	-- " AND report_period_month=",in_month
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month

prepare stmt from @sql;
execute stmt;
DEALLOCATE PREPARE stmt;
-- End insert


SET @sql2=CONCAT("UPDATE base_data_",in_report_form_id,'_',in_report_form_group_id);
SET @sql21=CONCAT(@sql2," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.parish_id=b.parish_id
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 SET b.data_element_value = i.data_element_value,
						 b.batch_id=i.batch_id
WHERE i.batch_id = ",in_batch_id,"  
  AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.parish_id=i.parish_id
	AND i.entry_mode='SMS'
	 AND b.report_period_year=",in_calendar_year
	);
	
PREPARE stmt12 FROM @sql21;
EXECUTE stmt12;
DEALLOCATE PREPARE stmt12;
END IF;

-- End Update SMS Data

ELSEIF reporting_level='District' THEN 
SET @sql111=CONCAT("INSERT INTO base_data_",in_report_form_id,'_',in_report_form_group_id);
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
report_period_year,report_period_bi_month,report_form_id,county_id,report_form_group_id,entry_mode,rec_id) SELECT 
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
id.county_id,id.report_form_group_id,entry_mode,id.rec_id,
id.district_name,
id.county_name,
id.sub_county_name,
id.parish_name,
id.health_facility_name,
se.section_name,
ss.sub_section_name,
de.data_element_name,
de.data_element_context,
de.data_type,
de.data_size,
de.age_category,
de.sex_category,
de.other_category,
ta.technical_area_name
FROM interface_data id INNER JOIN validation_report vr on vr.batch_id=id.batch_id and vr.district_id=id.district_id where vr.batch_id=",in_batch_id," AND vr.status_v='Pass'");
SET @sql_text3=CONCAT(@sql111,@sql222);
PREPARE stmt3 FROM @sql_text3;
EXECUTE stmt3;
DEALLOCATE PREPARE stmt3;

-- Update for SMS Data
-- Weekly
IF in_frequency='Weekly' THEN
-- Insert into base_data_deleted2 before updating

SET @sql= CONCAT('INSERT INTO base_data_deleted2 (base_data_id,
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
report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name)

SELECT
b.base_data_id,
b.data_element_id,
b.data_element_value,
b.health_facility_id,
b.parish_id,
b.sub_county_id,
b.county_id,
b.district_id,
b.financial_year_id,
b.report_period_week,
b.report_period_month,
b.report_period_bi_month,
b.report_period_quarter,
b.report_period_year,
b.report_period_from_date,
b.report_period_to_date,
b.is_deleted,
b.is_active,
b.add_date,
b.add_by,
b.last_edit_date,
b.last_edit_by,
b.batch_id,
b.report_form_id,1,
NOW(),
b.report_form_group_id,b.entry_mode,b.rec_id,
b.district_name,
b.county_name,
b.sub_county_name,
b.parish_name,
b.health_facility_name,
b.section_name,
b.sub_section_name,
b.data_element_name,
b.data_element_context,
b.data_type,
b.data_size,
b.age_category,
b.sex_category,
b.other_category,
b.technical_area_name
FROM
base_data_',in_report_form_id," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 			 AND i.district_id=b.district_id
			 AND b.report_period_week=i.report_period_week
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.district_id=i.district_id
	AND i.entry_mode='SMS'
	AND b.report_period_week=",in_week,
	" AND b.report_period_year=",in_calendar_year
	);
	-- " AND report_period_month=",in_month
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month

prepare stmt from @sql;
execute stmt;
DEALLOCATE PREPARE stmt;
-- End insert

SET @sql2=CONCAT("UPDATE base_data_",in_report_form_id,'_',in_report_form_group_id);
SET @sql21=CONCAT(@sql2," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.district_id=b.district_id
			 AND b.report_period_week=i.report_period_week
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 SET b.data_element_value = i.data_element_value,
						 b.batch_id=i.batch_id
WHERE i.batch_id = ",in_batch_id,"  
  AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.district_id=i.district_id
	AND i.entry_mode='SMS'
	AND b.report_period_week=",in_week,
	" AND b.report_period_year=",in_calendar_year
);
	
PREPARE stmt12 FROM @sql21;
EXECUTE stmt12;
DEALLOCATE PREPARE stmt12;
END IF;

-- Monthly
IF in_frequency='Monthly' THEN
-- Insert into base_data_deleted2 before updating

SET @sql= CONCAT('INSERT INTO base_data_deleted2 (base_data_id,
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
report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name)

SELECT
b.base_data_id,
b.data_element_id,
b.data_element_value,
b.health_facility_id,
b.parish_id,
b.sub_county_id,
b.county_id,
b.district_id,
b.financial_year_id,
b.report_period_week,
b.report_period_month,
b.report_period_bi_month,
b.report_period_quarter,
b.report_period_year,
b.report_period_from_date,
b.report_period_to_date,
b.is_deleted,
b.is_active,
b.add_date,
b.add_by,
b.last_edit_date,
b.last_edit_by,
b.batch_id,
b.report_form_id,1,
NOW(),
b.report_form_group_id,b.entry_mode,b.rec_id,
b.district_name,
b.county_name,
b.sub_county_name,
b.parish_name,
b.health_facility_name,
b.section_name,
b.sub_section_name,
b.data_element_name,
b.data_element_context,
b.data_type,
b.data_size,
b.age_category,
b.sex_category,
b.other_category,
b.technical_area_name
FROM
base_data_',in_report_form_id," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 			 AND i.district_id=b.district_id
			 AND b.report_period_month=i.report_period_month
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.district_id=i.district_id
	AND i.entry_mode='SMS'
	AND b.report_period_month=",in_month,
	" AND b.report_period_year=",in_calendar_year
	);
	-- " AND report_period_month=",in_month
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month

prepare stmt from @sql;
execute stmt;
DEALLOCATE PREPARE stmt;
-- End insert

SET @sql2=CONCAT("UPDATE base_data_",in_report_form_id,'_',in_report_form_group_id);
SET @sql21=CONCAT(@sql2," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.district_id=b.district_id
			 AND b.report_period_month=i.report_period_month
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 SET b.data_element_value = i.data_element_value,
						 b.batch_id=i.batch_id
WHERE i.batch_id = ",in_batch_id,"  
  AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.district_id=i.district_id
	AND i.entry_mode='SMS'
	AND b.report_period_month=",in_month,
	" AND b.report_period_year=",in_calendar_year
);
	
PREPARE stmt12 FROM @sql21;
EXECUTE stmt12;
DEALLOCATE PREPARE stmt12;
END IF;

-- Bi-Monthly
IF in_frequency='Bi-Monthly' THEN
-- Insert into base_data_deleted2 before updating

SET @sql= CONCAT('INSERT INTO base_data_deleted2 (base_data_id,
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
report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name)

SELECT
b.base_data_id,
b.data_element_id,
b.data_element_value,
b.health_facility_id,
b.parish_id,
b.sub_county_id,
b.county_id,
b.district_id,
b.financial_year_id,
b.report_period_week,
b.report_period_month,
b.report_period_bi_month,
b.report_period_quarter,
b.report_period_year,
b.report_period_from_date,
b.report_period_to_date,
b.is_deleted,
b.is_active,
b.add_date,
b.add_by,
b.last_edit_date,
b.last_edit_by,
b.batch_id,
b.report_form_id,1,
NOW(),
b.report_form_group_id,b.entry_mode,b.rec_id,
b.district_name,
b.county_name,
b.sub_county_name,
b.parish_name,
b.health_facility_name,
b.section_name,
b.sub_section_name,
b.data_element_name,
b.data_element_context,
b.data_type,
b.data_size,
b.age_category,
b.sex_category,
b.other_category,
b.technical_area_name
FROM
base_data_',in_report_form_id," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 			 AND i.district_id=b.district_id
			 AND b.report_period_bi_month=i.report_period_bi_month
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.district_id=i.district_id
	AND i.entry_mode='SMS'
	AND b.report_period_bi_month=",in_bi_month,
	" AND b.report_period_year=",in_calendar_year
	);
	-- " AND report_period_month=",in_month
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month

prepare stmt from @sql;
execute stmt;
DEALLOCATE PREPARE stmt;
-- End insert

SET @sql2=CONCAT("UPDATE base_data_",in_report_form_id,'_',in_report_form_group_id);
SET @sql21=CONCAT(@sql2," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.district_id=b.district_id
			 AND b.report_period_bi_month=i.report_period_bi_month
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 SET b.data_element_value = i.data_element_value,
						 b.batch_id=i.batch_id
WHERE i.batch_id = ",in_batch_id,"  
  AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.district_id=i.district_id
	AND i.entry_mode='SMS'
	AND b.report_period_bi_month=",in_bi_month,
	" AND b.report_period_year=",in_calendar_year
);
	
PREPARE stmt12 FROM @sql21;
EXECUTE stmt12;
DEALLOCATE PREPARE stmt12;
END IF;

-- Quarterly
IF in_frequency='Quarterly' THEN
-- Insert into base_data_deleted2 before updating

SET @sql= CONCAT('INSERT INTO base_data_deleted2 (base_data_id,
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
report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name)

SELECT
b.base_data_id,
b.data_element_id,
b.data_element_value,
b.health_facility_id,
b.parish_id,
b.sub_county_id,
b.county_id,
b.district_id,
b.financial_year_id,
b.report_period_week,
b.report_period_month,
b.report_period_bi_month,
b.report_period_quarter,
b.report_period_year,
b.report_period_from_date,
b.report_period_to_date,
b.is_deleted,
b.is_active,
b.add_date,
b.add_by,
b.last_edit_date,
b.last_edit_by,
b.batch_id,
b.report_form_id,1,
NOW(),
b.report_form_group_id,b.entry_mode,b.rec_id,
b.district_name,
b.county_name,
b.sub_county_name,
b.parish_name,
b.health_facility_name,
b.section_name,
b.sub_section_name,
b.data_element_name,
b.data_element_context,
b.data_type,
b.data_size,
b.age_category,
b.sex_category,
b.other_category,
b.technical_area_name
FROM
base_data_',in_report_form_id," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 			 AND i.district_id=b.district_id
			 AND b.report_period_quarter=i.report_period_quarter
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.district_id=i.district_id
	AND i.entry_mode='SMS'
	AND b.report_period_quarter=",in_quarter,
	" AND b.report_period_year=",in_calendar_year
	);
	-- " AND report_period_month=",in_month
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month

prepare stmt from @sql;
execute stmt;
DEALLOCATE PREPARE stmt;
-- End insert

SET @sql2=CONCAT("UPDATE base_data_",in_report_form_id,'_',in_report_form_group_id);
SET @sql21=CONCAT(@sql2," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.district_id=b.district_id
			 AND b.report_period_quarter=i.report_period_quarter
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 SET b.data_element_value = i.data_element_value,
						 b.batch_id=i.batch_id
WHERE i.batch_id = ",in_batch_id,"  
  AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.district_id=i.district_id
	AND i.entry_mode='SMS'
	AND b.report_period_quarter=",in_quarter,
	" AND b.report_period_year=",in_calendar_year
);
	
PREPARE stmt12 FROM @sql21;
EXECUTE stmt12;
DEALLOCATE PREPARE stmt12;
END IF;

-- Annually

IF in_frequency='Annually' THEN
-- Insert into base_data_deleted2 before updating

SET @sql= CONCAT('INSERT INTO base_data_deleted2 (base_data_id,
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
report_form_group_id,entry_mode,rec_id,
district_name,
county_name,
sub_county_name,
parish_name,
health_facility_name,
section_name,
sub_section_name,
data_element_name,
data_element_context,
data_type,
data_size,
age_category,
sex_category,
other_category,
technical_area_name)

SELECT
b.base_data_id,
b.data_element_id,
b.data_element_value,
b.health_facility_id,
b.parish_id,
b.sub_county_id,
b.county_id,
b.district_id,
b.financial_year_id,
b.report_period_week,
b.report_period_month,
b.report_period_bi_month,
b.report_period_quarter,
b.report_period_year,
b.report_period_from_date,
b.report_period_to_date,
b.is_deleted,
b.is_active,
b.add_date,
b.add_by,
b.last_edit_date,
b.last_edit_by,
b.batch_id,
b.report_form_id,1,
NOW(),
b.report_form_group_id,b.entry_mode,b.rec_id,
b.district_name,
b.county_name,
b.sub_county_name,
b.parish_name,
b.health_facility_name,
b.section_name,
b.sub_section_name,
b.data_element_name,
b.data_element_context,
b.data_type,
b.data_size,
b.age_category,
b.sex_category,
b.other_category,
b.technical_area_name
FROM
base_data_',in_report_form_id," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 			 AND i.district_id=b.district_id
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 WHERE i.batch_id = ",in_batch_id," AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.district_id=i.district_id
	AND i.entry_mode='SMS'
	 AND b.report_period_year=",in_calendar_year
	);
	-- " AND report_period_month=",in_month
		-- " AND report_eriod_quarter=",in_quarter
	-- " AND report_period_bi_month=",in_bi_month

prepare stmt from @sql;
execute stmt;
DEALLOCATE PREPARE stmt;
-- End insert

SET @sql2=CONCAT("UPDATE base_data_",in_report_form_id,'_',in_report_form_group_id);
SET @sql21=CONCAT(@sql2," AS b
INNER JOIN interface_data AS i 
       ON i.data_element_id = b.data_element_id 
			 AND i.district_id=b.district_id
			 AND b.report_period_year=i.report_period_year
			 INNER JOIN validation_report vr on vr.batch_id=i.batch_id
			 			 SET b.data_element_value = i.data_element_value,
						 b.batch_id=i.batch_id
WHERE i.batch_id = ",in_batch_id,"  
  AND vr.status_v_desc like '%Passed Validation Rules%'
	AND vr.status_v_desc like '%Data for the same period%'
	AND b.data_element_id=i.data_element_id
	AND vr.district_id=i.district_id
	AND i.entry_mode='SMS'
	 AND b.report_period_year=",in_calendar_year
);
	
PREPARE stmt12 FROM @sql21;
EXECUTE stmt12;
DEALLOCATE PREPARE stmt12;
END IF;

-- End Update SMS Data
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


-- Add SURGE 

SELECT * FROM report_form where report_form_id=in_report_form_id AND report_form_code='SURGE';
IF FOUND_ROWS()>0 THEN
DELETE FROM dashboard_surge WHERE dashboard_surge_id>0 AND report_period_week=in_week AND report_period_year=in_calendar_year AND health_facility_id=(select distinct health_facility_id from validation_report where batch_id=in_batch_id) and report_form_id=in_report_form_group_id;
CALL sp_insert_dashboard_surge(in_batch_id);
END IF;

-- End Add SURGE

-- Delete from interface_data
-- DELETE from interface_data WHERE batch_id=in_batch_id;
CALL sp_delete_from_interface_data_by_batch_id(in_batch_id);
-- Delete from interface_data

END //
DELIMITER ;
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

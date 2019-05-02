CREATE VIEW view_facility_targets_annually AS 
select bd.health_facility_id,bd.report_period_year,
GROUP_CONCAT(DISTINCT if(de.data_element_code ='5', CEILING(bd.data_element_value/52), NULL)) AS 'targ_htc_tst_pos', 
GROUP_CONCAT(DISTINCT if(de.data_element_code = '7', CEILING(bd.data_element_value/52), NULL)) AS 'targ_tx_new'  
from base_data_X bd 
inner join data_element de on bd.report_form_id=de.report_form_id and bd.report_form_group_id=de.report_form_group_id and bd.data_element_id=de.data_element_id 
GROUP BY bd.health_facility_id,bd.report_period_year;


create table art_retention_pivot (art_retention_pivot_id int(11) not null auto_increment, 
batch_id int(11), district_id int(11), district_name varchar(100), health_facility_id int(11), health_facility_name varchar(100), 
y int(11), m int(11), m0 int(11), m1 int(11), m2 int(11), m3 int(11), m4 int(11), m5 int(11), 
primary key (art_retention_pivot_id));

DROP PROCEDURE IF EXISTS `sp_select_raw_art_retention`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_select_raw_art_retention`(
	IN in_batch_id int(11)
)
BEGIN 
	SELECT * FROM base_data_67 WHERE batch_id=in_batch_id order by base_data_id ASC;
END
;;
DELIMITER ;


-- DELETE DATA MAY NOT BE WORKING AS THERE IS NO GROUP ID; add delete for retetion also!
CREATE VIEW view_facility_targets_annually AS 
select bd.health_facility_id,bd.report_period_year,
GROUP_CONCAT(DISTINCT if(de.data_element_code ='5', CEILING(bd.data_element_value/52), NULL)) AS 'targ_htc_tst_pos', 
GROUP_CONCAT(DISTINCT if(de.data_element_code = '7', CEILING(bd.data_element_value/52), NULL)) AS 'targ_tx_new'  
from base_data_65 bd 
inner join data_element de on bd.report_form_id=de.report_form_id and bd.report_form_group_id=de.report_form_group_id and bd.data_element_id=de.data_element_id 
GROUP BY bd.health_facility_id,bd.report_period_year;




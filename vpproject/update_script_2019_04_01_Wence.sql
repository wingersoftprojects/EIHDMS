CREATE VIEW view_facility_targets_annually AS 
select bd.health_facility_id,bd.report_period_year,
GROUP_CONCAT(DISTINCT if(de.data_element_code ='5', CEILING(bd.data_element_value/52), NULL)) AS 'targ_htc_tst_pos', 
GROUP_CONCAT(DISTINCT if(de.data_element_code = '7', CEILING(bd.data_element_value/52), NULL)) AS 'targ_tx_new'  
from base_data_65 bd 
inner join data_element de on bd.report_form_id=de.report_form_id and bd.report_form_group_id=de.report_form_group_id and bd.data_element_id=de.data_element_id 
GROUP BY bd.health_facility_id,bd.report_period_year;

SELECT sum(a) as a,sum(b) as b,sum(b_prev) as b_prev,sum(c) as c,sum(d) as d,sum(e) as e,sum(f) as f,sum(g) as g,sum(h) as h,sum(i) as i,sum(j) as j,sum(k) as k,sum(l) as l,
avg(perc_test_coverage) as perc_test_coverage,avg(perc_miss_appoint_cur) as perc_miss_appoint_cur,avg(perc_miss_appoint_prev) as perc_miss_appoint_prev,
avg(perc_hts_yield) as perc_hts_yield,avg(perc_start_art) as perc_start_art,
sum(vt.targ_htc_tst_pos) as targ_htc_tst_pos,sum(vt.targ_tx_new) as targ_tx_new 
FROM dashboard_surge ds left join view_facility_targets_annually vt on ds.report_period_year=vt.report_period_year and ds.health_facility_id=vt.health_facility_id 
WHERE 1=1;




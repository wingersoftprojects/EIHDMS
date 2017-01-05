
-- delete
delete from loaded_data_summary where loaded_data_summary_id>0;

-- insert
insert into loaded_data_summary
(
report_period_month,report_period_week,report_period_year,report_period_quarter,report_period_bi_month,report_form_group_id,report_form_id,batch_id
) select distinct 
report_period_month,report_period_week,report_period_year,report_period_quarter,report_period_bi_month,report_form_group_id,report_form_id,batch_id 
from validation_report;

-- update all
update loaded_data_summary l 
set l.loaded_entities=(select count(*) from validation_report v where v.batch_id=l.batch_id and v.status_m='Pass') 
where loaded_data_summary_id>0;
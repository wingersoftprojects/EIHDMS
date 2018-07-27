alter table report_form add column is_patient_level int(1);
alter table base_data_46 add column rec_id varchar(100);
alter table interface_data add column rec_id varchar(100);
alter table base_data_deleted add column rec_id varchar(100);
alter table data_element add column is_patient_level_record_id int(1);
alter table validation_report add column rec_id varchar(100);
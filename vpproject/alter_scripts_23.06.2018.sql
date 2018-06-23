update data_element AS d set d.data_element_code=(d.data_element_id-get_minimum_data_element_id(d.report_form_id)+1) where (d.data_element_code is null or d.data_element_code='');

alter table report_form_group add column def_name varchar(100);
alter table data_element add constraint Report_Form_Group_Data_Element_Code unique (report_form_group_id, data_element_code);

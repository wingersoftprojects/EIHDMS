alter table report_form_group add column def_name varchar(100);
alter table data_element add constraint Report_Form_Group_Data_Element_Code unique (report_form_group_id, data_element_code);

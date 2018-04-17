alter table report_form_short_code drop column seperators;

alter table report_form_short_code add column number_of_separators int(2);
alter table report_form_short_code modify column add_date datetime;
alter table report_form_short_code modify column last_edit_date datetime;

alter table data_element_sms_position modify column code_position int(2) NULL;



alter table access_scope modify column add_date datetime not null;
alter table access_scope modify column add_by int(10) not null;
alter table access_scope modify column last_edit_date datetime;
alter table data_element modify column data_element_name varchar(255);
alter table data_element modify column data_element_context varchar(255);
alter table data_element modify column description varchar(255);
alter table data_element modify column add_date datetime;
alter table data_element modify column last_edit_date datetime;
alter table data_element_sms_position modify column data_element_sms_position_id int(11) not null;
alter table data_element_sms_position modify column add_date datetime not null;
alter table data_element_sms_position modify column add_by int(10) not null;
alter table data_element_sms_position modify column last_edit_date datetime;
alter table interface_data_sms modify column add_date datetime not null;
alter table interface_data_sms modify column add_by int(10) not null;
alter table interface_data_sms modify column last_edit_date datetime;
alter table organisation modify column add_date datetime not null;
alter table organisation modify column add_by int(10) not null;
alter table organisation modify column last_edit_date datetime;
alter table phone_contact modify column add_date datetime not null;
alter table phone_contact modify column add_by int(10) not null;
alter table phone_contact modify column last_edit_date datetime;
alter table report_form modify column add_date datetime;
alter table report_form modify column last_edit_date datetime;
alter table report_form_short_code modify column add_date datetime not null;
alter table report_form_short_code modify column add_by int(10) not null;
alter table report_form_short_code modify column last_edit_date datetime;
alter table user_detail modify column add_date datetime;
alter table user_detail modify column last_edit_date datetime;
alter table user_detail comment = 'Stores user details such as username, password, type, status, etc';

alter table report_form_short_code drop column number_of_separators;
alter table report_form_short_code add column number_of_separators int(2) not null;


alter table access_scope modify column add_date datetime not null;
alter table access_scope modify column last_edit_date datetime;
alter table data_element modify column data_element_name varchar(255);
alter table data_element modify column data_element_context varchar(255);
alter table data_element modify column description varchar(255);
alter table data_element modify column add_date datetime;
alter table data_element modify column last_edit_date datetime;
alter table data_element_sms_position drop primary key;
alter table data_element_sms_position modify column add_date datetime not null;
alter table data_element_sms_position modify column last_edit_date datetime;
alter table data_element_sms_position add primary key(data_element_sms_position_id);
alter table data_element_sms_position modify column data_element_sms_position_id int(11) not null auto_increment;
alter table interface_data_sms modify column add_date datetime not null;
alter table interface_data_sms modify column last_edit_date datetime;
alter table organisation modify column add_date datetime not null;
alter table organisation modify column last_edit_date datetime;
alter table phone_contact modify column add_date datetime not null;
alter table phone_contact modify column last_edit_date datetime;
alter table report_form modify column add_date datetime;
alter table report_form modify column last_edit_date datetime;
alter table report_form_short_code modify column add_date datetime not null;
alter table report_form_short_code modify column last_edit_date datetime;
alter table user_detail modify column add_date datetime;
alter table user_detail modify column last_edit_date datetime;
alter table user_detail comment = 'Stores user details such as username, password, type, status, etc';


alter table data_element_sms_position add constraint desp_data_element unique (data_element_id);


alter table report_form modify column add_date datetime;
alter table report_form modify column last_edit_date datetime;
alter table report_form_short_code modify column add_date datetime not null;
alter table report_form_short_code modify column last_edit_date datetime;
alter table report_form_short_code add column report_form_id int(11);
alter table report_form_short_code add index FKreport_for711820 (report_form_id), add constraint FKreport_for711820 foreign key (report_form_id) references report_form (report_form_id);
create table report_form_update (report_form_update_id int(11) not null auto_increment, report_form_id int(11) not null, last_edit_date datetime not null, primary key (report_form_update_id)) ENGINE=InnoDB;

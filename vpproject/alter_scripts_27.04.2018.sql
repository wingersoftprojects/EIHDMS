alter table access_scope modify column add_date datetime not null;
alter table access_scope modify column last_edit_date datetime;
alter table county modify column add_date datetime;
alter table county modify column last_edit_date datetime;
alter table data_element modify column data_element_name varchar(255);
alter table data_element modify column data_element_context varchar(255);
alter table data_element modify column description varchar(255);
alter table data_element modify column add_date datetime;
alter table data_element modify column last_edit_date datetime;
alter table data_element_sms_position modify column add_date datetime not null;
alter table data_element_sms_position modify column last_edit_date datetime;
create table deadline_extension (deadline_extension_id int(11) not null auto_increment, report_form_deadline_id int(11) not null, extended_to_date datetime not null, primary key (deadline_extension_id)) ENGINE=InnoDB;
alter table district modify column add_date datetime;
alter table district modify column last_edit_date datetime;
alter table health_facility modify column add_date datetime;
alter table health_facility modify column last_edit_date datetime;
alter table interface_data_sms modify column add_date datetime not null;
alter table interface_data_sms modify column last_edit_date datetime;
alter table interface_data_sms add column status_f varchar(50);
alter table interface_data_sms add column status_f_desc text;
alter table interface_data_sms add column status_v varchar(50);
alter table interface_data_sms add column status_v_desc text;
alter table interface_data_sms add column status_m varchar(50);
alter table interface_data_sms add column status_m_desc text;
alter table organisation modify column add_date datetime not null;
alter table organisation modify column last_edit_date datetime;
alter table parish modify column add_date datetime;
alter table parish modify column last_edit_date datetime;
alter table phone_contact modify column add_date datetime not null;
alter table phone_contact modify column last_edit_date datetime;
alter table region modify column add_date datetime;
alter table region modify column last_edit_date datetime;
alter table report_form modify column add_date datetime;
alter table report_form modify column last_edit_date datetime;
create table report_form_deadline (report_form_deadline_id int(11) not null auto_increment, report_form_id int(11), day_from int(2), day_to int(2), time_from time, time_to time, week_value varchar(50), month_value varchar(50), quarter_value varchar(50), primary key (report_form_deadline_id)) ENGINE=InnoDB;
create table report_form_entity (report_form_entity_id int(11) not null auto_increment, report_form_id int(11) not null, entity_type varchar(20) not null, entity_id int(11) not null, primary key (report_form_entity_id)) ENGINE=InnoDB;
alter table report_form_short_code modify column add_date datetime not null;
alter table report_form_short_code modify column last_edit_date datetime;
alter table report_form_update modify column last_edit_date datetime not null;
create table sent_sms_log (sent_sms_log_id int(11) not null auto_increment, sent_date datetime not null, phone varchar(100), sms varchar(255), scode varchar(11), status_code varchar(100), status_desc varchar(250), primary key (sent_sms_log_id)) ENGINE=InnoDB;
create table sms_recipient (sms_recipient_id int(11) not null auto_increment, sms_schedule_id int(11), phone varchar(100), primary key (sms_recipient_id)) ENGINE=InnoDB;
create table sms_schedule (sms_schedule_id int(11) not null auto_increment, send_date datetime null, sms varchar(255), status_code varchar(100), status_desc varchar(250), schedule_by varchar(100), primary key (sms_schedule_id)) ENGINE=InnoDB;
alter table sub_county modify column add_date datetime;
alter table sub_county modify column last_edit_date datetime;
alter table user_detail modify column add_date datetime;
alter table user_detail modify column last_edit_date datetime;
alter table user_detail comment = 'Stores user details such as username, password, type, status, etc';
alter table user_detail modify column add_date datetime;
alter table user_detail modify column last_edit_date datetime;
alter table user_detail comment = 'Stores user details such as username, password, type, status, etc';
alter table deadline_extension add constraint FKdeadline_e392986 foreign key (report_form_deadline_id) references report_form_deadline (report_form_deadline_id);
alter table report_form_entity add constraint FKreport_for256822 foreign key (report_form_id) references report_form (report_form_id);
alter table report_form_deadline add constraint FKreport_for555710 foreign key (report_form_id) references report_form (report_form_id);

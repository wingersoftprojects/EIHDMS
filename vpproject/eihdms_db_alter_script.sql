/*
sms_tables_scripts
*/
create table access_scope (access_scope_id int(11) not null auto_increment, user_detail_id int(11), region_id int(11), district_id int(11), parish_id int(11), health_facility_id int(11), primary key (access_scope_id)) ENGINE=InnoDB;
alter table data_element modify column data_element_name varchar(255);
alter table data_element modify column data_element_context varchar(255);
alter table data_element modify column description varchar(255);
alter table data_element modify column add_date datetime;
alter table data_element modify column last_edit_date datetime;
create table data_element_sms_position (data_element_sms_position_id int(11) not null auto_increment, data_element_id int(11) not null, value_position int(2) not null, code_position int(2) not null, report_form_short_code_id int(11), primary key (data_element_sms_position_id)) ENGINE=InnoDB;
create table interface_data_sms (interface_data_sms_id int(11) not null auto_increment, add_date datetime not null, phone varchar(100) not null, sms varchar(255), scode varchar(11), status_code varchar(100), status_desc varchar(250), report_form_code varchar(100), primary key (interface_data_sms_id)) ENGINE=InnoDB;
create table organisation (organisation_id int(11) not null auto_increment, organisation_name varchar(100) not null, is_active int(1) not null, primary key (organisation_id)) ENGINE=InnoDB;
create table phone_contact (phone_contact_id int(11) not null auto_increment, entity_type varchar(20) not null, entity_id int(11) not null, entity_phone varchar(100) not null, primary key (phone_contact_id)) ENGINE=InnoDB;
alter table report_form modify column add_date datetime;
alter table report_form modify column last_edit_date datetime;
create table report_form_short_code (report_form_short_code_id int(11) not null auto_increment, start_code varchar(50) not null, seperators int(2), short_code varchar(255) not null, primary key (report_form_short_code_id)) ENGINE=InnoDB;
alter table user_detail modify column add_date datetime;
alter table user_detail modify column last_edit_date datetime;
alter table user_detail add column organisation_id int(11);
alter table user_detail comment = 'Stores user details such as username, password, type, status, etc';
alter table user_detail add index FKuser_detai192219 (organisation_id), add constraint FKuser_detai192219 foreign key (organisation_id) references organisation (organisation_id);
alter table data_element_sms_position add index FKdata_eleme360408 (data_element_id), add constraint FKdata_eleme360408 foreign key (data_element_id) references data_element (data_element_id);
alter table data_element_sms_position add index FKdata_eleme644022 (report_form_short_code_id), add constraint FKdata_eleme644022 foreign key (report_form_short_code_id) references report_form_short_code (report_form_short_code_id);
alter table access_scope add column is_deleted int(1) not null;
alter table access_scope add column is_active int(1) not null;
alter table access_scope add column add_date datetime;
alter table access_scope add column add_by int(10);
alter table access_scope add column last_edit_date datetime;
alter table access_scope add column last_edit_by int(10);
alter table data_element modify column data_element_name varchar(255);
alter table data_element modify column data_element_context varchar(255);
alter table data_element modify column description varchar(255);
alter table data_element modify column add_date datetime;
alter table data_element modify column last_edit_date datetime;
alter table data_element_sms_position add column is_deleted int(1) not null;
alter table data_element_sms_position add column is_active int(1) not null;
alter table data_element_sms_position add column add_date datetime;
alter table data_element_sms_position add column add_by int(10);
alter table data_element_sms_position add column last_edit_date datetime;
alter table data_element_sms_position add column last_edit_by int(10);
alter table interface_data_sms modify column add_date datetime not null;
alter table interface_data_sms add column is_deleted int(1) not null;
alter table interface_data_sms add column is_active int(1) not null;
alter table interface_data_sms add column add_by int(10);
alter table interface_data_sms add column last_edit_date datetime;
alter table interface_data_sms add column last_edit_by int(10);
alter table organisation add column is_deleted int(1) not null;
alter table organisation add column add_date datetime;
alter table organisation add column add_by int(10);
alter table organisation add column last_edit_date datetime;
alter table organisation add column last_edit_by int(10);
alter table phone_contact add column is_deleted int(1) not null;
alter table phone_contact add column is_active int(1) not null;
alter table phone_contact add column add_date datetime;
alter table phone_contact add column add_by int(10);
alter table phone_contact add column last_edit_date datetime;
alter table phone_contact add column last_edit_by int(10);
alter table report_form modify column add_date datetime;
alter table report_form modify column last_edit_date datetime;
alter table report_form_short_code add column is_deleted int(1) not null;
alter table report_form_short_code add column is_active int(1) not null;
alter table report_form_short_code add column add_date datetime;
alter table report_form_short_code add column add_by int(10);
alter table report_form_short_code add column last_edit_date datetime;
alter table report_form_short_code add column last_edit_by int(10);
alter table user_detail modify column add_date datetime;
alter table user_detail modify column last_edit_date datetime;
alter table user_detail comment = 'Stores user details such as username, password, type, status, etc';


alter table access_scope modify column add_date datetime;
alter table access_scope modify column last_edit_date datetime;
alter table data_element modify column data_element_name varchar(255);
alter table data_element modify column data_element_context varchar(255);
alter table data_element modify column description varchar(255);
alter table data_element modify column add_date datetime;
alter table data_element modify column last_edit_date datetime;
alter table data_element_sms_position modify column add_date datetime;
alter table data_element_sms_position modify column last_edit_date datetime;
alter table interface_data_sms modify column add_date datetime not null;
alter table interface_data_sms modify column last_edit_date datetime;
alter table organisation modify column add_date datetime;
alter table organisation modify column last_edit_date datetime;
alter table phone_contact modify column add_date datetime;
alter table phone_contact modify column last_edit_date datetime;
alter table report_form modify column add_date datetime;
alter table report_form modify column last_edit_date datetime;
alter table report_form_short_code modify column add_date datetime;
alter table report_form_short_code modify column last_edit_date datetime;
alter table user_detail modify column add_date datetime;
alter table user_detail modify column last_edit_date datetime;
alter table user_detail comment = 'Stores user details such as username, password, type, status, etc';

/*
alter_scripts_report_form_shortcode
*/

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

/*
alter_scripts_access_scope
*/
alter table access_scope modify column user_detail_id int(11) not null;
alter table access_scope add column county_id int(11);
alter table access_scope add column sub_county_id int(11);
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
alter table district modify column add_date datetime;
alter table district modify column last_edit_date datetime;
alter table health_facility modify column add_date datetime;
alter table health_facility modify column last_edit_date datetime;
alter table interface_data_sms modify column add_date datetime not null;
alter table interface_data_sms modify column last_edit_date datetime;
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
alter table report_form_short_code modify column add_date datetime not null;
alter table report_form_short_code modify column last_edit_date datetime;
drop table report_form_update;
create table report_form_update (report_form_update_id int(11) not null auto_increment, report_form_id int(11) not null, last_edit_date datetime not null, primary key (report_form_update_id)) ENGINE=InnoDB;
alter table sub_county modify column add_date datetime;
alter table sub_county modify column last_edit_date datetime;
alter table user_detail modify column add_date datetime;
alter table user_detail modify column last_edit_date datetime;
alter table user_detail comment = 'Stores user details such as username, password, type, status, etc';
alter table user_detail modify column add_date datetime;
alter table user_detail modify column last_edit_date datetime;
alter table user_detail comment = 'Stores user details such as username, password, type, status, etc';
alter table access_scope add constraint FKaccess_sco501789 foreign key (user_detail_id) references user_detail (user_detail_id);
alter table access_scope add constraint FKaccess_sco464218 foreign key (district_id) references district (district_id);
alter table access_scope add constraint FKaccess_sco613427 foreign key (health_facility_id) references health_facility (health_facility_id);
alter table access_scope add constraint FKaccess_sco579026 foreign key (parish_id) references parish (parish_id);
alter table access_scope add constraint FKaccess_sco450360 foreign key (sub_county_id) references sub_county (sub_county_id);
alter table access_scope add constraint FKaccess_sco114602 foreign key (county_id) references county (county_id);
alter table access_scope add constraint FKaccess_sco658777 foreign key (region_id) references region (region_id);


/*
alter_scripts_interface_data
*/
alter table interface_data add column entry_mode varchar(20);


/*
alter_scripts_27.04.2018
*/
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


/*
alter_scripts_28.04.2018
*/
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
alter table deadline_extension modify column extended_to_date datetime not null;
alter table deadline_extension add column is_deleted int(1) not null;
alter table deadline_extension add column is_active int(1) not null;
alter table deadline_extension add column add_date datetime;
alter table deadline_extension add column add_by int(10);
alter table deadline_extension add column last_edit_date datetime;
alter table deadline_extension add column last_edit_by int(10);
alter table district modify column add_date datetime;
alter table district modify column last_edit_date datetime;
alter table health_facility modify column add_date datetime;
alter table health_facility modify column last_edit_date datetime;
alter table interface_data_sms modify column add_date datetime not null;
alter table interface_data_sms modify column last_edit_date datetime;
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
alter table report_form_deadline modify column time_from time;
alter table report_form_deadline modify column time_to time;
alter table report_form_deadline add column is_deleted int(1) not null;
alter table report_form_deadline add column is_active int(1) not null;
alter table report_form_deadline add column add_date datetime;
alter table report_form_deadline add column add_by int(10);
alter table report_form_deadline add column last_edit_date datetime;
alter table report_form_deadline add column last_edit_by int(10);
alter table report_form_entity add column is_deleted int(1) not null;
alter table report_form_entity add column is_active int(1) not null;
alter table report_form_entity add column add_date datetime;
alter table report_form_entity add column add_by int(10);
alter table report_form_entity add column last_edit_date datetime;
alter table report_form_entity add column last_edit_by int(10);
alter table report_form_short_code modify column add_date datetime not null;
alter table report_form_short_code modify column last_edit_date datetime;
alter table report_form_update modify column last_edit_date datetime not null;
alter table sent_sms_log modify column sent_date datetime not null;
alter table sent_sms_log add column is_deleted int(1) not null;
alter table sent_sms_log add column is_active int(1) not null;
alter table sent_sms_log add column add_date datetime;
alter table sent_sms_log add column add_by int(10);
alter table sent_sms_log add column last_edit_date datetime;
alter table sent_sms_log add column last_edit_by int(10);
alter table sms_recipient add column is_deleted int(1) not null;
alter table sms_recipient add column is_active int(1) not null;
alter table sms_recipient add column add_date datetime;
alter table sms_recipient add column add_by int(10);
alter table sms_recipient add column last_edit_date datetime;
alter table sms_recipient add column last_edit_by int(10);
alter table sms_schedule modify column send_date datetime;
alter table sms_schedule add column is_deleted int(1) not null;
alter table sms_schedule add column is_active int(1) not null;
alter table sms_schedule add column add_date datetime;
alter table sms_schedule add column add_by int(10);
alter table sms_schedule add column last_edit_date datetime;
alter table sms_schedule add column last_edit_by int(10);
alter table sub_county modify column add_date datetime;
alter table sub_county modify column last_edit_date datetime;
alter table user_detail modify column add_date datetime;
alter table user_detail modify column last_edit_date datetime;
alter table user_detail comment = 'Stores user details such as username, password, type, status, etc';
alter table user_detail modify column add_date datetime;
alter table user_detail modify column last_edit_date datetime;
alter table user_detail comment = 'Stores user details such as username, password, type, status, etc';


/*
create_script_mobile_app_interface
*/
create table batch_mob_app (batch_mob_app_id int(11) not null auto_increment, is_completed int(1) not null, is_deleted int(1) not null, is_active int(1) not null, add_date datetime null, add_by int(10), last_edit_date datetime null, last_edit_by int(10), primary key (batch_mob_app_id)) ENGINE=InnoDB;
create table interface_data_mob_app (interface_data_mob_app_id int(11) not null auto_increment, batch_mob_app_id int(11) not null, data_element_id int(11) not null, data_element_value varchar(100) not null, health_facility_name varchar(100), parish_name varchar(100), sub_county_name varchar(100), county_name varchar(100), district_name varchar(100), add_date_mob_app datetime not null, is_deleted int(1) not null, is_active int(1) not null, add_date datetime null, add_by int(10), last_edit_date datetime null, last_edit_by int(10), status_v varchar(50), status_v_desc text, status_m varchar(50), status_m_desc text, health_facility_id int(11), parish_id int(11), sub_county_id int(10), county_id int(11), district_id int(10), report_form_id int(11), report_form_group_id int(11), entry_mode varchar(20), primary key (interface_data_mob_app_id)) ENGINE=InnoDB;

/*
alter_scripts_01.05.2018
*/
alter table interface_data_sms add column batch_id int(11);

/*
alter_scripts_03.05.2018
*/
create table dashboard_surge (dashboard_surge_id int(11) not null auto_increment, report_form_id int(11), health_facility_id int(11), parish_id int(11), sub_county_id int(11), district_id int(11), report_period_week int(11), report_period_year int(11), report_period_from_date date, report_period_to_date date, data_element_id int(11), a int(11), b int(11), b_prev int(11), c int(11), d int(11), e int(11), f int(11), g int(11), h int(11), i int(11), j int(11), k int(11), l int(11), perc_test_coverage float, perc_miss_appoint_cur float, perc_miss_appoint_prev float, perc_hts_yield float, perc_start_art float, primary key (dashboard_surge_id)) ENGINE=InnoDB;
alter table access_scope modify column add_date datetime not null;
alter table access_scope modify column last_edit_date datetime;
create table batch_mob_app (batch_mob_app_id int(11) not null auto_increment, is_completed int(1) not null, is_deleted int(1) not null, is_active int(1) not null, add_date datetime null, add_by int(10), last_edit_date datetime null, last_edit_by int(10), primary key (batch_mob_app_id)) ENGINE=InnoDB;
alter table county modify column add_date datetime;
alter table county modify column last_edit_date datetime;
alter table data_element modify column data_element_name varchar(255);
alter table data_element modify column data_element_context varchar(255);
alter table data_element modify column description varchar(255);
alter table data_element modify column add_date datetime;
alter table data_element modify column last_edit_date datetime;
alter table data_element_sms_position modify column add_date datetime not null;
alter table data_element_sms_position modify column last_edit_date datetime;
alter table deadline_extension modify column extended_to_date datetime not null;
alter table deadline_extension modify column add_date datetime;
alter table deadline_extension modify column last_edit_date datetime;
create table deadline_reminder (deadline_reminder_id int(11) not null auto_increment, report_form_deadline_id int(11) not null, hours_before_deadline int(11), subject varchar(100), message varchar(250), is_deleted int(1) not null, is_active int(1) not null, add_date datetime null, add_by int(10), last_edit_date datetime null, last_edit_by int(10), primary key (deadline_reminder_id)) ENGINE=InnoDB;
alter table district modify column add_date datetime;
alter table district modify column last_edit_date datetime;
alter table health_facility modify column add_date datetime;
alter table health_facility modify column last_edit_date datetime;
create table interface_data_mob_app (interface_data_mob_app_id int(11) not null auto_increment, batch_mob_app_id int(11) not null, data_element_id int(11) not null, data_element_value varchar(100) not null, health_facility_name varchar(100), parish_name varchar(100), sub_county_name varchar(100), county_name varchar(100), district_name varchar(100), add_date_mob_app datetime not null, is_deleted int(1) not null, is_active int(1) not null, add_date datetime null, add_by int(10), last_edit_date datetime null, last_edit_by int(10), status_v varchar(50), status_v_desc text, status_m varchar(50), status_m_desc text, health_facility_id int(11), parish_id int(11), sub_county_id int(10), county_id int(11), district_id int(10), report_form_id int(11), report_form_group_id int(11), entry_mode varchar(20), primary key (interface_data_mob_app_id)) ENGINE=InnoDB;
alter table interface_data_sms modify column add_date datetime not null;
alter table interface_data_sms modify column last_edit_date datetime;
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
alter table report_form_deadline modify column time_from time;
alter table report_form_deadline modify column time_to time;
alter table report_form_deadline modify column add_date datetime;
alter table report_form_deadline modify column last_edit_date datetime;
alter table report_form_entity modify column add_date datetime;
alter table report_form_entity modify column last_edit_date datetime;
alter table report_form_short_code modify column add_date datetime not null;
alter table report_form_short_code modify column last_edit_date datetime;
alter table report_form_update modify column last_edit_date datetime not null;
create table report_period_week (report_period_week_id int(11) not null auto_increment, calendar_year int(11), week_value int(11), week_from_date date, week_to_date date, is_deleted int(1) not null, is_active int(1) not null, add_date datetime null, add_by int(10), last_edit_date datetime null, last_edit_by int(10), primary key (report_period_week_id)) ENGINE=InnoDB;
alter table sent_sms_log modify column sent_date datetime not null;
alter table sent_sms_log modify column add_date datetime;
alter table sent_sms_log modify column last_edit_date datetime;
alter table sms_recipient modify column add_date datetime;
alter table sms_recipient modify column last_edit_date datetime;
alter table sms_schedule modify column send_date datetime;
alter table sms_schedule modify column add_date datetime;
alter table sms_schedule modify column last_edit_date datetime;
alter table sub_county modify column add_date datetime;
alter table sub_county modify column last_edit_date datetime;
alter table user_detail modify column add_date datetime;
alter table user_detail modify column last_edit_date datetime;
alter table user_detail comment = 'Stores user details such as username, password, type, status, etc';
alter table user_detail modify column add_date datetime;
alter table user_detail modify column last_edit_date datetime;
alter table user_detail comment = 'Stores user details such as username, password, type, status, etc';
alter table deadline_reminder add constraint FKdeadline_r994913 foreign key (report_form_deadline_id) references report_form_deadline (report_form_deadline_id);



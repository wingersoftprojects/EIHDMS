alter table region modify column add_date datetime;
alter table region modify column last_edit_date datetime;
alter table district modify column add_date datetime;
alter table district modify column last_edit_date datetime;
alter table sub_district modify column add_date datetime;
alter table sub_district modify column last_edit_date datetime;
alter table county modify column add_date datetime;
alter table county modify column last_edit_date datetime;
alter table sub_county modify column add_date datetime;
alter table sub_county modify column last_edit_date datetime;
alter table parish modify column add_date datetime;
alter table parish modify column last_edit_date datetime;
alter table health_facility modify column add_date datetime;
alter table health_facility modify column last_edit_date datetime;
alter table facility_level modify column add_date datetime;
alter table facility_level modify column last_edit_date datetime;
alter table report_form modify column add_date datetime;
alter table report_form modify column last_edit_date datetime;
alter table section modify column add_date datetime;
alter table section modify column last_edit_date datetime;
alter table interface_data modify column add_date datetime;
alter table interface_data modify column last_edit_date datetime;
alter table data_element modify column data_element_name varchar(255);
alter table data_element modify column data_element_context varchar(255);
alter table data_element modify column description varchar(255);
alter table data_element modify column add_date datetime;
alter table data_element modify column last_edit_date datetime;
alter table base_data modify column add_date datetime;
alter table base_data modify column last_edit_date datetime;
alter table validation_rule modify column add_date datetime;
alter table validation_rule modify column last_edit_date datetime;
alter table standard_rule modify column add_date datetime;
alter table standard_rule modify column last_edit_date datetime;
alter table group_right modify column add_date datetime not null;
alter table group_right modify column last_edit_date datetime;
alter table user_detail modify column add_date datetime;
alter table user_detail modify column last_edit_date datetime;
alter table user_detail comment = 'Stores user details such as username, password, type, status, etc';
alter table group_user modify column add_date datetime not null;
alter table group_user modify column last_edit_date datetime;
alter table user_category modify column add_date datetime not null;
alter table user_category modify column last_edit_date datetime;
alter table group_detail modify column add_date datetime not null;
alter table group_detail modify column last_edit_date datetime;
alter table login_session modify column add_date datetime not null;
alter table login_session modify column last_edit_date datetime;
alter table user_action modify column action_date datetime not null;
alter table technical_area modify column add_date datetime;
alter table technical_area modify column last_edit_date datetime;
alter table sub_section modify column add_date datetime;
alter table sub_section modify column last_edit_date datetime;
alter table report_form_group modify column add_date datetime;
alter table report_form_group modify column last_edit_date datetime;
alter table application_configuration modify column add_date datetime;
alter table application_configuration modify column last_edit_date datetime;
alter table temp_data_element modify column report_form_name varchar(255) not null;
alter table temp_data_element modify column section_name varchar(255) not null;
alter table temp_data_element modify column sub_section_name varchar(255) not null;
alter table temp_data_element modify column report_form_group_name varchar(255);
alter table temp_data_element modify column data_element_name varchar(255);
alter table temp_data_element modify column technical_area_name varchar(255);
alter table temp_data_element modify column description varchar(255);
alter table temp_data_element modify column data_element_context varchar(255);
alter table temp_health_facility modify column health_facility_name varchar(255) not null;
alter table temp_health_facility modify column region_name varchar(255) not null;
alter table temp_health_facility modify column district_name varchar(255) not null;
alter table temp_health_facility modify column sub_district_name varchar(255) not null;
alter table temp_health_facility modify column county_name varchar(255) not null;
alter table temp_health_facility modify column sub_county_name varchar(255) not null;
alter table temp_health_facility modify column parish_name varchar(255) not null;
alter table temp_health_facility modify column facility_level_name varchar(255) not null;
alter table financial_year modify column add_date datetime;
alter table financial_year modify column last_edit_date datetime;
alter table batch modify column add_date datetime;
alter table batch modify column last_edit_date datetime;
alter table kpi modify column add_date datetime;
alter table kpi modify column last_edit_date datetime;
alter table base_data_deleted modify column add_date datetime;
alter table base_data_deleted modify column last_edit_date datetime;
alter table base_data_deleted modify column delete_date datetime not null;
alter table interface_data_temp modify column add_date datetime;
alter table interface_data_temp modify column last_edit_date datetime;
alter table validation_report modify column status_v_desc varchar(255);
alter table validation_report modify column status_m_desc varchar(255);
alter table validation_report modify column add_date datetime;
alter table loaded_data_summary modify column add_date datetime;
alter table loaded_data_summary modify column last_edit_date datetime;
alter table app_db_user_map modify column add_date datetime not null;
alter table app_db_user_map modify column last_edit_date datetime;
alter table kpi_summary_function modify column add_date datetime;
alter table kpi_summary_function modify column last_edit_date datetime;
alter table interface_data_sms modify column add_date datetime not null;
alter table interface_data_sms modify column last_edit_date datetime;
alter table phone_contact modify column add_date datetime not null;
alter table phone_contact modify column last_edit_date datetime;
alter table data_element_sms_position modify column add_date datetime not null;
alter table data_element_sms_position modify column last_edit_date datetime;
alter table report_form_short_code modify column add_date datetime not null;
alter table report_form_short_code modify column last_edit_date datetime;
alter table organisation modify column add_date datetime not null;
alter table organisation modify column last_edit_date datetime;
alter table access_scope modify column add_date datetime not null;
alter table access_scope modify column last_edit_date datetime;
alter table report_form_update modify column last_edit_date datetime not null;
alter table report_form_deadline modify column time_from time;
alter table report_form_deadline modify column time_to time;
alter table report_form_deadline modify column add_date datetime;
alter table report_form_deadline modify column last_edit_date datetime;
alter table report_form_entity modify column add_date datetime;
alter table report_form_entity modify column last_edit_date datetime;
alter table deadline_extension modify column extended_to_date datetime not null;
alter table deadline_extension modify column add_date datetime;
alter table deadline_extension modify column last_edit_date datetime;
alter table sms_schedule modify column send_date datetime;
alter table sms_schedule modify column add_date datetime;
alter table sms_schedule modify column last_edit_date datetime;
alter table sent_sms_log modify column sent_date datetime not null;
alter table sent_sms_log modify column add_date datetime;
alter table sent_sms_log modify column last_edit_date datetime;
alter table sms_recipient modify column add_date datetime;
alter table sms_recipient modify column last_edit_date datetime;
alter table interface_data_mob_app modify column add_date_mob_app datetime not null;
alter table interface_data_mob_app modify column add_date datetime;
alter table interface_data_mob_app modify column last_edit_date datetime;
alter table batch_mob_app modify column add_date datetime;
alter table batch_mob_app modify column last_edit_date datetime;
alter table dashboard_surge add column targ_htc_tst_pos float;
alter table dashboard_surge add column targ_tx_new float;
alter table dashboard_surge add column perc_htc_tst_pos float;
alter table dashboard_surge add column perc_tx_new float;
alter table deadline_reminder modify column add_date datetime;
alter table deadline_reminder modify column last_edit_date datetime;
alter table report_period_week modify column add_date datetime;
alter table report_period_week modify column last_edit_date datetime;
create table sms_category (sms_category_id int(11) not null auto_increment, sms_category_name varchar(20), sms_category_desc varchar(255), data_entry_scope varchar(20), is_deleted int(1) not null, is_active int(1) not null, add_date datetime null, add_by int(10), last_edit_date datetime null, last_edit_by int(10), primary key (sms_category_id)) ENGINE=InnoDB;
create table sub_section_cell (sub_section_cell_id int(11) not null auto_increment, sub_section_id int(11), section_id int(11), row_no int(11) not null, col_no int(11) not null, col_span int(11), row_span int(11), label_name varchar(100), data_element_id int(11), data_element_value varchar(100), text_color varchar(50), cell_color varchar(50), read_only int(1), is_deleted int(1) not null, is_active int(1) not null, add_date datetime not null, add_by int(10), last_edit_date datetime null, last_edit_by int(10), primary key (sub_section_cell_id)) ENGINE=InnoDB;
alter table report_form_entity_count modify column add_date datetime;
alter table report_form_entity_count modify column last_edit_date datetime;
alter table ForgotPassword modify column expirydate datetime not null;
alter table data_element add constraint FKdata_eleme957620 foreign key (report_form_id) references report_form (report_form_id);
alter table data_element add constraint FKdata_eleme646763 foreign key (section_id) references section (section_id);
alter table data_element add constraint FKdata_eleme387873 foreign key (technical_area_id) references technical_area (technical_area_id);
alter table data_element add constraint FKdata_eleme615147 foreign key (sub_section_id) references sub_section (sub_section_id);
alter table data_element add constraint FKdata_eleme532133 foreign key (report_form_group_id) references report_form_group (report_form_group_id);
alter table data_element_sms_position add constraint FKdata_eleme644022 foreign key (report_form_short_code_id) references report_form_short_code (report_form_short_code_id);
alter table data_element_sms_position add constraint FKdata_eleme360408 foreign key (data_element_id) references data_element (data_element_id);
alter table report_form_short_code add constraint FKreport_for711820 foreign key (report_form_id) references report_form (report_form_id);
alter table report_form_deadline add constraint FKreport_for555710 foreign key (report_form_id) references report_form (report_form_id);
alter table report_form_entity add constraint FKreport_for256822 foreign key (report_form_id) references report_form (report_form_id);
alter table deadline_extension add constraint FKdeadline_e392986 foreign key (report_form_deadline_id) references report_form_deadline (report_form_deadline_id);
alter table sub_section_cell add constraint FKsub_sectio34243 foreign key (sub_section_id) references sub_section (sub_section_id);
alter table sub_section_cell add constraint FKsub_sectio698396 foreign key (data_element_id) references data_element (data_element_id);
alter table sub_section_cell add constraint FKsub_sectio65859 foreign key (section_id) references section (section_id);
alter table report_form_entity_count add constraint FKreport_for328608 foreign key (report_form_id) references report_form (report_form_id);
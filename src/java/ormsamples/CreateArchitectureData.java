/**
 * Licensee: Ajuna Newton Brian
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class CreateArchitectureData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = eihdms.EIHDMSPersistentManager.instance().getSession().beginTransaction();
		try {
			eihdms.Region leihdmsRegion = eihdms.Region.createRegion();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : health_facility, district
			leihdmsRegion.save();
			eihdms.District leihdmsDistrict = eihdms.District.createDistrict();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : health_facility, county, sub_district, region
			leihdmsDistrict.save();
			eihdms.Sub_district leihdmsSub_district = eihdms.Sub_district.createSub_district();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : health_facility, district
			leihdmsSub_district.save();
			eihdms.County leihdmsCounty = eihdms.County.createCounty();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : health_facility, sub_county, district
			leihdmsCounty.save();
			eihdms.Sub_county leihdmsSub_county = eihdms.Sub_county.createSub_county();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : health_facility, parish, county
			leihdmsSub_county.save();
			eihdms.Parish leihdmsParish = eihdms.Parish.createParish();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : health_facility, sub_county
			leihdmsParish.save();
			eihdms.Health_facility leihdmsHealth_facility = eihdms.Health_facility.createHealth_facility();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : facility_level, parish, sub_county, county, sub_district, district, region
			leihdmsHealth_facility.save();
			eihdms.Facility_level leihdmsFacility_level = eihdms.Facility_level.createFacility_level();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : health_facility
			leihdmsFacility_level.save();
			eihdms.Report_form leihdmsReport_form = eihdms.Report_form.createReport_form();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : group_right, report_form_entity, data_obligation, validation_rule, report_form_group, user_action, section, data_element, is_active, is_deleted, lowest_report_form_level, report_form_frequency, report_form_name, report_form_code
			leihdmsReport_form.save();
			eihdms.Section leihdmsSection = eihdms.Section.createSection();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : sub_section, data_element, is_active, is_deleted, report_form, section_order, section_name
			leihdmsSection.save();
			eihdms.Interface_data leihdmsInterface_data = eihdms.Interface_data.createInterface_data();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, report_period_to_date, report_period_from_date, data_element_value, data_element
			leihdmsInterface_data.save();
			eihdms.Data_element leihdmsData_element = eihdms.Data_element.createData_element();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : data_element_sms_position, standard_rule, base_data, interface_data, is_active, is_deleted, sub_section, section, report_form
			leihdmsData_element.save();
			eihdms.Base_data leihdmsBase_data = eihdms.Base_data.createBase_data();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, report_period_to_date, report_period_from_date, data_element_value, data_element
			leihdmsBase_data.save();
			eihdms.Validation_rule leihdmsValidation_rule = eihdms.Validation_rule.createValidation_rule();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, data_elements_involved, validation_rule_formula, validation_rule_name, report_form_group, report_form
			leihdmsValidation_rule.save();
			eihdms.Standard_rule leihdmsStandard_rule = eihdms.Standard_rule.createStandard_rule();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, data_element, standard_rule_name
			leihdmsStandard_rule.save();
			eihdms.User_detail leihdmsUser_detail = eihdms.User_detail.createUser_detail();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : access_scope, user_action, login_session, group_user, is_active, is_deleted, is_user_gen_admin, third_name, second_name, first_name, user_password, user_name
			leihdmsUser_detail.save();
			eihdms.Group_user leihdmsGroup_user = eihdms.Group_user.createGroup_user();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : add_by, add_date, is_active, is_deleted, user_detail, group_detail
			leihdmsGroup_user.save();
			eihdms.User_category leihdmsUser_category = eihdms.User_category.createUser_category();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : add_by, add_date, is_active, is_deleted, user_category_name
			leihdmsUser_category.save();
			eihdms.Group_detail leihdmsGroup_detail = eihdms.Group_detail.createGroup_detail();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : group_right, group_user, add_by, add_date, is_active, is_deleted, group_name
			leihdmsGroup_detail.save();
			eihdms.Login_session leihdmsLogin_session = eihdms.Login_session.createLogin_session();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : add_by, add_date, is_active, is_deleted, remote_user, remote_host, remote_ip, session_id, user_detail
			leihdmsLogin_session.save();
			eihdms.User_action leihdmsUser_action = eihdms.User_action.createUser_action();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : action_date, action, form_template, user_detail
			leihdmsUser_action.save();
			eihdms.Technical_area leihdmsTechnical_area = eihdms.Technical_area.createTechnical_area();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, description, technical_area_name
			leihdmsTechnical_area.save();
			eihdms.Sub_section leihdmsSub_section = eihdms.Sub_section.createSub_section();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : sub_section_cell, data_element, is_active, is_deleted, section, sub_section_order, sub_section_name
			leihdmsSub_section.save();
			eihdms.Report_form_group leihdmsReport_form_group = eihdms.Report_form_group.createReport_form_group();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : validation_rule, group_order, is_active, is_deleted, report_form, description, report_form_group_name
			leihdmsReport_form_group.save();
			eihdms.Application_configuration leihdmsApplication_configuration = eihdms.Application_configuration.createApplication_configuration();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, parameter_value, parameter_name
			leihdmsApplication_configuration.save();
			eihdms.Temp_data_element leihdmsTemp_data_element = eihdms.Temp_data_element.createTemp_data_element();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : sub_section_name, section_name, report_form_name
			leihdmsTemp_data_element.save();
			eihdms.Temp_health_facility leihdmsTemp_health_facility = eihdms.Temp_health_facility.createTemp_health_facility();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, facility_level_name, parish_name, sub_county_name, county_name, sub_district_name, district_name, region_name, health_facility_name
			leihdmsTemp_health_facility.save();
			eihdms.Financial_year leihdmsFinancial_year = eihdms.Financial_year.createFinancial_year();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, financial_year_name
			leihdmsFinancial_year.save();
			eihdms.Batch leihdmsBatch = eihdms.Batch.createBatch();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted
			leihdmsBatch.save();
			eihdms.Kpi leihdmsKpi = eihdms.Kpi.createKpi();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : kpi_summary_function, is_active, is_deleted, kpi_name
			leihdmsKpi.save();
			eihdms.Data_obligation leihdmsData_obligation = eihdms.Data_obligation.createData_obligation();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : report_form
			leihdmsData_obligation.save();
			eihdms.Base_data_deleted leihdmsBase_data_deleted = eihdms.Base_data_deleted.createBase_data_deleted();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : delete_date, deleted_by, is_active, is_deleted, report_period_to_date, report_period_from_date, data_element_value, data_element_id, base_data_id
			leihdmsBase_data_deleted.save();
			eihdms.Interface_data_temp leihdmsInterface_data_temp = eihdms.Interface_data_temp.createInterface_data_temp();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : report_period_to_date, report_period_from_date, data_element_value, data_element_id
			leihdmsInterface_data_temp.save();
			eihdms.Validation_report leihdmsValidation_report = eihdms.Validation_report.createValidation_report();
			// Initialize the properties of the persistent object here
			leihdmsValidation_report.save();
			eihdms.Loaded_data_summary leihdmsLoaded_data_summary = eihdms.Loaded_data_summary.createLoaded_data_summary();
			// Initialize the properties of the persistent object here
			leihdmsLoaded_data_summary.save();
			eihdms.App_db_user_map leihdmsApp_db_user_map = eihdms.App_db_user_map.createApp_db_user_map();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : add_by, add_date, is_active, is_deleted, db_password, db_user, user_detail_id
			leihdmsApp_db_user_map.save();
			eihdms.Kpi_summary_function leihdmsKpi_summary_function = eihdms.Kpi_summary_function.createKpi_summary_function();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, data_elements_involved, summary_function, kpi_summary_function_name, kpi
			leihdmsKpi_summary_function.save();
			eihdms.Interface_data_sms leihdmsInterface_data_sms = eihdms.Interface_data_sms.createInterface_data_sms();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : add_by, is_active, is_deleted, phone, add_date
			leihdmsInterface_data_sms.save();
			eihdms.Phone_contact leihdmsPhone_contact = eihdms.Phone_contact.createPhone_contact();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : add_by, add_date, is_active, is_deleted, entity_phone, entity_id, entity_type
			leihdmsPhone_contact.save();
			eihdms.Data_element_sms_position leihdmsData_element_sms_position = eihdms.Data_element_sms_position.createData_element_sms_position();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : add_by, add_date, is_active, is_deleted, value_position, data_element
			leihdmsData_element_sms_position.save();
			eihdms.Report_form_short_code leihdmsReport_form_short_code = eihdms.Report_form_short_code.createReport_form_short_code();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : add_by, add_date, is_active, is_deleted, short_code, number_of_separators, start_code
			leihdmsReport_form_short_code.save();
			eihdms.Organisation leihdmsOrganisation = eihdms.Organisation.createOrganisation();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : add_by, add_date, is_deleted, is_active, organisation_name
			leihdmsOrganisation.save();
			eihdms.Access_scope leihdmsAccess_scope = eihdms.Access_scope.createAccess_scope();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : add_by, add_date, is_active, is_deleted, user_detail
			leihdmsAccess_scope.save();
			eihdms.Report_form_update leihdmsReport_form_update = eihdms.Report_form_update.createReport_form_update();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : last_edit_date, report_form_id
			leihdmsReport_form_update.save();
			eihdms.Group_right leihdmsGroup_right = eihdms.Group_right.createGroup_right();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : add_by, add_date, is_active, is_deleted, allow_delete, allow_edit, allow_add, allow_view, report_form, group_detail
			leihdmsGroup_right.save();
			eihdms.Report_form_deadline leihdmsReport_form_deadline = eihdms.Report_form_deadline.createReport_form_deadline();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : deadline_reminder, deadline_extension, is_active, is_deleted
			leihdmsReport_form_deadline.save();
			eihdms.Report_form_entity leihdmsReport_form_entity = eihdms.Report_form_entity.createReport_form_entity();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, entity_id, entity_type, report_form
			leihdmsReport_form_entity.save();
			eihdms.Deadline_extension leihdmsDeadline_extension = eihdms.Deadline_extension.createDeadline_extension();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, extended_to_date, report_form_deadline
			leihdmsDeadline_extension.save();
			eihdms.Sms_schedule leihdmsSms_schedule = eihdms.Sms_schedule.createSms_schedule();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted
			leihdmsSms_schedule.save();
			eihdms.Sent_sms_log leihdmsSent_sms_log = eihdms.Sent_sms_log.createSent_sms_log();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, sent_date
			leihdmsSent_sms_log.save();
			eihdms.Sms_recipient leihdmsSms_recipient = eihdms.Sms_recipient.createSms_recipient();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted
			leihdmsSms_recipient.save();
			eihdms.Interface_data_mob_app leihdmsInterface_data_mob_app = eihdms.Interface_data_mob_app.createInterface_data_mob_app();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, add_date_mob_app, data_element_value, data_element_id, batch_mob_app_id
			leihdmsInterface_data_mob_app.save();
			eihdms.Batch_mob_app leihdmsBatch_mob_app = eihdms.Batch_mob_app.createBatch_mob_app();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, is_completed
			leihdmsBatch_mob_app.save();
			eihdms.Dashboard_surge leihdmsDashboard_surge = eihdms.Dashboard_surge.createDashboard_surge();
			// Initialize the properties of the persistent object here
			leihdmsDashboard_surge.save();
			eihdms.Deadline_reminder leihdmsDeadline_reminder = eihdms.Deadline_reminder.createDeadline_reminder();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, report_form_deadline
			leihdmsDeadline_reminder.save();
			eihdms.Report_period_week leihdmsReport_period_week = eihdms.Report_period_week.createReport_period_week();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted
			leihdmsReport_period_week.save();
			eihdms.Sms_category leihdmsSms_category = eihdms.Sms_category.createSms_category();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted
			leihdmsSms_category.save();
			eihdms.Sub_section_cell leihdmsSub_section_cell = eihdms.Sub_section_cell.createSub_section_cell();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : add_date, is_active, is_deleted, col_no, row_no, sub_section
			leihdmsSub_section_cell.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateArchitectureData createArchitectureData = new CreateArchitectureData();
			try {
				createArchitectureData.createTestData();
			}
			finally {
				eihdms.EIHDMSPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

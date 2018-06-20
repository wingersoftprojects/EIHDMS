/**
 * Licensee: Ajuna Newton Brian
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class ListArchitectureData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Region...");
		eihdms.Region[] eihdmsRegions = eihdms.Region.listRegionByQuery(null, null);
		int length = Math.min(eihdmsRegions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsRegions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing District...");
		eihdms.District[] eihdmsDistricts = eihdms.District.listDistrictByQuery(null, null);
		length = Math.min(eihdmsDistricts.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsDistricts[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Sub_district...");
		eihdms.Sub_district[] eihdmsSub_districts = eihdms.Sub_district.listSub_districtByQuery(null, null);
		length = Math.min(eihdmsSub_districts.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsSub_districts[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing County...");
		eihdms.County[] eihdmsCountys = eihdms.County.listCountyByQuery(null, null);
		length = Math.min(eihdmsCountys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsCountys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Sub_county...");
		eihdms.Sub_county[] eihdmsSub_countys = eihdms.Sub_county.listSub_countyByQuery(null, null);
		length = Math.min(eihdmsSub_countys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsSub_countys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Parish...");
		eihdms.Parish[] eihdmsParishs = eihdms.Parish.listParishByQuery(null, null);
		length = Math.min(eihdmsParishs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsParishs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Health_facility...");
		eihdms.Health_facility[] eihdmsHealth_facilitys = eihdms.Health_facility.listHealth_facilityByQuery(null, null);
		length = Math.min(eihdmsHealth_facilitys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsHealth_facilitys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Facility_level...");
		eihdms.Facility_level[] eihdmsFacility_levels = eihdms.Facility_level.listFacility_levelByQuery(null, null);
		length = Math.min(eihdmsFacility_levels.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsFacility_levels[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Report_form...");
		eihdms.Report_form[] eihdmsReport_forms = eihdms.Report_form.listReport_formByQuery(null, null);
		length = Math.min(eihdmsReport_forms.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsReport_forms[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Section...");
		eihdms.Section[] eihdmsSections = eihdms.Section.listSectionByQuery(null, null);
		length = Math.min(eihdmsSections.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsSections[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Interface_data...");
		eihdms.Interface_data[] eihdmsInterface_datas = eihdms.Interface_data.listInterface_dataByQuery(null, null);
		length = Math.min(eihdmsInterface_datas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsInterface_datas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Data_element...");
		eihdms.Data_element[] eihdmsData_elements = eihdms.Data_element.listData_elementByQuery(null, null);
		length = Math.min(eihdmsData_elements.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsData_elements[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Base_data...");
		eihdms.Base_data[] eihdmsBase_datas = eihdms.Base_data.listBase_dataByQuery(null, null);
		length = Math.min(eihdmsBase_datas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsBase_datas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Validation_rule...");
		eihdms.Validation_rule[] eihdmsValidation_rules = eihdms.Validation_rule.listValidation_ruleByQuery(null, null);
		length = Math.min(eihdmsValidation_rules.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsValidation_rules[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Standard_rule...");
		eihdms.Standard_rule[] eihdmsStandard_rules = eihdms.Standard_rule.listStandard_ruleByQuery(null, null);
		length = Math.min(eihdmsStandard_rules.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsStandard_rules[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing User_detail...");
		eihdms.User_detail[] eihdmsUser_details = eihdms.User_detail.listUser_detailByQuery(null, null);
		length = Math.min(eihdmsUser_details.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsUser_details[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Group_user...");
		eihdms.Group_user[] eihdmsGroup_users = eihdms.Group_user.listGroup_userByQuery(null, null);
		length = Math.min(eihdmsGroup_users.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsGroup_users[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing User_category...");
		eihdms.User_category[] eihdmsUser_categorys = eihdms.User_category.listUser_categoryByQuery(null, null);
		length = Math.min(eihdmsUser_categorys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsUser_categorys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Group_detail...");
		eihdms.Group_detail[] eihdmsGroup_details = eihdms.Group_detail.listGroup_detailByQuery(null, null);
		length = Math.min(eihdmsGroup_details.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsGroup_details[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Login_session...");
		eihdms.Login_session[] eihdmsLogin_sessions = eihdms.Login_session.listLogin_sessionByQuery(null, null);
		length = Math.min(eihdmsLogin_sessions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsLogin_sessions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing User_action...");
		eihdms.User_action[] eihdmsUser_actions = eihdms.User_action.listUser_actionByQuery(null, null);
		length = Math.min(eihdmsUser_actions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsUser_actions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Technical_area...");
		eihdms.Technical_area[] eihdmsTechnical_areas = eihdms.Technical_area.listTechnical_areaByQuery(null, null);
		length = Math.min(eihdmsTechnical_areas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsTechnical_areas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Sub_section...");
		eihdms.Sub_section[] eihdmsSub_sections = eihdms.Sub_section.listSub_sectionByQuery(null, null);
		length = Math.min(eihdmsSub_sections.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsSub_sections[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Report_form_group...");
		eihdms.Report_form_group[] eihdmsReport_form_groups = eihdms.Report_form_group.listReport_form_groupByQuery(null, null);
		length = Math.min(eihdmsReport_form_groups.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsReport_form_groups[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Application_configuration...");
		eihdms.Application_configuration[] eihdmsApplication_configurations = eihdms.Application_configuration.listApplication_configurationByQuery(null, null);
		length = Math.min(eihdmsApplication_configurations.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsApplication_configurations[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Temp_data_element...");
		eihdms.Temp_data_element[] eihdmsTemp_data_elements = eihdms.Temp_data_element.listTemp_data_elementByQuery(null, null);
		length = Math.min(eihdmsTemp_data_elements.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsTemp_data_elements[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Temp_health_facility...");
		eihdms.Temp_health_facility[] eihdmsTemp_health_facilitys = eihdms.Temp_health_facility.listTemp_health_facilityByQuery(null, null);
		length = Math.min(eihdmsTemp_health_facilitys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsTemp_health_facilitys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Financial_year...");
		eihdms.Financial_year[] eihdmsFinancial_years = eihdms.Financial_year.listFinancial_yearByQuery(null, null);
		length = Math.min(eihdmsFinancial_years.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsFinancial_years[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Batch...");
		eihdms.Batch[] eihdmsBatchs = eihdms.Batch.listBatchByQuery(null, null);
		length = Math.min(eihdmsBatchs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsBatchs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Kpi...");
		eihdms.Kpi[] eihdmsKpis = eihdms.Kpi.listKpiByQuery(null, null);
		length = Math.min(eihdmsKpis.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsKpis[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Data_obligation...");
		eihdms.Data_obligation[] eihdmsData_obligations = eihdms.Data_obligation.listData_obligationByQuery(null, null);
		length = Math.min(eihdmsData_obligations.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsData_obligations[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Base_data_deleted...");
		eihdms.Base_data_deleted[] eihdmsBase_data_deleteds = eihdms.Base_data_deleted.listBase_data_deletedByQuery(null, null);
		length = Math.min(eihdmsBase_data_deleteds.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsBase_data_deleteds[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Interface_data_temp...");
		eihdms.Interface_data_temp[] eihdmsInterface_data_temps = eihdms.Interface_data_temp.listInterface_data_tempByQuery(null, null);
		length = Math.min(eihdmsInterface_data_temps.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsInterface_data_temps[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Validation_report...");
		eihdms.Validation_report[] eihdmsValidation_reports = eihdms.Validation_report.listValidation_reportByQuery(null, null);
		length = Math.min(eihdmsValidation_reports.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsValidation_reports[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Loaded_data_summary...");
		eihdms.Loaded_data_summary[] eihdmsLoaded_data_summarys = eihdms.Loaded_data_summary.listLoaded_data_summaryByQuery(null, null);
		length = Math.min(eihdmsLoaded_data_summarys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsLoaded_data_summarys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing App_db_user_map...");
		eihdms.App_db_user_map[] eihdmsApp_db_user_maps = eihdms.App_db_user_map.listApp_db_user_mapByQuery(null, null);
		length = Math.min(eihdmsApp_db_user_maps.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsApp_db_user_maps[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Kpi_summary_function...");
		eihdms.Kpi_summary_function[] eihdmsKpi_summary_functions = eihdms.Kpi_summary_function.listKpi_summary_functionByQuery(null, null);
		length = Math.min(eihdmsKpi_summary_functions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsKpi_summary_functions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Interface_data_sms...");
		eihdms.Interface_data_sms[] eihdmsInterface_data_smses = eihdms.Interface_data_sms.listInterface_data_smsByQuery(null, null);
		length = Math.min(eihdmsInterface_data_smses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsInterface_data_smses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Phone_contact...");
		eihdms.Phone_contact[] eihdmsPhone_contacts = eihdms.Phone_contact.listPhone_contactByQuery(null, null);
		length = Math.min(eihdmsPhone_contacts.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsPhone_contacts[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Data_element_sms_position...");
		eihdms.Data_element_sms_position[] eihdmsData_element_sms_positions = eihdms.Data_element_sms_position.listData_element_sms_positionByQuery(null, null);
		length = Math.min(eihdmsData_element_sms_positions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsData_element_sms_positions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Report_form_short_code...");
		eihdms.Report_form_short_code[] eihdmsReport_form_short_codes = eihdms.Report_form_short_code.listReport_form_short_codeByQuery(null, null);
		length = Math.min(eihdmsReport_form_short_codes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsReport_form_short_codes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Organisation...");
		eihdms.Organisation[] eihdmsOrganisations = eihdms.Organisation.listOrganisationByQuery(null, null);
		length = Math.min(eihdmsOrganisations.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsOrganisations[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Access_scope...");
		eihdms.Access_scope[] eihdmsAccess_scopes = eihdms.Access_scope.listAccess_scopeByQuery(null, null);
		length = Math.min(eihdmsAccess_scopes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsAccess_scopes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Report_form_update...");
		eihdms.Report_form_update[] eihdmsReport_form_updates = eihdms.Report_form_update.listReport_form_updateByQuery(null, null);
		length = Math.min(eihdmsReport_form_updates.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsReport_form_updates[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Group_right...");
		eihdms.Group_right[] eihdmsGroup_rights = eihdms.Group_right.listGroup_rightByQuery(null, null);
		length = Math.min(eihdmsGroup_rights.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsGroup_rights[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Report_form_deadline...");
		eihdms.Report_form_deadline[] eihdmsReport_form_deadlines = eihdms.Report_form_deadline.listReport_form_deadlineByQuery(null, null);
		length = Math.min(eihdmsReport_form_deadlines.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsReport_form_deadlines[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Report_form_entity...");
		eihdms.Report_form_entity[] eihdmsReport_form_entitys = eihdms.Report_form_entity.listReport_form_entityByQuery(null, null);
		length = Math.min(eihdmsReport_form_entitys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsReport_form_entitys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Deadline_extension...");
		eihdms.Deadline_extension[] eihdmsDeadline_extensions = eihdms.Deadline_extension.listDeadline_extensionByQuery(null, null);
		length = Math.min(eihdmsDeadline_extensions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsDeadline_extensions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Sms_schedule...");
		eihdms.Sms_schedule[] eihdmsSms_schedules = eihdms.Sms_schedule.listSms_scheduleByQuery(null, null);
		length = Math.min(eihdmsSms_schedules.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsSms_schedules[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Sent_sms_log...");
		eihdms.Sent_sms_log[] eihdmsSent_sms_logs = eihdms.Sent_sms_log.listSent_sms_logByQuery(null, null);
		length = Math.min(eihdmsSent_sms_logs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsSent_sms_logs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Sms_recipient...");
		eihdms.Sms_recipient[] eihdmsSms_recipients = eihdms.Sms_recipient.listSms_recipientByQuery(null, null);
		length = Math.min(eihdmsSms_recipients.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsSms_recipients[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Interface_data_mob_app...");
		eihdms.Interface_data_mob_app[] eihdmsInterface_data_mob_apps = eihdms.Interface_data_mob_app.listInterface_data_mob_appByQuery(null, null);
		length = Math.min(eihdmsInterface_data_mob_apps.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsInterface_data_mob_apps[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Batch_mob_app...");
		eihdms.Batch_mob_app[] eihdmsBatch_mob_apps = eihdms.Batch_mob_app.listBatch_mob_appByQuery(null, null);
		length = Math.min(eihdmsBatch_mob_apps.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsBatch_mob_apps[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Dashboard_surge...");
		eihdms.Dashboard_surge[] eihdmsDashboard_surges = eihdms.Dashboard_surge.listDashboard_surgeByQuery(null, null);
		length = Math.min(eihdmsDashboard_surges.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsDashboard_surges[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Deadline_reminder...");
		eihdms.Deadline_reminder[] eihdmsDeadline_reminders = eihdms.Deadline_reminder.listDeadline_reminderByQuery(null, null);
		length = Math.min(eihdmsDeadline_reminders.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsDeadline_reminders[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Report_period_week...");
		eihdms.Report_period_week[] eihdmsReport_period_weeks = eihdms.Report_period_week.listReport_period_weekByQuery(null, null);
		length = Math.min(eihdmsReport_period_weeks.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsReport_period_weeks[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Sms_category...");
		eihdms.Sms_category[] eihdmsSms_categorys = eihdms.Sms_category.listSms_categoryByQuery(null, null);
		length = Math.min(eihdmsSms_categorys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsSms_categorys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Sub_section_cell...");
		eihdms.Sub_section_cell[] eihdmsSub_section_cells = eihdms.Sub_section_cell.listSub_section_cellByQuery(null, null);
		length = Math.min(eihdmsSub_section_cells.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsSub_section_cells[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Region by Criteria...");
		eihdms.RegionCriteria leihdmsRegionCriteria = new eihdms.RegionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsRegionCriteria.region_id.eq();
		leihdmsRegionCriteria.setMaxResults(ROW_COUNT);
		eihdms.Region[] eihdmsRegions = leihdmsRegionCriteria.listRegion();
		int length =eihdmsRegions== null ? 0 : Math.min(eihdmsRegions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsRegions[i]);
		}
		System.out.println(length + " Region record(s) retrieved."); 
		
		System.out.println("Listing District by Criteria...");
		eihdms.DistrictCriteria leihdmsDistrictCriteria = new eihdms.DistrictCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsDistrictCriteria.district_id.eq();
		leihdmsDistrictCriteria.setMaxResults(ROW_COUNT);
		eihdms.District[] eihdmsDistricts = leihdmsDistrictCriteria.listDistrict();
		length =eihdmsDistricts== null ? 0 : Math.min(eihdmsDistricts.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsDistricts[i]);
		}
		System.out.println(length + " District record(s) retrieved."); 
		
		System.out.println("Listing Sub_district by Criteria...");
		eihdms.Sub_districtCriteria leihdmsSub_districtCriteria = new eihdms.Sub_districtCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsSub_districtCriteria.sub_district_id.eq();
		leihdmsSub_districtCriteria.setMaxResults(ROW_COUNT);
		eihdms.Sub_district[] eihdmsSub_districts = leihdmsSub_districtCriteria.listSub_district();
		length =eihdmsSub_districts== null ? 0 : Math.min(eihdmsSub_districts.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsSub_districts[i]);
		}
		System.out.println(length + " Sub_district record(s) retrieved."); 
		
		System.out.println("Listing County by Criteria...");
		eihdms.CountyCriteria leihdmsCountyCriteria = new eihdms.CountyCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsCountyCriteria.county_id.eq();
		leihdmsCountyCriteria.setMaxResults(ROW_COUNT);
		eihdms.County[] eihdmsCountys = leihdmsCountyCriteria.listCounty();
		length =eihdmsCountys== null ? 0 : Math.min(eihdmsCountys.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsCountys[i]);
		}
		System.out.println(length + " County record(s) retrieved."); 
		
		System.out.println("Listing Sub_county by Criteria...");
		eihdms.Sub_countyCriteria leihdmsSub_countyCriteria = new eihdms.Sub_countyCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsSub_countyCriteria.sub_county_id.eq();
		leihdmsSub_countyCriteria.setMaxResults(ROW_COUNT);
		eihdms.Sub_county[] eihdmsSub_countys = leihdmsSub_countyCriteria.listSub_county();
		length =eihdmsSub_countys== null ? 0 : Math.min(eihdmsSub_countys.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsSub_countys[i]);
		}
		System.out.println(length + " Sub_county record(s) retrieved."); 
		
		System.out.println("Listing Parish by Criteria...");
		eihdms.ParishCriteria leihdmsParishCriteria = new eihdms.ParishCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsParishCriteria.parish_id.eq();
		leihdmsParishCriteria.setMaxResults(ROW_COUNT);
		eihdms.Parish[] eihdmsParishs = leihdmsParishCriteria.listParish();
		length =eihdmsParishs== null ? 0 : Math.min(eihdmsParishs.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsParishs[i]);
		}
		System.out.println(length + " Parish record(s) retrieved."); 
		
		System.out.println("Listing Health_facility by Criteria...");
		eihdms.Health_facilityCriteria leihdmsHealth_facilityCriteria = new eihdms.Health_facilityCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsHealth_facilityCriteria.health_facility_id.eq();
		leihdmsHealth_facilityCriteria.setMaxResults(ROW_COUNT);
		eihdms.Health_facility[] eihdmsHealth_facilitys = leihdmsHealth_facilityCriteria.listHealth_facility();
		length =eihdmsHealth_facilitys== null ? 0 : Math.min(eihdmsHealth_facilitys.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsHealth_facilitys[i]);
		}
		System.out.println(length + " Health_facility record(s) retrieved."); 
		
		System.out.println("Listing Facility_level by Criteria...");
		eihdms.Facility_levelCriteria leihdmsFacility_levelCriteria = new eihdms.Facility_levelCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsFacility_levelCriteria.facility_level_id.eq();
		leihdmsFacility_levelCriteria.setMaxResults(ROW_COUNT);
		eihdms.Facility_level[] eihdmsFacility_levels = leihdmsFacility_levelCriteria.listFacility_level();
		length =eihdmsFacility_levels== null ? 0 : Math.min(eihdmsFacility_levels.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsFacility_levels[i]);
		}
		System.out.println(length + " Facility_level record(s) retrieved."); 
		
		System.out.println("Listing Report_form by Criteria...");
		eihdms.Report_formCriteria leihdmsReport_formCriteria = new eihdms.Report_formCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsReport_formCriteria.report_form_id.eq();
		leihdmsReport_formCriteria.setMaxResults(ROW_COUNT);
		eihdms.Report_form[] eihdmsReport_forms = leihdmsReport_formCriteria.listReport_form();
		length =eihdmsReport_forms== null ? 0 : Math.min(eihdmsReport_forms.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsReport_forms[i]);
		}
		System.out.println(length + " Report_form record(s) retrieved."); 
		
		System.out.println("Listing Section by Criteria...");
		eihdms.SectionCriteria leihdmsSectionCriteria = new eihdms.SectionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsSectionCriteria.section_id.eq();
		leihdmsSectionCriteria.setMaxResults(ROW_COUNT);
		eihdms.Section[] eihdmsSections = leihdmsSectionCriteria.listSection();
		length =eihdmsSections== null ? 0 : Math.min(eihdmsSections.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsSections[i]);
		}
		System.out.println(length + " Section record(s) retrieved."); 
		
		System.out.println("Listing Interface_data by Criteria...");
		eihdms.Interface_dataCriteria leihdmsInterface_dataCriteria = new eihdms.Interface_dataCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsInterface_dataCriteria.interface_data_id.eq();
		leihdmsInterface_dataCriteria.setMaxResults(ROW_COUNT);
		eihdms.Interface_data[] eihdmsInterface_datas = leihdmsInterface_dataCriteria.listInterface_data();
		length =eihdmsInterface_datas== null ? 0 : Math.min(eihdmsInterface_datas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsInterface_datas[i]);
		}
		System.out.println(length + " Interface_data record(s) retrieved."); 
		
		System.out.println("Listing Data_element by Criteria...");
		eihdms.Data_elementCriteria leihdmsData_elementCriteria = new eihdms.Data_elementCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsData_elementCriteria.data_element_id.eq();
		leihdmsData_elementCriteria.setMaxResults(ROW_COUNT);
		eihdms.Data_element[] eihdmsData_elements = leihdmsData_elementCriteria.listData_element();
		length =eihdmsData_elements== null ? 0 : Math.min(eihdmsData_elements.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsData_elements[i]);
		}
		System.out.println(length + " Data_element record(s) retrieved."); 
		
		System.out.println("Listing Base_data by Criteria...");
		eihdms.Base_dataCriteria leihdmsBase_dataCriteria = new eihdms.Base_dataCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsBase_dataCriteria.base_data_id.eq();
		leihdmsBase_dataCriteria.setMaxResults(ROW_COUNT);
		eihdms.Base_data[] eihdmsBase_datas = leihdmsBase_dataCriteria.listBase_data();
		length =eihdmsBase_datas== null ? 0 : Math.min(eihdmsBase_datas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsBase_datas[i]);
		}
		System.out.println(length + " Base_data record(s) retrieved."); 
		
		System.out.println("Listing Validation_rule by Criteria...");
		eihdms.Validation_ruleCriteria leihdmsValidation_ruleCriteria = new eihdms.Validation_ruleCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsValidation_ruleCriteria.validation_rule_id.eq();
		leihdmsValidation_ruleCriteria.setMaxResults(ROW_COUNT);
		eihdms.Validation_rule[] eihdmsValidation_rules = leihdmsValidation_ruleCriteria.listValidation_rule();
		length =eihdmsValidation_rules== null ? 0 : Math.min(eihdmsValidation_rules.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsValidation_rules[i]);
		}
		System.out.println(length + " Validation_rule record(s) retrieved."); 
		
		System.out.println("Listing Standard_rule by Criteria...");
		eihdms.Standard_ruleCriteria leihdmsStandard_ruleCriteria = new eihdms.Standard_ruleCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsStandard_ruleCriteria.standard_rule_id.eq();
		leihdmsStandard_ruleCriteria.setMaxResults(ROW_COUNT);
		eihdms.Standard_rule[] eihdmsStandard_rules = leihdmsStandard_ruleCriteria.listStandard_rule();
		length =eihdmsStandard_rules== null ? 0 : Math.min(eihdmsStandard_rules.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsStandard_rules[i]);
		}
		System.out.println(length + " Standard_rule record(s) retrieved."); 
		
		System.out.println("Listing User_detail by Criteria...");
		eihdms.User_detailCriteria leihdmsUser_detailCriteria = new eihdms.User_detailCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsUser_detailCriteria.user_detail_id.eq();
		leihdmsUser_detailCriteria.setMaxResults(ROW_COUNT);
		eihdms.User_detail[] eihdmsUser_details = leihdmsUser_detailCriteria.listUser_detail();
		length =eihdmsUser_details== null ? 0 : Math.min(eihdmsUser_details.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsUser_details[i]);
		}
		System.out.println(length + " User_detail record(s) retrieved."); 
		
		System.out.println("Listing Group_user by Criteria...");
		eihdms.Group_userCriteria leihdmsGroup_userCriteria = new eihdms.Group_userCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsGroup_userCriteria.group_user_id.eq();
		leihdmsGroup_userCriteria.setMaxResults(ROW_COUNT);
		eihdms.Group_user[] eihdmsGroup_users = leihdmsGroup_userCriteria.listGroup_user();
		length =eihdmsGroup_users== null ? 0 : Math.min(eihdmsGroup_users.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsGroup_users[i]);
		}
		System.out.println(length + " Group_user record(s) retrieved."); 
		
		System.out.println("Listing User_category by Criteria...");
		eihdms.User_categoryCriteria leihdmsUser_categoryCriteria = new eihdms.User_categoryCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsUser_categoryCriteria.user_category_id.eq();
		leihdmsUser_categoryCriteria.setMaxResults(ROW_COUNT);
		eihdms.User_category[] eihdmsUser_categorys = leihdmsUser_categoryCriteria.listUser_category();
		length =eihdmsUser_categorys== null ? 0 : Math.min(eihdmsUser_categorys.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsUser_categorys[i]);
		}
		System.out.println(length + " User_category record(s) retrieved."); 
		
		System.out.println("Listing Group_detail by Criteria...");
		eihdms.Group_detailCriteria leihdmsGroup_detailCriteria = new eihdms.Group_detailCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsGroup_detailCriteria.group_detail_id.eq();
		leihdmsGroup_detailCriteria.setMaxResults(ROW_COUNT);
		eihdms.Group_detail[] eihdmsGroup_details = leihdmsGroup_detailCriteria.listGroup_detail();
		length =eihdmsGroup_details== null ? 0 : Math.min(eihdmsGroup_details.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsGroup_details[i]);
		}
		System.out.println(length + " Group_detail record(s) retrieved."); 
		
		System.out.println("Listing Login_session by Criteria...");
		eihdms.Login_sessionCriteria leihdmsLogin_sessionCriteria = new eihdms.Login_sessionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsLogin_sessionCriteria.login_session_id.eq();
		leihdmsLogin_sessionCriteria.setMaxResults(ROW_COUNT);
		eihdms.Login_session[] eihdmsLogin_sessions = leihdmsLogin_sessionCriteria.listLogin_session();
		length =eihdmsLogin_sessions== null ? 0 : Math.min(eihdmsLogin_sessions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsLogin_sessions[i]);
		}
		System.out.println(length + " Login_session record(s) retrieved."); 
		
		System.out.println("Listing User_action by Criteria...");
		eihdms.User_actionCriteria leihdmsUser_actionCriteria = new eihdms.User_actionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsUser_actionCriteria.user_action_id.eq();
		leihdmsUser_actionCriteria.setMaxResults(ROW_COUNT);
		eihdms.User_action[] eihdmsUser_actions = leihdmsUser_actionCriteria.listUser_action();
		length =eihdmsUser_actions== null ? 0 : Math.min(eihdmsUser_actions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsUser_actions[i]);
		}
		System.out.println(length + " User_action record(s) retrieved."); 
		
		System.out.println("Listing Technical_area by Criteria...");
		eihdms.Technical_areaCriteria leihdmsTechnical_areaCriteria = new eihdms.Technical_areaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsTechnical_areaCriteria.technical_area_id.eq();
		leihdmsTechnical_areaCriteria.setMaxResults(ROW_COUNT);
		eihdms.Technical_area[] eihdmsTechnical_areas = leihdmsTechnical_areaCriteria.listTechnical_area();
		length =eihdmsTechnical_areas== null ? 0 : Math.min(eihdmsTechnical_areas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsTechnical_areas[i]);
		}
		System.out.println(length + " Technical_area record(s) retrieved."); 
		
		System.out.println("Listing Sub_section by Criteria...");
		eihdms.Sub_sectionCriteria leihdmsSub_sectionCriteria = new eihdms.Sub_sectionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsSub_sectionCriteria.sub_section_id.eq();
		leihdmsSub_sectionCriteria.setMaxResults(ROW_COUNT);
		eihdms.Sub_section[] eihdmsSub_sections = leihdmsSub_sectionCriteria.listSub_section();
		length =eihdmsSub_sections== null ? 0 : Math.min(eihdmsSub_sections.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsSub_sections[i]);
		}
		System.out.println(length + " Sub_section record(s) retrieved."); 
		
		System.out.println("Listing Report_form_group by Criteria...");
		eihdms.Report_form_groupCriteria leihdmsReport_form_groupCriteria = new eihdms.Report_form_groupCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsReport_form_groupCriteria.report_form_group_id.eq();
		leihdmsReport_form_groupCriteria.setMaxResults(ROW_COUNT);
		eihdms.Report_form_group[] eihdmsReport_form_groups = leihdmsReport_form_groupCriteria.listReport_form_group();
		length =eihdmsReport_form_groups== null ? 0 : Math.min(eihdmsReport_form_groups.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsReport_form_groups[i]);
		}
		System.out.println(length + " Report_form_group record(s) retrieved."); 
		
		System.out.println("Listing Application_configuration by Criteria...");
		eihdms.Application_configurationCriteria leihdmsApplication_configurationCriteria = new eihdms.Application_configurationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsApplication_configurationCriteria.application_configuration_id.eq();
		leihdmsApplication_configurationCriteria.setMaxResults(ROW_COUNT);
		eihdms.Application_configuration[] eihdmsApplication_configurations = leihdmsApplication_configurationCriteria.listApplication_configuration();
		length =eihdmsApplication_configurations== null ? 0 : Math.min(eihdmsApplication_configurations.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsApplication_configurations[i]);
		}
		System.out.println(length + " Application_configuration record(s) retrieved."); 
		
		System.out.println("Listing Temp_data_element by Criteria...");
		eihdms.Temp_data_elementCriteria leihdmsTemp_data_elementCriteria = new eihdms.Temp_data_elementCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsTemp_data_elementCriteria.temp_data_element_id.eq();
		leihdmsTemp_data_elementCriteria.setMaxResults(ROW_COUNT);
		eihdms.Temp_data_element[] eihdmsTemp_data_elements = leihdmsTemp_data_elementCriteria.listTemp_data_element();
		length =eihdmsTemp_data_elements== null ? 0 : Math.min(eihdmsTemp_data_elements.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsTemp_data_elements[i]);
		}
		System.out.println(length + " Temp_data_element record(s) retrieved."); 
		
		System.out.println("Listing Temp_health_facility by Criteria...");
		eihdms.Temp_health_facilityCriteria leihdmsTemp_health_facilityCriteria = new eihdms.Temp_health_facilityCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsTemp_health_facilityCriteria.temp_health_facility_id.eq();
		leihdmsTemp_health_facilityCriteria.setMaxResults(ROW_COUNT);
		eihdms.Temp_health_facility[] eihdmsTemp_health_facilitys = leihdmsTemp_health_facilityCriteria.listTemp_health_facility();
		length =eihdmsTemp_health_facilitys== null ? 0 : Math.min(eihdmsTemp_health_facilitys.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsTemp_health_facilitys[i]);
		}
		System.out.println(length + " Temp_health_facility record(s) retrieved."); 
		
		System.out.println("Listing Financial_year by Criteria...");
		eihdms.Financial_yearCriteria leihdmsFinancial_yearCriteria = new eihdms.Financial_yearCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsFinancial_yearCriteria.financial_year_id.eq();
		leihdmsFinancial_yearCriteria.setMaxResults(ROW_COUNT);
		eihdms.Financial_year[] eihdmsFinancial_years = leihdmsFinancial_yearCriteria.listFinancial_year();
		length =eihdmsFinancial_years== null ? 0 : Math.min(eihdmsFinancial_years.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsFinancial_years[i]);
		}
		System.out.println(length + " Financial_year record(s) retrieved."); 
		
		System.out.println("Listing Batch by Criteria...");
		eihdms.BatchCriteria leihdmsBatchCriteria = new eihdms.BatchCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsBatchCriteria.batch_id.eq();
		leihdmsBatchCriteria.setMaxResults(ROW_COUNT);
		eihdms.Batch[] eihdmsBatchs = leihdmsBatchCriteria.listBatch();
		length =eihdmsBatchs== null ? 0 : Math.min(eihdmsBatchs.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsBatchs[i]);
		}
		System.out.println(length + " Batch record(s) retrieved."); 
		
		System.out.println("Listing Kpi by Criteria...");
		eihdms.KpiCriteria leihdmsKpiCriteria = new eihdms.KpiCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsKpiCriteria.kpi_id.eq();
		leihdmsKpiCriteria.setMaxResults(ROW_COUNT);
		eihdms.Kpi[] eihdmsKpis = leihdmsKpiCriteria.listKpi();
		length =eihdmsKpis== null ? 0 : Math.min(eihdmsKpis.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsKpis[i]);
		}
		System.out.println(length + " Kpi record(s) retrieved."); 
		
		System.out.println("Listing Data_obligation by Criteria...");
		eihdms.Data_obligationCriteria leihdmsData_obligationCriteria = new eihdms.Data_obligationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsData_obligationCriteria.data_obligation_id.eq();
		leihdmsData_obligationCriteria.setMaxResults(ROW_COUNT);
		eihdms.Data_obligation[] eihdmsData_obligations = leihdmsData_obligationCriteria.listData_obligation();
		length =eihdmsData_obligations== null ? 0 : Math.min(eihdmsData_obligations.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsData_obligations[i]);
		}
		System.out.println(length + " Data_obligation record(s) retrieved."); 
		
		System.out.println("Listing Base_data_deleted by Criteria...");
		eihdms.Base_data_deletedCriteria leihdmsBase_data_deletedCriteria = new eihdms.Base_data_deletedCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsBase_data_deletedCriteria.base_data_deleted_id.eq();
		leihdmsBase_data_deletedCriteria.setMaxResults(ROW_COUNT);
		eihdms.Base_data_deleted[] eihdmsBase_data_deleteds = leihdmsBase_data_deletedCriteria.listBase_data_deleted();
		length =eihdmsBase_data_deleteds== null ? 0 : Math.min(eihdmsBase_data_deleteds.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsBase_data_deleteds[i]);
		}
		System.out.println(length + " Base_data_deleted record(s) retrieved."); 
		
		System.out.println("Listing Interface_data_temp by Criteria...");
		eihdms.Interface_data_tempCriteria leihdmsInterface_data_tempCriteria = new eihdms.Interface_data_tempCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsInterface_data_tempCriteria.interface_data_temp_id.eq();
		leihdmsInterface_data_tempCriteria.setMaxResults(ROW_COUNT);
		eihdms.Interface_data_temp[] eihdmsInterface_data_temps = leihdmsInterface_data_tempCriteria.listInterface_data_temp();
		length =eihdmsInterface_data_temps== null ? 0 : Math.min(eihdmsInterface_data_temps.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsInterface_data_temps[i]);
		}
		System.out.println(length + " Interface_data_temp record(s) retrieved."); 
		
		System.out.println("Listing Validation_report by Criteria...");
		eihdms.Validation_reportCriteria leihdmsValidation_reportCriteria = new eihdms.Validation_reportCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsValidation_reportCriteria.validation_report_id.eq();
		leihdmsValidation_reportCriteria.setMaxResults(ROW_COUNT);
		eihdms.Validation_report[] eihdmsValidation_reports = leihdmsValidation_reportCriteria.listValidation_report();
		length =eihdmsValidation_reports== null ? 0 : Math.min(eihdmsValidation_reports.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsValidation_reports[i]);
		}
		System.out.println(length + " Validation_report record(s) retrieved."); 
		
		System.out.println("Listing Loaded_data_summary by Criteria...");
		eihdms.Loaded_data_summaryCriteria leihdmsLoaded_data_summaryCriteria = new eihdms.Loaded_data_summaryCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsLoaded_data_summaryCriteria.loaded_data_summary_id.eq();
		leihdmsLoaded_data_summaryCriteria.setMaxResults(ROW_COUNT);
		eihdms.Loaded_data_summary[] eihdmsLoaded_data_summarys = leihdmsLoaded_data_summaryCriteria.listLoaded_data_summary();
		length =eihdmsLoaded_data_summarys== null ? 0 : Math.min(eihdmsLoaded_data_summarys.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsLoaded_data_summarys[i]);
		}
		System.out.println(length + " Loaded_data_summary record(s) retrieved."); 
		
		System.out.println("Listing App_db_user_map by Criteria...");
		eihdms.App_db_user_mapCriteria leihdmsApp_db_user_mapCriteria = new eihdms.App_db_user_mapCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsApp_db_user_mapCriteria.app_db_user_map_id.eq();
		leihdmsApp_db_user_mapCriteria.setMaxResults(ROW_COUNT);
		eihdms.App_db_user_map[] eihdmsApp_db_user_maps = leihdmsApp_db_user_mapCriteria.listApp_db_user_map();
		length =eihdmsApp_db_user_maps== null ? 0 : Math.min(eihdmsApp_db_user_maps.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsApp_db_user_maps[i]);
		}
		System.out.println(length + " App_db_user_map record(s) retrieved."); 
		
		System.out.println("Listing Kpi_summary_function by Criteria...");
		eihdms.Kpi_summary_functionCriteria leihdmsKpi_summary_functionCriteria = new eihdms.Kpi_summary_functionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsKpi_summary_functionCriteria.kpi_summary_function_id.eq();
		leihdmsKpi_summary_functionCriteria.setMaxResults(ROW_COUNT);
		eihdms.Kpi_summary_function[] eihdmsKpi_summary_functions = leihdmsKpi_summary_functionCriteria.listKpi_summary_function();
		length =eihdmsKpi_summary_functions== null ? 0 : Math.min(eihdmsKpi_summary_functions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsKpi_summary_functions[i]);
		}
		System.out.println(length + " Kpi_summary_function record(s) retrieved."); 
		
		System.out.println("Listing Interface_data_sms by Criteria...");
		eihdms.Interface_data_smsCriteria leihdmsInterface_data_smsCriteria = new eihdms.Interface_data_smsCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsInterface_data_smsCriteria.interface_data_sms_id.eq();
		leihdmsInterface_data_smsCriteria.setMaxResults(ROW_COUNT);
		eihdms.Interface_data_sms[] eihdmsInterface_data_smses = leihdmsInterface_data_smsCriteria.listInterface_data_sms();
		length =eihdmsInterface_data_smses== null ? 0 : Math.min(eihdmsInterface_data_smses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsInterface_data_smses[i]);
		}
		System.out.println(length + " Interface_data_sms record(s) retrieved."); 
		
		System.out.println("Listing Phone_contact by Criteria...");
		eihdms.Phone_contactCriteria leihdmsPhone_contactCriteria = new eihdms.Phone_contactCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsPhone_contactCriteria.phone_contact_id.eq();
		leihdmsPhone_contactCriteria.setMaxResults(ROW_COUNT);
		eihdms.Phone_contact[] eihdmsPhone_contacts = leihdmsPhone_contactCriteria.listPhone_contact();
		length =eihdmsPhone_contacts== null ? 0 : Math.min(eihdmsPhone_contacts.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsPhone_contacts[i]);
		}
		System.out.println(length + " Phone_contact record(s) retrieved."); 
		
		System.out.println("Listing Data_element_sms_position by Criteria...");
		eihdms.Data_element_sms_positionCriteria leihdmsData_element_sms_positionCriteria = new eihdms.Data_element_sms_positionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsData_element_sms_positionCriteria.data_element_sms_position_id.eq();
		leihdmsData_element_sms_positionCriteria.setMaxResults(ROW_COUNT);
		eihdms.Data_element_sms_position[] eihdmsData_element_sms_positions = leihdmsData_element_sms_positionCriteria.listData_element_sms_position();
		length =eihdmsData_element_sms_positions== null ? 0 : Math.min(eihdmsData_element_sms_positions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsData_element_sms_positions[i]);
		}
		System.out.println(length + " Data_element_sms_position record(s) retrieved."); 
		
		System.out.println("Listing Report_form_short_code by Criteria...");
		eihdms.Report_form_short_codeCriteria leihdmsReport_form_short_codeCriteria = new eihdms.Report_form_short_codeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsReport_form_short_codeCriteria.report_form_short_code_id.eq();
		leihdmsReport_form_short_codeCriteria.setMaxResults(ROW_COUNT);
		eihdms.Report_form_short_code[] eihdmsReport_form_short_codes = leihdmsReport_form_short_codeCriteria.listReport_form_short_code();
		length =eihdmsReport_form_short_codes== null ? 0 : Math.min(eihdmsReport_form_short_codes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsReport_form_short_codes[i]);
		}
		System.out.println(length + " Report_form_short_code record(s) retrieved."); 
		
		System.out.println("Listing Organisation by Criteria...");
		eihdms.OrganisationCriteria leihdmsOrganisationCriteria = new eihdms.OrganisationCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsOrganisationCriteria.organisation_id.eq();
		leihdmsOrganisationCriteria.setMaxResults(ROW_COUNT);
		eihdms.Organisation[] eihdmsOrganisations = leihdmsOrganisationCriteria.listOrganisation();
		length =eihdmsOrganisations== null ? 0 : Math.min(eihdmsOrganisations.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsOrganisations[i]);
		}
		System.out.println(length + " Organisation record(s) retrieved."); 
		
		System.out.println("Listing Access_scope by Criteria...");
		eihdms.Access_scopeCriteria leihdmsAccess_scopeCriteria = new eihdms.Access_scopeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsAccess_scopeCriteria.access_scope_id.eq();
		leihdmsAccess_scopeCriteria.setMaxResults(ROW_COUNT);
		eihdms.Access_scope[] eihdmsAccess_scopes = leihdmsAccess_scopeCriteria.listAccess_scope();
		length =eihdmsAccess_scopes== null ? 0 : Math.min(eihdmsAccess_scopes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsAccess_scopes[i]);
		}
		System.out.println(length + " Access_scope record(s) retrieved."); 
		
		System.out.println("Listing Report_form_update by Criteria...");
		eihdms.Report_form_updateCriteria leihdmsReport_form_updateCriteria = new eihdms.Report_form_updateCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsReport_form_updateCriteria.report_form_update_id.eq();
		leihdmsReport_form_updateCriteria.setMaxResults(ROW_COUNT);
		eihdms.Report_form_update[] eihdmsReport_form_updates = leihdmsReport_form_updateCriteria.listReport_form_update();
		length =eihdmsReport_form_updates== null ? 0 : Math.min(eihdmsReport_form_updates.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsReport_form_updates[i]);
		}
		System.out.println(length + " Report_form_update record(s) retrieved."); 
		
		System.out.println("Listing Group_right by Criteria...");
		eihdms.Group_rightCriteria leihdmsGroup_rightCriteria = new eihdms.Group_rightCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsGroup_rightCriteria.group_right_id.eq();
		leihdmsGroup_rightCriteria.setMaxResults(ROW_COUNT);
		eihdms.Group_right[] eihdmsGroup_rights = leihdmsGroup_rightCriteria.listGroup_right();
		length =eihdmsGroup_rights== null ? 0 : Math.min(eihdmsGroup_rights.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsGroup_rights[i]);
		}
		System.out.println(length + " Group_right record(s) retrieved."); 
		
		System.out.println("Listing Report_form_deadline by Criteria...");
		eihdms.Report_form_deadlineCriteria leihdmsReport_form_deadlineCriteria = new eihdms.Report_form_deadlineCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsReport_form_deadlineCriteria.report_form_deadline_id.eq();
		leihdmsReport_form_deadlineCriteria.setMaxResults(ROW_COUNT);
		eihdms.Report_form_deadline[] eihdmsReport_form_deadlines = leihdmsReport_form_deadlineCriteria.listReport_form_deadline();
		length =eihdmsReport_form_deadlines== null ? 0 : Math.min(eihdmsReport_form_deadlines.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsReport_form_deadlines[i]);
		}
		System.out.println(length + " Report_form_deadline record(s) retrieved."); 
		
		System.out.println("Listing Report_form_entity by Criteria...");
		eihdms.Report_form_entityCriteria leihdmsReport_form_entityCriteria = new eihdms.Report_form_entityCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsReport_form_entityCriteria.report_form_entity_id.eq();
		leihdmsReport_form_entityCriteria.setMaxResults(ROW_COUNT);
		eihdms.Report_form_entity[] eihdmsReport_form_entitys = leihdmsReport_form_entityCriteria.listReport_form_entity();
		length =eihdmsReport_form_entitys== null ? 0 : Math.min(eihdmsReport_form_entitys.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsReport_form_entitys[i]);
		}
		System.out.println(length + " Report_form_entity record(s) retrieved."); 
		
		System.out.println("Listing Deadline_extension by Criteria...");
		eihdms.Deadline_extensionCriteria leihdmsDeadline_extensionCriteria = new eihdms.Deadline_extensionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsDeadline_extensionCriteria.deadline_extension_id.eq();
		leihdmsDeadline_extensionCriteria.setMaxResults(ROW_COUNT);
		eihdms.Deadline_extension[] eihdmsDeadline_extensions = leihdmsDeadline_extensionCriteria.listDeadline_extension();
		length =eihdmsDeadline_extensions== null ? 0 : Math.min(eihdmsDeadline_extensions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsDeadline_extensions[i]);
		}
		System.out.println(length + " Deadline_extension record(s) retrieved."); 
		
		System.out.println("Listing Sms_schedule by Criteria...");
		eihdms.Sms_scheduleCriteria leihdmsSms_scheduleCriteria = new eihdms.Sms_scheduleCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsSms_scheduleCriteria.sms_schedule_id.eq();
		leihdmsSms_scheduleCriteria.setMaxResults(ROW_COUNT);
		eihdms.Sms_schedule[] eihdmsSms_schedules = leihdmsSms_scheduleCriteria.listSms_schedule();
		length =eihdmsSms_schedules== null ? 0 : Math.min(eihdmsSms_schedules.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsSms_schedules[i]);
		}
		System.out.println(length + " Sms_schedule record(s) retrieved."); 
		
		System.out.println("Listing Sent_sms_log by Criteria...");
		eihdms.Sent_sms_logCriteria leihdmsSent_sms_logCriteria = new eihdms.Sent_sms_logCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsSent_sms_logCriteria.sent_sms_log_id.eq();
		leihdmsSent_sms_logCriteria.setMaxResults(ROW_COUNT);
		eihdms.Sent_sms_log[] eihdmsSent_sms_logs = leihdmsSent_sms_logCriteria.listSent_sms_log();
		length =eihdmsSent_sms_logs== null ? 0 : Math.min(eihdmsSent_sms_logs.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsSent_sms_logs[i]);
		}
		System.out.println(length + " Sent_sms_log record(s) retrieved."); 
		
		System.out.println("Listing Sms_recipient by Criteria...");
		eihdms.Sms_recipientCriteria leihdmsSms_recipientCriteria = new eihdms.Sms_recipientCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsSms_recipientCriteria.sms_recipient_id.eq();
		leihdmsSms_recipientCriteria.setMaxResults(ROW_COUNT);
		eihdms.Sms_recipient[] eihdmsSms_recipients = leihdmsSms_recipientCriteria.listSms_recipient();
		length =eihdmsSms_recipients== null ? 0 : Math.min(eihdmsSms_recipients.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsSms_recipients[i]);
		}
		System.out.println(length + " Sms_recipient record(s) retrieved."); 
		
		System.out.println("Listing Interface_data_mob_app by Criteria...");
		eihdms.Interface_data_mob_appCriteria leihdmsInterface_data_mob_appCriteria = new eihdms.Interface_data_mob_appCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsInterface_data_mob_appCriteria.interface_data_mob_app_id.eq();
		leihdmsInterface_data_mob_appCriteria.setMaxResults(ROW_COUNT);
		eihdms.Interface_data_mob_app[] eihdmsInterface_data_mob_apps = leihdmsInterface_data_mob_appCriteria.listInterface_data_mob_app();
		length =eihdmsInterface_data_mob_apps== null ? 0 : Math.min(eihdmsInterface_data_mob_apps.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsInterface_data_mob_apps[i]);
		}
		System.out.println(length + " Interface_data_mob_app record(s) retrieved."); 
		
		System.out.println("Listing Batch_mob_app by Criteria...");
		eihdms.Batch_mob_appCriteria leihdmsBatch_mob_appCriteria = new eihdms.Batch_mob_appCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsBatch_mob_appCriteria.batch_mob_app_id.eq();
		leihdmsBatch_mob_appCriteria.setMaxResults(ROW_COUNT);
		eihdms.Batch_mob_app[] eihdmsBatch_mob_apps = leihdmsBatch_mob_appCriteria.listBatch_mob_app();
		length =eihdmsBatch_mob_apps== null ? 0 : Math.min(eihdmsBatch_mob_apps.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsBatch_mob_apps[i]);
		}
		System.out.println(length + " Batch_mob_app record(s) retrieved."); 
		
		System.out.println("Listing Dashboard_surge by Criteria...");
		eihdms.Dashboard_surgeCriteria leihdmsDashboard_surgeCriteria = new eihdms.Dashboard_surgeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsDashboard_surgeCriteria.dashboard_surge_id.eq();
		leihdmsDashboard_surgeCriteria.setMaxResults(ROW_COUNT);
		eihdms.Dashboard_surge[] eihdmsDashboard_surges = leihdmsDashboard_surgeCriteria.listDashboard_surge();
		length =eihdmsDashboard_surges== null ? 0 : Math.min(eihdmsDashboard_surges.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsDashboard_surges[i]);
		}
		System.out.println(length + " Dashboard_surge record(s) retrieved."); 
		
		System.out.println("Listing Deadline_reminder by Criteria...");
		eihdms.Deadline_reminderCriteria leihdmsDeadline_reminderCriteria = new eihdms.Deadline_reminderCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsDeadline_reminderCriteria.deadline_reminder_id.eq();
		leihdmsDeadline_reminderCriteria.setMaxResults(ROW_COUNT);
		eihdms.Deadline_reminder[] eihdmsDeadline_reminders = leihdmsDeadline_reminderCriteria.listDeadline_reminder();
		length =eihdmsDeadline_reminders== null ? 0 : Math.min(eihdmsDeadline_reminders.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsDeadline_reminders[i]);
		}
		System.out.println(length + " Deadline_reminder record(s) retrieved."); 
		
		System.out.println("Listing Report_period_week by Criteria...");
		eihdms.Report_period_weekCriteria leihdmsReport_period_weekCriteria = new eihdms.Report_period_weekCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsReport_period_weekCriteria.report_period_week_id.eq();
		leihdmsReport_period_weekCriteria.setMaxResults(ROW_COUNT);
		eihdms.Report_period_week[] eihdmsReport_period_weeks = leihdmsReport_period_weekCriteria.listReport_period_week();
		length =eihdmsReport_period_weeks== null ? 0 : Math.min(eihdmsReport_period_weeks.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsReport_period_weeks[i]);
		}
		System.out.println(length + " Report_period_week record(s) retrieved."); 
		
		System.out.println("Listing Sms_category by Criteria...");
		eihdms.Sms_categoryCriteria leihdmsSms_categoryCriteria = new eihdms.Sms_categoryCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsSms_categoryCriteria.sms_category_id.eq();
		leihdmsSms_categoryCriteria.setMaxResults(ROW_COUNT);
		eihdms.Sms_category[] eihdmsSms_categorys = leihdmsSms_categoryCriteria.listSms_category();
		length =eihdmsSms_categorys== null ? 0 : Math.min(eihdmsSms_categorys.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsSms_categorys[i]);
		}
		System.out.println(length + " Sms_category record(s) retrieved."); 
		
		System.out.println("Listing Sub_section_cell by Criteria...");
		eihdms.Sub_section_cellCriteria leihdmsSub_section_cellCriteria = new eihdms.Sub_section_cellCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//leihdmsSub_section_cellCriteria.sub_section_cell_id.eq();
		leihdmsSub_section_cellCriteria.setMaxResults(ROW_COUNT);
		eihdms.Sub_section_cell[] eihdmsSub_section_cells = leihdmsSub_section_cellCriteria.listSub_section_cell();
		length =eihdmsSub_section_cells== null ? 0 : Math.min(eihdmsSub_section_cells.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(eihdmsSub_section_cells[i]);
		}
		System.out.println(length + " Sub_section_cell record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListArchitectureData listArchitectureData = new ListArchitectureData();
			try {
				listArchitectureData.listTestData();
				//listArchitectureData.listByCriteria();
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

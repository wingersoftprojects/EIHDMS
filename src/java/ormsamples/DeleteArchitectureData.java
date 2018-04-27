/**
 * Licensee: Ajuna Newton Brian
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class DeleteArchitectureData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = eihdms.EIHDMSPersistentManager.instance().getSession().beginTransaction();
		try {
			eihdms.Region leihdmsRegion = eihdms.Region.loadRegionByQuery(null, null);
			leihdmsRegion.delete();
			eihdms.District leihdmsDistrict = eihdms.District.loadDistrictByQuery(null, null);
			leihdmsDistrict.delete();
			eihdms.Sub_district leihdmsSub_district = eihdms.Sub_district.loadSub_districtByQuery(null, null);
			leihdmsSub_district.delete();
			eihdms.County leihdmsCounty = eihdms.County.loadCountyByQuery(null, null);
			leihdmsCounty.delete();
			eihdms.Sub_county leihdmsSub_county = eihdms.Sub_county.loadSub_countyByQuery(null, null);
			leihdmsSub_county.delete();
			eihdms.Parish leihdmsParish = eihdms.Parish.loadParishByQuery(null, null);
			leihdmsParish.delete();
			eihdms.Health_facility leihdmsHealth_facility = eihdms.Health_facility.loadHealth_facilityByQuery(null, null);
			leihdmsHealth_facility.delete();
			eihdms.Facility_level leihdmsFacility_level = eihdms.Facility_level.loadFacility_levelByQuery(null, null);
			leihdmsFacility_level.delete();
			eihdms.Report_form leihdmsReport_form = eihdms.Report_form.loadReport_formByQuery(null, null);
			leihdmsReport_form.delete();
			eihdms.Section leihdmsSection = eihdms.Section.loadSectionByQuery(null, null);
			leihdmsSection.delete();
			eihdms.Interface_data leihdmsInterface_data = eihdms.Interface_data.loadInterface_dataByQuery(null, null);
			leihdmsInterface_data.delete();
			eihdms.Data_element leihdmsData_element = eihdms.Data_element.loadData_elementByQuery(null, null);
			leihdmsData_element.delete();
			eihdms.Base_data leihdmsBase_data = eihdms.Base_data.loadBase_dataByQuery(null, null);
			leihdmsBase_data.delete();
			eihdms.Validation_rule leihdmsValidation_rule = eihdms.Validation_rule.loadValidation_ruleByQuery(null, null);
			leihdmsValidation_rule.delete();
			eihdms.Standard_rule leihdmsStandard_rule = eihdms.Standard_rule.loadStandard_ruleByQuery(null, null);
			leihdmsStandard_rule.delete();
			eihdms.User_detail leihdmsUser_detail = eihdms.User_detail.loadUser_detailByQuery(null, null);
			leihdmsUser_detail.delete();
			eihdms.Group_user leihdmsGroup_user = eihdms.Group_user.loadGroup_userByQuery(null, null);
			leihdmsGroup_user.delete();
			eihdms.User_category leihdmsUser_category = eihdms.User_category.loadUser_categoryByQuery(null, null);
			leihdmsUser_category.delete();
			eihdms.Group_detail leihdmsGroup_detail = eihdms.Group_detail.loadGroup_detailByQuery(null, null);
			leihdmsGroup_detail.delete();
			eihdms.Login_session leihdmsLogin_session = eihdms.Login_session.loadLogin_sessionByQuery(null, null);
			leihdmsLogin_session.delete();
			eihdms.User_action leihdmsUser_action = eihdms.User_action.loadUser_actionByQuery(null, null);
			leihdmsUser_action.delete();
			eihdms.Technical_area leihdmsTechnical_area = eihdms.Technical_area.loadTechnical_areaByQuery(null, null);
			leihdmsTechnical_area.delete();
			eihdms.Sub_section leihdmsSub_section = eihdms.Sub_section.loadSub_sectionByQuery(null, null);
			leihdmsSub_section.delete();
			eihdms.Report_form_group leihdmsReport_form_group = eihdms.Report_form_group.loadReport_form_groupByQuery(null, null);
			leihdmsReport_form_group.delete();
			eihdms.Application_configuration leihdmsApplication_configuration = eihdms.Application_configuration.loadApplication_configurationByQuery(null, null);
			leihdmsApplication_configuration.delete();
			eihdms.Temp_data_element leihdmsTemp_data_element = eihdms.Temp_data_element.loadTemp_data_elementByQuery(null, null);
			leihdmsTemp_data_element.delete();
			eihdms.Temp_health_facility leihdmsTemp_health_facility = eihdms.Temp_health_facility.loadTemp_health_facilityByQuery(null, null);
			leihdmsTemp_health_facility.delete();
			eihdms.Financial_year leihdmsFinancial_year = eihdms.Financial_year.loadFinancial_yearByQuery(null, null);
			leihdmsFinancial_year.delete();
			eihdms.Batch leihdmsBatch = eihdms.Batch.loadBatchByQuery(null, null);
			leihdmsBatch.delete();
			eihdms.Kpi leihdmsKpi = eihdms.Kpi.loadKpiByQuery(null, null);
			leihdmsKpi.delete();
			eihdms.Data_obligation leihdmsData_obligation = eihdms.Data_obligation.loadData_obligationByQuery(null, null);
			leihdmsData_obligation.delete();
			eihdms.Base_data_deleted leihdmsBase_data_deleted = eihdms.Base_data_deleted.loadBase_data_deletedByQuery(null, null);
			leihdmsBase_data_deleted.delete();
			eihdms.Interface_data_temp leihdmsInterface_data_temp = eihdms.Interface_data_temp.loadInterface_data_tempByQuery(null, null);
			leihdmsInterface_data_temp.delete();
			eihdms.Validation_report leihdmsValidation_report = eihdms.Validation_report.loadValidation_reportByQuery(null, null);
			leihdmsValidation_report.delete();
			eihdms.Loaded_data_summary leihdmsLoaded_data_summary = eihdms.Loaded_data_summary.loadLoaded_data_summaryByQuery(null, null);
			leihdmsLoaded_data_summary.delete();
			eihdms.App_db_user_map leihdmsApp_db_user_map = eihdms.App_db_user_map.loadApp_db_user_mapByQuery(null, null);
			leihdmsApp_db_user_map.delete();
			eihdms.Kpi_summary_function leihdmsKpi_summary_function = eihdms.Kpi_summary_function.loadKpi_summary_functionByQuery(null, null);
			leihdmsKpi_summary_function.delete();
			eihdms.Interface_data_sms leihdmsInterface_data_sms = eihdms.Interface_data_sms.loadInterface_data_smsByQuery(null, null);
			leihdmsInterface_data_sms.delete();
			eihdms.Phone_contact leihdmsPhone_contact = eihdms.Phone_contact.loadPhone_contactByQuery(null, null);
			leihdmsPhone_contact.delete();
			eihdms.Data_element_sms_position leihdmsData_element_sms_position = eihdms.Data_element_sms_position.loadData_element_sms_positionByQuery(null, null);
			leihdmsData_element_sms_position.delete();
			eihdms.Report_form_short_code leihdmsReport_form_short_code = eihdms.Report_form_short_code.loadReport_form_short_codeByQuery(null, null);
			leihdmsReport_form_short_code.delete();
			eihdms.Organisation leihdmsOrganisation = eihdms.Organisation.loadOrganisationByQuery(null, null);
			leihdmsOrganisation.delete();
			eihdms.Access_scope leihdmsAccess_scope = eihdms.Access_scope.loadAccess_scopeByQuery(null, null);
			leihdmsAccess_scope.delete();
			eihdms.Report_form_update leihdmsReport_form_update = eihdms.Report_form_update.loadReport_form_updateByQuery(null, null);
			leihdmsReport_form_update.delete();
			eihdms.Group_right leihdmsGroup_right = eihdms.Group_right.loadGroup_rightByQuery(null, null);
			leihdmsGroup_right.delete();
			eihdms.Report_form_deadline leihdmsReport_form_deadline = eihdms.Report_form_deadline.loadReport_form_deadlineByQuery(null, null);
			leihdmsReport_form_deadline.delete();
			eihdms.Report_form_entity leihdmsReport_form_entity = eihdms.Report_form_entity.loadReport_form_entityByQuery(null, null);
			leihdmsReport_form_entity.delete();
			eihdms.Deadline_extension leihdmsDeadline_extension = eihdms.Deadline_extension.loadDeadline_extensionByQuery(null, null);
			leihdmsDeadline_extension.delete();
			eihdms.Sms_schedule leihdmsSms_schedule = eihdms.Sms_schedule.loadSms_scheduleByQuery(null, null);
			leihdmsSms_schedule.delete();
			eihdms.Sent_sms_log leihdmsSent_sms_log = eihdms.Sent_sms_log.loadSent_sms_logByQuery(null, null);
			leihdmsSent_sms_log.delete();
			eihdms.Sms_recipient leihdmsSms_recipient = eihdms.Sms_recipient.loadSms_recipientByQuery(null, null);
			leihdmsSms_recipient.delete();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteArchitectureData deleteArchitectureData = new DeleteArchitectureData();
			try {
				deleteArchitectureData.deleteTestData();
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

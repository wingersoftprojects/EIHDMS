/**
 * Licensee: Ajuna Newton Brian
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateArchitectureData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = eihdms.EIHDMSPersistentManager.instance().getSession().beginTransaction();
		try {
			eihdms.Region leihdmsRegion = eihdms.Region.loadRegionByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsRegion.save();
			eihdms.District leihdmsDistrict = eihdms.District.loadDistrictByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsDistrict.save();
			eihdms.Sub_district leihdmsSub_district = eihdms.Sub_district.loadSub_districtByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsSub_district.save();
			eihdms.County leihdmsCounty = eihdms.County.loadCountyByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsCounty.save();
			eihdms.Sub_county leihdmsSub_county = eihdms.Sub_county.loadSub_countyByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsSub_county.save();
			eihdms.Parish leihdmsParish = eihdms.Parish.loadParishByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsParish.save();
			eihdms.Health_facility leihdmsHealth_facility = eihdms.Health_facility.loadHealth_facilityByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsHealth_facility.save();
			eihdms.Facility_level leihdmsFacility_level = eihdms.Facility_level.loadFacility_levelByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsFacility_level.save();
			eihdms.Report_form leihdmsReport_form = eihdms.Report_form.loadReport_formByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsReport_form.save();
			eihdms.Section leihdmsSection = eihdms.Section.loadSectionByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsSection.save();
			eihdms.Interface_data leihdmsInterface_data = eihdms.Interface_data.loadInterface_dataByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsInterface_data.save();
			eihdms.Data_element leihdmsData_element = eihdms.Data_element.loadData_elementByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsData_element.save();
			eihdms.Base_data leihdmsBase_data = eihdms.Base_data.loadBase_dataByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsBase_data.save();
			eihdms.Validation_rule leihdmsValidation_rule = eihdms.Validation_rule.loadValidation_ruleByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsValidation_rule.save();
			eihdms.Standard_rule leihdmsStandard_rule = eihdms.Standard_rule.loadStandard_ruleByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsStandard_rule.save();
			eihdms.User_detail leihdmsUser_detail = eihdms.User_detail.loadUser_detailByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsUser_detail.save();
			eihdms.Group_user leihdmsGroup_user = eihdms.Group_user.loadGroup_userByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsGroup_user.save();
			eihdms.User_category leihdmsUser_category = eihdms.User_category.loadUser_categoryByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsUser_category.save();
			eihdms.Group_detail leihdmsGroup_detail = eihdms.Group_detail.loadGroup_detailByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsGroup_detail.save();
			eihdms.Login_session leihdmsLogin_session = eihdms.Login_session.loadLogin_sessionByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsLogin_session.save();
			eihdms.User_action leihdmsUser_action = eihdms.User_action.loadUser_actionByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsUser_action.save();
			eihdms.Technical_area leihdmsTechnical_area = eihdms.Technical_area.loadTechnical_areaByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsTechnical_area.save();
			eihdms.Sub_section leihdmsSub_section = eihdms.Sub_section.loadSub_sectionByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsSub_section.save();
			eihdms.Report_form_group leihdmsReport_form_group = eihdms.Report_form_group.loadReport_form_groupByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsReport_form_group.save();
			eihdms.Application_configuration leihdmsApplication_configuration = eihdms.Application_configuration.loadApplication_configurationByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsApplication_configuration.save();
			eihdms.Temp_data_element leihdmsTemp_data_element = eihdms.Temp_data_element.loadTemp_data_elementByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsTemp_data_element.save();
			eihdms.Temp_health_facility leihdmsTemp_health_facility = eihdms.Temp_health_facility.loadTemp_health_facilityByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsTemp_health_facility.save();
			eihdms.Financial_year leihdmsFinancial_year = eihdms.Financial_year.loadFinancial_yearByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsFinancial_year.save();
			eihdms.Batch leihdmsBatch = eihdms.Batch.loadBatchByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsBatch.save();
			eihdms.Kpi leihdmsKpi = eihdms.Kpi.loadKpiByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsKpi.save();
			eihdms.Data_obligation leihdmsData_obligation = eihdms.Data_obligation.loadData_obligationByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsData_obligation.save();
			eihdms.Base_data_deleted leihdmsBase_data_deleted = eihdms.Base_data_deleted.loadBase_data_deletedByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsBase_data_deleted.save();
			eihdms.Interface_data_temp leihdmsInterface_data_temp = eihdms.Interface_data_temp.loadInterface_data_tempByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsInterface_data_temp.save();
			eihdms.Validation_report leihdmsValidation_report = eihdms.Validation_report.loadValidation_reportByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsValidation_report.save();
			eihdms.Loaded_data_summary leihdmsLoaded_data_summary = eihdms.Loaded_data_summary.loadLoaded_data_summaryByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsLoaded_data_summary.save();
			eihdms.App_db_user_map leihdmsApp_db_user_map = eihdms.App_db_user_map.loadApp_db_user_mapByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsApp_db_user_map.save();
			eihdms.Kpi_summary_function leihdmsKpi_summary_function = eihdms.Kpi_summary_function.loadKpi_summary_functionByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsKpi_summary_function.save();
			eihdms.Interface_data_sms leihdmsInterface_data_sms = eihdms.Interface_data_sms.loadInterface_data_smsByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsInterface_data_sms.save();
			eihdms.Phone_contact leihdmsPhone_contact = eihdms.Phone_contact.loadPhone_contactByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsPhone_contact.save();
			eihdms.Data_element_sms_position leihdmsData_element_sms_position = eihdms.Data_element_sms_position.loadData_element_sms_positionByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsData_element_sms_position.save();
			eihdms.Report_form_short_code leihdmsReport_form_short_code = eihdms.Report_form_short_code.loadReport_form_short_codeByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsReport_form_short_code.save();
			eihdms.Organisation leihdmsOrganisation = eihdms.Organisation.loadOrganisationByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsOrganisation.save();
			eihdms.Access_scope leihdmsAccess_scope = eihdms.Access_scope.loadAccess_scopeByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsAccess_scope.save();
			eihdms.Report_form_update leihdmsReport_form_update = eihdms.Report_form_update.loadReport_form_updateByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsReport_form_update.save();
			eihdms.Group_right leihdmsGroup_right = eihdms.Group_right.loadGroup_rightByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsGroup_right.save();
			eihdms.Report_form_deadline leihdmsReport_form_deadline = eihdms.Report_form_deadline.loadReport_form_deadlineByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsReport_form_deadline.save();
			eihdms.Report_form_entity leihdmsReport_form_entity = eihdms.Report_form_entity.loadReport_form_entityByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsReport_form_entity.save();
			eihdms.Deadline_extension leihdmsDeadline_extension = eihdms.Deadline_extension.loadDeadline_extensionByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsDeadline_extension.save();
			eihdms.Sms_schedule leihdmsSms_schedule = eihdms.Sms_schedule.loadSms_scheduleByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsSms_schedule.save();
			eihdms.Sent_sms_log leihdmsSent_sms_log = eihdms.Sent_sms_log.loadSent_sms_logByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsSent_sms_log.save();
			eihdms.Sms_recipient leihdmsSms_recipient = eihdms.Sms_recipient.loadSms_recipientByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsSms_recipient.save();
			eihdms.Interface_data_mob_app leihdmsInterface_data_mob_app = eihdms.Interface_data_mob_app.loadInterface_data_mob_appByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsInterface_data_mob_app.save();
			eihdms.Batch_mob_app leihdmsBatch_mob_app = eihdms.Batch_mob_app.loadBatch_mob_appByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsBatch_mob_app.save();
			eihdms.Dashboard_surge leihdmsDashboard_surge = eihdms.Dashboard_surge.loadDashboard_surgeByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsDashboard_surge.save();
			eihdms.Deadline_reminder leihdmsDeadline_reminder = eihdms.Deadline_reminder.loadDeadline_reminderByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsDeadline_reminder.save();
			eihdms.Report_period_week leihdmsReport_period_week = eihdms.Report_period_week.loadReport_period_weekByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsReport_period_week.save();
			eihdms.Sms_category leihdmsSms_category = eihdms.Sms_category.loadSms_categoryByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsSms_category.save();
			eihdms.Sub_section_cell leihdmsSub_section_cell = eihdms.Sub_section_cell.loadSub_section_cellByQuery(null, null);
			// Update the properties of the persistent object
			leihdmsSub_section_cell.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Region by RegionCriteria");
		eihdms.RegionCriteria leihdmsRegionCriteria = new eihdms.RegionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsRegionCriteria.region_id.eq();
		System.out.println(leihdmsRegionCriteria.uniqueRegion());
		
		System.out.println("Retrieving District by DistrictCriteria");
		eihdms.DistrictCriteria leihdmsDistrictCriteria = new eihdms.DistrictCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsDistrictCriteria.district_id.eq();
		System.out.println(leihdmsDistrictCriteria.uniqueDistrict());
		
		System.out.println("Retrieving Sub_district by Sub_districtCriteria");
		eihdms.Sub_districtCriteria leihdmsSub_districtCriteria = new eihdms.Sub_districtCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsSub_districtCriteria.sub_district_id.eq();
		System.out.println(leihdmsSub_districtCriteria.uniqueSub_district());
		
		System.out.println("Retrieving County by CountyCriteria");
		eihdms.CountyCriteria leihdmsCountyCriteria = new eihdms.CountyCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsCountyCriteria.county_id.eq();
		System.out.println(leihdmsCountyCriteria.uniqueCounty());
		
		System.out.println("Retrieving Sub_county by Sub_countyCriteria");
		eihdms.Sub_countyCriteria leihdmsSub_countyCriteria = new eihdms.Sub_countyCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsSub_countyCriteria.sub_county_id.eq();
		System.out.println(leihdmsSub_countyCriteria.uniqueSub_county());
		
		System.out.println("Retrieving Parish by ParishCriteria");
		eihdms.ParishCriteria leihdmsParishCriteria = new eihdms.ParishCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsParishCriteria.parish_id.eq();
		System.out.println(leihdmsParishCriteria.uniqueParish());
		
		System.out.println("Retrieving Health_facility by Health_facilityCriteria");
		eihdms.Health_facilityCriteria leihdmsHealth_facilityCriteria = new eihdms.Health_facilityCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsHealth_facilityCriteria.health_facility_id.eq();
		System.out.println(leihdmsHealth_facilityCriteria.uniqueHealth_facility());
		
		System.out.println("Retrieving Facility_level by Facility_levelCriteria");
		eihdms.Facility_levelCriteria leihdmsFacility_levelCriteria = new eihdms.Facility_levelCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsFacility_levelCriteria.facility_level_id.eq();
		System.out.println(leihdmsFacility_levelCriteria.uniqueFacility_level());
		
		System.out.println("Retrieving Report_form by Report_formCriteria");
		eihdms.Report_formCriteria leihdmsReport_formCriteria = new eihdms.Report_formCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsReport_formCriteria.report_form_id.eq();
		System.out.println(leihdmsReport_formCriteria.uniqueReport_form());
		
		System.out.println("Retrieving Section by SectionCriteria");
		eihdms.SectionCriteria leihdmsSectionCriteria = new eihdms.SectionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsSectionCriteria.section_id.eq();
		System.out.println(leihdmsSectionCriteria.uniqueSection());
		
		System.out.println("Retrieving Interface_data by Interface_dataCriteria");
		eihdms.Interface_dataCriteria leihdmsInterface_dataCriteria = new eihdms.Interface_dataCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsInterface_dataCriteria.interface_data_id.eq();
		System.out.println(leihdmsInterface_dataCriteria.uniqueInterface_data());
		
		System.out.println("Retrieving Data_element by Data_elementCriteria");
		eihdms.Data_elementCriteria leihdmsData_elementCriteria = new eihdms.Data_elementCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsData_elementCriteria.data_element_id.eq();
		System.out.println(leihdmsData_elementCriteria.uniqueData_element());
		
		System.out.println("Retrieving Base_data by Base_dataCriteria");
		eihdms.Base_dataCriteria leihdmsBase_dataCriteria = new eihdms.Base_dataCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsBase_dataCriteria.base_data_id.eq();
		System.out.println(leihdmsBase_dataCriteria.uniqueBase_data());
		
		System.out.println("Retrieving Validation_rule by Validation_ruleCriteria");
		eihdms.Validation_ruleCriteria leihdmsValidation_ruleCriteria = new eihdms.Validation_ruleCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsValidation_ruleCriteria.validation_rule_id.eq();
		System.out.println(leihdmsValidation_ruleCriteria.uniqueValidation_rule());
		
		System.out.println("Retrieving Standard_rule by Standard_ruleCriteria");
		eihdms.Standard_ruleCriteria leihdmsStandard_ruleCriteria = new eihdms.Standard_ruleCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsStandard_ruleCriteria.standard_rule_id.eq();
		System.out.println(leihdmsStandard_ruleCriteria.uniqueStandard_rule());
		
		System.out.println("Retrieving User_detail by User_detailCriteria");
		eihdms.User_detailCriteria leihdmsUser_detailCriteria = new eihdms.User_detailCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsUser_detailCriteria.user_detail_id.eq();
		System.out.println(leihdmsUser_detailCriteria.uniqueUser_detail());
		
		System.out.println("Retrieving Group_user by Group_userCriteria");
		eihdms.Group_userCriteria leihdmsGroup_userCriteria = new eihdms.Group_userCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsGroup_userCriteria.group_user_id.eq();
		System.out.println(leihdmsGroup_userCriteria.uniqueGroup_user());
		
		System.out.println("Retrieving User_category by User_categoryCriteria");
		eihdms.User_categoryCriteria leihdmsUser_categoryCriteria = new eihdms.User_categoryCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsUser_categoryCriteria.user_category_id.eq();
		System.out.println(leihdmsUser_categoryCriteria.uniqueUser_category());
		
		System.out.println("Retrieving Group_detail by Group_detailCriteria");
		eihdms.Group_detailCriteria leihdmsGroup_detailCriteria = new eihdms.Group_detailCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsGroup_detailCriteria.group_detail_id.eq();
		System.out.println(leihdmsGroup_detailCriteria.uniqueGroup_detail());
		
		System.out.println("Retrieving Login_session by Login_sessionCriteria");
		eihdms.Login_sessionCriteria leihdmsLogin_sessionCriteria = new eihdms.Login_sessionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsLogin_sessionCriteria.login_session_id.eq();
		System.out.println(leihdmsLogin_sessionCriteria.uniqueLogin_session());
		
		System.out.println("Retrieving User_action by User_actionCriteria");
		eihdms.User_actionCriteria leihdmsUser_actionCriteria = new eihdms.User_actionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsUser_actionCriteria.user_action_id.eq();
		System.out.println(leihdmsUser_actionCriteria.uniqueUser_action());
		
		System.out.println("Retrieving Technical_area by Technical_areaCriteria");
		eihdms.Technical_areaCriteria leihdmsTechnical_areaCriteria = new eihdms.Technical_areaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsTechnical_areaCriteria.technical_area_id.eq();
		System.out.println(leihdmsTechnical_areaCriteria.uniqueTechnical_area());
		
		System.out.println("Retrieving Sub_section by Sub_sectionCriteria");
		eihdms.Sub_sectionCriteria leihdmsSub_sectionCriteria = new eihdms.Sub_sectionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsSub_sectionCriteria.sub_section_id.eq();
		System.out.println(leihdmsSub_sectionCriteria.uniqueSub_section());
		
		System.out.println("Retrieving Report_form_group by Report_form_groupCriteria");
		eihdms.Report_form_groupCriteria leihdmsReport_form_groupCriteria = new eihdms.Report_form_groupCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsReport_form_groupCriteria.report_form_group_id.eq();
		System.out.println(leihdmsReport_form_groupCriteria.uniqueReport_form_group());
		
		System.out.println("Retrieving Application_configuration by Application_configurationCriteria");
		eihdms.Application_configurationCriteria leihdmsApplication_configurationCriteria = new eihdms.Application_configurationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsApplication_configurationCriteria.application_configuration_id.eq();
		System.out.println(leihdmsApplication_configurationCriteria.uniqueApplication_configuration());
		
		System.out.println("Retrieving Temp_data_element by Temp_data_elementCriteria");
		eihdms.Temp_data_elementCriteria leihdmsTemp_data_elementCriteria = new eihdms.Temp_data_elementCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsTemp_data_elementCriteria.temp_data_element_id.eq();
		System.out.println(leihdmsTemp_data_elementCriteria.uniqueTemp_data_element());
		
		System.out.println("Retrieving Temp_health_facility by Temp_health_facilityCriteria");
		eihdms.Temp_health_facilityCriteria leihdmsTemp_health_facilityCriteria = new eihdms.Temp_health_facilityCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsTemp_health_facilityCriteria.temp_health_facility_id.eq();
		System.out.println(leihdmsTemp_health_facilityCriteria.uniqueTemp_health_facility());
		
		System.out.println("Retrieving Financial_year by Financial_yearCriteria");
		eihdms.Financial_yearCriteria leihdmsFinancial_yearCriteria = new eihdms.Financial_yearCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsFinancial_yearCriteria.financial_year_id.eq();
		System.out.println(leihdmsFinancial_yearCriteria.uniqueFinancial_year());
		
		System.out.println("Retrieving Batch by BatchCriteria");
		eihdms.BatchCriteria leihdmsBatchCriteria = new eihdms.BatchCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsBatchCriteria.batch_id.eq();
		System.out.println(leihdmsBatchCriteria.uniqueBatch());
		
		System.out.println("Retrieving Kpi by KpiCriteria");
		eihdms.KpiCriteria leihdmsKpiCriteria = new eihdms.KpiCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsKpiCriteria.kpi_id.eq();
		System.out.println(leihdmsKpiCriteria.uniqueKpi());
		
		System.out.println("Retrieving Data_obligation by Data_obligationCriteria");
		eihdms.Data_obligationCriteria leihdmsData_obligationCriteria = new eihdms.Data_obligationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsData_obligationCriteria.data_obligation_id.eq();
		System.out.println(leihdmsData_obligationCriteria.uniqueData_obligation());
		
		System.out.println("Retrieving Base_data_deleted by Base_data_deletedCriteria");
		eihdms.Base_data_deletedCriteria leihdmsBase_data_deletedCriteria = new eihdms.Base_data_deletedCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsBase_data_deletedCriteria.base_data_deleted_id.eq();
		System.out.println(leihdmsBase_data_deletedCriteria.uniqueBase_data_deleted());
		
		System.out.println("Retrieving Interface_data_temp by Interface_data_tempCriteria");
		eihdms.Interface_data_tempCriteria leihdmsInterface_data_tempCriteria = new eihdms.Interface_data_tempCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsInterface_data_tempCriteria.interface_data_temp_id.eq();
		System.out.println(leihdmsInterface_data_tempCriteria.uniqueInterface_data_temp());
		
		System.out.println("Retrieving Validation_report by Validation_reportCriteria");
		eihdms.Validation_reportCriteria leihdmsValidation_reportCriteria = new eihdms.Validation_reportCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsValidation_reportCriteria.validation_report_id.eq();
		System.out.println(leihdmsValidation_reportCriteria.uniqueValidation_report());
		
		System.out.println("Retrieving Loaded_data_summary by Loaded_data_summaryCriteria");
		eihdms.Loaded_data_summaryCriteria leihdmsLoaded_data_summaryCriteria = new eihdms.Loaded_data_summaryCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsLoaded_data_summaryCriteria.loaded_data_summary_id.eq();
		System.out.println(leihdmsLoaded_data_summaryCriteria.uniqueLoaded_data_summary());
		
		System.out.println("Retrieving App_db_user_map by App_db_user_mapCriteria");
		eihdms.App_db_user_mapCriteria leihdmsApp_db_user_mapCriteria = new eihdms.App_db_user_mapCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsApp_db_user_mapCriteria.app_db_user_map_id.eq();
		System.out.println(leihdmsApp_db_user_mapCriteria.uniqueApp_db_user_map());
		
		System.out.println("Retrieving Kpi_summary_function by Kpi_summary_functionCriteria");
		eihdms.Kpi_summary_functionCriteria leihdmsKpi_summary_functionCriteria = new eihdms.Kpi_summary_functionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsKpi_summary_functionCriteria.kpi_summary_function_id.eq();
		System.out.println(leihdmsKpi_summary_functionCriteria.uniqueKpi_summary_function());
		
		System.out.println("Retrieving Interface_data_sms by Interface_data_smsCriteria");
		eihdms.Interface_data_smsCriteria leihdmsInterface_data_smsCriteria = new eihdms.Interface_data_smsCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsInterface_data_smsCriteria.interface_data_sms_id.eq();
		System.out.println(leihdmsInterface_data_smsCriteria.uniqueInterface_data_sms());
		
		System.out.println("Retrieving Phone_contact by Phone_contactCriteria");
		eihdms.Phone_contactCriteria leihdmsPhone_contactCriteria = new eihdms.Phone_contactCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsPhone_contactCriteria.phone_contact_id.eq();
		System.out.println(leihdmsPhone_contactCriteria.uniquePhone_contact());
		
		System.out.println("Retrieving Data_element_sms_position by Data_element_sms_positionCriteria");
		eihdms.Data_element_sms_positionCriteria leihdmsData_element_sms_positionCriteria = new eihdms.Data_element_sms_positionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsData_element_sms_positionCriteria.data_element_sms_position_id.eq();
		System.out.println(leihdmsData_element_sms_positionCriteria.uniqueData_element_sms_position());
		
		System.out.println("Retrieving Report_form_short_code by Report_form_short_codeCriteria");
		eihdms.Report_form_short_codeCriteria leihdmsReport_form_short_codeCriteria = new eihdms.Report_form_short_codeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsReport_form_short_codeCriteria.report_form_short_code_id.eq();
		System.out.println(leihdmsReport_form_short_codeCriteria.uniqueReport_form_short_code());
		
		System.out.println("Retrieving Organisation by OrganisationCriteria");
		eihdms.OrganisationCriteria leihdmsOrganisationCriteria = new eihdms.OrganisationCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsOrganisationCriteria.organisation_id.eq();
		System.out.println(leihdmsOrganisationCriteria.uniqueOrganisation());
		
		System.out.println("Retrieving Access_scope by Access_scopeCriteria");
		eihdms.Access_scopeCriteria leihdmsAccess_scopeCriteria = new eihdms.Access_scopeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsAccess_scopeCriteria.access_scope_id.eq();
		System.out.println(leihdmsAccess_scopeCriteria.uniqueAccess_scope());
		
		System.out.println("Retrieving Report_form_update by Report_form_updateCriteria");
		eihdms.Report_form_updateCriteria leihdmsReport_form_updateCriteria = new eihdms.Report_form_updateCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsReport_form_updateCriteria.report_form_update_id.eq();
		System.out.println(leihdmsReport_form_updateCriteria.uniqueReport_form_update());
		
		System.out.println("Retrieving Group_right by Group_rightCriteria");
		eihdms.Group_rightCriteria leihdmsGroup_rightCriteria = new eihdms.Group_rightCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsGroup_rightCriteria.group_right_id.eq();
		System.out.println(leihdmsGroup_rightCriteria.uniqueGroup_right());
		
		System.out.println("Retrieving Report_form_deadline by Report_form_deadlineCriteria");
		eihdms.Report_form_deadlineCriteria leihdmsReport_form_deadlineCriteria = new eihdms.Report_form_deadlineCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsReport_form_deadlineCriteria.report_form_deadline_id.eq();
		System.out.println(leihdmsReport_form_deadlineCriteria.uniqueReport_form_deadline());
		
		System.out.println("Retrieving Report_form_entity by Report_form_entityCriteria");
		eihdms.Report_form_entityCriteria leihdmsReport_form_entityCriteria = new eihdms.Report_form_entityCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsReport_form_entityCriteria.report_form_entity_id.eq();
		System.out.println(leihdmsReport_form_entityCriteria.uniqueReport_form_entity());
		
		System.out.println("Retrieving Deadline_extension by Deadline_extensionCriteria");
		eihdms.Deadline_extensionCriteria leihdmsDeadline_extensionCriteria = new eihdms.Deadline_extensionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsDeadline_extensionCriteria.deadline_extension_id.eq();
		System.out.println(leihdmsDeadline_extensionCriteria.uniqueDeadline_extension());
		
		System.out.println("Retrieving Sms_schedule by Sms_scheduleCriteria");
		eihdms.Sms_scheduleCriteria leihdmsSms_scheduleCriteria = new eihdms.Sms_scheduleCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsSms_scheduleCriteria.sms_schedule_id.eq();
		System.out.println(leihdmsSms_scheduleCriteria.uniqueSms_schedule());
		
		System.out.println("Retrieving Sent_sms_log by Sent_sms_logCriteria");
		eihdms.Sent_sms_logCriteria leihdmsSent_sms_logCriteria = new eihdms.Sent_sms_logCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsSent_sms_logCriteria.sent_sms_log_id.eq();
		System.out.println(leihdmsSent_sms_logCriteria.uniqueSent_sms_log());
		
		System.out.println("Retrieving Sms_recipient by Sms_recipientCriteria");
		eihdms.Sms_recipientCriteria leihdmsSms_recipientCriteria = new eihdms.Sms_recipientCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsSms_recipientCriteria.sms_recipient_id.eq();
		System.out.println(leihdmsSms_recipientCriteria.uniqueSms_recipient());
		
		System.out.println("Retrieving Interface_data_mob_app by Interface_data_mob_appCriteria");
		eihdms.Interface_data_mob_appCriteria leihdmsInterface_data_mob_appCriteria = new eihdms.Interface_data_mob_appCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsInterface_data_mob_appCriteria.interface_data_mob_app_id.eq();
		System.out.println(leihdmsInterface_data_mob_appCriteria.uniqueInterface_data_mob_app());
		
		System.out.println("Retrieving Batch_mob_app by Batch_mob_appCriteria");
		eihdms.Batch_mob_appCriteria leihdmsBatch_mob_appCriteria = new eihdms.Batch_mob_appCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsBatch_mob_appCriteria.batch_mob_app_id.eq();
		System.out.println(leihdmsBatch_mob_appCriteria.uniqueBatch_mob_app());
		
		System.out.println("Retrieving Dashboard_surge by Dashboard_surgeCriteria");
		eihdms.Dashboard_surgeCriteria leihdmsDashboard_surgeCriteria = new eihdms.Dashboard_surgeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsDashboard_surgeCriteria.dashboard_surge_id.eq();
		System.out.println(leihdmsDashboard_surgeCriteria.uniqueDashboard_surge());
		
		System.out.println("Retrieving Deadline_reminder by Deadline_reminderCriteria");
		eihdms.Deadline_reminderCriteria leihdmsDeadline_reminderCriteria = new eihdms.Deadline_reminderCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsDeadline_reminderCriteria.deadline_reminder_id.eq();
		System.out.println(leihdmsDeadline_reminderCriteria.uniqueDeadline_reminder());
		
		System.out.println("Retrieving Report_period_week by Report_period_weekCriteria");
		eihdms.Report_period_weekCriteria leihdmsReport_period_weekCriteria = new eihdms.Report_period_weekCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsReport_period_weekCriteria.report_period_week_id.eq();
		System.out.println(leihdmsReport_period_weekCriteria.uniqueReport_period_week());
		
		System.out.println("Retrieving Sms_category by Sms_categoryCriteria");
		eihdms.Sms_categoryCriteria leihdmsSms_categoryCriteria = new eihdms.Sms_categoryCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsSms_categoryCriteria.sms_category_id.eq();
		System.out.println(leihdmsSms_categoryCriteria.uniqueSms_category());
		
		System.out.println("Retrieving Sub_section_cell by Sub_section_cellCriteria");
		eihdms.Sub_section_cellCriteria leihdmsSub_section_cellCriteria = new eihdms.Sub_section_cellCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//leihdmsSub_section_cellCriteria.sub_section_cell_id.eq();
		System.out.println(leihdmsSub_section_cellCriteria.uniqueSub_section_cell());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateArchitectureData retrieveAndUpdateArchitectureData = new RetrieveAndUpdateArchitectureData();
			try {
				retrieveAndUpdateArchitectureData.retrieveAndUpdateTestData();
				//retrieveAndUpdateArchitectureData.retrieveByCriteria();
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

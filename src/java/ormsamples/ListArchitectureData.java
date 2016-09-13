/**
 * Licensee: bajuna
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
		
		System.out.println("Listing Group_right...");
		eihdms.Group_right[] eihdmsGroup_rights = eihdms.Group_right.listGroup_rightByQuery(null, null);
		length = Math.min(eihdmsGroup_rights.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(eihdmsGroup_rights[i]);
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

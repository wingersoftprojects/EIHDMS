/**
 * Licensee: btwesigye
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
			eihdms.Group_right leihdmsGroup_right = eihdms.Group_right.loadGroup_rightByQuery(null, null);
			leihdmsGroup_right.delete();
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
			eihdms.Kpi_data_element leihdmsKpi_data_element = eihdms.Kpi_data_element.loadKpi_data_elementByQuery(null, null);
			leihdmsKpi_data_element.delete();
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

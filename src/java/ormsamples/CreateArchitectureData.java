/**
 * Licensee: bajuna
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
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : validation_rule, report_form_group, user_action, group_right, section, data_element, is_active, is_deleted, lowest_report_form_level, report_form_frequency, report_form_name, report_form_code
			leihdmsReport_form.save();
			eihdms.Section leihdmsSection = eihdms.Section.createSection();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : sub_section, data_element, is_active, is_deleted, report_form, section_order, section_name
			leihdmsSection.save();
			eihdms.Interface_data leihdmsInterface_data = eihdms.Interface_data.createInterface_data();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, report_period_name, report_period_to_date, report_period_from_date, data_element_value, data_element
			leihdmsInterface_data.save();
			eihdms.Data_element leihdmsData_element = eihdms.Data_element.createData_element();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : kpi_data_element, standard_rule, base_data, interface_data, is_active, is_deleted, sub_section, section, report_form
			leihdmsData_element.save();
			eihdms.Base_data leihdmsBase_data = eihdms.Base_data.createBase_data();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, report_period_name, report_period_to_date, report_period_from_date, data_element_value, data_element
			leihdmsBase_data.save();
			eihdms.Validation_rule leihdmsValidation_rule = eihdms.Validation_rule.createValidation_rule();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, validation_rule_formula, validation_rule_name, report_form_group, report_form
			leihdmsValidation_rule.save();
			eihdms.Standard_rule leihdmsStandard_rule = eihdms.Standard_rule.createStandard_rule();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, data_element, standard_rule_name
			leihdmsStandard_rule.save();
			eihdms.Group_right leihdmsGroup_right = eihdms.Group_right.createGroup_right();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : add_by, add_date, is_active, is_deleted, allow_delete, allow_edit, allow_add, allow_view, report_form, group_detail
			leihdmsGroup_right.save();
			eihdms.User_detail leihdmsUser_detail = eihdms.User_detail.createUser_detail();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : user_action, login_session, group_user, is_active, is_deleted, is_user_gen_admin, third_name, second_name, first_name, user_password, user_name
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
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : remote_user, remote_host, remote_ip, add_date, session_id, user_detail, login_session_id
			leihdmsLogin_session.save();
			eihdms.User_action leihdmsUser_action = eihdms.User_action.createUser_action();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : action_date, action, form_template, user_detail
			leihdmsUser_action.save();
			eihdms.Technical_area leihdmsTechnical_area = eihdms.Technical_area.createTechnical_area();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, description, technical_area_name
			leihdmsTechnical_area.save();
			eihdms.Sub_section leihdmsSub_section = eihdms.Sub_section.createSub_section();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : data_element, is_active, is_deleted, section, sub_section_order, sub_section_name
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
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : facility_level_name, parish_name, sub_county_name, county_name, sub_district_name, district_name, region_name, health_facility_name
			leihdmsTemp_health_facility.save();
			eihdms.Financial_year leihdmsFinancial_year = eihdms.Financial_year.createFinancial_year();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, financial_year_name
			leihdmsFinancial_year.save();
			eihdms.Batch leihdmsBatch = eihdms.Batch.createBatch();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted
			leihdmsBatch.save();
			eihdms.Kpi leihdmsKpi = eihdms.Kpi.createKpi();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : kpi_data_element, is_active, is_deleted
			leihdmsKpi.save();
			eihdms.Kpi_data_element leihdmsKpi_data_element = eihdms.Kpi_data_element.createKpi_data_element();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : is_active, is_deleted, data_element, kpi
			leihdmsKpi_data_element.save();
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

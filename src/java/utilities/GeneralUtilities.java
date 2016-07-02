/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import eihdms.County;
import eihdms.Data_element;
import eihdms.District;
import eihdms.EIHDMSPersistentManager;
import eihdms.Facility_level;
import eihdms.Health_facility;
import eihdms.Parish;
import eihdms.Region;
import eihdms.Report_form;
import eihdms.Report_form_group;
import eihdms.Section;
import eihdms.Sub_county;
import eihdms.Sub_district;
import eihdms.Sub_section;
import eihdms.Technical_area;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class GeneralUtilities implements Serializable {

    private Report_form report_form_to_load_dependancies;

    public Report_form getReport_form_to_load_dependancies() {
        return report_form_to_load_dependancies;
    }

    public void setReport_form_to_load_dependancies(Report_form report_form_to_load_dependancies) {
        this.report_form_to_load_dependancies = report_form_to_load_dependancies;
    }

    public static void clearsession() {
        try {
            EIHDMSPersistentManager.instance().disposePersistentManager();
        } catch (PersistentException ex) {
            Logger.getLogger(GeneralUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void flushandclearsession() {
        try {
            EIHDMSPersistentManager.instance().getSession().flush();
            EIHDMSPersistentManager.instance().getSession().clear();
        } catch (PersistentException ex) {
            Logger.getLogger(GeneralUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("ddMMyyyyHmmss");
    }

    public static SimpleDateFormat simpleDateFormatDate() {
        return new SimpleDateFormat("yyyy-MM-ddd");
    }

    public String checkdoctype(String docurl) {
        if (docurl.toLowerCase().contains(".jpg") || docurl.toLowerCase().contains(".png") || docurl.toLowerCase().contains(".jpeg") || docurl.toLowerCase().contains(".gif")) {
            return "image";
        } else if (docurl.toLowerCase().contains(".pdf") || docurl.toLowerCase().contains(".PDF")) {
            return "pdf";
        } else if (docurl.toLowerCase().contains(".doc") || docurl.toLowerCase().contains(".docx")) {
            return "word";
        } else if (docurl.toLowerCase().contains(".xls") || docurl.toLowerCase().contains(".xlsx")) {
            return "excel";
        } else {
            return "";
        }
    }
    private final String currencyformat = "###,##0.0";

    public String getCurrencyformat() {
        return currencyformat;
    }

    public String convertYesNo(int value) {
        switch (value) {
            case 0:
                return "No";
            case 1:
                return "Yes";
            default:
                return "";
        }
    }

    public void load_data_element_dependancies(String report_form_name) {
        try {
            // TODO code application logic here
            PersistentTransaction t = EIHDMSPersistentManager.instance().getSession().beginTransaction();
            //String report_form_name = "HMIS 105";
            Report_form report_form = Report_form.loadReport_formByQuery("report_form_name='" + report_form_name + "'", null);
            if (report_form != null) {
                /**
                 * Report Form group
                 */
                List<Object[]> report_form_group_nameList = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT distinct report_form_group_name from temp_data_element where report_form_name='" + report_form_name + "' order by temp_data_element_id asc").list();
                int counter = 1;
                for (Object report_form_group_name : report_form_group_nameList) {
                    if (report_form_group_name != null) {
                        if (!report_form_group_name.toString().isEmpty()) {
                            Report_form_group report_form_group = Report_form_group.loadReport_form_groupByQuery("report_form_group_name='" + report_form_group_name + "' AND report_form_id=" + report_form.getReport_form_id(), null);
                            if (report_form_group == null) {
                                report_form_group = Report_form_group.createReport_form_group();
                                report_form_group.setReport_form(report_form);
                                report_form_group.setReport_form_group_name(report_form_group_name.toString());
                                report_form_group.setDescription(report_form_group_name.toString());
                                report_form_group.setGroup_order(counter);
                                report_form_group.setIs_active(1);
                                report_form_group.setIs_deleted(0);
                                report_form_group.setAdd_by(1);
                                report_form_group.setAdd_date(new Timestamp(new Date().getTime()));
                                report_form_group.save();
                            }
                        }
                    }
                    counter++;

                }
                /**
                 * Section
                 */
                List<Object[]> section_nameList = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT distinct section_name from temp_data_element where report_form_name='" + report_form_name + "' order by temp_data_element_id asc").list();
                counter = 0;
                for (Object section_name : section_nameList) {
                    if (section_name != null) {
                        if (!section_name.toString().isEmpty()) {
                            Section section = Section.loadSectionByQuery("section_name='" + section_name + "' AND report_form_id=" + report_form.getReport_form_id(), null);
                            if (section == null) {
                                section = Section.createSection();
                                section.setReport_form(report_form);
                                section.setSection_order(String.valueOf(counter));
                                section.setSection_name(section_name.toString());
                                section.setIs_active(1);
                                section.setIs_deleted(0);
                                section.setAdd_by(1);
                                section.setAdd_date(new Timestamp(new Date().getTime()));
                                section.save();
                            }
                            /**
                             * Sub Section
                             */
                            List<Object[]> sub_section_nameList = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT distinct sub_section_name from temp_data_element where section_name='" + section.getSection_name() + "' order by temp_data_element_id asc").list();
                            int sub_section_counter = 0;
                            for (Object sub_section_name : sub_section_nameList) {
                                if (sub_section_name != null) {
                                    if (!sub_section_name.toString().isEmpty()) {
                                        Sub_section sub_section = Sub_section.loadSub_sectionByQuery("sub_section_name='" + sub_section_name + "' AND section_id=" + section.getSection_id(), null);
                                        if (sub_section == null) {
                                            sub_section = Sub_section.createSub_section();
                                            sub_section.setSection(section);
                                            sub_section.setSub_section_order(String.valueOf(sub_section_counter));
                                            sub_section.setSub_section_name(sub_section_name.toString());
                                            sub_section.setIs_active(1);
                                            sub_section.setIs_deleted(0);
                                            sub_section.setAdd_by(1);
                                            sub_section.setAdd_date(new Timestamp(new Date().getTime()));
                                            sub_section.save();
                                        }
                                    }
                                }
                            }
                            sub_section_counter++;
                        }
                    }
                }
                counter++;
                /**
                 * Technical Area
                 */
                List<Object[]> technical_area_nameList = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT distinct technical_area_name from temp_data_element where report_form_name='" + report_form_name + "' order by temp_data_element_id asc").list();
                for (Object technical_area_name : technical_area_nameList) {
                    if (technical_area_name != null) {
                        if (!technical_area_name.toString().isEmpty()) {
                            Technical_area technical_area = Technical_area.loadTechnical_areaByQuery("technical_area_name='" + technical_area_name + "'", null);
                            if (technical_area == null) {
                                technical_area = Technical_area.createTechnical_area();
                                technical_area.setTechnical_area_name(technical_area_name.toString());
                                technical_area.setDescription(technical_area_name.toString());
                                technical_area.setIs_active(1);
                                technical_area.setIs_deleted(0);
                                technical_area.setAdd_by(1);
                                technical_area.setAdd_date(new Timestamp(new Date().getTime()));
                                technical_area.save();
                            }
                        }
                    }
                }
            } else {
                System.out.println("Please create the form first!");
            }
            t.commit();
            /**
             * Data Element
             */
            if (report_form != null) {
                List<Object[]> data_element_nameList = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT report_form_group_name,technical_area_name,section_column_number,group_column_number,data_element_name,data_type,data_size,age_category,sex_category,other_category,description,data_element_code,section_name,sub_section_name from temp_data_element where report_form_name='" + report_form.getReport_form_name() + "' order by temp_data_element_id asc").list();
                for (Object[] data_element_name : data_element_nameList) {
                    t = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                    if (data_element_name[4] != null) {
                        if (!data_element_name[4].toString().isEmpty()) {
                            Section section = Section.loadSectionByQuery("section_name='" + data_element_name[12] + "'", null);
                            Sub_section sub_section = Sub_section.loadSub_sectionByQuery("sub_section_name='" + data_element_name[13] + "'", null);
                            Data_element data_element = Data_element.loadData_elementByQuery("data_element_name='" + data_element_name[4].toString() + "' AND section_id=" + (section != null ? section.getSection_id() : 0) + " AND sub_section_id=" + (sub_section != null ? sub_section.getSub_section_id() : 0) + " AND report_form_id=" + report_form.getReport_form_id(), null);
                            if (data_element == null) {
                                data_element = Data_element.createData_element();
                                data_element.setReport_form_group(Report_form_group.loadReport_form_groupByQuery("report_form_group_name='" + data_element_name[0] + "' AND report_form_id=" + report_form.getReport_form_id(), null));
                                data_element.setTechnical_area(Technical_area.loadTechnical_areaByQuery("technical_area_name='" + data_element_name[1] + "'", null));
                                data_element.setSection_column_number(data_element_name[2] != null ? Integer.parseInt(data_element_name[2].toString()) : null);
                                data_element.setGroup_column_number(data_element_name[3] != null ? Integer.parseInt(data_element_name[3].toString()) : null);
                                data_element.setData_element_name(data_element_name[4] != null ? data_element_name[4].toString() : null);
                                data_element.setData_type(data_element_name[5] != null ? data_element_name[5].toString() : null);
                                data_element.setData_size(data_element_name[6] != null ? Integer.parseInt(data_element_name[6].toString()) : null);
                                data_element.setAge_category(data_element_name[7] != null ? data_element_name[7].toString() : null);
                                data_element.setSex_category(data_element_name[8] != null ? data_element_name[8].toString() : null);
                                data_element.setOther_category(data_element_name[9] != null ? data_element_name[9].toString() : null);
                                data_element.setOther_category(data_element_name[10] != null ? data_element_name[10].toString() : null);
                                data_element.setData_element_code(data_element_name[11] != null ? data_element_name[11].toString() : null);
                                data_element.setReport_form(report_form);
                                data_element.setSection(section);
                                data_element.setSub_section(sub_section);
                                data_element.setIs_active(1);
                                data_element.setIs_deleted(0);
                                data_element.setAdd_by(1);
                                data_element.setAdd_date(new Timestamp(new Date().getTime()));
                                data_element.save();
                            }
                        }
                    }
                    t.commit();

                }
            }
        } catch (PersistentException ex) {
            Logger.getLogger(GeneralUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void load_health_facility_dependancies() {
        try {
            // TODO code application logic here
            PersistentTransaction t = EIHDMSPersistentManager.instance().getSession().beginTransaction();
            /**
             * Section
             */
            List<Object[]> region_nameList = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT distinct region_name from temp_health_facility order by temp_health_facility_id asc").list();
            for (Object region_name : region_nameList) {
                if (region_name != null) {
                    if (!region_name.toString().isEmpty()) {
                        Region region = Region.loadRegionByQuery("region_name='" + region_name + "'", null);
                        if (region == null) {
                            region = Region.createRegion();
                            region.setRegion_name(region_name.toString());
                            region.setIs_active(1);
                            region.setIs_deleted(0);
                            region.setAdd_by(1);
                            region.setAdd_date(new Timestamp(new Date().getTime()));
                            region.save();
                        }
                        /**
                         * District
                         */
                        List<Object[]> districtList = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT distinct district_name from temp_health_facility where region_name='" + region.getRegion_name() + "' order by temp_health_facility_id asc").list();
                        for (Object district_name : districtList) {
                            if (district_name != null) {
                                if (!district_name.toString().isEmpty()) {
                                    District district = District.loadDistrictByQuery("district_name='" + district_name + "' AND region_id=" + region.getRegion_id(), null);
                                    if (district == null) {
                                        district = District.createDistrict();
                                        district.setRegion(region);
                                        district.setDistrict_name(district_name.toString());
                                        district.setIs_active(1);
                                        district.setIs_deleted(0);
                                        district.setAdd_by(1);
                                        district.setAdd_date(new Timestamp(new Date().getTime()));
                                        district.save();
                                    }
                                    /**
                                     * Sub_district
                                     */
                                    List<Object[]> sub_districtList = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT distinct sub_district_name from temp_health_facility where district_name='" + district.getDistrict_name() + "' order by temp_health_facility_id asc").list();
                                    for (Object sub_district_name : sub_districtList) {
                                        if (sub_district_name != null) {
                                            if (!sub_district_name.toString().isEmpty()) {
                                                Sub_district sub_district = Sub_district.loadSub_districtByQuery("sub_district_name='" + sub_district_name + "' AND district_id=" + district.getDistrict_id(), null);
                                                if (sub_district == null) {
                                                    sub_district = Sub_district.createSub_district();
                                                    sub_district.setDistrict(district);
                                                    sub_district.setSub_district_name(sub_district_name.toString());
                                                    sub_district.setIs_active(1);
                                                    sub_district.setIs_deleted(0);
                                                    sub_district.setAdd_by(1);
                                                    sub_district.setAdd_date(new Timestamp(new Date().getTime()));
                                                    sub_district.save();
                                                }
                                            }
                                        }
                                    }
                                    /**
                                     * County
                                     */
                                    List<Object[]> countyList = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT distinct county_name from temp_health_facility where district_name='" + district.getDistrict_name() + "' order by temp_health_facility_id asc").list();
                                    for (Object county_name : countyList) {
                                        if (county_name != null) {
                                            if (!county_name.toString().isEmpty()) {
                                                County county = County.loadCountyByQuery("county_name='" + county_name + "' AND district_id=" + district.getDistrict_id(), null);
                                                if (county == null) {
                                                    county = County.createCounty();
                                                    county.setDistrict(district);
                                                    county.setCounty_name(county_name.toString());
                                                    county.setIs_active(1);
                                                    county.setIs_deleted(0);
                                                    county.setAdd_by(1);
                                                    county.setAdd_date(new Timestamp(new Date().getTime()));
                                                    county.save();

                                                    /**
                                                     * Sub_sub_county
                                                     */
                                                    List<Object[]> sub_countyList = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT distinct sub_county_name from temp_health_facility where county_name='" + county.getCounty_name() + "' order by temp_health_facility_id asc").list();
                                                    for (Object sub_county_name : sub_countyList) {
                                                        if (sub_county_name != null) {
                                                            if (!sub_county_name.toString().isEmpty()) {
                                                                Sub_county sub_county = Sub_county.loadSub_countyByQuery("sub_county_name='" + sub_county_name + "' AND county_id=" + county.getCounty_id(), null);
                                                                if (sub_county == null) {
                                                                    sub_county = Sub_county.createSub_county();
                                                                    sub_county.setCounty(county);
                                                                    sub_county.setSub_county_name(sub_county_name.toString());
                                                                    sub_county.setIs_active(1);
                                                                    sub_county.setIs_deleted(0);
                                                                    sub_county.setAdd_by(1);
                                                                    sub_county.setAdd_date(new Timestamp(new Date().getTime()));
                                                                    sub_county.save();

                                                                    /**
                                                                     * Sub_parish
                                                                     */
                                                                    List<Object[]> parishList = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT distinct parish_name from temp_health_facility where sub_county_name='" + sub_county.getSub_county_name() + "' order by temp_health_facility_id asc").list();
                                                                    for (Object parish_name : parishList) {
                                                                        if (parish_name != null) {
                                                                            if (!parish_name.toString().isEmpty()) {
                                                                                Parish parish = Parish.loadParishByQuery("parish_name='" + parish_name + "' AND sub_county_id=" + sub_county.getSub_county_id(), null);
                                                                                if (parish == null) {
                                                                                    parish = Parish.createParish();
                                                                                    parish.setSub_county(sub_county);
                                                                                    parish.setParish_name(parish_name.toString());
                                                                                    parish.setIs_active(1);
                                                                                    parish.setIs_deleted(0);
                                                                                    parish.setAdd_by(1);
                                                                                    parish.setAdd_date(new Timestamp(new Date().getTime()));
                                                                                    parish.save();
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                /**
                 * Facility Level
                 */
                List<Object[]> facility_level_nameList = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT distinct facility_level_name from temp_health_facility order by temp_health_facility_id asc").list();
                for (Object facility_level_name : facility_level_nameList) {
                    if (facility_level_name != null) {
                        if (!facility_level_name.toString().isEmpty()) {
                            Facility_level facility_level = Facility_level.loadFacility_levelByQuery("facility_level_name='" + facility_level_name + "'", null);
                            if (facility_level == null) {
                                facility_level = Facility_level.createFacility_level();
                                facility_level.setFacility_level_name(facility_level_name.toString());
                                facility_level.setIs_active(1);
                                facility_level.setIs_deleted(0);
                                facility_level.setAdd_by(1);
                                facility_level.setAdd_date(new Timestamp(new Date().getTime()));
                                facility_level.save();
                            }
                        }
                    }
                }
                t.commit();

                /**
                 * Health Facility
                 */
                List<Object[]> health_facility_nameList = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT health_facility_name,sub_district_name,xcoordinate,ycoordinate,zcoordinate,district_name,county_name,sub_county_name,parish_name,facility_level_name,region_name from temp_health_facility order by temp_health_facility_id asc").list();
                for (Object[] health_facility_name : health_facility_nameList) {
                    t = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                    if (health_facility_name[0] != null) {
                        if (!health_facility_name[0].toString().isEmpty()) {
                            Region region = Region.loadRegionByQuery("region_name='" + health_facility_name[10].toString() + "'", null);
                            District district = District.loadDistrictByQuery("district_name='" + health_facility_name[5].toString() + "' AND region_id=" + (region != null ? region.getRegion_id(): 0), null);
                            County county = County.loadCountyByQuery("county_name='" + health_facility_name[6].toString() + "' AND district_id=" + (district != null ? district.getDistrict_id() : 0), null);
                            if(county==null){
                                System.out.println(health_facility_name[6].toString());
                            }
                            Sub_county sub_county = Sub_county.loadSub_countyByQuery("sub_county_name='" + health_facility_name[7].toString() + "' AND county_id=" + (county != null ? county.getCounty_id() : 0), null);
                            Parish parish = Parish.loadParishByQuery("parish_name='" + health_facility_name[8].toString() + "' AND sub_county_id=" + (sub_county != null ? sub_county.getSub_county_id() : 0), null);
                            Facility_level facility_level = Facility_level.loadFacility_levelByQuery("facility_level_name='" + health_facility_name[9].toString() + "'", null);
                            Health_facility health_facility = Health_facility.loadHealth_facilityByQuery("health_facility_name='" + health_facility_name[0].toString().replace("'", "''") + "' AND parish_id=" + (parish != null ? parish.getParish_id() : 0), null);
                            if (health_facility == null) {
                                health_facility = Health_facility.createHealth_facility();
                                health_facility.setSub_district(Sub_district.loadSub_districtByQuery("sub_district_name='" + health_facility_name[1] + "'", null));
                                health_facility.setRegion(region);
                                health_facility.setDistrict(district);
                                health_facility.setCounty(county);
                                health_facility.setSub_county(sub_county);
                                health_facility.setParish(parish);
                                health_facility.setFacility_level(facility_level);
                                health_facility.setHealth_facility_name(health_facility_name[0] != null ? ((String) health_facility_name[0]).replace("'", "''") : null);
                                health_facility.setXcoordinate(health_facility_name[2] != null ? (String) health_facility_name[2] : null);
                                health_facility.setYcoordinate(health_facility_name[3] != null ? (String) health_facility_name[3] : null);
                                health_facility.setZcoordinate(health_facility_name[4] != null ? (String) health_facility_name[4] : null);
                                health_facility.setIs_active(1);
                                health_facility.setIs_deleted(0);
                                health_facility.setAdd_by(1);
                                health_facility.setAdd_date(new Timestamp(new Date().getTime()));
                                health_facility.save();
                            }
                        }
                    }
                    t.commit();
                }

            }
        } catch (PersistentException ex) {
            Logger.getLogger(GeneralUtilities.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
}

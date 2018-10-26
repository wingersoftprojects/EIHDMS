/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import eihdms.Base_data;
import eihdms.Batch;
import eihdms.Batch_mob_app;
import eihdms.County;
import eihdms.Data_element;
import eihdms.Data_element_sms_position;
import eihdms.District;
import eihdms.EIHDMSPersistentManager;
import eihdms.Financial_year;
import eihdms.Health_facility;
import eihdms.Interface_data;
import eihdms.Interface_data_sms;
import eihdms.Parish;
import eihdms.Phone_contact;
import eihdms.Region;
import eihdms.Report_form;
import eihdms.Report_form_group;
import eihdms.Report_form_short_code;
import eihdms.Section;
import eihdms.Sub_county;
import eihdms.Sub_section;
import eihdms.User_detail;
import eihdms.Validation_rule;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.HibernateException;
import org.joda.time.DateTime;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;
import utilities.GeneralUtilities;
import utilities.Patient_Level_Data;
import utilities.SMSData;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class UploadBean implements Serializable {

    private JSONArray jSONArray;
    private List<String> rowdatas;
    private Report_form_group report_form_group;
    private Report_form report_form;
    private List<Report_form_group> report_form_groups;
    private List<Report_form> report_forms;
    private Date report_period_from_date;
    private Date report_period_to_date;
    private Financial_year financial_year;
    private Integer report_period_quarter;
    private String report_period_name;
    @ManagedProperty("#{interface_dataBean}")
    private Interface_dataBean interface_dataBean;
    @ManagedProperty("#{base_dataBean}")
    private Base_dataBean base_dataBean;
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    private Region region;
    private District district;
    private County county;
    private Sub_county sub_county;
    private Parish parish;
    private List<Data_element> data_elements;
    private Health_facility health_facility;

    private Integer report_period_year;
    private Integer report_period_month;
    private Integer report_period_week;
    private BatchDetails batchDetails;
    private Integer report_period_bi_month;
    private String insert_string;
    private String table_string;
    private String database_type = "MY SQL";

    private List<ValidationReport> validationReportList;
    private List<ValidationReport> validationReportListAll;
    private List<ValidationReport> validationReportSelected;
    private List<ValidationReport> validationReportFiltered;

    String report_form_name;
    List<String> report_form_nameList;

    private int passed;
    private int failed;

    private String ReportFormName;
    private String ReportFormGroupName;

    private District[] selectedDistricts;
    private Parish[] selectedParishes;
    private Health_facility[] selectedHealth_facilities;

    private Integer[] selectedYears;
    private Integer[] selectedMonths;
    private Integer[] selectedQuarters;
    private Integer[] selectedWeeks;
    private Integer[] selectedBiMonths;

    List<Section> sections;
    List<Sub_section> sub_sections;

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Sub_section> getSub_sections() {
        return sub_sections;
    }

    public void setSub_sections(List<Sub_section> sub_sections) {
        this.sub_sections = sub_sections;
    }

    public String getReportFormGroupName() {
        return ReportFormGroupName;
    }

    public void setReportFormGroupName(String ReportFormGroupName) {
        this.ReportFormGroupName = ReportFormGroupName;
    }

    public String getReportFormName() {
        return ReportFormName;
    }

    public void setReportFormName(String ReportFormName) {
        this.ReportFormName = ReportFormName;
    }

    public Integer[] getSelectedYears() {
        return selectedYears;
    }

    public void setSelectedYears(Integer[] selectedYears) {
        this.selectedYears = selectedYears;
    }

    public Integer[] getSelectedMonths() {
        return selectedMonths;
    }

    public void setSelectedMonths(Integer[] selectedMonths) {
        this.selectedMonths = selectedMonths;
    }

    public Integer[] getSelectedQuarters() {
        return selectedQuarters;
    }

    public void setSelectedQuarters(Integer[] selectedQuarters) {
        this.selectedQuarters = selectedQuarters;
    }

    public Integer[] getSelectedWeeks() {
        return selectedWeeks;
    }

    public void setSelectedWeeks(Integer[] selectedWeeks) {
        this.selectedWeeks = selectedWeeks;
    }

    public Integer[] getSelectedBiMonths() {
        return selectedBiMonths;
    }

    public void setSelectedBiMonths(Integer[] selectedBiMonths) {
        this.selectedBiMonths = selectedBiMonths;
    }

    private List<Interface_data> interface_datas;
    private List<Base_data> base_datas;
    private List<Object[]> base_data_objects;

    String BaseDataStr = "";

    public List<Object[]> getBase_data_objects() {
        return base_data_objects;
    }

    public void setBase_data_objects(List<Object[]> base_data_objects) {
        this.base_data_objects = base_data_objects;
    }

    private List<LocationHierarchy> locationHierarchyList;

    public List<LocationHierarchy> getLocationHierarchyList() {
        return locationHierarchyList;
    }

    public void setLocationHierarchyList(List<LocationHierarchy> locationHierarchyList) {
        this.locationHierarchyList = locationHierarchyList;
    }

    public List<ValidationReport> getValidationReportListAll() {
        return validationReportListAll;
    }

    public void setValidationReportListAll(List<ValidationReport> validationReportListAll) {
        this.validationReportListAll = validationReportListAll;
    }

    public String getBaseDataStr() {
        return BaseDataStr;
    }

    public void setBaseDataStr(String BaseDataStr) {
        this.BaseDataStr = BaseDataStr;
    }

    public List<Base_data> getBase_datas() {
        return base_datas;
    }

    public void setBase_datas(List<Base_data> base_datas) {
        this.base_datas = base_datas;
    }

    public District[] getSelectedDistricts() {
        return selectedDistricts;
    }

    public void setSelectedDistricts(District[] selectedDistricts) {
        this.selectedDistricts = selectedDistricts;
    }

    public Parish[] getSelectedParishes() {
        return selectedParishes;
    }

    public void setSelectedParishes(Parish[] selectedParishes) {
        this.selectedParishes = selectedParishes;
    }

    public Health_facility[] getSelectedHealth_facilities() {
        return selectedHealth_facilities;
    }

    public void setSelectedHealth_facilities(Health_facility[] selectedHealth_facilities) {
        this.selectedHealth_facilities = selectedHealth_facilities;
    }

    public List<District> getdistricts() {
        List<District> districtList = new ArrayList<>();
        try {
            districtList = District.queryDistrict("is_deleted=0", "district_name");
        } catch (PersistentException | NullPointerException ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(ex.getMessage(), ex.getMessage()));
        }
        return districtList;
    }

    public List<Parish> getparishes() {
        List<Parish> parishList = new ArrayList<>();
        try {
            parishList = Parish.queryParish("is_deleted=0 AND sub_county_id=" + sub_county.getSub_county_id(), "parish_name");
        } catch (PersistentException | NullPointerException ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(ex.getMessage(), ex.getMessage()));
        }
        return parishList;
    }

    public List<County> getts_county(District d) {
        List<County> temp = new ArrayList<>();
        try {
            if (d != null) {
                temp = (List<County>) EIHDMSPersistentManager.instance().getSession().createQuery("select c FROM County  c where c.is_deleted<>1 AND c.district=" + d.getDistrict_id()).list();
            } else {
                temp = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public List<Sub_county> getts_sub_county(County c) {
        List<Sub_county> temp = new ArrayList<>();
        try {
            if (c != null) {
                temp = (List<Sub_county>) EIHDMSPersistentManager.instance().getSession().createQuery("select sc FROM Sub_county  sc where sc.is_deleted<>1 AND sc.county=" + c.getCounty_id()).list();
            } else {
                temp = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public List<Parish> getts_parish(Sub_county sc) {
        List<Parish> temp = new ArrayList<>();
        try {
            if (sub_county != null) {
                temp = (List<Parish>) EIHDMSPersistentManager.instance().getSession().createQuery("select p FROM Parish  p where p.is_deleted<>1 AND p.sub_county=" + sc.getSub_county_id()).list();
            } else {
                temp = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public List<Health_facility> getts_health_facility(Sub_county sc) {
        List<Health_facility> temp = new ArrayList<>();
        try {
            if (sc != null) {
                temp = (List<Health_facility>) EIHDMSPersistentManager.instance().getSession().createQuery("select h FROM Health_facility  h where h.is_deleted<>1 AND h.sub_county=" + sc.getSub_county_id()).list();
            } else {
                temp = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public List<Health_facility> gethealth_facilities() {
        List<Health_facility> health_facilityList = new ArrayList<>();
        try {
            health_facilityList = Health_facility.queryHealth_facility("is_deleted=0 AND parish_id=" + parish.getParish_id(), "health_facility_name");
        } catch (PersistentException | NullPointerException ex) {
        }
        return health_facilityList;
    }

    public int getPassed() {
        return passed;
    }

    public void setPassed(int passed) {
        this.passed = passed;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }

    public String getReport_form_name() {
        return report_form_name;
    }

    public void setReport_form_name(String report_form_name) {
        this.report_form_name = report_form_name;
    }

    public List<String> getReport_form_nameList() {
        List<String> aList = new ArrayList<>();
        try {
            aList = EIHDMSPersistentManager.instance().getSession().createQuery("select distinct report_form_name from Temp_data_element").list();
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.report_form_nameList = aList;
        return report_form_nameList;
    }

    public void setReport_form_nameList(List<String> report_form_nameList) {
        this.report_form_nameList = report_form_nameList;
    }

    public boolean show_facility_level() {
        if (report_form == null) {
            return false;
        } else if (report_form.getLowest_report_form_level().equals("Facility")) {
            return true;
        }
        return false;
    }

    public boolean show_parish_level() {
        if (report_form == null) {
            return false;
        } else if (report_form.getLowest_report_form_level().equals("Parish")) {
            return true;
        }
        return false;
    }

    public boolean show_district_level() {
        if (report_form == null) {
            return false;
        } else if (report_form.getLowest_report_form_level().equals("District")) {
            return true;
        }
        return false;
    }

    public boolean showweekly() {
        if (report_form == null) {
            return false;
        } else if (report_form.getReport_form_frequency().equals("Weekly")) {
            return true;
        }
        return false;
    }

    public boolean showmonthly() {
        if (report_form == null) {
            return false;
        } else if (report_form.getReport_form_frequency().equals("Monthly") || report_form.getReport_form_frequency().equals("Weekly")) {
            return true;
        }
        return false;
    }

    public boolean showmonthly2() {
        if (report_form == null) {
            return false;
        } else if (report_form.getReport_form_frequency().equals("Monthly")) {
            return true;
        }
        return false;
    }

    public List<Integer> weeks() {
        List<Integer> temp = new ArrayList<>();
        for (int x = 1; x < 54; x++) {
            temp.add(x);
        }
        return temp;
    }

    public void get_date_from_other_periods() {
        if (report_form != null) {
            /**
             * Weekly
             */
            if (report_period_year != null && report_period_week != null && report_form.getReport_form_frequency().equals("Weekly")) {
                DateTime date = new DateTime().withWeekyear(report_period_year).withWeekOfWeekyear(report_period_week);
                report_period_month = date.getMonthOfYear();
                report_period_from_date = new DateTime().withWeekyear(report_period_year).withWeekOfWeekyear(report_period_week).withDayOfWeek(1).toDate();
                report_period_to_date = new DateTime().withWeekyear(report_period_year).withWeekOfWeekyear(report_period_week).withDayOfWeek(7).toDate();
            }
            /**
             * Monthly
             */
            if (report_period_year != null && report_period_month != null && report_form.getReport_form_frequency().equals("Monthly")) {
                DateTime date = new DateTime().withYear(report_period_year).withMonthOfYear(report_period_month);
                DateTime start = date.withDayOfMonth(1).withTimeAtStartOfDay();
                DateTime end = start.plusMonths(1).minusMillis(1);
                report_period_from_date = start.toDate();
                report_period_to_date = end.toDate();;
            }
            /**
             * Quarter
             */
            if (report_period_year != null && report_period_quarter != null && report_form.getReport_form_frequency().equals("Quarterly")) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    if (report_period_quarter == 1) {
                        report_period_from_date = sdf.parse(1 + "/" + 1 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(31 + "/" + 3 + "/" + report_period_year);
                    }
                    if (report_period_quarter == 2) {
                        report_period_from_date = sdf.parse(1 + "/" + 4 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(30 + "/" + 6 + "/" + report_period_year);
                    }
                    if (report_period_quarter == 3) {
                        report_period_from_date = sdf.parse(1 + "/" + 7 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(30 + "/" + 9 + "/" + report_period_year);
                    }
                    if (report_period_quarter == 4) {
                        report_period_from_date = sdf.parse(1 + "/" + 10 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(31 + "/" + 12 + "/" + report_period_year);
                    }
                } catch (ParseException ex) {

                }
            }

            /**
             * Bi-Month
             */
            if (report_period_year != null && report_period_bi_month != null && report_form.getReport_form_frequency().equals("Bi-Monthly")) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    if (report_period_bi_month == 1) {
                        report_period_from_date = sdf.parse(1 + "/" + 1 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(28 + "/" + 2 + "/" + report_period_year);
                    }
                    if (report_period_bi_month == 2) {
                        report_period_from_date = sdf.parse(1 + "/" + 3 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(30 + "/" + 4 + "/" + report_period_year);
                    }
                    if (report_period_bi_month == 3) {
                        report_period_from_date = sdf.parse(1 + "/" + 5 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(30 + "/" + 6 + "/" + report_period_year);
                    }
                    if (report_period_bi_month == 4) {
                        report_period_from_date = sdf.parse(1 + "/" + 7 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(31 + "/" + 8 + "/" + report_period_year);
                    }
                    if (report_period_bi_month == 5) {
                        report_period_from_date = sdf.parse(1 + "/" + 9 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(31 + "/" + 10 + "/" + report_period_year);
                    }
                    if (report_period_bi_month == 6) {
                        report_period_from_date = sdf.parse(1 + "/" + 11 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(31 + "/" + 12 + "/" + report_period_year);
                    }
                } catch (ParseException ex) {

                }
            }

        }
    }

    public boolean showbimonthly() {
        if (report_form == null) {
            return false;
        } else if (report_form.getReport_form_frequency().equals("Bi-Monthly")) {
            return true;
        }
        return false;
    }

    public boolean showquartery() {
        if (report_form == null) {
            return false;
        } else if (report_form.getReport_form_frequency().equals("Quarterly")) {
            return true;
        }
        return false;
    }

    public BatchDetails getBatchDetails() {
        return batchDetails;
    }

    public void setBatchDetails(BatchDetails batchDetails) {
        this.batchDetails = batchDetails;
    }

    public List<ValidationReport> getValidationReportList() {
        return validationReportList;
    }

    public void setValidationReportList(List<ValidationReport> validationReportList) {
        this.validationReportList = validationReportList;
    }

    public List<ValidationReport> getValidationReportSelected() {
        return validationReportSelected;
    }

    public void setValidationReportSelected(List<ValidationReport> validationReportSelected) {
        this.validationReportSelected = validationReportSelected;
    }

    public Integer getReport_period_year() {
        return report_period_year;
    }

    public void setReport_period_year(Integer report_period_year) {
        this.report_period_year = report_period_year;
    }

    public Integer getReport_period_month() {
        return report_period_month;
    }

    public void setReport_period_month(Integer report_period_month) {
        this.report_period_month = report_period_month;
    }

    public Integer getReport_period_week() {
        return report_period_week;
    }

    public void setReport_period_week(Integer report_period_week) {
        this.report_period_week = report_period_week;
    }

    public Interface_dataBean getInterface_dataBean() {
        return interface_dataBean;
    }

    public void setInterface_dataBean(Interface_dataBean interface_dataBean) {
        this.interface_dataBean = interface_dataBean;
    }

    public Base_dataBean getBase_dataBean() {
        return base_dataBean;
    }

    public void setBase_dataBean(Base_dataBean base_dataBean) {
        this.base_dataBean = base_dataBean;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public Sub_county getSub_county() {
        return sub_county;
    }

    public void setSub_county(Sub_county sub_county) {
        this.sub_county = sub_county;
    }

    public Parish getParish() {
        return parish;
    }

    public void setParish(Parish parish) {
        this.parish = parish;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public Date getReport_period_from_date() {
        return report_period_from_date;
    }

    public void setReport_period_from_date(Date report_period_from_date) {
        this.report_period_from_date = report_period_from_date;
    }

    public Date getReport_period_to_date() {
        return report_period_to_date;
    }

    public void setReport_period_to_date(Date report_period_to_date) {
        this.report_period_to_date = report_period_to_date;
    }

    public Financial_year getFinancial_year() {
        return financial_year;
    }

    public void setFinancial_year(Financial_year financial_year) {
        this.financial_year = financial_year;
    }

    public Integer getReport_period_quarter() {
        return report_period_quarter;
    }

    public void setReport_period_quarter(Integer report_period_quarter) {
        this.report_period_quarter = report_period_quarter;
    }

    public String getReport_period_name() {
        return report_period_name;
    }

    public void setReport_period_name(String report_period_name) {
        this.report_period_name = report_period_name;
    }

    public Integer getReport_period_bi_month() {
        return report_period_bi_month;
    }

    public void setReport_period_bi_month(Integer report_period_bi_month) {
        this.report_period_bi_month = report_period_bi_month;
    }

    public String getDatabase_type() {
        return database_type;
    }

    public void setDatabase_type(String database_type) {
        this.database_type = database_type;
    }

    public String getInsert_string() {
        return insert_string;
    }

    public void setInsert_string(String insert_string) {
        this.insert_string = insert_string;
    }

    public String getTable_string() {
        return table_string;
    }

    public void setTable_string(String table_string) {
        this.table_string = table_string;
    }

    public JSONArray getjSONArray() {
        jSONArray = new JSONArray();
        JSONArray jArray = new JSONArray();
        if (report_form != null) {
            JSONObject jObj = new JSONObject();
            jObj.put("DataElement", new JSONObject().put("type", "string"));
            if (report_form.getLowest_report_form_level().equals("Facility")) {
                jObj.put("District", new JSONObject().put("type", "string"));
                //jObj.put("County", new JSONObject().put("type", "string"));
                jObj.put("Subcounty", new JSONObject().put("type", "string"));
                jObj.put("Facility", new JSONObject().put("type", "string"));
            }
            if (report_form.getLowest_report_form_level().equals("Parish")) {
                jObj.put("District", new JSONObject().put("type", "string"));
                //jObj.put("County", new JSONObject().put("type", "string"));
                jObj.put("Subcounty", new JSONObject().put("type", "string"));
                jObj.put("Parish", new JSONObject().put("type", "string"));
            }
            if (report_form.getLowest_report_form_level().equals("District")) {
                jObj.put("District", new JSONObject().put("type", "string"));
            }
            jObj.put("DataElementValue", new JSONObject().put("type", "number"));
            jArray.put(jObj);

            if (interface_datas == null) {
                interface_datas = new ArrayList<>();
            }
            for (Interface_data interface_data : interface_datas) {
                if (interface_data.getData_element().getData_type().equals("integer") || interface_data.getData_element().getData_type().equals("float")) {
                    jObj = new JSONObject();
                    jObj.put("DataElement", String.format("%1$03d", interface_data.getData_element().getGroup_column_number()) + interface_data.getData_element().getData_element_name());
                    if (report_form.getLowest_report_form_level().equals("Facility")) {
                        jObj.put("District", interface_data.getDistrict_name());
                        //jObj.put("County", interface_data.getCounty_name());
                        jObj.put("Subcounty", interface_data.getSub_county_name());
                        jObj.put("Facility", interface_data.getHealth_facility_name());
                    }
                    if (report_form.getLowest_report_form_level().equals("Parish")) {
                        jObj.put("District", interface_data.getDistrict_name());
                        //jObj.put("County", interface_data.getCounty_name());
                        jObj.put("Subcounty", interface_data.getSub_county_name());
                        jObj.put("Parish", interface_data.getParish_name());
                    }
                    if (report_form.getLowest_report_form_level().equals("District")) {
                        jObj.put("District", interface_data.getDistrict_name());
                    }
                    if (interface_data.getData_element_value() == null) {
                        jObj.put("DataElementValue", 0);
                    } else {
                        try {
                            jObj.put("DataElementValue", Float.parseFloat(interface_data.getData_element_value()));
                        } catch (NumberFormatException nfe) {
                            jObj.put("DataElementValue", 0);
                        }
                    }
                    jArray.put(jObj);
                }
            }
            jSONArray = jArray;
        }
        return jSONArray;
    }

    public void clear_jSONArray(){
        jSONArray=new JSONArray();
    }
    
    public void load_jSONArray(District[] selectedDistricts, Integer[] selectedYears, Integer[] selectedDataElements) {

        JSONArray jArray = new JSONArray();
        jSONArray = new JSONArray();

        String YearsStr = "";
        String DistrictsStr = "";
        String DataElementStr = "";
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        base_data_objects = new ArrayList<>();
        if (selectedYears == null || selectedDistricts == null) {
            jSONArray = new JSONArray();
        }
        //get 1016,2015,2013 string format for selected years
        int x = 0;
        x = selectedYears.length;
        for (int i = 0; i < x; i++) {
            if (YearsStr.length() > 0) {
                YearsStr = YearsStr + "," + selectedYears[i];
            } else {
                YearsStr = "" + selectedYears[i];
            }
        }

        //get 1,2,3 string format for selected districts
        int y = 0;
        y = selectedDistricts.length;
        for (int i = 0; i < y; i++) {
            if (DistrictsStr.length() > 0) {
                DistrictsStr = DistrictsStr + "," + selectedDistricts[i].getDistrict_id();
            } else {
                DistrictsStr = "" + selectedDistricts[i].getDistrict_id();
            }
        }
        //get 1,2,3 string format for selected districts
        y = selectedDataElements.length;
        for (int i = 0; i < y; i++) {
            if (DataElementStr.length() > 0) {
                DataElementStr = DataElementStr + "," + selectedDataElements[i];
            } else {
                DataElementStr = "" + selectedDataElements[i];
            }
        }

        GeneralUtilities.flushandclearsession();
        if (report_form != null && report_form_group != null) {
            String sql = "SELECT\n"
                    + "district_name,\n"
                    + "county_name,\n"
                    + "sub_county_name,\n"
                    + "parish_name,\n"
                    + "health_facility_name,\n"
                    + "b.report_period_year,\n"
                    + "b.report_period_quarter,\n"
                    + "b.report_period_bi_month,\n"
                    + "b.report_period_month,\n"
                    + "b.report_period_week,\n"
                    + "section_name,\n"
                    + "sub_section_name,\n"
                    + "data_element_name,\n"
                    + "data_element_value,\n"
                    + "data_element_context,\n"
                    + "data_type,\n"
                    + "data_size,\n"
                    + "age_category,\n"
                    + "sex_category,\n"
                    + "other_category,\n"
                    + "technical_area_name\n"
                    + "FROM\n"
                    + "base_data_" + report_form.getReport_form_id() + "_" + report_form_group.getReport_form_group_id() + " AS b\n"
                    + " where b.data_element_id in (" + DataElementStr + ")"
                    + " AND b.district_id in(" + DistrictsStr + ") AND report_period_year IN( " + YearsStr + ") AND b.report_form_group_id=" + report_form_group.getReport_form_group_id();

            //String sql2 = "CALL sp_select_dyanamic ('" + DistrictsStr + "','" + YearsStr + "','" + DataElementStr + "'," + report_form_group.getReport_form_group_id() + "," + report_form.getReport_form_id() + ");";
//            try {
//                base_data_objects = (List<Object[]>) EIHDMSPersistentManager.instance().getSession().createSQLQuery(sql).list();
//                //base_data_objects = (List<Object[]>) EIHDMSPersistentManager.instance().getSession().createSQLQuery(sql).list();
//            } catch (PersistentException ex) {
//                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
//            }
            try (Connection conn = DBConnection.getMySQLConnection();
                    PreparedStatement ps = conn.prepareStatement(sql);) {
                ResultSet rs = ps.executeQuery();
                load_json_array_from_base_data_array2(jSONArray, jArray, "dynamic", rs);
            } catch (SQLException ex) {
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //load_json_array_from_base_data_array(jSONArray, jArray, "dynamic");

    }

    public JSONArray getjSONArray_Dynamic_Pivot() {
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        return jSONArray;
    }

    /**
     *
     * @param jsona
     * @param jArray
     * @param context is used to refer to load method that is calling this
     * method
     */
    public void load_json_array_from_base_data_array(JSONArray jsona, JSONArray jArray, String context) {
        if (report_form != null) {
            JSONObject jObj = new JSONObject();
            jObj.put("DataElement", new JSONObject().put("type", "string"));
            if (report_form.getLowest_report_form_level().equals("Facility")) {
                jObj.put("District", new JSONObject().put("type", "string"));
                jObj.put("County", new JSONObject().put("type", "string"));
                jObj.put("Subcounty", new JSONObject().put("type", "string"));
                jObj.put("Facility", new JSONObject().put("type", "string"));
            }
            if (report_form.getLowest_report_form_level().equals("Parish")) {
                jObj.put("District", new JSONObject().put("type", "string"));
                jObj.put("County", new JSONObject().put("type", "string"));
                jObj.put("Subcounty", new JSONObject().put("type", "string"));
                jObj.put("Parish", new JSONObject().put("type", "string"));
            }
            if (report_form.getLowest_report_form_level().equals("District")) {
                jObj.put("District", new JSONObject().put("type", "string"));
            }

            if (report_form.getReport_form_frequency().equals("Weekly")) {
                jObj.put("Week", new JSONObject().put("type", "number"));
                jObj.put("Month", new JSONObject().put("type", "string"));
            }
            if (report_form.getReport_form_frequency().equals("Monthly")) {
                jObj.put("Month", new JSONObject().put("type", "string"));
            }
            if (report_form.getReport_form_frequency().equals("Bi-Monthly")) {
                jObj.put("Bi-Month", new JSONObject().put("type", "number"));
            }
            if (report_form.getReport_form_frequency().equals("Quarterly")) {
                jObj.put("Quarter", new JSONObject().put("type", "string"));
            }
            jObj.put("Year", new JSONObject().put("type", "number"));
            jObj.put("Section", new JSONObject().put("type", "string"));
            jObj.put("SubSection", new JSONObject().put("type", "string"));
            jObj.put("DataElementContext", new JSONObject().put("type", "string"));
            jObj.put("AgeCategory", new JSONObject().put("type", "string"));
            jObj.put("SexCategory", new JSONObject().put("type", "string"));
            jObj.put("OtherCategory", new JSONObject().put("type", "string"));
            jObj.put("TechnicalArea", new JSONObject().put("type", "string"));

            jObj.put("DataElementValue", new JSONObject().put("type", "number"));
            jArray.put(jObj);

            if (base_data_objects == null) {
                base_data_objects = new ArrayList<>();
            }
            for (Object[] base_data : base_data_objects) {
                if (base_data[15].toString().equals("integer") || base_data[15].toString().equals("float")) {
                    jObj = new JSONObject();
                    jObj.put("DataElement", base_data[12].toString());
                    if (report_form.getLowest_report_form_level().equals("Facility")) {
                        jObj.put("District", base_data[0].toString());
                        jObj.put("County", base_data[1].toString());
                        jObj.put("Subcounty", base_data[2].toString());
                        jObj.put("Facility", base_data[4].toString());
                    }
                    if (report_form.getLowest_report_form_level().equals("Parish")) {
                        jObj.put("District", base_data[0].toString());
                        jObj.put("County", base_data[1].toString());
                        jObj.put("Subcounty", base_data[2].toString());
                        jObj.put("Parish", base_data[3].toString());
                    }
                    if (report_form.getLowest_report_form_level().equals("District")) {
                        jObj.put("District", base_data[0].toString());
                    }
                    if (base_data[13] == null) {
                        jObj.put("DataElementValue", 0);
                    } else {
                        try {
                            jObj.put("DataElementValue", Float.parseFloat(base_data[13].toString()));
                        } catch (NumberFormatException nfe) {
                            jObj.put("DataElementValue", 0);
                        }
                    }
                    if (report_form.getReport_form_frequency().equals("Weekly")) {
                        jObj.put("Week", Integer.parseInt(base_data[9].toString()));
                        jObj.put("Month", GeneralUtilities.convert_int_month_to_string_month(Integer.parseInt(base_data[8].toString())));
                    }
                    if (report_form.getReport_form_frequency().equals("Monthly")) {
                        jObj.put("Month", GeneralUtilities.convert_int_month_to_string_month(Integer.parseInt(base_data[8].toString())));
                    }
                    if (report_form.getReport_form_frequency().equals("Bi-Monthly")) {
                        jObj.put("Bi-Month", Integer.parseInt(base_data[7].toString()));
                    }
                    if (report_form.getReport_form_frequency().equals("Quarterly")) {
                        jObj.put("Quarter", GeneralUtilities.convert_int_quarter_to_string_quarter(Integer.parseInt(base_data[6].toString())));
                    }
                    jObj.put("Year", Integer.parseInt(base_data[5].toString()));

                    jObj.put("Section", base_data[10].toString());
                    jObj.put("SubSection", base_data[11].toString());
                    try {
                        jObj.put("DataElementContext", base_data[14].toString());
                    } catch (Exception ex) {
                        jObj.put("DataElementContext", "");
                    }
                    try {
                        jObj.put("AgeCategory", base_data[17].toString());
                    } catch (Exception ex) {
                        jObj.put("AgeCategory", "");
                    }
                    try {
                        jObj.put("SexCategory", base_data[18].toString());
                    } catch (Exception ex) {
                        jObj.put("SexCategory", "");
                    }
                    try {
                        jObj.put("OtherCategory", base_data[19].toString());
                    } catch (Exception ex) {
                        jObj.put("OtherCategory", "");
                    }
                    try {
                        jObj.put("TechnicalArea", base_data[20].toString());
                    } catch (Exception ex) {
                        jObj.put("TechnicalArea", "");
                    }
                    jArray.put(jObj);
                }
                /**
                 * If calling method is the delete method
                 */
                if (context.equals("delete_data")) {
                    if (BaseDataStr.length() > 0) {
                        BaseDataStr = BaseDataStr + "," + base_data[21].toString();
                    } else {
                        BaseDataStr = "" + base_data[21].toString();
                    }
                }
            }
            jSONArray = jArray;
        }
    }

    public void load_json_array_from_base_data_array2(JSONArray jsona, JSONArray jArray, String context, ResultSet rs) {
        if (report_form != null) {
            try {
                JSONObject jObj = new JSONObject();
                jObj.put("DataElement", new JSONObject().put("type", "string"));
                if (report_form.getLowest_report_form_level().equals("Facility")) {
                    jObj.put("District", new JSONObject().put("type", "string"));
                    jObj.put("County", new JSONObject().put("type", "string"));
                    jObj.put("Subcounty", new JSONObject().put("type", "string"));
                    jObj.put("Facility", new JSONObject().put("type", "string"));
                }
                if (report_form.getLowest_report_form_level().equals("Parish")) {
                    jObj.put("District", new JSONObject().put("type", "string"));
                    jObj.put("County", new JSONObject().put("type", "string"));
                    jObj.put("Subcounty", new JSONObject().put("type", "string"));
                    jObj.put("Parish", new JSONObject().put("type", "string"));
                }
                if (report_form.getLowest_report_form_level().equals("District")) {
                    jObj.put("District", new JSONObject().put("type", "string"));
                }

                if (report_form.getReport_form_frequency().equals("Weekly")) {
                    jObj.put("Week", new JSONObject().put("type", "number"));
                    jObj.put("Month", new JSONObject().put("type", "string"));
                }
                if (report_form.getReport_form_frequency().equals("Monthly")) {
                    jObj.put("Month", new JSONObject().put("type", "string"));
                }
                if (report_form.getReport_form_frequency().equals("Bi-Monthly")) {
                    jObj.put("Bi-Month", new JSONObject().put("type", "number"));
                }
                if (report_form.getReport_form_frequency().equals("Quarterly")) {
                    jObj.put("Quarter", new JSONObject().put("type", "string"));
                }
                jObj.put("Year", new JSONObject().put("type", "number"));
                jObj.put("Section", new JSONObject().put("type", "string"));
                jObj.put("SubSection", new JSONObject().put("type", "string"));
                jObj.put("DataElementContext", new JSONObject().put("type", "string"));
                jObj.put("AgeCategory", new JSONObject().put("type", "string"));
                jObj.put("SexCategory", new JSONObject().put("type", "string"));
                jObj.put("OtherCategory", new JSONObject().put("type", "string"));
                jObj.put("TechnicalArea", new JSONObject().put("type", "string"));

                jObj.put("DataElementValue", new JSONObject().put("type", "number"));
                jArray.put(jObj);

//            if (base_data_objects == null) {
//                base_data_objects = new ArrayList<>();
//            }
                int counter = 1;
                while (rs.next()) {
                    if (rs.getString("data_type").equals("integer") || rs.getString("data_type").equals("float")) {
                        jObj = new JSONObject();
                        jObj.put("DataElement", rs.getString("data_element_name"));
                        if (report_form.getLowest_report_form_level().equals("Facility")) {
                            jObj.put("District", rs.getString("district_name"));
                            jObj.put("County", rs.getString("county_name"));
                            jObj.put("Subcounty", rs.getString("sub_county_name"));
                            jObj.put("Facility", rs.getString("health_facility_name"));
                        }
                        if (report_form.getLowest_report_form_level().equals("Parish")) {
                            jObj.put("District", rs.getString("district_name"));
                            jObj.put("County", rs.getString("county_name"));
                            jObj.put("Subcounty", rs.getString("sub_county_name"));
                            jObj.put("Parish", rs.getString("parish_name"));
                        }
                        if (report_form.getLowest_report_form_level().equals("District")) {
                            jObj.put("District", rs.getString("district_name"));
                        }
                        try {
                            jObj.put("DataElementValue", rs.getFloat("data_element_value"));
                        } catch (SQLException | JSONException ex) {
                            jObj.put("DataElementValue", 0);
                        }
                        if (report_form.getReport_form_frequency().equals("Weekly")) {
                            jObj.put("Week", rs.getInt("report_period_week"));
                            jObj.put("Month", GeneralUtilities.convert_int_month_to_string_month(rs.getInt("report_period_month")));
                        }
                        if (report_form.getReport_form_frequency().equals("Monthly")) {
                            jObj.put("Month", GeneralUtilities.convert_int_month_to_string_month(rs.getInt("report_period_month")));
                        }
                        if (report_form.getReport_form_frequency().equals("Bi-Monthly")) {
                            jObj.put("Bi-Month", rs.getInt("report_period_bi_month"));
                        }
                        if (report_form.getReport_form_frequency().equals("Quarterly")) {
                            jObj.put("Quarter", GeneralUtilities.convert_int_quarter_to_string_quarter(rs.getInt("report_period_quarter")));
                        }
                        jObj.put("Year", rs.getInt("report_period_year"));

                        jObj.put("Section", rs.getString("section_name"));
                        jObj.put("SubSection", rs.getString("sub_section_name"));
                        try {
                            jObj.put("DataElementContext", rs.getString("data_element_context"));
                        } catch (Exception ex) {
                            jObj.put("DataElementContext", "");
                        }
                        try {
                            jObj.put("AgeCategory", rs.getString("age_category"));
                        } catch (Exception ex) {
                            jObj.put("AgeCategory", "");
                        }
                        try {
                            jObj.put("SexCategory", rs.getString("sex_category"));
                        } catch (Exception ex) {
                            jObj.put("SexCategory", "");
                        }
                        try {
                            jObj.put("OtherCategory", rs.getString("other_category"));
                        } catch (Exception ex) {
                            jObj.put("OtherCategory", "");
                        }
                        try {
                            jObj.put("TechnicalArea", rs.getString("technical_area_name"));
                        } catch (Exception ex) {
                            jObj.put("TechnicalArea", "");
                        }
                        jArray.put(jObj);
                    }
                    System.out.println(counter);
                    counter++;
                }
                rs.close();
                jSONArray = jArray;
            } catch (SQLException ex) {
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * To refresh when deleting by period
     */
    public void refresh_delete_data_by_period() {
        String QuarterStr = "";
        String BiMonthStr = "";
        String MonthStr = "";
        String WeekStr = "";
        BaseDataStr = "";
        GeneralUtilities.flushandclearsession();

        if (report_form != null) {
            String sql = "SELECT\n"
                    + "d.district_name,\n"
                    + "c.county_name,\n"
                    + "sc.sub_county_name,\n"
                    + "p.parish_name,\n"
                    + "hf.health_facility_name,\n"
                    + "b.report_period_year,\n"
                    + "b.report_period_quarter,\n"
                    + "b.report_period_bi_month,\n"
                    + "b.report_period_month,\n"
                    + "b.report_period_week,\n"
                    + "se.section_name,\n"
                    + "ss.sub_section_name,\n"
                    + "de.data_element_name,\n"
                    + "b.data_element_value,\n"
                    + "de.data_element_context,\n"
                    + "de.data_type,\n"
                    + "de.data_size,\n"
                    + "de.age_category,\n"
                    + "de.sex_category,\n"
                    + "de.other_category,\n"
                    + "ta.technical_area_name,\n"
                    + "b.base_data_id\n"
                    + "FROM\n"
                    + "base_data_" + report_form.getReport_form_id() + " AS b\n"
                    + "LEFT JOIN district AS d ON d.district_id = b.district_id\n"
                    + "LEFT JOIN county AS c ON c.county_id = b.county_id\n"
                    + "LEFT JOIN sub_county AS sc ON sc.sub_county_id = b.sub_county_id\n"
                    + "LEFT JOIN parish AS p ON p.parish_id = b.parish_id\n"
                    + "LEFT JOIN health_facility AS hf ON hf.health_facility_id = b.health_facility_id\n"
                    + "INNER JOIN data_element AS de ON de.data_element_id = b.data_element_id\n"
                    + "INNER JOIN section AS se ON de.section_id = se.section_id\n"
                    + "INNER JOIN sub_section AS ss ON de.sub_section_id = ss.sub_section_id\n"
                    + "LEFT JOIN technical_area AS ta ON de.technical_area_id = ta.technical_area_id WHERE ";
            //+ "b.district_id in(" + DistrictsStr + ") AND report_period_year IN( " + YearsStr + ")";

            switch (report_form.getReport_form_frequency()) {
                case "Weekly":
                    int x = 0;
                    x = this.selectedWeeks.length;
                    for (int i = 0; i < x; i++) {
                        if (WeekStr.length() > 0) {
                            WeekStr = WeekStr + "," + this.selectedWeeks[i];
                        } else {
                            WeekStr = "" + this.selectedWeeks[i];
                        }
                    }
                    sql = sql + "b.report_period_week in(" + WeekStr + ") AND report_period_year=" + report_period_year;
                    try {
                        base_data_objects = (List<Object[]>) EIHDMSPersistentManager.instance().getSession().createSQLQuery(sql).list();
                    } catch (PersistentException ex) {
                        base_data_objects = new ArrayList<>();
                        Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Monthly":
                    x = 0;
                    x = this.selectedMonths.length;
                    for (int i = 0; i < x; i++) {
                        if (MonthStr.length() > 0) {
                            MonthStr = MonthStr + "," + this.selectedMonths[i];
                        } else {
                            MonthStr = "" + this.selectedMonths[i];
                        }
                    }
                    sql = sql + "b.report_period_month in(" + MonthStr + ") AND report_period_year=" + report_period_year;
                    try {
                        base_data_objects = (List<Object[]>) EIHDMSPersistentManager.instance().getSession().createSQLQuery(sql).list();
                    } catch (PersistentException ex) {
                        base_data_objects = new ArrayList<>();
                        Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Bi-Monthly":
                    x = 0;
                    x = this.selectedBiMonths.length;
                    for (int i = 0; i < x; i++) {
                        if (BiMonthStr.length() > 0) {
                            BiMonthStr = BiMonthStr + "," + this.selectedBiMonths[i];
                        } else {
                            BiMonthStr = "" + this.selectedBiMonths[i];
                        }
                    }
                    sql = sql + "b.report_period_bi_month in(" + BiMonthStr + ") AND report_period_year=" + report_period_year;
                    try {
                        base_data_objects = (List<Object[]>) EIHDMSPersistentManager.instance().getSession().createSQLQuery(sql).list();
                    } catch (PersistentException ex) {
                        base_data_objects = new ArrayList<>();
                        Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Quarterly":
                    x = 0;
                    x = this.selectedQuarters.length;
                    for (int i = 0; i < x; i++) {
                        if (QuarterStr.length() > 0) {
                            QuarterStr = QuarterStr + "," + this.selectedQuarters[i];
                        } else {
                            QuarterStr = "" + this.selectedQuarters[i];
                        }
                    }
                    sql = sql + "b.report_period_quarter in(" + QuarterStr + ") AND report_period_year=" + report_period_year;
                    try {
                        base_data_objects = (List<Object[]>) EIHDMSPersistentManager.instance().getSession().createSQLQuery(sql).list();
                    } catch (PersistentException ex) {
                        base_data_objects = new ArrayList<>();
                        Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                default:
                    break;
            }
        }
        JSONArray jArray = new JSONArray();
        jSONArray = new JSONArray();
        load_json_array_from_base_data_array(jSONArray, jArray, "delete_data");
    }

    /**
     * To refresh when deleting by level
     */
    public void refresh_delete_data_by_level() {
        String ParishesStr = "";
        String HealthFacilitiesStr = "";
        String DistrictsStr = "";
        BaseDataStr = "";
        GeneralUtilities.flushandclearsession();
        if (report_form != null) {
            String period_condition = "";
            switch (report_form.getReport_form_frequency()) {
                case "Weekly":
                    period_condition = "report_period_week=" + report_period_week + " AND report_period_month=" + report_period_month + " AND report_period_year=" + report_period_year;
                    break;
                case "Monthly":
                    period_condition = "report_period_month=" + report_period_month + " AND report_period_year=" + report_period_year;
                    break;
                case "Bi-Monthly":
                    period_condition = "report_period_bi_month=" + report_period_bi_month + " AND report_period_year=" + report_period_year;
                    break;
                case "Quarterly":
                    period_condition = "report_period_quarter=" + report_period_quarter + " AND report_period_year=" + report_period_year;
                    break;
                case "Annually":
                    period_condition = "report_period_year=" + report_period_year;
                    break;
                default:
                    break;
            }

            if (report_form != null) {
                String sql = "SELECT\n"
                        + "d.district_name,\n"
                        + "c.county_name,\n"
                        + "sc.sub_county_name,\n"
                        + "p.parish_name,\n"
                        + "hf.health_facility_name,\n"
                        + "b.report_period_year,\n"
                        + "b.report_period_quarter,\n"
                        + "b.report_period_bi_month,\n"
                        + "b.report_period_month,\n"
                        + "b.report_period_week,\n"
                        + "se.section_name,\n"
                        + "ss.sub_section_name,\n"
                        + "de.data_element_name,\n"
                        + "b.data_element_value,\n"
                        + "de.data_element_context,\n"
                        + "de.data_type,\n"
                        + "de.data_size,\n"
                        + "de.age_category,\n"
                        + "de.sex_category,\n"
                        + "de.other_category,\n"
                        + "ta.technical_area_name,\n"
                        + "b.base_data_id\n"
                        + "FROM\n"
                        + "base_data_" + report_form.getReport_form_id() + " AS b\n"
                        + "LEFT JOIN district AS d ON d.district_id = b.district_id\n"
                        + "LEFT JOIN county AS c ON c.county_id = b.county_id\n"
                        + "LEFT JOIN sub_county AS sc ON sc.sub_county_id = b.sub_county_id\n"
                        + "LEFT JOIN parish AS p ON p.parish_id = b.parish_id\n"
                        + "LEFT JOIN health_facility AS hf ON hf.health_facility_id = b.health_facility_id\n"
                        + "INNER JOIN data_element AS de ON de.data_element_id = b.data_element_id\n"
                        + "INNER JOIN section AS se ON de.section_id = se.section_id\n"
                        + "INNER JOIN sub_section AS ss ON de.sub_section_id = ss.sub_section_id\n"
                        + "LEFT JOIN technical_area AS ta ON de.technical_area_id = ta.technical_area_id WHERE ";
                //+ "b.district_id in(" + DistrictsStr + ") AND report_period_year IN( " + YearsStr + ")";

                if (report_form.getLowest_report_form_level().equals("Parish") && selectedParishes != null) {
                    //get 1016,2015,2013 string format for selected years
                    int x = 0;
                    x = this.selectedParishes.length;
                    for (int i = 0; i < x; i++) {
                        if (ParishesStr.length() > 0) {
                            ParishesStr = ParishesStr + "," + this.selectedParishes[i];
                        } else {
                            ParishesStr = "" + this.selectedParishes[i];
                        }
                    }
                    sql = sql + "b.parish_id in(" + ParishesStr + ") AND " + period_condition;
                    try {
                        base_data_objects = (List<Object[]>) EIHDMSPersistentManager.instance().getSession().createSQLQuery(sql).list();
                    } catch (PersistentException ex) {
                        base_data_objects = new ArrayList<>();
                        Logger
                                .getLogger(UploadBean.class
                                        .getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (report_form.getLowest_report_form_level().equals("District") && selectedDistricts != null) {
                    //get 1,2,3 string format for selected districts
                    int y = 0;
                    y = this.selectedDistricts.length;
                    for (int i = 0; i < y; i++) {
                        if (DistrictsStr.length() > 0) {
                            DistrictsStr = DistrictsStr + "," + this.selectedDistricts[i].getDistrict_id();
                        } else {
                            DistrictsStr = "" + this.selectedDistricts[i].getDistrict_id();
                        }
                    }
                    sql = sql + "b.district_id in(" + DistrictsStr + ") AND " + period_condition;
                    try {
                        base_data_objects = (List<Object[]>) EIHDMSPersistentManager.instance().getSession().createSQLQuery(sql).list();
                    } catch (PersistentException ex) {
                        base_data_objects = new ArrayList<>();
                        Logger
                                .getLogger(UploadBean.class
                                        .getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (report_form.getLowest_report_form_level().equals("Facility") && selectedHealth_facilities != null) {
                    //get 1,2,3 string format for selected Health Facilities
                    int z = 0;
                    z = this.selectedHealth_facilities.length;
                    for (int i = 0; i < z; i++) {
                        if (HealthFacilitiesStr.length() > 0) {
                            HealthFacilitiesStr = HealthFacilitiesStr + "," + this.selectedHealth_facilities[i];
                        } else {
                            HealthFacilitiesStr = "" + this.selectedHealth_facilities[i];
                        }
                    }
                    sql = sql + "b.health_facility_id in(" + HealthFacilitiesStr + ") AND " + period_condition;
                    try {
                        base_data_objects = (List<Object[]>) EIHDMSPersistentManager.instance().getSession().createSQLQuery(sql).list();
                    } catch (PersistentException ex) {
                        base_data_objects = new ArrayList<>();
                        Logger
                                .getLogger(UploadBean.class
                                        .getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        JSONArray jArray = new JSONArray();
        jSONArray = new JSONArray();
        load_json_array_from_base_data_array(jSONArray, jArray, "delete_data");
    }

    public JSONArray getjSONArray_Delete() {
        return jSONArray;
    }

    public void setjSONArray(JSONArray jSONArray) {
        this.jSONArray = jSONArray;
    }

    public Report_form_group getReport_form_group() {
        return report_form_group;
    }

    public void setReport_form_group(Report_form_group report_form_group) {
        this.report_form_group = report_form_group;
    }

    public Report_form getReport_form() {
        return report_form;
    }

    public void setReport_form(Report_form report_form) {
        this.report_form = report_form;
    }

    public List<Report_form_group> getReport_form_groups() {
        try {
            if (report_form != null) {
                report_form_groups = Report_form_group.queryReport_form_group("report_form_id=" + report_form.getReport_form_id(), null);
            } else {
                report_form_groups = new ArrayList<>();

            }
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return report_form_groups;
    }

    public void setReport_form_groups(List<Report_form_group> report_form_groups) {
        this.report_form_groups = report_form_groups;
    }

    public List<Report_form> getReport_forms() {
        try {
            report_forms = Report_form.queryReport_form(null, null);

        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return report_forms;
    }

    public void setReport_forms(List<Report_form> report_forms) {
        this.report_forms = report_forms;
    }

    public List<String> getRowdatas() {
        return rowdatas;
    }

    public void setRowdatas(List<String> rowdatas) {
        this.rowdatas = rowdatas;
    }

    public List<Interface_data> getInterface_datas() {
        return interface_datas;
    }

    public void setInterface_datas(List<Interface_data> interface_datas) {
        this.interface_datas = interface_datas;
    }

    public void handleFileUpload(FileUploadEvent event) {
        try (InputStream inputStream = event.getFile().getInputstream()) {
            uploadexcel(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleFileUploadgenerate_insertstring(FileUploadEvent event) {
        try {
            InputStream inputStream = event.getFile().getInputstream();
            generate_insertstring(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String validationtext;

    public String getValidationtext() {
        return validationtext;
    }

    public void setValidationtext(String validationtext) {
        this.validationtext = validationtext;
    }

    public String validate_upload_procedure(int batch_id, String reporting_level_name, String reporting_name) {
        String validation_rule_name = "";
        try {
            List<Validation_rule> validation_temps = Validation_rule.queryValidation_rule("is_active=1 AND report_form_group=" + report_form_group.getReport_form_group_id(), null);
            String sql = "{call sp_validate_batch(?,?,?,?)}";
            ResultSet rs = null;
            for (Validation_rule v : validation_temps) {
                try (Connection conn = DBConnection.getMySQLConnection();
                        PreparedStatement ps = conn.prepareStatement(sql);) {
                    ps.setInt(1, batch_id);
                    ps.setString(2, reporting_level_name);
                    ps.setString(3, v.getValidation_rule_formula());
                    ps.setString(4, reporting_name);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        validation_rule_name = "";
                    } else {
                        validation_rule_name += "\n" + v.getValidation_rule_name();
                    }
                } catch (SQLException se) {
                    System.err.println(se.getMessage());

                }
            }
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return validation_rule_name;
    }

    public String validate_upload_existing_data(String reporting_hierarchy, int financial_year, int quarter, int month, int week, int calendar_year) {
        String condition = "";
        condition += "CONCAT(d.district_name,CASE WHEN sub_county_name IS NULL THEN '' ELSE sub_county_name END,CASE WHEN parish_name IS NULL THEN '' ELSE parish_name END,CASE WHEN health_facility_name IS NULL THEN '' ELSE health_facility_name END)='" + reporting_hierarchy + "'";
        if (financial_year != 0) {
            condition += " AND fy.financial_year_id=" + financial_year;
        }
        if (quarter != 0) {
            condition += " AND report_period_quarter=" + quarter;
        }
        if (month != 0) {
            condition += " AND report_period_month=" + month;
        }
        if (calendar_year != 0) {
            condition += " AND report_period_year=" + calendar_year;
        }
        if (week != 0) {
            condition += " AND report_period_week=" + week;
        }
        String validation_rule_name = "";
        String sql = "SELECT b.data_element_id,b.data_element_value FROM base_data AS b "
                + "INNER JOIN district AS d ON b.district_id = d.district_id"
                + " LEFT JOIN sub_county AS s ON b.sub_county_id = s.sub_county_id"
                + " LEFT JOIN parish AS p ON b.parish_id = p.parish_id"
                + " INNER JOIN financial_year AS fy ON b.financial_year_id = fy.financial_year_id"
                + " LEFT JOIN health_facility AS f ON b.health_facility_id = f.health_facility_id"
                + " INNER JOIN data_element ON b.data_element_id = data_element.data_element_id "
                + " INNER JOIN report_form_group AS rg ON data_element.report_form_group_id = rg.report_form_group_id WHERE " + condition + " AND rg.report_form_group_id=" + report_form_group.getReport_form_group_id();
        ResultSet rs = null;
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery();
            if (rs.next()) {
                validation_rule_name += "\n" + "Data for the same period has already been uploaded Location:" + reporting_hierarchy + ",FY:" + this.financial_year.getFinancial_year_name() + ",Quarter:" + quarter + ",Month:" + month + ",Week:" + week + "";
            } else {
                validation_rule_name = "";
            }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
        return validation_rule_name;
    }

    private void set_Status_V(Interface_data interface_data) {
        if (!validationtext.isEmpty()) {
            interface_data.setStatus_v("Fail");
            interface_data.setStatus_v_desc("Not Passed Validation because: " + validationtext);
        } else {
            interface_data.setStatus_v("Pass");
            interface_data.setStatus_v_desc("Validated and ready for moving");
        }
    }

    public void validate_and_load_data_to_base(int batch_id) {
        String sql = "{call sp_validate_data(?,?,?,?)}";
        ResultSet rs = null;
        try (Connection conn = loginBean.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, report_form.getReport_form_id());
            ps.setInt(2, report_form_group.getReport_form_group_id());
            ps.setInt(3, batch_id);
            ps.setString(4, report_form.getLowest_report_form_level());
            rs = ps.executeQuery();
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
    }

    public void validate_and_load_data_to_base_patient_level(int batch_id) {
        String sql = "{call sp_validate_data_patient_level(?,?,?,?)}";
        ResultSet rs = null;
        try (Connection conn = loginBean.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, report_form.getReport_form_id());
            ps.setInt(2, report_form_group.getReport_form_group_id());
            ps.setInt(3, batch_id);
            ps.setString(4, report_form.getLowest_report_form_level());
            rs = ps.executeQuery();
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
    }

    public void validate_and_load_data_to_base_SMS(int batch_id, Report_form report_form_SMS, Report_form_group report_form_groupSMS) {
        String sql = "{call sp_validate_data(?,?,?,?)}";
        ResultSet rs = null;
        try (Connection conn = loginBean.getMySQLConnection_System_User();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, report_form_SMS.getReport_form_id());
            ps.setInt(2, report_form_groupSMS.getReport_form_group_id());
            ps.setInt(3, batch_id);
            ps.setString(4, report_form_SMS.getLowest_report_form_level());
            rs = ps.executeQuery();
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
    }

    public void delete_base_data(String delete_by) {
        if (BaseDataStr.length() == 0) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("No Data Selected!", "No Data Selected!"));
            return;
        }
        String sql = "{call sp_delete_base_data(?,?,?)}";
        ResultSet rs = null;
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, BaseDataStr);
            ps.setInt(2, loginBean.getUser_detail().getUser_detail_id());
            ps.setInt(3, report_form.getReport_form_id());
            rs = ps.executeQuery();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Deleted successfully", "Deleted successfully"));
        } catch (SQLException se) {
            System.err.println(se.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(se.getMessage(), se.getMessage()));
        }
        if ("level".equals(delete_by)) {
            refresh_delete_data_by_level();
        }
        if ("period".equals(delete_by)) {
            refresh_delete_data_by_period();
        }
    }

    public void load_interface_old() {
//        if (!interface_datas.isEmpty()) {
//            try {
//                /**
//                 * Validate Data
//                 */
//                //validate_upload(report_form_group);
//                /**
//                 * End Validate Data
//                 */
//                /**
//                 * Load Interface Data
//                 */
//                PersistentTransaction transaction = loginBean.getInstance().getSession().beginTransaction();
//                /**
//                 * Generate Batch
//                 */
//                try {
//                    Batch batch = new Batch();
//                    batch.setAdd_date(new Timestamp(new Date().getTime()));
//                    batch.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
//                    batch.setIs_deleted(0);
//                    batch.setIs_active(1);
//                    batch.save();
//                    /**
//                     * End Batch
//                     */
//                    /**
//                     * Load Interface
//                     */
//                    int counter = 0;
//                    for (Interface_data i : interface_datas) {
//                        //interface_dataBean.setSelected(i);
//                        i.setBatch(batch);
//                        i.setIs_active(1);
//                        i.setAdd_date(new Timestamp(new Date().getTime()));
//                        i.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
//                        i.setIs_deleted(0);
//                        //i.setStatus_u("Pass");
//                        //i.setStatus_u_desc("Uploaded To interface");
//                        i.save();
//                        if (counter % 20 == 0) { //20, same as the JDBC batch size
//                            //flush a batch of inserts and release memory:
//                            loginBean.getInstance().getSession().flush(); //line1
//                            loginBean.getInstance().getSession().clear();
//                        }
//                        counter++;
//                        //interface_dataBean.save(loginBean.getUser_detail().getUser_detail_id());
//                    }
//                    transaction.commit();
//                    /**
//                     * End load interface
//                     */
//                    /**
//                     * Load Base Data
//                     */
//                    validate_and_load_data_to_base(batch.getBatch_id());
//
//                    /**
//                     * Validate Data
//                     */
//                    loginBean.saveMessage();
//                    generate_validation_report(batch.getBatch_id());
//                    interface_datas = new ArrayList<>();
////                    Map<String, Object> options = new HashMap<>();
////                    options.put("draggable", false);
////                    options.put("resizable", false);
////                    options.put("contentHeight", 530);
////                    options.put("height", 550);
////                    options.put("width", 800);
////                    options.put("modal", true);
////                    org.primefaces.context.RequestContext.getCurrentInstance().openDialog("dialog_validationreport2", options, null);
//                    RequestContext.getCurrentInstance().execute("PF('validationReport').show();");
//                } catch (PersistentException ex) {
//                    transaction.rollback();
//                    FacesContext context = FacesContext.getCurrentInstance();
//                    context.addMessage(null, new FacesMessage(ex.getMessage(), ex.getMessage()));
//                    Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } catch (PersistentException ex) {
//                FacesContext context = FacesContext.getCurrentInstance();
//                context.addMessage(null, new FacesMessage(ex.getMessage(), ex.getMessage()));
//                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }

    public Batch newBatch() {
        PersistentSession session;
        PersistentTransaction transaction;
        Batch batch = null;
        //System.out.println("START-BATCH:" + new Date());
        try {
            session = loginBean.getInstance().getSession();
            transaction = session.beginTransaction();
            batch = new Batch();
            batch.setAdd_date(new Timestamp(new Date().getTime()));
            batch.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
            batch.setIs_deleted(0);
            batch.setIs_active(1);
            batch.save();
        } catch (PersistentException ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(ex.getMessage(), ex.getMessage()));
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("END-BATCH:" + new Date());
        return batch;
    }

    public Batch newBatch_SMS(PersistentTransaction transaction) {
        //PersistentSession session;
        Batch batch = null;
        //System.out.println("START-BATCH:" + new Date());
        try {
            //session = loginBean.getInstance().getSession();
            //transaction = session.beginTransaction();
            batch = new Batch();
            batch.setAdd_date(new Timestamp(new Date().getTime()));
            batch.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
            batch.setIs_deleted(0);
            batch.setIs_active(1);
            batch.save();
            transaction.commit();
        } catch (PersistentException ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(ex.getMessage(), ex.getMessage()));
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("END-BATCH:" + new Date());
        return batch;
    }

    /**
     * For Web both upload and data entry
     */
    public void load_interface() {
        Batch batch;
        String sql = "";
        if (!interface_datas.isEmpty()) {
            batch = newBatch();
            //System.out.println("START-INSERT-INTERFACE: " + new Date());
            //3,5,5,5,2,4,4=28
            sql = "INSERT INTO interface_data(batch_id,data_element_id,data_element_value,"
                    + "health_facility_name,parish_name,sub_county_name,county_name,district_name,"
                    + "health_facility_id,parish_id,sub_county_id,county_id,district_id,"
                    + "report_period_year,report_period_quarter,report_period_bi_month,report_period_month,report_period_week,"
                    + "report_period_from_date,report_period_to_date,"
                    + "status_u,status_u_desc,is_deleted,is_active,"
                    + "add_date,add_by,report_form_id,report_form_group_id,entry_mode) "
                    + "VALUES("
                    + "?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,"
                    + "?,?,?,?,"
                    + "?,?,?,?,?)";
            try (
                    Connection connection = loginBean.getMySQLConnection();
                    PreparedStatement ps = connection.prepareStatement(sql);) {
                connection.setAutoCommit(false);
                int j = 0;
                for (Interface_data i : interface_datas) {
                    try {
                        ps.setInt(1, batch.getBatch_id());
                    } catch (NullPointerException npe) {
                        ps.setInt(1, 0);
                        ps.setObject(1, null);
                    }
                    try {
                        ps.setInt(2, i.getData_element().getData_element_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(2, null);
                    }
                    try {
                        ps.setString(3, i.getData_element_value());
                    } catch (NullPointerException npe) {
                        ps.setObject(3, null);
                    }
                    try {
                        ps.setString(4, i.getHealth_facility_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(4, null);
                    }
                    try {
                        ps.setString(5, i.getParish_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(5, null);
                    }
                    try {
                        ps.setString(6, i.getSub_county_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(6, null);
                    }
                    try {
                        ps.setString(7, i.getCounty_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(7, null);
                    }
                    try {
                        ps.setString(8, i.getDistrict_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(8, null);
                    }
                    try {
                        ps.setInt(9, i.getHealth_facility_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(9, null);
                    }
                    try {
                        ps.setInt(10, i.getParish_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(10, null);
                    }
                    try {
                        ps.setInt(11, i.getSub_county_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(11, null);
                    }
                    try {
                        ps.setInt(12, i.getCounty_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(12, null);
                    }
                    try {
                        ps.setInt(13, i.getDistrict_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(13, null);
                    }
                    try {
                        ps.setInt(14, i.getReport_period_year());
                    } catch (NullPointerException npe) {
                        ps.setObject(14, null);
                    }
                    try {
                        ps.setInt(15, i.getReport_period_quarter());
                    } catch (NullPointerException npe) {
                        ps.setObject(15, null);
                    }
                    try {
                        ps.setInt(16, i.getReport_period_bi_month());
                    } catch (NullPointerException npe) {
                        ps.setObject(16, null);
                    }
                    try {
                        ps.setInt(17, i.getReport_period_month());
                    } catch (NullPointerException npe) {
                        ps.setObject(17, null);
                    }
                    try {
                        ps.setInt(18, i.getReport_period_week());
                    } catch (NullPointerException npe) {
                        ps.setObject(18, null);
                    }
                    try {
                        ps.setDate(19, new java.sql.Date(i.getReport_period_from_date().getTime()));
                    } catch (NullPointerException npe) {
                        ps.setObject(19, null);
                    }
                    try {
                        ps.setDate(20, new java.sql.Date(i.getReport_period_to_date().getTime()));
                    } catch (NullPointerException npe) {
                        ps.setDate(20, null);
                    }
                    ps.setString(21, "Pass");
                    ps.setString(22, "Uploaded");
                    ps.setInt(23, 0);
                    ps.setInt(24, 1);
                    try {
                        ps.setTimestamp(25, new java.sql.Timestamp(new java.util.Date().getTime()));
                    } catch (NullPointerException npe) {
                        ps.setTimestamp(25, new java.sql.Timestamp(new java.util.Date().getTime()));
                    }
                    try {
                        ps.setInt(26, loginBean.getUser_detail().getUser_detail_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(26, null);
                    }
                    try {
                        ps.setInt(27, i.getReport_form().getReport_form_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(27, null);
                    }
                    try {
                        ps.setInt(28, i.getReport_form_group_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(28, null);
                    }
                    try {
                        ps.setString(29, i.getEntry_mode());
                    } catch (NullPointerException npe) {
                        ps.setString(29, null);
                    }
                    ps.addBatch();
                    j++;
                    if (j % 500 == 0 || j == interface_datas.size()) {
                        //System.out.println("--execute-J--:" + j);
                        ps.executeBatch();
                    }
                }
                //System.out.println("--final-J1--:" + j);
                connection.commit();
                //System.out.println("--final-J2--:" + j);
                interface_datas.clear();
                //System.out.println("END-INSERT-INTERFACE:" + new Date());

                //Load Base Data
                //System.out.println("START-VALIDATION-LOAD-BASE:" + new Date());
                validate_and_load_data_to_base(batch.getBatch_id());
                //System.out.println("END-VALIDATION-LOAD-BASE:" + new Date());

                loginBean.saveMessage();
                //System.out.println("START-VALIDATION-REPORT:" + new Date());
                generate_validation_report(batch.getBatch_id());
                //System.out.println("END-VALIDATION-REPORT:" + new Date());

                RequestContext.getCurrentInstance().execute("PF('validationReport').show();");
            } catch (SQLException ex) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(ex.getMessage(), ex.getMessage()));
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * For SMS Entry
     *
     * @param interface_dataList
     * @param report_form_SMS
     * @param report_form_group_SMS
     * @param interface_data_sms
     */
    public void load_interface(List<Interface_data> interface_dataList, Report_form report_form_SMS, Report_form_group report_form_group_SMS, Interface_data_sms interface_data_sms) {
        try {
            PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
            Batch batch;
            loginBean = new LoginBean();
            try {
                loginBean.setUser_detail(User_detail.getUser_detailByORMID(1));
            } catch (PersistentException ex) {
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "";
//            if (!interface_dataList.isEmpty()) {
            batch = newBatch_SMS(transaction);
//                try {
//                    for (Interface_data i : interface_dataList) {
//                        i.setStatus_u("Pass");
//                        i.setStatus_u_desc("Uploaded");
//                        i.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
//                        i.save();
//                    }
//                    transaction.commit();
            //System.out.println("START-INSERT-INTERFACE: " + new Date());
            //3,5,5,5,2,4,4=28
            sql = "INSERT INTO interface_data(batch_id,data_element_id,data_element_value,"
                    + "health_facility_name,parish_name,sub_county_name,county_name,district_name,"
                    + "health_facility_id,parish_id,sub_county_id,county_id,district_id,"
                    + "report_period_year,report_period_quarter,report_period_bi_month,report_period_month,report_period_week,"
                    + "report_period_from_date,report_period_to_date,"
                    + "status_u,status_u_desc,is_deleted,is_active,"
                    + "add_date,add_by,report_form_id,report_form_group_id,entry_mode) "
                    + "VALUES("
                    + "?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,"
                    + "?,?,?,?,"
                    + "?,?,?,?,?)";
            try (
                    Connection connection = loginBean.getMySQLConnection_System_User();
                    PreparedStatement ps = connection.prepareStatement(sql);) {
                connection.setAutoCommit(false);
                int j = 0;
                for (Interface_data i : interface_dataList) {
                    try {
                        ps.setInt(1, batch.getBatch_id());
                    } catch (NullPointerException npe) {
                        ps.setInt(1, 0);
                        ps.setObject(1, null);
                    }
                    try {
                        ps.setInt(2, i.getData_element().getData_element_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(2, null);
                    }
                    try {
                        ps.setString(3, i.getData_element_value());
                    } catch (NullPointerException npe) {
                        ps.setObject(3, null);
                    }
                    try {
                        ps.setString(4, i.getHealth_facility_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(4, null);
                    }
                    try {
                        ps.setString(5, i.getParish_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(5, null);
                    }
                    try {
                        ps.setString(6, i.getSub_county_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(6, null);
                    }
                    try {
                        ps.setString(7, i.getCounty_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(7, null);
                    }
                    try {
                        ps.setString(8, i.getDistrict_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(8, null);
                    }
                    try {
                        ps.setInt(9, i.getHealth_facility_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(9, null);
                    }
                    try {
                        ps.setInt(10, i.getParish_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(10, null);
                    }
                    try {
                        ps.setInt(11, i.getSub_county_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(11, null);
                    }
                    try {
                        ps.setInt(12, i.getCounty_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(12, null);
                    }
                    try {
                        ps.setInt(13, i.getDistrict_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(13, null);
                    }
                    try {
                        ps.setInt(14, i.getReport_period_year());
                    } catch (NullPointerException npe) {
                        ps.setObject(14, null);
                    }
                    try {
                        ps.setInt(15, i.getReport_period_quarter());
                    } catch (NullPointerException npe) {
                        ps.setObject(15, null);
                    }
                    try {
                        ps.setInt(16, i.getReport_period_bi_month());
                    } catch (NullPointerException npe) {
                        ps.setObject(16, null);
                    }
                    try {
                        ps.setInt(17, i.getReport_period_month());
                    } catch (NullPointerException npe) {
                        ps.setObject(17, null);
                    }
                    try {
                        ps.setInt(18, i.getReport_period_week());
                    } catch (NullPointerException npe) {
                        ps.setObject(18, null);
                    }
                    try {
                        ps.setDate(19, new java.sql.Date(i.getReport_period_from_date().getTime()));
                    } catch (NullPointerException npe) {
                        ps.setObject(19, null);
                    }
                    try {
                        ps.setDate(20, new java.sql.Date(i.getReport_period_to_date().getTime()));
                    } catch (NullPointerException npe) {
                        ps.setDate(20, null);
                    }
                    ps.setString(21, "Pass");
                    ps.setString(22, "Uploaded");
                    ps.setInt(23, 0);
                    ps.setInt(24, 1);
                    try {
                        ps.setTimestamp(25, new java.sql.Timestamp(new java.util.Date().getTime()));
                    } catch (NullPointerException npe) {
                        ps.setTimestamp(25, new java.sql.Timestamp(new java.util.Date().getTime()));
                    }
                    try {
                        /**
                         * User Id Loading the data
                         */
                        ps.setInt(26, loginBean.getUser_detail().getUser_detail_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(26, null);
                    }
                    try {
                        ps.setInt(27, i.getReport_form().getReport_form_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(27, null);
                    }
                    try {
                        ps.setInt(28, i.getReport_form_group_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(28, null);
                    }
                    try {
                        ps.setString(29, i.getEntry_mode());
                    } catch (NullPointerException npe) {
                        ps.setString(29, null);
                    }
                    ps.addBatch();
                    j++;
                    if (j % 500 == 0 || j == interface_dataList.size()) {
                        //System.out.println("--execute-J--:" + j);
                        ps.executeBatch();
                    }
                }
//System.out.println("--final-J1--:" + j);
                connection.commit();
//System.out.println("--final-J2--:" + j);
                interface_dataList.clear();
//System.out.println("END-INSERT-INTERFACE:" + new Date());

//Load Base Data
//System.out.println("START-VALIDATION-LOAD-BASE:" + new Date());
                validate_and_load_data_to_base_SMS(batch.getBatch_id(), report_form_SMS, report_form_group_SMS);
//System.out.println("END-VALIDATION-LOAD-BASE:" + new Date());
                /**
                 * Set Batch_Id of interface_data_sms
                 */
                interface_data_sms.setBatch_id(batch.getBatch_id());
//loginBean.saveMessage();
//System.out.println("START-VALIDATION-REPORT:" + new Date());
                String validationError = generate_validation_report_SMS(batch.getBatch_id());
                if (null == validationError) {
                    interface_data_sms.setStatus_v("Failed");
                    interface_data_sms.setStatus_v_desc("Failed Validation Rule(s)");
                } else {
                    switch (validationError) {
                        case "Passed":
                            interface_data_sms.setStatus_v("Passed");
                            interface_data_sms.setStatus_v_desc("Passed Validation Rules");
                            interface_data_sms.setStatus_m("Moved");
                            interface_data_sms.setStatus_m_desc("Moved To Base");
                            break;
                        case "Existing Data":
                            interface_data_sms.setStatus_v("Failed");
                            interface_data_sms.setStatus_v_desc("Data for the same period exists");
                            break;
                        case "Failed":
                            interface_data_sms.setStatus_v("Failed");
                            interface_data_sms.setStatus_v_desc("Failed Validation Rule(s)");
                            break;
                        default:
                            interface_data_sms.setStatus_v("Failed");
                            interface_data_sms.setStatus_v_desc("Failed Validation Rule(s)");
                            break;
                    }
                }

//System.out.println("END-VALIDATION-REPORT:" + new Date());
                /**
                 * Save interface_data_sms
                 */
                transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                EIHDMSPersistentManager.instance().getSession().merge(interface_data_sms);
                transaction.commit();
                /**
                 * End Save interface_data_sms
                 */

                //pivot dashboard surge form
                //this.InsertPivotEGPAFSurgeFormData(batch.getBatch_id());
            } catch (SQLException ex) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(ex.getMessage(), ex.getMessage()));
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * For Mobile App Data
     *
     * @param interface_dataList
     * @param report_form_SMS
     * @param report_form_group_SMS
     * @param batch_mob_app
     */
    public void load_interface(List<Interface_data> interface_dataList, Report_form report_form_SMS, Report_form_group report_form_group_SMS, Batch_mob_app batch_mob_app) {
        try {
            PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
            Batch batch;
            loginBean = new LoginBean();
            try {
                loginBean.setUser_detail(User_detail.getUser_detailByORMID(1));
            } catch (PersistentException ex) {
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "";
//            if (!interface_dataList.isEmpty()) {
            batch = newBatch_SMS(transaction);
//                try {
//                    for (Interface_data i : interface_dataList) {
//                        i.setStatus_u("Pass");
//                        i.setStatus_u_desc("Uploaded");
//                        i.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
//                        i.save();
//                    }
//                    transaction.commit();
            //System.out.println("START-INSERT-INTERFACE: " + new Date());
            //3,5,5,5,2,4,4=28
            sql = "INSERT INTO interface_data(batch_id,data_element_id,data_element_value,"
                    + "health_facility_name,parish_name,sub_county_name,county_name,district_name,"
                    + "health_facility_id,parish_id,sub_county_id,county_id,district_id,"
                    + "report_period_year,report_period_quarter,report_period_bi_month,report_period_month,report_period_week,"
                    + "report_period_from_date,report_period_to_date,"
                    + "status_u,status_u_desc,is_deleted,is_active,"
                    + "add_date,add_by,report_form_id,report_form_group_id,entry_mode) "
                    + "VALUES("
                    + "?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,"
                    + "?,?,?,?,"
                    + "?,?,?,?,?)";
            try (
                    Connection connection = loginBean.getMySQLConnection_System_User();
                    PreparedStatement ps = connection.prepareStatement(sql);) {
                connection.setAutoCommit(false);
                int j = 0;
                for (Interface_data i : interface_dataList) {
                    try {
                        ps.setInt(1, batch.getBatch_id());
                    } catch (NullPointerException npe) {
                        ps.setInt(1, 0);
                        ps.setObject(1, null);
                    }
                    try {
                        ps.setInt(2, i.getData_element().getData_element_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(2, null);
                    }
                    try {
                        ps.setString(3, i.getData_element_value());
                    } catch (NullPointerException npe) {
                        ps.setObject(3, null);
                    }
                    try {
                        ps.setString(4, i.getHealth_facility_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(4, null);
                    }
                    try {
                        ps.setString(5, i.getParish_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(5, null);
                    }
                    try {
                        ps.setString(6, i.getSub_county_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(6, null);
                    }
                    try {
                        ps.setString(7, i.getCounty_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(7, null);
                    }
                    try {
                        ps.setString(8, i.getDistrict_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(8, null);
                    }
                    try {
                        ps.setInt(9, i.getHealth_facility_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(9, null);
                    }
                    try {
                        ps.setInt(10, i.getParish_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(10, null);
                    }
                    try {
                        ps.setInt(11, i.getSub_county_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(11, null);
                    }
                    try {
                        ps.setInt(12, i.getCounty_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(12, null);
                    }
                    try {
                        ps.setInt(13, i.getDistrict_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(13, null);
                    }
                    try {
                        ps.setInt(14, i.getReport_period_year());
                    } catch (NullPointerException npe) {
                        ps.setObject(14, null);
                    }
                    try {
                        ps.setInt(15, i.getReport_period_quarter());
                    } catch (NullPointerException npe) {
                        ps.setObject(15, null);
                    }
                    try {
                        ps.setInt(16, i.getReport_period_bi_month());
                    } catch (NullPointerException npe) {
                        ps.setObject(16, null);
                    }
                    try {
                        ps.setInt(17, i.getReport_period_month());
                    } catch (NullPointerException npe) {
                        ps.setObject(17, null);
                    }
                    try {
                        ps.setInt(18, i.getReport_period_week());
                    } catch (NullPointerException npe) {
                        ps.setObject(18, null);
                    }
                    try {
                        ps.setDate(19, new java.sql.Date(i.getReport_period_from_date().getTime()));
                    } catch (NullPointerException npe) {
                        ps.setObject(19, null);
                    }
                    try {
                        ps.setDate(20, new java.sql.Date(i.getReport_period_to_date().getTime()));
                    } catch (NullPointerException npe) {
                        ps.setDate(20, null);
                    }
                    ps.setString(21, "Pass");
                    ps.setString(22, "Uploaded");
                    ps.setInt(23, 0);
                    ps.setInt(24, 1);
                    try {
                        ps.setTimestamp(25, new java.sql.Timestamp(new java.util.Date().getTime()));
                    } catch (NullPointerException npe) {
                        ps.setTimestamp(25, new java.sql.Timestamp(new java.util.Date().getTime()));
                    }
                    try {
                        /**
                         * User Id Loading the data
                         */
                        ps.setInt(26, loginBean.getUser_detail().getUser_detail_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(26, null);
                    }
                    try {
                        ps.setInt(27, i.getReport_form().getReport_form_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(27, null);
                    }
                    try {
                        ps.setInt(28, i.getReport_form_group_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(28, null);
                    }
                    try {
                        ps.setString(29, i.getEntry_mode());
                    } catch (NullPointerException npe) {
                        ps.setString(29, null);
                    }
                    ps.addBatch();
                    j++;
                    if (j % 500 == 0 || j == interface_dataList.size()) {
                        //System.out.println("--execute-J--:" + j);
                        ps.executeBatch();
                    }
                }
//System.out.println("--final-J1--:" + j);
                connection.commit();
//System.out.println("--final-J2--:" + j);
                interface_dataList.clear();
//System.out.println("END-INSERT-INTERFACE:" + new Date());

//Load Base Data
//System.out.println("START-VALIDATION-LOAD-BASE:" + new Date());
                validate_and_load_data_to_base_SMS(batch.getBatch_id(), report_form_SMS, report_form_group_SMS);
//System.out.println("END-VALIDATION-LOAD-BASE:" + new Date());
                /**
                 * Set Batch_Id of interface_data_sms
                 */
                batch_mob_app.setBatch_id(batch.getBatch_id());
//loginBean.saveMessage();
//System.out.println("START-VALIDATION-REPORT:" + new Date());
                String validationError = generate_validation_report_SMS(batch.getBatch_id());
                if (null == validationError) {
                    batch_mob_app.setStatus_m("Failed");
                    batch_mob_app.setStatus_m_desc("Failed Validation Rule(s)");
                } else {
                    switch (validationError) {
                        case "Passed":
                            batch_mob_app.setStatus_m("Moved");
                            batch_mob_app.setStatus_m_desc("Moved To Base");
                            break;
                        case "Existing Data":
                            batch_mob_app.setStatus_m("Failed");
                            batch_mob_app.setStatus_m_desc("Data for the same period exists");
                            break;
                        case "Failed":
                            batch_mob_app.setStatus_m("Failed");
                            batch_mob_app.setStatus_m_desc("Failed Validation Rule(s)");
                            break;
                        default:
                            batch_mob_app.setStatus_m("Failed");
                            batch_mob_app.setStatus_m_desc("Failed Validation Rule(s)");
                            break;
                    }
                }

//System.out.println("END-VALIDATION-REPORT:" + new Date());
                /**
                 * Save interface_data_sms
                 */
                transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                EIHDMSPersistentManager.instance().getSession().merge(batch_mob_app);
                transaction.commit();
                /**
                 * End Save interface_data_sms
                 */

                //pivot dashboard surge form
                this.InsertPivotEGPAFSurgeFormData(batch.getBatch_id());
            } catch (SQLException ex) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(ex.getMessage(), ex.getMessage()));
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * For Patient Level Data Entry
     */
    public void load_interface_patient_level() {
        Batch batch;
        String sql = "";
        if (!interface_datas.isEmpty()) {
            batch = newBatch();
            //System.out.println("START-INSERT-INTERFACE: " + new Date());
            //3,5,5,5,2,4,4=28
            sql = "INSERT INTO interface_data(batch_id,data_element_id,data_element_value,"
                    + "health_facility_name,parish_name,sub_county_name,county_name,district_name,"
                    + "health_facility_id,parish_id,sub_county_id,county_id,district_id,"
                    + "report_period_year,report_period_quarter,report_period_bi_month,report_period_month,report_period_week,"
                    + "report_period_from_date,report_period_to_date,"
                    + "status_u,status_u_desc,is_deleted,is_active,"
                    + "add_date,add_by,report_form_id,report_form_group_id,entry_mode,rec_id) "
                    + "VALUES("
                    + "?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,"
                    + "?,?,?,?,"
                    + "?,?,?,?,?,?)";
            try (
                    Connection connection = loginBean.getMySQLConnection();
                    PreparedStatement ps = connection.prepareStatement(sql);) {
                connection.setAutoCommit(false);
                int j = 0;
                for (Interface_data i : interface_datas) {
                    try {
                        ps.setInt(1, batch.getBatch_id());
                    } catch (NullPointerException npe) {
                        ps.setInt(1, 0);
                        ps.setObject(1, null);
                    }
                    try {
                        ps.setInt(2, i.getData_element().getData_element_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(2, null);
                    }
                    try {
                        ps.setString(3, i.getData_element_value());
                    } catch (NullPointerException npe) {
                        ps.setObject(3, null);
                    }
                    try {
                        ps.setString(4, i.getHealth_facility_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(4, null);
                    }
                    try {
                        ps.setString(5, i.getParish_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(5, null);
                    }
                    try {
                        ps.setString(6, i.getSub_county_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(6, null);
                    }
                    try {
                        ps.setString(7, i.getCounty_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(7, null);
                    }
                    try {
                        ps.setString(8, i.getDistrict_name());
                    } catch (NullPointerException npe) {
                        ps.setObject(8, null);
                    }
                    try {
                        ps.setInt(9, i.getHealth_facility_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(9, null);
                    }
                    try {
                        ps.setInt(10, i.getParish_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(10, null);
                    }
                    try {
                        ps.setInt(11, i.getSub_county_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(11, null);
                    }
                    try {
                        ps.setInt(12, i.getCounty_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(12, null);
                    }
                    try {
                        ps.setInt(13, i.getDistrict_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(13, null);
                    }
                    try {
                        ps.setInt(14, i.getReport_period_year());
                    } catch (NullPointerException npe) {
                        ps.setObject(14, null);
                    }
                    try {
                        ps.setInt(15, i.getReport_period_quarter());
                    } catch (NullPointerException npe) {
                        ps.setObject(15, null);
                    }
                    try {
                        ps.setInt(16, i.getReport_period_bi_month());
                    } catch (NullPointerException npe) {
                        ps.setObject(16, null);
                    }
                    try {
                        ps.setInt(17, i.getReport_period_month());
                    } catch (NullPointerException npe) {
                        ps.setObject(17, null);
                    }
                    try {
                        ps.setInt(18, i.getReport_period_week());
                    } catch (NullPointerException npe) {
                        ps.setObject(18, null);
                    }
                    try {
                        ps.setDate(19, new java.sql.Date(i.getReport_period_from_date().getTime()));
                    } catch (NullPointerException npe) {
                        ps.setObject(19, null);
                    }
                    try {
                        ps.setDate(20, new java.sql.Date(i.getReport_period_to_date().getTime()));
                    } catch (NullPointerException npe) {
                        ps.setDate(20, null);
                    }
                    ps.setString(21, "Pass");
                    ps.setString(22, "Uploaded");
                    ps.setInt(23, 0);
                    ps.setInt(24, 1);
                    try {
                        ps.setTimestamp(25, new java.sql.Timestamp(new java.util.Date().getTime()));
                    } catch (NullPointerException npe) {
                        ps.setTimestamp(25, new java.sql.Timestamp(new java.util.Date().getTime()));
                    }
                    try {
                        ps.setInt(26, loginBean.getUser_detail().getUser_detail_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(26, null);
                    }
                    try {
                        ps.setInt(27, i.getReport_form().getReport_form_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(27, null);
                    }
                    try {
                        ps.setInt(28, i.getReport_form_group_id());
                    } catch (NullPointerException npe) {
                        ps.setObject(28, null);
                    }
                    try {
                        ps.setString(29, i.getEntry_mode());
                    } catch (NullPointerException npe) {
                        ps.setString(29, null);
                    }
                    try {
                        ps.setString(30, i.getRec_id());
                    } catch (NullPointerException npe) {
                        ps.setString(30, null);
                    }
                    ps.addBatch();
                    j++;
                    if (j % 500 == 0 || j == interface_datas.size()) {
                        //System.out.println("--execute-J--:" + j);
                        ps.executeBatch();
                    }
                }
                //System.out.println("--final-J1--:" + j);
                connection.commit();
                //System.out.println("--final-J2--:" + j);
                interface_datas.clear();
                //System.out.println("END-INSERT-INTERFACE:" + new Date());

                //Load Base Data
                //System.out.println("START-VALIDATION-LOAD-BASE:" + new Date());
                validate_and_load_data_to_base_patient_level(batch.getBatch_id());
                //System.out.println("END-VALIDATION-LOAD-BASE:" + new Date());

                loginBean.saveMessage();
                //System.out.println("START-VALIDATION-REPORT:" + new Date());
                generate_validation_report_patient_level(batch.getBatch_id());
                //System.out.println("END-VALIDATION-REPORT:" + new Date());

                RequestContext.getCurrentInstance().execute("PF('validationReport_patient_level').show();");
            } catch (SQLException ex) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(ex.getMessage(), ex.getMessage()));
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void InsertPivotEGPAFSurgeFormData(long aBatchId) {
        String sql = "{call sp_insert_dashboard_surge(?)}";
        try (
                Connection connection = loginBean.getMySQLConnection_System_User();
                CallableStatement cs = connection.prepareCall(sql);) {
            cs.setLong(1, aBatchId);
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void UpdatePivotEGPAFSurgeFormData(long aBatchId) {
        String sql = "{call sp_update_dashboard_surge(?)}";
        try (
                Connection connection = loginBean.getMySQLConnection_System_User();
                CallableStatement cs = connection.prepareCall(sql);) {
            cs.setLong(1, aBatchId);
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getDE_Form(Report_form_group aReport_form_group) {
        String frm = "def_0_0";
        try {
            if (aReport_form_group.getDef_name().length() > 0) {
                frm = aReport_form_group.getDef_name();
            }
        } catch (NullPointerException npe) {

        }
        return frm;
    }

    public void generate_validation_report(int batch_id) {
        try {
            Batch b = Batch.getBatchByORMID(batch_id);
            User_detail user_detail = User_detail.getUser_detailByORMID(b.getAdd_by());
            batchDetails = new BatchDetails();
            batchDetails.setBatchUserName(user_detail.getFirst_name() + " " + user_detail.getSecond_name() + " " + user_detail.getThird_name());
            batchDetails.setBatch(b);
            List<ValidationReport> tempValidationReports = new ArrayList<>();
            List<Object[]> validations = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT DISTINCT district_name,county_name,sub_county_name,parish_name,health_facility_name,status_v,status_v_desc,validation_report.report_form_id,report_form.report_form_name,report_form_group.report_form_group_name FROM validation_report INNER JOIN report_form ON report_form.report_form_id = validation_report.report_form_id INNER JOIN report_form_group ON validation_report.report_form_group_id = report_form_group.report_form_group_id where batch_id=" + batch_id).list();
            int counter = 1;
            failed = 0;
            passed = 0;
            for (Object[] objects : validations) {
                ValidationReport vr = new ValidationReport();
                if (objects[4] != null) {
                    if (objects[0] != null) {
                        vr.DistrictName = objects[0].toString();
                    } else {
                        vr.DistrictName = "";
                    }
                    if (objects[1] != null) {
                        vr.CountyName = objects[1].toString();
                    } else {
                        vr.CountyName = "";
                    }
                    if (objects[2] != null) {
                        vr.Sub_countyName = objects[2].toString();
                    } else {
                        vr.Sub_countyName = "";
                    }
                    if (objects[4] != null) {
                        vr.FacilityName = objects[4].toString();
                    } else {
                        vr.FacilityName = "";
                    }
                    vr.ParishName = "";
                } else if (objects[3] != null) {
                    if (objects[0] != null) {
                        vr.DistrictName = objects[0].toString();
                    } else {
                        vr.DistrictName = "";
                    }
                    if (objects[1] != null) {
                        vr.CountyName = objects[1].toString();
                    } else {
                        vr.CountyName = "";
                    }
                    if (objects[2] != null) {
                        vr.Sub_countyName = objects[2].toString();
                    } else {
                        vr.Sub_countyName = "";
                    }
                    if (objects[3] != null) {
                        vr.ParishName = objects[3].toString();
                    } else {
                        vr.ParishName = "";
                    }
                    vr.FacilityName = "";
                } else {
                    if (objects[0] != null) {
                        vr.DistrictName = objects[0].toString();
                    } else {
                        vr.DistrictName = "";
                    }
                    vr.Sub_countyName = "";
                    vr.ParishName = "";
                    vr.FacilityName = "";
                }
                try {
                    vr.setStatus(objects[5].toString());
                    vr.setValidationDescription(objects[6].toString());
                    if (objects[5].toString().equals("Fail")) {
                        failed++;
                    } else {
                        passed++;
                    }
                } catch (NullPointerException ex) {
                    vr.setValidationDescription("");
                }
                ReportFormName = objects[8].toString();
                ReportFormGroupName = objects[9].toString();
                vr.setReportId(counter);
                tempValidationReports.add(vr);
                counter++;
            }
            validationReportListAll = new ArrayList<>(tempValidationReports);
            //validationReportList = new ArrayList<>(tempValidationReports);

        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * For Patient Level
     *
     * @param batch_id
     */
    public void generate_validation_report_patient_level(int batch_id) {
        try {
            Batch b = Batch.getBatchByORMID(batch_id);
            User_detail user_detail = User_detail.getUser_detailByORMID(b.getAdd_by());
            batchDetails = new BatchDetails();
            batchDetails.setBatchUserName(user_detail.getFirst_name() + " " + user_detail.getSecond_name() + " " + user_detail.getThird_name());
            batchDetails.setBatch(b);
            List<ValidationReport> tempValidationReports = new ArrayList<>();
            List<Object[]> validations = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT DISTINCT district_name,county_name,sub_county_name,parish_name,health_facility_name,status_v,status_v_desc,validation_report.report_form_id,report_form.report_form_name,report_form_group.report_form_group_name,validation_report.rec_id FROM validation_report INNER JOIN report_form ON report_form.report_form_id = validation_report.report_form_id INNER JOIN report_form_group ON validation_report.report_form_group_id = report_form_group.report_form_group_id where batch_id=" + batch_id).list();
            int counter = 1;
            failed = 0;
            passed = 0;
            for (Object[] objects : validations) {
                ValidationReport vr = new ValidationReport();
                if (objects[10] != null) {
                    vr.PatientIdentifier = objects[10].toString();
                }
                if (objects[4] != null) {
                    if (objects[0] != null) {
                        vr.DistrictName = objects[0].toString();
                    } else {
                        vr.DistrictName = "";
                    }
                    if (objects[1] != null) {
                        vr.CountyName = objects[1].toString();
                    } else {
                        vr.CountyName = "";
                    }
                    if (objects[2] != null) {
                        vr.Sub_countyName = objects[2].toString();
                    } else {
                        vr.Sub_countyName = "";
                    }
                    if (objects[4] != null) {
                        vr.FacilityName = objects[4].toString();
                    } else {
                        vr.FacilityName = "";
                    }
                    vr.ParishName = "";
                } else if (objects[3] != null) {
                    if (objects[0] != null) {
                        vr.DistrictName = objects[0].toString();
                    } else {
                        vr.DistrictName = "";
                    }
                    if (objects[1] != null) {
                        vr.CountyName = objects[1].toString();
                    } else {
                        vr.CountyName = "";
                    }
                    if (objects[2] != null) {
                        vr.Sub_countyName = objects[2].toString();
                    } else {
                        vr.Sub_countyName = "";
                    }
                    if (objects[3] != null) {
                        vr.ParishName = objects[3].toString();
                    } else {
                        vr.ParishName = "";
                    }
                    vr.FacilityName = "";
                } else {
                    if (objects[0] != null) {
                        vr.DistrictName = objects[0].toString();
                    } else {
                        vr.DistrictName = "";
                    }
                    vr.Sub_countyName = "";
                    vr.ParishName = "";
                    vr.FacilityName = "";
                }
                try {
                    vr.setStatus(objects[5].toString());
                    vr.setValidationDescription(objects[6].toString());
                    if (objects[5].toString().equals("Fail")) {
                        failed++;
                    } else {
                        passed++;
                    }
                } catch (NullPointerException ex) {
                    vr.setValidationDescription("");
                }
                ReportFormName = objects[8].toString();
                ReportFormGroupName = objects[9].toString();
                vr.setReportId(counter);
                tempValidationReports.add(vr);
                counter++;
            }
            validationReportListAll = new ArrayList<>(tempValidationReports);
            //validationReportList = new ArrayList<>(tempValidationReports);

        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String generate_validation_report_SMS(int batch_id) {
        String validationError = "";
        try {
            Batch b = Batch.getBatchByORMID(batch_id);
            User_detail user_detail = User_detail.getUser_detailByORMID(b.getAdd_by());
            batchDetails = new BatchDetails();
            batchDetails.setBatchUserName(user_detail.getFirst_name() + " " + user_detail.getSecond_name() + " " + user_detail.getThird_name());
            batchDetails.setBatch(b);
            List<ValidationReport> tempValidationReports = new ArrayList<>();
            List<Object[]> validations = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT DISTINCT district_name,county_name,sub_county_name,parish_name,health_facility_name,status_v,status_v_desc,validation_report.report_form_id,report_form.report_form_name,report_form_group.report_form_group_name FROM validation_report INNER JOIN report_form ON report_form.report_form_id = validation_report.report_form_id INNER JOIN report_form_group ON validation_report.report_form_group_id = report_form_group.report_form_group_id where batch_id=" + batch_id).list();
            int counter = 1;
            failed = 0;
            passed = 0;
            for (Object[] objects : validations) {
                ValidationReport vr = new ValidationReport();
                if (objects[4] != null) {
                    if (objects[0] != null) {
                        vr.DistrictName = objects[0].toString();
                    } else {
                        vr.DistrictName = "";
                    }
                    if (objects[1] != null) {
                        vr.CountyName = objects[1].toString();
                    } else {
                        vr.CountyName = "";
                    }
                    if (objects[2] != null) {
                        vr.Sub_countyName = objects[2].toString();
                    } else {
                        vr.Sub_countyName = "";
                    }
                    if (objects[4] != null) {
                        vr.FacilityName = objects[4].toString();
                    } else {
                        vr.FacilityName = "";
                    }
                    vr.ParishName = "";
                } else if (objects[3] != null) {
                    if (objects[0] != null) {
                        vr.DistrictName = objects[0].toString();
                    } else {
                        vr.DistrictName = "";
                    }
                    if (objects[1] != null) {
                        vr.CountyName = objects[1].toString();
                    } else {
                        vr.CountyName = "";
                    }
                    if (objects[2] != null) {
                        vr.Sub_countyName = objects[2].toString();
                    } else {
                        vr.Sub_countyName = "";
                    }
                    if (objects[3] != null) {
                        vr.ParishName = objects[3].toString();
                    } else {
                        vr.ParishName = "";
                    }
                    vr.FacilityName = "";
                } else {
                    if (objects[0] != null) {
                        vr.DistrictName = objects[0].toString();
                    } else {
                        vr.DistrictName = "";
                    }
                    vr.Sub_countyName = "";
                    vr.ParishName = "";
                    vr.FacilityName = "";
                }
                try {
                    vr.setStatus(objects[5].toString());
                    vr.setValidationDescription(objects[6].toString());
                    if (objects[6].toString().equals("=>Passed Validation Rules")) {
                        validationError = "Passed";
                    } else if (objects[6].toString().contains("=>Data for the same period")) {
                        validationError = "Existing Data";
                    } else if (objects[6].toString().contains("=>Failed Validation Rule:")) {
                        validationError = "Failed";
                    } else {
                        validationError = "Failed";
                    }
                    if (objects[5].toString().equals("Fail")) {
                        failed++;
                    } else {
                        passed++;
                    }
                } catch (NullPointerException ex) {
                    vr.setValidationDescription("");
                }
                ReportFormName = objects[8].toString();
                ReportFormGroupName = objects[9].toString();
                vr.setReportId(counter);
                tempValidationReports.add(vr);
                counter++;
            }
            validationReportListAll = new ArrayList<>(tempValidationReports);
            //validationReportList = new ArrayList<>(tempValidationReports);

        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class
                    .getName()).log(Level.SEVERE, null, ex);
            validationError = "Failed Validation";
        }
        return validationError;
    }

    public List<ValidationReport> generate_validation_report() {
        validationReportList = new ArrayList<>();
        try {
            List<ValidationReport> tempValidationReports = new ArrayList<>();
            List<Object[]> validations = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT DISTINCT validation_report.batch_id,CONCAT(user_detail.second_name,' ',user_detail.third_name,' ',user_detail.first_name) AS AddedBy,DATE_FORMAT(batch.add_date,'%d %b %Y %T:%f') AS Add_Date,validation_report.report_form_id,report_form.report_form_name,report_form_group.report_form_group_name FROM validation_report INNER JOIN user_detail ON user_detail.user_detail_id = validation_report.add_by INNER JOIN batch ON validation_report.batch_id = batch.batch_id INNER JOIN report_form ON report_form.report_form_id = validation_report.report_form_id INNER JOIN report_form_group ON validation_report.report_form_group_id = report_form_group.report_form_group_id order by batch_id desc").list();
            for (Object[] objects : validations) {
                ValidationReport vr = new ValidationReport();
                vr.setBatch_id(Integer.parseInt(objects[0].toString()));
                vr.AddedBy = objects[1].toString();
                vr.setAddDate(objects[2].toString());
                vr.setReportFormId(Integer.parseInt(objects[3].toString()));
                vr.setReportFormName(objects[4].toString());
                vr.setReportFormGroupName(objects[5].toString());
                //tempValidationReports.add(vr);
                validationReportList.add(vr);

            }
            //validationReportList = new ArrayList<>(tempValidationReports);
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return validationReportList;
    }

    public void uploadexcel(InputStream inputStream) {
        //FileInputStream fis = null;
        try {
            //Report_form report_form = Report_form.getReport_formByORMID(reportformid);
            if (report_form != null && report_form_group != null) {
                if (report_period_year == null) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Year Field is Required for All Forms!", "Year Field is Required for All Forms!"));
                    return;
                }
                if (report_period_from_date == null) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Date From Field is Required for All Forms!", "Date From Field is Required for All Forms!"));
                    return;
                }
                if (report_period_to_date == null) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Date To Field is Required for All Forms!", "Date To Field is Required for All Forms!"));
                    return;
                }
                if (report_period_year == null) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Year Field is Required for All Forms!", "Year Field is Required for All Forms!"));
                    return;
                }
                if (report_form.getReport_form_frequency().equals("Quarterly") && report_period_quarter == null) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Quarter Field is Required for Quarterly Forms!", "Quarter Field is Required for Quarterly Forms!"));
                    return;
                }
                if (report_form.getReport_form_frequency().equals("Monthly") && report_period_month == null) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Month Field is Required for Monthly Forms!", "Month Field is Required for Monthly Forms!"));
                    return;
                }
                if (report_form.getReport_form_frequency().equals("Weekly") && report_period_week == null) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Week Field is Required for Monthly Forms!", "Week Field is Required for Weekly Forms!"));
                    return;
                }
                //fis = new FileInputStream(inputStream);

                // Using XSSF for xlsx format, for xls use HSSF
                //Workbook workbook = new XSSFWorkbook(fis);
                org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(inputStream);

                //int numberOfSheets = workbook.getNumberOfSheets();
                org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

                //looping over each workbook sheet
//            for (int i = 0; i < numberOfSheets; i++) {
//                Sheet sheet = workbook.getSheetAt(i);
                List<Data_element> data_elements = (List<Data_element>) EIHDMSPersistentManager.instance().getSession().createQuery("select de from Data_element de INNER JOIN de.report_form_group fg where de.report_form=" + report_form.getReport_form_id() + " and de.report_form_group=" + report_form_group.getReport_form_group_id() + " order by fg.group_order,de.group_column_number ASC").list();

                /**
                 * Set Column Order
                 */
                Map demap = new HashMap();
                int tempcounter = 0;
                if (report_form.getLowest_report_form_level().equals("Parish") || report_form.getLowest_report_form_level().equals("Facility")) {
                    tempcounter = 3;
                } else {
                    tempcounter = 1;
                }

                for (Data_element de : data_elements) {
                    demap.put(tempcounter, de);
                    tempcounter++;
                }

                Iterator<Row> rowIterator = sheet.iterator();
                int x = 0;
                //iterating over each row
                rowdatas = new ArrayList<>();
                interface_datas = new ArrayList<>();
                while (rowIterator.hasNext()) {
                    if (x > 0) {
                        Row row = rowIterator.next();
                        //Iterating over each cell (column wise)  in a particular row.
                        String facility_name = "";
                        String parish_name = "";
                        String district_name = "";
                        String county_name = "";
                        String sub_county_name = "";
                        //Cell cell = row.getCell(1);
                        Iterator<Cell> cellIterator1 = row.cellIterator();
                        int counter = 0;
                        while (cellIterator1.hasNext()) {
                            Cell cell = cellIterator1.next();
                            counter++;
                        }
                        if (row.getRowNum() == 0) {
                            if ((counter - 3) != data_elements.size() && report_form.getLowest_report_form_level().equals("Facility")) {
                                FacesContext context = FacesContext.getCurrentInstance();
                                context.addMessage(null, new FacesMessage("Invalid Upload due to Number Of Columns", "Invalid Upload due to  Number Of Columns"));
                                return;
                            }
                            if ((counter - 3) != data_elements.size() && report_form.getLowest_report_form_level().equals("Parish")) {
                                FacesContext context = FacesContext.getCurrentInstance();
                                context.addMessage(null, new FacesMessage("Invalid Upload due to Number Of Columns", "Invalid Upload due to  Number Of Columns"));
                                return;
                            }
                            if ((counter - 1) != data_elements.size() && report_form.getLowest_report_form_level().equals("District")) {
                                FacesContext context = FacesContext.getCurrentInstance();
                                context.addMessage(null, new FacesMessage("Invalid Upload due to Number Of Columns", "Invalid Upload due to  Number Of Columns"));
                                return;
                            }
                        }

                        Iterator<Cell> cellIterator2 = row.cellIterator();
                        if (row.getRowNum() > 0) {
                            if (report_form.getLowest_report_form_level().equals("Facility")) {
                                district_name = row.getCell(0).getStringCellValue();
                                //county_name = row.getCell(1).getStringCellValue();
                                sub_county_name = row.getCell(1).getStringCellValue();
                                facility_name = row.getCell(2).getStringCellValue();
                            }
                            if (report_form.getLowest_report_form_level().equals("Parish")) {
                                district_name = row.getCell(0).getStringCellValue();
                                //county_name = row.getCell(1).getStringCellValue();
                                sub_county_name = row.getCell(1).getStringCellValue();
                                parish_name = row.getCell(2).getStringCellValue();
                            }
                            if (report_form.getLowest_report_form_level().equals("District")) {
                                district_name = row.getCell(0).getStringCellValue();
                            }
                            district_name = district_name.trim();
                            sub_county_name = sub_county_name.trim();
                            parish_name = parish_name.trim();
                            facility_name = facility_name.trim();
                        }
                        while (cellIterator2.hasNext()) {
                            Cell cell = cellIterator2.next();
                            int cellindex = cell.getColumnIndex();
                            if (row.getRowNum() > 0 && cellindex >= 0) {
                                Iterator it = demap.entrySet().iterator();
                                while (it.hasNext()) {
                                    Map.Entry pair = (Map.Entry) it.next();
                                    Interface_data interface_data = new Interface_data();
                                    if (cellindex > 0 && (int) pair.getKey() == cellindex && report_form.getLowest_report_form_level().equals("District")) {
                                        if (district_name.contains("''") || !district_name.contains("'")) {
                                            interface_data.setDistrict_name(district_name);
                                        } else {
                                            interface_data.setDistrict_name(district_name.replace("'", "''"));
                                        }
                                        //interface_data.setSub_county_name(sub_county_name.replace("'", "''"));
                                        //interface_data.setParish_name(parish_name.replace("'", "''"));
                                        //interface_data.setHealth_facility_name(facility_name.replace("'", "''"));
                                        /**
                                         * Read Data values
                                         */
                                        read_excel_data(interface_data, pair, cell);
                                        /**
                                         * End Read Data values
                                         */
                                        interface_datas.add(interface_data);
                                    }
                                    if (cellindex > 2 && (int) pair.getKey() == cellindex && (report_form.getLowest_report_form_level().equals("Parish") || report_form.getLowest_report_form_level().equals("Facility"))) {
                                        //interface_data.setDistrict_name(district_name.replace("'", "''"));
                                        if (district_name.contains("''") || !district_name.contains("'")) {
                                            interface_data.setDistrict_name(district_name);
                                        } else {
                                            interface_data.setDistrict_name(district_name.replace("'", "''"));
                                        }
                                        //interface_data.setSub_county_name(sub_county_name.replace("'", "''"));
                                        if (sub_county_name.contains("''") || !sub_county_name.contains("'")) {
                                            interface_data.setSub_county_name(sub_county_name);
                                        } else {
                                            interface_data.setSub_county_name(sub_county_name.replace("'", "''"));
                                        }
                                        //interface_data.setParish_name(parish_name.replace("'", "''"));
                                        if (parish_name.contains("''") || !parish_name.contains("'")) {
                                            interface_data.setParish_name(parish_name);
                                        } else {
                                            interface_data.setParish_name(parish_name.replace("'", "''"));
                                        }
                                        //interface_data.setHealth_facility_name(facility_name.replace("'", "''"));
                                        if (facility_name.contains("''") || !facility_name.contains("'")) {
                                            interface_data.setHealth_facility_name(facility_name);
                                        } else {
                                            interface_data.setHealth_facility_name(facility_name.replace("'", "''"));
                                        }
                                        /**
                                         * Read Data values
                                         */
                                        read_excel_data(interface_data, pair, cell);
                                        /**
                                         * End Read Data values
                                         */
                                        interface_datas.add(interface_data);
                                    }
                                }
                            }
                        }
                    }
                    x++;
                }

            }
            //fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (InvalidFormatException ex) {
            Logger.getLogger(UploadBean.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void read_excel_data(Interface_data interface_data, Map.Entry pair, Cell cell) {
        /**
         * Set Entry Mode
         */
        interface_data.setEntry_mode("UPLOAD");
        /**
         * End Set Entry Mode
         */
        interface_data.setData_element((Data_element) pair.getValue());
        interface_data.setReport_period_from_date(report_period_from_date);
        interface_data.setReport_form(report_form);
        interface_data.setReport_form_group_id(report_form_group.getReport_form_group_id());
        interface_data.setReport_period_to_date(report_period_to_date);
        interface_data.setFinancial_year(financial_year);
        interface_data.setReport_period_quarter(report_period_quarter);
        interface_data.setReport_period_bi_month(report_period_bi_month);
        interface_data.setReport_period_month(report_period_month);
        interface_data.setReport_period_week(report_period_week);
        interface_data.setReport_period_year(report_period_year);
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                interface_data.setData_element_value(cell.getStringCellValue().replace("'", "''"));
                break;
            case Cell.CELL_TYPE_NUMERIC:
                interface_data.setData_element_value(String.valueOf(cell.getNumericCellValue()));
                break;
            case Cell.CELL_TYPE_FORMULA:
                switch (cell.getCachedFormulaResultType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        interface_data.setData_element_value(String.valueOf(cell.getNumericCellValue()));
                        break;
                    case Cell.CELL_TYPE_STRING:
                        interface_data.setData_element_value(cell.getStringCellValue().replace("'", "''"));
                        break;
                }
                break;
            case Cell.CELL_TYPE_BLANK:
                interface_data.setData_element_value("NULL");
                break;
            default:
                break;
        }
        setlocationids(interface_data);
    }

    public void generate_insertstring(InputStream inputStream) {
        //FileInputStream fis = null;
        try {
            if (table_string == null || database_type == null) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Please specify the database type and table name", "Please specify the database type and table name"));
                return;
            }
            if (table_string.isEmpty() || database_type.isEmpty()) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Please specify the database type and table name", "Please specify the database type and table name"));
                return;
            }
            // Using XSSF for xlsx format, for xls use HSSF
            //Workbook workbook = new XSSFWorkbook(fis);
            org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(inputStream);

            //int numberOfSheets = workbook.getNumberOfSheets();
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            int x = 0;
            //iterating over each row
            rowdatas = new ArrayList<>();
            interface_datas = new ArrayList<>();
            String column_headers = "";
            String data_values = "";
            insert_string = "";
            int counter = 0;
            while (rowIterator.hasNext()) {
                if (x > 0) {
                    Row row = rowIterator.next();
                    if (row.getRowNum() == 0) {
                        Iterator<Cell> cellIterator = row.cellIterator();
                        counter = 0;
                        while (cellIterator.hasNext()) {
                            Cell cell = cellIterator.next();
                            if (counter == 0) {
                                if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                                    if (database_type.equals("MY SQL")) {
                                        column_headers += ("`" + cell.getStringCellValue().replace("'", "''") + "`");
                                    } else if (database_type.equals("SQL SERVER")) {
                                        column_headers += ("[" + cell.getStringCellValue().replace("'", "''") + "]");
                                    }
                                } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                                    if (database_type.equals("MY SQL")) {
                                        column_headers += ("`" + cell.getNumericCellValue() + "`");
                                    } else if (database_type.equals("SQL SERVER")) {
                                        column_headers += ("[" + cell.getNumericCellValue() + "]");
                                    }
                                }
                            }
                            if (counter > 0) {
                                if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                                    if (database_type.equals("MY SQL")) {
                                        column_headers += ("," + "`" + cell.getStringCellValue().replace("'", "''") + "`");
                                    } else if (database_type.equals("SQL SERVER")) {
                                        column_headers += ("," + "[" + cell.getStringCellValue().replace("'", "''") + "]");
                                    }
                                } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                                    if (database_type.equals("MY SQL")) {
                                        column_headers += ("," + "`" + cell.getNumericCellValue() + "`");
                                    } else if (database_type.equals("SQL SERVER")) {
                                        column_headers += ("," + "[" + cell.getNumericCellValue() + "]");
                                    }
                                }
                            }
                            counter++;
                        }
                    }
                    //Iterating over each cell (column wise)  in a particular row.
                    Iterator<Cell> cellIterator2 = row.cellIterator();
                    counter = 0;
                    data_values = "";
                    while (cellIterator2.hasNext()) {
                        Cell cell = cellIterator2.next();
                        //System.out.println(cell.getCellType());
                        if (row.getRowNum() > 0) {
                            //Cell cell = cellIterator2.next();
                            if (counter == 0) {
                                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                    data_values += ("'" + cell.getStringCellValue().trim().replace("'", "''") + "'");
                                } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                                    data_values += (cell.getNumericCellValue());
                                } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK || cell.getCellType() == Cell.CELL_TYPE_ERROR) {
                                    data_values += ("NULL");
                                } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                                    switch (cell.getCachedFormulaResultType()) {
                                        case Cell.CELL_TYPE_NUMERIC:
                                            //System.out.println("Last evaluated as: " + cell.getNumericCellValue());
                                            data_values += (cell.getNumericCellValue());
                                            break;
                                        case Cell.CELL_TYPE_STRING:
                                            //System.out.println("Last evaluated as \"" + cell.getRichStringCellValue() + "\"");
                                            data_values += ("'" + cell.getRichStringCellValue() + "'");
                                            break;
                                    }

                                }
                            }
                            if (counter > 0) {
                                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                    data_values += (",'" + cell.getStringCellValue().trim().replace("'", "''") + "'");
                                } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                                    data_values += ("," + cell.getNumericCellValue());
                                } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK || cell.getCellType() == Cell.CELL_TYPE_ERROR) {
                                    data_values += (",NULL");
                                } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                                    switch (cell.getCachedFormulaResultType()) {
                                        case Cell.CELL_TYPE_NUMERIC:
                                            //System.out.println("Last evaluated as: " + cell.getNumericCellValue());
                                            data_values += ("," + cell.getNumericCellValue());
                                            break;
                                        case Cell.CELL_TYPE_STRING:
                                            //System.out.println("Last evaluated as \"" + cell.getRichStringCellValue() + "\"");
                                            //data_values += (cell.getRichStringCellValue());
                                            data_values += (",'" + cell.getRichStringCellValue() + "'");
                                            break;
                                    }
                                }
                            }
                        }
                        counter++;
                    }
                    if (row.getRowNum() > 0) {
                        insert_string += "insert into " + table_string + " (" + column_headers + ") values(" + data_values + ");\n";
                    }
                    //System.out.println(insert_string);
                    //System.out.println(row.getRowNum());
                }
                x++;
            }
            //}
            //fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (InvalidFormatException ex) {
            Logger.getLogger(UploadBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the data_elements
     */
    public List<Data_element> getData_elements() {
        return data_elements;
    }

    /**
     * @param data_elements the data_elements to set
     */
    public void setData_elements(List<Data_element> data_elements) {
        this.data_elements = data_elements;
    }

    public void refreshData_elements(Report_form report_form, Report_form_group report_form_group) {
        String sql = "";
        data_elements = new ArrayList<Data_element>();
        try {
            if (report_form != null && report_form_group != null) {
                sql = "select de from Data_element de INNER JOIN de.report_form_group fg where de.report_form=" + report_form + " and de.report_form_group=" + report_form_group + " order by fg.group_order,de.group_column_number ASC";
                data_elements = (List<Data_element>) EIHDMSPersistentManager.instance().getSession().createQuery(sql).list();
                this.createInterface_datas(data_elements);

            }
        } catch (Exception ex) {
            Logger.getLogger(UploadBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void refreshData_elements_patient_level(Report_form report_form, Report_form_group report_form_group) {
        String sql = "";
        data_elements = new ArrayList<Data_element>();
        try {
            if (report_form != null && report_form_group != null) {
                sql = "select de from Data_element de INNER JOIN de.report_form_group fg where de.report_form=" + report_form + " and de.report_form_group=" + report_form_group + " order by fg.group_order,de.group_column_number ASC";
                data_elements = (List<Data_element>) EIHDMSPersistentManager.instance().getSession().createQuery(sql).list();
                this.createInterface_datas(data_elements);
                load_list_for_entry(report_form);
            }
        } catch (Exception ex) {
            Logger.getLogger(UploadBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void createInterface_datas(List<Data_element> aData_elements) {
        Interface_data interface_data;
        if (null != aData_elements) {
            interface_datas = new ArrayList<>();
            for (Data_element data_element : aData_elements) {
                interface_data = new Interface_data();
                interface_data.setData_element(data_element);
                interface_data.setData_element_value("");
                try {
                    interface_data.setHealth_facility_id(this.getHealth_facility().getHealth_facility_id());
                    interface_data.setHealth_facility_name(this.getHealth_facility().getHealth_facility_name());
                } catch (NullPointerException npe) {
                    interface_data.setHealth_facility_id(null);
                    interface_data.setHealth_facility_name(null);
                }
                try {
                    interface_data.setDistrict_id(this.getDistrict().getDistrict_id());
                    interface_data.setDistrict_name(this.getDistrict().getDistrict_name());
                } catch (NullPointerException npe) {
                    interface_data.setDistrict_id(null);
                    interface_data.setDistrict_name(null);
                }
                try {
                    interface_data.setCounty_id(this.getCounty().getCounty_id());
                    interface_data.setCounty_name(this.getCounty().getCounty_name());
                } catch (NullPointerException npe) {
                    interface_data.setCounty_id(null);
                    interface_data.setCounty_name(null);
                }
                try {
                    interface_data.setSub_county_id(this.getSub_county().getSub_county_id());
                    interface_data.setSub_county_name(this.getSub_county().getSub_county_name());
                } catch (NullPointerException npe) {
                    interface_data.setSub_county_id(null);
                    interface_data.setSub_county_name(null);
                }
                try {
                    interface_data.setParish_id(this.getParish().getParish_id());
                    interface_data.setParish_name(this.getParish().getParish_name());
                } catch (NullPointerException npe) {
                    interface_data.setParish_id(null);
                    interface_data.setParish_name(null);
                }
                interface_data.setFinancial_year(this.getFinancial_year());
                interface_data.setReport_period_year(this.getReport_period_year());
                interface_data.setReport_period_quarter(this.getReport_period_quarter());
                interface_data.setReport_period_from_date(this.getReport_period_from_date());
                interface_data.setReport_period_to_date(this.getReport_period_to_date());
                interface_data.setReport_period_month(this.getReport_period_month());
                interface_data.setReport_period_week(this.getReport_period_week());
                interface_data.setReport_period_bi_month(this.getReport_period_bi_month());
                interface_data.setIs_deleted(0);
                interface_data.setIs_active(1);
                interface_data.setReport_form(report_form);
                interface_data.setReport_form_group_id(report_form_group.getReport_form_group_id());
                if (report_form.getLowest_report_form_level().equals("Facility")) {
                    this.parish = this.getHealth_facility().getParish();
                    interface_data.setParish_id(this.parish.getParish_id());
                    interface_data.setParish_name(this.parish.getParish_name());
                    this.sub_county = this.parish.getSub_county();
                    interface_data.setSub_county_id(this.sub_county.getSub_county_id());
                    interface_data.setSub_county_name(this.sub_county.getSub_county_name());
                    this.county = this.sub_county.getCounty();
                    interface_data.setCounty_id(this.county.getCounty_id());
                    interface_data.setCounty_name(this.county.getCounty_name());
                    this.district = this.county.getDistrict();
                    interface_data.setDistrict_id(this.district.getDistrict_id());
                    interface_data.setDistrict_name(this.district.getDistrict_name());
                }
                if (report_form.getLowest_report_form_level().equals("Parish")) {
                    this.sub_county = this.parish.getSub_county();
                    interface_data.setSub_county_id(this.sub_county.getSub_county_id());
                    interface_data.setSub_county_name(this.sub_county.getSub_county_name());
                    this.county = this.sub_county.getCounty();
                    interface_data.setCounty_id(this.county.getCounty_id());
                    interface_data.setCounty_name(this.county.getCounty_name());
                    this.district = this.county.getDistrict();
                    interface_data.setDistrict_id(this.district.getDistrict_id());
                    interface_data.setDistrict_name(this.district.getDistrict_name());
                }
                if (report_form.getLowest_report_form_level().equals("District")) {
                    interface_data.setDistrict_id(this.district.getDistrict_id());
                    interface_data.setDistrict_name(this.district.getDistrict_name());
                }
                /**
                 * Entry Mode
                 */
                interface_data.setEntry_mode("WEB");
                interface_datas.add(interface_data);
            }
        }
    }

    public Interface_data getInterface_dataCell(String aData_element_code) {
        int n = 0;
        Interface_data interface_data = new Interface_data();
        try {
            n = this.interface_datas.size();
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    if (this.interface_datas.get(i).getData_element().getData_element_code().equals(aData_element_code)) {
                        interface_data = this.interface_datas.get(i);
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return interface_data;
    }
//    public Interface_data getInterface_dataCell(long aData_element_id) {
//        int n = 0;
//        Interface_data interface_data = new Interface_data();
//        try {
//            n = this.interface_datas.size();
//            if (n > 0) {
//                for (int i = 0; i < n; i++) {
//                    if (this.interface_datas.get(i).getData_element().getData_element_id()== aData_element_id) {
//                        interface_data = this.interface_datas.get(i);
//                        break;
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return interface_data;
//    }

    /**
     * @return the health_facility
     */
    public Health_facility getHealth_facility() {
        return health_facility;
    }

    /**
     * @param health_facility the health_facility to set
     */
    public void setHealth_facility(Health_facility health_facility) {
        this.health_facility = health_facility;
    }

    public List<Health_facility> completeHealth_facility(String query) {
        List<Health_facility> filteredHealth_facilities = new ArrayList<>();
        try {
            filteredHealth_facilities = (List<Health_facility>) EIHDMSPersistentManager.instance().getSession().createQuery("select hf FROM Health_facility  hf where hf.is_deleted<>1 AND hf.is_active<>0 AND hf.health_facility_name like '%" + query + "%'").list();

        } catch (PersistentException ex) {
            Logger.getLogger(Health_facilityBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return filteredHealth_facilities;
    }

    public List<Parish> completeParish(String query) {
        List<Parish> filteredParishes = new ArrayList<>();
        try {
            filteredParishes = (List<Parish>) EIHDMSPersistentManager.instance().getSession().createQuery("select p FROM Parish  p where p.is_deleted<>1 AND p.is_active<>0 AND p.parish_name like '%" + query + "%'").list();

        } catch (PersistentException ex) {
            Logger.getLogger(ParishBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return filteredParishes;
    }

    public List<District> completeDistrict(String query) {
        List<District> filteredDistricts = new ArrayList<>();
        try {
            filteredDistricts = (List<District>) EIHDMSPersistentManager.instance().getSession().createQuery("select d FROM District  d where d.is_deleted<>1 AND d.is_active<>0 AND d.district_name like '%" + query + "%'").list();

        } catch (PersistentException ex) {
            Logger.getLogger(DistrictBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return filteredDistricts;
    }

    public void dataentry_load_interface() {
        if (!interface_datas.isEmpty()) {
            try {
                /**
                 * Load Interface Data
                 */
                PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                for (Interface_data i : interface_datas) {
                    i.setIs_active(1);
                    i.setAdd_date(new Timestamp(new Date().getTime()));
                    i.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
                    i.setIs_deleted(0);
                    i.save();
                }
                transaction.commit();
                /**
                 * Load Base Data
                 */
                transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                List<Interface_data> interface_datas_tobase = (List<Interface_data>) EIHDMSPersistentManager.instance().getSession().createQuery("SELECT i FROM Interface_data i where i.status='Not Moved' AND i.data_element.report_form=" + report_form.getReport_form_id()).list();
                for (Interface_data i : interface_datas_tobase) {
                    List<Health_facility> health_facilityList = Health_facility.queryHealth_facility("health_facility_name='" + i.getHealth_facility_name() + "'", null);
                    if (health_facilityList.size() == 1) {
                        Base_data base_data = Base_data.createBase_data();
                        base_data.setData_element(i.getData_element());
                        base_data.setData_element_value(i.getData_element_value());
                        base_data.setData_element_value(i.getData_element_value());
                        Health_facility health_facility = Health_facility.loadHealth_facilityByQuery("health_facility_name='" + i.getHealth_facility_name() + "'", null); //AND district_id=" + (district != null ? district.getDistrict_id() : 0) + " AND parish_id=" + (parish != null ? parish.getParish_id() : 0), null);
                        base_data.setHealth_facility(health_facility);
                        base_data.setDistrict(health_facility.getDistrict());
                        base_data.setParish(health_facility.getParish());
                        base_data.setFinancial_year(i.getFinancial_year());
                        base_data.setReport_period_quarter(i.getReport_period_quarter());
                        base_data.setReport_period_from_date(i.getReport_period_from_date());
                        base_data.setReport_period_to_date(i.getReport_period_to_date());
                        //base_data.setReport_period_name(i.getReport_period_name());
                        base_data.setReport_period_bi_month(i.getReport_period_bi_month());
                        base_data.setIs_active(1);
                        base_data.setAdd_date(new Timestamp(new Date().getTime()));
                        base_data.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
                        base_data.setIs_deleted(0);
                        /**
                         * Save Base Data
                         */
                        base_data.save();
                        /**
                         * Modify Interface Data
                         */
                        //i.setStatus("Moved");
                        //i.setStatus_desc("Moved to base successfully");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                    if (health_facilityList.size() > 1) {
                        i.setStatus_v("Fail");
                        i.setStatus_v_desc("Not moved to base because more than one facility found in facilities table");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                    if (health_facilityList.isEmpty()) {
                        i.setStatus_v("Fail");
                        i.setStatus_v_desc("Not moved to base because facility not found in facilities table");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                    //base_dataBean.setSelected(base_data);
                    //base_dataBean.save(loginBean.getUser_detail().getUser_detail_id());

                    //i.setIs_deleted(0);
                    //interface_dataBean.setSelected(i);
                    //interface_dataBean.save(loginBean.getUser_detail().getUser_detail_id());
                }
                transaction.commit();
                loginBean.saveMessage();

            } catch (PersistentException ex) {
                Logger.getLogger(UploadBean.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            interface_datas = new ArrayList<>();
        }
    }

    /**
     * @return the validationReportFiltered
     */
    public List<ValidationReport> getValidationReportFiltered() {
        return validationReportFiltered;
    }

    /**
     * @param validationReportFiltered the validationReportFiltered to set
     */
    public void setValidationReportFiltered(List<ValidationReport> validationReportFiltered) {
        this.validationReportFiltered = validationReportFiltered;

    }

    public class ValidationReport {

        private String FacilityName;
        private String DistrictName;
        private String CountyName;
        private String ParishName;
        private String Sub_countyName;
        private String ValidationDescription;
        private String Status;
        private String AddedBy;
        private int batch_id;
        private String AddDate;
        private int ReportId;

        private int ReportFormId;
        private String ReportFormName;
        private String ReportFormGroupName;
        private String PatientIdentifier;

        public String getPatientIdentifier() {
            return PatientIdentifier;
        }

        public void setPatientIdentifier(String PatientIdentifier) {
            this.PatientIdentifier = PatientIdentifier;
        }

        public String getReportFormGroupName() {
            return ReportFormGroupName;
        }

        public void setReportFormGroupName(String ReportFormGroupName) {
            this.ReportFormGroupName = ReportFormGroupName;
        }

        public int getReportFormId() {
            return ReportFormId;
        }

        public void setReportFormId(int ReportFormId) {
            this.ReportFormId = ReportFormId;
        }

        public String getReportFormName() {
            return ReportFormName;
        }

        public void setReportFormName(String ReportFormName) {
            this.ReportFormName = ReportFormName;
        }

        public int getReportId() {
            return ReportId;
        }

        public void setReportId(int ReportId) {
            this.ReportId = ReportId;
        }

        public String getCountyName() {
            return CountyName;
        }

        public void setCountyName(String CountyName) {
            this.CountyName = CountyName;
        }

        public String getAddDate() {
            return AddDate;
        }

        public void setAddDate(String AddDate) {
            this.AddDate = AddDate;
        }

        public String getAddedBy() {
            return AddedBy;
        }

        public void setAddedBy(String AddedBy) {
            this.AddedBy = AddedBy;
        }

        public int getBatch_id() {
            return batch_id;
        }

        public void setBatch_id(int batch_id) {
            this.batch_id = batch_id;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getFacilityName() {
            return FacilityName;
        }

        public void setFacilityName(String FacilityName) {
            this.FacilityName = FacilityName;
        }

        public String getValidationDescription() {
            return ValidationDescription;
        }

        public void setValidationDescription(String ValidationDescription) {
            this.ValidationDescription = ValidationDescription;
        }

        public String getDistrictName() {
            return DistrictName;
        }

        public void setDistrictName(String DistrictName) {
            this.DistrictName = DistrictName;
        }

        public String getParishName() {
            return ParishName;
        }

        public String getSub_countyName() {
            return Sub_countyName;
        }

        public void setSub_countyName(String Sub_countyName) {
            this.Sub_countyName = Sub_countyName;
        }

        public void setParishName(String ParishName) {
            this.ParishName = ParishName;
        }

    }

    public class BatchDetails {

        private Batch batch;
        private String BatchUserName;

        public Batch getBatch() {
            return batch;
        }

        public void setBatch(Batch batch) {
            this.batch = batch;
        }

        public String getBatchUserName() {
            return BatchUserName;
        }

        public void setBatchUserName(String BatchUserName) {
            this.BatchUserName = BatchUserName;
        }

    }

    public void setlocationids(Interface_data id) {
        for (LocationHierarchy lh : locationHierarchyList) {
            if (report_form.getLowest_report_form_level().equals("Facility")) {
                if (id.getDistrict_name().toUpperCase().equals(lh.getDistrict_name().toUpperCase()) && id.getSub_county_name().toUpperCase().equals(lh.getSub_county_name().toUpperCase()) && id.getHealth_facility_name().toUpperCase().equals(lh.getHealth_facility_name().toUpperCase())) {
                    id.setDistrict_id(lh.getDistrict_id());
                    id.setCounty_id(lh.getCounty_id());
                    id.setSub_county_id(lh.getSub_county_id());
                    id.setHealth_facility_id(lh.getHealth_facility_id());
                    break;
                }
            }
            if (report_form.getLowest_report_form_level().equals("Parish")) {
                if (id.getDistrict_name().toUpperCase().equals(lh.getDistrict_name().toUpperCase()) && id.getSub_county_name().toUpperCase().equals(lh.getSub_county_name().toUpperCase()) && id.getParish_name().toUpperCase().equals(lh.getParish_name().toUpperCase())) {
                    id.setDistrict_id(lh.getDistrict_id());
                    id.setCounty_id(lh.getCounty_id());
                    id.setSub_county_id(lh.getSub_county_id());
                    id.setParish_id(lh.getParish_id());
                    break;
                }
            }
            if (report_form.getLowest_report_form_level().equals("District")) {
                if (id.getDistrict_name().toUpperCase().equals(lh.getDistrict_name().toUpperCase())) {
                    id.setDistrict_id(lh.getDistrict_id());
                    break;
                }
            }
        }
    }

    public void load_location_hierarchy() {
        String sql = "SELECT * FROM vw_location;";
        ResultSet rs = null;
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery();
            locationHierarchyList = new ArrayList<>();
            while (rs.next()) {
                LocationHierarchy locationHierarchy = new LocationHierarchy();
                locationHierarchy.setDistrict_id(rs.getInt("district_id"));
                locationHierarchy.setCounty_id(rs.getInt("county_id"));
                locationHierarchy.setSub_county_id(rs.getInt("sub_county_id"));
                locationHierarchy.setParish_id(rs.getInt("parish_id"));
                locationHierarchy.setHealth_facility_id(rs.getInt("health_facility_id"));
                locationHierarchy.setDistrict_name(rs.getString("district_name"));
                locationHierarchy.setCounty_name(rs.getString("county_name"));
                locationHierarchy.setSub_county_name(rs.getString("sub_county_name"));
                locationHierarchy.setParish_name(rs.getString("parish_name"));
                locationHierarchy.setHealth_facility_name(rs.getString("health_facility_name"));
                locationHierarchyList.add(locationHierarchy);
            }
            //FacesContext context = FacesContext.getCurrentInstance();
            //context.addMessage(null, new FacesMessage("Deleted successfully", "Deleted successfully"));
        } catch (SQLException se) {
            System.err.println(se.getMessage());
            //FacesContext context = FacesContext.getCurrentInstance();
            //context.addMessage(null, new FacesMessage(se.getMessage(), se.getMessage()));

        }

    }

    public class LocationHierarchy {

        private int district_id;
        private int county_id;
        private int sub_county_id;
        private int parish_id;
        private int health_facility_id;
        private String district_name;
        private String county_name;
        private String sub_county_name;
        private String parish_name;
        private String health_facility_name;

        public int getDistrict_id() {
            return district_id;
        }

        public void setDistrict_id(int district_id) {
            this.district_id = district_id;
        }

        public int getCounty_id() {
            return county_id;
        }

        public void setCounty_id(int county_id) {
            this.county_id = county_id;
        }

        public int getSub_county_id() {
            return sub_county_id;
        }

        public void setSub_county_id(int sub_county_id) {
            this.sub_county_id = sub_county_id;
        }

        public int getParish_id() {
            return parish_id;
        }

        public void setParish_id(int parish_id) {
            this.parish_id = parish_id;
        }

        public int getHealth_facility_id() {
            return health_facility_id;
        }

        public void setHealth_facility_id(int health_facility_id) {
            this.health_facility_id = health_facility_id;
        }

        public String getDistrict_name() {
            return district_name;
        }

        public void setDistrict_name(String district_name) {
            this.district_name = district_name;
        }

        public String getCounty_name() {
            return county_name;
        }

        public void setCounty_name(String county_name) {
            this.county_name = county_name;
        }

        public String getSub_county_name() {
            return sub_county_name;
        }

        public void setSub_county_name(String sub_county_name) {
            this.sub_county_name = sub_county_name;
        }

        public String getParish_name() {
            return parish_name;
        }

        public void setParish_name(String parish_name) {
            this.parish_name = parish_name;
        }

        public String getHealth_facility_name() {
            return health_facility_name;
        }

        public void setHealth_facility_name(String health_facility_name) {
            this.health_facility_name = health_facility_name;
        }
    }
    private String report_form_frequency;
    private List<Object[]> loaded_data_objects;

    private List<Report_form_group> report_form_groupList;
    private List<Report_form> report_formList;

    public List<Report_form_group> returnReport_form_groupList(Report_form report_form) {
        report_form_groupList = new ArrayList<>();
        try {
            report_form_groupList = Report_form_group.queryReport_form_group("report_form_id=" + report_form.getReport_form_id(), "group_order ASC");

        } catch (PersistentException ex) {
            Logger.getLogger(Data_elementBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return report_form_groupList;
    }

    public void refreshGroupList(int aYear, String aFrequency, Report_form aReport_form) {
        String sql = "";
        base_data_objects = new ArrayList<>();
        if (aYear == 0 || aFrequency.length() == 0) {
            report_formList = null;
        }

        if (aReport_form != null) {
            try {
                report_formList = Report_form.queryReport_form("report_form_frequency='" + aFrequency + "' AND report_form_id=" + aReport_form.getReport_form_id(), "report_form_name ASC");

            } catch (PersistentException ex) {
                Logger.getLogger(UploadBean.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                report_formList = Report_form.queryReport_form("report_form_frequency='" + aFrequency + "' AND report_form_id>0", "report_form_name ASC");

            } catch (PersistentException ex) {
                Logger.getLogger(UploadBean.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getLoadedEntitiesMonthly(Report_form rf, Report_form_group fg, int y, int m) {
        String les = "";
        int lei = 0;
        String sql = "select sum(l.loaded_entities) as loaded_entities from loaded_data_summary l \n"
                + "where l.report_form_id=" + rf.getReport_form_id() + " AND report_form_group_id=" + fg.getReport_form_group_id() + " \n"
                + "AND l.report_period_year=" + y + " AND l.report_period_month=" + m;
        ResultSet rs = null;
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery();
            if (rs.next()) {
                lei = rs.getInt("loaded_entities");
            }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
        if (lei == 0) {
            les = "";
        } else {
            les = Integer.toString(lei);
        }
        return les;
    }

    public String getLoadedEntitiesBiMonthly(Report_form rf, Report_form_group fg, int y, int bm) {
        String les = "";
        int lei = 0;
        String sql = "select sum(l.loaded_entities) as loaded_entities from loaded_data_summary l \n"
                + "where l.report_form_id=" + rf.getReport_form_id() + " AND report_form_group_id=" + fg.getReport_form_group_id() + " \n"
                + "AND l.report_period_year=" + y + " AND l.report_period_bi_month=" + bm;
        ResultSet rs = null;
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery();
            if (rs.next()) {
                lei = rs.getInt("loaded_entities");
            }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
        if (lei == 0) {
            les = "";
        } else {
            les = Integer.toString(lei);
        }
        return les;
    }

    public String getLoadedEntitiesQuarterly(Report_form rf, Report_form_group fg, int y, int q) {
        String les = "";
        int lei = 0;
        String sql = "select sum(l.loaded_entities) as loaded_entities from loaded_data_summary l \n"
                + "where l.report_form_id=" + rf.getReport_form_id() + " AND report_form_group_id=" + fg.getReport_form_group_id() + " \n"
                + "AND l.report_period_year=" + y + " AND l.report_period_quarter=" + q;
        ResultSet rs = null;
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery();
            if (rs.next()) {
                lei = rs.getInt("loaded_entities");
            }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
        if (lei == 0) {
            les = "";
        } else {
            les = Integer.toString(lei);
        }
        return les;
    }

    public String getLoadedEntitiesAnnually(Report_form rf, Report_form_group fg, int y) {
        String les = "";
        int lei = 0;
        String sql = "select sum(l.loaded_entities) as loaded_entities from loaded_data_summary l \n"
                + "where l.report_form_id=" + rf.getReport_form_id() + " AND report_form_group_id=" + fg.getReport_form_group_id() + " \n"
                + "AND l.report_period_year=" + y;
        ResultSet rs = null;
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery();
            if (rs.next()) {
                lei = rs.getInt("loaded_entities");
            }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
        if (lei == 0) {
            les = "";
        } else {
            les = Integer.toString(lei);
        }
        return les;
    }

    public String getLoadedEntitiesWeekly(Report_form rf, Report_form_group fg, int y, int w) {
        String les = "";
        int lei = 0;
        String sql = "select sum(l.loaded_entities) as loaded_entities from loaded_data_summary l \n"
                + "where l.report_form_id=" + rf.getReport_form_id() + " AND report_form_group_id=" + fg.getReport_form_group_id() + " \n"
                + "AND l.report_period_year=" + y + " AND l.report_period_week=" + w;
        ResultSet rs = null;
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery();
            if (rs.next()) {
                lei = rs.getInt("loaded_entities");
            }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
        if (lei == 0) {
            les = "";
        } else {
            les = Integer.toString(lei);
        }
        return les;
    }

    /**
     * @return the report_form_frequency
     */
    public String getReport_form_frequency() {
        return report_form_frequency;
    }

    /**
     * @param report_form_frequency the report_form_frequency to set
     */
    public void setReport_form_frequency(String report_form_frequency) {
        this.report_form_frequency = report_form_frequency;
    }

    /**
     * @return the loaded_data_objects
     */
    public List<Object[]> getLoaded_data_objects() {
        return loaded_data_objects;
    }

    /**
     * @param loaded_data_objects the loaded_data_objects to set
     */
    public void setLoaded_data_objects(List<Object[]> loaded_data_objects) {
        this.loaded_data_objects = loaded_data_objects;
    }

    /**
     * @return the report_form_groupList
     */
    public List<Report_form_group> getReport_form_groupList() {
        return report_form_groupList;
    }

    /**
     * @param report_form_groupList the report_form_groupList to set
     */
    public void setReport_form_groupList(List<Report_form_group> report_form_groupList) {
        this.report_form_groupList = report_form_groupList;
    }

    /**
     * @return the report_formList
     */
    public List<Report_form> getReport_formList() {
        return report_formList;
    }

    /**
     * @param report_formList the report_formList to set
     */
    public void setReport_formList(List<Report_form> report_formList) {
        this.report_formList = report_formList;
    }

    public List<Section> returnSections(Report_form report_form, Report_form_group report_form_group) {
        String sql = "";
        sections = new ArrayList<Section>();
        try {
            if (report_form != null && report_form_group != null) {
                sql = "select distinct de.section from Data_element de INNER JOIN de.report_form_group fg where de.report_form=" + report_form + " and de.report_form_group=" + report_form_group + " order by fg.group_order,de.group_column_number ASC";
                sections = (List<Section>) EIHDMSPersistentManager.instance().getSession().createQuery(sql).list();
                //this.createInterface_datas(data_elements);

            }
        } catch (Exception ex) {
            Logger.getLogger(UploadBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return sections;
    }

    public List<Sub_section> returnSub_sections(Report_form report_form, Report_form_group report_form_group, Section section) {
        String sql = "";
        sub_sections = new ArrayList<Sub_section>();
        try {
            if (report_form != null && report_form_group != null && section != null) {
                sql = "select distinct de.sub_section from Data_element de INNER JOIN de.report_form_group fg where de.report_form=" + report_form + " and de.report_form_group=" + report_form_group + " and de.section=" + section + " order by fg.group_order,de.group_column_number ASC";
                sub_sections = (List<Sub_section>) EIHDMSPersistentManager.instance().getSession().createQuery(sql).list();

            }
        } catch (Exception ex) {
            Logger.getLogger(UploadBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return sub_sections;
    }

    /**
     * Start SMS Data functions
     */
    public void load_interface_data_sms(String phone, String sms, String scode) {
        if (phone != null && !phone.isEmpty() && sms != null && !sms.isEmpty()) {
            try {
                Interface_data_sms interface_data_sms = new Interface_data_sms();
                String[] splitString = sms.split(" ");
                interface_data_sms.setAdd_date(new Timestamp(new Date().getTime()));
                interface_data_sms.setPhone(phone);
                interface_data_sms.setReport_form_code(splitString[0]);
                interface_data_sms.setSms(splitString[1]);
                interface_data_sms.setScode(scode);
                interface_data_sms.setStatus_f("R");
                interface_data_sms.setStatus_f_desc("Received");
                interface_data_sms.setIs_deleted(0);
                interface_data_sms.setIs_active(1);
                PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                if (interface_data_sms.getInterface_data_sms_id() > 0) {
                    EIHDMSPersistentManager.instance().getSession().merge(interface_data_sms);
                } else {
                    interface_data_sms.save();
                }

                transaction.commit();

                //loginBean.saveMessage ();
            } catch (PersistentException ex) {
                Logger.getLogger(UploadBean.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void decode_and_load_sms(String sms, String phone, String report_form_code) {
        try {
            interface_datas = new ArrayList<>();
            List<Data_element_sms_position> data_element_sms_positionList = new ArrayList<>();
            /**
             * Read form being loaded
             */
            Report_form sms_report_form = Report_form.loadReport_formByQuery("report_form_code='" + report_form_code + "'", "");
            if (sms_report_form != null) {
                /**
                 * Read report form short code list
                 */
                List<Report_form_short_code> report_form_short_codeList = new ArrayList<>();
                report_form_short_codeList = Report_form_short_code.queryReport_form_short_code("report_form_id=" + sms_report_form.getReport_form_id(), "");
                if (report_form_short_codeList.size() > 0) {
                    /**
                     * Loop through available short codes for one that starts
                     * like current SMS
                     */
                    for (Report_form_short_code object : report_form_short_codeList) {
                        if (sms.toUpperCase().startsWith(object.getStart_code().toUpperCase())) {
                            sms = sms.replace(object.getStart_code(), "");
                            int count = sms.length() - sms.replace(".", "").length();
                            /**
                             * Check if number of separators equals those in SMS
                             */
                            if (count == object.getNumber_of_separators()) {
                                data_element_sms_positionList = Data_element_sms_position.queryData_element_sms_position("report_form_short_code_id=" + object.getReport_form_short_code_id(), "");
                            }
                            break;
                        }
                    }
                }
                /**
                 * Get location info from phone number
                 */
                Phone_contact phone_contact = Phone_contact.loadPhone_contactByQuery("entity_phone='" + phone + "'", null);
                if (phone_contact != null) {
                    set_sms_location(phone_contact);
                }
                /**
                 * Return invalid SMS is size=0
                 */
                if (data_element_sms_positionList.size() > 0) {

                    /**
                     * Split SMS into an array of strings
                     */
                    String[] smsStrings = sms.split(".");

                    for (Data_element_sms_position outer : data_element_sms_positionList) {
                        Interface_data i = new Interface_data();
                        i.setData_element(outer.getData_element());
                        i.setData_element_value(smsStrings[outer.getCode_position() - 1]);
                        if (phone_contact != null) {
                            switch (phone_contact.getEntity_type()) {
                                case "District":
                                    i.setDistrict_id(smsDistrict.getDistrict_id());
                                    i.setDistrict_name(smsDistrict.getDistrict_name());
                                    break;
                                case "Parish":
                                    i.setDistrict_id(smsParish.getSub_county().getCounty().getDistrict().getDistrict_id());
                                    i.setDistrict_name(smsParish.getSub_county().getCounty().getDistrict().getDistrict_name());
                                    i.setCounty_id(smsParish.getSub_county().getCounty().getCounty_id());
                                    i.setCounty_name(smsParish.getSub_county().getCounty().getCounty_name());
                                    i.setSub_county_id(smsParish.getSub_county().getSub_county_id());
                                    i.setCounty_name(smsParish.getSub_county().getSub_county_name());
                                    i.setParish_id(smsParish.getParish_id());
                                    i.setCounty_name(smsParish.getParish_name());
                                    break;
                                case "Facility":
                                    i.setDistrict_id(smsHealth_facility.getDistrict().getDistrict_id());
                                    i.setDistrict_name(smsHealth_facility.getDistrict().getDistrict_name());
                                    i.setCounty_id(smsHealth_facility.getSub_county().getCounty().getCounty_id());
                                    i.setCounty_name(smsHealth_facility.getSub_county().getCounty().getCounty_name());
                                    i.setSub_county_id(smsHealth_facility.getSub_county().getSub_county_id());
                                    i.setCounty_name(smsHealth_facility.getSub_county().getSub_county_name());
                                    i.setParish_id(smsHealth_facility.getParish().getParish_id());
                                    i.setCounty_name(smsHealth_facility.getParish().getParish_name());
                                    i.setHealth_facility_id(smsHealth_facility.getHealth_facility_id());
                                    i.setHealth_facility_name(smsHealth_facility.getHealth_facility_name());
                                    break;
                                default:
                                    break;

                            }
                        }
                    }
                }
            }
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    District smsDistrict;
    County smsCounty;
    Sub_county smsSub_county;
    Parish smsParish;
    Health_facility smsHealth_facility;

    /**
     * Set location from sms phone
     *
     * @param phone_contact
     */
    public void set_sms_location(Phone_contact phone_contact) {
        if (phone_contact != null) {
            try {
                switch (phone_contact.getEntity_type()) {
                    case "District":
                        smsDistrict = District.getDistrictByORMID(phone_contact.getEntity_id());
                        break;
                    case "Parish":
                        smsParish = Parish.getParishByORMID(phone_contact.getEntity_id());
                        break;
                    case "Facility":
                        smsHealth_facility = Health_facility.getHealth_facilityByORMID(phone_contact.getEntity_id());
                        break;
                    default:
                        break;

                }
            } catch (PersistentException ex) {
                Logger.getLogger(UploadBean.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public District getSmsDistrict() {
        return smsDistrict;
    }

    public void setSmsDistrict(District smsDistrict) {
        this.smsDistrict = smsDistrict;
    }

    public County getSmsCounty() {
        return smsCounty;
    }

    public void setSmsCounty(County smsCounty) {
        this.smsCounty = smsCounty;
    }

    public Sub_county getSmsSub_county() {
        return smsSub_county;
    }

    public void setSmsSub_county(Sub_county smsSub_county) {
        this.smsSub_county = smsSub_county;
    }

    public Parish getSmsParish() {
        return smsParish;
    }

    public void setSmsParish(Parish smsParish) {
        this.smsParish = smsParish;
    }

    public Health_facility getSmsHealth_facility() {
        return smsHealth_facility;
    }

    public void setSmsHealth_facility(Health_facility smsHealth_facility) {
        this.smsHealth_facility = smsHealth_facility;
    }

    /**
     * End SMS data functions
     */
    /**
     * Start Patient Level Data
     */
    private int columns = 1;
    private List<Patient_Level_Data> patient_level_data_list = new ArrayList<>();

    public List<Patient_Level_Data> getPatient_level_data_list() {
        return patient_level_data_list;
    }

    public void setPatient_level_data_list(List<Patient_Level_Data> patient_level_data_list) {
        this.patient_level_data_list = patient_level_data_list;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
    List<Data_element> data_elements_inner;

    public List<Data_element> getData_elements_inner() {
        return data_elements_inner;
    }

    public void setData_elements_inner(List<Data_element> data_elements_inner) {
        this.data_elements_inner = data_elements_inner;
    }

    public void load_list_for_entry(Report_form report_form_inner) {
        patient_level_data_list = new ArrayList<>();
        if (report_form_inner != null) {
            try {
                data_elements_inner = Data_element.queryData_element("report_form_id=" + report_form_inner.getReport_form_id(), "group_column_number");
                patient_level_data_list.add(create_new_Patient_Level_Data(data_elements_inner));
            } catch (PersistentException ex) {
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void add_new_patient_data() {
        patient_level_data_list.add(create_new_Patient_Level_Data(data_elements_inner));
    }

    public void remove_patient_data(Patient_Level_Data pld) {
        if (patient_level_data_list.size() > 1) {
            patient_level_data_list.remove(pld);
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("There should be a minimum of one patient level record", "There should be a minimum of one patient level record"));
        }
    }

    public void save_patient_level_data() {
        System.out.println(interface_datas.size());
        un_pivot_patient_level_data();
        /**
         * Load Data
         */
        load_interface_patient_level();
    }

    /**
     * Un Pivot Patient Level Data
     */
    public void un_pivot_patient_level_data() {
        try {
            interface_datas = new ArrayList<>();
            for (Patient_Level_Data patient_Level_Data : patient_level_data_list) {
                Interface_data interface_data;
                if (patient_Level_Data.getDei_1() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_1());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_1()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_2() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_2());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_2()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_3() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_3());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_3()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_4() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_4());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_4()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_5() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_5());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_5()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_6() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_6());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_6()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_7() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_7());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_7()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_8() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_8());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_8()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_9() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_9());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_9()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_10() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_10());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_10()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_11() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_11());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_11()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_12() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_12());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_12()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_13() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_13());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_13()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_14() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_14());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_14()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_15() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_15());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_15()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_16() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_16());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_16()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_17() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_17());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_17()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_18() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_18());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_18()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_19() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_19());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_19()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_20() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_20());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_20()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_21() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_21());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_21()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_22() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_22());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_22()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_23() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_23());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_23()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_24() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_24());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_24()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_25() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_25());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_25()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_26() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_26());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_26()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_27() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_27());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_27()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_28() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_28());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_28()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_29() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_29());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_29()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_30() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_30());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_30()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_31() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_31());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_31()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_32() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_32());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_32()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_33() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_33());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_33()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_34() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_34());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_34()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_35() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_35());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_35()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_36() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_36());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_36()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_37() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_37());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_37()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_38() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_38());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_38()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_39() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_39());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_39()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_40() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_40());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_40()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_41() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_41());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_41()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_42() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_42());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_42()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_43() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_43());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_43()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_44() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_44());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_44()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_45() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_45());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_45()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_46() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_46());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_46()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_47() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_47());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_47()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_48() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_48());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_48()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_49() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_49());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_49()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_50() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_50());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_50()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_50() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_50());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_50()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_51() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_51());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_51()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_52() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_52());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_52()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_53() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_53());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_53()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_54() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_54());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_54()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_55() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_55());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_55()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_56() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_56());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_56()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_57() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_57());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_57()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_58() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_58());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_58()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_59() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_59());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_59()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_60() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_60());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_60()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_61() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_61());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_61()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_62() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_62());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_62()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_63() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_63());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_63()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_64() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_64());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_64()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_65() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_65());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_65()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_66() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_66());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_66()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_67() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_67());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_67()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_68() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_68());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_68()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_69() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_69());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_69()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_70() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_70());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_70()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_71() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_71());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_71()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_72() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_72());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_72()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_73() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_73());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_73()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_74() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_74());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_74()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_75() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_75());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_75()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_76() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_76());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_76()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_77() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_77());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_77()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_78() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_78());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_78()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_79() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_79());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_79()));
                    set_other_patient_level_interface_data_values(interface_data);
                }
                if (patient_Level_Data.getDei_80() != 0) {
                    interface_data = new Interface_data();
                    interface_data.setData_element_value(patient_Level_Data.getDev_80());
                    interface_data.setData_element(Data_element.getData_elementByORMID(patient_Level_Data.getDei_80()));
                    set_other_patient_level_interface_data_values(interface_data);
                }

                String rec_id = null;
                /**
                 * Get Rec_Id
                 */
                for (Interface_data temp_i : interface_datas) {
                    if (temp_i.getData_element().getIs_patient_level_record_id() == 1 && temp_i.getRec_id() == null) {
                        rec_id = temp_i.getData_element_value();
                        break;
                    }
                }
                /**
                 * Set Rec_Id
                 */
                for (Interface_data temp_i : interface_datas) {
                    if (temp_i.getRec_id() == null) {
                        temp_i.setRec_id(rec_id);
                        //break;
                    }
                }
            }
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void set_other_patient_level_interface_data_values(Interface_data interface_data) {
        try {
            interface_data.setHealth_facility_id(this.getHealth_facility().getHealth_facility_id());
            interface_data.setHealth_facility_name(this.getHealth_facility().getHealth_facility_name());
        } catch (NullPointerException npe) {
            interface_data.setHealth_facility_id(null);
            interface_data.setHealth_facility_name(null);
        }
        try {
            interface_data.setDistrict_id(this.getDistrict().getDistrict_id());
            interface_data.setDistrict_name(this.getDistrict().getDistrict_name());
        } catch (NullPointerException npe) {
            interface_data.setDistrict_id(null);
            interface_data.setDistrict_name(null);
        }
        try {
            interface_data.setCounty_id(this.getCounty().getCounty_id());
            interface_data.setCounty_name(this.getCounty().getCounty_name());
        } catch (NullPointerException npe) {
            interface_data.setCounty_id(null);
            interface_data.setCounty_name(null);
        }
        try {
            interface_data.setSub_county_id(this.getSub_county().getSub_county_id());
            interface_data.setSub_county_name(this.getSub_county().getSub_county_name());
        } catch (NullPointerException npe) {
            interface_data.setSub_county_id(null);
            interface_data.setSub_county_name(null);
        }
        try {
            interface_data.setParish_id(this.getParish().getParish_id());
            interface_data.setParish_name(this.getParish().getParish_name());
        } catch (NullPointerException npe) {
            interface_data.setParish_id(null);
            interface_data.setParish_name(null);
        }
        interface_data.setFinancial_year(this.getFinancial_year());
        interface_data.setReport_period_year(this.getReport_period_year());
        interface_data.setReport_period_quarter(this.getReport_period_quarter());
        interface_data.setReport_period_from_date(this.getReport_period_from_date());
        interface_data.setReport_period_to_date(this.getReport_period_to_date());
        interface_data.setReport_period_month(this.getReport_period_month());
        interface_data.setReport_period_week(this.getReport_period_week());
        interface_data.setReport_period_bi_month(this.getReport_period_bi_month());
        interface_data.setIs_deleted(0);
        interface_data.setIs_active(1);
        interface_data.setReport_form(report_form);
        interface_data.setReport_form_group_id(report_form_group.getReport_form_group_id());
        if (report_form.getLowest_report_form_level().equals("Facility")) {
            this.parish = this.getHealth_facility().getParish();
            interface_data.setParish_id(this.parish.getParish_id());
            interface_data.setParish_name(this.parish.getParish_name());
            this.sub_county = this.parish.getSub_county();
            interface_data.setSub_county_id(this.sub_county.getSub_county_id());
            interface_data.setSub_county_name(this.sub_county.getSub_county_name());
            this.county = this.sub_county.getCounty();
            interface_data.setCounty_id(this.county.getCounty_id());
            interface_data.setCounty_name(this.county.getCounty_name());
            this.district = this.county.getDistrict();
            interface_data.setDistrict_id(this.district.getDistrict_id());
            interface_data.setDistrict_name(this.district.getDistrict_name());
        }
        if (report_form.getLowest_report_form_level().equals("Parish")) {
            this.sub_county = this.parish.getSub_county();
            interface_data.setSub_county_id(this.sub_county.getSub_county_id());
            interface_data.setSub_county_name(this.sub_county.getSub_county_name());
            this.county = this.sub_county.getCounty();
            interface_data.setCounty_id(this.county.getCounty_id());
            interface_data.setCounty_name(this.county.getCounty_name());
            this.district = this.county.getDistrict();
            interface_data.setDistrict_id(this.district.getDistrict_id());
            interface_data.setDistrict_name(this.district.getDistrict_name());
        }
        if (report_form.getLowest_report_form_level().equals("District")) {
            interface_data.setDistrict_id(this.district.getDistrict_id());
            interface_data.setDistrict_name(this.district.getDistrict_name());
        }
        /**
         * Entry Mode
         */
        interface_data.setEntry_mode("WEB");
        interface_datas.add(interface_data);
    }

    private Patient_Level_Data create_new_Patient_Level_Data(List<Data_element> data_element_list) {
        int count = 1;
        columns = data_element_list.size();
        Patient_Level_Data patient_Level_Data = new Patient_Level_Data();
        for (Data_element data_element : data_element_list) {
            if (null != data_element.getGroup_column_number()) {
                switch (data_element.getGroup_column_number()) {
                    case 1:
                        patient_Level_Data.setDei_1(data_element.getData_element_id());
                        break;
                    case 2:
                        patient_Level_Data.setDei_2(data_element.getData_element_id());
                        break;
                    case 3:
                        patient_Level_Data.setDei_3(data_element.getData_element_id());
                        break;
                    case 4:
                        patient_Level_Data.setDei_4(data_element.getData_element_id());
                        break;
                    case 5:
                        patient_Level_Data.setDei_5(data_element.getData_element_id());
                        break;
                    case 6:
                        patient_Level_Data.setDei_6(data_element.getData_element_id());
                        break;
                    case 7:
                        patient_Level_Data.setDei_7(data_element.getData_element_id());
                        break;
                    case 8:
                        patient_Level_Data.setDei_8(data_element.getData_element_id());
                        break;
                    case 9:
                        patient_Level_Data.setDei_9(data_element.getData_element_id());
                        break;
                    case 10:
                        patient_Level_Data.setDei_10(data_element.getData_element_id());
                        break;
                    case 11:
                        patient_Level_Data.setDei_11(data_element.getData_element_id());
                        break;
                    case 12:
                        patient_Level_Data.setDei_12(data_element.getData_element_id());
                        break;
                    case 13:
                        patient_Level_Data.setDei_13(data_element.getData_element_id());
                        break;
                    case 14:
                        patient_Level_Data.setDei_14(data_element.getData_element_id());
                        break;
                    case 15:
                        patient_Level_Data.setDei_15(data_element.getData_element_id());
                        break;
                    case 16:
                        patient_Level_Data.setDei_16(data_element.getData_element_id());
                        break;
                    case 17:
                        patient_Level_Data.setDei_17(data_element.getData_element_id());
                        break;
                    case 18:
                        patient_Level_Data.setDei_18(data_element.getData_element_id());
                        break;
                    case 19:
                        patient_Level_Data.setDei_19(data_element.getData_element_id());
                        break;
                    case 20:
                        patient_Level_Data.setDei_20(data_element.getData_element_id());
                        break;
                    case 21:
                        patient_Level_Data.setDei_21(data_element.getData_element_id());
                        break;
                    case 22:
                        patient_Level_Data.setDei_22(data_element.getData_element_id());
                        break;
                    case 23:
                        patient_Level_Data.setDei_23(data_element.getData_element_id());
                        break;
                    case 24:
                        patient_Level_Data.setDei_24(data_element.getData_element_id());
                        break;
                    case 25:
                        patient_Level_Data.setDei_25(data_element.getData_element_id());
                        break;
                    case 26:
                        patient_Level_Data.setDei_26(data_element.getData_element_id());
                        break;
                    case 27:
                        patient_Level_Data.setDei_27(data_element.getData_element_id());
                        break;
                    case 28:
                        patient_Level_Data.setDei_28(data_element.getData_element_id());
                        break;
                    case 29:
                        patient_Level_Data.setDei_29(data_element.getData_element_id());
                        break;
                    case 30:
                        patient_Level_Data.setDei_30(data_element.getData_element_id());
                        break;
                    case 31:
                        patient_Level_Data.setDei_31(data_element.getData_element_id());
                        break;
                    case 32:
                        patient_Level_Data.setDei_32(data_element.getData_element_id());
                        break;
                    case 33:
                        patient_Level_Data.setDei_33(data_element.getData_element_id());
                        break;
                    case 34:
                        patient_Level_Data.setDei_34(data_element.getData_element_id());
                        break;
                    case 35:
                        patient_Level_Data.setDei_35(data_element.getData_element_id());
                        break;
                    case 36:
                        patient_Level_Data.setDei_36(data_element.getData_element_id());
                        break;
                    case 37:
                        patient_Level_Data.setDei_37(data_element.getData_element_id());
                        break;
                    case 38:
                        patient_Level_Data.setDei_38(data_element.getData_element_id());
                        break;
                    case 39:
                        patient_Level_Data.setDei_39(data_element.getData_element_id());
                        break;
                    case 40:
                        patient_Level_Data.setDei_40(data_element.getData_element_id());
                        break;
                    case 41:
                        patient_Level_Data.setDei_41(data_element.getData_element_id());
                        break;
                    case 42:
                        patient_Level_Data.setDei_42(data_element.getData_element_id());
                        break;
                    case 43:
                        patient_Level_Data.setDei_43(data_element.getData_element_id());
                        break;
                    case 44:
                        patient_Level_Data.setDei_44(data_element.getData_element_id());
                        break;
                    case 45:
                        patient_Level_Data.setDei_45(data_element.getData_element_id());
                        break;
                    case 46:
                        patient_Level_Data.setDei_46(data_element.getData_element_id());
                        break;
                    case 47:
                        patient_Level_Data.setDei_47(data_element.getData_element_id());
                        break;
                    case 48:
                        patient_Level_Data.setDei_48(data_element.getData_element_id());
                        break;
                    case 49:
                        patient_Level_Data.setDei_49(data_element.getData_element_id());
                        break;
                    case 50:
                        patient_Level_Data.setDei_50(data_element.getData_element_id());
                        break;
                    case 51:
                        patient_Level_Data.setDei_51(data_element.getData_element_id());
                        break;
                    case 52:
                        patient_Level_Data.setDei_52(data_element.getData_element_id());
                        break;
                    case 53:
                        patient_Level_Data.setDei_53(data_element.getData_element_id());
                        break;
                    case 54:
                        patient_Level_Data.setDei_54(data_element.getData_element_id());
                        break;
                    case 55:
                        patient_Level_Data.setDei_55(data_element.getData_element_id());
                        break;
                    case 56:
                        patient_Level_Data.setDei_56(data_element.getData_element_id());
                        break;
                    case 57:
                        patient_Level_Data.setDei_57(data_element.getData_element_id());
                        break;
                    case 58:
                        patient_Level_Data.setDei_58(data_element.getData_element_id());
                        break;
                    case 59:
                        patient_Level_Data.setDei_59(data_element.getData_element_id());
                        break;
                    case 60:
                        patient_Level_Data.setDei_60(data_element.getData_element_id());
                        break;
                    case 61:
                        patient_Level_Data.setDei_61(data_element.getData_element_id());
                        break;
                    case 62:
                        patient_Level_Data.setDei_62(data_element.getData_element_id());
                        break;
                    case 63:
                        patient_Level_Data.setDei_63(data_element.getData_element_id());
                        break;
                    case 64:
                        patient_Level_Data.setDei_64(data_element.getData_element_id());
                        break;
                    case 65:
                        patient_Level_Data.setDei_65(data_element.getData_element_id());
                        break;
                    case 66:
                        patient_Level_Data.setDei_66(data_element.getData_element_id());
                        break;
                    case 67:
                        patient_Level_Data.setDei_67(data_element.getData_element_id());
                        break;
                    case 68:
                        patient_Level_Data.setDei_68(data_element.getData_element_id());
                        break;
                    case 69:
                        patient_Level_Data.setDei_69(data_element.getData_element_id());
                        break;
                    case 70:
                        patient_Level_Data.setDei_70(data_element.getData_element_id());
                        break;
                    case 71:
                        patient_Level_Data.setDei_71(data_element.getData_element_id());
                        break;
                    case 72:
                        patient_Level_Data.setDei_72(data_element.getData_element_id());
                        break;
                    case 73:
                        patient_Level_Data.setDei_73(data_element.getData_element_id());
                        break;
                    case 74:
                        patient_Level_Data.setDei_74(data_element.getData_element_id());
                        break;
                    case 75:
                        patient_Level_Data.setDei_75(data_element.getData_element_id());
                        break;
                    case 76:
                        patient_Level_Data.setDei_76(data_element.getData_element_id());
                        break;
                    case 77:
                        patient_Level_Data.setDei_77(data_element.getData_element_id());
                        break;
                    case 78:
                        patient_Level_Data.setDei_78(data_element.getData_element_id());
                        break;
                    case 79:
                        patient_Level_Data.setDei_79(data_element.getData_element_id());
                        break;
                    case 80:
                        patient_Level_Data.setDei_80(data_element.getData_element_id());
                        break;
                    default:
                        break;
                }
            }
            if (count == columns) {
                break;
            }
            count++;
        }
        return patient_Level_Data;
    }

    /**
     * End Patient Level Data
     */
    /**
     * Edit SMS
     */
    private Interface_data_sms interface_data_sms_edit = new Interface_data_sms();
    private Integer edit_sms_week;
    private Integer edit_sms_month;
    private Integer edit_sms_year;

    public Interface_data_sms getInterface_data_sms_edit() {
        return interface_data_sms_edit;
    }

    public void setInterface_data_sms_edit(Interface_data_sms interface_data_sms_edit) {
        this.interface_data_sms_edit = interface_data_sms_edit;
    }

    public Integer getEdit_sms_week() {
        return edit_sms_week;
    }

    public void setEdit_sms_week(Integer edit_sms_week) {
        this.edit_sms_week = edit_sms_week;
    }

    public Integer getEdit_sms_month() {
        return edit_sms_month;
    }

    public void setEdit_sms_month(Integer edit_sms_month) {
        this.edit_sms_month = edit_sms_month;
    }

    public Integer getEdit_sms_year() {
        return edit_sms_year;
    }

    public void setEdit_sms_year(Integer edit_sms_year) {
        this.edit_sms_year = edit_sms_year;
    }

    public void edit_sms(Interface_data_sms interface_data_sms) {
        edit_sms_month = null;
        edit_sms_week = null;
        edit_sms_year = null;
        interface_data_sms_edit = interface_data_sms;
    }

    public void save_edit_sms() {
        if (interface_data_sms_edit.getInterface_data_sms_id() == 0) {
            FacesContext.getCurrentInstance().addMessage("Please select SMS to edit!", new FacesMessage("Please select SMS to edit!"));
            return;
        }
        new SMSData().edit_and_reupload_sms(interface_data_sms_edit, edit_sms_year, edit_sms_week, edit_sms_month);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Completed successfully", "Completed successfully"));
        interface_data_sms_edit = new Interface_data_sms();
    }
    /**
     * End Edit SMS
     */
}

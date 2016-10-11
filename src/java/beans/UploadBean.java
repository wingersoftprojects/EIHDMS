/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import eihdms.Base_data;
import eihdms.Batch;
import eihdms.County;
import eihdms.Data_element;
import eihdms.District;
import eihdms.EIHDMSPersistentManager;
import eihdms.Financial_year;
import eihdms.Health_facility;
import eihdms.Interface_data;
import eihdms.Parish;
import eihdms.Region;
import eihdms.Report_form;
import eihdms.Report_form_group;
import eihdms.Sub_county;
import eihdms.User_detail;
import eihdms.Validation_rule;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;
import utilities.GeneralUtilities;

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

    private District[] selectedDistricts;
    private Parish[] selectedParishes;
    private Health_facility[] selectedHealth_facilities;

    private List<Interface_data> interface_datas;
    private List<Base_data> base_datas;

    String BaseDataStr = "";

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

    public JSONArray getjSONArray_Dynamic_Pivot(District[] selectedDistricts, Integer[] selectedYears) {
        String YearsStr = "";
        String DistrictsStr = "";
        JSONArray jArray = new JSONArray();

        if (selectedYears == null || selectedDistricts == null) {
            return jArray;
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

        GeneralUtilities.flushandclearsession();
        if (report_form != null) {
            try {
                base_datas = Base_data.queryBase_data("report_form_id=" + report_form.getReport_form_id() + " AND district_id in(" + DistrictsStr + ") AND report_period_year IN( " + YearsStr + ")", null);
            } catch (PersistentException ex) {
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        jSONArray = new JSONArray();
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
            jObj.put("DataElementValue", new JSONObject().put("type", "number"));
            jArray.put(jObj);

            if (base_datas == null) {
                base_datas = new ArrayList<>();
            }
            for (Base_data base_data : base_datas) {
                if (base_data.getData_element().getData_type().equals("integer") || base_data.getData_element().getData_type().equals("float")) {
                    jObj = new JSONObject();
                    jObj.put("DataElement", String.format("%1$03d", base_data.getData_element().getGroup_column_number()) + base_data.getData_element().getData_element_name());
                    if (report_form.getLowest_report_form_level().equals("Facility")) {
                        jObj.put("District", base_data.getDistrict().getDistrict_name());
                        jObj.put("County", base_data.getCounty().getCounty_name());
                        jObj.put("Subcounty", base_data.getSub_county().getSub_county_name());
                        jObj.put("Facility", base_data.getHealth_facility().getHealth_facility_name());
                    }
                    if (report_form.getLowest_report_form_level().equals("Parish")) {
                        jObj.put("District", base_data.getDistrict().getDistrict_name());
                        jObj.put("County", base_data.getCounty().getCounty_name());
                        jObj.put("Subcounty", base_data.getSub_county().getSub_county_name());
                        jObj.put("Parish", base_data.getParish().getParish_name());
                    }
                    if (report_form.getLowest_report_form_level().equals("District")) {
                        jObj.put("District", base_data.getDistrict().getDistrict_name());
                    }
                    if (base_data.getData_element_value() == null) {
                        jObj.put("DataElementValue", 0);
                    } else {
                        try {
                            jObj.put("DataElementValue", Float.parseFloat(base_data.getData_element_value()));
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

    public JSONArray getjSONArray_Delete() {
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
                try {
                    base_datas = Base_data.queryBase_data("report_form_id=" + report_form.getReport_form_id() + " AND parish_id in(" + ParishesStr + ") AND " + period_condition, null);
                } catch (PersistentException ex) {
                    Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
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
                try {
                    base_datas = Base_data.queryBase_data("report_form_id=" + report_form.getReport_form_id() + " AND district_id in(" + DistrictsStr + ") AND " + period_condition, null);
                } catch (PersistentException ex) {
                    Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
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
                try {
                    base_datas = Base_data.queryBase_data("report_form_id=" + report_form.getReport_form_id() + " AND health_facility_id in(" + HealthFacilitiesStr + ") AND " + period_condition, null);
                } catch (PersistentException ex) {
                    Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        JSONArray jArray = new JSONArray();
        jSONArray = new JSONArray();
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
            jObj.put("DataElementValue", new JSONObject().put("type", "number"));
            jArray.put(jObj);

            if (base_datas == null) {
                base_datas = new ArrayList<>();
            }
            for (Base_data base_data : base_datas) {
                if (base_data.getData_element().getData_type().equals("integer") || base_data.getData_element().getData_type().equals("float")) {
                    jObj = new JSONObject();
                    jObj.put("DataElement", String.format("%1$03d", base_data.getData_element().getGroup_column_number()) + base_data.getData_element().getData_element_name());
                    if (report_form.getLowest_report_form_level().equals("Facility")) {
                        jObj.put("District", base_data.getDistrict().getDistrict_name());
                        jObj.put("County", base_data.getCounty().getCounty_name());
                        jObj.put("Subcounty", base_data.getSub_county().getSub_county_name());
                        jObj.put("Facility", base_data.getHealth_facility().getHealth_facility_name());
                    }
                    if (report_form.getLowest_report_form_level().equals("Parish")) {
                        jObj.put("District", base_data.getDistrict().getDistrict_name());
                        jObj.put("County", base_data.getCounty().getCounty_name());
                        jObj.put("Subcounty", base_data.getSub_county().getSub_county_name());
                        jObj.put("Parish", base_data.getParish().getParish_name());
                    }
                    if (report_form.getLowest_report_form_level().equals("District")) {
                        jObj.put("District", base_data.getDistrict().getDistrict_name());
                    }
                    if (base_data.getData_element_value() == null) {
                        jObj.put("DataElementValue", 0);
                    } else {
                        try {
                            jObj.put("DataElementValue", Float.parseFloat(base_data.getData_element_value()));
                        } catch (NumberFormatException nfe) {
                            jObj.put("DataElementValue", 0);
                        }
                    }
                    jArray.put(jObj);
                }
                if (BaseDataStr.length() > 0) {
                    BaseDataStr = BaseDataStr + "," + base_data.getBase_data_id();
                } else {
                    BaseDataStr = "" + base_data.getBase_data_id();
                }
            }
            jSONArray = jArray;
        }
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
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
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
        String sql = "{call sp_validate_data(?,?,?)}";
        ResultSet rs = null;
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, report_form_group.getReport_form_group_id());
            ps.setInt(2, batch_id);
            ps.setString(3, report_form.getLowest_report_form_level());
            rs = ps.executeQuery();
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
    }

    public void delete_base_data() {
        if (BaseDataStr.length() == 0) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("No Data Selected!", "No Data Selected!"));
            return;
        }
        String sql = "{call sp_delete_base_data(?,?)}";
        ResultSet rs = null;
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, BaseDataStr);
            ps.setInt(2, loginBean.getUser_detail().getUser_detail_id());
            rs = ps.executeQuery();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Deleted successfully", "Deleted successfully"));
        } catch (SQLException se) {
            System.err.println(se.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(se.getMessage(), se.getMessage()));
        }
    }

    public void load_interface() {
        if (!interface_datas.isEmpty()) {
            try {
                /**
                 * Validate Data
                 */
                //validate_upload(report_form_group);
                /**
                 * End Validate Data
                 */
                /**
                 * Load Interface Data
                 */
                PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                /**
                 * Generate Batch
                 */
                try {
                    Batch batch = new Batch();
                    batch.setAdd_date(new Timestamp(new Date().getTime()));
                    batch.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
                    batch.setIs_deleted(0);
                    batch.setIs_active(1);
                    batch.save();
                    /**
                     * End Batch
                     */
                    /**
                     * Load Interface
                     */
                    int counter = 0;
                    for (Interface_data i : interface_datas) {
                        //interface_dataBean.setSelected(i);
                        i.setBatch(batch);
                        i.setIs_active(1);
                        i.setAdd_date(new Timestamp(new Date().getTime()));
                        i.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
                        i.setIs_deleted(0);
                        //i.setStatus_u("Pass");
                        //i.setStatus_u_desc("Uploaded To interface");
                        i.save();
                        if (counter % 20 == 0) { //20, same as the JDBC batch size
                            //flush a batch of inserts and release memory:
                            EIHDMSPersistentManager.instance().getSession().flush(); //line1
                            EIHDMSPersistentManager.instance().getSession().clear();
                        }
                        counter++;
                        //interface_dataBean.save(loginBean.getUser_detail().getUser_detail_id());
                    }
                    transaction.commit();

                    /**
                     * End load interface
                     */
                    /**
                     * Load Base Data
                     */
                    validate_and_load_data_to_base(batch.getBatch_id());

                    /**
                     * Validate Data
                     */
                    loginBean.saveMessage();
                    generate_validation_report(batch.getBatch_id());
//                    interface_datas = new ArrayList<>();
//                    Map<String, Object> options = new HashMap<>();
//                    options.put("draggable", false);
//                    options.put("resizable", false);
//                    options.put("contentHeight", 530);
//                    options.put("height", 550);
//                    options.put("width", 800);
//                    options.put("modal", true);
//                    org.primefaces.context.RequestContext.getCurrentInstance().openDialog("dialog_validationreport2", options, null);
                    RequestContext.getCurrentInstance().execute("PF('validationReport').show();");
                } catch (PersistentException ex) {
                    transaction.rollback();
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(ex.getMessage(), ex.getMessage()));
                    Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (PersistentException ex) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(ex.getMessage(), ex.getMessage()));
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void generate_validation_report(int batch_id) {
        try {
            Batch b = Batch.getBatchByORMID(batch_id);
            User_detail user_detail = User_detail.getUser_detailByORMID(b.getAdd_by());
            batchDetails = new BatchDetails();
            batchDetails.setBatchUserName(user_detail.getFirst_name() + " " + user_detail.getSecond_name() + " " + user_detail.getThird_name());
            batchDetails.setBatch(b);
            List<ValidationReport> tempValidationReports = new ArrayList<>();
            List<Object[]> validations = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT DISTINCT district_name,county_name,sub_county_name,parish_name,health_facility_name,status_v,status_v_desc FROM validation_report where batch_id=" + batch_id).list();
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
                vr.setReportId(counter);
                tempValidationReports.add(vr);
                counter++;
            }
            validationReportListAll = new ArrayList<>(tempValidationReports);
            //validationReportList = new ArrayList<>(tempValidationReports);
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ValidationReport> generate_validation_report() {
        validationReportList = new ArrayList<>();
        try {
            List<ValidationReport> tempValidationReports = new ArrayList<>();
            List<Object[]> validations = EIHDMSPersistentManager.instance().getSession().createSQLQuery("SELECT DISTINCT validation_report.batch_id,CONCAT(user_detail.second_name,' ',user_detail.third_name,' ',user_detail.first_name) AS AddedBy,DATE_FORMAT(batch.add_date,'%d %b %Y %T:%f') AS Add_Date FROM validation_report INNER JOIN user_detail ON user_detail.user_detail_id = validation_report.add_by INNER JOIN batch ON validation_report.batch_id = batch.batch_id order by batch_id desc").list();
            for (Object[] objects : validations) {
                ValidationReport vr = new ValidationReport();
                vr.setBatch_id(Integer.parseInt(objects[0].toString()));
                vr.AddedBy = objects[1].toString();
                vr.setAddDate(objects[2].toString());
                //tempValidationReports.add(vr);
                validationReportList.add(vr);
            }
            //validationReportList = new ArrayList<>(tempValidationReports);
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
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
                                        interface_data.setDistrict_name(district_name.replace("'", "''"));
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
                                        interface_data.setDistrict_name(district_name.replace("'", "''"));
                                        //interface_data.setCounty_name(county_name.replace("'", "''"));
                                        interface_data.setSub_county_name(sub_county_name.replace("'", "''"));
                                        interface_data.setParish_name(parish_name.replace("'", "''"));
                                        interface_data.setHealth_facility_name(facility_name.replace("'", "''"));
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
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void read_excel_data(Interface_data interface_data, Map.Entry pair, Cell cell) {
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
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createInterface_datas(List<Data_element> aData_elements) {
        Interface_data interface_data;
        if (null != aData_elements) {
            interface_datas = new ArrayList<Interface_data>();
            for (Data_element data_element : aData_elements) {
                interface_data = new Interface_data();
                interface_data.setData_element(data_element);
                interface_data.setData_element_value("");
                try {
                    interface_data.setHealth_facility_name(this.getHealth_facility().getHealth_facility_name());
                } catch (NullPointerException npe) {
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
                interface_datas.add(interface_data);
            }
        }
    }

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
            Logger.getLogger(Health_facilityBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filteredHealth_facilities;
    }

    public List<Parish> completeParish(String query) {
        List<Parish> filteredParishes = new ArrayList<>();
        try {
            filteredParishes = (List<Parish>) EIHDMSPersistentManager.instance().getSession().createQuery("select p FROM Parish  p where p.is_deleted<>1 AND p.is_active<>0 AND p.parish_name like '%" + query + "%'").list();
        } catch (PersistentException ex) {
            Logger.getLogger(ParishBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filteredParishes;
    }

    public List<District> completeDistrict(String query) {
        List<District> filteredDistricts = new ArrayList<>();
        try {
            filteredDistricts = (List<District>) EIHDMSPersistentManager.instance().getSession().createQuery("select d FROM District  d where d.is_deleted<>1 AND d.is_active<>0 AND d.district_name like '%" + query + "%'").list();
        } catch (PersistentException ex) {
            Logger.getLogger(DistrictBean.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
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

}

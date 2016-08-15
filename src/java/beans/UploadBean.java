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
import eihdms.Validation_rule;
import eihdms.Validation_temp;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

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
    private int report_period_quarter;
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

    public int getReport_period_quarter() {
        return report_period_quarter;
    }

    public void setReport_period_quarter(int report_period_quarter) {
        this.report_period_quarter = report_period_quarter;
    }

    public String getReport_period_name() {
        return report_period_name;
    }

    public void setReport_period_name(String report_period_name) {
        this.report_period_name = report_period_name;
    }

    private String insert_string;
    private String table_string;
    private String database_type;

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
        JSONArray jArray = new JSONArray();
        if (report_form != null) {
            JSONObject jObj = new JSONObject();
            jObj.put("DataElement", new JSONObject().put("type", "string"));
            if (report_form.getLowest_report_form_level().equals("Facility")) {
                jObj.put("District", new JSONObject().put("type", "string"));
                jObj.put("Parish", new JSONObject().put("type", "string"));
                jObj.put("Facility", new JSONObject().put("type", "string"));
            }
            if (report_form.getLowest_report_form_level().equals("Parish")) {
                jObj.put("District", new JSONObject().put("type", "string"));
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
                jObj = new JSONObject();
                jObj.put("DataElement", String.format("%1$03d", interface_data.getData_element().getGroup_column_number()) + interface_data.getData_element().getData_element_name());
                if (report_form.getLowest_report_form_level().equals("Facility")) {
                    jObj.put("District", interface_data.getDistrict_name());
                    jObj.put("Parish", interface_data.getParish_name());
                    jObj.put("Facility", interface_data.getHealth_facility_name());
                }
                if (report_form.getLowest_report_form_level().equals("Parish")) {
                    jObj.put("District", interface_data.getDistrict_name());
                    jObj.put("Subcounty", interface_data.getSub_county_name());
                    jObj.put("Parish", interface_data.getParish_name());
                }
                if (report_form.getLowest_report_form_level().equals("District")) {
                    jObj.put("District", interface_data.getDistrict_name());
                }
                if (interface_data.getData_element_value() == null) {
                    jObj.put("DataElementValue", 0);
                } else {
                    jObj.put("DataElementValue", Float.parseFloat(interface_data.getData_element_value()));
                }
                jArray.put(jObj);
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

    private List<Interface_data> interface_datas;

    public List<Interface_data> getInterface_datas() {
        return interface_datas;
    }

    public void setInterface_datas(List<Interface_data> interface_datas) {
        this.interface_datas = interface_datas;
    }

    public void handleFileUpload(FileUploadEvent event) {
        try {
            InputStream inputStream = event.getFile().getInputstream();
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
                try {

                    Connection conn = DBConnection.getMySQLConnection();
                    PreparedStatement ps = conn.prepareStatement(sql);
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

//    public void validate_upload(Report_form_group report_form_group) {
//        switch (report_form_group.getReport_form().getLowest_report_form_level()) {
//            case "Facility":
//                Set<String> facility_hierarchyset = new HashSet();
//                for (Interface_data interface_data : interface_datas) {
//                    facility_hierarchyset.add(interface_data.getDistrict_name() + ":" + interface_data.getParish_name() + ":" + interface_data.getHealth_facility_name());
//                }
//                for (String facilityhierarchy : facility_hierarchyset) {
//                    validationtext = validate(report_form_group, facilityhierarchy);
//                    for (Interface_data interface_data : interface_datas) {
//                        if (facilityhierarchy.equals(interface_data.getDistrict_name() + ":" + interface_data.getParish_name() + ":" + interface_data.getHealth_facility_name())) {
//                            if (!validationtext.isEmpty()) {
//                                interface_data.setStatus("Invalid");
//                                interface_data.setStatus_desc("Not Passed Validation because: " + validationtext);
//                            } else {
//                                interface_data.setStatus("Validated");
//                                interface_data.setStatus_desc("Validated and ready for moving");
//                            }
//                        }
//                    }
//                }
//                break;
//            case "Parish":
//                Set<String> parish_hierarchyset = new HashSet();
//                for (Interface_data interface_data : interface_datas) {
//                    parish_hierarchyset.add(interface_data.getDistrict_name() + ":" + interface_data.getSub_county_name() + ":" + interface_data.getParish_name());
//                }
//                for (String parish_hierarchy : parish_hierarchyset) {
//                    validationtext = validate(report_form_group, parish_hierarchy);
//                    for (Interface_data interface_data : interface_datas) {
//                        if (parish_hierarchy.equals(interface_data.getDistrict_name() + ":" + interface_data.getSub_county_name() + ":" + interface_data.getParish_name())) {
//                            if (!validationtext.isEmpty()) {
//                                interface_data.setStatus("Invalid");
//                                interface_data.setStatus_desc("Not Passed Validation because: " + validationtext);
//                            } else {
//                                interface_data.setStatus("Validated");
//                                interface_data.setStatus_desc("Validated and ready for moving");
//                            }
//                        }
//                    }
//                }
//                break;
//            case "District":
//                Set<String> district_hierarchyset = new HashSet();
//                for (Interface_data interface_data : interface_datas) {
//                    district_hierarchyset.add(interface_data.getDistrict_name() + ":" + interface_data.getSub_county_name() + ":" + interface_data.getParish_name());
//                }
//                for (String district_hierarchy : district_hierarchyset) {
//                    validationtext = validate(report_form_group, district_hierarchy);
//                    for (Interface_data interface_data : interface_datas) {
//                        if (district_hierarchy.equals(interface_data.getDistrict_name() + ":" + interface_data.getSub_county_name() + ":" + interface_data.getParish_name())) {
//                            if (!validationtext.isEmpty()) {
//                                interface_data.setStatus("Invalid");
//                                interface_data.setStatus_desc("Not Passed Validation because: " + validationtext);
//                            } else {
//                                interface_data.setStatus("Validated");
//                                interface_data.setStatus_desc("Validated and ready for moving");
//                            }
//                        }
//                    }
//                }
//                break;
//            default:
//                break;
//        }
//    }
//    public String validate(Report_form_group report_form_group, String locationarray) {
//        String[] splitlocation = locationarray.split(":");
//        String val_district = "";
//        String val_parish = "";
//        String val_facility = "";
//        String val_sub_county = "";
//        if (report_form_group.getReport_form().getLowest_report_form_level().equals("Facility")) {
//            val_district = splitlocation[0];
//            val_parish = splitlocation[1];
//            val_facility = splitlocation[2];
//        }
//        if (report_form_group.getReport_form().getLowest_report_form_level().equals("Parish")) {
//            val_district = splitlocation[0];
//            val_sub_county = splitlocation[1];
//            val_parish = splitlocation[2];
//        }
//        if (report_form_group.getReport_form().getLowest_report_form_level().equals("District")) {
//            val_district = splitlocation[0];
//        }
//        validationtext = "";
//        try {
//            List<Validation_rule> validation_temps = Validation_rule.queryValidation_rule("is_active=1 AND report_form_group=" + report_form_group.getReport_form_group_id(), null);
//            for (Validation_rule v : validation_temps) {
//                Interface_data a = null;
//                Interface_data b = null;
//                Interface_data c = null;
//                Interface_data d = null;
//                for (Interface_data interface_data : interface_datas) {
//                    if (report_form_group.getReport_form().getLowest_report_form_level().equals("Facility") && interface_data.getDistrict_name().equals(val_district) && interface_data.getParish_name().equals(val_parish) && interface_data.getHealth_facility_name().equals(val_facility)) {
//                        if (v.getA() != null && interface_data.getData_element().getData_element_id() == v.getA().getData_element_id()) {
//                            a = interface_data;
//                        }
//                        if (v.getB() != null && interface_data.getData_element().getData_element_id() == v.getB().getData_element_id()) {
//                            b = interface_data;
//                        }
//                        if (v.getC() != null && interface_data.getData_element().getData_element_id() == v.getC().getData_element_id()) {
//                            c = interface_data;
//                        }
//                        if (v.getD() != null && interface_data.getData_element().getData_element_id() == v.getD().getData_element_id()) {
//                            d = interface_data;
//                        }
//                    } else if (report_form_group.getReport_form().getLowest_report_form_level().equals("Parish") && interface_data.getDistrict_name().equals(val_district) && interface_data.getSub_county_name().equals(val_sub_county) && interface_data.getParish_name().equals(val_parish)) {
//                        if (v.getA() != null && interface_data.getData_element().getData_element_id() == v.getA().getData_element_id()) {
//                            a = interface_data;
//                        }
//                        if (v.getB() != null && interface_data.getData_element().getData_element_id() == v.getB().getData_element_id()) {
//                            b = interface_data;
//                        }
//                        if (v.getC() != null && interface_data.getData_element().getData_element_id() == v.getC().getData_element_id()) {
//                            c = interface_data;
//                        }
//                        if (v.getD() != null && interface_data.getData_element().getData_element_id() == v.getD().getData_element_id()) {
//                            d = interface_data;
//                        }
//                    } else if (report_form_group.getReport_form().getLowest_report_form_level().equals("District") && interface_data.getDistrict_name().equals(val_district)) {
//                        if (v.getA() != null && interface_data.getData_element().getData_element_id() == v.getA().getData_element_id()) {
//                            a = interface_data;
//                        }
//                        if (v.getB() != null && interface_data.getData_element().getData_element_id() == v.getB().getData_element_id()) {
//                            b = interface_data;
//                        }
//                        if (v.getC() != null && interface_data.getData_element().getData_element_id() == v.getC().getData_element_id()) {
//                            c = interface_data;
//                        }
//                        if (v.getD() != null && interface_data.getData_element().getData_element_id() == v.getD().getData_element_id()) {
//                            d = interface_data;
//                        }
//                    }
//                }
//                switch (v.getValidation_rule_formula()) {
//                    case "a+b=c":
//                        if (a != null && b != null && c != null) {
//                            if ((Float.parseFloat(a.getData_element_value()) + Float.parseFloat(b.getData_element_value())) != Float.parseFloat(c.getData_element_value())) {
//                                validationtext += ":" + v.getValidation_rule_name();
//                            }
//                        }
//                        break;
//                    case "a Greater Than b":
//                        if (a != null && b != null) {
//                            if (Float.parseFloat(a.getData_element_value()) <= Float.parseFloat(b.getData_element_value())) {
//                                validationtext += ":" + v.getValidation_rule_name();
//                            }
//                        }
//                        break;
//                    case "a Less Than b":
//                        if (a != null && b != null) {
//                            if (Float.parseFloat(a.getData_element_value()) >= Float.parseFloat(b.getData_element_value())) {
//                                validationtext += ":" + v.getValidation_rule_name();
//                            }
//                        }
//                        break;
//                    default:
//                        break;
//                }
//            }
//        } catch (PersistentException ex) {
//            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return validationtext;
//    }
    private void set_Status_V(Interface_data interface_data) {
        if (!validationtext.isEmpty()) {
            interface_data.setStatus_v("Invalid");
            interface_data.setStatus_v_desc("Not Passed Validation because: " + validationtext);
        } else {
            interface_data.setStatus_v("Validated");
            interface_data.setStatus_v_desc("Validated and ready for moving");
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
                Batch batch = new Batch();
                batch.setAdd_date(new Timestamp(new Date().getTime()));
                batch.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
                batch.setIs_deleted(0);
                batch.save();
                /**
                 * End Batch
                 */
                for (Interface_data i : interface_datas) {
                    //interface_dataBean.setSelected(i);
                    i.setBatch(batch);
                    i.setIs_active(1);
                    i.setAdd_date(new Timestamp(new Date().getTime()));
                    i.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
                    i.setIs_deleted(0);
                    i.setStatus_u("Uploaded");
                    i.setStatus_u_desc("Uploaded To interface pending validation");
                    i.save();
                    //interface_dataBean.save(loginBean.getUser_detail().getUser_detail_id());
                }
                transaction.commit();
                /**
                 * Load Base Data
                 */

                /**
                 * Validate Data
                 */
                transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                List<Interface_data> interface_datas_tovalidate = (List<Interface_data>) EIHDMSPersistentManager.instance().getSession().createQuery("SELECT i FROM Interface_data i where batch= " + batch.getBatch_id() + " AND i.data_element.report_form=" + report_form.getReport_form_id() + " AND i.data_element.report_form_group=" + report_form_group.getReport_form_group_id()).list();

                if (report_form.getLowest_report_form_level().equals("Facility")) {
                    Set<String> facility_hierarchyset = new HashSet();
                    for (Interface_data interface_data : interface_datas_tovalidate) {
                        facility_hierarchyset.add(interface_data.getDistrict_name() + interface_data.getParish_name() + interface_data.getHealth_facility_name());
                    }
                    for (String facilityhierarchy : facility_hierarchyset) {
                        validationtext = validate_upload_procedure(batch.getBatch_id(), "CONCAT(district_name,parish_name,health_facility_name)", facilityhierarchy);
                        for (Interface_data interface_data : interface_datas_tovalidate) {
                            if (facilityhierarchy.equals(interface_data.getDistrict_name() + interface_data.getParish_name() + interface_data.getHealth_facility_name())) {
                                set_Status_V(interface_data);
                            }
                            EIHDMSPersistentManager.instance().getSession().merge(interface_data);
                        }
                    }
                }
                if (report_form.getLowest_report_form_level().equals("Parish")) {
                    Set<String> parish_hierarchyset = new HashSet();
                    for (Interface_data interface_data : interface_datas_tovalidate) {
                        parish_hierarchyset.add(interface_data.getDistrict_name() + interface_data.getSub_county_name() + interface_data.getParish_name());
                    }
                    for (String parishhierarchy : parish_hierarchyset) {
                        validationtext = validate_upload_procedure(batch.getBatch_id(), "CONCAT(district_name,sub_county_name,parish_name)", parishhierarchy);
                        for (Interface_data interface_data : interface_datas_tovalidate) {
                            if (parishhierarchy.equals(interface_data.getDistrict_name() + interface_data.getSub_county_name() + interface_data.getParish_name())) {
                                set_Status_V(interface_data);
                            }
                            EIHDMSPersistentManager.instance().getSession().merge(interface_data);
                        }
                    }
                }
                if (report_form.getLowest_report_form_level().equals("District")) {
                    Set<String> district_hierarchyset = new HashSet();
                    for (Interface_data interface_data : interface_datas_tovalidate) {
                        district_hierarchyset.add(interface_data.getDistrict_name());
                    }
                    for (String districthierarchy : district_hierarchyset) {
                        validationtext = validate_upload_procedure(batch.getBatch_id(), "CONCAT(district_name)", districthierarchy);
                        for (Interface_data interface_data : interface_datas_tovalidate) {
                            if (districthierarchy.equals(interface_data.getDistrict_name())) {
                                set_Status_V(interface_data);
                            }
                            EIHDMSPersistentManager.instance().getSession().merge(interface_data);
                        }
                    }
                }
                transaction.commit();

                /**
                 * End Validate Data
                 */
                transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                /**
                 * Move data to base
                 */
                move_data_to_base(batch);
                /**
                 * End move data to base
                 */
                transaction.commit();
                loginBean.saveMessage();
            } catch (PersistentException ex) {
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            interface_datas = new ArrayList<>();
        }
    }

    private void move_data_to_base(Batch batch) {
        try {
            List<Interface_data> interface_datas_tobase = (List<Interface_data>) EIHDMSPersistentManager.instance().getSession().createQuery("SELECT i FROM Interface_data i where i.status_v='Validated' AND batch= " + batch.getBatch_id()).list();
            for (Interface_data i : interface_datas_tobase) {
                District d = District.loadDistrictByQuery("is_active=1 AND district_name='" + i.getDistrict_name() + "'", null);
                Sub_county s = Sub_county.loadSub_countyByQuery("is_active=1 AND sub_county_name='" + i.getSub_county_name() + "' AND county.district=" + (d != null ? d.getDistrict_id() : 0), null);
                Parish p = null;
                if (report_form.getLowest_report_form_level().equals("Facility")) {
                    p = Parish.loadParishByQuery("is_active=1 AND parish_name='" + i.getParish_name() + "' AND sub_county.county.district=" + (d != null ? d.getDistrict_id() : 0), null);
                }
                if (report_form.getLowest_report_form_level().equals("Parish")) {
                    p = Parish.loadParishByQuery("is_active=1 AND parish_name='" + i.getParish_name() + "' AND sub_county_id=" + (s != null ? s.getSub_county_id() : 0), null);
                }

                List<Health_facility> health_facilityList = Health_facility.queryHealth_facility("is_active=1 AND health_facility_name='" + i.getHealth_facility_name() + "' AND parish.sub_county.county.district=" + (d != null ? d.getDistrict_id() : 0) + " AND parish=" + (p != null ? p.getParish_id() : 0), null);
                List<Parish> parishList = EIHDMSPersistentManager.instance().getSession().createQuery("SELECT p from Parish p where p.is_active=1 AND p.sub_county.county.district=" + (d != null ? d.getDistrict_id() : 0) + " AND p.sub_county=" + (s != null ? s.getSub_county_id() : 0) + " AND p.parish_name='" + i.getParish_name() + "'").list();// Parish.queryParish("is_active=1 AND parish_name='" + i.getParish_name() + "' AND district_id=" + (d != null ? d.getDistrict_id() : 0) + " AND sub_county_id=" + (s != null ? s.getSub_county_id() : 0), null);
                List<District> districtList = District.queryDistrict("is_active=1 AND district_name='" + i.getDistrict_name() + "'", null);
                if (report_form.getLowest_report_form_level().equals("Facility")) {
                    if (health_facilityList.size() == 1) {
                        Base_data base_data = Base_data.createBase_data();
                        health_facility = Health_facility.loadHealth_facilityByQuery("is_active=1 AND health_facility_name='" + i.getHealth_facility_name() + "' AND parish.sub_county.county.district=" + (d != null ? d.getDistrict_id() : 0) + " AND parish=" + (p != null ? p.getParish_id() : 0), null);
                        base_data.setHealth_facility(health_facility);
                        base_data.setDistrict(health_facility.getDistrict());
                        base_data.setParish(health_facility.getParish());
                        /**
                         * Save to base data
                         */
                        save_basa_data(base_data, i);
                    }
                    if (health_facilityList.size() > 1) {
                        i.setStatus_v("Not Moved");
                        i.setStatus_v_desc("Not moved to base because more than one facility found in facilities table");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                    if (health_facilityList.isEmpty()) {
                        i.setStatus_v("Not Moved");
                        i.setStatus_v_desc("Not moved to base because facility not found in facilities table");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                }
                if (report_form.getLowest_report_form_level().equals("Parish")) {
                    if (parishList.size() == 1) {
                        Base_data base_data = Base_data.createBase_data();
                        parish = Parish.loadParishByQuery("is_active=1 AND parish_name='" + i.getParish_name() + "' AND sub_county.county.district=" + (d != null ? d.getDistrict_id() : 0) + " AND sub_county=" + (s != null ? s.getSub_county_id() : 0), null);
                        base_data.setParish(parish);
                        if (parish != null) {
                            base_data.setDistrict(d);
                            base_data.setSub_county(parish.getSub_county());
                        }

                        /**
                         * Save to base data
                         */
                        save_basa_data(base_data, i);
                    }
                    if (parishList.size() > 1) {
                        i.setStatus_v("Not Moved");
                        i.setStatus_v_desc("Not moved to base because more than one parish found in parishes table");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                    if (parishList.isEmpty()) {
                        i.setStatus_v("Not Moved");
                        i.setStatus_v_desc("Not moved to base because parish not found in parishes table");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                }
                if (report_form.getLowest_report_form_level().equals("District")) {
                    if (districtList.size() == 1) {
                        Base_data base_data = Base_data.createBase_data();
                        district = District.loadDistrictByQuery("is_active=1 AND district_name='" + i.getDistrict_name() + "'", null);
                        base_data.setDistrict(district);

                        /**
                         * Save to base data
                         */
                        save_basa_data(base_data, i);
                    }
                    if (districtList.size() > 1) {
                        i.setStatus_v("Not Moved");
                        i.setStatus_v_desc("Not moved to base because more than one district found in districts table");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                    if (districtList.isEmpty()) {
                        i.setStatus_v("Not Moved");
                        i.setStatus_v_desc("Not moved to base because district not found in districts table");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                }
            }
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void save_basa_data(Base_data base_data, Interface_data i) {
        try {
            base_data.setBatch(i.getBatch());
            base_data.setData_element(i.getData_element());
            base_data.setData_element_value(i.getData_element_value());
            base_data.setFinancial_year(i.getFinancial_year());
            base_data.setReport_period_quarter(i.getReport_period_quarter());
            base_data.setReport_period_from_date(i.getReport_period_from_date());
            base_data.setReport_period_to_date(i.getReport_period_to_date());
            base_data.setReport_period_name(i.getReport_period_name());
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
            i.setStatus_m("Moved");
            i.setStatus_m_desc("Moved to base successfully");
            i.setLast_edit_date(new Timestamp(new Date().getTime()));
            i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
            EIHDMSPersistentManager.instance().getSession().merge(i);
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void uploadexcel(InputStream inputStream) {
        //FileInputStream fis = null;
        try {
            //Report_form report_form = Report_form.getReport_formByORMID(reportformid);
            if (report_form != null && report_form_group != null) {
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
                Map demap = new HashMap();
                int tempcounter = 1;
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
                                parish_name = row.getCell(1).getStringCellValue();
                                facility_name = row.getCell(2).getStringCellValue();
                            }
                            if (report_form.getLowest_report_form_level().equals("Parish")) {
                                district_name = row.getCell(0).getStringCellValue();
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
                                        interface_data.setDistrict_name(district_name);
                                        interface_data.setSub_county_name(sub_county_name);
                                        interface_data.setParish_name(parish_name);
                                        interface_data.setHealth_facility_name(facility_name);
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
                                        interface_data.setDistrict_name(district_name);
                                        interface_data.setSub_county_name(sub_county_name);
                                        interface_data.setParish_name(parish_name);
                                        interface_data.setHealth_facility_name(facility_name);
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
        interface_data.setReport_period_to_date(report_period_to_date);
        interface_data.setFinancial_year(financial_year);
        interface_data.setReport_period_quarter(report_period_quarter);
        interface_data.setReport_period_name(report_period_name);
        if (district != null) {
            interface_data.setDistrict_name(district.getDistrict_name());
        }
        if (parish != null) {
            interface_data.setParish_name(parish.getParish_name());
        }
        interface_data.setStatus("Not Moved");
        interface_data.setStatus_desc("Not yet moved to base data");
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
                                    data_values += ("'" + cell.getStringCellValue().replace("'", "''") + "'");
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
                                    data_values += (",'" + cell.getStringCellValue().replace("'", "''") + "'");
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
                    interface_data.setDistrict_name(this.getDistrict().getDistrict_name());
                } catch (NullPointerException npe) {
                    interface_data.setDistrict_name(null);
                }
                try {
                    interface_data.setParish_name(this.getParish().getParish_name());
                } catch (NullPointerException npe) {
                    interface_data.setParish_name(null);
                }
                interface_data.setFinancial_year(this.getFinancial_year());
                interface_data.setReport_period_quarter(this.getReport_period_quarter());
                interface_data.setReport_period_from_date(this.getReport_period_from_date());
                interface_data.setReport_period_to_date(this.getReport_period_to_date());
                interface_data.setReport_period_name(this.getReport_period_name());
                interface_data.setIs_deleted(0);
                interface_data.setIs_active(1);
                interface_data.setStatus("Not Moved");
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
//                    District d = District.loadDistrictByQuery("district_name='" + i.getDistrict_name() + "'", null);
//                    Parish p = Parish.loadParishByQuery("parish_name='" + i.getParish_name() + "'", null);
                        Health_facility health_facility = Health_facility.loadHealth_facilityByQuery("health_facility_name='" + i.getHealth_facility_name() + "'", null); //AND district_id=" + (district != null ? district.getDistrict_id() : 0) + " AND parish_id=" + (parish != null ? parish.getParish_id() : 0), null);
                        base_data.setHealth_facility(health_facility);
                        base_data.setDistrict(health_facility.getDistrict());
                        base_data.setParish(health_facility.getParish());
                        base_data.setFinancial_year(i.getFinancial_year());
                        base_data.setReport_period_quarter(i.getReport_period_quarter());
                        base_data.setReport_period_from_date(i.getReport_period_from_date());
                        base_data.setReport_period_to_date(i.getReport_period_to_date());
                        base_data.setReport_period_name(i.getReport_period_name());
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
                        i.setStatus("Moved");
                        i.setStatus_desc("Moved to base successfully");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                    if (health_facilityList.size() > 1) {
                        i.setStatus("Not Moved");
                        i.setStatus_desc("Not moved to base because more than one facility found in facilities table");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                    if (health_facilityList.isEmpty()) {
                        i.setStatus("Not Moved");
                        i.setStatus_desc("Not moved to base because facility not found in facilities table");
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

}

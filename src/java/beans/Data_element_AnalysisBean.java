/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Base_data;
import eihdms.EIHDMSPersistentManager;
import eihdms.Report_form;
import eihdms.Report_form_group;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.orm.PersistentException;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class Data_element_AnalysisBean {

    private Report_form_group report_form_group;
    private Report_form report_form;
    private List<Report_form_group> report_form_groups;
    private List<Report_form> report_forms;
    private Integer report_period_year;
    private Integer report_period_quarter;
    private Integer report_period_month;
    private String report_period_week;
    private List<Base_data> base_dataList;
    private String condition;
    private JSONArray jSONArray;

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
        return report_form_groups;
    }

    public void setReport_form_groups(List<Report_form_group> report_form_groups) {
        this.report_form_groups = report_form_groups;
    }

    public List<Report_form> getReport_forms() {
        return report_forms;
    }

    public void setReport_forms(List<Report_form> report_forms) {
        this.report_forms = report_forms;
    }

    public List<Base_data> getBase_dataList() {
        return base_dataList;
    }

    public void setBase_dataList(List<Base_data> base_dataList) {
        this.base_dataList = base_dataList;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getReport_period_year() {
        return report_period_year;
    }

    public void setReport_period_year(Integer report_period_year) {
        this.report_period_year = report_period_year;
    }

    public Integer getReport_period_quarter() {
        return report_period_quarter;
    }

    public void setReport_period_quarter(Integer report_period_quarter) {
        this.report_period_quarter = report_period_quarter;
    }

    public Integer getReport_period_month() {
        return report_period_month;
    }

    public void setReport_period_month(Integer report_period_month) {
        this.report_period_month = report_period_month;
    }

    public String getReport_period_week() {
        return report_period_week;
    }

    public void setReport_period_week(String report_period_week) {
        this.report_period_week = report_period_week;
    }
    
    public void filter_base_data() {
        condition = "";
        if (report_form != null) {
            condition += "b.data_element.report_form=" + report_form.getReport_form_id();
        }
        if (report_form_group != null) {
            if (!condition.isEmpty()) {
                condition += " AND b.data_element.report_form_group=" + report_form_group.getReport_form_group_id();
            } else {
                condition += "b.data_element.report_form_group=" + report_form_group.getReport_form_group_id();
            }
        }
        if (report_period_year != null) {
            if (!condition.isEmpty()) {
                condition += " AND report_period_year=" + report_period_year;
            } else {
                condition += "report_period_year=" + report_period_year;
            }
        }
        if (report_period_quarter != null) {
            if (!condition.isEmpty()) {
                condition += " AND report_period_quarter=" + report_period_quarter;
            } else {
                condition += "report_period_quarter=" + report_period_quarter;
            }
        }
        if (report_period_month != null) {
            if (!condition.isEmpty()) {
                condition += " AND report_period_month=" + report_period_month;
            } else {
                condition += "report_period_month=" + report_period_month;
            }
        }
        if (report_period_week != null) {
            if (!condition.isEmpty()) {
                condition += " AND report_period_week=" + report_period_week;
            } else {
                condition += "report_period_week=" + report_period_week;
            }
        }
        try {
            if (condition.isEmpty()) {
                base_dataList = new ArrayList<>();
            } else {
                base_dataList = (List<Base_data>) EIHDMSPersistentManager.instance().getSession().createQuery("SELECT b FROM Base_data b where " + condition).list();
            }
        } catch (PersistentException ex) {
            base_dataList = new ArrayList<>();
            Logger.getLogger(Data_element_AnalysisBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        load_jSON();
    }

    private void load_jSON() {
        JSONArray jArray = new JSONArray();
        JSONObject jObj = new JSONObject();
        jObj.put("AgeCategory", new JSONObject().put("type", "string"));
        jObj.put("SexCategory", new JSONObject().put("type", "string"));
        jObj.put("OtherCategory", new JSONObject().put("type", "string"));
        jObj.put("District", new JSONObject().put("hierarchy", "Location").accumulate("type", "level"));
        if (report_form != null) {
            if (report_form.getLowest_report_form_level().equals("Facility")) {
                jObj.put("SubCounty", new JSONObject().put("parent", "District").accumulate("hierarchy", "Location").accumulate("type", "level"));
                jObj.put("Facility", new JSONObject().put("hierarchy", "Location").accumulate("type", "level").accumulate("parent", "SubCounty"));
            }
            if (report_form.getLowest_report_form_level().equals("Parish")) {
                jObj.put("SubCounty", new JSONObject().put("parent", "District").accumulate("hierarchy", "Location").accumulate("type", "level"));
                jObj.put("Parish", new JSONObject().put("parent", "SubCounty").accumulate("hierarchy", "Location").accumulate("type", "level"));
            }
        }
        jObj.put("Section", new JSONObject().put("type", "level").accumulate("hierarchy", "Section"));
        jObj.put("SubSection", new JSONObject().put("type", "level").accumulate("hierarchy", "Section").accumulate("parent", "Section"));
        jObj.put("DataElement", new JSONObject().put("type", "level").accumulate("hierarchy", "Section").accumulate("parent", "SubSection"));
        jObj.put("DataElementValue", new JSONObject().put("type", "number"));
        jArray.put(jObj);

        if (base_dataList == null) {
            base_dataList = new ArrayList<>();
        }
        for (Base_data base_data : base_dataList) {
            jObj = new JSONObject();
            if (base_data.getData_element().getAge_category() != null) {
                jObj.put("AgeCategory", base_data.getData_element().getAge_category());
            } else {
                jObj.put("AgeCategory", "N/A");
            }
            if (base_data.getData_element().getSex_category() != null) {
                jObj.put("SexCategory", base_data.getData_element().getSex_category());
            } else {
                jObj.put("SexCategory", "N/A");
            }
            if (base_data.getData_element().getOther_category() != null) {
                jObj.put("OtherCategory", base_data.getData_element().getOther_category());
            } else {
                jObj.put("OtherCategory", "N/A");
            }
            jObj.put("District", base_data.getDistrict().getDistrict_name());
            if (report_form.getLowest_report_form_level().equals("Facility")) {
                jObj.put("SubCounty", base_data.getSub_county().getSub_county_name());
                jObj.put("Facility", base_data.getHealth_facility().getHealth_facility_name());
            }
            if (report_form.getLowest_report_form_level().equals("Parish")) {
                jObj.put("Parish", base_data.getParish().getParish_name());
                jObj.put("SubCounty", base_data.getSub_county().getSub_county_name());
            }
            jObj.put("Section", base_data.getData_element().getSection().getSection_name());
            jObj.put("SubSection", base_data.getData_element().getSub_section().getSub_section_name());
            jObj.put("DataElement", base_data.getData_element().getData_element_name());
            if (base_data.getData_element_value() == null) {
                jObj.put("DataElementValue", 0);
            } else {
                jObj.put("DataElementValue", Float.parseFloat(base_data.getData_element_value()));
            }
            jArray.put(jObj);
        }
        jSONArray = jArray;
    }

    public JSONArray getjSONArray() {
        if (report_form == null) {
            filter_base_data();
        }
        return jSONArray;
    }

    public void setjSONArray(JSONArray jSONArray) {
        this.jSONArray = jSONArray;
    }

}

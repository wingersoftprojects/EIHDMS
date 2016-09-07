/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Base_data;
import eihdms.EIHDMSPersistentManager;
import eihdms.Financial_year;
import eihdms.Report_form;
import eihdms.Report_form_group;
import java.util.ArrayList;
import java.util.Date;
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
    private Date report_period_from_date;
    private Date report_period_to_date;
    private Financial_year financial_year;
    private int report_period_quarter;
    private String report_period_name;
    private List<Base_data> base_dataList;
    private String condition;
    private JSONArray jSONArray;

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
        if (financial_year != null) {
            if (!condition.isEmpty()) {
                condition += " AND b.financial_year=" + financial_year.getFinancial_year_id();
            } else {
                condition += "b.financial_year=" + financial_year.getFinancial_year_id();
            }
        }
        if (report_period_quarter != 0) {
            if (!condition.isEmpty()) {
                condition += " AND report_period_quarter=" + report_period_quarter;
            } else {
                condition += "report_period_quarter=" + report_period_quarter;
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

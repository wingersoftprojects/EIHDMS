/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.google.gson.Gson;
import connections.DBConnection;
import eihdms.Health_facility;
import eihdms.Interface_data_mob_app;
import eihdms.Parish;
import eihdms.Phone_contact;
import eihdms.Report_form;
import eihdms.Report_form_entity;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.orm.PersistentException;
import utilities.GeneralUtilities;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class Interface_data_mob_appBean extends AbstractBean<Interface_data_mob_app> implements Serializable {

    private Report_form report_form;
    private Integer report_period_week;
    private Integer report_period_year;
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    private int count_n1;
    private int count_d1;
    private float perc_value1;
    private int count_n2;
    private int count_d2;
    private float perc_value2;
    private List<Interface_data_mob_app> received_MOB_APPs = new ArrayList<>();
    private String CategoriesChartString;
    private String DataseriesChartString;
    private String CategoriesChartString1;
    private String DataseriesChartString1;
    private String CategoriesChartString2;
    private String DataseriesChartString2;
    private List<Report_form> weekList = new ArrayList<>();
    private Report_form[] selectedReport_forms;
    private List<Report_form> report_forms;
    private Report_form report_form1;
    private Report_form report_form2;

    public Interface_data_mob_appBean() {
        super(Interface_data_mob_app.class);
    }

    @Override
    public void init() {
        if (super.getEntityClass() == null) {
            loginBean.logout();
        }
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public void refreshWeeks(int aYear, int aTopWeek) {
        this.weekList = new ArrayList<>();
        Report_form week = null;
        GeneralUtilities gu = new GeneralUtilities();
        int i = 1;
        while (i <= 10) {
            week = new Report_form();
            week.setIs_active(aTopWeek);
            week.setReport_form_code(aTopWeek + " (" + gu.get_week_dates_from_year_and_week(aYear, aTopWeek) + ")");
            getWeekList().add(week);
            aTopWeek = aTopWeek - 1;
            if (aTopWeek <= 0) {
                break;
            }
            i = i + 1;
        }
    }

    public void initDashboard() {
        if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
            // Skip ajax requests.
        } else {
            try {
                this.report_forms = Report_form.queryReport_form("mode_data_entry=3", null);
            } catch (PersistentException ex) {
                Logger.getLogger(Interface_data_mob_appBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.resetDashboard();
        }
    }

    public void resetDashboard() {
        int current_year = Calendar.getInstance().get(Calendar.YEAR);
        Date current_date = Calendar.getInstance().getTime();
        int current_week = Integer.parseInt(new GeneralUtilities().get_week_from_date(current_date, ""));

        int previous_week = 0;
        int previous_week_year = 0;
        if (current_week > 1) {
            previous_week = current_week - 1;
            previous_week_year = current_year;
        } else {
            previous_week_year = current_year - 1;
            previous_week = new GeneralUtilities().get_weeks_in_a_year(previous_week_year);
        }
        this.report_period_year = previous_week_year;
        this.report_period_week = previous_week;
        this.refreshWeeks(this.report_period_year, this.report_period_week);
        this.convertListToArry();
        this.refreshMOB_APPreceivedDashboard();
    }

    public void convertListToArry() {
        int n = 0;
        try {
            n = this.report_forms.size();
        } catch (NullPointerException npe) {
            n = 0;
        }

        if (n > 0) {
            this.selectedReport_forms = new Report_form[n];
            for (int i = 0; i < n; i++) {
                this.selectedReport_forms[i] = this.report_forms.get(i);
            }
        } else {

        }
    }

    public void refreshMOB_APPreceivedDashboard() {
        GeneralUtilities gn = new GeneralUtilities();
        String WhereDate = "";
        String WhereDate2 = "";
        String ReportFormsCodeStr = "";//1,2,3 string format for selected RFs
        int nSelRFs = 0;
        try {
            nSelRFs = this.selectedReport_forms.length;
        } catch (Exception e) {
            nSelRFs = 0;
        }
        //if no forms selected, select all
        if (nSelRFs == 0) {
            this.convertListToArry();
            try {
                nSelRFs = this.selectedReport_forms.length;
            } catch (Exception e) {
                nSelRFs = 0;
            }
        }
        this.report_form1 = null;
        this.report_form2 = null;
        ReportFormsCodeStr = "";
        if (nSelRFs > 0) {//when there are forms selected
            int x = 0;
            for (int i = 0; i < nSelRFs; i++) {
                String reportformcode = "";
                try {
                    reportformcode = "" + this.selectedReport_forms[i].getReport_form_id();
                } catch (NullPointerException npe) {
                    reportformcode = "0";//Unknown
                }
                if (ReportFormsCodeStr.length() > 0) {
                    ReportFormsCodeStr = ReportFormsCodeStr + "," + reportformcode + "";
                } else {
                    ReportFormsCodeStr = "" + reportformcode + "";
                }
                if (reportformcode.equals("0")) {
                    //do nothing
                } else {
                    x = x + 1;
                    if (x == 1) {
                        this.report_form1 = this.selectedReport_forms[i];
                    } else if (x == 2) {
                        this.report_form2 = this.selectedReport_forms[i];
                    }
                }
            }
        } else {//when NO forms selected
        }
        this.count_d1 = 0;
        this.count_d2 = 0;
        this.perc_value1 = 0;
        this.count_n1 = 0;
        this.count_n2 = 0;
        this.perc_value2 = 0;

        //get denominator; eligible entities for the report form
        this.count_d1 = this.getElibileEntities(this.report_form1);
        this.count_d2 = this.getElibileEntities(this.report_form2);

        //get numerator;entities that submitted the report form
        this.count_n1 = this.getReceivedEntities(this.report_form1, this.report_period_year, this.report_period_week);
        this.count_n2 = this.getReceivedEntities(this.report_form2, this.report_period_year, this.report_period_week);

        //calculate percentage for the gauge
        if (this.count_d1 > 0) {
            this.perc_value1 = 100 * (this.count_n1 / this.count_d1);
        } else {
            this.perc_value1 = 0;
        }
        if (this.count_d2 > 0) {
            this.perc_value2 = 100 * (this.count_n2 / this.count_d2);
        } else {
            this.perc_value2 = 0;
        }

        //where for date
        Date startdat = gn.get_week_date_from(this.report_period_year, this.report_period_week);
        Date enddat = gn.get_week_date_to(this.report_period_year, this.report_period_week);
        Date startdat2 = gn.get_week_date_from(this.report_period_year, this.report_period_week + 1);
        Date enddat2 = gn.get_week_date_to(this.report_period_year, this.report_period_week + 1);
        WhereDate = " AND DATE(add_date) BETWEEN '" + new java.sql.Date(startdat2.getTime()) + "' AND '" + new java.sql.Date(enddat2.getTime()) + "'";
        WhereDate2 = " AND DATE(add_date) BETWEEN '" + new java.sql.Date(startdat2.getTime()) + "' AND '" + new java.sql.Date(enddat2.getTime()) + "'";

        //stacked-bar graph
        String sqlPivot = "";
        if (ReportFormsCodeStr.length() > 0) {
            sqlPivot = "select "
                    + "report_form_id,"
                    + "COUNT(IF(status_v='Pass',status_v,NULL)) AS ok,"
                    + "COUNT(IF(status_v='Fail',status_v,NULL)) AS err"
                    + " from (select b.add_date,v.health_facility_id,v.parish_id,v.district_id," +
                    "v.report_form_id,v.status_v,v.status_v_desc from batch_mob_app b " +
                    "inner join validation_report v on b.batch_id=v.batch_id and b.is_completed=1) as mobdata "
                    + "WHERE report_form_id IN(" + ReportFormsCodeStr + ")"
                    + WhereDate
                    + " GROUP BY report_form_id";
        } else {
            sqlPivot = "select "
                    + "report_form_id,"
                    + "COUNT(IF(status_v='Pass',status_v,NULL)) AS ok,"
                    + "COUNT(IF(status_v='Fail',status_v,NULL)) AS err"
                    + " from (select b.add_date,v.health_facility_id,v.parish_id,v.district_id," +
                    "v.report_form_id,v.status_v,v.status_v_desc from batch_mob_app b " +
                    "inner join validation_report v on b.batch_id=v.batch_id and b.is_completed=1) as mobdata "
                    + "WHERE 1=1"
                    + WhereDate
                    + " GROUP BY report_form_id";
        }
        this.refreshStackedBarChartdata(sqlPivot);

        //data table
        this.received_MOB_APPs = new ArrayList<>();
        String sqlData = "";
        ResultSet rs = null;
        if (ReportFormsCodeStr.length() > 0) {
            sqlData = "select * from (select b.add_date,v.health_facility_id,v.parish_id,v.district_id," +
            "v.health_facility_name,v.parish_name,v.district_name,"+
            "v.report_form_id,v.status_v,v.status_v_desc from batch_mob_app b " +
            "inner join validation_report v on b.batch_id=v.batch_id and b.is_completed=1) as mobdata "
                    + "WHERE report_form_id IN(" + ReportFormsCodeStr + ")"
                    + WhereDate;
        } else {
            sqlData = "select * from (select b.add_date,v.health_facility_id,v.parish_id,v.district_id," +
            "v.health_facility_name,v.parish_name,v.district_name,"+
            "v.report_form_id,v.status_v,v.status_v_desc from batch_mob_app b " +
            "inner join validation_report v on b.batch_id=v.batch_id and b.is_completed=1) as mobdata "
                    + "WHERE 1=1"
                    + WhereDate;
        }
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sqlData);) {
            rs = ps.executeQuery();
            Interface_data_mob_app obj;
            while (rs.next()) {
                obj = new Interface_data_mob_app();
                try {
                    obj.setReport_form_id(rs.getInt("report_form_id"));
                } catch (NullPointerException npe) {
                }
                try {
                    obj.setHealth_facility_id(rs.getInt("health_facility_id"));
                    obj.setHealth_facility_name(rs.getString("health_facility_name"));
                } catch (NullPointerException npe) {
                }
                try {
                    obj.setDistrict_id(rs.getInt("district_id"));
                    obj.setDistrict_name(rs.getString("district_name"));
                } catch (NullPointerException npe) {
                }
                try {
                    obj.setAdd_date(rs.getTimestamp("add_date"));
                } catch (NullPointerException npe) {
                }
                try {
                    obj.setStatus_v(rs.getString("status_v"));
                } catch (NullPointerException npe) {
                }
                try {
                    obj.setStatus_v_desc(rs.getString("status_v_desc"));
                } catch (NullPointerException npe) {
                }
                this.received_MOB_APPs.add(obj);
            }
        } catch (SQLException se) {
        }
    }

    public int getElibileEntities(Report_form aReport_form) {
        int x = 0;
        try {
            if (null != aReport_form) {
                x = Report_form_entity.queryReport_form_entity("is_active=1 and is_deleted=0 and report_form_id=" + aReport_form.getReport_form_id(), null).size();
                if (x == 0) {
                    if (aReport_form.getLowest_report_form_level().equals("Facility")) {
                        x = Health_facility.queryHealth_facility("is_active=1 and is_deleted=0", null).size();
                    } else if (aReport_form.getLowest_report_form_level().equals("Parish")) {
                        x = Parish.queryParish("is_active=1 and is_deleted=0", null).size();
                    }
                }
            } else {
                //initilaise
                x = 0;
            }
        } catch (PersistentException ex) {
            Logger.getLogger(Report_formBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    public int getReceivedEntities(Report_form aReport_form, int aReportPeriodYear, int aReportPeriodWeek) {
        int x = 0;
        ResultSet rs = null;
        String WhereDate = "";
        GeneralUtilities gn = new GeneralUtilities();
        try {
            if (null != aReport_form) {
                if (aReport_form.getReport_form_frequency().equals("Weekly")) {
                    if (aReportPeriodWeek > 0) {
                        Date startdat = gn.get_week_date_from(aReportPeriodYear, aReportPeriodWeek);
                        Date enddat = gn.get_week_date_to(aReportPeriodYear, aReportPeriodWeek);
                        Date startdat2 = gn.get_week_date_from(aReportPeriodYear, aReportPeriodWeek + 1);
                        Date enddat2 = gn.get_week_date_to(aReportPeriodYear, aReportPeriodWeek + 1);
                        WhereDate = " AND DATE(add_date) BETWEEN '" + new java.sql.Date(startdat2.getTime()) + "' AND '" + new java.sql.Date(enddat2.getTime()) + "'";
                        //WhereDate = " AND add_date BETWEEN '" + new java.sql.Date(startdat2.getTime()) + "' AND '" + new java.sql.Date(enddat2.getTime()) + "'";
                        //x = Interface_data_mob_app.queryInterface_data_mob_app("is_active=1 and is_deleted=0 and report_form_code='" + aReport_form.getReport_form_code() + "'" + WhereDate, null).size();
                        String sql = "select count(*) as x from "
                                + "(select b.add_date,v.health_facility_id,v.parish_id,v.district_id," +
                                "v.report_form_id,v.status_v,v.status_v_desc from batch_mob_app b " +
                                "inner join validation_report v on b.batch_id=v.batch_id and b.is_completed=1) as mdata "
                                + "where report_form_id=" + aReport_form.getReport_form_id() + WhereDate;
                        try (Connection conn = DBConnection.getMySQLConnection();
                                PreparedStatement ps = conn.prepareStatement(sql);) {
                            rs = ps.executeQuery();
                            if (rs.next()) {
                                x = rs.getInt("x");
                            }
                        } catch (SQLException se) {
                        }
                    } else {
                        x = 0;
                    }
                } else {
                    x = 0;
                }
            } else {
                //initilaise
                x = 0;
            }
        } catch (Exception ex) {
            Logger.getLogger(Report_formBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    public void refreshStackedBarChartdata(String sql) {
        ResultSet rs = null;
        Gson gson = new Gson();
        Map<String, String> dataMap;

        this.CategoriesChartString = "";
        ArrayList<Object> categoryarray = new ArrayList<>();
        this.DataseriesChartString = "";
        ArrayList<Object> dataSeriesArray = new ArrayList<>();
        ArrayList<Object> dataSeriesArray1 = new ArrayList<>();
        ArrayList<Object> dataSeriesArray2 = new ArrayList<>();
        String SerieName1 = "", SerieName2 = "";
        String SerieString1 = "", SerieString2 = "";

        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery();
            while (rs.next()) {
                String FormName = "";
                // add category data to the category array
                dataMap = new LinkedHashMap<String, String>();
                try {
                    FormName = Report_form.getReport_formByORMID(rs.getInt("report_form_id")).getReport_form_name();
                } catch (PersistentException ex) {
                    Logger.getLogger(Interface_data_mob_appBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                FormName = GeneralUtilities.encodeFusionChartSpecialCharacters(FormName);
                dataMap.put("label", FormName);
                categoryarray.add(dataMap);

                // dataseries
                dataMap = new LinkedHashMap<String, String>();
                dataMap.put("value", rs.getString("ok"));
                dataSeriesArray1.add(dataMap);

                dataMap = new LinkedHashMap<String, String>();
                dataMap.put("value", rs.getString("err"));
                dataSeriesArray2.add(dataMap);
            }
            //final categories string from the array
            CategoriesChartString = "[{\"category\":" + gson.toJson(categoryarray) + "}]";

            //build series string from the array
            SerieName1 = "OK";
            SerieString1 = "{\"seriesname\": \"" + SerieName1 + "\",\"data\":" + gson.toJson(dataSeriesArray1) + "}";
            dataSeriesArray.add(SerieString1);
            SerieName2 = "ERR";
            SerieString2 = "{\"seriesname\": \"" + SerieName2 + "\",\"data\":" + gson.toJson(dataSeriesArray2) + "}";
            dataSeriesArray.add(SerieString2);

            //final data series string from the array
            DataseriesChartString = dataSeriesArray.toString();
        } catch (SQLException se) {
            System.err.println("refreshStackedBarChartdata:" + se.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public String getEntityNameByPhone(String aPhone) {
        Phone_contact pc = null;
        String entityname = "";
        try {
            pc = (Phone_contact) Phone_contact.queryPhone_contact("entity_phone='" + aPhone + "'", null).get(0);
            if (null != pc) {
                try {
                    if (pc.getEntity_type().equals("FACILITY")) {
                        entityname = Health_facility.getHealth_facilityByORMID(pc.getEntity_id()).getHealth_facility_name();
                    }
                } catch (NullPointerException npe) {

                }
            }
        } catch (PersistentException ex) {
            Logger.getLogger(Interface_data_mob_appBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entityname;
    }

    /**
     * @return the report_form
     */
    public Report_form getReport_form() {
        return report_form;
    }

    /**
     * @param report_form the report_form to set
     */
    public void setReport_form(Report_form report_form) {
        this.report_form = report_form;
    }

    /**
     * @return the report_period_week
     */
    public Integer getReport_period_week() {
        return report_period_week;
    }

    /**
     * @param report_period_week the report_period_week to set
     */
    public void setReport_period_week(Integer report_period_week) {
        this.report_period_week = report_period_week;
    }

    /**
     * @return the received_MOB_APPs
     */
    public List<Interface_data_mob_app> getReceived_MOB_APPs() {
        return received_MOB_APPs;
    }

    /**
     * @param received_MOB_APPs the received_MOB_APPs to set
     */
    public void setReceived_MOB_APPs(List<Interface_data_mob_app> received_MOB_APPs) {
        this.received_MOB_APPs = received_MOB_APPs;
    }

    /**
     * @return the CategoriesChartString
     */
    public String getCategoriesChartString() {
        return CategoriesChartString;
    }

    /**
     * @param CategoriesChartString the CategoriesChartString to set
     */
    public void setCategoriesChartString(String CategoriesChartString) {
        this.CategoriesChartString = CategoriesChartString;
    }

    /**
     * @return the DataseriesChartString
     */
    public String getDataseriesChartString() {
        return DataseriesChartString;
    }

    /**
     * @param DataseriesChartString the DataseriesChartString to set
     */
    public void setDataseriesChartString(String DataseriesChartString) {
        this.DataseriesChartString = DataseriesChartString;
    }

    /**
     * @return the report_period_year
     */
    public Integer getReport_period_year() {
        return report_period_year;
    }

    /**
     * @param report_period_year the report_period_year to set
     */
    public void setReport_period_year(Integer report_period_year) {
        this.report_period_year = report_period_year;
    }

    /**
     * @return the weekList
     */
    public List<Report_form> getWeekList() {
        return weekList;
    }

    /**
     * @param weekList the weekList to set
     */
    public void setWeekList(List<Report_form> weekList) {
        this.weekList = weekList;
    }

    /**
     * @return the selectedReport_forms
     */
    public Report_form[] getSelectedReport_forms() {
        return selectedReport_forms;
    }

    /**
     * @param selectedReport_forms the selectedReport_forms to set
     */
    public void setSelectedReport_forms(Report_form[] selectedReport_forms) {
        this.selectedReport_forms = selectedReport_forms;
    }

    /**
     * @return the report_forms
     */
    public List<Report_form> getReport_forms() {
        return report_forms;
    }

    /**
     * @param report_forms the report_forms to set
     */
    public void setReport_forms(List<Report_form> report_forms) {
        this.report_forms = report_forms;
    }

    /**
     * @return the report_form1
     */
    public Report_form getReport_form1() {
        return report_form1;
    }

    /**
     * @param report_form1 the report_form1 to set
     */
    public void setReport_form1(Report_form report_form1) {
        this.report_form1 = report_form1;
    }

    /**
     * @return the report_form2
     */
    public Report_form getReport_form2() {
        return report_form2;
    }

    /**
     * @param report_form2 the report_form2 to set
     */
    public void setReport_form2(Report_form report_form2) {
        this.report_form2 = report_form2;
    }

    /**
     * @return the count_n1
     */
    public int getCount_n1() {
        return count_n1;
    }

    /**
     * @param count_n1 the count_n1 to set
     */
    public void setCount_n1(int count_n1) {
        this.count_n1 = count_n1;
    }

    /**
     * @return the count_d1
     */
    public int getCount_d1() {
        return count_d1;
    }

    /**
     * @param count_d1 the count_d1 to set
     */
    public void setCount_d1(int count_d1) {
        this.count_d1 = count_d1;
    }

    /**
     * @return the perc_value1
     */
    public float getPerc_value1() {
        return perc_value1;
    }

    /**
     * @param perc_value1 the perc_value1 to set
     */
    public void setPerc_value1(float perc_value1) {
        this.perc_value1 = perc_value1;
    }

    /**
     * @return the count_n2
     */
    public int getCount_n2() {
        return count_n2;
    }

    /**
     * @param count_n2 the count_n2 to set
     */
    public void setCount_n2(int count_n2) {
        this.count_n2 = count_n2;
    }

    /**
     * @return the count_d2
     */
    public int getCount_d2() {
        return count_d2;
    }

    /**
     * @param count_d2 the count_d2 to set
     */
    public void setCount_d2(int count_d2) {
        this.count_d2 = count_d2;
    }

    /**
     * @return the perc_value2
     */
    public float getPerc_value2() {
        return perc_value2;
    }

    /**
     * @param perc_value2 the perc_value2 to set
     */
    public void setPerc_value2(float perc_value2) {
        this.perc_value2 = perc_value2;
    }

    /**
     * @return the CategoriesChartString1
     */
    public String getCategoriesChartString1() {
        return CategoriesChartString1;
    }

    /**
     * @param CategoriesChartString1 the CategoriesChartString1 to set
     */
    public void setCategoriesChartString1(String CategoriesChartString1) {
        this.CategoriesChartString1 = CategoriesChartString1;
    }

    /**
     * @return the DataseriesChartString1
     */
    public String getDataseriesChartString1() {
        return DataseriesChartString1;
    }

    /**
     * @param DataseriesChartString1 the DataseriesChartString1 to set
     */
    public void setDataseriesChartString1(String DataseriesChartString1) {
        this.DataseriesChartString1 = DataseriesChartString1;
    }

    /**
     * @return the CategoriesChartString2
     */
    public String getCategoriesChartString2() {
        return CategoriesChartString2;
    }

    /**
     * @param CategoriesChartString2 the CategoriesChartString2 to set
     */
    public void setCategoriesChartString2(String CategoriesChartString2) {
        this.CategoriesChartString2 = CategoriesChartString2;
    }

    /**
     * @return the DataseriesChartString2
     */
    public String getDataseriesChartString2() {
        return DataseriesChartString2;
    }

    /**
     * @param DataseriesChartString2 the DataseriesChartString2 to set
     */
    public void setDataseriesChartString2(String DataseriesChartString2) {
        this.DataseriesChartString2 = DataseriesChartString2;
    }

}

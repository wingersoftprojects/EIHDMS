/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.google.gson.Gson;
import connections.DBConnection;
import eihdms.Health_facility;
import eihdms.Interface_data_sms;
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
public class Interface_data_smsBean extends AbstractBean<Interface_data_sms> implements Serializable {

    private Report_form report_form;
    private Integer report_period_week;
    private Integer report_period_year;
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    private int count_n;
    private int count_d;
    private float perc_value;
    private List<Interface_data_sms> received_SMSs = new ArrayList<>();
    private String CategoriesChartString;
    private String DataseriesChartString;
    private List<Report_form> weekList = new ArrayList<>();

    public Interface_data_smsBean() {
        super(Interface_data_sms.class);
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
        try {
            this.report_form = (Report_form) Report_form.queryReport_form("mode_data_entry=2", null).get(0);
        } catch (PersistentException | IndexOutOfBoundsException ex) {
            Logger.getLogger(Interface_data_smsBean.class.getName()).log(Level.SEVERE, null, ex);
            this.report_form = null;
        }
        this.refreshWeeks(this.report_period_year, this.report_period_week);
        this.refreshSMSreceivedDashboard(this.report_form, this.report_period_year, this.report_period_week);
    }

    public void refreshSMSreceivedDashboard(Report_form aReport_form, int aReportPeriodYear, int aReportPeriodWeek) {
        GeneralUtilities gn = new GeneralUtilities();
        String WhereDate = "";
        String WhereDate2 = "";
        if (null != aReport_form) {
            //get denominator; eligible entities for the report form
            this.count_d = this.getElibileEntities(aReport_form);

            //get numerator;entities that submitted the report form
            this.count_n = this.getReceivedEntities(aReport_form, aReportPeriodYear, aReportPeriodWeek);

            //calculate percentage for the gauge
            if (this.count_d > 0) {
                this.perc_value = 100 * (this.count_n / this.count_d);
            } else {
                this.perc_value = 0;
            }

            //where for date
            Date startdat = gn.get_week_date_from(aReportPeriodYear, aReportPeriodWeek);
            Date enddat = gn.get_week_date_to(aReportPeriodYear, aReportPeriodWeek);
            Date startdat2 = gn.get_week_date_from(aReportPeriodYear, aReportPeriodWeek+1);
            Date enddat2 = gn.get_week_date_to(aReportPeriodYear, aReportPeriodWeek+1);
            WhereDate = " AND DATE(s.add_date) BETWEEN '" + new java.sql.Date(startdat2.getTime()) + "' AND '" + new java.sql.Date(enddat2.getTime()) + "'";
            WhereDate2 = " AND DATE(add_date) BETWEEN '" + new java.sql.Date(startdat2.getTime()) + "' AND '" + new java.sql.Date(enddat2.getTime()) + "'";

            //stacked-bar graph
            String sqlPivot = "SELECT s.report_form_code,rf.report_form_name,"
                    + "COUNT(IF(status_f='OK',status_f,NULL)) AS ok,"
                    + "COUNT(IF(status_f='ERR',status_f,NULL)) AS err "
                    + "FROM interface_data_sms s "
                    + "inner join report_form rf on s.report_form_code=rf.report_form_code "
                    + "WHERE s.report_form_code='" + aReport_form.getReport_form_code() + "'"
                    + WhereDate
                    + " GROUP BY report_form_code";
            this.refreshStackedBarChartdata(sqlPivot);

            //data table
            this.received_SMSs = new ArrayList<>();
            try {
                this.received_SMSs = Interface_data_sms.queryInterface_data_sms("is_active=1 and is_deleted=0 and report_form_code='" + aReport_form.getReport_form_code() + "' " + WhereDate2, "add_date DESC");
            } catch (PersistentException ex) {
                Logger.getLogger(Report_formBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //initilaise
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
        String WhereDate = "";
        GeneralUtilities gn = new GeneralUtilities();
        try {
            if (null != aReport_form) {
                if (aReport_form.getReport_form_frequency().equals("Weekly")) {
                    if (aReportPeriodWeek > 0) {
                        Date startdat = gn.get_week_date_from(aReportPeriodYear, aReportPeriodWeek);
                        Date enddat = gn.get_week_date_to(aReportPeriodYear, aReportPeriodWeek);
                        Date startdat2 = gn.get_week_date_from(aReportPeriodYear, aReportPeriodWeek+1);
                        Date enddat2 = gn.get_week_date_to(aReportPeriodYear, aReportPeriodWeek+1);
                        WhereDate = " AND DATE(add_date) BETWEEN '" + new java.sql.Date(startdat2.getTime()) + "' AND '" + new java.sql.Date(enddat2.getTime()) + "'";
                        x = Interface_data_sms.queryInterface_data_sms("is_active=1 and is_deleted=0 and report_form_code='" + aReport_form.getReport_form_code() + "'" + WhereDate, null).size();
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
        } catch (PersistentException ex) {
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
                FormName = rs.getString("report_form_name");
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
            Logger.getLogger(Interface_data_smsBean.class.getName()).log(Level.SEVERE, null, ex);
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
     * @return the count_n
     */
    public int getCount_n() {
        return count_n;
    }

    /**
     * @param count_n the count_n to set
     */
    public void setCount_n(int count_n) {
        this.count_n = count_n;
    }

    /**
     * @return the count_d
     */
    public int getCount_d() {
        return count_d;
    }

    /**
     * @param count_d the count_d to set
     */
    public void setCount_d(int count_d) {
        this.count_d = count_d;
    }

    /**
     * @return the perc_value
     */
    public float getPerc_value() {
        return perc_value;
    }

    /**
     * @param perc_value the perc_value to set
     */
    public void setPerc_value(float perc_value) {
        this.perc_value = perc_value;
    }

    /**
     * @return the received_SMSs
     */
    public List<Interface_data_sms> getReceived_SMSs() {
        return received_SMSs;
    }

    /**
     * @param received_SMSs the received_SMSs to set
     */
    public void setReceived_SMSs(List<Interface_data_sms> received_SMSs) {
        this.received_SMSs = received_SMSs;
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

}

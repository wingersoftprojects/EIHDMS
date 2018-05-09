/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.google.gson.Gson;
import connections.DBConnection;
import eihdms.Dashboard_surge;
import eihdms.District;
import eihdms.Health_facility;
import eihdms.Interface_data_sms;
import eihdms.Parish;
import eihdms.Report_form;
import eihdms.Report_form_entity;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
public class Dashboard_surgeBean extends AbstractBean<Dashboard_surge> implements Serializable {

    private Report_form report_form;
    private Integer report_period_week;
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    private int count_n;
    private int count_d;
    private float perc_value;
    private List<Interface_data_sms> received_SMSs = new ArrayList<>();
    private String CategoriesChartString;
    private String DataseriesChartString;
    private District district;
    private Health_facility facility;
    private int year_value;
    private int month_value;
    private int week_value;
    private int indicator_id;
    private String indicator_name;
    private int count_n1;
    private int count_d1;
    private float perc_value1;
    private int count_n2;
    private int count_d2;
    private float perc_value2;
    private int count_n3;
    private int count_d3;
    private float perc_value3;
    private int count_n4;
    private int count_d4;
    private float perc_value4;
    private int count_n5;
    private int count_d5;
    private float perc_value5;
    private int count_n6;
    private int count_d6;
    private float perc_value6;
    private String DataChartString2;
    private String DataChartString4;
    private String DataChartString5;
    private String DataChartString6;
    private List<Report_form> weekList = new ArrayList<>();

    public Dashboard_surgeBean() {
        super(Dashboard_surge.class);
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

    public String getIndicatorStringById(int aIndicatorId) {
        if (aIndicatorId == 1) {
            return "% Viral Load Testing Coverage";
        } else if (aIndicatorId == 2) {
            return "% of clients missed appointment during the week";
        } else if (aIndicatorId == 3) {
            return "% of clients missed appointment during the previous week and brought back into care";
        } else if (aIndicatorId == 4) {
            return "HTS Yield";
        } else if (aIndicatorId == 5) {
            return "Total/% started ART";
        } else {
            return "";
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
        this.year_value = previous_week_year;
        this.week_value = previous_week;
        this.district = null;
        this.facility = null;
        this.indicator_id = 1;
        this.month_value = 0;
        this.refreshWeeks(this.year_value,this.week_value);
        this.refreshDashboard(this.year_value, this.month_value, this.week_value, this.district, this.facility, this.indicator_id);
    }
    
    public void refreshWeeks(int aYear, int aTopWeek){
        weekList = new ArrayList<>();
        Report_form week=null;
        GeneralUtilities gu=new GeneralUtilities();
        int i=1;
        while(i<=10){
            week=new Report_form();
            week.setIs_active(aTopWeek);
            week.setReport_form_code(aTopWeek + " (" + gu.get_week_dates_from_year_and_week(aYear, aTopWeek) + ")");
            weekList.add(week);
            aTopWeek=aTopWeek-1;
            if(aTopWeek<=0){
                break;
            }
            i=i+1;
        }
    }

    public void refreshDashboard(int aYear, int aMonth, int aWeek, District aDistrict, Health_facility aFacility, int aIndicatorId) {
        ResultSet rs = null;
        ResultSet rs2 = null;
        Gson gson;
        String sql1 = "SELECT "
                + "ceil(avg(a)) as a,ceil(avg(b)) as b,ceil(avg(b_prev)) as b_prev,ceil(avg(c)) as c,ceil(avg(d)) as d,ceil(avg(e)) as e,ceil(avg(f)) as f,ceil(avg(g)) as g,ceil(avg(h)) as h,ceil(avg(i)) as i,ceil(avg(j)) as j,ceil(avg(k)) as k,ceil(avg(l)) as l,"
                + "avg(perc_test_coverage) as perc_test_coverage,avg(perc_miss_appoint_cur) as perc_miss_appoint_cur,avg(perc_miss_appoint_prev) as perc_miss_appoint_prev,"
                + "avg(perc_hts_yield) as perc_hts_yield,avg(perc_start_art) as perc_start_art "
                + "FROM dashboard_surge WHERE 1=1";
        String sql2 = "SELECT report_period_year,report_period_week,"
                + "perc_test_coverage,perc_miss_appoint_cur,perc_miss_appoint_prev,perc_hts_yield,perc_start_art "
                + "FROM dashboard_surge WHERE 1=1";
        String order2 = " ORDER BY report_period_year ASC,report_period_week ASC";
        String where1 = "";
        if (aYear > 0) {
            where1 = where1 + " and report_period_year=" + aYear;
        }
        if (aMonth > 0) {
            where1 = where1 + " and (MONTH(report_period_from_date)>=" + aMonth + " and MONTH(report_period_from_date)<=" + aMonth + ")";
        }
        if (aWeek > 0) {
            where1 = where1 + " and report_period_week=" + aWeek;
        }
        try {
            if (null != aDistrict && aDistrict.getDistrict_id() > 0) {
                where1 = where1 + " and district_id=" + aDistrict.getDistrict_id();
            }
        } catch (NullPointerException npe) {
            //skip 
        }
        try {
            if (null != aFacility && aFacility.getHealth_facility_id() > 0) {
                where1 = where1 + " and health_facility_id=" + aFacility.getHealth_facility_id();
            }
        } catch (NullPointerException npe) {
            //skip 
        }
        sql1 = sql1 + where1;
        sql2 = sql2 + where1 + order2;

        //for the indicator charts
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql1);) {
            System.out.println("SQL1:" + sql1);
            rs = ps.executeQuery();
            if (rs.next()) {
                DecimalFormat myFormatter = new DecimalFormat("###,###");
                Map<String, String> lv;
                //indicator-1:d/a*100%
                try {
                    this.count_n1 = rs.getInt("d");
                } catch (NullPointerException npe) {
                    this.count_n1 = 0;
                }
                try {
                    this.count_d1 = rs.getInt("a");
                } catch (NullPointerException npe) {
                    this.count_d1 = 0;
                }
                try {
                    this.perc_value1 = rs.getFloat("perc_test_coverage");
                } catch (NullPointerException npe) {
                    this.perc_value1 = 0;
                }

                //indicator-2:b/(a+b)*100%
                gson = new Gson();
                this.DataChartString2 = "[]";
                List<Object> ChartDataArray2 = new ArrayList<>();
                lv = new HashMap<String, String>();
                lv.put("label", "Missed");
                lv.put("value", myFormatter.format(rs.getFloat("perc_miss_appoint_cur")));
                ChartDataArray2.add(lv);
                lv = new HashMap<String, String>();
                lv.put("label", "Attended");
                lv.put("value", myFormatter.format(100 - rs.getFloat("perc_miss_appoint_cur")));
                ChartDataArray2.add(lv);
                if (ChartDataArray2.size() > 0) {
                    this.DataChartString2 = gson.toJson(ChartDataArray2);
                    System.out.println("DataChartString2:" + DataChartString2);
                }

                //indicator-3:c/b*100%
                try {
                    this.count_n3 = rs.getInt("c");
                } catch (NullPointerException npe) {
                    this.count_n3 = 0;
                }
                try {
                    this.count_d3 = rs.getInt("b_prev");
                } catch (NullPointerException npe) {
                    this.count_d3 = 0;
                }
                try {
                    this.perc_value3 = rs.getFloat("perc_miss_appoint_prev");
                } catch (NullPointerException npe) {
                    this.perc_value3 = 0;
                }

                //indicator-4:f/e*100%
                try {
                    this.count_n4 = rs.getInt("f");
                } catch (NullPointerException npe) {
                    this.count_n4 = 0;
                }
                try {
                    this.count_d4 = rs.getInt("e");
                } catch (NullPointerException npe) {
                    this.count_d4 = 0;
                }
                try {
                    this.perc_value4 = rs.getFloat("perc_hts_yield");
                } catch (NullPointerException npe) {
                    this.perc_value4 = 0;
                }

                //indicator-5:
                try {
                    this.count_n5 = rs.getInt("h");
                } catch (NullPointerException npe) {
                    this.count_n5 = 0;
                }
                try {
                    this.count_d5 = rs.getInt("f");
                } catch (NullPointerException npe) {
                    this.count_d5 = 0;
                }
                try {
                    this.perc_value5 = rs.getFloat("perc_start_art");
                } catch (NullPointerException npe) {
                    this.perc_value5 = 0;
                }
            }
        } catch (SQLException se1) {
            System.err.println("refreshDashboard1-Charts:" + se1.getMessage());
        }

        //for the trend
        try (Connection conn2 = DBConnection.getMySQLConnection();
                PreparedStatement ps2 = conn2.prepareStatement(sql2);) {
            System.out.println("SQL2:" + sql2);
            rs2 = ps2.executeQuery();
            DecimalFormat myFormatter = new DecimalFormat("###,###");
            Map<String, String> lv;
            gson = new Gson();
            this.DataChartString6 = "[]";
            List<Object> ChartDataArray6 = new ArrayList<>();
            while (rs2.next()) {
                lv = new HashMap<String, String>();
                try {
                    lv.put("label", rs2.getString("report_period_year") + "W" + rs2.getString("report_period_week"));
                } catch (NullPointerException npe) {
                    lv.put("label", "");
                }
                if (aIndicatorId == 1) {
                    //perc_test_coverage
                    try {
                        lv.put("value", myFormatter.format(rs2.getFloat("perc_test_coverage")));
                    } catch (NullPointerException npe) {
                        lv.put("value", "0");
                    }
                } else if (aIndicatorId == 2) {
                    //perc_miss_appoint_cur
                    try {
                        lv.put("value", myFormatter.format(rs2.getFloat("perc_miss_appoint_cur")));
                    } catch (NullPointerException npe) {
                        lv.put("value", "0");
                    }
                } else if (aIndicatorId == 3) {
                    //perc_miss_appoint_prev
                    try {
                        lv.put("value", myFormatter.format(rs2.getFloat("perc_miss_appoint_prev")));
                    } catch (NullPointerException npe) {
                        lv.put("value", "0");
                    }
                } else if (aIndicatorId == 4) {
                    //perc_hts_yield
                    try {
                        lv.put("value", myFormatter.format(rs2.getFloat("perc_hts_yield")));
                    } catch (NullPointerException npe) {
                        lv.put("value", "0");
                    }
                } else if (aIndicatorId == 5) {
                    //perc_start_art
                    try {
                        lv.put("value", myFormatter.format(rs2.getFloat("perc_miss_appoint_cur")));
                    } catch (NullPointerException npe) {
                        lv.put("value", "0");
                    }
                } else {
                    lv.put("value", "0");
                }
                ChartDataArray6.add(lv);
            }
            if (ChartDataArray6.size() > 0) {
                this.DataChartString6 = gson.toJson(ChartDataArray6);
                System.out.println("DataChartString6:" + DataChartString6);
            }
        } catch (SQLException se1) {
            System.err.println("refreshDashboard1-Trend:" + se1.getMessage());
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

    public int getReceivedEntities(Report_form aReport_form, int aReportPeriodWeek) {
        int x = 0;
        try {
            if (null != aReport_form) {
                if (aReport_form.getReport_form_frequency().equals("Weekly")) {
                    if (aReportPeriodWeek > 0) {
                        //Need to first add period in sms_data or calculate it from add_date

                    } else {
                        x = Interface_data_sms.queryInterface_data_sms("is_active=1 and is_deleted=0 and report_form_code='" + aReport_form.getReport_form_code() + "'", null).size();
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
     * @return the district
     */
    public District getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(District district) {
        this.district = district;
    }

    /**
     * @return the facility
     */
    public Health_facility getFacility() {
        return facility;
    }

    /**
     * @param facility the facility to set
     */
    public void setFacility(Health_facility facility) {
        this.facility = facility;
    }

    /**
     * @return the year_value
     */
    public int getYear_value() {
        return year_value;
    }

    /**
     * @param year_value the year_value to set
     */
    public void setYear_value(int year_value) {
        this.year_value = year_value;
    }

    /**
     * @return the month_value
     */
    public int getMonth_value() {
        return month_value;
    }

    /**
     * @param month_value the month_value to set
     */
    public void setMonth_value(int month_value) {
        this.month_value = month_value;
    }

    /**
     * @return the week_value
     */
    public int getWeek_value() {
        return week_value;
    }

    /**
     * @param week_value the week_value to set
     */
    public void setWeek_value(int week_value) {
        this.week_value = week_value;
    }

    /**
     * @return the indicator_id
     */
    public int getIndicator_id() {
        return indicator_id;
    }

    /**
     * @param indicator_id the indicator_id to set
     */
    public void setIndicator_id(int indicator_id) {
        this.indicator_id = indicator_id;
    }

    /**
     * @return the indicator_name
     */
    public String getIndicator_name() {
        return indicator_name;
    }

    /**
     * @param indicator_name the indicator_name to set
     */
    public void setIndicator_name(String indicator_name) {
        this.indicator_name = indicator_name;
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
     * @return the count_n3
     */
    public int getCount_n3() {
        return count_n3;
    }

    /**
     * @param count_n3 the count_n3 to set
     */
    public void setCount_n3(int count_n3) {
        this.count_n3 = count_n3;
    }

    /**
     * @return the count_d3
     */
    public int getCount_d3() {
        return count_d3;
    }

    /**
     * @param count_d3 the count_d3 to set
     */
    public void setCount_d3(int count_d3) {
        this.count_d3 = count_d3;
    }

    /**
     * @return the perc_value3
     */
    public float getPerc_value3() {
        return perc_value3;
    }

    /**
     * @param perc_value3 the perc_value3 to set
     */
    public void setPerc_value3(float perc_value3) {
        this.perc_value3 = perc_value3;
    }

    /**
     * @return the count_n4
     */
    public int getCount_n4() {
        return count_n4;
    }

    /**
     * @param count_n4 the count_n4 to set
     */
    public void setCount_n4(int count_n4) {
        this.count_n4 = count_n4;
    }

    /**
     * @return the count_d4
     */
    public int getCount_d4() {
        return count_d4;
    }

    /**
     * @param count_d4 the count_d4 to set
     */
    public void setCount_d4(int count_d4) {
        this.count_d4 = count_d4;
    }

    /**
     * @return the perc_value4
     */
    public float getPerc_value4() {
        return perc_value4;
    }

    /**
     * @param perc_value4 the perc_value4 to set
     */
    public void setPerc_value4(float perc_value4) {
        this.perc_value4 = perc_value4;
    }

    /**
     * @return the count_n5
     */
    public int getCount_n5() {
        return count_n5;
    }

    /**
     * @param count_n5 the count_n5 to set
     */
    public void setCount_n5(int count_n5) {
        this.count_n5 = count_n5;
    }

    /**
     * @return the count_d5
     */
    public int getCount_d5() {
        return count_d5;
    }

    /**
     * @param count_d5 the count_d5 to set
     */
    public void setCount_d5(int count_d5) {
        this.count_d5 = count_d5;
    }

    /**
     * @return the perc_value5
     */
    public float getPerc_value5() {
        return perc_value5;
    }

    /**
     * @param perc_value5 the perc_value5 to set
     */
    public void setPerc_value5(float perc_value5) {
        this.perc_value5 = perc_value5;
    }

    /**
     * @return the count_n6
     */
    public int getCount_n6() {
        return count_n6;
    }

    /**
     * @param count_n6 the count_n6 to set
     */
    public void setCount_n6(int count_n6) {
        this.count_n6 = count_n6;
    }

    /**
     * @return the count_d6
     */
    public int getCount_d6() {
        return count_d6;
    }

    /**
     * @param count_d6 the count_d6 to set
     */
    public void setCount_d6(int count_d6) {
        this.count_d6 = count_d6;
    }

    /**
     * @return the perc_value6
     */
    public float getPerc_value6() {
        return perc_value6;
    }

    /**
     * @param perc_value6 the perc_value6 to set
     */
    public void setPerc_value6(float perc_value6) {
        this.perc_value6 = perc_value6;
    }

    /**
     * @return the DataChartString2
     */
    public String getDataChartString2() {
        return DataChartString2;
    }

    /**
     * @param DataChartString2 the DataChartString2 to set
     */
    public void setDataChartString2(String DataChartString2) {
        this.DataChartString2 = DataChartString2;
    }

    /**
     * @return the DataChartString4
     */
    public String getDataChartString4() {
        return DataChartString4;
    }

    /**
     * @param DataChartString4 the DataChartString4 to set
     */
    public void setDataChartString4(String DataChartString4) {
        this.DataChartString4 = DataChartString4;
    }

    /**
     * @return the DataChartString5
     */
    public String getDataChartString5() {
        return DataChartString5;
    }

    /**
     * @param DataChartString5 the DataChartString5 to set
     */
    public void setDataChartString5(String DataChartString5) {
        this.DataChartString5 = DataChartString5;
    }

    /**
     * @return the DataChartString6
     */
    public String getDataChartString6() {
        return DataChartString6;
    }

    /**
     * @param DataChartString6 the DataChartString6 to set
     */
    public void setDataChartString6(String DataChartString6) {
        this.DataChartString6 = DataChartString6;
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

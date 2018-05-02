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
import eihdms.Report_form;
import eihdms.Report_form_entity;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
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
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    private int count_n;
    private int count_d;
    private float perc_value;
    private List<Interface_data_sms> received_SMSs = new ArrayList<>();
    private String CategoriesChartString;
    private String DataseriesChartString;

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

    public void refreshSMSreceivedDashboard(Report_form aReport_form, int aReportPeriodWeek) {
        if (null != aReport_form) {
            //get denominator; eligible entities for the report form
            this.count_d = this.getElibileEntities(aReport_form);
            
            //get numerator;entities that submitted the report form
            this.count_n = this.getReceivedEntities(aReport_form, aReportPeriodWeek);
            
            //calculate percentage for the gauge
            if (this.count_d > 0) {
                this.perc_value = 100 * (this.count_n / this.count_d);
            } else {
                this.perc_value = 0;
            }
            
            //stacked-bar graph
            String sqlPivot = "SELECT s.report_form_code,rf.report_form_name,"
                    + "COUNT(IF(status_f='OK',status_f,NULL)) AS ok,"
                    + "COUNT(IF(status_f='ERR',status_f,NULL)) AS err "
                    + "FROM interface_data_sms s "
                    + "inner join report_form rf on s.report_form_code=rf.report_form_code "
                    + "WHERE s.report_form_code='" + aReport_form.getReport_form_code() + "' "
                    + "GROUP BY report_form_code"; 
            this.refreshStackedBarChartdata(sqlPivot);

            //data table
            this.received_SMSs = new ArrayList<>();
            try {
                this.received_SMSs = Interface_data_sms.queryInterface_data_sms("is_active=1 and is_deleted=0 and report_form_code='" + aReport_form.getReport_form_code() + "'", "add_date DESC");
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

}

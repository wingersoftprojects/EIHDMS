/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.google.gson.Gson;
import connections.DBConnection;
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

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class Art_retentionBean_old2 implements Serializable {

    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    private List<Art_retention> Art_retentionList = new ArrayList<>();
    private String CategoriesChartString;
    private String DataseriesChartString;
    private District district;
    private Health_facility facility;
    private int year_value;
    private int month_value;
    private District[] selectedDistricts;
    private Health_facility[] selectedFacilities;
    private List<District> districts;
    private List<Health_facility> facilities;
    private String RangeDesc;

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public void pivotArtRetention(long aBatchId) {
        String sql = "{call sp_select_raw_art_retention(?)}";
        ResultSet rs = null;
        try (Connection conn = DBConnection.getMySQLConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, aBatchId);
            rs = ps.executeQuery();
            int Adistrict_id = 0;
            String Adistrict_name = "";
            int Ahealth_facility_id = 0;
            String Ahealth_facility_name = "";
            int Ay = 0;
            int Am = 0;
            int Am0 = 0;
            int Am1 = 0;
            int Am2 = 0;
            int Am3 = 0;
            int Am4 = 0;
            int Am5 = 0;
            int col = 1;
            while (rs.next()) {
                if (col == 1) {
                    try {
                        Adistrict_id = rs.getInt("district_id");
                    } catch (NullPointerException npe) {
                        Adistrict_id = 0;
                    }
                    try {
                        Adistrict_name = rs.getString("district_name");
                    } catch (Exception e) {
                        Adistrict_name = "";
                    }
                    try {
                        Ahealth_facility_id = rs.getInt("health_facility_id");
                    } catch (NullPointerException npe) {
                        Ahealth_facility_id = 0;
                    }
                    try {
                        Ahealth_facility_name = rs.getString("health_facility_name");
                    } catch (Exception e) {
                        Ahealth_facility_name = "";
                    }
                    try {
                        Ay = rs.getInt("data_element_value");
                    } catch (NullPointerException npe) {
                        Ay = 0;
                    }
                    col = col + 1;
                } else if (col == 2) {
                    try {
                        Am = rs.getInt("data_element_value");
                    } catch (NullPointerException npe) {
                        Am = 0;
                    }
                    col = col + 1;
                } else if (col == 3) {
                    try {
                        Am0 = rs.getInt("data_element_value");
                    } catch (NullPointerException npe) {
                        Am0 = 0;
                    }
                    col = col + 1;
                } else if (col == 4) {
                    try {
                        Am1 = rs.getInt("data_element_value");
                    } catch (NullPointerException npe) {
                        Am1 = 0;
                    }
                    col = col + 1;
                } else if (col == 5) {
                    try {
                        Am2 = rs.getInt("data_element_value");
                    } catch (NullPointerException npe) {
                        Am2 = 0;
                    }
                    col = col + 1;
                } else if (col == 6) {
                    try {
                        Am3 = rs.getInt("data_element_value");
                    } catch (NullPointerException npe) {
                        Am3 = 0;
                    }
                    col = col + 1;
                } else if (col == 7) {
                    try {
                        Am4 = rs.getInt("data_element_value");
                    } catch (NullPointerException npe) {
                        Am4 = 0;
                    }
                    col = col + 1;
                } else if (col == 8) {
                    try {
                        Am5 = rs.getInt("data_element_value");
                    } catch (NullPointerException npe) {
                        Am5 = 0;
                    }
                    long aID = this.getPivotArtRetention(Ahealth_facility_id, Ay, Am);
                    if (aID == 0) {
                        this.pivotInsertArtRetention(aBatchId, Adistrict_id, Adistrict_name, Ahealth_facility_id, Ahealth_facility_name, Ay, Am, Am0, Am1, Am2, Am3, Am4, Am5);
                    } else {
                        this.pivotUpdateArtRetention(aBatchId, Adistrict_id, Adistrict_name, Ahealth_facility_id, Ahealth_facility_name, Ay, Am, Am0, Am1, Am2, Am3, Am4, Am5, aID);
                    }
                    col = 1;
                }
            }
        } catch (SQLException se) {
            System.err.println("pivotInsertArtRetention:" + se.getMessage());
        }
    }

    public void deletePivotArtRetention(long aBatchId) {
        String sql = "delete from art_retention_pivot where batch_id=?";
        ResultSet rs = null;
        try (Connection conn = DBConnection.getMySQLConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, aBatchId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("deletePivotArtRetention:" + e.getMessage());
        }
    }

    public void pivotInsertArtRetention(long aBatchId, int Adistrict_id, String Adistrict_name, int Ahealth_facility_id, String Ahealth_facility_name, int Ay, int Am, int Am0, int Am1, int Am2, int Am3, int Am4, int Am5) {
        String sql = "INSERT INTO art_retention_pivot("
                + "batch_id,district_id,district_name,health_facility_id,health_facility_name,"
                + "y,m,m0,m1,m2,m3,m4,m5) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getMySQLConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, aBatchId);
            ps.setInt(2, Adistrict_id);
            ps.setString(3, Adistrict_name);
            ps.setInt(4, Ahealth_facility_id);
            ps.setString(5, Ahealth_facility_name);
            if (Ay >= 0) {
                ps.setInt(6, Ay);
            } else {
                ps.setInt(6, 0);
            }
            if (Am >= 0) {
                ps.setInt(7, Am);
            } else {
                ps.setInt(7, 0);
            }
            if (Am0 >= 0) {
                ps.setInt(8, Am0);
            } else {
                ps.setInt(8, 0);
            }
            if (Am1 >= 0) {
                ps.setInt(9, Am1);
            } else {
                ps.setInt(9, 0);
            }
            if (Am2 >= 0) {
                ps.setInt(10, Am2);
            } else {
                ps.setInt(10, 0);
            }
            if (Am3 >= 0) {
                ps.setInt(11, Am3);
            } else {
                ps.setInt(11, 0);
            }
            if (Am4 >= 0) {
                ps.setInt(12, Am4);
            } else {
                ps.setInt(12, 0);
            }
            if (Am5 >= 0) {
                ps.setInt(13, Am5);
            } else {
                ps.setInt(13, 0);
            }
            //System.out.println("INSERT:" + ps.toString());
            ps.executeUpdate();
        } catch (SQLException se) {
            System.err.println("pivotInsertArtRetention:" + se.getMessage());
        }
    }

    public void pivotUpdateArtRetention(long aBatchId, int Adistrict_id, String Adistrict_name, int Ahealth_facility_id, String Ahealth_facility_name, int Ay, int Am, int Am0, int Am1, int Am2, int Am3, int Am4, int Am5, long aID) {
        String sql = "UPDATE art_retention_pivot SET "
                + "batch_id=?,"
                + "m0=?,m1=?,m2=?,m3=?,m4=?,m5=? WHERE art_retention_pivot_id=?";
        try (Connection conn = DBConnection.getMySQLConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, aBatchId);
            ps.setInt(2, Am0);
            ps.setInt(3, Am1);
            ps.setInt(4, Am2);
            ps.setInt(5, Am3);
            ps.setInt(6, Am4);
            ps.setInt(7, Am5);
            ps.setLong(8, aID);
            //System.out.println("UPDATE:" + ps.toString());
            ps.executeUpdate();
        } catch (SQLException se) {
            System.err.println("pivotUpdateArtRetention:" + se.getMessage());
        }
    }

    public long getPivotArtRetention(int Ahealth_facility_id, int Ay, int Am) {
        ResultSet rs = null;
        long aID = 0;
        String sql = "SELECT * FROM art_retention_pivot WHERE "
                + "health_facility_id=? AND y=? and m=?";
        try (Connection conn = DBConnection.getMySQLConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Ahealth_facility_id);
            ps.setInt(2, Ay);
            ps.setInt(3, Am);
            rs = ps.executeQuery();
            if (rs.next()) {
                try {
                    aID = rs.getLong("art_retention_pivot_id");
                } catch (Exception e) {
                    //do nothing
                }
            }
        } catch (SQLException se) {
            System.err.println("getPivotArtRetention:" + se.getMessage());
        }
        return aID;
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
        int current_month = Calendar.getInstance().get(Calendar.MONTH);

        this.year_value = current_year;
        this.month_value = 0;//current_month;
        selectedDistricts = new District[0];
        selectedFacilities = new Health_facility[0];
        this.refreshDashboard(this.year_value, this.month_value, this.selectedDistricts, this.selectedFacilities);
    }

    public void refreshDashboard(int aYear, int aMonth, District[] aSelectedDistricts, Health_facility[] aSelectedFacilities) {
        ResultSet rs = null;
        ResultSet rs2 = null;
        Gson gson;
        String sql1 = "SELECT sum(m0) as m0,sum(m1) as m1,sum(m2) as m2,sum(m3) as m3,sum(m4) as m4,sum(m5) as m5 "
                + "FROM art_retention_pivot pv left join health_facility hf on pv.health_facility_id=hf.health_facility_id "
                + " left join district d on pv.district_id=d.district_id "
                + "WHERE 1=1";
        String sql2 = "SELECT d.district_name,hf.health_facility_name,pv.district_id,pv.health_facility_id,"
                + "y,m,m0,m1,m2,m3,m4,m5 "
                + "FROM art_retention_pivot pv left join health_facility hf on pv.health_facility_id=hf.health_facility_id "
                + " left join district d on pv.district_id=d.district_id "
                + "WHERE 1=1";
        String where1 = "";
        String where2 = "";
        if (aYear > 0) {
            where1 = where1 + " and y=" + aYear;
            where2 = where2 + " and y=" + aYear;
        }
        if (aMonth > 0) {
            where1 = where1 + " and m=" + aMonth;
            where2 = where2 + " and m=" + aMonth;
        }
        try {
            String aDIDs = this.getDistrictsStr();
            if (aDIDs.length() > 0) {
                where1 = where1 + " and pv.district_id IN (" + aDIDs + ")";
                where2 = where2 + " and pv.district_id IN (" + aDIDs + ")";
            }
        } catch (NullPointerException npe) {
            //skip 
        }
        try {
            String aFIDs = this.getFacilitiesStr();
            if (aFIDs.length() > 0) {
                where1 = where1 + " and pv.health_facility_id IN(" + aFIDs + ")";
                where2 = where2 + " and pv.health_facility_id IN(" + aFIDs + ")";
            }
        } catch (NullPointerException npe) {
            //skip 
        }
        sql1 = sql1 + where1;
        sql2 = sql2 + where2 + " ORDER BY y desc,m desc";
        //for the chart
        //System.out.println("sql1:" + sql1);
        this.refreshBarChartdata(sql1);

        //for the data list
        try {
            this.Art_retentionList.clear();
            this.refreshDashboardList(sql2);
        } catch (Exception ex) {
            Logger.getLogger(Art_retentionBean_old2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshDashboardList(String Asql) {
        ResultSet rs = null;
        //System.out.println("SQL2:" + Asql);
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(Asql);) {
            rs = ps.executeQuery();
            while (rs.next()) {
                Art_retention ds = new Art_retention();
                this.setObjectFromResultset(ds, rs);
                this.Art_retentionList.add(ds);
            }
        } catch (SQLException se) {
            System.err.println("refreshDashboardList:" + se.getMessage());
        }
    }

    public void setObjectFromResultset(Art_retention aArt_retention, ResultSet aResultSet) {
        try {
            try {
                aArt_retention.setDistrict_id(aResultSet.getInt("district_id"));
            } catch (NullPointerException npe) {
            }
            try {
                aArt_retention.setHealth_facility_id(aResultSet.getInt("health_facility_id"));
            } catch (NullPointerException npe) {
            }
            aArt_retention.setDistrict_name(aResultSet.getString("district_name"));
            aArt_retention.setHealth_facility_name(aResultSet.getString("health_facility_name"));
            try {
                aArt_retention.setCohort_start_year(aResultSet.getInt("y"));
            } catch (NullPointerException npe) {

            }
            try {
                aArt_retention.setCohort_start_month(aResultSet.getInt("m"));
            } catch (NullPointerException npe) {

            }
            try {
                aArt_retention.setMo(aResultSet.getInt("m0"));
            } catch (NullPointerException npe) {

            }
            try {
                aArt_retention.setM1(aResultSet.getInt("m1"));
            } catch (NullPointerException npe) {

            }
            try {
                aArt_retention.setM2(aResultSet.getInt("m2"));
            } catch (NullPointerException npe) {

            }
            try {
                aArt_retention.setM3(aResultSet.getInt("m3"));
            } catch (NullPointerException npe) {

            }
            try {
                aArt_retention.setM4(aResultSet.getInt("m4"));
            } catch (NullPointerException npe) {

            }
            try {
                aArt_retention.setM5(aResultSet.getInt("m5"));
            } catch (NullPointerException npe) {

            }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
    }

    public void refreshBarChartdata(String sql) {
        ResultSet rs2 = null;
        Gson gson = new Gson();
        Map<String, String> lv;
        DecimalFormat myFormatter = new DecimalFormat("###,###");

        this.CategoriesChartString = "";
        ArrayList<Object> categoryarray = new ArrayList<>();
        this.DataseriesChartString = "";
        ArrayList<Object> dataSeriesArray = new ArrayList<>();
        ArrayList<Object> dataSeriesArray1 = new ArrayList<>();
        ArrayList<Object> dataSeriesArray2 = new ArrayList<>();
        String SerieName1 = "", SerieName2 = "";
        String SerieString1 = "", SerieString2 = "";
        //System.out.println("SQL-TRENDS:" + sql);
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs2 = ps.executeQuery();
            if (rs2.next()) {
                // add category data to the category array
                lv = new LinkedHashMap<String, String>();
                lv.put("label", "M0");
                categoryarray.add(lv);
                lv = new LinkedHashMap<String, String>();
                lv.put("label", "M1");
                categoryarray.add(lv);
                lv = new LinkedHashMap<String, String>();
                lv.put("label", "M2");
                categoryarray.add(lv);
                lv = new LinkedHashMap<String, String>();
                lv.put("label", "M3");
                categoryarray.add(lv);
                lv = new LinkedHashMap<String, String>();
                lv.put("label", "M4");
                categoryarray.add(lv);
                lv = new LinkedHashMap<String, String>();
                lv.put("label", "M5");
                categoryarray.add(lv);

                // dataseries
                lv = new LinkedHashMap<String, String>();
                try {
                    lv.put("value", Integer.toString(rs2.getInt("m0")));
                } catch (NullPointerException npe) {
                    lv.put("value", "0");
                }
                dataSeriesArray1.add(lv);
                dataSeriesArray2.add(lv);
                lv = new LinkedHashMap<String, String>();
                try {
                    lv.put("value", Integer.toString(rs2.getInt("m1")));
                } catch (NullPointerException npe) {
                    lv.put("value", "0");
                }
                dataSeriesArray1.add(lv);
                dataSeriesArray2.add(lv);
                lv = new LinkedHashMap<String, String>();
                try {
                    lv.put("value", Integer.toString(rs2.getInt("m2")));
                } catch (NullPointerException npe) {
                    lv.put("value", "0");
                }
                dataSeriesArray1.add(lv);
                dataSeriesArray2.add(lv);
                lv = new LinkedHashMap<String, String>();
                try {
                    lv.put("value", Integer.toString(rs2.getInt("m3")));
                } catch (NullPointerException npe) {
                    lv.put("value", "0");
                }
                dataSeriesArray1.add(lv);
                dataSeriesArray2.add(lv);
                lv = new LinkedHashMap<String, String>();
                try {
                    lv.put("value", Integer.toString(rs2.getInt("m4")));
                } catch (NullPointerException npe) {
                    lv.put("value", "0");
                }
                dataSeriesArray1.add(lv);
                dataSeriesArray2.add(lv);
                lv = new LinkedHashMap<String, String>();
                try {
                    lv.put("value", Integer.toString(rs2.getInt("m5")));
                } catch (NullPointerException npe) {
                    lv.put("value", "0");
                }
                dataSeriesArray1.add(lv);
                dataSeriesArray2.add(lv);
            }
            //final categories string from the array
            CategoriesChartString = "[{\"category\":" + gson.toJson(categoryarray) + "}]";

            //build series string from the array
            SerieName1 = "Data";
            SerieString1 = "{\"seriesname\": \"" + SerieName1 + "\",\"showValues\":\"1\",\"data\":" + gson.toJson(dataSeriesArray1) + "}";
            dataSeriesArray.add(SerieString1);
            SerieName2 = "Trendline";
            String renderas2 = "line";
            SerieString2 = "{\"seriesname\": \"" + SerieName2 + "\",\"renderAs\":\"line\",\"parentYAxis\":\"S\",\"showValues\":\"0\",\"data\":" + gson.toJson(dataSeriesArray2) + "}";
            dataSeriesArray.add(SerieString2);

            //final data series string from the array
            DataseriesChartString = dataSeriesArray.toString();
        } catch (SQLException se) {
            System.err.println("refreshBarChartdata:" + se.getMessage());
        } finally {
            if (rs2 != null) {
                try {
                    rs2.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public Health_facility getHfById(int aHfId) {
        try {
            return Health_facility.getHealth_facilityByORMID(aHfId);
        } catch (PersistentException ex) {
            Logger.getLogger(Art_retentionBean_old2.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public District getDsById(int aDsId) {
        try {
            return District.getDistrictByORMID(aDsId);
        } catch (PersistentException ex) {
            Logger.getLogger(Art_retentionBean_old2.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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
     * @return the Art_retentionList
     */
    public List<Art_retention> getArt_retentionList() {
        return Art_retentionList;
    }

    /**
     * @param Art_retentionList the Art_retentionList to set
     */
    public void setArt_retentionList(List<Art_retention> Art_retentionList) {
        this.Art_retentionList = Art_retentionList;
    }

    /**
     * @return the selectedDistricts
     */
    public District[] getSelectedDistricts() {
        return selectedDistricts;
    }

    /**
     * @param selectedDistricts the selectedDistricts to set
     */
    public void setSelectedDistricts(District[] selectedDistricts) {
        this.selectedDistricts = selectedDistricts;
    }

    /**
     * @return the selectedFacilities
     */
    public Health_facility[] getSelectedFacilities() {
        return selectedFacilities;
    }

    /**
     * @param selectedFacilities the selectedFacilities to set
     */
    public void setSelectedFacilities(Health_facility[] selectedFacilities) {
        this.selectedFacilities = selectedFacilities;
    }

    /**
     * @return the districts
     */
    public List<District> getDistricts() {
        List<District> districtList = new ArrayList<>();
        try {
            districtList = District.queryDistrict("is_deleted=0", "district_name");
        } catch (PersistentException | NullPointerException ex) {
        }
        this.districts = districtList;
        return districts;
    }

    /**
     * @param districts the districts to set
     */
    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public String getDistrictsStr() {
        String DistrictsStr = "";
        int y = 0;
        y = this.selectedDistricts.length;
        for (int i = 0; i < y; i++) {
            if (DistrictsStr.length() > 0) {
                DistrictsStr = DistrictsStr + "," + selectedDistricts[i].getDistrict_id();
            } else {
                DistrictsStr = "" + selectedDistricts[i].getDistrict_id();
            }
        }
        return DistrictsStr;
    }

    public String getFacilitiesStr() {
        String FacilitiesStr = "";
        int y = 0;
        y = this.selectedFacilities.length;
        for (int i = 0; i < y; i++) {
            if (FacilitiesStr.length() > 0) {
                FacilitiesStr = FacilitiesStr + "," + selectedFacilities[i].getHealth_facility_id();
            } else {
                FacilitiesStr = "" + selectedFacilities[i].getHealth_facility_id();
            }
        }
        return FacilitiesStr;
    }

    /**
     * @return the facilities
     */
    public List<Health_facility> getFacilities() {
        List<Health_facility> facilityList = new ArrayList<>();
        try {
            if (this.getDistrictsStr().length() > 0) {
                facilityList = Health_facility.queryHealth_facility("is_deleted=0 and district_id IN(" + this.getDistrictsStr() + ")", "district_id,health_facility_name");
            }
        } catch (Exception ex) {
        }
        this.facilities = facilityList;
        return facilities;
    }

    /**
     * @param facilities the facilities to set
     */
    public void setFacilities(List<Health_facility> facilities) {
        this.facilities = facilities;
    }

    /**
     * @return the RangeDesc
     */
    public String getRangeDesc() {
        return RangeDesc;
    }

    /**
     * @param RangeDesc the RangeDesc to set
     */
    public void setRangeDesc(String RangeDesc) {
        this.RangeDesc = RangeDesc;
    }

}

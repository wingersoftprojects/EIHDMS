/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import eihdms.Data_obligation;
import eihdms.Report_form;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class Data_obligationBean extends AbstractBean<Data_obligation> implements Serializable {

    private int selected_year;
    private int selected_quarter;
    private int selected_bi_month;
    private int selected_month;
    private int selected_week;
    private List<Report_form> report_formList;
    private List<Report_form> report_form_quarterlyList;
    private List<Report_form> report_form_bi_monthlyList;
    private List<Report_form> report_form_monthlyList;
    private List<Report_form> report_form_weeklyList;
    private List<Data_obligation> data_obligation_yearlyList;
    private List<Data_obligation> data_obligation_quarterlyList;
    private List<Data_obligation> data_obligation_bi_monthlyList;
    private List<Data_obligation> data_obligation_monthlyList;
    private List<Data_obligation> data_obligation_weeklyList;

    public Data_obligationBean() {
        super(Data_obligation.class);
    }

    @Override
    public void init() {
        if (super.getEntityClass() == null) {
            loginBean.logout();
        }
    }
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public void update_data_obligation_full_current_year() {
        int current_year = GeneralUtilities.getCurrentYear();
        int current_month = GeneralUtilities.getCurrentMonth();
        int current_bi_month = 0;
        if (current_month % 2 > 0) {
            current_bi_month = (current_month + 1) / 2;
        } else {
            current_bi_month = current_month / 2;
        }

        //update for quartely
        for (int i = 1; i <= 3; i++) {
            this.update_data_obligation_quarterly(current_year, i);
        }

        //update for bi-monthly
        for (int i = 1; i <= current_bi_month; i++) {
            this.update_data_obligation_bi_monthly(current_year, i);
        }

        //update for monthly
        for (int i = 1; i <= current_month; i++) {
            this.update_data_obligation_monthly(current_year, i);
        }

        //update for weekly
        for (int i = 1; i <= current_month; i++) {
            for (int x = 1; x <= 4; x++) {
                this.update_data_obligation_weekly(current_year, i, x);
            }
        }
    }

    public void update_data_obligation_full_current_month() {
        int current_year = GeneralUtilities.getCurrentYear();
        int current_month = GeneralUtilities.getCurrentMonth();
        int current_bi_month = 0;
        if (current_month % 2 > 0) {
            current_bi_month = (current_month + 1) / 2;
        } else {
            current_bi_month = current_month / 2;
        }

        //update for quartely
        for (int i = 1; i <= 3; i++) {
            this.update_data_obligation_quarterly(current_year, i);
        }

        //update for bi-monthly
        this.update_data_obligation_bi_monthly(current_year, current_bi_month);

        //update for monthly
        this.update_data_obligation_monthly(current_year, current_month);

        //update for weekly
        for (int x = 1; x <= 4; x++) {
            this.update_data_obligation_weekly(current_year, current_month, x);
        }
    }

    public void update_data_obligation_monthly(int year_value, int month_value) {
        String sql = "{call sp_update_data_obligation_monthly(?,?)}";
        ResultSet rs = null;
        try {

            Connection conn = DBConnection.getMySQLConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, year_value);
            ps.setInt(2, month_value);
            rs = ps.executeQuery();
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
    }

    public void update_data_obligation_bi_monthly(int year_value, int bi_month_value) {
        String sql = "{call sp_update_data_obligation_bi_monthly(?,?)}";
        ResultSet rs = null;
        try {

            Connection conn = DBConnection.getMySQLConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, year_value);
            ps.setInt(2, bi_month_value);
            rs = ps.executeQuery();
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
    }

    public void update_data_obligation_quarterly(int year_value, int quarter_value) {
        String sql = "{call sp_update_data_obligation_quarterly(?,?)}";
        ResultSet rs = null;
        try {

            Connection conn = DBConnection.getMySQLConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, year_value);
            ps.setInt(2, quarter_value);
            rs = ps.executeQuery();
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
    }

    public void update_data_obligation_weekly(int year_value, int month_value, int week_value) {
        String sql = "{call sp_update_data_obligation_weekly(?,?,?)}";
        ResultSet rs = null;
        try {

            Connection conn = DBConnection.getMySQLConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, year_value);
            ps.setInt(2, month_value);
            ps.setInt(3, week_value);
            rs = ps.executeQuery();
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
    }

    public void refreshData_obligation_all_List(int year_value) {
        this.refreshData_obligation_quarterlyList(year_value);
        this.refreshData_obligation_bi_monthlyList(year_value);
        this.refreshData_obligation_monthlyList(year_value);
        this.refreshData_obligation_weeklyList(year_value);
    }

    public void refreshData_obligation_monthlyList(int year_value) {
        data_obligation_monthlyList = new ArrayList<>();
        String rfi = "";
        List<Report_form> rfs = this.getReport_form_monthlyList();
        for (int i = 0; i < rfs.size(); i++) {
            if (rfi.length() > 0) {
                rfi = rfi + "," + rfs.get(i).getReport_form_id();
            } else {
                rfi = "" + rfs.get(i).getReport_form_id();
            }
        }
        try {
            if (rfi.length() > 0) {
                data_obligation_monthlyList = Data_obligation.queryData_obligation("report_form_id IN (" + rfi + ") and year_value=" + year_value, null);
            }
        } catch (PersistentException | NullPointerException ex) {
            Logger.getLogger(Data_obligationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshData_obligation_bi_monthlyList(int year_value) {
        data_obligation_bi_monthlyList = new ArrayList<>();
        String rfi = "";
        List<Report_form> rfs = this.getReport_form_bi_monthlyList();
        for (int i = 0; i < rfs.size(); i++) {
            if (rfi.length() > 0) {
                rfi = rfi + "," + rfs.get(i).getReport_form_id();
            } else {
                rfi = "" + rfs.get(i).getReport_form_id();
            }
        }
        try {
            if (rfi.length() > 0) {
                data_obligation_bi_monthlyList = Data_obligation.queryData_obligation("report_form_id IN (" + rfi + ") and year_value=" + year_value, null);
            }
        } catch (PersistentException | NullPointerException ex) {
            Logger.getLogger(Data_obligationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshData_obligation_weeklyList(int year_value) {
        data_obligation_weeklyList = new ArrayList<>();
        String rfi = "";
        List<Report_form> rfs = this.getReport_form_weeklyList();
        for (int i = 0; i < rfs.size(); i++) {
            if (rfi.length() > 0) {
                rfi = rfi + "," + rfs.get(i).getReport_form_id();
            } else {
                rfi = "" + rfs.get(i).getReport_form_id();
            }
        }
        int current_month = GeneralUtilities.getCurrentMonth();
        try {
            if (rfi.length() > 0) {
                data_obligation_weeklyList = Data_obligation.queryData_obligation("report_form_id IN (" + rfi + ") and year_value=" + year_value + " and month_value=" + current_month, null);
            }
        } catch (PersistentException | NullPointerException ex) {
            Logger.getLogger(Data_obligationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshData_obligation_quarterlyList(int year_value) {
        data_obligation_quarterlyList = new ArrayList<>();
        String rfi = "";
        List<Report_form> rfs = this.getReport_form_quarterlyList();
        for (int i = 0; i < rfs.size(); i++) {
            if (rfi.length() > 0) {
                rfi = rfi + "," + rfs.get(i).getReport_form_id();
            } else {
                rfi = "" + rfs.get(i).getReport_form_id();
            }
        }
        try {
            if (rfi.length() > 0) {
                data_obligation_quarterlyList = Data_obligation.queryData_obligation("report_form_id IN (" + rfi + ") and year_value=" + year_value, null);
            }
        } catch (PersistentException | NullPointerException ex) {
            Logger.getLogger(Data_obligationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getObligationRecordsMonthly(int report_form_id, int month_value) {
        Data_obligation obl = new Data_obligation();
        int n;
        float PercRec = 0;
        String PercRecStr = "";
        try {
            n = this.data_obligation_monthlyList.size();
            for (int i = 0; i < n; i++) {
                obl = this.data_obligation_monthlyList.get(i);
                if (obl.getReport_form().getReport_form_id() == report_form_id && obl.getMonth_value() == month_value) {
                    switch (obl.getReport_form().getLowest_report_form_level()) {
                        case "District":
                            if (obl.getCount_district() > 0) {
                                PercRec = 100 * obl.getMonth_records_d() / obl.getCount_district();
                            }
                            PercRecStr = PercRec + "% D";
                            break;
                        case "Parish":
                            if (obl.getCount_parish() > 0) {
                                PercRec = 100 * obl.getMonth_records_p() / obl.getCount_parish();
                            }
                            PercRecStr = PercRec + "% P";
                            break;
                        case "Facility":
                            if (obl.getCount_facility() > 0) {
                                PercRec = 100 * obl.getMonth_records_f() / obl.getCount_facility();
                            }
                            PercRecStr = PercRec + "% F";
                            break;
                    }
                    break;
                }
            }
        } catch (NullPointerException npe) {

        }
        return PercRecStr;
    }

    public String getObligationDEsMonthly(int report_form_id, int month_value) {
        Data_obligation obl = new Data_obligation();
        int n;
        float PercRec = 0;
        String PercRecStr = "";
        try {
            n = this.data_obligation_monthlyList.size();
            for (int i = 0; i < n; i++) {
                obl = this.data_obligation_monthlyList.get(i);
                if (obl.getReport_form().getReport_form_id() == report_form_id && obl.getMonth_value() == month_value) {
                    if (obl.getCount_de() > 0) {
                        PercRec = 100 * obl.getMonth_des() / obl.getCount_de();
                    }
                    PercRecStr = PercRec + "% E";
                    break;
                }
            }
        } catch (NullPointerException npe) {

        }
        return PercRecStr;
    }

    public String getObligationRecordsBiMonthly(int report_form_id, int bi_month_value) {
        Data_obligation obl = new Data_obligation();
        int n;
        float PercRec = 0;
        String PercRecStr = "";
        try {
            n = this.data_obligation_bi_monthlyList.size();
            for (int i = 0; i < n; i++) {
                obl = this.data_obligation_bi_monthlyList.get(i);
                if (obl.getReport_form().getReport_form_id() == report_form_id && obl.getBi_month_value() == bi_month_value) {
                    switch (obl.getReport_form().getLowest_report_form_level()) {
                        case "District":
                            if (obl.getCount_district() > 0) {
                                PercRec = 100 * obl.getBi_month_records_d() / obl.getCount_district();
                            }
                            PercRecStr = PercRec + "% D";
                            break;
                        case "Parish":
                            if (obl.getCount_parish() > 0) {
                                PercRec = 100 * obl.getBi_month_records_p() / obl.getCount_parish();
                            }
                            PercRecStr = PercRec + "% P";
                            break;
                        case "Facility":
                            if (obl.getCount_facility() > 0) {
                                PercRec = 100 * obl.getBi_month_records_f() / obl.getCount_facility();
                            }
                            PercRecStr = PercRec + "% F";
                            break;
                    }
                    break;
                }
            }
        } catch (NullPointerException npe) {

        }
        return PercRecStr;
    }

    public String getObligationDEsBiMonthly(int report_form_id, int bi_month_value) {
        Data_obligation obl = new Data_obligation();
        int n;
        float PercRec = 0;
        String PercRecStr = "";
        try {
            n = this.data_obligation_bi_monthlyList.size();
            for (int i = 0; i < n; i++) {
                obl = this.data_obligation_bi_monthlyList.get(i);
                if (obl.getReport_form().getReport_form_id() == report_form_id && obl.getBi_month_value() == bi_month_value) {
                    if (obl.getCount_de() > 0) {
                        PercRec = 100 * obl.getBi_month_des() / obl.getCount_de();
                    }
                    PercRecStr = PercRec + "% E";
                    break;
                }
            }
        } catch (NullPointerException npe) {

        }
        return PercRecStr;
    }

    public String getObligationRecordsQuarterly(int report_form_id, int quarter_value) {
        Data_obligation obl = new Data_obligation();
        int n;
        float PercRec = 0;
        String PercRecStr = "";
        try {
            n = this.data_obligation_quarterlyList.size();
            for (int i = 0; i < n; i++) {
                obl = this.data_obligation_quarterlyList.get(i);
                if (obl.getReport_form().getReport_form_id() == report_form_id && obl.getQuarter_value() == quarter_value) {
                    switch (obl.getReport_form().getLowest_report_form_level()) {
                        case "District":
                            if (obl.getCount_district() > 0) {
                                PercRec = 100 * obl.getQuarter_records_d() / obl.getCount_district();
                            }
                            PercRecStr = PercRec + "% D";
                            break;
                        case "Parish":
                            if (obl.getCount_parish() > 0) {
                                PercRec = 100 * obl.getQuarter_records_p() / obl.getCount_parish();
                            }
                            PercRecStr = PercRec + "% P";
                            break;
                        case "Facility":
                            if (obl.getCount_facility() > 0) {
                                PercRec = 100 * obl.getQuarter_records_f() / obl.getCount_facility();
                            }
                            PercRecStr = PercRec + "% F";
                            break;
                    }
                    break;
                }
            }
        } catch (NullPointerException npe) {

        }
        return PercRecStr;
    }

    public String getObligationDEsQuarterly(int report_form_id, int quarter_value) {
        Data_obligation obl = new Data_obligation();
        int n;
        float PercRec = 0;
        String PercRecStr = "";
        try {
            n = this.data_obligation_quarterlyList.size();
            for (int i = 0; i < n; i++) {
                obl = this.data_obligation_quarterlyList.get(i);
                if (obl.getReport_form().getReport_form_id() == report_form_id && obl.getQuarter_value() == quarter_value) {
                    if (obl.getCount_de() > 0) {
                        PercRec = 100 * obl.getQuarter_des() / obl.getCount_de();
                    }
                    PercRecStr = PercRec + "% E";
                    break;
                }
            }
        } catch (NullPointerException npe) {

        }
        return PercRecStr;
    }

    public String getObligationRecordsWeekly(int report_form_id, int week_value) {
        Data_obligation obl = new Data_obligation();
        int n;
        float PercRec = 0;
        String PercRecStr = "";
        try {
            n = this.data_obligation_weeklyList.size();
            for (int i = 0; i < n; i++) {
                obl = this.data_obligation_weeklyList.get(i);
                if (obl.getReport_form().getReport_form_id() == report_form_id && obl.getWeek_value() == week_value) {
                    switch (obl.getReport_form().getLowest_report_form_level()) {
                        case "District":
                            if (obl.getCount_district() > 0) {
                                PercRec = 100 * obl.getWeek_records_d() / obl.getCount_district();
                            }
                            PercRecStr = PercRec + "% D";
                            break;
                        case "Parish":
                            if (obl.getCount_parish() > 0) {
                                PercRec = 100 * obl.getWeek_records_p() / obl.getCount_parish();
                            }
                            PercRecStr = PercRec + "% P";
                            break;
                        case "Facility":
                            if (obl.getCount_facility() > 0) {
                                PercRec = 100 * obl.getWeek_records_f() / obl.getCount_facility();
                            }
                            PercRecStr = PercRec + "% F";
                            break;
                    }
                    break;
                }
            }
        } catch (NullPointerException npe) {

        }
        return PercRecStr;
    }

    public String getObligationDEsWeekly(int report_form_id, int week_value) {
        Data_obligation obl = new Data_obligation();
        int n;
        float PercRec = 0;
        String PercRecStr = "";
        try {
            n = this.data_obligation_weeklyList.size();
            for (int i = 0; i < n; i++) {
                obl = this.data_obligation_weeklyList.get(i);
                if (obl.getReport_form().getReport_form_id() == report_form_id && obl.getWeek_value() == week_value) {
                    if (obl.getCount_de() > 0) {
                        PercRec = 100 * obl.getWeek_des() / obl.getCount_de();
                    }
                    PercRecStr = PercRec + "% E";
                    break;
                }
            }
        } catch (NullPointerException npe) {

        }
        return PercRecStr;
    }

    public Data_obligation getData_obligation_monthly(int report_form_id, int year_value, int month_value) {
        Data_obligation obl = new Data_obligation();
        try {
            obl = (Data_obligation) Data_obligation.queryData_obligation("report_form_id=" + report_form_id + " and year_value=" + year_value + " and month_value=" + month_value, null).get(0);
        } catch (PersistentException | NullPointerException | IndexOutOfBoundsException ex) {
            Logger.getLogger(Data_obligationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obl;
    }

    /**
     * @return the selected_year
     */
    public int getSelected_year() {
        return selected_year;
    }

    /**
     * @param selected_year the selected_year to set
     */
    public void setSelected_year(int selected_year) {
        this.selected_year = selected_year;
    }

    /**
     * @return the selected_quarter
     */
    public int getSelected_quarter() {
        return selected_quarter;
    }

    /**
     * @param selected_quarter the selected_quarter to set
     */
    public void setSelected_quarter(int selected_quarter) {
        this.selected_quarter = selected_quarter;
    }

    /**
     * @return the selected_bi_month
     */
    public int getSelected_bi_month() {
        return selected_bi_month;
    }

    /**
     * @param selected_bi_month the selected_bi_month to set
     */
    public void setSelected_bi_month(int selected_bi_month) {
        this.selected_bi_month = selected_bi_month;
    }

    /**
     * @return the selected_month
     */
    public int getSelected_month() {
        return selected_month;
    }

    /**
     * @param selected_month the selected_month to set
     */
    public void setSelected_month(int selected_month) {
        this.selected_month = selected_month;
    }

    /**
     * @return the selected_week
     */
    public int getSelected_week() {
        return selected_week;
    }

    /**
     * @param selected_week the selected_week to set
     */
    public void setSelected_week(int selected_week) {
        this.selected_week = selected_week;
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

    /**
     * @return the report_form_quarterlyList
     */
    public List<Report_form> getReport_form_quarterlyList() {
        try {
            this.report_form_quarterlyList = Report_form.queryReport_form("report_form_frequency='Quarterly'", null);
        } catch (PersistentException ex) {
            Logger.getLogger(Data_obligationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return report_form_quarterlyList;
    }

    /**
     * @param report_form_quarterlyList the report_form_quarterlyList to set
     */
    public void setReport_form_quarterlyList(List<Report_form> report_form_quarterlyList) {
        this.report_form_quarterlyList = report_form_quarterlyList;
    }

    /**
     * @return the report_form_bi_monthlyList
     */
    public List<Report_form> getReport_form_bi_monthlyList() {
        try {
            this.report_form_bi_monthlyList = Report_form.queryReport_form("report_form_frequency='Bi-Monthly'", null);
        } catch (PersistentException ex) {
            Logger.getLogger(Data_obligationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return report_form_bi_monthlyList;
    }

    /**
     * @param report_form_bi_monthlyList the report_form_bi_monthlyList to set
     */
    public void setReport_form_bi_monthlyList(List<Report_form> report_form_bi_monthlyList) {
        this.report_form_bi_monthlyList = report_form_bi_monthlyList;
    }

    /**
     * @return the report_form_monthlyList
     */
    public List<Report_form> getReport_form_monthlyList() {
        try {
            this.report_form_monthlyList = Report_form.queryReport_form("report_form_frequency='Monthly'", null);
        } catch (PersistentException ex) {
            Logger.getLogger(Data_obligationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return report_form_monthlyList;
    }

    /**
     * @param report_form_monthlyList the report_form_monthlyList to set
     */
    public void setReport_form_monthlyList(List<Report_form> report_form_monthlyList) {
        this.report_form_monthlyList = report_form_monthlyList;
    }

    /**
     * @return the report_form_weeklyList
     */
    public List<Report_form> getReport_form_weeklyList() {
        try {
            this.report_form_weeklyList = Report_form.queryReport_form("report_form_frequency='Weekly'", null);
        } catch (PersistentException ex) {
            Logger.getLogger(Data_obligationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return report_form_weeklyList;
    }

    /**
     * @param report_form_weeklyList the report_form_weeklyList to set
     */
    public void setReport_form_weeklyList(List<Report_form> report_form_weeklyList) {
        this.report_form_weeklyList = report_form_weeklyList;
    }

    /**
     * @return the data_obligation_yearlyList
     */
    public List<Data_obligation> getData_obligation_yearlyList() {
        return data_obligation_yearlyList;
    }

    /**
     * @param data_obligation_yearlyList the data_obligation_yearlyList to set
     */
    public void setData_obligation_yearlyList(List<Data_obligation> data_obligation_yearlyList) {
        this.data_obligation_yearlyList = data_obligation_yearlyList;
    }

    /**
     * @return the data_obligation_quarterlyList
     */
    public List<Data_obligation> getData_obligation_quarterlyList() {
        return data_obligation_quarterlyList;
    }

    /**
     * @param data_obligation_quarterlyList the data_obligation_quarterlyList to
     * set
     */
    public void setData_obligation_quarterlyList(List<Data_obligation> data_obligation_quarterlyList) {
        this.data_obligation_quarterlyList = data_obligation_quarterlyList;
    }

    /**
     * @return the data_obligation_bi_monthlyList
     */
    public List<Data_obligation> getData_obligation_bi_monthlyList() {
        return data_obligation_bi_monthlyList;
    }

    /**
     * @param data_obligation_bi_monthlyList the data_obligation_bi_monthlyList
     * to set
     */
    public void setData_obligation_bi_monthlyList(List<Data_obligation> data_obligation_bi_monthlyList) {
        this.data_obligation_bi_monthlyList = data_obligation_bi_monthlyList;
    }

    /**
     * @return the data_obligation_monthlyList
     */
    public List<Data_obligation> getData_obligation_monthlyList() {
        return data_obligation_monthlyList;
    }

    /**
     * @param data_obligation_monthlyList the data_obligation_monthlyList to set
     */
    public void setData_obligation_monthlyList(List<Data_obligation> data_obligation_monthlyList) {
        this.data_obligation_monthlyList = data_obligation_monthlyList;
    }

    /**
     * @return the data_obligation_weeklyList
     */
    public List<Data_obligation> getData_obligation_weeklyList() {
        return data_obligation_weeklyList;
    }

    /**
     * @param data_obligation_weeklyList the data_obligation_weeklyList to set
     */
    public void setData_obligation_weeklyList(List<Data_obligation> data_obligation_weeklyList) {
        this.data_obligation_weeklyList = data_obligation_weeklyList;
    }
}

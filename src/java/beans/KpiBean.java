/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import eihdms.Base_data;
import eihdms.Data_element;
import eihdms.District;
import eihdms.EIHDMSPersistentManager;
import eihdms.Kpi;
import eihdms.Report_form;
import eihdms.Technical_area;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.orm.PersistentException;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;
import utilities.GeneralUtilities;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class KpiBean extends AbstractBean<Kpi> implements Serializable {

    private String validation_formula = "";
    private Data_element data_element;
    private Kpi selectedKPI;
    private Integer[] selectedYears;
    private List<Integer> years;
    private Integer[] selectedDistrictIDs;
    private List<Integer> districtIDs;
    private Technical_area selectedTA;

    private District[] selectedDistricts;
    private List<District> districts;
    private JSONArray jSONArray;
    private List<Object[]> base_dataList;

    public KpiBean() {
        super(Kpi.class);
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

    public List<Kpi> returnKpiByTA(Technical_area ta) {
        List<Kpi> kpiList = new ArrayList<>();
        try {
            if (loginBean.getUser_detail().getIs_user_gen_admin() == 1) {
                kpiList = Kpi.queryKpi("technical_area=" + ta.getTechnical_area_id(), null);
            } else {
                String AllowStr = "";
                AllowStr = loginBean.getUser_report_form_str("allow_view");
                if (AllowStr.length() > 0) {
                    kpiList = Kpi.queryKpi("technical_area=" + ta.getTechnical_area_id() + " and report_form IN(" + AllowStr + ")", null);
                } else {
                    kpiList = null;
                }
            }
        } catch (PersistentException | NullPointerException ex) {
            //Logger.getLogger(KpiBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kpiList;
    }

    public void showReport() {
        String YearsStr = "";
        String DistrictsStr = "";

        //get 1016,2015,2013 string format for selected years
        int x = 0;
        x = this.selectedYears.length;
        for (int i = 0; i < x; i++) {
            if (YearsStr.length() > 0) {
                YearsStr = YearsStr + "," + this.selectedYears[i];
            } else {
                YearsStr = "" + this.selectedYears[i];
            }
        }

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
        String sql = "{call sp_select_kpi(?,?,?,?,?)}";
        ResultSet rs = null;
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, selectedKPI.getKpi_id());
            ps.setString(2, loginBean.getUser_detail().getUser_name());
            ps.setInt(3, selectedKPI.getReport_form().getReport_form_id());
            ps.setString(4, YearsStr);
            ps.setString(5, DistrictsStr);
            rs = ps.executeQuery();
            load_jSON(rs);
        } catch (SQLException se) {
            System.err.println(se.getMessage());
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

    public String getYearString() {
        String YearsStr = "";
        //get 1016,2015,2013 string format for selected years
        int x = 0;
        x = this.selectedYears.length;
        for (int i = 0; i < x; i++) {
            if (YearsStr.length() > 0) {
                YearsStr = YearsStr + "," + this.selectedYears[i];
            } else {
                YearsStr = "" + this.selectedYears[i];
            }
        }
        return YearsStr;
    }

    public String getDistrictString() {
        String DistrictsStr = "";
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
        return DistrictsStr;
    }

    private Report_form report_form;

    public Report_form getReport_form() {
        return report_form;
    }

    public void setReport_form(Report_form report_form) {
        this.report_form = report_form;
    }

    @Override
    public void save(int aUserDetailId) {
        String sql = "{call sp_validate_kpi_summary_function(?,?)}";
        ResultSet rs = null;
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, this.getSelected().getKpi_summary_function());
            ps.setInt(2, this.getSelected().getReport_form().getReport_form_id());
            rs = ps.executeQuery();
        } catch (SQLException se) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Invalid Summary Function!", "Invalid Summary Function!"));
            System.err.println(se.getMessage());
            return;
        }
        super.save(aUserDetailId); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Data_element> completeData_element(String query) {
        List<Data_element> filteredData_elements = new ArrayList<>();
        try {
            if (this.getSelected() != null) {
                if (this.getSelected().getReport_form() != null) {
                    filteredData_elements = (List<Data_element>) EIHDMSPersistentManager.instance().getSession().createQuery("select de FROM Data_element  de where de.is_deleted<>1 AND de.report_form.report_form_id=" + this.getSelected().getReport_form().getReport_form_id() + " AND de.data_element_name like '%" + query + "%'").list();
                } else {
                    filteredData_elements = (List<Data_element>) EIHDMSPersistentManager.instance().getSession().createQuery("select de FROM Data_element  de where de.is_deleted<>1 AND ( de.description like '%" + query + "%' OR  de.technical_area.technical_area_name '%" + query + "%' or de.report_form.report_form_name like '%" + query + "%' OR de.data_element_name like '%" + query + "%')").list();
                }
            } else {
                filteredData_elements = (List<Data_element>) EIHDMSPersistentManager.instance().getSession().createQuery("select de FROM Data_element  de where de.is_deleted<>1 AND ( de.description like '%" + query + "%' OR  de.technical_area.technical_area_name '%" + query + "%' or de.report_form.report_form_name like '%" + query + "%' OR de.data_element_name like '%" + query + "%')").list();
            }
        } catch (PersistentException ex) {
            Logger.getLogger(Data_elementBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filteredData_elements;
    }

    public Data_element getData_element() {
        return data_element;
    }

    public void setData_element(Data_element data_element) {
        this.data_element = data_element;
    }

    public void append_operand(String operand) {
        this.getSelected().setKpi_summary_function(this.getSelected().getKpi_summary_function() + " " + operand);;
    }

    public void append_data_element() {
        validation_formula = this.getSelected().getKpi_summary_function();
        if (validation_formula == null) {
            validation_formula = "";
        }
        this.getSelected().setKpi_summary_function(validation_formula + " DE" + data_element.getData_element_id());;
        String data_elements_involved = this.getSelected().getData_elements_involved();
        if (data_elements_involved == null) {
            data_elements_involved = "";
        }
        this.getSelected().setData_elements_involved(data_elements_involved + "\n" + " DE" + data_element.getData_element_id() + "=>" + data_element.getData_element_name());
    }

    /**
     * @return the selectedKPI
     */
    public Kpi getSelectedKPI() {
        return selectedKPI;
    }

    /**
     * @param selectedKPI the selectedKPI to set
     */
    public void setSelectedKPI(Kpi selectedKPI) {
        this.selectedKPI = selectedKPI;
    }

    /**
     * @return the selectedYears
     */
    public Integer[] getSelectedYears() {
        return selectedYears;
    }

    /**
     * @param selectedYears the selectedYears to set
     */
    public void setSelectedYears(Integer[] selectedYears) {
        this.selectedYears = selectedYears;
    }

    /**
     * @return the years
     */
    public List<Integer> getYears() {
        int currentYear = 0;
        try {
            currentYear = GeneralUtilities.getCurrentYear();
            this.years = new ArrayList<>();
            this.years.add(currentYear);
            this.years.add(currentYear - 1);
            this.years.add(currentYear - 2);
            this.years.add(currentYear - 3);
            this.years.add(currentYear - 4);
            this.years.add(currentYear - 5);
            this.years.add(currentYear - 6);
            this.years.add(currentYear - 7);
            this.years.add(currentYear - 8);
            this.years.add(currentYear - 9);
            this.years.add(currentYear - 10);
        } catch (NullPointerException npe) {
        }
        return years;
    }

    /**
     * @param years the years to set
     */
    public void setYears(List<Integer> years) {
        this.years = years;
    }

    /**
     * @return the selectedTA
     */
    public Technical_area getSelectedTA() {
        return selectedTA;
    }

    /**
     * @param selectedTA the selectedTA to set
     */
    public void setSelectedTA(Technical_area selectedTA) {
        this.selectedTA = selectedTA;
    }

    /**
     * @return the selectedDistrictIDs
     */
    public Integer[] getSelectedDistrictIDs() {
        return selectedDistrictIDs;
    }

    /**
     * @param selectedDistrictIDs the selectedDistrictIDs to set
     */
    public void setSelectedDistrictIDs(Integer[] selectedDistrictIDs) {
        this.selectedDistrictIDs = selectedDistrictIDs;
    }

    /**
     * @return the districtIDs
     */
    public List<Integer> getDistrictIDs() {
        List<District> districtList = new ArrayList<>();
        this.districtIDs = new ArrayList<>();
        try {
            districtList = District.queryDistrict("is_deleted=0", "district_name");
            for (int i = 0; i < districtList.size(); i++) {
                this.districtIDs.add(districtList.get(i).getDistrict_id());
            }
        } catch (PersistentException | NullPointerException ex) {
        }
        return districtIDs;
    }

    /**
     * @param districtIDs the districtIDs to set
     */
    public void setDistrictIDs(List<Integer> districtIDs) {
        this.districtIDs = districtIDs;
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

    public String getValidation_formula() {
        return validation_formula;
    }

    public void setValidation_formula(String validation_formula) {
        this.validation_formula = validation_formula;
    }

    public List<Object[]> getBase_dataList() {
        return base_dataList;
    }

    public void setBase_dataList(List<Object[]> base_dataList) {
        this.base_dataList = base_dataList;
    }

    private void load_jSON(ResultSet rs) {
        try {
            JSONArray jArray = new JSONArray();
            JSONObject jObj = new JSONObject();
            jObj.put("District", new JSONObject().put("type", "string"));
            jObj.put("County", new JSONObject().put("type", "string"));
            jObj.put("Subcounty", new JSONObject().put("type", "string"));
            jObj.put("Parish", new JSONObject().put("type", "string"));
            jObj.put("Facility", new JSONObject().put("type", "string"));
            jObj.put("Year", new JSONObject().put("type", "string"));
            jObj.put("Quarter", new JSONObject().put("type", "string"));
            jObj.put("Value", new JSONObject().put("type", "number"));
            jArray.put(jObj);

            while (rs.next()) {
                jObj = new JSONObject();
                try {
                    jObj.put("District", rs.getString(1));
                } catch (NullPointerException npe) {
                    jObj.put("District", "");
                }

                try {
                    jObj.put("County", rs.getString(2));
                } catch (NullPointerException npe) {
                    jObj.put("County", "");
                }
                try {
                    jObj.put("Subcounty", rs.getString(3));
                } catch (NullPointerException npe) {
                    jObj.put("Subcounty", "");
                }

                try {
                    jObj.put("Parish", rs.getString(4));
                } catch (NullPointerException npe) {
                    jObj.put("Parish", "");
                }
                try {
                    jObj.put("Facility", rs.getString(5));
                } catch (NullPointerException npe) {
                    jObj.put("Facility", "");
                }
                try {
                    jObj.put("Year", rs.getInt(6));
                } catch (NullPointerException npe) {
                    jObj.put("Year", "");
                }
                try {
                    jObj.put("Quarter", rs.getString(7));
                } catch (NullPointerException npe) {
                    jObj.put("Quarter", "");
                }
                try {
                    jObj.put("Value", rs.getInt(8));
                } catch (NullPointerException npe) {
                    jObj.put("Value", 0);
                }
                jArray.put(jObj);
            }
            jSONArray = jArray;
        } catch (SQLException ex) {
            Logger.getLogger(KpiBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JSONArray getjSONArray() {
        return jSONArray;
    }

    public void setjSONArray(JSONArray jSONArray) {
        this.jSONArray = jSONArray;
    }
}

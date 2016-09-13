/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
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
    private District selectedDistrict;
    private Integer[] selectedYears;
    private List<Integer> years;
    private Technical_area selectedTA;

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
            kpiList = Kpi.queryKpi("technical_area=" + ta.getTechnical_area_id(), null);
        } catch (PersistentException | NullPointerException ex) {
            //Logger.getLogger(KpiBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kpiList;
    }

    public void showReport() {

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
        try {

            Connection conn = DBConnection.getMySQLConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
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
     * @return the selectedDistrict
     */
    public District getSelectedDistrict() {
        return selectedDistrict;
    }

    /**
     * @param selectedDistrict the selectedDistrict to set
     */
    public void setSelectedDistrict(District selectedDistrict) {
        this.selectedDistrict = selectedDistrict;
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
            this.years=new ArrayList<>();
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
}

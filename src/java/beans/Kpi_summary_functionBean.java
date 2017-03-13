/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import eihdms.Data_element;
import eihdms.EIHDMSPersistentManager;
import eihdms.Kpi_summary_function;
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
import javax.faces.application.FacesMessage;
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
public class Kpi_summary_functionBean extends AbstractBean<Kpi_summary_function> implements Serializable {

    private String validation_formula = "";
    private Data_element data_element;

    private Report_form report_form;

    public Report_form getReport_form() {
        return report_form;
    }

    public void setReport_form(Report_form report_form) {
        this.report_form = report_form;
    }

    public Data_element getData_element() {
        return data_element;
    }

    public void setData_element(Data_element data_element) {
        this.data_element = data_element;
    }

    public String getValidation_formula() {
        return validation_formula;
    }

    public void setValidation_formula(String validation_formula) {
        this.validation_formula = validation_formula;
    }

    public Kpi_summary_functionBean() {
        super(Kpi_summary_function.class);
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

    public void append_operand(String operand) {
        this.getSelected().setSummary_function(this.getSelected().getSummary_function() + " " + operand);;
    }

    public void append_data_element() {
        validation_formula = this.getSelected().getSummary_function();
        if (validation_formula == null) {
            validation_formula = "";
        }
        this.getSelected().setSummary_function(validation_formula + " DE" + data_element.getData_element_id());;
        String data_elements_involved = this.getSelected().getData_elements_involved();
        if (data_elements_involved == null) {
            data_elements_involved = "";
        }
        this.getSelected().setData_elements_involved(data_elements_involved + "\n" + " DE" + data_element.getData_element_id() + "=>" + data_element.getData_element_name());

        String data_element_ids_involved = this.getSelected().getData_element_ids_involved();
        if (data_element_ids_involved == null) {
            data_element_ids_involved = "";
        }

        if ("".equals(data_element_ids_involved)) {
            this.getSelected().setData_element_ids_involved(String.valueOf(data_element.getData_element_id()));
        } else {
            this.getSelected().setData_element_ids_involved(data_element_ids_involved + "," + String.valueOf(data_element.getData_element_id()));
        }
    }

    @Override
    public void save(int aUserDetailId) {
        String sql = "{call sp_validate_kpi_summary_function(?,?,?)}";
        ResultSet rs = null;
        try (Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, this.getSelected().getSummary_function());
            ps.setInt(2, this.getSelected().getKpi().getReport_form().getReport_form_id());
            ps.setString(3, this.getSelected().getData_element_ids_involved());
            rs = ps.executeQuery();
        } catch (SQLException se) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Invalid Summary Function!", "Invalid Summary Function!"));
            System.err.println(se.getMessage());
            return;
        }
        super.save(aUserDetailId); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add() {
        this.setReport_form(null);
        super.add(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public List<Kpi_summary_function> getTs() {
        if (this.getSelected() != null) {
            if (this.getSelected().getKpi() == null) {
                this.init();
                this.initializelist();
                return super.getTs(); //To change body of generated methods, choose Tools | Templates.
            } else {
                try {
                    super.setTs(Kpi_summary_function.queryKpi_summary_function("kpi_id=" + this.getSelected().getKpi().getKpi_id(), null));
                } catch (PersistentException ex) {
                    this.init();
                    this.initializelist();
                    Logger.getLogger(Kpi_summary_functionBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                return super.getTs(); //To change body of generated methods, choose Tools | Templates.
            }
        } else {
            this.init();
            this.initializelist();
            return super.getTs(); //To change body of generated methods, choose Tools | Templates.
        }
    }

    public List<Data_element> completeData_element(String query) {
        List<Data_element> filteredData_elements = new ArrayList<>();
        try {
            if (this.getSelected() != null) {
                if (this.getReport_form() == null) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Please select the report form first!", "Please select the report form first!"));
                    return filteredData_elements;
                }
                filteredData_elements = (List<Data_element>) EIHDMSPersistentManager.instance().getSession().createQuery("select de FROM Data_element  de where de.is_deleted<>1 AND de.report_form.report_form_id=" + this.getReport_form().getReport_form_id() + " AND de.data_element_name like '%" + query + "%'").list();
            }
        } catch (PersistentException ex) {
            Logger.getLogger(Data_elementBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filteredData_elements;
    }
}

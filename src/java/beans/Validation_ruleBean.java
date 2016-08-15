/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import eihdms.Data_element;
import eihdms.EIHDMSPersistentManager;
import eihdms.Report_form;
import eihdms.Validation_rule;
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
public class Validation_ruleBean extends AbstractBean<Validation_rule> implements Serializable {

    private String validation_formula = "";

    private Data_element data_element;

    /**
     * Creates a new instance of Validation_ruleBean
     */
    public Validation_ruleBean() {
        super(Validation_rule.class);
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

    private Report_form report_form;

    public Report_form getReport_form() {
        return report_form;
    }

    public void setReport_form(Report_form report_form) {
        this.report_form = report_form;
    }

    @Override
    public void save(int aUserDetailId) {
        String sql = "{call sp_validate_formula(?)}";
        ResultSet rs = null;
        try {

            Connection conn = DBConnection.getMySQLConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, this.getSelected().getValidation_rule_formula());
            rs = ps.executeQuery();
        } catch (SQLException se) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Invalid Formula!", "Invalid Formula!"));
            System.err.println(se.getMessage());
            return;
        }
        super.save(aUserDetailId); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Data_element> completeData_element(String query) {
        List<Data_element> filteredData_elements = new ArrayList<>();
        try {
            if (this.getSelected() != null) {
                if (this.getSelected().getReport_form() != null && this.getSelected().getReport_form_group() != null) {
                    filteredData_elements = (List<Data_element>) EIHDMSPersistentManager.instance().getSession().createQuery("select de FROM Data_element  de where de.is_deleted<>1 AND de.report_form.report_form_id=" + this.getSelected().getReport_form().getReport_form_id() + " AND  de.report_form_group=" + this.getSelected().getReport_form_group().getReport_form_group_id() + " AND de.data_element_name like '%" + query + "%'").list();
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

    public String getValidation_formula() {
        return validation_formula;
    }

    public void setValidation_formula(String validation_formula) {
        this.validation_formula = validation_formula;
    }

    public void append_operand(String operand) {
        if (operand.equals("le")) {
            operand = "<=";
        }
        if (operand.equals("lt")) {
            operand = "<";
        }
        this.getSelected().setValidation_rule_formula(this.getSelected().getValidation_rule_formula() + " " + operand);;
    }

    public void append_data_element() {
        validation_formula = this.getSelected().getValidation_rule_formula();
        if (validation_formula == null) {
            validation_formula = "";
        }
        this.getSelected().setValidation_rule_formula(validation_formula + " Col" + data_element.getData_element_id());;
        String data_elements_involved = this.getSelected().getData_elements_involved();
        if (data_elements_involved == null) {
            data_elements_involved = "";
        }
        this.getSelected().setData_elements_involved(data_elements_involved + "\n" + " Col" + data_element.getData_element_id() + "=>" + data_element.getData_element_name());
    }
}

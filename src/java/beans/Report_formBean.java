/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Report_form;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.orm.PersistentException;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class Report_formBean extends AbstractBean<Report_form> implements Serializable {

    /**
     * Creates a new instance of Report_formBean
     */
    public Report_formBean() {
        super(Report_form.class);
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

    public List<Report_form> getReport_forms(Report_form report_form) {
        List<Report_form> report_forms = new ArrayList<>();
        if (null != report_form) {
            report_forms.add(report_form);
        }
        return report_forms;
    }

    public List<Report_form> getReport_forms_by_user(String allow) {
        try {
            if (loginBean.getUser_detail().getIs_user_gen_admin() == 1) {
                return this.getTsActive();
            } else {
                String RFIDs = "";
                RFIDs = loginBean.getUser_report_form_str(allow);
                if (RFIDs.length() > 0) {
                    return Report_form.queryReport_form("is_active=1 and is_deleted=0 and report_form_id IN(" + RFIDs + ")", null);
                } else {
                    return null;
                }
            }
        } catch (PersistentException ex) {
            Logger.getLogger(Report_formBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Report_form> getReport_forms_by_user(String allow,String mode_col_name) {
        try {
            if (loginBean.getUser_detail().getIs_user_gen_admin() == 1) {
                return Report_form.queryReport_form("is_active=1 and is_deleted=0 and "+ mode_col_name +"=1", null);
            } else {
                String RFIDs = "";
                RFIDs = loginBean.getUser_report_form_str(allow);
                if (RFIDs.length() > 0) {
                    return Report_form.queryReport_form("is_active=1 and is_deleted=0 and "+ mode_col_name +"=1 and report_form_id IN(" + RFIDs + ")", null);
                } else {
                    return null;
                }
            }
        } catch (PersistentException ex) {
            Logger.getLogger(Report_formBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

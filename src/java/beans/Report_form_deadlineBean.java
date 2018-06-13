/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Report_form_deadline;
import eihdms.Report_form;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped
public class Report_form_deadlineBean extends AbstractBean<Report_form_deadline> implements Serializable {

    private Report_form report_form;

    public Report_form_deadlineBean() {
        super(Report_form_deadline.class);
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
    
    public boolean showweekly(Report_form aReport_form) {
        if (aReport_form == null) {
            return false;
        } else if (aReport_form.getReport_form_frequency().equals("Weekly")) {
            return true;
        }
        return false;
    }

    public boolean showmonthly(Report_form aReport_form) {
        if (aReport_form == null) {
            return false;
        } else if (aReport_form.getReport_form_frequency().equals("Monthly")) {
            return true;
        }
        return false;
    }

    public boolean showquartery(Report_form aReport_form) {
        if (aReport_form == null) {
            return false;
        } else if (aReport_form.getReport_form_frequency().equals("Quarterly")) {
            return true;
        }
        return false;
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

}

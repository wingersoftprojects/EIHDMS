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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

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
}

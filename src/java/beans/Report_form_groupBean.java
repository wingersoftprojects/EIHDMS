/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Report_form_group;
import eihdms.EIHDMSPersistentManager;
import eihdms.Report_form;
import eihdms.Report_form_group;
import eihdms.Section;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;
import org.orm.PersistentException;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class Report_form_groupBean extends AbstractBean<Report_form_group> implements Serializable {

    /**
     * Creates a new instance of Report_form_groupBean
     */
    public Report_form_groupBean() {
        super(Report_form_group.class);
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

    public List<Report_form_group> getts(Report_form report_form) {
        List<Report_form_group> temp = new ArrayList<>();
        try {
            if (this.getEntityClass() != null && report_form != null) {
                temp = (List<Report_form_group>) EIHDMSPersistentManager.instance().getSession().createQuery("select d FROM Report_form_group  d where d.is_deleted<>1 AND d.report_form=" + report_form.getReport_form_id()).list();
            } else {
                temp = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public List<Section> getsecions(Report_form report_form) {
        List<Section> temp = new ArrayList<>();
        try {
            if (this.getEntityClass() != null && report_form != null) {
                temp = (List<Section>) EIHDMSPersistentManager.instance().getSession().createQuery("select s FROM Section s where s.is_deleted<>1 AND s.report_form=" + report_form.getReport_form_id()).list();
            } else {
                temp = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
}

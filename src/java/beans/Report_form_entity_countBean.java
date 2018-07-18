/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.EIHDMSPersistentManager;
import eihdms.Report_form;
import eihdms.Report_form_entity;
import eihdms.Report_form_entity_count;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped
public class Report_form_entity_countBean extends AbstractBean<Report_form_entity_count> implements Serializable {

    public Report_form_entity_countBean() {
        super(Report_form_entity_count.class);
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

    public void saveEntityCount(Report_form aReport_form,int id) {
        int entity_count = 0;
        try {
            entity_count = Report_form_entity.queryReport_form_entity("is_active=1 and is_deleted=0 and report_form_id=" + aReport_form.getReport_form_id(), null).size();
            Report_form_entity_count rfec = new Report_form_entity_count();
            rfec.setReport_form(aReport_form);
            rfec.setEntity_count(entity_count);
            rfec.setCount_date(new Date());
            rfec.setIs_active(1);
            rfec.setAdd_date(new Timestamp(new Date().getTime()));
            rfec.setAdd_by(id);
            rfec.setIs_deleted(0);
            PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
            rfec.save();
            transaction.commit();
        } catch (PersistentException ex) {
            Logger.getLogger(Report_form_entity_countBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

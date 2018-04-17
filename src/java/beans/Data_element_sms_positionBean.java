/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Data_element_sms_position;
import eihdms.EIHDMSPersistentManager;
import eihdms.Report_form;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import utilities.GeneralUtilities;

/**
 *
 * @author btwesigye
 */
@ManagedBean
@SessionScoped
public class Data_element_sms_positionBean extends AbstractBean<Data_element_sms_position> implements Serializable {

    /**
     * Creates a new instance of Data_element_sms_positionBean
     */
    public Data_element_sms_positionBean() {
        super(Data_element_sms_position.class);
    }
    
    private List<Data_element_sms_position> data_element_sms_positionFiltered;
    
    public List<Data_element_sms_position> getData_element_sms_positionFiltered() {
        return data_element_sms_positionFiltered;
    }
    
    public void setData_element_sms_positionFiltered(List<Data_element_sms_position> data_element_sms_positionFiltered) {
        this.data_element_sms_positionFiltered = data_element_sms_positionFiltered;
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
        try {
            PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
            if (super.getFormstate().equals("add")) {
                super.getSelected().setAdd_date(new Timestamp(new Date().getTime()));
                super.getSelected().setIs_deleted(0);
                super.getSelected().setAdd_by(aUserDetailId);
            }
            if (super.getFormstate().equals("edit")) {
                super.getSelected().setLast_edit_date(new Timestamp(new Date().getTime()));
                super.getSelected().setLast_edit_by(aUserDetailId);
            }
            int id = super.getSelected().getData_element_sms_position_id();
            if (id > 0) {
                EIHDMSPersistentManager.instance().getSession().merge(super.getSelected());
            } else {
                super.getSelected().save();
            }
            transaction.commit();
            clearCache(super.getSelected());
            super.setFormstate("view");
            add();
            loginBean.saveMessage();
        } catch (PersistentException | SecurityException | IllegalArgumentException ex) {
            GeneralUtilities.clearsession();
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
            loginBean.Error(ex.getMessage() + " " + ex.getLocalizedMessage());
        }
        //super.save(aUserDetailId); //To change body of generated methods, choose Tools | Templates.
    }
    
}

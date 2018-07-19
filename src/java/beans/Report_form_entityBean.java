/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Health_facility;
import eihdms.Report_form;
import eihdms.Report_form_entity;
import java.io.Serializable;
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
import utilities.Security;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped
public class Report_form_entityBean extends AbstractBean<Report_form_entity> implements Serializable {

    public Report_form_entityBean() {
        super(Report_form_entity.class);
    }

    private List<Report_form_entity> Report_form_entityList = new ArrayList<>();
    private Report_form Report_formObj=new Report_form();
    private boolean All_allow;
    
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

    public void saveReport_form_entity(int id) {
        Report_form savedReport_form = this.getSelected().getReport_form();
        super.save(id);
        new Report_form_entity_countBean().saveEntityCount(savedReport_form, id);
    }

    public void refreshReport_form_entityList(Report_form aReport_form) {
        String reportlevel = aReport_form.getLowest_report_form_level();
        String enitytype = "";
        this.Report_form_entityList = new ArrayList<>();
        if (reportlevel.equals("Facility")) {
            try {
                enitytype = "Facility";
                List<Health_facility> HfList = new ArrayList<>();
                HfList = Health_facility.queryHealth_facility("is_active=1 and is_deleted=0", null);
                Report_form_entity RfObj;
                for(Health_facility HfObj:HfList){
                    RfObj=new Report_form_entity();
                    RfObj.setEntity_type(enitytype);
                    RfObj.setEntity_id(HfObj.getHealth_facility_id());
                    RfObj.setReport_form(aReport_form);
                    this.Report_form_entityList.add(RfObj);
                }
            } catch (PersistentException ex) {
                Logger.getLogger(Report_form_entityBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (reportlevel.equals("Parish")) {
            enitytype = "Parish";
        }

    }
    
    public void All_allow(boolean bool_value) {
        try {
            if (bool_value) {
                //multiChangeGroupRight(allow_what, 1);
            } else {
                //multiChangeGroupRight(allow_what, 0);
            }
        } catch (Exception ex) {
            Logger.getLogger(Report_form_entity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the Report_form_entityList
     */
    public List<Report_form_entity> getReport_form_entityList() {
        return Report_form_entityList;
    }

    /**
     * @param Report_form_entityList the Report_form_entityList to set
     */
    public void setReport_form_entityList(List<Report_form_entity> Report_form_entityList) {
        this.Report_form_entityList = Report_form_entityList;
    }

    /**
     * @return the Report_formObj
     */
    public Report_form getReport_formObj() {
        return Report_formObj;
    }

    /**
     * @param Report_formObj the Report_formObj to set
     */
    public void setReport_formObj(Report_form Report_formObj) {
        this.Report_formObj = Report_formObj;
    }

    /**
     * @return the All_allow
     */
    public boolean isAll_allow() {
        return All_allow;
    }

    /**
     * @param All_allow the All_allow to set
     */
    public void setAll_allow(boolean All_allow) {
        this.All_allow = All_allow;
    }

}

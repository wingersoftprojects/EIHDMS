/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.EIHDMSPersistentManager;
import eihdms.Health_facility;
import eihdms.Parish;
import eihdms.Report_form;
import eihdms.Report_form_entity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class Report_form_entityBean extends AbstractBean<Report_form_entity> implements Serializable {
    
    public Report_form_entityBean() {
        super(Report_form_entity.class);
    }

    private List<Report_form_entity> Report_form_entityList = new ArrayList<>();
    private Report_form Report_formObj = new Report_form();
    private boolean All_allow;
    private List<Report_form_entity_ui> Report_form_entity_uiList = new ArrayList<>();

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
    }
    
    public void saveReport_form_entities(Report_form aReport_form,int id){
        try {
            Report_form_entity rfe=null;
            for(Report_form_entity_ui objui:this.Report_form_entity_uiList){
                //exists do nothing
                if(objui.getReport_form_entity_id()>0 && objui.isIs_checked()){
                }
                //new for adding
                if(objui.getReport_form_entity_id()==0 && objui.isIs_checked()){
                    try {
                        rfe=new Report_form_entity();
                        rfe.setReport_form(aReport_form);
                        rfe.setEntity_type(objui.getEntity_type());
                        rfe.setEntity_id(objui.getEntity_id());
                        rfe.setIs_active(1);
                        rfe.setAdd_date(new Timestamp(new Date().getTime()));
                        rfe.setAdd_by(id);
                        rfe.setIs_deleted(0);
                        PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                        rfe.save();
                        transaction.commit();
                    } catch (PersistentException ex) {
                        Logger.getLogger(Report_form_entityBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //exists for deleting
                if(objui.getReport_form_entity_id()>0 && !objui.isIs_checked()){
                    try {
                        PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                        Report_form_entity.getReport_form_entityByORMID((int) objui.getReport_form_entity_id()).deleteAndDissociate();
                        transaction.commit();
                    } catch (PersistentException ex) {
                        Logger.getLogger(Report_form_entityBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            new Report_form_entity_countBean().saveEntityCount(aReport_form, id);
            this.Report_form_entity_uiList.clear();
            this.All_allow=false;
        } catch (Exception ex) {
            Logger.getLogger(Report_form_entityBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshReport_form_entityList(Report_form aReport_form) {
        String reportlevel = aReport_form.getLowest_report_form_level();
        String enitytype = "";
        this.Report_form_entity_uiList = new ArrayList<>();
        if (reportlevel.equals("Facility")) {
            try {
                enitytype = "Facility";
                List<Health_facility> HfList = new ArrayList<>();
                try {
                    HfList = Health_facility.queryHealth_facility("is_active=1 and is_deleted=0", "district.district_name,health_facility_name");
                } catch (PersistentException ex) {
                }
                Report_form_entity_ui RfeUiObj;
                int i = 0;
                Report_form_entity existobj;
                for (Health_facility HfObj : HfList) {
                    i = i + 1;
                    RfeUiObj = new Report_form_entity_ui();
                    RfeUiObj.setEntity_type(enitytype);
                    RfeUiObj.setEntity_id(HfObj.getHealth_facility_id());
                    RfeUiObj.setReport_form_id(aReport_form.getReport_form_id());
                    RfeUiObj.setEntity_name(HfObj.getHealth_facility_name());
                    RfeUiObj.setEntity_parent_name(HfObj.getDistrict().getDistrict_name());
                    RfeUiObj.setItem_no(i);
                    existobj = new Report_form_entity();
                    try {
                        existobj = (Report_form_entity) Report_form_entity.queryReport_form_entity("is_active=1 and is_deleted=0 and report_form_id=" + aReport_form.getReport_form_id() + " and entity_id=" + RfeUiObj.getEntity_id(), null).get(0);
                    } catch (PersistentException | IndexOutOfBoundsException ex) {
                        existobj = null;
                    }
                    if (null == existobj || existobj.getReport_form_entity_id() == 0) {
                        RfeUiObj.setIs_checked(false);
                        RfeUiObj.setReport_form_entity_id(0);
                    } else {
                        RfeUiObj.setIs_checked(true);
                        RfeUiObj.setReport_form_entity_id(existobj.getReport_form_entity_id());
                    }
                    this.Report_form_entity_uiList.add(RfeUiObj);
                }
            } catch (NullPointerException ex) {
                Logger.getLogger(Report_form_entityBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (reportlevel.equals("Parish")) {
            try {
                enitytype = "Parish";
                List<Parish> PaList = new ArrayList<>();
                try {
                    PaList = Parish.queryParish("is_active=1 and is_deleted=0", "sub_county.county.district.district_name,parish_name");
                } catch (PersistentException ex) {
                }
                Report_form_entity_ui RfeUiObj;
                int i = 0;
                Report_form_entity existobj;
                for (Parish PaObj : PaList) {
                    i = i + 1;
                    RfeUiObj = new Report_form_entity_ui();
                    RfeUiObj.setEntity_type(enitytype);
                    RfeUiObj.setEntity_id(PaObj.getParish_id());
                    RfeUiObj.setReport_form_id(aReport_form.getReport_form_id());
                    RfeUiObj.setEntity_name(PaObj.getParish_name());
                    RfeUiObj.setEntity_parent_name(PaObj.getSub_county().getCounty().getDistrict().getDistrict_name());
                    RfeUiObj.setItem_no(i);
                    existobj = new Report_form_entity();
                    try {
                        existobj = (Report_form_entity) Report_form_entity.queryReport_form_entity("is_active=1 and is_deleted=0 and report_form_id=" + aReport_form.getReport_form_id() + " and entity_id=" + RfeUiObj.getEntity_id(), null).get(0);
                    } catch (PersistentException | IndexOutOfBoundsException ex) {
                        existobj = null;
                    }
                    if (null == existobj || existobj.getReport_form_entity_id() == 0) {
                        RfeUiObj.setIs_checked(false);
                        RfeUiObj.setReport_form_entity_id(0);
                    } else {
                        RfeUiObj.setIs_checked(true);
                        RfeUiObj.setReport_form_entity_id(existobj.getReport_form_entity_id());
                    }
                    this.Report_form_entity_uiList.add(RfeUiObj);
                }
            } catch (NullPointerException ex) {
                Logger.getLogger(Report_form_entityBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }

    public void refreshReport_form_entityList_old(Report_form aReport_form) {
        String reportlevel = aReport_form.getLowest_report_form_level();
        String enitytype = "";
        this.Report_form_entityList = new ArrayList<>();
        if (reportlevel.equals("Facility")) {
            try {
                enitytype = "Facility";
                List<Health_facility> HfList = new ArrayList<>();
                HfList = Health_facility.queryHealth_facility("is_active=1 and is_deleted=0", null);
                Report_form_entity RfObj;
                for (Health_facility HfObj : HfList) {
                    RfObj = new Report_form_entity();
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

    public void multiAllowAll(boolean aValue) {
        try {
            int n = 0;
            n = this.Report_form_entity_uiList.size();
            for (int i = 0; i < n; i++) {
                this.Report_form_entity_uiList.get(i).setIs_checked(aValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    /**
     * @return the Report_form_entity_uiList
     */
    public List<Report_form_entity_ui> getReport_form_entity_uiList() {
        return Report_form_entity_uiList;
    }

    /**
     * @param Report_form_entity_uiList the Report_form_entity_uiList to set
     */
    public void setReport_form_entity_uiList(List<Report_form_entity_ui> Report_form_entity_uiList) {
        this.Report_form_entity_uiList = Report_form_entity_uiList;
    }

}

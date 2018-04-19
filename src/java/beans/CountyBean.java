/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.District;
import eihdms.EIHDMSPersistentManager;
import eihdms.County;
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
public class CountyBean extends AbstractBean<County> implements Serializable {

    public CountyBean() {
        super(County.class);
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
    private District district;

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<County> getts() {
        List<County> temp = new ArrayList<>();
        try {
            if (this.getEntityClass() != null && district != null) {
                temp = (List<County>) EIHDMSPersistentManager.instance().getSession().createQuery("select c FROM County  c where c.is_deleted<>1 AND c.district=" + district.getDistrict_id()).list();
            } else {
                temp = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public List<County> getts(District district) {
        List<County> temp = new ArrayList<>();
        try {
            if (this.getEntityClass() != null && district != null) {
                temp = (List<County>) EIHDMSPersistentManager.instance().getSession().createQuery("select c FROM County  c where c.is_deleted<>1 AND c.district=" + district.getDistrict_id()).list();
            } else {
                temp = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public List<County> getts_id(int aDistrict_id) {
        List<County> temp = new ArrayList<>();
        try {
            if (this.getEntityClass() != null && aDistrict_id != 0) {
                temp = (List<County>) EIHDMSPersistentManager.instance().getSession().createQuery("select d FROM County  d where d.is_deleted<>1 AND d.district=" + aDistrict_id).list();
            } else {
                temp = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

}

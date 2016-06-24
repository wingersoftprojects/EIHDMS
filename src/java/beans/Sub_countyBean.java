/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.County;
import eihdms.EIHDMSPersistentManager;
import eihdms.Sub_county;
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
public class Sub_countyBean extends AbstractBean<Sub_county> implements Serializable {

    public Sub_countyBean() {
        super(Sub_county.class);
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

    private County county;

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public List<Sub_county> getts() {
        List<Sub_county> temp = new ArrayList<>();
        try {
            if (this.getEntityClass() != null && county != null) {
                temp = (List<Sub_county>) EIHDMSPersistentManager.instance().getSession().createQuery("select sc FROM Sub_county  sc where sc.is_deleted<>1 AND sc.county=" + county.getCounty_id()).list();
            } else {
                temp = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public List<Sub_county> getts(County county) {
        List<Sub_county> temp = new ArrayList<>();
        try {
            if (this.getEntityClass() != null && county != null) {
                temp = (List<Sub_county>) EIHDMSPersistentManager.instance().getSession().createQuery("select sc FROM Sub_county  sc where sc.is_deleted<>1 AND sc.county=" + county.getCounty_id()).list();
            } else {
                temp = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.County;
import eihdms.District;
import eihdms.EIHDMSPersistentManager;
import eihdms.Parish;
import eihdms.Parish;
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
public class ParishBean extends AbstractBean<Parish> implements Serializable {

    List<Object[]> parish_list;

    public ParishBean() {
        super(Parish.class);
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

    public List<Parish> getts(Sub_county sub_county) {
        List<Parish> temp = new ArrayList<>();
        try {
            if (this.getEntityClass() != null && sub_county != null) {
                temp = (List<Parish>) EIHDMSPersistentManager.instance().getSession().createQuery("select p FROM Parish  p where p.is_deleted<>1 AND p.sub_county=" + sub_county.getSub_county_id()).list();
            } else {
                temp = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public List<Parish> getts_id(int aDistrict_id) {
        List<Parish> temp = new ArrayList<>();

        try {
            if (this.getEntityClass() != null && aDistrict_id != 0) {
                temp = (List<Parish>) EIHDMSPersistentManager.instance().getSession().createQuery("select d FROM Parish  d where d.is_deleted<>1 AND d.district=" + aDistrict_id).list();
            } else {
                temp = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public Parish getParish_by_id(int aParish_id) {
        try {
            return (Parish) Parish.queryParish("is_active=1 and is_deleted=0 and parish_id=" + aParish_id, null).get(0);
        } catch (PersistentException ex) {
            Logger.getLogger(ParishBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Parish> getParish_list(District aDistrict) {
        List<Parish> temp = new ArrayList<>();
        try {
            if (this.getEntityClass() != null && aDistrict != null) {
                String sql = "SELECT p.* FROM parish p WHERE p.sub_county_id IN \n"
                        + "( SELECT s.sub_county_id FROM sub_county s WHERE s.county_id IN \n"
                        + "( SELECT c.county_id FROM county c WHERE c.district_id=" + aDistrict.getDistrict_id() + "))";
//                System.out.println(sql);
                temp = EIHDMSPersistentManager.instance().getSession().createSQLQuery(sql).addEntity(Parish.class).list();
            } else {
                temp = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;

    }

}

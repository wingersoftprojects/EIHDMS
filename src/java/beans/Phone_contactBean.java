/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Access_scope;
import eihdms.EIHDMSPersistentManager;
import eihdms.Organisation;
import eihdms.Phone_contact;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped
public class Phone_contactBean extends AbstractBean<Phone_contact> implements Serializable {

    public Phone_contactBean() {
        super(Phone_contact.class);
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

    @Override
    public void save(int aUserDetailId) {
        try {
            Phone_contact phone_contact = Phone_contact.loadPhone_contactByQuery("entity_phone='" + this.getSelected().getEntity_phone() + "'", null);
            if (phone_contact != null) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Phone number already used for another entity!", "Phone number already used for another entity!"));
                return;
            }
        } catch (PersistentException ex) {
            Logger.getLogger(Phone_contactBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.save(aUserDetailId); //To change body of generated methods, choose Tools | Templates.
    }

    List<Object[]> phone_contact_list;
    List<Object[]> filtered_phone_contact_list;

    public List<Object[]> getFiltered_phone_contact_list() {
        return filtered_phone_contact_list;
    }

    public void setFiltered_phone_contact_list(List<Object[]> filtered_phone_contact_list) {
        this.filtered_phone_contact_list = filtered_phone_contact_list;
    }

    public List<Object[]> getPhone_contact_list() {
        try {
            phone_contact_list = (List<Object[]>) EIHDMSPersistentManager.instance().getSession().createSQLQuery("select \n"
                    + "CASE WHEN pc.entity_type='Facility' THEN (SELECT district_name FROM district where district_id in (select district_id from health_facility where health_facility_id=pc.entity_id))\n"
                    + "\n"
                    + "WHEN pc.entity_type='Parish' THEN (SELECT district_name FROM district where district_id in (select district_id from county where county_id in (select county_id from sub_county where sub_county_id in (select sub_county_id from parish where parish_id=pc.entity_id))))\n"
                    + "\n"
                    + "WHEN pc.entity_type='District' THEN '' END AS District_Name,\n"
                    + "CASE WHEN pc.entity_type='Facility' THEN (SELECT health_facility_name FROM health_facility where health_facility_id=pc.entity_id) WHEN pc.entity_type='Parish' THEN (SELECT parish_name FROM parish where parish_id=pc.entity_id) WHEN pc.entity_type='District' THEN (SELECT district_name FROM district where district_id=pc.entity_id) END AS Entity_Name, pc.entity_id,pc.entity_type,pc.entity_phone,pc.is_active\n"
                    + "from phone_contact pc").list();
        } catch (PersistentException ex) {
            Logger.getLogger(Phone_contactBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phone_contact_list;
    }

    public void setPhone_contact_list(List<Object[]> phone_contact_list) {
        this.phone_contact_list = phone_contact_list;
    }

}

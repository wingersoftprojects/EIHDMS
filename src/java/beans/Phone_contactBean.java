/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Access_scope;
import eihdms.Organisation;
import eihdms.Phone_contact;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

}

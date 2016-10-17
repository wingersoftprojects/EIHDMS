/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.App_db_user_map;
import java.io.Serializable;
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
 * @author btwesigye
 */
@ManagedBean
@SessionScoped
public class App_db_user_mapBean extends AbstractBean<App_db_user_map> implements Serializable {

    /**
     * Creates a new instance of App_db_user_mapBean
     */
    public App_db_user_mapBean() {
        super(App_db_user_map.class);
    }

    @Override
    public void init() {
        if (super.getEntityClass() == null) {
            loginBean.logout();
        }
    }
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;

    public void doEncrypt(App_db_user_map aApp_db_user_map) {
        if (aApp_db_user_map != null) {
            aApp_db_user_map.setDb_password(Security.Encrypt(aApp_db_user_map.getDb_password()));
        }
    }

    public void editUI(App_db_user_map aApp_db_user_map) {
        if (aApp_db_user_map != null) {
            aApp_db_user_map.setDb_password(Security.Decrypt(aApp_db_user_map.getDb_password()));
            this.setSelected(aApp_db_user_map);
        }
    }

    public void deleteUI(App_db_user_map aApp_db_user_map) {
        if (aApp_db_user_map != null) {
            try {
                App_db_user_map.getApp_db_user_mapByORMID(aApp_db_user_map.getApp_db_user_map_id()).delete();
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Completed successfully", "Deleted successfully"));
            } catch (PersistentException ex) {
                Logger.getLogger(App_db_user_mapBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public void save_App_db_user_map(int id) {
        this.getSelected().setDb_password(Security.Encrypt(this.getSelected().getDb_password()));
        super.save(id);
    }

}

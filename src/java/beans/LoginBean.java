/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Group_right;
import eihdms.User_detail;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.orm.PersistentException;
import utilities.GeneralUtilities;
import utilities.Security;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String username;
    private String password;
    private boolean isloggedin = false;
    private String action = "login";
    private String messageString = "";
    private User_detail user_detail;
    private List<Group_right> group_rights;

    public LoginBean() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isIsloggedin() {
        return isloggedin;
    }

    public void setIsloggedin(boolean isloggedin) {
        this.isloggedin = isloggedin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        user_detail = null;
        setIsloggedin(false);
        try {
            user_detail = User_detail.loadUser_detailByQuery("is_deleted=0 and is_active=1 and user_name='" + username + "'", null);
        } catch (PersistentException ex) {
            Logger.getLogger(NavigationBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (user_detail != null) {
            if (Security.Decrypt(user_detail.getUser_password()).equals(password)) {
                setIsloggedin(true);
            } else {
                setIsloggedin(false);
            }
        } else {
            setIsloggedin(false);
        }
        
        //get group_rights for this User
        try {
            this.setGroup_rights(new Group_rightBean().getActiveGroup_rightListByUser(user_detail));
        } catch (NullPointerException npe) {
            this.setGroup_rights(null);
        }

        if (isloggedin) {
            setIsloggedin(true);
            messageString = "";
            return "home?faces-redirect=true";
        } else {
            messageString = "Invalid Login Details Submitted!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("EIHDMS Login Failure",messageString));
            return "#";
        }
    }
    
    public boolean IsAllowed(int form_id, String role) {
        try {
            return new Group_rightBean().IsUserGroupsFormAccessAllowed(this.getUser_detail(), this.getGroup_rights(), form_id, role) != 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public String getMessageString() {
        return messageString;
    }

    public void setMessageString(String messageString) {
        this.messageString = messageString;
    }

    public String logout() {
        setUsername("");
        setPassword("");
        setIsloggedin(false);
        prelogout();
        return "login?faces-redirect=true";
    }

    private void prelogout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public boolean IsAllowed(String functionname, String role) {
        return false;
    }

    public void redirectifnotloggedin() {
        if (!isloggedin) {
            logout();
            FacesContext fc = FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
            nav.performNavigation("login?faces-redirect=true");
        }
    }

    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Completed successfully", "Completed successfully"));
    }

    /**
     * @return the user_detail
     */
    public User_detail getUser_detail() {
        return user_detail;
    }

    /**
     * @param user_detail the user_detail to set
     */
    public void setUser_detail(User_detail user_detail) {
        this.user_detail = user_detail;
    }

    /**
     * @return the group_rights
     */
    public List<Group_right> getGroup_rights() {
        return group_rights;
    }

    /**
     * @param group_rights the group_rights to set
     */
    public void setGroup_rights(List<Group_right> group_rights) {
        this.group_rights = group_rights;
    }

}

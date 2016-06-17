/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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

    public LoginBean() {

    }

    public String login() {

        //get grouprights for this User
        if (isloggedin) {
            setIsloggedin(true);
            messageString = "";
            return "upload?faces-redirect=true";
        } else {
            messageString = "Invalid Login Details Submitted!";
            FacesContext.getCurrentInstance().addMessage("List", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Login Details", "Invalid Login Details"));
            return "upload?faces-redirect=true";
        }
    }

    private String newpassword;
    private String retypenewpassword;

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getRetypenewpassword() {
        return retypenewpassword;
    }

    public void setRetypenewpassword(String retypenewpassword) {
        this.retypenewpassword = retypenewpassword;
    }

    public String changepassword() {
            return "login?faces-redirect=true";
    }

    private String messageString = "";

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

}

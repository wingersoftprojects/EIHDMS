/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.User_detail;
import java.io.Serializable;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import utilities.Security;

/**
 *
 * @author btwesigye
 */
@ManagedBean
@SessionScoped
public class User_detailBean extends AbstractBean<User_detail> implements Serializable {

    private boolean OverridePassword;
    private String CurrentPassword;
    private String NewPassword;
    private String ConfirmPassword;

    /**
     * Creates a new instance of User_detailBean
     */
    public User_detailBean() {
        super(User_detail.class);
    }

    @Override
    public void init() {
        if (super.getEntityClass() == null) {
            loginBean.logout();
        }
    }
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;

    public void doEncrypt(User_detail aUser_Detail) {
        if (aUser_Detail != null) {
            aUser_Detail.setUser_password(Security.Encrypt(aUser_Detail.getUser_password()));
        }
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    /**
     * @return the OverridePassword
     */
    public boolean isOverridePassword() {
        return OverridePassword;
    }

    /**
     * @param OverridePassword the OverridePassword to set
     */
    public void setOverridePassword(boolean OverridePassword) {
        this.OverridePassword = OverridePassword;
    }

    public void save_User_detail(int id) {
        if ((this.OverridePassword && this.getSelected().getUser_detail_id() > 0) || this.getSelected().getUser_detail_id() == 0) {
            if (this.getSelected().getUser_password().length() < 8) {
                //passord less than 8 characters
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Password", "Password cannot be less than 8 characters!"));
            } else if (!this.getSelected().getUser_password().equals(this.ConfirmPassword)) {
                //password not equal
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Match failed", "Password and Confirm passwords do not match"));
            } else {
                this.getSelected().setUser_password(Security.Encrypt(this.getSelected().getUser_password()));
                super.save(id);
            }
        }else{
            super.save(id);
        }
    }

    public void changeUserPassword(User_detail ud) {
        if (!this.CurrentPassword.equals(Security.Decrypt(ud.getUser_password()))) {
            //current passord is right
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Current password", "Current password is wrong"));
        } else if (this.NewPassword.length() < 8) {
            //passord less than 8 characters
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("New password", "New password cannot be less than 8 characters!"));
        } else if (!this.NewPassword.equals(this.ConfirmPassword)) {
            //password not equal
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Match failed", "New and Confirm passwords do not match"));
        } else {
            //update password here
            this.setSelected(ud);
            this.getSelected().setUser_password(Security.Encrypt(this.NewPassword));
            super.save(ud.getUser_detail_id());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("CHANGED", "Password changed successfully!"));
            //return to login
            FacesContext fc = FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
            nav.performNavigation("login?faces-redirect=true");
        }
    }

    /**
     * @return the CurrentPassword
     */
    public String getCurrentPassword() {
        return CurrentPassword;
    }

    /**
     * @param CurrentPassword the CurrentPassword to set
     */
    public void setCurrentPassword(String CurrentPassword) {
        this.CurrentPassword = CurrentPassword;
    }

    /**
     * @return the NewPassword
     */
    public String getNewPassword() {
        return NewPassword;
    }

    /**
     * @param NewPassword the NewPassword to set
     */
    public void setNewPassword(String NewPassword) {
        this.NewPassword = NewPassword;
    }

    /**
     * @return the ConfirmPassword
     */
    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    /**
     * @param ConfirmPassword the ConfirmPassword to set
     */
    public void setConfirmPassword(String ConfirmPassword) {
        this.ConfirmPassword = ConfirmPassword;
    }

}

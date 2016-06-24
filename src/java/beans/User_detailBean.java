/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.User_detail;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author btwesigye
 */
@ManagedBean
@SessionScoped
public class User_detailBean extends AbstractBean<User_detail> implements Serializable {
    private boolean OverridePassword;
    
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
    
}

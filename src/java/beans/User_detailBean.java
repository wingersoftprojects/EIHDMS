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
import utilities.Security;

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
            this.getSelected().setUser_password(Security.Encrypt(this.getSelected().getUser_password()));
        }
        super.save(id);
    }
    
}

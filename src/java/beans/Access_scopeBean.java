/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Access_scope;
import eihdms.County;
import eihdms.Sub_county;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped
public class Access_scopeBean extends AbstractBean<Access_scope> implements Serializable{
    private County county = new County();
    private Sub_county sub_county = new Sub_county();
    
    public Access_scopeBean(){
        super(Access_scope.class);
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
     * @return the county
     */
    public County getCounty() {
        return county;
    }

    /**
     * @param county the county to set
     */
    public void setCounty(County county) {
        this.county = county;
    }

    /**
     * @return the sub_county
     */
    public Sub_county getSub_county() {
        return sub_county;
    }

    /**
     * @param sub_county the sub_county to set
     */
    public void setSub_county(Sub_county sub_county) {
        this.sub_county = sub_county;
    }

}

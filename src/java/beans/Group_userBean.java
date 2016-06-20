/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Group_user;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author btwesigye
 */
@ManagedBean
@SessionScoped
public class Group_userBean extends AbstractBean<Group_user> implements Serializable  {

    /**
     * Creates a new instance of Group_userBean
     */
    public Group_userBean() {
        super(Group_user.class);
    }
    
}

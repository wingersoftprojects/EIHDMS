/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.EIHDMSPersistentManager;
import eihdms.Group_right;
import eihdms.User_detail;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.orm.PersistentException;
import utilities.GeneralUtilities;

/**
 *
 * @author btwesigye
 */
@ManagedBean
@SessionScoped
public class Group_rightBean extends AbstractBean<Group_right> implements Serializable {

    /**
     * Creates a new instance of Group_rightBean
     */
    public Group_rightBean() {
        super(Group_right.class);
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
    
    public List<Group_right> getActiveGroup_rightListByUser(User_detail user_detail) {
        List<Group_right> grl = new ArrayList<Group_right>();
        try {
            grl = null;
            if (user_detail == null || user_detail.getIs_active()==0 || user_detail.getIs_deleted()==1 || user_detail.getIs_user_gen_admin()==1) {
                //do nothing; user is either general admin OR inactive OR deleted
            } else {
                grl = (List<Group_right>) EIHDMSPersistentManager.instance().getSession().createQuery(""
                        + "SELECT gr FROM Group_right gr WHERE gr.group_detail IN("
                        + "SELECT gu.group_detail FROM Group_user gu "
                        + "INNER JOIN gu.group_detail gd "
                        + "WHERE gd.is_active=1 and gd.is_deleted=0 "
                        + "AND gu.user_detail=" + user_detail + ")"
                        + "").list();
            }
        } catch (PersistentException ex) {
            Logger.getLogger(Group_rightBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage("List", new FacesMessage(ex.getMessage()));
            GeneralUtilities.clearsession();
        }
        return grl;
    }
    
    public int IsUserGroupsFormAccessAllowed(User_detail user_detail, List<Group_right> group_rights, int form_id, String allow) {
        //first check if user is general admin
        if (user_detail == null) {
            return 0;
        }
        //for gen admins
        if (user_detail.getIs_user_gen_admin()==1 && user_detail.getIs_active()==1) {
            return 1;
        }
        //for non-gen-admins      
        int ListItemIndex = 0;
        int ListItemNo = 0;
        try {
            ListItemNo = group_rights.size();
        } catch (NullPointerException npe) {
        }
        int IsNegativeRightSeen = 0;
        int IsPositiveRightSeen = 0;

        while (ListItemIndex < ListItemNo) {
            if (group_rights.get(ListItemIndex).getReport_form().getReport_form_id()==form_id) {
                if (allow.equals("View")) {
                    if (group_rights.get(ListItemIndex).getAllow_view()==1 && IsPositiveRightSeen == 0) {
                        IsPositiveRightSeen = 1;
                    } else if (group_rights.get(ListItemIndex).getAllow_view()==0 && IsNegativeRightSeen == 0) {
                        IsNegativeRightSeen = 1;
                    }
                } else if (allow.equals("Add")) {
                    if (group_rights.get(ListItemIndex).getAllow_add()==1 && IsPositiveRightSeen == 0) {
                        IsPositiveRightSeen = 1;
                    } else if (group_rights.get(ListItemIndex).getAllow_add()==0 && IsNegativeRightSeen == 0) {
                        IsNegativeRightSeen = 1;
                    }
                } else if (allow.equals("Edit")) {
                    if (group_rights.get(ListItemIndex).getAllow_edit()==1 && IsPositiveRightSeen == 0) {
                        IsPositiveRightSeen = 1;
                    } else if (group_rights.get(ListItemIndex).getAllow_edit()==0 && IsNegativeRightSeen == 0) {
                        IsNegativeRightSeen = 1;
                    }
                } else if (allow.equals("Delete")) {
                    if (group_rights.get(ListItemIndex).getAllow_delete()==1 && IsPositiveRightSeen == 0) {
                        IsPositiveRightSeen = 1;
                    } else if (group_rights.get(ListItemIndex).getAllow_delete()==0 && IsNegativeRightSeen == 0) {
                        IsNegativeRightSeen = 1;
                    }
                }
            }
            ListItemIndex = ListItemIndex + 1;
        }
        if (IsPositiveRightSeen == 1 && IsNegativeRightSeen == 0) {
            return 1;//Allow Function Access
        } else {
            return 0;//Dissallow Function Access
        }
    }
}

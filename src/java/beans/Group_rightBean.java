/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.EIHDMSPersistentManager;
import eihdms.Group_detail;
import eihdms.Group_right;
import eihdms.Report_form;
import eihdms.User_detail;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.LockMode;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import utilities.GeneralUtilities;

/**
 *
 * @author btwesigye
 */
@ManagedBean
@SessionScoped
public class Group_rightBean extends AbstractBean<Group_right> implements Serializable {

    private Group_detail selectedGroup_detail;
    private List<Group_right> group_rights;
    private boolean All_allow_view;
    private boolean All_allow_add;
    private boolean All_allow_edit;
    private boolean All_allow_delete;

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

    /**
     * @return the All_allow_view
     */
    public boolean isAll_allow_view() {
        return All_allow_view;
    }

    /**
     * @param All_allow_view the All_allow_view to set
     */
    public void setAll_allow_view(boolean All_allow_view) {
        this.All_allow_view = All_allow_view;
    }

    /**
     * @return the All_allow_add
     */
    public boolean isAll_allow_add() {
        return All_allow_add;
    }

    /**
     * @param All_allow_add the All_allow_add to set
     */
    public void setAll_allow_add(boolean All_allow_add) {
        this.All_allow_add = All_allow_add;
    }

    /**
     * @return the All_allow_edit
     */
    public boolean isAll_allow_edit() {
        return All_allow_edit;
    }

    /**
     * @param All_allow_edit the All_allow_edit to set
     */
    public void setAll_allow_edit(boolean All_allow_edit) {
        this.All_allow_edit = All_allow_edit;
    }

    /**
     * @return the All_allow_delete
     */
    public boolean isAll_allow_delete() {
        return All_allow_delete;
    }

    /**
     * @param All_allow_delete the All_allow_delete to set
     */
    public void setAll_allow_delete(boolean All_allow_delete) {
        this.All_allow_delete = All_allow_delete;
    }

    public void All_allow(String allow_what, boolean bool_value) {
        if (bool_value) {
            multiChangeGroupRight(allow_what, 1);
        } else {
            multiChangeGroupRight(allow_what, 0);
        }
    }

    public void multiChangeGroupRight(String allow_what, int allow_value) {
        int n = 0;
        n = this.group_rights.size();
        switch (allow_what) {
            case "view":
                for (int i = 0; i < n; i++) {
                    this.group_rights.get(i).setAllow_view(allow_value);
                }
                break;
            case "add":
                for (int i = 0; i < n; i++) {
                    this.group_rights.get(i).setAllow_add(allow_value);
                }
                break;
            case "edit":
                for (int i = 0; i < n; i++) {
                    this.group_rights.get(i).setAllow_edit(allow_value);
                }
                break;
            case "delete":
                for (int i = 0; i < n; i++) {
                    this.group_rights.get(i).setAllow_delete(allow_value);
                }
                break;
        }
    }

    public void refreshGroup_rights(Group_detail group_detail) {
        //first deselect allow all
        this.All_allow_view=false;
        this.All_allow_add=false;
        this.All_allow_edit=false;
        this.All_allow_delete=false;
        
        group_rights = new ArrayList<Group_right>();
        List<Report_form> report_forms = new ArrayList<>();
        report_forms = new Report_formBean().getTsActive();
        int n = 0;
        n = report_forms.size();
        for (int i = 0; i < n; i++) {
            Group_right group_right = null;
            try {
                group_right = Group_right.loadGroup_rightByQuery("report_form_id=" + report_forms.get(i).getReport_form_id() + " and group_detail_id=" + group_detail.getGroup_detail_id(), null, LockMode.NONE);
                //group_right=(Group_right) Group_right.queryGroup_right("report_form_id=" + report_forms.get(i).getReport_form_id() + " and group_detail_id=" + group_detail.getGroup_detail_id(), null).get(0);
            } catch (PersistentException | IndexOutOfBoundsException | NullPointerException ex) {
                group_right = null;
                Logger.getLogger(Group_rightBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (group_right == null) {
                group_right = new Group_right();
                group_right.setGroup_detail(group_detail);
                group_right.setReport_form(report_forms.get(i));
                group_right.setAllow_add(0);
                group_right.setAllow_view(0);
                group_right.setAllow_edit(0);
                group_right.setAllow_delete(0);
            }
            group_rights.add(group_right);
        }
    }

    public void saveGroup_rights() {
        try {
            if (!this.group_rights.isEmpty()) {
                PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                for (Group_right gr : this.group_rights) {
                    gr.setIs_active(1);
                    gr.setAdd_date(new Timestamp(new Date().getTime()));
                    gr.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
                    gr.setIs_deleted(0);
                    gr.save();
                }
                transaction.commit();
                loginBean.saveMessage();
            }
        } catch (PersistentException ex) {
            Logger.getLogger(Group_rightBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Group_right> getActiveGroup_rightListByUser(User_detail user_detail) {
        List<Group_right> grl = new ArrayList<Group_right>();
        try {
            grl = null;
            if (user_detail == null || user_detail.getIs_active() == 0 || user_detail.getIs_deleted() == 1 || user_detail.getIs_user_gen_admin() == 1) {
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
        if (user_detail.getIs_user_gen_admin() == 1 && user_detail.getIs_active() == 1) {
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
            if (group_rights.get(ListItemIndex).getReport_form().getReport_form_id() == form_id) {
                if (allow.equals("View")) {
                    if (group_rights.get(ListItemIndex).getAllow_view() == 1 && IsPositiveRightSeen == 0) {
                        IsPositiveRightSeen = 1;
                    } else if (group_rights.get(ListItemIndex).getAllow_view() == 0 && IsNegativeRightSeen == 0) {
                        IsNegativeRightSeen = 1;
                    }
                } else if (allow.equals("Add")) {
                    if (group_rights.get(ListItemIndex).getAllow_add() == 1 && IsPositiveRightSeen == 0) {
                        IsPositiveRightSeen = 1;
                    } else if (group_rights.get(ListItemIndex).getAllow_add() == 0 && IsNegativeRightSeen == 0) {
                        IsNegativeRightSeen = 1;
                    }
                } else if (allow.equals("Edit")) {
                    if (group_rights.get(ListItemIndex).getAllow_edit() == 1 && IsPositiveRightSeen == 0) {
                        IsPositiveRightSeen = 1;
                    } else if (group_rights.get(ListItemIndex).getAllow_edit() == 0 && IsNegativeRightSeen == 0) {
                        IsNegativeRightSeen = 1;
                    }
                } else if (allow.equals("Delete")) {
                    if (group_rights.get(ListItemIndex).getAllow_delete() == 1 && IsPositiveRightSeen == 0) {
                        IsPositiveRightSeen = 1;
                    } else if (group_rights.get(ListItemIndex).getAllow_delete() == 0 && IsNegativeRightSeen == 0) {
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

    /**
     * @return the selectedGroup_detail
     */
    public Group_detail getSelectedGroup_detail() {
        return selectedGroup_detail;
    }

    /**
     * @param selectedGroup_detail the selectedGroup_detail to set
     */
    public void setSelectedGroup_detail(Group_detail selectedGroup_detail) {
        this.selectedGroup_detail = selectedGroup_detail;
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

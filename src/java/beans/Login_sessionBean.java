/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import eihdms.Region;
import eihdms.Login_session;
import eihdms.EIHDMSPersistentManager;
import eihdms.Region;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;
import org.orm.PersistentException;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class Login_sessionBean extends AbstractBean<Login_session> implements Serializable {

    public Login_sessionBean() {
        super(Login_session.class);
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

    public List<Login_session> getActiveLoginSessions() {
        List<Login_session> lss = new ArrayList<>();
        try {
            if (this.getEntityClass() != null) {
                lss = (List<Login_session>) EIHDMSPersistentManager.instance().getSession().createQuery("select l FROM Login_session l where is_deleted=0").list();
            } else {
                lss = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lss;
    }

    public void deleteOldUnloggedOutSessions() {
        String sql = "{call sp_delete_login_session_unlogged_out(?)}";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, loginBean.getUser_detail().getUser_detail_id());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteLoggedInSessionId(int user_id, String session_id) {
        String sql = "{call sp_delete_login_session_id(?,?)}";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, user_id);
            ps.setString(2, session_id);
            ps.executeUpdate();
        } catch (Exception ex) {
            // System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import configurations.ConfigurationsFileBean;
import connections.DBConnection;
import eihdms.App_db_user_map;
import eihdms.EIHDMSPersistentManager;
import eihdms.ForgotPassword;
import eihdms.Group_right;
import eihdms.Login_session;
import eihdms.User_detail;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.joda.time.DateTime;
import org.orm.PersistentException;
import org.orm.PersistentManager;
import org.orm.PersistentTransaction;
import utilities.EIHDMSPersistentManager2;
import utilities.GeneralUtilities;
import utilities.Security;
import utilities.SendMail;

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
    private String login_session_id;
    private PersistentManager _instance;
    private App_db_user_map app_db_user_map;

    private String newpassword;
    private String retypenewpassword;
    private int verificationcode;

    public int getVerificationcode() {
        return verificationcode;
    }

    public void setVerificationcode(int verificationcode) {
        this.verificationcode = verificationcode;
    }

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

    public PersistentManager getInstance() {
        return _instance;
    }

    public void setInstance(PersistentManager _instance) {
        this._instance = _instance;
    }

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

    //returns a list (1,2,3,4,...) of report form IDs for the current looged user given the allow_add,etc
    public String getUser_report_form_str(String allow) {
        String report_form_str = "";
        for (int i = 0; i < this.getGroup_rights().size(); i++) {
            switch (allow) {
                case "allow_view":
                    if (this.getGroup_rights().get(i).getAllow_view() == 1) {
                        if (report_form_str.length() > 0) {
                            report_form_str = report_form_str + "," + this.getGroup_rights().get(i).getReport_form().getReport_form_id();
                        } else {
                            report_form_str = "" + this.getGroup_rights().get(i).getReport_form().getReport_form_id();
                        }
                    }
                    break;
                case "allow_add":
                    if (this.getGroup_rights().get(i).getAllow_add() == 1) {
                        if (report_form_str.length() > 0) {
                            report_form_str = report_form_str + "," + this.getGroup_rights().get(i).getReport_form().getReport_form_id();
                        } else {
                            report_form_str = "" + this.getGroup_rights().get(i).getReport_form().getReport_form_id();
                        }
                    }
                    break;
                case "allow_edit":
                    if (this.getGroup_rights().get(i).getAllow_edit() == 1) {
                        if (report_form_str.length() > 0) {
                            report_form_str = report_form_str + "," + this.getGroup_rights().get(i).getReport_form().getReport_form_id();
                        } else {
                            report_form_str = "" + this.getGroup_rights().get(i).getReport_form().getReport_form_id();
                        }
                    }
                    break;
                case "allow_delete":
                    if (this.getGroup_rights().get(i).getAllow_delete() == 1) {
                        if (report_form_str.length() > 0) {
                            report_form_str = report_form_str + "," + this.getGroup_rights().get(i).getReport_form().getReport_form_id();
                        } else {
                            report_form_str = "" + this.getGroup_rights().get(i).getReport_form().getReport_form_id();
                        }
                    }
                    break;
            }
        }
        return report_form_str;
    }

    public void login() {
        user_detail = null;
        setIsloggedin(false);
        try {
            user_detail = User_detail.loadUser_detailByQuery("is_deleted=0 and is_active=1 and user_name='" + username + "'", null);
        } catch (PersistentException ex) {
            GeneralUtilities.clearsession();
            Logger.getLogger(NavigationBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            GeneralUtilities.clearsession();
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

            try {
                //get app_db_user_map
                app_db_user_map = (App_db_user_map) App_db_user_map.queryApp_db_user_map("user_detail_id=" + user_detail.getUser_detail_id(), null).get(0);
            } catch (Exception ex) {
                app_db_user_map = null;
                //Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            }

            //create seesion
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpSession httpSession = request.getSession(true);

            //first delete all un-logged out sessions of this user that are older than 12 hours
            new Login_sessionBean().deleteOldUnloggedOutSessions(user_detail.getUser_detail_id());
            //---------------add login session to the session database---
            Login_session ls = new Login_session();
            ls.setUser_detail(user_detail);
            ls.setSession_id(FacesContext.getCurrentInstance().getExternalContext().getSessionId(false));
            login_session_id = ls.getSession_id();
            String aRemoteIp = "";
            String aRemoteHost = "";
            String aRemoteUser = "";
            aRemoteIp = request.getHeader("X-FORWARDED-FOR");
            if (aRemoteIp == null) {
                aRemoteIp = request.getRemoteAddr();
            }
            ls.setRemote_ip(aRemoteIp);
            try {
                aRemoteHost = request.getRemoteHost();
                if (aRemoteHost == null) {
                    aRemoteHost = "";
                }
            } catch (NullPointerException npe) {
                aRemoteHost = "";
            }
            ls.setRemote_host(aRemoteHost);
            try {
                aRemoteUser = request.getRemoteUser();
                if (aRemoteUser == null) {
                    aRemoteUser = "";
                }
            } catch (NullPointerException npe) {
                aRemoteUser = "";
            }
            ls.setRemote_user(aRemoteUser);

            Login_sessionBean lsb = new Login_sessionBean();
            lsb.setSelected(ls);
            lsb.save(user_detail.getUser_detail_id());

            try {
                _instance = new EIHDMSPersistentManager2();
            } catch (PersistentException ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            //FacesContext fc = FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
            nav.performNavigation("home?faces-redirect=true");
        } else {
            messageString = "Invalid Login Details Submitted!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("EIHDMS Login Failure", messageString));
            //return "login?faces-redirect=true";
        }
    }

    public Connection getMySQLConnection() {
        Connection conn = null;
        try {
            Class.forName(DBConnection.getMySQL_JDBC_DRIVER());
            if (app_db_user_map == null) {
                conn = DriverManager.getConnection(DBConnection.getMySQL_DB_URL(), DBConnection.getMySQL_USER(), DBConnection.getMySQL_PASSWORD());
            } else {
                conn = DriverManager.getConnection(DBConnection.getMySQL_DB_URL(), app_db_user_map.getDb_user(), Security.Decrypt(app_db_user_map.getDb_password()));
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return conn;
    }

    public Connection getMySQLConnection_System_User() {
//        try {
//            ConfigurationsFileBean.readConfigurationsFile();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            if (app_db_user_map == null) {
            //conn = DriverManager.getConnection(DBConnection.getMySQL_DB_URL(), DBConnection.getMySQL_USER(), DBConnection.getMySQL_PASSWORD());
            conn = DriverManager.getConnection("jdbc:mysql://localhost/eihdms", "eihdms_u1", "eihdms_u1");
//            } else {
            //conn = DriverManager.getConnection(DBConnection.getMySQL_DB_URL(), app_db_user_map.getDb_user(), Security.Decrypt(app_db_user_map.getDb_password()));
            //}
        } catch (ClassNotFoundException | SQLException e) {
        }
        return conn;
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
        new Login_sessionBean().deleteLoggedInSessionId(this.user_detail.getUser_detail_id(), this.login_session_id);
        setUsername("");
        setPassword("");
        setIsloggedin(false);
        prelogout();
        try {
            //_instance.getSession().close();
            _instance.disposePersistentManager();
        } catch (PersistentException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void Error(String error) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Error", error));
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

    /**
     * @return the login_session_id
     */
    public String getLogin_session_id() {
        return login_session_id;
    }

    /**
     * @param login_session_id the login_session_id to set
     */
    public void setLogin_session_id(String login_session_id) {
        this.login_session_id = login_session_id;
    }

    /**
     * @return the app_db_user_map
     */
    public App_db_user_map getApp_db_user_map() {
        return app_db_user_map;
    }

    /**
     * @param app_db_user_map the app_db_user_map to set
     */
    public void setApp_db_user_map(App_db_user_map app_db_user_map) {
        this.app_db_user_map = app_db_user_map;
    }

    public void send_verification_code(String username_forgot_password) throws FileNotFoundException {
        try {
            User_detail user2 = User_detail.loadUser_detailByQuery("user_name='" + username_forgot_password + "'", null);
            if (user2 != null) {
                PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                Random rand = new Random();
                int value = rand.nextInt(1000);
                ForgotPassword forgotPassword = new ForgotPassword();
                DateTime dateTime = new DateTime(new Date());
                dateTime.plusDays(1).toDate();
                forgotPassword.setExpirydate(new Timestamp(dateTime.plusDays(1).toDate().getTime()));
                forgotPassword.setCode(value + 3000);
                forgotPassword.setUser_detail(user2);
                forgotPassword.save();
                transaction.commit();
                SendMail sendMail = new SendMail(user2.getEmail_address(), "EIHDMS System Password Change", "Dear " + user2.getEmail_address() + ",\n\n Kindly use the Verification Code: " + forgotPassword.getCode() + " to change your password");
                sendMail.send();
                //LogFile.write_log(getClientComputerName(getClientIp(request)), getClientIp(request), "VERIFICATION CODE", username, "Verification Code Sent Successfully!");
                messageString = "Kindly check your email a verification code has been sent!";
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Please check your email for the verification code!", "Please check your email for the verification code!"));
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Username!", "Invalid Username!"));
            }
        } catch (PersistentException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String forgotpassword() {
        //user = null;
        //setIsloggedin(false);
        try {
            User_detail user2 = User_detail.loadUser_detailByQuery("user_name='" + username + "'", null);
            if (user2 != null) {
                List<ForgotPassword> forgotPasswords = ForgotPassword.queryForgotPassword("user_detail_id=" + user2.getUser_detail_id() + " and code=" + verificationcode + " and expirydate>='" + GeneralUtilities.simpleDateFormatDate2().format(new Date()) + "'", null);
                if (forgotPasswords.size() > 0) {
                    if (!newpassword.equals(retypenewpassword)) {
                        messageString = "New Password does not match with Re-entered Password!";
                        action = "forgotpassword";
                        return "login?faces-redirect=true";
                    }
                    if (newpassword.length() < 6) {
                        messageString = "New Password should be atleast 6 characters";
                        action = "forgotpassword";
                        return "login?faces-redirect=true";
                    }
                    try {
                        PersistentTransaction t = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                        user2.setUser_password(Security.Encrypt(newpassword));
                        user2.setLast_edit_by(user2.getUser_detail_id());
                        user2.setLast_edit_date(new Timestamp(new Date().getTime()));
                        EIHDMSPersistentManager.instance().getSession().merge(user2);
                        t.commit();
                    } catch (PersistentException ex) {
                        Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    messageString = "";
                    action = "login";
                    setUsername("");
                    setPassword("");
                    setIsloggedin(false);
                    prelogout();
                    messageString = "Password changed successfuly!";
                    return "login?faces-redirect=true";
                } else {
                    messageString = "Invalid Code!";
                    action = "forgotpassword";
                    return "login?faces-redirect=true";
                }
            }
        } catch (PersistentException ex) {
            Logger.getLogger(NavigationBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        messageString = "Invalid Username or Password!";
        action = "forgotpassword";
        return "forgotpassword?faces-redirect=true";
    }

    public String changepassword() {
        user_detail = null;
        //setIsloggedin(false);
        try {
            user_detail = User_detail.loadUser_detailByQuery("user_name='" + username + "'", null);
        } catch (PersistentException ex) {
            Logger.getLogger(NavigationBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (user_detail != null) {
            if (!newpassword.equals(retypenewpassword)) {
//                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation", "New Password does not match with Re-entered Password!");
//                RequestContext.getCurrentInstance().showMessageInDialog(message);
                messageString = "New Password does not match with Re-entered Password!";
                action = "changepw";
                return "login?faces-redirect=true";
            }
            if (newpassword.length() < 6) {
//                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation", "Please enter the Contact Name!");
//                RequestContext.getCurrentInstance().showMessageInDialog(message);
                messageString = "New Password should be atleast 6 characters";
                action = "changepw";
                return "login?faces-redirect=true";
            }

            if (!Security.Decrypt(user_detail.getUser_password()).equals(password)) {
                messageString = "Invalid Username or Password!";
                action = "changepw";
                return "login?faces-redirect=true";
            }

            try {
                PersistentTransaction t = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                user_detail.setUser_password(Security.Encrypt(newpassword));
                user_detail.setLast_edit_by(user_detail.getUser_detail_id());
                user_detail.setLast_edit_date(new Timestamp(new Date().getTime()));
                EIHDMSPersistentManager.instance().getSession().merge(user_detail);
                t.commit();
            } catch (PersistentException ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            messageString = "";
            action = "login";
            setUsername("");
            setPassword("");
            setIsloggedin(false);
            user_detail = null;
            prelogout();
            return "login?faces-redirect=true";
        } else {
            messageString = "Invalid Username or Password!";
            action = "changepw";
            return "login?faces-redirect=true";
        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.FileNotFoundException;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class GlobalSettingsBean {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of GlobalSettingsBean
     */
    public GlobalSettingsBean() {
    }

    public static void readConnectionConfigurations() throws FileNotFoundException {
        ResourceBundle properties = ResourceBundle.getBundle("configs.ConfigFile");
        GlobalSettingsBean.setEMAIL_HOST(properties.getString("EMAIL_HOST"));
        GlobalSettingsBean.setEMAIL_PORT(properties.getString("EMAIL_PORT"));
        GlobalSettingsBean.setEMAIL_USERNAME(properties.getString("EMAIL_USERNAME"));
        GlobalSettingsBean.setEMAIL_PASSWORD(properties.getString("EMAIL_PASSWORD"));
    }
    private static String EMAIL_PORT;
    private static String EMAIL_HOST;
    private static String EMAIL_PASSWORD;
    private static String EMAIL_USERNAME;

    public static String getEMAIL_PASSWORD() {
        return EMAIL_PASSWORD;
    }

    public static void setEMAIL_PASSWORD(String EMAIL_PASSWORD) {
        GlobalSettingsBean.EMAIL_PASSWORD = EMAIL_PASSWORD;
    }

    public static String getEMAIL_USERNAME() {
        return EMAIL_USERNAME;
    }

    public static void setEMAIL_USERNAME(String EMAIL_USERNAME) {
        GlobalSettingsBean.EMAIL_USERNAME = EMAIL_USERNAME;
    }

    public static String getEMAIL_HOST() {
        return EMAIL_HOST;
    }

    public static void setEMAIL_HOST(String EMAIL_HOST) {
        GlobalSettingsBean.EMAIL_HOST = EMAIL_HOST;
    }

    public static String getEMAIL_PORT() {
        return EMAIL_PORT;
    }

    public static void setEMAIL_PORT(String EMAIL_PORT) {
        GlobalSettingsBean.EMAIL_PORT = EMAIL_PORT;
    }
}

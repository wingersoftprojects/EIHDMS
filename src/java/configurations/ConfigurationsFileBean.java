/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurations;

import connections.DBConnection;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author btwesigye
 */
@ManagedBean
@SessionScoped
public class ConfigurationsFileBean implements Serializable{
    private static final long serialVersionUID = 1L;

    private static String HOST;
    private static String DATABASE;
    private static String USER;
    private static String PASSWORD;
    private static String DOCROOT;
    private static String DOCROOT_CONVERT;

    /**
     * Creates a new instance of GlobalSettingsBean
     */
    public ConfigurationsFileBean() {
    }
    
     public static void readConfigurationsFile() throws FileNotFoundException {
        ResourceBundle properties = ResourceBundle.getBundle("configurations.ConfigurationsFile");
        ConfigurationsFileBean.setHOST(properties.getString("HOST"));
        ConfigurationsFileBean.setDATABASE(properties.getString("DATABASE"));
        ConfigurationsFileBean.setUSER(properties.getString("USER"));
        ConfigurationsFileBean.setPASSWORD(properties.getString("PASSWORD"));
        ConfigurationsFileBean.setDOCROOT(properties.getString("DOCROOT"));
        ConfigurationsFileBean.setDOCROOT_CONVERT(properties.getString("DOCROOT_CONVERT"));
        DBConnection.setMySQL_DB_HOST_IP_OR_NAME(ConfigurationsFileBean.getHOST());
        DBConnection.setMySQL_DB_NAME(ConfigurationsFileBean.getDATABASE());
        DBConnection.setMySQL_USER(ConfigurationsFileBean.getUSER());
        DBConnection.setMySQL_PASSWORD(ConfigurationsFileBean.getPASSWORD());
    }
     
     /**
     * @return the DOCROOT_CONVERT
     */
    public static String getDOCROOT_CONVERT() {
        return DOCROOT_CONVERT;
    }

    /**
     * @param aDOCROOT_CONVERT the DOCROOT_CONVERT to set
     */
    public static void setDOCROOT_CONVERT(String aDOCROOT_CONVERT) {
        DOCROOT_CONVERT = aDOCROOT_CONVERT;
    }

    /**
     * @return the HOST
     */
    public static String getHOST() {
        return HOST;
    }

    /**
     * @param aHOST the HOST to set
     */
    public static void setHOST(String aHOST) {
        HOST = aHOST;
    }

    /**
     * @return the DATABASE
     */
    public static String getDATABASE() {
        return DATABASE;
    }

    /**
     * @param aDATABASE the DATABASE to set
     */
    public static void setDATABASE(String aDATABASE) {
        DATABASE = aDATABASE;
    }

    /**
     * @return the USER
     */
    public static String getUSER() {
        return USER;
    }

    /**
     * @param aUSER the USER to set
     */
    public static void setUSER(String aUSER) {
        USER = aUSER;
    }

    /**
     * @return the PASSWORD
     */
    public static String getPASSWORD() {
        return PASSWORD;
    }

    /**
     * @param aPASSWORD the PASSWORD to set
     */
    public static void setPASSWORD(String aPASSWORD) {
        PASSWORD = aPASSWORD;
    }

    /**
     * @return the DOCROOT
     */
    public static String getDOCROOT() {
        return DOCROOT;
    }

    /**
     * @param aDOCROOT the DOCROOT to set
     */
    public static void setDOCROOT(String aDOCROOT) {
        DOCROOT = aDOCROOT;
    }

}

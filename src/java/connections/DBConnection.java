package connections;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DBConnection implements Serializable {

    private static final long serialVersionUID = 1L;

    private static String MySQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String MySQL_DB_HOST_IP_OR_NAME = "";
    private static String MySQL_DB_NAME = "";
    private static String MySQL_DB_URL = "";
    private static String MySQL_USER = "";
    private static String MySQL_PASSWORD = "";
    private static Connection MySQL_Conn;

    public static Connection getMySQLConnection(){
        try {
            Class.forName(getMySQL_JDBC_DRIVER());
            DBConnection.setMySQL_DB_URL("jdbc:mysql://" + DBConnection.getMySQL_DB_HOST_IP_OR_NAME() + "/" + DBConnection.getMySQL_DB_NAME());
            setMySQL_Conn(DriverManager.getConnection(getMySQL_DB_URL(), getMySQL_USER(), getMySQL_PASSWORD()));
        } catch (ClassNotFoundException | SQLException e) {
        }
        return getMySQL_Conn();
    }

    /**
     * @return the MySQL_JDBC_DRIVER
     */
    public static String getMySQL_JDBC_DRIVER() {
        return MySQL_JDBC_DRIVER;
    }

    /**
     * @param aMySQL_JDBC_DRIVER the MySQL_JDBC_DRIVER to set
     */
    public static void setMySQL_JDBC_DRIVER(String aMySQL_JDBC_DRIVER) {
        MySQL_JDBC_DRIVER = aMySQL_JDBC_DRIVER;
    }

    /**
     * @return the MySQL_DB_HOST_IP_OR_NAME
     */
    public static String getMySQL_DB_HOST_IP_OR_NAME() {
        return MySQL_DB_HOST_IP_OR_NAME;
    }

    /**
     * @param aMySQL_DB_HOST_IP_OR_NAME the MySQL_DB_HOST_IP_OR_NAME to set
     */
    public static void setMySQL_DB_HOST_IP_OR_NAME(String aMySQL_DB_HOST_IP_OR_NAME) {
        MySQL_DB_HOST_IP_OR_NAME = aMySQL_DB_HOST_IP_OR_NAME;
    }

    /**
     * @return the MySQL_DB_NAME
     */
    public static String getMySQL_DB_NAME() {
        return MySQL_DB_NAME;
    }

    /**
     * @param aMySQL_DB_NAME the MySQL_DB_NAME to set
     */
    public static void setMySQL_DB_NAME(String aMySQL_DB_NAME) {
        MySQL_DB_NAME = aMySQL_DB_NAME;
    }

    /**
     * @return the MySQL_DB_URL
     */
    public static String getMySQL_DB_URL() {
        return MySQL_DB_URL;
    }

    /**
     * @param aMySQL_DB_URL the MySQL_DB_URL to set
     */
    public static void setMySQL_DB_URL(String aMySQL_DB_URL) {
        MySQL_DB_URL = aMySQL_DB_URL;
    }

    /**
     * @return the MySQL_USER
     */
    public static String getMySQL_USER() {
        return MySQL_USER;
    }

    /**
     * @param aMySQL_USER the MySQL_USER to set
     */
    public static void setMySQL_USER(String aMySQL_USER) {
        MySQL_USER = aMySQL_USER;
    }

    /**
     * @return the MySQL_PASSWORD
     */
    public static String getMySQL_PASSWORD() {
        return MySQL_PASSWORD;
    }

    /**
     * @param aMySQL_PASSWORD the MySQL_PASSWORD to set
     */
    public static void setMySQL_PASSWORD(String aMySQL_PASSWORD) {
        MySQL_PASSWORD = aMySQL_PASSWORD;
    }

    /**
     * @return the MySQL_Conn
     */
    public static Connection getMySQL_Conn() {
        return MySQL_Conn;
    }

    /**
     * @param aMySQL_Conn the MySQL_Conn to set
     */
    public static void setMySQL_Conn(Connection aMySQL_Conn) {
        MySQL_Conn = aMySQL_Conn;
    }

}

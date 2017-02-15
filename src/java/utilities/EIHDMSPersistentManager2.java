/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import eihdms.*;
import java.util.Properties;
import org.hibernate.FlushMode;
import org.hibernate.cfg.Configuration;
import org.orm.PersistentException;
import org.orm.PersistentManager;
import org.orm.cfg.JDBCConnectionSetting;

/**
 *
 * @author bajuna
 */
public class EIHDMSPersistentManager2 extends PersistentManager {

    private static final String PROJECT_NAME = "Architecture";
    private static PersistentManager _instance = null;
    private static PersistentManager.SessionType _sessionType = PersistentManager.SessionType.THREAD_BASE;
    private static int _timeToAlive = 60000;
    private static JDBCConnectionSetting _connectionSetting = null;
    private static Properties _extraProperties = null;
    private static String _configurationFile = null;

    public EIHDMSPersistentManager2() throws PersistentException {
        super(_connectionSetting, _sessionType, _timeToAlive, new String[]{}, _extraProperties, _configurationFile);
        setFlushMode(FlushMode.ALWAYS);
    }

    @Override
    public Configuration createConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Region.class);
        configuration.addAnnotatedClass(District.class);
        configuration.addAnnotatedClass(Sub_district.class);
        configuration.addAnnotatedClass(County.class);
        configuration.addAnnotatedClass(Sub_county.class);
        configuration.addAnnotatedClass(Parish.class);
        configuration.addAnnotatedClass(Health_facility.class);
        configuration.addAnnotatedClass(Facility_level.class);
        configuration.addAnnotatedClass(Report_form.class);
        configuration.addAnnotatedClass(Section.class);
        configuration.addAnnotatedClass(Interface_data.class);
        configuration.addAnnotatedClass(Data_element.class);
        configuration.addAnnotatedClass(Base_data.class);
        configuration.addAnnotatedClass(Validation_rule.class);
        configuration.addAnnotatedClass(Standard_rule.class);
        configuration.addAnnotatedClass(Group_right.class);
        configuration.addAnnotatedClass(User_detail.class);
        configuration.addAnnotatedClass(Group_user.class);
        configuration.addAnnotatedClass(User_category.class);
        configuration.addAnnotatedClass(Group_detail.class);
        configuration.addAnnotatedClass(User_action.class);
        configuration.addAnnotatedClass(Technical_area.class);
        configuration.addAnnotatedClass(Sub_section.class);
        configuration.addAnnotatedClass(Report_form_group.class);
        configuration.addAnnotatedClass(Application_configuration.class);
        configuration.addAnnotatedClass(Temp_data_element.class);
        configuration.addAnnotatedClass(Temp_health_facility.class);
        configuration.addAnnotatedClass(Financial_year.class);
        configuration.addAnnotatedClass(Batch.class);
        configuration.addAnnotatedClass(Kpi.class);
        configuration.addAnnotatedClass(Data_obligation.class);
        configuration.addAnnotatedClass(Base_data_deleted.class);
        configuration.addAnnotatedClass(Login_session.class);
        configuration.addAnnotatedClass(Interface_data_temp.class);
        configuration.addAnnotatedClass(Validation_report.class);
        configuration.addAnnotatedClass(Loaded_data_summary.class);
        configuration.addAnnotatedClass(Kpi_summary_function.class);
        configuration.buildMappings();
        return configuration;
    }

    public String getProjectName() {
        return PROJECT_NAME;
    }

    public static synchronized final PersistentManager instance() throws PersistentException {
        if (_instance == null) {
            _instance = new EIHDMSPersistentManager2();
        }

        return _instance;
    }

    public void disposePersistentManager() throws PersistentException {
        _instance = null;
        super.disposePersistentManager();
    }

    public static void setSessionType(PersistentManager.SessionType sessionType) throws PersistentException {
        if (_instance != null) {
            throw new PersistentException("Cannot set session type after create PersistentManager instance");
        } else {
            _sessionType = sessionType;
        }

    }

    public static void setAppBaseSessionTimeToAlive(int timeInMs) throws PersistentException {
        if (_instance != null) {
            throw new PersistentException("Cannot set session time to alive after create PersistentManager instance");
        } else {
            _timeToAlive = timeInMs;
        }

    }

    public static void setJDBCConnectionSetting(JDBCConnectionSetting aConnectionSetting) throws PersistentException {
        if (_instance != null) {
            throw new PersistentException("Cannot set connection setting after create PersistentManager instance");
        } else {
            _connectionSetting = aConnectionSetting;
        }

    }

    public static void setHibernateProperties(Properties aProperties) throws PersistentException {
        if (_instance != null) {
            throw new PersistentException("Cannot set hibernate properties after create PersistentManager instance");
        } else {
            _extraProperties = aProperties;
        }

    }

    public static void setConfigurationFile(String aConfigurationFile) throws PersistentException {
        if (_instance != null) {
            throw new PersistentException("Cannot set configuration file after create PersistentManager instance");
        } else {
            _configurationFile = aConfigurationFile;
        }

    }

    public static void saveJDBCConnectionSetting() {
        PersistentManager.saveJDBCConnectionSetting(PROJECT_NAME, _connectionSetting);
    }
}

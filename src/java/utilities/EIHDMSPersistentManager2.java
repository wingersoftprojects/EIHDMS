/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import eihdms.*;
import java.util.Properties;
import org.hibernate.FlushMode;
import org.hibernate.boot.MetadataSources;
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
    protected void configureMetadataSources(MetadataSources aMetadataSources) {
        super.configureMetadataSources(aMetadataSources);
        aMetadataSources.addAnnotatedClass(eihdms.Group_right.class);
        aMetadataSources.addAnnotatedClass(eihdms.Region.class);
        aMetadataSources.addAnnotatedClass(eihdms.District.class);
        aMetadataSources.addAnnotatedClass(eihdms.Sub_district.class);
        aMetadataSources.addAnnotatedClass(eihdms.County.class);
        aMetadataSources.addAnnotatedClass(eihdms.Sub_county.class);
        aMetadataSources.addAnnotatedClass(eihdms.Parish.class);
        aMetadataSources.addAnnotatedClass(eihdms.Health_facility.class);
        aMetadataSources.addAnnotatedClass(eihdms.Facility_level.class);
        aMetadataSources.addAnnotatedClass(eihdms.Report_form.class);
        aMetadataSources.addAnnotatedClass(eihdms.Section.class);
        aMetadataSources.addAnnotatedClass(eihdms.Interface_data.class);
        aMetadataSources.addAnnotatedClass(eihdms.Data_element.class);
        aMetadataSources.addAnnotatedClass(eihdms.Base_data.class);
        aMetadataSources.addAnnotatedClass(eihdms.Validation_rule.class);
        aMetadataSources.addAnnotatedClass(eihdms.Standard_rule.class);
        aMetadataSources.addAnnotatedClass(eihdms.User_detail.class);
        aMetadataSources.addAnnotatedClass(eihdms.Group_user.class);
        aMetadataSources.addAnnotatedClass(eihdms.User_category.class);
        aMetadataSources.addAnnotatedClass(eihdms.Group_detail.class);
        aMetadataSources.addAnnotatedClass(eihdms.Login_session.class);
        aMetadataSources.addAnnotatedClass(eihdms.User_action.class);
        aMetadataSources.addAnnotatedClass(eihdms.Technical_area.class);
        aMetadataSources.addAnnotatedClass(eihdms.Sub_section.class);
        aMetadataSources.addAnnotatedClass(eihdms.Report_form_group.class);
        aMetadataSources.addAnnotatedClass(eihdms.Application_configuration.class);
        aMetadataSources.addAnnotatedClass(eihdms.Temp_data_element.class);
        aMetadataSources.addAnnotatedClass(eihdms.Temp_health_facility.class);
        aMetadataSources.addAnnotatedClass(eihdms.Financial_year.class);
        aMetadataSources.addAnnotatedClass(eihdms.Batch.class);
        aMetadataSources.addAnnotatedClass(eihdms.Kpi.class);
        aMetadataSources.addAnnotatedClass(eihdms.Data_obligation.class);
        aMetadataSources.addAnnotatedClass(eihdms.Base_data_deleted.class);
        aMetadataSources.addAnnotatedClass(eihdms.Interface_data_temp.class);
        aMetadataSources.addAnnotatedClass(eihdms.Validation_report.class);
        aMetadataSources.addAnnotatedClass(eihdms.Loaded_data_summary.class);
        aMetadataSources.addAnnotatedClass(eihdms.App_db_user_map.class);
        aMetadataSources.addAnnotatedClass(eihdms.Kpi_summary_function.class);
        aMetadataSources.addAnnotatedClass(eihdms.Interface_data_sms.class);
        aMetadataSources.addAnnotatedClass(eihdms.Phone_contact.class);
        aMetadataSources.addAnnotatedClass(eihdms.Data_element_sms_position.class);
        aMetadataSources.addAnnotatedClass(eihdms.Report_form_short_code.class);
        aMetadataSources.addAnnotatedClass(eihdms.Organisation.class);
        aMetadataSources.addAnnotatedClass(eihdms.Access_scope.class);
        aMetadataSources.addAnnotatedClass(eihdms.Report_form_update.class);
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

/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Ajuna Newton Brian
 * License Type: Purchased
 */
package eihdms;

import org.orm.*;
import org.orm.cfg.JDBCConnectionSetting;
import org.hibernate.*;
import java.util.Properties;
import org.hibernate.cfg.*;

public class EIHDMSPersistentManager extends PersistentManager {
	private static final String PROJECT_NAME = "Architecture";
	private static PersistentManager _instance = null;
	private static SessionType _sessionType = SessionType.THREAD_BASE;
	private static int _timeToAlive = 60000;
	private static JDBCConnectionSetting _connectionSetting = null;
	private static Properties _extraProperties = null;
	private static String _configurationFile = null;
	
	private EIHDMSPersistentManager() throws PersistentException {
		super(_connectionSetting, _sessionType, _timeToAlive, new String[] {}, _extraProperties, _configurationFile);
		setFlushMode(FlushMode.ALWAYS);
	}
	
	@Override
	public Configuration createConfiguration() {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(eihdms.Group_right.class);
		configuration.addAnnotatedClass(eihdms.Region.class);
		configuration.addAnnotatedClass(eihdms.District.class);
		configuration.addAnnotatedClass(eihdms.Sub_district.class);
		configuration.addAnnotatedClass(eihdms.County.class);
		configuration.addAnnotatedClass(eihdms.Sub_county.class);
		configuration.addAnnotatedClass(eihdms.Parish.class);
		configuration.addAnnotatedClass(eihdms.Health_facility.class);
		configuration.addAnnotatedClass(eihdms.Facility_level.class);
		configuration.addAnnotatedClass(eihdms.Report_form.class);
		configuration.addAnnotatedClass(eihdms.Section.class);
		configuration.addAnnotatedClass(eihdms.Interface_data.class);
		configuration.addAnnotatedClass(eihdms.Data_element.class);
		configuration.addAnnotatedClass(eihdms.Base_data.class);
		configuration.addAnnotatedClass(eihdms.Validation_rule.class);
		configuration.addAnnotatedClass(eihdms.Standard_rule.class);
		configuration.addAnnotatedClass(eihdms.User_detail.class);
		configuration.addAnnotatedClass(eihdms.Group_user.class);
		configuration.addAnnotatedClass(eihdms.User_category.class);
		configuration.addAnnotatedClass(eihdms.Group_detail.class);
		configuration.addAnnotatedClass(eihdms.Login_session.class);
		configuration.addAnnotatedClass(eihdms.User_action.class);
		configuration.addAnnotatedClass(eihdms.Technical_area.class);
		configuration.addAnnotatedClass(eihdms.Sub_section.class);
		configuration.addAnnotatedClass(eihdms.Report_form_group.class);
		configuration.addAnnotatedClass(eihdms.Application_configuration.class);
		configuration.addAnnotatedClass(eihdms.Temp_data_element.class);
		configuration.addAnnotatedClass(eihdms.Temp_health_facility.class);
		configuration.addAnnotatedClass(eihdms.Financial_year.class);
		configuration.addAnnotatedClass(eihdms.Batch.class);
		configuration.addAnnotatedClass(eihdms.Kpi.class);
		configuration.addAnnotatedClass(eihdms.Data_obligation.class);
		configuration.addAnnotatedClass(eihdms.Base_data_deleted.class);
		configuration.addAnnotatedClass(eihdms.Interface_data_temp.class);
		configuration.addAnnotatedClass(eihdms.Validation_report.class);
		configuration.addAnnotatedClass(eihdms.Loaded_data_summary.class);
		configuration.addAnnotatedClass(eihdms.App_db_user_map.class);
		configuration.addAnnotatedClass(eihdms.Kpi_summary_function.class);
		configuration.addAnnotatedClass(eihdms.Interface_data_sms.class);
		configuration.addAnnotatedClass(eihdms.Phone_contact.class);
		configuration.addAnnotatedClass(eihdms.Data_element_sms_position.class);
		configuration.addAnnotatedClass(eihdms.Report_form_short_code.class);
		configuration.addAnnotatedClass(eihdms.Organisation.class);
		configuration.addAnnotatedClass(eihdms.Access_scope.class);
		configuration.buildMappings();
		return configuration;
	}
	
	public String getProjectName() {
		return PROJECT_NAME;
	}
	
	public static synchronized final PersistentManager instance() throws PersistentException {
		if (_instance == null) {
			_instance = new EIHDMSPersistentManager();
		}
		
		return _instance;
	}
	
	public void disposePersistentManager() throws PersistentException {
		_instance = null;
		super.disposePersistentManager();
	}
	
	public static void setSessionType(SessionType sessionType) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set session type after create PersistentManager instance");
		}
		else {
			_sessionType = sessionType;
		}
		
	}
	
	public static void setAppBaseSessionTimeToAlive(int timeInMs) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set session time to alive after create PersistentManager instance");
		}
		else {
			_timeToAlive = timeInMs;
		}
		
	}
	
	public static void setJDBCConnectionSetting(JDBCConnectionSetting aConnectionSetting) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set connection setting after create PersistentManager instance");
		}
		else {
			_connectionSetting = aConnectionSetting;
		}
		
	}
	
	public static void setHibernateProperties(Properties aProperties) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set hibernate properties after create PersistentManager instance");
		}
		else {
			_extraProperties = aProperties;
		}
		
	}
	
	public static void setConfigurationFile(String aConfigurationFile) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set configuration file after create PersistentManager instance");
		}
		else {
			_configurationFile = aConfigurationFile;
		}
		
	}
	
	public static void saveJDBCConnectionSetting() {
		PersistentManager.saveJDBCConnectionSetting(PROJECT_NAME, _connectionSetting);
	}
}

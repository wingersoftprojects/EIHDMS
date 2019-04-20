/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: rlumala
 * License Type: Purchased
 */
package eihdms;

import org.orm.*;
import org.orm.cfg.JDBCConnectionSetting;
import org.hibernate.*;
import java.util.Properties;
import org.hibernate.cfg.*;
import org.hibernate.boot.MetadataSources;

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
	protected void configureMetadataSources(MetadataSources aMetadataSources) {
		super.configureMetadataSources(aMetadataSources);
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
		aMetadataSources.addAnnotatedClass(eihdms.Group_right.class);
		aMetadataSources.addAnnotatedClass(eihdms.Report_form_deadline.class);
		aMetadataSources.addAnnotatedClass(eihdms.Report_form_entity.class);
		aMetadataSources.addAnnotatedClass(eihdms.Deadline_extension.class);
		aMetadataSources.addAnnotatedClass(eihdms.Sms_schedule.class);
		aMetadataSources.addAnnotatedClass(eihdms.Sent_sms_log.class);
		aMetadataSources.addAnnotatedClass(eihdms.Sms_recipient.class);
		aMetadataSources.addAnnotatedClass(eihdms.Interface_data_mob_app.class);
		aMetadataSources.addAnnotatedClass(eihdms.Batch_mob_app.class);
		aMetadataSources.addAnnotatedClass(eihdms.Dashboard_surge.class);
		aMetadataSources.addAnnotatedClass(eihdms.Deadline_reminder.class);
		aMetadataSources.addAnnotatedClass(eihdms.Report_period_week.class);
		aMetadataSources.addAnnotatedClass(eihdms.Sms_category.class);
		aMetadataSources.addAnnotatedClass(eihdms.Sub_section_cell.class);
		aMetadataSources.addAnnotatedClass(eihdms.Report_form_entity_count.class);
		aMetadataSources.addAnnotatedClass(eihdms.Report_form_group.class);
		aMetadataSources.addAnnotatedClass(eihdms.ForgotPassword.class);
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

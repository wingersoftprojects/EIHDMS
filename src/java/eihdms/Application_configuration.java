/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Kiyingi Simon Peter
 * License Type: Purchased
 */
package eihdms;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="application_configuration")
public class Application_configuration implements Serializable {
	public Application_configuration() {
	}
	
	public static Application_configuration loadApplication_configurationByORMID(int application_configuration_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadApplication_configurationByORMID(session, application_configuration_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application_configuration getApplication_configurationByORMID(int application_configuration_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getApplication_configurationByORMID(session, application_configuration_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application_configuration loadApplication_configurationByORMID(int application_configuration_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadApplication_configurationByORMID(session, application_configuration_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application_configuration getApplication_configurationByORMID(int application_configuration_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getApplication_configurationByORMID(session, application_configuration_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application_configuration loadApplication_configurationByORMID(PersistentSession session, int application_configuration_id) throws PersistentException {
		try {
			return (Application_configuration) session.load(eihdms.Application_configuration.class, new Integer(application_configuration_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application_configuration getApplication_configurationByORMID(PersistentSession session, int application_configuration_id) throws PersistentException {
		try {
			return (Application_configuration) session.get(eihdms.Application_configuration.class, new Integer(application_configuration_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application_configuration loadApplication_configurationByORMID(PersistentSession session, int application_configuration_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Application_configuration) session.load(eihdms.Application_configuration.class, new Integer(application_configuration_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application_configuration getApplication_configurationByORMID(PersistentSession session, int application_configuration_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Application_configuration) session.get(eihdms.Application_configuration.class, new Integer(application_configuration_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryApplication_configuration(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryApplication_configuration(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryApplication_configuration(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryApplication_configuration(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application_configuration[] listApplication_configurationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listApplication_configurationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application_configuration[] listApplication_configurationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listApplication_configurationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryApplication_configuration(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Application_configuration as Application_configuration");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryApplication_configuration(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Application_configuration as Application_configuration");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Application_configuration", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application_configuration[] listApplication_configurationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryApplication_configuration(session, condition, orderBy);
			return (Application_configuration[]) list.toArray(new Application_configuration[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application_configuration[] listApplication_configurationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryApplication_configuration(session, condition, orderBy, lockMode);
			return (Application_configuration[]) list.toArray(new Application_configuration[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application_configuration loadApplication_configurationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadApplication_configurationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application_configuration loadApplication_configurationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadApplication_configurationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application_configuration loadApplication_configurationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Application_configuration[] application_configurations = listApplication_configurationByQuery(session, condition, orderBy);
		if (application_configurations != null && application_configurations.length > 0)
			return application_configurations[0];
		else
			return null;
	}
	
	public static Application_configuration loadApplication_configurationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Application_configuration[] application_configurations = listApplication_configurationByQuery(session, condition, orderBy, lockMode);
		if (application_configurations != null && application_configurations.length > 0)
			return application_configurations[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateApplication_configurationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateApplication_configurationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateApplication_configurationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateApplication_configurationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateApplication_configurationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Application_configuration as Application_configuration");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateApplication_configurationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Application_configuration as Application_configuration");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Application_configuration", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Application_configuration loadApplication_configurationByCriteria(Application_configurationCriteria application_configurationCriteria) {
		Application_configuration[] application_configurations = listApplication_configurationByCriteria(application_configurationCriteria);
		if(application_configurations == null || application_configurations.length == 0) {
			return null;
		}
		return application_configurations[0];
	}
	
	public static Application_configuration[] listApplication_configurationByCriteria(Application_configurationCriteria application_configurationCriteria) {
		return application_configurationCriteria.listApplication_configuration();
	}
	
	public static Application_configuration createApplication_configuration() {
		return new eihdms.Application_configuration();
	}
	
	public boolean save() throws PersistentException {
		try {
			eihdms.EIHDMSPersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			eihdms.EIHDMSPersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			eihdms.EIHDMSPersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			eihdms.EIHDMSPersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	@Column(name="application_configuration_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_APPLICATION_CONFIGURATION_APPLICATION_CONFIGURATION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_APPLICATION_CONFIGURATION_APPLICATION_CONFIGURATION_ID_GENERATOR", strategy="native")	
	private int application_configuration_id;
	
	@Column(name="parameter_name", nullable=false, length=100)	
	private String parameter_name;
	
	@Column(name="parameter_value", nullable=false, length=100)	
	private String parameter_value;
	
	@Column(name="is_deleted", nullable=false, length=1)	
	private int is_deleted;
	
	@Column(name="is_active", nullable=false, length=1)	
	private int is_active;
	
	@Column(name="add_date", nullable=true)	
	private java.sql.Timestamp add_date;
	
	@Column(name="add_by", nullable=true, length=10)	
	private Integer add_by;
	
	@Column(name="last_edit_date", nullable=true)	
	private java.sql.Timestamp last_edit_date;
	
	@Column(name="last_edit_by", nullable=true, length=10)	
	private Integer last_edit_by;
	
	private void setApplication_configuration_id(int value) {
		this.application_configuration_id = value;
	}
	
	public int getApplication_configuration_id() {
		return application_configuration_id;
	}
	
	public int getORMID() {
		return getApplication_configuration_id();
	}
	
	public void setParameter_name(String value) {
		this.parameter_name = value;
	}
	
	public String getParameter_name() {
		return parameter_name;
	}
	
	public void setParameter_value(String value) {
		this.parameter_value = value;
	}
	
	public String getParameter_value() {
		return parameter_value;
	}
	
	public void setIs_deleted(int value) {
		this.is_deleted = value;
	}
	
	public int getIs_deleted() {
		return is_deleted;
	}
	
	public void setIs_active(int value) {
		this.is_active = value;
	}
	
	public int getIs_active() {
		return is_active;
	}
	
	public void setAdd_date(java.sql.Timestamp value) {
		this.add_date = value;
	}
	
	public java.sql.Timestamp getAdd_date() {
		return add_date;
	}
	
	public void setAdd_by(int value) {
		setAdd_by(new Integer(value));
	}
	
	public void setAdd_by(Integer value) {
		this.add_by = value;
	}
	
	public Integer getAdd_by() {
		return add_by;
	}
	
	public void setLast_edit_date(java.sql.Timestamp value) {
		this.last_edit_date = value;
	}
	
	public java.sql.Timestamp getLast_edit_date() {
		return last_edit_date;
	}
	
	public void setLast_edit_by(int value) {
		setLast_edit_by(new Integer(value));
	}
	
	public void setLast_edit_by(Integer value) {
		this.last_edit_by = value;
	}
	
	public Integer getLast_edit_by() {
		return last_edit_by;
	}
	
	@Override	
	public int hashCode() {
		int hash = 3;
				return hash;
	}
	
	@Override	
	public boolean equals(Object obj) {
		if (obj == null) {
				            return false;
				        }
				        Application_configuration object = (Application_configuration) obj;
				        return (this.getApplication_configuration_id() == object.getApplication_configuration_id());
	}
	
	public String toString() {
		return String.valueOf(getApplication_configuration_id());
	}
	
}

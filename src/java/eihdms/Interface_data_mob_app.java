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
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="interface_data_mob_app")
public class Interface_data_mob_app implements Serializable {
	public Interface_data_mob_app() {
	}
	
	public static Interface_data_mob_app loadInterface_data_mob_appByORMID(int interface_data_mob_app_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadInterface_data_mob_appByORMID(session, interface_data_mob_app_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_mob_app getInterface_data_mob_appByORMID(int interface_data_mob_app_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getInterface_data_mob_appByORMID(session, interface_data_mob_app_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_mob_app loadInterface_data_mob_appByORMID(int interface_data_mob_app_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadInterface_data_mob_appByORMID(session, interface_data_mob_app_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_mob_app getInterface_data_mob_appByORMID(int interface_data_mob_app_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getInterface_data_mob_appByORMID(session, interface_data_mob_app_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_mob_app loadInterface_data_mob_appByORMID(PersistentSession session, int interface_data_mob_app_id) throws PersistentException {
		try {
			return (Interface_data_mob_app) session.load(eihdms.Interface_data_mob_app.class, new Integer(interface_data_mob_app_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_mob_app getInterface_data_mob_appByORMID(PersistentSession session, int interface_data_mob_app_id) throws PersistentException {
		try {
			return (Interface_data_mob_app) session.get(eihdms.Interface_data_mob_app.class, new Integer(interface_data_mob_app_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_mob_app loadInterface_data_mob_appByORMID(PersistentSession session, int interface_data_mob_app_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Interface_data_mob_app) session.load(eihdms.Interface_data_mob_app.class, new Integer(interface_data_mob_app_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_mob_app getInterface_data_mob_appByORMID(PersistentSession session, int interface_data_mob_app_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Interface_data_mob_app) session.get(eihdms.Interface_data_mob_app.class, new Integer(interface_data_mob_app_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInterface_data_mob_app(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryInterface_data_mob_app(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInterface_data_mob_app(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryInterface_data_mob_app(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_mob_app[] listInterface_data_mob_appByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listInterface_data_mob_appByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_mob_app[] listInterface_data_mob_appByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listInterface_data_mob_appByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInterface_data_mob_app(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Interface_data_mob_app as Interface_data_mob_app");
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
	
	public static List queryInterface_data_mob_app(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Interface_data_mob_app as Interface_data_mob_app");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Interface_data_mob_app", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_mob_app[] listInterface_data_mob_appByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryInterface_data_mob_app(session, condition, orderBy);
			return (Interface_data_mob_app[]) list.toArray(new Interface_data_mob_app[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_mob_app[] listInterface_data_mob_appByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryInterface_data_mob_app(session, condition, orderBy, lockMode);
			return (Interface_data_mob_app[]) list.toArray(new Interface_data_mob_app[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_mob_app loadInterface_data_mob_appByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadInterface_data_mob_appByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_mob_app loadInterface_data_mob_appByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadInterface_data_mob_appByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_mob_app loadInterface_data_mob_appByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Interface_data_mob_app[] interface_data_mob_apps = listInterface_data_mob_appByQuery(session, condition, orderBy);
		if (interface_data_mob_apps != null && interface_data_mob_apps.length > 0)
			return interface_data_mob_apps[0];
		else
			return null;
	}
	
	public static Interface_data_mob_app loadInterface_data_mob_appByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Interface_data_mob_app[] interface_data_mob_apps = listInterface_data_mob_appByQuery(session, condition, orderBy, lockMode);
		if (interface_data_mob_apps != null && interface_data_mob_apps.length > 0)
			return interface_data_mob_apps[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateInterface_data_mob_appByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateInterface_data_mob_appByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateInterface_data_mob_appByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateInterface_data_mob_appByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateInterface_data_mob_appByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Interface_data_mob_app as Interface_data_mob_app");
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
	
	public static java.util.Iterator iterateInterface_data_mob_appByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Interface_data_mob_app as Interface_data_mob_app");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Interface_data_mob_app", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_mob_app loadInterface_data_mob_appByCriteria(Interface_data_mob_appCriteria interface_data_mob_appCriteria) {
		Interface_data_mob_app[] interface_data_mob_apps = listInterface_data_mob_appByCriteria(interface_data_mob_appCriteria);
		if(interface_data_mob_apps == null || interface_data_mob_apps.length == 0) {
			return null;
		}
		return interface_data_mob_apps[0];
	}
	
	public static Interface_data_mob_app[] listInterface_data_mob_appByCriteria(Interface_data_mob_appCriteria interface_data_mob_appCriteria) {
		return interface_data_mob_appCriteria.listInterface_data_mob_app();
	}
	
	public static Interface_data_mob_app createInterface_data_mob_app() {
		return new eihdms.Interface_data_mob_app();
	}
	
	public boolean save() throws PersistentException {
		try {
			EIHDMSPersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			EIHDMSPersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			EIHDMSPersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			EIHDMSPersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	@Column(name="interface_data_mob_app_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_INTERFACE_DATA_MOB_APP_INTERFACE_DATA_MOB_APP_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_INTERFACE_DATA_MOB_APP_INTERFACE_DATA_MOB_APP_ID_GENERATOR", strategy="native")	
	private int interface_data_mob_app_id;
	
	@Column(name="batch_mob_app_id", nullable=false, length=11)	
	private int batch_mob_app_id;
	
	@Column(name="data_element_id", nullable=false, length=11)	
	private int data_element_id;
	
	@Column(name="data_element_value", nullable=false, length=100)	
	private String data_element_value;
	
	@Column(name="health_facility_name", nullable=true, length=100)	
	private String health_facility_name;
	
	@Column(name="parish_name", nullable=true, length=100)	
	private String parish_name;
	
	@Column(name="sub_county_name", nullable=true, length=100)	
	private String sub_county_name;
	
	@Column(name="county_name", nullable=true, length=100)	
	private String county_name;
	
	@Column(name="district_name", nullable=true, length=100)	
	private String district_name;
	
	@Column(name="add_date_mob_app", nullable=false)	
	private java.sql.Timestamp add_date_mob_app;
	
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
	
	@Column(name="status_v", nullable=true, length=50)	
	private String status_v;
	
	@Column(name="status_v_desc", nullable=true)	
	private String status_v_desc;
	
	@Column(name="status_m", nullable=true, length=50)	
	private String status_m;
	
	@Column(name="status_m_desc", nullable=true)	
	private String status_m_desc;
	
	@Column(name="health_facility_id", nullable=true, length=11)	
	private Integer health_facility_id;
	
	@Column(name="parish_id", nullable=true, length=11)	
	private Integer parish_id;
	
	@Column(name="sub_county_id", nullable=true, length=10)	
	private Integer sub_county_id;
	
	@Column(name="county_id", nullable=true, length=11)	
	private Integer county_id;
	
	@Column(name="district_id", nullable=true, length=10)	
	private Integer district_id;
	
	@Column(name="report_form_id", nullable=true, length=11)	
	private Integer report_form_id;
	
	@Column(name="report_form_group_id", nullable=true, length=11)	
	private Integer report_form_group_id;
	
	@Column(name="entry_mode", nullable=true, length=20)	
	private String entry_mode;
	
	@Column(name="rec_id", nullable=true, length=100)	
	private String rec_id;
	
	private void setInterface_data_mob_app_id(int value) {
		this.interface_data_mob_app_id = value;
	}
	
	public int getInterface_data_mob_app_id() {
		return interface_data_mob_app_id;
	}
	
	public int getORMID() {
		return getInterface_data_mob_app_id();
	}
	
	public void setBatch_mob_app_id(int value) {
		this.batch_mob_app_id = value;
	}
	
	public int getBatch_mob_app_id() {
		return batch_mob_app_id;
	}
	
	public void setData_element_id(int value) {
		this.data_element_id = value;
	}
	
	public int getData_element_id() {
		return data_element_id;
	}
	
	public void setData_element_value(String value) {
		this.data_element_value = value;
	}
	
	public String getData_element_value() {
		return data_element_value;
	}
	
	public void setHealth_facility_name(String value) {
		this.health_facility_name = value;
	}
	
	public String getHealth_facility_name() {
		return health_facility_name;
	}
	
	public void setParish_name(String value) {
		this.parish_name = value;
	}
	
	public String getParish_name() {
		return parish_name;
	}
	
	public void setSub_county_name(String value) {
		this.sub_county_name = value;
	}
	
	public String getSub_county_name() {
		return sub_county_name;
	}
	
	public void setCounty_name(String value) {
		this.county_name = value;
	}
	
	public String getCounty_name() {
		return county_name;
	}
	
	public void setDistrict_name(String value) {
		this.district_name = value;
	}
	
	public String getDistrict_name() {
		return district_name;
	}
	
	public void setAdd_date_mob_app(java.sql.Timestamp value) {
		this.add_date_mob_app = value;
	}
	
	public java.sql.Timestamp getAdd_date_mob_app() {
		return add_date_mob_app;
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
	
	public void setStatus_v(String value) {
		this.status_v = value;
	}
	
	public String getStatus_v() {
		return status_v;
	}
	
	public void setStatus_v_desc(String value) {
		this.status_v_desc = value;
	}
	
	public String getStatus_v_desc() {
		return status_v_desc;
	}
	
	public void setStatus_m(String value) {
		this.status_m = value;
	}
	
	public String getStatus_m() {
		return status_m;
	}
	
	public void setStatus_m_desc(String value) {
		this.status_m_desc = value;
	}
	
	public String getStatus_m_desc() {
		return status_m_desc;
	}
	
	public void setHealth_facility_id(int value) {
		setHealth_facility_id(new Integer(value));
	}
	
	public void setHealth_facility_id(Integer value) {
		this.health_facility_id = value;
	}
	
	public Integer getHealth_facility_id() {
		return health_facility_id;
	}
	
	public void setParish_id(int value) {
		setParish_id(new Integer(value));
	}
	
	public void setParish_id(Integer value) {
		this.parish_id = value;
	}
	
	public Integer getParish_id() {
		return parish_id;
	}
	
	public void setSub_county_id(int value) {
		setSub_county_id(new Integer(value));
	}
	
	public void setSub_county_id(Integer value) {
		this.sub_county_id = value;
	}
	
	public Integer getSub_county_id() {
		return sub_county_id;
	}
	
	public void setCounty_id(int value) {
		setCounty_id(new Integer(value));
	}
	
	public void setCounty_id(Integer value) {
		this.county_id = value;
	}
	
	public Integer getCounty_id() {
		return county_id;
	}
	
	public void setDistrict_id(int value) {
		setDistrict_id(new Integer(value));
	}
	
	public void setDistrict_id(Integer value) {
		this.district_id = value;
	}
	
	public Integer getDistrict_id() {
		return district_id;
	}
	
	public void setReport_form_id(int value) {
		setReport_form_id(new Integer(value));
	}
	
	public void setReport_form_id(Integer value) {
		this.report_form_id = value;
	}
	
	public Integer getReport_form_id() {
		return report_form_id;
	}
	
	public void setReport_form_group_id(int value) {
		setReport_form_group_id(new Integer(value));
	}
	
	public void setReport_form_group_id(Integer value) {
		this.report_form_group_id = value;
	}
	
	public Integer getReport_form_group_id() {
		return report_form_group_id;
	}
	
	public void setEntry_mode(String value) {
		this.entry_mode = value;
	}
	
	public String getEntry_mode() {
		return entry_mode;
	}
	
	public void setRec_id(String value) {
		this.rec_id = value;
	}
	
	public String getRec_id() {
		return rec_id;
	}
	
	public String toString() {
		return String.valueOf(getInterface_data_mob_app_id());
	}
	
}

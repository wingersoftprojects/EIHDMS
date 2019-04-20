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
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="interface_data_temp")
public class Interface_data_temp implements Serializable {
	public Interface_data_temp() {
	}
	
	public static Interface_data_temp loadInterface_data_tempByORMID(int interface_data_temp_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadInterface_data_tempByORMID(session, interface_data_temp_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_temp getInterface_data_tempByORMID(int interface_data_temp_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getInterface_data_tempByORMID(session, interface_data_temp_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_temp loadInterface_data_tempByORMID(int interface_data_temp_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadInterface_data_tempByORMID(session, interface_data_temp_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_temp getInterface_data_tempByORMID(int interface_data_temp_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getInterface_data_tempByORMID(session, interface_data_temp_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_temp loadInterface_data_tempByORMID(PersistentSession session, int interface_data_temp_id) throws PersistentException {
		try {
			return (Interface_data_temp) session.load(eihdms.Interface_data_temp.class, new Integer(interface_data_temp_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_temp getInterface_data_tempByORMID(PersistentSession session, int interface_data_temp_id) throws PersistentException {
		try {
			return (Interface_data_temp) session.get(eihdms.Interface_data_temp.class, new Integer(interface_data_temp_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_temp loadInterface_data_tempByORMID(PersistentSession session, int interface_data_temp_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Interface_data_temp) session.load(eihdms.Interface_data_temp.class, new Integer(interface_data_temp_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_temp getInterface_data_tempByORMID(PersistentSession session, int interface_data_temp_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Interface_data_temp) session.get(eihdms.Interface_data_temp.class, new Integer(interface_data_temp_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInterface_data_temp(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryInterface_data_temp(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInterface_data_temp(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryInterface_data_temp(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_temp[] listInterface_data_tempByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listInterface_data_tempByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_temp[] listInterface_data_tempByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listInterface_data_tempByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInterface_data_temp(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Interface_data_temp as Interface_data_temp");
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
	
	public static List queryInterface_data_temp(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Interface_data_temp as Interface_data_temp");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Interface_data_temp", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_temp[] listInterface_data_tempByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryInterface_data_temp(session, condition, orderBy);
			return (Interface_data_temp[]) list.toArray(new Interface_data_temp[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_temp[] listInterface_data_tempByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryInterface_data_temp(session, condition, orderBy, lockMode);
			return (Interface_data_temp[]) list.toArray(new Interface_data_temp[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_temp loadInterface_data_tempByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadInterface_data_tempByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_temp loadInterface_data_tempByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadInterface_data_tempByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_temp loadInterface_data_tempByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Interface_data_temp[] interface_data_temps = listInterface_data_tempByQuery(session, condition, orderBy);
		if (interface_data_temps != null && interface_data_temps.length > 0)
			return interface_data_temps[0];
		else
			return null;
	}
	
	public static Interface_data_temp loadInterface_data_tempByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Interface_data_temp[] interface_data_temps = listInterface_data_tempByQuery(session, condition, orderBy, lockMode);
		if (interface_data_temps != null && interface_data_temps.length > 0)
			return interface_data_temps[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateInterface_data_tempByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateInterface_data_tempByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateInterface_data_tempByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateInterface_data_tempByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateInterface_data_tempByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Interface_data_temp as Interface_data_temp");
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
	
	public static java.util.Iterator iterateInterface_data_tempByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Interface_data_temp as Interface_data_temp");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Interface_data_temp", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_temp loadInterface_data_tempByCriteria(Interface_data_tempCriteria interface_data_tempCriteria) {
		Interface_data_temp[] interface_data_temps = listInterface_data_tempByCriteria(interface_data_tempCriteria);
		if(interface_data_temps == null || interface_data_temps.length == 0) {
			return null;
		}
		return interface_data_temps[0];
	}
	
	public static Interface_data_temp[] listInterface_data_tempByCriteria(Interface_data_tempCriteria interface_data_tempCriteria) {
		return interface_data_tempCriteria.listInterface_data_temp();
	}
	
	public static Interface_data_temp createInterface_data_temp() {
		return new eihdms.Interface_data_temp();
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
	
	@Column(name="interface_data_temp_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_INTERFACE_DATA_TEMP_INTERFACE_DATA_TEMP_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_INTERFACE_DATA_TEMP_INTERFACE_DATA_TEMP_ID_GENERATOR", strategy="native")	
	private int interface_data_temp_id;
	
	@Column(name="batch_id", nullable=true, length=11)	
	private Integer batch_id;
	
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
	
	@Column(name="report_period_month", nullable=true, length=11)	
	private Integer report_period_month;
	
	@Column(name="report_period_week", nullable=true, length=11)	
	private Integer report_period_week;
	
	@Column(name="report_period_year", nullable=true, length=11)	
	private Integer report_period_year;
	
	@Column(name="report_period_quarter", nullable=true, length=11)	
	private Integer report_period_quarter;
	
	@Column(name="report_period_from_date", nullable=false)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date report_period_from_date;
	
	@Column(name="report_period_to_date", nullable=false)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date report_period_to_date;
	
	@Column(name="add_date", nullable=true)	
	private java.sql.Timestamp add_date;
	
	@Column(name="add_by", nullable=true, length=10)	
	private Integer add_by;
	
	@Column(name="last_edit_date", nullable=true)	
	private java.sql.Timestamp last_edit_date;
	
	@Column(name="last_edit_by", nullable=true, length=10)	
	private Integer last_edit_by;
	
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
	
	@Column(name="report_period_bi_month", nullable=true, length=11)	
	private Integer report_period_bi_month;
	
	@Column(name="report_form_id", nullable=true, length=11)	
	private Integer report_form_id;
	
	@Column(name="report_form_group_id", nullable=true, length=11)	
	private Integer report_form_group_id;
	
	private void setInterface_data_temp_id(int value) {
		this.interface_data_temp_id = value;
	}
	
	public int getInterface_data_temp_id() {
		return interface_data_temp_id;
	}
	
	public int getORMID() {
		return getInterface_data_temp_id();
	}
	
	public void setBatch_id(int value) {
		setBatch_id(new Integer(value));
	}
	
	public void setBatch_id(Integer value) {
		this.batch_id = value;
	}
	
	public Integer getBatch_id() {
		return batch_id;
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
	
	public void setReport_period_month(int value) {
		setReport_period_month(new Integer(value));
	}
	
	public void setReport_period_month(Integer value) {
		this.report_period_month = value;
	}
	
	public Integer getReport_period_month() {
		return report_period_month;
	}
	
	public void setReport_period_week(int value) {
		setReport_period_week(new Integer(value));
	}
	
	public void setReport_period_week(Integer value) {
		this.report_period_week = value;
	}
	
	public Integer getReport_period_week() {
		return report_period_week;
	}
	
	public void setReport_period_year(int value) {
		setReport_period_year(new Integer(value));
	}
	
	public void setReport_period_year(Integer value) {
		this.report_period_year = value;
	}
	
	public Integer getReport_period_year() {
		return report_period_year;
	}
	
	public void setReport_period_quarter(int value) {
		setReport_period_quarter(new Integer(value));
	}
	
	public void setReport_period_quarter(Integer value) {
		this.report_period_quarter = value;
	}
	
	public Integer getReport_period_quarter() {
		return report_period_quarter;
	}
	
	public void setReport_period_from_date(java.util.Date value) {
		this.report_period_from_date = value;
	}
	
	public java.util.Date getReport_period_from_date() {
		return report_period_from_date;
	}
	
	public void setReport_period_to_date(java.util.Date value) {
		this.report_period_to_date = value;
	}
	
	public java.util.Date getReport_period_to_date() {
		return report_period_to_date;
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
	
	public void setReport_period_bi_month(int value) {
		setReport_period_bi_month(new Integer(value));
	}
	
	public void setReport_period_bi_month(Integer value) {
		this.report_period_bi_month = value;
	}
	
	public Integer getReport_period_bi_month() {
		return report_period_bi_month;
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
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Interface_data_temp object = (Interface_data_temp) obj;
		return (this.getInterface_data_temp_id() == object.getInterface_data_temp_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getInterface_data_temp_id());
	}
	
}

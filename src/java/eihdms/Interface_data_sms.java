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
@Table(name="interface_data_sms")
public class Interface_data_sms implements Serializable {
	public Interface_data_sms() {
	}
	
	public static Interface_data_sms loadInterface_data_smsByORMID(int interface_data_sms_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadInterface_data_smsByORMID(session, interface_data_sms_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_sms getInterface_data_smsByORMID(int interface_data_sms_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getInterface_data_smsByORMID(session, interface_data_sms_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_sms loadInterface_data_smsByORMID(int interface_data_sms_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadInterface_data_smsByORMID(session, interface_data_sms_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_sms getInterface_data_smsByORMID(int interface_data_sms_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getInterface_data_smsByORMID(session, interface_data_sms_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_sms loadInterface_data_smsByORMID(PersistentSession session, int interface_data_sms_id) throws PersistentException {
		try {
			return (Interface_data_sms) session.load(eihdms.Interface_data_sms.class, new Integer(interface_data_sms_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_sms getInterface_data_smsByORMID(PersistentSession session, int interface_data_sms_id) throws PersistentException {
		try {
			return (Interface_data_sms) session.get(eihdms.Interface_data_sms.class, new Integer(interface_data_sms_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_sms loadInterface_data_smsByORMID(PersistentSession session, int interface_data_sms_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Interface_data_sms) session.load(eihdms.Interface_data_sms.class, new Integer(interface_data_sms_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_sms getInterface_data_smsByORMID(PersistentSession session, int interface_data_sms_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Interface_data_sms) session.get(eihdms.Interface_data_sms.class, new Integer(interface_data_sms_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInterface_data_sms(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryInterface_data_sms(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInterface_data_sms(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryInterface_data_sms(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_sms[] listInterface_data_smsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listInterface_data_smsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_sms[] listInterface_data_smsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listInterface_data_smsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInterface_data_sms(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Interface_data_sms as Interface_data_sms");
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
	
	public static List queryInterface_data_sms(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Interface_data_sms as Interface_data_sms");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Interface_data_sms", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_sms[] listInterface_data_smsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryInterface_data_sms(session, condition, orderBy);
			return (Interface_data_sms[]) list.toArray(new Interface_data_sms[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_sms[] listInterface_data_smsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryInterface_data_sms(session, condition, orderBy, lockMode);
			return (Interface_data_sms[]) list.toArray(new Interface_data_sms[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_sms loadInterface_data_smsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadInterface_data_smsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_sms loadInterface_data_smsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadInterface_data_smsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_sms loadInterface_data_smsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Interface_data_sms[] interface_data_smses = listInterface_data_smsByQuery(session, condition, orderBy);
		if (interface_data_smses != null && interface_data_smses.length > 0)
			return interface_data_smses[0];
		else
			return null;
	}
	
	public static Interface_data_sms loadInterface_data_smsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Interface_data_sms[] interface_data_smses = listInterface_data_smsByQuery(session, condition, orderBy, lockMode);
		if (interface_data_smses != null && interface_data_smses.length > 0)
			return interface_data_smses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateInterface_data_smsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateInterface_data_smsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateInterface_data_smsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateInterface_data_smsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateInterface_data_smsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Interface_data_sms as Interface_data_sms");
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
	
	public static java.util.Iterator iterateInterface_data_smsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Interface_data_sms as Interface_data_sms");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Interface_data_sms", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data_sms loadInterface_data_smsByCriteria(Interface_data_smsCriteria interface_data_smsCriteria) {
		Interface_data_sms[] interface_data_smses = listInterface_data_smsByCriteria(interface_data_smsCriteria);
		if(interface_data_smses == null || interface_data_smses.length == 0) {
			return null;
		}
		return interface_data_smses[0];
	}
	
	public static Interface_data_sms[] listInterface_data_smsByCriteria(Interface_data_smsCriteria interface_data_smsCriteria) {
		return interface_data_smsCriteria.listInterface_data_sms();
	}
	
	public static Interface_data_sms createInterface_data_sms() {
		return new eihdms.Interface_data_sms();
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
	
	@Column(name="interface_data_sms_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_INTERFACE_DATA_SMS_INTERFACE_DATA_SMS_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_INTERFACE_DATA_SMS_INTERFACE_DATA_SMS_ID_GENERATOR", strategy="native")	
	private int interface_data_sms_id;
	
	@Column(name="add_date", nullable=false)	
	private java.sql.Timestamp add_date;
	
	@Column(name="phone", nullable=false, length=100)	
	private String phone;
	
	@Column(name="sms", nullable=true, length=255)	
	private String sms;
	
	@Column(name="scode", nullable=true, length=11)	
	private String scode;
	
	@Column(name="status_code", nullable=true, length=100)	
	private String status_code;
	
	@Column(name="status_desc", nullable=true, length=250)	
	private String status_desc;
	
	@Column(name="report_form_code", nullable=true, length=100)	
	private String report_form_code;
	
	@Column(name="is_deleted", nullable=false, length=1)	
	private int is_deleted;
	
	@Column(name="is_active", nullable=false, length=1)	
	private int is_active;
	
	@Column(name="add_by", nullable=false, length=10)	
	private Integer add_by;
	
	@Column(name="last_edit_date", nullable=true)	
	private java.sql.Timestamp last_edit_date;
	
	@Column(name="last_edit_by", nullable=true, length=10)	
	private Integer last_edit_by;
	
	private void setInterface_data_sms_id(int value) {
		this.interface_data_sms_id = value;
	}
	
	public int getInterface_data_sms_id() {
		return interface_data_sms_id;
	}
	
	public int getORMID() {
		return getInterface_data_sms_id();
	}
	
	public void setAdd_date(java.sql.Timestamp value) {
		this.add_date = value;
	}
	
	public java.sql.Timestamp getAdd_date() {
		return add_date;
	}
	
	public void setPhone(String value) {
		this.phone = value;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setSms(String value) {
		this.sms = value;
	}
	
	public String getSms() {
		return sms;
	}
	
	public void setScode(String value) {
		this.scode = value;
	}
	
	public String getScode() {
		return scode;
	}
	
	public void setStatus_code(String value) {
		this.status_code = value;
	}
	
	public String getStatus_code() {
		return status_code;
	}
	
	public void setStatus_desc(String value) {
		this.status_desc = value;
	}
	
	public String getStatus_desc() {
		return status_desc;
	}
	
	public void setReport_form_code(String value) {
		this.report_form_code = value;
	}
	
	public String getReport_form_code() {
		return report_form_code;
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
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Interface_data_sms object = (Interface_data_sms) obj;
		return (this.getInterface_data_sms_id() == object.getInterface_data_sms_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getInterface_data_sms_id());
	}
	
}

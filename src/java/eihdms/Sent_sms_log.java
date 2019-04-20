/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Wence
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
@Table(name="sent_sms_log")
public class Sent_sms_log implements Serializable {
	public Sent_sms_log() {
	}
	
	public static Sent_sms_log loadSent_sms_logByORMID(int sent_sms_log_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSent_sms_logByORMID(session, sent_sms_log_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sent_sms_log getSent_sms_logByORMID(int sent_sms_log_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getSent_sms_logByORMID(session, sent_sms_log_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sent_sms_log loadSent_sms_logByORMID(int sent_sms_log_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSent_sms_logByORMID(session, sent_sms_log_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sent_sms_log getSent_sms_logByORMID(int sent_sms_log_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getSent_sms_logByORMID(session, sent_sms_log_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sent_sms_log loadSent_sms_logByORMID(PersistentSession session, int sent_sms_log_id) throws PersistentException {
		try {
			return (Sent_sms_log) session.load(eihdms.Sent_sms_log.class, new Integer(sent_sms_log_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sent_sms_log getSent_sms_logByORMID(PersistentSession session, int sent_sms_log_id) throws PersistentException {
		try {
			return (Sent_sms_log) session.get(eihdms.Sent_sms_log.class, new Integer(sent_sms_log_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sent_sms_log loadSent_sms_logByORMID(PersistentSession session, int sent_sms_log_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sent_sms_log) session.load(eihdms.Sent_sms_log.class, new Integer(sent_sms_log_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sent_sms_log getSent_sms_logByORMID(PersistentSession session, int sent_sms_log_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sent_sms_log) session.get(eihdms.Sent_sms_log.class, new Integer(sent_sms_log_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySent_sms_log(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return querySent_sms_log(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySent_sms_log(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return querySent_sms_log(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sent_sms_log[] listSent_sms_logByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listSent_sms_logByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sent_sms_log[] listSent_sms_logByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listSent_sms_logByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySent_sms_log(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sent_sms_log as Sent_sms_log");
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
	
	public static List querySent_sms_log(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sent_sms_log as Sent_sms_log");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sent_sms_log", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sent_sms_log[] listSent_sms_logByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySent_sms_log(session, condition, orderBy);
			return (Sent_sms_log[]) list.toArray(new Sent_sms_log[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sent_sms_log[] listSent_sms_logByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySent_sms_log(session, condition, orderBy, lockMode);
			return (Sent_sms_log[]) list.toArray(new Sent_sms_log[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sent_sms_log loadSent_sms_logByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSent_sms_logByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sent_sms_log loadSent_sms_logByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSent_sms_logByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sent_sms_log loadSent_sms_logByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Sent_sms_log[] sent_sms_logs = listSent_sms_logByQuery(session, condition, orderBy);
		if (sent_sms_logs != null && sent_sms_logs.length > 0)
			return sent_sms_logs[0];
		else
			return null;
	}
	
	public static Sent_sms_log loadSent_sms_logByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Sent_sms_log[] sent_sms_logs = listSent_sms_logByQuery(session, condition, orderBy, lockMode);
		if (sent_sms_logs != null && sent_sms_logs.length > 0)
			return sent_sms_logs[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSent_sms_logByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateSent_sms_logByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSent_sms_logByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateSent_sms_logByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSent_sms_logByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sent_sms_log as Sent_sms_log");
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
	
	public static java.util.Iterator iterateSent_sms_logByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sent_sms_log as Sent_sms_log");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sent_sms_log", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sent_sms_log loadSent_sms_logByCriteria(Sent_sms_logCriteria sent_sms_logCriteria) {
		Sent_sms_log[] sent_sms_logs = listSent_sms_logByCriteria(sent_sms_logCriteria);
		if(sent_sms_logs == null || sent_sms_logs.length == 0) {
			return null;
		}
		return sent_sms_logs[0];
	}
	
	public static Sent_sms_log[] listSent_sms_logByCriteria(Sent_sms_logCriteria sent_sms_logCriteria) {
		return sent_sms_logCriteria.listSent_sms_log();
	}
	
	public static Sent_sms_log createSent_sms_log() {
		return new eihdms.Sent_sms_log();
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
	
	@Column(name="sent_sms_log_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_SENT_SMS_LOG_SENT_SMS_LOG_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_SENT_SMS_LOG_SENT_SMS_LOG_ID_GENERATOR", strategy="native")	
	private int sent_sms_log_id;
	
	@Column(name="sent_date", nullable=false)	
	private java.sql.Timestamp sent_date;
	
	@Column(name="phone", nullable=true, length=100)	
	private String phone;
	
	@Column(name="sms", nullable=true, length=255)	
	private String sms;
	
	@Column(name="scode", nullable=true, length=11)	
	private String scode;
	
	@Column(name="status_code", nullable=true, length=100)	
	private String status_code;
	
	@Column(name="status_desc", nullable=true, length=250)	
	private String status_desc;
	
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
	
	private void setSent_sms_log_id(int value) {
		this.sent_sms_log_id = value;
	}
	
	public int getSent_sms_log_id() {
		return sent_sms_log_id;
	}
	
	public int getORMID() {
		return getSent_sms_log_id();
	}
	
	public void setSent_date(java.sql.Timestamp value) {
		this.sent_date = value;
	}
	
	public java.sql.Timestamp getSent_date() {
		return sent_date;
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
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Sent_sms_log object = (Sent_sms_log) obj;
		return (this.getSent_sms_log_id() == object.getSent_sms_log_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getSent_sms_log_id());
	}
	
}

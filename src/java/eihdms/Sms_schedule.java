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
@Table(name="sms_schedule")
public class Sms_schedule implements Serializable {
	public Sms_schedule() {
	}
	
	public static Sms_schedule loadSms_scheduleByORMID(int sms_schedule_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSms_scheduleByORMID(session, sms_schedule_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_schedule getSms_scheduleByORMID(int sms_schedule_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getSms_scheduleByORMID(session, sms_schedule_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_schedule loadSms_scheduleByORMID(int sms_schedule_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSms_scheduleByORMID(session, sms_schedule_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_schedule getSms_scheduleByORMID(int sms_schedule_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getSms_scheduleByORMID(session, sms_schedule_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_schedule loadSms_scheduleByORMID(PersistentSession session, int sms_schedule_id) throws PersistentException {
		try {
			return (Sms_schedule) session.load(eihdms.Sms_schedule.class, new Integer(sms_schedule_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_schedule getSms_scheduleByORMID(PersistentSession session, int sms_schedule_id) throws PersistentException {
		try {
			return (Sms_schedule) session.get(eihdms.Sms_schedule.class, new Integer(sms_schedule_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_schedule loadSms_scheduleByORMID(PersistentSession session, int sms_schedule_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sms_schedule) session.load(eihdms.Sms_schedule.class, new Integer(sms_schedule_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_schedule getSms_scheduleByORMID(PersistentSession session, int sms_schedule_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sms_schedule) session.get(eihdms.Sms_schedule.class, new Integer(sms_schedule_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySms_schedule(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return querySms_schedule(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySms_schedule(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return querySms_schedule(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_schedule[] listSms_scheduleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listSms_scheduleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_schedule[] listSms_scheduleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listSms_scheduleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySms_schedule(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sms_schedule as Sms_schedule");
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
	
	public static List querySms_schedule(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sms_schedule as Sms_schedule");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sms_schedule", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_schedule[] listSms_scheduleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySms_schedule(session, condition, orderBy);
			return (Sms_schedule[]) list.toArray(new Sms_schedule[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_schedule[] listSms_scheduleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySms_schedule(session, condition, orderBy, lockMode);
			return (Sms_schedule[]) list.toArray(new Sms_schedule[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_schedule loadSms_scheduleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSms_scheduleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_schedule loadSms_scheduleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSms_scheduleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_schedule loadSms_scheduleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Sms_schedule[] sms_schedules = listSms_scheduleByQuery(session, condition, orderBy);
		if (sms_schedules != null && sms_schedules.length > 0)
			return sms_schedules[0];
		else
			return null;
	}
	
	public static Sms_schedule loadSms_scheduleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Sms_schedule[] sms_schedules = listSms_scheduleByQuery(session, condition, orderBy, lockMode);
		if (sms_schedules != null && sms_schedules.length > 0)
			return sms_schedules[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSms_scheduleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateSms_scheduleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSms_scheduleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateSms_scheduleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSms_scheduleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sms_schedule as Sms_schedule");
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
	
	public static java.util.Iterator iterateSms_scheduleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sms_schedule as Sms_schedule");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sms_schedule", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_schedule loadSms_scheduleByCriteria(Sms_scheduleCriteria sms_scheduleCriteria) {
		Sms_schedule[] sms_schedules = listSms_scheduleByCriteria(sms_scheduleCriteria);
		if(sms_schedules == null || sms_schedules.length == 0) {
			return null;
		}
		return sms_schedules[0];
	}
	
	public static Sms_schedule[] listSms_scheduleByCriteria(Sms_scheduleCriteria sms_scheduleCriteria) {
		return sms_scheduleCriteria.listSms_schedule();
	}
	
	public static Sms_schedule createSms_schedule() {
		return new eihdms.Sms_schedule();
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
	
	@Column(name="sms_schedule_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_SMS_SCHEDULE_SMS_SCHEDULE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_SMS_SCHEDULE_SMS_SCHEDULE_ID_GENERATOR", strategy="native")	
	private int sms_schedule_id;
	
	@Column(name="send_date", nullable=true)	
	private java.sql.Timestamp send_date;
	
	@Column(name="sms", nullable=true, length=255)	
	private String sms;
	
	@Column(name="status_code", nullable=true, length=100)	
	private String status_code;
	
	@Column(name="status_desc", nullable=true, length=250)	
	private String status_desc;
	
	@Column(name="schedule_by", nullable=true, length=100)	
	private String schedule_by;
	
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
	
	private void setSms_schedule_id(int value) {
		this.sms_schedule_id = value;
	}
	
	public int getSms_schedule_id() {
		return sms_schedule_id;
	}
	
	public int getORMID() {
		return getSms_schedule_id();
	}
	
	public void setSend_date(java.sql.Timestamp value) {
		this.send_date = value;
	}
	
	public java.sql.Timestamp getSend_date() {
		return send_date;
	}
	
	public void setSms(String value) {
		this.sms = value;
	}
	
	public String getSms() {
		return sms;
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
	
	public void setSchedule_by(String value) {
		this.schedule_by = value;
	}
	
	public String getSchedule_by() {
		return schedule_by;
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
		Sms_schedule object = (Sms_schedule) obj;
		return (this.getSms_schedule_id() == object.getSms_schedule_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getSms_schedule_id());
	}
	
}

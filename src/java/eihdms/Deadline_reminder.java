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
@Table(name="deadline_reminder")
public class Deadline_reminder implements Serializable {
	public Deadline_reminder() {
	}
	
	public static Deadline_reminder loadDeadline_reminderByORMID(int deadline_reminder_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadDeadline_reminderByORMID(session, deadline_reminder_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_reminder getDeadline_reminderByORMID(int deadline_reminder_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getDeadline_reminderByORMID(session, deadline_reminder_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_reminder loadDeadline_reminderByORMID(int deadline_reminder_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadDeadline_reminderByORMID(session, deadline_reminder_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_reminder getDeadline_reminderByORMID(int deadline_reminder_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getDeadline_reminderByORMID(session, deadline_reminder_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_reminder loadDeadline_reminderByORMID(PersistentSession session, int deadline_reminder_id) throws PersistentException {
		try {
			return (Deadline_reminder) session.load(eihdms.Deadline_reminder.class, new Integer(deadline_reminder_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_reminder getDeadline_reminderByORMID(PersistentSession session, int deadline_reminder_id) throws PersistentException {
		try {
			return (Deadline_reminder) session.get(eihdms.Deadline_reminder.class, new Integer(deadline_reminder_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_reminder loadDeadline_reminderByORMID(PersistentSession session, int deadline_reminder_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Deadline_reminder) session.load(eihdms.Deadline_reminder.class, new Integer(deadline_reminder_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_reminder getDeadline_reminderByORMID(PersistentSession session, int deadline_reminder_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Deadline_reminder) session.get(eihdms.Deadline_reminder.class, new Integer(deadline_reminder_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDeadline_reminder(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryDeadline_reminder(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDeadline_reminder(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryDeadline_reminder(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_reminder[] listDeadline_reminderByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listDeadline_reminderByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_reminder[] listDeadline_reminderByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listDeadline_reminderByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDeadline_reminder(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Deadline_reminder as Deadline_reminder");
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
	
	public static List queryDeadline_reminder(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Deadline_reminder as Deadline_reminder");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Deadline_reminder", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_reminder[] listDeadline_reminderByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryDeadline_reminder(session, condition, orderBy);
			return (Deadline_reminder[]) list.toArray(new Deadline_reminder[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_reminder[] listDeadline_reminderByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryDeadline_reminder(session, condition, orderBy, lockMode);
			return (Deadline_reminder[]) list.toArray(new Deadline_reminder[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_reminder loadDeadline_reminderByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadDeadline_reminderByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_reminder loadDeadline_reminderByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadDeadline_reminderByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_reminder loadDeadline_reminderByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Deadline_reminder[] deadline_reminders = listDeadline_reminderByQuery(session, condition, orderBy);
		if (deadline_reminders != null && deadline_reminders.length > 0)
			return deadline_reminders[0];
		else
			return null;
	}
	
	public static Deadline_reminder loadDeadline_reminderByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Deadline_reminder[] deadline_reminders = listDeadline_reminderByQuery(session, condition, orderBy, lockMode);
		if (deadline_reminders != null && deadline_reminders.length > 0)
			return deadline_reminders[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDeadline_reminderByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateDeadline_reminderByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDeadline_reminderByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateDeadline_reminderByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDeadline_reminderByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Deadline_reminder as Deadline_reminder");
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
	
	public static java.util.Iterator iterateDeadline_reminderByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Deadline_reminder as Deadline_reminder");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Deadline_reminder", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_reminder loadDeadline_reminderByCriteria(Deadline_reminderCriteria deadline_reminderCriteria) {
		Deadline_reminder[] deadline_reminders = listDeadline_reminderByCriteria(deadline_reminderCriteria);
		if(deadline_reminders == null || deadline_reminders.length == 0) {
			return null;
		}
		return deadline_reminders[0];
	}
	
	public static Deadline_reminder[] listDeadline_reminderByCriteria(Deadline_reminderCriteria deadline_reminderCriteria) {
		return deadline_reminderCriteria.listDeadline_reminder();
	}
	
	public static Deadline_reminder createDeadline_reminder() {
		return new eihdms.Deadline_reminder();
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
	
	public boolean deleteAndDissociate()throws PersistentException {
		try {
			if(getReport_form_deadline() != null) {
				getReport_form_deadline().getDeadline_reminder().remove(this);
			}
			
			return delete();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(org.orm.PersistentSession session)throws PersistentException {
		try {
			if(getReport_form_deadline() != null) {
				getReport_form_deadline().getDeadline_reminder().remove(this);
			}
			
			try {
				session.delete(this);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	@Column(name="deadline_reminder_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_DEADLINE_REMINDER_DEADLINE_REMINDER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_DEADLINE_REMINDER_DEADLINE_REMINDER_ID_GENERATOR", strategy="native")	
	private int deadline_reminder_id;
	
	@ManyToOne(targetEntity=eihdms.Report_form_deadline.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="report_form_deadline_id", referencedColumnName="report_form_deadline_id", nullable=false) }, foreignKey=@ForeignKey(name="FKdeadline_r994913"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Report_form_deadline report_form_deadline;
	
	@Column(name="hours_before_deadline", nullable=true, length=11)	
	private Integer hours_before_deadline;
	
	@Column(name="subject", nullable=true, length=100)	
	private String subject;
	
	@Column(name="message", nullable=true, length=250)	
	private String message;
	
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
	
	private void setDeadline_reminder_id(int value) {
		this.deadline_reminder_id = value;
	}
	
	public int getDeadline_reminder_id() {
		return deadline_reminder_id;
	}
	
	public int getORMID() {
		return getDeadline_reminder_id();
	}
	
	public void setHours_before_deadline(int value) {
		setHours_before_deadline(new Integer(value));
	}
	
	public void setHours_before_deadline(Integer value) {
		this.hours_before_deadline = value;
	}
	
	public Integer getHours_before_deadline() {
		return hours_before_deadline;
	}
	
	public void setSubject(String value) {
		this.subject = value;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setMessage(String value) {
		this.message = value;
	}
	
	public String getMessage() {
		return message;
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
	
	public void setReport_form_deadline(eihdms.Report_form_deadline value) {
		this.report_form_deadline = value;
	}
	
	public eihdms.Report_form_deadline getReport_form_deadline() {
		return report_form_deadline;
	}
	
	/**
	 * Testing
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Deadline_reminder object = (Deadline_reminder) obj;
		return (this.getDeadline_reminder_id() == object.getDeadline_reminder_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getDeadline_reminder_id());
	}
	
}

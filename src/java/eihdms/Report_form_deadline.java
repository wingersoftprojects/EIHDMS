/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: bajuna
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
@Table(name="report_form_deadline")
public class Report_form_deadline implements Serializable {
	public Report_form_deadline() {
	}
	
	public static Report_form_deadline loadReport_form_deadlineByORMID(int report_form_deadline_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_form_deadlineByORMID(session, report_form_deadline_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_deadline getReport_form_deadlineByORMID(int report_form_deadline_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getReport_form_deadlineByORMID(session, report_form_deadline_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_deadline loadReport_form_deadlineByORMID(int report_form_deadline_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_form_deadlineByORMID(session, report_form_deadline_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_deadline getReport_form_deadlineByORMID(int report_form_deadline_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getReport_form_deadlineByORMID(session, report_form_deadline_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_deadline loadReport_form_deadlineByORMID(PersistentSession session, int report_form_deadline_id) throws PersistentException {
		try {
			return (Report_form_deadline) session.load(eihdms.Report_form_deadline.class, new Integer(report_form_deadline_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_deadline getReport_form_deadlineByORMID(PersistentSession session, int report_form_deadline_id) throws PersistentException {
		try {
			return (Report_form_deadline) session.get(eihdms.Report_form_deadline.class, new Integer(report_form_deadline_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_deadline loadReport_form_deadlineByORMID(PersistentSession session, int report_form_deadline_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Report_form_deadline) session.load(eihdms.Report_form_deadline.class, new Integer(report_form_deadline_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_deadline getReport_form_deadlineByORMID(PersistentSession session, int report_form_deadline_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Report_form_deadline) session.get(eihdms.Report_form_deadline.class, new Integer(report_form_deadline_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_form_deadline(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryReport_form_deadline(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_form_deadline(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryReport_form_deadline(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_deadline[] listReport_form_deadlineByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listReport_form_deadlineByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_deadline[] listReport_form_deadlineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listReport_form_deadlineByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_form_deadline(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form_deadline as Report_form_deadline");
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
	
	public static List queryReport_form_deadline(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form_deadline as Report_form_deadline");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Report_form_deadline", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_deadline[] listReport_form_deadlineByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryReport_form_deadline(session, condition, orderBy);
			return (Report_form_deadline[]) list.toArray(new Report_form_deadline[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_deadline[] listReport_form_deadlineByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryReport_form_deadline(session, condition, orderBy, lockMode);
			return (Report_form_deadline[]) list.toArray(new Report_form_deadline[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_deadline loadReport_form_deadlineByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_form_deadlineByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_deadline loadReport_form_deadlineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_form_deadlineByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_deadline loadReport_form_deadlineByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Report_form_deadline[] report_form_deadlines = listReport_form_deadlineByQuery(session, condition, orderBy);
		if (report_form_deadlines != null && report_form_deadlines.length > 0)
			return report_form_deadlines[0];
		else
			return null;
	}
	
	public static Report_form_deadline loadReport_form_deadlineByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Report_form_deadline[] report_form_deadlines = listReport_form_deadlineByQuery(session, condition, orderBy, lockMode);
		if (report_form_deadlines != null && report_form_deadlines.length > 0)
			return report_form_deadlines[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateReport_form_deadlineByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateReport_form_deadlineByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReport_form_deadlineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateReport_form_deadlineByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReport_form_deadlineByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form_deadline as Report_form_deadline");
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
	
	public static java.util.Iterator iterateReport_form_deadlineByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form_deadline as Report_form_deadline");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Report_form_deadline", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_deadline loadReport_form_deadlineByCriteria(Report_form_deadlineCriteria report_form_deadlineCriteria) {
		Report_form_deadline[] report_form_deadlines = listReport_form_deadlineByCriteria(report_form_deadlineCriteria);
		if(report_form_deadlines == null || report_form_deadlines.length == 0) {
			return null;
		}
		return report_form_deadlines[0];
	}
	
	public static Report_form_deadline[] listReport_form_deadlineByCriteria(Report_form_deadlineCriteria report_form_deadlineCriteria) {
		return report_form_deadlineCriteria.listReport_form_deadline();
	}
	
	public static Report_form_deadline createReport_form_deadline() {
		return new eihdms.Report_form_deadline();
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
			if(getReport_form() != null) {
				getReport_form().getReport_form_deadline().remove(this);
			}
			
			if(getDeadline_extension() != null) {
				getDeadline_extension().setReport_form_deadline(null);
			}
			
			eihdms.Deadline_reminder[] lDeadline_reminders = (eihdms.Deadline_reminder[])getDeadline_reminder().toArray(new eihdms.Deadline_reminder[getDeadline_reminder().size()]);
			for(int i = 0; i < lDeadline_reminders.length; i++) {
				lDeadline_reminders[i].setReport_form_deadline(null);
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
			if(getReport_form() != null) {
				getReport_form().getReport_form_deadline().remove(this);
			}
			
			if(getDeadline_extension() != null) {
				getDeadline_extension().setReport_form_deadline(null);
			}
			
			eihdms.Deadline_reminder[] lDeadline_reminders = (eihdms.Deadline_reminder[])getDeadline_reminder().toArray(new eihdms.Deadline_reminder[getDeadline_reminder().size()]);
			for(int i = 0; i < lDeadline_reminders.length; i++) {
				lDeadline_reminders[i].setReport_form_deadline(null);
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
	
	@Column(name="report_form_deadline_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_REPORT_FORM_DEADLINE_REPORT_FORM_DEADLINE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_REPORT_FORM_DEADLINE_REPORT_FORM_DEADLINE_ID_GENERATOR", strategy="native")	
	private int report_form_deadline_id;
	
	@ManyToOne(targetEntity=eihdms.Report_form.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="report_form_id", referencedColumnName="report_form_id") }, foreignKey=@ForeignKey(name="FKreport_for555710"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Report_form report_form;
	
	@Column(name="day_from", nullable=true, length=2)	
	private Integer day_from;
	
	@Column(name="day_to", nullable=true, length=2)	
	private Integer day_to;
	
	@Column(name="time_from", nullable=true)	
	private java.sql.Time time_from;
	
	@Column(name="time_to", nullable=true)	
	private java.sql.Time time_to;
	
	@Column(name="week_value", nullable=true, length=50)	
	private String week_value;
	
	@Column(name="month_value", nullable=true, length=50)	
	private String month_value;
	
	@Column(name="quarter_value", nullable=true, length=50)	
	private String quarter_value;
	
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
	
	@OneToOne(mappedBy="report_form_deadline", targetEntity=eihdms.Deadline_extension.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Deadline_extension deadline_extension;
	
	@OneToMany(mappedBy="report_form_deadline", targetEntity=eihdms.Deadline_reminder.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set deadline_reminder = new java.util.HashSet();
	
	private void setReport_form_deadline_id(int value) {
		this.report_form_deadline_id = value;
	}
	
	public int getReport_form_deadline_id() {
		return report_form_deadline_id;
	}
	
	public int getORMID() {
		return getReport_form_deadline_id();
	}
	
	public void setDay_from(int value) {
		setDay_from(new Integer(value));
	}
	
	public void setDay_from(Integer value) {
		this.day_from = value;
	}
	
	public Integer getDay_from() {
		return day_from;
	}
	
	public void setDay_to(int value) {
		setDay_to(new Integer(value));
	}
	
	public void setDay_to(Integer value) {
		this.day_to = value;
	}
	
	public Integer getDay_to() {
		return day_to;
	}
	
	public void setTime_from(java.sql.Time value) {
		this.time_from = value;
	}
	
	public java.sql.Time getTime_from() {
		return time_from;
	}
	
	public void setTime_to(java.sql.Time value) {
		this.time_to = value;
	}
	
	public java.sql.Time getTime_to() {
		return time_to;
	}
	
	public void setWeek_value(String value) {
		this.week_value = value;
	}
	
	public String getWeek_value() {
		return week_value;
	}
	
	public void setMonth_value(String value) {
		this.month_value = value;
	}
	
	public String getMonth_value() {
		return month_value;
	}
	
	public void setQuarter_value(String value) {
		this.quarter_value = value;
	}
	
	public String getQuarter_value() {
		return quarter_value;
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
	
	public void setReport_form(eihdms.Report_form value) {
		this.report_form = value;
	}
	
	public eihdms.Report_form getReport_form() {
		return report_form;
	}
	
	public void setDeadline_extension(eihdms.Deadline_extension value) {
		this.deadline_extension = value;
	}
	
	public eihdms.Deadline_extension getDeadline_extension() {
		return deadline_extension;
	}
	
	public void setDeadline_reminder(java.util.Set value) {
		this.deadline_reminder = value;
	}
	
	public java.util.Set getDeadline_reminder() {
		return deadline_reminder;
	}
	
	
	public String toString() {
		return String.valueOf(getReport_form_deadline_id());
	}
	
}

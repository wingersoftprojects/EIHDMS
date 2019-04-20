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
@Table(name="report_period_week")
public class Report_period_week implements Serializable {
	public Report_period_week() {
	}
	
	public static Report_period_week loadReport_period_weekByORMID(int report_period_week_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_period_weekByORMID(session, report_period_week_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_period_week getReport_period_weekByORMID(int report_period_week_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getReport_period_weekByORMID(session, report_period_week_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_period_week loadReport_period_weekByORMID(int report_period_week_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_period_weekByORMID(session, report_period_week_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_period_week getReport_period_weekByORMID(int report_period_week_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getReport_period_weekByORMID(session, report_period_week_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_period_week loadReport_period_weekByORMID(PersistentSession session, int report_period_week_id) throws PersistentException {
		try {
			return (Report_period_week) session.load(eihdms.Report_period_week.class, new Integer(report_period_week_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_period_week getReport_period_weekByORMID(PersistentSession session, int report_period_week_id) throws PersistentException {
		try {
			return (Report_period_week) session.get(eihdms.Report_period_week.class, new Integer(report_period_week_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_period_week loadReport_period_weekByORMID(PersistentSession session, int report_period_week_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Report_period_week) session.load(eihdms.Report_period_week.class, new Integer(report_period_week_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_period_week getReport_period_weekByORMID(PersistentSession session, int report_period_week_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Report_period_week) session.get(eihdms.Report_period_week.class, new Integer(report_period_week_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_period_week(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryReport_period_week(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_period_week(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryReport_period_week(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_period_week[] listReport_period_weekByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listReport_period_weekByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_period_week[] listReport_period_weekByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listReport_period_weekByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_period_week(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_period_week as Report_period_week");
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
	
	public static List queryReport_period_week(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_period_week as Report_period_week");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Report_period_week", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_period_week[] listReport_period_weekByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryReport_period_week(session, condition, orderBy);
			return (Report_period_week[]) list.toArray(new Report_period_week[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_period_week[] listReport_period_weekByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryReport_period_week(session, condition, orderBy, lockMode);
			return (Report_period_week[]) list.toArray(new Report_period_week[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_period_week loadReport_period_weekByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_period_weekByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_period_week loadReport_period_weekByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_period_weekByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_period_week loadReport_period_weekByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Report_period_week[] report_period_weeks = listReport_period_weekByQuery(session, condition, orderBy);
		if (report_period_weeks != null && report_period_weeks.length > 0)
			return report_period_weeks[0];
		else
			return null;
	}
	
	public static Report_period_week loadReport_period_weekByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Report_period_week[] report_period_weeks = listReport_period_weekByQuery(session, condition, orderBy, lockMode);
		if (report_period_weeks != null && report_period_weeks.length > 0)
			return report_period_weeks[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateReport_period_weekByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateReport_period_weekByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReport_period_weekByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateReport_period_weekByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReport_period_weekByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_period_week as Report_period_week");
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
	
	public static java.util.Iterator iterateReport_period_weekByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_period_week as Report_period_week");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Report_period_week", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_period_week loadReport_period_weekByCriteria(Report_period_weekCriteria report_period_weekCriteria) {
		Report_period_week[] report_period_weeks = listReport_period_weekByCriteria(report_period_weekCriteria);
		if(report_period_weeks == null || report_period_weeks.length == 0) {
			return null;
		}
		return report_period_weeks[0];
	}
	
	public static Report_period_week[] listReport_period_weekByCriteria(Report_period_weekCriteria report_period_weekCriteria) {
		return report_period_weekCriteria.listReport_period_week();
	}
	
	public static Report_period_week createReport_period_week() {
		return new eihdms.Report_period_week();
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
	
	@Column(name="report_period_week_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_REPORT_PERIOD_WEEK_REPORT_PERIOD_WEEK_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_REPORT_PERIOD_WEEK_REPORT_PERIOD_WEEK_ID_GENERATOR", strategy="native")	
	private int report_period_week_id;
	
	@Column(name="calendar_year", nullable=true, length=11)	
	private Integer calendar_year;
	
	@Column(name="week_value", nullable=true, length=11)	
	private Integer week_value;
	
	@Column(name="week_from_date", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date week_from_date;
	
	@Column(name="week_to_date", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date week_to_date;
	
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
	
	private void setReport_period_week_id(int value) {
		this.report_period_week_id = value;
	}
	
	public int getReport_period_week_id() {
		return report_period_week_id;
	}
	
	public int getORMID() {
		return getReport_period_week_id();
	}
	
	public void setCalendar_year(int value) {
		setCalendar_year(new Integer(value));
	}
	
	public void setCalendar_year(Integer value) {
		this.calendar_year = value;
	}
	
	public Integer getCalendar_year() {
		return calendar_year;
	}
	
	public void setWeek_value(int value) {
		setWeek_value(new Integer(value));
	}
	
	public void setWeek_value(Integer value) {
		this.week_value = value;
	}
	
	public Integer getWeek_value() {
		return week_value;
	}
	
	public void setWeek_from_date(java.util.Date value) {
		this.week_from_date = value;
	}
	
	public java.util.Date getWeek_from_date() {
		return week_from_date;
	}
	
	public void setWeek_to_date(java.util.Date value) {
		this.week_to_date = value;
	}
	
	public java.util.Date getWeek_to_date() {
		return week_to_date;
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
	
	/**
	 * Testing
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Report_period_week object = (Report_period_week) obj;
		return (this.getReport_period_week_id() == object.getReport_period_week_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getReport_period_week_id());
	}
	
}

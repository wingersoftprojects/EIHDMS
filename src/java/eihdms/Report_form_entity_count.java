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
@Table(name="report_form_entity_count")
public class Report_form_entity_count implements Serializable {
	public Report_form_entity_count() {
	}
	
	public static Report_form_entity_count loadReport_form_entity_countByORMID(int report_form_entity_count_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_form_entity_countByORMID(session, report_form_entity_count_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_entity_count getReport_form_entity_countByORMID(int report_form_entity_count_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getReport_form_entity_countByORMID(session, report_form_entity_count_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_entity_count loadReport_form_entity_countByORMID(int report_form_entity_count_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_form_entity_countByORMID(session, report_form_entity_count_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_entity_count getReport_form_entity_countByORMID(int report_form_entity_count_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getReport_form_entity_countByORMID(session, report_form_entity_count_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_entity_count loadReport_form_entity_countByORMID(PersistentSession session, int report_form_entity_count_id) throws PersistentException {
		try {
			return (Report_form_entity_count) session.load(eihdms.Report_form_entity_count.class, new Integer(report_form_entity_count_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_entity_count getReport_form_entity_countByORMID(PersistentSession session, int report_form_entity_count_id) throws PersistentException {
		try {
			return (Report_form_entity_count) session.get(eihdms.Report_form_entity_count.class, new Integer(report_form_entity_count_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_entity_count loadReport_form_entity_countByORMID(PersistentSession session, int report_form_entity_count_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Report_form_entity_count) session.load(eihdms.Report_form_entity_count.class, new Integer(report_form_entity_count_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_entity_count getReport_form_entity_countByORMID(PersistentSession session, int report_form_entity_count_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Report_form_entity_count) session.get(eihdms.Report_form_entity_count.class, new Integer(report_form_entity_count_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_form_entity_count(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryReport_form_entity_count(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_form_entity_count(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryReport_form_entity_count(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_entity_count[] listReport_form_entity_countByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listReport_form_entity_countByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_entity_count[] listReport_form_entity_countByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listReport_form_entity_countByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_form_entity_count(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form_entity_count as Report_form_entity_count");
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
	
	public static List queryReport_form_entity_count(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form_entity_count as Report_form_entity_count");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Report_form_entity_count", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_entity_count[] listReport_form_entity_countByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryReport_form_entity_count(session, condition, orderBy);
			return (Report_form_entity_count[]) list.toArray(new Report_form_entity_count[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_entity_count[] listReport_form_entity_countByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryReport_form_entity_count(session, condition, orderBy, lockMode);
			return (Report_form_entity_count[]) list.toArray(new Report_form_entity_count[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_entity_count loadReport_form_entity_countByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_form_entity_countByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_entity_count loadReport_form_entity_countByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_form_entity_countByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_entity_count loadReport_form_entity_countByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Report_form_entity_count[] report_form_entity_counts = listReport_form_entity_countByQuery(session, condition, orderBy);
		if (report_form_entity_counts != null && report_form_entity_counts.length > 0)
			return report_form_entity_counts[0];
		else
			return null;
	}
	
	public static Report_form_entity_count loadReport_form_entity_countByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Report_form_entity_count[] report_form_entity_counts = listReport_form_entity_countByQuery(session, condition, orderBy, lockMode);
		if (report_form_entity_counts != null && report_form_entity_counts.length > 0)
			return report_form_entity_counts[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateReport_form_entity_countByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateReport_form_entity_countByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReport_form_entity_countByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateReport_form_entity_countByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReport_form_entity_countByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form_entity_count as Report_form_entity_count");
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
	
	public static java.util.Iterator iterateReport_form_entity_countByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form_entity_count as Report_form_entity_count");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Report_form_entity_count", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_entity_count loadReport_form_entity_countByCriteria(Report_form_entity_countCriteria report_form_entity_countCriteria) {
		Report_form_entity_count[] report_form_entity_counts = listReport_form_entity_countByCriteria(report_form_entity_countCriteria);
		if(report_form_entity_counts == null || report_form_entity_counts.length == 0) {
			return null;
		}
		return report_form_entity_counts[0];
	}
	
	public static Report_form_entity_count[] listReport_form_entity_countByCriteria(Report_form_entity_countCriteria report_form_entity_countCriteria) {
		return report_form_entity_countCriteria.listReport_form_entity_count();
	}
	
	public static Report_form_entity_count createReport_form_entity_count() {
		return new eihdms.Report_form_entity_count();
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
				getReport_form().getReport_form_entity_count().remove(this);
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
				getReport_form().getReport_form_entity_count().remove(this);
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
	
	@Column(name="report_form_entity_count_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_REPORT_FORM_ENTITY_COUNT_REPORT_FORM_ENTITY_COUNT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_REPORT_FORM_ENTITY_COUNT_REPORT_FORM_ENTITY_COUNT_ID_GENERATOR", strategy="native")	
	private int report_form_entity_count_id;
	
	@ManyToOne(targetEntity=eihdms.Report_form.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="report_form_id", referencedColumnName="report_form_id", nullable=false) }, foreignKey=@ForeignKey(name="FKreport_for328608"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Report_form report_form;
	
	@Column(name="entity_count", nullable=false, length=11)	
	private int entity_count;
	
	@Column(name="count_date", nullable=false)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date count_date;
	
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
	
	private void setReport_form_entity_count_id(int value) {
		this.report_form_entity_count_id = value;
	}
	
	public int getReport_form_entity_count_id() {
		return report_form_entity_count_id;
	}
	
	public int getORMID() {
		return getReport_form_entity_count_id();
	}
	
	public void setEntity_count(int value) {
		this.entity_count = value;
	}
	
	public int getEntity_count() {
		return entity_count;
	}
	
	public void setCount_date(java.util.Date value) {
		this.count_date = value;
	}
	
	public java.util.Date getCount_date() {
		return count_date;
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
	
	@Transient	
	private int report_form_id;
	
	public String toString() {
		return String.valueOf(getReport_form_entity_count_id());
	}
	
}

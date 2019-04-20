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
@Table(name="loaded_data_summary")
public class Loaded_data_summary implements Serializable {
	public Loaded_data_summary() {
	}
	
	public static Loaded_data_summary loadLoaded_data_summaryByORMID(int loaded_data_summary_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadLoaded_data_summaryByORMID(session, loaded_data_summary_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Loaded_data_summary getLoaded_data_summaryByORMID(int loaded_data_summary_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getLoaded_data_summaryByORMID(session, loaded_data_summary_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Loaded_data_summary loadLoaded_data_summaryByORMID(int loaded_data_summary_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadLoaded_data_summaryByORMID(session, loaded_data_summary_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Loaded_data_summary getLoaded_data_summaryByORMID(int loaded_data_summary_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getLoaded_data_summaryByORMID(session, loaded_data_summary_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Loaded_data_summary loadLoaded_data_summaryByORMID(PersistentSession session, int loaded_data_summary_id) throws PersistentException {
		try {
			return (Loaded_data_summary) session.load(eihdms.Loaded_data_summary.class, new Integer(loaded_data_summary_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Loaded_data_summary getLoaded_data_summaryByORMID(PersistentSession session, int loaded_data_summary_id) throws PersistentException {
		try {
			return (Loaded_data_summary) session.get(eihdms.Loaded_data_summary.class, new Integer(loaded_data_summary_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Loaded_data_summary loadLoaded_data_summaryByORMID(PersistentSession session, int loaded_data_summary_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Loaded_data_summary) session.load(eihdms.Loaded_data_summary.class, new Integer(loaded_data_summary_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Loaded_data_summary getLoaded_data_summaryByORMID(PersistentSession session, int loaded_data_summary_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Loaded_data_summary) session.get(eihdms.Loaded_data_summary.class, new Integer(loaded_data_summary_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLoaded_data_summary(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryLoaded_data_summary(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLoaded_data_summary(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryLoaded_data_summary(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Loaded_data_summary[] listLoaded_data_summaryByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listLoaded_data_summaryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Loaded_data_summary[] listLoaded_data_summaryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listLoaded_data_summaryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLoaded_data_summary(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Loaded_data_summary as Loaded_data_summary");
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
	
	public static List queryLoaded_data_summary(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Loaded_data_summary as Loaded_data_summary");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Loaded_data_summary", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Loaded_data_summary[] listLoaded_data_summaryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryLoaded_data_summary(session, condition, orderBy);
			return (Loaded_data_summary[]) list.toArray(new Loaded_data_summary[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Loaded_data_summary[] listLoaded_data_summaryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryLoaded_data_summary(session, condition, orderBy, lockMode);
			return (Loaded_data_summary[]) list.toArray(new Loaded_data_summary[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Loaded_data_summary loadLoaded_data_summaryByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadLoaded_data_summaryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Loaded_data_summary loadLoaded_data_summaryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadLoaded_data_summaryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Loaded_data_summary loadLoaded_data_summaryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Loaded_data_summary[] loaded_data_summarys = listLoaded_data_summaryByQuery(session, condition, orderBy);
		if (loaded_data_summarys != null && loaded_data_summarys.length > 0)
			return loaded_data_summarys[0];
		else
			return null;
	}
	
	public static Loaded_data_summary loadLoaded_data_summaryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Loaded_data_summary[] loaded_data_summarys = listLoaded_data_summaryByQuery(session, condition, orderBy, lockMode);
		if (loaded_data_summarys != null && loaded_data_summarys.length > 0)
			return loaded_data_summarys[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateLoaded_data_summaryByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateLoaded_data_summaryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLoaded_data_summaryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateLoaded_data_summaryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLoaded_data_summaryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Loaded_data_summary as Loaded_data_summary");
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
	
	public static java.util.Iterator iterateLoaded_data_summaryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Loaded_data_summary as Loaded_data_summary");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Loaded_data_summary", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Loaded_data_summary loadLoaded_data_summaryByCriteria(Loaded_data_summaryCriteria loaded_data_summaryCriteria) {
		Loaded_data_summary[] loaded_data_summarys = listLoaded_data_summaryByCriteria(loaded_data_summaryCriteria);
		if(loaded_data_summarys == null || loaded_data_summarys.length == 0) {
			return null;
		}
		return loaded_data_summarys[0];
	}
	
	public static Loaded_data_summary[] listLoaded_data_summaryByCriteria(Loaded_data_summaryCriteria loaded_data_summaryCriteria) {
		return loaded_data_summaryCriteria.listLoaded_data_summary();
	}
	
	public static Loaded_data_summary createLoaded_data_summary() {
		return new eihdms.Loaded_data_summary();
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
	
	@Column(name="loaded_data_summary_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_LOADED_DATA_SUMMARY_LOADED_DATA_SUMMARY_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_LOADED_DATA_SUMMARY_LOADED_DATA_SUMMARY_ID_GENERATOR", strategy="native")	
	private int loaded_data_summary_id;
	
	@Column(name="report_period_month", nullable=true, length=11)	
	private Integer report_period_month;
	
	@Column(name="report_period_week", nullable=true, length=11)	
	private Integer report_period_week;
	
	@Column(name="report_period_year", nullable=true, length=11)	
	private Integer report_period_year;
	
	@Column(name="report_period_quarter", nullable=true, length=11)	
	private Integer report_period_quarter;
	
	@Column(name="report_period_bi_month", nullable=true, length=11)	
	private Integer report_period_bi_month;
	
	@Column(name="report_form_group_id", nullable=true, length=11)	
	private Integer report_form_group_id;
	
	@Column(name="report_form_id", nullable=true, length=11)	
	private Integer report_form_id;
	
	@Column(name="batch_id", nullable=true, length=11)	
	private Integer batch_id;
	
	@Column(name="add_date", nullable=true)	
	private java.sql.Timestamp add_date;
	
	@Column(name="add_by", nullable=true, length=10)	
	private Integer add_by;
	
	@Column(name="loaded_records", nullable=true, length=11)	
	private Integer loaded_records;
	
	@Column(name="last_edit_date", nullable=true)	
	private java.sql.Timestamp last_edit_date;
	
	@Column(name="last_edit_by", nullable=true, length=11)	
	private Integer last_edit_by;
	
	@Column(name="loaded_entities", nullable=true, length=11)	
	private Integer loaded_entities;
	
	@Column(name="loaded_data_elements", nullable=true, length=11)	
	private Integer loaded_data_elements;
	
	private void setLoaded_data_summary_id(int value) {
		this.loaded_data_summary_id = value;
	}
	
	public int getLoaded_data_summary_id() {
		return loaded_data_summary_id;
	}
	
	public int getORMID() {
		return getLoaded_data_summary_id();
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
	
	public void setReport_period_bi_month(int value) {
		setReport_period_bi_month(new Integer(value));
	}
	
	public void setReport_period_bi_month(Integer value) {
		this.report_period_bi_month = value;
	}
	
	public Integer getReport_period_bi_month() {
		return report_period_bi_month;
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
	
	public void setReport_form_id(int value) {
		setReport_form_id(new Integer(value));
	}
	
	public void setReport_form_id(Integer value) {
		this.report_form_id = value;
	}
	
	public Integer getReport_form_id() {
		return report_form_id;
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
	
	public void setLoaded_records(int value) {
		setLoaded_records(new Integer(value));
	}
	
	public void setLoaded_records(Integer value) {
		this.loaded_records = value;
	}
	
	public Integer getLoaded_records() {
		return loaded_records;
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
	
	public void setLoaded_entities(int value) {
		setLoaded_entities(new Integer(value));
	}
	
	public void setLoaded_entities(Integer value) {
		this.loaded_entities = value;
	}
	
	public Integer getLoaded_entities() {
		return loaded_entities;
	}
	
	public void setLoaded_data_elements(int value) {
		setLoaded_data_elements(new Integer(value));
	}
	
	public void setLoaded_data_elements(Integer value) {
		this.loaded_data_elements = value;
	}
	
	public Integer getLoaded_data_elements() {
		return loaded_data_elements;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Loaded_data_summary object = (Loaded_data_summary) obj;
		return (this.getLoaded_data_summary_id() == object.getLoaded_data_summary_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getLoaded_data_summary_id());
	}
	
}

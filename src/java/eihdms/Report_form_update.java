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
@Table(name="report_form_update")
public class Report_form_update implements Serializable {
	public Report_form_update() {
	}
	
	public static Report_form_update loadReport_form_updateByORMID(int report_form_update_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_form_updateByORMID(session, report_form_update_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_update getReport_form_updateByORMID(int report_form_update_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getReport_form_updateByORMID(session, report_form_update_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_update loadReport_form_updateByORMID(int report_form_update_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_form_updateByORMID(session, report_form_update_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_update getReport_form_updateByORMID(int report_form_update_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getReport_form_updateByORMID(session, report_form_update_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_update loadReport_form_updateByORMID(PersistentSession session, int report_form_update_id) throws PersistentException {
		try {
			return (Report_form_update) session.load(eihdms.Report_form_update.class, new Integer(report_form_update_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_update getReport_form_updateByORMID(PersistentSession session, int report_form_update_id) throws PersistentException {
		try {
			return (Report_form_update) session.get(eihdms.Report_form_update.class, new Integer(report_form_update_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_update loadReport_form_updateByORMID(PersistentSession session, int report_form_update_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Report_form_update) session.load(eihdms.Report_form_update.class, new Integer(report_form_update_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_update getReport_form_updateByORMID(PersistentSession session, int report_form_update_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Report_form_update) session.get(eihdms.Report_form_update.class, new Integer(report_form_update_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_form_update(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryReport_form_update(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_form_update(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryReport_form_update(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_update[] listReport_form_updateByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listReport_form_updateByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_update[] listReport_form_updateByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listReport_form_updateByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_form_update(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form_update as Report_form_update");
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
	
	public static List queryReport_form_update(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form_update as Report_form_update");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Report_form_update", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_update[] listReport_form_updateByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryReport_form_update(session, condition, orderBy);
			return (Report_form_update[]) list.toArray(new Report_form_update[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_update[] listReport_form_updateByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryReport_form_update(session, condition, orderBy, lockMode);
			return (Report_form_update[]) list.toArray(new Report_form_update[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_update loadReport_form_updateByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_form_updateByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_update loadReport_form_updateByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_form_updateByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_update loadReport_form_updateByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Report_form_update[] report_form_updates = listReport_form_updateByQuery(session, condition, orderBy);
		if (report_form_updates != null && report_form_updates.length > 0)
			return report_form_updates[0];
		else
			return null;
	}
	
	public static Report_form_update loadReport_form_updateByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Report_form_update[] report_form_updates = listReport_form_updateByQuery(session, condition, orderBy, lockMode);
		if (report_form_updates != null && report_form_updates.length > 0)
			return report_form_updates[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateReport_form_updateByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateReport_form_updateByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReport_form_updateByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateReport_form_updateByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReport_form_updateByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form_update as Report_form_update");
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
	
	public static java.util.Iterator iterateReport_form_updateByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form_update as Report_form_update");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Report_form_update", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_update loadReport_form_updateByCriteria(Report_form_updateCriteria report_form_updateCriteria) {
		Report_form_update[] report_form_updates = listReport_form_updateByCriteria(report_form_updateCriteria);
		if(report_form_updates == null || report_form_updates.length == 0) {
			return null;
		}
		return report_form_updates[0];
	}
	
	public static Report_form_update[] listReport_form_updateByCriteria(Report_form_updateCriteria report_form_updateCriteria) {
		return report_form_updateCriteria.listReport_form_update();
	}
	
	public static Report_form_update createReport_form_update() {
		return new eihdms.Report_form_update();
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
	
	@Column(name="report_form_update_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_REPORT_FORM_UPDATE_REPORT_FORM_UPDATE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_REPORT_FORM_UPDATE_REPORT_FORM_UPDATE_ID_GENERATOR", strategy="native")	
	private int report_form_update_id;
	
	@Column(name="report_form_id", nullable=false, length=11)	
	private int report_form_id;
	
	@Column(name="last_edit_date", nullable=false)	
	private java.sql.Timestamp last_edit_date;
	
	private void setReport_form_update_id(int value) {
		this.report_form_update_id = value;
	}
	
	public int getReport_form_update_id() {
		return report_form_update_id;
	}
	
	public int getORMID() {
		return getReport_form_update_id();
	}
	
	public void setReport_form_id(int value) {
		this.report_form_id = value;
	}
	
	public int getReport_form_id() {
		return report_form_id;
	}
	
	public void setLast_edit_date(java.sql.Timestamp value) {
		this.last_edit_date = value;
	}
	
	public java.sql.Timestamp getLast_edit_date() {
		return last_edit_date;
	}
	
	public String toString() {
		return String.valueOf(getReport_form_update_id());
	}
	
}

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
@Table(name="batch_mob_app")
public class Batch_mob_app implements Serializable {
	public Batch_mob_app() {
	}
	
	public static Batch_mob_app loadBatch_mob_appByORMID(int batch_mob_app_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadBatch_mob_appByORMID(session, batch_mob_app_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Batch_mob_app getBatch_mob_appByORMID(int batch_mob_app_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getBatch_mob_appByORMID(session, batch_mob_app_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Batch_mob_app loadBatch_mob_appByORMID(int batch_mob_app_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadBatch_mob_appByORMID(session, batch_mob_app_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Batch_mob_app getBatch_mob_appByORMID(int batch_mob_app_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getBatch_mob_appByORMID(session, batch_mob_app_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Batch_mob_app loadBatch_mob_appByORMID(PersistentSession session, int batch_mob_app_id) throws PersistentException {
		try {
			return (Batch_mob_app) session.load(eihdms.Batch_mob_app.class, new Integer(batch_mob_app_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Batch_mob_app getBatch_mob_appByORMID(PersistentSession session, int batch_mob_app_id) throws PersistentException {
		try {
			return (Batch_mob_app) session.get(eihdms.Batch_mob_app.class, new Integer(batch_mob_app_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Batch_mob_app loadBatch_mob_appByORMID(PersistentSession session, int batch_mob_app_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Batch_mob_app) session.load(eihdms.Batch_mob_app.class, new Integer(batch_mob_app_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Batch_mob_app getBatch_mob_appByORMID(PersistentSession session, int batch_mob_app_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Batch_mob_app) session.get(eihdms.Batch_mob_app.class, new Integer(batch_mob_app_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBatch_mob_app(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryBatch_mob_app(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBatch_mob_app(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryBatch_mob_app(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Batch_mob_app[] listBatch_mob_appByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listBatch_mob_appByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Batch_mob_app[] listBatch_mob_appByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listBatch_mob_appByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBatch_mob_app(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Batch_mob_app as Batch_mob_app");
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
	
	public static List queryBatch_mob_app(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Batch_mob_app as Batch_mob_app");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Batch_mob_app", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Batch_mob_app[] listBatch_mob_appByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryBatch_mob_app(session, condition, orderBy);
			return (Batch_mob_app[]) list.toArray(new Batch_mob_app[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Batch_mob_app[] listBatch_mob_appByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryBatch_mob_app(session, condition, orderBy, lockMode);
			return (Batch_mob_app[]) list.toArray(new Batch_mob_app[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Batch_mob_app loadBatch_mob_appByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadBatch_mob_appByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Batch_mob_app loadBatch_mob_appByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadBatch_mob_appByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Batch_mob_app loadBatch_mob_appByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Batch_mob_app[] batch_mob_apps = listBatch_mob_appByQuery(session, condition, orderBy);
		if (batch_mob_apps != null && batch_mob_apps.length > 0)
			return batch_mob_apps[0];
		else
			return null;
	}
	
	public static Batch_mob_app loadBatch_mob_appByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Batch_mob_app[] batch_mob_apps = listBatch_mob_appByQuery(session, condition, orderBy, lockMode);
		if (batch_mob_apps != null && batch_mob_apps.length > 0)
			return batch_mob_apps[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateBatch_mob_appByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateBatch_mob_appByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBatch_mob_appByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateBatch_mob_appByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBatch_mob_appByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Batch_mob_app as Batch_mob_app");
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
	
	public static java.util.Iterator iterateBatch_mob_appByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Batch_mob_app as Batch_mob_app");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Batch_mob_app", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Batch_mob_app loadBatch_mob_appByCriteria(Batch_mob_appCriteria batch_mob_appCriteria) {
		Batch_mob_app[] batch_mob_apps = listBatch_mob_appByCriteria(batch_mob_appCriteria);
		if(batch_mob_apps == null || batch_mob_apps.length == 0) {
			return null;
		}
		return batch_mob_apps[0];
	}
	
	public static Batch_mob_app[] listBatch_mob_appByCriteria(Batch_mob_appCriteria batch_mob_appCriteria) {
		return batch_mob_appCriteria.listBatch_mob_app();
	}
	
	public static Batch_mob_app createBatch_mob_app() {
		return new eihdms.Batch_mob_app();
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
	
	@Column(name="batch_mob_app_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_BATCH_MOB_APP_BATCH_MOB_APP_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_BATCH_MOB_APP_BATCH_MOB_APP_ID_GENERATOR", strategy="native")	
	private int batch_mob_app_id;
	
	@Column(name="is_completed", nullable=false, length=1)	
	private int is_completed;
	
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
	
	@Column(name="status_m", nullable=true, length=50)	
	private String status_m;
	
	@Column(name="status_m_desc", nullable=true)	
	private String status_m_desc;
	
	private void setBatch_mob_app_id(int value) {
		this.batch_mob_app_id = value;
	}
	
	public int getBatch_mob_app_id() {
		return batch_mob_app_id;
	}
	
	public int getORMID() {
		return getBatch_mob_app_id();
	}
	
	public void setIs_completed(int value) {
		this.is_completed = value;
	}
	
	public int getIs_completed() {
		return is_completed;
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
	
	public void setStatus_m(String value) {
		this.status_m = value;
	}
	
	public String getStatus_m() {
		return status_m;
	}
	
	public void setStatus_m_desc(String value) {
		this.status_m_desc = value;
	}
	
	public String getStatus_m_desc() {
		return status_m_desc;
	}
	
	public String toString() {
		return String.valueOf(getBatch_mob_app_id());
	}
	
}

/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: wence.twesigye
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
@Table(name="sms_category")
public class Sms_category implements Serializable {
	public Sms_category() {
	}
	
	public static Sms_category loadSms_categoryByORMID(int sms_category_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSms_categoryByORMID(session, sms_category_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_category getSms_categoryByORMID(int sms_category_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getSms_categoryByORMID(session, sms_category_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_category loadSms_categoryByORMID(int sms_category_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSms_categoryByORMID(session, sms_category_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_category getSms_categoryByORMID(int sms_category_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getSms_categoryByORMID(session, sms_category_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_category loadSms_categoryByORMID(PersistentSession session, int sms_category_id) throws PersistentException {
		try {
			return (Sms_category) session.load(eihdms.Sms_category.class, new Integer(sms_category_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_category getSms_categoryByORMID(PersistentSession session, int sms_category_id) throws PersistentException {
		try {
			return (Sms_category) session.get(eihdms.Sms_category.class, new Integer(sms_category_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_category loadSms_categoryByORMID(PersistentSession session, int sms_category_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sms_category) session.load(eihdms.Sms_category.class, new Integer(sms_category_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_category getSms_categoryByORMID(PersistentSession session, int sms_category_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sms_category) session.get(eihdms.Sms_category.class, new Integer(sms_category_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySms_category(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return querySms_category(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySms_category(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return querySms_category(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_category[] listSms_categoryByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listSms_categoryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_category[] listSms_categoryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listSms_categoryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySms_category(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sms_category as Sms_category");
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
	
	public static List querySms_category(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sms_category as Sms_category");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sms_category", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_category[] listSms_categoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySms_category(session, condition, orderBy);
			return (Sms_category[]) list.toArray(new Sms_category[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_category[] listSms_categoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySms_category(session, condition, orderBy, lockMode);
			return (Sms_category[]) list.toArray(new Sms_category[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_category loadSms_categoryByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSms_categoryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_category loadSms_categoryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSms_categoryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_category loadSms_categoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Sms_category[] sms_categorys = listSms_categoryByQuery(session, condition, orderBy);
		if (sms_categorys != null && sms_categorys.length > 0)
			return sms_categorys[0];
		else
			return null;
	}
	
	public static Sms_category loadSms_categoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Sms_category[] sms_categorys = listSms_categoryByQuery(session, condition, orderBy, lockMode);
		if (sms_categorys != null && sms_categorys.length > 0)
			return sms_categorys[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSms_categoryByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateSms_categoryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSms_categoryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateSms_categoryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSms_categoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sms_category as Sms_category");
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
	
	public static java.util.Iterator iterateSms_categoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sms_category as Sms_category");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sms_category", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_category loadSms_categoryByCriteria(Sms_categoryCriteria sms_categoryCriteria) {
		Sms_category[] sms_categorys = listSms_categoryByCriteria(sms_categoryCriteria);
		if(sms_categorys == null || sms_categorys.length == 0) {
			return null;
		}
		return sms_categorys[0];
	}
	
	public static Sms_category[] listSms_categoryByCriteria(Sms_categoryCriteria sms_categoryCriteria) {
		return sms_categoryCriteria.listSms_category();
	}
	
	public static Sms_category createSms_category() {
		return new eihdms.Sms_category();
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
	
	@Column(name="sms_category_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_SMS_CATEGORY_SMS_CATEGORY_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_SMS_CATEGORY_SMS_CATEGORY_ID_GENERATOR", strategy="native")	
	private int sms_category_id;
	
	@Column(name="sms_category_name", nullable=true, length=20)	
	private String sms_category_name;
	
	@Column(name="sms_category_desc", nullable=true, length=255)	
	private String sms_category_desc;
	
	@Column(name="data_entry_scope", nullable=true, length=20)	
	private String data_entry_scope;
	
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
	
	private void setSms_category_id(int value) {
		this.sms_category_id = value;
	}
	
	public int getSms_category_id() {
		return sms_category_id;
	}
	
	public int getORMID() {
		return getSms_category_id();
	}
	
	public void setSms_category_name(String value) {
		this.sms_category_name = value;
	}
	
	public String getSms_category_name() {
		return sms_category_name;
	}
	
	public void setSms_category_desc(String value) {
		this.sms_category_desc = value;
	}
	
	public String getSms_category_desc() {
		return sms_category_desc;
	}
	
	public void setData_entry_scope(String value) {
		this.data_entry_scope = value;
	}
	
	public String getData_entry_scope() {
		return data_entry_scope;
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
	
	public String toString() {
		return String.valueOf(getSms_category_id());
	}
	
}

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
@Table(name="sms_recipient")
public class Sms_recipient implements Serializable {
	public Sms_recipient() {
	}
	
	public static Sms_recipient loadSms_recipientByORMID(int sms_recipient_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSms_recipientByORMID(session, sms_recipient_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_recipient getSms_recipientByORMID(int sms_recipient_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getSms_recipientByORMID(session, sms_recipient_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_recipient loadSms_recipientByORMID(int sms_recipient_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSms_recipientByORMID(session, sms_recipient_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_recipient getSms_recipientByORMID(int sms_recipient_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getSms_recipientByORMID(session, sms_recipient_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_recipient loadSms_recipientByORMID(PersistentSession session, int sms_recipient_id) throws PersistentException {
		try {
			return (Sms_recipient) session.load(eihdms.Sms_recipient.class, new Integer(sms_recipient_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_recipient getSms_recipientByORMID(PersistentSession session, int sms_recipient_id) throws PersistentException {
		try {
			return (Sms_recipient) session.get(eihdms.Sms_recipient.class, new Integer(sms_recipient_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_recipient loadSms_recipientByORMID(PersistentSession session, int sms_recipient_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sms_recipient) session.load(eihdms.Sms_recipient.class, new Integer(sms_recipient_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_recipient getSms_recipientByORMID(PersistentSession session, int sms_recipient_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sms_recipient) session.get(eihdms.Sms_recipient.class, new Integer(sms_recipient_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySms_recipient(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return querySms_recipient(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySms_recipient(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return querySms_recipient(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_recipient[] listSms_recipientByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listSms_recipientByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_recipient[] listSms_recipientByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listSms_recipientByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySms_recipient(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sms_recipient as Sms_recipient");
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
	
	public static List querySms_recipient(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sms_recipient as Sms_recipient");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sms_recipient", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_recipient[] listSms_recipientByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySms_recipient(session, condition, orderBy);
			return (Sms_recipient[]) list.toArray(new Sms_recipient[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_recipient[] listSms_recipientByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySms_recipient(session, condition, orderBy, lockMode);
			return (Sms_recipient[]) list.toArray(new Sms_recipient[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_recipient loadSms_recipientByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSms_recipientByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_recipient loadSms_recipientByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSms_recipientByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_recipient loadSms_recipientByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Sms_recipient[] sms_recipients = listSms_recipientByQuery(session, condition, orderBy);
		if (sms_recipients != null && sms_recipients.length > 0)
			return sms_recipients[0];
		else
			return null;
	}
	
	public static Sms_recipient loadSms_recipientByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Sms_recipient[] sms_recipients = listSms_recipientByQuery(session, condition, orderBy, lockMode);
		if (sms_recipients != null && sms_recipients.length > 0)
			return sms_recipients[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSms_recipientByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateSms_recipientByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSms_recipientByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateSms_recipientByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSms_recipientByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sms_recipient as Sms_recipient");
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
	
	public static java.util.Iterator iterateSms_recipientByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sms_recipient as Sms_recipient");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sms_recipient", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sms_recipient loadSms_recipientByCriteria(Sms_recipientCriteria sms_recipientCriteria) {
		Sms_recipient[] sms_recipients = listSms_recipientByCriteria(sms_recipientCriteria);
		if(sms_recipients == null || sms_recipients.length == 0) {
			return null;
		}
		return sms_recipients[0];
	}
	
	public static Sms_recipient[] listSms_recipientByCriteria(Sms_recipientCriteria sms_recipientCriteria) {
		return sms_recipientCriteria.listSms_recipient();
	}
	
	public static Sms_recipient createSms_recipient() {
		return new eihdms.Sms_recipient();
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
	
	@Column(name="sms_recipient_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_SMS_RECIPIENT_SMS_RECIPIENT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_SMS_RECIPIENT_SMS_RECIPIENT_ID_GENERATOR", strategy="native")	
	private int sms_recipient_id;
	
	@Column(name="sms_schedule_id", nullable=true, length=11)	
	private Integer sms_schedule_id;
	
	@Column(name="phone", nullable=true, length=100)	
	private String phone;
	
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
	
	private void setSms_recipient_id(int value) {
		this.sms_recipient_id = value;
	}
	
	public int getSms_recipient_id() {
		return sms_recipient_id;
	}
	
	public int getORMID() {
		return getSms_recipient_id();
	}
	
	public void setSms_schedule_id(int value) {
		setSms_schedule_id(new Integer(value));
	}
	
	public void setSms_schedule_id(Integer value) {
		this.sms_schedule_id = value;
	}
	
	public Integer getSms_schedule_id() {
		return sms_schedule_id;
	}
	
	public void setPhone(String value) {
		this.phone = value;
	}
	
	public String getPhone() {
		return phone;
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
		Sms_recipient object = (Sms_recipient) obj;
		return (this.getSms_recipient_id() == object.getSms_recipient_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getSms_recipient_id());
	}
	
}

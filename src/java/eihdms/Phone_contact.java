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
@Table(name="phone_contact")
public class Phone_contact implements Serializable {
	public Phone_contact() {
	}
	
	public static Phone_contact loadPhone_contactByORMID(int phone_contact_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadPhone_contactByORMID(session, phone_contact_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Phone_contact getPhone_contactByORMID(int phone_contact_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getPhone_contactByORMID(session, phone_contact_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Phone_contact loadPhone_contactByORMID(int phone_contact_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadPhone_contactByORMID(session, phone_contact_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Phone_contact getPhone_contactByORMID(int phone_contact_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getPhone_contactByORMID(session, phone_contact_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Phone_contact loadPhone_contactByORMID(PersistentSession session, int phone_contact_id) throws PersistentException {
		try {
			return (Phone_contact) session.load(eihdms.Phone_contact.class, new Integer(phone_contact_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Phone_contact getPhone_contactByORMID(PersistentSession session, int phone_contact_id) throws PersistentException {
		try {
			return (Phone_contact) session.get(eihdms.Phone_contact.class, new Integer(phone_contact_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Phone_contact loadPhone_contactByORMID(PersistentSession session, int phone_contact_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Phone_contact) session.load(eihdms.Phone_contact.class, new Integer(phone_contact_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Phone_contact getPhone_contactByORMID(PersistentSession session, int phone_contact_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Phone_contact) session.get(eihdms.Phone_contact.class, new Integer(phone_contact_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPhone_contact(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryPhone_contact(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPhone_contact(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryPhone_contact(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Phone_contact[] listPhone_contactByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listPhone_contactByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Phone_contact[] listPhone_contactByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listPhone_contactByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPhone_contact(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Phone_contact as Phone_contact");
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
	
	public static List queryPhone_contact(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Phone_contact as Phone_contact");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Phone_contact", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Phone_contact[] listPhone_contactByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPhone_contact(session, condition, orderBy);
			return (Phone_contact[]) list.toArray(new Phone_contact[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Phone_contact[] listPhone_contactByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPhone_contact(session, condition, orderBy, lockMode);
			return (Phone_contact[]) list.toArray(new Phone_contact[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Phone_contact loadPhone_contactByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadPhone_contactByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Phone_contact loadPhone_contactByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadPhone_contactByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Phone_contact loadPhone_contactByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Phone_contact[] phone_contacts = listPhone_contactByQuery(session, condition, orderBy);
		if (phone_contacts != null && phone_contacts.length > 0)
			return phone_contacts[0];
		else
			return null;
	}
	
	public static Phone_contact loadPhone_contactByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Phone_contact[] phone_contacts = listPhone_contactByQuery(session, condition, orderBy, lockMode);
		if (phone_contacts != null && phone_contacts.length > 0)
			return phone_contacts[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePhone_contactByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iteratePhone_contactByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePhone_contactByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iteratePhone_contactByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePhone_contactByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Phone_contact as Phone_contact");
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
	
	public static java.util.Iterator iteratePhone_contactByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Phone_contact as Phone_contact");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Phone_contact", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Phone_contact loadPhone_contactByCriteria(Phone_contactCriteria phone_contactCriteria) {
		Phone_contact[] phone_contacts = listPhone_contactByCriteria(phone_contactCriteria);
		if(phone_contacts == null || phone_contacts.length == 0) {
			return null;
		}
		return phone_contacts[0];
	}
	
	public static Phone_contact[] listPhone_contactByCriteria(Phone_contactCriteria phone_contactCriteria) {
		return phone_contactCriteria.listPhone_contact();
	}
	
	public static Phone_contact createPhone_contact() {
		return new eihdms.Phone_contact();
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
	
	@Column(name="phone_contact_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_PHONE_CONTACT_PHONE_CONTACT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_PHONE_CONTACT_PHONE_CONTACT_ID_GENERATOR", strategy="native")	
	private int phone_contact_id;
	
	@Column(name="entity_type", nullable=false, length=20)	
	private String entity_type;
	
	@Column(name="entity_id", nullable=false, length=11)	
	private int entity_id;
	
	@Column(name="entity_phone", nullable=false, length=100)	
	private String entity_phone;
	
	@Column(name="is_deleted", nullable=false, length=1)	
	private int is_deleted;
	
	@Column(name="is_active", nullable=false, length=1)	
	private int is_active;
	
	@Column(name="add_date", nullable=false)	
	private java.sql.Timestamp add_date;
	
	@Column(name="add_by", nullable=false, length=10)	
	private Integer add_by;
	
	@Column(name="last_edit_date", nullable=true)	
	private java.sql.Timestamp last_edit_date;
	
	@Column(name="last_edit_by", nullable=true, length=10)	
	private Integer last_edit_by;
	
	private void setPhone_contact_id(int value) {
		this.phone_contact_id = value;
	}
	
	public int getPhone_contact_id() {
		return phone_contact_id;
	}
	
	public int getORMID() {
		return getPhone_contact_id();
	}
	
	public void setEntity_type(String value) {
		this.entity_type = value;
	}
	
	public String getEntity_type() {
		return entity_type;
	}
	
	public void setEntity_id(int value) {
		this.entity_id = value;
	}
	
	public int getEntity_id() {
		return entity_id;
	}
	
	public void setEntity_phone(String value) {
		this.entity_phone = value;
	}
	
	public String getEntity_phone() {
		return entity_phone;
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
		Phone_contact object = (Phone_contact) obj;
		return (this.getPhone_contact_id() == object.getPhone_contact_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getPhone_contact_id());
	}
	
}

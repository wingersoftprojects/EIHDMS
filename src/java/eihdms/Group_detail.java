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
@Table(name="group_detail")
public class Group_detail implements Serializable {
	public Group_detail() {
	}
	
	public static Group_detail loadGroup_detailByORMID(int group_detail_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadGroup_detailByORMID(session, group_detail_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Group_detail getGroup_detailByORMID(int group_detail_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getGroup_detailByORMID(session, group_detail_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Group_detail loadGroup_detailByORMID(int group_detail_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadGroup_detailByORMID(session, group_detail_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Group_detail getGroup_detailByORMID(int group_detail_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getGroup_detailByORMID(session, group_detail_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Group_detail loadGroup_detailByORMID(PersistentSession session, int group_detail_id) throws PersistentException {
		try {
			return (Group_detail) session.load(eihdms.Group_detail.class, new Integer(group_detail_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Group_detail getGroup_detailByORMID(PersistentSession session, int group_detail_id) throws PersistentException {
		try {
			return (Group_detail) session.get(eihdms.Group_detail.class, new Integer(group_detail_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Group_detail loadGroup_detailByORMID(PersistentSession session, int group_detail_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Group_detail) session.load(eihdms.Group_detail.class, new Integer(group_detail_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Group_detail getGroup_detailByORMID(PersistentSession session, int group_detail_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Group_detail) session.get(eihdms.Group_detail.class, new Integer(group_detail_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGroup_detail(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryGroup_detail(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGroup_detail(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryGroup_detail(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Group_detail[] listGroup_detailByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listGroup_detailByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Group_detail[] listGroup_detailByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listGroup_detailByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryGroup_detail(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Group_detail as Group_detail");
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
	
	public static List queryGroup_detail(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Group_detail as Group_detail");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Group_detail", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Group_detail[] listGroup_detailByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryGroup_detail(session, condition, orderBy);
			return (Group_detail[]) list.toArray(new Group_detail[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Group_detail[] listGroup_detailByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryGroup_detail(session, condition, orderBy, lockMode);
			return (Group_detail[]) list.toArray(new Group_detail[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Group_detail loadGroup_detailByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadGroup_detailByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Group_detail loadGroup_detailByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadGroup_detailByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Group_detail loadGroup_detailByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Group_detail[] group_details = listGroup_detailByQuery(session, condition, orderBy);
		if (group_details != null && group_details.length > 0)
			return group_details[0];
		else
			return null;
	}
	
	public static Group_detail loadGroup_detailByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Group_detail[] group_details = listGroup_detailByQuery(session, condition, orderBy, lockMode);
		if (group_details != null && group_details.length > 0)
			return group_details[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateGroup_detailByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateGroup_detailByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGroup_detailByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateGroup_detailByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGroup_detailByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Group_detail as Group_detail");
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
	
	public static java.util.Iterator iterateGroup_detailByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Group_detail as Group_detail");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Group_detail", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Group_detail loadGroup_detailByCriteria(Group_detailCriteria group_detailCriteria) {
		Group_detail[] group_details = listGroup_detailByCriteria(group_detailCriteria);
		if(group_details == null || group_details.length == 0) {
			return null;
		}
		return group_details[0];
	}
	
	public static Group_detail[] listGroup_detailByCriteria(Group_detailCriteria group_detailCriteria) {
		return group_detailCriteria.listGroup_detail();
	}
	
	public static Group_detail createGroup_detail() {
		return new eihdms.Group_detail();
	}
	
	public boolean save() throws PersistentException {
		try {
			eihdms.EIHDMSPersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			eihdms.EIHDMSPersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			eihdms.EIHDMSPersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			eihdms.EIHDMSPersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate()throws PersistentException {
		try {
			eihdms.Group_user[] lGroup_users = (eihdms.Group_user[])getGroup_user().toArray(new eihdms.Group_user[getGroup_user().size()]);
			for(int i = 0; i < lGroup_users.length; i++) {
				lGroup_users[i].setGroup_detail(null);
			}
			eihdms.Group_right[] lGroup_rights = (eihdms.Group_right[])getGroup_right().toArray(new eihdms.Group_right[getGroup_right().size()]);
			for(int i = 0; i < lGroup_rights.length; i++) {
				lGroup_rights[i].setGroup_detail(null);
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
			eihdms.Group_user[] lGroup_users = (eihdms.Group_user[])getGroup_user().toArray(new eihdms.Group_user[getGroup_user().size()]);
			for(int i = 0; i < lGroup_users.length; i++) {
				lGroup_users[i].setGroup_detail(null);
			}
			eihdms.Group_right[] lGroup_rights = (eihdms.Group_right[])getGroup_right().toArray(new eihdms.Group_right[getGroup_right().size()]);
			for(int i = 0; i < lGroup_rights.length; i++) {
				lGroup_rights[i].setGroup_detail(null);
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
	
	@Column(name="group_detail_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_GROUP_DETAIL_GROUP_DETAIL_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_GROUP_DETAIL_GROUP_DETAIL_ID_GENERATOR", strategy="native")	
	private int group_detail_id;
	
	@Column(name="group_name", nullable=false, unique=true, length=50)	
	private String group_name;
	
	@Column(name="is_deleted", nullable=false, length=1)	
	private int is_deleted;
	
	@Column(name="is_active", nullable=false, length=1)	
	private int is_active;
	
	@Column(name="add_date", nullable=false)	
	private java.sql.Timestamp add_date;
	
	@Column(name="add_by", nullable=false, length=11)	
	private int add_by;
	
	@Column(name="last_edit_date", nullable=true)	
	private java.sql.Timestamp last_edit_date;
	
	@Column(name="last_edit_by", nullable=true, length=11)	
	private Integer last_edit_by;
	
	@OneToMany(mappedBy="group_detail", targetEntity=eihdms.Group_user.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set group_user = new java.util.HashSet();
	
	@OneToMany(mappedBy="group_detail", targetEntity=eihdms.Group_right.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set group_right = new java.util.HashSet();
	
	private void setGroup_detail_id(int value) {
		this.group_detail_id = value;
	}
	
	public int getGroup_detail_id() {
		return group_detail_id;
	}
	
	public int getORMID() {
		return getGroup_detail_id();
	}
	
	public void setGroup_name(String value) {
		this.group_name = value;
	}
	
	public String getGroup_name() {
		return group_name;
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
		this.add_by = value;
	}
	
	public int getAdd_by() {
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
	
	public void setGroup_user(java.util.Set value) {
		this.group_user = value;
	}
	
	public java.util.Set getGroup_user() {
		return group_user;
	}
	
	
	public void setGroup_right(java.util.Set value) {
		this.group_right = value;
	}
	
	public java.util.Set getGroup_right() {
		return group_right;
	}
	
	
	@Override	
	public int hashCode() {
		int hash = 3;
				return hash;
	}
	
	@Override	
	public boolean equals(Object obj) {
		if (obj == null) {
				            return false;
				        }
				        Group_detail object = (Group_detail) obj;
				        return (this.getGroup_detail_id() == object.getGroup_detail_id());
	}
	
	public String toString() {
		return String.valueOf(getGroup_detail_id());
	}
	
}

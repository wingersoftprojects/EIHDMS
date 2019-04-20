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
@Table(name="user_action")
public class User_action implements Serializable {
	public User_action() {
	}
	
	public static User_action loadUser_actionByORMID(int user_action_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadUser_actionByORMID(session, user_action_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_action getUser_actionByORMID(int user_action_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getUser_actionByORMID(session, user_action_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_action loadUser_actionByORMID(int user_action_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadUser_actionByORMID(session, user_action_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_action getUser_actionByORMID(int user_action_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getUser_actionByORMID(session, user_action_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_action loadUser_actionByORMID(PersistentSession session, int user_action_id) throws PersistentException {
		try {
			return (User_action) session.load(eihdms.User_action.class, new Integer(user_action_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_action getUser_actionByORMID(PersistentSession session, int user_action_id) throws PersistentException {
		try {
			return (User_action) session.get(eihdms.User_action.class, new Integer(user_action_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_action loadUser_actionByORMID(PersistentSession session, int user_action_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (User_action) session.load(eihdms.User_action.class, new Integer(user_action_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_action getUser_actionByORMID(PersistentSession session, int user_action_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (User_action) session.get(eihdms.User_action.class, new Integer(user_action_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUser_action(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryUser_action(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUser_action(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryUser_action(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_action[] listUser_actionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listUser_actionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_action[] listUser_actionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listUser_actionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUser_action(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.User_action as User_action");
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
	
	public static List queryUser_action(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.User_action as User_action");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("User_action", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_action[] listUser_actionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryUser_action(session, condition, orderBy);
			return (User_action[]) list.toArray(new User_action[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_action[] listUser_actionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryUser_action(session, condition, orderBy, lockMode);
			return (User_action[]) list.toArray(new User_action[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_action loadUser_actionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadUser_actionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_action loadUser_actionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadUser_actionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_action loadUser_actionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		User_action[] user_actions = listUser_actionByQuery(session, condition, orderBy);
		if (user_actions != null && user_actions.length > 0)
			return user_actions[0];
		else
			return null;
	}
	
	public static User_action loadUser_actionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		User_action[] user_actions = listUser_actionByQuery(session, condition, orderBy, lockMode);
		if (user_actions != null && user_actions.length > 0)
			return user_actions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUser_actionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateUser_actionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUser_actionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateUser_actionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUser_actionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.User_action as User_action");
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
	
	public static java.util.Iterator iterateUser_actionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.User_action as User_action");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("User_action", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_action loadUser_actionByCriteria(User_actionCriteria user_actionCriteria) {
		User_action[] user_actions = listUser_actionByCriteria(user_actionCriteria);
		if(user_actions == null || user_actions.length == 0) {
			return null;
		}
		return user_actions[0];
	}
	
	public static User_action[] listUser_actionByCriteria(User_actionCriteria user_actionCriteria) {
		return user_actionCriteria.listUser_action();
	}
	
	public static User_action createUser_action() {
		return new eihdms.User_action();
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
			if(getUser_detail() != null) {
				getUser_detail().getUser_action().remove(this);
			}
			
			if(getForm_template() != null) {
				getForm_template().getUser_action().remove(this);
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
			if(getUser_detail() != null) {
				getUser_detail().getUser_action().remove(this);
			}
			
			if(getForm_template() != null) {
				getForm_template().getUser_action().remove(this);
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
	
	@Column(name="user_action_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_USER_ACTION_USER_ACTION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_USER_ACTION_USER_ACTION_ID_GENERATOR", strategy="native")	
	private int user_action_id;
	
	@ManyToOne(targetEntity=eihdms.User_detail.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="user_detail_id", referencedColumnName="user_detail_id", nullable=false) }, foreignKey=@ForeignKey(name="FKuser_actio257421"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.User_detail user_detail;
	
	@ManyToOne(targetEntity=eihdms.Report_form.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="form_template_id", referencedColumnName="report_form_id", nullable=false) }, foreignKey=@ForeignKey(name="FKuser_actio47015"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Report_form form_template;
	
	@Column(name="action", nullable=false, length=100)	
	private String action;
	
	@Column(name="action_date", nullable=false)	
	private java.sql.Timestamp action_date;
	
	private void setUser_action_id(int value) {
		this.user_action_id = value;
	}
	
	public int getUser_action_id() {
		return user_action_id;
	}
	
	public int getORMID() {
		return getUser_action_id();
	}
	
	public void setAction(String value) {
		this.action = value;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction_date(java.sql.Timestamp value) {
		this.action_date = value;
	}
	
	public java.sql.Timestamp getAction_date() {
		return action_date;
	}
	
	public void setUser_detail(eihdms.User_detail value) {
		this.user_detail = value;
	}
	
	public eihdms.User_detail getUser_detail() {
		return user_detail;
	}
	
	public void setForm_template(eihdms.Report_form value) {
		this.form_template = value;
	}
	
	public eihdms.Report_form getForm_template() {
		return form_template;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		User_action object = (User_action) obj;
		return (this.getUser_action_id() == object.getUser_action_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getUser_action_id());
	}
	
}

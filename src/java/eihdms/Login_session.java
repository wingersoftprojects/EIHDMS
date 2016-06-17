/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Kiyingi Simon Peter
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
@Table(name="login_session")
public class Login_session implements Serializable {
	public Login_session() {
	}
	
	public static Login_session loadLogin_sessionByORMID(int login_session_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadLogin_sessionByORMID(session, login_session_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login_session getLogin_sessionByORMID(int login_session_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getLogin_sessionByORMID(session, login_session_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login_session loadLogin_sessionByORMID(int login_session_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadLogin_sessionByORMID(session, login_session_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login_session getLogin_sessionByORMID(int login_session_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getLogin_sessionByORMID(session, login_session_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login_session loadLogin_sessionByORMID(PersistentSession session, int login_session_id) throws PersistentException {
		try {
			return (Login_session) session.load(eihdms.Login_session.class, new Integer(login_session_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login_session getLogin_sessionByORMID(PersistentSession session, int login_session_id) throws PersistentException {
		try {
			return (Login_session) session.get(eihdms.Login_session.class, new Integer(login_session_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login_session loadLogin_sessionByORMID(PersistentSession session, int login_session_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Login_session) session.load(eihdms.Login_session.class, new Integer(login_session_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login_session getLogin_sessionByORMID(PersistentSession session, int login_session_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Login_session) session.get(eihdms.Login_session.class, new Integer(login_session_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLogin_session(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryLogin_session(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLogin_session(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryLogin_session(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login_session[] listLogin_sessionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listLogin_sessionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login_session[] listLogin_sessionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listLogin_sessionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryLogin_session(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Login_session as Login_session");
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
	
	public static List queryLogin_session(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Login_session as Login_session");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Login_session", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login_session[] listLogin_sessionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryLogin_session(session, condition, orderBy);
			return (Login_session[]) list.toArray(new Login_session[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login_session[] listLogin_sessionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryLogin_session(session, condition, orderBy, lockMode);
			return (Login_session[]) list.toArray(new Login_session[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login_session loadLogin_sessionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadLogin_sessionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login_session loadLogin_sessionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadLogin_sessionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login_session loadLogin_sessionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Login_session[] login_sessions = listLogin_sessionByQuery(session, condition, orderBy);
		if (login_sessions != null && login_sessions.length > 0)
			return login_sessions[0];
		else
			return null;
	}
	
	public static Login_session loadLogin_sessionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Login_session[] login_sessions = listLogin_sessionByQuery(session, condition, orderBy, lockMode);
		if (login_sessions != null && login_sessions.length > 0)
			return login_sessions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateLogin_sessionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateLogin_sessionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLogin_sessionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateLogin_sessionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateLogin_sessionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Login_session as Login_session");
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
	
	public static java.util.Iterator iterateLogin_sessionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Login_session as Login_session");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Login_session", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Login_session loadLogin_sessionByCriteria(Login_sessionCriteria login_sessionCriteria) {
		Login_session[] login_sessions = listLogin_sessionByCriteria(login_sessionCriteria);
		if(login_sessions == null || login_sessions.length == 0) {
			return null;
		}
		return login_sessions[0];
	}
	
	public static Login_session[] listLogin_sessionByCriteria(Login_sessionCriteria login_sessionCriteria) {
		return login_sessionCriteria.listLogin_session();
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Login_session))
			return false;
		Login_session login_session = (Login_session)aObj;
		if (getLogin_session_id() != login_session.getLogin_session_id())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getLogin_session_id();
		return hashcode;
	}
	
	public static Login_session createLogin_session() {
		return new eihdms.Login_session();
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
			if(getUser_detail() != null) {
				getUser_detail().getLogin_session().remove(this);
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
				getUser_detail().getLogin_session().remove(this);
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
	
	@Column(name="login_session_id", nullable=false, length=11)	
	@Id	
	private int login_session_id;
	
	@ManyToOne(targetEntity=eihdms.User_detail.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="user_detail_id", referencedColumnName="user_detail_id", nullable=false) })	
	private eihdms.User_detail user_detail;
	
	@Column(name="session_id", nullable=false, length=100)	
	private String session_id;
	
	@Column(name="add_date", nullable=false)	
	private java.sql.Timestamp add_date;
	
	@Column(name="remote_ip", nullable=false, length=100)	
	private String remote_ip;
	
	@Column(name="remote_host", nullable=false, length=100)	
	private String remote_host;
	
	@Column(name="remote_user", nullable=false, length=100)	
	private String remote_user;
	
	public void setLogin_session_id(int value) {
		this.login_session_id = value;
	}
	
	public int getLogin_session_id() {
		return login_session_id;
	}
	
	public int getORMID() {
		return getLogin_session_id();
	}
	
	public void setSession_id(String value) {
		this.session_id = value;
	}
	
	public String getSession_id() {
		return session_id;
	}
	
	public void setAdd_date(java.sql.Timestamp value) {
		this.add_date = value;
	}
	
	public java.sql.Timestamp getAdd_date() {
		return add_date;
	}
	
	public void setRemote_ip(String value) {
		this.remote_ip = value;
	}
	
	public String getRemote_ip() {
		return remote_ip;
	}
	
	public void setRemote_host(String value) {
		this.remote_host = value;
	}
	
	public String getRemote_host() {
		return remote_host;
	}
	
	public void setRemote_user(String value) {
		this.remote_user = value;
	}
	
	public String getRemote_user() {
		return remote_user;
	}
	
	public void setUser_detail(eihdms.User_detail value) {
		this.user_detail = value;
	}
	
	public eihdms.User_detail getUser_detail() {
		return user_detail;
	}
	
	public String toString() {
		return String.valueOf(getLogin_session_id());
	}
	
	@Transient	
	private boolean _saved = false;
	
	public void onSave() {
		_saved=true;
	}
	
	
	public void onLoad() {
		_saved=true;
	}
	
	
	public boolean isSaved() {
		return _saved;
	}
	
	
}

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
@Table(name="ForgotPassword")
public class ForgotPassword implements Serializable {
	public ForgotPassword() {
	}
	
	public static ForgotPassword loadForgotPasswordByORMID(int forgot_password_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadForgotPasswordByORMID(session, forgot_password_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ForgotPassword getForgotPasswordByORMID(int forgot_password_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getForgotPasswordByORMID(session, forgot_password_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ForgotPassword loadForgotPasswordByORMID(int forgot_password_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadForgotPasswordByORMID(session, forgot_password_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ForgotPassword getForgotPasswordByORMID(int forgot_password_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getForgotPasswordByORMID(session, forgot_password_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ForgotPassword loadForgotPasswordByORMID(PersistentSession session, int forgot_password_id) throws PersistentException {
		try {
			return (ForgotPassword) session.load(eihdms.ForgotPassword.class, new Integer(forgot_password_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ForgotPassword getForgotPasswordByORMID(PersistentSession session, int forgot_password_id) throws PersistentException {
		try {
			return (ForgotPassword) session.get(eihdms.ForgotPassword.class, new Integer(forgot_password_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ForgotPassword loadForgotPasswordByORMID(PersistentSession session, int forgot_password_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ForgotPassword) session.load(eihdms.ForgotPassword.class, new Integer(forgot_password_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ForgotPassword getForgotPasswordByORMID(PersistentSession session, int forgot_password_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ForgotPassword) session.get(eihdms.ForgotPassword.class, new Integer(forgot_password_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryForgotPassword(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryForgotPassword(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryForgotPassword(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryForgotPassword(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ForgotPassword[] listForgotPasswordByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listForgotPasswordByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ForgotPassword[] listForgotPasswordByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listForgotPasswordByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryForgotPassword(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.ForgotPassword as ForgotPassword");
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
	
	public static List queryForgotPassword(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.ForgotPassword as ForgotPassword");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ForgotPassword", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ForgotPassword[] listForgotPasswordByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryForgotPassword(session, condition, orderBy);
			return (ForgotPassword[]) list.toArray(new ForgotPassword[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ForgotPassword[] listForgotPasswordByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryForgotPassword(session, condition, orderBy, lockMode);
			return (ForgotPassword[]) list.toArray(new ForgotPassword[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ForgotPassword loadForgotPasswordByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadForgotPasswordByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ForgotPassword loadForgotPasswordByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadForgotPasswordByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ForgotPassword loadForgotPasswordByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		ForgotPassword[] forgotPasswords = listForgotPasswordByQuery(session, condition, orderBy);
		if (forgotPasswords != null && forgotPasswords.length > 0)
			return forgotPasswords[0];
		else
			return null;
	}
	
	public static ForgotPassword loadForgotPasswordByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		ForgotPassword[] forgotPasswords = listForgotPasswordByQuery(session, condition, orderBy, lockMode);
		if (forgotPasswords != null && forgotPasswords.length > 0)
			return forgotPasswords[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateForgotPasswordByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateForgotPasswordByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateForgotPasswordByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateForgotPasswordByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateForgotPasswordByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.ForgotPassword as ForgotPassword");
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
	
	public static java.util.Iterator iterateForgotPasswordByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.ForgotPassword as ForgotPassword");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ForgotPassword", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ForgotPassword loadForgotPasswordByCriteria(ForgotPasswordCriteria forgotPasswordCriteria) {
		ForgotPassword[] forgotPasswords = listForgotPasswordByCriteria(forgotPasswordCriteria);
		if(forgotPasswords == null || forgotPasswords.length == 0) {
			return null;
		}
		return forgotPasswords[0];
	}
	
	public static ForgotPassword[] listForgotPasswordByCriteria(ForgotPasswordCriteria forgotPasswordCriteria) {
		return forgotPasswordCriteria.listForgotPassword();
	}
	
	public static ForgotPassword createForgotPassword() {
		return new eihdms.ForgotPassword();
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
				getUser_detail().getForgotPassword().remove(this);
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
				getUser_detail().getForgotPassword().remove(this);
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
	
	@Column(name="forgot_password_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_FORGOTPASSWORD_FORGOT_PASSWORD_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_FORGOTPASSWORD_FORGOT_PASSWORD_ID_GENERATOR", strategy="native")	
	private int forgot_password_id;
	
	@Column(name="expirydate", nullable=false)	
	private java.sql.Timestamp expirydate;
	
	@Column(name="code", nullable=false, length=11)	
	private int code;
	
	@ManyToOne(targetEntity=eihdms.User_detail.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="user_detail_id", referencedColumnName="user_detail_id", nullable=false) }, foreignKey=@ForeignKey(name="Forgot_Password_User"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.User_detail user_detail;
	
	private void setForgot_password_id(int value) {
		this.forgot_password_id = value;
	}
	
	public int getForgot_password_id() {
		return forgot_password_id;
	}
	
	public int getORMID() {
		return getForgot_password_id();
	}
	
	public void setExpirydate(java.sql.Timestamp value) {
		this.expirydate = value;
	}
	
	public java.sql.Timestamp getExpirydate() {
		return expirydate;
	}
	
	public void setCode(int value) {
		this.code = value;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setUser_detail(eihdms.User_detail value) {
		this.user_detail = value;
	}
	
	public eihdms.User_detail getUser_detail() {
		return user_detail;
	}
	
	public String toString() {
		return String.valueOf(getForgot_password_id());
	}
	
}

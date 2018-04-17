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
@Table(name="access_scope")
public class Access_scope implements Serializable {
	public Access_scope() {
	}
	
	public static Access_scope loadAccess_scopeByORMID(int access_scope_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadAccess_scopeByORMID(session, access_scope_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope getAccess_scopeByORMID(int access_scope_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getAccess_scopeByORMID(session, access_scope_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope loadAccess_scopeByORMID(int access_scope_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadAccess_scopeByORMID(session, access_scope_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope getAccess_scopeByORMID(int access_scope_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getAccess_scopeByORMID(session, access_scope_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope loadAccess_scopeByORMID(PersistentSession session, int access_scope_id) throws PersistentException {
		try {
			return (Access_scope) session.load(eihdms.Access_scope.class, new Integer(access_scope_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope getAccess_scopeByORMID(PersistentSession session, int access_scope_id) throws PersistentException {
		try {
			return (Access_scope) session.get(eihdms.Access_scope.class, new Integer(access_scope_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope loadAccess_scopeByORMID(PersistentSession session, int access_scope_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Access_scope) session.load(eihdms.Access_scope.class, new Integer(access_scope_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope getAccess_scopeByORMID(PersistentSession session, int access_scope_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Access_scope) session.get(eihdms.Access_scope.class, new Integer(access_scope_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAccess_scope(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryAccess_scope(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAccess_scope(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryAccess_scope(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope[] listAccess_scopeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listAccess_scopeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope[] listAccess_scopeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listAccess_scopeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAccess_scope(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Access_scope as Access_scope");
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
	
	public static List queryAccess_scope(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Access_scope as Access_scope");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Access_scope", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope[] listAccess_scopeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAccess_scope(session, condition, orderBy);
			return (Access_scope[]) list.toArray(new Access_scope[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope[] listAccess_scopeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAccess_scope(session, condition, orderBy, lockMode);
			return (Access_scope[]) list.toArray(new Access_scope[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope loadAccess_scopeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadAccess_scopeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope loadAccess_scopeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadAccess_scopeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope loadAccess_scopeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Access_scope[] access_scopes = listAccess_scopeByQuery(session, condition, orderBy);
		if (access_scopes != null && access_scopes.length > 0)
			return access_scopes[0];
		else
			return null;
	}
	
	public static Access_scope loadAccess_scopeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Access_scope[] access_scopes = listAccess_scopeByQuery(session, condition, orderBy, lockMode);
		if (access_scopes != null && access_scopes.length > 0)
			return access_scopes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAccess_scopeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateAccess_scopeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAccess_scopeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateAccess_scopeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAccess_scopeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Access_scope as Access_scope");
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
	
	public static java.util.Iterator iterateAccess_scopeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Access_scope as Access_scope");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Access_scope", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope loadAccess_scopeByCriteria(Access_scopeCriteria access_scopeCriteria) {
		Access_scope[] access_scopes = listAccess_scopeByCriteria(access_scopeCriteria);
		if(access_scopes == null || access_scopes.length == 0) {
			return null;
		}
		return access_scopes[0];
	}
	
	public static Access_scope[] listAccess_scopeByCriteria(Access_scopeCriteria access_scopeCriteria) {
		return access_scopeCriteria.listAccess_scope();
	}
	
	public static Access_scope createAccess_scope() {
		return new eihdms.Access_scope();
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
	
	@Column(name="access_scope_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_ACCESS_SCOPE_ACCESS_SCOPE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_ACCESS_SCOPE_ACCESS_SCOPE_ID_GENERATOR", strategy="native")	
	private int access_scope_id;
	
	@Column(name="user_detail_id", nullable=true, length=11)	
	private Integer user_detail_id;
	
	@Column(name="region_id", nullable=true, length=11)	
	private Integer region_id;
	
	@Column(name="district_id", nullable=true, length=11)	
	private Integer district_id;
	
	@Column(name="parish_id", nullable=true, length=11)	
	private Integer parish_id;
	
	@Column(name="health_facility_id", nullable=true, length=11)	
	private Integer health_facility_id;
	
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
	
	private void setAccess_scope_id(int value) {
		this.access_scope_id = value;
	}
	
	public int getAccess_scope_id() {
		return access_scope_id;
	}
	
	public int getORMID() {
		return getAccess_scope_id();
	}
	
	public void setUser_detail_id(int value) {
		setUser_detail_id(new Integer(value));
	}
	
	public void setUser_detail_id(Integer value) {
		this.user_detail_id = value;
	}
	
	public Integer getUser_detail_id() {
		return user_detail_id;
	}
	
	public void setRegion_id(int value) {
		setRegion_id(new Integer(value));
	}
	
	public void setRegion_id(Integer value) {
		this.region_id = value;
	}
	
	public Integer getRegion_id() {
		return region_id;
	}
	
	public void setDistrict_id(int value) {
		setDistrict_id(new Integer(value));
	}
	
	public void setDistrict_id(Integer value) {
		this.district_id = value;
	}
	
	public Integer getDistrict_id() {
		return district_id;
	}
	
	public void setParish_id(int value) {
		setParish_id(new Integer(value));
	}
	
	public void setParish_id(Integer value) {
		this.parish_id = value;
	}
	
	public Integer getParish_id() {
		return parish_id;
	}
	
	public void setHealth_facility_id(int value) {
		setHealth_facility_id(new Integer(value));
	}
	
	public void setHealth_facility_id(Integer value) {
		this.health_facility_id = value;
	}
	
	public Integer getHealth_facility_id() {
		return health_facility_id;
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
	
	/**
	 * Testing
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Access_scope object = (Access_scope) obj;
		return (this.getAccess_scope_id() == object.getAccess_scope_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getAccess_scope_id());
	}
	
}

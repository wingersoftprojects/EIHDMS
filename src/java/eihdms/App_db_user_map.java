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
@Table(name="app_db_user_map")
public class App_db_user_map implements Serializable {
	public App_db_user_map() {
	}
	
	public static App_db_user_map loadApp_db_user_mapByORMID(int app_db_user_map_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadApp_db_user_mapByORMID(session, app_db_user_map_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static App_db_user_map getApp_db_user_mapByORMID(int app_db_user_map_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getApp_db_user_mapByORMID(session, app_db_user_map_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static App_db_user_map loadApp_db_user_mapByORMID(int app_db_user_map_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadApp_db_user_mapByORMID(session, app_db_user_map_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static App_db_user_map getApp_db_user_mapByORMID(int app_db_user_map_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getApp_db_user_mapByORMID(session, app_db_user_map_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static App_db_user_map loadApp_db_user_mapByORMID(PersistentSession session, int app_db_user_map_id) throws PersistentException {
		try {
			return (App_db_user_map) session.load(eihdms.App_db_user_map.class, new Integer(app_db_user_map_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static App_db_user_map getApp_db_user_mapByORMID(PersistentSession session, int app_db_user_map_id) throws PersistentException {
		try {
			return (App_db_user_map) session.get(eihdms.App_db_user_map.class, new Integer(app_db_user_map_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static App_db_user_map loadApp_db_user_mapByORMID(PersistentSession session, int app_db_user_map_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (App_db_user_map) session.load(eihdms.App_db_user_map.class, new Integer(app_db_user_map_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static App_db_user_map getApp_db_user_mapByORMID(PersistentSession session, int app_db_user_map_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (App_db_user_map) session.get(eihdms.App_db_user_map.class, new Integer(app_db_user_map_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryApp_db_user_map(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryApp_db_user_map(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryApp_db_user_map(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryApp_db_user_map(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static App_db_user_map[] listApp_db_user_mapByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listApp_db_user_mapByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static App_db_user_map[] listApp_db_user_mapByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listApp_db_user_mapByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryApp_db_user_map(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.App_db_user_map as App_db_user_map");
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
	
	public static List queryApp_db_user_map(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.App_db_user_map as App_db_user_map");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("App_db_user_map", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static App_db_user_map[] listApp_db_user_mapByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryApp_db_user_map(session, condition, orderBy);
			return (App_db_user_map[]) list.toArray(new App_db_user_map[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static App_db_user_map[] listApp_db_user_mapByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryApp_db_user_map(session, condition, orderBy, lockMode);
			return (App_db_user_map[]) list.toArray(new App_db_user_map[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static App_db_user_map loadApp_db_user_mapByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadApp_db_user_mapByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static App_db_user_map loadApp_db_user_mapByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadApp_db_user_mapByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static App_db_user_map loadApp_db_user_mapByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		App_db_user_map[] app_db_user_maps = listApp_db_user_mapByQuery(session, condition, orderBy);
		if (app_db_user_maps != null && app_db_user_maps.length > 0)
			return app_db_user_maps[0];
		else
			return null;
	}
	
	public static App_db_user_map loadApp_db_user_mapByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		App_db_user_map[] app_db_user_maps = listApp_db_user_mapByQuery(session, condition, orderBy, lockMode);
		if (app_db_user_maps != null && app_db_user_maps.length > 0)
			return app_db_user_maps[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateApp_db_user_mapByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateApp_db_user_mapByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateApp_db_user_mapByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateApp_db_user_mapByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateApp_db_user_mapByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.App_db_user_map as App_db_user_map");
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
	
	public static java.util.Iterator iterateApp_db_user_mapByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.App_db_user_map as App_db_user_map");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("App_db_user_map", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static App_db_user_map loadApp_db_user_mapByCriteria(App_db_user_mapCriteria app_db_user_mapCriteria) {
		App_db_user_map[] app_db_user_maps = listApp_db_user_mapByCriteria(app_db_user_mapCriteria);
		if(app_db_user_maps == null || app_db_user_maps.length == 0) {
			return null;
		}
		return app_db_user_maps[0];
	}
	
	public static App_db_user_map[] listApp_db_user_mapByCriteria(App_db_user_mapCriteria app_db_user_mapCriteria) {
		return app_db_user_mapCriteria.listApp_db_user_map();
	}
	
	public static App_db_user_map createApp_db_user_map() {
		return new eihdms.App_db_user_map();
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
	
	@Column(name="app_db_user_map_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_APP_DB_USER_MAP_APP_DB_USER_MAP_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_APP_DB_USER_MAP_APP_DB_USER_MAP_ID_GENERATOR", strategy="native")	
	private int app_db_user_map_id;
	
	@Column(name="user_detail_id", nullable=false, length=11)	
	private int user_detail_id;
	
	@Column(name="db_user", nullable=false, length=50)	
	private String db_user;
	
	@Column(name="db_password", nullable=false, length=255)	
	private String db_password;
	
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
	
	private void setApp_db_user_map_id(int value) {
		this.app_db_user_map_id = value;
	}
	
	public int getApp_db_user_map_id() {
		return app_db_user_map_id;
	}
	
	public int getORMID() {
		return getApp_db_user_map_id();
	}
	
	public void setUser_detail_id(int value) {
		this.user_detail_id = value;
	}
	
	public int getUser_detail_id() {
		return user_detail_id;
	}
	
	public void setDb_user(String value) {
		this.db_user = value;
	}
	
	public String getDb_user() {
		return db_user;
	}
	
	public void setDb_password(String value) {
		this.db_password = value;
	}
	
	public String getDb_password() {
		return db_password;
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
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		App_db_user_map object = (App_db_user_map) obj;
		return (this.getApp_db_user_map_id() == object.getApp_db_user_map_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getApp_db_user_map_id());
	}
	
}

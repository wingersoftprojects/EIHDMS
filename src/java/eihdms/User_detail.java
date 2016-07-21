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
/**
 * Stores user details such as username, password, type, status, etc
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="user_detail")
public class User_detail implements Serializable {
	public User_detail() {
	}
	
	public static User_detail loadUser_detailByORMID(int user_detail_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadUser_detailByORMID(session, user_detail_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_detail getUser_detailByORMID(int user_detail_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getUser_detailByORMID(session, user_detail_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_detail loadUser_detailByORMID(int user_detail_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadUser_detailByORMID(session, user_detail_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_detail getUser_detailByORMID(int user_detail_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getUser_detailByORMID(session, user_detail_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_detail loadUser_detailByORMID(PersistentSession session, int user_detail_id) throws PersistentException {
		try {
			return (User_detail) session.load(eihdms.User_detail.class, new Integer(user_detail_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_detail getUser_detailByORMID(PersistentSession session, int user_detail_id) throws PersistentException {
		try {
			return (User_detail) session.get(eihdms.User_detail.class, new Integer(user_detail_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_detail loadUser_detailByORMID(PersistentSession session, int user_detail_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (User_detail) session.load(eihdms.User_detail.class, new Integer(user_detail_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_detail getUser_detailByORMID(PersistentSession session, int user_detail_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (User_detail) session.get(eihdms.User_detail.class, new Integer(user_detail_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUser_detail(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryUser_detail(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUser_detail(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryUser_detail(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_detail[] listUser_detailByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listUser_detailByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_detail[] listUser_detailByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listUser_detailByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUser_detail(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.User_detail as User_detail");
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
	
	public static List queryUser_detail(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.User_detail as User_detail");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("User_detail", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_detail[] listUser_detailByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryUser_detail(session, condition, orderBy);
			return (User_detail[]) list.toArray(new User_detail[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_detail[] listUser_detailByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryUser_detail(session, condition, orderBy, lockMode);
			return (User_detail[]) list.toArray(new User_detail[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_detail loadUser_detailByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadUser_detailByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_detail loadUser_detailByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadUser_detailByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_detail loadUser_detailByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		User_detail[] user_details = listUser_detailByQuery(session, condition, orderBy);
		if (user_details != null && user_details.length > 0)
			return user_details[0];
		else
			return null;
	}
	
	public static User_detail loadUser_detailByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		User_detail[] user_details = listUser_detailByQuery(session, condition, orderBy, lockMode);
		if (user_details != null && user_details.length > 0)
			return user_details[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUser_detailByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateUser_detailByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUser_detailByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateUser_detailByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUser_detailByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.User_detail as User_detail");
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
	
	public static java.util.Iterator iterateUser_detailByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.User_detail as User_detail");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("User_detail", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_detail loadUser_detailByCriteria(User_detailCriteria user_detailCriteria) {
		User_detail[] user_details = listUser_detailByCriteria(user_detailCriteria);
		if(user_details == null || user_details.length == 0) {
			return null;
		}
		return user_details[0];
	}
	
	public static User_detail[] listUser_detailByCriteria(User_detailCriteria user_detailCriteria) {
		return user_detailCriteria.listUser_detail();
	}
	
	public static User_detail createUser_detail() {
		return new eihdms.User_detail();
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
			if(getUser_category() != null) {
				getUser_category().getUser_detail().remove(this);
			}
			
			eihdms.Group_user[] lGroup_users = (eihdms.Group_user[])getGroup_user().toArray(new eihdms.Group_user[getGroup_user().size()]);
			for(int i = 0; i < lGroup_users.length; i++) {
				lGroup_users[i].setUser_detail(null);
			}
			eihdms.Login_session[] lLogin_sessions = (eihdms.Login_session[])getLogin_session().toArray(new eihdms.Login_session[getLogin_session().size()]);
			for(int i = 0; i < lLogin_sessions.length; i++) {
				lLogin_sessions[i].setUser_detail(null);
			}
			eihdms.User_action[] lUser_actions = (eihdms.User_action[])getUser_action().toArray(new eihdms.User_action[getUser_action().size()]);
			for(int i = 0; i < lUser_actions.length; i++) {
				lUser_actions[i].setUser_detail(null);
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
			if(getUser_category() != null) {
				getUser_category().getUser_detail().remove(this);
			}
			
			eihdms.Group_user[] lGroup_users = (eihdms.Group_user[])getGroup_user().toArray(new eihdms.Group_user[getGroup_user().size()]);
			for(int i = 0; i < lGroup_users.length; i++) {
				lGroup_users[i].setUser_detail(null);
			}
			eihdms.Login_session[] lLogin_sessions = (eihdms.Login_session[])getLogin_session().toArray(new eihdms.Login_session[getLogin_session().size()]);
			for(int i = 0; i < lLogin_sessions.length; i++) {
				lLogin_sessions[i].setUser_detail(null);
			}
			eihdms.User_action[] lUser_actions = (eihdms.User_action[])getUser_action().toArray(new eihdms.User_action[getUser_action().size()]);
			for(int i = 0; i < lUser_actions.length; i++) {
				lUser_actions[i].setUser_detail(null);
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
	
	@Column(name="user_detail_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_USER_DETAIL_USER_DETAIL_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_USER_DETAIL_USER_DETAIL_ID_GENERATOR", strategy="native")	
	private int user_detail_id;
	
	@Column(name="user_name", nullable=false, unique=true, length=20)	
	private String user_name;
	
	@Column(name="user_password", nullable=false, length=255)	
	private String user_password;
	
	@Column(name="first_name", nullable=false, length=100)	
	private String first_name;
	
	@Column(name="second_name", nullable=false, length=100)	
	private String second_name;
	
	@Column(name="third_name", nullable=false, length=100)	
	private String third_name;
	
	@Column(name="user_image", nullable=true)	
	private java.sql.Blob user_image;
	
	@ManyToOne(targetEntity=eihdms.User_category.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="user_category_id", referencedColumnName="user_category_id") })	
	private eihdms.User_category user_category;
	
	@Column(name="is_user_gen_admin", nullable=false, length=1)	
	private int is_user_gen_admin;
	
	@Column(name="is_deleted", nullable=false, length=1)	
	private int is_deleted;
	
	@Column(name="is_active", nullable=false, length=1)	
	private int is_active;
	
	@Column(name="add_date", nullable=true)	
	private java.sql.Timestamp add_date;
	
	@Column(name="add_by", nullable=true, length=11)	
	private int add_by;
	
	@Column(name="last_edit_date", nullable=true)	
	private java.sql.Timestamp last_edit_date;
	
	@Column(name="last_edit_by", nullable=true, length=11)	
	private Integer last_edit_by;
	
	@OneToMany(mappedBy="user_detail", targetEntity=eihdms.Group_user.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set group_user = new java.util.HashSet();
	
	@OneToMany(mappedBy="user_detail", targetEntity=eihdms.Login_session.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set login_session = new java.util.HashSet();
	
	@OneToMany(mappedBy="user_detail", targetEntity=eihdms.User_action.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set user_action = new java.util.HashSet();
	
	private void setUser_detail_id(int value) {
		this.user_detail_id = value;
	}
	
	public int getUser_detail_id() {
		return user_detail_id;
	}
	
	public int getORMID() {
		return getUser_detail_id();
	}
	
	public void setUser_name(String value) {
		this.user_name = value;
	}
	
	public String getUser_name() {
		return user_name;
	}
	
	public void setUser_password(String value) {
		this.user_password = value;
	}
	
	public String getUser_password() {
		return user_password;
	}
	
	public void setFirst_name(String value) {
		this.first_name = value;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setSecond_name(String value) {
		this.second_name = value;
	}
	
	public String getSecond_name() {
		return second_name;
	}
	
	public void setThird_name(String value) {
		this.third_name = value;
	}
	
	public String getThird_name() {
		return third_name;
	}
	
	public void setUser_image(java.sql.Blob value) {
		this.user_image = value;
	}
	
	public java.sql.Blob getUser_image() {
		return user_image;
	}
	
	public void setIs_user_gen_admin(int value) {
		this.is_user_gen_admin = value;
	}
	
	public int getIs_user_gen_admin() {
		return is_user_gen_admin;
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
	
	public void setUser_category(eihdms.User_category value) {
		this.user_category = value;
	}
	
	public eihdms.User_category getUser_category() {
		return user_category;
	}
	
	public void setGroup_user(java.util.Set value) {
		this.group_user = value;
	}
	
	public java.util.Set getGroup_user() {
		return group_user;
	}
	
	
	public void setLogin_session(java.util.Set value) {
		this.login_session = value;
	}
	
	public java.util.Set getLogin_session() {
		return login_session;
	}
	
	
	public void setUser_action(java.util.Set value) {
		this.user_action = value;
	}
	
	public java.util.Set getUser_action() {
		return user_action;
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
				        User_detail object = (User_detail) obj;
				        return (this.getUser_detail_id() == object.getUser_detail_id());
	}
	
	public String toString() {
		return String.valueOf(getUser_detail_id());
	}
	
}

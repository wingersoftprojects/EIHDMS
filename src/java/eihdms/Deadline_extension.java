/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: rlumala
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
@Table(name="deadline_extension")
public class Deadline_extension implements Serializable {
	public Deadline_extension() {
	}
	
	public static Deadline_extension loadDeadline_extensionByORMID(int deadline_extension_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadDeadline_extensionByORMID(session, deadline_extension_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_extension getDeadline_extensionByORMID(int deadline_extension_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getDeadline_extensionByORMID(session, deadline_extension_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_extension loadDeadline_extensionByORMID(int deadline_extension_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadDeadline_extensionByORMID(session, deadline_extension_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_extension getDeadline_extensionByORMID(int deadline_extension_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getDeadline_extensionByORMID(session, deadline_extension_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_extension loadDeadline_extensionByORMID(PersistentSession session, int deadline_extension_id) throws PersistentException {
		try {
			return (Deadline_extension) session.load(eihdms.Deadline_extension.class, new Integer(deadline_extension_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_extension getDeadline_extensionByORMID(PersistentSession session, int deadline_extension_id) throws PersistentException {
		try {
			return (Deadline_extension) session.get(eihdms.Deadline_extension.class, new Integer(deadline_extension_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_extension loadDeadline_extensionByORMID(PersistentSession session, int deadline_extension_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Deadline_extension) session.load(eihdms.Deadline_extension.class, new Integer(deadline_extension_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_extension getDeadline_extensionByORMID(PersistentSession session, int deadline_extension_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Deadline_extension) session.get(eihdms.Deadline_extension.class, new Integer(deadline_extension_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDeadline_extension(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryDeadline_extension(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDeadline_extension(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryDeadline_extension(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_extension[] listDeadline_extensionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listDeadline_extensionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_extension[] listDeadline_extensionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listDeadline_extensionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDeadline_extension(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Deadline_extension as Deadline_extension");
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
	
	public static List queryDeadline_extension(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Deadline_extension as Deadline_extension");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Deadline_extension", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_extension[] listDeadline_extensionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryDeadline_extension(session, condition, orderBy);
			return (Deadline_extension[]) list.toArray(new Deadline_extension[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_extension[] listDeadline_extensionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryDeadline_extension(session, condition, orderBy, lockMode);
			return (Deadline_extension[]) list.toArray(new Deadline_extension[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_extension loadDeadline_extensionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadDeadline_extensionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_extension loadDeadline_extensionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadDeadline_extensionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_extension loadDeadline_extensionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Deadline_extension[] deadline_extensions = listDeadline_extensionByQuery(session, condition, orderBy);
		if (deadline_extensions != null && deadline_extensions.length > 0)
			return deadline_extensions[0];
		else
			return null;
	}
	
	public static Deadline_extension loadDeadline_extensionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Deadline_extension[] deadline_extensions = listDeadline_extensionByQuery(session, condition, orderBy, lockMode);
		if (deadline_extensions != null && deadline_extensions.length > 0)
			return deadline_extensions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDeadline_extensionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateDeadline_extensionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDeadline_extensionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateDeadline_extensionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDeadline_extensionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Deadline_extension as Deadline_extension");
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
	
	public static java.util.Iterator iterateDeadline_extensionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Deadline_extension as Deadline_extension");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Deadline_extension", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Deadline_extension loadDeadline_extensionByCriteria(Deadline_extensionCriteria deadline_extensionCriteria) {
		Deadline_extension[] deadline_extensions = listDeadline_extensionByCriteria(deadline_extensionCriteria);
		if(deadline_extensions == null || deadline_extensions.length == 0) {
			return null;
		}
		return deadline_extensions[0];
	}
	
	public static Deadline_extension[] listDeadline_extensionByCriteria(Deadline_extensionCriteria deadline_extensionCriteria) {
		return deadline_extensionCriteria.listDeadline_extension();
	}
	
	public static Deadline_extension createDeadline_extension() {
		return new eihdms.Deadline_extension();
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
			if(getReport_form_deadline() != null) {
				getReport_form_deadline().setDeadline_extension(null);
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
			if(getReport_form_deadline() != null) {
				getReport_form_deadline().setDeadline_extension(null);
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
	
	@Column(name="deadline_extension_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_DEADLINE_EXTENSION_DEADLINE_EXTENSION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_DEADLINE_EXTENSION_DEADLINE_EXTENSION_ID_GENERATOR", strategy="native")	
	private int deadline_extension_id;
	
	@OneToOne(optional=false, targetEntity=eihdms.Report_form_deadline.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="report_form_deadline_id", referencedColumnName="report_form_deadline_id", nullable=false) }, foreignKey=@ForeignKey(name="FKdeadline_e392986"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Report_form_deadline report_form_deadline;
	
	@Column(name="extended_to_date", nullable=false)	
	private java.sql.Timestamp extended_to_date;
	
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
	
	private void setDeadline_extension_id(int value) {
		this.deadline_extension_id = value;
	}
	
	public int getDeadline_extension_id() {
		return deadline_extension_id;
	}
	
	public int getORMID() {
		return getDeadline_extension_id();
	}
	
	public void setExtended_to_date(java.sql.Timestamp value) {
		this.extended_to_date = value;
	}
	
	public java.sql.Timestamp getExtended_to_date() {
		return extended_to_date;
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
	
	public void setReport_form_deadline(eihdms.Report_form_deadline value) {
		this.report_form_deadline = value;
	}
	
	public eihdms.Report_form_deadline getReport_form_deadline() {
		return report_form_deadline;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Deadline_extension object = (Deadline_extension) obj;
		return (this.getDeadline_extension_id() == object.getDeadline_extension_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getDeadline_extension_id());
	}
	
}

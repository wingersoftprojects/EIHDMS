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
@Table(name="kpi_summary_function")
public class Kpi_summary_function implements Serializable {
	public Kpi_summary_function() {
	}
	
	public static Kpi_summary_function loadKpi_summary_functionByORMID(int kpi_summary_function_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadKpi_summary_functionByORMID(session, kpi_summary_function_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kpi_summary_function getKpi_summary_functionByORMID(int kpi_summary_function_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getKpi_summary_functionByORMID(session, kpi_summary_function_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kpi_summary_function loadKpi_summary_functionByORMID(int kpi_summary_function_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadKpi_summary_functionByORMID(session, kpi_summary_function_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kpi_summary_function getKpi_summary_functionByORMID(int kpi_summary_function_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getKpi_summary_functionByORMID(session, kpi_summary_function_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kpi_summary_function loadKpi_summary_functionByORMID(PersistentSession session, int kpi_summary_function_id) throws PersistentException {
		try {
			return (Kpi_summary_function) session.load(eihdms.Kpi_summary_function.class, new Integer(kpi_summary_function_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kpi_summary_function getKpi_summary_functionByORMID(PersistentSession session, int kpi_summary_function_id) throws PersistentException {
		try {
			return (Kpi_summary_function) session.get(eihdms.Kpi_summary_function.class, new Integer(kpi_summary_function_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kpi_summary_function loadKpi_summary_functionByORMID(PersistentSession session, int kpi_summary_function_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Kpi_summary_function) session.load(eihdms.Kpi_summary_function.class, new Integer(kpi_summary_function_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kpi_summary_function getKpi_summary_functionByORMID(PersistentSession session, int kpi_summary_function_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Kpi_summary_function) session.get(eihdms.Kpi_summary_function.class, new Integer(kpi_summary_function_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryKpi_summary_function(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryKpi_summary_function(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryKpi_summary_function(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryKpi_summary_function(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kpi_summary_function[] listKpi_summary_functionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listKpi_summary_functionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kpi_summary_function[] listKpi_summary_functionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listKpi_summary_functionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryKpi_summary_function(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Kpi_summary_function as Kpi_summary_function");
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
	
	public static List queryKpi_summary_function(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Kpi_summary_function as Kpi_summary_function");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Kpi_summary_function", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kpi_summary_function[] listKpi_summary_functionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKpi_summary_function(session, condition, orderBy);
			return (Kpi_summary_function[]) list.toArray(new Kpi_summary_function[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kpi_summary_function[] listKpi_summary_functionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKpi_summary_function(session, condition, orderBy, lockMode);
			return (Kpi_summary_function[]) list.toArray(new Kpi_summary_function[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kpi_summary_function loadKpi_summary_functionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadKpi_summary_functionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kpi_summary_function loadKpi_summary_functionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadKpi_summary_functionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kpi_summary_function loadKpi_summary_functionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Kpi_summary_function[] kpi_summary_functions = listKpi_summary_functionByQuery(session, condition, orderBy);
		if (kpi_summary_functions != null && kpi_summary_functions.length > 0)
			return kpi_summary_functions[0];
		else
			return null;
	}
	
	public static Kpi_summary_function loadKpi_summary_functionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Kpi_summary_function[] kpi_summary_functions = listKpi_summary_functionByQuery(session, condition, orderBy, lockMode);
		if (kpi_summary_functions != null && kpi_summary_functions.length > 0)
			return kpi_summary_functions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateKpi_summary_functionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateKpi_summary_functionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateKpi_summary_functionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateKpi_summary_functionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateKpi_summary_functionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Kpi_summary_function as Kpi_summary_function");
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
	
	public static java.util.Iterator iterateKpi_summary_functionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Kpi_summary_function as Kpi_summary_function");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Kpi_summary_function", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kpi_summary_function loadKpi_summary_functionByCriteria(Kpi_summary_functionCriteria kpi_summary_functionCriteria) {
		Kpi_summary_function[] kpi_summary_functions = listKpi_summary_functionByCriteria(kpi_summary_functionCriteria);
		if(kpi_summary_functions == null || kpi_summary_functions.length == 0) {
			return null;
		}
		return kpi_summary_functions[0];
	}
	
	public static Kpi_summary_function[] listKpi_summary_functionByCriteria(Kpi_summary_functionCriteria kpi_summary_functionCriteria) {
		return kpi_summary_functionCriteria.listKpi_summary_function();
	}
	
	public static Kpi_summary_function createKpi_summary_function() {
		return new eihdms.Kpi_summary_function();
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
			if(getKpi() != null) {
				getKpi().getKpi_summary_function().remove(this);
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
			if(getKpi() != null) {
				getKpi().getKpi_summary_function().remove(this);
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
	
	@Column(name="kpi_summary_function_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_KPI_SUMMARY_FUNCTION_KPI_SUMMARY_FUNCTION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_KPI_SUMMARY_FUNCTION_KPI_SUMMARY_FUNCTION_ID_GENERATOR", strategy="native")	
	private int kpi_summary_function_id;
	
	@ManyToOne(targetEntity=eihdms.Kpi.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="kpi_id", referencedColumnName="kpi_id", nullable=false) }, foreignKey=@ForeignKey(name="FKkpi_summar177936"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Kpi kpi;
	
	@Column(name="kpi_summary_function_name", nullable=false, length=100)	
	private String kpi_summary_function_name;
	
	@Column(name="summary_function", nullable=false, length=100)	
	private String summary_function;
	
	@Column(name="data_elements_involved", nullable=false)	
	private String data_elements_involved;
	
	@Column(name="data_element_ids_involved", nullable=true)	
	private String data_element_ids_involved;
	
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
	
	private void setKpi_summary_function_id(int value) {
		this.kpi_summary_function_id = value;
	}
	
	public int getKpi_summary_function_id() {
		return kpi_summary_function_id;
	}
	
	public int getORMID() {
		return getKpi_summary_function_id();
	}
	
	public void setKpi_summary_function_name(String value) {
		this.kpi_summary_function_name = value;
	}
	
	public String getKpi_summary_function_name() {
		return kpi_summary_function_name;
	}
	
	public void setSummary_function(String value) {
		this.summary_function = value;
	}
	
	public String getSummary_function() {
		return summary_function;
	}
	
	public void setData_elements_involved(String value) {
		this.data_elements_involved = value;
	}
	
	public String getData_elements_involved() {
		return data_elements_involved;
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
	
	public void setData_element_ids_involved(String value) {
		this.data_element_ids_involved = value;
	}
	
	public String getData_element_ids_involved() {
		return data_element_ids_involved;
	}
	
	public void setKpi(eihdms.Kpi value) {
		this.kpi = value;
	}
	
	public eihdms.Kpi getKpi() {
		return kpi;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Kpi_summary_function object = (Kpi_summary_function) obj;
		return (this.getKpi_summary_function_id() == object.getKpi_summary_function_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getKpi_summary_function_id());
	}
	
}

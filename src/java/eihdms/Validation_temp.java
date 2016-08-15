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
@Table(name="validation_temp")
public class Validation_temp implements Serializable {
	public Validation_temp() {
	}
	
	public static Validation_temp loadValidation_tempByORMID(int validation_temp_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadValidation_tempByORMID(session, validation_temp_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_temp getValidation_tempByORMID(int validation_temp_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getValidation_tempByORMID(session, validation_temp_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_temp loadValidation_tempByORMID(int validation_temp_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadValidation_tempByORMID(session, validation_temp_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_temp getValidation_tempByORMID(int validation_temp_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getValidation_tempByORMID(session, validation_temp_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_temp loadValidation_tempByORMID(PersistentSession session, int validation_temp_id) throws PersistentException {
		try {
			return (Validation_temp) session.load(eihdms.Validation_temp.class, new Integer(validation_temp_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_temp getValidation_tempByORMID(PersistentSession session, int validation_temp_id) throws PersistentException {
		try {
			return (Validation_temp) session.get(eihdms.Validation_temp.class, new Integer(validation_temp_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_temp loadValidation_tempByORMID(PersistentSession session, int validation_temp_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Validation_temp) session.load(eihdms.Validation_temp.class, new Integer(validation_temp_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_temp getValidation_tempByORMID(PersistentSession session, int validation_temp_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Validation_temp) session.get(eihdms.Validation_temp.class, new Integer(validation_temp_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryValidation_temp(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryValidation_temp(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryValidation_temp(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryValidation_temp(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_temp[] listValidation_tempByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listValidation_tempByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_temp[] listValidation_tempByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listValidation_tempByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryValidation_temp(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Validation_temp as Validation_temp");
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
	
	public static List queryValidation_temp(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Validation_temp as Validation_temp");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Validation_temp", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_temp[] listValidation_tempByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryValidation_temp(session, condition, orderBy);
			return (Validation_temp[]) list.toArray(new Validation_temp[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_temp[] listValidation_tempByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryValidation_temp(session, condition, orderBy, lockMode);
			return (Validation_temp[]) list.toArray(new Validation_temp[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_temp loadValidation_tempByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadValidation_tempByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_temp loadValidation_tempByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadValidation_tempByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_temp loadValidation_tempByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Validation_temp[] validation_temps = listValidation_tempByQuery(session, condition, orderBy);
		if (validation_temps != null && validation_temps.length > 0)
			return validation_temps[0];
		else
			return null;
	}
	
	public static Validation_temp loadValidation_tempByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Validation_temp[] validation_temps = listValidation_tempByQuery(session, condition, orderBy, lockMode);
		if (validation_temps != null && validation_temps.length > 0)
			return validation_temps[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateValidation_tempByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateValidation_tempByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateValidation_tempByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateValidation_tempByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateValidation_tempByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Validation_temp as Validation_temp");
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
	
	public static java.util.Iterator iterateValidation_tempByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Validation_temp as Validation_temp");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Validation_temp", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_temp loadValidation_tempByCriteria(Validation_tempCriteria validation_tempCriteria) {
		Validation_temp[] validation_temps = listValidation_tempByCriteria(validation_tempCriteria);
		if(validation_temps == null || validation_temps.length == 0) {
			return null;
		}
		return validation_temps[0];
	}
	
	public static Validation_temp[] listValidation_tempByCriteria(Validation_tempCriteria validation_tempCriteria) {
		return validation_tempCriteria.listValidation_temp();
	}
	
	public static Validation_temp createValidation_temp() {
		return new eihdms.Validation_temp();
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
			if(getReport_form() != null) {
				getReport_form().getValidation_temp().remove(this);
			}
			
			if(getReport_form_group() != null) {
				getReport_form_group().getValidation_temp().remove(this);
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
			if(getReport_form() != null) {
				getReport_form().getValidation_temp().remove(this);
			}
			
			if(getReport_form_group() != null) {
				getReport_form_group().getValidation_temp().remove(this);
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
	
	@Column(name="validation_temp_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_VALIDATION_TEMP_VALIDATION_TEMP_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_VALIDATION_TEMP_VALIDATION_TEMP_ID_GENERATOR", strategy="native")	
	private int validation_temp_id;
	
	@ManyToOne(targetEntity=eihdms.Report_form.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="report_form_id", referencedColumnName="report_form_id", nullable=false) })	
	private eihdms.Report_form report_form;
	
	@ManyToOne(targetEntity=eihdms.Report_form_group.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="report_form_group_id", referencedColumnName="report_form_group_id", nullable=false) })	
	private eihdms.Report_form_group report_form_group;
	
	@Column(name="validation_temp_name", nullable=false, length=100)	
	private String validation_temp_name;
	
	@Column(name="valifation_temp_formula", nullable=false, length=200)	
	private String valifation_temp_formula;
	
	@Column(name="data_elements_involved", nullable=true)	
	private String data_elements_involved;
	
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
	
	private void setValidation_temp_id(int value) {
		this.validation_temp_id = value;
	}
	
	public int getValidation_temp_id() {
		return validation_temp_id;
	}
	
	public int getORMID() {
		return getValidation_temp_id();
	}
	
	public void setValidation_temp_name(String value) {
		this.validation_temp_name = value;
	}
	
	public String getValidation_temp_name() {
		return validation_temp_name;
	}
	
	public void setValifation_temp_formula(String value) {
		this.valifation_temp_formula = value;
	}
	
	public String getValifation_temp_formula() {
		return valifation_temp_formula;
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
	
	public void setData_elements_involved(String value) {
		this.data_elements_involved = value;
	}
	
	public String getData_elements_involved() {
		return data_elements_involved;
	}
	
	public void setReport_form(eihdms.Report_form value) {
		this.report_form = value;
	}
	
	public eihdms.Report_form getReport_form() {
		return report_form;
	}
	
	public void setReport_form_group(eihdms.Report_form_group value) {
		this.report_form_group = value;
	}
	
	public eihdms.Report_form_group getReport_form_group() {
		return report_form_group;
	}
	
	public String toString() {
		return String.valueOf(getValidation_temp_id());
	}
	
}

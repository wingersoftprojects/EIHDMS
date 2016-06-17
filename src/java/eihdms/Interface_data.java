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
@Table(name="interface_data")
public class Interface_data implements Serializable {
	public Interface_data() {
	}
	
	public static Interface_data loadInterface_dataByORMID(int interface_data_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadInterface_dataByORMID(session, interface_data_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data getInterface_dataByORMID(int interface_data_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getInterface_dataByORMID(session, interface_data_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data loadInterface_dataByORMID(int interface_data_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadInterface_dataByORMID(session, interface_data_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data getInterface_dataByORMID(int interface_data_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getInterface_dataByORMID(session, interface_data_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data loadInterface_dataByORMID(PersistentSession session, int interface_data_id) throws PersistentException {
		try {
			return (Interface_data) session.load(eihdms.Interface_data.class, new Integer(interface_data_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data getInterface_dataByORMID(PersistentSession session, int interface_data_id) throws PersistentException {
		try {
			return (Interface_data) session.get(eihdms.Interface_data.class, new Integer(interface_data_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data loadInterface_dataByORMID(PersistentSession session, int interface_data_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Interface_data) session.load(eihdms.Interface_data.class, new Integer(interface_data_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data getInterface_dataByORMID(PersistentSession session, int interface_data_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Interface_data) session.get(eihdms.Interface_data.class, new Integer(interface_data_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInterface_data(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryInterface_data(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInterface_data(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryInterface_data(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data[] listInterface_dataByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listInterface_dataByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data[] listInterface_dataByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listInterface_dataByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInterface_data(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Interface_data as Interface_data");
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
	
	public static List queryInterface_data(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Interface_data as Interface_data");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Interface_data", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data[] listInterface_dataByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryInterface_data(session, condition, orderBy);
			return (Interface_data[]) list.toArray(new Interface_data[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data[] listInterface_dataByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryInterface_data(session, condition, orderBy, lockMode);
			return (Interface_data[]) list.toArray(new Interface_data[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data loadInterface_dataByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadInterface_dataByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data loadInterface_dataByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadInterface_dataByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data loadInterface_dataByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Interface_data[] interface_datas = listInterface_dataByQuery(session, condition, orderBy);
		if (interface_datas != null && interface_datas.length > 0)
			return interface_datas[0];
		else
			return null;
	}
	
	public static Interface_data loadInterface_dataByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Interface_data[] interface_datas = listInterface_dataByQuery(session, condition, orderBy, lockMode);
		if (interface_datas != null && interface_datas.length > 0)
			return interface_datas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateInterface_dataByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateInterface_dataByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateInterface_dataByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateInterface_dataByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateInterface_dataByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Interface_data as Interface_data");
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
	
	public static java.util.Iterator iterateInterface_dataByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Interface_data as Interface_data");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Interface_data", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Interface_data loadInterface_dataByCriteria(Interface_dataCriteria interface_dataCriteria) {
		Interface_data[] interface_datas = listInterface_dataByCriteria(interface_dataCriteria);
		if(interface_datas == null || interface_datas.length == 0) {
			return null;
		}
		return interface_datas[0];
	}
	
	public static Interface_data[] listInterface_dataByCriteria(Interface_dataCriteria interface_dataCriteria) {
		return interface_dataCriteria.listInterface_data();
	}
	
	public static Interface_data createInterface_data() {
		return new eihdms.Interface_data();
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
			if(getData_element() != null) {
				getData_element().getInterface_data().remove(this);
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
			if(getData_element() != null) {
				getData_element().getInterface_data().remove(this);
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
	
	@Column(name="interface_data_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_INTERFACE_DATA_INTERFACE_DATA_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_INTERFACE_DATA_INTERFACE_DATA_ID_GENERATOR", strategy="native")	
	private int interface_data_id;
	
	@ManyToOne(targetEntity=eihdms.Data_element.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="data_element_id", referencedColumnName="data_element_id", nullable=false) })	
	private eihdms.Data_element data_element;
	
	@Column(name="data_element_value", nullable=false, length=100)	
	private String data_element_value;
	
	@Column(name="health_facility_name", nullable=true, length=100)	
	private String health_facility_name;
	
	@Column(name="parish_name", nullable=true, length=100)	
	private String parish_name;
	
	@Column(name="district_name", nullable=true, length=100)	
	private String district_name;
	
	@Column(name="report_period_from_date", nullable=false)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date report_period_from_date;
	
	@Column(name="report_period_to_date", nullable=false)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date report_period_to_date;
	
	@Column(name="report_period_name", nullable=false, length=100)	
	private String report_period_name;
	
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
	
	@Column(name="status", nullable=false, length=100)	
	private String status;
	
	@Column(name="status_desc", nullable=true, length=100)	
	private String status_desc;
	
	private void setInterface_data_id(int value) {
		this.interface_data_id = value;
	}
	
	public int getInterface_data_id() {
		return interface_data_id;
	}
	
	public int getORMID() {
		return getInterface_data_id();
	}
	
	public void setData_element_value(String value) {
		this.data_element_value = value;
	}
	
	public String getData_element_value() {
		return data_element_value;
	}
	
	public void setHealth_facility_name(String value) {
		this.health_facility_name = value;
	}
	
	public String getHealth_facility_name() {
		return health_facility_name;
	}
	
	public void setParish_name(String value) {
		this.parish_name = value;
	}
	
	public String getParish_name() {
		return parish_name;
	}
	
	public void setDistrict_name(String value) {
		this.district_name = value;
	}
	
	public String getDistrict_name() {
		return district_name;
	}
	
	public void setReport_period_from_date(java.util.Date value) {
		this.report_period_from_date = value;
	}
	
	public java.util.Date getReport_period_from_date() {
		return report_period_from_date;
	}
	
	public void setReport_period_to_date(java.util.Date value) {
		this.report_period_to_date = value;
	}
	
	public java.util.Date getReport_period_to_date() {
		return report_period_to_date;
	}
	
	public void setReport_period_name(String value) {
		this.report_period_name = value;
	}
	
	public String getReport_period_name() {
		return report_period_name;
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
	
	public void setStatus(String value) {
		this.status = value;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus_desc(String value) {
		this.status_desc = value;
	}
	
	public String getStatus_desc() {
		return status_desc;
	}
	
	public void setData_element(eihdms.Data_element value) {
		this.data_element = value;
	}
	
	public eihdms.Data_element getData_element() {
		return data_element;
	}
	
	public String toString() {
		return String.valueOf(getInterface_data_id());
	}
	
}

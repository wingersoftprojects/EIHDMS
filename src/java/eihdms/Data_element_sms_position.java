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
@Table(name="data_element_sms_position", uniqueConstraints={ @UniqueConstraint(name="desp_data_element", columnNames={ "data_element_id" }) })
public class Data_element_sms_position implements Serializable {
	public Data_element_sms_position() {
	}
	
	public static Data_element_sms_position loadData_element_sms_positionByORMID(int data_element_sms_position_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadData_element_sms_positionByORMID(session, data_element_sms_position_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element_sms_position getData_element_sms_positionByORMID(int data_element_sms_position_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getData_element_sms_positionByORMID(session, data_element_sms_position_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element_sms_position loadData_element_sms_positionByORMID(int data_element_sms_position_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadData_element_sms_positionByORMID(session, data_element_sms_position_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element_sms_position getData_element_sms_positionByORMID(int data_element_sms_position_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getData_element_sms_positionByORMID(session, data_element_sms_position_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element_sms_position loadData_element_sms_positionByORMID(PersistentSession session, int data_element_sms_position_id) throws PersistentException {
		try {
			return (Data_element_sms_position) session.load(eihdms.Data_element_sms_position.class, new Integer(data_element_sms_position_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element_sms_position getData_element_sms_positionByORMID(PersistentSession session, int data_element_sms_position_id) throws PersistentException {
		try {
			return (Data_element_sms_position) session.get(eihdms.Data_element_sms_position.class, new Integer(data_element_sms_position_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element_sms_position loadData_element_sms_positionByORMID(PersistentSession session, int data_element_sms_position_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Data_element_sms_position) session.load(eihdms.Data_element_sms_position.class, new Integer(data_element_sms_position_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element_sms_position getData_element_sms_positionByORMID(PersistentSession session, int data_element_sms_position_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Data_element_sms_position) session.get(eihdms.Data_element_sms_position.class, new Integer(data_element_sms_position_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryData_element_sms_position(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryData_element_sms_position(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryData_element_sms_position(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryData_element_sms_position(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element_sms_position[] listData_element_sms_positionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listData_element_sms_positionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element_sms_position[] listData_element_sms_positionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listData_element_sms_positionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryData_element_sms_position(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Data_element_sms_position as Data_element_sms_position");
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
	
	public static List queryData_element_sms_position(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Data_element_sms_position as Data_element_sms_position");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Data_element_sms_position", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element_sms_position[] listData_element_sms_positionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryData_element_sms_position(session, condition, orderBy);
			return (Data_element_sms_position[]) list.toArray(new Data_element_sms_position[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element_sms_position[] listData_element_sms_positionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryData_element_sms_position(session, condition, orderBy, lockMode);
			return (Data_element_sms_position[]) list.toArray(new Data_element_sms_position[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element_sms_position loadData_element_sms_positionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadData_element_sms_positionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element_sms_position loadData_element_sms_positionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadData_element_sms_positionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element_sms_position loadData_element_sms_positionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Data_element_sms_position[] data_element_sms_positions = listData_element_sms_positionByQuery(session, condition, orderBy);
		if (data_element_sms_positions != null && data_element_sms_positions.length > 0)
			return data_element_sms_positions[0];
		else
			return null;
	}
	
	public static Data_element_sms_position loadData_element_sms_positionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Data_element_sms_position[] data_element_sms_positions = listData_element_sms_positionByQuery(session, condition, orderBy, lockMode);
		if (data_element_sms_positions != null && data_element_sms_positions.length > 0)
			return data_element_sms_positions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateData_element_sms_positionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateData_element_sms_positionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateData_element_sms_positionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateData_element_sms_positionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateData_element_sms_positionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Data_element_sms_position as Data_element_sms_position");
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
	
	public static java.util.Iterator iterateData_element_sms_positionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Data_element_sms_position as Data_element_sms_position");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Data_element_sms_position", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element_sms_position loadData_element_sms_positionByCriteria(Data_element_sms_positionCriteria data_element_sms_positionCriteria) {
		Data_element_sms_position[] data_element_sms_positions = listData_element_sms_positionByCriteria(data_element_sms_positionCriteria);
		if(data_element_sms_positions == null || data_element_sms_positions.length == 0) {
			return null;
		}
		return data_element_sms_positions[0];
	}
	
	public static Data_element_sms_position[] listData_element_sms_positionByCriteria(Data_element_sms_positionCriteria data_element_sms_positionCriteria) {
		return data_element_sms_positionCriteria.listData_element_sms_position();
	}
	
	public static Data_element_sms_position createData_element_sms_position() {
		return new eihdms.Data_element_sms_position();
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
			if(getData_element() != null) {
				getData_element().setData_element_sms_position(null);
			}
			
			if(getReport_form_short_code() != null) {
				getReport_form_short_code().getData_element_sms_position().remove(this);
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
				getData_element().setData_element_sms_position(null);
			}
			
			if(getReport_form_short_code() != null) {
				getReport_form_short_code().getData_element_sms_position().remove(this);
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
	
	@Column(name="data_element_sms_position_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_DATA_ELEMENT_SMS_POSITION_DATA_ELEMENT_SMS_POSITION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_DATA_ELEMENT_SMS_POSITION_DATA_ELEMENT_SMS_POSITION_ID_GENERATOR", strategy="native")	
	private int data_element_sms_position_id;
	
	@OneToOne(optional=false, targetEntity=eihdms.Data_element.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="data_element_id", referencedColumnName="data_element_id", nullable=false) }, foreignKey=@ForeignKey(name="FKdata_eleme360408"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Data_element data_element;
	
	@Column(name="value_position", nullable=false, length=2)	
	private int value_position;
	
	@Column(name="code_position", nullable=true, length=2)	
	private int code_position;
	
	@ManyToOne(targetEntity=eihdms.Report_form_short_code.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="report_form_short_code_id", referencedColumnName="report_form_short_code_id") }, foreignKey=@ForeignKey(name="FKdata_eleme644022"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Report_form_short_code report_form_short_code;
	
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
	
	private void setData_element_sms_position_id(int value) {
		this.data_element_sms_position_id = value;
	}
	
	public int getData_element_sms_position_id() {
		return data_element_sms_position_id;
	}
	
	public int getORMID() {
		return getData_element_sms_position_id();
	}
	
	public void setValue_position(int value) {
		this.value_position = value;
	}
	
	public int getValue_position() {
		return value_position;
	}
	
	public void setCode_position(int value) {
		this.code_position = value;
	}
	
	public int getCode_position() {
		return code_position;
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
	
	public void setReport_form_short_code(eihdms.Report_form_short_code value) {
		this.report_form_short_code = value;
	}
	
	public eihdms.Report_form_short_code getReport_form_short_code() {
		return report_form_short_code;
	}
	
	public void setData_element(eihdms.Data_element value) {
		this.data_element = value;
	}
	
	public eihdms.Data_element getData_element() {
		return data_element;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Data_element_sms_position object = (Data_element_sms_position) obj;
		return (this.getData_element_sms_position_id() == object.getData_element_sms_position_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getData_element_sms_position_id());
	}
	
}

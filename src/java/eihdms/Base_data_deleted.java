/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: wence.twesigye
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
@Table(name="base_data_deleted")
public class Base_data_deleted implements Serializable {
	public Base_data_deleted() {
	}
	
	public static Base_data_deleted loadBase_data_deletedByORMID(int base_data_deleted_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadBase_data_deletedByORMID(session, base_data_deleted_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data_deleted getBase_data_deletedByORMID(int base_data_deleted_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getBase_data_deletedByORMID(session, base_data_deleted_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data_deleted loadBase_data_deletedByORMID(int base_data_deleted_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadBase_data_deletedByORMID(session, base_data_deleted_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data_deleted getBase_data_deletedByORMID(int base_data_deleted_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getBase_data_deletedByORMID(session, base_data_deleted_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data_deleted loadBase_data_deletedByORMID(PersistentSession session, int base_data_deleted_id) throws PersistentException {
		try {
			return (Base_data_deleted) session.load(eihdms.Base_data_deleted.class, new Integer(base_data_deleted_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data_deleted getBase_data_deletedByORMID(PersistentSession session, int base_data_deleted_id) throws PersistentException {
		try {
			return (Base_data_deleted) session.get(eihdms.Base_data_deleted.class, new Integer(base_data_deleted_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data_deleted loadBase_data_deletedByORMID(PersistentSession session, int base_data_deleted_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Base_data_deleted) session.load(eihdms.Base_data_deleted.class, new Integer(base_data_deleted_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data_deleted getBase_data_deletedByORMID(PersistentSession session, int base_data_deleted_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Base_data_deleted) session.get(eihdms.Base_data_deleted.class, new Integer(base_data_deleted_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBase_data_deleted(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryBase_data_deleted(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBase_data_deleted(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryBase_data_deleted(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data_deleted[] listBase_data_deletedByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listBase_data_deletedByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data_deleted[] listBase_data_deletedByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listBase_data_deletedByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBase_data_deleted(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Base_data_deleted as Base_data_deleted");
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
	
	public static List queryBase_data_deleted(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Base_data_deleted as Base_data_deleted");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Base_data_deleted", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data_deleted[] listBase_data_deletedByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryBase_data_deleted(session, condition, orderBy);
			return (Base_data_deleted[]) list.toArray(new Base_data_deleted[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data_deleted[] listBase_data_deletedByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryBase_data_deleted(session, condition, orderBy, lockMode);
			return (Base_data_deleted[]) list.toArray(new Base_data_deleted[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data_deleted loadBase_data_deletedByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadBase_data_deletedByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data_deleted loadBase_data_deletedByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadBase_data_deletedByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data_deleted loadBase_data_deletedByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Base_data_deleted[] base_data_deleteds = listBase_data_deletedByQuery(session, condition, orderBy);
		if (base_data_deleteds != null && base_data_deleteds.length > 0)
			return base_data_deleteds[0];
		else
			return null;
	}
	
	public static Base_data_deleted loadBase_data_deletedByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Base_data_deleted[] base_data_deleteds = listBase_data_deletedByQuery(session, condition, orderBy, lockMode);
		if (base_data_deleteds != null && base_data_deleteds.length > 0)
			return base_data_deleteds[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateBase_data_deletedByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateBase_data_deletedByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBase_data_deletedByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateBase_data_deletedByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBase_data_deletedByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Base_data_deleted as Base_data_deleted");
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
	
	public static java.util.Iterator iterateBase_data_deletedByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Base_data_deleted as Base_data_deleted");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Base_data_deleted", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data_deleted loadBase_data_deletedByCriteria(Base_data_deletedCriteria base_data_deletedCriteria) {
		Base_data_deleted[] base_data_deleteds = listBase_data_deletedByCriteria(base_data_deletedCriteria);
		if(base_data_deleteds == null || base_data_deleteds.length == 0) {
			return null;
		}
		return base_data_deleteds[0];
	}
	
	public static Base_data_deleted[] listBase_data_deletedByCriteria(Base_data_deletedCriteria base_data_deletedCriteria) {
		return base_data_deletedCriteria.listBase_data_deleted();
	}
	
	public static Base_data_deleted createBase_data_deleted() {
		return new eihdms.Base_data_deleted();
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
	
	@Column(name="base_data_deleted_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_BASE_DATA_DELETED_BASE_DATA_DELETED_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_BASE_DATA_DELETED_BASE_DATA_DELETED_ID_GENERATOR", strategy="native")	
	private int base_data_deleted_id;
	
	@Column(name="base_data_id", nullable=false, length=11)	
	private int base_data_id;
	
	@Column(name="batch_id", nullable=true, length=11)	
	private Integer batch_id;
	
	@Column(name="data_element_id", nullable=false, length=11)	
	private int data_element_id;
	
	@Column(name="data_element_value", nullable=false, length=100)	
	private String data_element_value;
	
	@Column(name="health_facility_id", nullable=true, length=11)	
	private Integer health_facility_id;
	
	@Column(name="parish_id", nullable=true, length=11)	
	private Integer parish_id;
	
	@Column(name="sub_county_id", nullable=true, length=11)	
	private Integer sub_county_id;
	
	@Column(name="county_id", nullable=true, length=11)	
	private Integer county_id;
	
	@Column(name="district_id", nullable=true, length=11)	
	private Integer district_id;
	
	@Column(name="financial_year_id", nullable=true, length=11)	
	private Integer financial_year_id;
	
	@Column(name="report_period_month", nullable=true, length=11)	
	private Integer report_period_month;
	
	@Column(name="report_period_week", nullable=true, length=11)	
	private Integer report_period_week;
	
	@Column(name="report_period_year", nullable=true, length=11)	
	private Integer report_period_year;
	
	@Column(name="report_period_quarter", nullable=true, length=11)	
	private Integer report_period_quarter;
	
	@Column(name="report_period_from_date", nullable=false)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date report_period_from_date;
	
	@Column(name="report_period_to_date", nullable=false)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date report_period_to_date;
	
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
	
	@Column(name="report_period_bi_month", nullable=true, length=11)	
	private Integer report_period_bi_month;
	
	@Column(name="report_form_id", nullable=true, length=11)	
	private Integer report_form_id;
	
	@Column(name="deleted_by", nullable=false, length=11)	
	private int deleted_by;
	
	@Column(name="delete_date", nullable=false)	
	private java.sql.Timestamp delete_date;
	
	@Column(name="report_form_group_id", nullable=true, length=11)	
	private Integer report_form_group_id;
	
	private void setBase_data_deleted_id(int value) {
		this.base_data_deleted_id = value;
	}
	
	public int getBase_data_deleted_id() {
		return base_data_deleted_id;
	}
	
	public int getORMID() {
		return getBase_data_deleted_id();
	}
	
	public void setBase_data_id(int value) {
		this.base_data_id = value;
	}
	
	public int getBase_data_id() {
		return base_data_id;
	}
	
	public void setBatch_id(int value) {
		setBatch_id(new Integer(value));
	}
	
	public void setBatch_id(Integer value) {
		this.batch_id = value;
	}
	
	public Integer getBatch_id() {
		return batch_id;
	}
	
	public void setData_element_id(int value) {
		this.data_element_id = value;
	}
	
	public int getData_element_id() {
		return data_element_id;
	}
	
	public void setData_element_value(String value) {
		this.data_element_value = value;
	}
	
	public String getData_element_value() {
		return data_element_value;
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
	
	public void setParish_id(int value) {
		setParish_id(new Integer(value));
	}
	
	public void setParish_id(Integer value) {
		this.parish_id = value;
	}
	
	public Integer getParish_id() {
		return parish_id;
	}
	
	public void setSub_county_id(int value) {
		setSub_county_id(new Integer(value));
	}
	
	public void setSub_county_id(Integer value) {
		this.sub_county_id = value;
	}
	
	public Integer getSub_county_id() {
		return sub_county_id;
	}
	
	public void setCounty_id(int value) {
		setCounty_id(new Integer(value));
	}
	
	public void setCounty_id(Integer value) {
		this.county_id = value;
	}
	
	public Integer getCounty_id() {
		return county_id;
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
	
	public void setFinancial_year_id(int value) {
		setFinancial_year_id(new Integer(value));
	}
	
	public void setFinancial_year_id(Integer value) {
		this.financial_year_id = value;
	}
	
	public Integer getFinancial_year_id() {
		return financial_year_id;
	}
	
	public void setReport_period_month(int value) {
		setReport_period_month(new Integer(value));
	}
	
	public void setReport_period_month(Integer value) {
		this.report_period_month = value;
	}
	
	public Integer getReport_period_month() {
		return report_period_month;
	}
	
	public void setReport_period_week(int value) {
		setReport_period_week(new Integer(value));
	}
	
	public void setReport_period_week(Integer value) {
		this.report_period_week = value;
	}
	
	public Integer getReport_period_week() {
		return report_period_week;
	}
	
	public void setReport_period_year(int value) {
		setReport_period_year(new Integer(value));
	}
	
	public void setReport_period_year(Integer value) {
		this.report_period_year = value;
	}
	
	public Integer getReport_period_year() {
		return report_period_year;
	}
	
	public void setReport_period_quarter(int value) {
		setReport_period_quarter(new Integer(value));
	}
	
	public void setReport_period_quarter(Integer value) {
		this.report_period_quarter = value;
	}
	
	public Integer getReport_period_quarter() {
		return report_period_quarter;
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
	
	public void setReport_period_bi_month(int value) {
		setReport_period_bi_month(new Integer(value));
	}
	
	public void setReport_period_bi_month(Integer value) {
		this.report_period_bi_month = value;
	}
	
	public Integer getReport_period_bi_month() {
		return report_period_bi_month;
	}
	
	public void setReport_form_id(int value) {
		setReport_form_id(new Integer(value));
	}
	
	public void setReport_form_id(Integer value) {
		this.report_form_id = value;
	}
	
	public Integer getReport_form_id() {
		return report_form_id;
	}
	
	public void setDeleted_by(int value) {
		this.deleted_by = value;
	}
	
	public int getDeleted_by() {
		return deleted_by;
	}
	
	public void setDelete_date(java.sql.Timestamp value) {
		this.delete_date = value;
	}
	
	public java.sql.Timestamp getDelete_date() {
		return delete_date;
	}
	
	public void setReport_form_group_id(int value) {
		setReport_form_group_id(new Integer(value));
	}
	
	public void setReport_form_group_id(Integer value) {
		this.report_form_group_id = value;
	}
	
	public Integer getReport_form_group_id() {
		return report_form_group_id;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Base_data_deleted object = (Base_data_deleted) obj;
		return (this.getBase_data_deleted_id() == object.getBase_data_deleted_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getBase_data_deleted_id());
	}
	
}

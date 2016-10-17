/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: btwesigye
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
@Table(name="base_data")
public class Base_data implements Serializable {
	public Base_data() {
	}
	
	public static Base_data loadBase_dataByORMID(int base_data_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadBase_dataByORMID(session, base_data_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data getBase_dataByORMID(int base_data_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getBase_dataByORMID(session, base_data_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data loadBase_dataByORMID(int base_data_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadBase_dataByORMID(session, base_data_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data getBase_dataByORMID(int base_data_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getBase_dataByORMID(session, base_data_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data loadBase_dataByORMID(PersistentSession session, int base_data_id) throws PersistentException {
		try {
			return (Base_data) session.load(eihdms.Base_data.class, new Integer(base_data_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data getBase_dataByORMID(PersistentSession session, int base_data_id) throws PersistentException {
		try {
			return (Base_data) session.get(eihdms.Base_data.class, new Integer(base_data_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data loadBase_dataByORMID(PersistentSession session, int base_data_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Base_data) session.load(eihdms.Base_data.class, new Integer(base_data_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data getBase_dataByORMID(PersistentSession session, int base_data_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Base_data) session.get(eihdms.Base_data.class, new Integer(base_data_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBase_data(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryBase_data(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBase_data(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryBase_data(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data[] listBase_dataByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listBase_dataByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data[] listBase_dataByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listBase_dataByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBase_data(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Base_data as Base_data");
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
	
	public static List queryBase_data(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Base_data as Base_data");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Base_data", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data[] listBase_dataByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryBase_data(session, condition, orderBy);
			return (Base_data[]) list.toArray(new Base_data[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data[] listBase_dataByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryBase_data(session, condition, orderBy, lockMode);
			return (Base_data[]) list.toArray(new Base_data[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data loadBase_dataByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadBase_dataByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data loadBase_dataByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadBase_dataByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data loadBase_dataByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Base_data[] base_datas = listBase_dataByQuery(session, condition, orderBy);
		if (base_datas != null && base_datas.length > 0)
			return base_datas[0];
		else
			return null;
	}
	
	public static Base_data loadBase_dataByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Base_data[] base_datas = listBase_dataByQuery(session, condition, orderBy, lockMode);
		if (base_datas != null && base_datas.length > 0)
			return base_datas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateBase_dataByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateBase_dataByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBase_dataByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateBase_dataByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBase_dataByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Base_data as Base_data");
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
	
	public static java.util.Iterator iterateBase_dataByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Base_data as Base_data");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Base_data", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Base_data loadBase_dataByCriteria(Base_dataCriteria base_dataCriteria) {
		Base_data[] base_datas = listBase_dataByCriteria(base_dataCriteria);
		if(base_datas == null || base_datas.length == 0) {
			return null;
		}
		return base_datas[0];
	}
	
	public static Base_data[] listBase_dataByCriteria(Base_dataCriteria base_dataCriteria) {
		return base_dataCriteria.listBase_data();
	}
	
	public static Base_data createBase_data() {
		return new eihdms.Base_data();
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
			if(getBatch() != null) {
				getBatch().getBase_data().remove(this);
			}
			
			if(getData_element() != null) {
				getData_element().getBase_data().remove(this);
			}
			
			if(getHealth_facility() != null) {
				getHealth_facility().getBase_data().remove(this);
			}
			
			if(getParish() != null) {
				getParish().getBase_data().remove(this);
			}
			
			if(getSub_county() != null) {
				getSub_county().getBase_data().remove(this);
			}
			
			if(getCounty() != null) {
				getCounty().getBase_data().remove(this);
			}
			
			if(getDistrict() != null) {
				getDistrict().getBase_data().remove(this);
			}
			
			if(getFinancial_year() != null) {
				getFinancial_year().getBase_data().remove(this);
			}
			
			if(getReport_form() != null) {
				getReport_form().getBase_data().remove(this);
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
			if(getBatch() != null) {
				getBatch().getBase_data().remove(this);
			}
			
			if(getData_element() != null) {
				getData_element().getBase_data().remove(this);
			}
			
			if(getHealth_facility() != null) {
				getHealth_facility().getBase_data().remove(this);
			}
			
			if(getParish() != null) {
				getParish().getBase_data().remove(this);
			}
			
			if(getSub_county() != null) {
				getSub_county().getBase_data().remove(this);
			}
			
			if(getCounty() != null) {
				getCounty().getBase_data().remove(this);
			}
			
			if(getDistrict() != null) {
				getDistrict().getBase_data().remove(this);
			}
			
			if(getFinancial_year() != null) {
				getFinancial_year().getBase_data().remove(this);
			}
			
			if(getReport_form() != null) {
				getReport_form().getBase_data().remove(this);
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
	
	@Column(name="base_data_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_BASE_DATA_BASE_DATA_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_BASE_DATA_BASE_DATA_ID_GENERATOR", strategy="native")	
	private int base_data_id;
	
	@ManyToOne(targetEntity=eihdms.Batch.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="batch_id", referencedColumnName="batch_id") })	
	private eihdms.Batch batch;
	
	@ManyToOne(targetEntity=eihdms.Data_element.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="data_element_id", referencedColumnName="data_element_id", nullable=false) })	
	private eihdms.Data_element data_element;
	
	@Column(name="data_element_value", nullable=false, length=100)	
	private String data_element_value;
	
	@ManyToOne(targetEntity=eihdms.Health_facility.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="health_facility_id", referencedColumnName="health_facility_id") })	
	private eihdms.Health_facility health_facility;
	
	@ManyToOne(targetEntity=eihdms.Parish.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="parish_id", referencedColumnName="parish_id") })	
	private eihdms.Parish parish;
	
	@ManyToOne(targetEntity=eihdms.Sub_county.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="sub_county_id", referencedColumnName="sub_county_id") })	
	private eihdms.Sub_county sub_county;
	
	@ManyToOne(targetEntity=eihdms.County.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="county_id", referencedColumnName="county_id") })	
	private eihdms.County county;
	
	@ManyToOne(targetEntity=eihdms.District.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="district_id", referencedColumnName="district_id") })	
	private eihdms.District district;
	
	@ManyToOne(targetEntity=eihdms.Financial_year.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="financial_year_id", referencedColumnName="financial_year_id") })	
	private eihdms.Financial_year financial_year;
	
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
	
	@ManyToOne(targetEntity=eihdms.Report_form.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="report_form_id", referencedColumnName="report_form_id") })	
	private eihdms.Report_form report_form;
	
	@Column(name="report_form_group_id", nullable=true, length=11)	
	private Integer report_form_group_id;
	
	private void setBase_data_id(int value) {
		this.base_data_id = value;
	}
	
	public int getBase_data_id() {
		return base_data_id;
	}
	
	public int getORMID() {
		return getBase_data_id();
	}
	
	public void setData_element_value(String value) {
		this.data_element_value = value;
	}
	
	public String getData_element_value() {
		return data_element_value;
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
	
	public void setReport_form_group_id(int value) {
		setReport_form_group_id(new Integer(value));
	}
	
	public void setReport_form_group_id(Integer value) {
		this.report_form_group_id = value;
	}
	
	public Integer getReport_form_group_id() {
		return report_form_group_id;
	}
	
	public void setData_element(eihdms.Data_element value) {
		this.data_element = value;
	}
	
	public eihdms.Data_element getData_element() {
		return data_element;
	}
	
	public void setHealth_facility(eihdms.Health_facility value) {
		this.health_facility = value;
	}
	
	public eihdms.Health_facility getHealth_facility() {
		return health_facility;
	}
	
	public void setParish(eihdms.Parish value) {
		this.parish = value;
	}
	
	public eihdms.Parish getParish() {
		return parish;
	}
	
	public void setDistrict(eihdms.District value) {
		this.district = value;
	}
	
	public eihdms.District getDistrict() {
		return district;
	}
	
	public void setFinancial_year(eihdms.Financial_year value) {
		this.financial_year = value;
	}
	
	public eihdms.Financial_year getFinancial_year() {
		return financial_year;
	}
	
	public void setSub_county(eihdms.Sub_county value) {
		this.sub_county = value;
	}
	
	public eihdms.Sub_county getSub_county() {
		return sub_county;
	}
	
	public void setBatch(eihdms.Batch value) {
		this.batch = value;
	}
	
	public eihdms.Batch getBatch() {
		return batch;
	}
	
	public void setReport_form(eihdms.Report_form value) {
		this.report_form = value;
	}
	
	public eihdms.Report_form getReport_form() {
		return report_form;
	}
	
	public void setCounty(eihdms.County value) {
		this.county = value;
	}
	
	public eihdms.County getCounty() {
		return county;
	}
	
	public String toString() {
		return String.valueOf(getBase_data_id());
	}
	
}

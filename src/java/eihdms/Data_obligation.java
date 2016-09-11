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
@Table(name="data_obligation")
public class Data_obligation implements Serializable {
	public Data_obligation() {
	}
	
	public static Data_obligation loadData_obligationByORMID(int data_obligation_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadData_obligationByORMID(session, data_obligation_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_obligation getData_obligationByORMID(int data_obligation_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getData_obligationByORMID(session, data_obligation_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_obligation loadData_obligationByORMID(int data_obligation_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadData_obligationByORMID(session, data_obligation_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_obligation getData_obligationByORMID(int data_obligation_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getData_obligationByORMID(session, data_obligation_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_obligation loadData_obligationByORMID(PersistentSession session, int data_obligation_id) throws PersistentException {
		try {
			return (Data_obligation) session.load(eihdms.Data_obligation.class, new Integer(data_obligation_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_obligation getData_obligationByORMID(PersistentSession session, int data_obligation_id) throws PersistentException {
		try {
			return (Data_obligation) session.get(eihdms.Data_obligation.class, new Integer(data_obligation_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_obligation loadData_obligationByORMID(PersistentSession session, int data_obligation_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Data_obligation) session.load(eihdms.Data_obligation.class, new Integer(data_obligation_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_obligation getData_obligationByORMID(PersistentSession session, int data_obligation_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Data_obligation) session.get(eihdms.Data_obligation.class, new Integer(data_obligation_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryData_obligation(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryData_obligation(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryData_obligation(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryData_obligation(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_obligation[] listData_obligationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listData_obligationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_obligation[] listData_obligationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listData_obligationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryData_obligation(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Data_obligation as Data_obligation");
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
	
	public static List queryData_obligation(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Data_obligation as Data_obligation");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Data_obligation", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_obligation[] listData_obligationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryData_obligation(session, condition, orderBy);
			return (Data_obligation[]) list.toArray(new Data_obligation[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_obligation[] listData_obligationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryData_obligation(session, condition, orderBy, lockMode);
			return (Data_obligation[]) list.toArray(new Data_obligation[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_obligation loadData_obligationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadData_obligationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_obligation loadData_obligationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadData_obligationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_obligation loadData_obligationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Data_obligation[] data_obligations = listData_obligationByQuery(session, condition, orderBy);
		if (data_obligations != null && data_obligations.length > 0)
			return data_obligations[0];
		else
			return null;
	}
	
	public static Data_obligation loadData_obligationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Data_obligation[] data_obligations = listData_obligationByQuery(session, condition, orderBy, lockMode);
		if (data_obligations != null && data_obligations.length > 0)
			return data_obligations[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateData_obligationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateData_obligationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateData_obligationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateData_obligationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateData_obligationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Data_obligation as Data_obligation");
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
	
	public static java.util.Iterator iterateData_obligationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Data_obligation as Data_obligation");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Data_obligation", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_obligation loadData_obligationByCriteria(Data_obligationCriteria data_obligationCriteria) {
		Data_obligation[] data_obligations = listData_obligationByCriteria(data_obligationCriteria);
		if(data_obligations == null || data_obligations.length == 0) {
			return null;
		}
		return data_obligations[0];
	}
	
	public static Data_obligation[] listData_obligationByCriteria(Data_obligationCriteria data_obligationCriteria) {
		return data_obligationCriteria.listData_obligation();
	}
	
	public static Data_obligation createData_obligation() {
		return new eihdms.Data_obligation();
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
				getReport_form().getData_obligation().remove(this);
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
				getReport_form().getData_obligation().remove(this);
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
	
	@Column(name="data_obligation_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_DATA_OBLIGATION_DATA_OBLIGATION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_DATA_OBLIGATION_DATA_OBLIGATION_ID_GENERATOR", strategy="native")	
	private int data_obligation_id;
	
	@ManyToOne(targetEntity=eihdms.Report_form.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="report_form_id", referencedColumnName="report_form_id", nullable=false) })	
	private eihdms.Report_form report_form;
	
	@Column(name="count_de", nullable=true, length=11)	
	private Integer count_de;
	
	@Column(name="count_parish", nullable=true, length=11)	
	private Integer count_parish;
	
	@Column(name="count_district", nullable=true, length=11)	
	private Integer count_district;
	
	@Column(name="count_facility", nullable=true, length=11)	
	private Integer count_facility;
	
	@Column(name="year_value", nullable=true, length=11)	
	private Integer year_value;
	
	@Column(name="quarter_value", nullable=true, length=11)	
	private Integer quarter_value;
	
	@Column(name="bi_month_value", nullable=true, length=11)	
	private Integer bi_month_value;
	
	@Column(name="month_value", nullable=true, length=11)	
	private Integer month_value;
	
	@Column(name="week_value", nullable=true, length=11)	
	private Integer week_value;
	
	@Column(name="quarter_records_f", nullable=true, length=11)	
	private Integer quarter_records_f;
	
	@Column(name="quarter_records_p", nullable=true, length=11)	
	private Integer quarter_records_p;
	
	@Column(name="quarter_records_d", nullable=true, length=11)	
	private Integer quarter_records_d;
	
	@Column(name="quarter_des", nullable=true, length=11)	
	private Integer quarter_des;
	
	@Column(name="bi_month_records_f", nullable=true, length=11)	
	private Integer bi_month_records_f;
	
	@Column(name="bi_month_records_p", nullable=true, length=11)	
	private Integer bi_month_records_p;
	
	@Column(name="bi_month_records_d", nullable=true, length=11)	
	private Integer bi_month_records_d;
	
	@Column(name="bi_month_des", nullable=true, length=11)	
	private Integer bi_month_des;
	
	@Column(name="month_records_f", nullable=true, length=11)	
	private Integer month_records_f;
	
	@Column(name="month_records_p", nullable=true, length=11)	
	private Integer month_records_p;
	
	@Column(name="month_records_d", nullable=true, length=11)	
	private Integer month_records_d;
	
	@Column(name="month_des", nullable=true, length=11)	
	private Integer month_des;
	
	@Column(name="week_records_f", nullable=true, length=11)	
	private Integer week_records_f;
	
	@Column(name="week_records_p", nullable=true, length=11)	
	private Integer week_records_p;
	
	@Column(name="week_records_d", nullable=true, length=11)	
	private Integer week_records_d;
	
	@Column(name="week_des", nullable=true, length=11)	
	private Integer week_des;
	
	private void setData_obligation_id(int value) {
		this.data_obligation_id = value;
	}
	
	public int getData_obligation_id() {
		return data_obligation_id;
	}
	
	public int getORMID() {
		return getData_obligation_id();
	}
	
	public void setCount_de(int value) {
		setCount_de(new Integer(value));
	}
	
	public void setCount_de(Integer value) {
		this.count_de = value;
	}
	
	public Integer getCount_de() {
		return count_de;
	}
	
	public void setCount_parish(int value) {
		setCount_parish(new Integer(value));
	}
	
	public void setCount_parish(Integer value) {
		this.count_parish = value;
	}
	
	public Integer getCount_parish() {
		return count_parish;
	}
	
	public void setCount_district(int value) {
		setCount_district(new Integer(value));
	}
	
	public void setCount_district(Integer value) {
		this.count_district = value;
	}
	
	public Integer getCount_district() {
		return count_district;
	}
	
	public void setCount_facility(int value) {
		setCount_facility(new Integer(value));
	}
	
	public void setCount_facility(Integer value) {
		this.count_facility = value;
	}
	
	public Integer getCount_facility() {
		return count_facility;
	}
	
	public void setYear_value(int value) {
		setYear_value(new Integer(value));
	}
	
	public void setYear_value(Integer value) {
		this.year_value = value;
	}
	
	public Integer getYear_value() {
		return year_value;
	}
	
	public void setQuarter_value(int value) {
		setQuarter_value(new Integer(value));
	}
	
	public void setQuarter_value(Integer value) {
		this.quarter_value = value;
	}
	
	public Integer getQuarter_value() {
		return quarter_value;
	}
	
	public void setBi_month_value(int value) {
		setBi_month_value(new Integer(value));
	}
	
	public void setBi_month_value(Integer value) {
		this.bi_month_value = value;
	}
	
	public Integer getBi_month_value() {
		return bi_month_value;
	}
	
	public void setMonth_value(int value) {
		setMonth_value(new Integer(value));
	}
	
	public void setMonth_value(Integer value) {
		this.month_value = value;
	}
	
	public Integer getMonth_value() {
		return month_value;
	}
	
	public void setWeek_value(int value) {
		setWeek_value(new Integer(value));
	}
	
	public void setWeek_value(Integer value) {
		this.week_value = value;
	}
	
	public Integer getWeek_value() {
		return week_value;
	}
	
	public void setQuarter_records_f(int value) {
		setQuarter_records_f(new Integer(value));
	}
	
	public void setQuarter_records_f(Integer value) {
		this.quarter_records_f = value;
	}
	
	public Integer getQuarter_records_f() {
		return quarter_records_f;
	}
	
	public void setQuarter_records_p(int value) {
		setQuarter_records_p(new Integer(value));
	}
	
	public void setQuarter_records_p(Integer value) {
		this.quarter_records_p = value;
	}
	
	public Integer getQuarter_records_p() {
		return quarter_records_p;
	}
	
	public void setQuarter_records_d(int value) {
		setQuarter_records_d(new Integer(value));
	}
	
	public void setQuarter_records_d(Integer value) {
		this.quarter_records_d = value;
	}
	
	public Integer getQuarter_records_d() {
		return quarter_records_d;
	}
	
	public void setQuarter_des(int value) {
		setQuarter_des(new Integer(value));
	}
	
	public void setQuarter_des(Integer value) {
		this.quarter_des = value;
	}
	
	public Integer getQuarter_des() {
		return quarter_des;
	}
	
	public void setBi_month_records_f(int value) {
		setBi_month_records_f(new Integer(value));
	}
	
	public void setBi_month_records_f(Integer value) {
		this.bi_month_records_f = value;
	}
	
	public Integer getBi_month_records_f() {
		return bi_month_records_f;
	}
	
	public void setBi_month_records_p(int value) {
		setBi_month_records_p(new Integer(value));
	}
	
	public void setBi_month_records_p(Integer value) {
		this.bi_month_records_p = value;
	}
	
	public Integer getBi_month_records_p() {
		return bi_month_records_p;
	}
	
	public void setBi_month_records_d(int value) {
		setBi_month_records_d(new Integer(value));
	}
	
	public void setBi_month_records_d(Integer value) {
		this.bi_month_records_d = value;
	}
	
	public Integer getBi_month_records_d() {
		return bi_month_records_d;
	}
	
	public void setBi_month_des(int value) {
		setBi_month_des(new Integer(value));
	}
	
	public void setBi_month_des(Integer value) {
		this.bi_month_des = value;
	}
	
	public Integer getBi_month_des() {
		return bi_month_des;
	}
	
	public void setMonth_records_f(int value) {
		setMonth_records_f(new Integer(value));
	}
	
	public void setMonth_records_f(Integer value) {
		this.month_records_f = value;
	}
	
	public Integer getMonth_records_f() {
		return month_records_f;
	}
	
	public void setMonth_records_p(int value) {
		setMonth_records_p(new Integer(value));
	}
	
	public void setMonth_records_p(Integer value) {
		this.month_records_p = value;
	}
	
	public Integer getMonth_records_p() {
		return month_records_p;
	}
	
	public void setMonth_records_d(int value) {
		setMonth_records_d(new Integer(value));
	}
	
	public void setMonth_records_d(Integer value) {
		this.month_records_d = value;
	}
	
	public Integer getMonth_records_d() {
		return month_records_d;
	}
	
	public void setMonth_des(int value) {
		setMonth_des(new Integer(value));
	}
	
	public void setMonth_des(Integer value) {
		this.month_des = value;
	}
	
	public Integer getMonth_des() {
		return month_des;
	}
	
	public void setWeek_records_f(int value) {
		setWeek_records_f(new Integer(value));
	}
	
	public void setWeek_records_f(Integer value) {
		this.week_records_f = value;
	}
	
	public Integer getWeek_records_f() {
		return week_records_f;
	}
	
	public void setWeek_records_p(int value) {
		setWeek_records_p(new Integer(value));
	}
	
	public void setWeek_records_p(Integer value) {
		this.week_records_p = value;
	}
	
	public Integer getWeek_records_p() {
		return week_records_p;
	}
	
	public void setWeek_records_d(int value) {
		setWeek_records_d(new Integer(value));
	}
	
	public void setWeek_records_d(Integer value) {
		this.week_records_d = value;
	}
	
	public Integer getWeek_records_d() {
		return week_records_d;
	}
	
	public void setWeek_des(int value) {
		setWeek_des(new Integer(value));
	}
	
	public void setWeek_des(Integer value) {
		this.week_des = value;
	}
	
	public Integer getWeek_des() {
		return week_des;
	}
	
	public void setReport_form(eihdms.Report_form value) {
		this.report_form = value;
	}
	
	public eihdms.Report_form getReport_form() {
		return report_form;
	}
	
	public String toString() {
		return String.valueOf(getData_obligation_id());
	}
	
}

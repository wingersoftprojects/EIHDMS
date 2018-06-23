/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Ajuna Newton Brian
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
@Table(name="validation_report")
public class Validation_report implements Serializable {
	public Validation_report() {
	}
	
	public static Validation_report loadValidation_reportByORMID(int validation_report_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadValidation_reportByORMID(session, validation_report_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_report getValidation_reportByORMID(int validation_report_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getValidation_reportByORMID(session, validation_report_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_report loadValidation_reportByORMID(int validation_report_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadValidation_reportByORMID(session, validation_report_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_report getValidation_reportByORMID(int validation_report_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getValidation_reportByORMID(session, validation_report_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_report loadValidation_reportByORMID(PersistentSession session, int validation_report_id) throws PersistentException {
		try {
			return (Validation_report) session.load(eihdms.Validation_report.class, new Integer(validation_report_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_report getValidation_reportByORMID(PersistentSession session, int validation_report_id) throws PersistentException {
		try {
			return (Validation_report) session.get(eihdms.Validation_report.class, new Integer(validation_report_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_report loadValidation_reportByORMID(PersistentSession session, int validation_report_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Validation_report) session.load(eihdms.Validation_report.class, new Integer(validation_report_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_report getValidation_reportByORMID(PersistentSession session, int validation_report_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Validation_report) session.get(eihdms.Validation_report.class, new Integer(validation_report_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryValidation_report(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryValidation_report(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryValidation_report(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryValidation_report(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_report[] listValidation_reportByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listValidation_reportByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_report[] listValidation_reportByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listValidation_reportByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryValidation_report(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Validation_report as Validation_report");
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
	
	public static List queryValidation_report(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Validation_report as Validation_report");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Validation_report", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_report[] listValidation_reportByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryValidation_report(session, condition, orderBy);
			return (Validation_report[]) list.toArray(new Validation_report[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_report[] listValidation_reportByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryValidation_report(session, condition, orderBy, lockMode);
			return (Validation_report[]) list.toArray(new Validation_report[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_report loadValidation_reportByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadValidation_reportByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_report loadValidation_reportByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadValidation_reportByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_report loadValidation_reportByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Validation_report[] validation_reports = listValidation_reportByQuery(session, condition, orderBy);
		if (validation_reports != null && validation_reports.length > 0)
			return validation_reports[0];
		else
			return null;
	}
	
	public static Validation_report loadValidation_reportByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Validation_report[] validation_reports = listValidation_reportByQuery(session, condition, orderBy, lockMode);
		if (validation_reports != null && validation_reports.length > 0)
			return validation_reports[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateValidation_reportByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateValidation_reportByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateValidation_reportByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateValidation_reportByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateValidation_reportByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Validation_report as Validation_report");
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
	
	public static java.util.Iterator iterateValidation_reportByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Validation_report as Validation_report");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Validation_report", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_report loadValidation_reportByCriteria(Validation_reportCriteria validation_reportCriteria) {
		Validation_report[] validation_reports = listValidation_reportByCriteria(validation_reportCriteria);
		if(validation_reports == null || validation_reports.length == 0) {
			return null;
		}
		return validation_reports[0];
	}
	
	public static Validation_report[] listValidation_reportByCriteria(Validation_reportCriteria validation_reportCriteria) {
		return validation_reportCriteria.listValidation_report();
	}
	
	public static Validation_report createValidation_report() {
		return new eihdms.Validation_report();
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
	
	@Column(name="validation_report_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_VALIDATION_REPORT_VALIDATION_REPORT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_VALIDATION_REPORT_VALIDATION_REPORT_ID_GENERATOR", strategy="native")	
	private int validation_report_id;
	
	@Column(name="batch_id", nullable=true, length=11)	
	private Integer batch_id;
	
	@Column(name="health_facility_name", nullable=true, length=100)	
	private String health_facility_name;
	
	@Column(name="parish_name", nullable=true, length=100)	
	private String parish_name;
	
	@Column(name="sub_county_name", nullable=true, length=100)	
	private String sub_county_name;
	
	@Column(name="county_name", nullable=true, length=100)	
	private String county_name;
	
	@Column(name="district_name", nullable=true, length=100)	
	private String district_name;
	
	@Column(name="health_facility_id", nullable=true, length=11)	
	private Integer health_facility_id;
	
	@Column(name="parish_id", nullable=true, length=11)	
	private Integer parish_id;
	
	@Column(name="sub_county_id", nullable=true, length=10)	
	private Integer sub_county_id;
	
	@Column(name="county_id", nullable=true, length=11)	
	private Integer county_id;
	
	@Column(name="district_id", nullable=true, length=10)	
	private Integer district_id;
	
	@Column(name="status_v", nullable=true, length=50)	
	private String status_v;
	
	@Column(name="status_v_desc", nullable=true)	
	private String status_v_desc;
	
	@Column(name="status_m", nullable=true, length=50)	
	private String status_m;
	
	@Column(name="status_m_desc", nullable=true)	
	private String status_m_desc;
	
	@Column(name="report_period_month", nullable=true, length=11)	
	private Integer report_period_month;
	
	@Column(name="report_period_week", nullable=true, length=11)	
	private Integer report_period_week;
	
	@Column(name="report_period_year", nullable=true, length=11)	
	private Integer report_period_year;
	
	@Column(name="report_period_quarter", nullable=true, length=11)	
	private Integer report_period_quarter;
	
	@Column(name="report_period_bi_month", nullable=true, length=11)	
	private Integer report_period_bi_month;
	
	@Column(name="report_form_id", nullable=true, length=11)	
	private Integer report_form_id;
	
	@Column(name="report_form_group_id", nullable=true, length=11)	
	private Integer report_form_group_id;
	
	@Column(name="add_date", nullable=true)	
	private java.sql.Timestamp add_date;
	
	@Column(name="add_by", nullable=true, length=10)	
	private Integer add_by;
	
	private void setValidation_report_id(int value) {
		this.validation_report_id = value;
	}
	
	public int getValidation_report_id() {
		return validation_report_id;
	}
	
	public int getORMID() {
		return getValidation_report_id();
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
	
	public void setSub_county_name(String value) {
		this.sub_county_name = value;
	}
	
	public String getSub_county_name() {
		return sub_county_name;
	}
	
	public void setCounty_name(String value) {
		this.county_name = value;
	}
	
	public String getCounty_name() {
		return county_name;
	}
	
	public void setDistrict_name(String value) {
		this.district_name = value;
	}
	
	public String getDistrict_name() {
		return district_name;
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
	
	public void setStatus_v(String value) {
		this.status_v = value;
	}
	
	public String getStatus_v() {
		return status_v;
	}
	
	public void setStatus_v_desc(String value) {
		this.status_v_desc = value;
	}
	
	public String getStatus_v_desc() {
		return status_v_desc;
	}
	
	public void setStatus_m(String value) {
		this.status_m = value;
	}
	
	public String getStatus_m() {
		return status_m;
	}
	
	public void setStatus_m_desc(String value) {
		this.status_m_desc = value;
	}
	
	public String getStatus_m_desc() {
		return status_m_desc;
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
	
	public void setReport_form_group_id(int value) {
		setReport_form_group_id(new Integer(value));
	}
	
	public void setReport_form_group_id(Integer value) {
		this.report_form_group_id = value;
	}
	
	public Integer getReport_form_group_id() {
		return report_form_group_id;
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
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Validation_report object = (Validation_report) obj;
		return (this.getValidation_report_id() == object.getValidation_report_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getValidation_report_id());
	}
	
}

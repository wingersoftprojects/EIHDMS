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
@Table(name="dashboard_surge")
public class Dashboard_surge implements Serializable {
	public Dashboard_surge() {
	}
	
	public static Dashboard_surge loadDashboard_surgeByORMID(int dashboard_surge_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadDashboard_surgeByORMID(session, dashboard_surge_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dashboard_surge getDashboard_surgeByORMID(int dashboard_surge_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getDashboard_surgeByORMID(session, dashboard_surge_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dashboard_surge loadDashboard_surgeByORMID(int dashboard_surge_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadDashboard_surgeByORMID(session, dashboard_surge_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dashboard_surge getDashboard_surgeByORMID(int dashboard_surge_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getDashboard_surgeByORMID(session, dashboard_surge_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dashboard_surge loadDashboard_surgeByORMID(PersistentSession session, int dashboard_surge_id) throws PersistentException {
		try {
			return (Dashboard_surge) session.load(eihdms.Dashboard_surge.class, new Integer(dashboard_surge_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dashboard_surge getDashboard_surgeByORMID(PersistentSession session, int dashboard_surge_id) throws PersistentException {
		try {
			return (Dashboard_surge) session.get(eihdms.Dashboard_surge.class, new Integer(dashboard_surge_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dashboard_surge loadDashboard_surgeByORMID(PersistentSession session, int dashboard_surge_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Dashboard_surge) session.load(eihdms.Dashboard_surge.class, new Integer(dashboard_surge_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dashboard_surge getDashboard_surgeByORMID(PersistentSession session, int dashboard_surge_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Dashboard_surge) session.get(eihdms.Dashboard_surge.class, new Integer(dashboard_surge_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDashboard_surge(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryDashboard_surge(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDashboard_surge(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryDashboard_surge(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dashboard_surge[] listDashboard_surgeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listDashboard_surgeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dashboard_surge[] listDashboard_surgeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listDashboard_surgeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDashboard_surge(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Dashboard_surge as Dashboard_surge");
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
	
	public static List queryDashboard_surge(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Dashboard_surge as Dashboard_surge");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Dashboard_surge", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dashboard_surge[] listDashboard_surgeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryDashboard_surge(session, condition, orderBy);
			return (Dashboard_surge[]) list.toArray(new Dashboard_surge[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dashboard_surge[] listDashboard_surgeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryDashboard_surge(session, condition, orderBy, lockMode);
			return (Dashboard_surge[]) list.toArray(new Dashboard_surge[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dashboard_surge loadDashboard_surgeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadDashboard_surgeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dashboard_surge loadDashboard_surgeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadDashboard_surgeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dashboard_surge loadDashboard_surgeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Dashboard_surge[] dashboard_surges = listDashboard_surgeByQuery(session, condition, orderBy);
		if (dashboard_surges != null && dashboard_surges.length > 0)
			return dashboard_surges[0];
		else
			return null;
	}
	
	public static Dashboard_surge loadDashboard_surgeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Dashboard_surge[] dashboard_surges = listDashboard_surgeByQuery(session, condition, orderBy, lockMode);
		if (dashboard_surges != null && dashboard_surges.length > 0)
			return dashboard_surges[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDashboard_surgeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateDashboard_surgeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDashboard_surgeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateDashboard_surgeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDashboard_surgeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Dashboard_surge as Dashboard_surge");
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
	
	public static java.util.Iterator iterateDashboard_surgeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Dashboard_surge as Dashboard_surge");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Dashboard_surge", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dashboard_surge loadDashboard_surgeByCriteria(Dashboard_surgeCriteria dashboard_surgeCriteria) {
		Dashboard_surge[] dashboard_surges = listDashboard_surgeByCriteria(dashboard_surgeCriteria);
		if(dashboard_surges == null || dashboard_surges.length == 0) {
			return null;
		}
		return dashboard_surges[0];
	}
	
	public static Dashboard_surge[] listDashboard_surgeByCriteria(Dashboard_surgeCriteria dashboard_surgeCriteria) {
		return dashboard_surgeCriteria.listDashboard_surge();
	}
	
	public static Dashboard_surge createDashboard_surge() {
		return new eihdms.Dashboard_surge();
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
	
	@Column(name="dashboard_surge_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_DASHBOARD_SURGE_DASHBOARD_SURGE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_DASHBOARD_SURGE_DASHBOARD_SURGE_ID_GENERATOR", strategy="native")	
	private int dashboard_surge_id;
	
	@Column(name="report_form_id", nullable=true, length=11)	
	private Integer report_form_id;
	
	@Column(name="health_facility_id", nullable=true, length=11)	
	private Integer health_facility_id;
	
	@Column(name="parish_id", nullable=true, length=11)	
	private Integer parish_id;
	
	@Column(name="sub_county_id", nullable=true, length=11)	
	private Integer sub_county_id;
	
	@Column(name="district_id", nullable=true, length=11)	
	private Integer district_id;
	
	@Column(name="report_period_week", nullable=true, length=11)	
	private Integer report_period_week;
	
	@Column(name="report_period_year", nullable=true, length=11)	
	private Integer report_period_year;
	
	@Column(name="report_period_from_date", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date report_period_from_date;
	
	@Column(name="report_period_to_date", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date report_period_to_date;
	
	@Column(name="data_element_id", nullable=true, length=11)	
	private Integer data_element_id;
	
	@Column(name="a", nullable=true, length=11)	
	private Integer a;
	
	@Column(name="b", nullable=true, length=11)	
	private Integer b;
	
	@Column(name="b_prev", nullable=true, length=11)	
	private Integer b_prev;
	
	@Column(name="c", nullable=true, length=11)	
	private Integer c;
	
	@Column(name="d", nullable=true, length=11)	
	private Integer d;
	
	@Column(name="e", nullable=true, length=11)	
	private Integer e;
	
	@Column(name="f", nullable=true, length=11)	
	private Integer f;
	
	@Column(name="g", nullable=true, length=11)	
	private Integer g;
	
	@Column(name="h", nullable=true, length=11)	
	private Integer h;
	
	@Column(name="i", nullable=true, length=11)	
	private Integer i;
	
	@Column(name="j", nullable=true, length=11)	
	private Integer j;
	
	@Column(name="k", nullable=true, length=11)	
	private Integer k;
	
	@Column(name="l", nullable=true, length=11)	
	private Integer l;
	
	@Column(name="perc_test_coverage", nullable=true)	
	private Float perc_test_coverage;
	
	@Column(name="perc_miss_appoint_cur", nullable=true)	
	private Float perc_miss_appoint_cur;
	
	@Column(name="perc_miss_appoint_prev", nullable=true)	
	private Float perc_miss_appoint_prev;
	
	@Column(name="perc_hts_yield", nullable=true)	
	private Float perc_hts_yield;
	
	@Column(name="perc_start_art", nullable=true)	
	private Float perc_start_art;
	
	private void setDashboard_surge_id(int value) {
		this.dashboard_surge_id = value;
	}
	
	public int getDashboard_surge_id() {
		return dashboard_surge_id;
	}
	
	public int getORMID() {
		return getDashboard_surge_id();
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
	
	public void setDistrict_id(int value) {
		setDistrict_id(new Integer(value));
	}
	
	public void setDistrict_id(Integer value) {
		this.district_id = value;
	}
	
	public Integer getDistrict_id() {
		return district_id;
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
	
	public void setData_element_id(int value) {
		setData_element_id(new Integer(value));
	}
	
	public void setData_element_id(Integer value) {
		this.data_element_id = value;
	}
	
	public Integer getData_element_id() {
		return data_element_id;
	}
	
	public void setA(int value) {
		setA(new Integer(value));
	}
	
	public void setA(Integer value) {
		this.a = value;
	}
	
	public Integer getA() {
		return a;
	}
	
	public void setB(int value) {
		setB(new Integer(value));
	}
	
	public void setB(Integer value) {
		this.b = value;
	}
	
	public Integer getB() {
		return b;
	}
	
	public void setB_prev(int value) {
		setB_prev(new Integer(value));
	}
	
	public void setB_prev(Integer value) {
		this.b_prev = value;
	}
	
	public Integer getB_prev() {
		return b_prev;
	}
	
	public void setC(int value) {
		setC(new Integer(value));
	}
	
	public void setC(Integer value) {
		this.c = value;
	}
	
	public Integer getC() {
		return c;
	}
	
	public void setD(int value) {
		setD(new Integer(value));
	}
	
	public void setD(Integer value) {
		this.d = value;
	}
	
	public Integer getD() {
		return d;
	}
	
	public void setE(int value) {
		setE(new Integer(value));
	}
	
	public void setE(Integer value) {
		this.e = value;
	}
	
	public Integer getE() {
		return e;
	}
	
	public void setF(int value) {
		setF(new Integer(value));
	}
	
	public void setF(Integer value) {
		this.f = value;
	}
	
	public Integer getF() {
		return f;
	}
	
	public void setG(int value) {
		setG(new Integer(value));
	}
	
	public void setG(Integer value) {
		this.g = value;
	}
	
	public Integer getG() {
		return g;
	}
	
	public void setH(int value) {
		setH(new Integer(value));
	}
	
	public void setH(Integer value) {
		this.h = value;
	}
	
	public Integer getH() {
		return h;
	}
	
	public void setI(int value) {
		setI(new Integer(value));
	}
	
	public void setI(Integer value) {
		this.i = value;
	}
	
	public Integer getI() {
		return i;
	}
	
	public void setJ(int value) {
		setJ(new Integer(value));
	}
	
	public void setJ(Integer value) {
		this.j = value;
	}
	
	public Integer getJ() {
		return j;
	}
	
	public void setK(int value) {
		setK(new Integer(value));
	}
	
	public void setK(Integer value) {
		this.k = value;
	}
	
	public Integer getK() {
		return k;
	}
	
	public void setL(int value) {
		setL(new Integer(value));
	}
	
	public void setL(Integer value) {
		this.l = value;
	}
	
	public Integer getL() {
		return l;
	}
	
	public void setPerc_test_coverage(float value) {
		setPerc_test_coverage(new Float(value));
	}
	
	public void setPerc_test_coverage(Float value) {
		this.perc_test_coverage = value;
	}
	
	public Float getPerc_test_coverage() {
		return perc_test_coverage;
	}
	
	public void setPerc_miss_appoint_cur(float value) {
		setPerc_miss_appoint_cur(new Float(value));
	}
	
	public void setPerc_miss_appoint_cur(Float value) {
		this.perc_miss_appoint_cur = value;
	}
	
	public Float getPerc_miss_appoint_cur() {
		return perc_miss_appoint_cur;
	}
	
	public void setPerc_miss_appoint_prev(float value) {
		setPerc_miss_appoint_prev(new Float(value));
	}
	
	public void setPerc_miss_appoint_prev(Float value) {
		this.perc_miss_appoint_prev = value;
	}
	
	public Float getPerc_miss_appoint_prev() {
		return perc_miss_appoint_prev;
	}
	
	public void setPerc_hts_yield(float value) {
		setPerc_hts_yield(new Float(value));
	}
	
	public void setPerc_hts_yield(Float value) {
		this.perc_hts_yield = value;
	}
	
	public Float getPerc_hts_yield() {
		return perc_hts_yield;
	}
	
	public void setPerc_start_art(float value) {
		setPerc_start_art(new Float(value));
	}
	
	public void setPerc_start_art(Float value) {
		this.perc_start_art = value;
	}
	
	public Float getPerc_start_art() {
		return perc_start_art;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Dashboard_surge object = (Dashboard_surge) obj;
		return (this.getDashboard_surge_id() == object.getDashboard_surge_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getDashboard_surge_id());
	}
	
}

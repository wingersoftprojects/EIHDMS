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
@Table(name="report_form_short_code")
public class Report_form_short_code implements Serializable {
	public Report_form_short_code() {
	}
	
	public static Report_form_short_code loadReport_form_short_codeByORMID(int report_form_short_code_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_form_short_codeByORMID(session, report_form_short_code_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_short_code getReport_form_short_codeByORMID(int report_form_short_code_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getReport_form_short_codeByORMID(session, report_form_short_code_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_short_code loadReport_form_short_codeByORMID(int report_form_short_code_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_form_short_codeByORMID(session, report_form_short_code_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_short_code getReport_form_short_codeByORMID(int report_form_short_code_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getReport_form_short_codeByORMID(session, report_form_short_code_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_short_code loadReport_form_short_codeByORMID(PersistentSession session, int report_form_short_code_id) throws PersistentException {
		try {
			return (Report_form_short_code) session.load(eihdms.Report_form_short_code.class, new Integer(report_form_short_code_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_short_code getReport_form_short_codeByORMID(PersistentSession session, int report_form_short_code_id) throws PersistentException {
		try {
			return (Report_form_short_code) session.get(eihdms.Report_form_short_code.class, new Integer(report_form_short_code_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_short_code loadReport_form_short_codeByORMID(PersistentSession session, int report_form_short_code_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Report_form_short_code) session.load(eihdms.Report_form_short_code.class, new Integer(report_form_short_code_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_short_code getReport_form_short_codeByORMID(PersistentSession session, int report_form_short_code_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Report_form_short_code) session.get(eihdms.Report_form_short_code.class, new Integer(report_form_short_code_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_form_short_code(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryReport_form_short_code(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_form_short_code(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryReport_form_short_code(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_short_code[] listReport_form_short_codeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listReport_form_short_codeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_short_code[] listReport_form_short_codeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listReport_form_short_codeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_form_short_code(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form_short_code as Report_form_short_code");
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
	
	public static List queryReport_form_short_code(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form_short_code as Report_form_short_code");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Report_form_short_code", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_short_code[] listReport_form_short_codeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryReport_form_short_code(session, condition, orderBy);
			return (Report_form_short_code[]) list.toArray(new Report_form_short_code[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_short_code[] listReport_form_short_codeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryReport_form_short_code(session, condition, orderBy, lockMode);
			return (Report_form_short_code[]) list.toArray(new Report_form_short_code[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_short_code loadReport_form_short_codeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_form_short_codeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_short_code loadReport_form_short_codeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_form_short_codeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_short_code loadReport_form_short_codeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Report_form_short_code[] report_form_short_codes = listReport_form_short_codeByQuery(session, condition, orderBy);
		if (report_form_short_codes != null && report_form_short_codes.length > 0)
			return report_form_short_codes[0];
		else
			return null;
	}
	
	public static Report_form_short_code loadReport_form_short_codeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Report_form_short_code[] report_form_short_codes = listReport_form_short_codeByQuery(session, condition, orderBy, lockMode);
		if (report_form_short_codes != null && report_form_short_codes.length > 0)
			return report_form_short_codes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateReport_form_short_codeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateReport_form_short_codeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReport_form_short_codeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateReport_form_short_codeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReport_form_short_codeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form_short_code as Report_form_short_code");
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
	
	public static java.util.Iterator iterateReport_form_short_codeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form_short_code as Report_form_short_code");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Report_form_short_code", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form_short_code loadReport_form_short_codeByCriteria(Report_form_short_codeCriteria report_form_short_codeCriteria) {
		Report_form_short_code[] report_form_short_codes = listReport_form_short_codeByCriteria(report_form_short_codeCriteria);
		if(report_form_short_codes == null || report_form_short_codes.length == 0) {
			return null;
		}
		return report_form_short_codes[0];
	}
	
	public static Report_form_short_code[] listReport_form_short_codeByCriteria(Report_form_short_codeCriteria report_form_short_codeCriteria) {
		return report_form_short_codeCriteria.listReport_form_short_code();
	}
	
	public static Report_form_short_code createReport_form_short_code() {
		return new eihdms.Report_form_short_code();
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
			if(getReport_form() != null) {
				getReport_form().getReport_form_short_code().remove(this);
			}
			
			eihdms.Data_element_sms_position[] lData_element_sms_positions = (eihdms.Data_element_sms_position[])getData_element_sms_position().toArray(new eihdms.Data_element_sms_position[getData_element_sms_position().size()]);
			for(int i = 0; i < lData_element_sms_positions.length; i++) {
				lData_element_sms_positions[i].setReport_form_short_code(null);
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
				getReport_form().getReport_form_short_code().remove(this);
			}
			
			eihdms.Data_element_sms_position[] lData_element_sms_positions = (eihdms.Data_element_sms_position[])getData_element_sms_position().toArray(new eihdms.Data_element_sms_position[getData_element_sms_position().size()]);
			for(int i = 0; i < lData_element_sms_positions.length; i++) {
				lData_element_sms_positions[i].setReport_form_short_code(null);
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
	
	@Column(name="report_form_short_code_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_REPORT_FORM_SHORT_CODE_REPORT_FORM_SHORT_CODE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_REPORT_FORM_SHORT_CODE_REPORT_FORM_SHORT_CODE_ID_GENERATOR", strategy="native")	
	private int report_form_short_code_id;
	
	@Column(name="start_code", nullable=false, length=50)	
	private String start_code;
	
	@Column(name="number_of_separators", nullable=false, length=2)	
	private Integer number_of_separators;
	
	@Column(name="short_code", nullable=false, length=255)	
	private String short_code;
	
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
	
	@ManyToOne(targetEntity=eihdms.Report_form.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="report_form_id", referencedColumnName="report_form_id") })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Report_form report_form;
	
	@OneToMany(mappedBy="report_form_short_code", targetEntity=eihdms.Data_element_sms_position.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set data_element_sms_position = new java.util.HashSet();
	
	private void setReport_form_short_code_id(int value) {
		this.report_form_short_code_id = value;
	}
	
	public int getReport_form_short_code_id() {
		return report_form_short_code_id;
	}
	
	public int getORMID() {
		return getReport_form_short_code_id();
	}
	
	public void setStart_code(String value) {
		this.start_code = value;
	}
	
	public String getStart_code() {
		return start_code;
	}
	
	public void setNumber_of_separators(int value) {
		setNumber_of_separators(new Integer(value));
	}
	
	public void setNumber_of_separators(Integer value) {
		this.number_of_separators = value;
	}
	
	public Integer getNumber_of_separators() {
		return number_of_separators;
	}
	
	public void setShort_code(String value) {
		this.short_code = value;
	}
	
	public String getShort_code() {
		return short_code;
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
	
	public void setReport_form(eihdms.Report_form value) {
		this.report_form = value;
	}
	
	public eihdms.Report_form getReport_form() {
		return report_form;
	}
	
	public void setData_element_sms_position(java.util.Set value) {
		this.data_element_sms_position = value;
	}
	
	public java.util.Set getData_element_sms_position() {
		return data_element_sms_position;
	}
	
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Report_form_short_code object = (Report_form_short_code) obj;
		return (this.getReport_form_short_code_id() == object.getReport_form_short_code_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getReport_form_short_code_id());
	}
	
}

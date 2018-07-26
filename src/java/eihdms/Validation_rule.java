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
@Table(name="validation_rule")
public class Validation_rule implements Serializable {
	public Validation_rule() {
	}
	
	public static Validation_rule loadValidation_ruleByORMID(int validation_rule_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadValidation_ruleByORMID(session, validation_rule_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_rule getValidation_ruleByORMID(int validation_rule_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getValidation_ruleByORMID(session, validation_rule_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_rule loadValidation_ruleByORMID(int validation_rule_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadValidation_ruleByORMID(session, validation_rule_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_rule getValidation_ruleByORMID(int validation_rule_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getValidation_ruleByORMID(session, validation_rule_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_rule loadValidation_ruleByORMID(PersistentSession session, int validation_rule_id) throws PersistentException {
		try {
			return (Validation_rule) session.load(eihdms.Validation_rule.class, new Integer(validation_rule_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_rule getValidation_ruleByORMID(PersistentSession session, int validation_rule_id) throws PersistentException {
		try {
			return (Validation_rule) session.get(eihdms.Validation_rule.class, new Integer(validation_rule_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_rule loadValidation_ruleByORMID(PersistentSession session, int validation_rule_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Validation_rule) session.load(eihdms.Validation_rule.class, new Integer(validation_rule_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_rule getValidation_ruleByORMID(PersistentSession session, int validation_rule_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Validation_rule) session.get(eihdms.Validation_rule.class, new Integer(validation_rule_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryValidation_rule(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryValidation_rule(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryValidation_rule(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryValidation_rule(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_rule[] listValidation_ruleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listValidation_ruleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_rule[] listValidation_ruleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listValidation_ruleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryValidation_rule(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Validation_rule as Validation_rule");
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
	
	public static List queryValidation_rule(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Validation_rule as Validation_rule");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Validation_rule", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_rule[] listValidation_ruleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryValidation_rule(session, condition, orderBy);
			return (Validation_rule[]) list.toArray(new Validation_rule[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_rule[] listValidation_ruleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryValidation_rule(session, condition, orderBy, lockMode);
			return (Validation_rule[]) list.toArray(new Validation_rule[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_rule loadValidation_ruleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadValidation_ruleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_rule loadValidation_ruleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadValidation_ruleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_rule loadValidation_ruleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Validation_rule[] validation_rules = listValidation_ruleByQuery(session, condition, orderBy);
		if (validation_rules != null && validation_rules.length > 0)
			return validation_rules[0];
		else
			return null;
	}
	
	public static Validation_rule loadValidation_ruleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Validation_rule[] validation_rules = listValidation_ruleByQuery(session, condition, orderBy, lockMode);
		if (validation_rules != null && validation_rules.length > 0)
			return validation_rules[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateValidation_ruleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateValidation_ruleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateValidation_ruleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateValidation_ruleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateValidation_ruleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Validation_rule as Validation_rule");
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
	
	public static java.util.Iterator iterateValidation_ruleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Validation_rule as Validation_rule");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Validation_rule", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Validation_rule loadValidation_ruleByCriteria(Validation_ruleCriteria validation_ruleCriteria) {
		Validation_rule[] validation_rules = listValidation_ruleByCriteria(validation_ruleCriteria);
		if(validation_rules == null || validation_rules.length == 0) {
			return null;
		}
		return validation_rules[0];
	}
	
	public static Validation_rule[] listValidation_ruleByCriteria(Validation_ruleCriteria validation_ruleCriteria) {
		return validation_ruleCriteria.listValidation_rule();
	}
	
	public static Validation_rule createValidation_rule() {
		return new eihdms.Validation_rule();
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
				getReport_form().getValidation_rule().remove(this);
			}
			
			if(getReport_form_group() != null) {
				getReport_form_group().getValidation_rule().remove(this);
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
				getReport_form().getValidation_rule().remove(this);
			}
			
			if(getReport_form_group() != null) {
				getReport_form_group().getValidation_rule().remove(this);
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
	
	@Column(name="validation_rule_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_VALIDATION_RULE_VALIDATION_RULE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_VALIDATION_RULE_VALIDATION_RULE_ID_GENERATOR", strategy="native")	
	private int validation_rule_id;
	
	@ManyToOne(targetEntity=eihdms.Report_form.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="report_form_id", referencedColumnName="report_form_id", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Report_form report_form;
	
	@ManyToOne(targetEntity=eihdms.Report_form_group.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="report_form_group_id", referencedColumnName="report_form_group_id", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Report_form_group report_form_group;
	
	@Column(name="validation_rule_name", nullable=false, length=100)	
	private String validation_rule_name;
	
	@Column(name="validation_rule_formula", nullable=false, length=100)	
	private String validation_rule_formula;
	
	@Column(name="data_elements_involved", nullable=false)	
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
	
	private void setValidation_rule_id(int value) {
		this.validation_rule_id = value;
	}
	
	public int getValidation_rule_id() {
		return validation_rule_id;
	}
	
	public int getORMID() {
		return getValidation_rule_id();
	}
	
	public void setValidation_rule_name(String value) {
		this.validation_rule_name = value;
	}
	
	public String getValidation_rule_name() {
		return validation_rule_name;
	}
	
	public void setValidation_rule_formula(String value) {
		this.validation_rule_formula = value;
	}
	
	public String getValidation_rule_formula() {
		return validation_rule_formula;
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
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Validation_rule object = (Validation_rule) obj;
		return (this.getValidation_rule_id() == object.getValidation_rule_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getValidation_rule_id());
	}
	
}

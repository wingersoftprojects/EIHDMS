/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Wence
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
@Table(name="standard_rule")
public class Standard_rule implements Serializable {
	public Standard_rule() {
	}
	
	public static Standard_rule loadStandard_ruleByORMID(int standard_rule_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadStandard_ruleByORMID(session, standard_rule_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Standard_rule getStandard_ruleByORMID(int standard_rule_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getStandard_ruleByORMID(session, standard_rule_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Standard_rule loadStandard_ruleByORMID(int standard_rule_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadStandard_ruleByORMID(session, standard_rule_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Standard_rule getStandard_ruleByORMID(int standard_rule_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getStandard_ruleByORMID(session, standard_rule_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Standard_rule loadStandard_ruleByORMID(PersistentSession session, int standard_rule_id) throws PersistentException {
		try {
			return (Standard_rule) session.load(eihdms.Standard_rule.class, new Integer(standard_rule_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Standard_rule getStandard_ruleByORMID(PersistentSession session, int standard_rule_id) throws PersistentException {
		try {
			return (Standard_rule) session.get(eihdms.Standard_rule.class, new Integer(standard_rule_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Standard_rule loadStandard_ruleByORMID(PersistentSession session, int standard_rule_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Standard_rule) session.load(eihdms.Standard_rule.class, new Integer(standard_rule_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Standard_rule getStandard_ruleByORMID(PersistentSession session, int standard_rule_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Standard_rule) session.get(eihdms.Standard_rule.class, new Integer(standard_rule_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryStandard_rule(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryStandard_rule(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryStandard_rule(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryStandard_rule(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Standard_rule[] listStandard_ruleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listStandard_ruleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Standard_rule[] listStandard_ruleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listStandard_ruleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryStandard_rule(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Standard_rule as Standard_rule");
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
	
	public static List queryStandard_rule(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Standard_rule as Standard_rule");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Standard_rule", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Standard_rule[] listStandard_ruleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryStandard_rule(session, condition, orderBy);
			return (Standard_rule[]) list.toArray(new Standard_rule[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Standard_rule[] listStandard_ruleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryStandard_rule(session, condition, orderBy, lockMode);
			return (Standard_rule[]) list.toArray(new Standard_rule[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Standard_rule loadStandard_ruleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadStandard_ruleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Standard_rule loadStandard_ruleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadStandard_ruleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Standard_rule loadStandard_ruleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Standard_rule[] standard_rules = listStandard_ruleByQuery(session, condition, orderBy);
		if (standard_rules != null && standard_rules.length > 0)
			return standard_rules[0];
		else
			return null;
	}
	
	public static Standard_rule loadStandard_ruleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Standard_rule[] standard_rules = listStandard_ruleByQuery(session, condition, orderBy, lockMode);
		if (standard_rules != null && standard_rules.length > 0)
			return standard_rules[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateStandard_ruleByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateStandard_ruleByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateStandard_ruleByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateStandard_ruleByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateStandard_ruleByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Standard_rule as Standard_rule");
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
	
	public static java.util.Iterator iterateStandard_ruleByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Standard_rule as Standard_rule");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Standard_rule", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Standard_rule loadStandard_ruleByCriteria(Standard_ruleCriteria standard_ruleCriteria) {
		Standard_rule[] standard_rules = listStandard_ruleByCriteria(standard_ruleCriteria);
		if(standard_rules == null || standard_rules.length == 0) {
			return null;
		}
		return standard_rules[0];
	}
	
	public static Standard_rule[] listStandard_ruleByCriteria(Standard_ruleCriteria standard_ruleCriteria) {
		return standard_ruleCriteria.listStandard_rule();
	}
	
	public static Standard_rule createStandard_rule() {
		return new eihdms.Standard_rule();
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
				getData_element().getStandard_rule().remove(this);
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
				getData_element().getStandard_rule().remove(this);
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
	
	@Column(name="standard_rule_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_STANDARD_RULE_STANDARD_RULE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_STANDARD_RULE_STANDARD_RULE_ID_GENERATOR", strategy="native")	
	private int standard_rule_id;
	
	@Column(name="standard_rule_name", nullable=false, length=100)	
	private String standard_rule_name;
	
	@ManyToOne(targetEntity=eihdms.Data_element.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="data_element_id", referencedColumnName="data_element_id", nullable=false) }, foreignKey=@ForeignKey(name="FKstandard_r569908"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Data_element data_element;
	
	@Column(name="source_value", nullable=true, length=100)	
	private String source_value;
	
	@Column(name="target_value", nullable=true, length=100)	
	private String target_value;
	
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
	
	private void setStandard_rule_id(int value) {
		this.standard_rule_id = value;
	}
	
	public int getStandard_rule_id() {
		return standard_rule_id;
	}
	
	public int getORMID() {
		return getStandard_rule_id();
	}
	
	public void setStandard_rule_name(String value) {
		this.standard_rule_name = value;
	}
	
	public String getStandard_rule_name() {
		return standard_rule_name;
	}
	
	public void setSource_value(String value) {
		this.source_value = value;
	}
	
	public String getSource_value() {
		return source_value;
	}
	
	public void setTarget_value(String value) {
		this.target_value = value;
	}
	
	public String getTarget_value() {
		return target_value;
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
		Standard_rule object = (Standard_rule) obj;
		return (this.getStandard_rule_id() == object.getStandard_rule_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getStandard_rule_id());
	}
	
}

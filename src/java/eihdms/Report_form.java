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
@Table(name="report_form")
public class Report_form implements Serializable {
	public Report_form() {
	}
	
	public static Report_form loadReport_formByORMID(int report_form_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadReport_formByORMID(session, report_form_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form getReport_formByORMID(int report_form_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getReport_formByORMID(session, report_form_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form loadReport_formByORMID(int report_form_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadReport_formByORMID(session, report_form_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form getReport_formByORMID(int report_form_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getReport_formByORMID(session, report_form_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form loadReport_formByORMID(PersistentSession session, int report_form_id) throws PersistentException {
		try {
			return (Report_form) session.load(eihdms.Report_form.class, new Integer(report_form_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form getReport_formByORMID(PersistentSession session, int report_form_id) throws PersistentException {
		try {
			return (Report_form) session.get(eihdms.Report_form.class, new Integer(report_form_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form loadReport_formByORMID(PersistentSession session, int report_form_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Report_form) session.load(eihdms.Report_form.class, new Integer(report_form_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form getReport_formByORMID(PersistentSession session, int report_form_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Report_form) session.get(eihdms.Report_form.class, new Integer(report_form_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_form(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryReport_form(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_form(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryReport_form(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form[] listReport_formByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listReport_formByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form[] listReport_formByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listReport_formByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_form(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form as Report_form");
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
	
	public static List queryReport_form(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form as Report_form");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Report_form", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form[] listReport_formByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryReport_form(session, condition, orderBy);
			return (Report_form[]) list.toArray(new Report_form[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form[] listReport_formByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryReport_form(session, condition, orderBy, lockMode);
			return (Report_form[]) list.toArray(new Report_form[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form loadReport_formByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadReport_formByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form loadReport_formByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadReport_formByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form loadReport_formByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Report_form[] report_forms = listReport_formByQuery(session, condition, orderBy);
		if (report_forms != null && report_forms.length > 0)
			return report_forms[0];
		else
			return null;
	}
	
	public static Report_form loadReport_formByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Report_form[] report_forms = listReport_formByQuery(session, condition, orderBy, lockMode);
		if (report_forms != null && report_forms.length > 0)
			return report_forms[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateReport_formByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateReport_formByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReport_formByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateReport_formByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReport_formByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form as Report_form");
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
	
	public static java.util.Iterator iterateReport_formByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Report_form as Report_form");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Report_form", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form loadReport_formByCriteria(Report_formCriteria report_formCriteria) {
		Report_form[] report_forms = listReport_formByCriteria(report_formCriteria);
		if(report_forms == null || report_forms.length == 0) {
			return null;
		}
		return report_forms[0];
	}
	
	public static Report_form[] listReport_formByCriteria(Report_formCriteria report_formCriteria) {
		return report_formCriteria.listReport_form();
	}
	
	public static Report_form createReport_form() {
		return new eihdms.Report_form();
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
			eihdms.Data_element[] lData_elements = (eihdms.Data_element[])getData_element().toArray(new eihdms.Data_element[getData_element().size()]);
			for(int i = 0; i < lData_elements.length; i++) {
				lData_elements[i].setReport_form(null);
			}
			eihdms.Section[] lSections = (eihdms.Section[])getSection().toArray(new eihdms.Section[getSection().size()]);
			for(int i = 0; i < lSections.length; i++) {
				lSections[i].setReport_form(null);
			}
			eihdms.Group_right[] lGroup_rights = (eihdms.Group_right[])getGroup_right().toArray(new eihdms.Group_right[getGroup_right().size()]);
			for(int i = 0; i < lGroup_rights.length; i++) {
				lGroup_rights[i].setReport_form(null);
			}
			eihdms.User_action[] lUser_actions = (eihdms.User_action[])getUser_action().toArray(new eihdms.User_action[getUser_action().size()]);
			for(int i = 0; i < lUser_actions.length; i++) {
				lUser_actions[i].setForm_template(null);
			}
			eihdms.Report_form_group[] lReport_form_groups = (eihdms.Report_form_group[])getReport_form_group().toArray(new eihdms.Report_form_group[getReport_form_group().size()]);
			for(int i = 0; i < lReport_form_groups.length; i++) {
				lReport_form_groups[i].setReport_form(null);
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
			eihdms.Data_element[] lData_elements = (eihdms.Data_element[])getData_element().toArray(new eihdms.Data_element[getData_element().size()]);
			for(int i = 0; i < lData_elements.length; i++) {
				lData_elements[i].setReport_form(null);
			}
			eihdms.Section[] lSections = (eihdms.Section[])getSection().toArray(new eihdms.Section[getSection().size()]);
			for(int i = 0; i < lSections.length; i++) {
				lSections[i].setReport_form(null);
			}
			eihdms.Group_right[] lGroup_rights = (eihdms.Group_right[])getGroup_right().toArray(new eihdms.Group_right[getGroup_right().size()]);
			for(int i = 0; i < lGroup_rights.length; i++) {
				lGroup_rights[i].setReport_form(null);
			}
			eihdms.User_action[] lUser_actions = (eihdms.User_action[])getUser_action().toArray(new eihdms.User_action[getUser_action().size()]);
			for(int i = 0; i < lUser_actions.length; i++) {
				lUser_actions[i].setForm_template(null);
			}
			eihdms.Report_form_group[] lReport_form_groups = (eihdms.Report_form_group[])getReport_form_group().toArray(new eihdms.Report_form_group[getReport_form_group().size()]);
			for(int i = 0; i < lReport_form_groups.length; i++) {
				lReport_form_groups[i].setReport_form(null);
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
	
	@Column(name="report_form_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_REPORT_FORM_REPORT_FORM_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_REPORT_FORM_REPORT_FORM_ID_GENERATOR", strategy="native")	
	private int report_form_id;
	
	@Column(name="report_form_code", nullable=false, length=100)	
	private String report_form_code;
	
	@Column(name="report_form_name", nullable=false, length=100)	
	private String report_form_name;
	
	@Column(name="report_form_description", nullable=true, length=250)	
	private String report_form_description;
	
	@Column(name="report_form_frequency", nullable=false, length=100)	
	private String report_form_frequency;
	
	@Column(name="lowest_report_form_level", nullable=false, length=100)	
	private String lowest_report_form_level;
	
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
	
	@OneToMany(mappedBy="report_form", targetEntity=eihdms.Data_element.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set data_element = new java.util.HashSet();
	
	@OneToMany(mappedBy="report_form", targetEntity=eihdms.Section.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set section = new java.util.HashSet();
	
	@OneToMany(mappedBy="report_form", targetEntity=eihdms.Group_right.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set group_right = new java.util.HashSet();
	
	@OneToMany(mappedBy="form_template", targetEntity=eihdms.User_action.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set user_action = new java.util.HashSet();
	
	@OneToMany(mappedBy="report_form", targetEntity=eihdms.Report_form_group.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set report_form_group = new java.util.HashSet();
	
	private void setReport_form_id(int value) {
		this.report_form_id = value;
	}
	
	public int getReport_form_id() {
		return report_form_id;
	}
	
	public int getORMID() {
		return getReport_form_id();
	}
	
	public void setReport_form_code(String value) {
		this.report_form_code = value;
	}
	
	public String getReport_form_code() {
		return report_form_code;
	}
	
	public void setReport_form_name(String value) {
		this.report_form_name = value;
	}
	
	public String getReport_form_name() {
		return report_form_name;
	}
	
	public void setReport_form_description(String value) {
		this.report_form_description = value;
	}
	
	public String getReport_form_description() {
		return report_form_description;
	}
	
	public void setReport_form_frequency(String value) {
		this.report_form_frequency = value;
	}
	
	public String getReport_form_frequency() {
		return report_form_frequency;
	}
	
	public void setLowest_report_form_level(String value) {
		this.lowest_report_form_level = value;
	}
	
	public String getLowest_report_form_level() {
		return lowest_report_form_level;
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
	
	public void setData_element(java.util.Set value) {
		this.data_element = value;
	}
	
	public java.util.Set getData_element() {
		return data_element;
	}
	
	
	public void setSection(java.util.Set value) {
		this.section = value;
	}
	
	public java.util.Set getSection() {
		return section;
	}
	
	
	public void setGroup_right(java.util.Set value) {
		this.group_right = value;
	}
	
	public java.util.Set getGroup_right() {
		return group_right;
	}
	
	
	public void setUser_action(java.util.Set value) {
		this.user_action = value;
	}
	
	public java.util.Set getUser_action() {
		return user_action;
	}
	
	
	public void setReport_form_group(java.util.Set value) {
		this.report_form_group = value;
	}
	
	public java.util.Set getReport_form_group() {
		return report_form_group;
	}
	
	
	@Override	
	public int hashCode() {
		int hash = 3;
				return hash;
	}
	
	@Override	
	public boolean equals(Object obj) {
		if (obj == null) {
				            return false;
				        }
				        Report_form object = (Report_form) obj;
				        return (this.getReport_form_id() == object.getReport_form_id());
	}
	
	public String toString() {
		return String.valueOf(getReport_form_id());
	}
	
}

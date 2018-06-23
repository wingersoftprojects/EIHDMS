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
@Table(name="report_form")
public class Report_form implements Serializable {
	public Report_form() {
	}
	
	public static Report_form loadReport_formByORMID(int report_form_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_formByORMID(session, report_form_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form getReport_formByORMID(int report_form_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getReport_formByORMID(session, report_form_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form loadReport_formByORMID(int report_form_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_formByORMID(session, report_form_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form getReport_formByORMID(int report_form_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
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
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryReport_form(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryReport_form(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryReport_form(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form[] listReport_formByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listReport_formByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form[] listReport_formByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
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
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadReport_formByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Report_form loadReport_formByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
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
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateReport_formByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReport_formByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
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
			eihdms.Data_element[] lData_elements = (eihdms.Data_element[])getData_element().toArray(new eihdms.Data_element[getData_element().size()]);
			for(int i = 0; i < lData_elements.length; i++) {
				lData_elements[i].setReport_form(null);
			}
			eihdms.Section[] lSections = (eihdms.Section[])getSection().toArray(new eihdms.Section[getSection().size()]);
			for(int i = 0; i < lSections.length; i++) {
				lSections[i].setReport_form(null);
			}
			eihdms.User_action[] lUser_actions = (eihdms.User_action[])getUser_action().toArray(new eihdms.User_action[getUser_action().size()]);
			for(int i = 0; i < lUser_actions.length; i++) {
				lUser_actions[i].setForm_template(null);
			}
			eihdms.Report_form_group[] lReport_form_groups = (eihdms.Report_form_group[])getReport_form_group().toArray(new eihdms.Report_form_group[getReport_form_group().size()]);
			for(int i = 0; i < lReport_form_groups.length; i++) {
				lReport_form_groups[i].setReport_form(null);
			}
			eihdms.Validation_rule[] lValidation_rules = (eihdms.Validation_rule[])getValidation_rule().toArray(new eihdms.Validation_rule[getValidation_rule().size()]);
			for(int i = 0; i < lValidation_rules.length; i++) {
				lValidation_rules[i].setReport_form(null);
			}
			eihdms.Data_obligation[] lData_obligations = (eihdms.Data_obligation[])getData_obligation().toArray(new eihdms.Data_obligation[getData_obligation().size()]);
			for(int i = 0; i < lData_obligations.length; i++) {
				lData_obligations[i].setReport_form(null);
			}
			eihdms.Kpi[] lKpis = (eihdms.Kpi[])getKpi().toArray(new eihdms.Kpi[getKpi().size()]);
			for(int i = 0; i < lKpis.length; i++) {
				lKpis[i].setReport_form(null);
			}
			eihdms.Interface_data[] lInterface_datas = (eihdms.Interface_data[])getInterface_data().toArray(new eihdms.Interface_data[getInterface_data().size()]);
			for(int i = 0; i < lInterface_datas.length; i++) {
				lInterface_datas[i].setReport_form(null);
			}
			eihdms.Base_data[] lBase_datas = (eihdms.Base_data[])getBase_data().toArray(new eihdms.Base_data[getBase_data().size()]);
			for(int i = 0; i < lBase_datas.length; i++) {
				lBase_datas[i].setReport_form(null);
			}
			eihdms.Report_form_short_code[] lReport_form_short_codes = (eihdms.Report_form_short_code[])getReport_form_short_code().toArray(new eihdms.Report_form_short_code[getReport_form_short_code().size()]);
			for(int i = 0; i < lReport_form_short_codes.length; i++) {
				lReport_form_short_codes[i].setReport_form(null);
			}
			eihdms.Report_form_deadline[] lReport_form_deadlines = (eihdms.Report_form_deadline[])getReport_form_deadline().toArray(new eihdms.Report_form_deadline[getReport_form_deadline().size()]);
			for(int i = 0; i < lReport_form_deadlines.length; i++) {
				lReport_form_deadlines[i].setReport_form(null);
			}
			eihdms.Report_form_entity[] lReport_form_entitys = (eihdms.Report_form_entity[])getReport_form_entity().toArray(new eihdms.Report_form_entity[getReport_form_entity().size()]);
			for(int i = 0; i < lReport_form_entitys.length; i++) {
				lReport_form_entitys[i].setReport_form(null);
			}
			eihdms.Group_right[] lGroup_rights = (eihdms.Group_right[])getGroup_right().toArray(new eihdms.Group_right[getGroup_right().size()]);
			for(int i = 0; i < lGroup_rights.length; i++) {
				lGroup_rights[i].setReport_form(null);
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
			eihdms.User_action[] lUser_actions = (eihdms.User_action[])getUser_action().toArray(new eihdms.User_action[getUser_action().size()]);
			for(int i = 0; i < lUser_actions.length; i++) {
				lUser_actions[i].setForm_template(null);
			}
			eihdms.Report_form_group[] lReport_form_groups = (eihdms.Report_form_group[])getReport_form_group().toArray(new eihdms.Report_form_group[getReport_form_group().size()]);
			for(int i = 0; i < lReport_form_groups.length; i++) {
				lReport_form_groups[i].setReport_form(null);
			}
			eihdms.Validation_rule[] lValidation_rules = (eihdms.Validation_rule[])getValidation_rule().toArray(new eihdms.Validation_rule[getValidation_rule().size()]);
			for(int i = 0; i < lValidation_rules.length; i++) {
				lValidation_rules[i].setReport_form(null);
			}
			eihdms.Data_obligation[] lData_obligations = (eihdms.Data_obligation[])getData_obligation().toArray(new eihdms.Data_obligation[getData_obligation().size()]);
			for(int i = 0; i < lData_obligations.length; i++) {
				lData_obligations[i].setReport_form(null);
			}
			eihdms.Kpi[] lKpis = (eihdms.Kpi[])getKpi().toArray(new eihdms.Kpi[getKpi().size()]);
			for(int i = 0; i < lKpis.length; i++) {
				lKpis[i].setReport_form(null);
			}
			eihdms.Interface_data[] lInterface_datas = (eihdms.Interface_data[])getInterface_data().toArray(new eihdms.Interface_data[getInterface_data().size()]);
			for(int i = 0; i < lInterface_datas.length; i++) {
				lInterface_datas[i].setReport_form(null);
			}
			eihdms.Base_data[] lBase_datas = (eihdms.Base_data[])getBase_data().toArray(new eihdms.Base_data[getBase_data().size()]);
			for(int i = 0; i < lBase_datas.length; i++) {
				lBase_datas[i].setReport_form(null);
			}
			eihdms.Report_form_short_code[] lReport_form_short_codes = (eihdms.Report_form_short_code[])getReport_form_short_code().toArray(new eihdms.Report_form_short_code[getReport_form_short_code().size()]);
			for(int i = 0; i < lReport_form_short_codes.length; i++) {
				lReport_form_short_codes[i].setReport_form(null);
			}
			eihdms.Report_form_deadline[] lReport_form_deadlines = (eihdms.Report_form_deadline[])getReport_form_deadline().toArray(new eihdms.Report_form_deadline[getReport_form_deadline().size()]);
			for(int i = 0; i < lReport_form_deadlines.length; i++) {
				lReport_form_deadlines[i].setReport_form(null);
			}
			eihdms.Report_form_entity[] lReport_form_entitys = (eihdms.Report_form_entity[])getReport_form_entity().toArray(new eihdms.Report_form_entity[getReport_form_entity().size()]);
			for(int i = 0; i < lReport_form_entitys.length; i++) {
				lReport_form_entitys[i].setReport_form(null);
			}
			eihdms.Group_right[] lGroup_rights = (eihdms.Group_right[])getGroup_right().toArray(new eihdms.Group_right[getGroup_right().size()]);
			for(int i = 0; i < lGroup_rights.length; i++) {
				lGroup_rights[i].setReport_form(null);
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
	
	@Column(name="source_system", nullable=true, length=50)	
	private String source_system;
	
	@Column(name="mode_upload", nullable=true, length=1)	
	private Integer mode_upload;
	
	@Column(name="mode_data_entry", nullable=true, length=1)	
	private Integer mode_data_entry;
	
	@OneToMany(mappedBy="report_form", targetEntity=eihdms.Data_element.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set data_element = new java.util.HashSet();
	
	@OneToMany(mappedBy="report_form", targetEntity=eihdms.Section.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set section = new java.util.HashSet();
	
	@OneToMany(mappedBy="form_template", targetEntity=eihdms.User_action.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set user_action = new java.util.HashSet();
	
	@OneToMany(mappedBy="report_form", targetEntity=eihdms.Report_form_group.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set report_form_group = new java.util.HashSet();
	
	@OneToMany(mappedBy="report_form", targetEntity=eihdms.Validation_rule.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set validation_rule = new java.util.HashSet();
	
	@OneToMany(mappedBy="report_form", targetEntity=eihdms.Data_obligation.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set data_obligation = new java.util.HashSet();
	
	@OneToMany(mappedBy="report_form", targetEntity=eihdms.Kpi.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set kpi = new java.util.HashSet();
	
	@OneToMany(mappedBy="report_form", targetEntity=eihdms.Interface_data.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set interface_data = new java.util.HashSet();
	
	@OneToMany(mappedBy="report_form", targetEntity=eihdms.Base_data.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set base_data = new java.util.HashSet();
	
	@OneToMany(mappedBy="report_form", targetEntity=eihdms.Report_form_short_code.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set report_form_short_code = new java.util.HashSet();
	
	@OneToMany(mappedBy="report_form", targetEntity=eihdms.Report_form_deadline.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set report_form_deadline = new java.util.HashSet();
	
	@OneToMany(mappedBy="report_form", targetEntity=eihdms.Report_form_entity.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set report_form_entity = new java.util.HashSet();
	
	@OneToMany(mappedBy="report_form", targetEntity=eihdms.Group_right.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set group_right = new java.util.HashSet();
	
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
	
	public void setSource_system(String value) {
		this.source_system = value;
	}
	
	public String getSource_system() {
		return source_system;
	}
	
	public void setMode_upload(int value) {
		setMode_upload(new Integer(value));
	}
	
	public void setMode_upload(Integer value) {
		this.mode_upload = value;
	}
	
	public Integer getMode_upload() {
		return mode_upload;
	}
	
	public void setMode_data_entry(int value) {
		setMode_data_entry(new Integer(value));
	}
	
	public void setMode_data_entry(Integer value) {
		this.mode_data_entry = value;
	}
	
	public Integer getMode_data_entry() {
		return mode_data_entry;
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
	
	
	public void setValidation_rule(java.util.Set value) {
		this.validation_rule = value;
	}
	
	public java.util.Set getValidation_rule() {
		return validation_rule;
	}
	
	
	public void setData_obligation(java.util.Set value) {
		this.data_obligation = value;
	}
	
	public java.util.Set getData_obligation() {
		return data_obligation;
	}
	
	
	public void setKpi(java.util.Set value) {
		this.kpi = value;
	}
	
	public java.util.Set getKpi() {
		return kpi;
	}
	
	
	public void setInterface_data(java.util.Set value) {
		this.interface_data = value;
	}
	
	public java.util.Set getInterface_data() {
		return interface_data;
	}
	
	
	public void setBase_data(java.util.Set value) {
		this.base_data = value;
	}
	
	public java.util.Set getBase_data() {
		return base_data;
	}
	
	
	public void setReport_form_short_code(java.util.Set value) {
		this.report_form_short_code = value;
	}
	
	public java.util.Set getReport_form_short_code() {
		return report_form_short_code;
	}
	
	
	public void setReport_form_deadline(java.util.Set value) {
		this.report_form_deadline = value;
	}
	
	public java.util.Set getReport_form_deadline() {
		return report_form_deadline;
	}
	
	
	public void setReport_form_entity(java.util.Set value) {
		this.report_form_entity = value;
	}
	
	public java.util.Set getReport_form_entity() {
		return report_form_entity;
	}
	
	
	public void setGroup_right(java.util.Set value) {
		this.group_right = value;
	}
	
	public java.util.Set getGroup_right() {
		return group_right;
	}
	
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Report_form object = (Report_form) obj;
		return (this.getReport_form_id() == object.getReport_form_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getReport_form_id());
	}
	
}

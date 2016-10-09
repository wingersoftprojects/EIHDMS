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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Report_formCriteria extends AbstractORMCriteria {
	public final IntegerExpression report_form_id;
	public final StringExpression report_form_code;
	public final StringExpression report_form_name;
	public final StringExpression report_form_description;
	public final StringExpression report_form_frequency;
	public final StringExpression lowest_report_form_level;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final StringExpression source_system;
	public final IntegerExpression mode_upload;
	public final IntegerExpression mode_data_entry;
	public final CollectionExpression data_element;
	public final CollectionExpression section;
	public final CollectionExpression group_right;
	public final CollectionExpression user_action;
	public final CollectionExpression report_form_group;
	public final CollectionExpression validation_rule;
	public final CollectionExpression data_obligation;
	public final CollectionExpression kpi;
	public final CollectionExpression interface_data;
	public final CollectionExpression base_data;
	
	public Report_formCriteria(Criteria criteria) {
		super(criteria);
		report_form_id = new IntegerExpression("report_form_id", this);
		report_form_code = new StringExpression("report_form_code", this);
		report_form_name = new StringExpression("report_form_name", this);
		report_form_description = new StringExpression("report_form_description", this);
		report_form_frequency = new StringExpression("report_form_frequency", this);
		lowest_report_form_level = new StringExpression("lowest_report_form_level", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		source_system = new StringExpression("source_system", this);
		mode_upload = new IntegerExpression("mode_upload", this);
		mode_data_entry = new IntegerExpression("mode_data_entry", this);
		data_element = new CollectionExpression("data_element", this);
		section = new CollectionExpression("section", this);
		group_right = new CollectionExpression("group_right", this);
		user_action = new CollectionExpression("user_action", this);
		report_form_group = new CollectionExpression("report_form_group", this);
		validation_rule = new CollectionExpression("validation_rule", this);
		data_obligation = new CollectionExpression("data_obligation", this);
		kpi = new CollectionExpression("kpi", this);
		interface_data = new CollectionExpression("interface_data", this);
		base_data = new CollectionExpression("base_data", this);
	}
	
	public Report_formCriteria(PersistentSession session) {
		this(session.createCriteria(Report_form.class));
	}
	
	public Report_formCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public Data_elementCriteria createData_elementCriteria() {
		return new Data_elementCriteria(createCriteria("data_element"));
	}
	
	public SectionCriteria createSectionCriteria() {
		return new SectionCriteria(createCriteria("section"));
	}
	
	public Group_rightCriteria createGroup_rightCriteria() {
		return new Group_rightCriteria(createCriteria("group_right"));
	}
	
	public User_actionCriteria createUser_actionCriteria() {
		return new User_actionCriteria(createCriteria("user_action"));
	}
	
	public Report_form_groupCriteria createReport_form_groupCriteria() {
		return new Report_form_groupCriteria(createCriteria("report_form_group"));
	}
	
	public Validation_ruleCriteria createValidation_ruleCriteria() {
		return new Validation_ruleCriteria(createCriteria("validation_rule"));
	}
	
	public Data_obligationCriteria createData_obligationCriteria() {
		return new Data_obligationCriteria(createCriteria("data_obligation"));
	}
	
	public KpiCriteria createKpiCriteria() {
		return new KpiCriteria(createCriteria("kpi"));
	}
	
	public Interface_dataCriteria createInterface_dataCriteria() {
		return new Interface_dataCriteria(createCriteria("interface_data"));
	}
	
	public Base_dataCriteria createBase_dataCriteria() {
		return new Base_dataCriteria(createCriteria("base_data"));
	}
	
	public Report_form uniqueReport_form() {
		return (Report_form) super.uniqueResult();
	}
	
	public Report_form[] listReport_form() {
		java.util.List list = super.list();
		return (Report_form[]) list.toArray(new Report_form[list.size()]);
	}
}


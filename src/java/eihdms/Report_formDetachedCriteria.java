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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Report_formDetachedCriteria extends AbstractORMDetachedCriteria {
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
	public final IntegerExpression is_patient_level;
	public final CollectionExpression data_element;
	public final CollectionExpression section;
	public final CollectionExpression user_action;
	public final CollectionExpression validation_rule;
	public final CollectionExpression data_obligation;
	public final CollectionExpression kpi;
	public final CollectionExpression interface_data;
	public final CollectionExpression base_data;
	public final CollectionExpression report_form_short_code;
	public final CollectionExpression report_form_deadline;
	public final CollectionExpression report_form_entity;
	public final CollectionExpression group_right;
	public final CollectionExpression report_form_entity_count;
	public final CollectionExpression report_form_group;
	
	public Report_formDetachedCriteria() {
		super(eihdms.Report_form.class, eihdms.Report_formCriteria.class);
		report_form_id = new IntegerExpression("report_form_id", this.getDetachedCriteria());
		report_form_code = new StringExpression("report_form_code", this.getDetachedCriteria());
		report_form_name = new StringExpression("report_form_name", this.getDetachedCriteria());
		report_form_description = new StringExpression("report_form_description", this.getDetachedCriteria());
		report_form_frequency = new StringExpression("report_form_frequency", this.getDetachedCriteria());
		lowest_report_form_level = new StringExpression("lowest_report_form_level", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		source_system = new StringExpression("source_system", this.getDetachedCriteria());
		mode_upload = new IntegerExpression("mode_upload", this.getDetachedCriteria());
		mode_data_entry = new IntegerExpression("mode_data_entry", this.getDetachedCriteria());
		is_patient_level = new IntegerExpression("is_patient_level", this.getDetachedCriteria());
		data_element = new CollectionExpression("data_element", this.getDetachedCriteria());
		section = new CollectionExpression("section", this.getDetachedCriteria());
		user_action = new CollectionExpression("user_action", this.getDetachedCriteria());
		validation_rule = new CollectionExpression("validation_rule", this.getDetachedCriteria());
		data_obligation = new CollectionExpression("data_obligation", this.getDetachedCriteria());
		kpi = new CollectionExpression("kpi", this.getDetachedCriteria());
		interface_data = new CollectionExpression("interface_data", this.getDetachedCriteria());
		base_data = new CollectionExpression("base_data", this.getDetachedCriteria());
		report_form_short_code = new CollectionExpression("report_form_short_code", this.getDetachedCriteria());
		report_form_deadline = new CollectionExpression("report_form_deadline", this.getDetachedCriteria());
		report_form_entity = new CollectionExpression("report_form_entity", this.getDetachedCriteria());
		group_right = new CollectionExpression("group_right", this.getDetachedCriteria());
		report_form_entity_count = new CollectionExpression("report_form_entity_count", this.getDetachedCriteria());
		report_form_group = new CollectionExpression("report_form_group", this.getDetachedCriteria());
	}
	
	public Report_formDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Report_formCriteria.class);
		report_form_id = new IntegerExpression("report_form_id", this.getDetachedCriteria());
		report_form_code = new StringExpression("report_form_code", this.getDetachedCriteria());
		report_form_name = new StringExpression("report_form_name", this.getDetachedCriteria());
		report_form_description = new StringExpression("report_form_description", this.getDetachedCriteria());
		report_form_frequency = new StringExpression("report_form_frequency", this.getDetachedCriteria());
		lowest_report_form_level = new StringExpression("lowest_report_form_level", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		source_system = new StringExpression("source_system", this.getDetachedCriteria());
		mode_upload = new IntegerExpression("mode_upload", this.getDetachedCriteria());
		mode_data_entry = new IntegerExpression("mode_data_entry", this.getDetachedCriteria());
		is_patient_level = new IntegerExpression("is_patient_level", this.getDetachedCriteria());
		data_element = new CollectionExpression("data_element", this.getDetachedCriteria());
		section = new CollectionExpression("section", this.getDetachedCriteria());
		user_action = new CollectionExpression("user_action", this.getDetachedCriteria());
		validation_rule = new CollectionExpression("validation_rule", this.getDetachedCriteria());
		data_obligation = new CollectionExpression("data_obligation", this.getDetachedCriteria());
		kpi = new CollectionExpression("kpi", this.getDetachedCriteria());
		interface_data = new CollectionExpression("interface_data", this.getDetachedCriteria());
		base_data = new CollectionExpression("base_data", this.getDetachedCriteria());
		report_form_short_code = new CollectionExpression("report_form_short_code", this.getDetachedCriteria());
		report_form_deadline = new CollectionExpression("report_form_deadline", this.getDetachedCriteria());
		report_form_entity = new CollectionExpression("report_form_entity", this.getDetachedCriteria());
		group_right = new CollectionExpression("group_right", this.getDetachedCriteria());
		report_form_entity_count = new CollectionExpression("report_form_entity_count", this.getDetachedCriteria());
		report_form_group = new CollectionExpression("report_form_group", this.getDetachedCriteria());
	}
	
	public Data_elementDetachedCriteria createData_elementCriteria() {
		return new Data_elementDetachedCriteria(createCriteria("data_element"));
	}
	
	public SectionDetachedCriteria createSectionCriteria() {
		return new SectionDetachedCriteria(createCriteria("section"));
	}
	
	public User_actionDetachedCriteria createUser_actionCriteria() {
		return new User_actionDetachedCriteria(createCriteria("user_action"));
	}
	
	public Validation_ruleDetachedCriteria createValidation_ruleCriteria() {
		return new Validation_ruleDetachedCriteria(createCriteria("validation_rule"));
	}
	
	public Data_obligationDetachedCriteria createData_obligationCriteria() {
		return new Data_obligationDetachedCriteria(createCriteria("data_obligation"));
	}
	
	public KpiDetachedCriteria createKpiCriteria() {
		return new KpiDetachedCriteria(createCriteria("kpi"));
	}
	
	public Interface_dataDetachedCriteria createInterface_dataCriteria() {
		return new Interface_dataDetachedCriteria(createCriteria("interface_data"));
	}
	
	public Base_dataDetachedCriteria createBase_dataCriteria() {
		return new Base_dataDetachedCriteria(createCriteria("base_data"));
	}
	
	public Report_form_short_codeDetachedCriteria createReport_form_short_codeCriteria() {
		return new Report_form_short_codeDetachedCriteria(createCriteria("report_form_short_code"));
	}
	
	public Report_form_deadlineDetachedCriteria createReport_form_deadlineCriteria() {
		return new Report_form_deadlineDetachedCriteria(createCriteria("report_form_deadline"));
	}
	
	public Report_form_entityDetachedCriteria createReport_form_entityCriteria() {
		return new Report_form_entityDetachedCriteria(createCriteria("report_form_entity"));
	}
	
	public Group_rightDetachedCriteria createGroup_rightCriteria() {
		return new Group_rightDetachedCriteria(createCriteria("group_right"));
	}
	
	public Report_form_entity_countDetachedCriteria createReport_form_entity_countCriteria() {
		return new Report_form_entity_countDetachedCriteria(createCriteria("report_form_entity_count"));
	}
	
	public Report_form_groupDetachedCriteria createReport_form_groupCriteria() {
		return new Report_form_groupDetachedCriteria(createCriteria("report_form_group"));
	}
	
	public Report_form uniqueReport_form(PersistentSession session) {
		return (Report_form) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Report_form[] listReport_form(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Report_form[]) list.toArray(new Report_form[list.size()]);
	}
}


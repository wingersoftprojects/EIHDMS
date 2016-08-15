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
	public final CollectionExpression data_element;
	public final CollectionExpression section;
	public final CollectionExpression group_right;
	public final CollectionExpression user_action;
	public final CollectionExpression report_form_group;
	public final CollectionExpression validation_rule;
	
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
		data_element = new CollectionExpression("data_element", this.getDetachedCriteria());
		section = new CollectionExpression("section", this.getDetachedCriteria());
		group_right = new CollectionExpression("group_right", this.getDetachedCriteria());
		user_action = new CollectionExpression("user_action", this.getDetachedCriteria());
		report_form_group = new CollectionExpression("report_form_group", this.getDetachedCriteria());
		validation_rule = new CollectionExpression("validation_rule", this.getDetachedCriteria());
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
		data_element = new CollectionExpression("data_element", this.getDetachedCriteria());
		section = new CollectionExpression("section", this.getDetachedCriteria());
		group_right = new CollectionExpression("group_right", this.getDetachedCriteria());
		user_action = new CollectionExpression("user_action", this.getDetachedCriteria());
		report_form_group = new CollectionExpression("report_form_group", this.getDetachedCriteria());
		validation_rule = new CollectionExpression("validation_rule", this.getDetachedCriteria());
	}
	
	public Data_elementDetachedCriteria createData_elementCriteria() {
		return new Data_elementDetachedCriteria(createCriteria("data_element"));
	}
	
	public SectionDetachedCriteria createSectionCriteria() {
		return new SectionDetachedCriteria(createCriteria("section"));
	}
	
	public Group_rightDetachedCriteria createGroup_rightCriteria() {
		return new Group_rightDetachedCriteria(createCriteria("group_right"));
	}
	
	public User_actionDetachedCriteria createUser_actionCriteria() {
		return new User_actionDetachedCriteria(createCriteria("user_action"));
	}
	
	public Report_form_groupDetachedCriteria createReport_form_groupCriteria() {
		return new Report_form_groupDetachedCriteria(createCriteria("report_form_group"));
	}
	
	public Validation_ruleDetachedCriteria createValidation_ruleCriteria() {
		return new Validation_ruleDetachedCriteria(createCriteria("validation_rule"));
	}
	
	public Report_form uniqueReport_form(PersistentSession session) {
		return (Report_form) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Report_form[] listReport_form(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Report_form[]) list.toArray(new Report_form[list.size()]);
	}
}


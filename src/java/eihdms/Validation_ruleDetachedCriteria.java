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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Validation_ruleDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression validation_rule_id;
	public final IntegerExpression report_formId;
	public final AssociationExpression report_form;
	public final IntegerExpression report_form_groupId;
	public final AssociationExpression report_form_group;
	public final StringExpression validation_rule_name;
	public final StringExpression validation_rule_formula;
	public final StringExpression data_elements_involved;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Validation_ruleDetachedCriteria() {
		super(eihdms.Validation_rule.class, eihdms.Validation_ruleCriteria.class);
		validation_rule_id = new IntegerExpression("validation_rule_id", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		report_form_groupId = new IntegerExpression("report_form_group.report_form_group_id", this.getDetachedCriteria());
		report_form_group = new AssociationExpression("report_form_group", this.getDetachedCriteria());
		validation_rule_name = new StringExpression("validation_rule_name", this.getDetachedCriteria());
		validation_rule_formula = new StringExpression("validation_rule_formula", this.getDetachedCriteria());
		data_elements_involved = new StringExpression("data_elements_involved", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Validation_ruleDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Validation_ruleCriteria.class);
		validation_rule_id = new IntegerExpression("validation_rule_id", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		report_form_groupId = new IntegerExpression("report_form_group.report_form_group_id", this.getDetachedCriteria());
		report_form_group = new AssociationExpression("report_form_group", this.getDetachedCriteria());
		validation_rule_name = new StringExpression("validation_rule_name", this.getDetachedCriteria());
		validation_rule_formula = new StringExpression("validation_rule_formula", this.getDetachedCriteria());
		data_elements_involved = new StringExpression("data_elements_involved", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Report_formDetachedCriteria createReport_formCriteria() {
		return new Report_formDetachedCriteria(createCriteria("report_form"));
	}
	
	public Report_form_groupDetachedCriteria createReport_form_groupCriteria() {
		return new Report_form_groupDetachedCriteria(createCriteria("report_form_group"));
	}
	
	public Validation_rule uniqueValidation_rule(PersistentSession session) {
		return (Validation_rule) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Validation_rule[] listValidation_rule(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Validation_rule[]) list.toArray(new Validation_rule[list.size()]);
	}
}


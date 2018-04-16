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

public class Report_form_groupDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression report_form_group_id;
	public final StringExpression report_form_group_name;
	public final StringExpression description;
	public final IntegerExpression report_formId;
	public final AssociationExpression report_form;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final IntegerExpression group_order;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression data_element;
	public final CollectionExpression validation_rule;
	
	public Report_form_groupDetachedCriteria() {
		super(eihdms.Report_form_group.class, eihdms.Report_form_groupCriteria.class);
		report_form_group_id = new IntegerExpression("report_form_group_id", this.getDetachedCriteria());
		report_form_group_name = new StringExpression("report_form_group_name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		group_order = new IntegerExpression("group_order", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		data_element = new CollectionExpression("data_element", this.getDetachedCriteria());
		validation_rule = new CollectionExpression("validation_rule", this.getDetachedCriteria());
	}
	
	public Report_form_groupDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Report_form_groupCriteria.class);
		report_form_group_id = new IntegerExpression("report_form_group_id", this.getDetachedCriteria());
		report_form_group_name = new StringExpression("report_form_group_name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		group_order = new IntegerExpression("group_order", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		data_element = new CollectionExpression("data_element", this.getDetachedCriteria());
		validation_rule = new CollectionExpression("validation_rule", this.getDetachedCriteria());
	}
	
	public Report_formDetachedCriteria createReport_formCriteria() {
		return new Report_formDetachedCriteria(createCriteria("report_form"));
	}
	
	public Data_elementDetachedCriteria createData_elementCriteria() {
		return new Data_elementDetachedCriteria(createCriteria("data_element"));
	}
	
	public Validation_ruleDetachedCriteria createValidation_ruleCriteria() {
		return new Validation_ruleDetachedCriteria(createCriteria("validation_rule"));
	}
	
	public Report_form_group uniqueReport_form_group(PersistentSession session) {
		return (Report_form_group) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Report_form_group[] listReport_form_group(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Report_form_group[]) list.toArray(new Report_form_group[list.size()]);
	}
}


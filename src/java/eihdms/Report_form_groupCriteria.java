/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: rlumala
 * License Type: Purchased
 */
package eihdms;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Report_form_groupCriteria extends AbstractORMCriteria {
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
	public final StringExpression def_name;
	public final CollectionExpression data_element;
	public final CollectionExpression validation_rule;
	
	public Report_form_groupCriteria(Criteria criteria) {
		super(criteria);
		report_form_group_id = new IntegerExpression("report_form_group_id", this);
		report_form_group_name = new StringExpression("report_form_group_name", this);
		description = new StringExpression("description", this);
		report_formId = new IntegerExpression("report_form.report_form_id", this);
		report_form = new AssociationExpression("report_form", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		group_order = new IntegerExpression("group_order", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		def_name = new StringExpression("def_name", this);
		data_element = new CollectionExpression("data_element", this);
		validation_rule = new CollectionExpression("validation_rule", this);
	}
	
	public Report_form_groupCriteria(PersistentSession session) {
		this(session.createCriteria(Report_form_group.class));
	}
	
	public Report_form_groupCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Report_formCriteria createReport_formCriteria() {
		return new Report_formCriteria(createCriteria("report_form"));
	}
	
	public Data_elementCriteria createData_elementCriteria() {
		return new Data_elementCriteria(createCriteria("data_element"));
	}
	
	public Validation_ruleCriteria createValidation_ruleCriteria() {
		return new Validation_ruleCriteria(createCriteria("validation_rule"));
	}
	
	public Report_form_group uniqueReport_form_group() {
		return (Report_form_group) super.uniqueResult();
	}
	
	public Report_form_group[] listReport_form_group() {
		java.util.List list = super.list();
		return (Report_form_group[]) list.toArray(new Report_form_group[list.size()]);
	}
}


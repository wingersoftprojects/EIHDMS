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

public class Validation_ruleCriteria extends AbstractORMCriteria {
	public final IntegerExpression validation_rule_id;
	public final IntegerExpression report_formId;
	public final AssociationExpression report_form;
	public final IntegerExpression report_form_groupId;
	public final AssociationExpression report_form_group;
	public final StringExpression validation_rule_name;
	public final StringExpression validation_rule_formula;
	public final StringExpression validation_rule_text;
	public final IntegerExpression aId;
	public final AssociationExpression a;
	public final IntegerExpression bId;
	public final AssociationExpression b;
	public final IntegerExpression cId;
	public final AssociationExpression c;
	public final IntegerExpression dId;
	public final AssociationExpression d;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Validation_ruleCriteria(Criteria criteria) {
		super(criteria);
		validation_rule_id = new IntegerExpression("validation_rule_id", this);
		report_formId = new IntegerExpression("report_form.report_form_id", this);
		report_form = new AssociationExpression("report_form", this);
		report_form_groupId = new IntegerExpression("report_form_group.report_form_group_id", this);
		report_form_group = new AssociationExpression("report_form_group", this);
		validation_rule_name = new StringExpression("validation_rule_name", this);
		validation_rule_formula = new StringExpression("validation_rule_formula", this);
		validation_rule_text = new StringExpression("validation_rule_text", this);
		aId = new IntegerExpression("a.data_element_id", this);
		a = new AssociationExpression("a", this);
		bId = new IntegerExpression("b.data_element_id", this);
		b = new AssociationExpression("b", this);
		cId = new IntegerExpression("c.data_element_id", this);
		c = new AssociationExpression("c", this);
		dId = new IntegerExpression("d.data_element_id", this);
		d = new AssociationExpression("d", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Validation_ruleCriteria(PersistentSession session) {
		this(session.createCriteria(Validation_rule.class));
	}
	
	public Validation_ruleCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public Report_formCriteria createReport_formCriteria() {
		return new Report_formCriteria(createCriteria("report_form"));
	}
	
	public Report_form_groupCriteria createReport_form_groupCriteria() {
		return new Report_form_groupCriteria(createCriteria("report_form_group"));
	}
	
	public Data_elementCriteria createACriteria() {
		return new Data_elementCriteria(createCriteria("a"));
	}
	
	public Data_elementCriteria createBCriteria() {
		return new Data_elementCriteria(createCriteria("b"));
	}
	
	public Data_elementCriteria createCCriteria() {
		return new Data_elementCriteria(createCriteria("c"));
	}
	
	public Data_elementCriteria createDCriteria() {
		return new Data_elementCriteria(createCriteria("d"));
	}
	
	public Validation_rule uniqueValidation_rule() {
		return (Validation_rule) super.uniqueResult();
	}
	
	public Validation_rule[] listValidation_rule() {
		java.util.List list = super.list();
		return (Validation_rule[]) list.toArray(new Validation_rule[list.size()]);
	}
}


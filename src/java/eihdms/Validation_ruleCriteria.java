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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Validation_ruleCriteria extends AbstractORMCriteria {
	public final IntegerExpression validation_rule_id;
	public final IntegerExpression data_elementId;
	public final AssociationExpression data_element;
	public final StringExpression validation_rule_name;
	public final StringExpression validation_rule_formula;
	public final StringExpression validation_rule_text;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Validation_ruleCriteria(Criteria criteria) {
		super(criteria);
		validation_rule_id = new IntegerExpression("validation_rule_id", this);
		data_elementId = new IntegerExpression("data_element.data_element_id", this);
		data_element = new AssociationExpression("data_element", this);
		validation_rule_name = new StringExpression("validation_rule_name", this);
		validation_rule_formula = new StringExpression("validation_rule_formula", this);
		validation_rule_text = new StringExpression("validation_rule_text", this);
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
	
	public Data_elementCriteria createData_elementCriteria() {
		return new Data_elementCriteria(createCriteria("data_element"));
	}
	
	public Validation_rule uniqueValidation_rule() {
		return (Validation_rule) super.uniqueResult();
	}
	
	public Validation_rule[] listValidation_rule() {
		java.util.List list = super.list();
		return (Validation_rule[]) list.toArray(new Validation_rule[list.size()]);
	}
}


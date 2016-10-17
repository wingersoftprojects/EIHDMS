/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: btwesigye
 * License Type: Purchased
 */
package eihdms;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Standard_ruleCriteria extends AbstractORMCriteria {
	public final IntegerExpression standard_rule_id;
	public final StringExpression standard_rule_name;
	public final IntegerExpression data_elementId;
	public final AssociationExpression data_element;
	public final StringExpression source_value;
	public final StringExpression target_value;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Standard_ruleCriteria(Criteria criteria) {
		super(criteria);
		standard_rule_id = new IntegerExpression("standard_rule_id", this);
		standard_rule_name = new StringExpression("standard_rule_name", this);
		data_elementId = new IntegerExpression("data_element.data_element_id", this);
		data_element = new AssociationExpression("data_element", this);
		source_value = new StringExpression("source_value", this);
		target_value = new StringExpression("target_value", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Standard_ruleCriteria(PersistentSession session) {
		this(session.createCriteria(Standard_rule.class));
	}
	
	public Standard_ruleCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public Data_elementCriteria createData_elementCriteria() {
		return new Data_elementCriteria(createCriteria("data_element"));
	}
	
	public Standard_rule uniqueStandard_rule() {
		return (Standard_rule) super.uniqueResult();
	}
	
	public Standard_rule[] listStandard_rule() {
		java.util.List list = super.list();
		return (Standard_rule[]) list.toArray(new Standard_rule[list.size()]);
	}
}


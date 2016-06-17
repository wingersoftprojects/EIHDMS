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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Standard_ruleDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public Standard_ruleDetachedCriteria() {
		super(eihdms.Standard_rule.class, eihdms.Standard_ruleCriteria.class);
		standard_rule_id = new IntegerExpression("standard_rule_id", this.getDetachedCriteria());
		standard_rule_name = new StringExpression("standard_rule_name", this.getDetachedCriteria());
		data_elementId = new IntegerExpression("data_element.data_element_id", this.getDetachedCriteria());
		data_element = new AssociationExpression("data_element", this.getDetachedCriteria());
		source_value = new StringExpression("source_value", this.getDetachedCriteria());
		target_value = new StringExpression("target_value", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Standard_ruleDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Standard_ruleCriteria.class);
		standard_rule_id = new IntegerExpression("standard_rule_id", this.getDetachedCriteria());
		standard_rule_name = new StringExpression("standard_rule_name", this.getDetachedCriteria());
		data_elementId = new IntegerExpression("data_element.data_element_id", this.getDetachedCriteria());
		data_element = new AssociationExpression("data_element", this.getDetachedCriteria());
		source_value = new StringExpression("source_value", this.getDetachedCriteria());
		target_value = new StringExpression("target_value", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Data_elementDetachedCriteria createData_elementCriteria() {
		return new Data_elementDetachedCriteria(createCriteria("data_element"));
	}
	
	public Standard_rule uniqueStandard_rule(PersistentSession session) {
		return (Standard_rule) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Standard_rule[] listStandard_rule(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Standard_rule[]) list.toArray(new Standard_rule[list.size()]);
	}
}


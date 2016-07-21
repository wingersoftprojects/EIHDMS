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

public class Application_configurationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression application_configuration_id;
	public final StringExpression parameter_name;
	public final StringExpression parameter_value;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Application_configurationDetachedCriteria() {
		super(eihdms.Application_configuration.class, eihdms.Application_configurationCriteria.class);
		application_configuration_id = new IntegerExpression("application_configuration_id", this.getDetachedCriteria());
		parameter_name = new StringExpression("parameter_name", this.getDetachedCriteria());
		parameter_value = new StringExpression("parameter_value", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Application_configurationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Application_configurationCriteria.class);
		application_configuration_id = new IntegerExpression("application_configuration_id", this.getDetachedCriteria());
		parameter_name = new StringExpression("parameter_name", this.getDetachedCriteria());
		parameter_value = new StringExpression("parameter_value", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Application_configuration uniqueApplication_configuration(PersistentSession session) {
		return (Application_configuration) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Application_configuration[] listApplication_configuration(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Application_configuration[]) list.toArray(new Application_configuration[list.size()]);
	}
}


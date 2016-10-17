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

public class Application_configurationCriteria extends AbstractORMCriteria {
	public final IntegerExpression application_configuration_id;
	public final StringExpression parameter_name;
	public final StringExpression parameter_value;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Application_configurationCriteria(Criteria criteria) {
		super(criteria);
		application_configuration_id = new IntegerExpression("application_configuration_id", this);
		parameter_name = new StringExpression("parameter_name", this);
		parameter_value = new StringExpression("parameter_value", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Application_configurationCriteria(PersistentSession session) {
		this(session.createCriteria(Application_configuration.class));
	}
	
	public Application_configurationCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public Application_configuration uniqueApplication_configuration() {
		return (Application_configuration) super.uniqueResult();
	}
	
	public Application_configuration[] listApplication_configuration() {
		java.util.List list = super.list();
		return (Application_configuration[]) list.toArray(new Application_configuration[list.size()]);
	}
}


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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Interface_data_smsCriteria extends AbstractORMCriteria {
	public final IntegerExpression interface_data_sms_id;
	public final TimestampExpression add_date;
	public final StringExpression phone;
	public final StringExpression sms;
	public final StringExpression scode;
	public final StringExpression status_code;
	public final StringExpression status_desc;
	public final StringExpression report_form_code;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Interface_data_smsCriteria(Criteria criteria) {
		super(criteria);
		interface_data_sms_id = new IntegerExpression("interface_data_sms_id", this);
		add_date = new TimestampExpression("add_date", this);
		phone = new StringExpression("phone", this);
		sms = new StringExpression("sms", this);
		scode = new StringExpression("scode", this);
		status_code = new StringExpression("status_code", this);
		status_desc = new StringExpression("status_desc", this);
		report_form_code = new StringExpression("report_form_code", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Interface_data_smsCriteria(PersistentSession session) {
		this(session.createCriteria(Interface_data_sms.class));
	}
	
	public Interface_data_smsCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Interface_data_sms uniqueInterface_data_sms() {
		return (Interface_data_sms) super.uniqueResult();
	}
	
	public Interface_data_sms[] listInterface_data_sms() {
		java.util.List list = super.list();
		return (Interface_data_sms[]) list.toArray(new Interface_data_sms[list.size()]);
	}
}


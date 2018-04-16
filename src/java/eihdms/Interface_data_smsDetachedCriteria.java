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

public class Interface_data_smsDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public Interface_data_smsDetachedCriteria() {
		super(eihdms.Interface_data_sms.class, eihdms.Interface_data_smsCriteria.class);
		interface_data_sms_id = new IntegerExpression("interface_data_sms_id", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		phone = new StringExpression("phone", this.getDetachedCriteria());
		sms = new StringExpression("sms", this.getDetachedCriteria());
		scode = new StringExpression("scode", this.getDetachedCriteria());
		status_code = new StringExpression("status_code", this.getDetachedCriteria());
		status_desc = new StringExpression("status_desc", this.getDetachedCriteria());
		report_form_code = new StringExpression("report_form_code", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Interface_data_smsDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Interface_data_smsCriteria.class);
		interface_data_sms_id = new IntegerExpression("interface_data_sms_id", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		phone = new StringExpression("phone", this.getDetachedCriteria());
		sms = new StringExpression("sms", this.getDetachedCriteria());
		scode = new StringExpression("scode", this.getDetachedCriteria());
		status_code = new StringExpression("status_code", this.getDetachedCriteria());
		status_desc = new StringExpression("status_desc", this.getDetachedCriteria());
		report_form_code = new StringExpression("report_form_code", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Interface_data_sms uniqueInterface_data_sms(PersistentSession session) {
		return (Interface_data_sms) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Interface_data_sms[] listInterface_data_sms(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Interface_data_sms[]) list.toArray(new Interface_data_sms[list.size()]);
	}
}


/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Wence
 * License Type: Purchased
 */
package eihdms;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Sms_recipientDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression sms_recipient_id;
	public final IntegerExpression sms_schedule_id;
	public final StringExpression phone;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Sms_recipientDetachedCriteria() {
		super(eihdms.Sms_recipient.class, eihdms.Sms_recipientCriteria.class);
		sms_recipient_id = new IntegerExpression("sms_recipient_id", this.getDetachedCriteria());
		sms_schedule_id = new IntegerExpression("sms_schedule_id", this.getDetachedCriteria());
		phone = new StringExpression("phone", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Sms_recipientDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Sms_recipientCriteria.class);
		sms_recipient_id = new IntegerExpression("sms_recipient_id", this.getDetachedCriteria());
		sms_schedule_id = new IntegerExpression("sms_schedule_id", this.getDetachedCriteria());
		phone = new StringExpression("phone", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Sms_recipient uniqueSms_recipient(PersistentSession session) {
		return (Sms_recipient) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Sms_recipient[] listSms_recipient(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Sms_recipient[]) list.toArray(new Sms_recipient[list.size()]);
	}
}


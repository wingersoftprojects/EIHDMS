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

public class Sms_recipientDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression sms_recipient_id;
	public final IntegerExpression sms_schedule_id;
	public final StringExpression phone;
	
	public Sms_recipientDetachedCriteria() {
		super(eihdms.Sms_recipient.class, eihdms.Sms_recipientCriteria.class);
		sms_recipient_id = new IntegerExpression("sms_recipient_id", this.getDetachedCriteria());
		sms_schedule_id = new IntegerExpression("sms_schedule_id", this.getDetachedCriteria());
		phone = new StringExpression("phone", this.getDetachedCriteria());
	}
	
	public Sms_recipientDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Sms_recipientCriteria.class);
		sms_recipient_id = new IntegerExpression("sms_recipient_id", this.getDetachedCriteria());
		sms_schedule_id = new IntegerExpression("sms_schedule_id", this.getDetachedCriteria());
		phone = new StringExpression("phone", this.getDetachedCriteria());
	}
	
	public Sms_recipient uniqueSms_recipient(PersistentSession session) {
		return (Sms_recipient) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Sms_recipient[] listSms_recipient(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Sms_recipient[]) list.toArray(new Sms_recipient[list.size()]);
	}
}


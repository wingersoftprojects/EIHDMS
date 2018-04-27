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

public class Sent_sms_logDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression sent_sms_log_id;
	public final TimestampExpression sent_date;
	public final StringExpression phone;
	public final StringExpression sms;
	public final StringExpression scode;
	public final StringExpression status_code;
	public final StringExpression status_desc;
	
	public Sent_sms_logDetachedCriteria() {
		super(eihdms.Sent_sms_log.class, eihdms.Sent_sms_logCriteria.class);
		sent_sms_log_id = new IntegerExpression("sent_sms_log_id", this.getDetachedCriteria());
		sent_date = new TimestampExpression("sent_date", this.getDetachedCriteria());
		phone = new StringExpression("phone", this.getDetachedCriteria());
		sms = new StringExpression("sms", this.getDetachedCriteria());
		scode = new StringExpression("scode", this.getDetachedCriteria());
		status_code = new StringExpression("status_code", this.getDetachedCriteria());
		status_desc = new StringExpression("status_desc", this.getDetachedCriteria());
	}
	
	public Sent_sms_logDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Sent_sms_logCriteria.class);
		sent_sms_log_id = new IntegerExpression("sent_sms_log_id", this.getDetachedCriteria());
		sent_date = new TimestampExpression("sent_date", this.getDetachedCriteria());
		phone = new StringExpression("phone", this.getDetachedCriteria());
		sms = new StringExpression("sms", this.getDetachedCriteria());
		scode = new StringExpression("scode", this.getDetachedCriteria());
		status_code = new StringExpression("status_code", this.getDetachedCriteria());
		status_desc = new StringExpression("status_desc", this.getDetachedCriteria());
	}
	
	public Sent_sms_log uniqueSent_sms_log(PersistentSession session) {
		return (Sent_sms_log) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Sent_sms_log[] listSent_sms_log(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Sent_sms_log[]) list.toArray(new Sent_sms_log[list.size()]);
	}
}


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

public class Sent_sms_logCriteria extends AbstractORMCriteria {
	public final IntegerExpression sent_sms_log_id;
	public final TimestampExpression sent_date;
	public final StringExpression phone;
	public final StringExpression sms;
	public final StringExpression scode;
	public final StringExpression status_code;
	public final StringExpression status_desc;
	
	public Sent_sms_logCriteria(Criteria criteria) {
		super(criteria);
		sent_sms_log_id = new IntegerExpression("sent_sms_log_id", this);
		sent_date = new TimestampExpression("sent_date", this);
		phone = new StringExpression("phone", this);
		sms = new StringExpression("sms", this);
		scode = new StringExpression("scode", this);
		status_code = new StringExpression("status_code", this);
		status_desc = new StringExpression("status_desc", this);
	}
	
	public Sent_sms_logCriteria(PersistentSession session) {
		this(session.createCriteria(Sent_sms_log.class));
	}
	
	public Sent_sms_logCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Sent_sms_log uniqueSent_sms_log() {
		return (Sent_sms_log) super.uniqueResult();
	}
	
	public Sent_sms_log[] listSent_sms_log() {
		java.util.List list = super.list();
		return (Sent_sms_log[]) list.toArray(new Sent_sms_log[list.size()]);
	}
}


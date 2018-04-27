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

public class Sms_recipientCriteria extends AbstractORMCriteria {
	public final IntegerExpression sms_recipient_id;
	public final IntegerExpression sms_schedule_id;
	public final StringExpression phone;
	
	public Sms_recipientCriteria(Criteria criteria) {
		super(criteria);
		sms_recipient_id = new IntegerExpression("sms_recipient_id", this);
		sms_schedule_id = new IntegerExpression("sms_schedule_id", this);
		phone = new StringExpression("phone", this);
	}
	
	public Sms_recipientCriteria(PersistentSession session) {
		this(session.createCriteria(Sms_recipient.class));
	}
	
	public Sms_recipientCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Sms_recipient uniqueSms_recipient() {
		return (Sms_recipient) super.uniqueResult();
	}
	
	public Sms_recipient[] listSms_recipient() {
		java.util.List list = super.list();
		return (Sms_recipient[]) list.toArray(new Sms_recipient[list.size()]);
	}
}


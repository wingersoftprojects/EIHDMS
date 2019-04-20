/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: rlumala
 * License Type: Purchased
 */
package eihdms;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Sms_scheduleCriteria extends AbstractORMCriteria {
	public final IntegerExpression sms_schedule_id;
	public final TimestampExpression send_date;
	public final StringExpression sms;
	public final StringExpression status_code;
	public final StringExpression status_desc;
	public final StringExpression schedule_by;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Sms_scheduleCriteria(Criteria criteria) {
		super(criteria);
		sms_schedule_id = new IntegerExpression("sms_schedule_id", this);
		send_date = new TimestampExpression("send_date", this);
		sms = new StringExpression("sms", this);
		status_code = new StringExpression("status_code", this);
		status_desc = new StringExpression("status_desc", this);
		schedule_by = new StringExpression("schedule_by", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Sms_scheduleCriteria(PersistentSession session) {
		this(session.createCriteria(Sms_schedule.class));
	}
	
	public Sms_scheduleCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Sms_schedule uniqueSms_schedule() {
		return (Sms_schedule) super.uniqueResult();
	}
	
	public Sms_schedule[] listSms_schedule() {
		java.util.List list = super.list();
		return (Sms_schedule[]) list.toArray(new Sms_schedule[list.size()]);
	}
}


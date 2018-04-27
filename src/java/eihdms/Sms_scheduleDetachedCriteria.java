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

public class Sms_scheduleDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression sms_schedule_id;
	public final TimestampExpression send_date;
	public final StringExpression sms;
	public final StringExpression status_code;
	public final StringExpression status_desc;
	public final StringExpression schedule_by;
	
	public Sms_scheduleDetachedCriteria() {
		super(eihdms.Sms_schedule.class, eihdms.Sms_scheduleCriteria.class);
		sms_schedule_id = new IntegerExpression("sms_schedule_id", this.getDetachedCriteria());
		send_date = new TimestampExpression("send_date", this.getDetachedCriteria());
		sms = new StringExpression("sms", this.getDetachedCriteria());
		status_code = new StringExpression("status_code", this.getDetachedCriteria());
		status_desc = new StringExpression("status_desc", this.getDetachedCriteria());
		schedule_by = new StringExpression("schedule_by", this.getDetachedCriteria());
	}
	
	public Sms_scheduleDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Sms_scheduleCriteria.class);
		sms_schedule_id = new IntegerExpression("sms_schedule_id", this.getDetachedCriteria());
		send_date = new TimestampExpression("send_date", this.getDetachedCriteria());
		sms = new StringExpression("sms", this.getDetachedCriteria());
		status_code = new StringExpression("status_code", this.getDetachedCriteria());
		status_desc = new StringExpression("status_desc", this.getDetachedCriteria());
		schedule_by = new StringExpression("schedule_by", this.getDetachedCriteria());
	}
	
	public Sms_schedule uniqueSms_schedule(PersistentSession session) {
		return (Sms_schedule) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Sms_schedule[] listSms_schedule(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Sms_schedule[]) list.toArray(new Sms_schedule[list.size()]);
	}
}


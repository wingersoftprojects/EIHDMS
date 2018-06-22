/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: wence.twesigye
 * License Type: Purchased
 */
package eihdms;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Deadline_reminderDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression deadline_reminder_id;
	public final IntegerExpression report_form_deadlineId;
	public final AssociationExpression report_form_deadline;
	public final IntegerExpression hours_before_deadline;
	public final StringExpression subject;
	public final StringExpression message;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Deadline_reminderDetachedCriteria() {
		super(eihdms.Deadline_reminder.class, eihdms.Deadline_reminderCriteria.class);
		deadline_reminder_id = new IntegerExpression("deadline_reminder_id", this.getDetachedCriteria());
		report_form_deadlineId = new IntegerExpression("report_form_deadline.report_form_deadline_id", this.getDetachedCriteria());
		report_form_deadline = new AssociationExpression("report_form_deadline", this.getDetachedCriteria());
		hours_before_deadline = new IntegerExpression("hours_before_deadline", this.getDetachedCriteria());
		subject = new StringExpression("subject", this.getDetachedCriteria());
		message = new StringExpression("message", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Deadline_reminderDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Deadline_reminderCriteria.class);
		deadline_reminder_id = new IntegerExpression("deadline_reminder_id", this.getDetachedCriteria());
		report_form_deadlineId = new IntegerExpression("report_form_deadline.report_form_deadline_id", this.getDetachedCriteria());
		report_form_deadline = new AssociationExpression("report_form_deadline", this.getDetachedCriteria());
		hours_before_deadline = new IntegerExpression("hours_before_deadline", this.getDetachedCriteria());
		subject = new StringExpression("subject", this.getDetachedCriteria());
		message = new StringExpression("message", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Report_form_deadlineDetachedCriteria createReport_form_deadlineCriteria() {
		return new Report_form_deadlineDetachedCriteria(createCriteria("report_form_deadline"));
	}
	
	public Deadline_reminder uniqueDeadline_reminder(PersistentSession session) {
		return (Deadline_reminder) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Deadline_reminder[] listDeadline_reminder(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Deadline_reminder[]) list.toArray(new Deadline_reminder[list.size()]);
	}
}


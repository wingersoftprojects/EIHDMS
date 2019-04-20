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

public class Report_form_deadlineDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression report_form_deadline_id;
	public final IntegerExpression report_formId;
	public final AssociationExpression report_form;
	public final IntegerExpression day_from;
	public final IntegerExpression day_to;
	public final TimeExpression time_from;
	public final TimeExpression time_to;
	public final StringExpression week_value;
	public final StringExpression month_value;
	public final StringExpression quarter_value;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final IntegerExpression deadline_extensionId;
	public final AssociationExpression deadline_extension;
	public final CollectionExpression deadline_reminder;
	
	public Report_form_deadlineDetachedCriteria() {
		super(eihdms.Report_form_deadline.class, eihdms.Report_form_deadlineCriteria.class);
		report_form_deadline_id = new IntegerExpression("report_form_deadline_id", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		day_from = new IntegerExpression("day_from", this.getDetachedCriteria());
		day_to = new IntegerExpression("day_to", this.getDetachedCriteria());
		time_from = new TimeExpression("time_from", this.getDetachedCriteria());
		time_to = new TimeExpression("time_to", this.getDetachedCriteria());
		week_value = new StringExpression("week_value", this.getDetachedCriteria());
		month_value = new StringExpression("month_value", this.getDetachedCriteria());
		quarter_value = new StringExpression("quarter_value", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		deadline_extensionId = new IntegerExpression("deadline_extension.report_form_deadline_id", this.getDetachedCriteria());
		deadline_extension = new AssociationExpression("deadline_extension", this.getDetachedCriteria());
		deadline_reminder = new CollectionExpression("deadline_reminder", this.getDetachedCriteria());
	}
	
	public Report_form_deadlineDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Report_form_deadlineCriteria.class);
		report_form_deadline_id = new IntegerExpression("report_form_deadline_id", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		day_from = new IntegerExpression("day_from", this.getDetachedCriteria());
		day_to = new IntegerExpression("day_to", this.getDetachedCriteria());
		time_from = new TimeExpression("time_from", this.getDetachedCriteria());
		time_to = new TimeExpression("time_to", this.getDetachedCriteria());
		week_value = new StringExpression("week_value", this.getDetachedCriteria());
		month_value = new StringExpression("month_value", this.getDetachedCriteria());
		quarter_value = new StringExpression("quarter_value", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		deadline_extensionId = new IntegerExpression("deadline_extension.report_form_deadline_id", this.getDetachedCriteria());
		deadline_extension = new AssociationExpression("deadline_extension", this.getDetachedCriteria());
		deadline_reminder = new CollectionExpression("deadline_reminder", this.getDetachedCriteria());
	}
	
	public Report_formDetachedCriteria createReport_formCriteria() {
		return new Report_formDetachedCriteria(createCriteria("report_form"));
	}
	
	public Deadline_extensionDetachedCriteria createDeadline_extensionCriteria() {
		return new Deadline_extensionDetachedCriteria(createCriteria("deadline_extension"));
	}
	
	public Deadline_reminderDetachedCriteria createDeadline_reminderCriteria() {
		return new Deadline_reminderDetachedCriteria(createCriteria("deadline_reminder"));
	}
	
	public Report_form_deadline uniqueReport_form_deadline(PersistentSession session) {
		return (Report_form_deadline) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Report_form_deadline[] listReport_form_deadline(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Report_form_deadline[]) list.toArray(new Report_form_deadline[list.size()]);
	}
}


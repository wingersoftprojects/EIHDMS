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

public class Report_form_deadlineCriteria extends AbstractORMCriteria {
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
	
	public Report_form_deadlineCriteria(Criteria criteria) {
		super(criteria);
		report_form_deadline_id = new IntegerExpression("report_form_deadline_id", this);
		report_formId = new IntegerExpression("report_form.report_form_id", this);
		report_form = new AssociationExpression("report_form", this);
		day_from = new IntegerExpression("day_from", this);
		day_to = new IntegerExpression("day_to", this);
		time_from = new TimeExpression("time_from", this);
		time_to = new TimeExpression("time_to", this);
		week_value = new StringExpression("week_value", this);
		month_value = new StringExpression("month_value", this);
		quarter_value = new StringExpression("quarter_value", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		deadline_extensionId = new IntegerExpression("deadline_extension.report_form_deadline_id", this);
		deadline_extension = new AssociationExpression("deadline_extension", this);
		deadline_reminder = new CollectionExpression("deadline_reminder", this);
	}
	
	public Report_form_deadlineCriteria(PersistentSession session) {
		this(session.createCriteria(Report_form_deadline.class));
	}
	
	public Report_form_deadlineCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Report_formCriteria createReport_formCriteria() {
		return new Report_formCriteria(createCriteria("report_form"));
	}
	
	public Deadline_extensionCriteria createDeadline_extensionCriteria() {
		return new Deadline_extensionCriteria(createCriteria("deadline_extension"));
	}
	
	public Deadline_reminderCriteria createDeadline_reminderCriteria() {
		return new Deadline_reminderCriteria(createCriteria("deadline_reminder"));
	}
	
	public Report_form_deadline uniqueReport_form_deadline() {
		return (Report_form_deadline) super.uniqueResult();
	}
	
	public Report_form_deadline[] listReport_form_deadline() {
		java.util.List list = super.list();
		return (Report_form_deadline[]) list.toArray(new Report_form_deadline[list.size()]);
	}
}


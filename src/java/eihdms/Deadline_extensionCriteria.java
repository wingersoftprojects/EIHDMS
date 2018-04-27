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

public class Deadline_extensionCriteria extends AbstractORMCriteria {
	public final IntegerExpression deadline_extension_id;
	public final IntegerExpression report_form_deadlineId;
	public final AssociationExpression report_form_deadline;
	public final TimestampExpression extended_to_date;
	
	public Deadline_extensionCriteria(Criteria criteria) {
		super(criteria);
		deadline_extension_id = new IntegerExpression("deadline_extension_id", this);
		report_form_deadlineId = new IntegerExpression("report_form_deadline.report_form_deadline_id", this);
		report_form_deadline = new AssociationExpression("report_form_deadline", this);
		extended_to_date = new TimestampExpression("extended_to_date", this);
	}
	
	public Deadline_extensionCriteria(PersistentSession session) {
		this(session.createCriteria(Deadline_extension.class));
	}
	
	public Deadline_extensionCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Report_form_deadlineCriteria createReport_form_deadlineCriteria() {
		return new Report_form_deadlineCriteria(createCriteria("report_form_deadline"));
	}
	
	public Deadline_extension uniqueDeadline_extension() {
		return (Deadline_extension) super.uniqueResult();
	}
	
	public Deadline_extension[] listDeadline_extension() {
		java.util.List list = super.list();
		return (Deadline_extension[]) list.toArray(new Deadline_extension[list.size()]);
	}
}


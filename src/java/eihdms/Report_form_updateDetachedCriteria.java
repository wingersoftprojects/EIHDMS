/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: bajuna
 * License Type: Purchased
 */
package eihdms;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Report_form_updateDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression report_form_update_id;
	public final IntegerExpression report_form_id;
	public final TimestampExpression last_edit_date;
	
	public Report_form_updateDetachedCriteria() {
		super(eihdms.Report_form_update.class, eihdms.Report_form_updateCriteria.class);
		report_form_update_id = new IntegerExpression("report_form_update_id", this.getDetachedCriteria());
		report_form_id = new IntegerExpression("report_form_id", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
	}
	
	public Report_form_updateDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Report_form_updateCriteria.class);
		report_form_update_id = new IntegerExpression("report_form_update_id", this.getDetachedCriteria());
		report_form_id = new IntegerExpression("report_form_id", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
	}
	
	public Report_form_update uniqueReport_form_update(PersistentSession session) {
		return (Report_form_update) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Report_form_update[] listReport_form_update(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Report_form_update[]) list.toArray(new Report_form_update[list.size()]);
	}
}


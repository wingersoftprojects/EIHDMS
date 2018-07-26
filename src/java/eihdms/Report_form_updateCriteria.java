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

public class Report_form_updateCriteria extends AbstractORMCriteria {
	public final IntegerExpression report_form_update_id;
	public final IntegerExpression report_form_id;
	public final TimestampExpression last_edit_date;
	
	public Report_form_updateCriteria(Criteria criteria) {
		super(criteria);
		report_form_update_id = new IntegerExpression("report_form_update_id", this);
		report_form_id = new IntegerExpression("report_form_id", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
	}
	
	public Report_form_updateCriteria(PersistentSession session) {
		this(session.createCriteria(Report_form_update.class));
	}
	
	public Report_form_updateCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Report_form_update uniqueReport_form_update() {
		return (Report_form_update) super.uniqueResult();
	}
	
	public Report_form_update[] listReport_form_update() {
		java.util.List list = super.list();
		return (Report_form_update[]) list.toArray(new Report_form_update[list.size()]);
	}
}


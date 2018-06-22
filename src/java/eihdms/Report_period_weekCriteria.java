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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Report_period_weekCriteria extends AbstractORMCriteria {
	public final IntegerExpression report_period_week_id;
	public final IntegerExpression calendar_year;
	public final IntegerExpression week_value;
	public final DateExpression week_from_date;
	public final DateExpression week_to_date;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Report_period_weekCriteria(Criteria criteria) {
		super(criteria);
		report_period_week_id = new IntegerExpression("report_period_week_id", this);
		calendar_year = new IntegerExpression("calendar_year", this);
		week_value = new IntegerExpression("week_value", this);
		week_from_date = new DateExpression("week_from_date", this);
		week_to_date = new DateExpression("week_to_date", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Report_period_weekCriteria(PersistentSession session) {
		this(session.createCriteria(Report_period_week.class));
	}
	
	public Report_period_weekCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Report_period_week uniqueReport_period_week() {
		return (Report_period_week) super.uniqueResult();
	}
	
	public Report_period_week[] listReport_period_week() {
		java.util.List list = super.list();
		return (Report_period_week[]) list.toArray(new Report_period_week[list.size()]);
	}
}


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

public class Report_period_weekDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public Report_period_weekDetachedCriteria() {
		super(eihdms.Report_period_week.class, eihdms.Report_period_weekCriteria.class);
		report_period_week_id = new IntegerExpression("report_period_week_id", this.getDetachedCriteria());
		calendar_year = new IntegerExpression("calendar_year", this.getDetachedCriteria());
		week_value = new IntegerExpression("week_value", this.getDetachedCriteria());
		week_from_date = new DateExpression("week_from_date", this.getDetachedCriteria());
		week_to_date = new DateExpression("week_to_date", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Report_period_weekDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Report_period_weekCriteria.class);
		report_period_week_id = new IntegerExpression("report_period_week_id", this.getDetachedCriteria());
		calendar_year = new IntegerExpression("calendar_year", this.getDetachedCriteria());
		week_value = new IntegerExpression("week_value", this.getDetachedCriteria());
		week_from_date = new DateExpression("week_from_date", this.getDetachedCriteria());
		week_to_date = new DateExpression("week_to_date", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Report_period_week uniqueReport_period_week(PersistentSession session) {
		return (Report_period_week) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Report_period_week[] listReport_period_week(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Report_period_week[]) list.toArray(new Report_period_week[list.size()]);
	}
}


/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: btwesigye
 * License Type: Purchased
 */
package eihdms;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Loaded_data_summaryDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression loaded_data_summary_id;
	public final IntegerExpression report_period_month;
	public final IntegerExpression report_period_week;
	public final IntegerExpression report_period_year;
	public final IntegerExpression report_period_quarter;
	public final IntegerExpression report_period_bi_month;
	public final IntegerExpression report_form_group_id;
	public final IntegerExpression report_form_id;
	public final IntegerExpression batch_id;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	
	public Loaded_data_summaryDetachedCriteria() {
		super(eihdms.Loaded_data_summary.class, eihdms.Loaded_data_summaryCriteria.class);
		loaded_data_summary_id = new IntegerExpression("loaded_data_summary_id", this.getDetachedCriteria());
		report_period_month = new IntegerExpression("report_period_month", this.getDetachedCriteria());
		report_period_week = new IntegerExpression("report_period_week", this.getDetachedCriteria());
		report_period_year = new IntegerExpression("report_period_year", this.getDetachedCriteria());
		report_period_quarter = new IntegerExpression("report_period_quarter", this.getDetachedCriteria());
		report_period_bi_month = new IntegerExpression("report_period_bi_month", this.getDetachedCriteria());
		report_form_group_id = new IntegerExpression("report_form_group_id", this.getDetachedCriteria());
		report_form_id = new IntegerExpression("report_form_id", this.getDetachedCriteria());
		batch_id = new IntegerExpression("batch_id", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
	}
	
	public Loaded_data_summaryDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Loaded_data_summaryCriteria.class);
		loaded_data_summary_id = new IntegerExpression("loaded_data_summary_id", this.getDetachedCriteria());
		report_period_month = new IntegerExpression("report_period_month", this.getDetachedCriteria());
		report_period_week = new IntegerExpression("report_period_week", this.getDetachedCriteria());
		report_period_year = new IntegerExpression("report_period_year", this.getDetachedCriteria());
		report_period_quarter = new IntegerExpression("report_period_quarter", this.getDetachedCriteria());
		report_period_bi_month = new IntegerExpression("report_period_bi_month", this.getDetachedCriteria());
		report_form_group_id = new IntegerExpression("report_form_group_id", this.getDetachedCriteria());
		report_form_id = new IntegerExpression("report_form_id", this.getDetachedCriteria());
		batch_id = new IntegerExpression("batch_id", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
	}
	
	public Loaded_data_summary uniqueLoaded_data_summary(PersistentSession session) {
		return (Loaded_data_summary) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Loaded_data_summary[] listLoaded_data_summary(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Loaded_data_summary[]) list.toArray(new Loaded_data_summary[list.size()]);
	}
}


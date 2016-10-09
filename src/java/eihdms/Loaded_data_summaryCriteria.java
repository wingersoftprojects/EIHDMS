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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Loaded_data_summaryCriteria extends AbstractORMCriteria {
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
	
	public Loaded_data_summaryCriteria(Criteria criteria) {
		super(criteria);
		loaded_data_summary_id = new IntegerExpression("loaded_data_summary_id", this);
		report_period_month = new IntegerExpression("report_period_month", this);
		report_period_week = new IntegerExpression("report_period_week", this);
		report_period_year = new IntegerExpression("report_period_year", this);
		report_period_quarter = new IntegerExpression("report_period_quarter", this);
		report_period_bi_month = new IntegerExpression("report_period_bi_month", this);
		report_form_group_id = new IntegerExpression("report_form_group_id", this);
		report_form_id = new IntegerExpression("report_form_id", this);
		batch_id = new IntegerExpression("batch_id", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
	}
	
	public Loaded_data_summaryCriteria(PersistentSession session) {
		this(session.createCriteria(Loaded_data_summary.class));
	}
	
	public Loaded_data_summaryCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public Loaded_data_summary uniqueLoaded_data_summary() {
		return (Loaded_data_summary) super.uniqueResult();
	}
	
	public Loaded_data_summary[] listLoaded_data_summary() {
		java.util.List list = super.list();
		return (Loaded_data_summary[]) list.toArray(new Loaded_data_summary[list.size()]);
	}
}


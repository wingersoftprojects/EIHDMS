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

public class Validation_reportCriteria extends AbstractORMCriteria {
	public final IntegerExpression validation_report_id;
	public final IntegerExpression batch_id;
	public final StringExpression health_facility_name;
	public final StringExpression parish_name;
	public final StringExpression sub_county_name;
	public final StringExpression county_name;
	public final StringExpression district_name;
	public final IntegerExpression health_facility_id;
	public final IntegerExpression parish_id;
	public final IntegerExpression sub_county_id;
	public final IntegerExpression county_id;
	public final IntegerExpression district_id;
	public final StringExpression status_v;
	public final StringExpression status_v_desc;
	public final StringExpression status_m;
	public final StringExpression status_m_desc;
	public final IntegerExpression report_period_month;
	public final IntegerExpression report_period_week;
	public final IntegerExpression report_period_year;
	public final IntegerExpression report_period_quarter;
	public final IntegerExpression report_period_bi_month;
	public final IntegerExpression report_form_id;
	public final IntegerExpression report_form_group_id;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	
	public Validation_reportCriteria(Criteria criteria) {
		super(criteria);
		validation_report_id = new IntegerExpression("validation_report_id", this);
		batch_id = new IntegerExpression("batch_id", this);
		health_facility_name = new StringExpression("health_facility_name", this);
		parish_name = new StringExpression("parish_name", this);
		sub_county_name = new StringExpression("sub_county_name", this);
		county_name = new StringExpression("county_name", this);
		district_name = new StringExpression("district_name", this);
		health_facility_id = new IntegerExpression("health_facility_id", this);
		parish_id = new IntegerExpression("parish_id", this);
		sub_county_id = new IntegerExpression("sub_county_id", this);
		county_id = new IntegerExpression("county_id", this);
		district_id = new IntegerExpression("district_id", this);
		status_v = new StringExpression("status_v", this);
		status_v_desc = new StringExpression("status_v_desc", this);
		status_m = new StringExpression("status_m", this);
		status_m_desc = new StringExpression("status_m_desc", this);
		report_period_month = new IntegerExpression("report_period_month", this);
		report_period_week = new IntegerExpression("report_period_week", this);
		report_period_year = new IntegerExpression("report_period_year", this);
		report_period_quarter = new IntegerExpression("report_period_quarter", this);
		report_period_bi_month = new IntegerExpression("report_period_bi_month", this);
		report_form_id = new IntegerExpression("report_form_id", this);
		report_form_group_id = new IntegerExpression("report_form_group_id", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
	}
	
	public Validation_reportCriteria(PersistentSession session) {
		this(session.createCriteria(Validation_report.class));
	}
	
	public Validation_reportCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Validation_report uniqueValidation_report() {
		return (Validation_report) super.uniqueResult();
	}
	
	public Validation_report[] listValidation_report() {
		java.util.List list = super.list();
		return (Validation_report[]) list.toArray(new Validation_report[list.size()]);
	}
}


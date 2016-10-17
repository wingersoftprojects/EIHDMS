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

public class Validation_reportDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public Validation_reportDetachedCriteria() {
		super(eihdms.Validation_report.class, eihdms.Validation_reportCriteria.class);
		validation_report_id = new IntegerExpression("validation_report_id", this.getDetachedCriteria());
		batch_id = new IntegerExpression("batch_id", this.getDetachedCriteria());
		health_facility_name = new StringExpression("health_facility_name", this.getDetachedCriteria());
		parish_name = new StringExpression("parish_name", this.getDetachedCriteria());
		sub_county_name = new StringExpression("sub_county_name", this.getDetachedCriteria());
		county_name = new StringExpression("county_name", this.getDetachedCriteria());
		district_name = new StringExpression("district_name", this.getDetachedCriteria());
		health_facility_id = new IntegerExpression("health_facility_id", this.getDetachedCriteria());
		parish_id = new IntegerExpression("parish_id", this.getDetachedCriteria());
		sub_county_id = new IntegerExpression("sub_county_id", this.getDetachedCriteria());
		county_id = new IntegerExpression("county_id", this.getDetachedCriteria());
		district_id = new IntegerExpression("district_id", this.getDetachedCriteria());
		status_v = new StringExpression("status_v", this.getDetachedCriteria());
		status_v_desc = new StringExpression("status_v_desc", this.getDetachedCriteria());
		status_m = new StringExpression("status_m", this.getDetachedCriteria());
		status_m_desc = new StringExpression("status_m_desc", this.getDetachedCriteria());
		report_period_month = new IntegerExpression("report_period_month", this.getDetachedCriteria());
		report_period_week = new IntegerExpression("report_period_week", this.getDetachedCriteria());
		report_period_year = new IntegerExpression("report_period_year", this.getDetachedCriteria());
		report_period_quarter = new IntegerExpression("report_period_quarter", this.getDetachedCriteria());
		report_period_bi_month = new IntegerExpression("report_period_bi_month", this.getDetachedCriteria());
		report_form_id = new IntegerExpression("report_form_id", this.getDetachedCriteria());
		report_form_group_id = new IntegerExpression("report_form_group_id", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
	}
	
	public Validation_reportDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Validation_reportCriteria.class);
		validation_report_id = new IntegerExpression("validation_report_id", this.getDetachedCriteria());
		batch_id = new IntegerExpression("batch_id", this.getDetachedCriteria());
		health_facility_name = new StringExpression("health_facility_name", this.getDetachedCriteria());
		parish_name = new StringExpression("parish_name", this.getDetachedCriteria());
		sub_county_name = new StringExpression("sub_county_name", this.getDetachedCriteria());
		county_name = new StringExpression("county_name", this.getDetachedCriteria());
		district_name = new StringExpression("district_name", this.getDetachedCriteria());
		health_facility_id = new IntegerExpression("health_facility_id", this.getDetachedCriteria());
		parish_id = new IntegerExpression("parish_id", this.getDetachedCriteria());
		sub_county_id = new IntegerExpression("sub_county_id", this.getDetachedCriteria());
		county_id = new IntegerExpression("county_id", this.getDetachedCriteria());
		district_id = new IntegerExpression("district_id", this.getDetachedCriteria());
		status_v = new StringExpression("status_v", this.getDetachedCriteria());
		status_v_desc = new StringExpression("status_v_desc", this.getDetachedCriteria());
		status_m = new StringExpression("status_m", this.getDetachedCriteria());
		status_m_desc = new StringExpression("status_m_desc", this.getDetachedCriteria());
		report_period_month = new IntegerExpression("report_period_month", this.getDetachedCriteria());
		report_period_week = new IntegerExpression("report_period_week", this.getDetachedCriteria());
		report_period_year = new IntegerExpression("report_period_year", this.getDetachedCriteria());
		report_period_quarter = new IntegerExpression("report_period_quarter", this.getDetachedCriteria());
		report_period_bi_month = new IntegerExpression("report_period_bi_month", this.getDetachedCriteria());
		report_form_id = new IntegerExpression("report_form_id", this.getDetachedCriteria());
		report_form_group_id = new IntegerExpression("report_form_group_id", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
	}
	
	public Validation_report uniqueValidation_report(PersistentSession session) {
		return (Validation_report) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Validation_report[] listValidation_report(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Validation_report[]) list.toArray(new Validation_report[list.size()]);
	}
}


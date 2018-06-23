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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Dashboard_surgeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression dashboard_surge_id;
	public final IntegerExpression report_form_id;
	public final IntegerExpression health_facility_id;
	public final IntegerExpression parish_id;
	public final IntegerExpression sub_county_id;
	public final IntegerExpression district_id;
	public final IntegerExpression report_period_week;
	public final IntegerExpression report_period_year;
	public final DateExpression report_period_from_date;
	public final DateExpression report_period_to_date;
	public final IntegerExpression batch_id;
	public final IntegerExpression a;
	public final IntegerExpression b;
	public final IntegerExpression b_prev;
	public final IntegerExpression c;
	public final IntegerExpression d;
	public final IntegerExpression e;
	public final IntegerExpression f;
	public final IntegerExpression g;
	public final IntegerExpression h;
	public final IntegerExpression i;
	public final IntegerExpression j;
	public final IntegerExpression k;
	public final IntegerExpression l;
	public final FloatExpression perc_test_coverage;
	public final FloatExpression perc_miss_appoint_cur;
	public final FloatExpression perc_miss_appoint_prev;
	public final FloatExpression perc_hts_yield;
	public final FloatExpression perc_start_art;
	
	public Dashboard_surgeDetachedCriteria() {
		super(eihdms.Dashboard_surge.class, eihdms.Dashboard_surgeCriteria.class);
		dashboard_surge_id = new IntegerExpression("dashboard_surge_id", this.getDetachedCriteria());
		report_form_id = new IntegerExpression("report_form_id", this.getDetachedCriteria());
		health_facility_id = new IntegerExpression("health_facility_id", this.getDetachedCriteria());
		parish_id = new IntegerExpression("parish_id", this.getDetachedCriteria());
		sub_county_id = new IntegerExpression("sub_county_id", this.getDetachedCriteria());
		district_id = new IntegerExpression("district_id", this.getDetachedCriteria());
		report_period_week = new IntegerExpression("report_period_week", this.getDetachedCriteria());
		report_period_year = new IntegerExpression("report_period_year", this.getDetachedCriteria());
		report_period_from_date = new DateExpression("report_period_from_date", this.getDetachedCriteria());
		report_period_to_date = new DateExpression("report_period_to_date", this.getDetachedCriteria());
		batch_id = new IntegerExpression("batch_id", this.getDetachedCriteria());
		a = new IntegerExpression("a", this.getDetachedCriteria());
		b = new IntegerExpression("b", this.getDetachedCriteria());
		b_prev = new IntegerExpression("b_prev", this.getDetachedCriteria());
		c = new IntegerExpression("c", this.getDetachedCriteria());
		d = new IntegerExpression("d", this.getDetachedCriteria());
		e = new IntegerExpression("e", this.getDetachedCriteria());
		f = new IntegerExpression("f", this.getDetachedCriteria());
		g = new IntegerExpression("g", this.getDetachedCriteria());
		h = new IntegerExpression("h", this.getDetachedCriteria());
		i = new IntegerExpression("i", this.getDetachedCriteria());
		j = new IntegerExpression("j", this.getDetachedCriteria());
		k = new IntegerExpression("k", this.getDetachedCriteria());
		l = new IntegerExpression("l", this.getDetachedCriteria());
		perc_test_coverage = new FloatExpression("perc_test_coverage", this.getDetachedCriteria());
		perc_miss_appoint_cur = new FloatExpression("perc_miss_appoint_cur", this.getDetachedCriteria());
		perc_miss_appoint_prev = new FloatExpression("perc_miss_appoint_prev", this.getDetachedCriteria());
		perc_hts_yield = new FloatExpression("perc_hts_yield", this.getDetachedCriteria());
		perc_start_art = new FloatExpression("perc_start_art", this.getDetachedCriteria());
	}
	
	public Dashboard_surgeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Dashboard_surgeCriteria.class);
		dashboard_surge_id = new IntegerExpression("dashboard_surge_id", this.getDetachedCriteria());
		report_form_id = new IntegerExpression("report_form_id", this.getDetachedCriteria());
		health_facility_id = new IntegerExpression("health_facility_id", this.getDetachedCriteria());
		parish_id = new IntegerExpression("parish_id", this.getDetachedCriteria());
		sub_county_id = new IntegerExpression("sub_county_id", this.getDetachedCriteria());
		district_id = new IntegerExpression("district_id", this.getDetachedCriteria());
		report_period_week = new IntegerExpression("report_period_week", this.getDetachedCriteria());
		report_period_year = new IntegerExpression("report_period_year", this.getDetachedCriteria());
		report_period_from_date = new DateExpression("report_period_from_date", this.getDetachedCriteria());
		report_period_to_date = new DateExpression("report_period_to_date", this.getDetachedCriteria());
		batch_id = new IntegerExpression("batch_id", this.getDetachedCriteria());
		a = new IntegerExpression("a", this.getDetachedCriteria());
		b = new IntegerExpression("b", this.getDetachedCriteria());
		b_prev = new IntegerExpression("b_prev", this.getDetachedCriteria());
		c = new IntegerExpression("c", this.getDetachedCriteria());
		d = new IntegerExpression("d", this.getDetachedCriteria());
		e = new IntegerExpression("e", this.getDetachedCriteria());
		f = new IntegerExpression("f", this.getDetachedCriteria());
		g = new IntegerExpression("g", this.getDetachedCriteria());
		h = new IntegerExpression("h", this.getDetachedCriteria());
		i = new IntegerExpression("i", this.getDetachedCriteria());
		j = new IntegerExpression("j", this.getDetachedCriteria());
		k = new IntegerExpression("k", this.getDetachedCriteria());
		l = new IntegerExpression("l", this.getDetachedCriteria());
		perc_test_coverage = new FloatExpression("perc_test_coverage", this.getDetachedCriteria());
		perc_miss_appoint_cur = new FloatExpression("perc_miss_appoint_cur", this.getDetachedCriteria());
		perc_miss_appoint_prev = new FloatExpression("perc_miss_appoint_prev", this.getDetachedCriteria());
		perc_hts_yield = new FloatExpression("perc_hts_yield", this.getDetachedCriteria());
		perc_start_art = new FloatExpression("perc_start_art", this.getDetachedCriteria());
	}
	
	public Dashboard_surge uniqueDashboard_surge(PersistentSession session) {
		return (Dashboard_surge) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Dashboard_surge[] listDashboard_surge(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Dashboard_surge[]) list.toArray(new Dashboard_surge[list.size()]);
	}
}


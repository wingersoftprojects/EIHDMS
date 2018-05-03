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

public class Dashboard_surgeCriteria extends AbstractORMCriteria {
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
	public final IntegerExpression data_element_id;
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
	
	public Dashboard_surgeCriteria(Criteria criteria) {
		super(criteria);
		dashboard_surge_id = new IntegerExpression("dashboard_surge_id", this);
		report_form_id = new IntegerExpression("report_form_id", this);
		health_facility_id = new IntegerExpression("health_facility_id", this);
		parish_id = new IntegerExpression("parish_id", this);
		sub_county_id = new IntegerExpression("sub_county_id", this);
		district_id = new IntegerExpression("district_id", this);
		report_period_week = new IntegerExpression("report_period_week", this);
		report_period_year = new IntegerExpression("report_period_year", this);
		report_period_from_date = new DateExpression("report_period_from_date", this);
		report_period_to_date = new DateExpression("report_period_to_date", this);
		data_element_id = new IntegerExpression("data_element_id", this);
		a = new IntegerExpression("a", this);
		b = new IntegerExpression("b", this);
		b_prev = new IntegerExpression("b_prev", this);
		c = new IntegerExpression("c", this);
		d = new IntegerExpression("d", this);
		e = new IntegerExpression("e", this);
		f = new IntegerExpression("f", this);
		g = new IntegerExpression("g", this);
		h = new IntegerExpression("h", this);
		i = new IntegerExpression("i", this);
		j = new IntegerExpression("j", this);
		k = new IntegerExpression("k", this);
		l = new IntegerExpression("l", this);
		perc_test_coverage = new FloatExpression("perc_test_coverage", this);
		perc_miss_appoint_cur = new FloatExpression("perc_miss_appoint_cur", this);
		perc_miss_appoint_prev = new FloatExpression("perc_miss_appoint_prev", this);
		perc_hts_yield = new FloatExpression("perc_hts_yield", this);
		perc_start_art = new FloatExpression("perc_start_art", this);
	}
	
	public Dashboard_surgeCriteria(PersistentSession session) {
		this(session.createCriteria(Dashboard_surge.class));
	}
	
	public Dashboard_surgeCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Dashboard_surge uniqueDashboard_surge() {
		return (Dashboard_surge) super.uniqueResult();
	}
	
	public Dashboard_surge[] listDashboard_surge() {
		java.util.List list = super.list();
		return (Dashboard_surge[]) list.toArray(new Dashboard_surge[list.size()]);
	}
}


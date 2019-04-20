/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Wence
 * License Type: Purchased
 */
package eihdms;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Interface_data_tempCriteria extends AbstractORMCriteria {
	public final IntegerExpression interface_data_temp_id;
	public final IntegerExpression batch_id;
	public final IntegerExpression data_element_id;
	public final StringExpression data_element_value;
	public final StringExpression health_facility_name;
	public final StringExpression parish_name;
	public final StringExpression sub_county_name;
	public final StringExpression county_name;
	public final StringExpression district_name;
	public final IntegerExpression report_period_month;
	public final IntegerExpression report_period_week;
	public final IntegerExpression report_period_year;
	public final IntegerExpression report_period_quarter;
	public final DateExpression report_period_from_date;
	public final DateExpression report_period_to_date;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final IntegerExpression health_facility_id;
	public final IntegerExpression parish_id;
	public final IntegerExpression sub_county_id;
	public final IntegerExpression county_id;
	public final IntegerExpression district_id;
	public final IntegerExpression report_period_bi_month;
	public final IntegerExpression report_form_id;
	public final IntegerExpression report_form_group_id;
	
	public Interface_data_tempCriteria(Criteria criteria) {
		super(criteria);
		interface_data_temp_id = new IntegerExpression("interface_data_temp_id", this);
		batch_id = new IntegerExpression("batch_id", this);
		data_element_id = new IntegerExpression("data_element_id", this);
		data_element_value = new StringExpression("data_element_value", this);
		health_facility_name = new StringExpression("health_facility_name", this);
		parish_name = new StringExpression("parish_name", this);
		sub_county_name = new StringExpression("sub_county_name", this);
		county_name = new StringExpression("county_name", this);
		district_name = new StringExpression("district_name", this);
		report_period_month = new IntegerExpression("report_period_month", this);
		report_period_week = new IntegerExpression("report_period_week", this);
		report_period_year = new IntegerExpression("report_period_year", this);
		report_period_quarter = new IntegerExpression("report_period_quarter", this);
		report_period_from_date = new DateExpression("report_period_from_date", this);
		report_period_to_date = new DateExpression("report_period_to_date", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		health_facility_id = new IntegerExpression("health_facility_id", this);
		parish_id = new IntegerExpression("parish_id", this);
		sub_county_id = new IntegerExpression("sub_county_id", this);
		county_id = new IntegerExpression("county_id", this);
		district_id = new IntegerExpression("district_id", this);
		report_period_bi_month = new IntegerExpression("report_period_bi_month", this);
		report_form_id = new IntegerExpression("report_form_id", this);
		report_form_group_id = new IntegerExpression("report_form_group_id", this);
	}
	
	public Interface_data_tempCriteria(PersistentSession session) {
		this(session.createCriteria(Interface_data_temp.class));
	}
	
	public Interface_data_tempCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Interface_data_temp uniqueInterface_data_temp() {
		return (Interface_data_temp) super.uniqueResult();
	}
	
	public Interface_data_temp[] listInterface_data_temp() {
		java.util.List list = super.list();
		return (Interface_data_temp[]) list.toArray(new Interface_data_temp[list.size()]);
	}
}


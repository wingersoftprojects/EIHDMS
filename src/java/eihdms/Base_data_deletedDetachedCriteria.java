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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Base_data_deletedDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression base_data_deleted_id;
	public final IntegerExpression base_data_id;
	public final IntegerExpression batch_id;
	public final IntegerExpression data_element_id;
	public final StringExpression data_element_value;
	public final IntegerExpression health_facility_id;
	public final IntegerExpression parish_id;
	public final IntegerExpression sub_county_id;
	public final IntegerExpression county_id;
	public final IntegerExpression district_id;
	public final IntegerExpression financial_year_id;
	public final IntegerExpression report_period_month;
	public final IntegerExpression report_period_week;
	public final IntegerExpression report_period_year;
	public final IntegerExpression report_period_quarter;
	public final DateExpression report_period_from_date;
	public final DateExpression report_period_to_date;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final IntegerExpression report_period_bi_month;
	public final IntegerExpression report_form_id;
	public final IntegerExpression deleted_by;
	public final TimestampExpression delete_date;
	public final IntegerExpression report_form_group_id;
	
	public Base_data_deletedDetachedCriteria() {
		super(eihdms.Base_data_deleted.class, eihdms.Base_data_deletedCriteria.class);
		base_data_deleted_id = new IntegerExpression("base_data_deleted_id", this.getDetachedCriteria());
		base_data_id = new IntegerExpression("base_data_id", this.getDetachedCriteria());
		batch_id = new IntegerExpression("batch_id", this.getDetachedCriteria());
		data_element_id = new IntegerExpression("data_element_id", this.getDetachedCriteria());
		data_element_value = new StringExpression("data_element_value", this.getDetachedCriteria());
		health_facility_id = new IntegerExpression("health_facility_id", this.getDetachedCriteria());
		parish_id = new IntegerExpression("parish_id", this.getDetachedCriteria());
		sub_county_id = new IntegerExpression("sub_county_id", this.getDetachedCriteria());
		county_id = new IntegerExpression("county_id", this.getDetachedCriteria());
		district_id = new IntegerExpression("district_id", this.getDetachedCriteria());
		financial_year_id = new IntegerExpression("financial_year_id", this.getDetachedCriteria());
		report_period_month = new IntegerExpression("report_period_month", this.getDetachedCriteria());
		report_period_week = new IntegerExpression("report_period_week", this.getDetachedCriteria());
		report_period_year = new IntegerExpression("report_period_year", this.getDetachedCriteria());
		report_period_quarter = new IntegerExpression("report_period_quarter", this.getDetachedCriteria());
		report_period_from_date = new DateExpression("report_period_from_date", this.getDetachedCriteria());
		report_period_to_date = new DateExpression("report_period_to_date", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		report_period_bi_month = new IntegerExpression("report_period_bi_month", this.getDetachedCriteria());
		report_form_id = new IntegerExpression("report_form_id", this.getDetachedCriteria());
		deleted_by = new IntegerExpression("deleted_by", this.getDetachedCriteria());
		delete_date = new TimestampExpression("delete_date", this.getDetachedCriteria());
		report_form_group_id = new IntegerExpression("report_form_group_id", this.getDetachedCriteria());
	}
	
	public Base_data_deletedDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Base_data_deletedCriteria.class);
		base_data_deleted_id = new IntegerExpression("base_data_deleted_id", this.getDetachedCriteria());
		base_data_id = new IntegerExpression("base_data_id", this.getDetachedCriteria());
		batch_id = new IntegerExpression("batch_id", this.getDetachedCriteria());
		data_element_id = new IntegerExpression("data_element_id", this.getDetachedCriteria());
		data_element_value = new StringExpression("data_element_value", this.getDetachedCriteria());
		health_facility_id = new IntegerExpression("health_facility_id", this.getDetachedCriteria());
		parish_id = new IntegerExpression("parish_id", this.getDetachedCriteria());
		sub_county_id = new IntegerExpression("sub_county_id", this.getDetachedCriteria());
		county_id = new IntegerExpression("county_id", this.getDetachedCriteria());
		district_id = new IntegerExpression("district_id", this.getDetachedCriteria());
		financial_year_id = new IntegerExpression("financial_year_id", this.getDetachedCriteria());
		report_period_month = new IntegerExpression("report_period_month", this.getDetachedCriteria());
		report_period_week = new IntegerExpression("report_period_week", this.getDetachedCriteria());
		report_period_year = new IntegerExpression("report_period_year", this.getDetachedCriteria());
		report_period_quarter = new IntegerExpression("report_period_quarter", this.getDetachedCriteria());
		report_period_from_date = new DateExpression("report_period_from_date", this.getDetachedCriteria());
		report_period_to_date = new DateExpression("report_period_to_date", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		report_period_bi_month = new IntegerExpression("report_period_bi_month", this.getDetachedCriteria());
		report_form_id = new IntegerExpression("report_form_id", this.getDetachedCriteria());
		deleted_by = new IntegerExpression("deleted_by", this.getDetachedCriteria());
		delete_date = new TimestampExpression("delete_date", this.getDetachedCriteria());
		report_form_group_id = new IntegerExpression("report_form_group_id", this.getDetachedCriteria());
	}
	
	public Base_data_deleted uniqueBase_data_deleted(PersistentSession session) {
		return (Base_data_deleted) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Base_data_deleted[] listBase_data_deleted(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Base_data_deleted[]) list.toArray(new Base_data_deleted[list.size()]);
	}
}


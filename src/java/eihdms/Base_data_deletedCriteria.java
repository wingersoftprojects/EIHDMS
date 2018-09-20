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

public class Base_data_deletedCriteria extends AbstractORMCriteria {
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
	
	public Base_data_deletedCriteria(Criteria criteria) {
		super(criteria);
		base_data_deleted_id = new IntegerExpression("base_data_deleted_id", this);
		base_data_id = new IntegerExpression("base_data_id", this);
		batch_id = new IntegerExpression("batch_id", this);
		data_element_id = new IntegerExpression("data_element_id", this);
		data_element_value = new StringExpression("data_element_value", this);
		health_facility_id = new IntegerExpression("health_facility_id", this);
		parish_id = new IntegerExpression("parish_id", this);
		sub_county_id = new IntegerExpression("sub_county_id", this);
		county_id = new IntegerExpression("county_id", this);
		district_id = new IntegerExpression("district_id", this);
		financial_year_id = new IntegerExpression("financial_year_id", this);
		report_period_month = new IntegerExpression("report_period_month", this);
		report_period_week = new IntegerExpression("report_period_week", this);
		report_period_year = new IntegerExpression("report_period_year", this);
		report_period_quarter = new IntegerExpression("report_period_quarter", this);
		report_period_from_date = new DateExpression("report_period_from_date", this);
		report_period_to_date = new DateExpression("report_period_to_date", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		report_period_bi_month = new IntegerExpression("report_period_bi_month", this);
		report_form_id = new IntegerExpression("report_form_id", this);
		deleted_by = new IntegerExpression("deleted_by", this);
		delete_date = new TimestampExpression("delete_date", this);
		report_form_group_id = new IntegerExpression("report_form_group_id", this);
	}
	
	public Base_data_deletedCriteria(PersistentSession session) {
		this(session.createCriteria(Base_data_deleted.class));
	}
	
	public Base_data_deletedCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Base_data_deleted uniqueBase_data_deleted() {
		return (Base_data_deleted) super.uniqueResult();
	}
	
	public Base_data_deleted[] listBase_data_deleted() {
		java.util.List list = super.list();
		return (Base_data_deleted[]) list.toArray(new Base_data_deleted[list.size()]);
	}
}


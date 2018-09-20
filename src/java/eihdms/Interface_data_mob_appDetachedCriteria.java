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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Interface_data_mob_appDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression interface_data_mob_app_id;
	public final IntegerExpression batch_mob_app_id;
	public final IntegerExpression data_element_id;
	public final StringExpression data_element_value;
	public final StringExpression health_facility_name;
	public final StringExpression parish_name;
	public final StringExpression sub_county_name;
	public final StringExpression county_name;
	public final StringExpression district_name;
	public final TimestampExpression add_date_mob_app;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final StringExpression status_v;
	public final StringExpression status_v_desc;
	public final StringExpression status_m;
	public final StringExpression status_m_desc;
	public final IntegerExpression health_facility_id;
	public final IntegerExpression parish_id;
	public final IntegerExpression sub_county_id;
	public final IntegerExpression county_id;
	public final IntegerExpression district_id;
	public final IntegerExpression report_form_id;
	public final IntegerExpression report_form_group_id;
	public final StringExpression entry_mode;
	public final StringExpression rec_id;
	
	public Interface_data_mob_appDetachedCriteria() {
		super(eihdms.Interface_data_mob_app.class, eihdms.Interface_data_mob_appCriteria.class);
		interface_data_mob_app_id = new IntegerExpression("interface_data_mob_app_id", this.getDetachedCriteria());
		batch_mob_app_id = new IntegerExpression("batch_mob_app_id", this.getDetachedCriteria());
		data_element_id = new IntegerExpression("data_element_id", this.getDetachedCriteria());
		data_element_value = new StringExpression("data_element_value", this.getDetachedCriteria());
		health_facility_name = new StringExpression("health_facility_name", this.getDetachedCriteria());
		parish_name = new StringExpression("parish_name", this.getDetachedCriteria());
		sub_county_name = new StringExpression("sub_county_name", this.getDetachedCriteria());
		county_name = new StringExpression("county_name", this.getDetachedCriteria());
		district_name = new StringExpression("district_name", this.getDetachedCriteria());
		add_date_mob_app = new TimestampExpression("add_date_mob_app", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		status_v = new StringExpression("status_v", this.getDetachedCriteria());
		status_v_desc = new StringExpression("status_v_desc", this.getDetachedCriteria());
		status_m = new StringExpression("status_m", this.getDetachedCriteria());
		status_m_desc = new StringExpression("status_m_desc", this.getDetachedCriteria());
		health_facility_id = new IntegerExpression("health_facility_id", this.getDetachedCriteria());
		parish_id = new IntegerExpression("parish_id", this.getDetachedCriteria());
		sub_county_id = new IntegerExpression("sub_county_id", this.getDetachedCriteria());
		county_id = new IntegerExpression("county_id", this.getDetachedCriteria());
		district_id = new IntegerExpression("district_id", this.getDetachedCriteria());
		report_form_id = new IntegerExpression("report_form_id", this.getDetachedCriteria());
		report_form_group_id = new IntegerExpression("report_form_group_id", this.getDetachedCriteria());
		entry_mode = new StringExpression("entry_mode", this.getDetachedCriteria());
		rec_id = new StringExpression("rec_id", this.getDetachedCriteria());
	}
	
	public Interface_data_mob_appDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Interface_data_mob_appCriteria.class);
		interface_data_mob_app_id = new IntegerExpression("interface_data_mob_app_id", this.getDetachedCriteria());
		batch_mob_app_id = new IntegerExpression("batch_mob_app_id", this.getDetachedCriteria());
		data_element_id = new IntegerExpression("data_element_id", this.getDetachedCriteria());
		data_element_value = new StringExpression("data_element_value", this.getDetachedCriteria());
		health_facility_name = new StringExpression("health_facility_name", this.getDetachedCriteria());
		parish_name = new StringExpression("parish_name", this.getDetachedCriteria());
		sub_county_name = new StringExpression("sub_county_name", this.getDetachedCriteria());
		county_name = new StringExpression("county_name", this.getDetachedCriteria());
		district_name = new StringExpression("district_name", this.getDetachedCriteria());
		add_date_mob_app = new TimestampExpression("add_date_mob_app", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		status_v = new StringExpression("status_v", this.getDetachedCriteria());
		status_v_desc = new StringExpression("status_v_desc", this.getDetachedCriteria());
		status_m = new StringExpression("status_m", this.getDetachedCriteria());
		status_m_desc = new StringExpression("status_m_desc", this.getDetachedCriteria());
		health_facility_id = new IntegerExpression("health_facility_id", this.getDetachedCriteria());
		parish_id = new IntegerExpression("parish_id", this.getDetachedCriteria());
		sub_county_id = new IntegerExpression("sub_county_id", this.getDetachedCriteria());
		county_id = new IntegerExpression("county_id", this.getDetachedCriteria());
		district_id = new IntegerExpression("district_id", this.getDetachedCriteria());
		report_form_id = new IntegerExpression("report_form_id", this.getDetachedCriteria());
		report_form_group_id = new IntegerExpression("report_form_group_id", this.getDetachedCriteria());
		entry_mode = new StringExpression("entry_mode", this.getDetachedCriteria());
		rec_id = new StringExpression("rec_id", this.getDetachedCriteria());
	}
	
	public Interface_data_mob_app uniqueInterface_data_mob_app(PersistentSession session) {
		return (Interface_data_mob_app) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Interface_data_mob_app[] listInterface_data_mob_app(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Interface_data_mob_app[]) list.toArray(new Interface_data_mob_app[list.size()]);
	}
}


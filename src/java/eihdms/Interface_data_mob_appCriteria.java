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

public class Interface_data_mob_appCriteria extends AbstractORMCriteria {
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
	
	public Interface_data_mob_appCriteria(Criteria criteria) {
		super(criteria);
		interface_data_mob_app_id = new IntegerExpression("interface_data_mob_app_id", this);
		batch_mob_app_id = new IntegerExpression("batch_mob_app_id", this);
		data_element_id = new IntegerExpression("data_element_id", this);
		data_element_value = new StringExpression("data_element_value", this);
		health_facility_name = new StringExpression("health_facility_name", this);
		parish_name = new StringExpression("parish_name", this);
		sub_county_name = new StringExpression("sub_county_name", this);
		county_name = new StringExpression("county_name", this);
		district_name = new StringExpression("district_name", this);
		add_date_mob_app = new TimestampExpression("add_date_mob_app", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		status_v = new StringExpression("status_v", this);
		status_v_desc = new StringExpression("status_v_desc", this);
		status_m = new StringExpression("status_m", this);
		status_m_desc = new StringExpression("status_m_desc", this);
		health_facility_id = new IntegerExpression("health_facility_id", this);
		parish_id = new IntegerExpression("parish_id", this);
		sub_county_id = new IntegerExpression("sub_county_id", this);
		county_id = new IntegerExpression("county_id", this);
		district_id = new IntegerExpression("district_id", this);
		report_form_id = new IntegerExpression("report_form_id", this);
		report_form_group_id = new IntegerExpression("report_form_group_id", this);
		entry_mode = new StringExpression("entry_mode", this);
	}
	
	public Interface_data_mob_appCriteria(PersistentSession session) {
		this(session.createCriteria(Interface_data_mob_app.class));
	}
	
	public Interface_data_mob_appCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Interface_data_mob_app uniqueInterface_data_mob_app() {
		return (Interface_data_mob_app) super.uniqueResult();
	}
	
	public Interface_data_mob_app[] listInterface_data_mob_app() {
		java.util.List list = super.list();
		return (Interface_data_mob_app[]) list.toArray(new Interface_data_mob_app[list.size()]);
	}
}


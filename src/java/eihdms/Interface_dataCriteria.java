/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Kiyingi Simon Peter
 * License Type: Purchased
 */
package eihdms;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Interface_dataCriteria extends AbstractORMCriteria {
	public final IntegerExpression interface_data_id;
	public final IntegerExpression data_elementId;
	public final AssociationExpression data_element;
	public final StringExpression data_element_value;
	public final StringExpression health_facility_name;
	public final StringExpression parish_name;
	public final StringExpression district_name;
	public final DateExpression report_period_from_date;
	public final DateExpression report_period_to_date;
	public final StringExpression report_period_name;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final StringExpression status;
	public final StringExpression status_desc;
	
	public Interface_dataCriteria(Criteria criteria) {
		super(criteria);
		interface_data_id = new IntegerExpression("interface_data_id", this);
		data_elementId = new IntegerExpression("data_element.data_element_id", this);
		data_element = new AssociationExpression("data_element", this);
		data_element_value = new StringExpression("data_element_value", this);
		health_facility_name = new StringExpression("health_facility_name", this);
		parish_name = new StringExpression("parish_name", this);
		district_name = new StringExpression("district_name", this);
		report_period_from_date = new DateExpression("report_period_from_date", this);
		report_period_to_date = new DateExpression("report_period_to_date", this);
		report_period_name = new StringExpression("report_period_name", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		status = new StringExpression("status", this);
		status_desc = new StringExpression("status_desc", this);
	}
	
	public Interface_dataCriteria(PersistentSession session) {
		this(session.createCriteria(Interface_data.class));
	}
	
	public Interface_dataCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public Data_elementCriteria createData_elementCriteria() {
		return new Data_elementCriteria(createCriteria("data_element"));
	}
	
	public Interface_data uniqueInterface_data() {
		return (Interface_data) super.uniqueResult();
	}
	
	public Interface_data[] listInterface_data() {
		java.util.List list = super.list();
		return (Interface_data[]) list.toArray(new Interface_data[list.size()]);
	}
}


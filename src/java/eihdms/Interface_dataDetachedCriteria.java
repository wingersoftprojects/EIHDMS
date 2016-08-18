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

public class Interface_dataDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression interface_data_id;
	public final IntegerExpression batchId;
	public final AssociationExpression batch;
	public final IntegerExpression data_elementId;
	public final AssociationExpression data_element;
	public final StringExpression data_element_value;
	public final StringExpression health_facility_name;
	public final StringExpression parish_name;
	public final StringExpression sub_county_name;
	public final StringExpression district_name;
	public final IntegerExpression financial_yearId;
	public final AssociationExpression financial_year;
	public final IntegerExpression report_period_quarter;
	public final DateExpression report_period_from_date;
	public final DateExpression report_period_to_date;
	public final StringExpression report_period_name;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final StringExpression status_u;
	public final StringExpression status_u_desc;
	public final StringExpression status_v;
	public final StringExpression status_v_desc;
	public final StringExpression status_m;
	public final StringExpression status_m_desc;
	
	public Interface_dataDetachedCriteria() {
		super(eihdms.Interface_data.class, eihdms.Interface_dataCriteria.class);
		interface_data_id = new IntegerExpression("interface_data_id", this.getDetachedCriteria());
		batchId = new IntegerExpression("batch.batch_id", this.getDetachedCriteria());
		batch = new AssociationExpression("batch", this.getDetachedCriteria());
		data_elementId = new IntegerExpression("data_element.data_element_id", this.getDetachedCriteria());
		data_element = new AssociationExpression("data_element", this.getDetachedCriteria());
		data_element_value = new StringExpression("data_element_value", this.getDetachedCriteria());
		health_facility_name = new StringExpression("health_facility_name", this.getDetachedCriteria());
		parish_name = new StringExpression("parish_name", this.getDetachedCriteria());
		sub_county_name = new StringExpression("sub_county_name", this.getDetachedCriteria());
		district_name = new StringExpression("district_name", this.getDetachedCriteria());
		financial_yearId = new IntegerExpression("financial_year.financial_year_id", this.getDetachedCriteria());
		financial_year = new AssociationExpression("financial_year", this.getDetachedCriteria());
		report_period_quarter = new IntegerExpression("report_period_quarter", this.getDetachedCriteria());
		report_period_from_date = new DateExpression("report_period_from_date", this.getDetachedCriteria());
		report_period_to_date = new DateExpression("report_period_to_date", this.getDetachedCriteria());
		report_period_name = new StringExpression("report_period_name", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		status_u = new StringExpression("status_u", this.getDetachedCriteria());
		status_u_desc = new StringExpression("status_u_desc", this.getDetachedCriteria());
		status_v = new StringExpression("status_v", this.getDetachedCriteria());
		status_v_desc = new StringExpression("status_v_desc", this.getDetachedCriteria());
		status_m = new StringExpression("status_m", this.getDetachedCriteria());
		status_m_desc = new StringExpression("status_m_desc", this.getDetachedCriteria());
	}
	
	public Interface_dataDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Interface_dataCriteria.class);
		interface_data_id = new IntegerExpression("interface_data_id", this.getDetachedCriteria());
		batchId = new IntegerExpression("batch.batch_id", this.getDetachedCriteria());
		batch = new AssociationExpression("batch", this.getDetachedCriteria());
		data_elementId = new IntegerExpression("data_element.data_element_id", this.getDetachedCriteria());
		data_element = new AssociationExpression("data_element", this.getDetachedCriteria());
		data_element_value = new StringExpression("data_element_value", this.getDetachedCriteria());
		health_facility_name = new StringExpression("health_facility_name", this.getDetachedCriteria());
		parish_name = new StringExpression("parish_name", this.getDetachedCriteria());
		sub_county_name = new StringExpression("sub_county_name", this.getDetachedCriteria());
		district_name = new StringExpression("district_name", this.getDetachedCriteria());
		financial_yearId = new IntegerExpression("financial_year.financial_year_id", this.getDetachedCriteria());
		financial_year = new AssociationExpression("financial_year", this.getDetachedCriteria());
		report_period_quarter = new IntegerExpression("report_period_quarter", this.getDetachedCriteria());
		report_period_from_date = new DateExpression("report_period_from_date", this.getDetachedCriteria());
		report_period_to_date = new DateExpression("report_period_to_date", this.getDetachedCriteria());
		report_period_name = new StringExpression("report_period_name", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		status_u = new StringExpression("status_u", this.getDetachedCriteria());
		status_u_desc = new StringExpression("status_u_desc", this.getDetachedCriteria());
		status_v = new StringExpression("status_v", this.getDetachedCriteria());
		status_v_desc = new StringExpression("status_v_desc", this.getDetachedCriteria());
		status_m = new StringExpression("status_m", this.getDetachedCriteria());
		status_m_desc = new StringExpression("status_m_desc", this.getDetachedCriteria());
	}
	
	public BatchDetachedCriteria createBatchCriteria() {
		return new BatchDetachedCriteria(createCriteria("batch"));
	}
	
	public Data_elementDetachedCriteria createData_elementCriteria() {
		return new Data_elementDetachedCriteria(createCriteria("data_element"));
	}
	
	public Financial_yearDetachedCriteria createFinancial_yearCriteria() {
		return new Financial_yearDetachedCriteria(createCriteria("financial_year"));
	}
	
	public Interface_data uniqueInterface_data(PersistentSession session) {
		return (Interface_data) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Interface_data[] listInterface_data(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Interface_data[]) list.toArray(new Interface_data[list.size()]);
	}
}


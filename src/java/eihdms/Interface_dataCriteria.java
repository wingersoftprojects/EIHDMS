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

public class Interface_dataCriteria extends AbstractORMCriteria {
	public final IntegerExpression interface_data_id;
	public final IntegerExpression batchId;
	public final AssociationExpression batch;
	public final IntegerExpression data_elementId;
	public final AssociationExpression data_element;
	public final StringExpression data_element_value;
	public final StringExpression health_facility_name;
	public final StringExpression parish_name;
	public final StringExpression sub_county_name;
	public final StringExpression county_name;
	public final StringExpression district_name;
	public final IntegerExpression financial_yearId;
	public final AssociationExpression financial_year;
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
	public final StringExpression status_u;
	public final StringExpression status_u_desc;
	public final StringExpression status_v;
	public final StringExpression status_v_desc;
	public final StringExpression status_m;
	public final StringExpression status_m_desc;
	public final IntegerExpression health_facility_id;
	public final IntegerExpression parish_id;
	public final IntegerExpression sub_county_id;
	public final IntegerExpression county_id;
	public final IntegerExpression district_id;
	public final IntegerExpression report_period_bi_month;
	public final IntegerExpression report_formId;
	public final AssociationExpression report_form;
	public final IntegerExpression report_form_group_id;
	public final StringExpression entry_mode;
	
	public Interface_dataCriteria(Criteria criteria) {
		super(criteria);
		interface_data_id = new IntegerExpression("interface_data_id", this);
		batchId = new IntegerExpression("batch.batch_id", this);
		batch = new AssociationExpression("batch", this);
		data_elementId = new IntegerExpression("data_element.data_element_id", this);
		data_element = new AssociationExpression("data_element", this);
		data_element_value = new StringExpression("data_element_value", this);
		health_facility_name = new StringExpression("health_facility_name", this);
		parish_name = new StringExpression("parish_name", this);
		sub_county_name = new StringExpression("sub_county_name", this);
		county_name = new StringExpression("county_name", this);
		district_name = new StringExpression("district_name", this);
		financial_yearId = new IntegerExpression("financial_year.financial_year_id", this);
		financial_year = new AssociationExpression("financial_year", this);
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
		status_u = new StringExpression("status_u", this);
		status_u_desc = new StringExpression("status_u_desc", this);
		status_v = new StringExpression("status_v", this);
		status_v_desc = new StringExpression("status_v_desc", this);
		status_m = new StringExpression("status_m", this);
		status_m_desc = new StringExpression("status_m_desc", this);
		health_facility_id = new IntegerExpression("health_facility_id", this);
		parish_id = new IntegerExpression("parish_id", this);
		sub_county_id = new IntegerExpression("sub_county_id", this);
		county_id = new IntegerExpression("county_id", this);
		district_id = new IntegerExpression("district_id", this);
		report_period_bi_month = new IntegerExpression("report_period_bi_month", this);
		report_formId = new IntegerExpression("report_form.report_form_id", this);
		report_form = new AssociationExpression("report_form", this);
		report_form_group_id = new IntegerExpression("report_form_group_id", this);
		entry_mode = new StringExpression("entry_mode", this);
	}
	
	public Interface_dataCriteria(PersistentSession session) {
		this(session.createCriteria(Interface_data.class));
	}
	
	public Interface_dataCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public BatchCriteria createBatchCriteria() {
		return new BatchCriteria(createCriteria("batch"));
	}
	
	public Data_elementCriteria createData_elementCriteria() {
		return new Data_elementCriteria(createCriteria("data_element"));
	}
	
	public Financial_yearCriteria createFinancial_yearCriteria() {
		return new Financial_yearCriteria(createCriteria("financial_year"));
	}
	
	public Report_formCriteria createReport_formCriteria() {
		return new Report_formCriteria(createCriteria("report_form"));
	}
	
	public Interface_data uniqueInterface_data() {
		return (Interface_data) super.uniqueResult();
	}
	
	public Interface_data[] listInterface_data() {
		java.util.List list = super.list();
		return (Interface_data[]) list.toArray(new Interface_data[list.size()]);
	}
}


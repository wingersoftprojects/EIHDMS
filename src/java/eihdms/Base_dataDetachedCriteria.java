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

public class Base_dataDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression base_data_id;
	public final IntegerExpression batchId;
	public final AssociationExpression batch;
	public final IntegerExpression data_elementId;
	public final AssociationExpression data_element;
	public final StringExpression data_element_value;
	public final IntegerExpression health_facilityId;
	public final AssociationExpression health_facility;
	public final IntegerExpression parishId;
	public final AssociationExpression parish;
	public final IntegerExpression sub_countyId;
	public final AssociationExpression sub_county;
	public final IntegerExpression districtId;
	public final AssociationExpression district;
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
	public final IntegerExpression report_period_bi_month;
	
	public Base_dataDetachedCriteria() {
		super(eihdms.Base_data.class, eihdms.Base_dataCriteria.class);
		base_data_id = new IntegerExpression("base_data_id", this.getDetachedCriteria());
		batchId = new IntegerExpression("batch.batch_id", this.getDetachedCriteria());
		batch = new AssociationExpression("batch", this.getDetachedCriteria());
		data_elementId = new IntegerExpression("data_element.data_element_id", this.getDetachedCriteria());
		data_element = new AssociationExpression("data_element", this.getDetachedCriteria());
		data_element_value = new StringExpression("data_element_value", this.getDetachedCriteria());
		health_facilityId = new IntegerExpression("health_facility.health_facility_id", this.getDetachedCriteria());
		health_facility = new AssociationExpression("health_facility", this.getDetachedCriteria());
		parishId = new IntegerExpression("parish.parish_id", this.getDetachedCriteria());
		parish = new AssociationExpression("parish", this.getDetachedCriteria());
		sub_countyId = new IntegerExpression("sub_county.sub_county_id", this.getDetachedCriteria());
		sub_county = new AssociationExpression("sub_county", this.getDetachedCriteria());
		districtId = new IntegerExpression("district.district_id", this.getDetachedCriteria());
		district = new AssociationExpression("district", this.getDetachedCriteria());
		financial_yearId = new IntegerExpression("financial_year.financial_year_id", this.getDetachedCriteria());
		financial_year = new AssociationExpression("financial_year", this.getDetachedCriteria());
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
	}
	
	public Base_dataDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Base_dataCriteria.class);
		base_data_id = new IntegerExpression("base_data_id", this.getDetachedCriteria());
		batchId = new IntegerExpression("batch.batch_id", this.getDetachedCriteria());
		batch = new AssociationExpression("batch", this.getDetachedCriteria());
		data_elementId = new IntegerExpression("data_element.data_element_id", this.getDetachedCriteria());
		data_element = new AssociationExpression("data_element", this.getDetachedCriteria());
		data_element_value = new StringExpression("data_element_value", this.getDetachedCriteria());
		health_facilityId = new IntegerExpression("health_facility.health_facility_id", this.getDetachedCriteria());
		health_facility = new AssociationExpression("health_facility", this.getDetachedCriteria());
		parishId = new IntegerExpression("parish.parish_id", this.getDetachedCriteria());
		parish = new AssociationExpression("parish", this.getDetachedCriteria());
		sub_countyId = new IntegerExpression("sub_county.sub_county_id", this.getDetachedCriteria());
		sub_county = new AssociationExpression("sub_county", this.getDetachedCriteria());
		districtId = new IntegerExpression("district.district_id", this.getDetachedCriteria());
		district = new AssociationExpression("district", this.getDetachedCriteria());
		financial_yearId = new IntegerExpression("financial_year.financial_year_id", this.getDetachedCriteria());
		financial_year = new AssociationExpression("financial_year", this.getDetachedCriteria());
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
	}
	
	public BatchDetachedCriteria createBatchCriteria() {
		return new BatchDetachedCriteria(createCriteria("batch"));
	}
	
	public Data_elementDetachedCriteria createData_elementCriteria() {
		return new Data_elementDetachedCriteria(createCriteria("data_element"));
	}
	
	public Health_facilityDetachedCriteria createHealth_facilityCriteria() {
		return new Health_facilityDetachedCriteria(createCriteria("health_facility"));
	}
	
	public ParishDetachedCriteria createParishCriteria() {
		return new ParishDetachedCriteria(createCriteria("parish"));
	}
	
	public Sub_countyDetachedCriteria createSub_countyCriteria() {
		return new Sub_countyDetachedCriteria(createCriteria("sub_county"));
	}
	
	public DistrictDetachedCriteria createDistrictCriteria() {
		return new DistrictDetachedCriteria(createCriteria("district"));
	}
	
	public Financial_yearDetachedCriteria createFinancial_yearCriteria() {
		return new Financial_yearDetachedCriteria(createCriteria("financial_year"));
	}
	
	public Base_data uniqueBase_data(PersistentSession session) {
		return (Base_data) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Base_data[] listBase_data(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Base_data[]) list.toArray(new Base_data[list.size()]);
	}
}


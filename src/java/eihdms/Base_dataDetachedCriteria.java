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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Base_dataDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression base_data_id;
	public final IntegerExpression data_elementId;
	public final AssociationExpression data_element;
	public final StringExpression data_element_value;
	public final IntegerExpression health_facilityId;
	public final AssociationExpression health_facility;
	public final IntegerExpression parishId;
	public final AssociationExpression parish;
	public final IntegerExpression districtId;
	public final AssociationExpression district;
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
	
	public Base_dataDetachedCriteria() {
		super(eihdms.Base_data.class, eihdms.Base_dataCriteria.class);
		base_data_id = new IntegerExpression("base_data_id", this.getDetachedCriteria());
		data_elementId = new IntegerExpression("data_element.data_element_id", this.getDetachedCriteria());
		data_element = new AssociationExpression("data_element", this.getDetachedCriteria());
		data_element_value = new StringExpression("data_element_value", this.getDetachedCriteria());
		health_facilityId = new IntegerExpression("health_facility.health_facility_id", this.getDetachedCriteria());
		health_facility = new AssociationExpression("health_facility", this.getDetachedCriteria());
		parishId = new IntegerExpression("parish.parish_id", this.getDetachedCriteria());
		parish = new AssociationExpression("parish", this.getDetachedCriteria());
		districtId = new IntegerExpression("district.district_id", this.getDetachedCriteria());
		district = new AssociationExpression("district", this.getDetachedCriteria());
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
	}
	
	public Base_dataDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Base_dataCriteria.class);
		base_data_id = new IntegerExpression("base_data_id", this.getDetachedCriteria());
		data_elementId = new IntegerExpression("data_element.data_element_id", this.getDetachedCriteria());
		data_element = new AssociationExpression("data_element", this.getDetachedCriteria());
		data_element_value = new StringExpression("data_element_value", this.getDetachedCriteria());
		health_facilityId = new IntegerExpression("health_facility.health_facility_id", this.getDetachedCriteria());
		health_facility = new AssociationExpression("health_facility", this.getDetachedCriteria());
		parishId = new IntegerExpression("parish.parish_id", this.getDetachedCriteria());
		parish = new AssociationExpression("parish", this.getDetachedCriteria());
		districtId = new IntegerExpression("district.district_id", this.getDetachedCriteria());
		district = new AssociationExpression("district", this.getDetachedCriteria());
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


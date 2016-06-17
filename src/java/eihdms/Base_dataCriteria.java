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

public class Base_dataCriteria extends AbstractORMCriteria {
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
	public final DateExpression report_period_from_date;
	public final DateExpression report_period_to_date;
	public final StringExpression report_period_name;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Base_dataCriteria(Criteria criteria) {
		super(criteria);
		base_data_id = new IntegerExpression("base_data_id", this);
		data_elementId = new IntegerExpression("data_element.data_element_id", this);
		data_element = new AssociationExpression("data_element", this);
		data_element_value = new StringExpression("data_element_value", this);
		health_facilityId = new IntegerExpression("health_facility.health_facility_id", this);
		health_facility = new AssociationExpression("health_facility", this);
		parishId = new IntegerExpression("parish.parish_id", this);
		parish = new AssociationExpression("parish", this);
		districtId = new IntegerExpression("district.district_id", this);
		district = new AssociationExpression("district", this);
		report_period_from_date = new DateExpression("report_period_from_date", this);
		report_period_to_date = new DateExpression("report_period_to_date", this);
		report_period_name = new StringExpression("report_period_name", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Base_dataCriteria(PersistentSession session) {
		this(session.createCriteria(Base_data.class));
	}
	
	public Base_dataCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public Data_elementCriteria createData_elementCriteria() {
		return new Data_elementCriteria(createCriteria("data_element"));
	}
	
	public Health_facilityCriteria createHealth_facilityCriteria() {
		return new Health_facilityCriteria(createCriteria("health_facility"));
	}
	
	public ParishCriteria createParishCriteria() {
		return new ParishCriteria(createCriteria("parish"));
	}
	
	public DistrictCriteria createDistrictCriteria() {
		return new DistrictCriteria(createCriteria("district"));
	}
	
	public Base_data uniqueBase_data() {
		return (Base_data) super.uniqueResult();
	}
	
	public Base_data[] listBase_data() {
		java.util.List list = super.list();
		return (Base_data[]) list.toArray(new Base_data[list.size()]);
	}
}


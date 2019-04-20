/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Wence
 * License Type: Purchased
 */
package eihdms;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CountyDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression county_id;
	public final StringExpression county_name;
	public final IntegerExpression districtId;
	public final AssociationExpression district;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression sub_county;
	public final CollectionExpression health_facility;
	public final CollectionExpression base_data;
	public final CollectionExpression access_scope;
	
	public CountyDetachedCriteria() {
		super(eihdms.County.class, eihdms.CountyCriteria.class);
		county_id = new IntegerExpression("county_id", this.getDetachedCriteria());
		county_name = new StringExpression("county_name", this.getDetachedCriteria());
		districtId = new IntegerExpression("district.district_id", this.getDetachedCriteria());
		district = new AssociationExpression("district", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		sub_county = new CollectionExpression("sub_county", this.getDetachedCriteria());
		health_facility = new CollectionExpression("health_facility", this.getDetachedCriteria());
		base_data = new CollectionExpression("base_data", this.getDetachedCriteria());
		access_scope = new CollectionExpression("access_scope", this.getDetachedCriteria());
	}
	
	public CountyDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.CountyCriteria.class);
		county_id = new IntegerExpression("county_id", this.getDetachedCriteria());
		county_name = new StringExpression("county_name", this.getDetachedCriteria());
		districtId = new IntegerExpression("district.district_id", this.getDetachedCriteria());
		district = new AssociationExpression("district", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		sub_county = new CollectionExpression("sub_county", this.getDetachedCriteria());
		health_facility = new CollectionExpression("health_facility", this.getDetachedCriteria());
		base_data = new CollectionExpression("base_data", this.getDetachedCriteria());
		access_scope = new CollectionExpression("access_scope", this.getDetachedCriteria());
	}
	
	public DistrictDetachedCriteria createDistrictCriteria() {
		return new DistrictDetachedCriteria(createCriteria("district"));
	}
	
	public Sub_countyDetachedCriteria createSub_countyCriteria() {
		return new Sub_countyDetachedCriteria(createCriteria("sub_county"));
	}
	
	public Health_facilityDetachedCriteria createHealth_facilityCriteria() {
		return new Health_facilityDetachedCriteria(createCriteria("health_facility"));
	}
	
	public Base_dataDetachedCriteria createBase_dataCriteria() {
		return new Base_dataDetachedCriteria(createCriteria("base_data"));
	}
	
	public Access_scopeDetachedCriteria createAccess_scopeCriteria() {
		return new Access_scopeDetachedCriteria(createCriteria("access_scope"));
	}
	
	public County uniqueCounty(PersistentSession session) {
		return (County) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public County[] listCounty(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (County[]) list.toArray(new County[list.size()]);
	}
}


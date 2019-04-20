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

public class DistrictDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression district_id;
	public final StringExpression district_name;
	public final IntegerExpression regionId;
	public final AssociationExpression region;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression sub_district;
	public final CollectionExpression county;
	public final CollectionExpression health_facility;
	public final CollectionExpression base_data;
	public final CollectionExpression access_scope;
	
	public DistrictDetachedCriteria() {
		super(eihdms.District.class, eihdms.DistrictCriteria.class);
		district_id = new IntegerExpression("district_id", this.getDetachedCriteria());
		district_name = new StringExpression("district_name", this.getDetachedCriteria());
		regionId = new IntegerExpression("region.region_id", this.getDetachedCriteria());
		region = new AssociationExpression("region", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		sub_district = new CollectionExpression("sub_district", this.getDetachedCriteria());
		county = new CollectionExpression("county", this.getDetachedCriteria());
		health_facility = new CollectionExpression("health_facility", this.getDetachedCriteria());
		base_data = new CollectionExpression("base_data", this.getDetachedCriteria());
		access_scope = new CollectionExpression("access_scope", this.getDetachedCriteria());
	}
	
	public DistrictDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.DistrictCriteria.class);
		district_id = new IntegerExpression("district_id", this.getDetachedCriteria());
		district_name = new StringExpression("district_name", this.getDetachedCriteria());
		regionId = new IntegerExpression("region.region_id", this.getDetachedCriteria());
		region = new AssociationExpression("region", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		sub_district = new CollectionExpression("sub_district", this.getDetachedCriteria());
		county = new CollectionExpression("county", this.getDetachedCriteria());
		health_facility = new CollectionExpression("health_facility", this.getDetachedCriteria());
		base_data = new CollectionExpression("base_data", this.getDetachedCriteria());
		access_scope = new CollectionExpression("access_scope", this.getDetachedCriteria());
	}
	
	public RegionDetachedCriteria createRegionCriteria() {
		return new RegionDetachedCriteria(createCriteria("region"));
	}
	
	public Sub_districtDetachedCriteria createSub_districtCriteria() {
		return new Sub_districtDetachedCriteria(createCriteria("sub_district"));
	}
	
	public CountyDetachedCriteria createCountyCriteria() {
		return new CountyDetachedCriteria(createCriteria("county"));
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
	
	public District uniqueDistrict(PersistentSession session) {
		return (District) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public District[] listDistrict(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (District[]) list.toArray(new District[list.size()]);
	}
}


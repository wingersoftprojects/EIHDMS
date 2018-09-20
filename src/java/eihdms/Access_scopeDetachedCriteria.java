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

public class Access_scopeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression access_scope_id;
	public final IntegerExpression user_detailId;
	public final AssociationExpression user_detail;
	public final IntegerExpression regionId;
	public final AssociationExpression region;
	public final IntegerExpression districtId;
	public final AssociationExpression district;
	public final IntegerExpression countyId;
	public final AssociationExpression county;
	public final IntegerExpression sub_countyId;
	public final AssociationExpression sub_county;
	public final IntegerExpression parishId;
	public final AssociationExpression parish;
	public final IntegerExpression health_facilityId;
	public final AssociationExpression health_facility;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Access_scopeDetachedCriteria() {
		super(eihdms.Access_scope.class, eihdms.Access_scopeCriteria.class);
		access_scope_id = new IntegerExpression("access_scope_id", this.getDetachedCriteria());
		user_detailId = new IntegerExpression("user_detail.user_detail_id", this.getDetachedCriteria());
		user_detail = new AssociationExpression("user_detail", this.getDetachedCriteria());
		regionId = new IntegerExpression("region.region_id", this.getDetachedCriteria());
		region = new AssociationExpression("region", this.getDetachedCriteria());
		districtId = new IntegerExpression("district.district_id", this.getDetachedCriteria());
		district = new AssociationExpression("district", this.getDetachedCriteria());
		countyId = new IntegerExpression("county.county_id", this.getDetachedCriteria());
		county = new AssociationExpression("county", this.getDetachedCriteria());
		sub_countyId = new IntegerExpression("sub_county.sub_county_id", this.getDetachedCriteria());
		sub_county = new AssociationExpression("sub_county", this.getDetachedCriteria());
		parishId = new IntegerExpression("parish.parish_id", this.getDetachedCriteria());
		parish = new AssociationExpression("parish", this.getDetachedCriteria());
		health_facilityId = new IntegerExpression("health_facility.health_facility_id", this.getDetachedCriteria());
		health_facility = new AssociationExpression("health_facility", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Access_scopeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Access_scopeCriteria.class);
		access_scope_id = new IntegerExpression("access_scope_id", this.getDetachedCriteria());
		user_detailId = new IntegerExpression("user_detail.user_detail_id", this.getDetachedCriteria());
		user_detail = new AssociationExpression("user_detail", this.getDetachedCriteria());
		regionId = new IntegerExpression("region.region_id", this.getDetachedCriteria());
		region = new AssociationExpression("region", this.getDetachedCriteria());
		districtId = new IntegerExpression("district.district_id", this.getDetachedCriteria());
		district = new AssociationExpression("district", this.getDetachedCriteria());
		countyId = new IntegerExpression("county.county_id", this.getDetachedCriteria());
		county = new AssociationExpression("county", this.getDetachedCriteria());
		sub_countyId = new IntegerExpression("sub_county.sub_county_id", this.getDetachedCriteria());
		sub_county = new AssociationExpression("sub_county", this.getDetachedCriteria());
		parishId = new IntegerExpression("parish.parish_id", this.getDetachedCriteria());
		parish = new AssociationExpression("parish", this.getDetachedCriteria());
		health_facilityId = new IntegerExpression("health_facility.health_facility_id", this.getDetachedCriteria());
		health_facility = new AssociationExpression("health_facility", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public User_detailDetachedCriteria createUser_detailCriteria() {
		return new User_detailDetachedCriteria(createCriteria("user_detail"));
	}
	
	public RegionDetachedCriteria createRegionCriteria() {
		return new RegionDetachedCriteria(createCriteria("region"));
	}
	
	public DistrictDetachedCriteria createDistrictCriteria() {
		return new DistrictDetachedCriteria(createCriteria("district"));
	}
	
	public CountyDetachedCriteria createCountyCriteria() {
		return new CountyDetachedCriteria(createCriteria("county"));
	}
	
	public Sub_countyDetachedCriteria createSub_countyCriteria() {
		return new Sub_countyDetachedCriteria(createCriteria("sub_county"));
	}
	
	public ParishDetachedCriteria createParishCriteria() {
		return new ParishDetachedCriteria(createCriteria("parish"));
	}
	
	public Health_facilityDetachedCriteria createHealth_facilityCriteria() {
		return new Health_facilityDetachedCriteria(createCriteria("health_facility"));
	}
	
	public Access_scope uniqueAccess_scope(PersistentSession session) {
		return (Access_scope) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Access_scope[] listAccess_scope(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Access_scope[]) list.toArray(new Access_scope[list.size()]);
	}
}


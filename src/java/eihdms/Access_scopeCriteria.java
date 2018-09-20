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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Access_scopeCriteria extends AbstractORMCriteria {
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
	
	public Access_scopeCriteria(Criteria criteria) {
		super(criteria);
		access_scope_id = new IntegerExpression("access_scope_id", this);
		user_detailId = new IntegerExpression("user_detail.user_detail_id", this);
		user_detail = new AssociationExpression("user_detail", this);
		regionId = new IntegerExpression("region.region_id", this);
		region = new AssociationExpression("region", this);
		districtId = new IntegerExpression("district.district_id", this);
		district = new AssociationExpression("district", this);
		countyId = new IntegerExpression("county.county_id", this);
		county = new AssociationExpression("county", this);
		sub_countyId = new IntegerExpression("sub_county.sub_county_id", this);
		sub_county = new AssociationExpression("sub_county", this);
		parishId = new IntegerExpression("parish.parish_id", this);
		parish = new AssociationExpression("parish", this);
		health_facilityId = new IntegerExpression("health_facility.health_facility_id", this);
		health_facility = new AssociationExpression("health_facility", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Access_scopeCriteria(PersistentSession session) {
		this(session.createCriteria(Access_scope.class));
	}
	
	public Access_scopeCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public User_detailCriteria createUser_detailCriteria() {
		return new User_detailCriteria(createCriteria("user_detail"));
	}
	
	public RegionCriteria createRegionCriteria() {
		return new RegionCriteria(createCriteria("region"));
	}
	
	public DistrictCriteria createDistrictCriteria() {
		return new DistrictCriteria(createCriteria("district"));
	}
	
	public CountyCriteria createCountyCriteria() {
		return new CountyCriteria(createCriteria("county"));
	}
	
	public Sub_countyCriteria createSub_countyCriteria() {
		return new Sub_countyCriteria(createCriteria("sub_county"));
	}
	
	public ParishCriteria createParishCriteria() {
		return new ParishCriteria(createCriteria("parish"));
	}
	
	public Health_facilityCriteria createHealth_facilityCriteria() {
		return new Health_facilityCriteria(createCriteria("health_facility"));
	}
	
	public Access_scope uniqueAccess_scope() {
		return (Access_scope) super.uniqueResult();
	}
	
	public Access_scope[] listAccess_scope() {
		java.util.List list = super.list();
		return (Access_scope[]) list.toArray(new Access_scope[list.size()]);
	}
}


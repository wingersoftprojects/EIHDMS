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

public class Health_facilityCriteria extends AbstractORMCriteria {
	public final IntegerExpression health_facility_id;
	public final StringExpression health_facility_name;
	public final IntegerExpression regionId;
	public final AssociationExpression region;
	public final IntegerExpression districtId;
	public final AssociationExpression district;
	public final IntegerExpression sub_districtId;
	public final AssociationExpression sub_district;
	public final IntegerExpression countyId;
	public final AssociationExpression county;
	public final IntegerExpression sub_countyId;
	public final AssociationExpression sub_county;
	public final IntegerExpression parishId;
	public final AssociationExpression parish;
	public final IntegerExpression facility_levelId;
	public final AssociationExpression facility_level;
	public final StringExpression xcoordinate;
	public final StringExpression ycoordinate;
	public final StringExpression zcoordinate;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final StringExpression ownership;
	public final StringExpression short_name;
	public final CollectionExpression base_data;
	public final CollectionExpression access_scope;
	
	public Health_facilityCriteria(Criteria criteria) {
		super(criteria);
		health_facility_id = new IntegerExpression("health_facility_id", this);
		health_facility_name = new StringExpression("health_facility_name", this);
		regionId = new IntegerExpression("region.region_id", this);
		region = new AssociationExpression("region", this);
		districtId = new IntegerExpression("district.district_id", this);
		district = new AssociationExpression("district", this);
		sub_districtId = new IntegerExpression("sub_district.sub_district_id", this);
		sub_district = new AssociationExpression("sub_district", this);
		countyId = new IntegerExpression("county.county_id", this);
		county = new AssociationExpression("county", this);
		sub_countyId = new IntegerExpression("sub_county.sub_county_id", this);
		sub_county = new AssociationExpression("sub_county", this);
		parishId = new IntegerExpression("parish.parish_id", this);
		parish = new AssociationExpression("parish", this);
		facility_levelId = new IntegerExpression("facility_level.facility_level_id", this);
		facility_level = new AssociationExpression("facility_level", this);
		xcoordinate = new StringExpression("xcoordinate", this);
		ycoordinate = new StringExpression("ycoordinate", this);
		zcoordinate = new StringExpression("zcoordinate", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		ownership = new StringExpression("ownership", this);
		short_name = new StringExpression("short_name", this);
		base_data = new CollectionExpression("base_data", this);
		access_scope = new CollectionExpression("access_scope", this);
	}
	
	public Health_facilityCriteria(PersistentSession session) {
		this(session.createCriteria(Health_facility.class));
	}
	
	public Health_facilityCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public RegionCriteria createRegionCriteria() {
		return new RegionCriteria(createCriteria("region"));
	}
	
	public DistrictCriteria createDistrictCriteria() {
		return new DistrictCriteria(createCriteria("district"));
	}
	
	public Sub_districtCriteria createSub_districtCriteria() {
		return new Sub_districtCriteria(createCriteria("sub_district"));
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
	
	public Facility_levelCriteria createFacility_levelCriteria() {
		return new Facility_levelCriteria(createCriteria("facility_level"));
	}
	
	public Base_dataCriteria createBase_dataCriteria() {
		return new Base_dataCriteria(createCriteria("base_data"));
	}
	
	public Access_scopeCriteria createAccess_scopeCriteria() {
		return new Access_scopeCriteria(createCriteria("access_scope"));
	}
	
	public Health_facility uniqueHealth_facility() {
		return (Health_facility) super.uniqueResult();
	}
	
	public Health_facility[] listHealth_facility() {
		java.util.List list = super.list();
		return (Health_facility[]) list.toArray(new Health_facility[list.size()]);
	}
}


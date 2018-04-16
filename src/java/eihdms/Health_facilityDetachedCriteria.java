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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Health_facilityDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public Health_facilityDetachedCriteria() {
		super(eihdms.Health_facility.class, eihdms.Health_facilityCriteria.class);
		health_facility_id = new IntegerExpression("health_facility_id", this.getDetachedCriteria());
		health_facility_name = new StringExpression("health_facility_name", this.getDetachedCriteria());
		regionId = new IntegerExpression("region.region_id", this.getDetachedCriteria());
		region = new AssociationExpression("region", this.getDetachedCriteria());
		districtId = new IntegerExpression("district.district_id", this.getDetachedCriteria());
		district = new AssociationExpression("district", this.getDetachedCriteria());
		sub_districtId = new IntegerExpression("sub_district.sub_district_id", this.getDetachedCriteria());
		sub_district = new AssociationExpression("sub_district", this.getDetachedCriteria());
		countyId = new IntegerExpression("county.county_id", this.getDetachedCriteria());
		county = new AssociationExpression("county", this.getDetachedCriteria());
		sub_countyId = new IntegerExpression("sub_county.sub_county_id", this.getDetachedCriteria());
		sub_county = new AssociationExpression("sub_county", this.getDetachedCriteria());
		parishId = new IntegerExpression("parish.parish_id", this.getDetachedCriteria());
		parish = new AssociationExpression("parish", this.getDetachedCriteria());
		facility_levelId = new IntegerExpression("facility_level.facility_level_id", this.getDetachedCriteria());
		facility_level = new AssociationExpression("facility_level", this.getDetachedCriteria());
		xcoordinate = new StringExpression("xcoordinate", this.getDetachedCriteria());
		ycoordinate = new StringExpression("ycoordinate", this.getDetachedCriteria());
		zcoordinate = new StringExpression("zcoordinate", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		ownership = new StringExpression("ownership", this.getDetachedCriteria());
		short_name = new StringExpression("short_name", this.getDetachedCriteria());
		base_data = new CollectionExpression("base_data", this.getDetachedCriteria());
	}
	
	public Health_facilityDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Health_facilityCriteria.class);
		health_facility_id = new IntegerExpression("health_facility_id", this.getDetachedCriteria());
		health_facility_name = new StringExpression("health_facility_name", this.getDetachedCriteria());
		regionId = new IntegerExpression("region.region_id", this.getDetachedCriteria());
		region = new AssociationExpression("region", this.getDetachedCriteria());
		districtId = new IntegerExpression("district.district_id", this.getDetachedCriteria());
		district = new AssociationExpression("district", this.getDetachedCriteria());
		sub_districtId = new IntegerExpression("sub_district.sub_district_id", this.getDetachedCriteria());
		sub_district = new AssociationExpression("sub_district", this.getDetachedCriteria());
		countyId = new IntegerExpression("county.county_id", this.getDetachedCriteria());
		county = new AssociationExpression("county", this.getDetachedCriteria());
		sub_countyId = new IntegerExpression("sub_county.sub_county_id", this.getDetachedCriteria());
		sub_county = new AssociationExpression("sub_county", this.getDetachedCriteria());
		parishId = new IntegerExpression("parish.parish_id", this.getDetachedCriteria());
		parish = new AssociationExpression("parish", this.getDetachedCriteria());
		facility_levelId = new IntegerExpression("facility_level.facility_level_id", this.getDetachedCriteria());
		facility_level = new AssociationExpression("facility_level", this.getDetachedCriteria());
		xcoordinate = new StringExpression("xcoordinate", this.getDetachedCriteria());
		ycoordinate = new StringExpression("ycoordinate", this.getDetachedCriteria());
		zcoordinate = new StringExpression("zcoordinate", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		ownership = new StringExpression("ownership", this.getDetachedCriteria());
		short_name = new StringExpression("short_name", this.getDetachedCriteria());
		base_data = new CollectionExpression("base_data", this.getDetachedCriteria());
	}
	
	public RegionDetachedCriteria createRegionCriteria() {
		return new RegionDetachedCriteria(createCriteria("region"));
	}
	
	public DistrictDetachedCriteria createDistrictCriteria() {
		return new DistrictDetachedCriteria(createCriteria("district"));
	}
	
	public Sub_districtDetachedCriteria createSub_districtCriteria() {
		return new Sub_districtDetachedCriteria(createCriteria("sub_district"));
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
	
	public Facility_levelDetachedCriteria createFacility_levelCriteria() {
		return new Facility_levelDetachedCriteria(createCriteria("facility_level"));
	}
	
	public Base_dataDetachedCriteria createBase_dataCriteria() {
		return new Base_dataDetachedCriteria(createCriteria("base_data"));
	}
	
	public Health_facility uniqueHealth_facility(PersistentSession session) {
		return (Health_facility) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Health_facility[] listHealth_facility(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Health_facility[]) list.toArray(new Health_facility[list.size()]);
	}
}


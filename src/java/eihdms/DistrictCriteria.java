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

public class DistrictCriteria extends AbstractORMCriteria {
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
	
	public DistrictCriteria(Criteria criteria) {
		super(criteria);
		district_id = new IntegerExpression("district_id", this);
		district_name = new StringExpression("district_name", this);
		regionId = new IntegerExpression("region.region_id", this);
		region = new AssociationExpression("region", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		sub_district = new CollectionExpression("sub_district", this);
		county = new CollectionExpression("county", this);
		health_facility = new CollectionExpression("health_facility", this);
		base_data = new CollectionExpression("base_data", this);
		access_scope = new CollectionExpression("access_scope", this);
	}
	
	public DistrictCriteria(PersistentSession session) {
		this(session.createCriteria(District.class));
	}
	
	public DistrictCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public RegionCriteria createRegionCriteria() {
		return new RegionCriteria(createCriteria("region"));
	}
	
	public Sub_districtCriteria createSub_districtCriteria() {
		return new Sub_districtCriteria(createCriteria("sub_district"));
	}
	
	public CountyCriteria createCountyCriteria() {
		return new CountyCriteria(createCriteria("county"));
	}
	
	public Health_facilityCriteria createHealth_facilityCriteria() {
		return new Health_facilityCriteria(createCriteria("health_facility"));
	}
	
	public Base_dataCriteria createBase_dataCriteria() {
		return new Base_dataCriteria(createCriteria("base_data"));
	}
	
	public Access_scopeCriteria createAccess_scopeCriteria() {
		return new Access_scopeCriteria(createCriteria("access_scope"));
	}
	
	public District uniqueDistrict() {
		return (District) super.uniqueResult();
	}
	
	public District[] listDistrict() {
		java.util.List list = super.list();
		return (District[]) list.toArray(new District[list.size()]);
	}
}


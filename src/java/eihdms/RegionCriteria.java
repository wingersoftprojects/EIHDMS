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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RegionCriteria extends AbstractORMCriteria {
	public final IntegerExpression region_id;
	public final StringExpression region_name;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression district;
	public final CollectionExpression health_facility;
	public final CollectionExpression access_scope;
	
	public RegionCriteria(Criteria criteria) {
		super(criteria);
		region_id = new IntegerExpression("region_id", this);
		region_name = new StringExpression("region_name", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		district = new CollectionExpression("district", this);
		health_facility = new CollectionExpression("health_facility", this);
		access_scope = new CollectionExpression("access_scope", this);
	}
	
	public RegionCriteria(PersistentSession session) {
		this(session.createCriteria(Region.class));
	}
	
	public RegionCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public DistrictCriteria createDistrictCriteria() {
		return new DistrictCriteria(createCriteria("district"));
	}
	
	public Health_facilityCriteria createHealth_facilityCriteria() {
		return new Health_facilityCriteria(createCriteria("health_facility"));
	}
	
	public Access_scopeCriteria createAccess_scopeCriteria() {
		return new Access_scopeCriteria(createCriteria("access_scope"));
	}
	
	public Region uniqueRegion() {
		return (Region) super.uniqueResult();
	}
	
	public Region[] listRegion() {
		java.util.List list = super.list();
		return (Region[]) list.toArray(new Region[list.size()]);
	}
}


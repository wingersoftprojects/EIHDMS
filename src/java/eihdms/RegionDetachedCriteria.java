/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: btwesigye
 * License Type: Purchased
 */
package eihdms;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RegionDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public RegionDetachedCriteria() {
		super(eihdms.Region.class, eihdms.RegionCriteria.class);
		region_id = new IntegerExpression("region_id", this.getDetachedCriteria());
		region_name = new StringExpression("region_name", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		district = new CollectionExpression("district", this.getDetachedCriteria());
		health_facility = new CollectionExpression("health_facility", this.getDetachedCriteria());
	}
	
	public RegionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.RegionCriteria.class);
		region_id = new IntegerExpression("region_id", this.getDetachedCriteria());
		region_name = new StringExpression("region_name", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		district = new CollectionExpression("district", this.getDetachedCriteria());
		health_facility = new CollectionExpression("health_facility", this.getDetachedCriteria());
	}
	
	public DistrictDetachedCriteria createDistrictCriteria() {
		return new DistrictDetachedCriteria(createCriteria("district"));
	}
	
	public Health_facilityDetachedCriteria createHealth_facilityCriteria() {
		return new Health_facilityDetachedCriteria(createCriteria("health_facility"));
	}
	
	public Region uniqueRegion(PersistentSession session) {
		return (Region) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Region[] listRegion(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Region[]) list.toArray(new Region[list.size()]);
	}
}


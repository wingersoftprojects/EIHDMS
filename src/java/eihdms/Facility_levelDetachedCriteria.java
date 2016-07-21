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

public class Facility_levelDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression facility_level_id;
	public final StringExpression facility_level_name;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression health_facility;
	
	public Facility_levelDetachedCriteria() {
		super(eihdms.Facility_level.class, eihdms.Facility_levelCriteria.class);
		facility_level_id = new IntegerExpression("facility_level_id", this.getDetachedCriteria());
		facility_level_name = new StringExpression("facility_level_name", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		health_facility = new CollectionExpression("health_facility", this.getDetachedCriteria());
	}
	
	public Facility_levelDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Facility_levelCriteria.class);
		facility_level_id = new IntegerExpression("facility_level_id", this.getDetachedCriteria());
		facility_level_name = new StringExpression("facility_level_name", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		health_facility = new CollectionExpression("health_facility", this.getDetachedCriteria());
	}
	
	public Health_facilityDetachedCriteria createHealth_facilityCriteria() {
		return new Health_facilityDetachedCriteria(createCriteria("health_facility"));
	}
	
	public Facility_level uniqueFacility_level(PersistentSession session) {
		return (Facility_level) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Facility_level[] listFacility_level(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Facility_level[]) list.toArray(new Facility_level[list.size()]);
	}
}


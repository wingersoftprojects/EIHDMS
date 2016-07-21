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

public class Temp_health_facilityDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression temp_health_facility_id;
	public final StringExpression health_facility_name;
	public final StringExpression region_name;
	public final StringExpression district_name;
	public final StringExpression sub_district_name;
	public final StringExpression county_name;
	public final StringExpression sub_county_name;
	public final StringExpression parish_name;
	public final StringExpression facility_level_name;
	public final StringExpression xcoordinate;
	public final StringExpression ycoordinate;
	public final StringExpression zcoordinate;
	
	public Temp_health_facilityDetachedCriteria() {
		super(eihdms.Temp_health_facility.class, eihdms.Temp_health_facilityCriteria.class);
		temp_health_facility_id = new IntegerExpression("temp_health_facility_id", this.getDetachedCriteria());
		health_facility_name = new StringExpression("health_facility_name", this.getDetachedCriteria());
		region_name = new StringExpression("region_name", this.getDetachedCriteria());
		district_name = new StringExpression("district_name", this.getDetachedCriteria());
		sub_district_name = new StringExpression("sub_district_name", this.getDetachedCriteria());
		county_name = new StringExpression("county_name", this.getDetachedCriteria());
		sub_county_name = new StringExpression("sub_county_name", this.getDetachedCriteria());
		parish_name = new StringExpression("parish_name", this.getDetachedCriteria());
		facility_level_name = new StringExpression("facility_level_name", this.getDetachedCriteria());
		xcoordinate = new StringExpression("xcoordinate", this.getDetachedCriteria());
		ycoordinate = new StringExpression("ycoordinate", this.getDetachedCriteria());
		zcoordinate = new StringExpression("zcoordinate", this.getDetachedCriteria());
	}
	
	public Temp_health_facilityDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Temp_health_facilityCriteria.class);
		temp_health_facility_id = new IntegerExpression("temp_health_facility_id", this.getDetachedCriteria());
		health_facility_name = new StringExpression("health_facility_name", this.getDetachedCriteria());
		region_name = new StringExpression("region_name", this.getDetachedCriteria());
		district_name = new StringExpression("district_name", this.getDetachedCriteria());
		sub_district_name = new StringExpression("sub_district_name", this.getDetachedCriteria());
		county_name = new StringExpression("county_name", this.getDetachedCriteria());
		sub_county_name = new StringExpression("sub_county_name", this.getDetachedCriteria());
		parish_name = new StringExpression("parish_name", this.getDetachedCriteria());
		facility_level_name = new StringExpression("facility_level_name", this.getDetachedCriteria());
		xcoordinate = new StringExpression("xcoordinate", this.getDetachedCriteria());
		ycoordinate = new StringExpression("ycoordinate", this.getDetachedCriteria());
		zcoordinate = new StringExpression("zcoordinate", this.getDetachedCriteria());
	}
	
	public Temp_health_facility uniqueTemp_health_facility(PersistentSession session) {
		return (Temp_health_facility) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Temp_health_facility[] listTemp_health_facility(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Temp_health_facility[]) list.toArray(new Temp_health_facility[list.size()]);
	}
}


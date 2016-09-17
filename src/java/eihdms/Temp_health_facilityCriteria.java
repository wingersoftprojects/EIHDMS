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

public class Temp_health_facilityCriteria extends AbstractORMCriteria {
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
	public final StringExpression ownership;
	public final StringExpression short_name;
	
	public Temp_health_facilityCriteria(Criteria criteria) {
		super(criteria);
		temp_health_facility_id = new IntegerExpression("temp_health_facility_id", this);
		health_facility_name = new StringExpression("health_facility_name", this);
		region_name = new StringExpression("region_name", this);
		district_name = new StringExpression("district_name", this);
		sub_district_name = new StringExpression("sub_district_name", this);
		county_name = new StringExpression("county_name", this);
		sub_county_name = new StringExpression("sub_county_name", this);
		parish_name = new StringExpression("parish_name", this);
		facility_level_name = new StringExpression("facility_level_name", this);
		xcoordinate = new StringExpression("xcoordinate", this);
		ycoordinate = new StringExpression("ycoordinate", this);
		zcoordinate = new StringExpression("zcoordinate", this);
		ownership = new StringExpression("ownership", this);
		short_name = new StringExpression("short_name", this);
	}
	
	public Temp_health_facilityCriteria(PersistentSession session) {
		this(session.createCriteria(Temp_health_facility.class));
	}
	
	public Temp_health_facilityCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public Temp_health_facility uniqueTemp_health_facility() {
		return (Temp_health_facility) super.uniqueResult();
	}
	
	public Temp_health_facility[] listTemp_health_facility() {
		java.util.List list = super.list();
		return (Temp_health_facility[]) list.toArray(new Temp_health_facility[list.size()]);
	}
}


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

public class Facility_levelCriteria extends AbstractORMCriteria {
	public final IntegerExpression facility_level_id;
	public final StringExpression facility_level_name;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression health_facility;
	
	public Facility_levelCriteria(Criteria criteria) {
		super(criteria);
		facility_level_id = new IntegerExpression("facility_level_id", this);
		facility_level_name = new StringExpression("facility_level_name", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		health_facility = new CollectionExpression("health_facility", this);
	}
	
	public Facility_levelCriteria(PersistentSession session) {
		this(session.createCriteria(Facility_level.class));
	}
	
	public Facility_levelCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Health_facilityCriteria createHealth_facilityCriteria() {
		return new Health_facilityCriteria(createCriteria("health_facility"));
	}
	
	public Facility_level uniqueFacility_level() {
		return (Facility_level) super.uniqueResult();
	}
	
	public Facility_level[] listFacility_level() {
		java.util.List list = super.list();
		return (Facility_level[]) list.toArray(new Facility_level[list.size()]);
	}
}


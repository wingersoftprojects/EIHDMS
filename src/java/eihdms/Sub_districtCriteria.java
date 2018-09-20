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

public class Sub_districtCriteria extends AbstractORMCriteria {
	public final IntegerExpression sub_district_id;
	public final StringExpression sub_district_name;
	public final IntegerExpression districtId;
	public final AssociationExpression district;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression health_facility;
	
	public Sub_districtCriteria(Criteria criteria) {
		super(criteria);
		sub_district_id = new IntegerExpression("sub_district_id", this);
		sub_district_name = new StringExpression("sub_district_name", this);
		districtId = new IntegerExpression("district.district_id", this);
		district = new AssociationExpression("district", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		health_facility = new CollectionExpression("health_facility", this);
	}
	
	public Sub_districtCriteria(PersistentSession session) {
		this(session.createCriteria(Sub_district.class));
	}
	
	public Sub_districtCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public DistrictCriteria createDistrictCriteria() {
		return new DistrictCriteria(createCriteria("district"));
	}
	
	public Health_facilityCriteria createHealth_facilityCriteria() {
		return new Health_facilityCriteria(createCriteria("health_facility"));
	}
	
	public Sub_district uniqueSub_district() {
		return (Sub_district) super.uniqueResult();
	}
	
	public Sub_district[] listSub_district() {
		java.util.List list = super.list();
		return (Sub_district[]) list.toArray(new Sub_district[list.size()]);
	}
}


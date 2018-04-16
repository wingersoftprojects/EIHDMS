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

public class Access_scopeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression access_scope_id;
	public final IntegerExpression user_detail_id;
	public final IntegerExpression region_id;
	public final IntegerExpression district_id;
	public final IntegerExpression parish_id;
	public final IntegerExpression health_facility_id;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Access_scopeDetachedCriteria() {
		super(eihdms.Access_scope.class, eihdms.Access_scopeCriteria.class);
		access_scope_id = new IntegerExpression("access_scope_id", this.getDetachedCriteria());
		user_detail_id = new IntegerExpression("user_detail_id", this.getDetachedCriteria());
		region_id = new IntegerExpression("region_id", this.getDetachedCriteria());
		district_id = new IntegerExpression("district_id", this.getDetachedCriteria());
		parish_id = new IntegerExpression("parish_id", this.getDetachedCriteria());
		health_facility_id = new IntegerExpression("health_facility_id", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Access_scopeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Access_scopeCriteria.class);
		access_scope_id = new IntegerExpression("access_scope_id", this.getDetachedCriteria());
		user_detail_id = new IntegerExpression("user_detail_id", this.getDetachedCriteria());
		region_id = new IntegerExpression("region_id", this.getDetachedCriteria());
		district_id = new IntegerExpression("district_id", this.getDetachedCriteria());
		parish_id = new IntegerExpression("parish_id", this.getDetachedCriteria());
		health_facility_id = new IntegerExpression("health_facility_id", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Access_scope uniqueAccess_scope(PersistentSession session) {
		return (Access_scope) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Access_scope[] listAccess_scope(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Access_scope[]) list.toArray(new Access_scope[list.size()]);
	}
}


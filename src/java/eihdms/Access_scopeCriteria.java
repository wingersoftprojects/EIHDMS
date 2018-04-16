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

public class Access_scopeCriteria extends AbstractORMCriteria {
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
	
	public Access_scopeCriteria(Criteria criteria) {
		super(criteria);
		access_scope_id = new IntegerExpression("access_scope_id", this);
		user_detail_id = new IntegerExpression("user_detail_id", this);
		region_id = new IntegerExpression("region_id", this);
		district_id = new IntegerExpression("district_id", this);
		parish_id = new IntegerExpression("parish_id", this);
		health_facility_id = new IntegerExpression("health_facility_id", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Access_scopeCriteria(PersistentSession session) {
		this(session.createCriteria(Access_scope.class));
	}
	
	public Access_scopeCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Access_scope uniqueAccess_scope() {
		return (Access_scope) super.uniqueResult();
	}
	
	public Access_scope[] listAccess_scope() {
		java.util.List list = super.list();
		return (Access_scope[]) list.toArray(new Access_scope[list.size()]);
	}
}


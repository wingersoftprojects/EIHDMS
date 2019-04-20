/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: rlumala
 * License Type: Purchased
 */
package eihdms;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class App_db_user_mapDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression app_db_user_map_id;
	public final IntegerExpression user_detail_id;
	public final StringExpression db_user;
	public final StringExpression db_password;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public App_db_user_mapDetachedCriteria() {
		super(eihdms.App_db_user_map.class, eihdms.App_db_user_mapCriteria.class);
		app_db_user_map_id = new IntegerExpression("app_db_user_map_id", this.getDetachedCriteria());
		user_detail_id = new IntegerExpression("user_detail_id", this.getDetachedCriteria());
		db_user = new StringExpression("db_user", this.getDetachedCriteria());
		db_password = new StringExpression("db_password", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public App_db_user_mapDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.App_db_user_mapCriteria.class);
		app_db_user_map_id = new IntegerExpression("app_db_user_map_id", this.getDetachedCriteria());
		user_detail_id = new IntegerExpression("user_detail_id", this.getDetachedCriteria());
		db_user = new StringExpression("db_user", this.getDetachedCriteria());
		db_password = new StringExpression("db_password", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public App_db_user_map uniqueApp_db_user_map(PersistentSession session) {
		return (App_db_user_map) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public App_db_user_map[] listApp_db_user_map(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (App_db_user_map[]) list.toArray(new App_db_user_map[list.size()]);
	}
}


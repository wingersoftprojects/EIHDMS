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

public class App_db_user_mapCriteria extends AbstractORMCriteria {
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
	
	public App_db_user_mapCriteria(Criteria criteria) {
		super(criteria);
		app_db_user_map_id = new IntegerExpression("app_db_user_map_id", this);
		user_detail_id = new IntegerExpression("user_detail_id", this);
		db_user = new StringExpression("db_user", this);
		db_password = new StringExpression("db_password", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public App_db_user_mapCriteria(PersistentSession session) {
		this(session.createCriteria(App_db_user_map.class));
	}
	
	public App_db_user_mapCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public App_db_user_map uniqueApp_db_user_map() {
		return (App_db_user_map) super.uniqueResult();
	}
	
	public App_db_user_map[] listApp_db_user_map() {
		java.util.List list = super.list();
		return (App_db_user_map[]) list.toArray(new App_db_user_map[list.size()]);
	}
}


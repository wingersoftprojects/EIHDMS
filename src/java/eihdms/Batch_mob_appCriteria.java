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

public class Batch_mob_appCriteria extends AbstractORMCriteria {
	public final IntegerExpression batch_mob_app_id;
	public final IntegerExpression is_completed;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final StringExpression status_m;
	public final StringExpression status_m_desc;
	public final IntegerExpression batch_id;
	
	public Batch_mob_appCriteria(Criteria criteria) {
		super(criteria);
		batch_mob_app_id = new IntegerExpression("batch_mob_app_id", this);
		is_completed = new IntegerExpression("is_completed", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		status_m = new StringExpression("status_m", this);
		status_m_desc = new StringExpression("status_m_desc", this);
		batch_id = new IntegerExpression("batch_id", this);
	}
	
	public Batch_mob_appCriteria(PersistentSession session) {
		this(session.createCriteria(Batch_mob_app.class));
	}
	
	public Batch_mob_appCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Batch_mob_app uniqueBatch_mob_app() {
		return (Batch_mob_app) super.uniqueResult();
	}
	
	public Batch_mob_app[] listBatch_mob_app() {
		java.util.List list = super.list();
		return (Batch_mob_app[]) list.toArray(new Batch_mob_app[list.size()]);
	}
}


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

public class Batch_mob_appDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression batch_mob_app_id;
	public final IntegerExpression is_completed;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Batch_mob_appDetachedCriteria() {
		super(eihdms.Batch_mob_app.class, eihdms.Batch_mob_appCriteria.class);
		batch_mob_app_id = new IntegerExpression("batch_mob_app_id", this.getDetachedCriteria());
		is_completed = new IntegerExpression("is_completed", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Batch_mob_appDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Batch_mob_appCriteria.class);
		batch_mob_app_id = new IntegerExpression("batch_mob_app_id", this.getDetachedCriteria());
		is_completed = new IntegerExpression("is_completed", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Batch_mob_app uniqueBatch_mob_app(PersistentSession session) {
		return (Batch_mob_app) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Batch_mob_app[] listBatch_mob_app(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Batch_mob_app[]) list.toArray(new Batch_mob_app[list.size()]);
	}
}


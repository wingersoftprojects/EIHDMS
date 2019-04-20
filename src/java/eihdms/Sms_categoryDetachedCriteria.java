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

public class Sms_categoryDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression sms_category_id;
	public final StringExpression sms_category_name;
	public final StringExpression sms_category_desc;
	public final StringExpression data_entry_scope;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Sms_categoryDetachedCriteria() {
		super(eihdms.Sms_category.class, eihdms.Sms_categoryCriteria.class);
		sms_category_id = new IntegerExpression("sms_category_id", this.getDetachedCriteria());
		sms_category_name = new StringExpression("sms_category_name", this.getDetachedCriteria());
		sms_category_desc = new StringExpression("sms_category_desc", this.getDetachedCriteria());
		data_entry_scope = new StringExpression("data_entry_scope", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Sms_categoryDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Sms_categoryCriteria.class);
		sms_category_id = new IntegerExpression("sms_category_id", this.getDetachedCriteria());
		sms_category_name = new StringExpression("sms_category_name", this.getDetachedCriteria());
		sms_category_desc = new StringExpression("sms_category_desc", this.getDetachedCriteria());
		data_entry_scope = new StringExpression("data_entry_scope", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Sms_category uniqueSms_category(PersistentSession session) {
		return (Sms_category) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Sms_category[] listSms_category(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Sms_category[]) list.toArray(new Sms_category[list.size()]);
	}
}


/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: btwesigye
 * License Type: Purchased
 */
package eihdms;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class User_categoryDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression user_category_id;
	public final StringExpression user_category_name;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression user_detail;
	
	public User_categoryDetachedCriteria() {
		super(eihdms.User_category.class, eihdms.User_categoryCriteria.class);
		user_category_id = new IntegerExpression("user_category_id", this.getDetachedCriteria());
		user_category_name = new StringExpression("user_category_name", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		user_detail = new CollectionExpression("user_detail", this.getDetachedCriteria());
	}
	
	public User_categoryDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.User_categoryCriteria.class);
		user_category_id = new IntegerExpression("user_category_id", this.getDetachedCriteria());
		user_category_name = new StringExpression("user_category_name", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		user_detail = new CollectionExpression("user_detail", this.getDetachedCriteria());
	}
	
	public User_detailDetachedCriteria createUser_detailCriteria() {
		return new User_detailDetachedCriteria(createCriteria("user_detail"));
	}
	
	public User_category uniqueUser_category(PersistentSession session) {
		return (User_category) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public User_category[] listUser_category(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (User_category[]) list.toArray(new User_category[list.size()]);
	}
}


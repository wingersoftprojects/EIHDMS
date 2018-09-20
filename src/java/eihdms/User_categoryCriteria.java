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

public class User_categoryCriteria extends AbstractORMCriteria {
	public final IntegerExpression user_category_id;
	public final StringExpression user_category_name;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression user_detail;
	
	public User_categoryCriteria(Criteria criteria) {
		super(criteria);
		user_category_id = new IntegerExpression("user_category_id", this);
		user_category_name = new StringExpression("user_category_name", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		user_detail = new CollectionExpression("user_detail", this);
	}
	
	public User_categoryCriteria(PersistentSession session) {
		this(session.createCriteria(User_category.class));
	}
	
	public User_categoryCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public User_detailCriteria createUser_detailCriteria() {
		return new User_detailCriteria(createCriteria("user_detail"));
	}
	
	public User_category uniqueUser_category() {
		return (User_category) super.uniqueResult();
	}
	
	public User_category[] listUser_category() {
		java.util.List list = super.list();
		return (User_category[]) list.toArray(new User_category[list.size()]);
	}
}


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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Group_detailCriteria extends AbstractORMCriteria {
	public final IntegerExpression group_detail_id;
	public final StringExpression group_name;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression group_user;
	public final CollectionExpression group_right;
	
	public Group_detailCriteria(Criteria criteria) {
		super(criteria);
		group_detail_id = new IntegerExpression("group_detail_id", this);
		group_name = new StringExpression("group_name", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		group_user = new CollectionExpression("group_user", this);
		group_right = new CollectionExpression("group_right", this);
	}
	
	public Group_detailCriteria(PersistentSession session) {
		this(session.createCriteria(Group_detail.class));
	}
	
	public Group_detailCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public Group_userCriteria createGroup_userCriteria() {
		return new Group_userCriteria(createCriteria("group_user"));
	}
	
	public Group_rightCriteria createGroup_rightCriteria() {
		return new Group_rightCriteria(createCriteria("group_right"));
	}
	
	public Group_detail uniqueGroup_detail() {
		return (Group_detail) super.uniqueResult();
	}
	
	public Group_detail[] listGroup_detail() {
		java.util.List list = super.list();
		return (Group_detail[]) list.toArray(new Group_detail[list.size()]);
	}
}


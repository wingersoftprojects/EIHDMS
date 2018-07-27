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

public class User_detailCriteria extends AbstractORMCriteria {
	public final IntegerExpression user_detail_id;
	public final StringExpression user_name;
	public final StringExpression user_password;
	public final StringExpression first_name;
	public final StringExpression second_name;
	public final StringExpression third_name;
	public final BlobExpression user_image;
	public final IntegerExpression user_categoryId;
	public final AssociationExpression user_category;
	public final IntegerExpression is_user_gen_admin;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final IntegerExpression organisationId;
	public final AssociationExpression organisation;
	public final CollectionExpression group_user;
	public final CollectionExpression login_session;
	public final CollectionExpression user_action;
	public final CollectionExpression access_scope;
	
	public User_detailCriteria(Criteria criteria) {
		super(criteria);
		user_detail_id = new IntegerExpression("user_detail_id", this);
		user_name = new StringExpression("user_name", this);
		user_password = new StringExpression("user_password", this);
		first_name = new StringExpression("first_name", this);
		second_name = new StringExpression("second_name", this);
		third_name = new StringExpression("third_name", this);
		user_image = new BlobExpression("user_image", this);
		user_categoryId = new IntegerExpression("user_category.user_category_id", this);
		user_category = new AssociationExpression("user_category", this);
		is_user_gen_admin = new IntegerExpression("is_user_gen_admin", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		organisationId = new IntegerExpression("organisation.organisation_id", this);
		organisation = new AssociationExpression("organisation", this);
		group_user = new CollectionExpression("group_user", this);
		login_session = new CollectionExpression("login_session", this);
		user_action = new CollectionExpression("user_action", this);
		access_scope = new CollectionExpression("access_scope", this);
	}
	
	public User_detailCriteria(PersistentSession session) {
		this(session.createCriteria(User_detail.class));
	}
	
	public User_detailCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public User_categoryCriteria createUser_categoryCriteria() {
		return new User_categoryCriteria(createCriteria("user_category"));
	}
	
	public OrganisationCriteria createOrganisationCriteria() {
		return new OrganisationCriteria(createCriteria("organisation"));
	}
	
	public Group_userCriteria createGroup_userCriteria() {
		return new Group_userCriteria(createCriteria("group_user"));
	}
	
	public Login_sessionCriteria createLogin_sessionCriteria() {
		return new Login_sessionCriteria(createCriteria("login_session"));
	}
	
	public User_actionCriteria createUser_actionCriteria() {
		return new User_actionCriteria(createCriteria("user_action"));
	}
	
	public Access_scopeCriteria createAccess_scopeCriteria() {
		return new Access_scopeCriteria(createCriteria("access_scope"));
	}
	
	public User_detail uniqueUser_detail() {
		return (User_detail) super.uniqueResult();
	}
	
	public User_detail[] listUser_detail() {
		java.util.List list = super.list();
		return (User_detail[]) list.toArray(new User_detail[list.size()]);
	}
}


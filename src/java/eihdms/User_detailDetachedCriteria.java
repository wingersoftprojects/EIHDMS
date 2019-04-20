/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Wence
 * License Type: Purchased
 */
package eihdms;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class User_detailDetachedCriteria extends AbstractORMDetachedCriteria {
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
	public final StringExpression email_address;
	public final CollectionExpression group_user;
	public final CollectionExpression login_session;
	public final CollectionExpression user_action;
	public final CollectionExpression access_scope;
	public final CollectionExpression forgotPassword;
	
	public User_detailDetachedCriteria() {
		super(eihdms.User_detail.class, eihdms.User_detailCriteria.class);
		user_detail_id = new IntegerExpression("user_detail_id", this.getDetachedCriteria());
		user_name = new StringExpression("user_name", this.getDetachedCriteria());
		user_password = new StringExpression("user_password", this.getDetachedCriteria());
		first_name = new StringExpression("first_name", this.getDetachedCriteria());
		second_name = new StringExpression("second_name", this.getDetachedCriteria());
		third_name = new StringExpression("third_name", this.getDetachedCriteria());
		user_image = new BlobExpression("user_image", this.getDetachedCriteria());
		user_categoryId = new IntegerExpression("user_category.user_category_id", this.getDetachedCriteria());
		user_category = new AssociationExpression("user_category", this.getDetachedCriteria());
		is_user_gen_admin = new IntegerExpression("is_user_gen_admin", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		organisationId = new IntegerExpression("organisation.organisation_id", this.getDetachedCriteria());
		organisation = new AssociationExpression("organisation", this.getDetachedCriteria());
		email_address = new StringExpression("email_address", this.getDetachedCriteria());
		group_user = new CollectionExpression("group_user", this.getDetachedCriteria());
		login_session = new CollectionExpression("login_session", this.getDetachedCriteria());
		user_action = new CollectionExpression("user_action", this.getDetachedCriteria());
		access_scope = new CollectionExpression("access_scope", this.getDetachedCriteria());
		forgotPassword = new CollectionExpression("forgotPassword", this.getDetachedCriteria());
	}
	
	public User_detailDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.User_detailCriteria.class);
		user_detail_id = new IntegerExpression("user_detail_id", this.getDetachedCriteria());
		user_name = new StringExpression("user_name", this.getDetachedCriteria());
		user_password = new StringExpression("user_password", this.getDetachedCriteria());
		first_name = new StringExpression("first_name", this.getDetachedCriteria());
		second_name = new StringExpression("second_name", this.getDetachedCriteria());
		third_name = new StringExpression("third_name", this.getDetachedCriteria());
		user_image = new BlobExpression("user_image", this.getDetachedCriteria());
		user_categoryId = new IntegerExpression("user_category.user_category_id", this.getDetachedCriteria());
		user_category = new AssociationExpression("user_category", this.getDetachedCriteria());
		is_user_gen_admin = new IntegerExpression("is_user_gen_admin", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		organisationId = new IntegerExpression("organisation.organisation_id", this.getDetachedCriteria());
		organisation = new AssociationExpression("organisation", this.getDetachedCriteria());
		email_address = new StringExpression("email_address", this.getDetachedCriteria());
		group_user = new CollectionExpression("group_user", this.getDetachedCriteria());
		login_session = new CollectionExpression("login_session", this.getDetachedCriteria());
		user_action = new CollectionExpression("user_action", this.getDetachedCriteria());
		access_scope = new CollectionExpression("access_scope", this.getDetachedCriteria());
		forgotPassword = new CollectionExpression("forgotPassword", this.getDetachedCriteria());
	}
	
	public User_categoryDetachedCriteria createUser_categoryCriteria() {
		return new User_categoryDetachedCriteria(createCriteria("user_category"));
	}
	
	public OrganisationDetachedCriteria createOrganisationCriteria() {
		return new OrganisationDetachedCriteria(createCriteria("organisation"));
	}
	
	public Group_userDetachedCriteria createGroup_userCriteria() {
		return new Group_userDetachedCriteria(createCriteria("group_user"));
	}
	
	public Login_sessionDetachedCriteria createLogin_sessionCriteria() {
		return new Login_sessionDetachedCriteria(createCriteria("login_session"));
	}
	
	public User_actionDetachedCriteria createUser_actionCriteria() {
		return new User_actionDetachedCriteria(createCriteria("user_action"));
	}
	
	public Access_scopeDetachedCriteria createAccess_scopeCriteria() {
		return new Access_scopeDetachedCriteria(createCriteria("access_scope"));
	}
	
	public ForgotPasswordDetachedCriteria createForgotPasswordCriteria() {
		return new ForgotPasswordDetachedCriteria(createCriteria("forgotPassword"));
	}
	
	public User_detail uniqueUser_detail(PersistentSession session) {
		return (User_detail) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public User_detail[] listUser_detail(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (User_detail[]) list.toArray(new User_detail[list.size()]);
	}
}


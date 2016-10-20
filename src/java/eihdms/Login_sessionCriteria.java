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

public class Login_sessionCriteria extends AbstractORMCriteria {
	public final IntegerExpression login_session_id;
	public final IntegerExpression user_detailId;
	public final AssociationExpression user_detail;
	public final StringExpression session_id;
	public final StringExpression remote_ip;
	public final StringExpression remote_host;
	public final StringExpression remote_user;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Login_sessionCriteria(Criteria criteria) {
		super(criteria);
		login_session_id = new IntegerExpression("login_session_id", this);
		user_detailId = new IntegerExpression("user_detail.user_detail_id", this);
		user_detail = new AssociationExpression("user_detail", this);
		session_id = new StringExpression("session_id", this);
		remote_ip = new StringExpression("remote_ip", this);
		remote_host = new StringExpression("remote_host", this);
		remote_user = new StringExpression("remote_user", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Login_sessionCriteria(PersistentSession session) {
		this(session.createCriteria(Login_session.class));
	}
	
	public Login_sessionCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public User_detailCriteria createUser_detailCriteria() {
		return new User_detailCriteria(createCriteria("user_detail"));
	}
	
	public Login_session uniqueLogin_session() {
		return (Login_session) super.uniqueResult();
	}
	
	public Login_session[] listLogin_session() {
		java.util.List list = super.list();
		return (Login_session[]) list.toArray(new Login_session[list.size()]);
	}
}


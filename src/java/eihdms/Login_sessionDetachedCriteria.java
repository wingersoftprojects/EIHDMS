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

public class Login_sessionDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public Login_sessionDetachedCriteria() {
		super(eihdms.Login_session.class, eihdms.Login_sessionCriteria.class);
		login_session_id = new IntegerExpression("login_session_id", this.getDetachedCriteria());
		user_detailId = new IntegerExpression("user_detail.user_detail_id", this.getDetachedCriteria());
		user_detail = new AssociationExpression("user_detail", this.getDetachedCriteria());
		session_id = new StringExpression("session_id", this.getDetachedCriteria());
		remote_ip = new StringExpression("remote_ip", this.getDetachedCriteria());
		remote_host = new StringExpression("remote_host", this.getDetachedCriteria());
		remote_user = new StringExpression("remote_user", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Login_sessionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Login_sessionCriteria.class);
		login_session_id = new IntegerExpression("login_session_id", this.getDetachedCriteria());
		user_detailId = new IntegerExpression("user_detail.user_detail_id", this.getDetachedCriteria());
		user_detail = new AssociationExpression("user_detail", this.getDetachedCriteria());
		session_id = new StringExpression("session_id", this.getDetachedCriteria());
		remote_ip = new StringExpression("remote_ip", this.getDetachedCriteria());
		remote_host = new StringExpression("remote_host", this.getDetachedCriteria());
		remote_user = new StringExpression("remote_user", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public User_detailDetachedCriteria createUser_detailCriteria() {
		return new User_detailDetachedCriteria(createCriteria("user_detail"));
	}
	
	public Login_session uniqueLogin_session(PersistentSession session) {
		return (Login_session) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Login_session[] listLogin_session(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Login_session[]) list.toArray(new Login_session[list.size()]);
	}
}


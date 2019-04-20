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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ForgotPasswordCriteria extends AbstractORMCriteria {
	public final IntegerExpression forgot_password_id;
	public final TimestampExpression expirydate;
	public final IntegerExpression code;
	public final IntegerExpression user_detailId;
	public final AssociationExpression user_detail;
	
	public ForgotPasswordCriteria(Criteria criteria) {
		super(criteria);
		forgot_password_id = new IntegerExpression("forgot_password_id", this);
		expirydate = new TimestampExpression("expirydate", this);
		code = new IntegerExpression("code", this);
		user_detailId = new IntegerExpression("user_detail.user_detail_id", this);
		user_detail = new AssociationExpression("user_detail", this);
	}
	
	public ForgotPasswordCriteria(PersistentSession session) {
		this(session.createCriteria(ForgotPassword.class));
	}
	
	public ForgotPasswordCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public User_detailCriteria createUser_detailCriteria() {
		return new User_detailCriteria(createCriteria("user_detail"));
	}
	
	public ForgotPassword uniqueForgotPassword() {
		return (ForgotPassword) super.uniqueResult();
	}
	
	public ForgotPassword[] listForgotPassword() {
		java.util.List list = super.list();
		return (ForgotPassword[]) list.toArray(new ForgotPassword[list.size()]);
	}
}


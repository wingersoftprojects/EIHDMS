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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ForgotPasswordDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression forgot_password_id;
	public final TimestampExpression expirydate;
	public final IntegerExpression code;
	public final IntegerExpression user_detailId;
	public final AssociationExpression user_detail;
	
	public ForgotPasswordDetachedCriteria() {
		super(eihdms.ForgotPassword.class, eihdms.ForgotPasswordCriteria.class);
		forgot_password_id = new IntegerExpression("forgot_password_id", this.getDetachedCriteria());
		expirydate = new TimestampExpression("expirydate", this.getDetachedCriteria());
		code = new IntegerExpression("code", this.getDetachedCriteria());
		user_detailId = new IntegerExpression("user_detail.user_detail_id", this.getDetachedCriteria());
		user_detail = new AssociationExpression("user_detail", this.getDetachedCriteria());
	}
	
	public ForgotPasswordDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.ForgotPasswordCriteria.class);
		forgot_password_id = new IntegerExpression("forgot_password_id", this.getDetachedCriteria());
		expirydate = new TimestampExpression("expirydate", this.getDetachedCriteria());
		code = new IntegerExpression("code", this.getDetachedCriteria());
		user_detailId = new IntegerExpression("user_detail.user_detail_id", this.getDetachedCriteria());
		user_detail = new AssociationExpression("user_detail", this.getDetachedCriteria());
	}
	
	public User_detailDetachedCriteria createUser_detailCriteria() {
		return new User_detailDetachedCriteria(createCriteria("user_detail"));
	}
	
	public ForgotPassword uniqueForgotPassword(PersistentSession session) {
		return (ForgotPassword) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ForgotPassword[] listForgotPassword(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ForgotPassword[]) list.toArray(new ForgotPassword[list.size()]);
	}
}


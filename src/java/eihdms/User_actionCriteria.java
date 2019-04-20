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

public class User_actionCriteria extends AbstractORMCriteria {
	public final IntegerExpression user_action_id;
	public final IntegerExpression user_detailId;
	public final AssociationExpression user_detail;
	public final IntegerExpression form_templateId;
	public final AssociationExpression form_template;
	public final StringExpression action;
	public final TimestampExpression action_date;
	
	public User_actionCriteria(Criteria criteria) {
		super(criteria);
		user_action_id = new IntegerExpression("user_action_id", this);
		user_detailId = new IntegerExpression("user_detail.user_detail_id", this);
		user_detail = new AssociationExpression("user_detail", this);
		form_templateId = new IntegerExpression("form_template.report_form_id", this);
		form_template = new AssociationExpression("form_template", this);
		action = new StringExpression("action", this);
		action_date = new TimestampExpression("action_date", this);
	}
	
	public User_actionCriteria(PersistentSession session) {
		this(session.createCriteria(User_action.class));
	}
	
	public User_actionCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public User_detailCriteria createUser_detailCriteria() {
		return new User_detailCriteria(createCriteria("user_detail"));
	}
	
	public Report_formCriteria createForm_templateCriteria() {
		return new Report_formCriteria(createCriteria("form_template"));
	}
	
	public User_action uniqueUser_action() {
		return (User_action) super.uniqueResult();
	}
	
	public User_action[] listUser_action() {
		java.util.List list = super.list();
		return (User_action[]) list.toArray(new User_action[list.size()]);
	}
}


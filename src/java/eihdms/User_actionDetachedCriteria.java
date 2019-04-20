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

public class User_actionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression user_action_id;
	public final IntegerExpression user_detailId;
	public final AssociationExpression user_detail;
	public final IntegerExpression form_templateId;
	public final AssociationExpression form_template;
	public final StringExpression action;
	public final TimestampExpression action_date;
	
	public User_actionDetachedCriteria() {
		super(eihdms.User_action.class, eihdms.User_actionCriteria.class);
		user_action_id = new IntegerExpression("user_action_id", this.getDetachedCriteria());
		user_detailId = new IntegerExpression("user_detail.user_detail_id", this.getDetachedCriteria());
		user_detail = new AssociationExpression("user_detail", this.getDetachedCriteria());
		form_templateId = new IntegerExpression("form_template.report_form_id", this.getDetachedCriteria());
		form_template = new AssociationExpression("form_template", this.getDetachedCriteria());
		action = new StringExpression("action", this.getDetachedCriteria());
		action_date = new TimestampExpression("action_date", this.getDetachedCriteria());
	}
	
	public User_actionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.User_actionCriteria.class);
		user_action_id = new IntegerExpression("user_action_id", this.getDetachedCriteria());
		user_detailId = new IntegerExpression("user_detail.user_detail_id", this.getDetachedCriteria());
		user_detail = new AssociationExpression("user_detail", this.getDetachedCriteria());
		form_templateId = new IntegerExpression("form_template.report_form_id", this.getDetachedCriteria());
		form_template = new AssociationExpression("form_template", this.getDetachedCriteria());
		action = new StringExpression("action", this.getDetachedCriteria());
		action_date = new TimestampExpression("action_date", this.getDetachedCriteria());
	}
	
	public User_detailDetachedCriteria createUser_detailCriteria() {
		return new User_detailDetachedCriteria(createCriteria("user_detail"));
	}
	
	public Report_formDetachedCriteria createForm_templateCriteria() {
		return new Report_formDetachedCriteria(createCriteria("form_template"));
	}
	
	public User_action uniqueUser_action(PersistentSession session) {
		return (User_action) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public User_action[] listUser_action(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (User_action[]) list.toArray(new User_action[list.size()]);
	}
}


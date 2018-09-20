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

public class Sms_categoryCriteria extends AbstractORMCriteria {
	public final IntegerExpression sms_category_id;
	public final StringExpression sms_category_name;
	public final StringExpression sms_category_desc;
	public final StringExpression data_entry_scope;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Sms_categoryCriteria(Criteria criteria) {
		super(criteria);
		sms_category_id = new IntegerExpression("sms_category_id", this);
		sms_category_name = new StringExpression("sms_category_name", this);
		sms_category_desc = new StringExpression("sms_category_desc", this);
		data_entry_scope = new StringExpression("data_entry_scope", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Sms_categoryCriteria(PersistentSession session) {
		this(session.createCriteria(Sms_category.class));
	}
	
	public Sms_categoryCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Sms_category uniqueSms_category() {
		return (Sms_category) super.uniqueResult();
	}
	
	public Sms_category[] listSms_category() {
		java.util.List list = super.list();
		return (Sms_category[]) list.toArray(new Sms_category[list.size()]);
	}
}


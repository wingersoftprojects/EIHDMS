/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: wence.twesigye
 * License Type: Purchased
 */
package eihdms;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Phone_contactCriteria extends AbstractORMCriteria {
	public final IntegerExpression phone_contact_id;
	public final StringExpression entity_type;
	public final IntegerExpression entity_id;
	public final StringExpression entity_phone;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Phone_contactCriteria(Criteria criteria) {
		super(criteria);
		phone_contact_id = new IntegerExpression("phone_contact_id", this);
		entity_type = new StringExpression("entity_type", this);
		entity_id = new IntegerExpression("entity_id", this);
		entity_phone = new StringExpression("entity_phone", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Phone_contactCriteria(PersistentSession session) {
		this(session.createCriteria(Phone_contact.class));
	}
	
	public Phone_contactCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Phone_contact uniquePhone_contact() {
		return (Phone_contact) super.uniqueResult();
	}
	
	public Phone_contact[] listPhone_contact() {
		java.util.List list = super.list();
		return (Phone_contact[]) list.toArray(new Phone_contact[list.size()]);
	}
}


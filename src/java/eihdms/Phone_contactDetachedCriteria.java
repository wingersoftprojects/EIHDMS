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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Phone_contactDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public Phone_contactDetachedCriteria() {
		super(eihdms.Phone_contact.class, eihdms.Phone_contactCriteria.class);
		phone_contact_id = new IntegerExpression("phone_contact_id", this.getDetachedCriteria());
		entity_type = new StringExpression("entity_type", this.getDetachedCriteria());
		entity_id = new IntegerExpression("entity_id", this.getDetachedCriteria());
		entity_phone = new StringExpression("entity_phone", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Phone_contactDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Phone_contactCriteria.class);
		phone_contact_id = new IntegerExpression("phone_contact_id", this.getDetachedCriteria());
		entity_type = new StringExpression("entity_type", this.getDetachedCriteria());
		entity_id = new IntegerExpression("entity_id", this.getDetachedCriteria());
		entity_phone = new StringExpression("entity_phone", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Phone_contact uniquePhone_contact(PersistentSession session) {
		return (Phone_contact) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Phone_contact[] listPhone_contact(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Phone_contact[]) list.toArray(new Phone_contact[list.size()]);
	}
}


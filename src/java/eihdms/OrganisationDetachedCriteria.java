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

public class OrganisationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression organisation_id;
	public final StringExpression organisation_name;
	public final IntegerExpression is_active;
	public final IntegerExpression is_deleted;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression user_detail;
	
	public OrganisationDetachedCriteria() {
		super(eihdms.Organisation.class, eihdms.OrganisationCriteria.class);
		organisation_id = new IntegerExpression("organisation_id", this.getDetachedCriteria());
		organisation_name = new StringExpression("organisation_name", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		user_detail = new CollectionExpression("user_detail", this.getDetachedCriteria());
	}
	
	public OrganisationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.OrganisationCriteria.class);
		organisation_id = new IntegerExpression("organisation_id", this.getDetachedCriteria());
		organisation_name = new StringExpression("organisation_name", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		user_detail = new CollectionExpression("user_detail", this.getDetachedCriteria());
	}
	
	public User_detailDetachedCriteria createUser_detailCriteria() {
		return new User_detailDetachedCriteria(createCriteria("user_detail"));
	}
	
	public Organisation uniqueOrganisation(PersistentSession session) {
		return (Organisation) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Organisation[] listOrganisation(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Organisation[]) list.toArray(new Organisation[list.size()]);
	}
}


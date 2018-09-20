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

public class OrganisationCriteria extends AbstractORMCriteria {
	public final IntegerExpression organisation_id;
	public final StringExpression organisation_name;
	public final IntegerExpression is_active;
	public final IntegerExpression is_deleted;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression user_detail;
	
	public OrganisationCriteria(Criteria criteria) {
		super(criteria);
		organisation_id = new IntegerExpression("organisation_id", this);
		organisation_name = new StringExpression("organisation_name", this);
		is_active = new IntegerExpression("is_active", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		user_detail = new CollectionExpression("user_detail", this);
	}
	
	public OrganisationCriteria(PersistentSession session) {
		this(session.createCriteria(Organisation.class));
	}
	
	public OrganisationCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public User_detailCriteria createUser_detailCriteria() {
		return new User_detailCriteria(createCriteria("user_detail"));
	}
	
	public Organisation uniqueOrganisation() {
		return (Organisation) super.uniqueResult();
	}
	
	public Organisation[] listOrganisation() {
		java.util.List list = super.list();
		return (Organisation[]) list.toArray(new Organisation[list.size()]);
	}
}


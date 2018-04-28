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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Report_form_entityCriteria extends AbstractORMCriteria {
	public final IntegerExpression report_form_entity_id;
	public final IntegerExpression report_formId;
	public final AssociationExpression report_form;
	public final StringExpression entity_type;
	public final IntegerExpression entity_id;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Report_form_entityCriteria(Criteria criteria) {
		super(criteria);
		report_form_entity_id = new IntegerExpression("report_form_entity_id", this);
		report_formId = new IntegerExpression("report_form.report_form_id", this);
		report_form = new AssociationExpression("report_form", this);
		entity_type = new StringExpression("entity_type", this);
		entity_id = new IntegerExpression("entity_id", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Report_form_entityCriteria(PersistentSession session) {
		this(session.createCriteria(Report_form_entity.class));
	}
	
	public Report_form_entityCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Report_formCriteria createReport_formCriteria() {
		return new Report_formCriteria(createCriteria("report_form"));
	}
	
	public Report_form_entity uniqueReport_form_entity() {
		return (Report_form_entity) super.uniqueResult();
	}
	
	public Report_form_entity[] listReport_form_entity() {
		java.util.List list = super.list();
		return (Report_form_entity[]) list.toArray(new Report_form_entity[list.size()]);
	}
}


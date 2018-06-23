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

public class Report_form_entityDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public Report_form_entityDetachedCriteria() {
		super(eihdms.Report_form_entity.class, eihdms.Report_form_entityCriteria.class);
		report_form_entity_id = new IntegerExpression("report_form_entity_id", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		entity_type = new StringExpression("entity_type", this.getDetachedCriteria());
		entity_id = new IntegerExpression("entity_id", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Report_form_entityDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Report_form_entityCriteria.class);
		report_form_entity_id = new IntegerExpression("report_form_entity_id", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		entity_type = new StringExpression("entity_type", this.getDetachedCriteria());
		entity_id = new IntegerExpression("entity_id", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Report_formDetachedCriteria createReport_formCriteria() {
		return new Report_formDetachedCriteria(createCriteria("report_form"));
	}
	
	public Report_form_entity uniqueReport_form_entity(PersistentSession session) {
		return (Report_form_entity) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Report_form_entity[] listReport_form_entity(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Report_form_entity[]) list.toArray(new Report_form_entity[list.size()]);
	}
}


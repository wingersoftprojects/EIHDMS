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
	
	public Report_form_entityDetachedCriteria() {
		super(eihdms.Report_form_entity.class, eihdms.Report_form_entityCriteria.class);
		report_form_entity_id = new IntegerExpression("report_form_entity_id", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		entity_type = new StringExpression("entity_type", this.getDetachedCriteria());
		entity_id = new IntegerExpression("entity_id", this.getDetachedCriteria());
	}
	
	public Report_form_entityDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Report_form_entityCriteria.class);
		report_form_entity_id = new IntegerExpression("report_form_entity_id", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		entity_type = new StringExpression("entity_type", this.getDetachedCriteria());
		entity_id = new IntegerExpression("entity_id", this.getDetachedCriteria());
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


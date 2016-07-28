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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Validation_tempDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression validation_temp_id;
	public final IntegerExpression report_formId;
	public final AssociationExpression report_form;
	public final IntegerExpression report_form_groupId;
	public final AssociationExpression report_form_group;
	public final StringExpression validation_temp_name;
	public final StringExpression formula;
	public final IntegerExpression aId;
	public final AssociationExpression a;
	public final IntegerExpression bId;
	public final AssociationExpression b;
	public final IntegerExpression cId;
	public final AssociationExpression c;
	public final IntegerExpression dId;
	public final AssociationExpression d;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Validation_tempDetachedCriteria() {
		super(eihdms.Validation_temp.class, eihdms.Validation_tempCriteria.class);
		validation_temp_id = new IntegerExpression("validation_temp_id", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		report_form_groupId = new IntegerExpression("report_form_group.report_form_group_id", this.getDetachedCriteria());
		report_form_group = new AssociationExpression("report_form_group", this.getDetachedCriteria());
		validation_temp_name = new StringExpression("validation_temp_name", this.getDetachedCriteria());
		formula = new StringExpression("formula", this.getDetachedCriteria());
		aId = new IntegerExpression("a.data_element_id", this.getDetachedCriteria());
		a = new AssociationExpression("a", this.getDetachedCriteria());
		bId = new IntegerExpression("b.data_element_id", this.getDetachedCriteria());
		b = new AssociationExpression("b", this.getDetachedCriteria());
		cId = new IntegerExpression("c.data_element_id", this.getDetachedCriteria());
		c = new AssociationExpression("c", this.getDetachedCriteria());
		dId = new IntegerExpression("d.data_element_id", this.getDetachedCriteria());
		d = new AssociationExpression("d", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Validation_tempDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Validation_tempCriteria.class);
		validation_temp_id = new IntegerExpression("validation_temp_id", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		report_form_groupId = new IntegerExpression("report_form_group.report_form_group_id", this.getDetachedCriteria());
		report_form_group = new AssociationExpression("report_form_group", this.getDetachedCriteria());
		validation_temp_name = new StringExpression("validation_temp_name", this.getDetachedCriteria());
		formula = new StringExpression("formula", this.getDetachedCriteria());
		aId = new IntegerExpression("a.data_element_id", this.getDetachedCriteria());
		a = new AssociationExpression("a", this.getDetachedCriteria());
		bId = new IntegerExpression("b.data_element_id", this.getDetachedCriteria());
		b = new AssociationExpression("b", this.getDetachedCriteria());
		cId = new IntegerExpression("c.data_element_id", this.getDetachedCriteria());
		c = new AssociationExpression("c", this.getDetachedCriteria());
		dId = new IntegerExpression("d.data_element_id", this.getDetachedCriteria());
		d = new AssociationExpression("d", this.getDetachedCriteria());
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
	
	public Report_form_groupDetachedCriteria createReport_form_groupCriteria() {
		return new Report_form_groupDetachedCriteria(createCriteria("report_form_group"));
	}
	
	public Data_elementDetachedCriteria createACriteria() {
		return new Data_elementDetachedCriteria(createCriteria("a"));
	}
	
	public Data_elementDetachedCriteria createBCriteria() {
		return new Data_elementDetachedCriteria(createCriteria("b"));
	}
	
	public Data_elementDetachedCriteria createCCriteria() {
		return new Data_elementDetachedCriteria(createCriteria("c"));
	}
	
	public Data_elementDetachedCriteria createDCriteria() {
		return new Data_elementDetachedCriteria(createCriteria("d"));
	}
	
	public Validation_temp uniqueValidation_temp(PersistentSession session) {
		return (Validation_temp) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Validation_temp[] listValidation_temp(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Validation_temp[]) list.toArray(new Validation_temp[list.size()]);
	}
}


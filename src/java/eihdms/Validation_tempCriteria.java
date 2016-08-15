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

public class Validation_tempCriteria extends AbstractORMCriteria {
	public final IntegerExpression validation_temp_id;
	public final IntegerExpression report_formId;
	public final AssociationExpression report_form;
	public final IntegerExpression report_form_groupId;
	public final AssociationExpression report_form_group;
	public final StringExpression validation_temp_name;
	public final StringExpression valifation_temp_formula;
	public final StringExpression data_elements_involved;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Validation_tempCriteria(Criteria criteria) {
		super(criteria);
		validation_temp_id = new IntegerExpression("validation_temp_id", this);
		report_formId = new IntegerExpression("report_form.report_form_id", this);
		report_form = new AssociationExpression("report_form", this);
		report_form_groupId = new IntegerExpression("report_form_group.report_form_group_id", this);
		report_form_group = new AssociationExpression("report_form_group", this);
		validation_temp_name = new StringExpression("validation_temp_name", this);
		valifation_temp_formula = new StringExpression("valifation_temp_formula", this);
		data_elements_involved = new StringExpression("data_elements_involved", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Validation_tempCriteria(PersistentSession session) {
		this(session.createCriteria(Validation_temp.class));
	}
	
	public Validation_tempCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public Report_formCriteria createReport_formCriteria() {
		return new Report_formCriteria(createCriteria("report_form"));
	}
	
	public Report_form_groupCriteria createReport_form_groupCriteria() {
		return new Report_form_groupCriteria(createCriteria("report_form_group"));
	}
	
	public Validation_temp uniqueValidation_temp() {
		return (Validation_temp) super.uniqueResult();
	}
	
	public Validation_temp[] listValidation_temp() {
		java.util.List list = super.list();
		return (Validation_temp[]) list.toArray(new Validation_temp[list.size()]);
	}
}


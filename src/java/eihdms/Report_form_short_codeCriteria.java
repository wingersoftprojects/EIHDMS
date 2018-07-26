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

public class Report_form_short_codeCriteria extends AbstractORMCriteria {
	public final IntegerExpression report_form_short_code_id;
	public final StringExpression start_code;
	public final IntegerExpression number_of_separators;
	public final StringExpression short_code;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final IntegerExpression report_formId;
	public final AssociationExpression report_form;
	public final CollectionExpression data_element_sms_position;
	
	public Report_form_short_codeCriteria(Criteria criteria) {
		super(criteria);
		report_form_short_code_id = new IntegerExpression("report_form_short_code_id", this);
		start_code = new StringExpression("start_code", this);
		number_of_separators = new IntegerExpression("number_of_separators", this);
		short_code = new StringExpression("short_code", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		report_formId = new IntegerExpression("report_form.report_form_id", this);
		report_form = new AssociationExpression("report_form", this);
		data_element_sms_position = new CollectionExpression("data_element_sms_position", this);
	}
	
	public Report_form_short_codeCriteria(PersistentSession session) {
		this(session.createCriteria(Report_form_short_code.class));
	}
	
	public Report_form_short_codeCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Report_formCriteria createReport_formCriteria() {
		return new Report_formCriteria(createCriteria("report_form"));
	}
	
	public Data_element_sms_positionCriteria createData_element_sms_positionCriteria() {
		return new Data_element_sms_positionCriteria(createCriteria("data_element_sms_position"));
	}
	
	public Report_form_short_code uniqueReport_form_short_code() {
		return (Report_form_short_code) super.uniqueResult();
	}
	
	public Report_form_short_code[] listReport_form_short_code() {
		java.util.List list = super.list();
		return (Report_form_short_code[]) list.toArray(new Report_form_short_code[list.size()]);
	}
}


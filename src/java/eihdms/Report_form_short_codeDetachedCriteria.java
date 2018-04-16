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

public class Report_form_short_codeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression report_form_short_code_id;
	public final StringExpression start_code;
	public final IntegerExpression seperators;
	public final StringExpression short_code;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression data_element_sms_position;
	
	public Report_form_short_codeDetachedCriteria() {
		super(eihdms.Report_form_short_code.class, eihdms.Report_form_short_codeCriteria.class);
		report_form_short_code_id = new IntegerExpression("report_form_short_code_id", this.getDetachedCriteria());
		start_code = new StringExpression("start_code", this.getDetachedCriteria());
		seperators = new IntegerExpression("seperators", this.getDetachedCriteria());
		short_code = new StringExpression("short_code", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		data_element_sms_position = new CollectionExpression("data_element_sms_position", this.getDetachedCriteria());
	}
	
	public Report_form_short_codeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Report_form_short_codeCriteria.class);
		report_form_short_code_id = new IntegerExpression("report_form_short_code_id", this.getDetachedCriteria());
		start_code = new StringExpression("start_code", this.getDetachedCriteria());
		seperators = new IntegerExpression("seperators", this.getDetachedCriteria());
		short_code = new StringExpression("short_code", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		data_element_sms_position = new CollectionExpression("data_element_sms_position", this.getDetachedCriteria());
	}
	
	public Data_element_sms_positionDetachedCriteria createData_element_sms_positionCriteria() {
		return new Data_element_sms_positionDetachedCriteria(createCriteria("data_element_sms_position"));
	}
	
	public Report_form_short_code uniqueReport_form_short_code(PersistentSession session) {
		return (Report_form_short_code) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Report_form_short_code[] listReport_form_short_code(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Report_form_short_code[]) list.toArray(new Report_form_short_code[list.size()]);
	}
}


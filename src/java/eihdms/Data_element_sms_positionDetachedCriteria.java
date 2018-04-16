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

public class Data_element_sms_positionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression data_element_sms_position_id;
	public final IntegerExpression data_elementId;
	public final AssociationExpression data_element;
	public final IntegerExpression value_position;
	public final IntegerExpression code_position;
	public final IntegerExpression report_form_short_codeId;
	public final AssociationExpression report_form_short_code;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Data_element_sms_positionDetachedCriteria() {
		super(eihdms.Data_element_sms_position.class, eihdms.Data_element_sms_positionCriteria.class);
		data_element_sms_position_id = new IntegerExpression("data_element_sms_position_id", this.getDetachedCriteria());
		data_elementId = new IntegerExpression("data_element.data_element_id", this.getDetachedCriteria());
		data_element = new AssociationExpression("data_element", this.getDetachedCriteria());
		value_position = new IntegerExpression("value_position", this.getDetachedCriteria());
		code_position = new IntegerExpression("code_position", this.getDetachedCriteria());
		report_form_short_codeId = new IntegerExpression("report_form_short_code.report_form_short_code_id", this.getDetachedCriteria());
		report_form_short_code = new AssociationExpression("report_form_short_code", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Data_element_sms_positionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Data_element_sms_positionCriteria.class);
		data_element_sms_position_id = new IntegerExpression("data_element_sms_position_id", this.getDetachedCriteria());
		data_elementId = new IntegerExpression("data_element.data_element_id", this.getDetachedCriteria());
		data_element = new AssociationExpression("data_element", this.getDetachedCriteria());
		value_position = new IntegerExpression("value_position", this.getDetachedCriteria());
		code_position = new IntegerExpression("code_position", this.getDetachedCriteria());
		report_form_short_codeId = new IntegerExpression("report_form_short_code.report_form_short_code_id", this.getDetachedCriteria());
		report_form_short_code = new AssociationExpression("report_form_short_code", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Data_elementDetachedCriteria createData_elementCriteria() {
		return new Data_elementDetachedCriteria(createCriteria("data_element"));
	}
	
	public Report_form_short_codeDetachedCriteria createReport_form_short_codeCriteria() {
		return new Report_form_short_codeDetachedCriteria(createCriteria("report_form_short_code"));
	}
	
	public Data_element_sms_position uniqueData_element_sms_position(PersistentSession session) {
		return (Data_element_sms_position) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Data_element_sms_position[] listData_element_sms_position(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Data_element_sms_position[]) list.toArray(new Data_element_sms_position[list.size()]);
	}
}


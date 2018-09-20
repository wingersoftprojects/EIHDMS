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

public class Data_element_sms_positionCriteria extends AbstractORMCriteria {
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
	
	public Data_element_sms_positionCriteria(Criteria criteria) {
		super(criteria);
		data_element_sms_position_id = new IntegerExpression("data_element_sms_position_id", this);
		data_elementId = new IntegerExpression("data_element.data_element_id", this);
		data_element = new AssociationExpression("data_element", this);
		value_position = new IntegerExpression("value_position", this);
		code_position = new IntegerExpression("code_position", this);
		report_form_short_codeId = new IntegerExpression("report_form_short_code.report_form_short_code_id", this);
		report_form_short_code = new AssociationExpression("report_form_short_code", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Data_element_sms_positionCriteria(PersistentSession session) {
		this(session.createCriteria(Data_element_sms_position.class));
	}
	
	public Data_element_sms_positionCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Data_elementCriteria createData_elementCriteria() {
		return new Data_elementCriteria(createCriteria("data_element"));
	}
	
	public Report_form_short_codeCriteria createReport_form_short_codeCriteria() {
		return new Report_form_short_codeCriteria(createCriteria("report_form_short_code"));
	}
	
	public Data_element_sms_position uniqueData_element_sms_position() {
		return (Data_element_sms_position) super.uniqueResult();
	}
	
	public Data_element_sms_position[] listData_element_sms_position() {
		java.util.List list = super.list();
		return (Data_element_sms_position[]) list.toArray(new Data_element_sms_position[list.size()]);
	}
}


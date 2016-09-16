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

public class Temp_data_elementCriteria extends AbstractORMCriteria {
	public final IntegerExpression temp_data_element_id;
	public final StringExpression report_form_name;
	public final StringExpression section_name;
	public final StringExpression sub_section_name;
	public final StringExpression report_form_group_name;
	public final IntegerExpression section_column_number;
	public final IntegerExpression group_column_number;
	public final StringExpression data_element_name;
	public final StringExpression data_type;
	public final IntegerExpression data_size;
	public final StringExpression age_category;
	public final StringExpression sex_category;
	public final StringExpression other_category;
	public final StringExpression technical_area_name;
	public final StringExpression description;
	public final StringExpression data_element_code;
	public final StringExpression data_element_context;
	
	public Temp_data_elementCriteria(Criteria criteria) {
		super(criteria);
		temp_data_element_id = new IntegerExpression("temp_data_element_id", this);
		report_form_name = new StringExpression("report_form_name", this);
		section_name = new StringExpression("section_name", this);
		sub_section_name = new StringExpression("sub_section_name", this);
		report_form_group_name = new StringExpression("report_form_group_name", this);
		section_column_number = new IntegerExpression("section_column_number", this);
		group_column_number = new IntegerExpression("group_column_number", this);
		data_element_name = new StringExpression("data_element_name", this);
		data_type = new StringExpression("data_type", this);
		data_size = new IntegerExpression("data_size", this);
		age_category = new StringExpression("age_category", this);
		sex_category = new StringExpression("sex_category", this);
		other_category = new StringExpression("other_category", this);
		technical_area_name = new StringExpression("technical_area_name", this);
		description = new StringExpression("description", this);
		data_element_code = new StringExpression("data_element_code", this);
		data_element_context = new StringExpression("data_element_context", this);
	}
	
	public Temp_data_elementCriteria(PersistentSession session) {
		this(session.createCriteria(Temp_data_element.class));
	}
	
	public Temp_data_elementCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public Temp_data_element uniqueTemp_data_element() {
		return (Temp_data_element) super.uniqueResult();
	}
	
	public Temp_data_element[] listTemp_data_element() {
		java.util.List list = super.list();
		return (Temp_data_element[]) list.toArray(new Temp_data_element[list.size()]);
	}
}


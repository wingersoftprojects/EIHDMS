/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: btwesigye
 * License Type: Purchased
 */
package eihdms;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Temp_data_elementDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public Temp_data_elementDetachedCriteria() {
		super(eihdms.Temp_data_element.class, eihdms.Temp_data_elementCriteria.class);
		temp_data_element_id = new IntegerExpression("temp_data_element_id", this.getDetachedCriteria());
		report_form_name = new StringExpression("report_form_name", this.getDetachedCriteria());
		section_name = new StringExpression("section_name", this.getDetachedCriteria());
		sub_section_name = new StringExpression("sub_section_name", this.getDetachedCriteria());
		report_form_group_name = new StringExpression("report_form_group_name", this.getDetachedCriteria());
		section_column_number = new IntegerExpression("section_column_number", this.getDetachedCriteria());
		group_column_number = new IntegerExpression("group_column_number", this.getDetachedCriteria());
		data_element_name = new StringExpression("data_element_name", this.getDetachedCriteria());
		data_type = new StringExpression("data_type", this.getDetachedCriteria());
		data_size = new IntegerExpression("data_size", this.getDetachedCriteria());
		age_category = new StringExpression("age_category", this.getDetachedCriteria());
		sex_category = new StringExpression("sex_category", this.getDetachedCriteria());
		other_category = new StringExpression("other_category", this.getDetachedCriteria());
		technical_area_name = new StringExpression("technical_area_name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		data_element_code = new StringExpression("data_element_code", this.getDetachedCriteria());
	}
	
	public Temp_data_elementDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Temp_data_elementCriteria.class);
		temp_data_element_id = new IntegerExpression("temp_data_element_id", this.getDetachedCriteria());
		report_form_name = new StringExpression("report_form_name", this.getDetachedCriteria());
		section_name = new StringExpression("section_name", this.getDetachedCriteria());
		sub_section_name = new StringExpression("sub_section_name", this.getDetachedCriteria());
		report_form_group_name = new StringExpression("report_form_group_name", this.getDetachedCriteria());
		section_column_number = new IntegerExpression("section_column_number", this.getDetachedCriteria());
		group_column_number = new IntegerExpression("group_column_number", this.getDetachedCriteria());
		data_element_name = new StringExpression("data_element_name", this.getDetachedCriteria());
		data_type = new StringExpression("data_type", this.getDetachedCriteria());
		data_size = new IntegerExpression("data_size", this.getDetachedCriteria());
		age_category = new StringExpression("age_category", this.getDetachedCriteria());
		sex_category = new StringExpression("sex_category", this.getDetachedCriteria());
		other_category = new StringExpression("other_category", this.getDetachedCriteria());
		technical_area_name = new StringExpression("technical_area_name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		data_element_code = new StringExpression("data_element_code", this.getDetachedCriteria());
	}
	
	public Temp_data_element uniqueTemp_data_element(PersistentSession session) {
		return (Temp_data_element) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Temp_data_element[] listTemp_data_element(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Temp_data_element[]) list.toArray(new Temp_data_element[list.size()]);
	}
}


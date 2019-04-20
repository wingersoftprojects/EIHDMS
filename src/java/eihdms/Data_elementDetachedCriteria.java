/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Wence
 * License Type: Purchased
 */
package eihdms;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Data_elementDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression data_element_id;
	public final IntegerExpression report_formId;
	public final AssociationExpression report_form;
	public final IntegerExpression sectionId;
	public final AssociationExpression section;
	public final IntegerExpression sub_sectionId;
	public final AssociationExpression sub_section;
	public final IntegerExpression report_form_groupId;
	public final AssociationExpression report_form_group;
	public final IntegerExpression section_column_number;
	public final IntegerExpression group_column_number;
	public final StringExpression data_element_name;
	public final StringExpression data_element_context;
	public final StringExpression data_type;
	public final IntegerExpression data_size;
	public final StringExpression age_category;
	public final StringExpression sex_category;
	public final StringExpression other_category;
	public final IntegerExpression technical_areaId;
	public final AssociationExpression technical_area;
	public final StringExpression description;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final StringExpression data_element_code;
	public final IntegerExpression is_patient_level_record_id;
	public final CollectionExpression interface_data;
	public final CollectionExpression base_data;
	public final CollectionExpression standard_rule;
	public final IntegerExpression data_element_sms_positionId;
	public final AssociationExpression data_element_sms_position;
	public final CollectionExpression sub_section_cell;
	
	public Data_elementDetachedCriteria() {
		super(eihdms.Data_element.class, eihdms.Data_elementCriteria.class);
		data_element_id = new IntegerExpression("data_element_id", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		sectionId = new IntegerExpression("section.section_id", this.getDetachedCriteria());
		section = new AssociationExpression("section", this.getDetachedCriteria());
		sub_sectionId = new IntegerExpression("sub_section.sub_section_id", this.getDetachedCriteria());
		sub_section = new AssociationExpression("sub_section", this.getDetachedCriteria());
		report_form_groupId = new IntegerExpression("report_form_group.report_form_group_id", this.getDetachedCriteria());
		report_form_group = new AssociationExpression("report_form_group", this.getDetachedCriteria());
		section_column_number = new IntegerExpression("section_column_number", this.getDetachedCriteria());
		group_column_number = new IntegerExpression("group_column_number", this.getDetachedCriteria());
		data_element_name = new StringExpression("data_element_name", this.getDetachedCriteria());
		data_element_context = new StringExpression("data_element_context", this.getDetachedCriteria());
		data_type = new StringExpression("data_type", this.getDetachedCriteria());
		data_size = new IntegerExpression("data_size", this.getDetachedCriteria());
		age_category = new StringExpression("age_category", this.getDetachedCriteria());
		sex_category = new StringExpression("sex_category", this.getDetachedCriteria());
		other_category = new StringExpression("other_category", this.getDetachedCriteria());
		technical_areaId = new IntegerExpression("technical_area.technical_area_id", this.getDetachedCriteria());
		technical_area = new AssociationExpression("technical_area", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		data_element_code = new StringExpression("data_element_code", this.getDetachedCriteria());
		is_patient_level_record_id = new IntegerExpression("is_patient_level_record_id", this.getDetachedCriteria());
		interface_data = new CollectionExpression("interface_data", this.getDetachedCriteria());
		base_data = new CollectionExpression("base_data", this.getDetachedCriteria());
		standard_rule = new CollectionExpression("standard_rule", this.getDetachedCriteria());
		data_element_sms_positionId = new IntegerExpression("data_element_sms_position.data_element_id", this.getDetachedCriteria());
		data_element_sms_position = new AssociationExpression("data_element_sms_position", this.getDetachedCriteria());
		sub_section_cell = new CollectionExpression("sub_section_cell", this.getDetachedCriteria());
	}
	
	public Data_elementDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Data_elementCriteria.class);
		data_element_id = new IntegerExpression("data_element_id", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		sectionId = new IntegerExpression("section.section_id", this.getDetachedCriteria());
		section = new AssociationExpression("section", this.getDetachedCriteria());
		sub_sectionId = new IntegerExpression("sub_section.sub_section_id", this.getDetachedCriteria());
		sub_section = new AssociationExpression("sub_section", this.getDetachedCriteria());
		report_form_groupId = new IntegerExpression("report_form_group.report_form_group_id", this.getDetachedCriteria());
		report_form_group = new AssociationExpression("report_form_group", this.getDetachedCriteria());
		section_column_number = new IntegerExpression("section_column_number", this.getDetachedCriteria());
		group_column_number = new IntegerExpression("group_column_number", this.getDetachedCriteria());
		data_element_name = new StringExpression("data_element_name", this.getDetachedCriteria());
		data_element_context = new StringExpression("data_element_context", this.getDetachedCriteria());
		data_type = new StringExpression("data_type", this.getDetachedCriteria());
		data_size = new IntegerExpression("data_size", this.getDetachedCriteria());
		age_category = new StringExpression("age_category", this.getDetachedCriteria());
		sex_category = new StringExpression("sex_category", this.getDetachedCriteria());
		other_category = new StringExpression("other_category", this.getDetachedCriteria());
		technical_areaId = new IntegerExpression("technical_area.technical_area_id", this.getDetachedCriteria());
		technical_area = new AssociationExpression("technical_area", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		data_element_code = new StringExpression("data_element_code", this.getDetachedCriteria());
		is_patient_level_record_id = new IntegerExpression("is_patient_level_record_id", this.getDetachedCriteria());
		interface_data = new CollectionExpression("interface_data", this.getDetachedCriteria());
		base_data = new CollectionExpression("base_data", this.getDetachedCriteria());
		standard_rule = new CollectionExpression("standard_rule", this.getDetachedCriteria());
		data_element_sms_positionId = new IntegerExpression("data_element_sms_position.data_element_id", this.getDetachedCriteria());
		data_element_sms_position = new AssociationExpression("data_element_sms_position", this.getDetachedCriteria());
		sub_section_cell = new CollectionExpression("sub_section_cell", this.getDetachedCriteria());
	}
	
	public Report_formDetachedCriteria createReport_formCriteria() {
		return new Report_formDetachedCriteria(createCriteria("report_form"));
	}
	
	public SectionDetachedCriteria createSectionCriteria() {
		return new SectionDetachedCriteria(createCriteria("section"));
	}
	
	public Sub_sectionDetachedCriteria createSub_sectionCriteria() {
		return new Sub_sectionDetachedCriteria(createCriteria("sub_section"));
	}
	
	public Report_form_groupDetachedCriteria createReport_form_groupCriteria() {
		return new Report_form_groupDetachedCriteria(createCriteria("report_form_group"));
	}
	
	public Technical_areaDetachedCriteria createTechnical_areaCriteria() {
		return new Technical_areaDetachedCriteria(createCriteria("technical_area"));
	}
	
	public Interface_dataDetachedCriteria createInterface_dataCriteria() {
		return new Interface_dataDetachedCriteria(createCriteria("interface_data"));
	}
	
	public Base_dataDetachedCriteria createBase_dataCriteria() {
		return new Base_dataDetachedCriteria(createCriteria("base_data"));
	}
	
	public Standard_ruleDetachedCriteria createStandard_ruleCriteria() {
		return new Standard_ruleDetachedCriteria(createCriteria("standard_rule"));
	}
	
	public Data_element_sms_positionDetachedCriteria createData_element_sms_positionCriteria() {
		return new Data_element_sms_positionDetachedCriteria(createCriteria("data_element_sms_position"));
	}
	
	public Sub_section_cellDetachedCriteria createSub_section_cellCriteria() {
		return new Sub_section_cellDetachedCriteria(createCriteria("sub_section_cell"));
	}
	
	public Data_element uniqueData_element(PersistentSession session) {
		return (Data_element) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Data_element[] listData_element(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Data_element[]) list.toArray(new Data_element[list.size()]);
	}
}


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

public class Data_elementCriteria extends AbstractORMCriteria {
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
	public final CollectionExpression interface_data;
	public final CollectionExpression base_data;
	public final CollectionExpression standard_rule;
	public final CollectionExpression validation_rule;
	public final CollectionExpression validation_rule1;
	public final CollectionExpression validation_rule2;
	public final CollectionExpression validation_rule3;
	
	public Data_elementCriteria(Criteria criteria) {
		super(criteria);
		data_element_id = new IntegerExpression("data_element_id", this);
		report_formId = new IntegerExpression("report_form.report_form_id", this);
		report_form = new AssociationExpression("report_form", this);
		sectionId = new IntegerExpression("section.section_id", this);
		section = new AssociationExpression("section", this);
		sub_sectionId = new IntegerExpression("sub_section.sub_section_id", this);
		sub_section = new AssociationExpression("sub_section", this);
		report_form_groupId = new IntegerExpression("report_form_group.report_form_group_id", this);
		report_form_group = new AssociationExpression("report_form_group", this);
		section_column_number = new IntegerExpression("section_column_number", this);
		group_column_number = new IntegerExpression("group_column_number", this);
		data_element_name = new StringExpression("data_element_name", this);
		data_type = new StringExpression("data_type", this);
		data_size = new IntegerExpression("data_size", this);
		age_category = new StringExpression("age_category", this);
		sex_category = new StringExpression("sex_category", this);
		other_category = new StringExpression("other_category", this);
		technical_areaId = new IntegerExpression("technical_area.technical_area_id", this);
		technical_area = new AssociationExpression("technical_area", this);
		description = new StringExpression("description", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		data_element_code = new StringExpression("data_element_code", this);
		interface_data = new CollectionExpression("interface_data", this);
		base_data = new CollectionExpression("base_data", this);
		standard_rule = new CollectionExpression("standard_rule", this);
		validation_rule = new CollectionExpression("validation_rule", this);
		validation_rule1 = new CollectionExpression("validation_rule1", this);
		validation_rule2 = new CollectionExpression("validation_rule2", this);
		validation_rule3 = new CollectionExpression("validation_rule3", this);
	}
	
	public Data_elementCriteria(PersistentSession session) {
		this(session.createCriteria(Data_element.class));
	}
	
	public Data_elementCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public Report_formCriteria createReport_formCriteria() {
		return new Report_formCriteria(createCriteria("report_form"));
	}
	
	public SectionCriteria createSectionCriteria() {
		return new SectionCriteria(createCriteria("section"));
	}
	
	public Sub_sectionCriteria createSub_sectionCriteria() {
		return new Sub_sectionCriteria(createCriteria("sub_section"));
	}
	
	public Report_form_groupCriteria createReport_form_groupCriteria() {
		return new Report_form_groupCriteria(createCriteria("report_form_group"));
	}
	
	public Technical_areaCriteria createTechnical_areaCriteria() {
		return new Technical_areaCriteria(createCriteria("technical_area"));
	}
	
	public Interface_dataCriteria createInterface_dataCriteria() {
		return new Interface_dataCriteria(createCriteria("interface_data"));
	}
	
	public Base_dataCriteria createBase_dataCriteria() {
		return new Base_dataCriteria(createCriteria("base_data"));
	}
	
	public Standard_ruleCriteria createStandard_ruleCriteria() {
		return new Standard_ruleCriteria(createCriteria("standard_rule"));
	}
	
	public Validation_ruleCriteria createValidation_ruleCriteria() {
		return new Validation_ruleCriteria(createCriteria("validation_rule"));
	}
	
	public Validation_ruleCriteria createValidation_rule1Criteria() {
		return new Validation_ruleCriteria(createCriteria("validation_rule1"));
	}
	
	public Validation_ruleCriteria createValidation_rule2Criteria() {
		return new Validation_ruleCriteria(createCriteria("validation_rule2"));
	}
	
	public Validation_ruleCriteria createValidation_rule3Criteria() {
		return new Validation_ruleCriteria(createCriteria("validation_rule3"));
	}
	
	public Data_element uniqueData_element() {
		return (Data_element) super.uniqueResult();
	}
	
	public Data_element[] listData_element() {
		java.util.List list = super.list();
		return (Data_element[]) list.toArray(new Data_element[list.size()]);
	}
}


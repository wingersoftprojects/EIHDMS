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

public class SectionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression section_id;
	public final StringExpression section_name;
	public final StringExpression section_order;
	public final IntegerExpression report_formId;
	public final AssociationExpression report_form;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression data_element;
	public final CollectionExpression sub_section;
	public final CollectionExpression sub_section_cell;
	
	public SectionDetachedCriteria() {
		super(eihdms.Section.class, eihdms.SectionCriteria.class);
		section_id = new IntegerExpression("section_id", this.getDetachedCriteria());
		section_name = new StringExpression("section_name", this.getDetachedCriteria());
		section_order = new StringExpression("section_order", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		data_element = new CollectionExpression("data_element", this.getDetachedCriteria());
		sub_section = new CollectionExpression("sub_section", this.getDetachedCriteria());
		sub_section_cell = new CollectionExpression("sub_section_cell", this.getDetachedCriteria());
	}
	
	public SectionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.SectionCriteria.class);
		section_id = new IntegerExpression("section_id", this.getDetachedCriteria());
		section_name = new StringExpression("section_name", this.getDetachedCriteria());
		section_order = new StringExpression("section_order", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		data_element = new CollectionExpression("data_element", this.getDetachedCriteria());
		sub_section = new CollectionExpression("sub_section", this.getDetachedCriteria());
		sub_section_cell = new CollectionExpression("sub_section_cell", this.getDetachedCriteria());
	}
	
	public Report_formDetachedCriteria createReport_formCriteria() {
		return new Report_formDetachedCriteria(createCriteria("report_form"));
	}
	
	public Data_elementDetachedCriteria createData_elementCriteria() {
		return new Data_elementDetachedCriteria(createCriteria("data_element"));
	}
	
	public Sub_sectionDetachedCriteria createSub_sectionCriteria() {
		return new Sub_sectionDetachedCriteria(createCriteria("sub_section"));
	}
	
	public Sub_section_cellDetachedCriteria createSub_section_cellCriteria() {
		return new Sub_section_cellDetachedCriteria(createCriteria("sub_section_cell"));
	}
	
	public Section uniqueSection(PersistentSession session) {
		return (Section) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Section[] listSection(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Section[]) list.toArray(new Section[list.size()]);
	}
}


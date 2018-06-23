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

public class SectionCriteria extends AbstractORMCriteria {
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
	
	public SectionCriteria(Criteria criteria) {
		super(criteria);
		section_id = new IntegerExpression("section_id", this);
		section_name = new StringExpression("section_name", this);
		section_order = new StringExpression("section_order", this);
		report_formId = new IntegerExpression("report_form.report_form_id", this);
		report_form = new AssociationExpression("report_form", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		data_element = new CollectionExpression("data_element", this);
		sub_section = new CollectionExpression("sub_section", this);
		sub_section_cell = new CollectionExpression("sub_section_cell", this);
	}
	
	public SectionCriteria(PersistentSession session) {
		this(session.createCriteria(Section.class));
	}
	
	public SectionCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Report_formCriteria createReport_formCriteria() {
		return new Report_formCriteria(createCriteria("report_form"));
	}
	
	public Data_elementCriteria createData_elementCriteria() {
		return new Data_elementCriteria(createCriteria("data_element"));
	}
	
	public Sub_sectionCriteria createSub_sectionCriteria() {
		return new Sub_sectionCriteria(createCriteria("sub_section"));
	}
	
	public Sub_section_cellCriteria createSub_section_cellCriteria() {
		return new Sub_section_cellCriteria(createCriteria("sub_section_cell"));
	}
	
	public Section uniqueSection() {
		return (Section) super.uniqueResult();
	}
	
	public Section[] listSection() {
		java.util.List list = super.list();
		return (Section[]) list.toArray(new Section[list.size()]);
	}
}


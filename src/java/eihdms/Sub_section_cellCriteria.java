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

public class Sub_section_cellCriteria extends AbstractORMCriteria {
	public final IntegerExpression sub_section_cell_id;
	public final IntegerExpression sub_sectionId;
	public final AssociationExpression sub_section;
	public final IntegerExpression sectionId;
	public final AssociationExpression section;
	public final IntegerExpression row_no;
	public final IntegerExpression col_no;
	public final IntegerExpression col_span;
	public final IntegerExpression row_span;
	public final StringExpression label_name;
	public final IntegerExpression data_elementId;
	public final AssociationExpression data_element;
	public final StringExpression data_element_value;
	public final StringExpression text_color;
	public final StringExpression cell_color;
	public final IntegerExpression read_only;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Sub_section_cellCriteria(Criteria criteria) {
		super(criteria);
		sub_section_cell_id = new IntegerExpression("sub_section_cell_id", this);
		sub_sectionId = new IntegerExpression("sub_section.sub_section_id", this);
		sub_section = new AssociationExpression("sub_section", this);
		sectionId = new IntegerExpression("section.section_id", this);
		section = new AssociationExpression("section", this);
		row_no = new IntegerExpression("row_no", this);
		col_no = new IntegerExpression("col_no", this);
		col_span = new IntegerExpression("col_span", this);
		row_span = new IntegerExpression("row_span", this);
		label_name = new StringExpression("label_name", this);
		data_elementId = new IntegerExpression("data_element.data_element_id", this);
		data_element = new AssociationExpression("data_element", this);
		data_element_value = new StringExpression("data_element_value", this);
		text_color = new StringExpression("text_color", this);
		cell_color = new StringExpression("cell_color", this);
		read_only = new IntegerExpression("read_only", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Sub_section_cellCriteria(PersistentSession session) {
		this(session.createCriteria(Sub_section_cell.class));
	}
	
	public Sub_section_cellCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Sub_sectionCriteria createSub_sectionCriteria() {
		return new Sub_sectionCriteria(createCriteria("sub_section"));
	}
	
	public SectionCriteria createSectionCriteria() {
		return new SectionCriteria(createCriteria("section"));
	}
	
	public Data_elementCriteria createData_elementCriteria() {
		return new Data_elementCriteria(createCriteria("data_element"));
	}
	
	public Sub_section_cell uniqueSub_section_cell() {
		return (Sub_section_cell) super.uniqueResult();
	}
	
	public Sub_section_cell[] listSub_section_cell() {
		java.util.List list = super.list();
		return (Sub_section_cell[]) list.toArray(new Sub_section_cell[list.size()]);
	}
}


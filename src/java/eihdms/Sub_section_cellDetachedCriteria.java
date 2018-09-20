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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Sub_section_cellDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public Sub_section_cellDetachedCriteria() {
		super(eihdms.Sub_section_cell.class, eihdms.Sub_section_cellCriteria.class);
		sub_section_cell_id = new IntegerExpression("sub_section_cell_id", this.getDetachedCriteria());
		sub_sectionId = new IntegerExpression("sub_section.sub_section_id", this.getDetachedCriteria());
		sub_section = new AssociationExpression("sub_section", this.getDetachedCriteria());
		sectionId = new IntegerExpression("section.section_id", this.getDetachedCriteria());
		section = new AssociationExpression("section", this.getDetachedCriteria());
		row_no = new IntegerExpression("row_no", this.getDetachedCriteria());
		col_no = new IntegerExpression("col_no", this.getDetachedCriteria());
		col_span = new IntegerExpression("col_span", this.getDetachedCriteria());
		row_span = new IntegerExpression("row_span", this.getDetachedCriteria());
		label_name = new StringExpression("label_name", this.getDetachedCriteria());
		data_elementId = new IntegerExpression("data_element.data_element_id", this.getDetachedCriteria());
		data_element = new AssociationExpression("data_element", this.getDetachedCriteria());
		data_element_value = new StringExpression("data_element_value", this.getDetachedCriteria());
		text_color = new StringExpression("text_color", this.getDetachedCriteria());
		cell_color = new StringExpression("cell_color", this.getDetachedCriteria());
		read_only = new IntegerExpression("read_only", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Sub_section_cellDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Sub_section_cellCriteria.class);
		sub_section_cell_id = new IntegerExpression("sub_section_cell_id", this.getDetachedCriteria());
		sub_sectionId = new IntegerExpression("sub_section.sub_section_id", this.getDetachedCriteria());
		sub_section = new AssociationExpression("sub_section", this.getDetachedCriteria());
		sectionId = new IntegerExpression("section.section_id", this.getDetachedCriteria());
		section = new AssociationExpression("section", this.getDetachedCriteria());
		row_no = new IntegerExpression("row_no", this.getDetachedCriteria());
		col_no = new IntegerExpression("col_no", this.getDetachedCriteria());
		col_span = new IntegerExpression("col_span", this.getDetachedCriteria());
		row_span = new IntegerExpression("row_span", this.getDetachedCriteria());
		label_name = new StringExpression("label_name", this.getDetachedCriteria());
		data_elementId = new IntegerExpression("data_element.data_element_id", this.getDetachedCriteria());
		data_element = new AssociationExpression("data_element", this.getDetachedCriteria());
		data_element_value = new StringExpression("data_element_value", this.getDetachedCriteria());
		text_color = new StringExpression("text_color", this.getDetachedCriteria());
		cell_color = new StringExpression("cell_color", this.getDetachedCriteria());
		read_only = new IntegerExpression("read_only", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Sub_sectionDetachedCriteria createSub_sectionCriteria() {
		return new Sub_sectionDetachedCriteria(createCriteria("sub_section"));
	}
	
	public SectionDetachedCriteria createSectionCriteria() {
		return new SectionDetachedCriteria(createCriteria("section"));
	}
	
	public Data_elementDetachedCriteria createData_elementCriteria() {
		return new Data_elementDetachedCriteria(createCriteria("data_element"));
	}
	
	public Sub_section_cell uniqueSub_section_cell(PersistentSession session) {
		return (Sub_section_cell) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Sub_section_cell[] listSub_section_cell(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Sub_section_cell[]) list.toArray(new Sub_section_cell[list.size()]);
	}
}


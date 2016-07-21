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

public class Sub_sectionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression sub_section_id;
	public final StringExpression sub_section_name;
	public final StringExpression sub_section_order;
	public final IntegerExpression sectionId;
	public final AssociationExpression section;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression data_element;
	
	public Sub_sectionDetachedCriteria() {
		super(eihdms.Sub_section.class, eihdms.Sub_sectionCriteria.class);
		sub_section_id = new IntegerExpression("sub_section_id", this.getDetachedCriteria());
		sub_section_name = new StringExpression("sub_section_name", this.getDetachedCriteria());
		sub_section_order = new StringExpression("sub_section_order", this.getDetachedCriteria());
		sectionId = new IntegerExpression("section.section_id", this.getDetachedCriteria());
		section = new AssociationExpression("section", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		data_element = new CollectionExpression("data_element", this.getDetachedCriteria());
	}
	
	public Sub_sectionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Sub_sectionCriteria.class);
		sub_section_id = new IntegerExpression("sub_section_id", this.getDetachedCriteria());
		sub_section_name = new StringExpression("sub_section_name", this.getDetachedCriteria());
		sub_section_order = new StringExpression("sub_section_order", this.getDetachedCriteria());
		sectionId = new IntegerExpression("section.section_id", this.getDetachedCriteria());
		section = new AssociationExpression("section", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		data_element = new CollectionExpression("data_element", this.getDetachedCriteria());
	}
	
	public SectionDetachedCriteria createSectionCriteria() {
		return new SectionDetachedCriteria(createCriteria("section"));
	}
	
	public Data_elementDetachedCriteria createData_elementCriteria() {
		return new Data_elementDetachedCriteria(createCriteria("data_element"));
	}
	
	public Sub_section uniqueSub_section(PersistentSession session) {
		return (Sub_section) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Sub_section[] listSub_section(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Sub_section[]) list.toArray(new Sub_section[list.size()]);
	}
}


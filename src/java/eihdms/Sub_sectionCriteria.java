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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Sub_sectionCriteria extends AbstractORMCriteria {
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
	public final CollectionExpression sub_section_cell;
	
	public Sub_sectionCriteria(Criteria criteria) {
		super(criteria);
		sub_section_id = new IntegerExpression("sub_section_id", this);
		sub_section_name = new StringExpression("sub_section_name", this);
		sub_section_order = new StringExpression("sub_section_order", this);
		sectionId = new IntegerExpression("section.section_id", this);
		section = new AssociationExpression("section", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		data_element = new CollectionExpression("data_element", this);
		sub_section_cell = new CollectionExpression("sub_section_cell", this);
	}
	
	public Sub_sectionCriteria(PersistentSession session) {
		this(session.createCriteria(Sub_section.class));
	}
	
	public Sub_sectionCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public SectionCriteria createSectionCriteria() {
		return new SectionCriteria(createCriteria("section"));
	}
	
	public Data_elementCriteria createData_elementCriteria() {
		return new Data_elementCriteria(createCriteria("data_element"));
	}
	
	public Sub_section_cellCriteria createSub_section_cellCriteria() {
		return new Sub_section_cellCriteria(createCriteria("sub_section_cell"));
	}
	
	public Sub_section uniqueSub_section() {
		return (Sub_section) super.uniqueResult();
	}
	
	public Sub_section[] listSub_section() {
		java.util.List list = super.list();
		return (Sub_section[]) list.toArray(new Sub_section[list.size()]);
	}
}


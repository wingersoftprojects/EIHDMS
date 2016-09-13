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

public class Technical_areaCriteria extends AbstractORMCriteria {
	public final IntegerExpression technical_area_id;
	public final StringExpression technical_area_name;
	public final StringExpression description;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression data_element;
	public final CollectionExpression kpi;
	
	public Technical_areaCriteria(Criteria criteria) {
		super(criteria);
		technical_area_id = new IntegerExpression("technical_area_id", this);
		technical_area_name = new StringExpression("technical_area_name", this);
		description = new StringExpression("description", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		data_element = new CollectionExpression("data_element", this);
		kpi = new CollectionExpression("kpi", this);
	}
	
	public Technical_areaCriteria(PersistentSession session) {
		this(session.createCriteria(Technical_area.class));
	}
	
	public Technical_areaCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public Data_elementCriteria createData_elementCriteria() {
		return new Data_elementCriteria(createCriteria("data_element"));
	}
	
	public KpiCriteria createKpiCriteria() {
		return new KpiCriteria(createCriteria("kpi"));
	}
	
	public Technical_area uniqueTechnical_area() {
		return (Technical_area) super.uniqueResult();
	}
	
	public Technical_area[] listTechnical_area() {
		java.util.List list = super.list();
		return (Technical_area[]) list.toArray(new Technical_area[list.size()]);
	}
}


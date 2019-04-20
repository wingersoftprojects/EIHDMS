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

public class Technical_areaDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public Technical_areaDetachedCriteria() {
		super(eihdms.Technical_area.class, eihdms.Technical_areaCriteria.class);
		technical_area_id = new IntegerExpression("technical_area_id", this.getDetachedCriteria());
		technical_area_name = new StringExpression("technical_area_name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		data_element = new CollectionExpression("data_element", this.getDetachedCriteria());
		kpi = new CollectionExpression("kpi", this.getDetachedCriteria());
	}
	
	public Technical_areaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Technical_areaCriteria.class);
		technical_area_id = new IntegerExpression("technical_area_id", this.getDetachedCriteria());
		technical_area_name = new StringExpression("technical_area_name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		data_element = new CollectionExpression("data_element", this.getDetachedCriteria());
		kpi = new CollectionExpression("kpi", this.getDetachedCriteria());
	}
	
	public Data_elementDetachedCriteria createData_elementCriteria() {
		return new Data_elementDetachedCriteria(createCriteria("data_element"));
	}
	
	public KpiDetachedCriteria createKpiCriteria() {
		return new KpiDetachedCriteria(createCriteria("kpi"));
	}
	
	public Technical_area uniqueTechnical_area(PersistentSession session) {
		return (Technical_area) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Technical_area[] listTechnical_area(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Technical_area[]) list.toArray(new Technical_area[list.size()]);
	}
}


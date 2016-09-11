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

public class Kpi_data_elementDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression kpi_data_element_id;
	public final IntegerExpression kpiId;
	public final AssociationExpression kpi;
	public final IntegerExpression data_elementId;
	public final AssociationExpression data_element;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Kpi_data_elementDetachedCriteria() {
		super(eihdms.Kpi_data_element.class, eihdms.Kpi_data_elementCriteria.class);
		kpi_data_element_id = new IntegerExpression("kpi_data_element_id", this.getDetachedCriteria());
		kpiId = new IntegerExpression("kpi.kpi_id", this.getDetachedCriteria());
		kpi = new AssociationExpression("kpi", this.getDetachedCriteria());
		data_elementId = new IntegerExpression("data_element.data_element_id", this.getDetachedCriteria());
		data_element = new AssociationExpression("data_element", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Kpi_data_elementDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Kpi_data_elementCriteria.class);
		kpi_data_element_id = new IntegerExpression("kpi_data_element_id", this.getDetachedCriteria());
		kpiId = new IntegerExpression("kpi.kpi_id", this.getDetachedCriteria());
		kpi = new AssociationExpression("kpi", this.getDetachedCriteria());
		data_elementId = new IntegerExpression("data_element.data_element_id", this.getDetachedCriteria());
		data_element = new AssociationExpression("data_element", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public KpiDetachedCriteria createKpiCriteria() {
		return new KpiDetachedCriteria(createCriteria("kpi"));
	}
	
	public Data_elementDetachedCriteria createData_elementCriteria() {
		return new Data_elementDetachedCriteria(createCriteria("data_element"));
	}
	
	public Kpi_data_element uniqueKpi_data_element(PersistentSession session) {
		return (Kpi_data_element) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Kpi_data_element[] listKpi_data_element(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Kpi_data_element[]) list.toArray(new Kpi_data_element[list.size()]);
	}
}


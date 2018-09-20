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

public class Kpi_summary_functionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression kpi_summary_function_id;
	public final IntegerExpression kpiId;
	public final AssociationExpression kpi;
	public final StringExpression kpi_summary_function_name;
	public final StringExpression summary_function;
	public final StringExpression data_elements_involved;
	public final StringExpression data_element_ids_involved;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	
	public Kpi_summary_functionDetachedCriteria() {
		super(eihdms.Kpi_summary_function.class, eihdms.Kpi_summary_functionCriteria.class);
		kpi_summary_function_id = new IntegerExpression("kpi_summary_function_id", this.getDetachedCriteria());
		kpiId = new IntegerExpression("kpi.kpi_id", this.getDetachedCriteria());
		kpi = new AssociationExpression("kpi", this.getDetachedCriteria());
		kpi_summary_function_name = new StringExpression("kpi_summary_function_name", this.getDetachedCriteria());
		summary_function = new StringExpression("summary_function", this.getDetachedCriteria());
		data_elements_involved = new StringExpression("data_elements_involved", this.getDetachedCriteria());
		data_element_ids_involved = new StringExpression("data_element_ids_involved", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
	}
	
	public Kpi_summary_functionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Kpi_summary_functionCriteria.class);
		kpi_summary_function_id = new IntegerExpression("kpi_summary_function_id", this.getDetachedCriteria());
		kpiId = new IntegerExpression("kpi.kpi_id", this.getDetachedCriteria());
		kpi = new AssociationExpression("kpi", this.getDetachedCriteria());
		kpi_summary_function_name = new StringExpression("kpi_summary_function_name", this.getDetachedCriteria());
		summary_function = new StringExpression("summary_function", this.getDetachedCriteria());
		data_elements_involved = new StringExpression("data_elements_involved", this.getDetachedCriteria());
		data_element_ids_involved = new StringExpression("data_element_ids_involved", this.getDetachedCriteria());
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
	
	public Kpi_summary_function uniqueKpi_summary_function(PersistentSession session) {
		return (Kpi_summary_function) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Kpi_summary_function[] listKpi_summary_function(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Kpi_summary_function[]) list.toArray(new Kpi_summary_function[list.size()]);
	}
}


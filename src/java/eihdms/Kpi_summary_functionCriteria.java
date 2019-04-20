/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: rlumala
 * License Type: Purchased
 */
package eihdms;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Kpi_summary_functionCriteria extends AbstractORMCriteria {
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
	
	public Kpi_summary_functionCriteria(Criteria criteria) {
		super(criteria);
		kpi_summary_function_id = new IntegerExpression("kpi_summary_function_id", this);
		kpiId = new IntegerExpression("kpi.kpi_id", this);
		kpi = new AssociationExpression("kpi", this);
		kpi_summary_function_name = new StringExpression("kpi_summary_function_name", this);
		summary_function = new StringExpression("summary_function", this);
		data_elements_involved = new StringExpression("data_elements_involved", this);
		data_element_ids_involved = new StringExpression("data_element_ids_involved", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Kpi_summary_functionCriteria(PersistentSession session) {
		this(session.createCriteria(Kpi_summary_function.class));
	}
	
	public Kpi_summary_functionCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public KpiCriteria createKpiCriteria() {
		return new KpiCriteria(createCriteria("kpi"));
	}
	
	public Kpi_summary_function uniqueKpi_summary_function() {
		return (Kpi_summary_function) super.uniqueResult();
	}
	
	public Kpi_summary_function[] listKpi_summary_function() {
		java.util.List list = super.list();
		return (Kpi_summary_function[]) list.toArray(new Kpi_summary_function[list.size()]);
	}
}


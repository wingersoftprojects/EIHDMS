/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: btwesigye
 * License Type: Purchased
 */
package eihdms;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class KpiCriteria extends AbstractORMCriteria {
	public final IntegerExpression kpi_id;
	public final StringExpression kpi_name;
	public final StringExpression kpi_summary_function;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression kpi_data_element;
	
	public KpiCriteria(Criteria criteria) {
		super(criteria);
		kpi_id = new IntegerExpression("kpi_id", this);
		kpi_name = new StringExpression("kpi_name", this);
		kpi_summary_function = new StringExpression("kpi_summary_function", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		kpi_data_element = new CollectionExpression("kpi_data_element", this);
	}
	
	public KpiCriteria(PersistentSession session) {
		this(session.createCriteria(Kpi.class));
	}
	
	public KpiCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public Kpi_data_elementCriteria createKpi_data_elementCriteria() {
		return new Kpi_data_elementCriteria(createCriteria("kpi_data_element"));
	}
	
	public Kpi uniqueKpi() {
		return (Kpi) super.uniqueResult();
	}
	
	public Kpi[] listKpi() {
		java.util.List list = super.list();
		return (Kpi[]) list.toArray(new Kpi[list.size()]);
	}
}


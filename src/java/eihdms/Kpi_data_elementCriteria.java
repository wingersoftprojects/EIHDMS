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

public class Kpi_data_elementCriteria extends AbstractORMCriteria {
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
	
	public Kpi_data_elementCriteria(Criteria criteria) {
		super(criteria);
		kpi_data_element_id = new IntegerExpression("kpi_data_element_id", this);
		kpiId = new IntegerExpression("kpi.kpi_id", this);
		kpi = new AssociationExpression("kpi", this);
		data_elementId = new IntegerExpression("data_element.data_element_id", this);
		data_element = new AssociationExpression("data_element", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
	}
	
	public Kpi_data_elementCriteria(PersistentSession session) {
		this(session.createCriteria(Kpi_data_element.class));
	}
	
	public Kpi_data_elementCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public KpiCriteria createKpiCriteria() {
		return new KpiCriteria(createCriteria("kpi"));
	}
	
	public Data_elementCriteria createData_elementCriteria() {
		return new Data_elementCriteria(createCriteria("data_element"));
	}
	
	public Kpi_data_element uniqueKpi_data_element() {
		return (Kpi_data_element) super.uniqueResult();
	}
	
	public Kpi_data_element[] listKpi_data_element() {
		java.util.List list = super.list();
		return (Kpi_data_element[]) list.toArray(new Kpi_data_element[list.size()]);
	}
}


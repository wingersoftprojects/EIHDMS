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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Financial_yearDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression financial_year_id;
	public final StringExpression financial_year_name;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression interface_data;
	public final CollectionExpression base_data;
	
	public Financial_yearDetachedCriteria() {
		super(eihdms.Financial_year.class, eihdms.Financial_yearCriteria.class);
		financial_year_id = new IntegerExpression("financial_year_id", this.getDetachedCriteria());
		financial_year_name = new StringExpression("financial_year_name", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		interface_data = new CollectionExpression("interface_data", this.getDetachedCriteria());
		base_data = new CollectionExpression("base_data", this.getDetachedCriteria());
	}
	
	public Financial_yearDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Financial_yearCriteria.class);
		financial_year_id = new IntegerExpression("financial_year_id", this.getDetachedCriteria());
		financial_year_name = new StringExpression("financial_year_name", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		interface_data = new CollectionExpression("interface_data", this.getDetachedCriteria());
		base_data = new CollectionExpression("base_data", this.getDetachedCriteria());
	}
	
	public Interface_dataDetachedCriteria createInterface_dataCriteria() {
		return new Interface_dataDetachedCriteria(createCriteria("interface_data"));
	}
	
	public Base_dataDetachedCriteria createBase_dataCriteria() {
		return new Base_dataDetachedCriteria(createCriteria("base_data"));
	}
	
	public Financial_year uniqueFinancial_year(PersistentSession session) {
		return (Financial_year) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Financial_year[] listFinancial_year(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Financial_year[]) list.toArray(new Financial_year[list.size()]);
	}
}


/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: wence.twesigye
 * License Type: Purchased
 */
package eihdms;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Financial_yearCriteria extends AbstractORMCriteria {
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
	
	public Financial_yearCriteria(Criteria criteria) {
		super(criteria);
		financial_year_id = new IntegerExpression("financial_year_id", this);
		financial_year_name = new StringExpression("financial_year_name", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		interface_data = new CollectionExpression("interface_data", this);
		base_data = new CollectionExpression("base_data", this);
	}
	
	public Financial_yearCriteria(PersistentSession session) {
		this(session.createCriteria(Financial_year.class));
	}
	
	public Financial_yearCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Interface_dataCriteria createInterface_dataCriteria() {
		return new Interface_dataCriteria(createCriteria("interface_data"));
	}
	
	public Base_dataCriteria createBase_dataCriteria() {
		return new Base_dataCriteria(createCriteria("base_data"));
	}
	
	public Financial_year uniqueFinancial_year() {
		return (Financial_year) super.uniqueResult();
	}
	
	public Financial_year[] listFinancial_year() {
		java.util.List list = super.list();
		return (Financial_year[]) list.toArray(new Financial_year[list.size()]);
	}
}


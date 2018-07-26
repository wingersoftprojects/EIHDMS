/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Ajuna Newton Brian
 * License Type: Purchased
 */
package eihdms;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class BatchCriteria extends AbstractORMCriteria {
	public final IntegerExpression batch_id;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression interface_data;
	public final CollectionExpression base_data;
	
	public BatchCriteria(Criteria criteria) {
		super(criteria);
		batch_id = new IntegerExpression("batch_id", this);
		is_deleted = new IntegerExpression("is_deleted", this);
		is_active = new IntegerExpression("is_active", this);
		add_date = new TimestampExpression("add_date", this);
		add_by = new IntegerExpression("add_by", this);
		last_edit_date = new TimestampExpression("last_edit_date", this);
		last_edit_by = new IntegerExpression("last_edit_by", this);
		interface_data = new CollectionExpression("interface_data", this);
		base_data = new CollectionExpression("base_data", this);
	}
	
	public BatchCriteria(PersistentSession session) {
		this(session.createCriteria(Batch.class));
	}
	
	public BatchCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Interface_dataCriteria createInterface_dataCriteria() {
		return new Interface_dataCriteria(createCriteria("interface_data"));
	}
	
	public Base_dataCriteria createBase_dataCriteria() {
		return new Base_dataCriteria(createCriteria("base_data"));
	}
	
	public Batch uniqueBatch() {
		return (Batch) super.uniqueResult();
	}
	
	public Batch[] listBatch() {
		java.util.List list = super.list();
		return (Batch[]) list.toArray(new Batch[list.size()]);
	}
}


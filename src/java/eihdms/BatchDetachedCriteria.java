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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class BatchDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression batch_id;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression interface_data;
	public final CollectionExpression base_data;
	
	public BatchDetachedCriteria() {
		super(eihdms.Batch.class, eihdms.BatchCriteria.class);
		batch_id = new IntegerExpression("batch_id", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		interface_data = new CollectionExpression("interface_data", this.getDetachedCriteria());
		base_data = new CollectionExpression("base_data", this.getDetachedCriteria());
	}
	
	public BatchDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.BatchCriteria.class);
		batch_id = new IntegerExpression("batch_id", this.getDetachedCriteria());
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
	
	public Batch uniqueBatch(PersistentSession session) {
		return (Batch) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Batch[] listBatch(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Batch[]) list.toArray(new Batch[list.size()]);
	}
}


/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Kiyingi Simon Peter
 * License Type: Purchased
 */
package ehmis;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ActionLogDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression logNo;
	public final IntegerExpression logDay;
	public final IntegerExpression logMonth;
	public final IntegerExpression logYear;
	public final IntegerExpression userNo;
	public final StringExpression userName;
	public final IntegerExpression permissionNo;
	public final StringExpression permissionName;
	
	public ActionLogDetachedCriteria() {
		super(ehmis.ActionLog.class, ehmis.ActionLogCriteria.class);
		logNo = new IntegerExpression("logNo", this.getDetachedCriteria());
		logDay = new IntegerExpression("logDay", this.getDetachedCriteria());
		logMonth = new IntegerExpression("logMonth", this.getDetachedCriteria());
		logYear = new IntegerExpression("logYear", this.getDetachedCriteria());
		userNo = new IntegerExpression("userNo", this.getDetachedCriteria());
		userName = new StringExpression("userName", this.getDetachedCriteria());
		permissionNo = new IntegerExpression("permissionNo", this.getDetachedCriteria());
		permissionName = new StringExpression("permissionName", this.getDetachedCriteria());
	}
	
	public ActionLogDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ehmis.ActionLogCriteria.class);
		logNo = new IntegerExpression("logNo", this.getDetachedCriteria());
		logDay = new IntegerExpression("logDay", this.getDetachedCriteria());
		logMonth = new IntegerExpression("logMonth", this.getDetachedCriteria());
		logYear = new IntegerExpression("logYear", this.getDetachedCriteria());
		userNo = new IntegerExpression("userNo", this.getDetachedCriteria());
		userName = new StringExpression("userName", this.getDetachedCriteria());
		permissionNo = new IntegerExpression("permissionNo", this.getDetachedCriteria());
		permissionName = new StringExpression("permissionName", this.getDetachedCriteria());
	}
	
	public ActionLog uniqueActionLog(PersistentSession session) {
		return (ActionLog) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ActionLog[] listActionLog(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ActionLog[]) list.toArray(new ActionLog[list.size()]);
	}
}


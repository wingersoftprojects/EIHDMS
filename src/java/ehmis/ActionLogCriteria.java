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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ActionLogCriteria extends AbstractORMCriteria {
	public final IntegerExpression logNo;
	public final IntegerExpression logDay;
	public final IntegerExpression logMonth;
	public final IntegerExpression logYear;
	public final IntegerExpression userNo;
	public final StringExpression userName;
	public final IntegerExpression permissionNo;
	public final StringExpression permissionName;
	
	public ActionLogCriteria(Criteria criteria) {
		super(criteria);
		logNo = new IntegerExpression("logNo", this);
		logDay = new IntegerExpression("logDay", this);
		logMonth = new IntegerExpression("logMonth", this);
		logYear = new IntegerExpression("logYear", this);
		userNo = new IntegerExpression("userNo", this);
		userName = new StringExpression("userName", this);
		permissionNo = new IntegerExpression("permissionNo", this);
		permissionName = new StringExpression("permissionName", this);
	}
	
	public ActionLogCriteria(PersistentSession session) {
		this(session.createCriteria(ActionLog.class));
	}
	
	public ActionLogCriteria() throws PersistentException {
		this(eihdms.EIHDMSPersistentManager.instance().getSession());
	}
	
	public ActionLog uniqueActionLog() {
		return (ActionLog) super.uniqueResult();
	}
	
	public ActionLog[] listActionLog() {
		java.util.List list = super.list();
		return (ActionLog[]) list.toArray(new ActionLog[list.size()]);
	}
}


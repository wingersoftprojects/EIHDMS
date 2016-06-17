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

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="ActionLog")
public class ActionLog implements Serializable {
	public ActionLog() {
	}
	
	public static ActionLog loadActionLogByORMID(int logNo) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadActionLogByORMID(session, logNo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ActionLog getActionLogByORMID(int logNo) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getActionLogByORMID(session, logNo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ActionLog loadActionLogByORMID(int logNo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadActionLogByORMID(session, logNo, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ActionLog getActionLogByORMID(int logNo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getActionLogByORMID(session, logNo, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ActionLog loadActionLogByORMID(PersistentSession session, int logNo) throws PersistentException {
		try {
			return (ActionLog) session.load(ehmis.ActionLog.class, new Integer(logNo));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ActionLog getActionLogByORMID(PersistentSession session, int logNo) throws PersistentException {
		try {
			return (ActionLog) session.get(ehmis.ActionLog.class, new Integer(logNo));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ActionLog loadActionLogByORMID(PersistentSession session, int logNo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ActionLog) session.load(ehmis.ActionLog.class, new Integer(logNo), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ActionLog getActionLogByORMID(PersistentSession session, int logNo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ActionLog) session.get(ehmis.ActionLog.class, new Integer(logNo), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryActionLog(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryActionLog(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryActionLog(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryActionLog(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ActionLog[] listActionLogByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listActionLogByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ActionLog[] listActionLogByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listActionLogByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryActionLog(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ehmis.ActionLog as ActionLog");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryActionLog(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ehmis.ActionLog as ActionLog");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ActionLog", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ActionLog[] listActionLogByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryActionLog(session, condition, orderBy);
			return (ActionLog[]) list.toArray(new ActionLog[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ActionLog[] listActionLogByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryActionLog(session, condition, orderBy, lockMode);
			return (ActionLog[]) list.toArray(new ActionLog[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ActionLog loadActionLogByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadActionLogByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ActionLog loadActionLogByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadActionLogByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ActionLog loadActionLogByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		ActionLog[] actionLogs = listActionLogByQuery(session, condition, orderBy);
		if (actionLogs != null && actionLogs.length > 0)
			return actionLogs[0];
		else
			return null;
	}
	
	public static ActionLog loadActionLogByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		ActionLog[] actionLogs = listActionLogByQuery(session, condition, orderBy, lockMode);
		if (actionLogs != null && actionLogs.length > 0)
			return actionLogs[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateActionLogByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateActionLogByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateActionLogByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateActionLogByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateActionLogByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ehmis.ActionLog as ActionLog");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateActionLogByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ehmis.ActionLog as ActionLog");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ActionLog", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ActionLog loadActionLogByCriteria(ActionLogCriteria actionLogCriteria) {
		ActionLog[] actionLogs = listActionLogByCriteria(actionLogCriteria);
		if(actionLogs == null || actionLogs.length == 0) {
			return null;
		}
		return actionLogs[0];
	}
	
	public static ActionLog[] listActionLogByCriteria(ActionLogCriteria actionLogCriteria) {
		return actionLogCriteria.listActionLog();
	}
	
	public static ActionLog createActionLog() {
		return new ehmis.ActionLog();
	}
	
	public boolean save() throws PersistentException {
		try {
			eihdms.EIHDMSPersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			eihdms.EIHDMSPersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			eihdms.EIHDMSPersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			eihdms.EIHDMSPersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	@Column(name="LogNo", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EHMIS_ACTIONLOG_LOGNO_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EHMIS_ACTIONLOG_LOGNO_GENERATOR", strategy="native")	
	private int logNo;
	
	@Column(name="LogDay", nullable=false, length=11)	
	private int logDay;
	
	@Column(name="LogMonth", nullable=false, length=11)	
	private int logMonth;
	
	@Column(name="LogYear", nullable=false, length=11)	
	private int logYear;
	
	@Column(name="UserNo", nullable=false, length=11)	
	private int userNo;
	
	@Column(name="UserName", nullable=true, length=255)	
	private String userName;
	
	@Column(name="PermissionNo", nullable=false, length=11)	
	private int permissionNo;
	
	@Column(name="PermissionName", nullable=true, length=255)	
	private String permissionName;
	
	private void setLogNo(int value) {
		this.logNo = value;
	}
	
	public int getLogNo() {
		return logNo;
	}
	
	public int getORMID() {
		return getLogNo();
	}
	
	public void setLogDay(int value) {
		this.logDay = value;
	}
	
	public int getLogDay() {
		return logDay;
	}
	
	public void setLogMonth(int value) {
		this.logMonth = value;
	}
	
	public int getLogMonth() {
		return logMonth;
	}
	
	public void setLogYear(int value) {
		this.logYear = value;
	}
	
	public int getLogYear() {
		return logYear;
	}
	
	public void setUserNo(int value) {
		this.userNo = value;
	}
	
	public int getUserNo() {
		return userNo;
	}
	
	public void setUserName(String value) {
		this.userName = value;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setPermissionNo(int value) {
		this.permissionNo = value;
	}
	
	public int getPermissionNo() {
		return permissionNo;
	}
	
	public void setPermissionName(String value) {
		this.permissionName = value;
	}
	
	public String getPermissionName() {
		return permissionName;
	}
	
	public String toString() {
		return String.valueOf(getLogNo());
	}
	
}

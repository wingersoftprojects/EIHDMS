/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Wence
 * License Type: Purchased
 */
package eihdms;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="access_scope")
public class Access_scope implements Serializable {
	public Access_scope() {
	}
	
	public static Access_scope loadAccess_scopeByORMID(int access_scope_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadAccess_scopeByORMID(session, access_scope_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope getAccess_scopeByORMID(int access_scope_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getAccess_scopeByORMID(session, access_scope_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope loadAccess_scopeByORMID(int access_scope_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadAccess_scopeByORMID(session, access_scope_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope getAccess_scopeByORMID(int access_scope_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getAccess_scopeByORMID(session, access_scope_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope loadAccess_scopeByORMID(PersistentSession session, int access_scope_id) throws PersistentException {
		try {
			return (Access_scope) session.load(eihdms.Access_scope.class, new Integer(access_scope_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope getAccess_scopeByORMID(PersistentSession session, int access_scope_id) throws PersistentException {
		try {
			return (Access_scope) session.get(eihdms.Access_scope.class, new Integer(access_scope_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope loadAccess_scopeByORMID(PersistentSession session, int access_scope_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Access_scope) session.load(eihdms.Access_scope.class, new Integer(access_scope_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope getAccess_scopeByORMID(PersistentSession session, int access_scope_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Access_scope) session.get(eihdms.Access_scope.class, new Integer(access_scope_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAccess_scope(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryAccess_scope(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAccess_scope(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryAccess_scope(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope[] listAccess_scopeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listAccess_scopeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope[] listAccess_scopeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listAccess_scopeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAccess_scope(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Access_scope as Access_scope");
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
	
	public static List queryAccess_scope(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Access_scope as Access_scope");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Access_scope", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope[] listAccess_scopeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAccess_scope(session, condition, orderBy);
			return (Access_scope[]) list.toArray(new Access_scope[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope[] listAccess_scopeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAccess_scope(session, condition, orderBy, lockMode);
			return (Access_scope[]) list.toArray(new Access_scope[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope loadAccess_scopeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadAccess_scopeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope loadAccess_scopeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadAccess_scopeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope loadAccess_scopeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Access_scope[] access_scopes = listAccess_scopeByQuery(session, condition, orderBy);
		if (access_scopes != null && access_scopes.length > 0)
			return access_scopes[0];
		else
			return null;
	}
	
	public static Access_scope loadAccess_scopeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Access_scope[] access_scopes = listAccess_scopeByQuery(session, condition, orderBy, lockMode);
		if (access_scopes != null && access_scopes.length > 0)
			return access_scopes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAccess_scopeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateAccess_scopeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAccess_scopeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateAccess_scopeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAccess_scopeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Access_scope as Access_scope");
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
	
	public static java.util.Iterator iterateAccess_scopeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Access_scope as Access_scope");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Access_scope", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Access_scope loadAccess_scopeByCriteria(Access_scopeCriteria access_scopeCriteria) {
		Access_scope[] access_scopes = listAccess_scopeByCriteria(access_scopeCriteria);
		if(access_scopes == null || access_scopes.length == 0) {
			return null;
		}
		return access_scopes[0];
	}
	
	public static Access_scope[] listAccess_scopeByCriteria(Access_scopeCriteria access_scopeCriteria) {
		return access_scopeCriteria.listAccess_scope();
	}
	
	public static Access_scope createAccess_scope() {
		return new eihdms.Access_scope();
	}
	
	public boolean save() throws PersistentException {
		try {
			EIHDMSPersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			EIHDMSPersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			EIHDMSPersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			EIHDMSPersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate()throws PersistentException {
		try {
			if(getUser_detail() != null) {
				getUser_detail().getAccess_scope().remove(this);
			}
			
			if(getRegion() != null) {
				getRegion().getAccess_scope().remove(this);
			}
			
			if(getDistrict() != null) {
				getDistrict().getAccess_scope().remove(this);
			}
			
			if(getCounty() != null) {
				getCounty().getAccess_scope().remove(this);
			}
			
			if(getSub_county() != null) {
				getSub_county().getAccess_scope().remove(this);
			}
			
			if(getParish() != null) {
				getParish().getAccess_scope().remove(this);
			}
			
			if(getHealth_facility() != null) {
				getHealth_facility().getAccess_scope().remove(this);
			}
			
			return delete();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(org.orm.PersistentSession session)throws PersistentException {
		try {
			if(getUser_detail() != null) {
				getUser_detail().getAccess_scope().remove(this);
			}
			
			if(getRegion() != null) {
				getRegion().getAccess_scope().remove(this);
			}
			
			if(getDistrict() != null) {
				getDistrict().getAccess_scope().remove(this);
			}
			
			if(getCounty() != null) {
				getCounty().getAccess_scope().remove(this);
			}
			
			if(getSub_county() != null) {
				getSub_county().getAccess_scope().remove(this);
			}
			
			if(getParish() != null) {
				getParish().getAccess_scope().remove(this);
			}
			
			if(getHealth_facility() != null) {
				getHealth_facility().getAccess_scope().remove(this);
			}
			
			try {
				session.delete(this);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	@Column(name="access_scope_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_ACCESS_SCOPE_ACCESS_SCOPE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_ACCESS_SCOPE_ACCESS_SCOPE_ID_GENERATOR", strategy="native")	
	private int access_scope_id;
	
	@ManyToOne(targetEntity=eihdms.User_detail.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="user_detail_id", referencedColumnName="user_detail_id", nullable=false) }, foreignKey=@ForeignKey(name="FKaccess_sco501789"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.User_detail user_detail;
	
	@ManyToOne(targetEntity=eihdms.Region.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="region_id", referencedColumnName="region_id") }, foreignKey=@ForeignKey(name="FKaccess_sco658777"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Region region;
	
	@ManyToOne(targetEntity=eihdms.District.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="district_id", referencedColumnName="district_id") }, foreignKey=@ForeignKey(name="FKaccess_sco464218"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.District district;
	
	@ManyToOne(targetEntity=eihdms.County.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="county_id", referencedColumnName="county_id") }, foreignKey=@ForeignKey(name="FKaccess_sco114602"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.County county;
	
	@ManyToOne(targetEntity=eihdms.Sub_county.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="sub_county_id", referencedColumnName="sub_county_id") }, foreignKey=@ForeignKey(name="FKaccess_sco450360"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Sub_county sub_county;
	
	@ManyToOne(targetEntity=eihdms.Parish.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="parish_id", referencedColumnName="parish_id") }, foreignKey=@ForeignKey(name="FKaccess_sco579026"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Parish parish;
	
	@ManyToOne(targetEntity=eihdms.Health_facility.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="health_facility_id", referencedColumnName="health_facility_id") }, foreignKey=@ForeignKey(name="FKaccess_sco613427"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Health_facility health_facility;
	
	@Column(name="is_deleted", nullable=false, length=1)	
	private int is_deleted;
	
	@Column(name="is_active", nullable=false, length=1)	
	private int is_active;
	
	@Column(name="add_date", nullable=false)	
	private java.sql.Timestamp add_date;
	
	@Column(name="add_by", nullable=false, length=10)	
	private Integer add_by;
	
	@Column(name="last_edit_date", nullable=true)	
	private java.sql.Timestamp last_edit_date;
	
	@Column(name="last_edit_by", nullable=true, length=10)	
	private Integer last_edit_by;
	
	private void setAccess_scope_id(int value) {
		this.access_scope_id = value;
	}
	
	public int getAccess_scope_id() {
		return access_scope_id;
	}
	
	public int getORMID() {
		return getAccess_scope_id();
	}
	
	public void setIs_deleted(int value) {
		this.is_deleted = value;
	}
	
	public int getIs_deleted() {
		return is_deleted;
	}
	
	public void setIs_active(int value) {
		this.is_active = value;
	}
	
	public int getIs_active() {
		return is_active;
	}
	
	public void setAdd_date(java.sql.Timestamp value) {
		this.add_date = value;
	}
	
	public java.sql.Timestamp getAdd_date() {
		return add_date;
	}
	
	public void setAdd_by(int value) {
		setAdd_by(new Integer(value));
	}
	
	public void setAdd_by(Integer value) {
		this.add_by = value;
	}
	
	public Integer getAdd_by() {
		return add_by;
	}
	
	public void setLast_edit_date(java.sql.Timestamp value) {
		this.last_edit_date = value;
	}
	
	public java.sql.Timestamp getLast_edit_date() {
		return last_edit_date;
	}
	
	public void setLast_edit_by(int value) {
		setLast_edit_by(new Integer(value));
	}
	
	public void setLast_edit_by(Integer value) {
		this.last_edit_by = value;
	}
	
	public Integer getLast_edit_by() {
		return last_edit_by;
	}
	
	public void setRegion(eihdms.Region value) {
		this.region = value;
	}
	
	public eihdms.Region getRegion() {
		return region;
	}
	
	public void setCounty(eihdms.County value) {
		this.county = value;
	}
	
	public eihdms.County getCounty() {
		return county;
	}
	
	public void setSub_county(eihdms.Sub_county value) {
		this.sub_county = value;
	}
	
	public eihdms.Sub_county getSub_county() {
		return sub_county;
	}
	
	public void setParish(eihdms.Parish value) {
		this.parish = value;
	}
	
	public eihdms.Parish getParish() {
		return parish;
	}
	
	public void setHealth_facility(eihdms.Health_facility value) {
		this.health_facility = value;
	}
	
	public eihdms.Health_facility getHealth_facility() {
		return health_facility;
	}
	
	public void setDistrict(eihdms.District value) {
		this.district = value;
	}
	
	public eihdms.District getDistrict() {
		return district;
	}
	
	public void setUser_detail(eihdms.User_detail value) {
		this.user_detail = value;
	}
	
	public eihdms.User_detail getUser_detail() {
		return user_detail;
	}
	
	/**
	 * Testing
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Access_scope object = (Access_scope) obj;
		return (this.getAccess_scope_id() == object.getAccess_scope_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getAccess_scope_id());
	}
	
}

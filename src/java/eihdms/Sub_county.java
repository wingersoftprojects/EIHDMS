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
@Table(name="sub_county")
public class Sub_county implements Serializable {
	public Sub_county() {
	}
	
	public static Sub_county loadSub_countyByORMID(int sub_county_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSub_countyByORMID(session, sub_county_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_county getSub_countyByORMID(int sub_county_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getSub_countyByORMID(session, sub_county_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_county loadSub_countyByORMID(int sub_county_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSub_countyByORMID(session, sub_county_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_county getSub_countyByORMID(int sub_county_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getSub_countyByORMID(session, sub_county_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_county loadSub_countyByORMID(PersistentSession session, int sub_county_id) throws PersistentException {
		try {
			return (Sub_county) session.load(eihdms.Sub_county.class, new Integer(sub_county_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_county getSub_countyByORMID(PersistentSession session, int sub_county_id) throws PersistentException {
		try {
			return (Sub_county) session.get(eihdms.Sub_county.class, new Integer(sub_county_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_county loadSub_countyByORMID(PersistentSession session, int sub_county_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sub_county) session.load(eihdms.Sub_county.class, new Integer(sub_county_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_county getSub_countyByORMID(PersistentSession session, int sub_county_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sub_county) session.get(eihdms.Sub_county.class, new Integer(sub_county_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySub_county(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return querySub_county(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySub_county(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return querySub_county(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_county[] listSub_countyByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listSub_countyByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_county[] listSub_countyByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listSub_countyByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySub_county(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sub_county as Sub_county");
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
	
	public static List querySub_county(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sub_county as Sub_county");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sub_county", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_county[] listSub_countyByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySub_county(session, condition, orderBy);
			return (Sub_county[]) list.toArray(new Sub_county[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_county[] listSub_countyByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySub_county(session, condition, orderBy, lockMode);
			return (Sub_county[]) list.toArray(new Sub_county[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_county loadSub_countyByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSub_countyByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_county loadSub_countyByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSub_countyByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_county loadSub_countyByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Sub_county[] sub_countys = listSub_countyByQuery(session, condition, orderBy);
		if (sub_countys != null && sub_countys.length > 0)
			return sub_countys[0];
		else
			return null;
	}
	
	public static Sub_county loadSub_countyByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Sub_county[] sub_countys = listSub_countyByQuery(session, condition, orderBy, lockMode);
		if (sub_countys != null && sub_countys.length > 0)
			return sub_countys[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSub_countyByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateSub_countyByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSub_countyByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateSub_countyByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSub_countyByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sub_county as Sub_county");
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
	
	public static java.util.Iterator iterateSub_countyByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sub_county as Sub_county");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sub_county", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_county loadSub_countyByCriteria(Sub_countyCriteria sub_countyCriteria) {
		Sub_county[] sub_countys = listSub_countyByCriteria(sub_countyCriteria);
		if(sub_countys == null || sub_countys.length == 0) {
			return null;
		}
		return sub_countys[0];
	}
	
	public static Sub_county[] listSub_countyByCriteria(Sub_countyCriteria sub_countyCriteria) {
		return sub_countyCriteria.listSub_county();
	}
	
	public static Sub_county createSub_county() {
		return new eihdms.Sub_county();
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
			if(getCounty() != null) {
				getCounty().getSub_county().remove(this);
			}
			
			eihdms.Parish[] lParishs = (eihdms.Parish[])getParish().toArray(new eihdms.Parish[getParish().size()]);
			for(int i = 0; i < lParishs.length; i++) {
				lParishs[i].setSub_county(null);
			}
			eihdms.Health_facility[] lHealth_facilitys = (eihdms.Health_facility[])getHealth_facility().toArray(new eihdms.Health_facility[getHealth_facility().size()]);
			for(int i = 0; i < lHealth_facilitys.length; i++) {
				lHealth_facilitys[i].setSub_county(null);
			}
			eihdms.Base_data[] lBase_datas = (eihdms.Base_data[])getBase_data().toArray(new eihdms.Base_data[getBase_data().size()]);
			for(int i = 0; i < lBase_datas.length; i++) {
				lBase_datas[i].setSub_county(null);
			}
			eihdms.Access_scope[] lAccess_scopes = (eihdms.Access_scope[])getAccess_scope().toArray(new eihdms.Access_scope[getAccess_scope().size()]);
			for(int i = 0; i < lAccess_scopes.length; i++) {
				lAccess_scopes[i].setSub_county(null);
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
			if(getCounty() != null) {
				getCounty().getSub_county().remove(this);
			}
			
			eihdms.Parish[] lParishs = (eihdms.Parish[])getParish().toArray(new eihdms.Parish[getParish().size()]);
			for(int i = 0; i < lParishs.length; i++) {
				lParishs[i].setSub_county(null);
			}
			eihdms.Health_facility[] lHealth_facilitys = (eihdms.Health_facility[])getHealth_facility().toArray(new eihdms.Health_facility[getHealth_facility().size()]);
			for(int i = 0; i < lHealth_facilitys.length; i++) {
				lHealth_facilitys[i].setSub_county(null);
			}
			eihdms.Base_data[] lBase_datas = (eihdms.Base_data[])getBase_data().toArray(new eihdms.Base_data[getBase_data().size()]);
			for(int i = 0; i < lBase_datas.length; i++) {
				lBase_datas[i].setSub_county(null);
			}
			eihdms.Access_scope[] lAccess_scopes = (eihdms.Access_scope[])getAccess_scope().toArray(new eihdms.Access_scope[getAccess_scope().size()]);
			for(int i = 0; i < lAccess_scopes.length; i++) {
				lAccess_scopes[i].setSub_county(null);
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
	
	@Column(name="sub_county_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_SUB_COUNTY_SUB_COUNTY_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_SUB_COUNTY_SUB_COUNTY_ID_GENERATOR", strategy="native")	
	private int sub_county_id;
	
	@Column(name="sub_county_name", nullable=true, length=100)	
	private String sub_county_name;
	
	@ManyToOne(targetEntity=eihdms.County.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="county_id", referencedColumnName="county_id", nullable=false) }, foreignKey=@ForeignKey(name="FKsub_county278438"))	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.County county;
	
	@Column(name="is_deleted", nullable=true, length=1)	
	private Integer is_deleted;
	
	@Column(name="is_active", nullable=true, length=1)	
	private Integer is_active;
	
	@Column(name="add_date", nullable=true)	
	private java.sql.Timestamp add_date;
	
	@Column(name="add_by", nullable=true, length=10)	
	private Integer add_by;
	
	@Column(name="last_edit_date", nullable=true)	
	private java.sql.Timestamp last_edit_date;
	
	@Column(name="last_edit_by", nullable=true, length=10)	
	private Integer last_edit_by;
	
	@OneToMany(mappedBy="sub_county", targetEntity=eihdms.Parish.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set parish = new java.util.HashSet();
	
	@OneToMany(mappedBy="sub_county", targetEntity=eihdms.Health_facility.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set health_facility = new java.util.HashSet();
	
	@OneToMany(mappedBy="sub_county", targetEntity=eihdms.Base_data.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set base_data = new java.util.HashSet();
	
	@OneToMany(mappedBy="sub_county", targetEntity=eihdms.Access_scope.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set access_scope = new java.util.HashSet();
	
	private void setSub_county_id(int value) {
		this.sub_county_id = value;
	}
	
	public int getSub_county_id() {
		return sub_county_id;
	}
	
	public int getORMID() {
		return getSub_county_id();
	}
	
	public void setSub_county_name(String value) {
		this.sub_county_name = value;
	}
	
	public String getSub_county_name() {
		return sub_county_name;
	}
	
	public void setIs_deleted(int value) {
		setIs_deleted(new Integer(value));
	}
	
	public void setIs_deleted(Integer value) {
		this.is_deleted = value;
	}
	
	public Integer getIs_deleted() {
		return is_deleted;
	}
	
	public void setIs_active(int value) {
		setIs_active(new Integer(value));
	}
	
	public void setIs_active(Integer value) {
		this.is_active = value;
	}
	
	public Integer getIs_active() {
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
	
	public void setCounty(eihdms.County value) {
		this.county = value;
	}
	
	public eihdms.County getCounty() {
		return county;
	}
	
	public void setParish(java.util.Set value) {
		this.parish = value;
	}
	
	public java.util.Set getParish() {
		return parish;
	}
	
	
	public void setHealth_facility(java.util.Set value) {
		this.health_facility = value;
	}
	
	public java.util.Set getHealth_facility() {
		return health_facility;
	}
	
	
	public void setBase_data(java.util.Set value) {
		this.base_data = value;
	}
	
	public java.util.Set getBase_data() {
		return base_data;
	}
	
	
	public void setAccess_scope(java.util.Set value) {
		this.access_scope = value;
	}
	
	public java.util.Set getAccess_scope() {
		return access_scope;
	}
	
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Sub_county object = (Sub_county) obj;
		return (this.getSub_county_id() == object.getSub_county_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getSub_county_id());
	}
	
}

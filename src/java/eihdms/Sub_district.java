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

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="sub_district")
public class Sub_district implements Serializable {
	public Sub_district() {
	}
	
	public static Sub_district loadSub_districtByORMID(int sub_district_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSub_districtByORMID(session, sub_district_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_district getSub_districtByORMID(int sub_district_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getSub_districtByORMID(session, sub_district_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_district loadSub_districtByORMID(int sub_district_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSub_districtByORMID(session, sub_district_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_district getSub_districtByORMID(int sub_district_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getSub_districtByORMID(session, sub_district_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_district loadSub_districtByORMID(PersistentSession session, int sub_district_id) throws PersistentException {
		try {
			return (Sub_district) session.load(eihdms.Sub_district.class, new Integer(sub_district_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_district getSub_districtByORMID(PersistentSession session, int sub_district_id) throws PersistentException {
		try {
			return (Sub_district) session.get(eihdms.Sub_district.class, new Integer(sub_district_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_district loadSub_districtByORMID(PersistentSession session, int sub_district_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sub_district) session.load(eihdms.Sub_district.class, new Integer(sub_district_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_district getSub_districtByORMID(PersistentSession session, int sub_district_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sub_district) session.get(eihdms.Sub_district.class, new Integer(sub_district_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySub_district(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return querySub_district(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySub_district(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return querySub_district(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_district[] listSub_districtByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listSub_districtByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_district[] listSub_districtByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listSub_districtByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySub_district(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sub_district as Sub_district");
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
	
	public static List querySub_district(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sub_district as Sub_district");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sub_district", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_district[] listSub_districtByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySub_district(session, condition, orderBy);
			return (Sub_district[]) list.toArray(new Sub_district[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_district[] listSub_districtByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySub_district(session, condition, orderBy, lockMode);
			return (Sub_district[]) list.toArray(new Sub_district[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_district loadSub_districtByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSub_districtByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_district loadSub_districtByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSub_districtByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_district loadSub_districtByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Sub_district[] sub_districts = listSub_districtByQuery(session, condition, orderBy);
		if (sub_districts != null && sub_districts.length > 0)
			return sub_districts[0];
		else
			return null;
	}
	
	public static Sub_district loadSub_districtByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Sub_district[] sub_districts = listSub_districtByQuery(session, condition, orderBy, lockMode);
		if (sub_districts != null && sub_districts.length > 0)
			return sub_districts[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSub_districtByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateSub_districtByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSub_districtByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateSub_districtByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSub_districtByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sub_district as Sub_district");
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
	
	public static java.util.Iterator iterateSub_districtByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sub_district as Sub_district");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sub_district", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_district loadSub_districtByCriteria(Sub_districtCriteria sub_districtCriteria) {
		Sub_district[] sub_districts = listSub_districtByCriteria(sub_districtCriteria);
		if(sub_districts == null || sub_districts.length == 0) {
			return null;
		}
		return sub_districts[0];
	}
	
	public static Sub_district[] listSub_districtByCriteria(Sub_districtCriteria sub_districtCriteria) {
		return sub_districtCriteria.listSub_district();
	}
	
	public static Sub_district createSub_district() {
		return new eihdms.Sub_district();
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
			if(getDistrict() != null) {
				getDistrict().getSub_district().remove(this);
			}
			
			eihdms.Health_facility[] lHealth_facilitys = (eihdms.Health_facility[])getHealth_facility().toArray(new eihdms.Health_facility[getHealth_facility().size()]);
			for(int i = 0; i < lHealth_facilitys.length; i++) {
				lHealth_facilitys[i].setSub_district(null);
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
			if(getDistrict() != null) {
				getDistrict().getSub_district().remove(this);
			}
			
			eihdms.Health_facility[] lHealth_facilitys = (eihdms.Health_facility[])getHealth_facility().toArray(new eihdms.Health_facility[getHealth_facility().size()]);
			for(int i = 0; i < lHealth_facilitys.length; i++) {
				lHealth_facilitys[i].setSub_district(null);
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
	
	@Column(name="sub_district_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_SUB_DISTRICT_SUB_DISTRICT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_SUB_DISTRICT_SUB_DISTRICT_ID_GENERATOR", strategy="native")	
	private int sub_district_id;
	
	@Column(name="sub_district_name", nullable=true, length=100)	
	private String sub_district_name;
	
	@ManyToOne(targetEntity=eihdms.District.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="district_id", referencedColumnName="district_id", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.District district;
	
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
	
	@OneToMany(mappedBy="sub_district", targetEntity=eihdms.Health_facility.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set health_facility = new java.util.HashSet();
	
	private void setSub_district_id(int value) {
		this.sub_district_id = value;
	}
	
	public int getSub_district_id() {
		return sub_district_id;
	}
	
	public int getORMID() {
		return getSub_district_id();
	}
	
	public void setSub_district_name(String value) {
		this.sub_district_name = value;
	}
	
	public String getSub_district_name() {
		return sub_district_name;
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
	
	public void setDistrict(eihdms.District value) {
		this.district = value;
	}
	
	public eihdms.District getDistrict() {
		return district;
	}
	
	public void setHealth_facility(java.util.Set value) {
		this.health_facility = value;
	}
	
	public java.util.Set getHealth_facility() {
		return health_facility;
	}
	
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Sub_district object = (Sub_district) obj;
		return (this.getSub_district_id() == object.getSub_district_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getSub_district_id());
	}
	
}

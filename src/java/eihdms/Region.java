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
@Table(name="region")
public class Region implements Serializable {
	public Region() {
	}
	
	public static Region loadRegionByORMID(int region_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadRegionByORMID(session, region_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Region getRegionByORMID(int region_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getRegionByORMID(session, region_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Region loadRegionByORMID(int region_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadRegionByORMID(session, region_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Region getRegionByORMID(int region_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getRegionByORMID(session, region_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Region loadRegionByORMID(PersistentSession session, int region_id) throws PersistentException {
		try {
			return (Region) session.load(eihdms.Region.class, new Integer(region_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Region getRegionByORMID(PersistentSession session, int region_id) throws PersistentException {
		try {
			return (Region) session.get(eihdms.Region.class, new Integer(region_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Region loadRegionByORMID(PersistentSession session, int region_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Region) session.load(eihdms.Region.class, new Integer(region_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Region getRegionByORMID(PersistentSession session, int region_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Region) session.get(eihdms.Region.class, new Integer(region_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRegion(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryRegion(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRegion(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryRegion(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Region[] listRegionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listRegionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Region[] listRegionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listRegionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRegion(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Region as Region");
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
	
	public static List queryRegion(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Region as Region");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Region", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Region[] listRegionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryRegion(session, condition, orderBy);
			return (Region[]) list.toArray(new Region[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Region[] listRegionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryRegion(session, condition, orderBy, lockMode);
			return (Region[]) list.toArray(new Region[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Region loadRegionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadRegionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Region loadRegionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadRegionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Region loadRegionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Region[] regions = listRegionByQuery(session, condition, orderBy);
		if (regions != null && regions.length > 0)
			return regions[0];
		else
			return null;
	}
	
	public static Region loadRegionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Region[] regions = listRegionByQuery(session, condition, orderBy, lockMode);
		if (regions != null && regions.length > 0)
			return regions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRegionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateRegionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRegionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateRegionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRegionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Region as Region");
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
	
	public static java.util.Iterator iterateRegionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Region as Region");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Region", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Region loadRegionByCriteria(RegionCriteria regionCriteria) {
		Region[] regions = listRegionByCriteria(regionCriteria);
		if(regions == null || regions.length == 0) {
			return null;
		}
		return regions[0];
	}
	
	public static Region[] listRegionByCriteria(RegionCriteria regionCriteria) {
		return regionCriteria.listRegion();
	}
	
	public static Region createRegion() {
		return new eihdms.Region();
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
			eihdms.District[] lDistricts = (eihdms.District[])getDistrict().toArray(new eihdms.District[getDistrict().size()]);
			for(int i = 0; i < lDistricts.length; i++) {
				lDistricts[i].setRegion(null);
			}
			eihdms.Health_facility[] lHealth_facilitys = (eihdms.Health_facility[])getHealth_facility().toArray(new eihdms.Health_facility[getHealth_facility().size()]);
			for(int i = 0; i < lHealth_facilitys.length; i++) {
				lHealth_facilitys[i].setRegion(null);
			}
			eihdms.Access_scope[] lAccess_scopes = (eihdms.Access_scope[])getAccess_scope().toArray(new eihdms.Access_scope[getAccess_scope().size()]);
			for(int i = 0; i < lAccess_scopes.length; i++) {
				lAccess_scopes[i].setRegion(null);
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
			eihdms.District[] lDistricts = (eihdms.District[])getDistrict().toArray(new eihdms.District[getDistrict().size()]);
			for(int i = 0; i < lDistricts.length; i++) {
				lDistricts[i].setRegion(null);
			}
			eihdms.Health_facility[] lHealth_facilitys = (eihdms.Health_facility[])getHealth_facility().toArray(new eihdms.Health_facility[getHealth_facility().size()]);
			for(int i = 0; i < lHealth_facilitys.length; i++) {
				lHealth_facilitys[i].setRegion(null);
			}
			eihdms.Access_scope[] lAccess_scopes = (eihdms.Access_scope[])getAccess_scope().toArray(new eihdms.Access_scope[getAccess_scope().size()]);
			for(int i = 0; i < lAccess_scopes.length; i++) {
				lAccess_scopes[i].setRegion(null);
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
	
	@Column(name="region_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_REGION_REGION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_REGION_REGION_ID_GENERATOR", strategy="native")	
	private int region_id;
	
	@Column(name="region_name", nullable=true, length=100)	
	private String region_name;
	
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
	
	@OneToMany(mappedBy="region", targetEntity=eihdms.District.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set district = new java.util.HashSet();
	
	@OneToMany(mappedBy="region", targetEntity=eihdms.Health_facility.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set health_facility = new java.util.HashSet();
	
	@OneToMany(mappedBy="region", targetEntity=eihdms.Access_scope.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set access_scope = new java.util.HashSet();
	
	private void setRegion_id(int value) {
		this.region_id = value;
	}
	
	public int getRegion_id() {
		return region_id;
	}
	
	public int getORMID() {
		return getRegion_id();
	}
	
	public void setRegion_name(String value) {
		this.region_name = value;
	}
	
	public String getRegion_name() {
		return region_name;
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
	
	public void setDistrict(java.util.Set value) {
		this.district = value;
	}
	
	public java.util.Set getDistrict() {
		return district;
	}
	
	
	public void setHealth_facility(java.util.Set value) {
		this.health_facility = value;
	}
	
	public java.util.Set getHealth_facility() {
		return health_facility;
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
		Region object = (Region) obj;
		return (this.getRegion_id() == object.getRegion_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getRegion_id());
	}
	
}

/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: bajuna
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
@Table(name="facility_level")
public class Facility_level implements Serializable {
	public Facility_level() {
	}
	
	public static Facility_level loadFacility_levelByORMID(int facility_level_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadFacility_levelByORMID(session, facility_level_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facility_level getFacility_levelByORMID(int facility_level_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getFacility_levelByORMID(session, facility_level_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facility_level loadFacility_levelByORMID(int facility_level_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadFacility_levelByORMID(session, facility_level_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facility_level getFacility_levelByORMID(int facility_level_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getFacility_levelByORMID(session, facility_level_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facility_level loadFacility_levelByORMID(PersistentSession session, int facility_level_id) throws PersistentException {
		try {
			return (Facility_level) session.load(eihdms.Facility_level.class, new Integer(facility_level_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facility_level getFacility_levelByORMID(PersistentSession session, int facility_level_id) throws PersistentException {
		try {
			return (Facility_level) session.get(eihdms.Facility_level.class, new Integer(facility_level_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facility_level loadFacility_levelByORMID(PersistentSession session, int facility_level_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Facility_level) session.load(eihdms.Facility_level.class, new Integer(facility_level_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facility_level getFacility_levelByORMID(PersistentSession session, int facility_level_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Facility_level) session.get(eihdms.Facility_level.class, new Integer(facility_level_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFacility_level(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryFacility_level(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFacility_level(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryFacility_level(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facility_level[] listFacility_levelByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listFacility_levelByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facility_level[] listFacility_levelByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listFacility_levelByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFacility_level(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Facility_level as Facility_level");
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
	
	public static List queryFacility_level(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Facility_level as Facility_level");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Facility_level", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facility_level[] listFacility_levelByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryFacility_level(session, condition, orderBy);
			return (Facility_level[]) list.toArray(new Facility_level[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facility_level[] listFacility_levelByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryFacility_level(session, condition, orderBy, lockMode);
			return (Facility_level[]) list.toArray(new Facility_level[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facility_level loadFacility_levelByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadFacility_levelByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facility_level loadFacility_levelByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadFacility_levelByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facility_level loadFacility_levelByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Facility_level[] facility_levels = listFacility_levelByQuery(session, condition, orderBy);
		if (facility_levels != null && facility_levels.length > 0)
			return facility_levels[0];
		else
			return null;
	}
	
	public static Facility_level loadFacility_levelByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Facility_level[] facility_levels = listFacility_levelByQuery(session, condition, orderBy, lockMode);
		if (facility_levels != null && facility_levels.length > 0)
			return facility_levels[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateFacility_levelByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateFacility_levelByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFacility_levelByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateFacility_levelByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFacility_levelByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Facility_level as Facility_level");
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
	
	public static java.util.Iterator iterateFacility_levelByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Facility_level as Facility_level");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Facility_level", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Facility_level loadFacility_levelByCriteria(Facility_levelCriteria facility_levelCriteria) {
		Facility_level[] facility_levels = listFacility_levelByCriteria(facility_levelCriteria);
		if(facility_levels == null || facility_levels.length == 0) {
			return null;
		}
		return facility_levels[0];
	}
	
	public static Facility_level[] listFacility_levelByCriteria(Facility_levelCriteria facility_levelCriteria) {
		return facility_levelCriteria.listFacility_level();
	}
	
	public static Facility_level createFacility_level() {
		return new eihdms.Facility_level();
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
	
	public boolean deleteAndDissociate()throws PersistentException {
		try {
			eihdms.Health_facility[] lHealth_facilitys = (eihdms.Health_facility[])getHealth_facility().toArray(new eihdms.Health_facility[getHealth_facility().size()]);
			for(int i = 0; i < lHealth_facilitys.length; i++) {
				lHealth_facilitys[i].setFacility_level(null);
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
			eihdms.Health_facility[] lHealth_facilitys = (eihdms.Health_facility[])getHealth_facility().toArray(new eihdms.Health_facility[getHealth_facility().size()]);
			for(int i = 0; i < lHealth_facilitys.length; i++) {
				lHealth_facilitys[i].setFacility_level(null);
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
	
	@Column(name="facility_level_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_FACILITY_LEVEL_FACILITY_LEVEL_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_FACILITY_LEVEL_FACILITY_LEVEL_ID_GENERATOR", strategy="native")	
	private int facility_level_id;
	
	@Column(name="facility_level_name", nullable=true, length=100)	
	private String facility_level_name;
	
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
	
	@OneToMany(mappedBy="facility_level", targetEntity=eihdms.Health_facility.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set health_facility = new java.util.HashSet();
	
	private void setFacility_level_id(int value) {
		this.facility_level_id = value;
	}
	
	public int getFacility_level_id() {
		return facility_level_id;
	}
	
	public int getORMID() {
		return getFacility_level_id();
	}
	
	public void setFacility_level_name(String value) {
		this.facility_level_name = value;
	}
	
	public String getFacility_level_name() {
		return facility_level_name;
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
		Facility_level object = (Facility_level) obj;
		return (this.getFacility_level_id() == object.getFacility_level_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getFacility_level_id());
	}
	
}

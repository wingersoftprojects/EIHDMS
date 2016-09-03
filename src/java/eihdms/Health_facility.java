/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: btwesigye
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
@Table(name="health_facility")
public class Health_facility implements Serializable {
	public Health_facility() {
	}
	
	public static Health_facility loadHealth_facilityByORMID(int health_facility_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadHealth_facilityByORMID(session, health_facility_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Health_facility getHealth_facilityByORMID(int health_facility_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getHealth_facilityByORMID(session, health_facility_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Health_facility loadHealth_facilityByORMID(int health_facility_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadHealth_facilityByORMID(session, health_facility_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Health_facility getHealth_facilityByORMID(int health_facility_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getHealth_facilityByORMID(session, health_facility_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Health_facility loadHealth_facilityByORMID(PersistentSession session, int health_facility_id) throws PersistentException {
		try {
			return (Health_facility) session.load(eihdms.Health_facility.class, new Integer(health_facility_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Health_facility getHealth_facilityByORMID(PersistentSession session, int health_facility_id) throws PersistentException {
		try {
			return (Health_facility) session.get(eihdms.Health_facility.class, new Integer(health_facility_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Health_facility loadHealth_facilityByORMID(PersistentSession session, int health_facility_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Health_facility) session.load(eihdms.Health_facility.class, new Integer(health_facility_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Health_facility getHealth_facilityByORMID(PersistentSession session, int health_facility_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Health_facility) session.get(eihdms.Health_facility.class, new Integer(health_facility_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHealth_facility(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryHealth_facility(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHealth_facility(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryHealth_facility(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Health_facility[] listHealth_facilityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listHealth_facilityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Health_facility[] listHealth_facilityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listHealth_facilityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHealth_facility(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Health_facility as Health_facility");
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
	
	public static List queryHealth_facility(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Health_facility as Health_facility");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Health_facility", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Health_facility[] listHealth_facilityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryHealth_facility(session, condition, orderBy);
			return (Health_facility[]) list.toArray(new Health_facility[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Health_facility[] listHealth_facilityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryHealth_facility(session, condition, orderBy, lockMode);
			return (Health_facility[]) list.toArray(new Health_facility[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Health_facility loadHealth_facilityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadHealth_facilityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Health_facility loadHealth_facilityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadHealth_facilityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Health_facility loadHealth_facilityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Health_facility[] health_facilitys = listHealth_facilityByQuery(session, condition, orderBy);
		if (health_facilitys != null && health_facilitys.length > 0)
			return health_facilitys[0];
		else
			return null;
	}
	
	public static Health_facility loadHealth_facilityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Health_facility[] health_facilitys = listHealth_facilityByQuery(session, condition, orderBy, lockMode);
		if (health_facilitys != null && health_facilitys.length > 0)
			return health_facilitys[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateHealth_facilityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateHealth_facilityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHealth_facilityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateHealth_facilityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHealth_facilityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Health_facility as Health_facility");
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
	
	public static java.util.Iterator iterateHealth_facilityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Health_facility as Health_facility");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Health_facility", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Health_facility loadHealth_facilityByCriteria(Health_facilityCriteria health_facilityCriteria) {
		Health_facility[] health_facilitys = listHealth_facilityByCriteria(health_facilityCriteria);
		if(health_facilitys == null || health_facilitys.length == 0) {
			return null;
		}
		return health_facilitys[0];
	}
	
	public static Health_facility[] listHealth_facilityByCriteria(Health_facilityCriteria health_facilityCriteria) {
		return health_facilityCriteria.listHealth_facility();
	}
	
	public static Health_facility createHealth_facility() {
		return new eihdms.Health_facility();
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
			if(getRegion() != null) {
				getRegion().getHealth_facility().remove(this);
			}
			
			if(getDistrict() != null) {
				getDistrict().getHealth_facility().remove(this);
			}
			
			if(getSub_district() != null) {
				getSub_district().getHealth_facility().remove(this);
			}
			
			if(getCounty() != null) {
				getCounty().getHealth_facility().remove(this);
			}
			
			if(getSub_county() != null) {
				getSub_county().getHealth_facility().remove(this);
			}
			
			if(getParish() != null) {
				getParish().getHealth_facility().remove(this);
			}
			
			if(getFacility_level() != null) {
				getFacility_level().getHealth_facility().remove(this);
			}
			
			eihdms.Base_data[] lBase_datas = (eihdms.Base_data[])getBase_data().toArray(new eihdms.Base_data[getBase_data().size()]);
			for(int i = 0; i < lBase_datas.length; i++) {
				lBase_datas[i].setHealth_facility(null);
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
			if(getRegion() != null) {
				getRegion().getHealth_facility().remove(this);
			}
			
			if(getDistrict() != null) {
				getDistrict().getHealth_facility().remove(this);
			}
			
			if(getSub_district() != null) {
				getSub_district().getHealth_facility().remove(this);
			}
			
			if(getCounty() != null) {
				getCounty().getHealth_facility().remove(this);
			}
			
			if(getSub_county() != null) {
				getSub_county().getHealth_facility().remove(this);
			}
			
			if(getParish() != null) {
				getParish().getHealth_facility().remove(this);
			}
			
			if(getFacility_level() != null) {
				getFacility_level().getHealth_facility().remove(this);
			}
			
			eihdms.Base_data[] lBase_datas = (eihdms.Base_data[])getBase_data().toArray(new eihdms.Base_data[getBase_data().size()]);
			for(int i = 0; i < lBase_datas.length; i++) {
				lBase_datas[i].setHealth_facility(null);
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
	
	@Column(name="health_facility_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_HEALTH_FACILITY_HEALTH_FACILITY_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_HEALTH_FACILITY_HEALTH_FACILITY_ID_GENERATOR", strategy="native")	
	private int health_facility_id;
	
	@Column(name="health_facility_name", nullable=true, length=100)	
	private String health_facility_name;
	
	@ManyToOne(targetEntity=eihdms.Region.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="region_id", referencedColumnName="region_id", nullable=false) })	
	private eihdms.Region region;
	
	@ManyToOne(targetEntity=eihdms.District.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="district_id", referencedColumnName="district_id", nullable=false) })	
	private eihdms.District district;
	
	@ManyToOne(targetEntity=eihdms.Sub_district.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="sub_district_id", referencedColumnName="sub_district_id", nullable=false) })	
	private eihdms.Sub_district sub_district;
	
	@ManyToOne(targetEntity=eihdms.County.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="county_id", referencedColumnName="county_id", nullable=false) })	
	private eihdms.County county;
	
	@ManyToOne(targetEntity=eihdms.Sub_county.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="sub_county_id", referencedColumnName="sub_county_id", nullable=false) })	
	private eihdms.Sub_county sub_county;
	
	@ManyToOne(targetEntity=eihdms.Parish.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="parish_id", referencedColumnName="parish_id", nullable=false) })	
	private eihdms.Parish parish;
	
	@ManyToOne(targetEntity=eihdms.Facility_level.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="facility_level_id", referencedColumnName="facility_level_id", nullable=false) })	
	private eihdms.Facility_level facility_level;
	
	@Column(name="xcoordinate", nullable=true, length=100)	
	private String xcoordinate;
	
	@Column(name="ycoordinate", nullable=true, length=100)	
	private String ycoordinate;
	
	@Column(name="zcoordinate", nullable=true, length=100)	
	private String zcoordinate;
	
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
	
	@Column(name="ownership", nullable=true, length=50)	
	private String ownership;
	
	@OneToMany(mappedBy="health_facility", targetEntity=eihdms.Base_data.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set base_data = new java.util.HashSet();
	
	private void setHealth_facility_id(int value) {
		this.health_facility_id = value;
	}
	
	public int getHealth_facility_id() {
		return health_facility_id;
	}
	
	public int getORMID() {
		return getHealth_facility_id();
	}
	
	public void setHealth_facility_name(String value) {
		this.health_facility_name = value;
	}
	
	public String getHealth_facility_name() {
		return health_facility_name;
	}
	
	public void setXcoordinate(String value) {
		this.xcoordinate = value;
	}
	
	public String getXcoordinate() {
		return xcoordinate;
	}
	
	public void setYcoordinate(String value) {
		this.ycoordinate = value;
	}
	
	public String getYcoordinate() {
		return ycoordinate;
	}
	
	public void setZcoordinate(String value) {
		this.zcoordinate = value;
	}
	
	public String getZcoordinate() {
		return zcoordinate;
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
	
	public void setOwnership(String value) {
		this.ownership = value;
	}
	
	public String getOwnership() {
		return ownership;
	}
	
	public void setRegion(eihdms.Region value) {
		this.region = value;
	}
	
	public eihdms.Region getRegion() {
		return region;
	}
	
	public void setDistrict(eihdms.District value) {
		this.district = value;
	}
	
	public eihdms.District getDistrict() {
		return district;
	}
	
	public void setCounty(eihdms.County value) {
		this.county = value;
	}
	
	public eihdms.County getCounty() {
		return county;
	}
	
	public void setSub_district(eihdms.Sub_district value) {
		this.sub_district = value;
	}
	
	public eihdms.Sub_district getSub_district() {
		return sub_district;
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
	
	public void setFacility_level(eihdms.Facility_level value) {
		this.facility_level = value;
	}
	
	public eihdms.Facility_level getFacility_level() {
		return facility_level;
	}
	
	public void setBase_data(java.util.Set value) {
		this.base_data = value;
	}
	
	public java.util.Set getBase_data() {
		return base_data;
	}
	
	
	@Override	
	public int hashCode() {
		int hash = 3;
				return hash;
	}
	
	@Override	
	public boolean equals(Object obj) {
		if (obj == null) {
				            return false;
				        }
				        Health_facility object = (Health_facility) obj;
				        return (this.getHealth_facility_id() == object.getHealth_facility_id());
	}
	
	public String toString() {
		return String.valueOf(getHealth_facility_id());
	}
	
}

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
@Table(name="district")
public class District implements Serializable {
	public District() {
	}
	
	public static District loadDistrictByORMID(int district_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadDistrictByORMID(session, district_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static District getDistrictByORMID(int district_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getDistrictByORMID(session, district_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static District loadDistrictByORMID(int district_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadDistrictByORMID(session, district_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static District getDistrictByORMID(int district_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getDistrictByORMID(session, district_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static District loadDistrictByORMID(PersistentSession session, int district_id) throws PersistentException {
		try {
			return (District) session.load(eihdms.District.class, new Integer(district_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static District getDistrictByORMID(PersistentSession session, int district_id) throws PersistentException {
		try {
			return (District) session.get(eihdms.District.class, new Integer(district_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static District loadDistrictByORMID(PersistentSession session, int district_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (District) session.load(eihdms.District.class, new Integer(district_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static District getDistrictByORMID(PersistentSession session, int district_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (District) session.get(eihdms.District.class, new Integer(district_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDistrict(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryDistrict(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDistrict(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryDistrict(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static District[] listDistrictByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listDistrictByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static District[] listDistrictByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listDistrictByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDistrict(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.District as District");
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
	
	public static List queryDistrict(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.District as District");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("District", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static District[] listDistrictByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryDistrict(session, condition, orderBy);
			return (District[]) list.toArray(new District[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static District[] listDistrictByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryDistrict(session, condition, orderBy, lockMode);
			return (District[]) list.toArray(new District[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static District loadDistrictByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadDistrictByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static District loadDistrictByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadDistrictByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static District loadDistrictByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		District[] districts = listDistrictByQuery(session, condition, orderBy);
		if (districts != null && districts.length > 0)
			return districts[0];
		else
			return null;
	}
	
	public static District loadDistrictByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		District[] districts = listDistrictByQuery(session, condition, orderBy, lockMode);
		if (districts != null && districts.length > 0)
			return districts[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDistrictByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateDistrictByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDistrictByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateDistrictByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDistrictByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.District as District");
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
	
	public static java.util.Iterator iterateDistrictByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.District as District");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("District", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static District loadDistrictByCriteria(DistrictCriteria districtCriteria) {
		District[] districts = listDistrictByCriteria(districtCriteria);
		if(districts == null || districts.length == 0) {
			return null;
		}
		return districts[0];
	}
	
	public static District[] listDistrictByCriteria(DistrictCriteria districtCriteria) {
		return districtCriteria.listDistrict();
	}
	
	public static District createDistrict() {
		return new eihdms.District();
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
				getRegion().getDistrict().remove(this);
			}
			
			eihdms.Sub_district[] lSub_districts = (eihdms.Sub_district[])getSub_district().toArray(new eihdms.Sub_district[getSub_district().size()]);
			for(int i = 0; i < lSub_districts.length; i++) {
				lSub_districts[i].setDistrict(null);
			}
			eihdms.County[] lCountys = (eihdms.County[])getCounty().toArray(new eihdms.County[getCounty().size()]);
			for(int i = 0; i < lCountys.length; i++) {
				lCountys[i].setDistrict(null);
			}
			eihdms.Health_facility[] lHealth_facilitys = (eihdms.Health_facility[])getHealth_facility().toArray(new eihdms.Health_facility[getHealth_facility().size()]);
			for(int i = 0; i < lHealth_facilitys.length; i++) {
				lHealth_facilitys[i].setDistrict(null);
			}
			eihdms.Base_data[] lBase_datas = (eihdms.Base_data[])getBase_data().toArray(new eihdms.Base_data[getBase_data().size()]);
			for(int i = 0; i < lBase_datas.length; i++) {
				lBase_datas[i].setDistrict(null);
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
				getRegion().getDistrict().remove(this);
			}
			
			eihdms.Sub_district[] lSub_districts = (eihdms.Sub_district[])getSub_district().toArray(new eihdms.Sub_district[getSub_district().size()]);
			for(int i = 0; i < lSub_districts.length; i++) {
				lSub_districts[i].setDistrict(null);
			}
			eihdms.County[] lCountys = (eihdms.County[])getCounty().toArray(new eihdms.County[getCounty().size()]);
			for(int i = 0; i < lCountys.length; i++) {
				lCountys[i].setDistrict(null);
			}
			eihdms.Health_facility[] lHealth_facilitys = (eihdms.Health_facility[])getHealth_facility().toArray(new eihdms.Health_facility[getHealth_facility().size()]);
			for(int i = 0; i < lHealth_facilitys.length; i++) {
				lHealth_facilitys[i].setDistrict(null);
			}
			eihdms.Base_data[] lBase_datas = (eihdms.Base_data[])getBase_data().toArray(new eihdms.Base_data[getBase_data().size()]);
			for(int i = 0; i < lBase_datas.length; i++) {
				lBase_datas[i].setDistrict(null);
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
	
	@Column(name="district_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_DISTRICT_DISTRICT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_DISTRICT_DISTRICT_ID_GENERATOR", strategy="native")	
	private int district_id;
	
	@Column(name="district_name", nullable=true, length=100)	
	private String district_name;
	
	@ManyToOne(targetEntity=eihdms.Region.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="region_id", referencedColumnName="region_id", nullable=false) })	
	private eihdms.Region region;
	
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
	
	@OneToMany(mappedBy="district", targetEntity=eihdms.Sub_district.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set sub_district = new java.util.HashSet();
	
	@OneToMany(mappedBy="district", targetEntity=eihdms.County.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set county = new java.util.HashSet();
	
	@OneToMany(mappedBy="district", targetEntity=eihdms.Health_facility.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set health_facility = new java.util.HashSet();
	
	@OneToMany(mappedBy="district", targetEntity=eihdms.Base_data.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set base_data = new java.util.HashSet();
	
	private void setDistrict_id(int value) {
		this.district_id = value;
	}
	
	public int getDistrict_id() {
		return district_id;
	}
	
	public int getORMID() {
		return getDistrict_id();
	}
	
	public void setDistrict_name(String value) {
		this.district_name = value;
	}
	
	public String getDistrict_name() {
		return district_name;
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
	
	public void setRegion(eihdms.Region value) {
		this.region = value;
	}
	
	public eihdms.Region getRegion() {
		return region;
	}
	
	public void setSub_district(java.util.Set value) {
		this.sub_district = value;
	}
	
	public java.util.Set getSub_district() {
		return sub_district;
	}
	
	
	public void setCounty(java.util.Set value) {
		this.county = value;
	}
	
	public java.util.Set getCounty() {
		return county;
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
				        District object = (District) obj;
				        return (this.getDistrict_id() == object.getDistrict_id());
	}
	
	public String toString() {
		return String.valueOf(getDistrict_id());
	}
	
}

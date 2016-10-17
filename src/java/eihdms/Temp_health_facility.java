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
@Table(name="temp_health_facility")
public class Temp_health_facility implements Serializable {
	public Temp_health_facility() {
	}
	
	public static Temp_health_facility loadTemp_health_facilityByORMID(int temp_health_facility_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadTemp_health_facilityByORMID(session, temp_health_facility_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_health_facility getTemp_health_facilityByORMID(int temp_health_facility_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getTemp_health_facilityByORMID(session, temp_health_facility_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_health_facility loadTemp_health_facilityByORMID(int temp_health_facility_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadTemp_health_facilityByORMID(session, temp_health_facility_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_health_facility getTemp_health_facilityByORMID(int temp_health_facility_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getTemp_health_facilityByORMID(session, temp_health_facility_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_health_facility loadTemp_health_facilityByORMID(PersistentSession session, int temp_health_facility_id) throws PersistentException {
		try {
			return (Temp_health_facility) session.load(eihdms.Temp_health_facility.class, new Integer(temp_health_facility_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_health_facility getTemp_health_facilityByORMID(PersistentSession session, int temp_health_facility_id) throws PersistentException {
		try {
			return (Temp_health_facility) session.get(eihdms.Temp_health_facility.class, new Integer(temp_health_facility_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_health_facility loadTemp_health_facilityByORMID(PersistentSession session, int temp_health_facility_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Temp_health_facility) session.load(eihdms.Temp_health_facility.class, new Integer(temp_health_facility_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_health_facility getTemp_health_facilityByORMID(PersistentSession session, int temp_health_facility_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Temp_health_facility) session.get(eihdms.Temp_health_facility.class, new Integer(temp_health_facility_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTemp_health_facility(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryTemp_health_facility(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTemp_health_facility(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryTemp_health_facility(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_health_facility[] listTemp_health_facilityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listTemp_health_facilityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_health_facility[] listTemp_health_facilityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listTemp_health_facilityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTemp_health_facility(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Temp_health_facility as Temp_health_facility");
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
	
	public static List queryTemp_health_facility(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Temp_health_facility as Temp_health_facility");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Temp_health_facility", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_health_facility[] listTemp_health_facilityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryTemp_health_facility(session, condition, orderBy);
			return (Temp_health_facility[]) list.toArray(new Temp_health_facility[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_health_facility[] listTemp_health_facilityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTemp_health_facility(session, condition, orderBy, lockMode);
			return (Temp_health_facility[]) list.toArray(new Temp_health_facility[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_health_facility loadTemp_health_facilityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadTemp_health_facilityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_health_facility loadTemp_health_facilityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadTemp_health_facilityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_health_facility loadTemp_health_facilityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Temp_health_facility[] temp_health_facilitys = listTemp_health_facilityByQuery(session, condition, orderBy);
		if (temp_health_facilitys != null && temp_health_facilitys.length > 0)
			return temp_health_facilitys[0];
		else
			return null;
	}
	
	public static Temp_health_facility loadTemp_health_facilityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Temp_health_facility[] temp_health_facilitys = listTemp_health_facilityByQuery(session, condition, orderBy, lockMode);
		if (temp_health_facilitys != null && temp_health_facilitys.length > 0)
			return temp_health_facilitys[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateTemp_health_facilityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateTemp_health_facilityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTemp_health_facilityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateTemp_health_facilityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTemp_health_facilityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Temp_health_facility as Temp_health_facility");
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
	
	public static java.util.Iterator iterateTemp_health_facilityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Temp_health_facility as Temp_health_facility");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Temp_health_facility", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_health_facility loadTemp_health_facilityByCriteria(Temp_health_facilityCriteria temp_health_facilityCriteria) {
		Temp_health_facility[] temp_health_facilitys = listTemp_health_facilityByCriteria(temp_health_facilityCriteria);
		if(temp_health_facilitys == null || temp_health_facilitys.length == 0) {
			return null;
		}
		return temp_health_facilitys[0];
	}
	
	public static Temp_health_facility[] listTemp_health_facilityByCriteria(Temp_health_facilityCriteria temp_health_facilityCriteria) {
		return temp_health_facilityCriteria.listTemp_health_facility();
	}
	
	public static Temp_health_facility createTemp_health_facility() {
		return new eihdms.Temp_health_facility();
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
	
	@Column(name="temp_health_facility_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_TEMP_HEALTH_FACILITY_TEMP_HEALTH_FACILITY_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_TEMP_HEALTH_FACILITY_TEMP_HEALTH_FACILITY_ID_GENERATOR", strategy="native")	
	private int temp_health_facility_id;
	
	@Column(name="health_facility_name", nullable=false)	
	private String health_facility_name;
	
	@Column(name="region_name", nullable=false)	
	private String region_name;
	
	@Column(name="district_name", nullable=false)	
	private String district_name;
	
	@Column(name="sub_district_name", nullable=false)	
	private String sub_district_name;
	
	@Column(name="county_name", nullable=false)	
	private String county_name;
	
	@Column(name="sub_county_name", nullable=false)	
	private String sub_county_name;
	
	@Column(name="parish_name", nullable=false)	
	private String parish_name;
	
	@Column(name="facility_level_name", nullable=false)	
	private String facility_level_name;
	
	@Column(name="xcoordinate", nullable=true, length=100)	
	private String xcoordinate;
	
	@Column(name="ycoordinate", nullable=true, length=100)	
	private String ycoordinate;
	
	@Column(name="zcoordinate", nullable=true, length=100)	
	private String zcoordinate;
	
	@Column(name="ownership", nullable=true, length=50)	
	private String ownership;
	
	@Column(name="short_name", nullable=true, length=100)	
	private String short_name;
	
	@Column(name="is_active", nullable=false, length=3)	
	private String is_active;
	
	private void setTemp_health_facility_id(int value) {
		this.temp_health_facility_id = value;
	}
	
	public int getTemp_health_facility_id() {
		return temp_health_facility_id;
	}
	
	public int getORMID() {
		return getTemp_health_facility_id();
	}
	
	public void setHealth_facility_name(String value) {
		this.health_facility_name = value;
	}
	
	public String getHealth_facility_name() {
		return health_facility_name;
	}
	
	public void setRegion_name(String value) {
		this.region_name = value;
	}
	
	public String getRegion_name() {
		return region_name;
	}
	
	public void setDistrict_name(String value) {
		this.district_name = value;
	}
	
	public String getDistrict_name() {
		return district_name;
	}
	
	public void setSub_district_name(String value) {
		this.sub_district_name = value;
	}
	
	public String getSub_district_name() {
		return sub_district_name;
	}
	
	public void setCounty_name(String value) {
		this.county_name = value;
	}
	
	public String getCounty_name() {
		return county_name;
	}
	
	public void setSub_county_name(String value) {
		this.sub_county_name = value;
	}
	
	public String getSub_county_name() {
		return sub_county_name;
	}
	
	public void setParish_name(String value) {
		this.parish_name = value;
	}
	
	public String getParish_name() {
		return parish_name;
	}
	
	public void setFacility_level_name(String value) {
		this.facility_level_name = value;
	}
	
	public String getFacility_level_name() {
		return facility_level_name;
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
	
	public void setOwnership(String value) {
		this.ownership = value;
	}
	
	public String getOwnership() {
		return ownership;
	}
	
	public void setShort_name(String value) {
		this.short_name = value;
	}
	
	public String getShort_name() {
		return short_name;
	}
	
	public void setIs_active(String value) {
		this.is_active = value;
	}
	
	public String getIs_active() {
		return is_active;
	}
	
	public String toString() {
		return String.valueOf(getTemp_health_facility_id());
	}
	
}

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
@Table(name="parish")
public class Parish implements Serializable {
	public Parish() {
	}
	
	public static Parish loadParishByORMID(int parish_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadParishByORMID(session, parish_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Parish getParishByORMID(int parish_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getParishByORMID(session, parish_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Parish loadParishByORMID(int parish_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadParishByORMID(session, parish_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Parish getParishByORMID(int parish_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getParishByORMID(session, parish_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Parish loadParishByORMID(PersistentSession session, int parish_id) throws PersistentException {
		try {
			return (Parish) session.load(eihdms.Parish.class, new Integer(parish_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Parish getParishByORMID(PersistentSession session, int parish_id) throws PersistentException {
		try {
			return (Parish) session.get(eihdms.Parish.class, new Integer(parish_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Parish loadParishByORMID(PersistentSession session, int parish_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Parish) session.load(eihdms.Parish.class, new Integer(parish_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Parish getParishByORMID(PersistentSession session, int parish_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Parish) session.get(eihdms.Parish.class, new Integer(parish_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryParish(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryParish(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryParish(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return queryParish(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Parish[] listParishByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listParishByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Parish[] listParishByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listParishByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryParish(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Parish as Parish");
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
	
	public static List queryParish(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Parish as Parish");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Parish", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Parish[] listParishByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryParish(session, condition, orderBy);
			return (Parish[]) list.toArray(new Parish[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Parish[] listParishByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryParish(session, condition, orderBy, lockMode);
			return (Parish[]) list.toArray(new Parish[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Parish loadParishByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadParishByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Parish loadParishByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadParishByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Parish loadParishByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Parish[] parishs = listParishByQuery(session, condition, orderBy);
		if (parishs != null && parishs.length > 0)
			return parishs[0];
		else
			return null;
	}
	
	public static Parish loadParishByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Parish[] parishs = listParishByQuery(session, condition, orderBy, lockMode);
		if (parishs != null && parishs.length > 0)
			return parishs[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateParishByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateParishByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateParishByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateParishByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateParishByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Parish as Parish");
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
	
	public static java.util.Iterator iterateParishByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Parish as Parish");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Parish", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Parish loadParishByCriteria(ParishCriteria parishCriteria) {
		Parish[] parishs = listParishByCriteria(parishCriteria);
		if(parishs == null || parishs.length == 0) {
			return null;
		}
		return parishs[0];
	}
	
	public static Parish[] listParishByCriteria(ParishCriteria parishCriteria) {
		return parishCriteria.listParish();
	}
	
	public static Parish createParish() {
		return new eihdms.Parish();
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
			if(getSub_county() != null) {
				getSub_county().getParish().remove(this);
			}
			
			eihdms.Health_facility[] lHealth_facilitys = (eihdms.Health_facility[])getHealth_facility().toArray(new eihdms.Health_facility[getHealth_facility().size()]);
			for(int i = 0; i < lHealth_facilitys.length; i++) {
				lHealth_facilitys[i].setParish(null);
			}
			eihdms.Base_data[] lBase_datas = (eihdms.Base_data[])getBase_data().toArray(new eihdms.Base_data[getBase_data().size()]);
			for(int i = 0; i < lBase_datas.length; i++) {
				lBase_datas[i].setParish(null);
			}
			eihdms.Access_scope[] lAccess_scopes = (eihdms.Access_scope[])getAccess_scope().toArray(new eihdms.Access_scope[getAccess_scope().size()]);
			for(int i = 0; i < lAccess_scopes.length; i++) {
				lAccess_scopes[i].setParish(null);
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
			if(getSub_county() != null) {
				getSub_county().getParish().remove(this);
			}
			
			eihdms.Health_facility[] lHealth_facilitys = (eihdms.Health_facility[])getHealth_facility().toArray(new eihdms.Health_facility[getHealth_facility().size()]);
			for(int i = 0; i < lHealth_facilitys.length; i++) {
				lHealth_facilitys[i].setParish(null);
			}
			eihdms.Base_data[] lBase_datas = (eihdms.Base_data[])getBase_data().toArray(new eihdms.Base_data[getBase_data().size()]);
			for(int i = 0; i < lBase_datas.length; i++) {
				lBase_datas[i].setParish(null);
			}
			eihdms.Access_scope[] lAccess_scopes = (eihdms.Access_scope[])getAccess_scope().toArray(new eihdms.Access_scope[getAccess_scope().size()]);
			for(int i = 0; i < lAccess_scopes.length; i++) {
				lAccess_scopes[i].setParish(null);
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
	
	@Column(name="parish_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_PARISH_PARISH_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_PARISH_PARISH_ID_GENERATOR", strategy="native")	
	private int parish_id;
	
	@Column(name="parish_name", nullable=true, length=100)	
	private String parish_name;
	
	@ManyToOne(targetEntity=eihdms.Sub_county.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="sub_county_id", referencedColumnName="sub_county_id", nullable=false) })	
	private eihdms.Sub_county sub_county;
	
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
	
	@OneToMany(mappedBy="parish", targetEntity=eihdms.Health_facility.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set health_facility = new java.util.HashSet();
	
	@OneToMany(mappedBy="parish", targetEntity=eihdms.Base_data.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set base_data = new java.util.HashSet();
	
	@OneToMany(mappedBy="parish", targetEntity=eihdms.Access_scope.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set access_scope = new java.util.HashSet();
	
	private void setParish_id(int value) {
		this.parish_id = value;
	}
	
	public int getParish_id() {
		return parish_id;
	}
	
	public int getORMID() {
		return getParish_id();
	}
	
	public void setParish_name(String value) {
		this.parish_name = value;
	}
	
	public String getParish_name() {
		return parish_name;
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
	
	public void setSub_county(eihdms.Sub_county value) {
		this.sub_county = value;
	}
	
	public eihdms.Sub_county getSub_county() {
		return sub_county;
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
		Parish object = (Parish) obj;
		return (this.getParish_id() == object.getParish_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getParish_id());
	}
	
}

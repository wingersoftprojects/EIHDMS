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
@Table(name="sub_section")
public class Sub_section implements Serializable {
	public Sub_section() {
	}
	
	public static Sub_section loadSub_sectionByORMID(int sub_section_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadSub_sectionByORMID(session, sub_section_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section getSub_sectionByORMID(int sub_section_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getSub_sectionByORMID(session, sub_section_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section loadSub_sectionByORMID(int sub_section_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadSub_sectionByORMID(session, sub_section_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section getSub_sectionByORMID(int sub_section_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getSub_sectionByORMID(session, sub_section_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section loadSub_sectionByORMID(PersistentSession session, int sub_section_id) throws PersistentException {
		try {
			return (Sub_section) session.load(eihdms.Sub_section.class, new Integer(sub_section_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section getSub_sectionByORMID(PersistentSession session, int sub_section_id) throws PersistentException {
		try {
			return (Sub_section) session.get(eihdms.Sub_section.class, new Integer(sub_section_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section loadSub_sectionByORMID(PersistentSession session, int sub_section_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sub_section) session.load(eihdms.Sub_section.class, new Integer(sub_section_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section getSub_sectionByORMID(PersistentSession session, int sub_section_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sub_section) session.get(eihdms.Sub_section.class, new Integer(sub_section_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySub_section(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return querySub_section(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySub_section(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return querySub_section(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section[] listSub_sectionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listSub_sectionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section[] listSub_sectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listSub_sectionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySub_section(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sub_section as Sub_section");
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
	
	public static List querySub_section(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sub_section as Sub_section");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sub_section", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section[] listSub_sectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySub_section(session, condition, orderBy);
			return (Sub_section[]) list.toArray(new Sub_section[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section[] listSub_sectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySub_section(session, condition, orderBy, lockMode);
			return (Sub_section[]) list.toArray(new Sub_section[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section loadSub_sectionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadSub_sectionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section loadSub_sectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadSub_sectionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section loadSub_sectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Sub_section[] sub_sections = listSub_sectionByQuery(session, condition, orderBy);
		if (sub_sections != null && sub_sections.length > 0)
			return sub_sections[0];
		else
			return null;
	}
	
	public static Sub_section loadSub_sectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Sub_section[] sub_sections = listSub_sectionByQuery(session, condition, orderBy, lockMode);
		if (sub_sections != null && sub_sections.length > 0)
			return sub_sections[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSub_sectionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateSub_sectionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSub_sectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateSub_sectionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSub_sectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sub_section as Sub_section");
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
	
	public static java.util.Iterator iterateSub_sectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sub_section as Sub_section");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sub_section", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section loadSub_sectionByCriteria(Sub_sectionCriteria sub_sectionCriteria) {
		Sub_section[] sub_sections = listSub_sectionByCriteria(sub_sectionCriteria);
		if(sub_sections == null || sub_sections.length == 0) {
			return null;
		}
		return sub_sections[0];
	}
	
	public static Sub_section[] listSub_sectionByCriteria(Sub_sectionCriteria sub_sectionCriteria) {
		return sub_sectionCriteria.listSub_section();
	}
	
	public static Sub_section createSub_section() {
		return new eihdms.Sub_section();
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
			if(getSection() != null) {
				getSection().getSub_section().remove(this);
			}
			
			eihdms.Data_element[] lData_elements = (eihdms.Data_element[])getData_element().toArray(new eihdms.Data_element[getData_element().size()]);
			for(int i = 0; i < lData_elements.length; i++) {
				lData_elements[i].setSub_section(null);
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
			if(getSection() != null) {
				getSection().getSub_section().remove(this);
			}
			
			eihdms.Data_element[] lData_elements = (eihdms.Data_element[])getData_element().toArray(new eihdms.Data_element[getData_element().size()]);
			for(int i = 0; i < lData_elements.length; i++) {
				lData_elements[i].setSub_section(null);
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
	
	@Column(name="sub_section_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_SUB_SECTION_SUB_SECTION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_SUB_SECTION_SUB_SECTION_ID_GENERATOR", strategy="native")	
	private int sub_section_id;
	
	@Column(name="sub_section_name", nullable=false, length=100)	
	private String sub_section_name;
	
	@Column(name="sub_section_order", nullable=false, length=100)	
	private String sub_section_order;
	
	@ManyToOne(targetEntity=eihdms.Section.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="section_id", referencedColumnName="section_id", nullable=false) })	
	private eihdms.Section section;
	
	@Column(name="is_deleted", nullable=false, length=1)	
	private int is_deleted;
	
	@Column(name="is_active", nullable=false, length=1)	
	private int is_active;
	
	@Column(name="add_date", nullable=true)	
	private java.sql.Timestamp add_date;
	
	@Column(name="add_by", nullable=true, length=10)	
	private Integer add_by;
	
	@Column(name="last_edit_date", nullable=true)	
	private java.sql.Timestamp last_edit_date;
	
	@Column(name="last_edit_by", nullable=true, length=10)	
	private Integer last_edit_by;
	
	@OneToMany(mappedBy="sub_section", targetEntity=eihdms.Data_element.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set data_element = new java.util.HashSet();
	
	private void setSub_section_id(int value) {
		this.sub_section_id = value;
	}
	
	public int getSub_section_id() {
		return sub_section_id;
	}
	
	public int getORMID() {
		return getSub_section_id();
	}
	
	public void setSub_section_name(String value) {
		this.sub_section_name = value;
	}
	
	public String getSub_section_name() {
		return sub_section_name;
	}
	
	public void setSub_section_order(String value) {
		this.sub_section_order = value;
	}
	
	public String getSub_section_order() {
		return sub_section_order;
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
	
	public void setSection(eihdms.Section value) {
		this.section = value;
	}
	
	public eihdms.Section getSection() {
		return section;
	}
	
	public void setData_element(java.util.Set value) {
		this.data_element = value;
	}
	
	public java.util.Set getData_element() {
		return data_element;
	}
	
	
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Sub_section object = (Sub_section) obj;
		return (this.getSub_section_id() == object.getSub_section_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getSub_section_id());
	}
	
}

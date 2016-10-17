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
@Table(name="section")
public class Section implements Serializable {
	public Section() {
	}
	
	public static Section loadSectionByORMID(int section_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadSectionByORMID(session, section_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Section getSectionByORMID(int section_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getSectionByORMID(session, section_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Section loadSectionByORMID(int section_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadSectionByORMID(session, section_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Section getSectionByORMID(int section_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getSectionByORMID(session, section_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Section loadSectionByORMID(PersistentSession session, int section_id) throws PersistentException {
		try {
			return (Section) session.load(eihdms.Section.class, new Integer(section_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Section getSectionByORMID(PersistentSession session, int section_id) throws PersistentException {
		try {
			return (Section) session.get(eihdms.Section.class, new Integer(section_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Section loadSectionByORMID(PersistentSession session, int section_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Section) session.load(eihdms.Section.class, new Integer(section_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Section getSectionByORMID(PersistentSession session, int section_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Section) session.get(eihdms.Section.class, new Integer(section_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySection(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return querySection(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySection(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return querySection(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Section[] listSectionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listSectionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Section[] listSectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listSectionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySection(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Section as Section");
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
	
	public static List querySection(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Section as Section");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Section", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Section[] listSectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySection(session, condition, orderBy);
			return (Section[]) list.toArray(new Section[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Section[] listSectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySection(session, condition, orderBy, lockMode);
			return (Section[]) list.toArray(new Section[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Section loadSectionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadSectionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Section loadSectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadSectionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Section loadSectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Section[] sections = listSectionByQuery(session, condition, orderBy);
		if (sections != null && sections.length > 0)
			return sections[0];
		else
			return null;
	}
	
	public static Section loadSectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Section[] sections = listSectionByQuery(session, condition, orderBy, lockMode);
		if (sections != null && sections.length > 0)
			return sections[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSectionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateSectionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSectionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateSectionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSectionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Section as Section");
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
	
	public static java.util.Iterator iterateSectionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Section as Section");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Section", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Section loadSectionByCriteria(SectionCriteria sectionCriteria) {
		Section[] sections = listSectionByCriteria(sectionCriteria);
		if(sections == null || sections.length == 0) {
			return null;
		}
		return sections[0];
	}
	
	public static Section[] listSectionByCriteria(SectionCriteria sectionCriteria) {
		return sectionCriteria.listSection();
	}
	
	public static Section createSection() {
		return new eihdms.Section();
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
			if(getReport_form() != null) {
				getReport_form().getSection().remove(this);
			}
			
			eihdms.Data_element[] lData_elements = (eihdms.Data_element[])getData_element().toArray(new eihdms.Data_element[getData_element().size()]);
			for(int i = 0; i < lData_elements.length; i++) {
				lData_elements[i].setSection(null);
			}
			eihdms.Sub_section[] lSub_sections = (eihdms.Sub_section[])getSub_section().toArray(new eihdms.Sub_section[getSub_section().size()]);
			for(int i = 0; i < lSub_sections.length; i++) {
				lSub_sections[i].setSection(null);
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
			if(getReport_form() != null) {
				getReport_form().getSection().remove(this);
			}
			
			eihdms.Data_element[] lData_elements = (eihdms.Data_element[])getData_element().toArray(new eihdms.Data_element[getData_element().size()]);
			for(int i = 0; i < lData_elements.length; i++) {
				lData_elements[i].setSection(null);
			}
			eihdms.Sub_section[] lSub_sections = (eihdms.Sub_section[])getSub_section().toArray(new eihdms.Sub_section[getSub_section().size()]);
			for(int i = 0; i < lSub_sections.length; i++) {
				lSub_sections[i].setSection(null);
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
	
	@Column(name="section_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_SECTION_SECTION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_SECTION_SECTION_ID_GENERATOR", strategy="native")	
	private int section_id;
	
	@Column(name="section_name", nullable=false, length=100)	
	private String section_name;
	
	@Column(name="section_order", nullable=false, length=100)	
	private String section_order;
	
	@ManyToOne(targetEntity=eihdms.Report_form.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="report_form_id", referencedColumnName="report_form_id", nullable=false) })	
	private eihdms.Report_form report_form;
	
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
	
	@OneToMany(mappedBy="section", targetEntity=eihdms.Data_element.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set data_element = new java.util.HashSet();
	
	@OneToMany(mappedBy="section", targetEntity=eihdms.Sub_section.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set sub_section = new java.util.HashSet();
	
	private void setSection_id(int value) {
		this.section_id = value;
	}
	
	public int getSection_id() {
		return section_id;
	}
	
	public int getORMID() {
		return getSection_id();
	}
	
	public void setSection_name(String value) {
		this.section_name = value;
	}
	
	public String getSection_name() {
		return section_name;
	}
	
	public void setSection_order(String value) {
		this.section_order = value;
	}
	
	public String getSection_order() {
		return section_order;
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
	
	public void setReport_form(eihdms.Report_form value) {
		this.report_form = value;
	}
	
	public eihdms.Report_form getReport_form() {
		return report_form;
	}
	
	public void setData_element(java.util.Set value) {
		this.data_element = value;
	}
	
	public java.util.Set getData_element() {
		return data_element;
	}
	
	
	public void setSub_section(java.util.Set value) {
		this.sub_section = value;
	}
	
	public java.util.Set getSub_section() {
		return sub_section;
	}
	
	
	public String toString() {
		return String.valueOf(getSection_id());
	}
	
}

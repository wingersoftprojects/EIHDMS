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
@Table(name="data_element")
public class Data_element implements Serializable {
	public Data_element() {
	}
	
	public static Data_element loadData_elementByORMID(int data_element_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadData_elementByORMID(session, data_element_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element getData_elementByORMID(int data_element_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getData_elementByORMID(session, data_element_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element loadData_elementByORMID(int data_element_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadData_elementByORMID(session, data_element_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element getData_elementByORMID(int data_element_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getData_elementByORMID(session, data_element_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element loadData_elementByORMID(PersistentSession session, int data_element_id) throws PersistentException {
		try {
			return (Data_element) session.load(eihdms.Data_element.class, new Integer(data_element_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element getData_elementByORMID(PersistentSession session, int data_element_id) throws PersistentException {
		try {
			return (Data_element) session.get(eihdms.Data_element.class, new Integer(data_element_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element loadData_elementByORMID(PersistentSession session, int data_element_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Data_element) session.load(eihdms.Data_element.class, new Integer(data_element_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element getData_elementByORMID(PersistentSession session, int data_element_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Data_element) session.get(eihdms.Data_element.class, new Integer(data_element_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryData_element(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryData_element(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryData_element(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryData_element(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element[] listData_elementByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listData_elementByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element[] listData_elementByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listData_elementByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryData_element(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Data_element as Data_element");
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
	
	public static List queryData_element(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Data_element as Data_element");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Data_element", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element[] listData_elementByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryData_element(session, condition, orderBy);
			return (Data_element[]) list.toArray(new Data_element[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element[] listData_elementByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryData_element(session, condition, orderBy, lockMode);
			return (Data_element[]) list.toArray(new Data_element[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element loadData_elementByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadData_elementByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element loadData_elementByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadData_elementByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element loadData_elementByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Data_element[] data_elements = listData_elementByQuery(session, condition, orderBy);
		if (data_elements != null && data_elements.length > 0)
			return data_elements[0];
		else
			return null;
	}
	
	public static Data_element loadData_elementByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Data_element[] data_elements = listData_elementByQuery(session, condition, orderBy, lockMode);
		if (data_elements != null && data_elements.length > 0)
			return data_elements[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateData_elementByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateData_elementByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateData_elementByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateData_elementByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateData_elementByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Data_element as Data_element");
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
	
	public static java.util.Iterator iterateData_elementByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Data_element as Data_element");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Data_element", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Data_element loadData_elementByCriteria(Data_elementCriteria data_elementCriteria) {
		Data_element[] data_elements = listData_elementByCriteria(data_elementCriteria);
		if(data_elements == null || data_elements.length == 0) {
			return null;
		}
		return data_elements[0];
	}
	
	public static Data_element[] listData_elementByCriteria(Data_elementCriteria data_elementCriteria) {
		return data_elementCriteria.listData_element();
	}
	
	public static Data_element createData_element() {
		return new eihdms.Data_element();
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
				getReport_form().getData_element().remove(this);
			}
			
			if(getSection() != null) {
				getSection().getData_element().remove(this);
			}
			
			if(getSub_section() != null) {
				getSub_section().getData_element().remove(this);
			}
			
			if(getReport_form_group() != null) {
				getReport_form_group().getData_element().remove(this);
			}
			
			if(getTechnical_area() != null) {
				getTechnical_area().getData_element().remove(this);
			}
			
			eihdms.Interface_data[] lInterface_datas = (eihdms.Interface_data[])getInterface_data().toArray(new eihdms.Interface_data[getInterface_data().size()]);
			for(int i = 0; i < lInterface_datas.length; i++) {
				lInterface_datas[i].setData_element(null);
			}
			eihdms.Base_data[] lBase_datas = (eihdms.Base_data[])getBase_data().toArray(new eihdms.Base_data[getBase_data().size()]);
			for(int i = 0; i < lBase_datas.length; i++) {
				lBase_datas[i].setData_element(null);
			}
			eihdms.Standard_rule[] lStandard_rules = (eihdms.Standard_rule[])getStandard_rule().toArray(new eihdms.Standard_rule[getStandard_rule().size()]);
			for(int i = 0; i < lStandard_rules.length; i++) {
				lStandard_rules[i].setData_element(null);
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
				getReport_form().getData_element().remove(this);
			}
			
			if(getSection() != null) {
				getSection().getData_element().remove(this);
			}
			
			if(getSub_section() != null) {
				getSub_section().getData_element().remove(this);
			}
			
			if(getReport_form_group() != null) {
				getReport_form_group().getData_element().remove(this);
			}
			
			if(getTechnical_area() != null) {
				getTechnical_area().getData_element().remove(this);
			}
			
			eihdms.Interface_data[] lInterface_datas = (eihdms.Interface_data[])getInterface_data().toArray(new eihdms.Interface_data[getInterface_data().size()]);
			for(int i = 0; i < lInterface_datas.length; i++) {
				lInterface_datas[i].setData_element(null);
			}
			eihdms.Base_data[] lBase_datas = (eihdms.Base_data[])getBase_data().toArray(new eihdms.Base_data[getBase_data().size()]);
			for(int i = 0; i < lBase_datas.length; i++) {
				lBase_datas[i].setData_element(null);
			}
			eihdms.Standard_rule[] lStandard_rules = (eihdms.Standard_rule[])getStandard_rule().toArray(new eihdms.Standard_rule[getStandard_rule().size()]);
			for(int i = 0; i < lStandard_rules.length; i++) {
				lStandard_rules[i].setData_element(null);
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
	
	@Column(name="data_element_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_DATA_ELEMENT_DATA_ELEMENT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_DATA_ELEMENT_DATA_ELEMENT_ID_GENERATOR", strategy="native")	
	private int data_element_id;
	
	@ManyToOne(targetEntity=eihdms.Report_form.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="report_form_id", referencedColumnName="report_form_id", nullable=false) })	
	private eihdms.Report_form report_form;
	
	@ManyToOne(targetEntity=eihdms.Section.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="section_id", referencedColumnName="section_id", nullable=false) })	
	private eihdms.Section section;
	
	@ManyToOne(targetEntity=eihdms.Sub_section.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="sub_section_id", referencedColumnName="sub_section_id", nullable=false) })	
	private eihdms.Sub_section sub_section;
	
	@ManyToOne(targetEntity=eihdms.Report_form_group.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="report_form_group_id", referencedColumnName="report_form_group_id") })	
	private eihdms.Report_form_group report_form_group;
	
	@Column(name="section_column_number", nullable=true, length=10)	
	private Integer section_column_number;
	
	@Column(name="group_column_number", nullable=true, length=10)	
	private Integer group_column_number;
	
	@Column(name="data_element_name", nullable=true)	
	private String data_element_name;
	
	@Column(name="data_element_context", nullable=true)	
	private String data_element_context;
	
	@Column(name="data_type", nullable=true, length=100)	
	private String data_type;
	
	@Column(name="data_size", nullable=true, length=10)	
	private Integer data_size;
	
	@Column(name="age_category", nullable=true, length=100)	
	private String age_category;
	
	@Column(name="sex_category", nullable=true, length=100)	
	private String sex_category;
	
	@Column(name="other_category", nullable=true, length=100)	
	private String other_category;
	
	@ManyToOne(targetEntity=eihdms.Technical_area.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="technical_area_id", referencedColumnName="technical_area_id") })	
	private eihdms.Technical_area technical_area;
	
	@Column(name="description", nullable=true)	
	private String description;
	
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
	
	@Column(name="data_element_code", nullable=true, length=100)	
	private String data_element_code;
	
	@OneToMany(mappedBy="data_element", targetEntity=eihdms.Interface_data.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set interface_data = new java.util.HashSet();
	
	@OneToMany(mappedBy="data_element", targetEntity=eihdms.Base_data.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set base_data = new java.util.HashSet();
	
	@OneToMany(mappedBy="data_element", targetEntity=eihdms.Standard_rule.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set standard_rule = new java.util.HashSet();
	
	private void setData_element_id(int value) {
		this.data_element_id = value;
	}
	
	public int getData_element_id() {
		return data_element_id;
	}
	
	public int getORMID() {
		return getData_element_id();
	}
	
	public void setSection_column_number(int value) {
		setSection_column_number(new Integer(value));
	}
	
	public void setSection_column_number(Integer value) {
		this.section_column_number = value;
	}
	
	public Integer getSection_column_number() {
		return section_column_number;
	}
	
	public void setGroup_column_number(int value) {
		setGroup_column_number(new Integer(value));
	}
	
	public void setGroup_column_number(Integer value) {
		this.group_column_number = value;
	}
	
	public Integer getGroup_column_number() {
		return group_column_number;
	}
	
	public void setData_element_name(String value) {
		this.data_element_name = value;
	}
	
	public String getData_element_name() {
		return data_element_name;
	}
	
	public void setData_type(String value) {
		this.data_type = value;
	}
	
	public String getData_type() {
		return data_type;
	}
	
	public void setData_size(int value) {
		setData_size(new Integer(value));
	}
	
	public void setData_size(Integer value) {
		this.data_size = value;
	}
	
	public Integer getData_size() {
		return data_size;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
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
	
	public void setData_element_code(String value) {
		this.data_element_code = value;
	}
	
	public String getData_element_code() {
		return data_element_code;
	}
	
	public void setAge_category(String value) {
		this.age_category = value;
	}
	
	public String getAge_category() {
		return age_category;
	}
	
	public void setSex_category(String value) {
		this.sex_category = value;
	}
	
	public String getSex_category() {
		return sex_category;
	}
	
	public void setOther_category(String value) {
		this.other_category = value;
	}
	
	public String getOther_category() {
		return other_category;
	}
	
	public void setData_element_context(String value) {
		this.data_element_context = value;
	}
	
	public String getData_element_context() {
		return data_element_context;
	}
	
	public void setReport_form(eihdms.Report_form value) {
		this.report_form = value;
	}
	
	public eihdms.Report_form getReport_form() {
		return report_form;
	}
	
	public void setSection(eihdms.Section value) {
		this.section = value;
	}
	
	public eihdms.Section getSection() {
		return section;
	}
	
	public void setTechnical_area(eihdms.Technical_area value) {
		this.technical_area = value;
	}
	
	public eihdms.Technical_area getTechnical_area() {
		return technical_area;
	}
	
	public void setSub_section(eihdms.Sub_section value) {
		this.sub_section = value;
	}
	
	public eihdms.Sub_section getSub_section() {
		return sub_section;
	}
	
	public void setReport_form_group(eihdms.Report_form_group value) {
		this.report_form_group = value;
	}
	
	public eihdms.Report_form_group getReport_form_group() {
		return report_form_group;
	}
	
	public void setInterface_data(java.util.Set value) {
		this.interface_data = value;
	}
	
	public java.util.Set getInterface_data() {
		return interface_data;
	}
	
	
	public void setBase_data(java.util.Set value) {
		this.base_data = value;
	}
	
	public java.util.Set getBase_data() {
		return base_data;
	}
	
	
	public void setStandard_rule(java.util.Set value) {
		this.standard_rule = value;
	}
	
	public java.util.Set getStandard_rule() {
		return standard_rule;
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
				        Data_element object = (Data_element) obj;
				        return (this.getData_element_id() == object.getData_element_id());
	}
	
	public String toString() {
		return String.valueOf(getData_element_id());
	}
	
}

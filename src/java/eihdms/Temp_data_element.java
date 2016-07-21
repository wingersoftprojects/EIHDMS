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
@Table(name="temp_data_element")
public class Temp_data_element implements Serializable {
	public Temp_data_element() {
	}
	
	public static Temp_data_element loadTemp_data_elementByORMID(int temp_data_element_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadTemp_data_elementByORMID(session, temp_data_element_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_data_element getTemp_data_elementByORMID(int temp_data_element_id) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getTemp_data_elementByORMID(session, temp_data_element_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_data_element loadTemp_data_elementByORMID(int temp_data_element_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadTemp_data_elementByORMID(session, temp_data_element_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_data_element getTemp_data_elementByORMID(int temp_data_element_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return getTemp_data_elementByORMID(session, temp_data_element_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_data_element loadTemp_data_elementByORMID(PersistentSession session, int temp_data_element_id) throws PersistentException {
		try {
			return (Temp_data_element) session.load(eihdms.Temp_data_element.class, new Integer(temp_data_element_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_data_element getTemp_data_elementByORMID(PersistentSession session, int temp_data_element_id) throws PersistentException {
		try {
			return (Temp_data_element) session.get(eihdms.Temp_data_element.class, new Integer(temp_data_element_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_data_element loadTemp_data_elementByORMID(PersistentSession session, int temp_data_element_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Temp_data_element) session.load(eihdms.Temp_data_element.class, new Integer(temp_data_element_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_data_element getTemp_data_elementByORMID(PersistentSession session, int temp_data_element_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Temp_data_element) session.get(eihdms.Temp_data_element.class, new Integer(temp_data_element_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTemp_data_element(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryTemp_data_element(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTemp_data_element(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return queryTemp_data_element(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_data_element[] listTemp_data_elementByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listTemp_data_elementByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_data_element[] listTemp_data_elementByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return listTemp_data_elementByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTemp_data_element(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Temp_data_element as Temp_data_element");
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
	
	public static List queryTemp_data_element(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Temp_data_element as Temp_data_element");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Temp_data_element", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_data_element[] listTemp_data_elementByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryTemp_data_element(session, condition, orderBy);
			return (Temp_data_element[]) list.toArray(new Temp_data_element[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_data_element[] listTemp_data_elementByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTemp_data_element(session, condition, orderBy, lockMode);
			return (Temp_data_element[]) list.toArray(new Temp_data_element[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_data_element loadTemp_data_elementByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadTemp_data_elementByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_data_element loadTemp_data_elementByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return loadTemp_data_elementByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_data_element loadTemp_data_elementByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Temp_data_element[] temp_data_elements = listTemp_data_elementByQuery(session, condition, orderBy);
		if (temp_data_elements != null && temp_data_elements.length > 0)
			return temp_data_elements[0];
		else
			return null;
	}
	
	public static Temp_data_element loadTemp_data_elementByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Temp_data_element[] temp_data_elements = listTemp_data_elementByQuery(session, condition, orderBy, lockMode);
		if (temp_data_elements != null && temp_data_elements.length > 0)
			return temp_data_elements[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateTemp_data_elementByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateTemp_data_elementByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTemp_data_elementByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eihdms.EIHDMSPersistentManager.instance().getSession();
			return iterateTemp_data_elementByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTemp_data_elementByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Temp_data_element as Temp_data_element");
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
	
	public static java.util.Iterator iterateTemp_data_elementByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Temp_data_element as Temp_data_element");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Temp_data_element", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Temp_data_element loadTemp_data_elementByCriteria(Temp_data_elementCriteria temp_data_elementCriteria) {
		Temp_data_element[] temp_data_elements = listTemp_data_elementByCriteria(temp_data_elementCriteria);
		if(temp_data_elements == null || temp_data_elements.length == 0) {
			return null;
		}
		return temp_data_elements[0];
	}
	
	public static Temp_data_element[] listTemp_data_elementByCriteria(Temp_data_elementCriteria temp_data_elementCriteria) {
		return temp_data_elementCriteria.listTemp_data_element();
	}
	
	public static Temp_data_element createTemp_data_element() {
		return new eihdms.Temp_data_element();
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
	
	@Column(name="temp_data_element_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_TEMP_DATA_ELEMENT_TEMP_DATA_ELEMENT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_TEMP_DATA_ELEMENT_TEMP_DATA_ELEMENT_ID_GENERATOR", strategy="native")	
	private int temp_data_element_id;
	
	@Column(name="report_form_name", nullable=false)	
	private String report_form_name;
	
	@Column(name="section_name", nullable=false)	
	private String section_name;
	
	@Column(name="sub_section_name", nullable=false)	
	private String sub_section_name;
	
	@Column(name="report_form_group_name", nullable=true)	
	private String report_form_group_name;
	
	@Column(name="section_column_number", nullable=true, length=10)	
	private Integer section_column_number;
	
	@Column(name="group_column_number", nullable=true, length=10)	
	private Integer group_column_number;
	
	@Column(name="data_element_name", nullable=true)	
	private String data_element_name;
	
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
	
	@Column(name="technical_area_name", nullable=true)	
	private String technical_area_name;
	
	@Column(name="description", nullable=true)	
	private String description;
	
	@Column(name="data_element_code", nullable=true, length=50)	
	private String data_element_code;
	
	private void setTemp_data_element_id(int value) {
		this.temp_data_element_id = value;
	}
	
	public int getTemp_data_element_id() {
		return temp_data_element_id;
	}
	
	public int getORMID() {
		return getTemp_data_element_id();
	}
	
	public void setReport_form_name(String value) {
		this.report_form_name = value;
	}
	
	public String getReport_form_name() {
		return report_form_name;
	}
	
	public void setSection_name(String value) {
		this.section_name = value;
	}
	
	public String getSection_name() {
		return section_name;
	}
	
	public void setSub_section_name(String value) {
		this.sub_section_name = value;
	}
	
	public String getSub_section_name() {
		return sub_section_name;
	}
	
	public void setReport_form_group_name(String value) {
		this.report_form_group_name = value;
	}
	
	public String getReport_form_group_name() {
		return report_form_group_name;
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
	
	public void setTechnical_area_name(String value) {
		this.technical_area_name = value;
	}
	
	public String getTechnical_area_name() {
		return technical_area_name;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setData_element_code(String value) {
		this.data_element_code = value;
	}
	
	public String getData_element_code() {
		return data_element_code;
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
				        Temp_data_element object = (Temp_data_element) obj;
				        return (this.getTemp_data_element_id() == object.getTemp_data_element_id());
	}
	
	public String toString() {
		return String.valueOf(getTemp_data_element_id());
	}
	
}

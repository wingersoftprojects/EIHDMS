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
@Table(name="sub_section_cell")
public class Sub_section_cell implements Serializable {
	public Sub_section_cell() {
	}
	
	public static Sub_section_cell loadSub_section_cellByORMID(int sub_section_cell_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSub_section_cellByORMID(session, sub_section_cell_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section_cell getSub_section_cellByORMID(int sub_section_cell_id) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getSub_section_cellByORMID(session, sub_section_cell_id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section_cell loadSub_section_cellByORMID(int sub_section_cell_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSub_section_cellByORMID(session, sub_section_cell_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section_cell getSub_section_cellByORMID(int sub_section_cell_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return getSub_section_cellByORMID(session, sub_section_cell_id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section_cell loadSub_section_cellByORMID(PersistentSession session, int sub_section_cell_id) throws PersistentException {
		try {
			return (Sub_section_cell) session.load(eihdms.Sub_section_cell.class, new Integer(sub_section_cell_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section_cell getSub_section_cellByORMID(PersistentSession session, int sub_section_cell_id) throws PersistentException {
		try {
			return (Sub_section_cell) session.get(eihdms.Sub_section_cell.class, new Integer(sub_section_cell_id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section_cell loadSub_section_cellByORMID(PersistentSession session, int sub_section_cell_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sub_section_cell) session.load(eihdms.Sub_section_cell.class, new Integer(sub_section_cell_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section_cell getSub_section_cellByORMID(PersistentSession session, int sub_section_cell_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sub_section_cell) session.get(eihdms.Sub_section_cell.class, new Integer(sub_section_cell_id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySub_section_cell(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return querySub_section_cell(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySub_section_cell(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return querySub_section_cell(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section_cell[] listSub_section_cellByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listSub_section_cellByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section_cell[] listSub_section_cellByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return listSub_section_cellByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySub_section_cell(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sub_section_cell as Sub_section_cell");
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
	
	public static List querySub_section_cell(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sub_section_cell as Sub_section_cell");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sub_section_cell", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section_cell[] listSub_section_cellByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySub_section_cell(session, condition, orderBy);
			return (Sub_section_cell[]) list.toArray(new Sub_section_cell[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section_cell[] listSub_section_cellByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySub_section_cell(session, condition, orderBy, lockMode);
			return (Sub_section_cell[]) list.toArray(new Sub_section_cell[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section_cell loadSub_section_cellByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSub_section_cellByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section_cell loadSub_section_cellByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return loadSub_section_cellByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section_cell loadSub_section_cellByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Sub_section_cell[] sub_section_cells = listSub_section_cellByQuery(session, condition, orderBy);
		if (sub_section_cells != null && sub_section_cells.length > 0)
			return sub_section_cells[0];
		else
			return null;
	}
	
	public static Sub_section_cell loadSub_section_cellByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Sub_section_cell[] sub_section_cells = listSub_section_cellByQuery(session, condition, orderBy, lockMode);
		if (sub_section_cells != null && sub_section_cells.length > 0)
			return sub_section_cells[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSub_section_cellByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateSub_section_cellByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSub_section_cellByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = EIHDMSPersistentManager.instance().getSession();
			return iterateSub_section_cellByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSub_section_cellByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sub_section_cell as Sub_section_cell");
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
	
	public static java.util.Iterator iterateSub_section_cellByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eihdms.Sub_section_cell as Sub_section_cell");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sub_section_cell", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sub_section_cell loadSub_section_cellByCriteria(Sub_section_cellCriteria sub_section_cellCriteria) {
		Sub_section_cell[] sub_section_cells = listSub_section_cellByCriteria(sub_section_cellCriteria);
		if(sub_section_cells == null || sub_section_cells.length == 0) {
			return null;
		}
		return sub_section_cells[0];
	}
	
	public static Sub_section_cell[] listSub_section_cellByCriteria(Sub_section_cellCriteria sub_section_cellCriteria) {
		return sub_section_cellCriteria.listSub_section_cell();
	}
	
	public static Sub_section_cell createSub_section_cell() {
		return new eihdms.Sub_section_cell();
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
			if(getSub_section() != null) {
				getSub_section().getSub_section_cell().remove(this);
			}
			
			if(getSection() != null) {
				getSection().getSub_section_cell().remove(this);
			}
			
			if(getData_element() != null) {
				getData_element().getSub_section_cell().remove(this);
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
			if(getSub_section() != null) {
				getSub_section().getSub_section_cell().remove(this);
			}
			
			if(getSection() != null) {
				getSection().getSub_section_cell().remove(this);
			}
			
			if(getData_element() != null) {
				getData_element().getSub_section_cell().remove(this);
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
	
	@Column(name="sub_section_cell_id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="EIHDMS_SUB_SECTION_CELL_SUB_SECTION_CELL_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="EIHDMS_SUB_SECTION_CELL_SUB_SECTION_CELL_ID_GENERATOR", strategy="native")	
	private int sub_section_cell_id;
	
	@ManyToOne(targetEntity=eihdms.Sub_section.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="sub_section_id", referencedColumnName="sub_section_id") })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Sub_section sub_section;
	
	@ManyToOne(targetEntity=eihdms.Section.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="section_id", referencedColumnName="section_id") })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Section section;
	
	@Column(name="row_no", nullable=false, length=11)	
	private int row_no;
	
	@Column(name="col_no", nullable=false, length=11)	
	private int col_no;
	
	@Column(name="col_span", nullable=true, length=11)	
	private Integer col_span;
	
	@Column(name="row_span", nullable=true, length=11)	
	private Integer row_span;
	
	@Column(name="label_name", nullable=true, length=100)	
	private String label_name;
	
	@ManyToOne(targetEntity=eihdms.Data_element.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="data_element_id", referencedColumnName="data_element_id") })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private eihdms.Data_element data_element;
	
	@Column(name="data_element_value", nullable=true, length=100)	
	private String data_element_value;
	
	@Column(name="text_color", nullable=true, length=50)	
	private String text_color;
	
	@Column(name="cell_color", nullable=true, length=50)	
	private String cell_color;
	
	@Column(name="read_only", nullable=true, length=1)	
	private Integer read_only;
	
	@Column(name="is_deleted", nullable=false, length=1)	
	private int is_deleted;
	
	@Column(name="is_active", nullable=false, length=1)	
	private int is_active;
	
	@Column(name="add_date", nullable=false)	
	private java.sql.Timestamp add_date;
	
	@Column(name="add_by", nullable=true, length=10)	
	private Integer add_by;
	
	@Column(name="last_edit_date", nullable=true)	
	private java.sql.Timestamp last_edit_date;
	
	@Column(name="last_edit_by", nullable=true, length=10)	
	private Integer last_edit_by;
	
	private void setSub_section_cell_id(int value) {
		this.sub_section_cell_id = value;
	}
	
	public int getSub_section_cell_id() {
		return sub_section_cell_id;
	}
	
	public int getORMID() {
		return getSub_section_cell_id();
	}
	
	public void setRow_no(int value) {
		this.row_no = value;
	}
	
	public int getRow_no() {
		return row_no;
	}
	
	public void setCol_no(int value) {
		this.col_no = value;
	}
	
	public int getCol_no() {
		return col_no;
	}
	
	public void setCol_span(int value) {
		setCol_span(new Integer(value));
	}
	
	public void setCol_span(Integer value) {
		this.col_span = value;
	}
	
	public Integer getCol_span() {
		return col_span;
	}
	
	public void setRow_span(int value) {
		setRow_span(new Integer(value));
	}
	
	public void setRow_span(Integer value) {
		this.row_span = value;
	}
	
	public Integer getRow_span() {
		return row_span;
	}
	
	public void setLabel_name(String value) {
		this.label_name = value;
	}
	
	public String getLabel_name() {
		return label_name;
	}
	
	public void setData_element_value(String value) {
		this.data_element_value = value;
	}
	
	public String getData_element_value() {
		return data_element_value;
	}
	
	public void setText_color(String value) {
		this.text_color = value;
	}
	
	public String getText_color() {
		return text_color;
	}
	
	public void setCell_color(String value) {
		this.cell_color = value;
	}
	
	public String getCell_color() {
		return cell_color;
	}
	
	public void setRead_only(int value) {
		setRead_only(new Integer(value));
	}
	
	public void setRead_only(Integer value) {
		this.read_only = value;
	}
	
	public Integer getRead_only() {
		return read_only;
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
	
	public void setSub_section(eihdms.Sub_section value) {
		this.sub_section = value;
	}
	
	public eihdms.Sub_section getSub_section() {
		return sub_section;
	}
	
	public void setData_element(eihdms.Data_element value) {
		this.data_element = value;
	}
	
	public eihdms.Data_element getData_element() {
		return data_element;
	}
	
	public void setSection(eihdms.Section value) {
		this.section = value;
	}
	
	public eihdms.Section getSection() {
		return section;
	}
	
	/**
	 * Testing
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
		 return false;
		 }
		Sub_section_cell object = (Sub_section_cell) obj;
		return (this.getSub_section_cell_id() == object.getSub_section_cell_id());
	}
	
	public int hashCode() {
		int hash = 3;
		return hash;
	}
	
	public String toString() {
		return String.valueOf(getSub_section_cell_id());
	}
	
}

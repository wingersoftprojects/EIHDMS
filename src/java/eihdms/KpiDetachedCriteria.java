/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: rlumala
 * License Type: Purchased
 */
package eihdms;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class KpiDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression kpi_id;
	public final IntegerExpression technical_areaId;
	public final AssociationExpression technical_area;
	public final IntegerExpression report_formId;
	public final AssociationExpression report_form;
	public final StringExpression kpi_name;
	public final IntegerExpression is_deleted;
	public final IntegerExpression is_active;
	public final TimestampExpression add_date;
	public final IntegerExpression add_by;
	public final TimestampExpression last_edit_date;
	public final IntegerExpression last_edit_by;
	public final CollectionExpression kpi_summary_function;
	
	public KpiDetachedCriteria() {
		super(eihdms.Kpi.class, eihdms.KpiCriteria.class);
		kpi_id = new IntegerExpression("kpi_id", this.getDetachedCriteria());
		technical_areaId = new IntegerExpression("technical_area.technical_area_id", this.getDetachedCriteria());
		technical_area = new AssociationExpression("technical_area", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		kpi_name = new StringExpression("kpi_name", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		kpi_summary_function = new CollectionExpression("kpi_summary_function", this.getDetachedCriteria());
	}
	
	public KpiDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.KpiCriteria.class);
		kpi_id = new IntegerExpression("kpi_id", this.getDetachedCriteria());
		technical_areaId = new IntegerExpression("technical_area.technical_area_id", this.getDetachedCriteria());
		technical_area = new AssociationExpression("technical_area", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		kpi_name = new StringExpression("kpi_name", this.getDetachedCriteria());
		is_deleted = new IntegerExpression("is_deleted", this.getDetachedCriteria());
		is_active = new IntegerExpression("is_active", this.getDetachedCriteria());
		add_date = new TimestampExpression("add_date", this.getDetachedCriteria());
		add_by = new IntegerExpression("add_by", this.getDetachedCriteria());
		last_edit_date = new TimestampExpression("last_edit_date", this.getDetachedCriteria());
		last_edit_by = new IntegerExpression("last_edit_by", this.getDetachedCriteria());
		kpi_summary_function = new CollectionExpression("kpi_summary_function", this.getDetachedCriteria());
	}
	
	public Technical_areaDetachedCriteria createTechnical_areaCriteria() {
		return new Technical_areaDetachedCriteria(createCriteria("technical_area"));
	}
	
	public Report_formDetachedCriteria createReport_formCriteria() {
		return new Report_formDetachedCriteria(createCriteria("report_form"));
	}
	
	public Kpi_summary_functionDetachedCriteria createKpi_summary_functionCriteria() {
		return new Kpi_summary_functionDetachedCriteria(createCriteria("kpi_summary_function"));
	}
	
	public Kpi uniqueKpi(PersistentSession session) {
		return (Kpi) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Kpi[] listKpi(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Kpi[]) list.toArray(new Kpi[list.size()]);
	}
}


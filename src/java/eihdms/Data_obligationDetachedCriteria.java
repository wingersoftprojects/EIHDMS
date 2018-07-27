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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Data_obligationDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression data_obligation_id;
	public final IntegerExpression report_formId;
	public final AssociationExpression report_form;
	public final IntegerExpression count_de;
	public final IntegerExpression count_parish;
	public final IntegerExpression count_district;
	public final IntegerExpression count_facility;
	public final IntegerExpression year_value;
	public final IntegerExpression quarter_value;
	public final IntegerExpression bi_month_value;
	public final IntegerExpression month_value;
	public final IntegerExpression week_value;
	public final IntegerExpression quarter_records_f;
	public final IntegerExpression quarter_records_p;
	public final IntegerExpression quarter_records_d;
	public final IntegerExpression quarter_des;
	public final IntegerExpression bi_month_records_f;
	public final IntegerExpression bi_month_records_p;
	public final IntegerExpression bi_month_records_d;
	public final IntegerExpression bi_month_des;
	public final IntegerExpression month_records_f;
	public final IntegerExpression month_records_p;
	public final IntegerExpression month_records_d;
	public final IntegerExpression month_des;
	public final IntegerExpression week_records_f;
	public final IntegerExpression week_records_p;
	public final IntegerExpression week_records_d;
	public final IntegerExpression week_des;
	
	public Data_obligationDetachedCriteria() {
		super(eihdms.Data_obligation.class, eihdms.Data_obligationCriteria.class);
		data_obligation_id = new IntegerExpression("data_obligation_id", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		count_de = new IntegerExpression("count_de", this.getDetachedCriteria());
		count_parish = new IntegerExpression("count_parish", this.getDetachedCriteria());
		count_district = new IntegerExpression("count_district", this.getDetachedCriteria());
		count_facility = new IntegerExpression("count_facility", this.getDetachedCriteria());
		year_value = new IntegerExpression("year_value", this.getDetachedCriteria());
		quarter_value = new IntegerExpression("quarter_value", this.getDetachedCriteria());
		bi_month_value = new IntegerExpression("bi_month_value", this.getDetachedCriteria());
		month_value = new IntegerExpression("month_value", this.getDetachedCriteria());
		week_value = new IntegerExpression("week_value", this.getDetachedCriteria());
		quarter_records_f = new IntegerExpression("quarter_records_f", this.getDetachedCriteria());
		quarter_records_p = new IntegerExpression("quarter_records_p", this.getDetachedCriteria());
		quarter_records_d = new IntegerExpression("quarter_records_d", this.getDetachedCriteria());
		quarter_des = new IntegerExpression("quarter_des", this.getDetachedCriteria());
		bi_month_records_f = new IntegerExpression("bi_month_records_f", this.getDetachedCriteria());
		bi_month_records_p = new IntegerExpression("bi_month_records_p", this.getDetachedCriteria());
		bi_month_records_d = new IntegerExpression("bi_month_records_d", this.getDetachedCriteria());
		bi_month_des = new IntegerExpression("bi_month_des", this.getDetachedCriteria());
		month_records_f = new IntegerExpression("month_records_f", this.getDetachedCriteria());
		month_records_p = new IntegerExpression("month_records_p", this.getDetachedCriteria());
		month_records_d = new IntegerExpression("month_records_d", this.getDetachedCriteria());
		month_des = new IntegerExpression("month_des", this.getDetachedCriteria());
		week_records_f = new IntegerExpression("week_records_f", this.getDetachedCriteria());
		week_records_p = new IntegerExpression("week_records_p", this.getDetachedCriteria());
		week_records_d = new IntegerExpression("week_records_d", this.getDetachedCriteria());
		week_des = new IntegerExpression("week_des", this.getDetachedCriteria());
	}
	
	public Data_obligationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eihdms.Data_obligationCriteria.class);
		data_obligation_id = new IntegerExpression("data_obligation_id", this.getDetachedCriteria());
		report_formId = new IntegerExpression("report_form.report_form_id", this.getDetachedCriteria());
		report_form = new AssociationExpression("report_form", this.getDetachedCriteria());
		count_de = new IntegerExpression("count_de", this.getDetachedCriteria());
		count_parish = new IntegerExpression("count_parish", this.getDetachedCriteria());
		count_district = new IntegerExpression("count_district", this.getDetachedCriteria());
		count_facility = new IntegerExpression("count_facility", this.getDetachedCriteria());
		year_value = new IntegerExpression("year_value", this.getDetachedCriteria());
		quarter_value = new IntegerExpression("quarter_value", this.getDetachedCriteria());
		bi_month_value = new IntegerExpression("bi_month_value", this.getDetachedCriteria());
		month_value = new IntegerExpression("month_value", this.getDetachedCriteria());
		week_value = new IntegerExpression("week_value", this.getDetachedCriteria());
		quarter_records_f = new IntegerExpression("quarter_records_f", this.getDetachedCriteria());
		quarter_records_p = new IntegerExpression("quarter_records_p", this.getDetachedCriteria());
		quarter_records_d = new IntegerExpression("quarter_records_d", this.getDetachedCriteria());
		quarter_des = new IntegerExpression("quarter_des", this.getDetachedCriteria());
		bi_month_records_f = new IntegerExpression("bi_month_records_f", this.getDetachedCriteria());
		bi_month_records_p = new IntegerExpression("bi_month_records_p", this.getDetachedCriteria());
		bi_month_records_d = new IntegerExpression("bi_month_records_d", this.getDetachedCriteria());
		bi_month_des = new IntegerExpression("bi_month_des", this.getDetachedCriteria());
		month_records_f = new IntegerExpression("month_records_f", this.getDetachedCriteria());
		month_records_p = new IntegerExpression("month_records_p", this.getDetachedCriteria());
		month_records_d = new IntegerExpression("month_records_d", this.getDetachedCriteria());
		month_des = new IntegerExpression("month_des", this.getDetachedCriteria());
		week_records_f = new IntegerExpression("week_records_f", this.getDetachedCriteria());
		week_records_p = new IntegerExpression("week_records_p", this.getDetachedCriteria());
		week_records_d = new IntegerExpression("week_records_d", this.getDetachedCriteria());
		week_des = new IntegerExpression("week_des", this.getDetachedCriteria());
	}
	
	public Report_formDetachedCriteria createReport_formCriteria() {
		return new Report_formDetachedCriteria(createCriteria("report_form"));
	}
	
	public Data_obligation uniqueData_obligation(PersistentSession session) {
		return (Data_obligation) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Data_obligation[] listData_obligation(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Data_obligation[]) list.toArray(new Data_obligation[list.size()]);
	}
}


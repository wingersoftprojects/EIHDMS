/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Wence
 * License Type: Purchased
 */
package eihdms;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Data_obligationCriteria extends AbstractORMCriteria {
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
	
	public Data_obligationCriteria(Criteria criteria) {
		super(criteria);
		data_obligation_id = new IntegerExpression("data_obligation_id", this);
		report_formId = new IntegerExpression("report_form.report_form_id", this);
		report_form = new AssociationExpression("report_form", this);
		count_de = new IntegerExpression("count_de", this);
		count_parish = new IntegerExpression("count_parish", this);
		count_district = new IntegerExpression("count_district", this);
		count_facility = new IntegerExpression("count_facility", this);
		year_value = new IntegerExpression("year_value", this);
		quarter_value = new IntegerExpression("quarter_value", this);
		bi_month_value = new IntegerExpression("bi_month_value", this);
		month_value = new IntegerExpression("month_value", this);
		week_value = new IntegerExpression("week_value", this);
		quarter_records_f = new IntegerExpression("quarter_records_f", this);
		quarter_records_p = new IntegerExpression("quarter_records_p", this);
		quarter_records_d = new IntegerExpression("quarter_records_d", this);
		quarter_des = new IntegerExpression("quarter_des", this);
		bi_month_records_f = new IntegerExpression("bi_month_records_f", this);
		bi_month_records_p = new IntegerExpression("bi_month_records_p", this);
		bi_month_records_d = new IntegerExpression("bi_month_records_d", this);
		bi_month_des = new IntegerExpression("bi_month_des", this);
		month_records_f = new IntegerExpression("month_records_f", this);
		month_records_p = new IntegerExpression("month_records_p", this);
		month_records_d = new IntegerExpression("month_records_d", this);
		month_des = new IntegerExpression("month_des", this);
		week_records_f = new IntegerExpression("week_records_f", this);
		week_records_p = new IntegerExpression("week_records_p", this);
		week_records_d = new IntegerExpression("week_records_d", this);
		week_des = new IntegerExpression("week_des", this);
	}
	
	public Data_obligationCriteria(PersistentSession session) {
		this(session.createCriteria(Data_obligation.class));
	}
	
	public Data_obligationCriteria() throws PersistentException {
		this(EIHDMSPersistentManager.instance().getSession());
	}
	
	public Report_formCriteria createReport_formCriteria() {
		return new Report_formCriteria(createCriteria("report_form"));
	}
	
	public Data_obligation uniqueData_obligation() {
		return (Data_obligation) super.uniqueResult();
	}
	
	public Data_obligation[] listData_obligation() {
		java.util.List list = super.list();
		return (Data_obligation[]) list.toArray(new Data_obligation[list.size()]);
	}
}


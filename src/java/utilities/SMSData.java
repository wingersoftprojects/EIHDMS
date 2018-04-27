/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import beans.UploadBean;
import eihdms.County;
import eihdms.Data_element_sms_position;
import eihdms.District;
import eihdms.EIHDMSPersistentManager;
import eihdms.Financial_year;
import eihdms.Health_facility;
import eihdms.Interface_data;
import eihdms.Interface_data_sms;
import eihdms.Parish;
import eihdms.Phone_contact;
import eihdms.Report_form;
import eihdms.Report_form_group;
import eihdms.Report_form_short_code;
import eihdms.Sub_county;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 *
 * @author bajuna
 */
public class SMSData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SMSData d = new SMSData();
        d.load_interface_data_sms("107 MA.a.400.b.359.c.50.d.98.e.10.f.50.g.0.h.n.i.y", "256782760115", "WTL");
        //d.decode_and_load_sms("MA.a.400.b.359.c.50.d.98.e.10.f.50.g.0.h.n.i.y", "256782760115", "107");
    }
    Report_form_group sms_report_form_group = null;
    Report_form sms_report_form = null;
    private Integer report_period_year;
    private Integer report_period_month;
    private Integer report_period_week;
    private Integer report_period_bi_month;
    private Date report_period_from_date;
    private Date report_period_to_date;
    private Financial_year financial_year;
    private Integer report_period_quarter;
    private String report_period_name;

    /**
     * Start SMS Data functions
     */
    public void load_interface_data_sms(String sms, String phone, String scode) {
        if (phone != null && !phone.isEmpty() && sms != null && !sms.isEmpty()) {
            try {
                Interface_data_sms interface_data_sms = new Interface_data_sms();
                String[] splitString = sms.split(" ");
                interface_data_sms.setAdd_date(new Timestamp(new Date().getTime()));
                interface_data_sms.setPhone(phone);
                try{
                interface_data_sms.setReport_form_code(splitString[1]);
                interface_data_sms.setSms(splitString[2]);
                }catch(Exception ex){
                interface_data_sms.setReport_form_code("");
                interface_data_sms.setSms(sms);    
                }
                interface_data_sms.setScode(scode);
                interface_data_sms.setStatus_f("R");
                interface_data_sms.setStatus_f_desc("Received");
                interface_data_sms.setIs_deleted(0);
                interface_data_sms.setIs_active(1);
                interface_data_sms.setAdd_by(1);
                PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                if (interface_data_sms.getInterface_data_sms_id() > 0) {
                    EIHDMSPersistentManager.instance().getSession().merge(interface_data_sms);
                } else {
                    interface_data_sms.save();
                }

                transaction.commit();
                this.decode_and_load_sms(interface_data_sms.getSms(), phone, interface_data_sms.getReport_form_code());
                //loginBean.saveMessage ();
            } catch (PersistentException ex) {
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void decode_and_load_sms(String sms, String phone, String report_form_code) {
        try {
            List<Interface_data> interface_datas = new ArrayList<>();
            List<Data_element_sms_position> data_element_sms_positionList = new ArrayList<>();
            /**
             * Read form being loaded
             */
            sms_report_form = Report_form.loadReport_formByQuery("report_form_code='" + report_form_code + "'", null);
            /**
             * Periods
             */
            Calendar calendar = new GregorianCalendar();
            Date trialTime = new Date();
            calendar.setTime(trialTime);
            System.out.println("Week number:" + calendar.get(Calendar.WEEK_OF_YEAR));
            //i.setReport_period_week(calendar.get(Calendar.WEEK_OF_YEAR));
            report_period_week = calendar.get(Calendar.WEEK_OF_YEAR);
            report_period_year = calendar.get(Calendar.YEAR);
            get_date_from_other_periods();
            /**
             * Periods
             */
            if (sms_report_form != null) {
                /**
                 * Read report form short code list
                 */
                List<Report_form_short_code> report_form_short_codeList = new ArrayList<>();
                report_form_short_codeList = Report_form_short_code.queryReport_form_short_code("report_form_id=" + sms_report_form.getReport_form_id(), null);
                if (report_form_short_codeList.size() > 0) {
                    /**
                     * Loop through available short codes for one that starts
                     * like current SMS
                     */
                    for (Report_form_short_code object : report_form_short_codeList) {
                        if (sms.toUpperCase().startsWith(object.getStart_code().toUpperCase())) {
                            sms = sms.replace(object.getStart_code(), "");
                            int count = sms.length() - sms.replace(".", "").length();
                            /**
                             * Check if number of separators equals those in SMS
                             */
                            if (count == object.getNumber_of_separators()) {
                                data_element_sms_positionList = Data_element_sms_position.queryData_element_sms_position("report_form_short_code_id=" + object.getReport_form_short_code_id(), null);
                            }
                            break;
                        }
                    }
                }
                /**
                 * Get location info from phone number
                 */
                Phone_contact phone_contact = Phone_contact.loadPhone_contactByQuery("entity_phone='" + phone + "'", null);
                if (phone_contact != null) {
                    set_sms_location(phone_contact);
                }
                /**
                 * Return invalid SMS is size=0
                 */
                if (data_element_sms_positionList.size() > 0) {

                    /**
                     * Split SMS into an array of strings
                     */
                    String[] smsStrings = sms.split("\\.");

                    for (Data_element_sms_position outer : data_element_sms_positionList) {
                        Interface_data i = new Interface_data();
                        i.setData_element(outer.getData_element());
                        i.setData_element_value(smsStrings[outer.getCode_position() - 1]);
                        i.setAdd_by(1);
                        i.setAdd_date(new Timestamp(new Date().getTime()));
                        i.setEntry_mode("SMS");
                        //i.setFinancial_year(value);
                        i.setIs_active(1);
                        i.setIs_deleted(0);
                        i.setReport_form(sms_report_form);
                        sms_report_form_group = outer.getData_element().getReport_form_group();
                        i.setReport_form_group_id(outer.getData_element().getReport_form_group().getReport_form_group_id());

                        /**
                         * Get reporting periods
                         */
                        i.setFinancial_year(this.getFinancial_year());
                        i.setReport_period_year(this.getReport_period_year());
                        i.setReport_period_quarter(this.getReport_period_quarter());
                        i.setReport_period_from_date(this.getReport_period_from_date());
                        i.setReport_period_to_date(this.getReport_period_to_date());
                        i.setReport_period_month(this.getReport_period_month());
                        i.setReport_period_week(this.getReport_period_week());
                        i.setReport_period_bi_month(this.getReport_period_bi_month());

                        /**
                         * End set reporting periods
                         */
                        i.setReport_period_from_date(new Date());
                        i.setReport_period_to_date(new Date());
                        if (phone_contact != null) {
                            switch (phone_contact.getEntity_type()) {
                                case "District":
                                    i.setDistrict_id(smsDistrict.getDistrict_id());
                                    i.setDistrict_name(smsDistrict.getDistrict_name());
                                    break;
                                case "Parish":
                                    i.setDistrict_id(smsParish.getSub_county().getCounty().getDistrict().getDistrict_id());
                                    i.setDistrict_name(smsParish.getSub_county().getCounty().getDistrict().getDistrict_name());
                                    i.setCounty_id(smsParish.getSub_county().getCounty().getCounty_id());
                                    i.setCounty_name(smsParish.getSub_county().getCounty().getCounty_name());
                                    i.setSub_county_id(smsParish.getSub_county().getSub_county_id());
                                    i.setSub_county_name(smsParish.getSub_county().getSub_county_name());
                                    i.setParish_id(smsParish.getParish_id());
                                    i.setParish_name(smsParish.getParish_name());
                                    break;
                                case "Facility":
                                    i.setDistrict_id(smsHealth_facility.getDistrict().getDistrict_id());
                                    i.setDistrict_name(smsHealth_facility.getDistrict().getDistrict_name());
                                    i.setCounty_id(smsHealth_facility.getSub_county().getCounty().getCounty_id());
                                    i.setCounty_name(smsHealth_facility.getSub_county().getCounty().getCounty_name());
                                    i.setSub_county_id(smsHealth_facility.getSub_county().getSub_county_id());
                                    i.setSub_county_name(smsHealth_facility.getSub_county().getSub_county_name());
                                    i.setParish_id(smsHealth_facility.getParish().getParish_id());
                                    i.setParish_name(smsHealth_facility.getParish().getParish_name());
                                    i.setHealth_facility_id(smsHealth_facility.getHealth_facility_id());
                                    i.setHealth_facility_name(smsHealth_facility.getHealth_facility_name());
                                    break;
                                default:
                                    break;
                            }
                        }
                        interface_datas.add(i);
                    }
                    UploadBean uploadBean = new UploadBean();
                    uploadBean.load_interface(interface_datas, sms_report_form, sms_report_form_group);
                    System.out.println(interface_datas.size());
                }
            }
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    District smsDistrict;
    County smsCounty;
    Sub_county smsSub_county;
    Parish smsParish;
    Health_facility smsHealth_facility;

    /**
     * Set location from sms phone
     *
     * @param phone_contact
     */
    public void set_sms_location(Phone_contact phone_contact) {
        if (phone_contact != null) {
            try {
                switch (phone_contact.getEntity_type()) {
                    case "District":
                        smsDistrict = District.getDistrictByORMID(phone_contact.getEntity_id());
                        break;
                    case "Parish":
                        smsParish = Parish.getParishByORMID(phone_contact.getEntity_id());
                        break;
                    case "Facility":
                        smsHealth_facility = Health_facility.getHealth_facilityByORMID(phone_contact.getEntity_id());
                        break;
                    default:
                        break;
                }
            } catch (PersistentException ex) {
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public District getSmsDistrict() {
        return smsDistrict;
    }

    public void setSmsDistrict(District smsDistrict) {
        this.smsDistrict = smsDistrict;
    }

    public County getSmsCounty() {
        return smsCounty;
    }

    public void setSmsCounty(County smsCounty) {
        this.smsCounty = smsCounty;
    }

    public Sub_county getSmsSub_county() {
        return smsSub_county;
    }

    public void setSmsSub_county(Sub_county smsSub_county) {
        this.smsSub_county = smsSub_county;
    }

    public Parish getSmsParish() {
        return smsParish;
    }

    public void setSmsParish(Parish smsParish) {
        this.smsParish = smsParish;
    }

    public Health_facility getSmsHealth_facility() {
        return smsHealth_facility;
    }

    public void setSmsHealth_facility(Health_facility smsHealth_facility) {
        this.smsHealth_facility = smsHealth_facility;
    }

    public void get_date_from_other_periods() {
        if (sms_report_form != null) {
            /**
             * Weekly
             */
            if (report_period_year != null && report_period_week != null && sms_report_form.getReport_form_frequency().equals("Weekly")) {
                DateTime date = new DateTime().withWeekyear(report_period_year).withWeekOfWeekyear(report_period_week);
                report_period_month = date.getMonthOfYear();
                report_period_from_date = new DateTime().withWeekyear(report_period_year).withWeekOfWeekyear(report_period_week).withDayOfWeek(1).toDate();
                report_period_to_date = new DateTime().withWeekyear(report_period_year).withWeekOfWeekyear(report_period_week).withDayOfWeek(7).toDate();
            }
            /**
             * Monthly
             */
            if (report_period_year != null && report_period_month != null && sms_report_form.getReport_form_frequency().equals("Monthly")) {
                DateTime date = new DateTime().withYear(report_period_year).withMonthOfYear(report_period_month);
                DateTime start = date.withDayOfMonth(1).withTimeAtStartOfDay();
                DateTime end = start.plusMonths(1).minusMillis(1);
                report_period_from_date = start.toDate();
                report_period_to_date = end.toDate();;
            }
            /**
             * Quarter
             */
            if (report_period_year != null && report_period_quarter != null && sms_report_form.getReport_form_frequency().equals("Quarterly")) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    if (report_period_quarter == 1) {
                        report_period_from_date = sdf.parse(1 + "/" + 1 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(31 + "/" + 3 + "/" + report_period_year);
                    }
                    if (report_period_quarter == 2) {
                        report_period_from_date = sdf.parse(1 + "/" + 4 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(30 + "/" + 6 + "/" + report_period_year);
                    }
                    if (report_period_quarter == 3) {
                        report_period_from_date = sdf.parse(1 + "/" + 7 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(30 + "/" + 9 + "/" + report_period_year);
                    }
                    if (report_period_quarter == 4) {
                        report_period_from_date = sdf.parse(1 + "/" + 10 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(31 + "/" + 12 + "/" + report_period_year);
                    }
                } catch (ParseException ex) {

                }
            }

            /**
             * Bi-Month
             */
            if (report_period_year != null && report_period_bi_month != null && sms_report_form.getReport_form_frequency().equals("Bi-Monthly")) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    if (report_period_bi_month == 1) {
                        report_period_from_date = sdf.parse(1 + "/" + 1 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(28 + "/" + 2 + "/" + report_period_year);
                    }
                    if (report_period_bi_month == 2) {
                        report_period_from_date = sdf.parse(1 + "/" + 3 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(30 + "/" + 4 + "/" + report_period_year);
                    }
                    if (report_period_bi_month == 3) {
                        report_period_from_date = sdf.parse(1 + "/" + 5 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(30 + "/" + 6 + "/" + report_period_year);
                    }
                    if (report_period_bi_month == 4) {
                        report_period_from_date = sdf.parse(1 + "/" + 7 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(31 + "/" + 8 + "/" + report_period_year);
                    }
                    if (report_period_bi_month == 5) {
                        report_period_from_date = sdf.parse(1 + "/" + 9 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(31 + "/" + 10 + "/" + report_period_year);
                    }
                    if (report_period_bi_month == 6) {
                        report_period_from_date = sdf.parse(1 + "/" + 11 + "/" + report_period_year);
                        report_period_to_date = sdf.parse(31 + "/" + 12 + "/" + report_period_year);
                    }
                } catch (ParseException ex) {

                }
            }

        }
    }

    public Report_form_group getSms_report_form_group() {
        return sms_report_form_group;
    }

    public void setSms_report_form_group(Report_form_group sms_report_form_group) {
        this.sms_report_form_group = sms_report_form_group;
    }

    public Report_form getSms_report_form() {
        return sms_report_form;
    }

    public void setSms_report_form(Report_form sms_report_form) {
        this.sms_report_form = sms_report_form;
    }

    public Integer getReport_period_year() {
        return report_period_year;
    }

    public void setReport_period_year(Integer report_period_year) {
        this.report_period_year = report_period_year;
    }

    public Integer getReport_period_month() {
        return report_period_month;
    }

    public void setReport_period_month(Integer report_period_month) {
        this.report_period_month = report_period_month;
    }

    public Integer getReport_period_week() {
        return report_period_week;
    }

    public void setReport_period_week(Integer report_period_week) {
        this.report_period_week = report_period_week;
    }

    public Integer getReport_period_bi_month() {
        return report_period_bi_month;
    }

    public void setReport_period_bi_month(Integer report_period_bi_month) {
        this.report_period_bi_month = report_period_bi_month;
    }

    public Date getReport_period_from_date() {
        return report_period_from_date;
    }

    public void setReport_period_from_date(Date report_period_from_date) {
        this.report_period_from_date = report_period_from_date;
    }

    public Date getReport_period_to_date() {
        return report_period_to_date;
    }

    public void setReport_period_to_date(Date report_period_to_date) {
        this.report_period_to_date = report_period_to_date;
    }

    public Financial_year getFinancial_year() {
        return financial_year;
    }

    public void setFinancial_year(Financial_year financial_year) {
        this.financial_year = financial_year;
    }

    public Integer getReport_period_quarter() {
        return report_period_quarter;
    }

    public void setReport_period_quarter(Integer report_period_quarter) {
        this.report_period_quarter = report_period_quarter;
    }

    public String getReport_period_name() {
        return report_period_name;
    }

    public void setReport_period_name(String report_period_name) {
        this.report_period_name = report_period_name;
    }

    /**
     * End SMS data functions
     */
}

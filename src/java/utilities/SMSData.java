/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import beans.LoginBean;
import beans.UploadBean;
import connections.DBConnection;
import eihdms.Batch_mob_app;
import eihdms.County;
import eihdms.Data_element;
import eihdms.Data_element_sms_position;
import eihdms.District;
import eihdms.EIHDMSPersistentManager;
import eihdms.Financial_year;
import eihdms.Health_facility;
import eihdms.Interface_data;
import eihdms.Interface_data_mob_app;
import eihdms.Interface_data_sms;
import eihdms.Parish;
import eihdms.Phone_contact;
import eihdms.Report_form;
import eihdms.Report_form_deadline;
import eihdms.Report_form_entity;
import eihdms.Report_form_group;
import eihdms.Report_form_short_code;
import eihdms.Sub_county;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceContextType;
import org.hibernate.Transaction;
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
     *
     * @param sms
     * @param phone
     * @param scode
     */
    public void load_interface_data_sms(String sms, String phone, String scode) {
        if (phone != null && !phone.isEmpty() && sms != null && !sms.isEmpty()) {
            try {
                Interface_data_sms interface_data_sms = new Interface_data_sms();
                String[] splitString = sms.split(" ");
                interface_data_sms.setAdd_date(new Timestamp(new Date().getTime()));
                interface_data_sms.setPhone(phone);
                try {
                    if (splitString.length == 3) {
                        interface_data_sms.setReport_form_code(splitString[1]);
                        interface_data_sms.setSms(splitString[2]);
                    }
                    if (splitString.length == 2) {
                        //interface_data_sms.setReport_form_code(splitString[1]);
                        interface_data_sms.setReport_form_code("");
                        interface_data_sms.setSms(splitString[1]);
                    }
                } catch (Exception ex) {
                    interface_data_sms.setReport_form_code("");
                    interface_data_sms.setSms(sms);
                }
                interface_data_sms.setScode(scode);
                //interface_data_sms.setStatus_f("R");
                //interface_data_sms.setStatus_f_desc("Received");
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
                this.update_sms_enity_id(interface_data_sms, phone);
//                this.decode_and_load_sms(interface_data_sms.getSms(), phone, interface_data_sms.getReport_form_code(), interface_data_sms);

                //loginBean.saveMessage ();
            } catch (PersistentException ex) {
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void edit_and_reupload_sms(Interface_data_sms interface_data_sms, Integer edit_sms_year, Integer edit_sms_week, Integer edit_sms_month) {
        try {
            String sms = interface_data_sms.getSms();
            List<Interface_data> interface_datas = new ArrayList<>();
            List<Data_element_sms_position> data_element_sms_positionList = new ArrayList<>();
            /**
             * Read form being loaded
             */
            if (!"".equals(interface_data_sms.getReport_form_code()) && interface_data_sms.getReport_form_code() != null) {
                sms_report_form = Report_form.loadReport_formByQuery("report_form_code='" + interface_data_sms.getReport_form_code() + "'", null);
            }
            /**
             * Delete from base data and dashboard surge
             */
            if (interface_data_sms.getBatch_id() != null && interface_data_sms.getReport_form_code() != null) {
                String sql = "{call sp_delete_dashboard_surge(?,?)}";
                ResultSet rs = null;
                try (Connection conn = DBConnection.getMySQLConnection();
                        PreparedStatement ps = conn.prepareStatement(sql);) {
                    ps.setInt(1, interface_data_sms.getBatch_id());
                    ps.setString(2, interface_data_sms.getReport_form_code());
                    rs = ps.executeQuery();
                    //FacesContext context = FacesContext.getCurrentInstance();
                    //context.addMessage(null, new FacesMessage("Deleted successfully", "Deleted successfully"));
                } catch (SQLException se) {
//                    System.err.println(se.getMessage());
//                    FacesContext context = FacesContext.getCurrentInstance();
//                    context.addMessage(null, new FacesMessage(se.getMessage(), se.getMessage()));
                    Logger.getLogger(SMSData.class.getName()).log(Level.SEVERE, null, se);
                }
            }
            /**
             * Periods
             */
            Calendar calendar = new GregorianCalendar();
            Date trialTime = interface_data_sms.getAdd_date();
            calendar.setTime(trialTime);
            //System.out.println("Week number:" + (calendar.get(Calendar.WEEK_OF_YEAR) - 1));
            //i.setReport_period_week(calendar.get(Calendar.WEEK_OF_YEAR));
            if (edit_sms_week == null) {
                report_period_week = calendar.get(Calendar.WEEK_OF_YEAR) - 1;
            } else {
                report_period_week = edit_sms_week;
            }
            if (edit_sms_year == null) {
                report_period_year = calendar.get(Calendar.YEAR);
            } else {
                report_period_year = edit_sms_year;
            }
            if (edit_sms_month == null) {
                report_period_month = calendar.get(Calendar.MONTH);
            } else {
                report_period_month = edit_sms_month;
            }

            /**
             * Quarterly Report_forms
             */
            switch (calendar.get(Calendar.MONTH)) {
                case 0:
                    report_period_quarter = 4;
                    break;
                case 3:
                    report_period_quarter = 1;
                    break;
                case 6:
                    report_period_quarter = 2;
                    break;
                case 9:
                    report_period_quarter = 3;
                    break;
                default:
                    break;
            }
            /**
             * Bi-Monthly Report_forms
             */
            switch (calendar.get(Calendar.MONTH)) {
                case 0:
                    report_period_bi_month = 6;
                    break;
                case 2:
                    report_period_bi_month = 1;
                    break;
                case 4:
                    report_period_bi_month = 2;
                    break;
                case 6:
                    report_period_bi_month = 3;
                    break;
                case 8:
                    report_period_bi_month = 4;
                    break;
                case 10:
                    report_period_bi_month = 5;
                    break;
                default:
                    break;
            }

            /**
             * Periods
             */
            /**
             * Read report form short code list
             */
            List<Report_form_short_code> report_form_short_codeList = new ArrayList<>();
            if (sms_report_form != null) {
                report_form_short_codeList = Report_form_short_code.queryReport_form_short_code("report_form_id=" + sms_report_form.getReport_form_id(), null);
            } else {
                report_form_short_codeList = Report_form_short_code.queryReport_form_short_code(null, null);
            }
            if (report_form_short_codeList.size() > 0) {
                /**
                 * Loop through available short codes for one that starts like
                 * current SMS
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
                            //sms_report_form=object.getReport_form();
                            interface_data_sms.setStatus_f("OK");
                            interface_data_sms.setStatus_f_desc("Valid Data Format");
                        } else {
                            interface_data_sms.setStatus_f("ERR");
                            interface_data_sms.setStatus_f_desc("Invalid Data Format (Reason: Data Incomplete)");
                        }
                        break;
                    }
                }
            }
            /**
             * Get location info from phone number
             */
            /**
             * Get entity phone where phone number used for multiple entities
             */
            Phone_contact phone_contact = new Phone_contact();// = Phone_contact.loadPhone_contactByQuery("entity_phone='" + phone + "'", null);
            if (data_element_sms_positionList.size() > 0) {
                Data_element_sms_position data_element_sms_position = data_element_sms_positionList.get(0);
                Report_form report_form_temp = data_element_sms_position.getReport_form_short_code().getReport_form();
                List<Report_form_entity> report_form_entityList = new ArrayList<>(report_form_temp.getReport_form_entity());
                if (report_form_entityList.isEmpty()) {
                    phone_contact = Phone_contact.loadPhone_contactByQuery("entity_phone='" + interface_data_sms.getPhone() + "'", null);
                    if (phone_contact == null) {
                        phone_contact = new Phone_contact();
                    }
                } else {
                    List<Phone_contact> phone_contactList = Phone_contact.queryPhone_contact("entity_phone='" + interface_data_sms.getPhone() + "'", null);
                    for (Report_form_entity report_form_entity : report_form_entityList) {
                        for (Phone_contact phone_contact_temp : phone_contactList) {
                            if (phone_contact_temp.getEntity_id() == report_form_entity.getEntity_id() && phone_contact_temp.getEntity_type().toUpperCase().equals(report_form_entity.getEntity_type().toUpperCase())) {
                                phone_contact = phone_contact_temp;
                                break;
                            }
                        }
                    }
                }
            }
            if (phone_contact.getPhone_contact_id() != 0) {
                set_sms_location(phone_contact);
            } else {
                interface_data_sms.setStatus_f("ERR");
                interface_data_sms.setStatus_f_desc("Unknown Sender");
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
                    i.setData_element_value(smsStrings[outer.getValue_position() - 1]);
                    i.setAdd_by(1);
                    i.setAdd_date(new Timestamp(new Date().getTime()));
                    i.setEntry_mode("SMS");
                    //i.setFinancial_year(value);
                    i.setIs_active(1);
                    i.setIs_deleted(0);
                    if (sms_report_form == null) {
                        sms_report_form = outer.getData_element().getReport_form();
                        /**
                         * If no report form code found
                         */
                        if (sms_report_form == null) {
                            interface_data_sms.setReport_form_code("Unknown");
                        }
                        /**
                         * Set interface_data_sms report_form_code
                         */
                        interface_data_sms.setReport_form_code(sms_report_form.getReport_form_code());

                        if (sms_report_form.getReport_form_frequency().equals("Weekly")) {
                            /**
                             * Weekly Report_forms
                             */
                            switch (calendar.get(Calendar.WEEK_OF_YEAR)) {
                                case 1:
                                    /**
                                     * To cater for december last week ending in
                                     * the year
                                     */
                                    if (calendar.get(Calendar.DAY_OF_MONTH) > 10) {
                                        report_period_year = calendar.get(Calendar.YEAR) - 1;
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (sms_report_form.getReport_form_frequency().equals("Bi-Monthly")) {
                            /**
                             * Bi-Monthly Report_forms
                             */
                            switch (calendar.get(Calendar.MONTH)) {
                                case 0:
                                    /**
                                     * To cater for december
                                     */
                                    report_period_year = calendar.get(Calendar.YEAR) - 1;
                                    break;
                                default:
                                    break;
                            }
                        }

                        /**
                         * Terminates if the deadline has passed
                         */
//                        Deadline deadline = check_deadline(sms_report_form);
//                        if (deadline.deadline_passed) {
//                            PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
//                            interface_data_sms.setStatus_v("ERR");
//                            interface_data_sms.setStatus_v_desc(deadline.getDeadline_reason());
//                            EIHDMSPersistentManager.instance().getSession().merge(interface_data_sms);
//                            transaction.commit();
//                            return;
//                        }
                        get_date_from_other_periods();

                    } else {
                        get_date_from_other_periods();
                    }
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
//                    i.setReport_period_from_date(new Date());
//                    i.setReport_period_to_date(new Date());
                    if (phone_contact.getPhone_contact_id() > 0) {
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
                uploadBean.load_interface(interface_datas, sms_report_form, sms_report_form_group, interface_data_sms);
                System.out.println(interface_datas.size());
            } else {
                interface_data_sms.setStatus_f("ERR");
                interface_data_sms.setStatus_f_desc("Invalid Data Format");
                interface_data_sms.setReport_form_code("Unknown");
                PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                EIHDMSPersistentManager.instance().getSession().merge(interface_data_sms);
                transaction.commit();
            }
            //}
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update_sms_enity_id(Interface_data_sms aInterface_data_sms, String phone) {
//        System.err.println("I'm here");
        String sql = "{call sp_update_entity_id(?,?)}";
        ResultSet rs = null;
        LoginBean aLoginBean = new LoginBean();
        try (Connection conn = aLoginBean.getMySQLConnection_System_User();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, aInterface_data_sms.getInterface_data_sms_id());
            ps.setString(2, aInterface_data_sms.getPhone());
            System.out.println(ps);
            rs = ps.executeQuery();
            
            this.decode_and_load_sms(aInterface_data_sms.getSms(), phone, aInterface_data_sms.getReport_form_code(), aInterface_data_sms);

        } catch (SQLException se) {
            se.printStackTrace();
            System.err.println(se.getMessage());
        }

    }

    public void decode_and_load_sms(String sms, String phone, String report_form_code, Interface_data_sms interface_data_sms) {
        try {
//            this.update_sms_enity_id(interface_data_sms, phone);
            List<Interface_data> interface_datas = new ArrayList<>();
            List<Data_element_sms_position> data_element_sms_positionList = new ArrayList<>();

            /**
             * Read form being loaded
             */
            if (!"".equals(report_form_code) && report_form_code != null) {
                sms_report_form = Report_form.loadReport_formByQuery("report_form_code='" + report_form_code + "'", null);
            }
            /**
             * Periods
             */
            Calendar calendar = new GregorianCalendar();
            Date trialTime = new Date();
            calendar.setTime(trialTime);
            //System.out.println("Week number:" + (calendar.get(Calendar.WEEK_OF_YEAR) - 1));
            //i.setReport_period_week(calendar.get(Calendar.WEEK_OF_YEAR));
            report_period_week = calendar.get(Calendar.WEEK_OF_YEAR) - 1;
            report_period_year = calendar.get(Calendar.YEAR);
            report_period_month = calendar.get(Calendar.MONTH);

            /**
             * Quarterly Report_forms
             */
            switch (calendar.get(Calendar.MONTH)) {
                case 0:
                    report_period_quarter = 4;
                    break;
                case 3:
                    report_period_quarter = 1;
                    break;
                case 6:
                    report_period_quarter = 2;
                    break;
                case 9:
                    report_period_quarter = 3;
                    break;
                default:
                    break;
            }
            /**
             * Bi-Monthly Report_forms
             */
            switch (calendar.get(Calendar.MONTH)) {
                case 0:
                    report_period_bi_month = 6;
                    break;
                case 2:
                    report_period_bi_month = 1;
                    break;
                case 4:
                    report_period_bi_month = 2;
                    break;
                case 6:
                    report_period_bi_month = 3;
                    break;
                case 8:
                    report_period_bi_month = 4;
                    break;
                case 10:
                    report_period_bi_month = 5;
                    break;
                default:
                    break;
            }

            /**
             * Periods
             */
            /**
             * Read report form short code list
             */
            List<Report_form_short_code> report_form_short_codeList = new ArrayList<>();
            if (sms_report_form != null) {
                report_form_short_codeList = Report_form_short_code.queryReport_form_short_code("report_form_id=" + sms_report_form.getReport_form_id(), null);
            } else {
                report_form_short_codeList = Report_form_short_code.queryReport_form_short_code(null, null);
            }
            if (report_form_short_codeList.size() > 0) {
                /**
                 * Loop through available short codes for one that starts like
                 * current SMS
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
                            //sms_report_form=object.getReport_form();
                            interface_data_sms.setStatus_f("OK");
                            interface_data_sms.setStatus_f_desc("Valid Data Format");
                        } else {
                            interface_data_sms.setStatus_f("ERR");
                            interface_data_sms.setStatus_f_desc("Invalid Data Format (Reason: Data Incomplete)");
                        }
                        break;
                    }
                }
            }
            /**
             * Get location info from phone number
             */
            /**
             * Get entity phone where phone number used for multiple entities
             */
            Phone_contact phone_contact = new Phone_contact();// = Phone_contact.loadPhone_contactByQuery("entity_phone='" + phone + "'", null);
            if (data_element_sms_positionList.size() > 0) {
                Data_element_sms_position data_element_sms_position = data_element_sms_positionList.get(0);
                Report_form report_form_temp = data_element_sms_position.getReport_form_short_code().getReport_form();
                List<Report_form_entity> report_form_entityList = new ArrayList<>(report_form_temp.getReport_form_entity());
                if (report_form_entityList.isEmpty()) {
                    phone_contact = Phone_contact.loadPhone_contactByQuery("entity_phone='" + phone + "'", null);
                    if (phone_contact == null) {
                        phone_contact = new Phone_contact();
                    }
                } else {
                    List<Phone_contact> phone_contactList = Phone_contact.queryPhone_contact("entity_phone='" + phone + "'", null);
                    for (Report_form_entity report_form_entity : report_form_entityList) {
                        for (Phone_contact phone_contact_temp : phone_contactList) {
                            if (phone_contact_temp.getEntity_id() == report_form_entity.getEntity_id() && phone_contact_temp.getEntity_type().toUpperCase().equals(report_form_entity.getEntity_type().toUpperCase())) {
                                phone_contact = phone_contact_temp;
                                break;
                            }
                        }
                    }
                }
            }

            if (phone_contact.getPhone_contact_id() != 0) {
//                interface_data_sms.setEntity_id(phone_contact.getEntity_id());
//                interface_data_sms.setEntity_type(phone_contact.getEntity_type());
                set_sms_location(phone_contact);
            } else {
                interface_data_sms.setStatus_f("ERR");
                interface_data_sms.setStatus_f_desc("UnMapped Entity");
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
                    i.setData_element_value(smsStrings[outer.getValue_position() - 1]);
                    i.setAdd_by(1);
                    i.setAdd_date(new Timestamp(new Date().getTime()));
                    i.setEntry_mode("SMS");
                    //i.setFinancial_year(value);
                    i.setIs_active(1);
                    i.setIs_deleted(0);
                    if (sms_report_form == null) {
                        sms_report_form = outer.getData_element().getReport_form();
                        /**
                         * If no report form code found
                         */
                        if (sms_report_form == null) {
                            interface_data_sms.setReport_form_code("Unknown");
                        }
                        /**
                         * Set interface_data_sms report_form_code
                         */
                        interface_data_sms.setReport_form_code(sms_report_form.getReport_form_code());

                        if (sms_report_form.getReport_form_frequency().equals("Weekly")) {
                            /**
                             * Weekly Report_forms
                             */
                            switch (calendar.get(Calendar.WEEK_OF_YEAR)) {
                                case 1:
                                    /**
                                     * To cater for december last week ending in
                                     * the year
                                     */
                                    if (calendar.get(Calendar.DAY_OF_MONTH) > 10) {
                                        report_period_year = calendar.get(Calendar.YEAR) - 1;
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (sms_report_form.getReport_form_frequency().equals("Bi-Monthly")) {
                            /**
                             * Bi-Monthly Report_forms
                             */
                            switch (calendar.get(Calendar.MONTH)) {
                                case 0:
                                    /**
                                     * To cater for december
                                     */
                                    report_period_year = calendar.get(Calendar.YEAR) - 1;
                                    break;
                                default:
                                    break;
                            }
                        }

                        /**
                         * Terminates if the deadline has passed
                         */
                        Deadline deadline = check_deadline(sms_report_form);
                        if (deadline.deadline_passed) {
                            PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                            interface_data_sms.setStatus_v("ERR");
                            interface_data_sms.setStatus_v_desc(deadline.getDeadline_reason());
                            EIHDMSPersistentManager.instance().getSession().merge(interface_data_sms);
                            transaction.commit();
                            return;
                        }
                        get_date_from_other_periods();

                    }
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
//                    i.setReport_period_from_date(new Date());
//                    i.setReport_period_to_date(new Date());
                    if (phone_contact.getPhone_contact_id() > 0) {
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
                uploadBean.load_interface(interface_datas, sms_report_form, sms_report_form_group, interface_data_sms);
                System.out.println(interface_datas.size());
            } else {
                interface_data_sms.setStatus_f("ERR");
                interface_data_sms.setStatus_f_desc("Invalid Data Format");
                interface_data_sms.setReport_form_code("Unknown");
                PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                EIHDMSPersistentManager.instance().getSession().merge(interface_data_sms);
                transaction.commit();

            }

            //}
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
                report_period_from_date = new DateTime().withWeekyear(report_period_year).withWeekOfWeekyear(report_period_week).withDayOfWeek(1).toDate();
                report_period_to_date = new DateTime().withWeekyear(report_period_year).withWeekOfWeekyear(report_period_week).withDayOfWeek(7).toDate();
                report_period_month = new DateTime(report_period_from_date.getTime()).getMonthOfYear();
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
     *
     * Function : check_deadline Created by: Brian Newton Ajuna Date :
     * 30/04/2018 Purpose : To check whether the reporting deadline of a
     * Report_form has passed or not
     *
     * @param report_form
     * @return Deadline Object
     */
    public Deadline check_deadline(Report_form report_form) {
        Deadline deadline = new Deadline();
        deadline.setDeadline_passed(true);
        java.util.Calendar calendar = new GregorianCalendar();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        System.out.println("Time Second:" + (calendar.get(java.util.Calendar.SECOND)));
        try {
            Report_form_deadline report_form_deadline = Report_form_deadline.loadReport_form_deadlineByQuery("report_form_id=" + report_form.getReport_form_id(), null);
            if (report_form_deadline != null) {
                /**
                 * If Deadline is extended
                 */
                if (report_form_deadline.getDeadline_extension() != null) {
                    DateTime extended_date = new DateTime(report_form_deadline.getDeadline_extension().getExtended_to_date());
                    DateTime comparisonDate = new DateTime(trialTime);
                    if (extended_date.toDateMidnight().equals(comparisonDate.toDateMidnight()) || report_form_deadline.getDeadline_extension().getExtended_to_date().after(trialTime)) {
                        deadline.setDeadline_passed(false);
                        deadline.setDeadline_reason("Within Deadline");
                        return deadline;
                    }
                }
                switch (report_form.getReport_form_frequency()) {
                    case "Weekly":
                        if (calendar.get(java.util.Calendar.DAY_OF_WEEK) >= report_form_deadline.getDay_from() && calendar.get(java.util.Calendar.DAY_OF_WEEK) <= report_form_deadline.getDay_to()) {
                            deadline.setDeadline_passed(false);
                            deadline.setDeadline_reason("Within Deadline");
                        } else {
                            deadline.setDeadline_passed(true);
                            deadline.setDeadline_reason("Deadline Passed");
                        }
                        break;
                    case "Monthly":
                        if (calendar.get(java.util.Calendar.DAY_OF_MONTH) >= report_form_deadline.getDay_from() && calendar.get(java.util.Calendar.DAY_OF_MONTH) <= report_form_deadline.getDay_to()) {
                            deadline.setDeadline_passed(false);
                            deadline.setDeadline_reason("Within Deadline");
                        } else {
                            deadline.setDeadline_passed(true);
                            deadline.setDeadline_reason("Deadline Passed");
                        }
                        break;
                    case "Quarterly":
                        break;
                    case "Bi-Monthly":
                        break;
                    default:
                        break;
                }
            } else {
                deadline.setDeadline_reason("Error: Report_form_deadline has not been configured!");
            }
        } catch (PersistentException ex) {
            Logger.getLogger(SMSData.class.getName()).log(Level.SEVERE, null, ex);
            deadline.setDeadline_reason("Error: " + ex.getMessage() + "!");
            return deadline;
        }
        return deadline;
    }

    /**
     * Inner class for deadline object Created by: Brian Newton Ajuna Date
     * :30/04/2018 Purpose : To hold the Reason and deadline status of a
     * Report_form
     */
    public class Deadline {

        private boolean deadline_passed;
        private String deadline_reason;

        public boolean isDeadline_passed() {
            return deadline_passed;
        }

        public void setDeadline_passed(boolean deadline_passed) {
            this.deadline_passed = deadline_passed;
        }

        public String getDeadline_reason() {
            return deadline_reason;
        }

        public void setDeadline_reason(String deadline_reason) {
            this.deadline_reason = deadline_reason;
        }
    }

    /**
     * End SMS data functions
     */
    /**
     * Mobile Upload
     *
     * @param batch_mob_app_id
     */
    public void upload_mobile_data(int batch_mob_app_id) {
        try {
            Batch_mob_app batch_mob_app = Batch_mob_app.getBatch_mob_appByORMID(batch_mob_app_id);
            if (batch_mob_app != null) {
                List<Interface_data_mob_app> interface_data_mob_appList = Interface_data_mob_app.queryInterface_data_mob_app("batch_mob_app_id=" + batch_mob_app_id, null);
                List<Interface_data> interface_datas = new ArrayList<>();
                for (Interface_data_mob_app interface_data_mob_app : interface_data_mob_appList) {
                    Interface_data interface_data = new Interface_data();
                    Data_element data_element = Data_element.getData_elementByORMID(interface_data_mob_app.getData_element_id());
                    interface_data.setData_element(data_element);
                    interface_data.setData_element_value(interface_data_mob_app.getData_element_value());
                    interface_data.setAdd_by(interface_data_mob_app.getAdd_by());
                    interface_data.setAdd_date(interface_data_mob_app.getAdd_date());
                    interface_data.setEntry_mode(interface_data_mob_app.getEntry_mode());
                    interface_data.setRec_id(interface_data_mob_app.getRec_id());
                    //i.setFinancial_year(value);
                    interface_data.setIs_active(1);
                    interface_data.setIs_deleted(0);

                    /**
                     * Get Report_form and Report_form_group
                     */
                    //Report_form report_form=Report_form.getReport_formByORMID(interface_data_mob_app.getReport_form_id());
                    //Report_form_group report_form_group=Report_form_group.getReport_form_groupByORMID(interface_data_mob_app.getReport_form_group_id());
                    //interface_data.setReport_form(report_form);
                    //interface_data.setReport_form_group_id(report_form_group.getReport_form_group_id());
                    Calendar calendar = new GregorianCalendar();
                    //Date trialTime = new Date();
                    calendar.setTime(interface_data_mob_app.getAdd_date());

                    /**
                     * Periods
                     */
                    //System.out.println("Week number:" + (calendar.get(Calendar.WEEK_OF_YEAR) - 1));
                    //i.setReport_period_week(calendar.get(Calendar.WEEK_OF_YEAR));
                    report_period_week = calendar.get(Calendar.WEEK_OF_YEAR) - 1;
                    report_period_year = calendar.get(Calendar.YEAR);
                    report_period_month = calendar.get(Calendar.MONTH);

                    /**
                     * Quarterly Report_forms
                     */
                    switch (calendar.get(Calendar.MONTH)) {
                        case 0:
                            report_period_quarter = 4;
                            break;
                        case 3:
                            report_period_quarter = 1;
                            break;
                        case 6:
                            report_period_quarter = 2;
                            break;
                        case 9:
                            report_period_quarter = 3;
                            break;
                        default:
                            break;
                    }
                    /**
                     * Bi-Monthly Report_forms
                     */
                    switch (calendar.get(Calendar.MONTH)) {
                        case 0:
                            report_period_bi_month = 6;
                            break;
                        case 2:
                            report_period_bi_month = 1;
                            break;
                        case 4:
                            report_period_bi_month = 2;
                            break;
                        case 6:
                            report_period_bi_month = 3;
                            break;
                        case 8:
                            report_period_bi_month = 4;
                            break;
                        case 10:
                            report_period_bi_month = 5;
                            break;
                        default:
                            break;
                    }

                    /**
                     * Periods
                     */
                    if (sms_report_form == null) {
                        sms_report_form = Report_form.getReport_formByORMID(interface_data_mob_app.getReport_form_id());
                        /**
                         * Set interface_data_sms report_form_code
                         */
                        //interface_data_sms.setReport_form_code(sms_report_form.getReport_form_code());

                        if (sms_report_form.getReport_form_frequency().equals("Weekly")) {
                            /**
                             * Weekly Report_forms
                             */
                            switch (calendar.get(Calendar.WEEK_OF_YEAR)) {
                                case 1:
                                    /**
                                     * To cater for december last week ending in
                                     * the year
                                     */
                                    if (calendar.get(Calendar.DAY_OF_MONTH) > 10) {
                                        report_period_year = calendar.get(Calendar.YEAR) - 1;
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (sms_report_form.getReport_form_frequency().equals("Bi-Monthly")) {
                            /**
                             * Bi-Monthly Report_forms
                             */
                            switch (calendar.get(Calendar.MONTH)) {
                                case 0:
                                    /**
                                     * To cater for december
                                     */
                                    report_period_year = calendar.get(Calendar.YEAR) - 1;
                                    break;
                                default:
                                    break;
                            }
                        }

                        /**
                         * Terminates if the deadline has passed
                         */
                        Deadline deadline = check_deadline(sms_report_form);
//                        if (deadline.deadline_passed) {
//                            PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
//                            batch_mob_app.setStatus_m("ERR");
//                            batch_mob_app.setStatus_m_desc(deadline.getDeadline_reason());
//                            EIHDMSPersistentManager.instance().getSession().merge(batch_mob_app);
//                            transaction.commit();
//                            return;
//                        }
                        get_date_from_other_periods();

                    }
                    interface_data.setReport_form(sms_report_form);
                    sms_report_form_group = Report_form_group.getReport_form_groupByORMID(interface_data_mob_app.getReport_form_group_id());
                    interface_data.setReport_form_group_id(sms_report_form_group.getReport_form_group_id());

                    /**
                     * Get reporting periods
                     */
                    interface_data.setFinancial_year(this.getFinancial_year());
                    interface_data.setReport_period_year(this.getReport_period_year());
                    interface_data.setReport_period_quarter(this.getReport_period_quarter());
                    interface_data.setReport_period_from_date(this.getReport_period_from_date());
                    interface_data.setReport_period_to_date(this.getReport_period_to_date());
                    interface_data.setReport_period_month(this.getReport_period_month());
                    interface_data.setReport_period_week(this.getReport_period_week());
                    interface_data.setReport_period_bi_month(this.getReport_period_bi_month());

                    interface_data.setDistrict_id(interface_data_mob_app.getDistrict_id());
                    interface_data.setDistrict_name(interface_data_mob_app.getDistrict_name());
                    interface_data.setCounty_id(interface_data_mob_app.getCounty_id());
                    interface_data.setCounty_name(interface_data_mob_app.getCounty_name());
                    interface_data.setSub_county_id(interface_data_mob_app.getSub_county_id());
                    interface_data.setSub_county_name(interface_data_mob_app.getSub_county_name());
                    interface_data.setParish_id(interface_data_mob_app.getParish_id());
                    interface_data.setParish_name(interface_data_mob_app.getParish_name());
                    interface_data.setHealth_facility_id(interface_data_mob_app.getHealth_facility_id());
                    interface_data.setHealth_facility_name(interface_data_mob_app.getHealth_facility_name());
                    interface_datas.add(interface_data);
                }
                UploadBean uploadBean = new UploadBean();
                uploadBean.load_interface(interface_datas, sms_report_form, sms_report_form_group, batch_mob_app);
            }
        } catch (PersistentException ex) {
            Logger.getLogger(SMSData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * End Mobile Upload
     */
}

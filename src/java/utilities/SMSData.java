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
import eihdms.Health_facility;
import eihdms.Interface_data;
import eihdms.Interface_data_sms;
import eihdms.Parish;
import eihdms.Phone_contact;
import eihdms.Report_form;
import eihdms.Report_form_short_code;
import eihdms.Sub_county;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        d.decode_and_load_sms("MA.a.400.b.359.c.50.d.98.e.10.f.50.g.0.h.n.i.y", "256782760115", "107");
        d.load_interface_data_sms("WTL MA.a.400.b.359.c.50.d.98.e.10.f.50.g.0.h.n.i.y", "256782760115", "107");
    }

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
                interface_data_sms.setReport_form_code(splitString[0]);
                interface_data_sms.setSms(splitString[1]);
                interface_data_sms.setScode(scode);
                interface_data_sms.setStatus_code("R");
                interface_data_sms.setStatus_desc("Received");
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
            Report_form sms_report_form = Report_form.loadReport_formByQuery("report_form_code='" + report_form_code + "'", null);
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
                                    i.setCounty_name(smsParish.getSub_county().getSub_county_name());
                                    i.setParish_id(smsParish.getParish_id());
                                    i.setCounty_name(smsParish.getParish_name());
                                    break;
                                case "Facility":
                                    i.setDistrict_id(smsHealth_facility.getDistrict().getDistrict_id());
                                    i.setDistrict_name(smsHealth_facility.getDistrict().getDistrict_name());
                                    i.setCounty_id(smsHealth_facility.getSub_county().getCounty().getCounty_id());
                                    i.setCounty_name(smsHealth_facility.getSub_county().getCounty().getCounty_name());
                                    i.setSub_county_id(smsHealth_facility.getSub_county().getSub_county_id());
                                    i.setCounty_name(smsHealth_facility.getSub_county().getSub_county_name());
                                    i.setParish_id(smsHealth_facility.getParish().getParish_id());
                                    i.setCounty_name(smsHealth_facility.getParish().getParish_name());
                                    i.setHealth_facility_id(smsHealth_facility.getHealth_facility_id());
                                    i.setHealth_facility_name(smsHealth_facility.getHealth_facility_name());
                                    break;
                                default:
                                    break;
                            }
                        }
                        interface_datas.add(i);
                    }

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

    /**
     * End SMS data functions
     */
}

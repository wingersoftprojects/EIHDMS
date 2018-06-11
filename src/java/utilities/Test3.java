/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import beans.Interface_data_smsBean;
import eihdms.Health_facility;
import eihdms.Phone_contact;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.LockMode;
import org.orm.PersistentException;

/**
 *
 * @author philp
 */
public class Test3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Phone_contact pc = null;
        String entityname = "";
        String aPhone = "256706267475";
        try {
            pc = (Phone_contact) Phone_contact.queryPhone_contact("entity_phone='" + aPhone + "'", null).get(0);
            if (null != pc) {
                try {
                    if (pc.getEntity_type().equals("FACILITY")) {
//                        entityname = Health_facility.getHealth_facilityByORMID(pc.getEntity_id()).getHealth_facility_name();
                        entityname = Health_facility.getHealth_facilityByORMID(pc.getEntity_id(), null).getHealth_facility_name();
                    }
                } catch (NullPointerException npe) {

                }
            }
        } catch (PersistentException ex) {
            Logger.getLogger(Interface_data_smsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(entityname);
    }
}

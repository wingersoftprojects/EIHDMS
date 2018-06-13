/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import beans.Interface_data_smsBean;
import eihdms.Health_facility;
import eihdms.Phone_contact;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String timeT ="16:00:00";
        Time t = null;
        try {
            long ms = sdf.parse(timeT).getTime();
            t = new Time(ms);

        } catch (ParseException e) {
            e.printStackTrace();
        }
       
        System.out.println(t);
    }
}

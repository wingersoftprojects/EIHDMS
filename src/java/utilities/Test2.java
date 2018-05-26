/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import org.hibernate.annotations.Source;
import org.joda.time.DateTime;

/**
 *
 * @author bajuna
 */
public class Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.println(new Test2().get_week_dates_from_year_and_week(2018, 2));
//        System.out.println(new Test2().get_week_from_date(new Date()));
        SMSData sData = new SMSData();
        sData.upload_mobile_data(1);
    }
    
    public String get_week_dates_from_year_and_week(Integer year, Integer week) {
        String date_from_to = "Invalid Week/Year Combination";
        try {
            if (year != null && week != null) {
                DateTime date = new DateTime().withWeekyear(year).withWeekOfWeekyear(week);
                date_from_to = new SimpleDateFormat("dd/MMM/yyyy").format(new DateTime().withWeekyear(year).withWeekOfWeekyear(week).withDayOfWeek(1).minusDays(1).toDate()) + "-"
                        + new SimpleDateFormat("dd/MMM/yyyy").format(new DateTime().withWeekyear(year).withWeekOfWeekyear(week).withDayOfWeek(7).minusDays(1).toDate());
            }
        } catch (Exception ex) {
            
        }
        return date_from_to;
    }

    public String get_week_from_date(Date date) {
        String week = "Invalid Date";
        try {
            if (date != null) {
                java.util.Calendar calendar = new GregorianCalendar();
                Date trialTime = new Date();
                calendar.setTime(trialTime);
                //System.out.println("Week number:" + (calendar.get(Calendar.WEEK_OF_YEAR) - 1));
                //i.setReport_period_week(calendar.get(Calendar.WEEK_OF_YEAR));
                week = "Week_" + calendar.get(java.util.Calendar.WEEK_OF_YEAR);
            }
        } catch (Exception ex) {
            
        }
        return week;
    }
}

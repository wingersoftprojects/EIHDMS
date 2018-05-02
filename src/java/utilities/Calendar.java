/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import org.joda.time.DateTime;

/**
 *
 * @author bajuna
 */
public class Calendar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        java.util.Calendar calendar = new GregorianCalendar();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        System.out.println("Time Second:" + (calendar.get(java.util.Calendar.SECOND)));
        System.out.println("Time Minute:" + (calendar.get(java.util.Calendar.MINUTE)));
        System.out.println("Time Hour:" + (calendar.get(java.util.Calendar.HOUR)));
        System.out.println("Time Hour:" + (calendar.get(java.util.Calendar.HOUR_OF_DAY)));
        System.out.println("Week number:" + (calendar.get(java.util.Calendar.WEEK_OF_YEAR)));
        System.out.println("Day of week number:" + (calendar.get(java.util.Calendar.DAY_OF_WEEK)));
        System.out.println("Day of month number:" + (calendar.get(java.util.Calendar.DAY_OF_MONTH)));
        System.out.println("Month number:" + (calendar.get(java.util.Calendar.MONTH)));
        System.out.println("Year number:" + (calendar.get(java.util.Calendar.YEAR)));

        String input = "20171231";
        String format = "yyyyMMdd";
        try {
            SimpleDateFormat df = new SimpleDateFormat(format);
            Date date = df.parse(input);
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(date);
            int week = cal.get(java.util.Calendar.WEEK_OF_YEAR);
            int year = cal.get(java.util.Calendar.YEAR);
            int day = cal.get(java.util.Calendar.DAY_OF_MONTH);

            System.out.println("Input " + input + " is in week " + week);
            System.out.println("Input " + input + " is in year " + year);
            System.out.println("Input " + input + " is in day " + day);
            System.out.println("Month=" + new DateTime().withWeekyear(2017).withWeekOfWeekyear(2).getMonthOfYear());
            //return week;
        } catch (ParseException e) {
            System.out.println("Could not find a week in " + input);
            //return 0;
        }

//        Calendar calendar2 = new GregorianCalendar(Locale.GERMAN);
//        calendar2.set(2016, Calendar.JANUARY, 1, 0, 0, 0);
//        Date date = calendar2.getTime();
//
//        int weekOfYear = calendar2.get(Calendar.WEEK_OF_YEAR);
//        int year = calendar2.getWeekYear();
//
//        System.out.println(date + " is in " + weekOfYear + " of " + year);
    }

}

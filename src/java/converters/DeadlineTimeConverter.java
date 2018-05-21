/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author philp
 */
@FacesConverter(value = "deadlineTimeConverter")
public class DeadlineTimeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        java.sql.Time t = null;
        try {            
            long ms = sdf.parse(string).getTime();
            t = new java.sql.Time(ms);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public String getAsString(FacesContext facesContext,
            UIComponent uIComponent,
            Object object
    ) {
        if (object == null) {
            return null;
        }
        return object.toString();
    }
}

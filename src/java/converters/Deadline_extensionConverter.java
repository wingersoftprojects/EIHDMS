/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author bajuna
 */
@FacesConverter(value = "deadline_extensionConverter")
public class Deadline_extensionConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext,UIComponent uIComponent,String string) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = null;
        Calendar calendar = Calendar.getInstance();
        try {
            date = sdf.parse(string);
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp result = new Timestamp(calendar.getTime().getTime());
        return result;
    }

    @Override
    public String getAsString(FacesContext facesContext,
            UIComponent uIComponent,
            Object object) {
        if (object == null) {
            return null;
        }
        return object.toString();
    }
}

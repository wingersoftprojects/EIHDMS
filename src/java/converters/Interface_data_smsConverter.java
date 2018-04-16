/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import eihdms.Interface_data_sms;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.orm.PersistentException;

/**
 *
 * @author bajuna
 */
@FacesConverter(value = "interfacedatasmsConverter")
public class Interface_data_smsConverter implements Converter   {
     public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        int id = 0;
        try {
            id = Integer.parseInt(string);
        } catch (NumberFormatException nfe) {

        }
        Interface_data_sms object = null;
        try {
            object = Interface_data_sms.getInterface_data_smsByORMID(id);
        } catch (PersistentException ex) {
            Logger.getLogger(Interface_data_smsConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Interface_data_sms) {
            Interface_data_sms o = (Interface_data_sms) object;
            return String.valueOf(o.getInterface_data_sms_id());
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: eihdms.Interface_data_sms");
        }
    }
}

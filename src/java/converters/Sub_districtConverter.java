/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.orm.PersistentException;
import eihdms.Sub_district;

/**
 *
 * @author bajuna
 */
@FacesConverter(value = "sub_districtConverter")
public class Sub_districtConverter implements Converter  {
        public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        int id = 0;
        try {
            id = Integer.parseInt(string);
        } catch (NumberFormatException nfe) {

        }
        Sub_district object = null;
        try {
            object = Sub_district.getSub_districtByORMID(id);
        } catch (PersistentException ex) {
            Logger.getLogger(Sub_districtConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Sub_district) {
            Sub_district o = (Sub_district) object;
            return String.valueOf(o.getSub_district_id());
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: eihdms.Sub_district");
        }
    }
}

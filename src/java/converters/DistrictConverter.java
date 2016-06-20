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
import javax.faces.convert.FacesConverter;
import org.orm.PersistentException;
import eihdms.District;
import javax.faces.convert.Converter;

/**
 *
 * @author bajuna
 */
@FacesConverter(value = "districtConverter")
public class DistrictConverter implements Converter  {
        public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        int id = 0;
        try {
            id = Integer.parseInt(string);
        } catch (NumberFormatException nfe) {

        }
        District object = null;
        try {
            object = District.getDistrictByORMID(id);
        } catch (PersistentException ex) {
            Logger.getLogger(DistrictConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof District) {
            District o = (District) object;
            return String.valueOf(o.getDistrict_id());
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: eihdms.District");
        }
    }
}

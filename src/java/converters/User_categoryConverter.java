/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import eihdms.User_category;
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
@FacesConverter(value = "user_categoryConverter")
public class User_categoryConverter implements Converter   {
     public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        int id = 0;
        try {
            id = Integer.parseInt(string);
        } catch (NumberFormatException nfe) {

        }
        User_category object = null;
        try {
            object = User_category.getUser_categoryByORMID(id);
        } catch (PersistentException ex) {
            Logger.getLogger(User_categoryConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof User_category) {
            User_category o = (User_category) object;
            return String.valueOf(o.getUser_category_id());
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: eihdms.User_category");
        }
    }
}

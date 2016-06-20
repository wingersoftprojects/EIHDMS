/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import eihdms.Group_user;
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
@FacesConverter(value = "group_userConverter")
public class Group_userConverter implements Converter {
       public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        int id = 0;
        try {
            id = Integer.parseInt(string);
        } catch (NumberFormatException nfe) {

        }
        Group_user object = null;
        try {
            object = Group_user.getGroup_userByORMID(id);
        } catch (PersistentException ex) {
            Logger.getLogger(Group_userConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Group_user) {
            Group_user o = (Group_user) object;
            return String.valueOf(o.getGroup_user_id());
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: eihdms.Group_user");
        }
    }
}

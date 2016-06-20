/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import eihdms.Standard_rule;
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
@FacesConverter(value = "standard_ruleConverter")
public class Standard_ruleConverter implements Converter {
           public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        int id = 0;
        try {
            id = Integer.parseInt(string);
        } catch (NumberFormatException nfe) {

        }
        Standard_rule object = null;
        try {
            object = Standard_rule.getStandard_ruleByORMID(id);
        } catch (PersistentException ex) {
            Logger.getLogger(Standard_ruleConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return object;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Standard_rule) {
            Standard_rule o = (Standard_rule) object;
            return String.valueOf(o.getStandard_rule_id());
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: eihdms.Standard_rule");
        }
    }
}

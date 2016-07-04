/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bajuna
 */
public class HttpJSFUtil {

    private HttpJSFUtil() {
    }

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public static HttpServletResponse getResponse() {
        return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    }

    public static Object getManagedBean(String name) {
        return FacesContext.getCurrentInstance().getApplication().createValueBinding(name).getValue(FacesContext.getCurrentInstance());
    }

    public static Object getManagedBean(FacesContext fc, String name) {
        return fc.getApplication().createValueBinding(name).getValue(fc);
    }
}

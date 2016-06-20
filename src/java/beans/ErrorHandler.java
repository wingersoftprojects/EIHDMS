/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author bajuna
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ErrorHandler {

    public String getStatusCode() {
        String val = String.valueOf((Integer) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.status_code"));
        return val;
    }

    public String getMessage() {
        String val = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.message");
        return val;
    }

    public String getExceptionType() {
        String val = "";
        try {
            val = FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.exception_type").toString();
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return val;
    }

    public String getException() {
        String val = "";
        try {
            val = (String) ((Exception) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.exception")).toString();
        } catch (Exception ex) {
        }
        return val;
    }

    public String getRequestURI() {
        return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.request_uri");
    }

    public String getServletName() {
        return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.servlet_name");
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import eihdms.EIHDMSPersistentManager;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.orm.PersistentException;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class GeneralUtilities implements Serializable {

    public static void clearsession() {
        try {
            EIHDMSPersistentManager.instance().disposePersistentManager();
        } catch (PersistentException ex) {
            Logger.getLogger(GeneralUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void flushandclearsession() {
        try {
            EIHDMSPersistentManager.instance().getSession().flush();
            EIHDMSPersistentManager.instance().getSession().clear();
        } catch (PersistentException ex) {
            Logger.getLogger(GeneralUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("ddMMyyyyHmmss");
    }

    public static SimpleDateFormat simpleDateFormatDate() {
        return new SimpleDateFormat("yyyy-MM-ddd");
    }

    public String checkdoctype(String docurl) {
        if (docurl.toLowerCase().contains(".jpg") || docurl.toLowerCase().contains(".png") || docurl.toLowerCase().contains(".jpeg") || docurl.toLowerCase().contains(".gif")) {
            return "image";
        } else if (docurl.toLowerCase().contains(".pdf") || docurl.toLowerCase().contains(".PDF")) {
            return "pdf";
        } else if (docurl.toLowerCase().contains(".doc") || docurl.toLowerCase().contains(".docx")) {
            return "word";
        } else if (docurl.toLowerCase().contains(".xls") || docurl.toLowerCase().contains(".xlsx")) {
            return "excel";
        } else {
            return "";
        }
    }
    private final String currencyformat = "###,##0.0";

    public String getCurrencyformat() {
        return currencyformat;
    }

    public String convertYesNo(int value) {
        switch (value) {
            case 0:
                return "No";
            case 1:
                return "Yes";
            default:
                return "No";
        }
    }
}

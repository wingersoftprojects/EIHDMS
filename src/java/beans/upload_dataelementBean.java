/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import eihdms.Temp_data_element;
import eihdms.EIHDMSPersistentManager;
import eihdms.Temp_health_facility;
import eihdms.Report_form;

import utilities.LoadDataElements;
import utilities.LoadHealthFacility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;
import utilities.GeneralUtilities;
import utilities.HttpJSFUtil;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class upload_dataelementBean implements Serializable {

    private Report_form report_form;
   

    public Report_form getReport_form() {
        return report_form;
    }

    public void setReport_form(Report_form report_form) {
        this.report_form = report_form;
    }

    public void loadDataElements() {
        GeneralUtilities gu = new GeneralUtilities();
        if (report_form != null) {
            gu.load_data_element_dependancies(report_form.getReport_form_name());
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Please Select The Report Form", "Please Select The Report Form"));
            return;
        }
        saveMessage();
    }

    public void loadHealthfacilities() {
        GeneralUtilities gu = new GeneralUtilities();
        gu.load_health_facility_dependancies();
        saveMessage();
    }

    private void saveMessage() {
        LoginBean loginBean = new LoginBean();
        loginBean.saveMessage();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Data_element;
import eihdms.EIHDMSPersistentManager;
import eihdms.Interface_data;
import eihdms.Report_form;
import eihdms.Report_form_group;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.orm.PersistentException;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class UploadBean implements Serializable {

    private int reportformid;
    private JSONArray jSONArray;

    public JSONArray getjSONArray() {
        JSONArray jArray = new JSONArray();

        JSONObject jObj = new JSONObject();
        JSONObject jObj2 = new JSONObject();
        jObj.put("DataElement", jObj2.put("type", "string"));
        jObj.put("Facility", jObj2.put("type", "string"));
        jObj.put("DataElementValue", jObj2.put("type", "number"));
        jArray.put(jObj);

        if (interface_datas == null) {
            interface_datas = new ArrayList<>();
        }
        for (Interface_data interface_data : interface_datas) {
            jObj = new JSONObject();
            jObj.put("DataElement", interface_data.getData_element().getData_element_name());
            jObj.put("Facility", interface_data.getHealth_facility_name());
            jObj.put("DataElementValue", (int) Float.parseFloat(interface_data.getData_element_value()));
            jArray.put(jObj);
        }
        jSONArray = jArray;
        return jSONArray;
    }

    public void setjSONArray(JSONArray jSONArray) {
        this.jSONArray = jSONArray;
    }

    public int getReportformid() {
        return reportformid;
    }

    public void setReportformid(int reportformid) {
        this.reportformid = reportformid;
    }
    private Report_form_group report_form_group;

    public Report_form_group getReport_form_group() {
        return report_form_group;
    }

    public void setReport_form_group(Report_form_group report_form_group) {
        this.report_form_group = report_form_group;
    }
    private Report_form report_form;

    public Report_form getReport_form() {
        return report_form;
    }

    public void setReport_form(Report_form report_form) {
        this.report_form = report_form;
    }

    private List<Report_form_group> report_form_groups;

    public List<Report_form_group> getReport_form_groups() {
        try {
            if (report_form != null) {
                report_form_groups = Report_form_group.queryReport_form_group("report_form_id=" + report_form.getReport_form_id(), null);
            } else {
                report_form_groups = new ArrayList<>();
            }
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return report_form_groups;
    }

    public void setReport_form_groups(List<Report_form_group> report_form_groups) {
        this.report_form_groups = report_form_groups;
    }
    private List<Report_form> report_forms;

    public List<Report_form> getReport_forms() {
        try {
            report_forms = Report_form.queryReport_form(null, null);
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return report_forms;
    }

    public void setReport_forms(List<Report_form> report_forms) {
        this.report_forms = report_forms;
    }

    private List<String> rowdatas;

    public List<String> getRowdatas() {
        return rowdatas;
    }

    public void setRowdatas(List<String> rowdatas) {
        this.rowdatas = rowdatas;
    }

    private List<Interface_data> interface_datas;

    public List<Interface_data> getInterface_datas() {
        return interface_datas;
    }

    public void setInterface_datas(List<Interface_data> interface_datas) {
        this.interface_datas = interface_datas;
    }

    public void handleFileUpload(FileUploadEvent event) {
        try {
            InputStream inputStream = event.getFile().getInputstream();
            uploadexcel(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load_interface(){
        if(!interface_datas.isEmpty()){
            
        }
    }
    
    public void uploadexcel(InputStream inputStream) {
        //FileInputStream fis = null;
        try {
            //Report_form report_form = Report_form.getReport_formByORMID(reportformid);
            if (report_form != null && report_form_group != null) {
                //fis = new FileInputStream(inputStream);

                // Using XSSF for xlsx format, for xls use HSSF
                //Workbook workbook = new XSSFWorkbook(fis);
                org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(inputStream);

                //int numberOfSheets = workbook.getNumberOfSheets();
                org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

                //looping over each workbook sheet
//            for (int i = 0; i < numberOfSheets; i++) {
//                Sheet sheet = workbook.getSheetAt(i);
                List<Data_element> data_elements = (List<Data_element>) EIHDMSPersistentManager.instance().getSession().createQuery("select de from Data_element de INNER JOIN de.report_form_group fg order by fg.group_order,de.group_column_number ASC").list();
                Map demap = new HashMap();
                int tempcounter = 1;
                for (Data_element de : data_elements) {
                    demap.put(tempcounter, de);
                    tempcounter++;
                }

                Iterator<Row> rowIterator = sheet.iterator();
                int x = 0;
                //iterating over each row
                rowdatas = new ArrayList<>();
                interface_datas = new ArrayList<>();
                while (rowIterator.hasNext()) {
                    if (x > 0) {
                        Row row = rowIterator.next();
                        //Iterating over each cell (column wise)  in a particular row.
                        String facility = "";
                        //Cell cell = row.getCell(1);
                        Iterator<Cell> cellIterator1 = row.cellIterator();
                        int counter = 0;
                        while (cellIterator1.hasNext()) {
                            Cell cell = cellIterator1.next();
                            counter++;
                        }

                        if ((counter - 1) != data_elements.size()) {
                            FacesContext context = FacesContext.getCurrentInstance();
                            context.addMessage(null, new FacesMessage("Invalid Upload dues to Number Of Columns", "Invalid Upload due to  Number Of Columns"));
                            return;
                        }

                        Iterator<Cell> cellIterator2 = row.cellIterator();
                        if (row.getRowNum() > 0) {
                            facility = row.getCell(0).getStringCellValue();
                            //break;
                        }
                        while (cellIterator2.hasNext()) {
                            Cell cell = cellIterator2.next();
                            int cellindex = cell.getColumnIndex();
                            if (row.getRowNum() > 0 && cellindex >= 0) {
                                Iterator it = demap.entrySet().iterator();
                                while (it.hasNext()) {
                                    Map.Entry pair = (Map.Entry) it.next();
                                    Interface_data interface_data = new Interface_data();
                                    if (cellindex > 0 && (int) pair.getKey() == cellindex) {
                                        interface_data.setHealth_facility_name(facility);
                                        interface_data.setData_element((Data_element) pair.getValue());
                                        if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                                            //rowdata += "|Col"+cell.getColumnIndex()+"- Value=" + cell.getStringCellValue();
                                            interface_data.setData_element_value(cell.getStringCellValue());
                                        } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                                            //rowdata += "|Col"+cell.getColumnIndex()+"- Value="+ cell.getNumericCellValue();
                                            interface_data.setData_element_value(String.valueOf(cell.getNumericCellValue()));
                                        }
                                        Cell c = row.getCell(cellindex);
                                        if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK) {
                                            interface_data.setData_element_value("NULL");
                                        }

                                        interface_datas.add(interface_data);
                                        //break;
                                    }
                                    //System.out.println(pair.getKey() + " = " + pair.getValue());
                                    //it.remove(); // avoids a ConcurrentModificationException
                                }
                            }
                        }
                    }
                    x++;
                }

            }
            //fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistentException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

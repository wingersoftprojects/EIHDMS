/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Data_element;
import eihdms.EIHDMSPersistentManager;
import eihdms.Financial_year;
import eihdms.Interface_data;
import eihdms.Report_form;
import eihdms.Report_form_group;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
    private List<String> rowdatas;
    private Report_form_group report_form_group;
    private Report_form report_form;
    private List<Report_form_group> report_form_groups;
    private List<Report_form> report_forms;
    private Date report_period_from_date;
    private Date report_period_to_date;
    private Financial_year financial_year;
    private int report_period_quarter;
    private String report_period_name;

    public Date getReport_period_from_date() {
        return report_period_from_date;
    }

    public void setReport_period_from_date(Date report_period_from_date) {
        this.report_period_from_date = report_period_from_date;
    }

    public Date getReport_period_to_date() {
        return report_period_to_date;
    }

    public void setReport_period_to_date(Date report_period_to_date) {
        this.report_period_to_date = report_period_to_date;
    }

    public Financial_year getFinancial_year() {
        return financial_year;
    }

    public void setFinancial_year(Financial_year financial_year) {
        this.financial_year = financial_year;
    }

    public int getReport_period_quarter() {
        return report_period_quarter;
    }

    public void setReport_period_quarter(int report_period_quarter) {
        this.report_period_quarter = report_period_quarter;
    }

    public String getReport_period_name() {
        return report_period_name;
    }

    public void setReport_period_name(String report_period_name) {
        this.report_period_name = report_period_name;
    }

    private String insert_string;
    private String table_string;
    private String database_type;

    public String getDatabase_type() {
        return database_type;
    }

    public void setDatabase_type(String database_type) {
        this.database_type = database_type;
    }

    public String getInsert_string() {
        return insert_string;
    }

    public void setInsert_string(String insert_string) {
        this.insert_string = insert_string;
    }

    public String getTable_string() {
        return table_string;
    }

    public void setTable_string(String table_string) {
        this.table_string = table_string;
    }

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

    public Report_form_group getReport_form_group() {
        return report_form_group;
    }

    public void setReport_form_group(Report_form_group report_form_group) {
        this.report_form_group = report_form_group;
    }

    public Report_form getReport_form() {
        return report_form;
    }

    public void setReport_form(Report_form report_form) {
        this.report_form = report_form;
    }

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

    public void handleFileUploadgenerate_insertstring(FileUploadEvent event) {
        try {
            InputStream inputStream = event.getFile().getInputstream();
            generate_insertstring(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load_interface() {
        if (!interface_datas.isEmpty()) {

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

    public void generate_insertstring(InputStream inputStream) {
        //FileInputStream fis = null;
        try {
            if (table_string == null || database_type == null) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Please specify the database type and table name", "Please specify the database type and table name"));
                return;
            }
            if (table_string.isEmpty() || database_type.isEmpty()) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Please specify the database type and table name", "Please specify the database type and table name"));
                return;
            }
            // Using XSSF for xlsx format, for xls use HSSF
            //Workbook workbook = new XSSFWorkbook(fis);
            org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(inputStream);

            //int numberOfSheets = workbook.getNumberOfSheets();
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            int x = 0;
            //iterating over each row
            rowdatas = new ArrayList<>();
            interface_datas = new ArrayList<>();
            String column_headers = "";
            String data_values = "";
            insert_string = "";
            int counter = 0;
            while (rowIterator.hasNext()) {
                if (x > 0) {
                    Row row = rowIterator.next();
                    if (row.getRowNum() == 0) {
                        Iterator<Cell> cellIterator = row.cellIterator();
                        counter = 0;
                        while (cellIterator.hasNext()) {
                            Cell cell = cellIterator.next();
                            if (counter == 0) {
                                if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                                    if (database_type.equals("MY SQL")) {
                                        column_headers += ("`" + cell.getStringCellValue() + "`");
                                    } else if (database_type.equals("SQL SERVER")) {
                                        column_headers += ("[" + cell.getStringCellValue() + "]");
                                    }
                                } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                                    if (database_type.equals("MY SQL")) {
                                        column_headers += ("`" + cell.getNumericCellValue() + "`");
                                    } else if (database_type.equals("SQL SERVER")) {
                                        column_headers += ("[" + cell.getNumericCellValue() + "]");
                                    }
                                }
                            }
                            if (counter > 0) {
                                if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                                    if (database_type.equals("MY SQL")) {
                                        column_headers += ("," + "`" + cell.getStringCellValue() + "`");
                                    } else if (database_type.equals("SQL SERVER")) {
                                        column_headers += ("," + "[" + cell.getStringCellValue() + "]");
                                    }
                                } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                                    if (database_type.equals("MY SQL")) {
                                        column_headers += ("," + "`" + cell.getNumericCellValue() + "`");
                                    } else if (database_type.equals("SQL SERVER")) {
                                        column_headers += ("," + "[" + cell.getNumericCellValue() + "]");
                                    }
                                }
                            }
                            counter++;
                        }
                    }
                    //Iterating over each cell (column wise)  in a particular row.
                    Iterator<Cell> cellIterator2 = row.cellIterator();
                    counter = 0;
                    data_values = "";
                    while (cellIterator2.hasNext()) {
                        Cell cell = cellIterator2.next();
                        //System.out.println(cell.getCellType());
                        if (row.getRowNum() > 0) {
                            //Cell cell = cellIterator2.next();
                            if (counter == 0) {
                                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                    data_values += ("'" + cell.getStringCellValue() + "'");
                                } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                                    data_values += (cell.getNumericCellValue());
                                } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK || cell.getCellType() == Cell.CELL_TYPE_ERROR) {
                                    data_values += ("NULL");
                                } else {
                                    data_values += ("NULL");
                                }
                            }
                            if (counter > 0) {
                                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                    data_values += (",'" + cell.getStringCellValue() + "'");
                                } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                                    data_values += ("," + cell.getNumericCellValue());
                                } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK || cell.getCellType() == Cell.CELL_TYPE_ERROR) {
                                    data_values += (",NULL");
                                } else {
                                    data_values += (",NULL");
                                }
                            }
                        }
                        counter++;
                    }
                    if (row.getRowNum() > 0) {
                        insert_string += "insert into " + table_string + " (" + column_headers + ") values(" + data_values + ");\n";
                    }
                    //System.out.println(insert_string);
                    //System.out.println(row.getRowNum());
                }
                x++;
            }
            //}
            //fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

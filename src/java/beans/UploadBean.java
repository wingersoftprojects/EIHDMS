/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Base_data;
import eihdms.County;
import eihdms.Data_element;
import eihdms.District;
import eihdms.EIHDMSPersistentManager;
import eihdms.Financial_year;
import eihdms.Health_facility;
import eihdms.Interface_data;
import eihdms.Parish;
import eihdms.Region;
import eihdms.Report_form;
import eihdms.Report_form_group;
import eihdms.Sub_county;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Timestamp;
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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
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
    @ManagedProperty("#{interface_dataBean}")
    private Interface_dataBean interface_dataBean;
    @ManagedProperty("#{base_dataBean}")
    private Base_dataBean base_dataBean;
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    private Region region;
    private District district;
    private County county;
    private Sub_county sub_county;
    private Parish parish;
    private List<Data_element> data_elements;
    private Health_facility health_facility;

    public Interface_dataBean getInterface_dataBean() {
        return interface_dataBean;
    }

    public void setInterface_dataBean(Interface_dataBean interface_dataBean) {
        this.interface_dataBean = interface_dataBean;
    }

    public Base_dataBean getBase_dataBean() {
        return base_dataBean;
    }

    public void setBase_dataBean(Base_dataBean base_dataBean) {
        this.base_dataBean = base_dataBean;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public Sub_county getSub_county() {
        return sub_county;
    }

    public void setSub_county(Sub_county sub_county) {
        this.sub_county = sub_county;
    }

    public Parish getParish() {
        return parish;
    }

    public void setParish(Parish parish) {
        this.parish = parish;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

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
            if (interface_data.getData_element_value() == null) {
                jObj.put("DataElementValue", 0);
            } else {
                jObj.put("DataElementValue", (int) Float.parseFloat(interface_data.getData_element_value()));
            }
            jArray.put(jObj);
        }
        jSONArray = jArray;
        return jSONArray;
    }

    public void setjSONArray(JSONArray jSONArray) {
        this.jSONArray = jSONArray;
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
            try {
                /**
                 * Load Interface Data
                 */
                PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                for (Interface_data i : interface_datas) {
                    //interface_dataBean.setSelected(i);
                    i.setIs_active(1);
                    i.setAdd_date(new Timestamp(new Date().getTime()));
                    i.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
                    i.setIs_deleted(0);
                    i.save();
                    //interface_dataBean.save(loginBean.getUser_detail().getUser_detail_id());
                }
                transaction.commit();
                /**
                 * Load Base Data
                 */
                transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                List<Interface_data> interface_datas_tobase = (List<Interface_data>) EIHDMSPersistentManager.instance().getSession().createQuery("SELECT i FROM Interface_data i where i.status='Not Moved' AND i.data_element.report_form=" + report_form.getReport_form_id()).list();
                for (Interface_data i : interface_datas_tobase) {
                    List<Health_facility> health_facilityList = Health_facility.queryHealth_facility("health_facility_name='" + i.getHealth_facility_name() + "'", null);
                    if (health_facilityList.size() == 1) {
                        Base_data base_data = Base_data.createBase_data();
                        base_data.setData_element(i.getData_element());
                        base_data.setData_element_value(i.getData_element_value());
                        base_data.setData_element_value(i.getData_element_value());
//                    District d = District.loadDistrictByQuery("district_name='" + i.getDistrict_name() + "'", null);
//                    Parish p = Parish.loadParishByQuery("parish_name='" + i.getParish_name() + "'", null);
                        Health_facility health_facility = Health_facility.loadHealth_facilityByQuery("health_facility_name='" + i.getHealth_facility_name() + "'", null); //AND district_id=" + (district != null ? district.getDistrict_id() : 0) + " AND parish_id=" + (parish != null ? parish.getParish_id() : 0), null);
                        base_data.setHealth_facility(health_facility);
                        base_data.setDistrict(health_facility.getDistrict());
                        base_data.setParish(health_facility.getParish());
                        base_data.setFinancial_year(i.getFinancial_year());
                        base_data.setReport_period_quarter(i.getReport_period_quarter());
                        base_data.setReport_period_from_date(i.getReport_period_from_date());
                        base_data.setReport_period_to_date(i.getReport_period_to_date());
                        base_data.setReport_period_name(i.getReport_period_name());
                        base_data.setIs_active(1);
                        base_data.setAdd_date(new Timestamp(new Date().getTime()));
                        base_data.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
                        base_data.setIs_deleted(0);
                        /**
                         * Save Base Data
                         */
                        base_data.save();
                        /**
                         * Modify Interface Data
                         */
                        i.setStatus("Moved");
                        i.setStatus_desc("Moved to base successfully");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                    if (health_facilityList.size() > 1) {
                        i.setStatus("Not Moved");
                        i.setStatus_desc("Not moved to base because more than one facility found in facilities table");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                    if (health_facilityList.isEmpty()) {
                        i.setStatus("Not Moved");
                        i.setStatus_desc("Not moved to base because facility not found in facilities table");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                    //base_dataBean.setSelected(base_data);
                    //base_dataBean.save(loginBean.getUser_detail().getUser_detail_id());

                    //i.setIs_deleted(0);
                    //interface_dataBean.setSelected(i);
                    //interface_dataBean.save(loginBean.getUser_detail().getUser_detail_id());
                }
                transaction.commit();
                loginBean.saveMessage();
            } catch (PersistentException ex) {
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            interface_datas = new ArrayList<>();
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
                                        interface_data.setReport_period_from_date(report_period_from_date);
                                        interface_data.setReport_period_to_date(report_period_to_date);
                                        interface_data.setFinancial_year(financial_year);
                                        interface_data.setReport_period_quarter(report_period_quarter);
                                        interface_data.setReport_period_name(report_period_name);
                                        if (district != null) {
                                            interface_data.setDistrict_name(district.getDistrict_name());
                                        }
                                        if (parish != null) {
                                            interface_data.setParish_name(parish.getParish_name());
                                        }
                                        interface_data.setStatus("Not Moved");
                                        interface_data.setStatus_desc("Not yet moved to base data");
                                        switch (cell.getCellType()) {
                                            case Cell.CELL_TYPE_STRING:
                                                interface_data.setData_element_value(cell.getStringCellValue().replace("'", "''"));
                                                break;
                                            case Cell.CELL_TYPE_NUMERIC:
                                                interface_data.setData_element_value(String.valueOf(cell.getNumericCellValue()));
                                                break;
                                            case Cell.CELL_TYPE_FORMULA:
                                                switch (cell.getCachedFormulaResultType()) {
                                                    case Cell.CELL_TYPE_NUMERIC:
                                                        interface_data.setData_element_value(String.valueOf(cell.getNumericCellValue()));
                                                        break;
                                                    case Cell.CELL_TYPE_STRING:
                                                        interface_data.setData_element_value(cell.getStringCellValue().replace("'", "''"));
                                                        break;
                                                }
                                                break;
                                            case Cell.CELL_TYPE_BLANK:
                                                interface_data.setData_element_value("NULL");
                                                break;
                                            default:
                                                break;
                                        }
//                                        Cell c = row.getCell(cellindex);
                                        interface_datas.add(interface_data);
                                    }
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
                                        column_headers += ("`" + cell.getStringCellValue().replace("'", "''") + "`");
                                    } else if (database_type.equals("SQL SERVER")) {
                                        column_headers += ("[" + cell.getStringCellValue().replace("'", "''") + "]");
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
                                        column_headers += ("," + "`" + cell.getStringCellValue().replace("'", "''") + "`");
                                    } else if (database_type.equals("SQL SERVER")) {
                                        column_headers += ("," + "[" + cell.getStringCellValue().replace("'", "''") + "]");
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
                                    data_values += ("'" + cell.getStringCellValue().replace("'", "''") + "'");
                                } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                                    data_values += (cell.getNumericCellValue());
                                } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK || cell.getCellType() == Cell.CELL_TYPE_ERROR) {
                                    data_values += ("NULL");
                                } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                                    switch (cell.getCachedFormulaResultType()) {
                                        case Cell.CELL_TYPE_NUMERIC:
                                            //System.out.println("Last evaluated as: " + cell.getNumericCellValue());
                                            data_values += (cell.getNumericCellValue());
                                            break;
                                        case Cell.CELL_TYPE_STRING:
                                            //System.out.println("Last evaluated as \"" + cell.getRichStringCellValue() + "\"");
                                            data_values += ("'" + cell.getRichStringCellValue() + "'");
                                            break;
                                    }

                                }
                            }
                            if (counter > 0) {
                                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                    data_values += (",'" + cell.getStringCellValue().replace("'", "''") + "'");
                                } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                                    data_values += ("," + cell.getNumericCellValue());
                                } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK || cell.getCellType() == Cell.CELL_TYPE_ERROR) {
                                    data_values += (",NULL");
                                } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                                    switch (cell.getCachedFormulaResultType()) {
                                        case Cell.CELL_TYPE_NUMERIC:
                                            //System.out.println("Last evaluated as: " + cell.getNumericCellValue());
                                            data_values += ("," + cell.getNumericCellValue());
                                            break;
                                        case Cell.CELL_TYPE_STRING:
                                            //System.out.println("Last evaluated as \"" + cell.getRichStringCellValue() + "\"");
                                            //data_values += (cell.getRichStringCellValue());
                                            data_values += (",'" + cell.getRichStringCellValue() + "'");
                                            break;
                                    }
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

    /**
     * @return the data_elements
     */
    public List<Data_element> getData_elements() {
        return data_elements;
    }

    /**
     * @param data_elements the data_elements to set
     */
    public void setData_elements(List<Data_element> data_elements) {
        this.data_elements = data_elements;
    }

    public void refreshData_elements(Report_form report_form, Report_form_group report_form_group) {
        String sql = "";
        data_elements = new ArrayList<Data_element>();
        try {
            if (report_form != null && report_form_group != null) {
                sql = "select de from Data_element de INNER JOIN de.report_form_group fg where de.report_form=" + report_form + " and de.report_form_group=" + report_form_group + " order by fg.group_order,de.group_column_number ASC";
                data_elements = (List<Data_element>) EIHDMSPersistentManager.instance().getSession().createQuery(sql).list();
                this.createInterface_datas(data_elements);
            }
        } catch (Exception ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createInterface_datas(List<Data_element> aData_elements) {
        Interface_data interface_data;
        if (null != aData_elements) {
            interface_datas = new ArrayList<Interface_data>();
            for (Data_element data_element : aData_elements) {
                interface_data = new Interface_data();
                interface_data.setData_element(data_element);
                interface_data.setData_element_value("");
                try {
                    interface_data.setHealth_facility_name(this.getHealth_facility().getHealth_facility_name());
                } catch (NullPointerException npe) {
                    interface_data.setHealth_facility_name(null);
                }
                try {
                    interface_data.setDistrict_name(this.getDistrict().getDistrict_name());
                } catch (NullPointerException npe) {
                    interface_data.setDistrict_name(null);
                }
                try {
                    interface_data.setParish_name(this.getParish().getParish_name());
                } catch (NullPointerException npe) {
                    interface_data.setParish_name(null);
                }
                interface_data.setFinancial_year(this.getFinancial_year());
                interface_data.setReport_period_quarter(this.getReport_period_quarter());
                interface_data.setReport_period_from_date(this.getReport_period_from_date());
                interface_data.setReport_period_to_date(this.getReport_period_to_date());
                interface_data.setReport_period_name(this.getReport_period_name());
                interface_data.setIs_deleted(0);
                interface_data.setIs_active(1);
                interface_data.setStatus("Not Moved");
                interface_datas.add(interface_data);
            }
        }
    }

    /**
     * @return the health_facility
     */
    public Health_facility getHealth_facility() {
        return health_facility;
    }

    /**
     * @param health_facility the health_facility to set
     */
    public void setHealth_facility(Health_facility health_facility) {
        this.health_facility = health_facility;
    }

    public List<Health_facility> completeHealth_facility(String query) {
        List<Health_facility> filteredHealth_facilities = new ArrayList<>();
        try {
            filteredHealth_facilities = (List<Health_facility>) EIHDMSPersistentManager.instance().getSession().createQuery("select hf FROM Health_facility  hf where hf.is_deleted<>1 AND hf.is_active<>0 AND hf.health_facility_name like '%" + query + "%'").list();
        } catch (PersistentException ex) {
            Logger.getLogger(Health_facilityBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filteredHealth_facilities;
    }

    public List<Parish> completeParish(String query) {
        List<Parish> filteredParishes = new ArrayList<>();
        try {
            filteredParishes = (List<Parish>) EIHDMSPersistentManager.instance().getSession().createQuery("select p FROM Parish  p where p.is_deleted<>1 AND p.is_active<>0 AND p.parish_name like '%" + query + "%'").list();
        } catch (PersistentException ex) {
            Logger.getLogger(ParishBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filteredParishes;
    }

    public List<District> completeDistrict(String query) {
        List<District> filteredDistricts = new ArrayList<>();
        try {
            filteredDistricts = (List<District>) EIHDMSPersistentManager.instance().getSession().createQuery("select d FROM District  d where d.is_deleted<>1 AND d.is_active<>0 AND d.district_name like '%" + query + "%'").list();
        } catch (PersistentException ex) {
            Logger.getLogger(DistrictBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filteredDistricts;
    }

    public void dataentry_load_interface() {
        if (!interface_datas.isEmpty()) {
            try {
                /**
                 * Load Interface Data
                 */
                PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                for (Interface_data i : interface_datas) {
                    i.setIs_active(1);
                    i.setAdd_date(new Timestamp(new Date().getTime()));
                    i.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
                    i.setIs_deleted(0);
                    i.save();
                }
                transaction.commit();
                /**
                 * Load Base Data
                 */
                transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
                List<Interface_data> interface_datas_tobase = (List<Interface_data>) EIHDMSPersistentManager.instance().getSession().createQuery("SELECT i FROM Interface_data i where i.status='Not Moved' AND i.data_element.report_form=" + report_form.getReport_form_id()).list();
                for (Interface_data i : interface_datas_tobase) {
                    List<Health_facility> health_facilityList = Health_facility.queryHealth_facility("health_facility_name='" + i.getHealth_facility_name() + "'", null);
                    if (health_facilityList.size() == 1) {
                        Base_data base_data = Base_data.createBase_data();
                        base_data.setData_element(i.getData_element());
                        base_data.setData_element_value(i.getData_element_value());
                        base_data.setData_element_value(i.getData_element_value());
//                    District d = District.loadDistrictByQuery("district_name='" + i.getDistrict_name() + "'", null);
//                    Parish p = Parish.loadParishByQuery("parish_name='" + i.getParish_name() + "'", null);
                        Health_facility health_facility = Health_facility.loadHealth_facilityByQuery("health_facility_name='" + i.getHealth_facility_name() + "'", null); //AND district_id=" + (district != null ? district.getDistrict_id() : 0) + " AND parish_id=" + (parish != null ? parish.getParish_id() : 0), null);
                        base_data.setHealth_facility(health_facility);
                        base_data.setDistrict(health_facility.getDistrict());
                        base_data.setParish(health_facility.getParish());
                        base_data.setFinancial_year(i.getFinancial_year());
                        base_data.setReport_period_quarter(i.getReport_period_quarter());
                        base_data.setReport_period_from_date(i.getReport_period_from_date());
                        base_data.setReport_period_to_date(i.getReport_period_to_date());
                        base_data.setReport_period_name(i.getReport_period_name());
                        base_data.setIs_active(1);
                        base_data.setAdd_date(new Timestamp(new Date().getTime()));
                        base_data.setAdd_by(loginBean.getUser_detail().getUser_detail_id());
                        base_data.setIs_deleted(0);
                        /**
                         * Save Base Data
                         */
                        base_data.save();
                        /**
                         * Modify Interface Data
                         */
                        i.setStatus("Moved");
                        i.setStatus_desc("Moved to base successfully");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                    if (health_facilityList.size() > 1) {
                        i.setStatus("Not Moved");
                        i.setStatus_desc("Not moved to base because more than one facility found in facilities table");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                    if (health_facilityList.isEmpty()) {
                        i.setStatus("Not Moved");
                        i.setStatus_desc("Not moved to base because facility not found in facilities table");
                        i.setLast_edit_date(new Timestamp(new Date().getTime()));
                        i.setLast_edit_by(loginBean.getUser_detail().getUser_detail_id());
                        EIHDMSPersistentManager.instance().getSession().merge(i);
                    }
                    //base_dataBean.setSelected(base_data);
                    //base_dataBean.save(loginBean.getUser_detail().getUser_detail_id());

                    //i.setIs_deleted(0);
                    //interface_dataBean.setSelected(i);
                    //interface_dataBean.save(loginBean.getUser_detail().getUser_detail_id());
                }
                transaction.commit();
                loginBean.saveMessage();
            } catch (PersistentException ex) {
                Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            interface_datas = new ArrayList<>();
        }
    }

}

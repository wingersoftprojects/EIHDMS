/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.EIHDMSPersistentManager;
import eihdms.Data_element;
import eihdms.District;
import eihdms.Report_form;
import eihdms.Report_form_group;
import eihdms.Section;
import eihdms.Sub_section;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.orm.PersistentException;
import org.primefaces.event.ReorderEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;
import utilities.HttpJSFUtil;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class Data_elementBean extends AbstractBean<Data_element> implements Serializable {

    StreamedContent file;
    private TreeNode TreeNodeByNone;
    private TreeNode TreeNodeByGroup;
    @ManagedProperty("#{report_formBean}")
    private Report_formBean report_formBean;
    @ManagedProperty("#{sectionBean}")
    private SectionBean sectionBean;
    @ManagedProperty("#{sub_sectionBean}")
    private Sub_sectionBean sub_sectionBean;
    @ManagedProperty("#{report_form_groupBean}")
    private Report_form_groupBean report_form_groupBean;
    private List<Report_form_group> report_form_groupList;
    private List<Section> sectionList;
    private List<Sub_section> sub_sectionList;
    private List<Data_element> data_elementList;

    /**
     * Creates a new instance of Data_elementBean
     */
    public Data_elementBean() {
        super(Data_element.class);
    }

    @Override
    public void init() {
        if (super.getEntityClass() == null) {
            loginBean.logout();
        }
    }
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public List<Data_element> completeData_element(String query) {
        List<Data_element> filteredData_elements = new ArrayList<>();
        try {
            filteredData_elements = (List<Data_element>) EIHDMSPersistentManager.instance().getSession().createQuery("select de FROM Data_element  de where de.is_deleted<>1 AND ( de.description like '%" + query + "%' OR  de.technical_area.technical_area_name '%" + query + "%' or de.report_form.report_form_name like '%" + query + "%' OR de.data_element_name like '%" + query + "%')").list();
        } catch (PersistentException ex) {
            Logger.getLogger(Data_elementBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filteredData_elements;
    }

    public Report_formBean getReport_formBean() {
        return report_formBean;
    }

    public void setReport_formBean(Report_formBean report_formBean) {
        this.report_formBean = report_formBean;
    }

    public SectionBean getSectionBean() {
        return sectionBean;
    }

    public void setSectionBean(SectionBean sectionBean) {
        this.sectionBean = sectionBean;
    }

    public Sub_sectionBean getSub_sectionBean() {
        return sub_sectionBean;
    }

    public void setSub_sectionBean(Sub_sectionBean sub_sectionBean) {
        this.sub_sectionBean = sub_sectionBean;
    }

    private TreeNode dataelementtreenode;

    public void getDataelementtreenode(Report_form report_form) {
        try {
            Data_element d0 = new Data_element();
            d0.setData_element_name("Root");
            d0.setData_type("-");
            setDataelementtreenode(new DefaultTreeNode(d0, null));
            TreeNode level2 = new DefaultTreeNode(null);
            TreeNode level3 = new DefaultTreeNode(null);
            TreeNode level1 = new DefaultTreeNode(null);
            TreeNode level4 = new DefaultTreeNode(null);

            if (null != report_form) {
                Data_element d1 = new Data_element();
                d1.setData_element_name(report_form.getReport_form_name());
                d1.setData_type("-");
                level1 = new DefaultTreeNode(d1, getDataelementtreenode());
                List<Section> tempSections = Section.querySection("report_form_id=" + report_form.getReport_form_id(), "section_order,section_id");
                for (Section section : tempSections) {
                    if (section.getReport_form().getReport_form_id() == report_form.getReport_form_id()) {
                        Data_element d2 = new Data_element();
                        d2.setData_element_name(section.getSection_name());
                        d2.setData_type("-");
                        level2 = new DefaultTreeNode(d2, level1);
                    }
                    List<Sub_section> tempSub_sections = Sub_section.querySub_section("section_id=" + section.getSection_id(), "sub_section_order,sub_section_id");
                    for (Sub_section sub_section : tempSub_sections) {
                        if (sub_section.getSection().getSection_id() == section.getSection_id()) {
                            Data_element d3 = new Data_element();
                            d3.setData_element_name(sub_section.getSub_section_name());
                            d3.setData_type("-");
                            level3 = new DefaultTreeNode(d3, level2);
                            List<Data_element> tempData_elements = Data_element.queryData_element("sub_section_id=" + sub_section.getSub_section_id(), "section_column_number");
                            for (Data_element data_element : tempData_elements) {
                                if (data_element.getSub_section().getSub_section_id() == sub_section.getSub_section_id()) {
                                    level4 = new DefaultTreeNode("dataelement", data_element, level3);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void retrieveReportFormOrderedDataElements(Report_form report_form, Report_form_group report_form_group, District[] districts) {
        String sql = "";
        List<Data_element> data_elements = new ArrayList<Data_element>();
        try {
            if (report_form != null && report_form_group != null) {
                sql = "select de from Data_element de INNER JOIN de.report_form_group fg where de.report_form=" + report_form + " and de.report_form_group=" + report_form_group + " order by fg.group_order,de.group_column_number ASC";
                data_elements = (List<Data_element>) EIHDMSPersistentManager.instance().getSession().createQuery(sql).list();
                if (data_elements.size() > 0) {
                    this.DownloadExcelTemplate(data_elements, "TMP_" + report_form.getReport_form_code() + "_" + report_form_group.getReport_form_group_name(), report_form_group.getReport_form_group_name(), report_form.getLowest_report_form_level(), districts);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DownloadExcelTemplate(List<Data_element> des, String filename, String sheetname, String lowestreportformlevel, District[] districts) {
        XSSFWorkbook workbook = null;
        int rowIndex = 0;
        int colIndex = 0;

        try {
            //Create Blank workbook
            workbook = new XSSFWorkbook();
            //Create a blank spreadsheet
            XSSFSheet spreadsheet = workbook.createSheet(sheetname);

            //set the margins
            double leftMarginInches = spreadsheet.getMargin(spreadsheet.LeftMargin);
            double topMarginInches = spreadsheet.getMargin(spreadsheet.TopMargin);

            double rightMarginInches = spreadsheet.getMargin(spreadsheet.RightMargin);
            double bottomMarginInches = spreadsheet.getMargin(spreadsheet.BottomMargin);
            spreadsheet.setMargin(spreadsheet.LeftMargin, leftMarginInches * 0);
            spreadsheet.setMargin(spreadsheet.TopMargin, topMarginInches * 0);
            spreadsheet.setMargin(spreadsheet.RightMargin, rightMarginInches * 0);
            spreadsheet.setMargin(spreadsheet.BottomMargin, bottomMarginInches * 0);
            spreadsheet.setMargin(spreadsheet.HeaderMargin, 0);
            spreadsheet.setMargin(spreadsheet.FooterMargin, 0);
            spreadsheet.setFitToPage(true);

            //create first row on a created spreadsheet
            XSSFRow row = null;
            XSSFCell cell = null;

            //--------------fonts---------------
            XSSFFont fontTop = workbook.createFont();
            fontTop.setBold(false);
            fontTop.setFontName("Arial");
            fontTop.setFontHeightInPoints((short) 16);

            //--------------header--------------
            rowIndex = 0;
            colIndex = 0;
            //set wrap text to true
            CellStyle cs = workbook.createCellStyle();
            cs.setWrapText(true);

            row = spreadsheet.createRow(rowIndex);
            for (Data_element de : des) {
                if (colIndex == 0) {
                    cell = (XSSFCell) row.createCell(colIndex);
                    cell.setCellStyle(cs);
                    cell.setCellValue("District");
                    colIndex += 1;
                    if (lowestreportformlevel.equals("Parish") || lowestreportformlevel.equals("Facility")) {
                        cell = (XSSFCell) row.createCell(colIndex);
                        cell.setCellStyle(cs);
                        cell.setCellValue("Sub County");
                        colIndex += 1;
                    }
                    if (lowestreportformlevel.equals("Parish")) {
                        cell = (XSSFCell) row.createCell(colIndex);
                        cell.setCellStyle(cs);
                        cell.setCellValue("Parish");
                        colIndex += 1;
                    }
                    if (lowestreportformlevel.equals("Facility")) {
                        cell = (XSSFCell) row.createCell(colIndex);
                        cell.setCellStyle(cs);
                        cell.setCellValue("Facility");
                        colIndex += 1;
                    }
                }
                cell = (XSSFCell) row.createCell(colIndex);
                cell.setCellStyle(cs);
                cell.setCellValue(de.getData_element_name());
                colIndex += 1;
            }
            //for the location fields
            String sql = "";
            if (districts != null && districts.length > 0) {
                //get 1,2,3 string format for selected districts
                String DistrictsStr = "";
                int y = 0;
                y = districts.length;
                for (int i = 0; i < y; i++) {
                    if (DistrictsStr.length() > 0) {
                        DistrictsStr = DistrictsStr + "," + districts[i].getDistrict_id();
                    } else {
                        DistrictsStr = "" + districts[i].getDistrict_id();
                    }
                }
                if (lowestreportformlevel.equals("Parish")) {
                    try {
                        sql = "SELECT DISTINCT district_name,sub_county_name,parish_name FROM vw_location where district_id IN (" + DistrictsStr + ") and p_is_active=1 order by district_name,sub_county_name,parish_name";
                        List<Object[]> objects = EIHDMSPersistentManager.instance().getSession().createSQLQuery(sql).list();
                        for (Object[] obj : objects) {
                            rowIndex = rowIndex + 1;
                            row = spreadsheet.createRow(rowIndex);
                            colIndex = 0;
                            cell = (XSSFCell) row.createCell(colIndex);
                            cell.setCellStyle(cs);
                            cell.setCellValue(obj[0].toString());
                            colIndex += 1;
                            cell = (XSSFCell) row.createCell(colIndex);
                            cell.setCellStyle(cs);
                            cell.setCellValue(obj[1].toString());
                            colIndex += 1;
                            cell = (XSSFCell) row.createCell(colIndex);
                            cell.setCellStyle(cs);
                            cell.setCellValue(obj[2].toString());
                            colIndex += 1;
                        }
                    } catch (PersistentException ex) {
                        Logger.getLogger(Data_elementBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (lowestreportformlevel.equals("Facility")) {
                    try {
                        sql = "SELECT DISTINCT district_name,sub_county_name,health_facility_name FROM vw_location where district_id IN (" + DistrictsStr + ") and hf_is_active=1 order by district_name,sub_county_name,health_facility_name";
                        List<Object[]> objects = EIHDMSPersistentManager.instance().getSession().createSQLQuery(sql).list();
                        for (Object[] obj : objects) {
                            rowIndex = rowIndex + 1;
                            row = spreadsheet.createRow(rowIndex);
                            colIndex = 0;
                            cell = (XSSFCell) row.createCell(colIndex);
                            cell.setCellStyle(cs);
                            cell.setCellValue(obj[0].toString());
                            colIndex += 1;
                            cell = (XSSFCell) row.createCell(colIndex);
                            cell.setCellStyle(cs);
                            cell.setCellValue(obj[1].toString());
                            colIndex += 1;
                            cell = (XSSFCell) row.createCell(colIndex);
                            cell.setCellStyle(cs);
                            cell.setCellValue(obj[2].toString());
                            colIndex += 1;
                        }
                    } catch (PersistentException ex) {
                        Logger.getLogger(Data_elementBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (lowestreportformlevel.equals("District")) {
                    try {
                        sql = "SELECT DISTINCT district_name,district_id FROM vw_location where district_id IN (" + DistrictsStr + ") and d_is_active=1 order by district_name";
                        
                        List<Object[]> objects = EIHDMSPersistentManager.instance().getSession().createSQLQuery(sql).list();
                        for (Object[] obj : objects) {
                            rowIndex = rowIndex + 1;
                            row = spreadsheet.createRow(rowIndex);
                            colIndex = 0;
                            cell = (XSSFCell) row.createCell(colIndex);
                            cell.setCellStyle(cs);
                            cell.setCellValue(obj[0].toString());
                        }
                    } catch (PersistentException ex) {
                        Logger.getLogger(Data_elementBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            HttpServletResponse res = HttpJSFUtil.getResponse();
            res.setContentType("application/vnd.ms-excel");
            res.setHeader("Content-disposition", "attachment; filename=" + filename + ".xlsx");
            try {
                ServletOutputStream sout = res.getOutputStream();
                workbook.write(sout);
                sout.flush();
                sout.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            FacesContext faces = FacesContext.getCurrentInstance();
            faces.responseComplete();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DownloadExcelTemplate_old(List<Data_element> des, String filename, String sheetname, String lowestreportformlevel) {
        XSSFWorkbook workbook = null;
        int rowIndex = 0;
        int colIndex = 0;

        try {
            //Create Blank workbook
            workbook = new XSSFWorkbook();
            //Create a blank spreadsheet
            XSSFSheet spreadsheet = workbook.createSheet(sheetname);

            //set the margins
            double leftMarginInches = spreadsheet.getMargin(spreadsheet.LeftMargin);
            double topMarginInches = spreadsheet.getMargin(spreadsheet.TopMargin);

            double rightMarginInches = spreadsheet.getMargin(spreadsheet.RightMargin);
            double bottomMarginInches = spreadsheet.getMargin(spreadsheet.BottomMargin);
            spreadsheet.setMargin(spreadsheet.LeftMargin, leftMarginInches * 0);
            spreadsheet.setMargin(spreadsheet.TopMargin, topMarginInches * 0);
            spreadsheet.setMargin(spreadsheet.RightMargin, rightMarginInches * 0);
            spreadsheet.setMargin(spreadsheet.BottomMargin, bottomMarginInches * 0);
            spreadsheet.setMargin(spreadsheet.HeaderMargin, 0);
            spreadsheet.setMargin(spreadsheet.FooterMargin, 0);
            spreadsheet.setFitToPage(true);

            //create first row on a created spreadsheet
            XSSFRow row = null;
            XSSFCell cell = null;

            //--------------fonts---------------
            XSSFFont fontTop = workbook.createFont();
            fontTop.setBold(false);
            fontTop.setFontName("Arial");
            fontTop.setFontHeightInPoints((short) 16);

            //--------------header--------------
            rowIndex = 0;
            colIndex = 0;
            //set wrap text to true
            CellStyle cs = workbook.createCellStyle();
            cs.setWrapText(true);

            row = spreadsheet.createRow(rowIndex);
            for (Data_element de : des) {
                if (colIndex == 0) {
                    cell = (XSSFCell) row.createCell(colIndex);
                    cell.setCellStyle(cs);
                    cell.setCellValue("District");
                    colIndex += 1;
                    if (lowestreportformlevel.equals("Parish") || lowestreportformlevel.equals("Facility")) {
                        cell = (XSSFCell) row.createCell(colIndex);
                        cell.setCellStyle(cs);
                        cell.setCellValue("Sub County");
                        colIndex += 1;
                    }
                    if (lowestreportformlevel.equals("Parish")) {
                        cell = (XSSFCell) row.createCell(colIndex);
                        cell.setCellStyle(cs);
                        cell.setCellValue("Parish");
                        colIndex += 1;
                    }
                    if (lowestreportformlevel.equals("Facility")) {
                        cell = (XSSFCell) row.createCell(colIndex);
                        cell.setCellStyle(cs);
                        cell.setCellValue("Facility");
                        colIndex += 1;
                    }
                }
                cell = (XSSFCell) row.createCell(colIndex);
                cell.setCellStyle(cs);
                cell.setCellValue(de.getData_element_name());
                colIndex += 1;
            }
            /*
             //Create file system using specific name
             out = new FileOutputStream(new File(fileNameFull));
             //write operation workbook using file out object
             workbook.write(out);
            
             //close
             out.close();
             */
            HttpServletResponse res = HttpJSFUtil.getResponse();
            res.setContentType("application/vnd.ms-excel");
            res.setHeader("Content-disposition", "attachment; filename=" + filename + ".xlsx");
            try {
                ServletOutputStream sout = res.getOutputStream();
                workbook.write(sout);
                sout.flush();
                sout.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            FacesContext faces = FacesContext.getCurrentInstance();
            faces.responseComplete();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTreeNodeByNone(Report_form report_form) {
        TreeNodeByNone = new DefaultTreeNode("TreeNodeByNone", null);
        TreeNode formNode = new DefaultTreeNode(null);
        TreeNode sectionNode = new DefaultTreeNode(null);
        TreeNode subsectionNode = new DefaultTreeNode(null);
        TreeNode elementNode = new DefaultTreeNode(null);
        if (null != report_form) {
            try {
                formNode = new DefaultTreeNode(report_form.getReport_form_name(), TreeNodeByNone);
                List<Section> tempSections = Section.querySection("report_form_id=" + report_form.getReport_form_id(), "section_order,section_id");
                for (Section section : tempSections) {
                    if (section.getReport_form().getReport_form_id() == report_form.getReport_form_id()) {
                        sectionNode = new DefaultTreeNode(section.getSection_name(), formNode);
                    }
                    List<Sub_section> tempSub_sections = Sub_section.querySub_section("section_id=" + section.getSection_id(), "sub_section_order,sub_section_id");
                    for (Sub_section sub_section : tempSub_sections) {
                        if (sub_section.getSection().getSection_id() == section.getSection_id()) {
                            subsectionNode = new DefaultTreeNode(sub_section.getSub_section_name(), sectionNode);
                            List<Data_element> tempData_elements = Data_element.queryData_element("sub_section_id=" + sub_section.getSub_section_id(), "section_column_number");
                            for (Data_element data_element : tempData_elements) {
                                if (data_element.getSub_section().getSub_section_id() == sub_section.getSub_section_id()) {
                                    elementNode = new DefaultTreeNode(data_element.getData_element_name(), subsectionNode);
                                }
                            }
                        }
                    }
                }
            } catch (PersistentException ex) {
                Logger.getLogger(Data_elementBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void getTreeNodeByGroup(Report_form report_form) {
        TreeNodeByGroup = new DefaultTreeNode("TreeNodeByGroup", null);
        TreeNode formNode = new DefaultTreeNode(null);
        TreeNode groupNode = new DefaultTreeNode(null);
        TreeNode sectionNode = new DefaultTreeNode(null);
        TreeNode subsectionNode = new DefaultTreeNode(null);
        TreeNode elementNode = new DefaultTreeNode(null);
        if (null != report_form) {
            try {
                formNode = new DefaultTreeNode(report_form.getReport_form_name(), TreeNodeByGroup);
                List<Report_form_group> tempReport_form_groups = Report_form_group.queryReport_form_group("report_form_id=" + report_form.getReport_form_id(), "group_order,report_form_group_id");
                for (Report_form_group report_form_group : tempReport_form_groups) {
                    if (report_form_group.getReport_form().getReport_form_id() == report_form.getReport_form_id()) {
                        groupNode = new DefaultTreeNode(report_form_group.getReport_form_group_name(), formNode);
                    }
                    List<Data_element> tempData_elements = Data_element.queryData_element("report_form_group_id=" + report_form_group.getReport_form_group_id(), "group_column_number");
                    for (Data_element data_element : tempData_elements) {
                        if (data_element.getReport_form_group().getReport_form_group_id() == report_form_group.getReport_form_group_id()) {
                            elementNode = new DefaultTreeNode(data_element.getData_element_name(), groupNode);
                        }
                    }
                }
            } catch (PersistentException ex) {
                Logger.getLogger(Data_elementBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void getTreeNodes(Report_form report_form) {
        this.getTreeNodeByNone(report_form);
        this.getTreeNodeByGroup(report_form);
    }

    public Data_element getData_element(int data_element_id) {
        Data_element aData_element = new Data_element();
        try {
            aData_element = Data_element.getData_elementByORMID(data_element_id);
        } catch (PersistentException ex) {
            Logger.getLogger(Data_elementBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aData_element;
    }

    public void refreshReport_form_groupList(Report_form report_form) {
        report_form_groupList = new ArrayList<>();
        try {
            report_form_groupList = Report_form_group.queryReport_form_group("report_form_id=" + report_form.getReport_form_id(), "group_order ASC");
        } catch (PersistentException ex) {
            Logger.getLogger(Data_elementBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshSectionList(Report_form report_form) {
        sectionList = new ArrayList<>();
        try {
            sectionList = Section.querySection("report_form_id=" + report_form.getReport_form_id(), "section_order ASC");
        } catch (PersistentException ex) {
            Logger.getLogger(Data_elementBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshSub_sectionList(Section section) {
        sub_sectionList = new ArrayList<>();
        try {
            sub_sectionList = Section.querySection("section_id=" + section.getSection_id(), "sub_section_order ASC");
        } catch (PersistentException ex) {
            Logger.getLogger(Data_elementBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Sub_section> returnSub_sectionList(Section section) {
        sub_sectionList = new ArrayList<>();
        try {
            sub_sectionList = Sub_section.querySub_section("section_id=" + section.getSection_id(), "sub_section_order ASC");
        } catch (PersistentException ex) {
            Logger.getLogger(Data_elementBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sub_sectionList;
    }

    public String returnReport_form_groupList(Section section, Sub_section sub_section) {
        String sql = "";
        String form_list = "";
        if (section != null && sub_section != null) {
            try {
                sql = "select distinct report_form_group from Data_element where section_id=" + section.getSection_id() + " and sub_section_id=" + sub_section.getSub_section_id();
                List<Report_form_group> RFGs = EIHDMSPersistentManager.instance().getSession().createQuery(sql).list();
                for (Report_form_group RFG : RFGs) {
                    if (form_list.length() > 0) {
                        form_list = form_list + ", " + RFG.getReport_form_group_name();
                    } else {
                        form_list = RFG.getReport_form_group_name();
                    }
                }
            } catch (PersistentException ex) {
                Logger.getLogger(Data_elementBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return form_list;
    }

    public void refreshData_elementList(Report_form report_form) {
        data_elementList = new ArrayList<>();
        try {
            data_elementList = Data_element.queryData_element("report_form_id=" + report_form.getReport_form_id(), "group_column_number,section_column_number");
        } catch (PersistentException ex) {
            Logger.getLogger(Data_elementBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onRowReorder(ReorderEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Row Moved", "From: " + event.getFromIndex() + ", To:" + event.getToIndex());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * @return the TreeNodeByNone
     */
    public TreeNode getTreeNodeByNone() {
        return TreeNodeByNone;
    }

    /**
     * @param TreeNodeByNone the TreeNodeByNone to set
     */
    public void setTreeNodeByNone(TreeNode TreeNodeByNone) {
        this.TreeNodeByNone = TreeNodeByNone;
    }

    /**
     * @return the TreeNodeByGroup
     */
    public TreeNode getTreeNodeByGroup() {
        return TreeNodeByGroup;
    }

    /**
     * @param TreeNodeByGroup the TreeNodeByGroup to set
     */
    public void setTreeNodeByGroup(TreeNode TreeNodeByGroup) {
        this.TreeNodeByGroup = TreeNodeByGroup;
    }

    /**
     * @return the report_form_groupBean
     */
    public Report_form_groupBean getReport_form_groupBean() {
        return report_form_groupBean;
    }

    /**
     * @param report_form_groupBean the report_form_groupBean to set
     */
    public void setReport_form_groupBean(Report_form_groupBean report_form_groupBean) {
        this.report_form_groupBean = report_form_groupBean;
    }

    /**
     * @return the dataelementtreenode
     */
    public TreeNode getDataelementtreenode() {
        if (null == dataelementtreenode) {
            dataelementtreenode = new DefaultTreeNode();
        }
        return dataelementtreenode;
    }

    /**
     * @param dataelementtreenode the dataelementtreenode to set
     */
    public void setDataelementtreenode(TreeNode dataelementtreenode) {
        this.dataelementtreenode = dataelementtreenode;
    }

    /**
     * @return the report_form_groupList
     */
    public List<Report_form_group> getReport_form_groupList() {
        return report_form_groupList;
    }

    /**
     * @param report_form_groupList the report_form_groupList to set
     */
    public void setReport_form_groupList(List<Report_form_group> report_form_groupList) {
        this.report_form_groupList = report_form_groupList;
    }

    /**
     * @return the sectionList
     */
    public List<Section> getSectionList() {
        return sectionList;
    }

    /**
     * @param sectionList the sectionList to set
     */
    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    /**
     * @return the sub_sectionList
     */
    public List<Sub_section> getSub_sectionList() {
        return sub_sectionList;
    }

    /**
     * @param sub_sectionList the sub_sectionList to set
     */
    public void setSub_sectionList(List<Sub_section> sub_sectionList) {
        this.sub_sectionList = sub_sectionList;
    }

    /**
     * @return the data_elementList
     */
    public List<Data_element> getData_elementList() {
        return data_elementList;
    }

    /**
     * @param data_elementList the data_elementList to set
     */
    public void setData_elementList(List<Data_element> data_elementList) {
        this.data_elementList = data_elementList;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.EIHDMSPersistentManager;
import eihdms.Data_element;
import eihdms.Report_form;
import eihdms.Report_form_group;
import eihdms.Section;
import eihdms.Sub_section;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.primefaces.model.DefaultStreamedContent;
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

    @ManagedProperty("#{report_formBean}")
    private Report_formBean report_formBean;
    @ManagedProperty("#{sectionBean}")
    private SectionBean sectionBean;
    @ManagedProperty("#{sub_sectionBean}")
    private Sub_sectionBean sub_sectionBean;

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

    public TreeNode dataelementtreenode;

    public TreeNode getDataelementtreenode() {
        Data_element d0 = new Data_element();
        d0.setData_element_name("Root");
        d0.setData_type("-");
        dataelementtreenode = new DefaultTreeNode(d0, null);
        TreeNode level2 = new DefaultTreeNode(null);
        TreeNode level3 = new DefaultTreeNode(null);
        TreeNode level1 = new DefaultTreeNode(null);
        TreeNode level4 = new DefaultTreeNode(null);
        for (Report_form report_form : report_formBean.getTsActive()) {
            Data_element d1 = new Data_element();
            d1.setData_element_name(report_form.getReport_form_name());
            d1.setData_type("-");
            level1 = new DefaultTreeNode(d1, dataelementtreenode);
            for (Section section : sectionBean.getTsActive()) {
                if (section.getReport_form().getReport_form_id() == report_form.getReport_form_id()) {
                    Data_element d2 = new Data_element();
                    d2.setData_element_name(section.getSection_name());
                    d2.setData_type("-");
                    level2 = new DefaultTreeNode(d2, level1);
                }
                for (Sub_section sub_section : sub_sectionBean.getTsActive()) {
                    if (sub_section.getSection().getSection_id() == section.getSection_id()) {
                        Data_element d3 = new Data_element();
                        d3.setData_element_name(sub_section.getSub_section_name());
                        d3.setData_type("-");
                        level3 = new DefaultTreeNode(d3, level2);
                        for (Data_element data_element : this.getTsActive()) {
                            if (data_element.getSub_section().getSub_section_id() == sub_section.getSub_section_id()) {
                                level4 = new DefaultTreeNode("dataelement", data_element, level3);
                            }
                        }
                    }
                }
            }
        }
        return dataelementtreenode;
    }

    public void setDataelementtreenode(TreeNode dataelementtreenode) {
        this.dataelementtreenode = dataelementtreenode;
    }

    public void retrieveReportFormOrderedDataElements(Report_form report_form, Report_form_group report_form_group) {
        String sql = "";
        List<Data_element> data_elements = new ArrayList<Data_element>();
        try {
            if (report_form != null && report_form_group != null) {
                sql = "select de from Data_element de INNER JOIN de.report_form_group fg where de.report_form=" + report_form + " and de.report_form_group=" + report_form_group + " order by fg.group_order,de.group_column_number ASC";
                data_elements = (List<Data_element>) EIHDMSPersistentManager.instance().getSession().createQuery(sql).list();
                if (data_elements.size() > 0) {
                    this.DownloadExcelTemplate(data_elements);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DownloadExcelTemplate(List<Data_element> des) {
        XSSFWorkbook workbook = null;
        int rowIndex = 0;
        int colIndex = 0;

        try {
            //Create Blank workbook
            workbook = new XSSFWorkbook();
            //Create a blank spreadsheet
            XSSFSheet spreadsheet = workbook.createSheet("template");

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
                    cell.setCellValue(de.getReport_form().getLowest_report_form_level());
                    colIndex += 1;
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
            res.setHeader("Content-disposition", "attachment; filename=test.xls");
            try {
                ServletOutputStream sout=res.getOutputStream();
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
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.EIHDMSPersistentManager;
import eihdms.Data_element;
import eihdms.Report_form;
import eihdms.Section;
import eihdms.Sub_section;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.orm.PersistentException;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class Data_elementBean extends AbstractBean<Data_element> implements Serializable {

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

}

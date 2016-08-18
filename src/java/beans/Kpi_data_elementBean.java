/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Data_element;
import eihdms.EIHDMSPersistentManager;
import eihdms.Kpi_data_element;
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

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class Kpi_data_elementBean extends AbstractBean<Kpi_data_element> implements Serializable {

    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    private Report_form report_form;
    private Section section;
    private Sub_section sub_section;

    public Kpi_data_elementBean() {
        super(Kpi_data_element.class);
    }

    @Override
    public void init() {
        if (super.getEntityClass() == null) {
            loginBean.logout();
        }
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public Report_form getReport_form() {
        return report_form;
    }

    public void setReport_form(Report_form report_form) {
        this.report_form = report_form;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public void edit(Kpi_data_element t) {
        this.report_form = t.getData_element().getReport_form();
        this.section = t.getData_element().getSection();
        super.edit(t); //To change body of generated methods, choose Tools | Templates.
        this.getSelected().setKpi(t.getKpi());
    }

    @Override
    public void delete() {
        clear();
        super.delete(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(int aUserDetailId) {
        clear();
        super.save(aUserDetailId); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancel() {
        clear();
        super.cancel(); //To change body of generated methods, choose Tools | Templates.
    }

    private void clear() {
        section = null;
        report_form = null;
    }

    public List<Data_element> completeData_element(String query) {
        List<Data_element> filteredData_elements = new ArrayList<>();
        try {
            if (report_form != null && section != null) {
                filteredData_elements = (List<Data_element>) EIHDMSPersistentManager.instance().getSession().createQuery("select de FROM Data_element  de where de.is_deleted<>1 AND de.report_form.report_form_id=" + report_form.getReport_form_id() + " AND  de.section=" + section.getSection_id() + " AND de.data_element_name like '%" + query + "%'").list();
            } else {
                filteredData_elements = (List<Data_element>) EIHDMSPersistentManager.instance().getSession().createQuery("select de FROM Data_element  de where de.is_deleted<>1 AND ( de.description like '%" + query + "%' OR  de.technical_area.technical_area_name '%" + query + "%' or de.report_form.report_form_name like '%" + query + "%' OR de.data_element_name like '%" + query + "%')").list();
            }
        } catch (PersistentException ex) {
            Logger.getLogger(Data_elementBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filteredData_elements;
    }
}

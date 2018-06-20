/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Base_data;
import eihdms.Data_element;
import eihdms.Report_form;
import java.util.ArrayList;
import java.util.List;
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
public class TestBean {

    List<Data_element> data_elementList = new ArrayList<>();
    List<Base_data> base_dataList = new ArrayList<>();

    public List<Data_element> getData_elementList() {
        return data_elementList;
    }

    public void setData_elementList(List<Data_element> data_elementList) {
        this.data_elementList = data_elementList;
    }

    public List<Base_data> getBase_dataList() {
        return base_dataList;
    }

    public void setBase_dataList(List<Base_data> base_dataList) {
        this.base_dataList = base_dataList;
    }

    public void save() {
        for (Base_data base_data : base_dataList) {
            System.out.println(base_data.getData_element().getData_element_name() + ": " + base_data.getData_element_value());
        }
    }

    public void retrieve_data(Report_form report_form) {
        if (report_form != null) {
            try {
                //report_form = Report_form.getReport_formByORMID(39);
                data_elementList = Data_element.queryData_element("report_form_id=" + report_form.getReport_form_id(), null);
                base_dataList = new ArrayList<>();
                for (Data_element data_element : data_elementList) {
                    Base_data base_data = new Base_data();
                    base_data.setData_element(data_element);
                    base_dataList.add(base_data);
                }
            } catch (PersistentException ex) {
                Logger.getLogger(TestBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Report_form> get_report_forms_by_user() {
        try {
            return Report_form.queryReport_form("is_active=1 and is_deleted=0", null);
        } catch (PersistentException ex) {
            Logger.getLogger(TestBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public void clear(){
        base_dataList=new ArrayList<>();
    }

}

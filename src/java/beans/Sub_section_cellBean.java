/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.EIHDMSPersistentManager;
import eihdms.Report_form;
import eihdms.Report_form_group;
import eihdms.Sub_section;
import eihdms.Sub_section_cell;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;
import org.orm.PersistentException;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class Sub_section_cellBean extends AbstractBean<Sub_section_cell> implements Serializable {
    private Report_form report_form;
    private Sub_section_cell[][] cellArray;
    
    public Sub_section_cellBean() {
        super(Sub_section_cell.class);
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
    
    public List<Sub_section_cell> getts(Sub_section subsection) {
        List<Sub_section_cell> temp = new ArrayList<>();
        try {
            if (this.getEntityClass() != null && subsection != null) {
                temp = (List<Sub_section_cell>) EIHDMSPersistentManager.instance().getSession().createQuery("select ssc FROM Sub_section_cell  ssc where ssc.is_deleted<>1 AND ssc.sub_section=" + subsection.getSub_section_id()).list();
            } else {
                temp = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
    
//    public void refreshCellArray(Report_form rf,Report_form_group rfg) {
//        String sql="SELECT * FROM sub_section_cell cell WHERE cell.data_element_id IN("
//                + "SELECT de.data_element_id FROM data_element de WHERE report_form_group_id=" + rfg.getReport_form_group_id()
//                + ")";
//        
//            //for rows and cols
//            Integer rowscount2 = 5;
//            Integer colscount2 = 6;
//            rws2 = new ArrayList<>();
//            for (Integer i = 1; i <= rowscount2; i++) {
//                rws2.add(i);
//            }
//            cls2 = new ArrayList<>();
//            for (Integer i = 1; i <= colscount2; i++) {
//                cls2.add(i);
//            }
//            this.cellsArray2 = new test[rowscount2+1][colscount2+1];
//            test t;
//            String rcs;
//            //r = 0;
//            for (r2 = 0; r2 <= rowscount2; r2++) {
//                if (r2 == 0) {
//                    continue;
//                }
//                if(r2==1){
//                    t = new test();
//                    t.setDe_id(0);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    t.setRow_span(2);
//                    this.cellsArray2[r2][1] = t;
//                    t = new test();
//                    t.setDe_id(0);
//                    t.setLabel_name("MALE");
//                    t.setCol_span(2);
//                    this.cellsArray2[r2][2] = t;
//                    t = new test();
//                    t.setDe_id(0);
//                    t.setLabel_name("FEMALE");
//                    t.setCol_span(2);
//                    this.cellsArray2[r2][3] = t;
//                    t = new test();
//                    t.setDe_id(0);
//                    t.setLabel_name("TOTAL");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][4] = t;
//                }
//                if(r2==2){
//                    t = new test();
//                    t.setDe_id(0);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][1] = t;
//                    t = new test();
//                    t.setDe_id(0);
//                    t.setLabel_name("<18");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][2] = t;
//                    t = new test();
//                    t.setDe_id(0);
//                    t.setLabel_name(">=18");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][3] = t;
//                    t = new test();
//                    t.setDe_id(0);
//                    t.setLabel_name("<18");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][4] = t;
//                    t = new test();
//                    t.setDe_id(0);
//                    t.setLabel_name(">=18");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][5] = t;
//                    t = new test();
//                    t.setDe_id(0);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][6] = t;
//                }
//                if(r2==3){
//                    t = new test();
//                    t.setDe_id(0);
//                    t.setLabel_name("Malaria");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][1] = t;
//                    t = new test();
//                    t.setDe_id(32);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][2] = t;
//                    t = new test();
//                    t.setDe_id(33);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][3] = t;
//                    t = new test();
//                    t.setDe_id(34);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][4] = t;
//                    t = new test();
//                    t.setDe_id(35);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][5] = t;
//                    t = new test();
//                    t.setDe_id(36);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][6] = t;
//                }
//                if(r2==4){
//                    t = new test();
//                    t.setDe_id(0);
//                    t.setLabel_name("Dysentry");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][1] = t;
//                    t = new test();
//                    t.setDe_id(42);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][2] = t;
//                    t = new test();
//                    t.setDe_id(43);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][3] = t;
//                    t = new test();
//                    t.setDe_id(44);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][4] = t;
//                    t = new test();
//                    t.setDe_id(45);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][5] = t;
//                    t = new test();
//                    t.setDe_id(46);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][6] = t;
//                }
//                if(r2==5){
//                    t = new test();
//                    t.setDe_id(0);
//                    t.setLabel_name("BCG");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][1] = t;
//                    t = new test();
//                    t.setDe_id(52);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][2] = t;
//                    t = new test();
//                    t.setDe_id(53);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][3] = t;
//                    t = new test();
//                    t.setDe_id(54);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][4] = t;
//                    t = new test();
//                    t.setDe_id(55);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][5] = t;
//                    t = new test();
//                    t.setDe_id(56);
//                    t.setLabel_name("");
//                    t.setCol_span(1);
//                    this.cellsArray2[r2][6] = t;
//                }
//            }
//    }

    public Report_form getReport_form() {
        return report_form;
    }

    public void setReport_form(Report_form report_form) {
        this.report_form = report_form;
    }

    /**
     * @return the cellArray
     */
    public Sub_section_cell[][] getCellArray() {
        return cellArray;
    }

    /**
     * @param cellArray the cellArray to set
     */
    public void setCellArray(Sub_section_cell[][] cellArray) {
        this.cellArray = cellArray;
    }
}

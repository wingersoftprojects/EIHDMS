/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Data_element;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class GenerateValidationBean {

    private String validation_formula = "";

    private Data_element data_element;

    public Data_element getData_element() {
        return data_element;
    }

    public void setData_element(Data_element data_element) {
        this.data_element = data_element;
    }

    public String getValidation_formula() {
        return validation_formula;
    }

    public void setValidation_formula(String validation_formula) {
        this.validation_formula = validation_formula;
    }

    public void append_operand(String operand) {
        if (operand.equals("le")) {
            operand = "<=";
        }
        if (operand.equals("lt")) {
            operand = "<";
        }
        validation_formula += " " + operand;
    }

    public void append_data_element() {
        validation_formula += " Col" + data_element.getData_element_id();
    }

}

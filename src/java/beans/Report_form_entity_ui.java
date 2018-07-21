/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class Report_form_entity_ui implements Serializable {
    private String entity_parent_name;
    private String entity_name;
    private String entity_type;
    private int entity_id;
    private int report_form_id;
    private long report_form_entity_id;
    private boolean is_checked;
    private int item_no;

    /**
     * @return the entity_parent_name
     */
    public String getEntity_parent_name() {
        return entity_parent_name;
    }

    /**
     * @param entity_parent_name the entity_parent_name to set
     */
    public void setEntity_parent_name(String entity_parent_name) {
        this.entity_parent_name = entity_parent_name;
    }

    /**
     * @return the entity_name
     */
    public String getEntity_name() {
        return entity_name;
    }

    /**
     * @param entity_name the entity_name to set
     */
    public void setEntity_name(String entity_name) {
        this.entity_name = entity_name;
    }

    /**
     * @return the entity_type
     */
    public String getEntity_type() {
        return entity_type;
    }

    /**
     * @param entity_type the entity_type to set
     */
    public void setEntity_type(String entity_type) {
        this.entity_type = entity_type;
    }

    /**
     * @return the report_form_id
     */
    public int getReport_form_id() {
        return report_form_id;
    }

    /**
     * @param report_form_id the report_form_id to set
     */
    public void setReport_form_id(int report_form_id) {
        this.report_form_id = report_form_id;
    }

    /**
     * @return the report_form_entity_id
     */
    public long getReport_form_entity_id() {
        return report_form_entity_id;
    }

    /**
     * @param report_form_entity_id the report_form_entity_id to set
     */
    public void setReport_form_entity_id(long report_form_entity_id) {
        this.report_form_entity_id = report_form_entity_id;
    }

    /**
     * @return the is_checked
     */
    public boolean isIs_checked() {
        return is_checked;
    }

    /**
     * @param is_checked the is_checked to set
     */
    public void setIs_checked(boolean is_checked) {
        this.is_checked = is_checked;
    }

    /**
     * @return the item_no
     */
    public int getItem_no() {
        return item_no;
    }

    /**
     * @param item_no the item_no to set
     */
    public void setItem_no(int item_no) {
        this.item_no = item_no;
    }

    /**
     * @return the entity_id
     */
    public int getEntity_id() {
        return entity_id;
    }

    /**
     * @param entity_id the entity_id to set
     */
    public void setEntity_id(int entity_id) {
        this.entity_id = entity_id;
    }
}

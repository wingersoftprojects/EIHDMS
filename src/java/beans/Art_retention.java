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
public class Art_retention implements Serializable {
    private int district_id;
    private String district_name;
    private int health_facility_id;
    private String health_facility_name;
    private int cohort_start_year;
    private int cohort_start_month;
    private int m0;
    private int m1;
    private int m2;
    private int m3;
    private int m4;
    private int m5;

    /**
     * @return the health_facility_id
     */
    public int getHealth_facility_id() {
        return health_facility_id;
    }

    /**
     * @param health_facility_id the health_facility_id to set
     */
    public void setHealth_facility_id(int health_facility_id) {
        this.health_facility_id = health_facility_id;
    }

    /**
     * @return the health_facility_name
     */
    public String getHealth_facility_name() {
        return health_facility_name;
    }

    /**
     * @param health_facility_name the health_facility_name to set
     */
    public void setHealth_facility_name(String health_facility_name) {
        this.health_facility_name = health_facility_name;
    }

    /**
     * @return the cohort_start_year
     */
    public int getCohort_start_year() {
        return cohort_start_year;
    }

    /**
     * @param cohort_start_year the cohort_start_year to set
     */
    public void setCohort_start_year(int cohort_start_year) {
        this.cohort_start_year = cohort_start_year;
    }

    /**
     * @return the cohort_start_month
     */
    public int getCohort_start_month() {
        return cohort_start_month;
    }

    /**
     * @param cohort_start_month the cohort_start_month to set
     */
    public void setCohort_start_month(int cohort_start_month) {
        this.cohort_start_month = cohort_start_month;
    }

    /**
     * @return the m0
     */
    public int getMo() {
        return m0;
    }

    /**
     * @param m0 the m0 to set
     */
    public void setMo(int m0) {
        this.m0 = m0;
    }

    /**
     * @return the m1
     */
    public int getM1() {
        return m1;
    }

    /**
     * @param m1 the m1 to set
     */
    public void setM1(int m1) {
        this.m1 = m1;
    }

    /**
     * @return the m2
     */
    public int getM2() {
        return m2;
    }

    /**
     * @param m2 the m2 to set
     */
    public void setM2(int m2) {
        this.m2 = m2;
    }

    /**
     * @return the m3
     */
    public int getM3() {
        return m3;
    }

    /**
     * @param m3 the m3 to set
     */
    public void setM3(int m3) {
        this.m3 = m3;
    }

    /**
     * @return the m4
     */
    public int getM4() {
        return m4;
    }

    /**
     * @param m4 the m4 to set
     */
    public void setM4(int m4) {
        this.m4 = m4;
    }

    /**
     * @return the m5
     */
    public int getM5() {
        return m5;
    }

    /**
     * @param m5 the m5 to set
     */
    public void setM5(int m5) {
        this.m5 = m5;
    }

    /**
     * @return the district_id
     */
    public int getDistrict_id() {
        return district_id;
    }

    /**
     * @param district_id the district_id to set
     */
    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    /**
     * @return the district_name
     */
    public String getDistrict_name() {
        return district_name;
    }

    /**
     * @param district_name the district_name to set
     */
    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }
}

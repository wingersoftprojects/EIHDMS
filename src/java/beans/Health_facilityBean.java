/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.County;
import eihdms.District;
import eihdms.Health_facility;
import eihdms.Parish;
import eihdms.Sub_county;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class Health_facilityBean extends AbstractBean<Health_facility> implements Serializable {

    private District district;
    @ManagedProperty("#{districtBean}")
    private DistrictBean districtBean;
    private TreeNode LocationTreeNode;
    @ManagedProperty("#{countyBean}")
    private CountyBean countyBean;
    @ManagedProperty("#{sub_countyBean}")
    private Sub_countyBean sub_countyBean;
    @ManagedProperty("#{parishBean}")
    private ParishBean parishBean;

    public Health_facilityBean() {
        super(Health_facility.class);
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

    public void getLocationTreeNodeByDistrict(District aDistrict) {
        LocationTreeNode = new DefaultTreeNode("LocationTreeNode", null);
        TreeNode regionNode = new DefaultTreeNode(null);
        TreeNode districtNode = new DefaultTreeNode(null);
        TreeNode countyNode = new DefaultTreeNode(null);
        TreeNode sub_countyNode = new DefaultTreeNode(null);
        TreeNode parishNode = new DefaultTreeNode(null);
        TreeNode health_facilityNode = new DefaultTreeNode(null);
        if (null != aDistrict) {
            districtNode = new DefaultTreeNode(aDistrict.getDistrict_name(), LocationTreeNode);
            for (County county : countyBean.getTsActive()) {
                if (county.getDistrict().getDistrict_id() == aDistrict.getDistrict_id()) {
                    countyNode = new DefaultTreeNode(county.getCounty_name(), districtNode);
                    for (Sub_county sub_county : sub_countyBean.getTsActive()) {
                        if (sub_county.getCounty().getCounty_id() == county.getCounty_id()) {
                            sub_countyNode = new DefaultTreeNode(sub_county.getSub_county_name(), countyNode);
                            for (Parish parish : parishBean.getTsActive()) {
                                if (parish.getSub_county().getSub_county_id() == sub_county.getSub_county_id()) {
                                    parishNode = new DefaultTreeNode(parish.getParish_name(), sub_countyNode);
                                    for (Health_facility health_facility : this.getTsActive()) {
                                        if (health_facility.getParish().getParish_id() == parish.getParish_id()) {
                                            health_facilityNode = new DefaultTreeNode(health_facility.getHealth_facility_name(), parishNode);
                                        }
                                    }

                                }
                            }
                        }
                    }
                }

            }
        }
    }

    public void getLocationTreeNodeByDistrict_F(District aDistrict) {
        LocationTreeNode = new DefaultTreeNode("LocationTreeNode", null);
        //TreeNode regionNode = new DefaultTreeNode(null);
        TreeNode districtNode = new DefaultTreeNode(null);
        //TreeNode countyNode = new DefaultTreeNode(null);
        TreeNode sub_countyNode = new DefaultTreeNode(null);
        //TreeNode parishNode = new DefaultTreeNode(null);
        TreeNode health_facilityNode = new DefaultTreeNode(null);
        if (null != aDistrict) {
            districtNode = new DefaultTreeNode(aDistrict.getDistrict_name(), LocationTreeNode);
            for (Sub_county sub_county : sub_countyBean.getTsActive()) {
                if (sub_county.getCounty().getDistrict().getDistrict_id() == aDistrict.getDistrict_id()) {
                    sub_countyNode = new DefaultTreeNode(sub_county.getSub_county_name(), districtNode);
                    for (Health_facility health_facility : this.getTsActive()) {
                        if (health_facility.getParish().getSub_county().getSub_county_id() == sub_county.getSub_county_id()) {
                            health_facilityNode = new DefaultTreeNode(health_facility.getHealth_facility_name(), sub_countyNode);
                        }
                    }
                }
            }
        }
    }

    public void getLocationTreeNodeByDistrict_P(District aDistrict) {
        LocationTreeNode = new DefaultTreeNode("LocationTreeNode", null);
        //TreeNode regionNode = new DefaultTreeNode(null);
        TreeNode districtNode = new DefaultTreeNode(null);
        //TreeNode countyNode = new DefaultTreeNode(null);
        TreeNode sub_countyNode = new DefaultTreeNode(null);
        TreeNode parishNode = new DefaultTreeNode(null);
        //TreeNode health_facilityNode = new DefaultTreeNode(null);
        if (null != aDistrict) {
            districtNode = new DefaultTreeNode(aDistrict.getDistrict_name(), LocationTreeNode);
            for (Sub_county sub_county : sub_countyBean.getTsActive()) {
                if (sub_county.getCounty().getDistrict().getDistrict_id() == aDistrict.getDistrict_id()) {
                    sub_countyNode = new DefaultTreeNode(sub_county.getSub_county_name(), districtNode);
                    for (Parish parish : parishBean.getTsActive()) {
                        if (parish.getSub_county().getSub_county_id() == sub_county.getSub_county_id()) {
                            parishNode = new DefaultTreeNode(parish.getParish_name(), sub_countyNode);
                        }
                    }
                }
            }
        }
    }

    /**
     * @return the LocationTreeNode
     */
    public TreeNode getLocationTreeNode() {
        return LocationTreeNode;
    }

    /**
     * @param LocationTreeNode the LocationTreeNode to set
     */
    public void setLocationTreeNode(TreeNode LocationTreeNode) {
        this.LocationTreeNode = LocationTreeNode;
    }

    /**
     * @return the countyBean
     */
    public CountyBean getCountyBean() {
        return countyBean;
    }

    /**
     * @param countyBean the countyBean to set
     */
    public void setCountyBean(CountyBean countyBean) {
        this.countyBean = countyBean;
    }

    /**
     * @return the sub_countyBean
     */
    public Sub_countyBean getSub_countyBean() {
        return sub_countyBean;
    }

    /**
     * @param sub_countyBean the sub_countyBean to set
     */
    public void setSub_countyBean(Sub_countyBean sub_countyBean) {
        this.sub_countyBean = sub_countyBean;
    }

    /**
     * @return the parishBean
     */
    public ParishBean getParishBean() {
        return parishBean;
    }

    /**
     * @param parishBean the parishBean to set
     */
    public void setParishBean(ParishBean parishBean) {
        this.parishBean = parishBean;
    }

    /**
     * @return the district
     */
    public District getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(District district) {
        this.district = district;
    }

    /**
     * @return the districtBean
     */
    public DistrictBean getDistrictBean() {
        return districtBean;
    }

    /**
     * @param districtBean the districtBean to set
     */
    public void setDistrictBean(DistrictBean districtBean) {
        this.districtBean = districtBean;
    }

}

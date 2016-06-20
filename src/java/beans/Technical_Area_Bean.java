/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.Technical_area;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class Technical_Area_Bean extends AbstractBean<Technical_area> implements Serializable {

    public Technical_Area_Bean() {
        super(Technical_area.class);
    }

}

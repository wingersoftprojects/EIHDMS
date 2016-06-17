/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class JsonBean {

    private JSONArray jSONArray;

    public JSONArray getjSONArray() {
        JSONArray jArray = new JSONArray();

        JSONObject jObj = new JSONObject();
        JSONObject jObj2 = new JSONObject();
        jObj.put("Gender",jObj2.put("type", "string"));
        jObj.put("Category",jObj2.put("type", "string"));
        jObj.put("Number",jObj2.put("type", "number"));
        jArray.put(jObj);

        int x = 0;
        while (x < 4000) {
            jObj = new JSONObject();
            if (x % 3 == 0) {
                jObj.put("Gender", "Male");
                jObj.put("Category", "DivisibleBy3");
            }
            if (x % 2 == 0) {
                jObj.put("Gender", "Female");
                jObj.put("Category", "DivisibleBy2");
            }
            if (x % 5 == 0) {
                jObj.put("Gender", "Unknown");
                jObj.put("Category", "DivisibleBy5");
            }
            jObj.put("Number", x);
            jArray.put(jObj);
            x++;
        }
        jSONArray = jArray;
        return jSONArray;
    }

    public void setjSONArray(JSONArray jSONArray) {
        this.jSONArray = jSONArray;
    }
}

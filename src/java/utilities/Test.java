/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author bajuna
 */
@ManagedBean
@SessionScoped
public class Test {

    public void generateReport() {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();

        HSSFRow row;

        row = sheet.createRow((short) 0);
        row.createCell((short) 0).setCellValue("Instance ID");
        row.createCell((short) 1).setCellValue("Start Date");
        row.createCell((short) 2).setCellValue("End Date");

        for (int i = 1; i < 20; i++) {
            row = sheet.createRow((short) i);
            row.createCell((short) 0).setCellValue(111);
            row.createCell((short) 1).setCellValue(222);
            row.createCell((short) 2).setCellValue(333);
        }
        HttpServletResponse res = HttpJSFUtil.getResponse();
        res.setContentType("application/vnd.ms-excel");
        res.setHeader("Content-disposition", "attachment; filename=test.xls");

        try {
            ServletOutputStream out = res.getOutputStream();

            wb.write(out);
            out.flush();
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        FacesContext faces = FacesContext.getCurrentInstance();
        faces.responseComplete();
    }
}

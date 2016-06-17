/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author bajuna
 */
public class ReadFile {

    //private static final String FILE_PATH = "D:\\My Documents\\PERSONAL\\WINGERsoft\\Proposals\\EGPAF\\USAID-EGPAF-EIHDMS\\2_Assessment\\Sample Downloads DHIS2\\testReadStudents.xlsx";
    private static final String FILE_PATH = "D:\\My Documents\\PERSONAL\\WINGERsoft\\Proposals\\EGPAF\\USAID-EGPAF-EIHDMS\\2_Assessment\\Sample Downloads DHIS2\\data (7).xls";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Student> studentList = getStudentsListFromExcel();
        System.out.println(studentList);
    }

    private static List<Student> getStudentsListFromExcel() {
        List<Student> studentList = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(FILE_PATH);

            // Using XSSF for xlsx format, for xls use HSSF
            //Workbook workbook = new XSSFWorkbook(fis);
            org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(fis);

            int numberOfSheets = workbook.getNumberOfSheets();

            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

            //looping over each workbook sheet
//            for (int i = 0; i < numberOfSheets; i++) {
//                Sheet sheet = workbook.getSheetAt(i);
            Iterator<Row> rowIterator = sheet.iterator();
            int x = 0;
            //iterating over each row
            while (rowIterator.hasNext()) {
                if (x > 0) {
                    //Student student = new Student();
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    //Iterating over each cell (column wise)  in a particular row.
                    String rowdata = "";
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                            rowdata += "|Col"+cell.getColumnIndex()+"- Value=" + cell.getStringCellValue();
                        } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                            rowdata += "|Col"+cell.getColumnIndex()+"- Value="+ cell.getNumericCellValue();
                        }
                    }
                    System.out.println(rowdata);
                }
                x++;
            }

            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentList;
    }

}

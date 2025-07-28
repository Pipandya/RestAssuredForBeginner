package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;

public class ExcelUtilities {

    static Workbook wb;
    static Sheet sh;

    public ExcelUtilities(String execelPath,String sheetName) {
        try {
            FileInputStream fis = new FileInputStream("./src/test/resources/RestExe.xlsx");
            wb = WorkbookFactory.create(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getRowCount() {
        sh = wb.getSheet("Sheet1");
        int rowCount = sh.getLastRowNum();
        System.out.println(rowCount);
    }

    public void getCellData() {
        DataFormatter dataFormat = new DataFormatter();
        Object value = dataFormat.formatCellValue(sh.getRow(3).getCell(1));
        System.out.println(value);
    }

}

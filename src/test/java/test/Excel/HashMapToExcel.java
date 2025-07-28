package test.Excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HashMapToExcel {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./RestAssuredForBeginner/src/test/resources/RestExe.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.createSheet("HashMap");

        Map<String, String> hs1 = new HashMap<String, String>();
        hs1.put("101", "Capgeminy");
        hs1.put("102", "Infosys");
        hs1.put("103", "TCS");
        hs1.put("104", "HSBC");

        int rowCount = 0;
        for (Map.Entry entry : hs1.entrySet()) {
            Row r = sh.createRow(rowCount++);
            r.createCell(0).setCellValue((String) entry.getKey());
            r.createCell(1).setCellValue((String) entry.getValue());
        }

        FileOutputStream fos = new FileOutputStream("./RestAssuredForBeginner/src/test/resources/RestExe.xlsx");
        wb.write(fos);
        wb.close();
        fos.close();
    }
}

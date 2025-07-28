package test.Excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelToHashMap {
    public static void main(String[] args) throws IOException {

        String txt = "Capgeminy";
        String id = "101";

        FileInputStream fis = new FileInputStream("./RestAssuredForBeginner/src/test/resources/RestExe.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet("HashMap");

        //Read the data from excel
        int rows = sh.getLastRowNum();
        Map<String,String> hs1 = new HashMap<>();
        for (int r=0;r<=rows;r++){
            String key = sh.getRow(r).getCell(0).getStringCellValue();
            String value = sh.getRow(r).getCell(1).getStringCellValue();
            hs1.put(key,value);
        }

        //Extract data from hashmap
        for (Map.Entry entry : hs1.entrySet()){
            System.out.println(entry.getKey() + " - "+ entry.getValue());
            if(id.equals(entry.getKey())) {
                Assert.assertEquals(id, entry.getKey(), "asserts are Not equal");
                Assert.assertEquals(txt, entry.getValue(), "asserts are not eulas");
                System.out.println("Asserts are Done");
            }
        }
    }
}

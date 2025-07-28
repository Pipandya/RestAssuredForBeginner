package test.Excel;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

public class ExcelDataReading {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("./RestAssuredForBeginner/src/test/resources/RestExe.xlsx");
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sh = wb.getSheet("Data");

            int rows = sh.getLastRowNum();
            int cols = sh.getRow(1).getLastCellNum();

            for (int r=0;r<=rows;r++){
               // Row r = sh.getRow(r);
                for (int c=0;c<cols;c++){
                   // Cell c = r.getCell(c);
                    DataFormatter dataFormat = new DataFormatter();
                    Object value = dataFormat.formatCellValue(sh.getRow(r).getCell(c));
                    System.out.print(value + " | ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

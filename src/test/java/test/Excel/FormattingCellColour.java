package test.Excel;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FormattingCellColour {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("./RestAssuredForBeginner/src/test/resources/RestExe.xlsx");
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sh = wb.createSheet("CellFormatting");
            Row rw = sh.createRow(1);

            //Setting BGColor of Cell
            CellStyle cs = wb.createCellStyle();
            cs.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
            cs.setFillPattern(FillPatternType.BIG_SPOTS);

            Cell cl = rw.createCell(1);
            cl.setCellValue("Welcome");
            cl.setCellStyle(cs);

            //Setting Forground Clour
            cs = wb.createCellStyle();
            cs.setFillForegroundColor(IndexedColors.RED.getIndex());
            cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            cl = rw.createCell(2);
            cl.setCellValue("Automation");
            cl.setCellStyle(cs);

            FileOutputStream fos = new FileOutputStream("./RestAssuredForBeginner/src/test/resources/RestExe.xlsx");
            wb.write(fos);
            wb.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

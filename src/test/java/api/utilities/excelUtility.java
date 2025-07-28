package api.utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class excelUtility {
    public FileInputStream fis;
    public FileOutputStream fos;
    public Workbook wb;
    public Sheet sh;
    public Row rows;
    public Cell cell;
    public CellStyle style;
    String path;

    public excelUtility(String path) {
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        fis = new FileInputStream(path);
        wb = WorkbookFactory.create(fis);
        sh = wb.getSheet(sheetName);
        int rowCount = sh.getPhysicalNumberOfRows()-1;
        wb.close();
        fis.close();
        return rowCount;
    }

    public int getCellCount(String sheetName, int rowNum) throws IOException {
        fis = new FileInputStream(path);
        wb = WorkbookFactory.create(fis);
        sh = wb.getSheet(sheetName);
        rows = sh.getRow(rowNum);
        int cellCount = rows.getLastCellNum();
        wb.close();
        fis.close();
        return cellCount;
    }

    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        fis = new FileInputStream(path);
        wb = WorkbookFactory.create(fis);
        sh = wb.getSheet(sheetName);
        rows = sh.getRow(rowNum);
        cell = rows.getCell(colNum);

        DataFormatter formatter = new DataFormatter();
        String data;
        try {
            data = formatter.formatCellValue(cell);
            System.out.println(data);
        } catch (Exception e) {
            data = "";
        }
        wb.close();
        fis.close();
        return data;
    }

    public void setCellData(String sheetName,int rowNum,int colNum,String data) throws IOException{
        File xlFile = new File(path);
        if (!xlFile.exists()){

        }
        fis = new FileInputStream(path);
        wb = WorkbookFactory.create(fis);

    }
}

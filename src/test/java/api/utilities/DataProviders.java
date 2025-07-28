package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "Data")
    public String[][] getAllData() throws IOException {
        String path = "./src/test/resources/RestExe.xlsx";
        excelUtility ex = new excelUtility(path);
        int rowNum = ex.getRowCount("UserInfo");
        int colNum = ex.getCellCount("UserInfo", 1);

        System.out.println(rowNum);
        String apiData[][] = new String[rowNum][colNum];
            for (int i = 1; i <=3; i++) {
                for (int j = 0; j < colNum; j++) {
                    apiData[i - 1][j] = ex.getCellData("UserInfo", i, j);
            }
        }
        return apiData;
    }

    @DataProvider(name = "UserNames")
    public String[] getUserNames() throws IOException {
        String path = "./src/test/resources/RestExe.xlsx";
        excelUtility ex = new excelUtility(path);
        int rowNum = ex.getRowCount("UserInfo");
        System.out.println(rowNum);
        String apiData[] = new String[rowNum];
        for (int i = 1; i <= 3; i++) {
            apiData[i - 1] = ex.getCellData("UserInfo", i, 1);
        }
        return apiData;
    }
}

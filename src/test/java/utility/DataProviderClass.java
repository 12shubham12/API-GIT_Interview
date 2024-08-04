package utility;

import org.testng.annotations.DataProvider;

import static utility.BaseClass.config;

public class DataProviderClass {

    @DataProvider(name="excelData")
    public Object[][] excelDataProvider() {
        String filePath = config.read_ExcelDataPath();
        String sheetName = "addObject";

        // Assuming you have rows of data to test; adjust row count as needed
        return new Object[][]{

                {ExcelDataProvider.getRowData(filePath, sheetName, 2)}
        };
    }
}

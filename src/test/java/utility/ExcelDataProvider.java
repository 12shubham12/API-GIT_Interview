package utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelDataProvider {

    XSSFWorkbook wb;
    public ExcelDataProvider(){
        File src = new File("./TestData/TestData.xlsx");
        try{
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        }
        catch(Exception e){
            System.out.println("File not found "+e.getMessage());
        }
    }

    public String getStringdata(String sheetName, int row, int col){
        return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
    }
    public int getNumericdata(String sheetName, int row, int col){
        return (int)wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
    }
}

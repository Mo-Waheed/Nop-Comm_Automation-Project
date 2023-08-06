package Data.Reg;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class RegData {
    public Object[][] MData() throws IOException, InvalidFormatException {
        File Myfile = new File("C:\\Users\\Waheed\\IdeaProjects\\FinalDemoProject\\src\\test\\java\\Data\\Reg\\RegData.xlsx");
        XSSFWorkbook XSL = new XSSFWorkbook(Myfile);
        XSSFSheet MySheet = XSL.getSheet("ValidMale");
        int RowCount = MySheet.getPhysicalNumberOfRows();
        int ColumnCount = MySheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] RegArray=new Object[RowCount-1][ColumnCount];
        for (int i = 1; i <RowCount ; i++) {
            for (int j = 0; j < ColumnCount; j++)
            {
                RegArray[i-1][j]=MySheet.getRow(i).getCell(j).getStringCellValue();
            }

        }
        return RegArray;
    }
    public Object[][] FData() throws IOException, InvalidFormatException {
        File Myfile = new File("C:\\Users\\Waheed\\IdeaProjects\\FinalDemoProject\\src\\test\\java\\Data\\Reg\\RegData.xlsx");
        XSSFWorkbook XSL = new XSSFWorkbook(Myfile);
        XSSFSheet MySheet = XSL.getSheet("ValidFemale");
        int RowCount = MySheet.getPhysicalNumberOfRows();
        int ColumnCount = MySheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] RegArray=new Object[RowCount-1][ColumnCount];
        for (int i = 1; i <RowCount ; i++) {
            for (int j = 0; j < ColumnCount; j++)
            {
                RegArray[i-1][j]=MySheet.getRow(i).getCell(j).getStringCellValue();
            }

        }
        return RegArray;
    }
    public Object[][] Data() throws IOException, InvalidFormatException {
        File Myfile = new File("C:\\Users\\Waheed\\IdeaProjects\\FinalDemoProject\\src\\test\\java\\Data\\Reg\\RegData.xlsx");
        XSSFWorkbook XSL = new XSSFWorkbook(Myfile);
        XSSFSheet MySheet = XSL.getSheet("ValidOp");
        int RowCount = MySheet.getPhysicalNumberOfRows();
        int ColumnCount = MySheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] RegArray=new Object[RowCount-1][ColumnCount];
        for (int i = 1; i <RowCount ; i++) {
            for (int j = 0; j < ColumnCount; j++)
            {
                RegArray[i-1][j]=MySheet.getRow(i).getCell(j).getStringCellValue();
            }

        }
        return RegArray;
    }
    public Object[][] InValidData() throws IOException, InvalidFormatException {
        File Myfile = new File("C:\\Users\\Waheed\\IdeaProjects\\FinalDemoProject\\src\\test\\java\\Data\\Reg\\RegData.xlsx");
        XSSFWorkbook XSL = new XSSFWorkbook(Myfile);
        XSSFSheet MySheet = XSL.getSheet("InValid");
        int RowCount = MySheet.getPhysicalNumberOfRows();
        int ColumnCount = MySheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] RegArray=new Object[RowCount-1][ColumnCount];
        for (int i = 1; i <RowCount ; i++) {
            for (int j = 0; j < ColumnCount; j++)
            {
                RegArray[i-1][j]=MySheet.getRow(i).getCell(j).getStringCellValue();
            }

        }
        return RegArray;
    }

}

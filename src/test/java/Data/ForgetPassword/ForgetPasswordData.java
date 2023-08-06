package Data.ForgetPassword;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ForgetPasswordData {
    public Object[][] ValidData() throws IOException, InvalidFormatException {
        File MyFile = new File("C:\\Users\\Waheed\\IdeaProjects\\FinalDemoProject\\src\\test\\java\\Data\\ForgetPassword\\ForgetPasswordData.xlsx");
        XSSFWorkbook XSL = new XSSFWorkbook(MyFile);
        XSSFSheet MySheet = XSL.getSheet("Valid");
        int RowCount = MySheet.getPhysicalNumberOfRows();
        int ColumnCount = MySheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] LoginArray = new Object[RowCount - 1][ColumnCount];
        for (int i = 1; i < RowCount; i++) {
            for (int j = 0; j < ColumnCount; j++) {
                LoginArray[i - 1][j] = MySheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return LoginArray;
    }

    public Object[][] InValidData1() throws IOException, InvalidFormatException {
        File MyFile = new File("C:\\Users\\Waheed\\IdeaProjects\\FinalDemoProject\\src\\test\\java\\Data\\ForgetPassword\\ForgetPasswordData.xlsx");
        XSSFWorkbook XSL = new XSSFWorkbook(MyFile);
        XSSFSheet MySheet = XSL.getSheet("InValid1");
        int RowCount = MySheet.getPhysicalNumberOfRows();
        int ColumnCount = MySheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] LoginArray = new Object[RowCount - 1][ColumnCount];
        for (int i = 1; i < RowCount; i++) {
            for (int j = 0; j < ColumnCount; j++) {
                LoginArray[i - 1][j] = MySheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return LoginArray;
    }
    public Object[][] InValidData2() throws IOException, InvalidFormatException {
        File MyFile = new File("C:\\Users\\Waheed\\IdeaProjects\\FinalDemoProject\\src\\test\\java\\Data\\ForgetPassword\\ForgetPasswordData.xlsx");
        XSSFWorkbook XSL = new XSSFWorkbook(MyFile);
        XSSFSheet MySheet = XSL.getSheet("InValid2");
        int RowCount = MySheet.getPhysicalNumberOfRows();
        int ColumnCount = MySheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] LoginArray = new Object[RowCount - 1][ColumnCount];
        for (int i = 1; i < RowCount; i++) {
            for (int j = 0; j < ColumnCount; j++) {
                LoginArray[i - 1][j] = MySheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return LoginArray;
    }
}

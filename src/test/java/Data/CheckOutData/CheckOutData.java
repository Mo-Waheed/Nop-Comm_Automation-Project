package Data.CheckOutData;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class CheckOutData {

    public Object[][] SendValidData1() throws IOException, InvalidFormatException {
        File Myfile = new File("C:\\Users\\Waheed\\IdeaProjects\\FinalDemoProject\\src\\test\\java\\Data\\CheckOutData\\CheckOutData.xlsx");
        XSSFWorkbook xml = new XSSFWorkbook(Myfile);
        XSSFSheet Mysheet = xml.getSheet("Valid1");
        int numberofRow=Mysheet.getPhysicalNumberOfRows();
        int NumberOfColumn = Mysheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] MyArray = new Object[numberofRow-1][NumberOfColumn];
        for(int i = 1 ;i<numberofRow;i++)
        {
            for (int j =0; j <NumberOfColumn;j++)
            {
                MyArray[i-1][j]=Mysheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return MyArray;
    }
    public Object[][] SendInValidData() throws IOException, InvalidFormatException {
        File Myfile = new File("C:\\Users\\Waheed\\IdeaProjects\\FinalDemoProject\\src\\test\\java\\Data\\CheckOutData\\CheckOutData.xlsx");
        XSSFWorkbook xml = new XSSFWorkbook(Myfile);
        XSSFSheet Mysheet = xml.getSheet("Invalid");
        int numberofRow=Mysheet.getPhysicalNumberOfRows();
        int NumberOfColumn = Mysheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] MyArray = new Object[numberofRow-1][NumberOfColumn];
        for(int i = 1 ;i<numberofRow;i++)
        {
            for (int j =0; j <NumberOfColumn;j++)
            {
                MyArray[i-1][j]=Mysheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return MyArray;
    }

}

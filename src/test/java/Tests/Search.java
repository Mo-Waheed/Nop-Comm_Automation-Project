package Tests;


import Data.Search.SearchData;
import Pages.HomePage;
import Pages.SearchPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class Search extends Test_Base{
    String Actual;
    String Expected;
    SoftAssert Soft = new SoftAssert();

    //Check The Invalid Cases (Empty,Blank,less then 3 Letters)
    @Test(priority = 1,dataProvider = "InValidData")
    public void InvalidSearchforItem(String Item)
    {
        HomePage Search = new HomePage(driver);
        SearchPage Elements=new SearchPage(driver);
     //Entering Item And Search
        Search.GetSearchBoxElement().sendKeys(Item);
        Search.GetSearchButtonElement().click();
     //Check if the Valid Empty Or Not
        if(Item.equals(""))
        {
            //Pop Up Alert Message
             Expected = "Please enter some search keyword";
             Actual = driver.switchTo().alert().getText();
             driver.switchTo().alert().accept();
             Soft.assertTrue(Actual.contains(Expected));


        }
        else
        {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            Expected = "Search term minimum length is 3 characters";
            Actual = Elements.GetWarningMessage().getText();
            Soft.assertTrue(Actual.contains(Expected));
        }


    }
    @DataProvider
    public Object[][] InValidData() throws IOException, InvalidFormatException {
        SearchData InValid=new SearchData();
        return InValid.InValidData();
    }
    //Check Valid Data
    @Test(priority = 2,dataProvider = "ValidData")
    public void validSearchforItem(String Item)
    {
        HomePage Search = new HomePage(driver);
        SearchPage Elements=new SearchPage(driver);

        Search.GetSearchBoxElement().sendKeys(Item);
        Search.GetSearchButtonElement().click();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            Expected = "Apple MacBook Pro 13-inch";
            Actual = Elements.GetSearchItem().getText();
            Soft.assertTrue(Actual.contains(Expected));
            Soft.assertAll();

    }
    @DataProvider
    public Object[][] ValidData() throws IOException, InvalidFormatException {
        SearchData Valid=new SearchData();
        return Valid.ValidData();
    }


}

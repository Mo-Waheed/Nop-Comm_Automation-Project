package Tests;

import Data.Reg.RegData;
import Pages.HomePage;
import Pages.RegPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class Registration extends Test_Base{

    SoftAssert Soft = new SoftAssert();
    String Expected;
    String Actual;

    @Test(priority = 1)
    public void NavigateToReGPage() {
        HomePage Reg = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Reg.GetRegElement().click();
    }

    //Checking (Valid Data) 1-GenderMale 2-FirstName,LastName One Or Two Characters
    // 3-Valid Email Form 4-Using Same Password
    //Lowest BirthDate
    @Test(priority = 2,dependsOnMethods = "NavigateToReGPage",dataProvider = "RegValidDataM")
    public void EnterValidData1
    (String Firstname,String Lastname,String Email,String Company,String Password,String ConPassword) {

        //Sending Locators From RegPage Class
        //Sending Data From Excel Sheet
        RegPage Elements = new RegPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Elements.GetMaleGenderElement().click();
        Elements.GetFirstnameElement().sendKeys(Firstname);
        Elements.GetLastnameElement().sendKeys(Lastname);

        //Choose Day Month Year From DropDown List
        Select Day=new Select(Elements.GetDayDropDownElement());
        Day.selectByValue("1");
        Select Month=new Select(Elements.GetMonthDropDownElement());
        Month.selectByValue("1");
        Select Year=new Select(Elements.GetYearDropDownElement());
        Year.selectByValue("1913");

        //Sending Email Company and Password
        Elements.GetEmailElement().sendKeys(Email);
        Elements.GetCompanyElement().sendKeys(Company);
        Elements.GetPasswordElement().sendKeys(Password);
        Elements.GetConfirmPasswordElement().sendKeys(ConPassword);

        //Clicking On Reg Bottom
        Elements.GetRegBottomElement().click();

        //Checking That User Successfully Registered
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected ="Your registration completed";
        Actual =Elements.GetSuccMessageElement().getText();
        Soft.assertTrue(Actual.contains(Expected));

        //Click on Continue Bottom
        Elements.GetContinueBottomElement().click();

        //Navigate To Reg Page To Try More Data
        NavigateToReGPage();

        //To Avoid Crush if Any Exception Found
        Soft.assertAll();
    }


    @DataProvider
    //Get THe Data From Data Class
    public Object[][] RegValidDataM() throws IOException, InvalidFormatException {
        RegData Vaild = new RegData();
        return Vaild.MData();
    }
    //Checking (Valid Data) 1-Gender Female 2-FirstName,LastName
    // 3-Valid Email Form 4-Using Same Password
    //Highest BirthDate
    @Test(priority = 2,dependsOnMethods = "NavigateToReGPage",dataProvider = "RegValidDataF")
    public void EnterValidData2
            (String Firstname,String Lastname,String Email,String Company,String Password,String ConPassword) {

        //Sending Locators From RegPage Class
        //Sending Data From Excel Sheet
        RegPage Elements = new RegPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Elements.GetFemaleGenderElement().click();
        Elements.GetFirstnameElement().sendKeys(Firstname);
        Elements.GetLastnameElement().sendKeys(Lastname);

        //Choose Day Month Year From DropDown List
        Select Day=new Select(Elements.GetDayDropDownElement());
        Day.selectByValue("31");
        Select Month=new Select(Elements.GetMonthDropDownElement());
        Month.selectByValue("12");
        Select Year=new Select(Elements.GetYearDropDownElement());
        Year.selectByValue("2023");

        //Sending Email Company and Password
        Elements.GetEmailElement().sendKeys(Email);
        Elements.GetCompanyElement().sendKeys(Company);
        Elements.GetPasswordElement().sendKeys(Password);
        Elements.GetConfirmPasswordElement().sendKeys(ConPassword);

        //Clicking On Reg Bottom
        Elements.GetRegBottomElement().click();


        //Checking That User Successfully Registered
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected ="Your registration completed";
        Actual =Elements.GetSuccMessageElement().getText();
        Soft.assertTrue(Actual.contains(Expected));

        //Click on Continue Bottom
        Elements.GetContinueBottomElement().click();

        //Navigate To Reg Page To Try More Data
        NavigateToReGPage();

        //To Avoid Crush if Any Exception Found
        Soft.assertAll();
    }
    @DataProvider
    //Get THe Data From Data Class
    public Object[][] RegValidDataF() throws IOException, InvalidFormatException {
        RegData Vaild = new RegData();
        return Vaild.FData();
    }
    //Checking (Valid Data) 1-Gender Female 2-FirstName,LastName
    // 3-Valid Email Form 4-Using Same Password
    //Without BirthDate and Company or Gender
    @Test(priority = 2,dependsOnMethods = "NavigateToReGPage",dataProvider = "RegValidData")
    public void EnterValidData3
    (String Firstname,String Lastname,String Email,String Password,String ConPassword) {

        //Sending Locators From RegPage Class
        //Sending Data From Excel Sheet
        RegPage Elements = new RegPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        Elements.GetFirstnameElement().sendKeys(Firstname);
        Elements.GetLastnameElement().sendKeys(Lastname);

        //Click on Send new News Bottom
        Elements.GetNewsBottomElement().click();


        //Sending Email Company and Password
        Elements.GetEmailElement().sendKeys(Email);
        Elements.GetPasswordElement().sendKeys(Password);
        Elements.GetConfirmPasswordElement().sendKeys(ConPassword);

        //Clicking On Reg Bottom
        Elements.GetRegBottomElement().click();


        //Checking That User Successfully Registered
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected ="Your registration completed";
        Actual =Elements.GetSuccMessageElement().getText();
        Soft.assertTrue(Actual.contains(Expected));

        //Click on Continue Bottom
        Elements.GetContinueBottomElement().click();

        //Navigate To Reg Page To Try More Data
        NavigateToReGPage();

        //To Avoid Crush if Any Exception Found
        Soft.assertAll();
    }
    @DataProvider
    //Get THe Data From Data Class
    public Object[][] RegValidData() throws IOException, InvalidFormatException {
        RegData Vaild = new RegData();
        return Vaild.Data();
    }
    @Test(priority = 3,dependsOnMethods = "NavigateToReGPage",dataProvider = "RegInValidData")
    public void EnterInValidData
            (String Firstname,String Lastname,String Email,String Company,String Password,String ConPassword) {

        //Sending Locators From RegPage Class
        //Sending Data From Excel Sheet
        RegPage Elements = new RegPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Elements.GetMaleGenderElement().click();
        Elements.GetFirstnameElement().sendKeys(Firstname);
        Elements.GetLastnameElement().sendKeys(Lastname);

        //Choose Day Month Year From DropDown List
        Select Day=new Select(Elements.GetDayDropDownElement());
        Day.selectByValue("1");
        Select Month=new Select(Elements.GetMonthDropDownElement());
        Month.selectByValue("1");
        Select Year=new Select(Elements.GetYearDropDownElement());
        Year.selectByValue("1913");

        //Sending Email Company and Password
        Elements.GetEmailElement().sendKeys(Email);
        Elements.GetCompanyElement().sendKeys(Company);
        Elements.GetPasswordElement().sendKeys(Password);
        Elements.GetConfirmPasswordElement().sendKeys(ConPassword);

        //Clicking On Reg Bottom
        Elements.GetRegBottomElement().click();

        //Checking That User Successfully Registered
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected ="https://demo.nopcommerce.com/register?return";
        Actual =driver.getCurrentUrl();
        Soft.assertTrue(Actual.contains(Expected));


        //Navigate To Reg Page To Reset and Try More Data
        NavigateToReGPage();

        //To Avoid Crush if Any Exception Found
        Soft.assertAll();
    }


    @DataProvider
    //Get THe Data From Data Class
    public Object[][] RegInValidData() throws IOException, InvalidFormatException {
        RegData InValid = new RegData();
        return InValid.InValidData();
    }


}

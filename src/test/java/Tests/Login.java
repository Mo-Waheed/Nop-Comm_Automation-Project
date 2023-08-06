package Tests;

import Data.Login.LoginData;
import Pages.HomePage;
import Pages.LoginPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class Login extends Test_Base{

    String Expected;
    String Actual ;
    SoftAssert Soft = new SoftAssert();
    @Test(priority = 1)
    public void NavigateToLoginPage()
    {
        HomePage Login = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Login.GetLoginElement().click();
    }
    //Verifying Valid Login Data 1-English Already Registered Data 2-ArabicEnglish Already Registered
    @Test(priority = 3,dependsOnMethods = "NavigateToLoginPage",dataProvider = "ValidData")

    public void EnterVaildData(String Username , String Password) {
        LoginPage Elements = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Enter The Data
        Elements.GetEmailElement().clear();
        Elements.GetEmailElement().sendKeys(Username);
        Elements.GetPasswordElement().clear();
        Elements.GetPasswordElement().sendKeys(Password);
        Elements.GetRemeberMeElement().click();
        Elements.GetLoginButtonElement().click();

        //Check That The Login is Success And Re-direct to Home Page

        Expected ="https://demo.nopcommerce.com/";
        Actual=driver.getCurrentUrl();
        Soft.assertEquals(Actual, Expected);
        Soft.assertAll();
    }
    //Get The Valid Data From Xsl File
    @DataProvider
    public Object[][] ValidData() throws IOException, InvalidFormatException {
        LoginData Valid=new LoginData();
        return Valid.ValidData();
    }
    //Verifying InValid Login Data 1-UnRegisted Email 2-Empty Email Field 3-Empty Password Field
    @Test(priority = 2,dependsOnMethods = "NavigateToLoginPage",dataProvider = "InValidData")
    public void EnterInVaildData(String Username , String Password)
    {
        LoginPage Elements = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Clear Previous Data And Enter New One

        Elements.GetEmailElement().clear();
        Elements.GetEmailElement().sendKeys(Username);
        Elements.GetPasswordElement().clear();
        Elements.GetPasswordElement().sendKeys(Password);
        Elements.GetRemeberMeElement().click();
        Elements.GetLoginButtonElement().click();

        //Check Failed of Login And Error Message

        Expected ="Login was unsuccessful. Please correct the errors and try again";
        Actual=Elements.GetFailedMessageElement().getText();
        Soft.assertTrue(Actual.contains(Expected));
        Soft.assertAll();

    }
    //Get The InValid Data From Xsl File
    @DataProvider
    public Object[][] InValidData() throws IOException, InvalidFormatException
    {
        LoginData InValid=new LoginData();
        return InValid.InValidData();
    }

    //LogOut Method
    public void LogoutMethod()
    {
        HomePage Logout = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Logout.GetLogoutElement().click();
    }
}

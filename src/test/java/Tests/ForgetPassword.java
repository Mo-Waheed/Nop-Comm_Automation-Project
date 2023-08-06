package Tests;

import Data.ForgetPassword.ForgetPasswordData;
import Pages.ForgetPasswordPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class ForgetPassword extends Test_Base{
    SoftAssert Soft =new SoftAssert();
    String Expected ;
    String Actual ;

    //Navigate To ForgetPassword Page
    @Test(priority = 1)
    public void NavigateToForgetPasswordPage()
    {
        //Navigate to Login Page
        HomePage Login = new HomePage(driver);
        Login.GetLoginElement().click();
        //Navigate to Forget Password Page
        LoginPage ForgetElement = new LoginPage(driver);
        ForgetElement.GetForgetPasswordElement().click();

        //Check We Navigated Success
        ForgetPasswordPage Elements =new ForgetPasswordPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected="Please enter your email address below. You will receive a link to reset your";
        Actual=Elements.GetTextCheckElement().getText();
        Soft.assertTrue(Actual.contains(Expected));

    }
    //Verify Using Valid Data
    @Test(priority = 2,dataProvider = "ValidData")
    public void GetThePasswordSucc(String Email)
    {
        ForgetPasswordPage Elements =new ForgetPasswordPage(driver);

        //Send Valid Email
        Elements.GetEmailElement().clear();
        Elements.GetEmailElement().sendKeys(Email);
        Elements.GetRecoverButtonElement().click();

        //Check That The Password Sent Successfully
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected="Email with instructions has been sent to you.";
        Actual=Elements.GetHoverMessageElement().getText();
        Soft.assertTrue(Actual.contains(Expected));

        Soft.assertAll();
    }
    @DataProvider
    public Object[][] ValidData() throws IOException, InvalidFormatException {
        ForgetPasswordData Valid=new ForgetPasswordData();
        return Valid.ValidData();
    }
    //Verify Using InValid Data(Wrong Email Format , Empty Email Field)
    @Test(priority = 3,dataProvider = "InValidData1")
    public void GetThePasswordFailed1(String Email) throws InterruptedException {
        ForgetPasswordPage Elements =new ForgetPasswordPage(driver);

        //Send Invalid Email
        Elements.GetEmailElement().clear();
        Elements.GetEmailElement().sendKeys(Email);
        Elements.GetRecoverButtonElement().click();

        Thread.sleep(2000);

        //Check That The Password Sent Successfully
        Expected="email";
        Actual=Elements.GetFailedMessageElement().getText();
        Soft.assertTrue(Actual.contains(Expected));

        Soft.assertAll();
    }
    @DataProvider
    public Object[][] InValidData1() throws IOException, InvalidFormatException {
        ForgetPasswordData InValid=new ForgetPasswordData();
        return InValid.InValidData1();
    }

    //Verify Using InValid Data(UnRegister Email)
    @Test(priority = 4,dataProvider = "InValidData2")
    public void GetThePasswordFailed2(String Email) throws InterruptedException {
        ForgetPasswordPage Elements =new ForgetPasswordPage(driver);

        //Send invalid Email
        Elements.GetEmailElement().clear();
        Elements.GetEmailElement().sendKeys(Email);
        Elements.GetRecoverButtonElement().click();

        Thread.sleep(2000);


        //Check That The Password Sent Successfully
        Expected="Email not found.";
        Actual=Elements.GetHoverMessageElement().getText();
        Soft.assertTrue(Actual.contains(Expected));

        Soft.assertAll();
    }
    @DataProvider
    public Object[][] InValidData2() throws IOException, InvalidFormatException {
        ForgetPasswordData InValid=new ForgetPasswordData();
        return InValid.InValidData2();
    }
}

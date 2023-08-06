package Tests;

import Data.Login.LoginData;
import Data.Search.SearchData;
import Data.SendToFrineds.ShareData;
import Pages.ItemPage;
import Pages.SendToFriendPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class SendToFriend extends Test_Base{
    String Expected ;
    String Actual ;
    SoftAssert Soft = new SoftAssert();

    //Login With Valid Data
    @Test(priority = 1,dataProvider = "ValidLoginData")
    public void ValidLogin(String Username , String Password)
    {
        Login login =new Login();
        login.NavigateToLoginPage();
        login.EnterVaildData(Username,Password);
    }
    @DataProvider
    public Object[][] ValidLoginData() throws IOException, InvalidFormatException {
        LoginData Valid=new LoginData();
        return Valid.ValidData();
    }
    //Search For The Item
    @Test(priority = 2,dataProvider = "SearchValidData")
    public void ValidSearch(String Item)
    {
        Search search = new Search();
        search.validSearchforItem(Item);
    }
    @DataProvider
    public Object[][] SearchValidData() throws IOException, InvalidFormatException {
        SearchData Valid=new SearchData();
        return Valid.ValidData();
    }
    //Add The Item To Cart
    @Test(priority = 3)
    public void ValidAddtoCart() throws InterruptedException {
        AddToCart addtocart = new AddToCart();
        addtocart.NavigatetItemPage();
    }
    //Send The Item To A Friend
    @Test(priority = 4,dataProvider = "SendValidData")
    public void VaildSendtoFriend(String FriendEmail , String MyEmail , String Personal) {

        //Open Email Friend Page
        ItemPage Navigate =new ItemPage(driver);
        Navigate.GetEmailFriendElement().click();

        //Check you navigated Successfully
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected="https://demo.nopcommerce.com/productemailafriend";
        Actual=driver.getCurrentUrl();
        Soft.assertTrue(Actual.contains(Expected));

        //Send Data From Excel file
        SendToFriendPage Elements = new SendToFriendPage(driver);
        Elements.GetFriendEmailElement().sendKeys(FriendEmail);
        Elements.GetYourEmailElement().clear();
        Elements.GetYourEmailElement().sendKeys(MyEmail);
        Elements.GetPersonalInfoElement().sendKeys(Personal);
        Elements.GetSendButtonElement().click();

        //Check you navigated Successfully
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected="Your message has been sent";
        Actual=Elements.GetSuccessMessageElement().getText();
        Soft.assertTrue(Actual.contains(Expected));

        //Logout TO try Invalid Data
        Login login = new Login();
        login.LogoutMethod();

        Soft.assertAll();

    }
    //Valid Data to Email a friend
    @DataProvider
    public Object[][] SendValidData() throws IOException, InvalidFormatException {
        ShareData Valid=new ShareData();
        return Valid.ValidData();
    }
    @Test(priority = 5,dataProvider = "SendInValidData")
    public void InvalidSendtoFriend(String FriendEmail , String MyEmail , String Personal) throws InterruptedException {
        //Call Search
        ValidSearch("Mac");
        //Call Add to Cart
        ValidAddtoCart();
        //Open Email Friend Page
        ItemPage Navigate =new ItemPage(driver);
        Navigate.GetEmailFriendElement().click();

        //Check you navigated Successfully
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected="https://demo.nopcommerce.com/productemailafriend";
        Actual=driver.getCurrentUrl();
        Soft.assertTrue(Actual.contains(Expected));

        //Send Data From Excel file and clear it
        SendToFriendPage Elements = new SendToFriendPage(driver);
        Elements.GetFriendEmailElement().clear();
        Elements.GetFriendEmailElement().sendKeys(FriendEmail);
        Elements.GetYourEmailElement().clear();
        Elements.GetYourEmailElement().sendKeys(MyEmail);
        Elements.GetPersonalInfoElement().clear();
        Elements.GetPersonalInfoElement().sendKeys(Personal);
        Elements.GetSendButtonElement().click();

        //Check That the Page Didn't Change (Email Failed)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected="https://demo.nopcommerce.com/productemailafriend/4";
        Actual= driver.getCurrentUrl();
        Soft.assertEquals(Expected,Actual);
        Soft.assertAll();
    }
    //Send Invalid Data
    @DataProvider
    public Object[][] SendInValidData() throws IOException, InvalidFormatException {
        ShareData InValid=new ShareData();
        return InValid.InValidData();
    }

}

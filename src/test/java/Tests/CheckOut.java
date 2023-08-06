package Tests;

import Data.CheckOutData.CheckOutData;
import Data.Login.LoginData;
import Data.Search.SearchData;
import Pages.CheckOutPage;
import Pages.ItemPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class CheckOut extends Test_Base{
    SoftAssert Soft= new SoftAssert();

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
    @Test(priority = 4)
    public void NavigateToCheckOut()
    {
        //Get ShoppingCart From ItemPage and Navigate TO Checkout
        ItemPage items = new ItemPage(driver);
        items.GetCartLinkElement().click();

        //Check Navigated Successfully
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String Expected1 = "https://demo.nopcommerce.com/cart";
        String Actual1=driver.getCurrentUrl();
        Soft.assertTrue(Actual1.contains(Expected1));

        //Get Elements From CheckoutPage
        CheckOutPage Elements = new CheckOutPage(driver);
        Elements.GetCheckBoxElement().click();
        Elements.GetGoToCheckOutElement().click();

        //Check Navigated Successfully
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String Expected2 = "Checkout";
        String Actual2=Elements.CheckOutTagElement().getText();
        Soft.assertTrue(Actual2.contains(Expected2));


    }
    //Valid Full Data + Optional Data
    //FirstName - LastName - Email - Company - Counter - Stat - city - Address1 - Address2 - ZIP -
    // Phonenumber - Fax - With Ground Shipping - With Cash Payment
    @Test(priority = 5,dataProvider = "ValidData")
    public void EnterValidData1(String Company,String City,String Address1 ,String Address2,String Zip,String PhoneNumber,String Fax) throws InterruptedException {
        //Get Elements From CheckoutPage
        CheckOutPage Elements = new CheckOutPage(driver);

        //Send Data To Fields
        Elements.GetCompanyElement().clear();
        Elements.GetCompanyElement().sendKeys(Company);
        Select select = new Select(Elements.GetCountryDropListElement());
        select.selectByValue("123");
        Elements.GetCityElement().clear();
        Elements.GetCityElement().sendKeys(City);
        Elements.GetAddress1Element().clear();
        Elements.GetAddress1Element().sendKeys(Address1);
        Elements.GetAddress2Element().sendKeys(Address2);
        Elements.GetPostalCodeyElement().sendKeys(Zip);
        Elements.GetPhoneNumberElement().sendKeys(PhoneNumber);
        Elements.GetFaxNumberElement().sendKeys(Fax);
        Elements.GetContinueElement().click();

        //Check Of Navigation
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String Expected3 = "https://demo.nopcommerce.com/onepagecheckout#opc-shipping_method";
        String Actual3=driver.getCurrentUrl();
        Soft.assertEquals(Expected3,Actual3);

        //Choose The Way For Shipping
        Elements.GetGroundElement().click();
        Elements.GetContinue2Element().click();
        //Check Of Navigation
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String Expected4="https://demo.nopcommerce.com/onepagecheckout#opc-payment_method";
        String Actual4=driver.getCurrentUrl();
        Soft.assertEquals(Expected4,Actual4);

        //Choose The Way For Payment
        Elements.GetPay1Element();
        Elements.GetContinue3Element().click();


        //Check Of Navigation
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String Expected5="https://demo.nopcommerce.com/onepagecheckout#opc-payment_info";
        String Actual5=driver.getCurrentUrl();
        Soft.assertEquals(Expected5,Actual5);

        Elements.GetContinue4Element().click();
        Elements.GetConfirmElement().click();


        //Check Success Message
        String Expected6 = "Thank you";
        String Actual6=Elements.GetSuccessMessageElement().getText();
        Soft.assertEquals(Expected6,Actual6);

        Thread.sleep(5000);

        Elements.GetFinalConfirmElement().click();

    }

    @DataProvider(name = "ValidData")
    public Object[][] ValidData() throws IOException, InvalidFormatException {
        CheckOutData ValidDataa1 = new CheckOutData();
        return ValidDataa1.SendValidData1();
    }
    //Valid Full Data Without Optional Data
    //FirstName - LastName - Email - Counter - Stat - city - Address1 - ZIP -
    // Phonenumber - With Air Shipping - With Cash Payment
    @Test(priority = 6,dataProvider = "SearchValidData")
    public void EnterValidData2(String Item) throws InterruptedException {

    //Wait 20 Sec Before Buying a new Item
        Thread.sleep(20000);
    //Call Search and add to Cart Methods
        ValidSearch(Item);
        ValidAddtoCart();
        NavigateToCheckOut();
    //Creating Elements from Checkout Page
        CheckOutPage Elements = new CheckOutPage(driver);
    //Edit Personal Information
        Elements.GetEditButtonElement().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Elements.GetCompanyElement().clear();
        Elements.GetAddress2Element().clear();
        Elements.GetFaxNumberElement().clear();
    //Save The New Info
        Elements.GetSaveElement().click();
        Elements.ContinueAfterSaveElement().click();
    //Choose The Second Method Of Shipping
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Elements.GetAirElement().click();
        Elements.GetContinue2Element().click();
    //Continue Till Finish
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Elements.GetContinue3Element().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        Elements.GetContinue4Element().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        Elements.GetConfirmElement().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Elements.GetFinalConfirmElement().click();

    }

    @Test(priority = 7)
    public void PreparationForInvalidData() throws InterruptedException {

        ValidSearch("mac");
        ValidAddtoCart();
        NavigateToCheckOut();
        CheckOutPage Elements = new CheckOutPage(driver);
        //Delete All Data
        Elements.GetDeleteButton().click();
    }
    @Test(priority = 7,dependsOnMethods ="PreparationForInvalidData" ,dataProvider = "invalid Data")
    public void EnterInValidData(String Firstname,String Lastname,String Email,String Company,String City,String Address,String Address2,String PostalCode , String Phonenumber,String Fax) throws InterruptedException {


        CheckOutPage Elements = new CheckOutPage(driver);
        Thread.sleep(1000);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //Provide Data Form Excel Sheet

        //FirstName
        Elements.GetFirstnameElement().clear();
        Elements.GetFirstnameElement().sendKeys(Firstname);
        Thread.sleep(100);

        //LastName
        Elements.GetLastnameElement().clear();
        Elements.GetLastnameElement().sendKeys(Lastname);
        Thread.sleep(100);

        //Email
        Elements.GetEmailElement().clear();
        Elements.GetEmailElement().sendKeys(Email);
        Thread.sleep(100);

        //Company Name
        Elements.GetCompanyElement().clear();
        Elements.GetCompanyElement().sendKeys(Company);
        Thread.sleep(100);

        //Select Country From Drop Down List
        Select select=new Select(Elements.GetCountryDropListElement());
        select.selectByValue("123");
        Thread.sleep(100);

        // City
        Elements.GetCityElement().clear();
        Elements.GetCityElement().sendKeys(City);
        Thread.sleep(100);

        // Address 1
        Elements.GetAddress1Element().clear();
        Elements.GetAddress1Element().sendKeys(Address);
        Thread.sleep(100);

        // Address 2
        Elements.GetAddress2Element().clear();
        Elements.GetAddress2Element().sendKeys(Address2);
        Thread.sleep(100);

        // Postal Code or ZIP
        Elements.GetPostalCodeyElement().clear();
        Elements.GetPostalCodeyElement().sendKeys(PostalCode);
        Thread.sleep(100);

        // Phone Number
        Elements.GetPhoneNumberElement().clear();
        Elements.GetPhoneNumberElement().sendKeys(Phonenumber);
        Thread.sleep(100);

        // Fax
        Elements.GetFaxNumberElement().clear();
        Elements.GetFaxNumberElement().sendKeys(Fax);
        Thread.sleep(100);


        // Try to Continue
        Elements.GetContinueElement().click();
        Thread.sleep(100);


        //Check Unsuccessful Message
        String Expected = "Checkout" ;
        String Actual = Elements.CheckOutTagElement().getText();
        Soft.assertEquals(Actual,Expected);


    }

    @DataProvider(name = "invalid Data")
    public Object[][] InValidData() throws IOException, InvalidFormatException {
        CheckOutData Invalid = new CheckOutData();
        return Invalid.SendInValidData();
    }


}

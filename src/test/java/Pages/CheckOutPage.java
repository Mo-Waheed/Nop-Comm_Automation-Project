package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
    WebDriver driver ;
    public CheckOutPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public WebElement GetGoToCheckOutElement()
    {
        WebElement GoToCheckOutElement = driver.findElement(By.id("checkout"));
        return GoToCheckOutElement;
    }
    public WebElement GetCheckBoxElement()
    {
        WebElement CheckBoxElement = driver.findElement(By.id("termsofservice"));
        return CheckBoxElement;
    }
    public WebElement GetCountryDropListElement()
    {
        WebElement CountryDropListElement= driver.findElement(By.id("BillingNewAddress_CountryId"));
        return CountryDropListElement;
    }
    public WebElement GetAddress1Element()
    {
        WebElement Address1Element= driver.findElement(By.id("BillingNewAddress_Address1"));
        return Address1Element;
    }
    public WebElement GetAddress2Element()
    {
        WebElement Address2Element= driver.findElement(By.id("BillingNewAddress_Address2"));
        return Address2Element;
    }
    public WebElement GetCityElement()
    {
        WebElement CityElement= driver.findElement(By.id("BillingNewAddress_City"));
        return CityElement;
    }
    public WebElement GetPostalCodeyElement()
    {
        WebElement PostalCodeyElement= driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        return PostalCodeyElement;
    }
    public WebElement GetPhoneNumberElement()
    {
        WebElement PhoneNumberElement= driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        return PhoneNumberElement;
    }
    public WebElement GetFaxNumberElement()
    {
        WebElement FaxNumberElement= driver.findElement(By.id("BillingNewAddress_FaxNumber"));
        return FaxNumberElement;
    }

    public WebElement GetCompanyElement()
    {
        WebElement CompanyElement= driver.findElement(By.id("BillingNewAddress_Company"));
        return CompanyElement;
    }
    public WebElement GetContinueElement()
    {
        WebElement ContinueElement= driver.findElement(By.xpath("(//button[@class=\"button-1 new-address-next-step-button\"])[1]"));
        return ContinueElement;
    }
    public WebElement GetSaveElement()
    {
        WebElement SaveElement= driver.findElement(By.xpath("//button[@id=\"save-billing-address-button\"]"));
        return SaveElement;
    }

    public WebElement GetContinue2Element()
    {
        WebElement Continue2Element= driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button"));
        return Continue2Element;
    }
    public WebElement GetGroundElement()
    {
        WebElement GroundElement= driver.findElement(By.id("shippingoption_0"));
        return GroundElement;
    }
    public WebElement GetAirElement()
    {
        WebElement AirElement= driver.findElement(By.id("shippingoption_1"));
        return AirElement;
    }
    public WebElement GetPay1Element()
    {
        WebElement GroundElement= driver.findElement(By.id("paymentmethod_0"));
        return GroundElement;
    }
    public WebElement GetContinue3Element()
    {
        WebElement ContinueElement= driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button"));
        return ContinueElement;
    }

    public WebElement GetContinue4Element()
    {
        WebElement ContinueElement= driver.findElement(By.xpath("//button[@class=\"button-1 payment-info-next-step-button\"]"));
        return ContinueElement;
    }

    public WebElement GetConfirmElement()
    {
        WebElement ContinueElement= driver.findElement(By.xpath("//button[@class=\"button-1 confirm-order-next-step-button\"]"));
        return ContinueElement;
    }

    public WebElement GetSuccessMessageElement()
    {
        WebElement SuccessMessageElement= driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1"));
        return SuccessMessageElement;
    }

    public WebElement GetFinalConfirmElement()
    {
        WebElement FinalConfirmElement= driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[3]/button"));
        return FinalConfirmElement;
    }

    public WebElement GetEditButtonElement()
    {
        WebElement FinalConfirmElement= driver.findElement(By.xpath("//*[@id=\"edit-billing-address-button\"]"));
        return FinalConfirmElement;
    }

    public WebElement ContinueAfterSaveElement()
    {
        WebElement ButtonElement= driver.findElement(By.xpath("(//button[@class=\"button-1 new-address-next-step-button\"])[1]"));
        return ButtonElement;
    }
    public WebElement CheckOutTagElement()
    {
        WebElement CheckOutTagElement= driver.findElement(By.tagName("h1"));
        return CheckOutTagElement;
    }

    public WebElement GetDeleteButton()
    {
       WebElement DeleteButton = driver.findElement(By.id("delete-billing-address-button"));
       return DeleteButton;
    }
    public WebElement GetFirstnameElement()
    {
        WebElement FirstnameElement = driver.findElement(By.id("BillingNewAddress_FirstName"));
        return FirstnameElement;
    }
    public WebElement GetLastnameElement()
    {
        WebElement LastnameElement = driver.findElement(By.id("BillingNewAddress_LastName"));
        return LastnameElement;
    }
    public WebElement GetEmailElement()
    {
        WebElement EmailElement = driver.findElement(By.id("BillingNewAddress_Email"));
        return EmailElement;
    }





}

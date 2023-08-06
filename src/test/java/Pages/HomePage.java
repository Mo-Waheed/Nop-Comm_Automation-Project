package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver ;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public WebElement GetRegElement()
    {
        WebElement RegElement=driver.findElement(By.xpath("//a[@href=\"/register?returnUrl=%2F\"]"));
        return RegElement;
    }

    public WebElement GetLoginElement()
    {
        WebElement LoginElement =driver.findElement(By.xpath("//a[@href=\"/login?returnUrl=%2F\"]"));
        return LoginElement;
    }
    public WebElement GetLogoutElement()
    {
        WebElement LogoutElement =driver.findElement(By.xpath("//a[@class=\"ico-logout\"]"));
        return LogoutElement;
    }
    public WebElement GetSearchBoxElement()
    {
        WebElement SearchBoxElement=driver.findElement(By.id("small-searchterms"));
        return SearchBoxElement;
    }
    public WebElement GetSearchButtonElement()
    {
        WebElement SearchButtonElement=driver.findElement(By.xpath("//button[@class=\"button-1 search-box-button\"]"));
        return SearchButtonElement;
    }
    public WebElement GetComputerElement()
    {
        WebElement ComputerElement=driver.findElement(By.linkText("Computers"));
        return ComputerElement;
    }

    public WebElement GetDesktopElement()
    {
        WebElement DesktopElement=driver.findElement(By.linkText("Desktops"));
        return DesktopElement;
    }
    public WebElement GetElectronicsElement()
    {
        WebElement ElectronicsElement=driver.findElement(By.linkText("Electronics"));
        return ElectronicsElement;
    }
    public WebElement GetCameraElement()
    {
        WebElement DesktopElement=driver.findElement(By.linkText("Camera & photo"));
        return DesktopElement;
    }
    public WebElement GetApparelElement()
    {
        WebElement ApparelElement=driver.findElement(By.linkText("Apparel"));
        return ApparelElement;
    }
    public WebElement GetShoesElement()
    {
        WebElement ShoesElement=driver.findElement(By.linkText("Shoes"));
        return ShoesElement;
    }
    public WebElement GetDigitalElement()
    {
        WebElement DigitalElement=driver.findElement(By.linkText("Digital downloads"));
        return DigitalElement;
    }
    public WebElement GetBooksElement()
    {
        WebElement ShoesElement=driver.findElement(By.linkText("Books"));
        return ShoesElement;
    }
    public WebElement GetJewelryElement()
    {
        WebElement JewelryElement=driver.findElement(By.linkText("Jewelry"));
        return JewelryElement;
    }
    public WebElement GetGiftElement()
    {
        WebElement GiftElement=driver.findElement(By.linkText("Gift Cards"));
        return GiftElement;
    }
}

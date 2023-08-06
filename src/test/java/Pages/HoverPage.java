package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoverPage {
    WebDriver driver ;
    public HoverPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public WebElement GetComputerElement()
    {
        WebElement ComputerElement=driver.findElement(By.linkText("Build your own computer"));
        return ComputerElement;
    }
    public WebElement GetCamElement()
    {
        WebElement CamElement=driver.findElement(By.linkText("Apple iCam"));
        return CamElement;
    }
    public WebElement GetShoesElement()
    {
        WebElement ShoesElement=driver.findElement(By.partialLinkText("adidas Consortium"));
        return ShoesElement;
    }
    public WebElement GetDigitalElement()
    {
        WebElement DigitalElement=driver.findElement(By.partialLinkText("If You Wait"));
        return DigitalElement;
    }
    public WebElement GetBooksElement()
    {
        WebElement BooksElement=driver.findElement(By.partialLinkText("First Prize"));
        return BooksElement;
    }
    public WebElement GetjewlaryElement()
    {
        WebElement jewlaryElement=driver.findElement(By.partialLinkText("Flower Girl"));
        return jewlaryElement;
    }
    public WebElement GetGiftElement()
    {
        WebElement GiftElement=driver.findElement(By.partialLinkText("$50 Physical"));
        return GiftElement;
    }
}

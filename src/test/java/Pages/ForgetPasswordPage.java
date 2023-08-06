package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPasswordPage {
    WebDriver driver;
    public ForgetPasswordPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public WebElement GetTextCheckElement()
    {
        WebElement TextCheckElement= driver.findElement(By.xpath("//p[@class=\"tooltip\"]"));
        return TextCheckElement;
    }

    public WebElement GetEmailElement()
    {
        WebElement EmailElement= driver.findElement(By.id("Email"));
        return EmailElement;
    }
    public WebElement GetRecoverButtonElement()
    {
        WebElement RecoverButtonElement= driver.findElement(By.xpath("//button[@class=\"button-1 password-recovery-button\"]"));
        return RecoverButtonElement;
    }
    public WebElement GetHoverMessageElement()
    {
        WebElement SuccMessageElement= driver.findElement(By.xpath("//p[@class=\"content\"]"));
        return SuccMessageElement;
    }
    public WebElement GetFailedMessageElement()
    {
        WebElement FailedMessageElement= driver.findElement(By.id("Email-error"));
        return FailedMessageElement;
    }



}

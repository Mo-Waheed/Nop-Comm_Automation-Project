package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver ;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public WebElement GetEmailElement()
    {
        WebElement UserNameElement= driver.findElement(By.id("Email"));
        return UserNameElement;
    }
    public WebElement GetPasswordElement()
    {
        WebElement PasswordElement= driver.findElement(By.id("Password"));
        return PasswordElement;
    }
    public WebElement GetRemeberMeElement()
    {
        WebElement RemeberMeElement= driver.findElement(By.id("RememberMe"));
        return RemeberMeElement;
    }
    public WebElement GetLoginButtonElement()
    {
        WebElement LoginButtonElement= driver.findElement(By.xpath("//button[@class=\"button-1 login-button\"]"));
        return LoginButtonElement;
    }
    public WebElement GetFailedMessageElement()
    {
        WebElement FailedMessageElement = driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]"));
        return FailedMessageElement;
    }
    public WebElement GetForgetPasswordElement()
    {
        WebElement ForgetPasswordElement = driver.findElement(By.linkText("Forgot password?"));
        return ForgetPasswordElement;
    }

}

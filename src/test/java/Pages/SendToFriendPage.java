package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendToFriendPage {
    WebDriver driver ;
    public SendToFriendPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public WebElement GetFriendEmailElement()
    {
       WebElement FriendEmailElement=driver.findElement(By.id("FriendEmail"));
       return FriendEmailElement;
    }
    public WebElement GetYourEmailElement()
    {
        WebElement YourEmailElement=driver.findElement(By.id("YourEmailAddress"));
        return YourEmailElement;
    }
    public WebElement GetPersonalInfoElement()
    {
        WebElement PersonalInfoElement=driver.findElement(By.id("PersonalMessage"));
        return PersonalInfoElement;
    }
    public WebElement GetSendButtonElement()
    {
        WebElement SendButtonElement=driver.findElement(By.xpath("//button[@class=\"button-1 send-email-a-friend-button\"]"));
        return SendButtonElement;
    }
    public WebElement GetSuccessMessageElement()
    {
        WebElement SuccessMessageElement=driver.findElement(By.xpath("//div[@class=\"result\"]"));
        return SuccessMessageElement;
    }
}

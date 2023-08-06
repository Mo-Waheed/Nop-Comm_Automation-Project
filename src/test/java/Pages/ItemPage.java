package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage {
    WebDriver driver;
    public ItemPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public WebElement GetHeadOfItemElement()
    {
        WebElement HeadOfItem= driver.findElement(By.tagName("h1"));
        return HeadOfItem;
    }
    public WebElement GetAddToCartButton()
    {
        WebElement AddToCartButton= driver.findElement(By.id("add-to-cart-button-4"));
        return AddToCartButton;
    }
    public WebElement GetQuantityElement()
    {
        WebElement QuantityElement= driver.findElement(By.id("product_enteredQuantity_4"));
        return QuantityElement;
    }

    public WebElement GetSuccMessageElement()
    {
        WebElement SuccMessageElement= driver.findElement(By.xpath("//p[@class=\"content\"]"));
        return SuccMessageElement;
    }
    public WebElement GetFailedMessageElement()
    {
        WebElement FailedMessageElement= driver.findElement(By.xpath("//p[@class=\"content\"]"));
        return FailedMessageElement;
    }
    public WebElement GetCartLinkElement()
    {
        WebElement CartLinkElement= driver.findElement(By.cssSelector("#bar-notification > div > p > a"));
        return CartLinkElement;
    }

    public WebElement GetEmailFriendElement()
    {
        WebElement EmailFriendElement= driver.findElement(By.xpath("//button[@class=\"button-2 email-a-friend-button\"]"));
        return EmailFriendElement;
    }


}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchPage {
    WebDriver driver;
    public SearchPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public WebElement GetWarningMessage()
    {
        WebElement WarningMessage= driver.findElement(By.xpath("//div[@class=\"warning\"]"));
        return WarningMessage;
    }
    public WebElement GetSearchItem()
    {
        WebElement SearchItem= driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div.center-2 > div > div.page-body > div.search-results > div > div.products-wrapper > div > div > div > div > div.details > h2 > a"));
        return SearchItem;
    }


}

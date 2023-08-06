package Tests;

import Data.Search.SearchData;
import Pages.ItemPage;
import Pages.SearchPage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class AddToCart extends Test_Base {
    String Expected;
    String Actual;
    SoftAssert Soft=new SoftAssert();
    SearchPage Enter;
    ItemPage Elements;
    @Test(priority = 1,dataProvider = "ValidData")
    public void CallSearch(String Item) {
        //Search for The Item
        Search Call = new Search();
        Enter = new SearchPage(driver);
        Call.validSearchforItem(Item);
    }
    @Test(priority = 2)
    public void NavigatetItemPage() throws InterruptedException {
        //Make Sure It's Exist
        Enter = new SearchPage(driver);
        Elements = new ItemPage(driver);
        Enter.GetSearchItem().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected="Apple MacBook Pro 13-inch";
        Actual=Elements.GetHeadOfItemElement().getText();
        Soft.assertTrue(Actual.contains(Expected));

        //Case One
        Elements.GetQuantityElement().clear();
        Elements.GetQuantityElement().sendKeys("0");
        Elements.GetAddToCartButton().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected="Quantity should be positive";
        Actual=Elements.GetFailedMessageElement().getText();
        Soft.assertTrue(Actual.contains(Expected));

        //Case Two
        Elements.GetQuantityElement().clear();
        Elements.GetQuantityElement().sendKeys("2");
        Elements.GetAddToCartButton().click();
        Thread.sleep(3000);
        Expected="The product has been added to your";
        Actual=Elements.GetSuccMessageElement().getText();
        Soft.assertTrue(Actual.contains(Expected));

        Soft.assertAll();
    }
    @DataProvider
    public Object[][] ValidData() throws IOException, InvalidFormatException {
        SearchData Valid=new SearchData();
        return Valid.ValidData();
    }
}

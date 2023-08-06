package Tests;

import Pages.HomePage;
import Pages.HoverPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Hover extends Test_Base{
    String Expected ;
    String Actual ;
    SoftAssert Soft = new SoftAssert();
    @Test
    public void SeeComputersList()  {

        //Creating Objects To Call WebElements
        HomePage Icons = new HomePage(driver);
        HoverPage Element = new HoverPage(driver);

        //Move to Hover and Click
        action.moveToElement(Icons.GetComputerElement()).perform();
        Icons.GetDesktopElement().click();

        //Checking Items
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected="Build your own computer";
        Actual=Element.GetComputerElement().getText();
        Soft.assertTrue(Actual.contains(Expected));
        Soft.assertAll();
    }
    @Test
    public void SeeElectronicsList()  {

        //Creating Objects To Call WebElements
        HomePage Icons = new HomePage(driver);
        HoverPage Element = new HoverPage(driver);

        //Move to Hover and Click
        action.moveToElement(Icons.GetElectronicsElement()).perform();
        Icons.GetCameraElement().click();

        //Checking Items
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected="Apple iCam";
        Actual=Element.GetCamElement().getText();
        Soft.assertTrue(Actual.contains(Expected));
        Soft.assertAll();

    }
    @Test
    public void SeeApparelList()  {

        //Creating Objects To Call WebElements
        HomePage Icons = new HomePage(driver);
        HoverPage Element = new HoverPage(driver);

        //Move to Hover and Click
        action.moveToElement(Icons.GetApparelElement()).perform();
        Icons.GetShoesElement().click();

        //Checking Items
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected="adidas Consortium";
        Actual=Element.GetShoesElement().getText();
        Soft.assertTrue(Actual.contains(Expected));
        Soft.assertAll();
    }
    @Test
    public void SeeDigitallList()  {

        //Creating Objects To Call WebElements
        HomePage Icons = new HomePage(driver);
        HoverPage Element = new HoverPage(driver);

        //Move to Hover and Click
        Icons.GetDigitalElement().click();

        //Checking Items
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected="If You Wait ";
        Actual=Element.GetDigitalElement().getText();
        Soft.assertTrue(Actual.contains(Expected));
        Soft.assertAll();
    }
    @Test
    public void SeeBooksList()  {

        //Creating Objects To Call WebElements
        HomePage Icons = new HomePage(driver);
        HoverPage Element = new HoverPage(driver);

        //Move to Hover and Click
        Icons.GetBooksElement().click();

        //Checking Items
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected="First Prize";
        Actual=Element.GetBooksElement().getText();
        Soft.assertTrue(Actual.contains(Expected));
        Soft.assertAll();
    }
    @Test
    public void SeeJewelryList()  {

        //Creating Objects To Call WebElements
        HomePage Icons = new HomePage(driver);
        HoverPage Element = new HoverPage(driver);

        //Move to Hover and Click
        Icons.GetJewelryElement().click();

        //Checking Items
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected="Flower Girl";
        Actual=Element.GetjewlaryElement().getText();
        Soft.assertTrue(Actual.contains(Expected));
        Soft.assertAll();
    }
    @Test
    public void SeeGiftCardsList()  {

        //Creating Objects To Call WebElements
        HomePage Icons = new HomePage(driver);
        HoverPage Element = new HoverPage(driver);

        //Move to Hover and Click
        Icons.GetGiftElement().click();

        //Checking Items
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Expected="$50 Physical";
        Actual=Element.GetGiftElement().getText();
        Soft.assertTrue(Actual.contains(Expected));
        Soft.assertAll();
    }
}

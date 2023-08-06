package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegPage {
    WebDriver driver ;
    public RegPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public WebElement GetMaleGenderElement()
    {
        WebElement GenderMaleElement=driver.findElement(By.id("gender-male"));
        return GenderMaleElement;
    }
    public WebElement GetFemaleGenderElement()
    {
        WebElement FemaleGenderElement=driver.findElement(By.id("gender-female"));
        return FemaleGenderElement;
    }
    public WebElement GetFirstnameElement()
    {
        WebElement FirstNameElement=driver.findElement(By.id("FirstName"));
        return FirstNameElement;
    }
    public WebElement GetLastnameElement()
    {
        WebElement LastNameElement=driver.findElement(By.id("LastName"));
        return LastNameElement;
    }
    public WebElement GetDayDropDownElement()
    {
        WebElement DayDropDownElement=driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]"));
        return DayDropDownElement;
    }
    public WebElement GetMonthDropDownElement()
    {
        WebElement MonthDropDownElement=driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]"));
        return MonthDropDownElement;
    }
    public WebElement GetYearDropDownElement()
    {
        WebElement YearDropDownElement=driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]"));
        return YearDropDownElement;
    }
    public WebElement GetEmailElement()
    {
        WebElement EmailElement=driver.findElement(By.id("Email"));
        return EmailElement;
    }
    public WebElement GetCompanyElement()
    {
        WebElement CompanyElement=driver.findElement(By.id("Company"));
        return CompanyElement;
    }
    public WebElement GetNewsBottomElement()
    {
        WebElement NewsBottomElement=driver.findElement(By.id("Newsletter"));
        return NewsBottomElement;
    }

    public WebElement GetPasswordElement() {
        WebElement PasswordElement = driver.findElement(By.id("Password"));
        return PasswordElement;
    }
    public WebElement GetConfirmPasswordElement() {
        WebElement ConfirmPasswordElement = driver.findElement(By.id("ConfirmPassword"));
        return ConfirmPasswordElement;
    }

    public WebElement GetRegBottomElement() {
        WebElement RegBottomElement = driver.findElement(By.id("register-button"));
        return RegBottomElement;
    }
    public WebElement GetSuccMessageElement() {
        WebElement SuccMessageElement = driver.findElement(By.xpath("//div[@class=\"result\"]"));
        return SuccMessageElement;
    }
    public WebElement GetContinueBottomElement() {
        WebElement ContinueBottomElement = driver.findElement(By.xpath("//a[@class=\"button-1 register-continue-button\"]"));
        return ContinueBottomElement;
    }

}

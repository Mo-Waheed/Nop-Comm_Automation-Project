package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Test_Base {
    public static WebDriver driver;
    public static Actions action ;

    @BeforeClass
    public void OpenBrowser()
    {
        String Bridge = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("chromedriver.chrome.driver",Bridge);
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        action = new Actions(driver) ;
    }
    @AfterClass
    public void Close()
    {
        driver.quit();
    }
}

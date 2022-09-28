package StepDefinition;

import Page.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
    public static WebDriver driver;
    protected static PageFactory pageFactory;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        pageFactory = new PageFactory(driver);
    }
//    public static void setup(String browserName) {
//        if (browserName.equalsIgnoreCase("Chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.navigate().to("https://demo.nopcommerce.com/");
//            driver.manage().window().maximize();
//            pageFactory = new PageFactory(driver);
//        } else if (browserName.equalsIgnoreCase("FireFox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//            driver.navigate().to("https://demo.nopcommerce.com/");
//            driver.manage().window().maximize();
//            pageFactory = new PageFactory(driver);
//        }
//    }
    @AfterClass
    public static void close() {
        driver.quit();
    }
}


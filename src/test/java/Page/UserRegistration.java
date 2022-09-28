package Page;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class UserRegistration {
    WebDriver driver;
    WebDriverWait wait;
    public static String path;

    By register = By.linkText("Register");
    By gender = By.xpath("//input[@type='radio' and @id='gender-male']");
    By firstName = By.xpath("//input[@type='text' and @id='FirstName']");
    By lastName = By.xpath("//input[@type='text' and @id='LastName']");
    By dateOfBirthDay = By.xpath("//select[@name='DateOfBirthDay']");
    By dateOfBirthMonth = By.xpath("//select[@name='DateOfBirthMonth']");
    By dateOfBirthYear = By.xpath("//select[@name='DateOfBirthYear']");
    By dateYear = By.xpath("//option[@value='1990' and text()='1990']");
    By dateMonth = By.xpath("//option[@value='8' and text()='August']");
    By dateDay = By.xpath("//option[@value='5' and text()='5']");
    By email = By.xpath("//input[@type='email' and @id='Email']");
    By company = By.xpath("//input[@id='Company']");
    By password = By.xpath("//input[@id='Password']");
    By confirmPassword = By.xpath("//input[@id='ConfirmPassword']");
    By registerButton = By.xpath("//button[@id='register-button']");

    public UserRegistration(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void registeringUser() throws IOException {
        path = System.getProperty("user.dir") + "C:\\Users\\LoveGupta\\IdeaProjects\\DemoNopCommerce2\\src\\test\\java\\TestData";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        driver.findElement(register).click();
        driver.findElement(gender).click();
        String firstNameCell = sheet.getRow(1).getCell(2).getStringCellValue();
        String lastNameCell = sheet.getRow(1).getCell(3).getStringCellValue();
        String emailCell = sheet.getRow(1).getCell(4).getStringCellValue();
        String companyCell = sheet.getRow(1).getCell(5).getStringCellValue();
        String passwordCell = sheet.getRow(1).getCell(6).getStringCellValue();
        driver.findElement(firstName).sendKeys(firstNameCell);
        driver.findElement(lastName).sendKeys(lastNameCell);
        driver.findElement(dateOfBirthDay).click();
        driver.findElement(dateDay).click();
        driver.findElement(dateOfBirthMonth).click();
        driver.findElement(dateMonth).click();
        driver.findElement(dateOfBirthYear).click();
        driver.findElement(dateYear).click();
        driver.findElement(email).sendKeys(emailCell);
        driver.findElement(company).sendKeys(companyCell);
        driver.findElement(password).sendKeys(passwordCell);
        driver.findElement(confirmPassword).sendKeys(passwordCell);
        driver.findElement(registerButton).click();
    }

    public void UserIsOnHomepage() {
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='header-menu']")).getText(), "Header Menu");
    }

    public void UserClickOnTheRegisterButton() {
        driver.findElement(register).click();
    }
}
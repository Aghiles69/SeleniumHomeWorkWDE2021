package Homework.LoginTestCases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestCase2Login {
    String absPath = System.getProperty("user.dir");
    String relativePath = "/Homework/resources/chromeDriver/chromedriver.exe";
    String chromeDriverPath = absPath + relativePath;
    String website = "https://www.amazon.com//";
    public static WebDriverWait webDriverWait;
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(website);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        WebElement signInLink = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        signInLink.click();
    }

    @Test
    public void enterInput() {

        WebElement enterEmail = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        enterEmail.click();
        enterEmail.sendKeys("amazontestcaselogin@gmail.com");
        WebElement clickContinue = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        clickContinue.click();
        WebElement inputPassword = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        inputPassword.click();
        inputPassword.sendKeys("Selenium1");
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
        signIn.click();
    }

    @Test
    public void accountHomePage(){

        WebElement accountPage = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        accountPage.click();
        WebElement updateInfo = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[2]/div[2]/a/div/div/div/div[2]/h2"));
        updateInfo.click();
        WebElement edit = driver.findElement(By.xpath("//*[@id=\"auth-cnep-edit-phone-button\"]"));
        edit.click();
        WebElement addNumber = driver.findElement(By.xpath("//*[@id=\"ap_phone_number\"]"));
        addNumber.click();
        addNumber.sendKeys("7185819358");
        WebElement continueEdit = driver.findElement(By.xpath("//*[@id=\"auth-continue\"]"));
        continueEdit.click();
        WebElement clickOK = driver.findElement(By.xpath("//*[@id=\"auth-verification-ok-announce\"]"));
        WebElement signOut = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"));
        WebElement clickSignOut = driver.findElement(By.xpath("//*[@id=\"nav-item-signout\"]/span"));
        clickSignOut.click();
        WebElement enterPhoneNumber = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        enterPhoneNumber.click();
        enterPhoneNumber.sendKeys("7185819358");
        WebElement clickContinue = driver.findElement(By.xpath("//*[@id=\"continue-announce\"]"));
        clickContinue.click();
        WebElement password = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        password.click();
        password.sendKeys("Selenium1");
        WebElement signin = driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
        signin.click();

    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

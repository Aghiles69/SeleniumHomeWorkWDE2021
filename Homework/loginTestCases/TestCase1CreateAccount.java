package Homework.loginTestCases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestCase1CreateAccount {
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
        WebElement createAccountLink = driver.findElement(By.id("createAccountSubmit"));
        createAccountLink.click();
    }

    @Test
    public void enterInput(){
        WebElement enterName = driver.findElement(By.xpath("//*[@id=\"ap_customer_name\"]"));
        enterName.click();
        enterName.sendKeys("Shams Uddin");
        WebElement enterEmail = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        enterEmail.click();
        enterEmail.sendKeys("amazontestcaselogin@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        password.click();
        password.sendKeys("Selenium1");
        WebElement reenterPassword = driver.findElement(By.xpath("//*[@id=\"ap_password_check\"]"));
        reenterPassword.click();
        reenterPassword.sendKeys("Selenium1");
        WebElement clickContinue = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        clickContinue.click();


    }
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}

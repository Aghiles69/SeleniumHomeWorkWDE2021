package Homework.sellingTestCases;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SellingTestCases {
    String absPath = System.getProperty("user.dir");
    String relativePath = "/Homework/resources/chromeDriver/chromedriver.exe";
    String chromeDriverPath = absPath + relativePath;
    String website = "https://www.amazon.com/";
    static ChromeDriver driver;
    public static WebDriverWait webDriverwait;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(website);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    @Test
    public void testSellingButton() throws InterruptedException {
//  Test Case 1: find selling option on homepage and clicking on it.
        WebElement findSelling = driver.findElement(By.cssSelector("#navFooter > div.navFooterVerticalColumn.navAccessibility > div > div:nth-child(3) > ul > li.nav_first"));
        findSelling.click();

//  Test Case 2: finding the signup option and clicking on it
        webDriverwait = new WebDriverWait(driver, 3);
        webDriverwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#rp_cta_h_prenav_t1 > div > a"))));
        WebElement signUp = driver.findElement(By.cssSelector("#rp_cta_h_prenav_t1 > div > a"));
        signUp.click();
        // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//  Test Case 3: looking for email input box and entering an email if you already have a selling account.
//        WebElement enterSellerEmail = driver.findElement(By.cssSelector("#ap_email"));
//        enterSellerEmail.sendKeys("asjadaftab9@gmail.com");
////  Test Case 4: location password input box and entering password and clicking continue
//        WebElement enterSellerPassword = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
//        enterSellerPassword.sendKeys("KashmreyPa$$");
//        driver.findElement(By.cssSelector("#a-autoid-0")).click();

//  Test Case 5: click on create an account and fill in information
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement createYourAmazonAccount = driver.findElement(By.cssSelector("#createAccountSubmit"));
        createYourAmazonAccount.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement enterYourName = driver.findElement(By.cssSelector("#ap_customer_name"));
        enterYourName.click();
        enterYourName.sendKeys("Kash");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement enterYourEmail = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        enterYourEmail.click();
        enterYourName.sendKeys("asjadaftab9@gmail.com");
        WebElement enterPassword = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        enterPassword.sendKeys("KashmreyPa$$");
        WebElement enterPasswordAgain = driver.findElement(By.xpath("//*[@id=\"ap_password_check\"]"));
        enterPasswordAgain.sendKeys("KashmreyPa$$");

        driver.findElement(By.cssSelector("#a-autoid-0")).click();


//      Assert.assertEquals("Search result quantity does not match", expectedText, actualText);

    }

    @After
    public void tearDown (){
        driver.close();
        driver.quit();
    }


}
}

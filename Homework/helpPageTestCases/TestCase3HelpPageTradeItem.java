package Homework.helpPageTestCases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestCase3HelpPageTradeItem {
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
        WebElement getHelpLink = driver.findElement(By.cssSelector("#navFooter > div.navFooterVerticalColumn." +
                "navAccessibility > div > div:nth-child(7) > ul > li.nav_last > a"));
        getHelpLink.click();
    }

    @Test
    public void tradeItem() {

        WebElement getProductHelpBox = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[1]/div[1]/div[3]/a/div"));
        getProductHelpBox.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement emailInputBox = driver.findElementByCssSelector("#ap_email");
        emailInputBox.sendKeys("aghilesham20@gmail.com");
        WebElement continueButton = driver.findElementByCssSelector("#continue");
        continueButton.click();
        WebElement pWInput = driver.findElementByCssSelector("#ap_password");
        pWInput.sendKeys("abcd1234");
        WebElement signInButton = driver.findElementByCssSelector("#signInSubmit");
        signInButton.click();
        WebElement getHelpLink = driver.findElement(By.cssSelector("#navFooter > div.navFooterVerticalColumn." +
                "navAccessibility > div > div:nth-child(7) > ul > li.nav_last > a"));
        getHelpLink.click();
        webDriverWait = new WebDriverWait(driver, 3);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[4]/div/div[1]/div[1]/div[3]/a/div")));
        getProductHelpBox.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pageContentContainer\"]/div[12]/div/div[2]/a/span")));
        WebElement tradeInLink = driver.findElementByXPath("//*[@id=\"pageContentContainer\"]/div[12]/div/div[2]/a/span");
        tradeInLink.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"contentGrid_731933\"]/div/div[4]/div[2]/div")));
        WebElement boxCategoryN2 = driver.findElementByXPath("//*[@id=\"contentGrid_731933\"]/div/div[4]/div[2]/div");
        boxCategoryN2.click();
        String expectedTextDisplay = "Amazon Tablets";
        WebElement tradeInTabPage = driver.findElementByXPath("//*[@id=\"contentGrid_691297\"]/div/div[4]/div[2]/div/div/h1/strong");
        String actualTextDisplay = tradeInTabPage.getText();
        Assert.assertEquals(actualTextDisplay, expectedTextDisplay);
    }

    @After
    public void tearDown() {
        //driver.close();
        //driver.quit();
    }
}

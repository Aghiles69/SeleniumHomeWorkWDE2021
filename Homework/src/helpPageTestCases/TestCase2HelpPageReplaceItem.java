package Homework.src.helpPageTestCases;

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

public class TestCase2HelpPageReplaceItem {
    String absPath = System.getProperty("user.dir");
    String relativePath = "/Homework/resources/chromeDriver/chromedriver.exe";
    String chromeDriverPath = absPath + relativePath;
    String website = "https://www.amazon.com//";
    public static WebDriverWait webDriverWait;
    static ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);

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
    public void testReplaceItem(){


        WebElement findDropMenu = driver.findElement(By.cssSelector("#category-section"));
        findDropMenu.click();
        WebElement getRetrunsOption = driver.findElementByCssSelector("#category-section > li:nth-child(4) > a");
        getRetrunsOption.click();
        WebElement getReplaceLink = driver.findElementByCssSelector("#help-gateway-category-3 > div > div > div > ul > li:nth-child(11) > a");
        getReplaceLink.click();
        webDriverWait = new WebDriverWait(driver,3);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[3]/h1")));
        String expectedText = "Replace an Item";
        WebElement replaceText = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[3]/h1"));
        String actualText = replaceText.getText();
        Assert.assertEquals(expectedText,actualText);

    }
    @After
    public void tearDown () {
        //driver.close();
        //driver.quit();
    }
}

package Homework.src.helpPageTestCases;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestCase2HelpPageReplaceItem {
    String absPath = System.getProperty("user.dir");
    String relativePath = "/resources/WinWebDriver/chromedriver.exe";
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
        WebElement getRTopicsOption = driver.findElementByCssSelector("#category-section > li:nth-child(1)");
        getRTopicsOption.click();
        WebElement getReturnsLink = driver.findElementByCssSelector("#help-gateway-category-0 > div > div > div.a-column.a-span6 > ul > li:nth-child(4) > a");
        getReturnsLink.click();

    }
}

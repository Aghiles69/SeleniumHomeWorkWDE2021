package helpPageTestCases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestCase1SearchBarTestCase {

    String absPath = System.getProperty("user.dir");
    String relativePath = "/Homework/resources/chromeDriver/chromedriver.exe";
    String chromeDriverPath = absPath + relativePath;
    String website = "https://www.amazon.com//";
    static WebDriverWait webDriverWait;
    static ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(website);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    @Test
    public void testHelpSearch(){

        WebElement getHelpLink = driver.findElement(By.cssSelector("#navFooter > div.navFooterVerticalColumn." +
                "navAccessibility > div > div:nth-child(7) > ul > li.nav_last > a"));
        getHelpLink.click();
        webDriverWait = new WebDriverWait(driver, 3);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#helpsearch"))));

        WebElement searchInputBox = driver.findElement(By.cssSelector("#helpsearch"));
        searchInputBox.click();

        searchInputBox .sendKeys("late delivery");
        searchInputBox.sendKeys(Keys.ENTER);

        WebElement testDisplay = driver.findElement(By.cssSelector("#search-help > div > p"));
        String expectedText = "11 search results for late delivery";
        String actualText = testDisplay.getText();
        Assert.assertEquals(expectedText, actualText);


    }

    @After
    public void tearDown (){
        //driver.close();
       // driver.quit();
    }



}

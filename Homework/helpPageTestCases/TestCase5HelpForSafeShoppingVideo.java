package Homework.helpPageTestCases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestCase5HelpForSafeShoppingVideo {
    String absPath = System.getProperty("user.dir");
    String relativePath = "/resources/WinWebDriver/chromedriver.exe";
    String chromeDriverPath = absPath + relativePath;
    String website = "https://www.amazon.com//";
    public static WebDriverWait webDriverWait;
    static ChromeDriver driver;

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
    public void getVideoForSafeShoppingStarted(){

        WebElement safeShoppingBox = driver.findElementByXPath("/html/body/div[2]/div[4]/div/div[1]/div[3]/div[3]/a/div/div");
        safeShoppingBox.click();
        webDriverWait = new WebDriverWait(driver,3);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div/div/div/" +
                "div/div/div/div[3]/div/div[2]/div[3]/div[3]/div/video")));
        WebElement startVideo = driver.findElementByXPath("//*[@id=\"a-page\"]/div[2]/div/div/div/div/div/div/" +
                "div/div[3]/div/div[2]/div[3]/div[3]/div/video");
        startVideo.click();

    }
    @After
    public void tearDown () {
        //driver.close();
        //driver.quit();
    }
}

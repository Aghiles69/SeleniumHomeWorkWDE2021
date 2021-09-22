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

public class WatchListHw {
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
    //    @Test
//    public void testSaveForLaterButton() throws InterruptedException {
////  Test Case 1: click on bestsellers
    WebElement findWatchList = driver.findElement(By.xpath("//*[@id=]/a[2]"));
        findWatchList.click();

//////  Test Case 2: add the item of choice into your cart
////        webDriverwait = new WebDriverWait(driver, 3);
////        webDriverwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"anonCarousel2\"]/ol/li[1]"))));
////        WebElement addItem = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
////        addItem.click();
////         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//////  Test Case 3: Go click shopping and click the checkout option.
////        WebElement clickShoppingCart = driver.findElement(By.xpath("//*[@id=\"nav-cart-count-container\"]/span[2]"));
////////  Test Case 4: Locate item in cart and click "save for later"
////        WebElement clickSaveForLater = driver.findElement(By.xpath("//*[@id=]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[3]/span/input"));

    @After
    public void tearDown (){
        driver.close();
        driver.quit();
    }
}

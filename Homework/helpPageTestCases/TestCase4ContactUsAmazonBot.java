package Homework.helpPageTestCases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestCase4ContactUsAmazonBot {
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
    public void contactUsBot() {
        WebElement getDropmenu = driver.findElement(By.cssSelector("#category-section"));
        getDropmenu.click();
        WebElement moreHelpOption = driver.findElementByCssSelector("#category-section > li:nth-child(12) > a");
        moreHelpOption.click();
        WebElement contactUsLink = driver.findElementByXPath("//*[@id=\"help-gateway-category-11\"]/div/div/div/ul/li[3]/a");
        contactUsLink.click();
        WebElement emailInputBox = driver.findElementByCssSelector("#ap_email");
        emailInputBox.sendKeys("aghilesham20@gmail.com");
        WebElement pWInput = driver.findElementByCssSelector("#ap_password");
        pWInput.sendKeys("abcd1234");
        WebElement signInButton = driver.findElementByCssSelector("#signInSubmit");
        signInButton.click();
        WebElement chatButton = driver.findElementByCssSelector("#roundChatCta > span > input");
        chatButton.click();
    }
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

package Homework.searchCases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchTest {
    static String absPath = System.getProperty("user.dir");
    static String relativePath = "/Resources/Webdriver/Windows/chromedriver.exe";
    String chromeDriverPath = absPath + relativePath;
    String website = "https://www.amazon.com/";
    // public static WebDriverWait webDriverWait;
    static ChromeDriver driver;

    @Before
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.get(website);
    }
    @Test
    public void testProductSearch(){
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver.manage().window().maximize();
        driver.get(website);
        WebElement searchBox=driver.findElement(By.cssSelector(("#twotabsearchtextbox")));
        searchBox.sendKeys("Book");
        WebElement searchButton = driver.findElement(By.cssSelector((".nav-search-submit")));
        searchButton.click();
        driver.quit();


    }

    @After
    public void afterClass() {
        //     driver.quit();
    }

}

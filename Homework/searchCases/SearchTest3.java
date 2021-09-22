//package Homework.searchCases;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.concurrent.TimeUnit;
//
//public class SearchTest3 {
//    static String absPath = System.getProperty("user.dir");
//    static String relativePath = "/Resources/Webdriver/Windows/chromedriver.exe";
//    String chromeDriverPath = absPath + relativePath;
//    String website = "https://www.amazon.com/";
//    static ChromeDriver driver;
//    public static WebDriverWait webDriverWait;
//
//    @Before
//    public void beforeClass(){
//        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get(website);
//    }
//    @Test
//    public void testProductSearch3(){
//        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//        driver.manage().window().maximize();
//        driver.get(website);
//        WebElement searchBox;
//        driver.findElement(By.className("nav-search-scope")).click();
//        WebElement searchButton = driver.findElement(By.id("searchDropdownBox"));
//        driver.quit();
//    }
//    @After
//    public void afterClass() {
//
//    }
//
//}

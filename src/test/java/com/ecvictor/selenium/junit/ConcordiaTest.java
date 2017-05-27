package com.ecvictor.selenium.junit;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

public class ConcordiaTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //chose driver type
        String os = (System.getProperty("os.name"));

        if (os.equalsIgnoreCase("Mac OS X"))
            System.setProperty("webdriver.chrome.driver", "/Users/jeanneluo/Documents/workspace/selenium_related/chromedriver");
        else System.setProperty("webdriver.chrome.driver", "/Users/jeanneluo/Documents/workspace/selenium_related/chromedriverchromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--kiosk");
        driver = new ChromeDriver(chromeOptions);
        baseUrl = "https://www.concordia.ca/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void AcademicsTest() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath(".//*[@id='main-navbar']/div/div/ul/li[2]/a")).click();

        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //implicit wait
        //Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 3); //explicit wait
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='content-main']/div/div/div[2]/div[1]/div/h1")));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

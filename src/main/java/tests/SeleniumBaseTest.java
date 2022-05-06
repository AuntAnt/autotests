package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;

import java.time.Duration;

/**
 * Base test for UI Selenium
 */
@Log4j2
public abstract class SeleniumBaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        log.info("WebDriver initializing");
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        BasePage.setDriver(driver);
    }

    @AfterSuite
    public void tearDown() {
        log.info("Close browser and WebDriver");
        driver.close();
        driver.quit();
    }
}

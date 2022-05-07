package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Base page for initializing driver and elements
 */
public abstract class BasePage {

    protected static WebDriver driver;

    protected BasePage() {
        PageFactory.initElements(driver, this);
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    /**
     * Wait util some text appears in element
     *
     * @param element - DOM element in which the text is expected to appear
     */
    protected void waitTillTextAppears(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(x -> x.findElement(element).getText().length() != 0);
    }

    /**
     * Checking by title that the expected page is open
     *
     * @param expectedTitle expected page title
     * @return is expected page open or not
     */
    protected boolean atPage(String expectedTitle) {
        return driver.getTitle().equals(expectedTitle);
    }
}

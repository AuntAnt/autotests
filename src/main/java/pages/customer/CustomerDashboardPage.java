package pages.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class CustomerDashboardPage extends BasePage {

    private static final String NAME_XPATH = "//strong[@style='text-transform:capitalize']";

    @FindBy(xpath = NAME_XPATH)
    private WebElement name;

    @FindBy(css = ".author__meta")
    private WebElement greeting;

    public CustomerDashboardPage() {
        waitTillTextAppears(By.xpath(NAME_XPATH));
    }

    public String getUserName() {
        return name.getText();
    }

    public String getGreetingText() {
        return greeting.getText();
    }
}

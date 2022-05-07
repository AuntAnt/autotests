package pages.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class CustomerDashboardPage extends BasePage {

    private static final String USER_NAME_XPATH = "//strong[@style='text-transform:capitalize']";

    @FindBy(xpath = USER_NAME_XPATH)
    private WebElement name;

    @FindBy(css = ".author__meta")
    private WebElement greeting;

    public CustomerDashboardPage() {
        if (atPage("Dashboard - PHPTRAVELS")) {
            waitTillTextAppears(By.xpath(USER_NAME_XPATH));
        } else
            throw new IllegalStateException("Dashboard page is not open");
    }

    public String getUserName() {
        return name.getText();
    }

    public String getGreetingText() {
        return greeting.getText();
    }
}

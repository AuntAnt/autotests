package pages.customer;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class CustomerDashboardPage extends BasePage {

    private static final String TITLE = "Dashboard - PHPTRAVELS";

    private static final String USER_NAME_XPATH = "//strong[@style='text-transform:capitalize']";

    @FindBy(xpath = USER_NAME_XPATH)
    private WebElement name;

    @FindBy(css = ".author__meta")
    private WebElement greeting;

    @FindBy(xpath = "//i[@class='la la-power-off mr-2 text-color-6']")
    private WebElement logout;

    public CustomerDashboardPage() {
        if (atPage(TITLE)) {
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

    @Step("User logout")
    public CustomerLoginPage logOut() {
        logout.click();
        return new CustomerLoginPage();
    }
}

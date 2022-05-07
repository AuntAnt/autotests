package pages.customer;

import data.User;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.Set;

public class CustomerLoginPage extends BasePage {

    private static final String TITLE = "Login - PHPTRAVELS";

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement email;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;

    public CustomerLoginPage() {
        String currentTab = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();

        for (String tab : tabs) {
            if (!currentTab.equals(tab)) {
                driver.close();
                driver.switchTo().window(tab);
            }
        }
    }

    @Step("Enter user credentials {user}")
    public CustomerDashboardPage logIn(User user) {
        if (atPage(TITLE)) {
            email.sendKeys(user.getLogin());
            password.sendKeys(user.getPassword(), Keys.ENTER);
            return new CustomerDashboardPage();
        } else
            throw new IllegalStateException("Login page is not open");

    }
}

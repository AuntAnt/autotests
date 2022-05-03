package pages.customer;

import data.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.Set;

public class CustomerLoginPage extends BasePage {

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

    public CustomerDashboardPage logIn(User user) {
        email.sendKeys(user.getLogin());
        password.sendKeys(user.getPassword(), Keys.ENTER);
        return new CustomerDashboardPage();
    }
}

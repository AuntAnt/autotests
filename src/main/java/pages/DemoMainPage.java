package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.customer.CustomerLoginPage;
import utils.ConfReader;

public class DemoMainPage extends BasePage {

    @FindBy(xpath = "//*[strong='Customer']/ancestor::div[@class='col-md-8']//a")
    private WebElement customerLoginButton;

    @FindBy(xpath = "//*[strong='Admin']/ancestor::div[@class='col-md-8']//a")
    private WebElement adminLoginButton;

    public DemoMainPage() {
        driver.get(ConfReader.getUrl());
    }

    @Step("Click on login button")
    public CustomerLoginPage customerLogin() {
        customerLoginButton.click();
        return new CustomerLoginPage();
    }
}

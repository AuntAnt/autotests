package pages.system;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class NotFoundPage extends BasePage {

    private static final String ERROR_XPATH = "//h1[@class='animated fadeInDown']//strong";

    @FindBy(xpath = ERROR_XPATH)
    private WebElement error;

    @FindBy(xpath = "//p[@class='animated fadeInDown']")
    private WebElement message;

    @FindBy(xpath = "//a[@class='btn btn-outline-primary waves-effect']")
    private WebElement backToHomeButton;

    public NotFoundPage() {
        waitTillTextAppears(By.xpath(ERROR_XPATH));
    }

    public String getError() {
        return error.getText();
    }

    public String getMessage() {
        return message.getText();
    }

    public String getBackToHomeButton() {
        return backToHomeButton.getText();
    }
}

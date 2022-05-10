package tests;

import data.User;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.DemoMainPage;
import pages.customer.CustomerDashboardPage;
import pages.system.NotFoundPage;

/**
 * Test for users login
 */
@Log4j2
public class LoginTest extends SeleniumBaseTest {

    private static final String USER_NAME = "Demo";
    private static final String GREETING = "Welcome Back";
    private static final String NOT_FOUND = "404 Error";
    private static final String MESSAGE_TEXT = "Page not Found";
    private static final String BUTTON_MESSAGE = "Back to Home";

    private CustomerDashboardPage customerDashboardPage;

    @Test(description = "Login as customer positive test")
    public void customerLoginTest() {
        log.info("Login as customer and check name and greeting message");
        customerDashboardPage = new DemoMainPage().customerLogin().logIn(User.CUSTOMER);

        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(customerDashboardPage.getUserName())
                    .describedAs("Checking user name")
                    .isEqualTo(USER_NAME);

            softAssertions.assertThat(customerDashboardPage.getGreetingText())
                    .describedAs("Checking greeting message")
                    .isEqualTo(GREETING);
        });
    }

    @Test(dependsOnMethods = "customerLoginTest", description = "Logout and try to go back to dashboard page")
    public void customerLogOut() {
        log.info("User logout");
        customerDashboardPage.logOut();
        NotFoundPage notFoundPage = navigateBackToDashboard();

        SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(notFoundPage.getError())
                    .describedAs("Checking 404 error")
                    .isEqualTo(NOT_FOUND);

            softAssertions.assertThat(notFoundPage.getMessage())
                    .describedAs("Checking message text")
                    .isEqualTo(MESSAGE_TEXT);

            softAssertions.assertThat(notFoundPage.getBackToHomeButton())
                    .describedAs("Checking button text")
                    .isEqualTo(BUTTON_MESSAGE);
        });
    }

    @Step("Navigate browser back to dashboard page after logout")
    private NotFoundPage navigateBackToDashboard() {
        log.info("Navigate browser back to dashboard page after logout");
        driver.navigate().back();
        return new NotFoundPage();
    }
}

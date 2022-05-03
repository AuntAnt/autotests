package tests;

import data.User;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.DemoMainPage;
import pages.customer.CustomerDashboardPage;

/**
 * Test for users login
 */
public class LoginTest extends SeleniumBaseTest {

    private static final String NAME = "Demo";

    @Test
    public void customerLoginTest() {
        CustomerDashboardPage customerDashboardPage = new DemoMainPage().customerLogin().logIn(User.CUSTOMER);

        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(driver.getCurrentUrl())
                    .describedAs("Checking that the dashboard page is open")
                    .contains("/account/dashboard");

            softAssertions.assertThat(customerDashboardPage.getUserName())
                    .describedAs("Checking user name")
                    .isEqualTo(NAME);

            softAssertions.assertThat(customerDashboardPage.getGreetingText())
                    .describedAs("Checking greeting message")
                    .isEqualTo("Welcome Back");
        });
    }
}

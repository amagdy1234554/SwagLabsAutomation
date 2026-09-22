package stepdefinitions;

import Pages.HomePage.HomePageHelper;
import Pages.LoginPage.LoginPageHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Assertions;

public class LogoutSteps {
    private final HomePageHelper homePage = new HomePageHelper();
    private final LoginPageHelper loginPage = new LoginPageHelper();
    private final Assertions assertions = new Assertions();

    @When("User logout from the application")
    public void logout() {
        homePage.logout();
    }

    @Then("the login page should be displayed after logout")
    public void verifyLogout() {
        assertions.assertTrue(loginPage.isLoginPageDisplayed(),
                "Login page should be displayed after logout");
    }

    @When("User login again with username {string} and password {string}")
    public void loginAgain(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("the cart should be empty after a fresh login")
    public void cartEmptyAfterLogin() {
        assertions.assertTrue(homePage.getCartCount() == 0,
                "SauceDemo should have an empty cart after a new login session");
    }
}

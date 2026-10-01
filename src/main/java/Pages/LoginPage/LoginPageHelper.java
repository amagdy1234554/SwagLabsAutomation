package Pages.LoginPage;

import org.testng.Assert;
import utils.*;
import org.openqa.selenium.WebDriver;

public class LoginPageHelper extends Actions {
    private final LoginPageElement loginPageElement;

    public LoginPageHelper(WebDriver driver) {
        super(driver);
        loginPageElement = new LoginPageElement();
    }

    public void logInCredentials(String username, String password) {
        fillUsernameTextField(username);
        fillPasswordTextField(password);
        clickSignInBtn();
    }

    public void logInEmptyUsername() {
        fillUsernameTextField("");
        fillPasswordTextField("secret_sauce");
        clickSignInBtn();
    }

    public void logInEmptyPassword() {
        fillUsernameTextField("standard_user");
        fillPasswordTextField("");
        clickSignInBtn();
    }

    public void logInEmptyUsernameAndPassword() {
        fillUsernameTextField("");
        fillPasswordTextField("");
        clickSignInBtn();
    }

    public void assertErrorMessageWithInvalidCredentials() {
        waitForElementVis(loginPageElement.errorMessage);
        String errorMessage = getMessage(loginPageElement.errorMessage);
        Assert.assertTrue(errorMessage.contains("Username and password do not match"));
    }
    public void assertErrorMessageWithEmptyUsername() {
        waitForElementVis(loginPageElement.errorMessage);
        String errorMessage = getMessage(loginPageElement.errorMessage);
        Assert.assertTrue(errorMessage.contains("Username is required"));
    }
    public void assertErrorMessageWithEmptyPassword() {
        waitForElementVis(loginPageElement.errorMessage);
        String errorMessage = getMessage(loginPageElement.errorMessage);
        Assert.assertTrue(errorMessage.contains("Password is required"));
    }

    private void fillUsernameTextField(String value) {
        waitForElementVis(loginPageElement.userName);
        fillElement(loginPageElement.userName, value);
    }

    private void fillPasswordTextField(String value) {
        waitForElementVis(loginPageElement.password);
        fillElement(loginPageElement.password, value);
    }

    private void clickSignInBtn() {
        waitForElementClick(loginPageElement.loginButton);
        clickElement(loginPageElement.loginButton);
    }
}


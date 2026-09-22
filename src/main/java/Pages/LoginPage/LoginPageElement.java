package Pages.LoginPage;

import org.openqa.selenium.By;

public class LoginPageElement {
    By userName = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.xpath("//*[@role=\"alert\" and @data-test=\"error\"]");
}

package Pages.LoginPage;

import utils.Actions;

public class LoginPageHelper extends LoginPageElement {
    private final Actions actions;
    public LoginPageHelper() {
        this.actions = new Actions();
    }
    public void enterValidUserName(String validUsername) {
        actions.fillText(userName,validUsername);
    }
    public void enterValidPassword(String validPassword) {
        actions.fillText(password,validPassword);
    }
    public void clickLoginButton() {
        actions.click(loginButton);
    }
    public void login(String username, String password) {
        enterValidUserName(username);
        enterValidPassword(password);
        clickLoginButton();
    }
    public String getErrorMessage() {
        return actions.getText(errorMessage);
    }
    public boolean isLoginPageDisplayed() {
        return !actions.findElements(loginButton).isEmpty();
    }
}

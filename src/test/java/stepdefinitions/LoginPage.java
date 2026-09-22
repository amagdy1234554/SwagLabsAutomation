package stepdefinitions;

import Pages.HomePage.HomePageHelper;
import Pages.LoginPage.LoginPageHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Actions;
import utils.Assertions;

public class LoginPage extends Actions {
    private final LoginPageHelper loginPageHelper = new LoginPageHelper();
    private final HomePageHelper homePageHelper = new HomePageHelper();
    private final Assertions assertions = new Assertions();

    @Given("User open the Swag Labs website")
    public void iOpenTheSwagLabsWebsite() {
        openWebSite();
    }
    @When("User Enter Valid Username {string}")
    public void userEnterValidUsername(String username){
        loginPageHelper.enterValidUserName(username);
    }
    @And("User Enter Valid Password {string}")
    public void userEnterValidPassword(String password){
        loginPageHelper.enterValidPassword(password);
    }
    @Then("User Click Login Button")
    public void userClickLoginButton(){
        loginPageHelper.clickLoginButton();
    }
    @Then("Verify Inventory Container Loaded")
    public void verifyInventoryContainerLoaded(){
        homePageHelper.isInventoryDisplayed();
    }
    @Then("User Login with Invalid Username {string} Invalid Password {string}")
    public void userLoginWithInvalidCredential(String username, String password){
        loginPageHelper.login(username, password);
    }
    @Then("the login error message should be displayed")
    public void loginErrorDisplayed() {
        assertions.assertTrue(loginPageHelper.getErrorMessage().contains("Username and password do not match"),
                "Expected invalid credentials error message");
    }
    @Then("the Inventory page should be displayed")
    public void inventoryDisplayed() {
        assertions.assertTrue(homePageHelper.isInventoryDisplayed(),
                "Inventory page should be displayed after successful login");
    }
}

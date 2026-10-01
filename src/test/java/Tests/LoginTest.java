package Tests;

import DriverFactory.BaseTest;
import org.testng.annotations.Test;
import javax.swing.*;
public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials(){
        loginPageHelper.logInCredentials("standard_user","secret_sauce");
        inventoryPageHelper.assertInventoryPageTitle();
    }
    @Test
    public void loginWithInvalidUsername(){
        loginPageHelper.logInCredentials("ASDF","secret_sauce");
        loginPageHelper.assertErrorMessageWithInvalidCredentials();
    }
    @Test
    public void loginWithInvalidPassword(){
        loginPageHelper.logInCredentials("standard_user","ASDF");
        loginPageHelper.assertErrorMessageWithInvalidCredentials();
    }
    @Test
    public void loginWithEmptyUsername(){
        loginPageHelper.logInEmptyUsername();
        loginPageHelper.assertErrorMessageWithEmptyUsername();
    }
    @Test
    public void loginWithEmptyPassword(){
        loginPageHelper.logInEmptyPassword();
        loginPageHelper.assertErrorMessageWithEmptyPassword();
    }
    @Test
    public void loginWithEmptyUsernameAndEmptyPassword(){
        loginPageHelper.logInEmptyUsernameAndPassword();
        loginPageHelper.assertErrorMessageWithEmptyUsername();
    }
}
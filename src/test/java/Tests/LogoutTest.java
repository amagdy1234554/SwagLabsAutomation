package Tests;

import DriverFactory.BaseTest;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void verifyCanLogout(){
        loginPageHelper.logInCredentials("standard_user","secret_sauce");
        inventoryPageHelper.assertInventoryPageTitle();
        inventoryPageHelper.clickMenu();
        inventoryPageHelper.clickLogOut();
    }
}

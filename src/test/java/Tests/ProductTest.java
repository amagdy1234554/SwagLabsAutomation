package Tests;

import DriverFactory.BaseTest;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test
    public void VerifyProductDetails() {
        loginPageHelper.logInCredentials("standard_user","secret_sauce");
        inventoryPageHelper.opedProduct();
        productPageHelper.assertProductNameDisplayed();
        productPageHelper.assertProductPriceDisplayed();
        productPageHelper.assertProductDesDisplayed();
        productPageHelper.clickBackButton();
        inventoryPageHelper.assertInventoryPageTitle();
    }
}

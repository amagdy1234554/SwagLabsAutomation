package Tests;

import DriverFactory.BaseTest;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void verifyNumberOfCartItems() {
        loginPageHelper.logInCredentials("standard_user","secret_sauce");
        inventoryPageHelper.clickAddToCartBtnForTwoProducts();
        inventoryPageHelper.clickCartBtn();
        cartPageHelper.assertNumberOfItemsInCart(2);
        cartPageHelper.assertSumProductPriceCorrect();
        cartPageHelper.clickRemoveFromCartButton();
        cartPageHelper.assertNumberOfItemsInCart(1);
    }
    @Test
    public void verifyCanNavigateToInventoryPage(){
        loginPageHelper.logInCredentials("standard_user","secret_sauce");
        inventoryPageHelper.clickCartBtn();
        cartPageHelper.clickContinueShoppingButton();
        inventoryPageHelper.assertInventoryPageTitle();
    }
}

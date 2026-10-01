package Tests;

import DriverFactory.BaseTest;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {

    @Test
    public void verifyProductsIsDisplayed(){
        loginPageHelper.logInCredentials("standard_user","secret_sauce");
        inventoryPageHelper.assertInventoryPageTitle();
        inventoryPageHelper.assertProductNameIsDisplayed();
        inventoryPageHelper.assertProductNameNotEmpty();
        inventoryPageHelper.assertProductPriceIsDisplayed();
        inventoryPageHelper.assertProductPriceNotEmpty();
    }
    @Test
    public void verifyProductsNameSortedFromAToZ(){
        loginPageHelper.logInCredentials("standard_user","secret_sauce");
        inventoryPageHelper.clickSelectDropdown();
        inventoryPageHelper.selectNameFromAToZ();
        inventoryPageHelper.assertProductSortByName();
    }
    @Test
    public void verifyProductsPriceSortedFromLowToHigh(){
        loginPageHelper.logInCredentials("standard_user","secret_sauce");
        inventoryPageHelper.clickSelectDropdown();
        inventoryPageHelper.selectPriceFromLowToHigh();
        inventoryPageHelper.assertProductSortByPrice();
    }
    @Test
    public void verifyCartStateDuringNavigation(){
        loginPageHelper.logInCredentials("standard_user","secret_sauce");
        inventoryPageHelper.clickAddToCartBtnForTwoProducts();
        inventoryPageHelper.clickCartBtn();
        cartPageHelper.clickContinueShoppingButton();
        inventoryPageHelper.clickMenu();
        inventoryPageHelper.clickLogOut();
        loginPageHelper.logInCredentials("standard_user","secret_sauce");
    }
}

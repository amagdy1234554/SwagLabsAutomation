package Tests;

import DriverFactory.BaseTest;
import org.testng.annotations.Test;

public class OverviewTest extends BaseTest {

    @Test
    public void verifyCanCompleteOrder(){
        loginPageHelper.logInCredentials("standard_user","secret_sauce");
        inventoryPageHelper.clickAddToCartBtnForTwoProducts();
        inventoryPageHelper.clickCartBtn();
        cartPageHelper.assertSumProductPriceCorrect();
        cartPageHelper.clickCheckOutButton();
        checkoutPageHelper.enterValidCustomerInformation("Ahmed","Magdy","13757");
        checkoutPageHelper.clickContinueBtn();
        overviewPageHelper.assertSubTotalCorrect();
        overviewPageHelper.assertTaxNotEmpty();
        overviewPageHelper.assertTotalPriceNotEmpty();
        overviewPageHelper.clickFinishBtn();
        overviewPageHelper.assertCompleteOrderCorrect();
    }
}

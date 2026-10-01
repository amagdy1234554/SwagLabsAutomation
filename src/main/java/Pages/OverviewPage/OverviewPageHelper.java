package Pages.OverviewPage;

import Pages.CartPage.CartPageHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Actions;

public class OverviewPageHelper extends Actions {
    private final OverviewPageElement overviewPageElement;
    private final CartPageHelper cartPageHelper;

    public OverviewPageHelper(WebDriver driver) {
        super(driver);
        overviewPageElement = new OverviewPageElement();
        cartPageHelper = new CartPageHelper(driver);
    }
    public void clickFinishBtn() {
        clickElement(overviewPageElement.finishBtn);
    }
    public void assertSubTotalCorrect(){
        String subTotal = getMessage(overviewPageElement.itemSubTotal).replaceAll("[^0-9.]","");
        Assert.assertEquals(cartPageHelper.getSumOfTwoProductPrice(),Double.parseDouble(subTotal));
    }
    public void assertTaxNotEmpty(){
        String tax = getMessage(overviewPageElement.itemTax);
        Assert.assertFalse(tax.isEmpty());
    }
    public void assertTotalPriceNotEmpty(){
        String totalPrice = getMessage(overviewPageElement.itemTotal);
        Assert.assertFalse(totalPrice.isEmpty());
    }
    public void assertCompleteOrderCorrect(){
        waitForElementClick(overviewPageElement.completeOrder);
        String completeOrder = getMessage(overviewPageElement.completeOrder);
        Assert.assertTrue(completeOrder.contains("Thank you for your order!"));
    }
}

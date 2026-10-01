package Pages.CartPage;

import Pages.InventoryPage.InventoryPageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Actions;

import java.util.ArrayList;
import java.util.List;

public class CartPageHelper extends Actions {
    private final CartPageElement cartPageElement;
    private final InventoryPageHelper inventoryPageHelper;
    public Double sumPrice;

    public CartPageHelper(WebDriver driver) {
        super(driver);
        cartPageElement = new CartPageElement();
        inventoryPageHelper = new InventoryPageHelper(driver);
    }
    public int getCartItemCount() {
        waitForElementVis(cartPageElement.cartItemCount);
        List<WebElement> elements = findElements(cartPageElement.cartItemCount);
        return elements.size();
    }
    public void assertNumberOfItemsInCart(int numberOfItems) {
        Assert.assertEquals(getCartItemCount(), numberOfItems);
    }
    public void clickRemoveFromCartButton() {
        waitForElementClick(cartPageElement.removeBtn);
        List<WebElement> buttons = findElements(cartPageElement.removeBtn);
        buttons.get(0).click();
    }
    public void clickContinueShoppingButton() {
        waitForElementClick(cartPageElement.continueBtn);
        clickElement(cartPageElement.continueBtn);
    }
    public void clickCheckOutButton() {
        waitForElementClick(cartPageElement.checkOut);
        clickElement(cartPageElement.checkOut);
    }
    public Double getSumOfTwoProductPrice(){
        List<Double> values = new ArrayList<>();
        for (WebElement element :findElements(cartPageElement.productPrice)) {
            values.add(Double.parseDouble(element.getText().replace("$", "").trim()));
        }
        return sumPrice = values.get(0)+values.get(1);
    }
    public void assertSumProductPriceCorrect(){
        Assert.assertEquals(inventoryPageHelper.getSumOfTwoProductPrice(),getSumOfTwoProductPrice());
    }
}

package Pages.InventoryPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryPageHelper extends Actions {
    private final InventoryPageElement inventoryPageElement;
    public Double sumPrice;

    public InventoryPageHelper(WebDriver driver) {
        super(driver);
        inventoryPageElement = new InventoryPageElement();
    }
    public void assertInventoryPageTitle(){
        waitForElementVis(inventoryPageElement.pageTitle);
        String title = getMessage(inventoryPageElement.pageTitle);
        Assert.assertTrue(title.contains("Products"));
    }
    public void assertProductNameIsDisplayed(){
        Assert.assertTrue(waitForElementVis(inventoryPageElement.productName).isDisplayed());
    }
    public void assertProductPriceIsDisplayed() {
        Assert.assertTrue(waitForElementVis(inventoryPageElement.productPrice).isDisplayed());
    }
    public void assertProductNameNotEmpty(){
        String productName = getMessage(inventoryPageElement.productName);
        Assert.assertFalse(productName.isEmpty());
    }
    public void assertProductPriceNotEmpty(){
        String productPrice = getMessage(inventoryPageElement.productPrice);
        Assert.assertFalse(productPrice.isEmpty());
    }
    public void clickSelectDropdown(){
        clickElement(inventoryPageElement.sortDropDown);
    }
    public void selectNameFromAToZ(){
        new Select(waitForElementClick(inventoryPageElement.sortDropDown)).selectByVisibleText("Name (A to Z)");
    }
    public void selectPriceFromLowToHigh(){
        new Select(waitForElementClick(inventoryPageElement.sortDropDown)).selectByVisibleText("Price (low to high)");
    }
    public void assertProductSortByName(){
        List<String> values = new ArrayList<>();
        for (WebElement element : findElements(inventoryPageElement.productName)) {
            values.add(element.getText().trim());
        }
        List<String> sortedTextList = new ArrayList<>(values);
        Collections.sort(sortedTextList);
        Assert.assertEquals(sortedTextList, values);
    }
    public void assertProductSortByPrice(){
        List<Double> values = new ArrayList<>();
        for (WebElement element :findElements(inventoryPageElement.productPrice)) {
            values.add(Double.parseDouble(element.getText().replace("$", "").trim()));
        }
        List<Double> sortedPriceList = new ArrayList<>(values);
        Collections.sort(sortedPriceList);
        Assert.assertEquals(sortedPriceList, values);
    }
    public void opedProduct(){
        clickElement(inventoryPageElement.productName);
    }
    public void clickAddToCartBtnForTwoProducts(){
        waitForElementClick(inventoryPageElement.addToCartBtn);
        List<WebElement> buttons = findElements(inventoryPageElement.addToCartBtn);
        buttons.get(0).click();
        buttons.get(1).click();
    }
    public void clickCartBtn(){
        waitForElementClick(inventoryPageElement.cartBtn);
        clickElement(inventoryPageElement.cartBtn);
    }
    public Double getSumOfTwoProductPrice(){
        List<Double> values = new ArrayList<>();
        for (WebElement element :findElements(inventoryPageElement.productPrice)) {
            values.add(Double.parseDouble(element.getText().replace("$", "").trim()));
        }
        return sumPrice = values.get(0)+values.get(1);
    }
    public void clickMenu(){
        waitForElementClick(inventoryPageElement.menu);
        clickElement(inventoryPageElement.menu);
    }
    public void clickLogOut(){
        waitForElementClick(inventoryPageElement.logOut);
        clickElement(inventoryPageElement.logOut);
    }
}

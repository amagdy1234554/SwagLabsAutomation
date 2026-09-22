package Pages.HomePage;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Actions;
import utils.Assertions;

import java.util.ArrayList;
import java.util.List;

public class HomePageHelper extends HomePageElement{
    private Actions actions;

    public boolean isInventoryDisplayed() {
        return !actions.findElements(pageTitle).isEmpty()
                && actions.getText(pageTitle).equals("Swag Labs");
    }

    public List<String> getProductNames() {
        List<String> values = new ArrayList<>();
        for (WebElement element : actions.findElements(productName)) {
            values.add(element.getText().trim());
        }
        return values;
    }

    public List<Double> getProductPrices() {
        List<Double> values = new ArrayList<>();
        for (WebElement element : actions.findElements(productPrice)) {
            values.add(Double.parseDouble(element.getText().replace("$", "").trim()));
        }
        return values;
    }

    public void sort(String visibleText) {
        actions.selectByVisibleText(sortDropDown, visibleText);
    }

    public void openFirstProduct() {
        actions.click(productLink);
    }

    public void addProductByName(String productName) {
        String id = "add-to-cart-" + productName.toLowerCase()
                .replace(" ", "-");
        actions.click(By.id(id));
    }

    public void addFirstProduct() {
        actions.click(addFirstProduct);
    }

    public int getCartCount() {
        if (actions.findElements(cartCount).isEmpty()) {
            return 0;
        }
        return Integer.parseInt(actions.getText(cartCount));
    }

    public void openCart() {
        actions.click(clickCart);
    }

    public void logout() {
        actions.click(menu);
        actions.click(logOut);
    }

    public void navigateBackToInventory() {
        DriverFactory.getDriver().navigate().back();
        actions.waitForPageLoad(pageTitle);
    }
}

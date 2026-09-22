package Pages.CartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Actions;

import java.util.ArrayList;
import java.util.List;

public class CartPageHelper extends CartPageElement {
    private Actions actions;

    public List<String> getItemNames() {
        List<String> names = new ArrayList<>();
        for (WebElement element : actions.findElements(itemName)) {
            names.add(element.getText().trim());
        }
        return names;
    }

    public void removeProductByName(String productName) {
        String id = "remove-" + productName.toLowerCase()
                .replace(" ", "-");
        actions.click(By.id(id));
    }

    public void clickCheckout() {
        actions.click(checkOut);
    }
}

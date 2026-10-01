package Pages.CartPage;

import org.openqa.selenium.By;

public class CartPageElement {
    By cartItemCount = By.xpath("//*[@class=\"cart_item\"]");
    By removeBtn = By.xpath("//*[@class=\"btn btn_secondary btn_small cart_button\"]");
    By continueBtn = By.id("continue-shopping");
    By checkOut = By.id("checkout");
    By productPrice = By.xpath("//*[@class=\"inventory_item_price\"]");
}

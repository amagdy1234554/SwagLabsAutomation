package Pages.InventoryPage;

import org.openqa.selenium.By;

public class InventoryPageElement {
    By pageTitle = By.xpath("//*[@class=\"title\" and @data-test=\"title\"]");
    By productName = By.xpath("//*[@class=\"inventory_item_name \"]");
    By productPrice = By.xpath("//*[@class=\"inventory_item_price\"]");
    By sortDropDown = By.xpath("//*[@class=\"product_sort_container\"]");
    By addToCartBtn = By.xpath("//*[@class=\"btn btn_primary btn_small btn_inventory \"]");
    By cartBtn = By.xpath("//*[@class=\"shopping_cart_link\" and @ role=\"button\"]");
    By menu = By.id("react-burger-menu-btn");
    By logOut = By.id("logout_sidebar_link");
}

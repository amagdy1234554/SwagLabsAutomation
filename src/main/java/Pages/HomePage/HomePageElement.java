package Pages.HomePage;

import org.openqa.selenium.By;

public class HomePageElement {
    By pageTitle = By.xpath("//div[contains(text(),\"Swag Labs\")]");
    By productName = By.xpath("//*[@class=\"inventory_item_name \"]");
    By productPrice = By.xpath("//*[@class=\"inventory_item_price\"]");
    By sortDropDown = By.xpath("//*[@class=\"product_sort_container\"]");
    By productLink = By.id("item_2_title_link");
    By addFirstProduct = By.id("add-to-cart-sauce-labs-onesie");
    By cartCount = By.xpath("//*[@class=\"inventory_item\"]");
    By menu = By.id("react-burger-menu-btn");
    By logOut = By.id("logout_sidebar_link");
    By clickCart = By.xpath("//*[@class=\"shopping_cart_link\"]");
}

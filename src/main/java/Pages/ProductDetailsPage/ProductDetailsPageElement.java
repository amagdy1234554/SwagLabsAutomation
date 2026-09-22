package Pages.ProductDetailsPage;

import org.openqa.selenium.By;

public class ProductDetailsPageElement {
    By productName = By.xpath("//*[@class=\"inventory_details_name large_size\"]");
    By productDes = By.xpath("//*[@class=\"inventory_details_desc large_size\"]");
    By productPrice = By.xpath("//*[@class=\"inventory_details_price\"]");
    By backToProduct = By.id("back-to-products");
}

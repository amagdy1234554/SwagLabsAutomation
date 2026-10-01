package Pages.ProductPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Actions;

public class ProductPageHelper extends Actions {
    private final ProductPageElement productPageElement;

    public ProductPageHelper(WebDriver driver){
        super(driver);
        productPageElement = new ProductPageElement();
    }
    public void assertProductNameDisplayed(){
        Assert.assertTrue(waitForElementVis(productPageElement.productName).isDisplayed());
    }
    public void assertProductDesDisplayed(){
        Assert.assertTrue(waitForElementVis(productPageElement.productDes).isDisplayed());
    }
    public void assertProductPriceDisplayed(){
        Assert.assertTrue(waitForElementVis(productPageElement.productPrice).isDisplayed());
    }
    public void clickBackButton(){
        waitForElementClick(productPageElement.backBtn);
        clickElement(productPageElement.backBtn);
    }
}

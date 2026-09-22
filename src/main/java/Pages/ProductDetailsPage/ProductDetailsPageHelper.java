package Pages.ProductDetailsPage;

import utils.Actions;

public class ProductDetailsPageHelper extends  ProductDetailsPageElement{
    private Actions actions;

    public String getName() {
        return actions.getText(productName);
    }

    public String getPrice() {
        return actions.getText(productPrice);
    }

    public String getDescription() {
        return actions.getText(productDes);
    }

    public void backToProducts() {
        actions.click(backToProduct);
    }
}

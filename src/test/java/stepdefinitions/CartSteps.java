package stepdefinitions;

import Pages.CartPage.CartPageHelper;
import Pages.HomePage.HomePageHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Assertions;

import java.util.List;

public class CartSteps {
    private final HomePageHelper homePage = new HomePageHelper();
    private final CartPageHelper cartPage = new CartPageHelper();
    private String firstProduct;
    private String secondProduct;
    private final Assertions assertions = new Assertions();

    @When("User add two different products to the cart")
    public void addTwoProducts() {
        List<String> products = homePage.getProductNames();
        firstProduct = products.get(0);
        secondProduct = products.get(1);
        homePage.addProductByName(firstProduct);
        homePage.addProductByName(secondProduct);
    }

    @Then("the cart should contain the two selected products")
    public void cartContainsTwo() {
        homePage.openCart();
        List<String> items = cartPage.getItemNames();
        assertions.assertTrue(items.contains(firstProduct), "First product should be in cart");
        assertions.assertTrue(items.contains(secondProduct), "Second product should be in cart");
    }

    @When("User remove the first selected product")
    public void removeFirstProduct() {
        cartPage.removeProductByName(firstProduct);
    }

    @Then("the remaining product and cart count should be correct")
    public void verifyRemainingProductAndCount() {
        assertions.assertEquals(cartPage.getItemNames().size(), 1,
                "Exactly one product should remain");
        assertions.assertTrue(cartPage.getItemNames().contains(secondProduct),
                "Second product should remain");
        homePage.navigateBackToInventory();
        assertions.assertEquals(homePage.getCartCount(), 1,
                "Cart badge should show one item");
    }

    @When("User add the first product to the cart")
    public void addFirstProduct() {
        firstProduct = homePage.getProductNames().get(0);
        homePage.addProductByName(firstProduct);
    }

    @When("User navigate between Inventory and Cart")
    public void navigateInventoryAndCart() {
        homePage.openCart();
        assertions.assertTrue(cartPage.getItemNames().contains(firstProduct),
                "Selected product should remain in cart");
        homePage.navigateBackToInventory();
    }

    @Then("the selected product should remain in the cart")
    public void selectedProductRemains() {
        homePage.openCart();
        assertions.assertTrue(cartPage.getItemNames().contains(firstProduct),
                "Selected product should remain after navigation");
    }
}

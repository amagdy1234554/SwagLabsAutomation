package stepdefinitions;

import Pages.HomePage.HomePageHelper;
import Pages.ProductDetailsPage.ProductDetailsPageHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventorySteps {
    private final HomePageHelper homePage = new HomePageHelper();
    private final ProductDetailsPageHelper productDetailsPage = new ProductDetailsPageHelper();
    private List<String> namesBeforeDetails;
    private String selectedProductName;
    private final Assertions assertions = new Assertions();

    @Then("products should be displayed with names and prices")
    public void productsDisplayed() {
        assertions.assertTrue(!homePage.getProductNames().isEmpty(), "Products should be displayed");
        assertions.assertTrue(!homePage.getProductPrices().isEmpty(), "Product prices should be displayed");
        assertions.assertEquals(homePage.getProductNames().size(), homePage.getProductPrices().size(),
                "Each product should have a name and price");
    }

    @When("User select inventory sort {string}")
    public void selectSort(String sort) {
        homePage.sort(sort);
    }

    @Then("products should be sorted by name ascending")
    public void nameAscending() {
        List<String> actual = homePage.getProductNames();
        List<String> expected = new ArrayList<>(actual);
        Collections.sort(expected);
        assertions.assertEquals(actual, expected, "Products are not sorted A-Z");
    }

    @Then("products should be sorted by price ascending")
    public void priceAscending() {
        List<Double> actual = homePage.getProductPrices();
        List<Double> expected = new ArrayList<>(actual);
        Collections.sort(expected);
        assertions.assertEquals(actual, expected, "Products are not sorted low-high");
    }

    @Then("products should be sorted by name descending")
    public void nameDescending() {
        List<String> actual = homePage.getProductNames();
        List<String> expected = new ArrayList<>(actual);
        expected.sort(Collections.reverseOrder());
        assertions.assertEquals(actual, expected, "Products are not sorted Z-A");
    }

    @Then("products should be sorted by price descending")
    public void priceDescending() {
        List<Double> actual = homePage.getProductPrices();
        List<Double> expected = new ArrayList<>(actual);
        expected.sort(Collections.reverseOrder());
        assertions.assertEquals(actual, expected, "Products are not sorted high-low");
    }

    @When("User open the first product")
    public void openFirstProduct() {
        namesBeforeDetails = homePage.getProductNames();
        selectedProductName = namesBeforeDetails.get(0);
        homePage.openFirstProduct();
    }

    @Then("the product details should contain a name, price, and description")
    public void productDetailsDisplayed() {
        assertions.assertEquals(productDetailsPage.getName(), selectedProductName,
                "Product detail name should match selected product");
        assertions.assertTrue(!productDetailsPage.getPrice().isBlank(), "Product price should be displayed");
        assertions.assertTrue(!productDetailsPage.getDescription().isBlank(), "Product description should be displayed");
    }

    @When("User return to the Inventory page")
    public void returnToInventory() {
        productDetailsPage.backToProducts();
    }

    @Then("the Inventory page should be displayed again")
    public void inventoryDisplayedAgain() {
        assertions.assertTrue(homePage.isInventoryDisplayed(),
                "Inventory page should be displayed after returning");
    }
}

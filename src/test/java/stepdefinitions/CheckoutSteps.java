package stepdefinitions;

import Pages.CartPage.CartPageHelper;
import Pages.CheckoutPage.CheckoutPageHelper;
import Pages.HomePage.HomePageHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Assertions;

public class CheckoutSteps {
    private final HomePageHelper homePage = new HomePageHelper();
    private final CartPageHelper cartPage = new CartPageHelper();
    private final CheckoutPageHelper checkoutPage = new CheckoutPageHelper();
    private final Assertions assertions = new Assertions();

    @When("User add a product and open Checkout")
    public void addAndCheckout() {
        homePage.addFirstProduct();
        homePage.openCart();
        cartPage.clickCheckout();
    }

    @When("User enter checkout customer information {string}, {string}, {string}")
    public void enterCustomerInfo(String firstName, String lastName, String postalCode) {
        checkoutPage.enterCustomerInfo(firstName, lastName, postalCode);
        checkoutPage.continueCheckout();
    }

    @Then("the checkout Overview should display one selected product")
    public void verifyOverviewProduct() {
        assertions.assertEquals(checkoutPage.getSummaryItemCount(), 1,
                "Overview should contain one selected product");
    }

    @Then("the checkout totals should contain subtotal, tax, and total")
    public void verifyTotals() {
        assertions.assertTrue(checkoutPage.getSubtotal().startsWith("Item total:"),
                "Subtotal should be displayed");
        assertions.assertTrue(checkoutPage.getTax().startsWith("Tax:"),
                "Tax should be displayed");
        assertions.assertTrue(checkoutPage.getTotal().startsWith("Total:"),
                "Total should be displayed");
    }

    @When("User finish the order")
    public void finishOrder() {
        checkoutPage.finish();
    }

    @Then("the order confirmation should be displayed")
    public void orderConfirmation() {
        assertions.assertEquals(checkoutPage.getConfirmationMessage(),
                "Thank you for your order!", "Order confirmation should be displayed");
    }

    @When("User continue checkout without entering customer information")
    public void continueWithoutInfo() {
        homePage.addFirstProduct();
        homePage.openCart();
        cartPage.clickCheckout();
        checkoutPage.continueCheckout();
    }

    @Then("the checkout required field error should be displayed")
    public void requiredFieldError() {
        assertions.assertTrue(checkoutPage.getErrorMessage().contains("First Name is required"),
                "First Name required validation should be displayed");
    }
}

@checkout
Feature: End to end checkout

  Background:
    Given User open the Swag Labs website
    Then User Enter Valid Username "standard_user"
    Then User Enter Valid Password "secret_sauce"
    And User Click Login Button
    Then the Inventory page should be displayed

  @smoke @positive
  Scenario: Complete an order successfully
    When User add a product and open Checkout
    And User enter checkout customer information "Ahmed", "Magdy", "12345"
    Then the checkout Overview should display one selected product
    And the checkout totals should contain subtotal, tax, and total
    When User finish the order
    Then the order confirmation should be displayed

  @negative
  Scenario: Checkout with missing required customer information
    When User continue checkout without entering customer information
    Then the checkout required field error should be displayed

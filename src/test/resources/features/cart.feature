@cart
Feature: Shopping cart

  Background:
    Given User open the Swag Labs website
    Then User Enter Valid Username "standard_user"
    Then User Enter Valid Password "secret_sauce"
    And User Click Login Button
    Then the Inventory page should be displayed

  @positive
  Scenario: Add two products and remove one
    When User add two different products to the cart
    Then the cart should contain the two selected products
    When User remove the first selected product
    Then the remaining product and cart count should be correct

  @positive
  Scenario: Cart state remains while navigating between Inventory and Cart
    When User add the first product to the cart
    And User navigate between Inventory and Cart
    Then the selected product should remain in the cart

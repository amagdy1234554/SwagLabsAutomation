@inventory
Feature: Product inventory and sorting

  Background:
    Given User open the Swag Labs website
    Then User Enter Valid Username "standard_user"
    Then User Enter Valid Password "secret_sauce"
    And User Click Login Button
    Then the Inventory page should be displayed

  Scenario: Verify products and prices are displayed
    Then products should be displayed with names and prices

  Scenario: Sort products by Name A to Z
    When User select inventory sort "Name (A to Z)"
    Then products should be sorted by name ascending

  Scenario: Sort products by Name Z to A
    When User select inventory sort "Name (Z to A)"
    Then products should be sorted by name descending

  Scenario: Sort products by Price low to high
    When User select inventory sort "Price (low to high)"
    Then products should be sorted by price ascending

  Scenario: Sort products by Price high to low
    When User select inventory sort "Price (high to low)"
    Then products should be sorted by price descending

  Scenario: Open product details and return to inventory
    When User open the first product
    Then the product details should contain a name, price, and description
    When User return to the Inventory page
    Then the Inventory page should be displayed again

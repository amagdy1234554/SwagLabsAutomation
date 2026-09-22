@logout
Feature: Logout and session behavior

  Background:
    Given User open the Swag Labs website
    Then User Enter Valid Username "standard_user"
    Then User Enter Valid Password "secret_sauce"
    And User Click Login Button

  Scenario: Logout successfully
    And User logout from the application
    Then the login page should be displayed after logout

  Scenario: Verify cart behavior after logout and login again
    And User add the first product to the cart
    And User logout from the application
    And User login again with username "standard_user" and password "secret_sauce"
    Then the cart should be empty after a fresh login

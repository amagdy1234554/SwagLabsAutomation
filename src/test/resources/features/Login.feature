Feature: Open Website

  Scenario Outline: Login Valid
    Given User open the Swag Labs website
    When User Enter Valid Username "<UserName>"
    And User Enter Valid Password "<Password>"
    Then User Click Login Button
    Then Verify Inventory Container Loaded
    Examples:
      | UserName                | Password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

  Scenario Outline:  Login Invalid
    Given User open the Swag Labs website
    Then User Login with Invalid Username "<Username>" Invalid Password "<Password>"
    Then the login error message should be displayed
    Examples:
    |Username|Password|
    |ASDF    |QWEA    |
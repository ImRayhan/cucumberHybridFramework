Feature: Search functionality

  Scenario: User searches for valid product
    Given User opens application
    When User enters valid product "HP" into search box fiueld
    And User clicks on search button
    Then User should get valid product displayed ins earch result

  Scenario: User seaches for an invalid product
    Given User opens application
    When User enters invalid product "Honda" into search box field
    And User clicks on search button
    Then User should get a massage about no product matching

  Scenario: User Searches without any product
    Given User opens application
    When User dont enter any product name into search box field
    And User clicks on search button
    Then User should get a massage about no product matching

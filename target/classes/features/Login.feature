Feature: Login functionality

  Scenario Outline: Login with valid credentials
    Given User navigates to login page
    When User entered valid email adress "<Username>" into email field
    And User has entered valid password "<Password>" into password field
    And User clicks on login button
    Then User should get successfully logged in

    Examples: 
      | Username                    | Password       |
      | imrayhanc@gmail.com         | Aarayhan00     |
      | nurulamin05021960@yahoo.com | z@bUYsKLGAH2e2 |
      | ryhnchdhry1@gmail.com       | EfNkP7wAQbFr@e |

  Scenario: Login with invalid credentials
    Given User navigates to login page
    When User enters invalid email adress into email field
    And User enters invalid password "1234567890" into passwrod field
    And User clicks on login button
    Then User should get a proper warning massage about credintials mismatch

  Scenario: Login with valid email invalid password
    Given User navigates to login page
    When User entered valid email adress "imrayhanc@gmail.com" into email field
    And User enters invalid password "1234567890" into passwrod field
    And User clicks on login button
    Then User should get a proper warning massage about credintials mismatch

  Scenario: Login with invalid email and valid password
    Given User navigates to login page
    When User enters invalid email adress into email field
    And User has entered valid password "Aarayhan00" into password field
    And User clicks on login button
    Then User should get a proper warning massage about credintials mismatch

  Scenario: Login without providing any credentials
    Given User navigates to login page
    When User dont enter email adress into email field
    And User dont enter password into password field
    And User clicks on login button
    Then User should get a proper warning massage about credintials mismatch

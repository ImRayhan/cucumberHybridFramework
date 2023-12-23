Feature: Registration functionality

  Scenario: User creates an account only with mandatory fields
    Given User navigates to regester account page
    When User enters the below fields
      | firstName | Rayhan     |
      | Lastname  | chowdhury  |
      | telephone | 9294529947 |
      | password  |      12345 |
    And User selects privacy policy
    And User clicks on continue button
    Then User account should get created successfully

  Scenario: User creates an account with all fields
    Given User navigates to regester account page
    When User enters the below fields
      | firstName | Rayhan     |
      | Lastname  | chowdhury  |
      | telephone | 9294529947 |
      | password  |      12345 |
    And User selects yes for newslatter
    And User selects privacy policy
    And User clicks on continue button
    Then User account should get created successfully

  Scenario: User creates an duplicate account
    Given User navigates to regester account page
    When User enters the below fields with the duplicate email
      | firstName | Rayhan              |
      | Lastname  | chowdhury           |
      | email     | imrayhanc@yahoo.com |
      | telephone |          9294529947 |
      | password  |               12345 |
    And User selects yes for newslatter
    And User selects privacy policy
    And User clicks on continue button
    Then User should het a proper warning about duplicate email

  Scenario: User creats and accounts without filling any details
    Given User navigates to regester account page
    And User clicks on continue button
    Then User should get proper warning massage for ebery mandatory fields

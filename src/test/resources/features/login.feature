Feature: Login functionality

  @Regression @Smoke
  Scenario: Login with valid credentials
    Given user is on login page
    When user enters email "standard_user" and password "secret_sauce"
    And user clicks on login button
    Then user should be logged in successfully

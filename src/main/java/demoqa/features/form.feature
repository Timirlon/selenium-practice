@regression
Feature: Practice Form

  Scenario: Submit form with valid data
    Given user opens practice form page
    When user enters first name "John"
    And user enters last name "Doe"
    And user clicks submit
    Then form should be submitted successfully

  @smoke
  Scenario: Submit form with empty fields
    Given user opens practice form page
    When user clicks submit without entering data
    Then error message should be displayed

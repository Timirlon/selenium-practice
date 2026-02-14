Feature: Navigation

  Scenario: Open practice page
    Given user opens browser
    When user navigates to practice page
    Then page title should be displayed

  Scenario: Check input field interaction
    Given user opens practice form page
    When user enters first name "Test"
    Then input field should contain "Test"

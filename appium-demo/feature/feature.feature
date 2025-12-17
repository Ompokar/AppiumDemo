Feature: Appium demo

  Scenario: Validate controls page
    Given app is launched
    When user navigates to controls page
    Then controls are displayed correctly

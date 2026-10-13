Feature: Login functionality

  Background:
    Given user opens the login page

  Scenario: Valid login
    When user enters username "admin"
    And user enters password "admin123"
    And user clicks login
    Then user should see home page

  Scenario: Invalid login
    When user enters username "admin"
    And user enters password "wrong123"
    And user clicks login
    Then user should see error message
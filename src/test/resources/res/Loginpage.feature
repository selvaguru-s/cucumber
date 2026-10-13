Feature: Login functionality

  Scenario: Valid login
    Given User is on the Instagram login page
    When User enters username "your_username"
    And User enters password "your_password"
    And User clicks login button
    Then User should be logged in successfully

  Scenario Outline: Valid login with different users
    Given User is on the Instagram login page
    When User enters username "<username>"
    And User enters password "<password>"
    And User clicks login button
    Then User should be logged in successfully

    Examples:
      | username      | password      |
      | your_username | your_password |
      | test_user     | test_password |
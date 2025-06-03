Feature: Login functionality

  Scenario Outline: Valid login
    Given I am on the login page
    When I login with email "<email>" and password "<password>"
    Then I should be logged in

    Examples:
      | email              | password   |
      | test@example.com   | password123 |
      | user2@example.com  | pass456     |

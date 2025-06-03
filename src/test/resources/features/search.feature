Feature: Product search

  Scenario: User searches for a product
    Given I am on the Wiggle homepage
    When I search for "bike"
    Then I should see search results

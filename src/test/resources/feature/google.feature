Feature: Google Search

  Scenario: Search keyword on Google
    Given user opens google page
    When user searches "Playwright Java"
    Then search result should be displayed

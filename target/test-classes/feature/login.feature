Feature: Login
  Background: Open page
    Given user opens google page

  Scenario: Login by Admin
    When Navigate to the cms page
    And Input user admin
    And Input password
    And Click on login button
    Then Verify access to Dashboard page success
@HistoryTickets
Feature: Verify History Tickets

  Background: Login user and click on active day menu
    Given I have successfully logged in
    When I click on my tickets link
    Then I should see the history tickets option in the left account menu

  @SmokeTest
  Scenario: Verify ticket code is correct when I click on the first ticket details
    When I click on the first ticket details from the list
    Then I should see the correct ticket code in the pop-up displayed correctly

  Scenario: Verify ticket is deleted from the list when I delete the first one
    When I delete the first ticket from the list
    Then I should not see the ticket in the tickets history list
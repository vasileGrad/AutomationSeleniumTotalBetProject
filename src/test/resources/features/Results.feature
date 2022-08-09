Feature: Check event results

  Background: Login user and click on active day menu
    Given I have successfully logged in
    When I click on results menu
    Then I should see the active days menu

  @Results
  Scenario: Verify event results are correctly shown
    When I read the event results from the file
    Then I should have a list with all the event results

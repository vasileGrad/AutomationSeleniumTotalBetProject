@VerifyTicket
Feature: Verify tickets

  Background: Login user
    Given I have successfully logged in
    When I click on home menu
    And I click on search input ticket

  Scenario: Verify if a sports bet ticket code is correctly displayed
    When I fill in a valid ticket code
    And I click on verify ticket button
    Then Pop-up ticket should appear
    And I should see correctly the ticket code

  Scenario: Verify a sports bet ticket status
    When I fill in a valid ticket code
    And I click on verify ticket button
    Then Pop-up ticket should appear
    And I should see correctly the ticket status

  Scenario: Verify a sports bet ticket max win value
    When I fill in a valid ticket code
    And I click on verify ticket button
    Then Pop-up ticket should appear
    And I should see the ticket max win value is displayed

  Scenario: Verify a sports bet ticket details
    When I fill in a valid ticket code
    And I click on verify ticket button
    Then Pop-up ticket should appear
    And I should see the details of the ticket correctly

  Scenario: Verify search input ticket with no code
    When I click on verify ticket button
    Then An alert should appear with error message

  Scenario Outline: Verify search input ticket with no code
    When I fill in an invalid ticket code as <invalidCode>
    And I click on verify ticket button
    Then An alert should appear with error message

    Examples:
      | invalidCode |
      | 1234        |
      | aslkj1@@@lk |

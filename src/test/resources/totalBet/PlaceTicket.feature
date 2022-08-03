@placeTicket
Feature: Place tickets

  Background: Login user
    Given I click on login link
    When I fill in valid login email and password
    And I click on submit button
    Then I should see my profile page

  Scenario: As a registered user I want to place a sports bet ticket and I can verify that the correct number of tickets appear in the right list
    Given I am an authenticated user
    When I click on sports bet menu
    And I click on the current date
    And I choose Football sport
    And I click on the first ticket number
    And I place the sports bet ticket
    Then I should see the number of sports bet in the right list

  Scenario: As a registered user I want to place a sports bet ticket and I can delete all of them
    Given I am an authenticated user
    When I click on sports bet menu
    And I click on the current date
    And I choose Football sport
    And I click on the first ticket number
    And I place the sports bet ticket
    Then I should see the number of sports bet in the right list
    And I delete all the sports bet
    And I should not see the sports bet in the right list

  Scenario: As a registered user I want to place a sports bet ticket and I remove one of them
    Given I am an authenticated user
    When I click on sports bet menu
    And I click on the current date
    And I choose Football sport
    And I click on the first ticket number
    And I place the sports bet ticket
    Then I should see the number of sports bet in the right list
    And I remove the first ticket from the right list
    Then I should see the number of sports bet in the right list to be correct

  Scenario: As a registered user I want to place a sports bet ticket successfully
    Given I am an authenticated user
    When I click on sports bet menu
    And I click on the current date
    And I choose Football sport
    And I click on the first ticket number
    And I place the sports bet ticket
    Then I should see the number of sports bet in the right list
    And I successfully placed and saved the sports bet ticket

  Scenario: As a registered user I want to place a sports bet ticket and to verify the ticket data value
    Given I am an authenticated user
    When I click on sports bet menu
    And I click on the current date
    And I choose Football sport
    And I click on the first ticket number
    And I place the sports bet ticket
    Then I verify the sports bet ticket data value is calculated correctly

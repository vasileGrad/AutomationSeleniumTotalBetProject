
Feature: Verify tickets

  Background: Login user
    Given I click on login link
    When I fill in valid login email and password
    And I click on submit button
    Then I should see my profile page

  Scenario: As a registered user I want to verify a sports bet ticket code is correctly displayed
    Given I am an authenticated user
    When I click on home menu
    And I click on search input ticket
    And I fill in a valid sports bet ticket code
    And I click on verify ticket button
    And I wait for the pop-up to appear
    Then I should see correctly the ticket code

  Scenario: As a registered user I want to verify a sports bet ticket status
    Given I am an authenticated user
    When I click on home menu
    And I click on search input ticket
    And I fill in a valid sports bet ticket code
    And I click on verify ticket button
    And I wait for the pop-up to appear
    Then I should see correctly the ticket status

  Scenario: As a registered user I want to verify a sports bet ticket max win value
    Given I am an authenticated user
    When I click on home menu
    And I click on search input ticket
    And I fill in a valid sports bet ticket code
    And I click on verify ticket button
    And I wait for the pop-up to appear
    Then I should see the ticket max win value is displayed

  Scenario: As a registered user I want to verify a sports bet ticket max win value
    Given I am an authenticated user
    When I click on home menu
    And I click on search input ticket
    And I fill in a valid sports bet ticket code
    And I click on verify ticket button
    And I wait for the pop-up to appear
    Then I should see the details of the ticket correctly

  @verifyTicket
  Scenario: As a registered user I want to verify a sports bet ticket max win value
    Given I am an authenticated user
    When I click on home menu
    And I click on search input ticket
    And I fill in a valid sports bet ticket code
    And I click on verify ticket button
    And I wait for the pop-up to appear
    Then I should see the max win of the ticket correctly
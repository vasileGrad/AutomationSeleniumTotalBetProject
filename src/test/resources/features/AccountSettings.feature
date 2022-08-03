Feature: Account settings

  Background: Login user
    Given I click on login link
    When I fill in valid login email and password
    And I click on submit button
    Then I should see my profile page

  @AccountSettings
  Scenario: As a registered user I want to see my account settings page
    Given I am an authenticated user
    When I click on account settings link
    Then I should see the account settings page

  @AccountSettings
  Scenario: As a registered user I want to verify my profile details on my account settings page
    Given I am an authenticated user
    When I click on account settings link
    Then I should see the account settings page
    And I should have the same name and email

  @AccountSettings
  Scenario: As a registered user I want to change the phone number with a valid number on my account settings page
    Given I am an authenticated user
    When I click on account settings link
    And I change the phone number
    And I click on save modifications button
    Then I should see the phone number saved

  @Ignore
  Scenario: As a registered user I want to change the actual password with a new password my account settings page
    Given I am an authenticated user
    When I click on account settings link
    And I change the actual password with a new password
    And I click on save modifications button
    Then I should change successfully the new password

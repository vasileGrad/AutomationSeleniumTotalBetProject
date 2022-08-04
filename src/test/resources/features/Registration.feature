@Registration
Feature: Registration Form

  Scenario: As a user I want to register
    Given I click on registration link
    When I fill in registration form details
    Then I have successfully completed the registration

  Scenario: As a user I want to register with a registered user credentials
    Given I click on registration link
    When I fill in registration form details
    Then I receive a registration error message
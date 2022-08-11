@Registration
Feature: Registration Form

  Scenario: Register with valid credentials
    Given I click on registration link
    When I fill in registration form details
    Then I have successfully completed the registration

  Scenario: Register with a registered user credentials
    Given I click on registration link
    When I fill in registration form details
    Then I receive a registration error message
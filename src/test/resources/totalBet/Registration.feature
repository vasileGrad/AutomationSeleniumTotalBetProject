Feature: Registration Form

  @ignore
  Scenario: As a user I want to register
    Given I click on registration menu
    When I fill in registration form details
    Then I have successfully completed the registration

  Scenario: As a user I want to register with a registered user credentials
    Given I click on registration menu
    When I fill in registration form details
    Then I receive an error message
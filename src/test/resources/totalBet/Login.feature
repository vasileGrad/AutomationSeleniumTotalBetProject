@login
Feature: Login Form

  @ignore
  Scenario: As a user I want to login with valid email and password
    Given I click on login menu
    When I fill in valid login email and password
    Then I should see my profile page

  Scenario Outline: As a user I want to login with invalid email and password
    Given I click on login menu
    When I fill invalid email as <email> and valid password as <password>
    Then I should receive a login error message

    Examples:
      | email                  | password |
      | wrong.email1@gmail.com | Text1234 |
      | wrong.email2@gmail.com | Text1234 |
      | wrong.email3@gmail.com | Text1234 |

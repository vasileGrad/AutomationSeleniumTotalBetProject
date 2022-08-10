@Login
Feature: Login Form

  Scenario: As a user I want to login with valid email and password
    Given I click on login link
    When I fill in valid login email and password
    And I click on submit button
    Then I should see my profile page

  Scenario: As a user I want to login with valid email and password and to logout
    Given I click on login link
    When I fill in valid login email and password
    And I click on submit button
    And I should see my profile page
    And I should see logout button
    And I click on logout button
    Then I should see login link

  Scenario: As a user I want to login with empty email and password
    Given I click on login link
    When I click on submit button
    Then I should receive email and password error messages

  Scenario Outline: As a user I want to login with invalid email and valid password
    Given I click on login link
    When I fill invalid email as <email> and valid password as <password>
    And I click on submit button
    Then I should receive a login error message

    Examples:
      | email                  | password |
      | wrong.email1@gmail.com | Text1234 |
      | wrong.email2@gmail.com | Text1234 |

  Scenario Outline: As a user I want to login with email and invalid password
    Given I click on login link
    When I fill valid email as <email> and invalid password as <password>
    And I click on submit button
    Then I should receive a login error message

    Examples:
      | email                  | password |
      | dacekib883@altpano.com | 1234     |
      | dacekib883@altpano.com | 1234     |

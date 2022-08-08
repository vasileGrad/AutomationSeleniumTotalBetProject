
Feature: Place tickets

  Background: Login user and click on active day menu
    Given I have successfully logged in
    When I click on sports bet menu
    Then I should see the active days menu


  Scenario Outline: Create bet events and verify that the correct number of events appear in the ticket bets container
    When I click on the current date
    And I click on the first ticket button from the ticket selector
    And I choose sport title as <sportTitle>
    And I select the sports bet ticket options
    Then I should see correct number of events in the ticket bets container
    Examples:
      | sportTitle |
      | FOTBAL     |
      | TENIS      |

  @SportsBetTicket
  Scenario Outline: Create a sports bet ticket and verify the ticket data value is calculated correctly with valid bet input
    When I click on the current date
    And I click on the first ticket button from the ticket selector
    And I choose sport title as <sportTitle>
    And I select the sports bet ticket options
    And I insert a valid bet input as <betInput>
    Then I should see correct number of events in the ticket bets container
    And I verify the sports bet ticket data value is calculated correctly
    Examples:
      | sportTitle | betInput |
      | FOTBAL     | 100      |
      | FOTBAL     | 10       |

  Scenario Outline: Create a sports bet ticket and verify the ticket data value is calculated correctly with negative bet input
    When I click on the current date
    And I click on the first ticket button from the ticket selector
    And I choose sport title as <sportTitle>
    And I select the sports bet ticket options
    And I insert a negative bet input as <betInput>
    Then I should see correct number of events in the ticket bets container
    And I verify the sports bet ticket data value is calculated correctly
    Examples:
      | sportTitle | betInput |
      | FOTBAL     | -100     |

  Scenario Outline: Create a sports bet ticket and verify the ticket data value has NaN RON with input as text
    When I click on the current date
    And I click on the first ticket button from the ticket selector
    And I choose sport title as <sportTitle>
    And I select the sports bet ticket options
    And I insert in the bet input text as <betInput>
    Then I should see correct number of events in the ticket bets container
    And Max win value should be NaN RON
    Examples:
      | sportTitle | betInput |
      | FOTBAL     | abcd     |


  Scenario Outline: Create a sports bet ticket and verify the ticket data value has 0 RON with zero input value
    When I click on the current date
    And I click on the first ticket button from the ticket selector
    And I choose sport title as <sportTitle>
    And I select the sports bet ticket options
    And I insert input value as zero
    Then I should see correct number of events in the ticket bets container
    And Max win value should be 0 RON
    Examples:
      | sportTitle |
      | FOTBAL     |


  Scenario Outline: Delete all bet tickets from the ticket bets container after you create them
    When I click on the current date
    And I click on the first ticket button from the ticket selector
    And I choose sport title as <sportTitle>
    And I select the sports bet ticket options
    And I delete all the sports bet
    Then I should not see the events bet in the ticket bets container
    Examples:
      | sportTitle |
      | FOTBAL     |

  Scenario Outline: Create a sports bet events and remove one of them from the ticket bets container
    When I click on the current date
    And I click on the first ticket button from the ticket selector
    And I choose sport title as <sportTitle>
    And I select the sports bet ticket options
    And I remove the first event from the ticket bets container
    Then I should see correctly the number of sport events in the ticket bets container
    Examples:
      | sportTitle |
      | BASCHET    |

  Scenario Outline: Create and place a sports bet ticket successfully
    When I click on the current date
    And I click on the first ticket button from the ticket selector
    And I choose sport title as <sportTitle>
    And I select the sports bet ticket options
    Then I should see correct number of events in the ticket bets container
    And I successfully placed and saved the sports bet ticket
    Examples:
      | sportTitle |
      | FOTBAL     |
      | TENIS      |

Feature: User search in google

  Scenario Outline: User searchs a word in google
    Given browser is open
    And user is in google
    When user enters <word>
    And user press enter
    Then browser shows page

    Examples: 
      | word  |
      | covid |
      | dog   |
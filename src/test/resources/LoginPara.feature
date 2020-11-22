Feature: Test user login

  Scenario Outline: User logins with credentials
    Given user has an open browser
    And user is on login page
    When user inputs <username> and <password>
    And clicks on login
    Then user is in main page
    
    Examples:
    |username||password|
    |Jorge||12345|
    |Eloy||12345|

Feature: Login Functionality for OpenCart E-commerce Website.

  As a user of the OpenCart website
  I want to be able to log in my account.
  So that I can access my account related features and manage my orders.

  Background:
    Given I am on the OpenCart login page.

  Scenario: Successful Login with valid credentials.
    Given I have entered valid username and password
    When I click on the login button
    Then I should logged in successfully

  Scenario Outline: Unsuccessful login with Invalid or Empty credentials
    Given I have entered Invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"
    Examples:
      | username        | password   | error_message                                         |
      | invalid@abc.com | invalidpwd | Warning: No match for E-Mail Address and/or Password. |
      | abctest.com     | invalidpwd | Warning: No match for E-Mail Address and/or Password. |
      | test@gmail.com  | abcd       | Warning: No match for E-Mail Address and/or Password. |

  Scenario: Navigating to the forgot password page
    Given Forgot Password link is present on Account Login page
    When I click on the "Forgotten Password" link
    Then I should be redirected to password reset page

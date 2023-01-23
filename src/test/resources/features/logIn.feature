
@url
Feature:login_feature
  Background:user_goes_to_hudl

  @logIn @smoke
  Scenario Outline: logIn_with_valid_credentials
    Given user opens the URL "https://www.hudl.com"
    When user navigate the login page
    And user enters email as "<email>" and password as "<password>" and click on login button
    Then verify the login is successful
    And capture the screenshot
    Then close the application
    Examples: test_data
    |email                    |password|
    |aysekapancigil@gmail.com| Ayse1985|

   @invalidCredentials
   Scenario Outline:login_with_invalid_credentials
     Given users navigate the login page
     When users enter invalid "<email>" and "<password>" in search box
     Then verifies "We didn't recognize that email and/or password" message displayed
     Examples: test_data
     |email|password|
     |abcd@gmail.com|1234a|









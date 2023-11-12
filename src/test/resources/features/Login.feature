@login @regression
Feature: Login functionality - WebDriver University

  Background:
    Given I land on the WebDriver University Login page

  Scenario: Login with valid credentials
    When I enter username webdriver
    And I enter password webdriver123
    And I click on Submit button
    Then I get valid login message

  Scenario: Login with invalid credentials - invalid password
    When I enter username webdriver
    And I enter password webdriver
    And I click on Submit button
    Then I get invalid login message

  Scenario Outline: Login with invalid credentials
    When I enter username <username>
    And I enter password <password>
    And I click on Submit button
    Then I get login message "<loginValidationMessage>"
    Examples:
      | username         | password         | loginValidationMessage |
      | webdriver        | webdriverInvalid | validation failed      |
      | webdriverInvalid | webdriver123     | validation failed      |
      | webdriverInvalid | webdriverInvalid | validation failed      |
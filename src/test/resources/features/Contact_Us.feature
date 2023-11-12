@contact-us @regression
Feature: Contact Us Page - WebDriver University

  Background:
    Given I land on the WebDriver University Contact Us page

  @unique
  Scenario: Validate Successful Submission - Unique Data
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on submit button
    Then I should be presented with a successful contact us submission message

  Scenario: Validate Sucessful Submission - Specific Data
    When I enter a specific first name Novak
    And I enter a specific last name Djokovic
    And I enter a specific email address nolejoker@gmail.com
    And I enter a specific comment "Najbolji teniser sveta!"
    And I click on submit button
    Then I should be presented with a successful contact us submission message
@ajax @regression
Feature: Loading functionality

  Scenario: Click on the button after Ajax Loader is vanished
    Given I land on Ajax page
    When I wait and click on the CLICK ME button
    Then Well Done For Waiting modal appears
@actions @smoke
Feature: Actions on buttons and fields

  Background:
    Given I land on Actions page

  Scenario: Drag and drop action
    When I drag and drop first box to the second box
    Then I get message from the second box with text Dropped!

  Scenario: Double click action
    When I double click on Double Click Me! button
    Then The button changes the color

  Scenario: Click and hold action
    When I click and hold on Click and Hold! button
    Then I get message from the button with text "Well done! keep holding that click now....."

  Scenario: Release after hold action
    When I click and hold on Click and Hold! button
    And I release button click
    Then I get message from the button with text "Dont release me!!!"
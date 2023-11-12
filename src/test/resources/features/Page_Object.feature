@po @regression
Feature: Page Object Feature

  Background:
    Given I land on the WebDriver University Page Object page

  Scenario Outline: Click on the promo link
    When I click on promo link "<promoLink>"
    Then I am redirected to the url "<url>"

    Examples:
      | promoLink    | url                                                             |
      | Home         | https://webdriveruniversity.com/Page-Object-Model/index.html    |
      | Our Products | https://webdriveruniversity.com/Page-Object-Model/products.html |
      | Contact Us   | https://webdriveruniversity.com/Contact-Us/contactus.html       |


  Scenario: Click on right banner arrow
    When I click on right banner arrow
    Then Next banner is shown

  Scenario: Click on left banner arrow
    When I click on left banner arrow
    Then Previous banner is shown

  Scenario: Find Out More button is calling Find Out Modal
    When I click on Find Out More button
    Then Find Out More modal is shown
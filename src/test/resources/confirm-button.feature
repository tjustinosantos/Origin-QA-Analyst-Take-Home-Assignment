Feature: Confirm Button Test

  Scenario: Test if the confirm button does nothing
    Given I access the saving simulation page
    When I set Total Amount as 550
    And I click on confirm button
    Then the page should be the same
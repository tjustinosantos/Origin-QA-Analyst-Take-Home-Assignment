Feature: Date Input Test

  Scenario: Test if it only allows future months
    Given I access the saving simulation page
    And I try to move back a month
    Then the month should not be changed, still set as the current one

  Scenario: Test if it is possible to move months by clicking on arrow key (getting back to the current one)
    Given I access the saving simulation page
    When And I try to move forward a month
    And I try to move back a month
    Then the month should not be changed, still set as the current one
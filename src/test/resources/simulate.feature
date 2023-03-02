Feature: Simulate Buying a house Test

  Scenario Outline: Happy Path
    Given I access the saving simulation page
    When I set Total Amount as <totalAmount>

    Examples:
      | totalAmount | month | year | monthlyAmount |
      | 100.22      |"April"| 2023 |     2.63      |
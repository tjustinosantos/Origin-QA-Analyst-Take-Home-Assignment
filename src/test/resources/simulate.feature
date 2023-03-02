Feature: Simulate Buying a house Test

  Scenario Outline: Happy Path
    Given I access the saving simulation page

    Examples:
      | totalAmount | month | year | monthlyAmount |
      | 100.00      |"April"| 2023 |     2.63      |
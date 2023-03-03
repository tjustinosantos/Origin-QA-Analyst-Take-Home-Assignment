Feature: Simulate Buying a house Test

  Scenario Outline: Happy Path
    Given I access the saving simulation page
    When I set Total Amount as <totalAmount>
    And I set a reachable goal by month <month> and year <year>
    Then the Monthly amount is <monthlyAmount> value
    And the number of monthly deposits are correct
    And the value to reach my goal is <totalAmount>
    Examples:
      | totalAmount | month | year | monthlyAmount |
      | 100.23      |"November"| 2024 |     4.77      |
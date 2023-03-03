Feature: Simulate a Saving Goal to Buy a House (Core Calculation)

  Scenario Outline: Core calculation for different totalAmounts, months and years
    Given I access the saving simulation page
    When I set Total Amount as <totalAmount>
    And I set a reachable goal by month <month> and year <year>
    Then the calculated Monthly amount is <monthlyAmount>
    And the calculated number of monthly deposits are correct
    And the calculated value to reach my goal is <totalAmount>
    And the reached by month is <month> and year <year>
    Examples:
      | totalAmount | month      | year | monthlyAmount |
      | 0           | "February" | 2025 | 0             |
      | 0.10        | "June"     | 2023 | 0.03          |
      | 99,999.99   | "March"    | 2030 | 1,176.47      |
      | 5,555.55    | "November" | 2026 | 123.46        |
      | 25.66       | "April"    | 2025 | 0.99          |
      | 8.95        | "December" | 2024 | 0.41          |
      | 850.55      | "February" | 2026 | 23.63         |
      | 5555.55     | "November" | 2026 | 123.46        |

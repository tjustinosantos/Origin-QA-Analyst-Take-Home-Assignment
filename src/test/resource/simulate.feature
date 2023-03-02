Feature: Simulate Buying a house Test

  Scenario Outline: Happy Path
    Given I access the saving simulation page
    When a set Total Amount as <totalAmount>
    And I set a reach goal by month <month> and year <year>
    Then the Monthly amount is <monthlyAmount> value
    And the number of monthly deposits is
    And the value to reach my goal is <totalAmount>
    And this will be reached by month <march> and year <year>
    Examples:
      | totalAmount | month | year | monthlyAmount |
      | 100.00      |"April"| 2023 |     2.63      |
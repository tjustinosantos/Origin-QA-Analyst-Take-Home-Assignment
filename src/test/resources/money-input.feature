Feature: Money Input Test

  Scenario Outline: Test if it only allows numbers
    Given I access the saving simulation page
    When I set Total Amount with letters <totalAmount>
    And the Total Amount is still empty by ignoring the input
    Examples:
      | totalAmount |
      | "Test" |
      | "@#$#@*&" |
      | -+/*- |
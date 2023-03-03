# Test Plan for Origin Savings Plan Simulation Screen

## Introduction:
The objective of this test plan is to ensure that the savings plan simulation screen is functioning as expected, meeting all the requirements specified in the assets section.

## Scope:
This test plan will cover the following components of the savings plan simulation screen:
- Money input
- Date input
- Confirm button

## Assumptions:
- The users have a basic understanding of how to use a web application.
- The users have access to a computer or mobile device with an internet connection.
- The users are familiar with the concept of saving towards a goal.

## Test Cases:

### Money input validation:
#### Objective:
To ensure that the money input field accepts only numbers and formats the entered value as money.
#### Test Steps:
1. Enter a non-numeric value in the money input field and verify that the field doesn't accept it.
2. Enter a valid number in the money input field and verify that the value is formatted as money (e.g 3500.45 should be 3,500.44).

### Date input validation:
#### Objective:
To ensure that the date input field accepts only future months and can be navigated using arrow keys.
#### Test Steps:
1. Enter a past month in the date input field and verify that the field doesn't accept it.
2. Enter a future month in the date input field and verify that the field accepts it.
3. Click on the arrow buttons to navigate through the months and verify that the field updates accordingly.
4. Focus on the date input field and verify that the users can move the months by typing the Left and Right arrow keys on the keyboard.

### Confirm button functionality:
#### Objective:
To ensure that the confirmation button is displayed and functional.
#### Test Steps:
1. Verify that the confirmation button is displayed on the screen.
2. Click on the confirmation button and verify that it doesn't have any action.

## Automated Test Script:
Automate the above test cases using a tool such as Selenium WebDriver or any other preferred automation tool. Save the test script to a document.

## Test Report:
Create a document containing the following sections:
- Summary of testing scope and objective.
- Test results for each test case (pass or fail).
- Description of any defects found during testing.
- Suggestions for improvements or enhancements.

## Conclusion:
This test plan covers the essential aspects of the savings plan simulation screen. By executing and automating the test cases, we can ensure that the screen meets the requirements specified in the assets section. The test report will provide insights into the test results and recommendations for improvements or enhancements.

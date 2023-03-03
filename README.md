# Origin QA Test


### About the project

Tests to simulate saving to buy a house

### Test Plan

Please access below link for detailed Test Plan

[Test_plan.md](Test_plan.md)

### Project Dependencies

*JDK 11
*Maven 3.5.3
*Chrome (latest)
*ChromeDriver latest

### Project Decisions
* Simple [Cucumber](https://docs.cucumber.io/) feature to better describe the steps on test execution
* [Page Object Pattern](https://martinfowler.com/bliki/PageObject.html) has been implemented for better readability. That means that each java class represent a page that Selenium Interacts with, including its mapped page elements.


### Installation Instructions

Download and extract [Chromedriver](https://chromedriver.chromium.org/downloads)
Start it: 

     $  chromedriver start



### Running Tests locally for Desktop Tests

            $ mvn test

### Running Tests locally for Mobile tests

           $ mvn  test -DrunOnMobile=true

### Running Tests on Docker (Desktop)

            $  ./run.sh

### Running Tests  on Docker (Mobile)

           $ ./run.sh mobile
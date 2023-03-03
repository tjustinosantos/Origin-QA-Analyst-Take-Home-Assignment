package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.Assert;
import pages.SavingSimulationPage;
import org.openqa.selenium.ElementClickInterceptedException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static pages.Helper.getMonthDifferenceFromNow;
import static pages.Helper.getCurrentMonth;

public class Stepdefs {

    private WebDriver driver;
    private SavingSimulationPage savingSimulationPage;
    private String month;
    private Integer year;
    private Double totalAmount;

    @Before
    public void setUp() throws IOException {
        String runOnMobile = System.getProperty("runOnMobile", "false");
        if (runOnMobile.equals("true")) {
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "iPhone X");
            options.setExperimentalOption("mobileEmulation", mobileEmulation);
            driver = new ChromeDriver(options);
        } else {
            driver = new ChromeDriver();
        }

        savingSimulationPage = new SavingSimulationPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I access the saving simulation page")
    public void givenIAccessTheSavingSimulationPage() {
        savingSimulationPage.navigateTo(ConfigReader.getUrl());
    }
    @When("I set Total Amount with characters {string}")
    public void whenISetTotalAmountWithCharaters(String input) {
        savingSimulationPage.inputTotalAmount(input);
    }

    @When("I set Total Amount as {double}")
    public void whenISetTotalAmountAs(Double totalAmount) {
        this.totalAmount = totalAmount;
        savingSimulationPage.inputTotalAmount(totalAmount);
    }

    @When("I set a reachable goal by month {string} and year {int}")
    public void whenISetReachableGoalByMonthAndYear(String month, int year) {
        this.month = month;
        this.year = year;
        savingSimulationPage.advanceToMonth(getMonthDifferenceFromNow(year, month));
    }

    @When("I try to move back a month")
    public void iTryToMoveBackAMonth(){
        try {
            //as the button is disabled, the exception is expected
            savingSimulationPage.goBackAMonth();
        } catch (ElementClickInterceptedException e) {
            Assert.assertTrue(e.getMessage().contains("is not clickable at point"));
        }
    }

    @When("I try to move back a month with left arrow key")
    public void iTryToMoveBackAMonthWithLeftArrowkey() {
        savingSimulationPage.goBackAMonthWithArrowKey();
    }

    @When("I try to move forward a month with right arrow key")
    public void iTryToMoveForwardAMonthWithRightArrowKey() {
        savingSimulationPage.advanceAMonthWithArrowKey();
    }

    @When("I try to move forward a month")
    public void iTryToMoveForwardAMonth() {
        savingSimulationPage.goBackAMonth();
    }

    @When("I click on confirm button")
    public void iClickOnConfirmButton() {
        savingSimulationPage.clickOnConfirmButton();
    }

    @Then("the month should not be changed, still set as the current one")
    public void theMonthShouldNotBeChangedStillSetAsTheCurrentOne() {
        Assert.assertEquals(getCurrentMonth(), savingSimulationPage.getCurrentDisplayedMonth());
    }
    @Then("the Total Amount is still empty by ignoring the input")
    public void theTotalAmountIsStillEmptyByIgnoringTheInput() {
        Assert.assertTrue(savingSimulationPage.totalAmountIsEmpty());
    }

    @Then("the calculated Monthly amount is {double}")
    public void thenTheCalculatedMonthlyAmountIs(Double monthlyAmount) {
        Assert.assertEquals(monthlyAmount, savingSimulationPage.getMonthlyAmount());
    }

    @Then("the calculated number of monthly deposits are correct")
    public void thenTheCalculatedNumberOfMonthlyDepositsAreCorrect() {
        Assert.assertEquals(getMonthDifferenceFromNow(year, month), savingSimulationPage.getNumberOfMonthlyDeposits());
    }

    @Then("the calculated value to reach my goal is {double}")
    public void thenTheCalculatedValueToReachMyGoalIs(Double totalAmount) {
        Assert.assertEquals(this.totalAmount, savingSimulationPage.getTotalAmount());
    }

    @Then("the reached by month is {string} and year {int}")
    public void thenTheReachedByMonthIsAndYear(String month, int year) {
        Assert.assertEquals(this.year, savingSimulationPage.getYear());
        Assert.assertEquals(this.month, savingSimulationPage.getMonth());
    }

    @Then("the page should be the same")
    public void thePageShouldBeTheSame() {
        Assert.assertEquals(ConfigReader.getUrl(), savingSimulationPage.getCurrentUrl());
    }

}

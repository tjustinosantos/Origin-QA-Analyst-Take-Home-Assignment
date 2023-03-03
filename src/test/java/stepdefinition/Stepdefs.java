package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import pages.SavingSimulationPage;
import static pages.Helper.getMonthDifferenceFromNow;

public class Stepdefs {

    private WebDriver driver;
    private SavingSimulationPage savingSimulationPage;
    private String month;
    private Integer year;
    private Double totalAmount;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        savingSimulationPage = new SavingSimulationPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I access the saving simulation page")
    public void givenIAccessTheSavingSimulationPage() {
        savingSimulationPage.navigateTo("http://qa-assignment.useorigin.com.s3-website-us-east-1.amazonaws.com/");
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

}

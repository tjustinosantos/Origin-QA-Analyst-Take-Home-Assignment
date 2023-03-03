package stepdefinition;

import pages.SavingSimulationPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.net.MalformedURLException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import static pages.Helper.getMonthDifferenceFromNow;

public class Stepdefs {

    WebDriver driver;

    private String month;
    private Integer year;
    private Double totalAmount;

    @Before
    public void startUp() throws MalformedURLException {
        this.driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Given("I access the saving simulation page")
    public void I_access_the_saving_simulation_page(){
        SavingSimulationPage savingSimulationPage = new SavingSimulationPage(driver);
        savingSimulationPage.navigateTo("http://qa-assignment.useorigin.com.s3-website-us-east-1.amazonaws.com/");
    }

    @When("I set Total Amount as {double}")
    public void I_set_total_amount_as(double totalAmount){
        SavingSimulationPage savingSimulationPage = new SavingSimulationPage(driver);
        this.totalAmount = totalAmount;
        savingSimulationPage.inputTotalAmount(totalAmount);
    }

    @When("I set a reachable goal by month {string} and year {int}")
    public void I_set_total_amount_as(String month, int year){
        this.month = month;
        this.year = year;
        SavingSimulationPage savingSimulationPage = new SavingSimulationPage(driver);
        savingSimulationPage.advanceToMonth(getMonthDifferenceFromNow(year, month));
    }

    @Then("the calculated Monthly amount is {double}")
    public void the_calculated_monthly_amount_is(Double monthlyAmount){
        SavingSimulationPage savingSimulationPage = new SavingSimulationPage(driver);
        Assert.assertEquals(monthlyAmount,savingSimulationPage.getMonthlyAmount());
    }

    @Then("the calculated number of monthly deposits are correct")
    public void the_calculated_number_of_monthly_deposits_are_correct(){
        SavingSimulationPage savingSimulationPage = new SavingSimulationPage(driver);
        Assert.assertEquals(getMonthDifferenceFromNow(year, month),savingSimulationPage.getNumberOfMonthlyDeposits());
    }

    @Then("the calculated value to reach my goal is {double}")
    public void the_calculated_value_to_reach_my_goal_is(Double totalAmount){
        SavingSimulationPage savingSimulationPage = new SavingSimulationPage(driver);
        Assert.assertEquals(this.totalAmount,savingSimulationPage.getTotalAmount());
    }

    @Then("the reached by month is {string} and year {int}")
    public void the_reached_by_month_is_and_year(String month, Integer year) throws Throwable {
        SavingSimulationPage savingSimulationPage = new SavingSimulationPage(driver);
        Assert.assertEquals(this.year,savingSimulationPage.getYear());
        Assert.assertEquals(this.month,savingSimulationPage.getMonth());
    }



}


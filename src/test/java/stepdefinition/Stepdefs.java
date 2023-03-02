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

import static pages.Helper.getMonthDifferenceFromNow;

public class Stepdefs {

    WebDriver driver;

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
    public void I_access_the_saving_simulation_page() throws Throwable {
        SavingSimulationPage savingSimulationPage = new SavingSimulationPage(driver);
        savingSimulationPage.navigateTo("http://qa-assignment.useorigin.com.s3-website-us-east-1.amazonaws.com/");
    }

    @When("I set Total Amount as {double}")
    public void I_set_total_amount_as(double totalAmount) throws Throwable {
        SavingSimulationPage savingSimulationPage = new SavingSimulationPage(driver);
        savingSimulationPage.inputTotalAmount(totalAmount);
    }

    @When("I set a reachable goal by month {string} and year {int}")
    public void I_set_total_amount_as(String month, int year) throws Throwable {
        SavingSimulationPage savingSimulationPage = new SavingSimulationPage(driver);
        savingSimulationPage.advanceToMonth(getMonthDifferenceFromNow(year, month));
    }
}


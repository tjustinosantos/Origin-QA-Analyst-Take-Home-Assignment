package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class SavingSimulationPage extends BasePage {


    private final By totalAmountTextBoxSelector = By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[1]/div/div/input");
    private final By advanceMonthButtonElementSelector = By.cssSelector("[data-testid='reachDateIncrement']");
    private final By monthlyAmountLabelSelector = By.xpath("//*[@id=\"root\"]/div[2]/div/div[3]/div/div[1]/div/div[2]/p");

    private final By resultLabelElementSelector = By.xpath("//*[@id=\"root\"]/div[2]/div/div[3]/div/div[2]/div/p/span");


    public SavingSimulationPage(WebDriver driver) {
        super(driver);
    }

    public SavingSimulationPage navigateTo(String url) {
        driver.navigate().to(url);
        return new SavingSimulationPage(driver);
    }

    public SavingSimulationPage inputTotalAmount(double totalAmount) {
        WebElement totalAmountTextBox = driver.findElement(totalAmountTextBoxSelector);
        totalAmountTextBox.sendKeys(String.valueOf(totalAmount));
        return new SavingSimulationPage(driver);
    }

    public SavingSimulationPage advanceToMonth(int monthsAhead) {
        int aux = 1;
        WebElement advanceMonthButton = driver.findElement(advanceMonthButtonElementSelector);
        if (monthsAhead != 1) {
            do {
                aux++;
                advanceMonthButton.click();
            } while (aux != monthsAhead);
        }
        return new SavingSimulationPage(driver);
    }

    public Double getMonthlyAmount() {
        WebElement monthlyAmountLabel = driver.findElement(monthlyAmountLabelSelector);
        // remove $ sign from captured value and convert to Double
        return Double.parseDouble(monthlyAmountLabel.getText().substring(1));
    }

    public int getNumberOfMonthlyDeposits() {
        return Integer.valueOf(resultLabelExtractor("monthly deposits"));
    }

    public Double getTotalAmount() {
        return Double.parseDouble((resultLabelExtractor("goal")));
    }

    public Integer getYear() {
        return Integer.parseInt((resultLabelExtractor("year")));
    }

    public String getMonth() {
        return resultLabelExtractor("month");
    }


    public String resultLabelExtractor(String wantedResult) {
        List<WebElement> resultsList = driver.findElements(resultLabelElementSelector);
        String extractedText = null;

        switch (wantedResult) {
            case "monthly deposits":
                extractedText = resultsList.get(0).getText().replaceAll("[^\\d]", "").replaceAll("[^\\d]", "");
                break;
            case "goal":
                extractedText = resultsList.get(1).getText().substring(1);
                break;
            case "month":
                extractedText = resultsList.get(2).getText().split(" ")[0];
                break;
            case "year":
                extractedText = resultsList.get(2).getText().split(" ")[1];
                break;

        }
        return extractedText;
    }
}


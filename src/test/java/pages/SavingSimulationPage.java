package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SavingSimulationPage extends BasePage {

    @FindBy(css = "[data-testid='reachDateIncrement']")
    private WebElement advanceMonthButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[2]/div[1]/div/div/input")
    private WebElement totalAmountTextBox;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[3]/div/div[1]/div/div[2]/p")
    private WebElement monthlyAmountLabel;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[3]/div/div[2]/div/p/span")
    private List<WebElement> resultLabels;

    public SavingSimulationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SavingSimulationPage navigateTo(String url) {
        driver.navigate().to(url);
        return this;
    }

    public SavingSimulationPage inputTotalAmount(double totalAmount) {
        totalAmountTextBox.sendKeys(String.valueOf(totalAmount));
        return this;
    }

    public SavingSimulationPage advanceToMonth(int monthsAhead) {
        for (int i = 0; i < monthsAhead - 1; i++) {
            advanceMonthButton.click();
        }
        return this;
    }

    public Double getMonthlyAmount() {
        String text = monthlyAmountLabel.getText();
        String amount = text.substring(text.indexOf("$") + 1);
        return Double.parseDouble(amount);
    }

    public int getNumberOfMonthlyDeposits() {
        String extractedText = getResultLabelText("monthly deposits");
        return Integer.parseInt(extractedText.replaceAll("\\D", ""));
    }

    public Double getTotalAmount() {
        String goalText = getResultLabelText("$");
        String goalValue = goalText.replace("$", "");
        return Double.parseDouble(goalValue);
    }

    public Integer getYear() {
        String extractedText = getResultLabelText("date");
        return Integer.parseInt(extractedText.substring(extractedText.indexOf(" ") + 1));
    }

    public String getMonth() {
        String extractedText = getResultLabelText("date");
        return extractedText.substring(0, extractedText.indexOf(" "));
    }

    private String getResultLabelText(String label) {
        if (label.equals("date")) {
            return resultLabels.get(2).getText();
        }
        for (WebElement resultLabel : resultLabels) {
            String text = resultLabel.getText().toLowerCase();
            if (text.contains(label)) {
                    return text;
            }
        }
        return null;
    }
}

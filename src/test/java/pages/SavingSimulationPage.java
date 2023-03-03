package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class SavingSimulationPage extends BasePage {

    @FindBy(css = "[data-testid='reachDateIncrement']")
    private WebElement advanceMonthButton;

    @FindBy(css = "[data-testid='reachDate']")
    private WebElement reachDateSelector;

    @FindBy(css = "[data-testid='reachDateDecrement']")
    private WebElement goBackMonthButton;

    @FindBy(css = "[data-testid='reachDateMonth']")
    private WebElement reachDateMonthSelector;

    @FindBy(css = "[data-testid='input']")
    private WebElement totalAmountTextBox;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[3]/div/div[1]/div/div[2]/p")
    private WebElement monthlyAmountLabel;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[3]/div/div[2]/div/p/span")
    private List<WebElement> resultLabels;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[4]/button")
    private WebElement confirmButtonSelector;


    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[5]/button")
    private WebElement mobileConfirmButtonSelector;

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

    public SavingSimulationPage inputTotalAmount(String totalAmount) {
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
        String amount = text.substring(text.indexOf("$") + 1).replace(",", "");;
        return Double.parseDouble(amount);
    }

    public int getNumberOfMonthlyDeposits() {
        String extractedText = getResultLabelText("monthly deposits");
        return Integer.parseInt(extractedText.replaceAll("\\D", ""));
    }

    public Double getTotalAmount() {
        String goalText = getResultLabelText("$");
        String goalValue = goalText.replace("$", "").replace(",", "");;
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

    public boolean totalAmountIsEmpty() {
        return totalAmountTextBox.getText().isEmpty();
    }

    public void advanceAMonth() {
        advanceMonthButton.click();
    }

    public void goBackAMonth() {
        goBackMonthButton.click();
    }

    public String getCurrentDisplayedMonth() {
        return reachDateMonthSelector.getText();
    }

    public String getCurrentMonth() {
        return reachDateMonthSelector.getText();
    }

    public void clickOnConfirmButton() {
        String runOnMobileStr = System.getProperty("runOnMobile", "false");
        boolean runOnMobile = Boolean.parseBoolean(runOnMobileStr);
        if (runOnMobile) {
            mobileConfirmButtonSelector.click();
        } else {
            confirmButtonSelector.click();
        }
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public void advanceAMonthWithArrowKey() {
        new Actions(driver).moveToElement(reachDateSelector).click().perform();
        reachDateSelector.sendKeys(Keys.ARROW_RIGHT);
    }

    public void goBackAMonthWithArrowKey() {
        new Actions(driver).moveToElement(reachDateSelector).click().perform();
        reachDateSelector.sendKeys(Keys.ARROW_LEFT);
    }
}

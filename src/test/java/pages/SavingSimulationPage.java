package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SavingSimulationPage extends BasePage{


    private final By totalAmountTextBoxSelector = By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[1]/div/div/input");
    private final By advanceMonthButtonElementSelector = By.cssSelector("[data-testid='reachDateIncrement']");
    private final By monthlyAmountLabelSelector = By.xpath("//*[@id=\"root\"]/div[2]/div/div[3]/div/div[1]/div/div[2]/p");

    public SavingSimulationPage(WebDriver driver) {
        super(driver);
    }

    public SavingSimulationPage navigateTo(String url){
        driver.navigate().to(url);
        return new SavingSimulationPage(driver);
    }

    public SavingSimulationPage inputTotalAmount(double totalAmount){
        WebElement totalAmountTextBox = driver.findElement(totalAmountTextBoxSelector);
        totalAmountTextBox.sendKeys(String.valueOf(totalAmount));
        return new SavingSimulationPage(driver);
    }

    public SavingSimulationPage advanceToMonth(int monthsAhead){
        int aux=1;
        WebElement advanceMonthButton = driver.findElement(advanceMonthButtonElementSelector);
        if(monthsAhead!=1) {
            do {
                aux++;
                advanceMonthButton.click();
            } while (aux != monthsAhead);
        }
        return new SavingSimulationPage(driver);
    }

    public Double getMonthlyAmount(){
        WebElement monthlyAmountLabel = driver.findElement(monthlyAmountLabelSelector);
        // remove $ sign from captured value and convert to Double
        return  Double.parseDouble(monthlyAmountLabel.getText().substring(1));
    }
}

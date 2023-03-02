package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class SavingSimulationPage extends BasePage{


    private final By totalAmountTextBoxSelector = By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[1]/div/div/input");


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
}

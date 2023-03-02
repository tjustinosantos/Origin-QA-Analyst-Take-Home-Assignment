package pages;

import org.openqa.selenium.WebDriver;

public class SavingSimulationPage extends BasePage{

    WebDriver driver;

    public SavingSimulationPage(WebDriver driver) {
        super(driver);
    }

    public SavingSimulationPage navigateTo(String url){
        driver.navigate().to(url);
        return new SavingSimulationPage(driver);
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getElementWaiter(int seconds) {
        Duration durationInSeconds = Duration.ofSeconds(seconds);
        WebDriverWait wait = new WebDriverWait(driver, durationInSeconds);
        return wait;
    }
}

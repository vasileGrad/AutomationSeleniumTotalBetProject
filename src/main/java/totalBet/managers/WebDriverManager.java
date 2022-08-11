package totalBet.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
    private WebDriver driver;

    public WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        return driver;
    }

    public WebDriver getDriver() {
        if(driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    public void closeDriver() {
        driver.quit();
    }
}

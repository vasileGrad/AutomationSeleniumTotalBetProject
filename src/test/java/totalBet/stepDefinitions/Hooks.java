package totalBet.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.*;
import totalBet.constants.Constants;
import totalBet.cucumber.TestContext;

import java.time.Duration;

public class Hooks {
    private WebDriver driver;
    TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setUp() {
        driver = testContext.getWebDriverManager().getDriver();
        driver.get("https://totalbet.ro/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.SHORT_TIME_SECONDS));
    }

    @After
    public void tearDown() {
        testContext.getWebDriverManager().closeDriver();
    }
}

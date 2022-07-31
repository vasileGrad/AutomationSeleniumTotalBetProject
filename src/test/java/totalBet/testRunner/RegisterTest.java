package totalBet.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/totalBet/Registration.feature",
        glue = "totalBet/stepDefinitions",
        tags = ("not @ignore")
)
public class RegisterTest {
}
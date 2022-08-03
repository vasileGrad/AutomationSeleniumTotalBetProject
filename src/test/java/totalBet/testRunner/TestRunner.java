package totalBet.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"totalBet/stepDefinitions"},
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/cucumber.html"},
        tags = "@PlaceTicket"
)
public class TestRunner {
}

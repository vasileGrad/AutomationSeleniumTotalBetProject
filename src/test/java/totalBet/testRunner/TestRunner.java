package totalBet.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/totalBet/Ticket.feature",
        glue = "totalBet/stepDefinitions",
        tags = "@ticket"
)
public class TestRunner {
}

// Login Runner
/*@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/totalBet/Login.feature",
        glue = "totalBet/stepDefinitions",
        tags = "@login"
)
public class TestRunner {
}*/

/*// Registration Runner
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/totalBet/Registration.feature",
        glue = "totalBet/stepDefinitions",
        tags = ("@registration")
)
public class TestRunner {
}*/

package totalBet.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// PlaceTicket Runner
/*@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/totalBet/PlaceTicket.feature",
        glue = "totalBet/stepDefinitions",
        tags = "@placeTicket"
)
public class TestRunner {
}*/

// VerifyTicket Runner
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/totalBet/VerifyTicket.feature",
        glue = "totalBet/stepDefinitions",
        tags = "@verifyTicket"
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

// Registration Runner
/*@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/totalBet/Registration.feature",
        glue = "totalBet/stepDefinitions",
        tags = ("@registration")
)
public class TestRunner {
}*/

// AccountSettings Runner
/*@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/totalBet/AccountSettings.feature",
        glue = "totalBet/stepDefinitions",
        tags = "@accountSettings"
)
public class TestRunner {
}*/

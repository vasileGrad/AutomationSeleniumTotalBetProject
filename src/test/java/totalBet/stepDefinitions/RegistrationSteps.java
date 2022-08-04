package totalBet.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import totalBet.cucumber.TestContext;
import totalBet.data.TestData;
import totalBet.pages.authentication.RegistrationPage;

public class RegistrationSteps {
    RegistrationPage registrationPage;

    public RegistrationSteps(TestContext testContext) {
        registrationPage = testContext.getPageObjectManager().getRegistrationPage();
    }

    @Given("I click on registration link")
    public void clickOnRegistrationLink() {
        registrationPage.clickOnRegistrationLink();
    }

    @When("I fill in registration form details")
    public void fillInRegistrationForm() {
        registrationPage.fillInRegistrationForm(TestData.registrationFormTestData());
    }

    @Then("I have successfully completed the registration")
    public void successfullyCompletedRegistration() throws InterruptedException {
        registrationPage.successfullyCompletedRegistration(TestData.registrationFormTestData());
    }

    @Then("I receive a registration error message")
    public void receivingRegistrationErrorMessage() {
        registrationPage.receivingRegistrationErrorMessage();
    }

}

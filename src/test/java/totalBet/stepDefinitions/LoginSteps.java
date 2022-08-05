package totalBet.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import totalBet.cucumber.TestContext;
import totalBet.data.TestData;
import totalBet.pages.authentication.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    public LoginSteps(TestContext testContext) {
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("I click on login link")
    public void clickOnLoginLink() {
        loginPage.clickOnLoginLink();
    }

    @When("I fill in valid login email and password")
    public void fillInValidLoginCredentials() {
        loginPage.fillInValidLoginCredentials(TestData.loginFormTestData());
    }

    @When("^I fill invalid email as (.*) and valid password as (.*)$")
    public void fillInvalidEmailAndValidPassword(String wrongEmail, String password) {
        loginPage.fillInEmailAndPassword(wrongEmail, password);
    }

    @When("^I fill valid email as (.*) and invalid password as (.*)$")
    public void fillValidEmailAndInvalidPassword(String email, String wrongPassword) {
        loginPage.fillInEmailAndPassword(email, wrongPassword);
    }

    @And("I click on submit button")
    public void clickOnSubmitButton() {
        loginPage.clickOnSubmitButton();
    }

    @Then("I should see my profile page")
    public void successfullyLoggedIn() throws InterruptedException {
        loginPage.successfullyLoggedIn();
    }

    @Given("I am an authenticated user")
    public void verifyAuthenticatedUser() {
        loginPage.verifyAuthenticatedUser();
    }

    @And("I should see logout button")
    public void verifyLogoutButton() {
        loginPage.verifyLogoutButton();
    }

    @When("I click on logout button")
    public void clickOnLogoutButton() {
        loginPage.clickOnLogoutButton();
    }

    @Then("I should see login link")
    public void verifyLoginLink() throws InterruptedException {
        loginPage.verifyLoginLink();
    }

    @Then("I should receive a login error message")
    public void receivingLoginErrorMessage() {
        loginPage.receivingLoginErrorMessage();
    }

    @Then("I should receive email and password error messages")
    public void receiveEmailAndPasswordErrorMessage() {
        loginPage.receiveEmailAndPasswordErrorMessages();
    }

    @Given("I have successfully logged in")
    public void verifySuccessfullyLoggedInUser() throws InterruptedException {
        loginPage.clickOnLoginLink();
        loginPage.fillInValidLoginCredentials(TestData.loginFormTestData());
        loginPage.clickOnSubmitButton();
        loginPage.successfullyLoggedIn();
    }
}

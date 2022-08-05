package totalBet.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import totalBet.cucumber.TestContext;
import totalBet.data.TestData;
import totalBet.pages.ticket.results.VerifyTicketPage;

public class VerifyTicketSteps {

    VerifyTicketPage verifyTicketPage;

    public VerifyTicketSteps(TestContext testContext) {
        this.verifyTicketPage = testContext.getPageObjectManager().getVerifyTicketPage();
    }

    @When("I click on home menu")
    public void clickOnHomeMenu() {
        verifyTicketPage.clickOnHomeMenu();
    }

    @Then("I click on search input ticket")
    public void clickOnSearchInputTicket() {
        verifyTicketPage.clickOnSearchInputTicket();
    }

    @And("I fill in a valid ticket code")
    public void fillValidTicketCode() {
        verifyTicketPage.fillValidTicketCode(TestData.ticketTestData().getCode());
    }

    @When("^I fill in an invalid ticket code as (.*)$")
    public void fillInvalidTicketCode(String invalidCode) {
        verifyTicketPage.fillInvalidTicketCode(invalidCode);
    }

    @And("I click on verify ticket button")
    public void clickOnVerifyTicketButton() {
        verifyTicketPage.clickOnVerifyTicketButton();
    }

    @Then("Pop-up ticket should appear")
    public void popUpTicketShouldAppear() {
        verifyTicketPage.popUpTicketShouldAppear();
    }

    @And("I should see correctly the ticket code")
    public void verifyPopUpTicketCodeIsDisplayedCorrectly() {
        verifyTicketPage.verifyPopUpTicketCodeIsDisplayedCorrectly(TestData.ticketTestData().getCode());
    }

    @And("I should see correctly the ticket status")
    public void verifyPopUpTicketStatusIsDisplayedCorrectly() {
        verifyTicketPage.verifyPopUpTicketStatusIsDisplayedCorrectly(TestData.ticketTestData().getStatus());
    }

    @Then("An alert should appear with error message")
    public void alertShouldAppearWithErrorMessage() {
        verifyTicketPage.alertShouldAppearWithErrorMessage();
    }

    @Then("I should see the ticket max win value is displayed")
    public void verifyPopUpTicketContainsMaxWinValue() {
        verifyTicketPage.verifyPopUpTicketContainsMaxWinValue(TestData.ticketTestData().getMaxWin());
    }

    @Then("I should see the details of the ticket correctly")
    public void verifyTicketDetailsAreCorrectlyDisplayed() {
        verifyTicketPage.verifyTicketDetailsAreCorrectlyDisplayed(TestData.ticketTestData());
    }

    @Then("I should see the max win of the ticket correctly")
    public void verifyMaxWinTicketIsCorrectlyDisplayed() {
        verifyTicketPage.verifyMaxWinTicketIsCorrectlyDisplayed(TestData.ticketTestData().getMaxWin());
    }
}

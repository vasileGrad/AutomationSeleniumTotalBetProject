package totalBet.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import totalBet.cucumber.TestContext;
import totalBet.pages.profile.HistoryTicketsPage;

public class HistoryTicketsSteps {
    private HistoryTicketsPage historyTicketsPage;

    public HistoryTicketsSteps(TestContext testContext) {
        this.historyTicketsPage = testContext.getPageObjectManager().getAccountTicketsPage();
    }

    @When("I click on my tickets link")
    public void clickOnMyTicketsLink() {
        historyTicketsPage.clickOnMyTicketsLink();
    }

    @Then("I should see the history tickets option in the left account menu")
    public void verifyHistoryTicketsOptionInLeftAccountMenu() throws InterruptedException {
        historyTicketsPage.verifyHistoryTicketsOptionInLeftAccountMenu();
    }

    @When("I click on the first ticket details from the list")
    public void clickOnFirstTicketDetailsFromList() throws InterruptedException {
        historyTicketsPage.clickOnFirstTicketDetailsFromList();
    }


    @Then("I should see the correct ticket code in the pop-up displayed correctly")
    public void verifyCorrectTicketCodeInPopUpIsDisplayedCorrectly() throws InterruptedException {
        historyTicketsPage.verifyCorrectTicketCodeInPopUpIsDisplayedCorrectly();
    }

    @When("I delete the first ticket from the list")
    public void deleteFirstTicketFromList() {
        historyTicketsPage.deleteFirstTicketFromList();
    }

    @Then("I should not see the ticket in the tickets history list")
    public void verifyTicketIsNotPresentInList() {
        historyTicketsPage.verifyTicketIsNotPresentInList();
    }
}

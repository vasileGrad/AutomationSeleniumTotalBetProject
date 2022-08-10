package totalBet.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import totalBet.cucumber.TestContext;
import totalBet.pages.ticket.results.ResultsPage;

public class ResultsSteps {
    private ResultsPage resultsPage;

    public ResultsSteps(TestContext testContext) {
        resultsPage = testContext.getPageObjectManager().getResultsPage();
    }

    @When("I click on results menu")
    public void clickOnResultsMenu() {
        resultsPage.clickOnResultsMenu();
    }

    @When("I read the event results from the file")
    public void readEventResultsFromFile() {
        resultsPage.readEventResultsFromFile();
    }

    @Then("I should have a list with all the event results")
    public void verifyListWithAllEventResults() throws InterruptedException {
        resultsPage.verifyListWithAllEventResults();
    }
}

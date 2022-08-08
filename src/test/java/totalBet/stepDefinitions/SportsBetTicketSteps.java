package totalBet.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import totalBet.cucumber.TestContext;
import totalBet.data.TestData;
import totalBet.pages.ticket.sportsBet.SportsBetPage;

public class SportsBetTicketSteps {
    SportsBetPage sportsBetPage;

    public SportsBetTicketSteps(TestContext testContext) {
        this.sportsBetPage = testContext.getPageObjectManager().getSportsBetPage();
    }

    @When("I click on sports bet menu")
    public void clickOnSportsBetMenu() {
        sportsBetPage.clickOnSportsBetMenu();
    }

    @When("I click on the current date")
    public void clickOnCurrentDate() {
        sportsBetPage.clickOnCurrentDate();
    }

    @And("^I choose sport title as (.*)$")
    public void chooseSportTitle(String sportTitle) {
        sportsBetPage.chooseSportTitle(sportTitle);
    }

    @And("^I insert a valid bet input as (.*)$")
    public void insertValidBetInputValue(double betInputValue) {
        sportsBetPage.insertValidBetInputValue(betInputValue);
    }

    @And("I insert input value as zero")
    public void insertInputValueZero() {
        sportsBetPage.insertInputValueZero();
    }

    @And("^I insert a negative bet input as (.*)$")
    public void insertInvalidBetInputValue(double invalidBetInputValue) {
        sportsBetPage.insertInvalidBetInputValue(invalidBetInputValue);
    }

    @And("^I insert in the bet input text as (.*)$")
    public void insertTextInBetInputValue(String textBetValue) {
        sportsBetPage.insertTextInBetInputValue(textBetValue);
    }

    @And("I click on the first ticket button from the ticket selector")
    public void chooseFirstTicketButtonFromTicketSelector() {
        sportsBetPage.chooseFirstTicketButtonFromTicketSelector();
    }

    @And("I select the sports bet ticket options")
    public void selectSportsBetTicketOptions() throws InterruptedException {
        sportsBetPage.selectSportsBetTicketOptions(TestData.sportsBetTicketTestData());
    }

    @Then("I should see the active days menu")
    public void verifyQuickDaysMenuVisibility() throws InterruptedException {
        sportsBetPage.verifyQuickDaysMenuVisibility();
    }

    @Then("I should see the number of sports bet in the ticket bets container")
    public void verifyNumberOfSportsBetInTicketBetsContainer() {
        sportsBetPage.verifyNumberOfSportsBetInTicketBetsContainer(TestData.sportsBetTicketTestData());
    }

    @And("I delete all the sports bet")
    public void shouldDeleteAllSportsBet() {
        sportsBetPage.shouldDeleteAllSportsBet();
    }

    @And("I remove the first event from the ticket bets container")
    public void deleteFirstEventFromRightList() {
        sportsBetPage.deleteFirstEventFromRightList();
    }

    @And("I should not see the events bet in the ticket bets container")
    public void verifyNotVisibleEventsInTicketBetsContainer() {
        sportsBetPage.verifyNotVisibleEventsInTicketBetsContainer();
    }

    @Then("I should see correct number of events in the ticket bets container")
    public void verifyNumberOfSportEventsInTicketBetsContainerIsCorrect() {
        sportsBetPage.verifyNumberOfSportEventsInTicketBetsContainerIsCorrect(TestData.sportsBetTicketTestData().get("numberEvents"));
    }

    @Then("I should see correctly the number of sport events in the ticket bets container")
    public void verifyNumberOfSportEventsInTicketBetsContainerAfterDelete() {
        sportsBetPage.verifyNumberOfSportEventsInTicketBetsContainerAfterDelete();
    }

    @And("I successfully placed and saved the sports bet ticket")
    public void successfullyPlacedAndSavedSportsBetTicket() throws InterruptedException {
        sportsBetPage.successfullyPlacedAndSavedSportsBetTicket();
    }

    @Then("I verify the sports bet ticket data value is calculated correctly")
    public void verifySportsBetTicketDataValueIsCalculatedCorrectly() throws InterruptedException {
        sportsBetPage.verifySportsBetTicketDataValueIsCalculatedCorrectly();
    }

    @And("Max win value should be 0 RON")
    public void verifyMaxWinValueIsZero() {
        sportsBetPage.verifyMaxWinValueIsZero();
    }
    @And("Max win value should be NaN RON")
    public void verifyMaxWinValueIsNaN() {
        sportsBetPage.verifyMaxWinValueIsNaN();
    }
}

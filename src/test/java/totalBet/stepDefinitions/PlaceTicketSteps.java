package totalBet.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import totalBet.data.TestData;
import totalBet.pages.account.ticket.sportsBet.SportsBetPage;

public class PlaceTicketSteps {
    SportsBetPage sportsBetPage;

    public PlaceTicketSteps(SportsBetPage sportsBetPage) {
        this.sportsBetPage = sportsBetPage;
    }

    @When("I click on sports bet menu")
    public void clickOnSportsBetMenu() {
        sportsBetPage.clickOnSportsBetMenu();
    }

    @And("I click on the current date")
    public void clickOnCurrentDate() {
        sportsBetPage.clickOnCurrentDate();
    }

    @And("I choose Football sport")
    public void chooseFootballSport() {
        sportsBetPage.chooseFootballSport();
    }

    @And("I click on the first ticket number")
    public void chooseFirstTicketNumber() {
        sportsBetPage.chooseFirstTicketNumber();
    }

    @And("I place the sports bet ticket")
    public void placeSportsBetTicket() throws InterruptedException {
        sportsBetPage.placeSportsBetTicket(TestData.sportsBetTicketTestData());
    }

    @Then("I should see the number of sports bet in the right list")
    public void shouldSeeNumberOfSportsBetInRightList() {
        sportsBetPage.shouldSeeNumberOfSportsBetInRightList(TestData.sportsBetTicketTestData());
    }

    @And("I delete all the sports bet")
    public void shouldDeleteAllSportsBet() {
        sportsBetPage.shouldDeleteAllSportsBet();
    }

    @And("I remove the first ticket from the right list")
    public void deleteTicketFromRightList() {
        sportsBetPage.deleteTicketFromRightList();
    }

    @And("I should not see the sports bet in the right list")
    public void shouldNotSeeTheSportsBetInTheRightList() {
        sportsBetPage.shouldNotSeeTheSportsBetInTheRightList();
    }

    @Then("I should see the number of sports bet in the right list to be correct")
    public void shouldSeeNumberOfSportsBetInRightListBeCorrect() {
        sportsBetPage.shouldSeeNumberOfSportsBetInRightListBeCorrect(TestData.sportsBetTicketTestData());
    }

    @And("I successfully placed and saved the sports bet ticket")
    public void successfullyPlacedAndSavedSportsBetTicket() throws InterruptedException {
        sportsBetPage.successfullyPlacedAndSavedSportsBetTicket();
    }

    @Then("I verify the sports bet ticket data value is calculated correctly")
    public void verifySportsBetTicketDataValueIsCalculatedCorrectly() {
        sportsBetPage.verifySportsBetTicketDataValueIsCalculatedCorrectly();
    }
}

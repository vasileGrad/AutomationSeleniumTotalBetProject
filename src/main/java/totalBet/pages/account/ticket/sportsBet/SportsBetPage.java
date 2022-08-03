package totalBet.pages.account.ticket.sportsBet;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import totalBet.common.ActionsHelper;
import totalBet.constants.Constants;
import totalBet.data.TestData;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SportsBetPage {

    WebDriver driver;

    public SportsBetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private ActionsHelper actionsHelper = new ActionsHelper();

    @FindBy(xpath = "//*[.='Pariuri Sportive']")
    private WebElement sportsBetLinkMenu;
    @FindBy(xpath = "//*[@class='quick-day active']")
    private WebElement currentQuickDateOption;
    @FindBy(xpath = "//*[@class='sport-menu-item']")
    private List<WebElement> sportMenuItems;
    @FindBy(xpath = "//*[@class='quick-day active']")
    private WebElement quickDayActive;
    @FindBy(xpath = "//*[.='Fotbal']")
    private WebElement footballSport;
    @FindBy(xpath = "//*[@class='event-odds count8']/*[1]")
    private List<WebElement> eventsOdd;
    @FindBy(xpath = "//div[@class='events-count']")
    private WebElement eventsCount;
    @FindBy(xpath = "//div[@class='max-win-value']")
    private WebElement maxWinValue;
    @FindBy(xpath = "//*[contains(@class,'ticket-no')][1]")
    private WebElement ticketNumberOne;
    @FindBy(xpath = "//*[contains(@class,'ticket-no')][2]")
    private WebElement ticketNumberTwo;
    @FindBy(xpath = "//*[contains(@class,'ticket-no')][3]")
    private WebElement ticketNumberThree;
    @FindBy(xpath = "//*[@class='reset-ticket']")
    private WebElement resetTicketButton;
    @FindBy(xpath = "//*[contains(@class,'ticket-body')]")
    private WebElement ticketBody;
    @FindBy(xpath = "//*[@class='ticket-event']")
    private List<WebElement> ticketEvents;
    @FindBy(xpath = "//*[@class='remove']")
    private List<WebElement> ticketEventsRemove;
    @FindBy(xpath = "//button[.='Plasează și salvează']")
    private WebElement placeAndSaveButton;
    @FindBy(xpath = "//div[@class='pop-up-title']")
    private WebElement popUpTitlePlaceTicket;
    @FindBy(xpath = "//*[@class='pop-up-close']")
    private WebElement popUpClosePlaceTicket;
    @FindBy(xpath = "//input[@class='bet-input']")
    private WebElement betInputTicket;
    @FindBy(xpath = "//*[@class='ticket-data-content-rows']/*[1]/*[@class='ticket-data-value']")
    private WebElement totalBetValueTicketDataContent;
    @FindBy(xpath = "//*[@class='ticket-data-content-rows']/*[2]/*[@class='ticket-data-value']")
    private WebElement betSumTicketDataContent;
    @FindBy(xpath = "//*[@class='ticket-data-content-rows']/*[3]/*[@class='ticket-data-value']")
    private WebElement combinationsTicketDataContent;
    @FindBy(xpath = "//*[@class='ticket-data-content-rows']/*[4]/*[@class='ticket-data-value']")
    private WebElement stakeTicketDataContent;
    @FindBy(xpath = "//*[@class='max-win-value']")
    private WebElement maxWinValueTicket;
    @FindBy(xpath = "//*[@class='bet-odd-value']")
    private List<WebElement> betOddValueList;

    public void clickOnSportsBetMenu() {
        actionsHelper.clickOnElement(sportsBetLinkMenu);
    }

    public void clickOnCurrentDate() {
        actionsHelper.clickOnElement(quickDayActive);
    }

    public void chooseFootballSport() {
        actionsHelper.clickOnElement(footballSport);
    }

    public void chooseFirstTicketNumber() {
        actionsHelper.clickOnElement(ticketNumberOne);
    }

    public void placeSportsBetTicket(HashMap<String, String> data) throws InterruptedException {
        int numberEvents = Integer.parseInt(data.get("numberEvents"));
        for (int i = 0; i < numberEvents; i++) {
            WebElement oddEvent = eventsOdd.get(i);
            actionsHelper.clickOnElement(oddEvent);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", oddEvent);
            Thread.sleep(Constants.SHORT_SLEEP);
        }
    }

    public void shouldSeeNumberOfSportsBetInRightList(HashMap<String, String> data) {
        assertTrue("The number of events is not correctly placed", eventsCount.getText().equals(data.get(Constants.NUMBER_EVENTS)));
    }

    public void shouldDeleteAllSportsBet() {
        actionsHelper.clickOnElement(resetTicketButton);
        driver.switchTo().alert().accept();
    }

    public void deleteTicketFromRightList() {
        actionsHelper.clickOnElement(ticketEventsRemove.get(ticketEventsRemove.size() - 1));
    }

    public void shouldNotSeeTheSportsBetInTheRightList() {
        assertTrue("The sports bet list is present", ticketBody.getAttribute(Constants.CLASS).contains(Constants.EMPTY_TICKET));
    }

    public void shouldSeeNumberOfSportsBetInRightListBeCorrect(HashMap<String, String> data) {
        assertTrue("The number of events is not correctly placed", eventsCount.getText().equals(String.valueOf(Integer.parseInt(data.get(Constants.NUMBER_EVENTS)) - 1)));
    }

    public void successfullyPlacedAndSavedSportsBetTicket() throws InterruptedException {
        actionsHelper.clickOnElement(placeAndSaveButton);
        Thread.sleep(Constants.LONG_SLEEP);
        boolean isTicketPlaced = popUpTitlePlaceTicket.getText().contains(Constants.SUCCESS);
        assertTrue("The sports bet ticket was not placed successfully", isTicketPlaced);
    }

    public void verifySportsBetTicketDataValueIsCalculatedCorrectly() {
        double totalBetTicketValue = actionsHelper.formatDoubleResult(getTotalBetTicket(betOddValueList));
        assertTrue("Total bet is not correct", actionsHelper.equals(totalBetValueTicketDataContent.getText(), String.valueOf(totalBetTicketValue)));

        String betInputValue = betInputTicket.getAttribute(Constants.VALUE);
        String betSumTicketValue = actionsHelper.extractFirstWordFromString(betSumTicketDataContent.getText());
        assertTrue("Bet sum value is not correct", actionsHelper.equals(betInputValue, betSumTicketValue));

        assertTrue("Combinations number is not correct", combinationsTicketDataContent.getText().equals(String.valueOf(0)));

        double stakeTicketValue = calculateStakeTicket(betInputValue, TestData.sportsBetTicketTestData());
        assertTrue("Stake ticket value is not correct", String.valueOf(stakeTicketValue).equals(stakeTicketDataContent.getText()));

        double maxWinBetTicket = stakeTicketValue * totalBetTicketValue;
        String expectedMaxWinBetTicket = String.valueOf(actionsHelper.formatDoubleResult(maxWinBetTicket));
        String actualMaxWinBetTicket = actionsHelper.extractFirstWordFromString(maxWinValueTicket.getText());
        assertEquals("Total bet ticket value is not correct", expectedMaxWinBetTicket, actualMaxWinBetTicket);
    }

    public int getRandom(int bound) {
        Random random = new Random();
        return random.nextInt(bound) + 1;
    }

    public double getTotalBetTicket(List<WebElement> betOddValueList) {
        double totalBetValue = 1;
        for (WebElement betOddValue : betOddValueList) {
            totalBetValue *= Double.parseDouble(betOddValue.getText());
        }

        return totalBetValue;
    }

    public double calculateStakeTicket(String betInputValue, HashMap<String, String> data) {
        double ticketTax = Double.parseDouble(betInputValue) * Double.parseDouble(data.get(Constants.TICKET_TAX));
        return Double.parseDouble(betInputValue) - ticketTax;
    }
}

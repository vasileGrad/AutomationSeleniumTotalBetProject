package totalBet.pages.ticket.sportsBet;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import totalBet.classes.Event;
import totalBet.common.ActionsHelper;
import totalBet.constants.Constants;
import totalBet.data.TestData;
import totalBet.pages.common.HeaderPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class SportsBetPage extends HeaderPage {

    private WebDriver driver;
    private ActionsHelper actionsHelper = new ActionsHelper();
    private List<Event> eventsSelected = new ArrayList<>();
    private List<WebElement> oddLabels;
    private List<WebElement> oddValues;

    public SportsBetPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='quick-days']")
    private WebElement quickDaysMenu;
    @FindBy(xpath = "//*[@class='quick-day active']")
    private WebElement currentQuickDateOption;
    @FindBy(xpath = "//*[@class='sport-menu-item']")
    private List<WebElement> sportMenuItems;
    @FindBy(xpath = "//*[@class='quick-day active']")
    private WebElement quickDayActive;
    @FindBy(xpath = "//*[.='Fotbal']")
    private WebElement footballSport;
    @FindBy(xpath = "(//div[contains(@class,'league-event-item')])")
    private List<WebElement> leagueEvents;
    @FindBy(xpath = "//*[contains(@class,'event-odds')]")
    private List<WebElement> oddEvents;
    @FindBy(xpath = "//*[@class='sport-title']")
    private List<WebElement> sportTitles;
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
    @FindBy(xpath = "//*[@class='pop-up']")
    private WebElement popUpPlacedTicket;
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
    @FindBy(xpath = "//*[@class='bonus']")
    private WebElement bonus;
    @FindBy(xpath = "//*[@class='bet-odd-value']")
    private List<WebElement> betOddValueList;
    @FindBy(xpath = "//*[@transform]//*[last()]")
    private WebElement placedTicketCode;
    @FindBy(xpath = "//*[@class='cookie-close-btn']")
    private WebElement closeCookieButton;

    public void clickOnSportsBetMenu() {
        actionsHelper.clickOnElement(getSportsBetLinkMenu());
        closeCookie();
    }

    public void clickOnCurrentDate() {
        actionsHelper.clickOnElement(quickDayActive);
    }

    public void chooseSportTitle(String sportTitleName) {
        WebElement sportEvent = footballSport;
        for (WebElement sportTitle : sportTitles) {
            if (sportTitle.getText().equals(sportTitleName.toUpperCase())) {
                sportEvent = sportTitle;
                break;
            }
        }
        actionsHelper.clickOnElement(sportEvent);
    }

    public void insertValidBetInputValue(double betInputValue) {
        actionsHelper.fillInText(betInputTicket, String.valueOf(betInputValue));
    }

    public void insertInvalidBetInputValue(double invalidBetInputValue) {
        actionsHelper.fillInText(betInputTicket, String.valueOf(invalidBetInputValue));
    }

    public void insertTextInBetInputValue(String text) {
        actionsHelper.fillInText(betInputTicket, text);
    }

    public void insertInputValueZero() {
        actionsHelper.fillInText(betInputTicket, "0");
    }

    public void chooseFirstTicketButtonFromTicketSelector() {
        actionsHelper.clickOnElement(ticketNumberOne);
    }

    public void selectSportsBetTicketOptions(HashMap<String, String> data) throws InterruptedException {
        int oddSize, randomOdd, numberEvents = Integer.parseInt(data.get("numberEvents"));
        String eventCode, eventName, eventDate, oddLabel, oddValue;
        for (int i = 1; i <= numberEvents; i++) {
            actionsHelper.waitForElementsVisibility(leagueEvents, driver);
            eventCode = leagueEvents.get(i).findElement(By.xpath("//*[@class='event-code']")).getText();
            eventName = leagueEvents.get(i).findElement(By.xpath("//*[@class='event-name']")).getText();
            eventDate = leagueEvents.get(i).findElement(By.xpath("//*[@class='event-date']")).getText();
            oddLabels = leagueEvents.get(i).findElements(By.xpath("(//div[contains(@class,'league-event-item')])[" + i + "]//*[@class='odd-label']"));
            oddValues = leagueEvents.get(i).findElements(By.xpath("(//div[contains(@class,'league-event-item')])[" + i + "]//*[@class='odd-value']"));
            oddEvents = leagueEvents.get(i).findElements(By.xpath("(//div[contains(@class,'league-event-item')])[" + i + "]//*[@class='odd']"));
            oddSize = oddLabels.size();
            randomOdd = getRandom(oddSize);
            WebElement oddEvent = oddEvents.get(randomOdd);
            actionsHelper.waitForElementClickable(oddEvent, driver);
            actionsHelper.clickOnElement(oddEvent);
            if (i % 4 == 0) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", oddEvent);
            }
            oddLabel = oddLabels.get(randomOdd).getText();
            oddValue = oddValues.get(randomOdd).getText();
            eventsSelected.add(new Event(Integer.parseInt(eventCode), eventName, eventDate, null, oddLabel, Double.parseDouble(oddValue), null));
        }
    }

    public void verifyNumberOfSportsBetInTicketBetsContainer(HashMap<String, String> data) {
        assertTrue("The number of events is not correctly placed", eventsCount.getText().equals(data.get("numberEvents")));
    }

    public void shouldDeleteAllSportsBet() {
        actionsHelper.clickOnElement(resetTicketButton);
        driver.switchTo().alert().accept();
    }

    public void deleteFirstEventFromRightList() {
        ticketEvents.remove(0);
        actionsHelper.clickOnElement(ticketEventsRemove.get(ticketEventsRemove.size() - 1));
    }

    public void verifyNotVisibleEventsInTicketBetsContainer() {
        assertTrue("The sports bet list is present", ticketBody.getAttribute(Constants.CLASS).contains("empty-ticket"));
    }

    public void verifyNumberOfSportEventsInTicketBetsContainerIsCorrect(String numberEvents) {
        assertEquals("The number of events is not correct", eventsSelected.size(), Integer.parseInt(numberEvents));
    }

    public void verifyNumberOfSportEventsInTicketBetsContainerAfterDelete() {
        assertEquals("The event was not deleted", eventsSelected.size() - 1, ticketEvents.size());
    }

    public void successfullyPlacedAndSavedSportsBetTicket() throws InterruptedException {
        actionsHelper.clickOnElement(placeAndSaveButton);
        actionsHelper.waitForElementVisibility(popUpTitlePlaceTicket, driver);
        assertTrue("The sports bet ticket was not placed successfully", popUpTitlePlaceTicket.getText().contains(Constants.SUCCESS));
        actionsHelper.waitForElementClickable(popUpClosePlaceTicket, driver);
        actionsHelper.clickOnElement(popUpClosePlaceTicket);
    }

    public void verifyQuickDaysMenuVisibility() throws InterruptedException {
        actionsHelper.waitForElementVisibility(quickDaysMenu, driver);
        assertTrue("The quick days menu is not displayed", quickDaysMenu.isDisplayed());
    }

    public void verifySportsBetTicketDataValueIsCalculatedCorrectly() throws InterruptedException {
        double totalBetTicketValue, stakeTicketValue, maxWinValueResult, expectedMaxWinBetTicket, actualMaxWinBetTicket;
        actionsHelper.waitForElementsVisibility(betOddValueList, driver);
        totalBetTicketValue = actionsHelper.formatDoubleResult(getTotalBetTicket(betOddValueList));
        assertTrue("Total bet is not correct", Double.valueOf(totalBetValueTicketDataContent.getText()) == totalBetTicketValue);
        String betInputValue = betInputTicket.getAttribute(Constants.VALUE);
        String betSumTicketValue = actionsHelper.extractFirstWordFromString(betSumTicketDataContent.getText());
        assertTrue("Bet input value is negative", Double.valueOf(betInputValue) >= 0);
        assertTrue("Bet sum value is not correct", actionsHelper.equals(betInputValue, betSumTicketValue));
        assertTrue("Combinations number is not correct", combinationsTicketDataContent.getText().equals(String.valueOf(0)));
        stakeTicketValue = calculateStakeTicket(betInputValue, TestData.sportsBetTicketTestData());
        assertTrue("Stake ticket value is not correct", stakeTicketValue == Double.parseDouble(stakeTicketDataContent.getText()));
        maxWinValueResult = stakeTicketValue * totalBetTicketValue;
        if (maxWinValueResult > Constants.MAX_WIN_VALUE) {
            maxWinValueResult = Constants.MAX_WIN_VALUE;
        }
        expectedMaxWinBetTicket = actionsHelper.formatDoubleResult(maxWinValueResult);
        actualMaxWinBetTicket = Double.parseDouble(actionsHelper.extractFirstWordFromString(maxWinValueTicket.getText()));
        if (expectedMaxWinBetTicket != actualMaxWinBetTicket) {
            if (actionsHelper.isElementDisplayed(bonus)) {
                int bonusValue = Integer.parseInt(actionsHelper.extractWordFromString(bonus.getText(), 2).replace(Constants.PERCENTAGE, Constants.EMPTY_SPACE));
                expectedMaxWinBetTicket += expectedMaxWinBetTicket * bonusValue / 100;
                expectedMaxWinBetTicket = actionsHelper.formatDoubleResult(expectedMaxWinBetTicket);
            }
        }
        assertEquals("Total bet ticket value is not correct", Double.valueOf(expectedMaxWinBetTicket), Double.valueOf(actualMaxWinBetTicket));
    }

    public void verifyMaxWinValueIsZero() {
        String betInputValue = betInputTicket.getAttribute(Constants.VALUE);
        assertTrue("Input value is not 0", betInputValue.equals("0"));
        double actualMaxWinBetTicket = Double.parseDouble(actionsHelper.extractFirstWordFromString(maxWinValueTicket.getText()));
        assertTrue("Max win value is not 0 RON", actualMaxWinBetTicket == 0);
    }

    public void verifyMaxWinValueIsNaN() {
        String actualMaxWinBetTicket = actionsHelper.extractFirstWordFromString(maxWinValueTicket.getText());
        assertTrue("Max win value is not NaN RON", actualMaxWinBetTicket.equals("NaN"));
    }

    public int getRandom(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public double getTotalBetTicket(List<WebElement> betOddValueList) {
        double totalBetValue = 1;
        for (WebElement betOddValue : betOddValueList) {
            totalBetValue *= Double.parseDouble(betOddValue.getText());
        }
        return totalBetValue;
    }

    public double calculateStakeTicket(String betInputValue, HashMap<String, String> data) {
        double ticketTax = Double.parseDouble(betInputValue) * Double.parseDouble(data.get("ticketTax"));
        return Double.parseDouble(betInputValue) - ticketTax;
    }

    public void closeCookie() {
        if (closeCookieButton.isDisplayed()) {
            actionsHelper.clickOnElement(closeCookieButton);
        }
    }
}

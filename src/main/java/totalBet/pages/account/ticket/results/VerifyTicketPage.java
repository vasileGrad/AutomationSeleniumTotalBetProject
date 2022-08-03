package totalBet.pages.account.ticket.results;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import totalBet.classes.Event;
import totalBet.classes.Ticket;
import totalBet.common.ActionsHelper;
import totalBet.constants.Constants;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VerifyTicketPage {

    WebDriver driver;

    public VerifyTicketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    ActionsHelper actionsHelper = new ActionsHelper();

    @FindBy(xpath = "//*[.='Acasă']")
    private WebElement homeMenu;
    @FindBy(xpath = "//*[@class='search-input']")
    private WebElement searchInputTicket;
    @FindBy(xpath = "//*[@class='verify-ticket-button']")
    private WebElement verifyTicketButton;
    @FindBy(xpath = "//*[@class='pop-up-title']")
    private WebElement popUpTitle;
    @FindBy(xpath = "//*[@class='placed-ticket-events']/*")
    private List<WebElement> placedTicketEvents;
    @FindBy(xpath = "//*[@class='placed-ticket-event-name']")
    private List<WebElement> ticketEventNames;
    @FindBy(xpath = "//*[@class='placed-ticket-event-date']")
    private List<WebElement> ticketEventCodeAndDates;
    @FindBy(xpath = "//*[@class='ticket-data-bet-info']/*[1]")
    private List<WebElement> ticketEventDetails;
    @FindBy(xpath = "//*[@class='ticket-data-bet-info']/*[2]")
    private List<WebElement> ticketEventOddLabels;
    @FindBy(xpath = "//*[@class='ticket-data-bet-info']/*[3]")
    private List<WebElement> ticketEventOddValues;
    @FindBy(xpath = "//*[@class='bet-detail status']/*[1]")
    private List<WebElement> ticketEventStatuses;
    @FindBy(xpath = "//*[@class='placed-ticket-time']")
    private WebElement placedTicketTime;
    @FindBy(xpath = "//*[@class='max-win']")
    private WebElement maxWin;

    @FindBys({
            @FindBy(xpath = "//*[contains(@class,'flex')]"),
            @FindBy(xpath = "//*[contains(text(), 'Combinații:')]")
    })
    private WebElement combinations;
    @FindBy(xpath = "//*[contains(text(), 'Pariu:')]")
    private WebElement betSum;
    @FindBy(xpath = "//*[contains(text(), 'Taxă')]")
    private WebElement betTax;
    @FindBy(xpath = "//*[contains(text(), 'Cotă totală:')]")
    private WebElement totalBetValue;
    @FindBy(xpath = "//*[@class='ticket-status']")
    private WebElement statusTicket;

    public void clickOnHomeMenu() {
        actionsHelper.clickOnElement(homeMenu);
    }

    public void clickOnSearchInputTicket() {
        actionsHelper.clickOnElement(searchInputTicket);
    }

    public void fillInValidSportsBetTicketCode(String ticketCode) {
        actionsHelper.fillInText(searchInputTicket, ticketCode);
    }

    public void clickOnVerifyTicketButton() {
        actionsHelper.clickOnElement(verifyTicketButton);
    }

    public void waitForPopUpToAppear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.LONG_WAIT));
        wait.until(ExpectedConditions.visibilityOf(popUpTitle));
        assertTrue("The pop-up is not displayed", popUpTitle.isEnabled());
    }

    public void verifyPopUpTicketCodeIsDisplayedCorrectly(String ticketCode) {
        assertTrue("The ticket code is not correctly displayed", popUpTitle.getText().contains(ticketCode));
    }

    public void verifyPopUpTicketStatusIsDisplayedCorrectly(String status) {
        assertTrue("Ticket status is not correct", status.equals(statusTicket.getText()));
    }

    public void verifyPopUpTicketContainsMaxWinValue(double expectedMaxWin) {
        String extractMaxWin = actionsHelper.extractWordFromString(maxWin.getText(), 2);
        double actualMaxWin = actionsHelper.formatDoubleResult(Double.valueOf(extractMaxWin));
        assertTrue("Ticket mas win value is not correct", expectedMaxWin == actualMaxWin);
    }

    public void verifyTicketDetailsAreCorrectlyDisplayed(Ticket expectedTicket) {
        Ticket actualTicket = getTicketDetailsFromPopUp();
        assertTrue("The ticket code is not correct", expectedTicket.getCode().equals(actualTicket.getCode()));
        assertTrue("Number of events are not equal", expectedTicket.getEvents().size() == actualTicket.getEvents().size());
        assertTrue("Max win value is not correct", expectedTicket.getMaxWin() == actualTicket.getMaxWin());
        assertTrue("The bet sum is not correct", expectedTicket.getBetSum() == actualTicket.getBetSum());
        assertTrue("The status is not correct", expectedTicket.getStatus().equals(actualTicket.getStatus()));
    }

    public void verifyMaxWinTicketIsCorrectlyDisplayed(double expectedMaxWin) {
        String actualMaxWin = actionsHelper.extractWordFromString(maxWin.getText(), 2);
        assertEquals("The max win value is not correctly displayed", String.valueOf(expectedMaxWin), actualMaxWin);
    }

    public Ticket getTicketDetailsFromPopUp() {
        List<Event> eventList = new ArrayList<>();
        int ticketEventsSize = placedTicketEvents.size();
        for (int i = 0; i < ticketEventsSize; i++) {
            int codeEvent = Integer.parseInt(actionsHelper.extractWordFromString(ticketEventCodeAndDates.get(i).getText(), 0));
            String nameEvent = ticketEventNames.get(i).getText();
            String dateEvent = actionsHelper.extractWordFromString(ticketEventCodeAndDates.get(i).getText(), 2) + Constants.SPACE;
            dateEvent += actionsHelper.extractWordFromString(ticketEventCodeAndDates.get(i).getText(), 3);
            String detailsEvent = ticketEventDetails.get(i).getText();
            String addLabelEvent = ticketEventOddLabels.get(i).getText();
            double oddValueEvent = Double.parseDouble(ticketEventOddValues.get(i).getText());
            String statusEvent = ticketEventStatuses.get(i).getAttribute(Constants.TITLE);

            Event event = new Event(codeEvent, nameEvent, dateEvent, detailsEvent, addLabelEvent, oddValueEvent, statusEvent);
            eventList.add(event);
        }

        String codeTicket = actionsHelper.extractWordFromString(popUpTitle.getText(), 2);
        String dateTicket = actionsHelper.extractWordFromString(placedTicketTime.getText(), 2) + Constants.SPACE;
        dateTicket += actionsHelper.extractWordFromString(placedTicketTime.getText(), 3);
        double maxWinValueTicket = Double.parseDouble(actionsHelper.extractWordFromString(maxWin.getText(), 2));
        maxWinValueTicket = actionsHelper.formatDoubleResult(maxWinValueTicket);
        int combinationsValueTicket = Integer.parseInt(actionsHelper.extractWordFromString(combinations.getText(), 1));
        double betSumValueTicket = Double.parseDouble(actionsHelper.extractWordFromString(betSum.getText(), 1));
        int betTaxPercentageValueTicket = Integer.parseInt(actionsHelper.extractWordFromString(betTax.getText(), 1).replace(Constants.PERCENTAGE, Constants.EMPTY_SPACE));
        double betTaxSumValueTicket = Double.parseDouble(actionsHelper.extractWordFromString(betTax.getText(), 2));
        double totalBetValueTicket = Double.parseDouble(actionsHelper.extractWordFromString(totalBetValue.getText(), 2));
        String statusValueTicket = statusTicket.getText();

        return new Ticket(codeTicket, dateTicket, maxWinValueTicket, combinationsValueTicket, betSumValueTicket, betTaxPercentageValueTicket, betTaxSumValueTicket, totalBetValueTicket, statusValueTicket, eventList);
    }
}

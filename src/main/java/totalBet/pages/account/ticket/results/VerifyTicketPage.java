package totalBet.pages.account.ticket.results;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import totalBet.common.ActionsHelper;
import totalBet.constants.Constants;

import java.time.Duration;
import java.util.List;

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
}

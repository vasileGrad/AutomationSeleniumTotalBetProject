package totalBet.pages.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import totalBet.common.ActionsHelper;
import totalBet.pages.common.HeaderPage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class HistoryTicketsPage extends HeaderPage {

    private WebDriver driver;
    private ActionsHelper actionsHelper = new ActionsHelper();
    private String deletedCode;

    public HistoryTicketsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tickets-history")
    private WebElement ticketsHistory;
    @FindBy(xpath = "//*[contains(@class, 'account-menu-item')]")
    private WebElement historyTicketsMenu;
    @FindBy(xpath = "//*[@class='account-ticket-detail'][1]")
    private List<WebElement> accountTicketDates;
    @FindBy(xpath = "//*[@class='account-ticket-detail'][2]")
    private List<WebElement> accountTicketCodes;
    @FindBy(xpath = "//*[@class='account-data-item-view']")
    private List<WebElement> accountDataItemsView;
    @FindBy(xpath = "//*[@class='account-data-item-delete']")
    private List<WebElement> accountDataItemsDelete;
    @FindBy(xpath = "//*[@class='pop-up']")
    private WebElement popUp;
    @FindBy(xpath = "//*[@class='pop-up-title']")
    private WebElement popUpTitle;
    @FindBy(xpath = "//*[@class='pop-up-close']")
    private WebElement popUpClose;

    public void clickOnMyTicketsLink() {
        actionsHelper.clickOnElement(getMyTicketsLink());
    }

    public void verifyHistoryTicketsOptionInLeftAccountMenu() throws InterruptedException {
        actionsHelper.waitForElementVisibility(historyTicketsMenu, driver);
        assertTrue("The history tickets menu is not visible", actionsHelper.isElementDisplayed(historyTicketsMenu));
    }

    public void clickOnFirstTicketDetailsFromList() throws InterruptedException {
        actionsHelper.waitForElementVisibility(ticketsHistory, driver);
        actionsHelper.clickOnElement(accountDataItemsView.get(0));
    }

    public void verifyCorrectTicketCodeInPopUpIsDisplayedCorrectly() throws InterruptedException {
        String expectedTicketCode = accountTicketCodes.get(0).getText();
        actionsHelper.waitForElementVisibility(popUpTitle, driver);
        String actualTicketCode = popUpTitle.getText();
        assertTrue("Ticket code is not correct", expectedTicketCode.equals(actualTicketCode));
    }

    public void deleteFirstTicketFromList() {
        deletedCode = accountTicketCodes.get(0).getText();
        actionsHelper.clickOnElement(accountDataItemsDelete.get(0));
        accountDataItemsDelete.remove(0);
    }

    public void verifyTicketIsNotPresentInList() {
        driver.navigate().refresh();
        boolean isDeleted = true;
        for(WebElement accountTicketCode : accountTicketCodes) {
            if(accountTicketCode.getText().equals(deletedCode)) {
                isDeleted = false;
            }
        }

        assertTrue("The ticket is not deleted from the tickets history list", isDeleted);
    }
}
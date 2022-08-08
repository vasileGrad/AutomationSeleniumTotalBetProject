package totalBet.managers;

import org.openqa.selenium.WebDriver;
import totalBet.pages.authentication.LoginPage;
import totalBet.pages.authentication.RegistrationPage;
import totalBet.pages.profile.AccountSettingsPage;
import totalBet.pages.profile.HistoryTicketsPage;
import totalBet.pages.ticket.results.VerifyTicketPage;
import totalBet.pages.ticket.sportsBet.SportsBetPage;

public class PageObjectManager {
    private WebDriver driver;

    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private SportsBetPage sportsBetPage;
    private AccountSettingsPage accountSettingsPage;
    private HistoryTicketsPage historyTicketsPage;
    private VerifyTicketPage verifyTicketPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage getRegistrationPage() {
        return (registrationPage == null) ? registrationPage = new RegistrationPage(driver) : registrationPage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public SportsBetPage getSportsBetPage() {
        return (sportsBetPage == null) ? sportsBetPage = new SportsBetPage(driver) : sportsBetPage;
    }

    public AccountSettingsPage getAccountSettingsPage() {
        return (accountSettingsPage == null) ? accountSettingsPage = new AccountSettingsPage(driver) : accountSettingsPage;
    }

    public VerifyTicketPage getVerifyTicketPage() {
        return (verifyTicketPage == null) ? verifyTicketPage = new VerifyTicketPage(driver) : verifyTicketPage;
    }

    public HistoryTicketsPage getAccountTicketsPage() {
        return (historyTicketsPage == null) ? historyTicketsPage = new HistoryTicketsPage(driver) : historyTicketsPage;
    }
}

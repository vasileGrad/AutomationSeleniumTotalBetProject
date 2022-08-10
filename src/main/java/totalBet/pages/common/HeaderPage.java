package totalBet.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

    private WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='Acasă']")
    private WebElement homeMenu;
    @FindBy(xpath = "//*[.='Pariuri Sportive']")
    private WebElement sportsBetLinkMenu;
    @FindBy(xpath = "//*[.='Rezultate']")
    private WebElement resultsLinkMenu;
    @FindBy(xpath = "//*[.='Contul meu']")
    private WebElement myAccount;
    @FindBy(xpath = "//*[.='Autentificare']")
    private WebElement loginLink;
    @FindBy(xpath = "//*[.='Înregistrare']")
    private WebElement registerLink;
    @FindBy(xpath = "//*[@class='auth-user']")
    private WebElement profileNameRegistered;
    @FindBy(xpath = "//*[@class='my-account-link'][1]")
    private WebElement myTicketsLink;
    @FindBy(xpath = "//*[.='Setari cont']")
    private WebElement accountSettingsLink;
    @FindBy(xpath = "//*[@class='logout-button']")
    private WebElement logoutButton;

    public WebElement getHomeMenu() {
        return homeMenu;
    }

    public WebElement getSportsBetLinkMenu() {
        return sportsBetLinkMenu;
    }

    public WebElement getResultsLinkMenu() {
        return resultsLinkMenu;
    }

    public WebElement getMyAccount() {
        return myAccount;
    }

    public WebElement getLoginLink() {
        return loginLink;
    }

    public WebElement getRegisterLink() {
        return registerLink;
    }

    public WebElement getProfileNameRegistered() {
        return profileNameRegistered;
    }

    public WebElement getMyTicketsLink() {
        return myTicketsLink;
    }

    public WebElement getAccountSettingsLink() {
        return accountSettingsLink;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }
}

package totalBet.pages.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import totalBet.common.ActionsHelper;
import totalBet.pages.common.HeaderPage;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LoginPage extends HeaderPage {

    private WebDriver driver;
    private ActionsHelper actionsHelper = new ActionsHelper();

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement emailTextbox;
    @FindBy(id = "password")
    private WebElement passwordTextbox;
    @FindBy(xpath = "//*[contains(text(), 'Trimite')]")
    private WebElement submitButton;
    @FindBy(xpath = "//*[@role='alert']")
    private WebElement emailTakenAlert;
    @FindBy(xpath = "//*[@class='invalid-feedback']")
    private List<WebElement> errorMessages;

    public void clickOnLoginLink() {
        actionsHelper.clickOnElement(getMyAccount());
        actionsHelper.clickOnElement(getLoginLink());
    }

    public void fillInValidLoginCredentials(HashMap<String, String> data) {
        actionsHelper.fillInText(emailTextbox, data.get("email"));
        actionsHelper.fillInText(passwordTextbox, data.get("password"));
    }

    public void fillInEmailAndPassword(String email, String password) {
        actionsHelper.fillInText(emailTextbox, email);
        actionsHelper.fillInText(passwordTextbox, password);
    }

    public void successfullyLoggedIn() throws InterruptedException {
        actionsHelper.clickOnElement(getMyAccount());
        actionsHelper.waitForElementVisibility(getProfileNameRegistered(), driver);
        assertTrue("The profile name is different", getProfileNameRegistered().isDisplayed());
    }

    public void clickOnSubmitButton() {
        actionsHelper.submitButton(submitButton);
    }

    public void clickOnLogoutButton() {
        actionsHelper.clickOnElement(getLogoutButton());
    }

    public void verifyAuthenticatedUser() throws InterruptedException {
        actionsHelper.clickOnElement(getMyAccount());
        actionsHelper.waitForElementVisibility(getProfileNameRegistered(), driver);
        assertTrue("The profile name is different", getProfileNameRegistered().isDisplayed());
    }

    public void verifyLogoutButton() {
        assertTrue("Logout button is no visible", getLogoutButton().isDisplayed());
    }

    public void verifyLoginLink() throws InterruptedException {
        actionsHelper.clickOnElement(getMyAccount());
        actionsHelper.waitForElementVisibility(getLoginLink(), driver);
        assertTrue("Login link is not visible", getLoginLink().isDisplayed());
    }

    public void receivingLoginErrorMessage() {
        assertTrue("The email has not been taken", emailTakenAlert.isDisplayed());
    }

    public void receiveEmailAndPasswordErrorMessages() {
        assertTrue("The password value is valid", errorMessages.get(1).getText().equals("The password field is required."));
        assertTrue("The email and password is correct", errorMessages.size() == 2);
    }
}

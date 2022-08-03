package totalBet.pages.account.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import totalBet.common.ActionsHelper;
import totalBet.constants.Constants;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private ActionsHelper actionsHelper = new ActionsHelper();

    @FindBy(xpath = "//*[.='Contul meu']")
    private WebElement myAccount;
    @FindBy(xpath = "//*[.='Autentificare']")
    private WebElement loginLink;
    @FindBy(xpath = "//*[@class='logout-button']")
    private WebElement logoutButton;
    @FindBy(id = "email")
    private WebElement emailTextbox;
    @FindBy(id = "password")
    private WebElement passwordTextbox;
    @FindBy(xpath = "//*[contains(text(), 'Trimite')]")
    private WebElement submitButton;
    @FindBy(xpath = "//*[@class='auth-user']")
    private WebElement profileNameRegistered;
    @FindBy(xpath = "//*[@role='alert']")
    private WebElement emailTakenAlert;
    @FindBy(xpath = "//*[@class='invalid-feedback']")
    private List<WebElement> errorMessages;

    public void clickOnLoginLink() {
        actionsHelper.clickOnElement(myAccount);
        actionsHelper.clickOnElement(loginLink);
    }

    public void fillInValidLoginCredentials(HashMap<String, String> data) {
        actionsHelper.fillInText(emailTextbox, data.get(Constants.EMAIL));
        actionsHelper.fillInText(passwordTextbox, data.get(Constants.PASSWORD));
    }

    public void fillInEmailAndPassword(String email, String password) {
        actionsHelper.fillInText(emailTextbox, email);
        actionsHelper.fillInText(passwordTextbox, password);
    }

    public void successfullyLoggedIn() throws InterruptedException {
        actionsHelper.clickOnElement(myAccount);
        Thread.sleep(Constants.SHORT_SLEEP);
        assertTrue("The profile name is different", profileNameRegistered.isDisplayed());
    }

    public void clickOnSubmitButton() {
        actionsHelper.submitButton(submitButton);
    }

    public void clickOnLogoutButton() {
        actionsHelper.clickOnElement(logoutButton);
    }

    public void verifyAuthenticatedUser() {
        actionsHelper.clickOnElement(myAccount);
        assertTrue("The profile name is different", profileNameRegistered.isDisplayed());
    }

    public void verifyLogoutButton() {
        assertTrue("Logout button is no visible", logoutButton.isDisplayed());
    }

    public void verifyLoginLink() throws InterruptedException {
        actionsHelper.clickOnElement(myAccount);
        Thread.sleep(Constants.SHORT_SLEEP);
        assertTrue("Login link is not visible", loginLink.isDisplayed());
    }

    public void receivingLoginErrorMessage() {
        assertTrue("The email has not been taken", emailTakenAlert.isDisplayed());
    }

    public void receiveEmailAndPasswordErrorMessages() {
        assertTrue("The password value is valid", errorMessages.get(1).getText().equals("The password field is required."));
        assertTrue("The email and password is correct", errorMessages.size() == 2);
    }
}

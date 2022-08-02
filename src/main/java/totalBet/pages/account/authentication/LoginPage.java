package totalBet.pages.account.authentication;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import totalBet.common.ActionsHelper;

import java.util.HashMap;

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

    public void clickOnLoginMenu() {
        PageFactory.initElements(driver, this);
        actionsHelper.clickOnElement(myAccount);
        actionsHelper.clickOnElement(loginLink);
    }

    public void fillInValidLoginCredentials(HashMap<String, String> data) {
        actionsHelper.fillInText(emailTextbox, data.get("email"));
        actionsHelper.fillInText(passwordTextbox, data.get("password"));
        actionsHelper.submitButton(submitButton);
    }

    public void successfullyLoggedIn() throws InterruptedException {
        actionsHelper.clickOnElement(myAccount);
        Thread.sleep(200);
        assertTrue("The profile name is different", profileNameRegistered.isDisplayed());
    }

    public void fillInvalidEmailAndValidPassword(String wrongEmail, String password) {
        actionsHelper.fillInText(emailTextbox, wrongEmail);
        actionsHelper.fillInText(passwordTextbox, password);
        actionsHelper.submitButton(submitButton);
    }

    public void verifyAuthenticatedUser() {
        actionsHelper.clickOnElement(myAccount);
        assertTrue("The profile name is different", profileNameRegistered.isDisplayed());
    }

    public void receivingLoginErrorMessage() {
        Assert.assertTrue("The email has not been taken", emailTakenAlert.isDisplayed());
    }
}

package totalBet.pages.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import totalBet.common.ActionsHelper;
import totalBet.constants.Constants;
import totalBet.pages.common.HeaderPage;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class RegistrationPage extends HeaderPage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private ActionsHelper actionsHelper = new ActionsHelper();

    @FindBy(id = "name")
    private WebElement fullNameTextbox;
    @FindBy(id = "email")
    private WebElement emailTextbox;
    @FindBy(id = "password")
    private WebElement passwordTextbox;
    @FindBy(id = "password-confirm")
    private WebElement confirmPasswordTextbox;
    @FindBy(xpath = "//*[contains(text(), 'Trimite')]")
    private WebElement submitButton;
    @FindBy(xpath = "//*[.='Date cont']")
    private WebElement accountTitle;
    @FindBy(xpath = "//*[@class='auth-user']")
    private WebElement profileNameRegistered;
    @FindBy(xpath = "//*[@role='alert']")
    private WebElement emailTakenAlert;

    public void clickOnRegistrationLink() {
        actionsHelper.clickOnElement(getMyAccount());
        actionsHelper.clickOnElement(getRegisterLink());
    }

    public void fillInRegistrationForm(HashMap<String, String> data) {
        actionsHelper.fillInText(fullNameTextbox, data.get("fullName"));
        actionsHelper.fillInText(emailTextbox, data.get("email"));
        actionsHelper.fillInText(passwordTextbox, data.get("password"));
        actionsHelper.fillInText(confirmPasswordTextbox, data.get("password"));
        actionsHelper.submitButton(submitButton);
    }

    public void successfullyCompletedRegistration(HashMap<String, String> data) throws InterruptedException {
        actionsHelper.waitForElementVisibility(accountTitle, driver);
        assertTrue("The title is not displayed", accountTitle.isDisplayed());
        actionsHelper.clickOnElement(getMyAccount());
        actionsHelper.waitForElementVisibility(profileNameRegistered, driver);
        assertTrue("The profile name is different", profileNameRegistered.getText().equals(data.get("fullName")));
    }

    public void receivingRegistrationErrorMessage() {
        assertTrue("The email has not been taken", emailTakenAlert.isDisplayed());
    }
}

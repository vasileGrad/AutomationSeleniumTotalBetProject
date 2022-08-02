package totalBet.pages.account.authentication;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import totalBet.common.ActionsHelper;
import totalBet.constants.Constants;

import java.util.HashMap;

public class RegistrationPage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private ActionsHelper actionsHelper = new ActionsHelper();

    @FindBy(xpath = "//*[.='Contul meu']")
    private WebElement myAccount;
    @FindBy(xpath = "//*[.='Înregistrare']")
    private WebElement registerLink;
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
    @FindBy(xpath = "//a[.='Acasă']")
    private WebElement homeMenu;
    @FindBy(xpath = "//*[@class='auth-user']")
    private WebElement profileNameRegistered;
    @FindBy(xpath = "//*[@role='alert']")
    private WebElement emailTakenAlert;

    public void clickOnRegistrationMenu() {
        actionsHelper.clickOnElement(myAccount);
        actionsHelper.clickOnElement(registerLink);
    }

    public void fillInRegistrationForm(HashMap<String, String> data) {
        actionsHelper.fillInText(fullNameTextbox, data.get("fullName"));
        actionsHelper.fillInText(emailTextbox, data.get("email"));
        actionsHelper.fillInText(passwordTextbox, data.get("password"));
        actionsHelper.fillInText(confirmPasswordTextbox, data.get("password"));
        actionsHelper.submitButton(submitButton);
    }

    public void successfullyCompletedRegistration(HashMap<String, String> data) throws InterruptedException {
        accountTitle.isDisplayed();
        actionsHelper.clickOnElement(myAccount);
        Thread.sleep(Constants.SHORT_SLEEP);
        Assert.assertTrue("The profile name is different", profileNameRegistered.getText().equals(data.get("fullName")));
    }

    public void receivingRegistrationErrorMessage() {
        Assert.assertTrue("The email has not been taken", emailTakenAlert.isDisplayed());
    }
}

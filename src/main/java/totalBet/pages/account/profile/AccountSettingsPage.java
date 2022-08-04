package totalBet.pages.account.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import totalBet.common.ActionsHelper;
import totalBet.constants.Constants;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountSettingsPage {

    WebDriver driver;

    public AccountSettingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private ActionsHelper actionsHelper = new ActionsHelper();

    @FindBy(xpath = "//*[.='Contul meu']")
    private WebElement myAccount;
    @FindBy(xpath = "//*[@class='auth-user']")
    private WebElement profileNameRegistered;
    @FindBy(xpath = "//*[.='Setari cont']")
    private WebElement accountSettingsLink;
    @FindBy(xpath = "//*[@class='account-title']")
    private WebElement accountTitle;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement name;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phone;
    @FindBy(xpath = "//input[@name='actual-password']")
    private WebElement actualPassword;
    @FindBy(xpath = "//input[@name='new-password']")
    private WebElement newPassword;
    @FindBy(xpath = "//input[@name='confirm-new-password']")
    private WebElement confirmNewPassword;
    @FindBy(xpath = "//*[@class='submit-group']")
    private WebElement saveModificationsButton;
    @FindBy(xpath = "//*[@class='account-menu-item active']")
    private WebElement accountSettingsMenuItem;

    public void clickOnAccountSettingsLink() {
        actionsHelper.clickOnElement(accountSettingsLink);
    }

    public void verifyAccountSettingsPage() {
        assertTrue("The account settings page is not shown", accountTitle.getText().equals("Date cont"));
    }

    public void verifyAccountSettingsNameAndEmail(HashMap<String, String> data) {
        assertEquals("The user name doesn't match", data.get("fullName"), name.getAttribute(Constants.VALUE));
        assertEquals("The email doesn't match", data.get("email"), email.getAttribute(Constants.VALUE));
    }

    public void changePhoneNumber(String phoneNumber) {
        actionsHelper.fillInText(phone, phoneNumber);
    }

    public void clickOnSaveModificationsButton() {
        actionsHelper.submitButton(saveModificationsButton);
    }

    public void verifyPhoneNumberIsPresent(String phoneNumber) {
        assertEquals("The phone number was not changed", phoneNumber, phone.getAttribute(Constants.VALUE));
    }

    public void changeActualPasswordWithNewPassword(HashMap<String, String> data) {
        actionsHelper.fillInText(actualPassword, data.get("actualPassword"));
        actionsHelper.fillInText(newPassword, data.get("newPassword"));
        actionsHelper.fillInText(confirmNewPassword, data.get("newPassword"));

        assertEquals("The new password is not equal with confirmation password", newPassword.getText(), confirmNewPassword.getText());
    }

    public void verifyNewPasswordChanged() {
        boolean arePasswordsClear = actualPassword.getText().isEmpty() && newPassword.getText().isEmpty() && confirmNewPassword.getText().isEmpty();
        assertTrue("The password was not changed", arePasswordsClear);
    }
}

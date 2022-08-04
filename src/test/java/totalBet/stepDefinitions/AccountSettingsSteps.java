package totalBet.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import totalBet.cucumber.TestContext;
import totalBet.data.TestData;
import totalBet.pages.profile.AccountSettingsPage;

public class AccountSettingsSteps {
    AccountSettingsPage accountSettingsPage;

    public AccountSettingsSteps(TestContext testContext) {
        accountSettingsPage = testContext.getPageObjectManager().getAccountSettingsPage();
    }

    @When("I click on account settings link")
    public void clickOnAccountSettingsLink() {
        accountSettingsPage.clickOnAccountSettingsLink();
    }

    @Then("I should see the account settings page")
    public void verifyAccountSettingsPage() {
        accountSettingsPage.verifyAccountSettingsPage();
    }

    @And("I should have the same name and email")
    public void verifyAccountSettingsNameAndEmail() {
        accountSettingsPage.verifyAccountSettingsNameAndEmail(TestData.accountSettingsFormTestData());
    }

    @And("I change the phone number")
    public void changePhoneNumber() {
        accountSettingsPage.changePhoneNumber(TestData.accountSettingsFormTestData().get("phone"));
    }

    @And("I click on save modifications button")
    public void clickOnSaveModificationsButton() {
        accountSettingsPage.clickOnSaveModificationsButton();
    }

    @Then("I should see the phone number saved")
    public void verifyPhoneNumberIsPresent() {
        accountSettingsPage.verifyPhoneNumberIsPresent(TestData.accountSettingsFormTestData().get("phone"));
    }

    @And("I change the actual password with a new password")
    public void changeActualPasswordWithNewPassword() {
        accountSettingsPage.changeActualPasswordWithNewPassword(TestData.accountSettingsFormTestData());
    }

    @Then("I should change successfully the new password")
    public void verifyNewPasswordChanged() {
        accountSettingsPage.verifyNewPasswordChanged();
    }
}

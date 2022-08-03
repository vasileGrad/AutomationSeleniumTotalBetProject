package totalBet.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import totalBet.constants.Constants;
import totalBet.data.TestData;
import totalBet.pages.account.authentication.LoginPage;
import totalBet.pages.account.authentication.RegistrationPage;
import totalBet.pages.account.profile.AccountSettingsPage;
import totalBet.pages.account.ticket.results.VerifyTicketPage;
import totalBet.pages.account.ticket.sportsBet.SportsBetPage;

import java.time.Duration;

public class Steps {
    private WebDriver driver;
    public RegistrationPage registrationPage;
    public LoginPage loginPage;
    public SportsBetPage sportsBetPage;
    public AccountSettingsPage accountSettingsPage;
    public VerifyTicketPage verifyTicketPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Endava\\Internship\\Courses\\Technologies\\Selenium\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://totalbet.ro/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.SHORT_TIME_SECONDS));

        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        sportsBetPage = new SportsBetPage(driver);
        accountSettingsPage = new AccountSettingsPage(driver);
        verifyTicketPage = new VerifyTicketPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // Registration Steps   - Start
    @Given("I click on registration link")
    public void clickOnRegistrationLink() {
        registrationPage.clickOnRegistrationLink();
    }

    @When("I fill in registration form details")
    public void fillInRegistrationForm() {
        registrationPage.fillInRegistrationForm(TestData.registrationFormTestData());
    }

    @Then("I have successfully completed the registration")
    public void successfullyCompletedRegistration() throws InterruptedException {
        registrationPage.successfullyCompletedRegistration(TestData.registrationFormTestData());
    }

    @Then("I receive a registration error message")
    public void receivingRegistrationErrorMessage() {
        registrationPage.receivingRegistrationErrorMessage();
    }


    // Login Steps   - Start
    @Given("I click on login link")
    public void clickOnLoginLink() {
        loginPage.clickOnLoginLink();
    }

    @When("I fill in valid login email and password")
    public void fillInValidLoginCredentials() {
        loginPage.fillInValidLoginCredentials(TestData.loginFormTestData());
    }

    @When("^I fill invalid email as (.*) and valid password as (.*)$")
    public void fillInvalidEmailAndValidPassword(String wrongEmail, String password) {
        loginPage.fillInEmailAndPassword(wrongEmail, password);
    }

    @When("^I fill valid email as (.*) and invalid password as (.*)$")
    public void fillValidEmailAndInvalidPassword(String email, String wrongPassword) {
        loginPage.fillInEmailAndPassword(email, wrongPassword);
    }

    @And("I click on submit button")
    public void clickOnSubmitButton() {
        loginPage.clickOnSubmitButton();
    }

    @Then("I should see my profile page")
    public void successfullyLoggedIn() throws InterruptedException {
        loginPage.successfullyLoggedIn();
    }

    @Given("I am an authenticated user")
    public void verifyAuthenticatedUser() {
        loginPage.verifyAuthenticatedUser();
    }

    @And("I should see logout button")
    public void verifyLogoutButton() {
        loginPage.verifyLogoutButton();
    }

    @When("I click on logout button")
    public void clickOnLogoutButton() {
        loginPage.clickOnLogoutButton();
    }

    @Then("I should see login link")
    public void verifyLoginLink() throws InterruptedException {
        loginPage.verifyLoginLink();
    }

    @Then("I should receive a login error message")
    public void receivingLoginErrorMessage() {
        loginPage.receivingLoginErrorMessage();
    }

    @Then("I should receive email and password error messages")
    public void receiveEmailAndPasswordErrorMessage() {
        loginPage.receiveEmailAndPasswordErrorMessages();
    }

    // Account Settings
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

    // Sports Bet Ticket
    // Place Ticket
    @When("I click on sports bet menu")
    public void clickOnSportsBetMenu() {
        sportsBetPage.clickOnSportsBetMenu();
    }

    @And("I click on the current date")
    public void clickOnCurrentDate() {
        sportsBetPage.clickOnCurrentDate();
    }

    @And("I choose Football sport")
    public void chooseFootballSport() {
        sportsBetPage.chooseFootballSport();
    }

    @And("I click on the first ticket number")
    public void chooseFirstTicketNumber() {
        sportsBetPage.chooseFirstTicketNumber();
    }

    @And("I place the sports bet ticket")
    public void placeSportsBetTicket() throws InterruptedException {
        sportsBetPage.placeSportsBetTicket(TestData.sportsBetTicketTestData());
    }

    @Then("I should see the number of sports bet in the right list")
    public void shouldSeeNumberOfSportsBetInRightList() {
        sportsBetPage.shouldSeeNumberOfSportsBetInRightList(TestData.sportsBetTicketTestData());
    }

    @And("I delete all the sports bet")
    public void shouldDeleteAllSportsBet() {
        sportsBetPage.shouldDeleteAllSportsBet();
    }

    @And("I remove the first ticket from the right list")
    public void deleteTicketFromRightList() {
        sportsBetPage.deleteTicketFromRightList();
    }

    @And("I should not see the sports bet in the right list")
    public void shouldNotSeeTheSportsBetInTheRightList() {
        sportsBetPage.shouldNotSeeTheSportsBetInTheRightList();
    }

    @Then("I should see the number of sports bet in the right list to be correct")
    public void shouldSeeNumberOfSportsBetInRightListBeCorrect() {
        sportsBetPage.shouldSeeNumberOfSportsBetInRightListBeCorrect(TestData.sportsBetTicketTestData());
    }

    @And("I successfully placed and saved the sports bet ticket")
    public void successfullyPlacedAndSavedSportsBetTicket() throws InterruptedException {
        sportsBetPage.successfullyPlacedAndSavedSportsBetTicket();
    }

    @Then("I verify the sports bet ticket data value is calculated correctly")
    public void verifySportsBetTicketDataValueIsCalculatedCorrectly() {
        sportsBetPage.verifySportsBetTicketDataValueIsCalculatedCorrectly();
    }

    // Verify Ticket
    @When("I click on home menu")
    public void clickOnHomeMenu() {
        verifyTicketPage.clickOnHomeMenu();
    }

    @And("I click on search input ticket")
    public void clickOnSearchInputTicket() {
        verifyTicketPage.clickOnSearchInputTicket();
    }

    @And("I fill in a valid sports bet ticket code")
    public void fillInValidSportsBetTicketCode() {
        verifyTicketPage.fillInValidSportsBetTicketCode(TestData.ticketTestData().getCode());
    }

    @And("I click on verify ticket button")
    public void clickOnVerifyTicketButton() {
        verifyTicketPage.clickOnVerifyTicketButton();
    }

    @And("I wait for the pop-up to appear")
    public void waitForPopUpToAppear() {
        verifyTicketPage.waitForPopUpToAppear();
    }

    @Then("I should see correctly the ticket code")
    public void verifyPopUpTicketCodeIsDisplayedCorrectly() {
        verifyTicketPage.verifyPopUpTicketCodeIsDisplayedCorrectly(TestData.ticketTestData().getCode());
    }

    @And("I should see correctly the ticket status")
    public void verifyPopUpTicketStatusIsDisplayedCorrectly() {
        verifyTicketPage.verifyPopUpTicketStatusIsDisplayedCorrectly(TestData.ticketTestData().getStatus());
    }

    @Then("I should see the ticket max win value is displayed")
    public void verifyPopUpTicketContainsMaxWinValue() {
        verifyTicketPage.verifyPopUpTicketContainsMaxWinValue(TestData.ticketTestData().getMaxWin());
    }

    @Then("I should see the details of the ticket correctly")
    public void verifyTicketDetailsAreCorrectlyDisplayed() {
        verifyTicketPage.verifyTicketDetailsAreCorrectlyDisplayed(TestData.ticketTestData());
    }

    @Then("I should see the max win of the ticket correctly")
    public void verifyMaxWinTicketIsCorrectlyDisplayed() {
        verifyTicketPage.verifyMaxWinTicketIsCorrectlyDisplayed(TestData.ticketTestData().getMaxWin());
    }
}

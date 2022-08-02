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
import totalBet.pages.account.ticket.sportsBet.SportsBetPage;

import java.time.Duration;

public class Steps {
    private WebDriver driver;
    public RegistrationPage registrationPage;
    public LoginPage loginPage;
    public SportsBetPage sportsBetPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Endava\\Internship\\Courses\\Technologies\\Selenium\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://totalbet.ro/");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.LONG_WAIT));

        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        sportsBetPage = new SportsBetPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // Registration Steps   - Start
    @Given("^I click on registration menu$")
    public void clickOnRegistrationMenu() {
        registrationPage.clickOnRegistrationMenu();
    }

    @When("^I fill in registration form details$")
    public void fillInRegistrationForm() {
        registrationPage.fillInRegistrationForm(TestData.registrationFormTestData());
    }

    @Then("^I have successfully completed the registration$")
    public void successfullyCompletedRegistration() throws InterruptedException {
        registrationPage.successfullyCompletedRegistration(TestData.registrationFormTestData());
    }

    @Then("^I receive a registration error message$")
    public void receivingRegistrationErrorMessage() {
        registrationPage.receivingRegistrationErrorMessage();
    }


    // Login Steps   - Start
    @Given("^I click on login menu$")
    public void clickOnLoginMenu() {
        loginPage.clickOnLoginMenu();
    }

    @When("^I fill in valid login email and password$")
    public void fillInValidLoginCredentials() {
        loginPage.fillInValidLoginCredentials(TestData.loginFormTestData());
    }

    @When("^I fill invalid email as (.*) and valid password as (.*)$")
    public void fillInvalidEmailAndValidPassword(String wrongEmail, String password) {
        loginPage.fillInvalidEmailAndValidPassword(wrongEmail, password);
    }

    @Then("^I should see my profile page$")
    public void successfullyLoggedIn() throws InterruptedException {
        loginPage.successfullyLoggedIn();
    }

    @Given("^I am an authenticated user$")
    public void verifyAuthenticatedUser() {
        loginPage.verifyAuthenticatedUser();
    }

    @Then("^I should receive a login error message$")
    public void receivingLoginErrorMessage() {
        loginPage.receivingLoginErrorMessage();
    }

    // Sports Bet Ticket
    @When("^I click on sports bet menu$")
    public void clickOnSportsBetMenu() {
        sportsBetPage.clickOnSportsBetMenu();
    }

    @And("^I click on the current date$")
    public void clickOnCurrentDate() {
        sportsBetPage.clickOnCurrentDate();
    }

    @And("^I choose Football sport$")
    public void chooseFootballSport() {
        sportsBetPage.chooseFootballSport();
    }

    @And("^I click on the first ticket number$")
    public void chooseFirstTicketNumber() {
        sportsBetPage.chooseFirstTicketNumber();
    }

    @And("^I place the sports bet ticket$")
    public void placeSportsBetTicket() throws InterruptedException {
        sportsBetPage.placeSportsBetTicket(TestData.sportsBetTicketTestData());
    }

    @Then("^I should see the number of sports bet in the right list$")
    public void shouldSeeNumberOfSportsBetInRightList() {
        sportsBetPage.shouldSeeNumberOfSportsBetInRightList(TestData.sportsBetTicketTestData());
    }

    @And("^I delete all the sports bet$")
    public void shouldDeleteAllSportsBet() {
        sportsBetPage.shouldDeleteAllSportsBet();
    }

    @And("^I remove the first ticket from the right list$")
    public void deleteTicketFromRightList() {
        sportsBetPage.deleteTicketFromRightList();
    }

    @And("^I should not see the sports bet in the right list$")
    public void shouldNotSeeTheSportsBetInTheRightList() {
        sportsBetPage.shouldNotSeeTheSportsBetInTheRightList();
    }

    @Then("^I should see the number of sports bet in the right list to be correct$")
    public void shouldSeeNumberOfSportsBetInRightListBeCorrect() {
        sportsBetPage.shouldSeeNumberOfSportsBetInRightListBeCorrect(TestData.sportsBetTicketTestData());
    }

    @And("^I successfully placed and saved the sports bet ticket$")
    public void successfullyPlacedAndSavedSportsBetTicket() throws InterruptedException {
        sportsBetPage.successfullyPlacedAndSavedSportsBetTicket();
    }

    @Then("^I verify the sports bet ticket data value is calculated correctly$")
    public void verifySportsBetTicketDataValueIsCalculatedCorrectly() {
        sportsBetPage.verifySportsBetTicketDataValueIsCalculatedCorrectly();
    }
}

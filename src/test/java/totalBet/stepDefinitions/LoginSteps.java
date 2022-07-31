package totalBet.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import totalBet.ActionsHelper;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver;
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

    String email = "dacekib883@altpano.com";
    String password = "Text1234";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Endava\\Internship\\Courses\\Technologies\\Selenium\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://totalbet.ro/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I click on login menu")
    public void clickOnLoginMenu() {
        PageFactory.initElements(driver, this);
        actionsHelper.clickOnElement(myAccount);
        actionsHelper.clickOnElement(loginLink);
    }

    @When("I fill in valid login email and password")
    public void fillInValidLoginCredentials() {
        actionsHelper.fillInText(emailTextbox, email);
        actionsHelper.fillInText(passwordTextbox, password);
        actionsHelper.submitButton(submitButton);
    }

    @When("^I fill invalid ([^\"]*) and valid ([^\"]*)$")
    public void fillInvalidEmailAndValidPassword(String wrongEmail, String password) {
        actionsHelper.fillInText(emailTextbox, wrongEmail);
        actionsHelper.fillInText(passwordTextbox, password);
        actionsHelper.submitButton(submitButton);
    }

    @Then("I should see my profile page")
    public void successfullyLoggedIn() {
        actionsHelper.clickOnElement(myAccount);
        Assert.assertTrue("The profile name is different", profileNameRegistered.isDisplayed());
    }

    @Then("I should receive an error message")
    public void receivingErrorMessage() {
        Assert.assertTrue("The email has not been taken", emailTakenAlert.isDisplayed());
    }
}

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

public class RegistrationSteps {

    WebDriver driver;

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

    String fullName = "Dace Altpano";
    String email = "dacekib883@altpano.com";
    String password = "Text1234";


    @Given("I click on registration menu")
    public void clickOnRegistrationMenu() {
        PageFactory.initElements(driver, this);
        actionsHelper.clickOnElement(myAccount);
        actionsHelper.clickOnElement(registerLink);
    }

    @When("I fill in registration form details")
    public void fillInRegistrationForm() {
        actionsHelper.fillInText(fullNameTextbox, fullName);
        actionsHelper.fillInText(emailTextbox, email);
        actionsHelper.fillInText(passwordTextbox, password);
        actionsHelper.fillInText(confirmPasswordTextbox, password);
        actionsHelper.submitButton(submitButton);
    }

    @Then("I have successfully completed the registration")
    public void successfullyCompletedRegistration() {
        accountTitle.isDisplayed();
        actionsHelper.clickOnElement(myAccount);
        Assert.assertTrue("The profile name is different", profileNameRegistered.getText().contains(fullName));
    }

    @Then("I receive an error message")
    public void receivingErrorMessage() {
        Assert.assertTrue("The email has not been taken", emailTakenAlert.isDisplayed());
    }

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
}
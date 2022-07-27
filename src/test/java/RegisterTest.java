import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import training.ActionsHelper;
import training.BaseTest;

public class RegisterTest extends BaseTest {

    ActionsHelper actionsHelper = new ActionsHelper();
    WebElement myAccount;
    String fullName = "Mevemy Agrolivana";
    //String fullName = "Car ma3";
    String email = "mevemiy314@agrolivana.com";
    //String email = "mev314@ca3.com";
    String password = "Text1234";
    String profileName;

    @Test
    public void registerTest() {
        myAccount = driver.findElement(By.xpath("//*[.='Contul meu']"));
        actionsHelper.clickOnElement(myAccount);

        WebElement registerLink = driver.findElement(By.xpath("//*[.='Înregistrare']"));
        actionsHelper.clickOnElement(registerLink);

        WebElement fullNameTextbox = driver.findElement(By.id("name"));
        actionsHelper.fillInText(fullNameTextbox, fullName);

        WebElement emailTextbox = driver.findElement(By.id("email"));
        actionsHelper.fillInText(emailTextbox, email);

        WebElement passwordTextbox = driver.findElement(By.id("password"));
        actionsHelper.fillInText(passwordTextbox, password);

        WebElement confirmPasswordTextbox = driver.findElement(By.id("password-confirm"));
        actionsHelper.fillInText(confirmPasswordTextbox, password);

        WebElement submitButton = driver.findElement(By.xpath("//*[contains(text(), 'Trimite')]"));
        actionsHelper.submitButton(submitButton);

        WebElement accountTitle = driver.findElement(By.xpath("//*[.='Date cont']"));
        accountTitle.isDisplayed();

        WebElement homeMenu = driver.findElement(By.xpath("//a[.='Acasă']"));
        actionsHelper.clickOnElement(homeMenu);

        myAccount = driver.findElement(By.xpath("//*[.='Contul meu']"));
        actionsHelper.clickOnElement(myAccount);

        profileName = "//*[.='" + fullName + "']";
        WebElement profileNameRegistered = driver.findElement(By.xpath(profileName));

        Assert.assertTrue("The profile name is different", profileNameRegistered.getText().contains(fullName));
    }

    @Test
    public void registerWithRegisteredAccountTest() {
        myAccount = driver.findElement(By.xpath("//*[.='Contul meu']"));
        actionsHelper.clickOnElement(myAccount);

        WebElement registerLink = driver.findElement(By.xpath("//*[.='Înregistrare']"));
        actionsHelper.clickOnElement(registerLink);

        WebElement fullNameTextbox = driver.findElement(By.id("name"));
        actionsHelper.fillInText(fullNameTextbox, fullName);

        WebElement emailTextbox = driver.findElement(By.id("email"));
        actionsHelper.fillInText(emailTextbox, email);

        WebElement passwordTextbox = driver.findElement(By.id("password"));
        actionsHelper.fillInText(passwordTextbox, password);

        WebElement confirmPasswordTextbox = driver.findElement(By.id("password-confirm"));
        actionsHelper.fillInText(confirmPasswordTextbox, password);

        WebElement submitButton = driver.findElement(By.xpath("//*[contains(text(), 'Trimite')]"));
        actionsHelper.submitButton(submitButton);

        WebElement emailTakenAlert = driver.findElement(By.xpath("//*[@role='alert']"));
        Assert.assertTrue("The email has not been taken", emailTakenAlert.isDisplayed());
    }
}

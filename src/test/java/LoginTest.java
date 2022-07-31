import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import totalBet.ActionsHelper;
import totalBet.BaseTest;

public class LoginTest extends BaseTest {

    ActionsHelper actionsHelper = new ActionsHelper();
    WebElement myAccount;
    String email = "dacekib883@altpano.com";
    String wrongEmail = "dacekib883@altpano2.com";
    String password = "Text1234";
    String fullName = "Dace Altpano";
    String profileName;

    @Test
    public void loginTest() {
        myAccount = driver.findElement(By.xpath("//*[.='Contul meu']"));
        actionsHelper.clickOnElement(myAccount);

        WebElement loginLink = driver.findElement(By.xpath("//*[.='Autentificare']"));
        actionsHelper.clickOnElement(loginLink);

        WebElement emailTextbox = driver.findElement(By.id("email"));
        actionsHelper.fillInText(emailTextbox, email);

        WebElement passwordTextbox = driver.findElement(By.id("password"));
        actionsHelper.fillInText(passwordTextbox, password);

        WebElement submitButton = driver.findElement(By.xpath("//*[contains(text(), 'Trimite')]"));
        actionsHelper.submitButton(submitButton);

        myAccount = driver.findElement(By.xpath("//*[.='Contul meu']"));
        actionsHelper.clickOnElement(myAccount);

        profileName = "//*[.='" + fullName + "']";
        WebElement profileNameRegistered = driver.findElement(By.xpath(profileName));

        Assert.assertTrue("The profile name is different", profileNameRegistered.getText().contains(fullName));
    }

    @Test
    public void loginWithWrongEmailTest() {
        myAccount = driver.findElement(By.xpath("//*[.='Contul meu']"));
        actionsHelper.clickOnElement(myAccount);

        WebElement loginLink = driver.findElement(By.xpath("//*[.='Autentificare']"));
        actionsHelper.clickOnElement(loginLink);

        WebElement emailTextbox = driver.findElement(By.id("email"));
        actionsHelper.fillInText(emailTextbox, wrongEmail);

        WebElement passwordTextbox = driver.findElement(By.id("password"));
        actionsHelper.fillInText(passwordTextbox, password);

        WebElement submitButton = driver.findElement(By.xpath("//*[contains(text(), 'Trimite')]"));
        actionsHelper.submitButton(submitButton);

        WebElement emailTakenAlert = driver.findElement(By.xpath("//*[@role='alert']"));
        Assert.assertTrue("The email has not been taken", emailTakenAlert.isDisplayed());
    }
}

package totalBet.common;

import org.openqa.selenium.WebElement;

public class ActionsHelper {

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void fillInText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void submitButton(WebElement element) {
        element.submit();
    }

    public boolean equals(String first, String second) {
        return first.equals(second);
    }
}

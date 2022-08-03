package totalBet.common;

import org.openqa.selenium.WebElement;
import totalBet.constants.Constants;

import java.text.DecimalFormat;
import java.util.Arrays;

public class ActionsHelper {

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void fillInText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void submitButton(WebElement element) {
        element.submit();
    }

    public boolean equals(String first, String second) {
        return first.equals(second);
    }

    public double formatDoubleResult(double value) {
        DecimalFormat formatResult = new DecimalFormat(Constants.BET_FORMAT_VALUE);
        return Double.valueOf(formatResult.format(value));
    }

    public String extractFirstWordFromString(String string) {
        return Arrays.stream(string.split(Constants.SPACE)).findFirst().map(Object::toString).get();
    }

    public String extractWordFromString(String string, int index) {
        String[] words = string.split(Constants.SPACE);
        return words[index];
    }
}

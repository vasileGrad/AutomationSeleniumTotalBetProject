import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import training.ActionsHelper;
import training.BaseTest;

import java.util.List;
import java.util.Random;

public class CreateTicketTest extends BaseTest {

    ActionsHelper actionsHelper = new ActionsHelper();
    private WebElement footballSport;
    private List<WebElement> eventsOdd;

    @Test
    public void createTicketCurrentDateTest() throws InterruptedException {
        WebElement sportBetsLink = driver.findElement(By.xpath("//a[.='Pariuri Sportive']"));
        actionsHelper.clickOnElement(sportBetsLink);

        WebElement currentQuickDateOption = driver.findElement(By.xpath("//*[@class='quick-day active']"));
        actionsHelper.clickOnElement(currentQuickDateOption);

        footballSport = driver.findElement(By.xpath("//*[.='Fotbal']"));
        actionsHelper.clickOnElement(footballSport);

        eventsOdd = driver.findElements(By.xpath("//*[@class='event-odds count8']/*[" + getRandom(7) + "]"));

        for (int i = 0; i < 10; i++) {
            WebElement oddEvent = eventsOdd.get(i);
            actionsHelper.clickOnElement(oddEvent);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", oddEvent);
            Thread.sleep(200);
        }
    }

    public int getRandom(int bound) {
        Random random = new Random();
        return random.nextInt(bound) + 1;
    }
}

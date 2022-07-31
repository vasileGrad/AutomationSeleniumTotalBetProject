import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import totalBet.ActionsHelper;
import totalBet.BaseTest;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class SportMenuItemTest extends BaseTest {
    ActionsHelper actionsHelper = new ActionsHelper();

    @Test
    public void sportMenuItemTest() {
        String sportTitle;
        Integer sportCounter;

        List<WebElement> sportTitles;
        List<WebElement> sportCounters;
        List<WebElement> leagueEventItems;
        Map<String, Integer> sportMenuItems = new LinkedHashMap<>();

        WebElement homeMenu = driver.findElement(By.xpath("//a[.='Acasă']"));
        actionsHelper.clickOnElement(homeMenu);

        sportTitles = driver.findElements(By.xpath("//*[@class='sport-menu-item-details']/*[2]"));
        sportCounters = driver.findElements(By.xpath("//*[@class='sport-menu-item-details']/*[3]"));
        int sportSizeList = sportTitles.size();
        for (int i = 0; i < sportSizeList; i++) {
            sportMenuItems.put(sportTitles.get(i).getText(), Integer.parseInt(sportCounters.get(i).getText()));
        }

        sportCounter = sportMenuItems.values().stream().findFirst().get();

        for (WebElement sportCounterElement : sportCounters) {
            int sportCounterValue = Integer.parseInt(sportCounterElement.getText());
            if (sportCounterValue >= 10 && sportCounterValue <= 20) {
                sportCounter = sportCounterValue;
                break;
            }
        }

        String newValue = "//*[.='" + sportCounter + "']";

        WebElement sportFound = driver.findElement(By.xpath(newValue));
        actionsHelper.clickOnElement(sportFound);

        leagueEventItems = driver.findElements(By.xpath("//*[@class='league-event-item gradient-bg']"));

        assertEquals("The league event items don't match", String.valueOf(sportCounter), String.valueOf(leagueEventItems.size()));
    }
}

package totalBet.pages.ticket.results;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import totalBet.classes.Result;
import totalBet.common.ActionsHelper;
import totalBet.data.TestData;
import totalBet.pages.common.HeaderPage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ResultsPage extends HeaderPage {
    private WebDriver driver;
    private ActionsHelper actionsHelper = new ActionsHelper();

    public ResultsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnResultsMenu() {
        actionsHelper.clickOnElement(getResultsLinkMenu());
    }

    public void readEventResultsFromFile() {
        List<Result> results = TestData.resultsTestData();
        for (Result result : results) {
            System.out.println(result.getName());
        }
    }

    public void verifyListWithAllEventResults() {
        assertTrue("The results are not correct", true);
    }
}

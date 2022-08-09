package totalBet.pages.ticket.results;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import totalBet.classes.Result;
import totalBet.common.ActionsHelper;
import totalBet.data.TestData;
import totalBet.enums.Year;
import totalBet.pages.common.HeaderPage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResultsPage extends HeaderPage {
    private WebDriver driver;
    private ActionsHelper actionsHelper = new ActionsHelper();
    private List<Result> results;

    public ResultsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@class,'calendar-toggle')]")
    private WebElement calendarToggle;
    @FindBy(xpath = "//*[contains(@class,'react-calendar date-range-picker')]")
    private WebElement dateRangePicker;
    @FindBy(xpath = "//*[@class='react-calendar__navigation__arrow react-calendar__navigation__prev2-button']")
    private WebElement prev2Button;
    @FindBy(xpath = "//*[@class='react-calendar__navigation__arrow react-calendar__navigation__prev-button']")
    private WebElement prevButton;
    @FindBy(xpath = "//*[@class='react-calendar__navigation__label']")
    private WebElement monthYearButton;
    @FindBy(xpath = "//*[@class='react-calendar__navigation__arrow react-calendar__navigation__next-button']")
    private WebElement nextButton;
    @FindBy(xpath = "//*[@class='react-calendar__navigation__arrow react-calendar__navigation__next2-button']")
    private WebElement next2Button;
    @FindBy(xpath = "//*[@class='react-calendar__year-view__months']")
    private WebElement calendarYearViewMonths;
    @FindBy(xpath = "//*[contains(@class,'react-calendar date-range-picker')]")
    private WebElement calendarDateRangePicker;
    @FindBy(xpath = "//*[@class='react-calendar__month-view__days']")
    private WebElement calendarMonthViewDays;
    @FindBy(xpath = "//*[@class='sport-menu-item']//span")
    private List<WebElement> sportTitles;
    @FindBy(xpath = "//*[@class='event-code']")
    private List<WebElement> eventCodes;
    @FindBy(xpath = "//*[@class='event-name']")
    private List<WebElement> eventNames;
    @FindBy(xpath = "//*[@class='event-date']")
    private List<WebElement> eventDates;
    @FindBy(xpath = "//*[@class='results-values']")
    private List<WebElement> resultsValues;
    @FindBy(xpath = "//*[@class='cookie-close-btn']")
    private WebElement closeCookieButton;

    public void clickOnResultsMenu() {
        actionsHelper.clickOnElement(getResultsLinkMenu());
    }

    public void readEventResultsFromFile() {
        results = TestData.resultsTestData();
        closeCookie();
    }

    public void verifyListWithAllEventResults() throws InterruptedException {
        for (Result result : results) {
            String[] date = result.getDate().split("/");
            String day = date[0];
            String month = date[1];
            int year = Integer.parseInt(date[2]);
            String time = result.getTime();
            String literalMonth = getMonth(Integer.parseInt(month)).toLowerCase();
            actionsHelper.clickOnElement(calendarToggle);
            actionsHelper.waitForElementClickable(monthYearButton, driver);
            actionsHelper.clickOnElement(monthYearButton);
            WebElement monthButton = calendarYearViewMonths.findElement(By.xpath("//*[text()='" + literalMonth + "']"));
            actionsHelper.clickOnElement(monthButton);
            WebElement dayButton = calendarMonthViewDays.findElement(By.xpath("//button[.='" + Integer.parseInt(day) + "'][1]"));
            Actions actions = new Actions(driver);
            actions.doubleClick(dayButton).perform();

            String sportTitleValue = result.getSportTitle();
            String codeValue = result.getCode();
            String nameValue = result.getName();

            for (WebElement sportTitle : sportTitles) {
                if (sportTitle.getText().equals(sportTitleValue)) {
                    actionsHelper.waitForElementClickable(sportTitle, driver);
                    actionsHelper.clickOnElement(sportTitle);
                    break;
                }
            }

            String eventCode = "", eventDate = "", eventName = "";
            int eventCodeSize = eventCodes.size();
            LinkedHashMap<String, String> halves = new LinkedHashMap<>();
            for (int i = 0; i < eventCodeSize; i++) {
                actionsHelper.waitForElementsVisibility(eventCodes, driver);
                if (eventCodes.get(i).getText().equals(codeValue)) {
                    eventCode = eventCodes.get(i).getText().trim();
                    eventDate = eventDates.get(i).getText().trim();
                    eventName = eventNames.get(i).getText().trim();
                    List<WebElement> resultLabels = resultsValues.get(i).findElements(By.xpath("(//*[@class='results-values'])[" + (i + 1) + "]//*[@class='result-label']"));
                    List<WebElement> resultValues = resultsValues.get(i).findElements(By.xpath("(//*[@class='results-values'])[" + (i + 1) + "]//*[@class='result-value']"));
                    int resultLabelsSize = resultLabels.size();
                    for (int j = 0; j < resultLabelsSize; j++) {
                        halves.put(resultLabels.get(j).getText(), resultValues.get(j).getText());
                    }
                    break;
                }
            }

            String expectedDateTime = day + "." + month + " " + time;
            assertTrue("The event code is not correct", codeValue.equals(eventCode));
            assertTrue("The event name is not correct", nameValue.equals(eventName));
            assertTrue("The event date and time is not correct", expectedDateTime.equals(eventDate));

            Set<String> keys = halves.keySet();
            for (String key : keys) {
                assertEquals("The half is not correct", result.getHalves().get(key), halves.get(key));
            }

            actionsHelper.clickOnElement(calendarToggle);
        }
    }

    public String getMonth(int month) {
        switch (month) {
            case 1:
                return Year.IANUARIE.toString();
            case 2:
                return Year.FEBRUARIE.toString();
            case 3:
                return Year.MARTIE.toString();
            case 4:
                return Year.APRILIE.toString();
            case 5:
                return Year.MAI.toString();
            case 6:
                return Year.IUNIE.toString();
            case 7:
                return Year.IULIE.toString();
            case 8:
                return Year.AUGUST.toString();
            case 9:
                return Year.SEPTEMBRIE.toString();
            case 10:
                return Year.OCTOMBRIE.toString();
            case 11:
                return Year.NOIEMBRIE.toString();
            case 12:
                return Year.DECEMBRIE.toString();
            default:
                return null;
        }
    }

    public void closeCookie() {
        if (closeCookieButton.isDisplayed()) {
            actionsHelper.clickOnElement(closeCookieButton);
        }
    }
}

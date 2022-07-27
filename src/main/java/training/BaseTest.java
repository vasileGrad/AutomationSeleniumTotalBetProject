package training;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Endava\\Internship\\Courses\\Technologies\\Selenium\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://totalbet.ro/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
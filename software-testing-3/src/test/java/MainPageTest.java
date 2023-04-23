import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import page.MainPage;
import util.ChromeOptionUtil;
import util.Constants;
import util.PropertiesUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest {

    List<WebDriver> driverList;
    WebDriver chromeDriver;
    WebDriver firefoxDriver;

    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().arm64().browserVersion(PropertiesUtil.get("chrome.version")).setup();
        WebDriverManager.firefoxdriver().arm64().setup();
    }

    @BeforeEach
    void setUp() {
        driverList = new ArrayList<>();
        chromeDriver = new ChromeDriver(ChromeOptionUtil.chromeOptions());
        firefoxDriver = new FirefoxDriver();
        driverList.add(chromeDriver);
        driverList.add(firefoxDriver);
        driverList.parallelStream()
                .forEach(driver -> driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS));
    }

    @Test
    void getTitleTest() {
        driverList.forEach(webDriver -> {
            assertEquals(Constants.MANE_PAGE_TITLE, PageFactory.initElements(webDriver,
                    MainPage.class).getTitle());
            webDriver.quit();
        });
    }

    @Test
    void getParticularCarTest() {
        driverList.forEach(webDriver -> {
            String model = PageFactory.initElements(webDriver, MainPage.class).searchCarsPage().initFactory().searchParticularModel();
            if (model != null) {
                assertTrue(PageFactory.initElements(webDriver, MainPage.class).searchCarsPage().initFactory().searchParticularModel().contains("A5"));
            } else assertTrue(true);
        });
    }

    @Test
    void searchCarsByInput() {
        driverList.forEach(webDriver -> assertTrue(PageFactory.initElements(webDriver, MainPage.class).searchByInput().initFactory().getWebDriver().getTitle()
                .contains(Constants.AUDI)));
    }

    @Test
    void searchNewCarsTest() {
        driverList.forEach(webDriver -> assertEquals(Constants.MANE_PAGE_NEW_CARS_HEADER, PageFactory.initElements(webDriver, MainPage.class).searchAllNewCars()));
    }

    @Test
    void journalTitleTest() {
        driverList.forEach(webDriver -> {
            assertEquals(Constants.JOURNAL_PAGE_TITLE, PageFactory.initElements(webDriver, MainPage.class).autoJournalTitle());
        });
    }
}

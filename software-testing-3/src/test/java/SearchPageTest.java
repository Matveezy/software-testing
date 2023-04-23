import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import page.SearchCarsPage;
import util.ChromeOptionUtil;
import util.PropertiesUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class SearchPageTest {

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
                .forEach(driver -> {
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
                });
    }

    @Test
    void filterByPriceTest() {
        int priceFrom = 500000;
        int priceTo = 1000000;
        driverList.parallelStream()
                .forEach(webDriver -> {
                    List<Integer> prices = PageFactory.initElements(webDriver, SearchCarsPage.class).filterByPrice(priceFrom, priceTo);
                    prices.forEach(price -> {
                        Assertions.assertTrue(() -> ((price >= priceFrom) && (price <= priceTo)));
                    });
                });
    }

    @Test
    void filterByMileage() {
        int mileageFrom = 1000;
        int mileageTo = 10000;
        driverList.parallelStream()
                .forEach(webDriver -> {
                    List<Integer> mileages = PageFactory.initElements(webDriver, SearchCarsPage.class).filterByMileage(mileageFrom, mileageTo);
                    mileages.forEach(mileage -> {
                        Assertions.assertTrue(() -> ((mileage >= mileageFrom) && (mileage <= mileageTo)));
                    });
                });
    }
}

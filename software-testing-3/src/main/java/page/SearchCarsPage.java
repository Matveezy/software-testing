package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.StringUtil;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class SearchCarsPage extends Page {
    @FindBy(xpath = "//a[@class=\"Link ListingItemTitle__link\"][contains(text(), \"A5\")]")
    List<WebElement> listOfParticularCars;

    @FindBy(xpath = "//a[@class=\"Link ListingItemTitle__link\"]")
    List<WebElement> listOfCar;

    @FindBy(xpath = "//input[@name=\"model\"]")
    WebElement modelChooseField;

    @FindBy(xpath = "//input[@name='price_from']")
    public WebElement priceFromFilterInput;

    @FindBy(xpath = "//input[@name='price_to']")
    public WebElement priceToFilterInput;

    @FindBy(xpath = "//input[@name='km_age_from']")
    public WebElement mileageFromFilterInput;

    @FindBy(xpath = "//input[@name='km_age_to']")
    public WebElement mileageToFilterInput;

    @FindBy(xpath = "//button[@class='Button Button_color_blue Button_size_m Button_type_button Button_width_full']")
    public WebElement submitFilterButton;

    @FindBy(xpath = "//a[@class='Link ListingItemPrice__link']/span")
    public List<WebElement> listOfFilteredPrices;

    @FindBy(xpath = "//div[@class='ListingItem__kmAge']")
    public List<WebElement> listOfFilteredMileages;

    @FindBy(xpath = "//span[@class='Button__text'][contains(text(), 'С пробегом')]/parent::span/parent::button")
    public WebElement carsWithMileageFilterButton;

    public void waitUntilPricesListIsPresent() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofMillis(1000));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='Link ListingItemPrice__link']/span")));
    }

    public void waitUntilMileagesListIsPresent() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofMillis(1000));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ListingItem__kmAge']")));
    }

    public String searchParticularModel() {
        int size = listOfParticularCars.size();
        if (0 == size) return null;
        System.out.println("ищем тачку мечты!");
        WebElement maybeAudiCar = listOfParticularCars.get(0);
        System.out.println(maybeAudiCar.getText());
        maybeAudiCar.click();
        return webDriver.getTitle();
    }

    public List<Integer> filterByPrice(int priceFrom, int priceTo) {
        try {
            webDriver.get("https://auto.ru/cars/audi/all/");
            carsWithMileageFilterButton.click();
            priceFromFilterInput.sendKeys(Integer.toString(priceFrom));
            priceToFilterInput.sendKeys(Integer.toString(priceTo));
            submitFilterButton.click();
            waitUntilPricesListIsPresent();
            if (0 == listOfFilteredPrices.size()) return Collections.emptyList();
            return listOfFilteredPrices.stream()
                    .map(WebElement::getText)
                    .filter(text -> !(text.equals("")))
                    .map(StringUtil::parsePrice)
                    .toList();
        } catch (StaleElementReferenceException e) {
            if (0 == listOfFilteredPrices.size()) return Collections.emptyList();
            return listOfFilteredPrices.stream()
                    .map(WebElement::getText)
                    .filter(text -> !(text.equals("")))
                    .map(StringUtil::parsePrice)
                    .toList();
        }
    }

    public List<Integer> filterByMileage(int mileageFrom, int mileageTo) {
        try {
            webDriver.get("https://auto.ru/cars/audi/all/");
            carsWithMileageFilterButton.click();
            mileageFromFilterInput.sendKeys(Integer.toString(mileageFrom));
            mileageToFilterInput.sendKeys(Integer.toString(mileageTo));
            submitFilterButton.click();
            waitUntilMileagesListIsPresent();
            if (0 == listOfFilteredMileages.size()) return Collections.emptyList();
            return listOfFilteredMileages.stream()
                    .map(WebElement::getText)
                    .filter(text -> !(text.equals("")))
                    .map(StringUtil::parseMileage)
                    .toList();
        } catch (StaleElementReferenceException e) {
            if (0 == listOfFilteredMileages.size()) return Collections.emptyList();
            return listOfFilteredMileages.stream()
                    .map(WebElement::getText)
                    .filter(text -> !(text.equals("")))
                    .map(StringUtil::parseMileage)
                    .toList();
        }
    }

    public SearchCarsPage(WebDriver driver) {
        super(driver);
    }

    public SearchCarsPage initFactory() {
        PageFactory.initElements(webDriver, this);
        return this;
    }
}
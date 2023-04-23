package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.PropertiesUtil;
public class MainPage extends Page {
    @FindBy(xpath = "//span[text()='Войти']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginInput;

    @FindBy(xpath = "//button[@class='Button Button_color_blue Button_size_l Button_type_button Button_width_default']")
    public WebElement submitLoginInputButton;

    @FindBy(xpath = "//a[@title='Audi']")
    public WebElement carBrandRef;

    @FindBy(xpath = "//input[@class=\"TextInput__control\"]")
    public WebElement searchInput;

    @FindBy(xpath = "//span[@class=\"Button__text\"][contains(text(), 'Новые')]")
    public WebElement searchAllCarsButton;

    @FindBy(xpath = "//h1[@class=\"Index__title-h1\"]")
    public WebElement typeOfSearchingCarsHeader;

    @FindBy(xpath = "//span[@class='Button__text'][contains(text(), 'Все материалы')]")
    public WebElement journalButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        webDriver.get("https://auto.ru/");
        long time = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - time);
        String title = webDriver.getTitle();
        System.out.println(title);
        loginButton.click();
        loginInput.sendKeys(PropertiesUtil.get("user.login"));
        submitLoginInputButton.click();
    }

    public String getTitle() {
        webDriver.get("https://auto.ru/");
        return webDriver.getTitle();
    }

    public SearchCarsPage searchCarsPage() {
        webDriver.get("https://auto.ru/");
        carBrandRef.click();
        return new SearchCarsPage(webDriver);
    }

    public SearchCarsPage searchByInput() {
        webDriver.get("https://auto.ru/");
        searchInput.sendKeys("Audi", Keys.ENTER);
        return new SearchCarsPage(webDriver);
    }

    public String searchAllNewCars() {
        webDriver.get("https://auto.ru/");
        searchAllCarsButton.click();
        return typeOfSearchingCarsHeader.getText();
    }

    public String autoJournalTitle() {
        webDriver.get("https://auto.ru/");
        journalButton.click();
        return webDriver.getTitle();
    }
}

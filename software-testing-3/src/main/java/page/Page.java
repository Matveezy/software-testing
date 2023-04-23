package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

abstract public class Page {

    protected WebDriver webDriver;

    public Page(WebDriver driver) {
        this.webDriver = driver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}

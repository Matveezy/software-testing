package util;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionUtil {
    public static ChromeOptions chromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=" + PropertiesUtil.get("user.data.dir"));
        chromeOptions.setBinary(PropertiesUtil.get("chrome.path"));
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }
}

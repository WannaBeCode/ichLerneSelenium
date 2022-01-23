package configuration;

import org.openqa.selenium.WebDriver;

public class DriverHelper {

    private static void throwExceptionWhenNull(String browser) {
        if (browser == null) {
            throw new RuntimeException("Es wurde kein Webdriver anegegeben.");
        }

    }

    public static WebDriver getDriver( String browser) {
        throwExceptionWhenNull(browser);
        AvailabeBrowser currentBrowser = AvailabeBrowser.valueOf(browser.toUpperCase());
        WebDriver driver = currentBrowser.createDriver();
        return driver;

    }
}

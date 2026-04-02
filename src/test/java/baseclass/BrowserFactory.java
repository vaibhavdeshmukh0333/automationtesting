package baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

/**
 * BrowserFactory class to return appropriate browser setup instance.
 * Uses singleton pattern.
 */
public class BrowserFactory {

    private static BrowserFactory instance;

    private BrowserFactory() {}

    /**
     * Returns singleton instance of BrowserFactory.
     * @return BrowserFactory instance.
     */
    public static BrowserFactory getInstance() {
        if (instance == null) {
            instance = new BrowserFactory();
        }
        return instance;
    }

    public WebDriver getDriver(String browserName) {

        if (browserName == null) {
            throw new IllegalArgumentException("Browser name cannot be null");
        }

        switch (browserName.toLowerCase()) {
            case "chrome":

                return new ChromeBrowserSetup().browserSetup();

            case "firefox":
                return new FirefoxBrowserSetup().browserSetup();

            case "edge":
                return new EdgeBrowserSetup().browserSetup();

            default:
                throw new IllegalArgumentException("Invalid browser: " + browserName);
        }
    }
}

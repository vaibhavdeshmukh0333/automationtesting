package baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * FirefoxBrowserSetup class to initialize Firefox browser.
 */
public class FirefoxBrowserSetup implements BrowserSetup {

    @Override
    public WebDriver browserSetup() {
        WebDriver driver = null;
        try {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            // Add options if needed
            driver = new FirefoxDriver(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }
}

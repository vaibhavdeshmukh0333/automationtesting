package baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * ChromeBrowserSetup class to initialize Chrome browser.
 */
public class ChromeBrowserSetup implements BrowserSetup {

    @Override
    public WebDriver browserSetup() {
        WebDriver driver = null;
        try {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            // Add options if needed
            driver = new ChromeDriver(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }
}

package baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/**
 * EdgeBrowserSetup class to initialize Edge browser.
 */
public class EdgeBrowserSetup implements BrowserSetup {

    @Override
    public WebDriver browserSetup() {
        WebDriver driver = null;
        try {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            // Add options if needed
            driver = new EdgeDriver(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }
}

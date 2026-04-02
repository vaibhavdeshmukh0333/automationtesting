package baseclass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utilities.ExtentReportUtil;
import utilities.WaitUtils;

/**
 * BaseClass to provide shared resources for test classes.
 * Holds the WebDriver instance and configuration.
 */
public class BaseClass {

    public static WebDriver driver;
    public static ReadConfig readConfig;


    @Before
    public void setUp() {
        try {
            ReadConfig readConfig = ReadConfig.getInstance();
            String browser = readConfig.getProperty("browser");
            if (browser == null) browser = "chrome";
            WebDriver driver = BrowserFactory.getInstance().getDriver(browser);
            driver.manage().window().maximize();
            WaitUtils.setImplicitWait(driver, 10);
            ExtentReportUtil.getInstance();

            // Store driver in BaseClass for accessibility
            BaseClass.driver = driver;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
            ExtentReportUtil.flushReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

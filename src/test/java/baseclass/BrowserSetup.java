package baseclass;

import org.openqa.selenium.WebDriver;

/**
 * BrowserSetup interface to define browser setup methods.
 */
public interface BrowserSetup {

    /**
     * Sets up the browser and returns WebDriver instance.
     * @return WebDriver instance.
     */
    WebDriver browserSetup();
}

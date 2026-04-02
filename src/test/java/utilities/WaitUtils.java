package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * WaitUtils class to implement explicit and implicit waits for web elements.
 */
public class WaitUtils {

    /**
     * Sets implicit wait for the driver.
     * @param driver WebDriver instance.
     * @param timeout Timeout in seconds.
     */
    public static void setImplicitWait(WebDriver driver, int timeout) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for element to be visible.
     * @param driver WebDriver instance.
     * @param element WebElement to wait for.
     * @param timeout Timeout in seconds.
     */
    public static void waitForElementToBeVisible(WebDriver driver, WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for element to be clickable.
     * @param driver WebDriver instance.
     * @param element WebElement to wait for.
     * @param timeout Timeout in seconds.
     */
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

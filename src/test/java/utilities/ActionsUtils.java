package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * ActionsUtils class to perform common actions on web elements.
 * Provides methods for click, sendKeys, select from dropdown, hover, etc.
 */
public class ActionsUtils {

    private static ActionsUtils instance;
    private WebDriver driver;

    private ActionsUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Returns singleton instance of ActionsUtils.
     * @param driver WebDriver instance.
     * @return ActionsUtils instance.
     */
    public static ActionsUtils getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new ActionsUtils(driver);
        }
        return instance;
    }

    /**
     * Clicks on the given web element.
     * @param element WebElement to click.
     */
    public void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends keys to the given web element.
     * @param element WebElement to send keys to.
     * @param text Text to send.
     */
    public void sendKeys(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Selects from dropdown by visible text.
     * @param element Dropdown WebElement.
     * @param text Visible text to select.
     */
    public void selectFromDropdown(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Selects from dropdown by value.
     * @param element Dropdown WebElement.
     * @param value Value to select.
     */
    public void selectFromDropdownByValue(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Selects from dropdown by index.
     * @param element Dropdown WebElement.
     * @param index Index to select.
     */
    public void selectFromDropdownByIndex(WebElement element, int index) {
        try {
            Select select = new Select(element);
            select.selectByIndex(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Hovers over the given web element.
     * @param element WebElement to hover over.
     */
    public void hoverOverElement(WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

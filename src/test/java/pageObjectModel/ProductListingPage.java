package pageObjectModel;

import baseclass.ReadConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * ProductListingPage - Page Object Model
 * All business logic and operations for PLP
 */
public class ProductListingPage {

    private WebDriver driver;
    private ReadConfig readConfig;

    @FindBy(id = "sort-dropdown")
    private WebElement sortDropdown;

    @FindBy(xpath = "//option[text()='Price: High to Low']")
    private WebElement priceHighToLowOption;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        this.readConfig = ReadConfig.getInstance();
        PageFactory.initElements(driver, this);
    }

    // Navigate to Product Listing Page
    public void navigateToProductListingPage() {
        String plpUrl = readConfig.getPlpUrl();
        driver.get(plpUrl);
    }

    // Wait for page to load
    public void waitForPageLoad() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);

        wait.until(d -> sortDropdown.isDisplayed());
    }

    // Verify user on correct page
    public void verifyUserOnCorrectPage() {
        String expectedUrl = readConfig.getPlpUrl();
        String actualUrl = driver.getCurrentUrl();

        if (!actualUrl.equalsIgnoreCase(expectedUrl)) {
            throw new AssertionError("URL mismatch! Expected: " + expectedUrl + ", Got: " + actualUrl);
        }
    }

    // Click sort dropdown
    public void clickSortDropdown() {
        sortDropdown.click();
    }

    // Select Price High to Low option with FluentWait
    public void selectPriceHighToLow() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);

        // Wait until option is clickable
        wait.until(d -> {
            try {
                priceHighToLowOption.click();
                return true;
            } catch (Exception e) {
                return false;
            }
        });

        // Wait for products to refresh after sorting
        wait.until(d -> driver.findElements(By.className("product-price")).size() > 0);
    }

    // Get all product prices
    public List<Double> getAllProductPrices() {
        List<Double> prices = new ArrayList<>();
        List<WebElement> priceElements = driver.findElements(By.className("product-price"));

        for (WebElement element : priceElements) {
            String priceText = element.getText()
                    .replaceAll("[£$€]", "")
                    .replaceAll("[^0-9.]", "")
                    .trim();

            if (!priceText.isEmpty()) {
                try {
                    prices.add(Double.parseDouble(priceText));
                } catch (NumberFormatException e) {
                    // Skip invalid prices
                }
            }
        }
        return prices;
    }

    // Verify products sorted in descending order
    public boolean verifyDescendingSortOrder(List<Double> prices) {
        if (prices == null || prices.isEmpty()) {
            return false;
        }

        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) < prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }



    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

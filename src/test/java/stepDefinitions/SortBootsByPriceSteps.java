package stepDefinitions;

import baseclass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjectModel.ProductListingPage;

import java.util.List;

/**
 * Step Definitions for Sort Boots By Price
 * Only calls methods from ProductListingPage
 */
public class SortBootsByPriceSteps {

    private ProductListingPage plpPage;

    @Given("user is on the product listing page")
    public void userIsOnTheProductListingPage() {
        plpPage = new ProductListingPage(BaseClass.driver);
        plpPage.navigateToProductListingPage();
        plpPage.waitForPageLoad();
        plpPage.verifyUserOnCorrectPage();
    }

    @When("user selects {string} filter")
    public void userSelectsFilter(String filter) {
        plpPage.clickSortDropdown();
        plpPage.selectPriceHighToLow();
    }

    @Then("products should be sorted in descending order of price")
    public void productsShouldBeSortedInDescendingOrderOfPrice() {
        List<Double> prices = plpPage.getAllProductPrices();
        boolean isSorted = plpPage.verifyDescendingSortOrder(prices);
        Assert.assertTrue(isSorted, "Products are not sorted in descending order of price");
    }
}

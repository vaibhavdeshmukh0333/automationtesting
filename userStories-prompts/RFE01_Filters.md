# **Test Script Generation Prompt: Sort Boots by Price (High to Low)**

## **User Story**
- **User Story ID:** US001
- **Acceptance Criteria:** AC1 - Verify High to Low Sorting on PLP

## **Feature File**
- **Purpose:** Create a Cucumber feature file inside `src/test/resources/features`
- **Feature File Name:** `SortBootsByPrice.feature`
- **Feature Description:** Verify that boots are sorted from high to low price on the product listing page
- **Steps (Gherkin Syntax):**
    1. `Given user is on the product listing page`
    2. `When user selects "Price: High to Low" filter`
    3. `Then products should be sorted in descending order of price`
- **Notes:** Use proper Gherkin syntax, pass expected URL and title as variables in feature file

## **Step Definitions**
- **Class Name:** `SortBootsByPriceSteps`
- **Package:** `src/test/java/stepdefinitions`
- **Mapping of Steps to Methods:**
    - `@Given("user is on product listing page")`
        - Get **plpUrl** from `config.properties` using `ReadConfig.getInstance().getBaseUrl()`
        - **Navigate directly to PLP page** using `driver.get(baseUrl)`
        - Verify URL using assertion with **WaitUtils**
    - `@When("user selects 'Price: High to Low' filter")`
        - Scroll down if dropdown is not visible
        - Click on "Sort: Most Relevant" dropdown using **ActionsUtils**
        - Select "Price: High to Low" option using **ActionsUtils.click()**
        - Use explicit wait for dropdown selection
    - `@Then("products should be sorted in descending order of price")`
        - Get all product prices from **Page Object** method `getAllProductPrices()`
        - Assert that the list is sorted in descending order
        - Use proper wait before assertion

## **Page Object Model**
- **Package:** `src/test/java/pageobjects`
- **Class Name:** `ProductListingPage`
- **WebElements and Actions:**
    - `WebElement sortDropdown`
    - `WebElement priceHighToLowOption`
- **Methods:**
    - `navigateToPLP()` → Open base URL directly using driver
    - `clickSortDropdown()` → Scroll if needed, click dropdown
    - `selectHighToLowPrice()` → Click "High to Low" filter, wait until products updated
    - `getAllProductPrices()` → Return list of product prices for assertion
    - `verifyPageTitle(String expectedTitle)` → Assert page title after navigation

## **Step Flow / Execution**
1. Open application using **base URL** from property file (directly points to PLP)
2. Verify URL loaded correctly with wait
3. Verify page is opened using `getTitle()` assertion, expected title passed in feature file
4. Get all product prices for later validation
5. Scroll to **Sort dropdown**, click it using ActionsUtils, wait for options
6. Select **Price: High to Low** option, wait for products to refresh
7. Verify product prices are sorted descending using assertions

## **Utilities**
- Use **WaitUtils** for implicit and explicit waits
- Use **ActionsUtils** for clicks and scroll actions
- Use **TakeScreenshotUtil** if assertion fails or for reports
- Ensure proper synchronization with waits at each step
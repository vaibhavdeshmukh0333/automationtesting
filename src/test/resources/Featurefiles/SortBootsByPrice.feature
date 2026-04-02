Feature: Sort Boots by Price (High to Low)

  @RFE01
  Scenario: Verify High to Low Sorting on PLP
    Given user is on the product listing page
    When user selects "Price: High to Low" filter
    Then products should be sorted in descending order of price

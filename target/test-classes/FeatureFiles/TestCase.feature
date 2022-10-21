Feature: WebstaurantStore Code Screen Task

  Scenario Outline: Testing the search functionality
    Given Set up the chrome driver and navigate to the application url
    When Search for "<search_str>"
    And Make sure each product title has "<keyword>" in it
		And Add the last of found elements to Cart
		And Navigate to the Cart page
		And Empty cart
		Then tear down the driver session

    Examples: 
      | search_str           | keyword |
      | stainless work table | Table   |

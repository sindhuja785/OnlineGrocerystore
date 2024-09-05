Feature: Grocery Store API testing

  Background:
    Given the base URL is set

  Scenario: User registration
    When the user registers with username "user1" and password "pass1"
    Then the user should be successfully registered

  Scenario: User login
    When the user logs in with username "user1" and password "pass1"
    Then the login should be successful

  Scenario: Add a new product
    When a new product "Product1" is added in category "Category1" with price 10.0 and stock 100
    Then the product should be successfully added

  Scenario: Retrieve product details
    When the product with id 1 is retrieved
    Then the product details should be available

  Scenario: Place a new order
    When the user places an order for product id 1 with quantity 2 and total price 20.0
    Then the order should be successfully placed

  Scenario: Retrieve order details
    When the order with id 1 is retrieved
    Then the order details should be available

  Scenario: Update user profile
    When the user updates profile with new username "updatedUser1" and password "updatedPass1"
    Then the user profile should be successfully updated

  Scenario: Delete user account
    When the user deletes their account
    Then the user account should be successfully deleted

  Scenario: Search product by name
    When search for product by name "Product1"
    Then the product details should be retrieved

  Scenario: Filter product by category
    When filter products by category "Category1"
    Then the filtered products should be retrieved

package Stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Groceryapistepdefinition {

    static {
        baseURI = "http://localhost:3001"; // Assuming your API is running on localhost at port 3001
    }

    @Given("the base URL is set")
    public void the_base_url_is_set() {
        System.out.println("Base URL is set: " + baseURI);
    }

    @When("the user registers with username {string} and password {string}")
    public void the_user_registers_with_username_and_password(String username, String password) {
        given()
            .contentType("application/json")
            .body("{\"username\": \"" + username + "\", \"password\": \"" + password + "\", \"email\": \"test@example.com\"}")
        .when()
            .post("/users/register")
        .then()
            .statusCode(201);
    }

    @Then("the user should be successfully registered")
    public void the_user_should_be_successfully_registered() {
        System.out.println("User successfully registered.");
    }

    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in(String username, String password) {
        given()
            .contentType("application/json")
            .body("{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}")
        .when()
            .post("/users/login")
        .then()
            .statusCode(200)
            .body("message", equalTo("Login successful"));
    }

    @Then("the login should be successful")
    public void the_login_should_be_successful() {
        System.out.println("Login was successful!");
    }

    @When("a new product {string} is added in category {string} with price {double} and stock {int}")
    public void add_new_product(String productName, String category, double price, int stock) {
        given()
            .contentType("application/json")
            .body("{\"name\": \"" + productName + "\", \"category\": \"" + category + "\", \"price\": " + price + ", \"stock\": " + stock + "}")
        .when()
            .post("/products")
        .then()
            .statusCode(201);
    }

    @Then("the product should be successfully added")
    public void the_product_should_be_successfully_added() {
        System.out.println("Product was successfully added!");
    }

    @Then("the product with id {int} is retrieved")
    public void retrieve_product(int productId) {
        given()
            .pathParam("productId", productId)
        .when()
            .get("/products/{productId}")
        .then()
            .statusCode(200)
            .body("id", equalTo(productId));
    }

    @Then("the product details should be available")
    public void the_product_details_should_be_available() {
        System.out.println("Product details are available!");
    }

    @When("the user places an order for product id {int} with quantity {int} and total price {double}")
    public void the_user_places_an_order_for_product_id_with_quantity_and_total_price(Integer productId, Integer quantity, Double totalPrice) {
        given()
            .contentType("application/json")
            .body("{\"productId\": " + productId + ", \"quantity\": " + quantity + ", \"totalPrice\": " + totalPrice + "}")
        .when()
            .post("/orders")
        .then()
            .statusCode(201);
    }

    @Then("the order should be successfully placed")
    public void the_order_should_be_successfully_placed() {
        System.out.println("Order was successfully placed!");
    }

    @Then("the order with id {int} is retrieved")
    public void retrieve_order(int orderId) {
        given()
            .pathParam("orderId", orderId)
        .when()
            .get("/orders/{orderId}")
        .then()
            .statusCode(200);
    }

    @Then("the order details should be available")
    public void the_order_details_should_be_available() {
        System.out.println("Order details are available!");
    }

    @When("the user updates profile with new username {string} and password {string}")
    public void update_user_profile(String newUsername, String newPassword) {
        given()
            .contentType("application/json")
            .body("{\"username\": \"" + newUsername + "\", \"password\": \"" + newPassword + "\"}")
        .when()
            .put("/users/1")
        .then()
            .statusCode(200);
    }

    @Then("the user profile should be successfully updated")
    public void the_user_profile_should_be_successfully_updated() {
        System.out.println("User profile has been successfully updated!");
    }

    @When("the user deletes their account")
    public void delete_user_account() {
        given()
            .pathParam("userId", 1)
        .when()
            .delete("/users/{userId}")
        .then()
            .statusCode(200);
    }

    @Then("the user account should be successfully deleted")
    public void the_user_account_should_be_successfully_deleted() {
        System.out.println("User account has been successfully deleted!");
    }

    @When("search for product by name {string}")
    public void search_for_product_by_name(String productName) {
        given()
            .queryParam("name", productName)
        .when()
            .get("/products/search")
        .then()
            .statusCode(200)
            .body("name", equalTo(productName));  // Assuming the API returns a product with this name
    }

    @Then("the product details should be retrieved")
    public void the_product_details_should_be_retrieved() {
        System.out.println("Product details successfully retrieved!");
    }

    @When("filter products by category {string}")
    public void filter_product_by_category(String category) {
        given()
            .queryParam("category", category)
        .when()
            .get("/products/filter")
        .then()
            .statusCode(200);
    }

    // Implementing the missing step for retrieving filtered products
    @Then("the filtered products should be retrieved")
    public void the_filtered_products_should_be_retrieved() {
        // Assuming the API returns the list of products for the filtered category
        System.out.println("Filtered products have been successfully retrieved.");
    }
}

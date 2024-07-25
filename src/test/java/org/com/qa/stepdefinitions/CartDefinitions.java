package org.com.qa.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.com.qa.tasks.HomeScreenplayTest;

public class CartDefinitions {

    HomeScreenplayTest main = new HomeScreenplayTest();

    @Given("a list of products on the main page")
    public void aListOfProductsOnTheMainPage() {
    }

    @When("the user clicks a product")
    public void theUserClicksAProduct() {
        main.testAddToCart();
    }

    @Then("product should be added to the cart")
    public void productShouldBeAddedToTheCart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}

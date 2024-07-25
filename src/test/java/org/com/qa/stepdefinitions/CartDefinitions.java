package org.com.qa.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.assertj.core.api.Assertions;
import org.com.qa.tasks.AddProductCartTask;
import org.com.qa.tasks.OpenMainPageAndVerifyProductsTask;
import org.openqa.selenium.WebDriver;

public class CartDefinitions {

    private Actor actor = Actor.named("Juan");

    @Managed
    WebDriver driver;

    @Given("a list of products on the main page")
    public void aListOfProductsOnTheMainPage() {
        actor.can(BrowseTheWeb.with(driver));
        actor.attemptsTo(OpenMainPageAndVerifyProductsTask.openAndVerify());
    }

    @When("the user clicks a product")
    public void theUserClicksAProduct() {
        actor.attemptsTo(AddProductCartTask.addProduct());
        // Assert the URL change
        String currentUrl = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
        Assertions.assertThat(currentUrl).isEqualTo("https://www.demoblaze.com/prod.html?idp_=1");

    }

    @Then("product should be added to the cart")
    public void productShouldBeAddedToTheCart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}

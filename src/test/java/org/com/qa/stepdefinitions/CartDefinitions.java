package org.com.qa.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.assertj.core.api.Assertions;
import org.com.qa.actions.CheckSweetAlertAction;
import org.com.qa.actions.ClickButtonAction;
import org.com.qa.models.User;
import org.com.qa.tasks.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartDefinitions {

    private final Actor actor = Actor.named("Juan");

    @Managed
    WebDriver driver;

    @Given("a list of products on the main page")
    public void aListOfProductsOnTheMainPage() {
        actor.can(BrowseTheWeb.with(driver));
        actor.attemptsTo(OpenMainPageAndVerifyProductsTask.openAndVerify());
    }

    @When("the user clicks a product")
    public void theUserClicksAProduct() {
        actor.attemptsTo(AddProductCartTask.addProduct("1"));
        // Assert the URL change
        String currentUrl = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
        Assertions.assertThat(currentUrl).isEqualTo("https://www.demoblaze.com/prod.html?idp_=1");

    }

    @When("the user clicks the Add to cart button on the product page")
    public void theUserClicksAddToCartButton() {
        actor.attemptsTo(ClickAddToCartButtonTask.clickAddToCartButton());
    }

    @When("the user returns to the main page and clicks another product")
    public void theUserReturnsToTheMainPageAndClicksAnotherProduct() {
        actor.attemptsTo(
                ClickNavButtonTask.clickButton("index")
        );
        String currentUrl = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
        Assertions.assertThat(currentUrl).isEqualTo("https://www.demoblaze.com/index.html");

        actor.attemptsTo(AddProductCartTask.addProduct("2"));

        actor.attemptsTo(ClickAddToCartButtonTask.clickAddToCartButton());
    }

    @When("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        actor.attemptsTo(
                ClickNavButtonTask.clickButton("cart")
        );
        String currentUrl = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
        Assertions.assertThat(currentUrl).isEqualTo("https://www.demoblaze.com/cart.html");
    }

    @Then("products should be added to the cart")
    public void productShouldBeAddedToTheCart() {
        actor.attemptsTo(VerifyCartItemsTask.verifyItemsInCart());
    }

    @When("the user clicks the place order button")
    public void theUserClickPlaceOrderButton() {
        actor.attemptsTo(ClickButtonAction.clickButton("#page-wrapper > div > div.col-lg-1 > button"));

        boolean isModalVisible = BrowseTheWeb.as(actor).getDriver().findElement(By.cssSelector("#orderModal")).isDisplayed();
        Assertions.assertThat(isModalVisible).isTrue();
    }

    @Then("the user fills the fields and sweet alert is shown")
    public void writeFieldsInformation() {
        actor.can(BrowseTheWeb.with(driver));

        User user = new User("John Doe", "USA", "New York", "1234567812345678", "12", "2024");

        actor.attemptsTo(FillFormTask.withUser(user));

        actor.attemptsTo(ClickButtonAction.clickButton("#orderModal > div > div > div.modal-footer > button.btn.btn-primary"));

        actor.attemptsTo(CheckSweetAlertAction.isVisible());
    }

}

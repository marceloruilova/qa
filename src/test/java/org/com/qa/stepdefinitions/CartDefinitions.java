package org.com.qa.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.assertj.core.api.Assertions;
import org.com.qa.actions.*;
import org.com.qa.models.User;
import org.com.qa.questions.VerifyCartItemsQuestion;
import org.com.qa.questions.VerifyElementVisibilityQuestion;
import org.com.qa.questions.VerifyProductsQuestion;
import org.com.qa.tasks.*;
import org.com.qa.userinterfaces.OrderModalElements;
import org.openqa.selenium.WebDriver;

public class CartDefinitions {

    @Managed
    WebDriver driver;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Juan").can(BrowseTheWeb.with(driver));
    }

    @Given("a list of products on the main page")
    public void aListOfProductsOnTheMainPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                OpenMainPageTask.open()
        );
    }

    @Then("there should be more than {int} products on the main page")
    public void thereShouldBeMoreThanProductsOnTheMainPage(int count) {
        Actor actor = OnStage.theActorInTheSpotlight();
        boolean result = actor.asksFor(VerifyProductsQuestion.hasMoreThan(count));
        Assertions.assertThat(result).isTrue();
    }


    @When("the user clicks a product")
    public void theUserClicksAProduct() {
        String productNumber = "1";
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickProductAction.addProduct(productNumber),
                VerifyLinkAction.verifyUrl("https://www.demoblaze.com/prod.html?idp_=" + productNumber)
        );
    }

    @When("the user clicks the add to cart button on the product page")
    public void theUserClicksAddToCartButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickAddToCartButtonTask.clickAddToCartButton()
        );
    }

    @When("the user returns to the main page")
    public void theUserReturnsToTheMainPageAndClicksAnotherProduct() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                ClickNavButtonAction.clickButton("index"),
                VerifyLinkAction.verifyUrl("https://www.demoblaze.com/index.html")
        );
    }

    @Then("the user clicks another product")
    public void clickAnotherProduct() {
        String productNumber = "2";
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickProductAction.addProduct(productNumber),
                VerifyLinkAction.verifyUrl("https://www.demoblaze.com/prod.html?idp_=" + productNumber),
                ClickAddToCartButtonTask.clickAddToCartButton()
        );
    }

    @When("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                ClickNavButtonAction.clickButton("cart"),
                VerifyLinkAction.verifyUrl("https://www.demoblaze.com/cart.html")
        );
    }

    @Then("products should be added to the cart")
    public void productShouldBeAddedToTheCart() {
        Actor actor = OnStage.theActorInTheSpotlight();
        Boolean areItemsCorrect = actor.asksFor(VerifyCartItemsQuestion.areCorrect());
        Assertions.assertThat(areItemsCorrect).isTrue();
    }

    @When("the user clicks the place order button")
    public void theUserClickPlaceOrderButton() {
        Actor actor = OnStage.theActorInTheSpotlight();
//        todo, fix
        actor.attemptsTo(ClickButtonAction.clickButton("#page-wrapper > div > div.col-lg-1 > button"));

        Boolean isModalVisible = actor.asksFor(VerifyElementVisibilityQuestion.isVisible(OrderModalElements.ORDER_MODAL));
        Assertions.assertThat(isModalVisible).isTrue();
    }

    @Then("the user fills the fields and sweet alert is shown")
    public void writeFieldsInformation() {
        Actor actor = OnStage.theActorInTheSpotlight();
        User user = new User("John Doe", "USA", "New York", "1234567812345678", "12", "2024");

        actor.attemptsTo(FillFormTask.withUser(user));
        actor.attemptsTo(ClickButtonAction.clickButton("#orderModal > div > div > div.modal-footer > button.btn.btn-primary"));
        actor.attemptsTo(CheckSweetAlertAction.isVisible());
    }
}

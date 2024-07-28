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
import org.com.qa.questions.*;
import org.com.qa.tasks.*;
import org.com.qa.userinterfaces.CartPageElements;
import org.com.qa.userinterfaces.MainPageElements;
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
                ClickProductAction.addProduct(MainPageElements.PRODUCT(productNumber))
        );
    }

    @Then("the user should be on the product page with product1 and URL {string}")
    public void theUserShouldBeOnThePageWithURL(String expectedUrl) {
        String productNumber = "1";
        Actor actor = OnStage.theActorInTheSpotlight();
        Boolean isUrlCorrect = actor.asksFor(VerifyLinkQuestion.verifyUrl(expectedUrl + productNumber));
        Assertions.assertThat(isUrlCorrect).isTrue();
    }

    @When("the user clicks the add to cart button on the product page")
    public void theUserClicksAddToCartButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickAddToCartButtonTask.clickAddToCartButton(),
                JSAlertAction.acceptAlert()
        );
    }

    @When("the user clicks the main page button")
    public void theUserReturnsToTheMainPageAndClicksAnotherProduct() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                ClickNavButtonAction.clickButton("index")
        );
    }

    @Then("the user should be on the main page {string}")
    public void theUserShouldBeOnThePageMainPage(String expectedUrl) {
        verifyPageUrl(expectedUrl, "main page");
    }

    @Then("the user clicks another product")
    public void clickAnotherProduct() {
        String productNumber = "2";
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickProductAction.addProduct(MainPageElements.PRODUCT(productNumber))
        );
    }

    @Then("the user should be on the product page with product2 and URL {string}")
    public void theUserShouldBeOnTheProductPage(String expectedUrl) {
        Actor actor = OnStage.theActorInTheSpotlight();
        Boolean isUrlCorrect = actor.asksFor(VerifyLinkQuestion.verifyUrl(expectedUrl + "2"));
        Assertions.assertThat(isUrlCorrect).isTrue();
    }

    @Then("the user clicks add to cart button")
    public void clickAddToCartButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickAddToCartButtonTask.clickAddToCartButton(),
                JSAlertAction.acceptAlert()
        );
    }

    @When("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                ClickNavButtonAction.clickButton("cart")
        );
    }

    @Then("the user should be on the cart page {string}")
    public void theUserShouldBeOnTheCartPage(String expectedUrl) {
        verifyPageUrl(expectedUrl, "cart page");
    }

    @Then("selected products should be on the cart page")
    public void productShouldBeAddedToTheCart() {
        Actor actor = OnStage.theActorInTheSpotlight();
        Boolean areItemsCorrect = actor.asksFor(VerifyCartItemsQuestion.areCorrect());
        Assertions.assertThat(areItemsCorrect).isTrue();
    }

    @When("the user clicks the place order button")
    public void theUserClickPlaceOrderButton() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(ClickButtonAction.clickButton(CartPageElements.PLACE_ORDER_BUTTON));

        Boolean isModalVisible = actor.asksFor(VerifyElementVisibilityQuestion.isVisible(OrderModalElements.ORDER_MODAL));
        Assertions.assertThat(isModalVisible).isTrue();
    }

    @Then("the user fills the fields and sweet alert is shown")
    public void writeFieldsInformation() {
        Actor actor = OnStage.theActorInTheSpotlight();
        User user = new User("John Doe", "USA", "New York", "1234567812345678", "12", "2024");

        actor.attemptsTo(FillFormTask.withUser(user));
        actor.attemptsTo(ClickButtonAction.clickButton(CartPageElements.PURCHASE_MODAL_BUTTON));
        Boolean isSweetAlertVisible = actor.asksFor(VerifySweetAlertQuestion.isVisible());
        Assertions.assertThat(isSweetAlertVisible).isTrue();
    }

    private void verifyPageUrl(String expectedUrl, String pageDescription) {
        Actor actor = OnStage.theActorInTheSpotlight();
        Boolean isUrlCorrect = actor.asksFor(VerifyLinkQuestion.verifyUrl(expectedUrl));
        Assertions.assertThat(isUrlCorrect).as("The user is not on the " + pageDescription).isTrue();
    }

}

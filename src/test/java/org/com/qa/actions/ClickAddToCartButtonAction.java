package org.com.qa.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import org.com.qa.userinterfaces.ProductPageElements;

public class ClickAddToCartButtonAction implements Performable {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ProductPageElements.ADD_TO_CART_BUTTON));
        BrowseTheWeb.as(actor).getDriver();
    }

    public static ClickAddToCartButtonAction clickAddToCartButton() {
        return new ClickAddToCartButtonAction();
    }
}

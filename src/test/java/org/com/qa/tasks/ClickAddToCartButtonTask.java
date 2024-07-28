package org.com.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import org.com.qa.userinterfaces.ProductPageElements;

public class ClickAddToCartButtonTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ProductPageElements.ADD_TO_CART_BUTTON));
        BrowseTheWeb.as(actor).getDriver();
    }

    public static ClickAddToCartButtonTask clickAddToCartButton() {
        return new ClickAddToCartButtonTask();
    }
}

package org.com.qa.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ClickProductAction implements Task {

    private final Target product;

    public ClickProductAction(Target product) {
        this.product = product;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(product, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(product)
        );
    }

    public static ClickProductAction addProduct(Target product) {
        return new ClickProductAction(product);
    }

}

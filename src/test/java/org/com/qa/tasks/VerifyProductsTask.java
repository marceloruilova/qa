package org.com.qa.tasks;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.assertj.core.api.Assertions;
import org.com.qa.userinterfaces.MainPageElements;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerifyProductsTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MainPageElements.PRODUCT_IMAGES, isVisible())
                        .forNoMoreThan(5).seconds()
        );

        ListOfWebElementFacades products = MainPageElements.PRODUCT_IMAGES.resolveAllFor(actor);
        Assertions.assertThat(products).hasSizeGreaterThan(3);
    }

    public static VerifyProductsTask verify() {
        return new VerifyProductsTask();
    }
}

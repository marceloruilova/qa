package org.com.qa.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.com.qa.userinterfaces.MainPageElements;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerifyProductsQuestion  implements Question<Boolean> {

    private final int expectedCount;

    public VerifyProductsQuestion(int expectedCount) {
        this.expectedCount = expectedCount;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(MainPageElements.PRODUCT_IMAGES, isVisible())
                        .forNoMoreThan(5).seconds()
        );

        List<WebElementFacade> products = MainPageElements.PRODUCT_IMAGES.resolveAllFor(actor);
        return products.size() > expectedCount;
    }

    public static VerifyProductsQuestion hasMoreThan(int count) {
        return new VerifyProductsQuestion(count);
    }
}

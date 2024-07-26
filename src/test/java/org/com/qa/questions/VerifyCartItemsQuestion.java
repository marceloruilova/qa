package org.com.qa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.com.qa.userinterfaces.CartPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerifyCartItemsQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(CartPageElements.TABLE_BODY_ROWS, isVisible())
                        .forNoMoreThan(5).seconds()
        );

        List<WebElement> rows = BrowseTheWeb.as(actor).getDriver().findElements(By.cssSelector(CartPageElements.TABLE_BODY_ROWS.getCssOrXPathSelector()));
        return rows.size() == 2;
    }

    public static VerifyCartItemsQuestion areCorrect() {
        return new VerifyCartItemsQuestion();
    }
}

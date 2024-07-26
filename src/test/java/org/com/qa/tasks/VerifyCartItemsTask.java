package org.com.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.assertj.core.api.Assertions;
import org.com.qa.userinterfaces.CartPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerifyCartItemsTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CartPageElements.TABLE_BODY, isVisible())
                        .forNoMoreThan(5).seconds()
        );

        List<WebElement> rows = BrowseTheWeb.as(actor).getDriver().findElements(By.cssSelector(".table tbody tr"));

        Assertions.assertThat(rows).hasSize(2);
    }

    public static VerifyCartItemsTask verify() {
        return new VerifyCartItemsTask();
    }
}

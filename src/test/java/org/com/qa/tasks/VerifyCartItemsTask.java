package org.com.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerifyCartItemsTask implements Task {

    private static final By TABLE_BODY = By.cssSelector(".table tbody");

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Wait until the table body is visible
        actor.attemptsTo(
                WaitUntil.the(TABLE_BODY, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        // Find all rows in the table body
        List<WebElement> rows = BrowseTheWeb.as(actor).getDriver().findElements(By.cssSelector(".table tbody tr"));

        // Assert that there are exactly two rows
        Assertions.assertThat(rows).hasSize(2);
    }

    public static VerifyCartItemsTask verifyItemsInCart() {
        return new VerifyCartItemsTask();
    }
}

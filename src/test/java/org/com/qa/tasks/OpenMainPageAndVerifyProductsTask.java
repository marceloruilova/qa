package org.com.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OpenMainPageAndVerifyProductsTask implements Task {

    private static final String URL = "https://www.demoblaze.com/";

    private static final By PRODUCT_IMAGES = By.cssSelector(".card-img-top.img-fluid");

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(URL));

        actor.attemptsTo(
                WaitUntil.the(PRODUCT_IMAGES, isVisible())
                        .forNoMoreThan(5).seconds()
        );

        List<WebElement> products = BrowseTheWeb.as(actor).getDriver().findElements(PRODUCT_IMAGES);
        Assertions.assertThat(products).hasSizeGreaterThan(3);
    }

    public static OpenMainPageAndVerifyProductsTask openAndVerify() {
        return new OpenMainPageAndVerifyProductsTask();
    }
}

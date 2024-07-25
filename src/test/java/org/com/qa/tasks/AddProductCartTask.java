package org.com.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

public class AddProductCartTask implements Task {


    private static final By PRODUCT_IMAGE = By.cssSelector("#tbodyid > div:nth-child(1) > div > a > img");

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PRODUCT_IMAGE, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(PRODUCT_IMAGE)
        );

        }

    public static AddProductCartTask addProduct() {
        return new AddProductCartTask();
    }

}

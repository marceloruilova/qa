package org.com.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

public class AddProductToCartTask implements Task {

    private final String childNumber;

    public AddProductToCartTask(String childNumber) {
        this.childNumber = childNumber;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        By by = By.cssSelector("#tbodyid > div:nth-child(" + childNumber + ") > div > a > img");
        actor.attemptsTo(
                WaitUntil.the(by, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(by)
        );
    }

    public static AddProductToCartTask addProduct(String childNumber) {
        return new AddProductToCartTask(childNumber);
    }

}

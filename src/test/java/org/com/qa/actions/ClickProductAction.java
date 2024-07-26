package org.com.qa.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.com.qa.userinterfaces.MainPageElements;
import org.openqa.selenium.By;

public class ClickProductAction implements Task {

    private final String childNumber;

    public ClickProductAction(String childNumber) {
        this.childNumber = childNumber;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        By by = By.cssSelector(MainPageElements.mainPageProductSelector(childNumber));
        actor.attemptsTo(
                WaitUntil.the(by, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(by)
        );
    }

    public static ClickProductAction addProduct(String childNumber) {
        return new ClickProductAction(childNumber);
    }

}

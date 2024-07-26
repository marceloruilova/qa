package org.com.qa.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;

public class ClickButtonAction implements Performable {

    private final String buttonSelector;

    public ClickButtonAction(String buttonSelector) {
        this.buttonSelector = buttonSelector;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        By by = By.cssSelector(buttonSelector);
        actor.attemptsTo(Click.on(by));
    }

    public static ClickButtonAction clickButton(String buttonSelector) {
        return new ClickButtonAction(buttonSelector);
    }
}

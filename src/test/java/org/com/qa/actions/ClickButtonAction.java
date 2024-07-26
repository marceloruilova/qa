package org.com.qa.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ClickButtonAction implements Performable {

    private final Target button;

    public ClickButtonAction(Target button) {
        this.button = button;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(button));
    }

    public static ClickButtonAction clickButton(Target button) {
        return new ClickButtonAction(button);
    }
}

package org.com.qa.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import org.com.qa.userinterfaces.NavigationElements;
import org.openqa.selenium.By;

public class ClickNavButtonAction implements Performable {

    private final String navReference;

    public ClickNavButtonAction(String navReference) {
        this.navReference = navReference;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        By Button = By.cssSelector(NavigationElements.navButtonSelector(navReference));
        actor.attemptsTo(Click.on(Button));
    }

    public static ClickNavButtonAction clickButton(String navReference) {
        return new ClickNavButtonAction(navReference);
    }
}


package org.com.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;

public class ClickNavButtonTask implements Task {

    private final String navReference;

    public ClickNavButtonTask(String navReference) {
        this.navReference = navReference;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        By Button = By.cssSelector("a.nav-link[href='" + navReference + ".html']");
        actor.attemptsTo(Click.on(Button));
    }

    public static ClickNavButtonTask clickButton(String navReference) {
        return new ClickNavButtonTask(navReference);
    }
}

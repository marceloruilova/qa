package org.com.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenMainPageTask implements Task {

    private static final String URL = "https://www.demoblaze.com/";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(URL));
    }

    public static OpenMainPageTask open() {
        return new OpenMainPageTask();
    }

}

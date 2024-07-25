package org.com.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;

public class AddProductCartTask implements Task {

    public static AddProductCartTask execute(){
        return new AddProductCartTask();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(By.cssSelector("#tbodyid > div:nth-child(1) > div > a > img"))
        );
    }

}

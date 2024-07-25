package org.com.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.com.qa.models.User;
import org.openqa.selenium.By;

public class FillFormTask implements Task {

    private final User user;

    public FillFormTask(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getName()).into(By.id("name")),
                Enter.theValue(user.getCountry()).into(By.id("country")),
                Enter.theValue(user.getCity()).into(By.id("city")),
                Enter.theValue(user.getCreditCard()).into(By.id("card")),
                Enter.theValue(user.getMonth()).into(By.id("month")),
                Enter.theValue(user.getYear()).into(By.id("year"))
        );
    }

    public static FillFormTask withUser(User user) {
        return new FillFormTask(user);
    }
}

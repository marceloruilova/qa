package org.com.qa.tasks;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class HomeScreenplayTest {

    @Managed
    WebDriver driver;

    @Steps
    Actor actor = Actor.named("Juan");

    @Test
    public void testAddToCart(){
        actor.can(BrowseTheWeb.with(driver));
        actor.wasAbleTo(Open.url("https://www.demoblaze.com/"));
        actor.attemptsTo(AddProductCartTask.execute());
    }

}

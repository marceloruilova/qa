package org.com.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickHomeButtonTask implements Task {

    private static final By HOME_BUTTON = By.cssSelector("a.nav-link[href='index.html']");

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            // No alert present, continue
        }

        actor.attemptsTo(Click.on(HOME_BUTTON));
    }

    public static ClickHomeButtonTask clickHomeButton() {
        return new ClickHomeButtonTask();
    }
}

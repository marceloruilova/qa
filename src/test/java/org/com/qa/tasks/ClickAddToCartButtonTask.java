package org.com.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickAddToCartButtonTask implements Task {

    private static final By ADD_TO_CART_BUTTON = By.cssSelector("#tbodyid > div.row > div > a");

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ADD_TO_CART_BUTTON));
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            // No alert present, continue
        }
    }

    public static ClickAddToCartButtonTask clickAddToCartButton() {
        return new ClickAddToCartButtonTask();
    }
}

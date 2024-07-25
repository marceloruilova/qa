package org.com.qa.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckSweetAlertAction implements Performable {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement alertElement = driver.findElement(By.cssSelector("body > div.sweet-alert.showSweetAlert.visible"));

        if (alertElement == null || !alertElement.isDisplayed()) {
            throw new AssertionError("Expected sweet alert was not displayed.");
        }
    }

    public static CheckSweetAlertAction isVisible() {
        return new CheckSweetAlertAction();
    }
}

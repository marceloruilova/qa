package org.com.qa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

public class VerifyElementVisibilityQuestion implements Question<Boolean> {

    private final Target target;

    public VerifyElementVisibilityQuestion(Target target) {
        this.target = target;
    }

    public static VerifyElementVisibilityQuestion isVisible(Target target) {
        return new VerifyElementVisibilityQuestion(target);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WebElement element = target.resolveFor(actor);
        return element.isDisplayed();
    }
}
